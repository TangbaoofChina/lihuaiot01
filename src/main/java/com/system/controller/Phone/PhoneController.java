package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.EC01DeviceMessageService;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.RoleDeviceOrgInfoService;
import com.system.service.RoleInfoService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;

    @RequestMapping(value = "selectOrgByUserId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrgByUserId(String userId) throws Exception {
        if(userId == null || userId.equals(""))
            return "[]";
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userId);
        if(roleInfoList.size() < 1)
            return "[]";
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfo();
        } else {
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(roleInfoList);
        }
        String jsonString = JSON.toJSONString(orgTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfo(String userId,String orgId) throws Exception {
        if(userId == null || userId.equals(""))
            return "[]";
        if(orgId == null || orgId.equals(""))
            return "[]";
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userId);
        if(roleInfoList.size() < 1)
            return "[]";
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByORGId(orgId);
        } else {
            ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(orgId, roleInfoList);;
        }
        String jsonString = "[]";
        if (ec01DeviceMessageList.size() > 0)
            jsonString = JSON.toJSONString(ec01DeviceMessageList);
        return jsonString;
    }

    @RequestMapping(value = "selectHisDeviceInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId,String deviceId,String day) throws Exception {
        if(userId == null || userId.equals(""))
            return "[]";
        if(deviceId == null || deviceId.equals(""))
            return "[]";
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userId);
        if(roleInfoList.size() < 1)
            return "[]";
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            //ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(deviceId,sStartDate,sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            //ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(deviceId, sStartDate,sEndDate);;
        }
        String jsonString = "[]";
        if (ec01DeviceMessageList.size() > 0)
            jsonString = JSON.toJSONString(ec01DeviceMessageList);
        return jsonString;
    }
}
