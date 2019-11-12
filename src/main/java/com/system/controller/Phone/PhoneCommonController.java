package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Phone.PhoneLoginMsg;
import com.system.po.Phone.PhoneTree;
import com.system.po.parameter.DeviceType;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.DeviceUtil;
import com.system.util.PhoneTreeNodeMerger;
import com.system.util.RoleInfoListUtil;
import com.system.util.msg.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/common")
public class PhoneCommonController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private BootStrapTreeNodeService bootStrapTreeNodeService;
    @Autowired
    private RoleDeviceOrgInfoService roleDeviceOrgInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping(value = "login", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
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

    /**
     * 获取树形结构-bootstrap格式
     * @param userId 用户ID
     * @param devType 设备类型
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectOrgByUserIdAndDevType", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrgByUserIdAndDevType(String userId,String devType) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        BootStrapTreeNode bootStrapTreeNode = null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            bootStrapTreeNode = bootStrapTreeNodeService.selectORGInfoByOrgId(devType);
        } else {
            bootStrapTreeNode = roleDeviceOrgInfoService.selectBstnByRoleId(roleInfoList);
        }
        if(bootStrapTreeNode == null)
            return "[]";
        String jsonString = JSON.toJSONString(bootStrapTreeNode);
        return jsonString;
    }

    //该接口貌似不通用，只能查询单个设备类型的组织结构，暂不使用
    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId,String devType) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName(devType);
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(devType, roleInfoListAdmin);
        } else {
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(devType, roleInfoList);
        }
        String jsonString = "[]";
        if (orgTreeNodeList.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList);
            PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
            jsonString = JSON.toJSONString(phoneTree);
        }
        return jsonString;
    }

    @RequestMapping(value = "insertDeviceTypeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertDeviceTypeInfo(String sDevType, String sDevTypeDescribe) throws Exception {
        String jsonString = JSON.toJSONString(ResponseUtil.setResponseOk("新增完成"));
        if (sDevType != null) {
            DeviceType deviceType = new DeviceType();
            deviceType.setDevType(sDevType);
            deviceType.setDevTypeDescribe(sDevTypeDescribe);
            deviceTypeService.insertDeviceType(deviceType);
        }
        return jsonString;
    }
}
