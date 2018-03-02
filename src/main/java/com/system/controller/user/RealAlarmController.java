package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.Userlogin;
import com.system.service.DeviceAlarmService;
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
        if (userlogin.getOrgid().equals("002")) {
            alarmCount = deviceAlarmService.selectDeviceRealAlarmCount();
        } else {

        }
        jsonString = "{";
        jsonString += "\"" + "alarmCount" + "\"";
        jsonString += ":";
        jsonString += "\"" + alarmCount + "\"";
        jsonString += "}";
        return jsonString;
    }
}
