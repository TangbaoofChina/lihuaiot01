package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.DeviceOfflineMapper;
import com.system.po.*;
import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.EChartsOptions.EChartsPie.EChartsPieOneSerie;
import com.system.po.EChartsOptions.EChartsPie.EChartsPieOneSerieData;
import com.system.po.EChartsOptions.EChartsPie.EChartsPieOptions;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.service.DeviceAlarmService;
import com.system.service.DeviceInfoService;
import com.system.service.DeviceOfflineService;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/welcome")
public class WelComeController {

    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private DeviceAlarmService deviceAlarmService;
    @Autowired
    private DeviceOfflineService deviceOfflineService;

    @RequestMapping(value = "selectOnline", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOnline() throws Exception {
        String jsonString = "[]";
        List<DeviceInfoAndNode> deviceInfoAndNodeList = new ArrayList<>();
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        int deviceCount = 0;
        int realOfflineCount = 0;
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceInfoAndNodeList = deviceInfoService.selectAllDeviceAndNodeInfo();
            deviceCount = deviceInfoAndNodeList.size();
            realOfflineCount = deviceOfflineService.selectOfflineInfoCount();
        } else {
            deviceInfoAndNodeList = deviceInfoService.selectDeviceInfoByRoleIdAll(userlogin.getRoleInfoList());
            deviceCount = deviceInfoAndNodeList.size();
            realOfflineCount = deviceOfflineService.selectOfflineInfoCountByRoleId(userlogin.getRoleInfoList());
        }
        EChartsPieOptions eChartsPieOptions = getEChartsPieOptions(deviceCount - realOfflineCount, realOfflineCount);
        jsonString = JSON.toJSONString(eChartsPieOptions);
        return jsonString;
    }

    @RequestMapping(value = "selectOfflineRate", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOfflineRate(String sStartDate, String sEndDate) throws Exception {
        String jsonString = "[]";
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceOfflineRate> deviceOfflineRateList = new ArrayList<>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceOfflineRateList = deviceOfflineService.selectHisOfflineTopN(sStartDate, sEndDate, 11);
        } else {
            deviceOfflineRateList = deviceOfflineService.selectHisOfflineTopNByRoleId(sStartDate, sEndDate, 11, userlogin.getRoleInfoList());
        }
        PhoneEChartsOptions phoneEChartsOptions = getEChartsOfflineOptions(deviceOfflineRateList);
        jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }

    @RequestMapping(value = "selectAlarmRate", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectAlarmRate(String sStartDate, String sEndDate) throws Exception {
        String jsonString = "[]";
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceAlarmRate> deviceAlarmRateList = new ArrayList<>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceAlarmRateList = deviceAlarmService.selectHisAlarmTopN(sStartDate, sEndDate, 11);
        } else {
            deviceAlarmRateList = deviceAlarmService.selectHisAlarmTopNByRoleId(sStartDate, sEndDate, 11, userlogin.getRoleInfoList());
        }
        PhoneEChartsOptions phoneEChartsOptions = getEChartsAlarmOptions(deviceAlarmRateList);
        jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }

    //在线、离线饼图
    private EChartsPieOptions getEChartsPieOptions(int onLineCount, int offLineCount) throws Exception {
        EChartsPieOptions eChartsPieOptions = new EChartsPieOptions();
        EChartsTitle title = new EChartsTitle();
        EChartsLegend legend = new EChartsLegend();
        //series
        List<EChartsPieOneSerie> eChartsPieOneSerieList = new ArrayList<>();

        //title
        title.setText("设备在线状态");
        title.setSubtext("设备数量：" + String.valueOf(onLineCount + offLineCount));
        title.setLeft("center");

        //legend
        legend.setBottom("10");
        legend.setLeft("center");
        List<String> legendDataList = new ArrayList<>();
        legendDataList.add("在线");
        legendDataList.add("离线");
        legend.setData(legendDataList);


        //one serie
        EChartsPieOneSerie eChartsPieOneSerie = new EChartsPieOneSerie();
        // one serie datas
        List<EChartsPieOneSerieData> eChartsPieOneSerieDataList = new ArrayList<>();
        // one serie data-在线
        EChartsPieOneSerieData eCPOSDOnline = new EChartsPieOneSerieData();
        eCPOSDOnline.setName("在线");
        eCPOSDOnline.setValue(String.valueOf(onLineCount));
        // one serie data-离线
        EChartsPieOneSerieData eCPOSDOffline = new EChartsPieOneSerieData();
        eCPOSDOffline.setName("离线");
        eCPOSDOffline.setValue(String.valueOf(offLineCount));

        eChartsPieOneSerieDataList.add(eCPOSDOnline);
        eChartsPieOneSerieDataList.add(eCPOSDOffline);

        eChartsPieOneSerie.setName("设备在线状态");
        eChartsPieOneSerie.setData(eChartsPieOneSerieDataList);

        eChartsPieOneSerieList.add(eChartsPieOneSerie);

        eChartsPieOptions.setTitle(title);
        eChartsPieOptions.setLegend(legend);
        eChartsPieOptions.setSeries(eChartsPieOneSerieList);
        return eChartsPieOptions;
    }

    //离线率前N的柱状图
    private PhoneEChartsOptions getEChartsOfflineOptions(List<DeviceOfflineRate> deviceOfflineRateList) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("设备离线(次)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        EChartsLegend eChartsLegend = new EChartsLegend();
        eChartsLegend.setData(DeviceOfflineRate.getOfflineData(deviceOfflineRateList));
        phoneEChartsOptions.setLegend(eChartsLegend);

        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        eChartsXAxis.setData(DeviceOfflineRate.getOfflineData(deviceOfflineRateList));
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("-50");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        if (deviceOfflineRateList.size() > 0) {
            eChartsYAxis.setMax(String.valueOf(Integer.valueOf(deviceOfflineRateList.get(0).getOfflineTimes()) + 1));
        } else {  //取出为空的情况
            eChartsYAxis.setMax("1");
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(DeviceOfflineRate.getdParameterdata(deviceOfflineRateList));
        phoneEChartsOptions.showPoint(false, false);
        return phoneEChartsOptions;
    }

    //报警率前N的柱状图
    private PhoneEChartsOptions getEChartsAlarmOptions(List<DeviceAlarmRate> deviceAlarmRateList) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("设备报警(次)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        EChartsLegend eChartsLegend = new EChartsLegend();
        eChartsLegend.setData(DeviceAlarmRate.getAlarmData(deviceAlarmRateList));
        phoneEChartsOptions.setLegend(eChartsLegend);

        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        eChartsXAxis.setData(DeviceAlarmRate.getAlarmData(deviceAlarmRateList));
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("-50");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        if (deviceAlarmRateList.size() > 0) {
            eChartsYAxis.setMax(String.valueOf(Integer.valueOf(deviceAlarmRateList.get(0).getAlarmTimes()) + 1));
        } else {  //取出为空的情况
            eChartsYAxis.setMax("1");
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(DeviceAlarmRate.getdParameterdata(deviceAlarmRateList));
        phoneEChartsOptions.showPoint(false, false);
        return phoneEChartsOptions;
    }
}
