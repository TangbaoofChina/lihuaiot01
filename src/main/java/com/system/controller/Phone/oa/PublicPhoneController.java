package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Phone.PhoneLoginMsg;
import com.system.po.Phone.PhoneTree;
import com.system.po.parameter.DeviceType;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.DeviceTypeService;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.service.RoleInfoService;
import com.system.service.UserloginService;
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

/**
 * @ClassName PhonePublicController
 * @Description 通用接口
 * @Author tangbao
 * @Date 2019-11-01 8:26
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/public")
public class PublicPhoneController extends BaseController{
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping(value = "login", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String login(String userName, String userPwd) throws Exception {
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild());
        Userlogin userlogin = userloginService.findByNameLiHua(userName);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userlogin.getUserid());
        PhoneLoginMsg phoneLoginMsg = new PhoneLoginMsg();
        if (roleInfoList.size() > 0) {   //如果物联网系统中已经配置
            userlogin.setRoleInfoList(roleInfoList);
        } else {
            userlogin = null;
            jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("无登录权限"));
        }
        if (userlogin != null) {
            //获取正式的密码(立华牧业用户表)
            String realPassword = MdPasswordUtil.encodePassword(userlogin.getUserid(), userPwd);
            if (!realPassword.equals(userlogin.getPassword())) {
                //密码错误
                userlogin = null;
                jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("密码错误"));
            } else {
                Subject currentSubject = SecurityUtils.getSubject();
                Session session = currentSubject.getSession();
                // 清除 session 中的 userInfo 密码敏感信息
                userlogin.setPassword(null);
                // 设置用户信息到 Session
                session.setAttribute("userInfo", userlogin);
                UserOAEas2019 userOAEas =  phoneUserOaEasService.selectUserOaEasByEasId2019(userlogin.getUserid());
                phoneLoginMsg.setOaId(userOAEas.getOaId2019());
                phoneLoginMsg.setMessage("登录成功");
                jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneLoginMsg));
            }
        }
        return jsonString;
    }

    //该接口貌似不通用，只能查询单个设备类型的组织结构，暂不使用
    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId,String devType) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild());
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        try {
            if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
                List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName(devType);
                orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(devType, roleInfoListAdmin);
            } else {
                orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(devType, roleInfoList);
            }
            List<PhoneTree> phoneTrees = new ArrayList<>();
            if (orgTreeNodeList.size() > 0) {
                List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList);
                PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
                phoneTrees.add(phoneTree);
            }
            if (phoneTrees.size() > 0)
                jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneTrees));
        } catch (Exception ex) {
            ex.printStackTrace();
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
