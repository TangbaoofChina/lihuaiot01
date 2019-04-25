package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.SewageC212DeviceMessage;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.PhoneLoginMsg;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.RoleInfo;
import com.system.po.UserOAEas;
import com.system.po.Userlogin;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.service.RoleInfoService;
import com.system.service.SewageC212DMService;
import com.system.service.UserloginService;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class SewageC212PhoneController {
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private SewageC212DMService sewageC212DMService;

    @RequestMapping(value = "login", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String login(String userName, String userPwd) throws Exception {
        String jsonString = "[]";
        Userlogin userlogin = userloginService.findByNameLiHua(userName);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userlogin.getUserid());
        PhoneLoginMsg phoneLoginMsg = new PhoneLoginMsg();
        if (roleInfoList.size() > 0) //如果物联网系统中已经配置
        {
            userlogin.setRoleInfoList(roleInfoList);
        } else {
            userlogin = null;
            phoneLoginMsg.setOaId("");
            phoneLoginMsg.setMessage("无登录权限");
        }
        if (userlogin != null) {
            //获取正式的密码(立华牧业用户表)
            String realPassword = MdPasswordUtil.encodePassword(userlogin.getUserid(), userPwd);
            if (!realPassword.equals(userlogin.getPassword())) {
                //密码错误
                userlogin = null;
                phoneLoginMsg.setOaId("");
                phoneLoginMsg.setMessage("密码错误");
            } else {
                Subject currentSubject = SecurityUtils.getSubject();
                Session session = currentSubject.getSession();
                // 清除 session 中的 userInfo 密码敏感信息
                userlogin.setPassword(null);
                // 设置用户信息到 Session
                session.setAttribute("userInfo", userlogin);
                UserOAEas userOAEas =  phoneUserOaEasService.selectUserOaEasByEasId(userlogin.getUserid());

                phoneLoginMsg.setOaId(userOAEas.getOaId());
                phoneLoginMsg.setMessage("登录成功");
            }
        }
        jsonString = JSON.toJSONString(phoneLoginMsg);
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = getRealSewageC212DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (sewageC212DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(sewageC212DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    /**
     * 通过用户ID和组织ID查询设备实时数据-概要信息
     *
     * @param userId
     * @param orgId
     * @return
     * @throws Exception
     */
    private List<SewageC212DeviceMessage> getRealSewageC212DeviceMessageByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = new ArrayList<SewageC212DeviceMessage>();
        if (userId == null || userId.equals(""))
            return sewageC212DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return sewageC212DeviceMessageList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return sewageC212DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC212DeviceMessageList = sewageC212DMService.selectSewageC212ByORGId(orgId);
        } else {
            sewageC212DeviceMessageList = sewageC212DMService.selectSewageC212ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return sewageC212DeviceMessageList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<SewageC212DeviceMessage> sewageC212DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (SewageC212DeviceMessage sewageC212DeviceMessage : sewageC212DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(sewageC212DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(SewageC212DeviceMessage sewageC212DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = sewageC212DeviceMessage.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(sewageC212DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(sewageC212DeviceMessage.getDName());
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }
}
