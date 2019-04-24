package com.system.controller.user.hj212C213;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.Hj212C213Chart;
import com.system.controller.util.Hj212C213ChartTwoParam;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Phone.PhoneEChartsOptionsY;
import com.system.po.Userlogin;
import com.system.service.DeviceInfoService;
import com.system.service.Hj212C213DMService;
import com.system.util.DeviceUtil;
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
import java.util.Map;

@Controller
@RequestMapping("/hisChartDevice")
public class HisChartDeviceListHj212213Controller {
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private Hj212C213DMService hj212C213DMService;
    @Autowired
    private Hj212C213Chart hj212C213Chart;
    @Autowired
    private Hj212C213ChartTwoParam hj212C213ChartTwoParam;
    @Autowired
    private DeviceUtilController deviceUtilController;

    @RequestMapping(value = "selectDevicesHj212C213", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevicesHj212C213() throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceInfoAndNode> deviceInfoList = new ArrayList<DeviceInfoAndNode>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("213"));
        } else {
            deviceInfoList = deviceInfoService.selectDeviceInfoByRoleIdAll(userlogin.getRoleInfoList());
            deviceInfoList =  DeviceUtil.splitDeviceByDevType(deviceInfoList,"213");
        }
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/selectHj212C213ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHj212C213ByIdsAndDateChart(String[] sDeviceIds,
                                                  String sQueryParam,
                                                  String sStartDate,
                                                  String sEndDate) throws Exception {
        String jsonString = "[]";
        switch (sQueryParam)
        {
            case "流量":
            case "pH":
            case "COD":
            case "氨氮":
            case "总磷":
                jsonString = getOneParamChart(sDeviceIds,sQueryParam,sStartDate,sEndDate);
                break;
            case "流量/COD":
            case "流量/氨氮":
            case "流量/总磷":
            case "COD/氨氮":
            case "COD/总磷":
            case "氨氮/总磷":
                jsonString = getTwoParamChart(sDeviceIds,sQueryParam,sStartDate,sEndDate);
                break;
        }
        return jsonString;
    }

    private String getOneParamChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception{
        Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate = hj212C213DMService.selectHisHj212C213ByDateAndIDs(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (hj212C213MapByDate == null || hj212C213MapByDate.size() < 1)
            return "[]";
        List<DeviceInfo> deviceInfoList = deviceUtilController.getDeviceInfoList(sDeviceIds);
        if (deviceInfoList == null || deviceInfoList.size() < 1)
            return "[]";
        Map<String, String> deviceInfoMap = deviceUtilController.getDeviceInfoMap(deviceInfoList);
        PhoneEChartsOptions phoneEChartsOptions = hj212C213Chart.getECharts(sQueryParam, deviceInfoMap, hj212C213MapByDate);
        if (phoneEChartsOptions == null)
            return "[]";
        String jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }

    private String getTwoParamChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception{
        Map<String, Hj212C213DayData> hj212C213MapByDate = hj212C213DMService.selectHisHj212C213ByDateAndIDsTwoParam(sDeviceIds, sStartDate, sEndDate);
        if (hj212C213MapByDate == null || hj212C213MapByDate.size() < 1)
            return "[]";
        PhoneEChartsOptionsY phoneEChartsOptions = hj212C213ChartTwoParam.getECharts(sQueryParam, hj212C213MapByDate);
        if (phoneEChartsOptions == null)
            return "[]";
        String jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }
}
