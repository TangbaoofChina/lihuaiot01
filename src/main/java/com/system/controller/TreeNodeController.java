package com.system.controller;

import com.alibaba.fastjson.JSON;
import com.system.po.ORGTreeNode;
import com.system.po.PeopleInfo;
import com.system.po.Userlogin;
import com.system.service.ORGTreeNodeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/treeNode-BackUp")
public class TreeNodeController {
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;

    @RequestMapping(value = "selectTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectZTreeNode() throws Exception {
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<ORGTreeNode> zTreeNodeList = null;
        if (userlogin.getRoleName().equals("admin")) {
            zTreeNodeList = orgTreeNodeService.selectORGInfo();
        } else {
            zTreeNodeList = orgTreeNodeService.selectORGInfoByOrgId(userlogin.getOrgid());
        }

        String jsonString = JSON.toJSONString(zTreeNodeList);

        return jsonString;
    }

    @RequestMapping(value = "selectORGAndDeviceTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectORGAndDeviceTreeNode() throws Exception {
//获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<ORGTreeNode> zTreeNodeList = null;
        if (userlogin.getRoleName().equals("admin")) {
            zTreeNodeList = orgTreeNodeService.selectORGAndDeviceInfo();
        } else {
            zTreeNodeList = orgTreeNodeService.selectORGAndDeviceByOrgId(userlogin.getOrgid());
        }

        String jsonString = JSON.toJSONString(zTreeNodeList);

        return jsonString;
    }

    @RequestMapping(value = "addZTreeNodeChild", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addZTreeNodeChild(String parentId, String childName) throws Exception {
        List<ORGTreeNode> zTreeNodeList = orgTreeNodeService.selectORGInfoByNameAndParentId(parentId, childName);
        if (zTreeNodeList.size() == 0) {
            orgTreeNodeService.insertORGInfo(parentId, childName);
            zTreeNodeList = orgTreeNodeService.selectORGInfoByNameAndParentId(parentId, childName);
        }
        String jsonString = JSON.toJSONString(zTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "removeZTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String removeZTreeNode(String nodeId) throws Exception {
        List<ORGTreeNode> zTreeNodeChildList = orgTreeNodeService.selectORGInfoByParentId(nodeId);

        String jsonString = "删除成功";
        if (nodeId.equals("002")) {
            return "未分组不允许删除";
        }
        if (zTreeNodeChildList.size() > 0) {
            jsonString = "存在子节点，不能删除";
        } else {
            ORGTreeNode orgTreeNode = orgTreeNodeService.selectORGInfoByNodeId(nodeId);
            if (orgTreeNode !=null) {
                int iResult = orgTreeNodeService.deleteORGInfoByNodeId(nodeId);
            }
        }
        return jsonString;
    }

    @RequestMapping(value = "renameZTreeNode", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String renameZTreeNode(String nodeId, String nodeName) throws Exception {
        String jsonString = "修改成功";

        ORGTreeNode orgTreeNode = orgTreeNodeService.selectORGInfoByNodeId(nodeId);
        if (orgTreeNode != null) {
            int iResult = orgTreeNodeService.updateORGInfoByNodeId(nodeId, nodeName);
        }
        return jsonString;
    }
}
