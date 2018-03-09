package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.EC01DeviceMessage;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.EC01DeviceMessageService;
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
    private BootStrapTreeNodeService bootStrapTreeNodeService;

    @RequestMapping(value = "selectEC01ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            //获取用户角色
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
            List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
            if (userlogin.getRoleName().equals("admin")) {
                ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByORGId(sORGId);
            } else {
                ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(sORGId, userlogin.getRoleId());
            }
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

    @RequestMapping(value = "exportRealDeviceList", method = RequestMethod.GET)
    public void exportDeviceList(String sORGId,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String fileName = "realdevicelist.xlsx";
        List<EC01DeviceMessage> ec01DeviceMessageList = null;
        if (sORGId != null) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByORGId(sORGId);
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
}
