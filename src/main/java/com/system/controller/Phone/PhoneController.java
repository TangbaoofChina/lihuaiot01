package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;

    @RequestMapping(value = "selectOrgByUserId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrgByUserId(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas =  phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
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
    public String selectRealDeviceInfo(String userId, String orgId) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (orgId == null || orgId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas =  phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByORGId(orgId);
        } else {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        String jsonString = "[]";
        if (ec01DeviceMessageList.size() > 0)
            jsonString = JSON.toJSONString(ec01DeviceMessageList);
        return jsonString;
    }

    @RequestMapping(value = "selectHisDeviceInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId, String deviceId, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (deviceId == null || deviceId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas =  phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        //获取时间-start
        int mDay = Integer.parseInt(day);
        mDay = -1 * mDay;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sEndDate = simpleFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, mDay);
        date = calendar.getTime();
        String sStartDate = simpleFormat.format(date);
        //获取时间-end
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(deviceId, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            //ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(deviceId, sStartDate,sEndDate);;
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(deviceId)) {
                    ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(deviceId, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString = "[]";
        if (ec01DeviceMessageList.size() > 0)
            jsonString = JSON.toJSONString(ec01DeviceMessageList);
        return jsonString;
    }
}
