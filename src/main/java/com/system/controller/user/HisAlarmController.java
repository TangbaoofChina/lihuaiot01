package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.DeviceAlarmInfo;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.DeviceAlarmService;
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
@RequestMapping("/hisAlarm")
public class HisAlarmController {
    @Autowired
    private DeviceAlarmService deviceAlarmService;

    @RequestMapping(value = "/selectHisAlarmInfoPaging", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisAlarmInfoPaging(Integer pageNumber, Integer pageSize, String alarmType, String sStartDate, String sEndDate) throws Exception {
        String jsonString = "[]";
        DataTablePageing dataTablePageing = selectDeviceAlarmInfoPaging(pageNumber, pageSize, alarmType, sStartDate, sEndDate);
        jsonString = "{";
        jsonString += "\"" + "total" + "\"";
        jsonString += ":";
        jsonString += "\"" + dataTablePageing.getTotal() + "\"";
        jsonString += ",";
        jsonString += "\"" + "rows" + "\"";
        jsonString += ":";
        jsonString += dataTablePageing.getsReturnJson();
        jsonString += "}";
        return jsonString;
    }

    @RequestMapping(value = "/selectHisAlarmInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisAlarmInfo(String alarmType, String sStartDate, String sEndDate) throws Exception {
        String jsonString = "[]";
        List<DeviceAlarmInfo> deviceAlarmInfoList = selectDeviceAlarmInfo(alarmType, sStartDate, sEndDate);
        jsonString = JSON.toJSONString(deviceAlarmInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/alarmHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String alarmHead() throws Exception {
        List<MydataTableColumn> myDTCList = deviceAlarmService.selectDeviceAlarmHead();
        String jsonString = JSON.toJSONString(myDTCList);
        return jsonString;
    }

    @RequestMapping(value = "exportHisAlarmList", method = RequestMethod.GET)
    public void exportRealAlarmList(String alarmType,
                                    String sStartDate,
                                    String sEndDate,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        String fileName = "hisAlarmList.xlsx";
        List<DeviceAlarmInfo> deviceAlarmInfoList = selectDeviceAlarmInfo(alarmType, sStartDate, sEndDate);
        File file = deviceAlarmService.exportStorage(deviceAlarmInfoList);
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

    private DataTablePageing selectDeviceAlarmInfoPaging(Integer pageNumber, Integer pageSize, String alarmType, String sStartDate, String sEndDate) throws Exception {
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        DataTablePageing dataTablePageing = new DataTablePageing();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            dataTablePageing = deviceAlarmService.selectDeviceHisAlarmInfoAndPaging(pageNumber, pageSize, alarmType, sStartDate, sEndDate);
        } else {
            dataTablePageing = deviceAlarmService.selectDeviceHisAlarmInfoByRoleIdAndPaging(pageNumber, pageSize, alarmType, sStartDate, sEndDate, userlogin.getRoleInfoList());
        }
        return dataTablePageing;
    }

    private List<DeviceAlarmInfo> selectDeviceAlarmInfo(String alarmType, String sStartDate, String sEndDate) throws Exception {
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceAlarmInfo> deviceAlarmInfoList = new ArrayList<DeviceAlarmInfo>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceAlarmInfoList = deviceAlarmService.selectDeviceHisAlarmInfo(alarmType, sStartDate, sEndDate);
        } else {
            deviceAlarmInfoList = deviceAlarmService.selectDeviceHisAlarmInfoByRoleId(alarmType, sStartDate, sEndDate, userlogin.getRoleInfoList());
        }
        return deviceAlarmInfoList;
    }
}
