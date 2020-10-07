package com.system.controller.user.Lhrj0b;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.Lhrj0bp1Chart;
import com.system.po.Device.Lhrj0bp1DMHis;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Userlogin;
import com.system.service.DeviceInfoService;
import com.system.service.Lhrj0bp1DMService;
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
public class Lhrj0bp1HCDLController {
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private Lhrj0bp1DMService dmService;
    @Autowired
    private Lhrj0bp1Chart dmChart;
    @Autowired
    private DeviceUtilController deviceUtilController;

    @RequestMapping(value = "selectDevicesLhrj0bp1", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevicesLhrj0bp1() throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceInfoAndNode> deviceInfoList = new ArrayList<DeviceInfoAndNode>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("LHrj0bp1"));
        } else {
            deviceInfoList = deviceInfoService.selectDeviceInfoByRoleIdAll(userlogin.getRoleInfoList());
            deviceInfoList =  DeviceUtil.splitDeviceByDevType(deviceInfoList,"LHrj0bp1");
        }
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/selectLhrj0bp1ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectLhrj0bp1ByIdsAndDateChart(String[] sDeviceIds,
                                                  String sQueryParam,
                                                  String sStartDate,
                                                  String sEndDate) throws Exception {
        String jsonString = "[]";
        switch (sQueryParam)
        {
            case "饮水量":
                jsonString = getOneParamChart(sDeviceIds,sQueryParam,sStartDate,sEndDate);
                break;
        }
        return jsonString;
    }

    private String getOneParamChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception{
        Map<String, List<Lhrj0bp1DMHis>> dmHisMapByDate = dmService.selectHisByDateAndIDs(sDeviceIds, sQueryParam, sStartDate, sEndDate);
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
