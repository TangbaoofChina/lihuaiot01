package com.system.controller.user.Lhsf0a;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.Lhsf0ap1DMService;
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

/**
 * @ClassName Lhsf0ap1RealCtl
 * @Description 智能生物安防-物资熏蒸
 * @Author tangbao
 * @Date 2020-05-23 10:59
 * @Version 1.0
 **/
@Controller
@RequestMapping("/realDeviceList")
public class Lhsf0ap1RDLController {
    @Autowired
    private Lhsf0ap1DMService dmService;

    @RequestMapping(value = "selectLhsf0ap1ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<Lhsf0ap1DM> dmList = selectDMList(sORGId);
            if (dmList.size() > 0)
                jsonString = JSON.toJSONString(dmList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/lhsf0ap1DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getDeviceHead(String devId) throws Exception {
        List<MydataTableColumn> headColumnList = dmService.selectDeviceHead(devId);
        String jsonString = JSON.toJSONString(headColumnList);
        return jsonString;
    }

    @RequestMapping(value = "selectLhsf0ap1ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectFeedC411ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            Lhsf0ap1DM dm = dmService.selectByDeviceId(sDeviceId);
            if (dm != null)
                jsonString = JSON.toJSONString(dm);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportLhsf0ap1DeviceList", method = RequestMethod.GET)
    public void exportFeedC411DeviceList(String sORGId,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
        String fileName = "realLhsf0ap1devicelist.xlsx";
        List<Lhsf0ap1DM> dmList = null;
        if (sORGId != null) {
            dmList = selectDMList(sORGId);
        }
        File file = dmService.exportStorage(dmList);
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

    private List<Lhsf0ap1DM> selectDMList(String sORGId) throws Exception {
        List<Lhsf0ap1DM> dmList = new ArrayList<>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            dmList = dmService.selectByORGId(sORGId);
        } else {
            dmList = dmService.selectByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return dmList;
    }
}
