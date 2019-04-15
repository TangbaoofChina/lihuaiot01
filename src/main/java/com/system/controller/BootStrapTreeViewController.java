package com.system.controller;

import com.alibaba.fastjson.JSON;
import com.system.po.parameter.DeviceType;
import com.system.util.RoleInfoListUtil;
import com.system.po.*;
import com.system.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bootStrapTreeNode")
public class BootStrapTreeViewController {

    @Autowired
    private BootStrapTreeNodeService bootStrapTreeNodeService;
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private DeviceTypeService deviceTypeService;
    @Autowired
    private RoleDeviceOrgInfoService roleDeviceOrgInfoService;

    @RequestMapping(value = "selectTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectTreeNode() throws Exception {
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            bootStrapTreeNodeList = bootStrapTreeNodeService.selectORGInfo();
        } else {
            for (DeviceType deviceType : deviceTypeList
                    ) {
                if (RoleInfoListUtil.checkIsControllerAdmin(userlogin.getRoleInfoList(), deviceType.getDevType())) {
                    BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeService.selectORGInfoByOrgId(deviceType.getDevType());
                    bootStrapTreeNodeList.add(bootStrapTreeNode);
                } else {
                    List<RoleInfo> roleInfoList = RoleInfoListUtil.getRoleInfoFromRoleInfoListByDevtype(userlogin.getRoleInfoList(), deviceType.getDevType());
                    if (roleInfoList.size() > 0) {
                        BootStrapTreeNode bootStrapTreeNode = roleDeviceOrgInfoService.selectBstnByRoleId(roleInfoList);
                        bootStrapTreeNodeList.add(bootStrapTreeNode);
                    }
                }
            }
        }
        String jsonString = JSON.toJSONString(bootStrapTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "selectORGAndDeviceTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectORGAndDeviceTreeNode() throws Exception {
//获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            bootStrapTreeNodeList = bootStrapTreeNodeService.selectORGAndDeviceInfo();
        } else {
            for (DeviceType deviceType : deviceTypeList
                    ) {
                if (RoleInfoListUtil.checkIsControllerAdmin(userlogin.getRoleInfoList(), deviceType.getDevType())) {
                    RoleInfo roleInfo = RoleInfoListUtil.getRoleAdminByDevtype(userlogin.getRoleInfoList(), deviceType.getDevType());
                    List<RoleInfo> roleInfoList = new ArrayList<>();
                    roleInfoList.add(roleInfo);
                    BootStrapTreeNode bootStrapTreeNode = roleDeviceOrgInfoService.selectBstnAndDeviceByRoleId(roleInfoList);
                    bootStrapTreeNodeList.add(bootStrapTreeNode);
                } else {
                    List<RoleInfo> roleInfoList = RoleInfoListUtil.getRoleInfoFromRoleInfoListByDevtype(userlogin.getRoleInfoList(), deviceType.getDevType());
                    if (roleInfoList.size() > 0) {
                        BootStrapTreeNode bootStrapTreeNode = roleDeviceOrgInfoService.selectBstnAndDeviceByRoleId(roleInfoList);
                        bootStrapTreeNodeList.add(bootStrapTreeNode);
                    }
                }
            }
        }
        String jsonString = JSON.toJSONString(bootStrapTreeNodeList);

        return jsonString;
    }

    @RequestMapping(value = "addZTreeNodeChild", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addZTreeNodeChild(String parentId, String childName) throws Exception {
        /*if (parentId.equals("101")) {
            return "未分组不允许增加子节点";
        }
        if (parentId.equals("201")) {
            return "未分组不允许增加子节点";
        }*/
        List<BootStrapTreeNode> bootStrapTreeNodeList = bootStrapTreeNodeService.selectORGInfoByNameAndParentId(parentId, childName);
        if (bootStrapTreeNodeList.size() == 0) {
            bootStrapTreeNodeService.insertORGInfo(parentId, childName);
            bootStrapTreeNodeList = bootStrapTreeNodeService.selectORGInfoByNameAndParentId(parentId, childName);
        }
        String jsonString = JSON.toJSONString(bootStrapTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "removeZTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String removeZTreeNode(String nodeId) throws Exception {
        if (nodeId.length() == 3) {
            return "固定分组不允许删除";
        }
/*        if (nodeId.equals("001")) {
            return "根节点不允许删除";
        }*/
        List<BootStrapTreeNode> bootStrapTreeNodeList = bootStrapTreeNodeService.selectORGInfoByParentId(nodeId);
        //List<PeopleInfo> peopleInfoList = peopleCombineOrgService.selectPeopleByORGId(nodeId);
        List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByORGId(nodeId);
        String jsonString = "删除成功";
        if (deviceInfoList.size() > 0) {
            return "存在关联设备，不能删除";
        }
        /*if (peopleInfoList.size() > 0) {
            return "存在关联用户，不能删除";
        }*/
        if (bootStrapTreeNodeList.size() > 0) {
            return "存在子节点，不能删除";
        }
        BootStrapTreeNode orgTreeNode = bootStrapTreeNodeService.selectORGInfoByNodeId(nodeId);
        if (orgTreeNode != null) {
            bootStrapTreeNodeService.deleteORGInfoByNodeId(nodeId);
        }
        return jsonString;
    }

    @RequestMapping(value = "renameZTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String renameZTreeNode(String nodeId, String nodeName) throws Exception {
        String jsonString = "修改成功";

        BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeService.selectORGInfoByNodeId(nodeId);
        if (bootStrapTreeNode != null) {
            bootStrapTreeNodeService.updateORGInfoByNodeId(nodeId, nodeName);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectDeviceTypeTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceTypeTreeNode() throws Exception{
        String jsonString = "";
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();

        return jsonString;
    }
}
