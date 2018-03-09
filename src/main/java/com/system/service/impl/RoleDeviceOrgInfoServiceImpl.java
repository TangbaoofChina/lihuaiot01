package com.system.service.impl;

import com.system.mapperiot.BootStrapTreeNodeMapper;
import com.system.mapperiot.RoleDeviceOrgInfoMapper;
import com.system.po.BootStrapTreeNode;
import com.system.po.RoleDeviceOrgInfo;
import com.system.service.RoleDeviceOrgInfoService;
import com.system.util.TreeNodeMerger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleDeviceOrgInfoServiceImpl implements RoleDeviceOrgInfoService {
    @Autowired
    private RoleDeviceOrgInfoMapper roleDeviceOrgInfoMapper;
    @Autowired
    private BootStrapTreeNodeMapper bootStrapTreeNodeMapper;

    @Override
    public List<RoleDeviceOrgInfo> selectRoleDeviceOrgInfoByRoleId(String roleId) {
        return roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleId);
    }

    @Override
    public BootStrapTreeNode selectBstnByRoleId(String roleId) {
        //显示组织结构树
        //根据节点id查找根节点
        //1、先列出当前设备列表的所有节点与根节点
        //2、查找每个根节点直到最终根节点
        List<RoleDeviceOrgInfo> roleDeviceOrgInfoList = roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleId);
        //3、整合成节点列表
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        BootStrapTreeNode bootStrapTreeNodeRoot = bootStrapTreeNodeMapper.selectORGInfoByNodeId("001");
        bootStrapTreeNodeList.add(bootStrapTreeNodeRoot);
        for (RoleDeviceOrgInfo roleDeviceOrgInfo : roleDeviceOrgInfoList) {
            //如果有完全相同的节点，则不添加
            if (!bootStrapTreeNodeList.contains(roleDeviceOrgInfo.getBootStrapTreeNode())) {
                bootStrapTreeNodeList.add(roleDeviceOrgInfo.getBootStrapTreeNode());
            }
        }
        //4、形成节点树

        return formatBootStrapTreeNode(bootStrapTreeNodeList);
    }

    @Override
    public BootStrapTreeNode selectBstnAndDeviceByRoleId(String roleId) {
        //显示组织结构树
        //根据节点id查找根节点
        //1、先列出当前设备列表的所有节点与根节点
        //2、查找每个根节点直到最终根节点
        List<RoleDeviceOrgInfo> roleDeviceOrgInfoList = roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleId);
        //3、整合成节点列表
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        BootStrapTreeNode bootStrapTreeNodeRoot = bootStrapTreeNodeMapper.selectORGInfoByNodeId("001");
        bootStrapTreeNodeList.add(bootStrapTreeNodeRoot);
        for (RoleDeviceOrgInfo roleDeviceOrgInfo : roleDeviceOrgInfoList) {
            //把设备当成节点添加进去
            BootStrapTreeNode bootStrapTreeNode = new BootStrapTreeNode();
            bootStrapTreeNode.setId(roleDeviceOrgInfo.getDeviceRoleInfo().getDevNum());
            bootStrapTreeNode.setText(roleDeviceOrgInfo.getDeviceRoleInfo().getDevName());
            bootStrapTreeNode.setpId(roleDeviceOrgInfo.getBootStrapTreeNode().getId());
            bootStrapTreeNodeList.add(bootStrapTreeNode);
            if (!bootStrapTreeNodeList.contains(roleDeviceOrgInfo.getBootStrapTreeNode())) {
                bootStrapTreeNodeList.add(roleDeviceOrgInfo.getBootStrapTreeNode());
            }
        }
        return formatBootStrapTreeNode(bootStrapTreeNodeList);
    }

    private BootStrapTreeNode formatBootStrapTreeNode(List<BootStrapTreeNode> bootStrapTreeNodeList) {
        BootStrapTreeNode mBootStrapTreeNode = new BootStrapTreeNode();
        List<BootStrapTreeNode> bootStrapTreeNodeList01 = new ArrayList<BootStrapTreeNode>();
        for (BootStrapTreeNode bootStrapTreeNode : bootStrapTreeNodeList
                ) {  //找出所有的ID和PID
            if (bootStrapTreeNode.getlPid() == null || bootStrapTreeNode.getlPid().equals(""))
                bootStrapTreeNodeList01.add(bootStrapTreeNode);
            else
                bootStrapTreeNodeList01.addAll(releaseOneLongNodeId(bootStrapTreeNode.getlPid()));
        }
        mBootStrapTreeNode = TreeNodeMerger.merge(bootStrapTreeNodeList01);
        return mBootStrapTreeNode;
    }

    private List<BootStrapTreeNode> releaseOneLongNodeId(String longNodeId) {
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        if (longNodeId.indexOf(".") > 0) {
            String[] sNodeId = longNodeId.split("\\.");
            for (int i = 0; i < sNodeId.length; i++) {
                //需要加上节点ID，父节点ID，节点名称
                BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(sNodeId[i + 1]);
                /*bootStrapTreeNode.setpId(sNodeId[i]);
                bootStrapTreeNode.setId(sNodeId[i + 1]);*/
                bootStrapTreeNodeList.add(bootStrapTreeNode);
                if (sNodeId.length == (i + 1 + 1)) //如果有3个，就是1-2,2-3的组合，
                    break;
            }
        } else {
            BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(longNodeId);
            bootStrapTreeNodeList.add(bootStrapTreeNode);
        }
        return bootStrapTreeNodeList;
    }

}
