package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Device.*;
import com.system.service.*;
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
    @Autowired
    private SewageC212DMService sewageC212DeviceMessageService;
    @Autowired
    private SewageC214DMService sewageC214DMService;
    @Autowired
    private ScaleC01DeviceMessageService scaleC01DeviceMessageService;

    /*************************Environment 种禽环控*********************************************/
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
        } else {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return ec01DeviceMessageList;
    }

    /*************************Sewage 立华禽环保1.0*********************************************/

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


    /*************************Sewage 立华禽环保2.0*********************************************/

    @RequestMapping(value = "selectSewageC212ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSewageC212ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<SewageC212DeviceMessage> sewageC212DeviceMessageList = selectSewageC212DeviceMessageList(sORGId);
            if (sewageC212DeviceMessageList.size() > 0)
                jsonString = JSON.toJSONString(sewageC212DeviceMessageList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/sewagec212DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String sewagec212DeviceHead() throws Exception {
        List<MydataTableColumn> sewagec212HeadColumnList = sewageC212DeviceMessageService.selectSewageC212DeviceHead();
        String jsonString = JSON.toJSONString(sewagec212HeadColumnList);
        return jsonString;
    }

    @RequestMapping(value = "selectSewageC212ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSewageC212ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            SewageC212DeviceMessage sewageC212DeviceMessage = sewageC212DeviceMessageService.selectSewageC212ByDeviceId(sDeviceId);
            if (sewageC212DeviceMessage != null)
                jsonString = JSON.toJSONString(sewageC212DeviceMessage);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportSewageC212DeviceList", method = RequestMethod.GET)
    public void exportSewageC212DeviceList(String sORGId,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        String fileName = "realsewagec212devicelist.xlsx";
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = null;
        if (sORGId != null) {
            sewageC212DeviceMessageList = selectSewageC212DeviceMessageList(sORGId);
        }
        File file = sewageC212DeviceMessageService.exportStorage(sewageC212DeviceMessageList);
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



    private List<SewageC212DeviceMessage> selectSewageC212DeviceMessageList(String sORGId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = new ArrayList<SewageC212DeviceMessage>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            sewageC212DeviceMessageList = sewageC212DeviceMessageService.selectSewageC212ByORGId(sORGId);
        } else {
            sewageC212DeviceMessageList = sewageC212DeviceMessageService.selectSewageC212ByByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return sewageC212DeviceMessageList;
    }

    /*************************Sewage 立华禽环保3.0 214*********************************************/

    @RequestMapping(value = "selectSewageC214ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSewageC214ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<SewageC214DM> sewageC214DMList = selectSewageC214DMList(sORGId);
            if (sewageC214DMList.size() > 0)
                jsonString = JSON.toJSONString(sewageC214DMList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/sewagec214DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String sewagec214DeviceHead() throws Exception {
        List<MydataTableColumn> sewagec214HeadColumnList = sewageC214DMService.selectSewageC214DeviceHead();
        String jsonString = JSON.toJSONString(sewagec214HeadColumnList);
        return jsonString;
    }

    @RequestMapping(value = "selectSewageC214ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSewageC214ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            SewageC214DM sewageC212DM = sewageC214DMService.selectSewageC214ByDeviceId(sDeviceId);
            if (sewageC212DM != null)
                jsonString = JSON.toJSONString(sewageC212DM);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportSewageC214DeviceList", method = RequestMethod.GET)
    public void exportSewageC214DeviceList(String sORGId,
                                           HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String fileName = "realsewagec214devicelist.xlsx";
        List<SewageC214DM> sewageC214DMList = null;
        if (sORGId != null) {
            sewageC214DMList = selectSewageC214DMList(sORGId);
        }
        File file = sewageC214DMService.exportStorage(sewageC214DMList);
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

    private List<SewageC214DM> selectSewageC214DMList(String sORGId) throws Exception {
        List<SewageC214DM> sewageC214DMList = new ArrayList<SewageC214DM>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            sewageC214DMList = sewageC214DMService.selectSewageC214ByORGId(sORGId);
        } else {
            sewageC214DMList = sewageC214DMService.selectSewageC214ByByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return sewageC214DMList;
    }
    /*************************Scale 自动称重*********************************************/


    @RequestMapping(value = "selectScaleC01ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectScaleC01ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = selectScaleC01DeviceMessageList(sORGId);
            if (scaleC01DeviceMessageList.size() > 0)
                jsonString = JSON.toJSONString(scaleC01DeviceMessageList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectScaleC01ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectScaleC01ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            ScaleC01DeviceMessage scaleC01DeviceMessage = scaleC01DeviceMessageService.selectScaleC01ByDeviceId(sDeviceId);
            if (scaleC01DeviceMessage != null)
                jsonString = JSON.toJSONString(scaleC01DeviceMessage);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportScaleC01DeviceList", method = RequestMethod.GET)
    public void exportScaleC01DeviceList(String sORGId,
                                         HttpServletRequest request,
                                         HttpServletResponse response) throws Exception {
        String fileName = "realscale01devicelist.xlsx";
        List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = null;
        if (sORGId != null) {
            scaleC01DeviceMessageList = selectScaleC01DeviceMessageList(sORGId);
        }
        File file = scaleC01DeviceMessageService.exportStorage(scaleC01DeviceMessageList);
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

    @RequestMapping(value = "/scalec01DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String scalec01DeviceHead() throws Exception {
        List<MydataTableColumn> scalec01HeadColumnList = scaleC01DeviceMessageService.selectScaleC01DeviceHead();
        String jsonString = JSON.toJSONString(scalec01HeadColumnList);
        return jsonString;
    }

    private List<ScaleC01DeviceMessage> selectScaleC01DeviceMessageList(String sORGId) throws Exception {
        List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = new ArrayList<ScaleC01DeviceMessage>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            scaleC01DeviceMessageList = scaleC01DeviceMessageService.selectScaleC01ByORGId(sORGId);
        } else {
            scaleC01DeviceMessageList = scaleC01DeviceMessageService.selectScaleC01ByByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return scaleC01DeviceMessageList;
    }

}
