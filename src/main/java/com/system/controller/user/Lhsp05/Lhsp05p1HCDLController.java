package com.system.controller.user.Lhsp05;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.Lhsp05p1Chart;
import com.system.po.Device.Lhsp05p1DM;
import com.system.po.Device.Lhsp05p1DMHis;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Phone.PhoneEChartsOptionsY;
import com.system.po.Userlogin;
import com.system.service.DeviceInfoService;
import com.system.service.Lhsp05p1DMService;
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
public class Lhsp05p1HCDLController {
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private Lhsp05p1DMService dmService;
    @Autowired
    private Lhsp05p1Chart dmChart;
    @Autowired
    private DeviceUtilController deviceUtilController;

    @RequestMapping(value = "selectDevicesLhsp05p1", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevicesLhsp05p1() throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceInfoAndNode> deviceInfoList = new ArrayList<DeviceInfoAndNode>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("LHSP05p1"));
        } else {
            deviceInfoList = deviceInfoService.selectDeviceInfoByRoleIdAll(userlogin.getRoleInfoList());
            deviceInfoList =  DeviceUtil.splitDeviceByDevType(deviceInfoList,"LHSP05p1");
        }
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/selectLhsp05p1ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectLhsp05p1ByIdsAndDateChart(String[] sDeviceIds,
                                                  String sQueryParam,
                                                  String sStartDate,
                                                  String sEndDate) throws Exception {
        String jsonString = "[]";
        switch (sQueryParam)
        {
            case "温度01":
            case "温度02":
            case "温度03":
            case "温度04":
                jsonString = getOneParamChart(sDeviceIds,sQueryParam,sStartDate,sEndDate);
                break;
        }
        return jsonString;
    }

    private String getOneParamChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception{
        Map<String, List<Lhsp05p1DMHis>> dmHisMapByDate = dmService.selectHisByDateAndIDs(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (dmHisMapByDate == null || dmHisMapByDate.size() < 1)
            return "[]";
        List<DeviceInfo> deviceInfoList = deviceUtilController.getDeviceInfoList(sDeviceIds);
        if (deviceInfoList == null || deviceInfoList.size() < 1)
            return "[]";
        Map<String, String> deviceInfoMap = deviceUtilController.getDeviceInfoMap(deviceInfoList);
        PhoneEChartsOptions phoneEChartsOptions = dmChart.getECharts(sQueryParam, deviceInfoMap, dmHisMapByDate);
        if (phoneEChartsOptions == null)
            return "[]";
        String jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }

}
