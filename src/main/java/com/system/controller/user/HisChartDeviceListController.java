package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.parameter.OneDataDetail;
import com.system.po.parameter.ParameterCharts;
import com.system.service.DeviceInfoService;
import com.system.service.EC01DeviceMessageService;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hisChartDevice")
public class HisChartDeviceListController {

    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private DeviceInfoService deviceInfoService;

    @RequestMapping(value = "selectDevices", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevices() throws Exception {
        String jsonString = "[]";
        List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByORGId("002");
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }

    @RequestMapping(value = "selectDevicesPost", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevicesPost() throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceInfoAndNode> deviceInfoList = new ArrayList<DeviceInfoAndNode>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceInfoList = deviceInfoService.selectDeviceInfoByOrgIdAll("001");
            deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("002"));
        } else {
            deviceInfoList = deviceInfoService.selectDeviceInfoByRoleIdAll(userlogin.getRoleInfoList());
        }
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/selectEC01ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByIdsAndDateChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        //List<DeviceMessage> deviceMessageList = deviceMessageService.selectHisDeviceMessage();
        ParameterCharts parameterCharts = ec01DeviceMessageService.selectHisEC01ByDateAndIDsChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (parameterCharts == null)
            return "[]";
        String jsonString = JSON.toJSONString(parameterCharts);
        return jsonString;
    }

    @RequestMapping(value = "selectEC01ByIdsAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByIdsAndDateAndPaging(Integer pageNumber, Integer pageSize, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        String sReturnJson = "[]";
        if (sDeviceIds == null) {
            return sReturnJson;
        }
        if (sDeviceIds.length > 0) {
            List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByIDs(sDeviceIds);
            DataTablePageing dataTablePageing = ec01DeviceMessageService.selectHisEC01ByDateAndIDsAndPage(pageNumber, pageSize, deviceInfoList, sDeviceIds, sQueryParam, sStartDate, sEndDate);
            sReturnJson = "{";
            sReturnJson += "\"" + "total" + "\"";
            sReturnJson += ":";
            sReturnJson += "\"" + dataTablePageing.getTotal() + "\"";
            sReturnJson += ",";
            sReturnJson += "\"" + "rows" + "\"";
            sReturnJson += ":";
            sReturnJson += dataTablePageing.getsReturnJson();
            sReturnJson += "}";
        }
        return sReturnJson;
    }

    @RequestMapping(value = "exportHisDeviceList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void exportHisDeviceList(String[] sDeviceIds,
                                    String sQueryParam,
                                    String sStartDate,
                                    String sEndDate,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        String fileName = "hisdevicelist.xlsx";
        List<List<OneDataDetail>> ec01DeviceMessageList = null;
        List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByIDs(sDeviceIds);
        if (sDeviceIds != null) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectHisEC01ByDateAndIDsTable(deviceInfoList, sDeviceIds, sQueryParam, sStartDate, sEndDate);
        }
        List<MydataTableColumn> myDTCList = getEC01DeviceHead(sDeviceIds);
        File file = ec01DeviceMessageService.exportStoragedynamic(myDTCList, ec01DeviceMessageList);
        if (file != null) {
            // 设置响应头
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            FileInputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[8192];

            int len;
            while ((len = inputStream.read(buffer, 0, buffer.length)) > 0) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
        }
    }

    @RequestMapping(value = "/ec01DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String ec01DeviceHead(String[] sDeviceIds) throws Exception {

        List<MydataTableColumn> myDTCList = getEC01DeviceHead(sDeviceIds);
        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

    private List<MydataTableColumn> getEC01DeviceHead(String[] sDeviceIds) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        if (sDeviceIds.length > 0) {
            List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByIDs(sDeviceIds);

            for (DeviceInfo deviceInfo : deviceInfoList
                    ) {
                MydataTableColumn mdtc = new MydataTableColumn();
                mdtc.setData(deviceInfo.getDSerialNum());
                mdtc.setTitle(deviceInfo.getDName());
                myDTCList.add(mdtc);
            }
        }

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sSendTime");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("发送时间");

        myDTCList.add(mdtcTime);
        return myDTCList;
    }
}
