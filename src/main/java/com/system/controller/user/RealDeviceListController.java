package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.EC01DeviceMessageService;
import com.system.service.SewageC01DeviceMessageService;
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
@RequestMapping("/realDeviceList")
public class RealDeviceListController {

    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private SewageC01DeviceMessageService sewageC01DeviceMessageService;

    /*************************Environment*********************************************/
    @RequestMapping(value = "selectEC01ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<EC01DeviceMessage> ec01DeviceMessageList = selectEC01DeviceMessageList(sORGId);
            if (ec01DeviceMessageList.size() > 0)
                jsonString = JSON.toJSONString(ec01DeviceMessageList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectEC01ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            EC01DeviceMessage ec01DeviceMessage = ec01DeviceMessageService.selectEC01ByDeviceId(sDeviceId);
            if (ec01DeviceMessage != null)
                jsonString = JSON.toJSONString(ec01DeviceMessage);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportEC01DeviceList", method = RequestMethod.GET)
    public void exportEC01DeviceList(String sORGId,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        String fileName = "realec01devicelist.xlsx";
        List<EC01DeviceMessage> ec01DeviceMessageList = null;
        if (sORGId != null) {
            ec01DeviceMessageList = selectEC01DeviceMessageList(sORGId);
        }
        File file = ec01DeviceMessageService.exportStorage(ec01DeviceMessageList);
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
    public String ec01DeviceHead() throws Exception {
        List<MydataTableColumn> ec01HeadColumnList = ec01DeviceMessageService.selectEC01DeviceHead();
        String jsonString = JSON.toJSONString(ec01HeadColumnList);
        return jsonString;
    }

    private List<EC01DeviceMessage> selectEC01DeviceMessageList(String sORGId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByORGId(sORGId);
        }  else {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return ec01DeviceMessageList;
    }

    /*************************Sewage*********************************************/

    @RequestMapping(value = "selectSewageC01ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSewageC01ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<SewageC01DeviceMessage> sewageC01DeviceMessageList = selectSewageC01DeviceMessageList(sORGId);
            if (sewageC01DeviceMessageList.size() > 0)
                jsonString = JSON.toJSONString(sewageC01DeviceMessageList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectSewageC01ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSewageC01ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            SewageC01DeviceMessage sewageC01DeviceMessage = sewageC01DeviceMessageService.selectSewageC01ByDeviceId(sDeviceId);
            if (sewageC01DeviceMessage != null)
                jsonString = JSON.toJSONString(sewageC01DeviceMessage);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportSewageC01DeviceList", method = RequestMethod.GET)
    public void exportSewageC01DeviceList(String sORGId,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        String fileName = "realsewagec01devicelist.xlsx";
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = null;
        if (sORGId != null) {
            sewageC01DeviceMessageList = selectSewageC01DeviceMessageList(sORGId);
        }
        File file = sewageC01DeviceMessageService.exportStorage(sewageC01DeviceMessageList);
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

    @RequestMapping(value = "/sewagec01DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String sewagec01DeviceHead() throws Exception {
        List<MydataTableColumn> sewagec01HeadColumnList = sewageC01DeviceMessageService.selectSewageC01DeviceHead();
        String jsonString = JSON.toJSONString(sewagec01HeadColumnList);
        return jsonString;
    }

    private List<SewageC01DeviceMessage> selectSewageC01DeviceMessageList(String sORGId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = new ArrayList<SewageC01DeviceMessage>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            sewageC01DeviceMessageList = sewageC01DeviceMessageService.selectSewageC01ByORGId(sORGId);
        } else {
            sewageC01DeviceMessageList = sewageC01DeviceMessageService.selectSewageC01ByByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return sewageC01DeviceMessageList;
    }
}
