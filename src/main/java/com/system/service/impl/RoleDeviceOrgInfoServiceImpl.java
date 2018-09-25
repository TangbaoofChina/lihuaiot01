package com.system.service.impl;

import com.system.mapperiot.BootStrapTreeNodeMapper;
import com.system.mapperiot.RoleDeviceOrgInfoMapper;
import com.system.po.BootStrapTreeNode;
import com.system.po.RoleDeviceOrgInfo;
import com.system.po.RoleInfo;
import com.system.service.RoleDeviceOrgInfoService;
import com.system.util.RoleInfoListUtil;
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
    public List<RoleDeviceOrgInfo> selectRoleDeviceOrgInfoByRoleId(List<RoleInfo> roleInfoList) {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        return roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleIds);
    }

    @Override
    public BootStrapTreeNode selectBstnByRoleId(List<RoleInfo> roleInfoList) {
        //显示组织结构树
        //根据节点id查找根节点
        //1、先列出当前设备列表的所有节点与根节点
        //2、查找每个根节点直到最终根节点
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<RoleDeviceOrgInfo> roleDeviceOrgInfoList = roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleIds);
        //3、整合成节点列表
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        /*BootStrapTreeNode bootStrapTreeNodeRoot = bootStrapTreeNodeMapper.selectORGInfoByNodeId(rootId);
        bootStrapTreeNodeList.add(bootStrapTreeNodeRoot);*/
        for (RoleDeviceOrgInfo roleDeviceOrgInfo : roleDeviceOrgInfoList) {
            //去掉重复的节点
            if (!judgeContainBootStrapTreeNode(bootStrapTreeNodeList, roleDeviceOrgInfo.getBootStrapTreeNode())) {
                bootStrapTreeNodeList.add(roleDeviceOrgInfo.getBootStrapTreeNode());
            }
        }
        //4、形成节点树

        return formatBootStrapTreeNode(bootStrapTreeNodeList);
    }

    @Override
    public BootStrapTreeNode selectBstnAndDeviceByRoleId(List<RoleInfo> roleInfoList) {
        //显示组织结构树
        //根据节点id查找根节点
        //1、先列出当前设备列表的所有节点与根节点
        //2、查找每个根节点直到最终根节点
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<RoleDeviceOrgInfo> roleDeviceOrgInfoList = roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleIds);
        //3、整合成节点列表
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        /*BootStrapTreeNode bootStrapTreeNodeRoot = bootStrapTreeNodeMapper.selectORGInfoByNodeId(rootId);
        bootStrapTreeNodeList.add(bootStrapTreeNodeRoot);*/
        for (RoleDeviceOrgInfo roleDeviceOrgInfo : roleDeviceOrgInfoList) {
            //把设备当成节点添加进去
            BootStrapTreeNode bootStrapTreeNode = new BootStrapTreeNode();
            bootStrapTreeNode.setId(roleDeviceOrgInfo.getDeviceRoleInfo().getDevNum());
            bootStrapTreeNode.setText(roleDeviceOrgInfo.getDeviceRoleInfo().getDevName());
            bootStrapTreeNode.setpId(roleDeviceOrgInfo.getBootStrapTreeNode().getId());
            bootStrapTreeNode.setIcon("glyphicon glyphicon-inbox");
            //去掉数据库查询过程中重复的设备
            if (!judgeContainBootStrapTreeNode(bootStrapTreeNodeList, bootStrapTreeNode)) {
                bootStrapTreeNodeList.add(bootStrapTreeNode);
            }
            //去掉重复的节点
            if (!judgeContainBootStrapTreeNode(bootStrapTreeNodeList, roleDeviceOrgInfo.getBootStrapTreeNode())) {
                bootStrapTreeNodeList.add(roleDeviceOrgInfo.getBootStrapTreeNode());
            }
        }
        return formatBootStrapTreeNode(bootStrapTreeNodeList);
    }

    private Boolean judgeContainBootStrapTreeNode(List<BootStrapTreeNode> bootStrapTreeNodeList, BootStrapTreeNode bootStrapTreeNode) {
        for (BootStrapTreeNode bstn : bootStrapTreeNodeList
                ) {
            if (bstn.toString().equals(bootStrapTreeNode.toString()))
                return true;
        }
        return false;
    }

    private BootStrapTreeNode formatBootStrapTreeNode(List<BootStrapTreeNode> bootStrapTreeNodeList) {
        //1、找出所有的ID和PID
        //2、形成节点树
        List<BootStrapTreeNode> bootStrapTreeNodeList01 = selectBootStrapTreeNodeByLPid(bootStrapTreeNodeList);
        //这里貌似没有去掉重复的？？？
        BootStrapTreeNode mBootStrapTreeNode = TreeNodeMerger.merge(bootStrapTreeNodeList01);
        return mBootStrapTreeNode;
    }

    private List<BootStrapTreeNode> selectBootStrapTreeNodeByLPid(List<BootStrapTreeNode> bootStrapTreeNodeList) {
        List<BootStrapTreeNode> bootStrapTreeNodeList01 = new ArrayList<BootStrapTreeNode>();
        for (BootStrapTreeNode bootStrapTreeNode : bootStrapTreeNodeList
                ) {  //找出所有的ID和PID
            if (!judgeContainBootStrapTreeNode(bootStrapTreeNodeList01, bootStrapTreeNode)) {
                //再次去掉重复的
                if (bootStrapTreeNode.getlPid() == null || bootStrapTreeNode.getlPid().equals(""))
                    bootStrapTreeNodeList01.add(bootStrapTreeNode);
                else {
                    List<BootStrapTreeNode> bootStrapTreeNodeList02 = releaseOneLongNodeId(bootStrapTreeNode.getlPid());
                    for (BootStrapTreeNode bSTN01 : bootStrapTreeNodeList02
                            ) {
                        //生成的节点list，也需要去掉重复的
                        if (!judgeContainBootStrapTreeNode(bootStrapTreeNodeList01, bSTN01)) {
                            bootStrapTreeNodeList01.add(bSTN01);
                        }
                    }
                }
            }
        }
        return bootStrapTreeNodeList01;
    }

    private List<BootStrapTreeNode> releaseOneLongNodeId(String longNodeId) {
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        if (longNodeId.indexOf(".") > 0) {
            String[] sNodeId = longNodeId.split("\\.");
            for (int i = 0; i < sNodeId.length; i++) {
                //需要加上节点ID，父节点ID，节点名称
                BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(sNodeId[i]);
                /*bootStrapTreeNode.setpId(sNodeId[i]);
                bootStrapTreeNode.setId(sNodeId[i + 1]);*/
                bootStrapTreeNodeList.add(bootStrapTreeNode);
                /*if (sNodeId.length == (i + 1 + 1)) //如果有3个，就是1-2,2-3的组合，
                    break;*/
            }
        } else {
            BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(longNodeId);
            bootStrapTreeNodeList.add(bootStrapTreeNode);
        }
        return bootStrapTreeNodeList;
    }

}
