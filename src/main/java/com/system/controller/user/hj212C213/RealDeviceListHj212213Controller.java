package com.system.controller.user.hj212C213;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.Hj212C213DMService;
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
public class RealDeviceListHj212213Controller {
    @Autowired
    private Hj212C213DMService hj212C213DMService;
    /*************************Hj212 立华水质213*********************************************/

    @RequestMapping(value = "selectHj212C213ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHj212C213ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = selectHj212C213DeviceMessageList(sORGId);
            if (hj212C213DeviceMessageList.size() > 0)
                jsonString = JSON.toJSONString(hj212C213DeviceMessageList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/hj212C213DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String hj212C213DeviceHead() throws Exception {
        List<MydataTableColumn> hj212C213HeadColumnList = hj212C213DMService.selectHj212C213DeviceHead();
        String jsonString = JSON.toJSONString(hj212C213HeadColumnList);
        return jsonString;
    }

    @RequestMapping(value = "selectHj212C213ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHj212C213ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            Hj212C213DeviceMessage hj212C213DeviceMessage = hj212C213DMService.selectHj212C213ByDeviceId(sDeviceId);
            if (hj212C213DeviceMessage != null)
                jsonString = JSON.toJSONString(hj212C213DeviceMessage);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportHj212C213DeviceList", method = RequestMethod.GET)
    public void exportHj212C213DeviceList(String sORGId,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String fileName = "realHj212C213devicelist.xlsx";
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = null;
        if (sORGId != null) {
            hj212C213DeviceMessageList = selectHj212C213DeviceMessageList(sORGId);
        }
        File file = hj212C213DMService.exportStorage(hj212C213DeviceMessageList);
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

    private List<Hj212C213DeviceMessage> selectHj212C213DeviceMessageList(String sORGId) throws Exception {
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = new ArrayList<Hj212C213DeviceMessage>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            hj212C213DeviceMessageList = hj212C213DMService.selectHj212C213ByORGId(sORGId);
        } else {
            hj212C213DeviceMessageList = hj212C213DMService.selectHj212C213ByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return hj212C213DeviceMessageList;
    }
}
