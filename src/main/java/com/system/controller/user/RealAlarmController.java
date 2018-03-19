package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.DeviceAlarmInfo;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.DeviceAlarmService;
import com.system.service.DeviceCombineOrgService;
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
@RequestMapping("/realAlarm")
public class RealAlarmController {
    @Autowired
    private DeviceAlarmService deviceAlarmService;

    @RequestMapping(value = "selectDeviceRealAlarmCount", method = {RequestMethod.POST,RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceRealAlarmCount() throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        int alarmCount = 0;
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            alarmCount = deviceAlarmService.selectDeviceRealAlarmCount();
        } else {
            alarmCount = deviceAlarmService.selectDeviceRealAlarmCountByRoleId(userlogin.getRoleInfoList());
        }
        jsonString = "{";
        jsonString += "\"" + "alarmCount" + "\"";
        jsonString += ":";
        jsonString += "\"" + alarmCount + "\"";
        jsonString += "}";
        return jsonString;
    }

    @RequestMapping(value = "/selectRealAlarmInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealAlarmInfo() throws Exception {
        String jsonString = "[]";
        List<DeviceAlarmInfo> deviceAlarmInfoList = selectDeviceAlarmInfo();
        if (deviceAlarmInfoList.size() > 0)
            jsonString = JSON.toJSONString(deviceAlarmInfoList);
        return jsonString;
    }

    @RequestMapping(value = "exportRealAlarmList", method = RequestMethod.GET)
    public void exportRealAlarmList(
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String fileName = "realAlarmList.xlsx";
        List<DeviceAlarmInfo> deviceAlarmInfoList = selectDeviceAlarmInfo();
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

    @RequestMapping(value = "/alarmHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String alarmHead() throws Exception {

        List<MydataTableColumn> myDTCList = deviceAlarmService.selectDeviceAlarmHead();
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

    private List<DeviceAlarmInfo> selectDeviceAlarmInfo() throws Exception
    {
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceAlarmInfo> deviceAlarmInfoList = new ArrayList<DeviceAlarmInfo>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            deviceAlarmInfoList = deviceAlarmService.selectDeviceAlarmInfo();
        } else {
            deviceAlarmInfoList = deviceAlarmService.selectDeviceAlarmInfoByRoleId(userlogin.getRoleInfoList());
        }
        return deviceAlarmInfoList;
    }
}
