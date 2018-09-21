package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.parameter.DeviceType;
import com.system.service.*;
import com.system.util.DeviceUtil;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理，角色关联设备
 */
@Controller
@RequestMapping("/roleCombineDev")
public class RoleCombineDevController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private DeviceTypeService deviceTypeService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private PeopleRoleInfoService peopleRoleInfoService;

    @RequestMapping(value = "selectRoleInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRoleInfo() throws Exception {
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            roleInfoList = roleInfoService.selectRoleInfo();
        } else {
            for (DeviceType deviceType : deviceTypeList
                    ) {
                if (RoleInfoListUtil.checkIsControllerAdmin(userlogin.getRoleInfoList(), deviceType.getDevType())) {
                    List<RoleInfo> roleInfoListOne = roleInfoService.selectRoleInfoByRoldAdmin(deviceType.getDevType());
                    roleInfoList.addAll(roleInfoListOne);
                }
            }
        }
        String jsonString = JSON.toJSONString(roleInfoList);
        return jsonString;
    }

    @RequestMapping(value = "selectDeviceByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            //获取用户角色
            List<DeviceInfo> deviceInfoList = new ArrayList<DeviceInfo>();
            deviceInfoList = deviceInfoService.selectDeviceInfoByORGId(sORGId);
            if (deviceInfoList.size() > 0)
                jsonString = JSON.toJSONString(deviceInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectDeviceByRoleId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByRoleId(String roleId) throws Exception {
        String jsonString = "[]";
        if (roleId != null) {
            //获取用户角色
            List<DeviceInfo> deviceInfoList = new ArrayList<DeviceInfo>();
            deviceInfoList = deviceInfoService.selectDeviceInfoByRoleId(roleId);
            if (deviceInfoList.size() > 0)
                jsonString = JSON.toJSONString(deviceInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "insertRoleInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertRoleInfo(String roleNewName, String roleNewDescribe, String roleBelong) throws Exception {
        String jsonString = "新增完成";
        if (roleNewName != null) {
            //先判断名称是否存在
            //如果存在，则返回，不能新增
            //如果不存在，则继续保存
            if (roleInfoService.selectRoleInfoByRoleNameAndBelong(roleNewName, roleBelong).size() > 0) {
                jsonString = "角色名称已经存在，请更换";
            } else {
                Subject currentSubject = SecurityUtils.getSubject();
                Session session = currentSubject.getSession();
                Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
                RoleInfo roleInfo = new RoleInfo();
                roleInfo.setRoleName(roleNewName);
                roleInfo.setRoleDescribe(roleNewDescribe);
                roleInfo.setRoleCreatUserId(userlogin.getUserid());
                roleInfo.setRoleBelong(roleBelong);
                roleInfoService.insertNewRoleInfo(roleInfo);
            }
        }
        return jsonString;
    }

    @RequestMapping(value = "insertUpdateRoleDeviceList", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertUpdateRoleDeviceList(@RequestBody List<DeviceRoleInfo> roleDeviceList) throws Exception {
        String jsonString = "更新角色完成";
        String roleName = roleDeviceList.get(0).getRoleName();
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        List<String> deviceTypeNumList = DeviceUtil.getDeviceTypeNum(deviceTypeList);
        if (roleName.equals("admin")) {
            jsonString = "管理员角色名称不可修改";
        } else if (deviceTypeNumList.contains(roleName)) {
            jsonString = "管理员角色名称不可修改";
        } else if (roleDeviceList != null && roleDeviceList.size() > 0) {
            //更新角色信息表
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
            RoleInfo roleInfo = new RoleInfo();
            roleInfo.setRoleId(roleDeviceList.get(0).getRoleId());
            roleInfo.setRoleName(roleDeviceList.get(0).getRoleName());
            roleInfo.setRoleDescribe(roleDeviceList.get(0).getRoleDescribe());
            roleInfo.setRoleCreatUserId(userlogin.getUserid());
            roleInfoService.updateRoleInfoByRoleId(roleInfo);
            //更新角色设备关联表
            deviceRoleInfoService.deleteInsertDeviceRole(roleDeviceList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/deleteRoleInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteRoleInfo(String roleId, String roleName) throws Exception {
        String jsonString = "删除成功";
        //首先要判断角色是否关联了用户，如果已经关联，则不能删除
        List<PeopleRoleInfo> peopleRoleInfoList = peopleRoleInfoService.selectPeopleRoleInfoByRoleId(roleId);
        if (peopleRoleInfoList.size() > 0) {
            jsonString = "该角色正关联用户，不可删除";
            return jsonString;
        }
        //如果没有关联，则执行下面的步骤
        //删除角色设备关联表
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        List<String> deviceTypeNumList = DeviceUtil.getDeviceTypeNum(deviceTypeList);
        if (roleName.equals("admin")) {
            jsonString = "管理员角色不可删除";
        } else if (deviceTypeNumList.contains(roleName)) {
            jsonString = "管理员角色不可删除";
        } else {
            //删除角色设备关联表
            deviceRoleInfoService.deleteDeviceRoleByRoleId(roleId);
            //删除角色表
            roleInfoService.deleteRoleInfoByRoleId(roleId);
        }
        return jsonString;
    }

    @RequestMapping(value = "RoleHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String RoleHead() throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("roleName");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("角色");

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("roleDescribe");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("数据范围");

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("roleBelong");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("所属");
        mdtc3.setVisible(false);

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
