package com.system.service.impl.Phone;

import com.system.mapperiot.ORGTreeNodeMapper;
import com.system.mapperiot.RoleDeviceOrgInfoMapper;
import com.system.po.BootStrapTreeNode;
import com.system.po.ORGTreeNode;
import com.system.po.RoleDeviceOrgInfo;
import com.system.po.RoleInfo;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneBootStrapTreeNodeServiceImpl implements PhoneBootStrapTreeNodeService {
    @Autowired
    private ORGTreeNodeMapper orgTreeNodeMapper;
    @Autowired
    private RoleDeviceOrgInfoMapper roleDeviceOrgInfoMapper;

    @Override
    public List<ORGTreeNode> selectOrgTreeNodeInfo() {
        return orgTreeNodeMapper.selectORGInfo();
    }

    @Override
    public List<ORGTreeNode> selectOrgTreeNodeInfoByRoleId(List<RoleInfo> roleInfoList) {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        //根据节点id查找根节点
        //1、先列出当前设备列表的所有节点与根节点
        //2、查找每个根节点直到最终根节点
        List<RoleDeviceOrgInfo> roleDeviceOrgInfoList = roleDeviceOrgInfoMapper.selectRoleDeviceOrgInfoByRoleId(roleIds);
        //3、整合成节点列表
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        //默认要增加根节点
        ORGTreeNode orgTreeNodeRoot =  orgTreeNodeMapper.selectORGInfoByNodeId("001");
        orgTreeNodeList.add(orgTreeNodeRoot);
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        for (RoleDeviceOrgInfo roleDeviceOrgInfo : roleDeviceOrgInfoList
             ) {
            bootStrapTreeNodeList.add(roleDeviceOrgInfo.getBootStrapTreeNode());
        }
        List<ORGTreeNode> orgTreeNodeList01 = selectORGTreeNodeByLPid(bootStrapTreeNodeList);
        for (ORGTreeNode orgTreeNode : orgTreeNodeList01) {
            //去掉重复的节点
            if (!judgeContainOrgTreeNode(orgTreeNodeList, orgTreeNode)) {
                orgTreeNodeList.add(orgTreeNode);
            }
        }
        return orgTreeNodeList;
    }

    private Boolean judgeContainOrgTreeNode(List<ORGTreeNode> orgTreeNodeList, ORGTreeNode orgTreeNode) {
        for (ORGTreeNode otn : orgTreeNodeList
                ) {
            if (otn.toString().equals(orgTreeNode.toString())) {
                return true;
            }
        }
        return false;
    }

    private List<ORGTreeNode> selectORGTreeNodeByLPid(List<BootStrapTreeNode> bootStrapTreeNodeList)
    {
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        for (BootStrapTreeNode bootStrapTreeNode : bootStrapTreeNodeList
                ) {  //找出所有的ID和PID
            if (bootStrapTreeNode.getlPid() == null || bootStrapTreeNode.getlPid().equals("")) {
                ORGTreeNode orgTreeNode = new ORGTreeNode();
                orgTreeNode.setId(bootStrapTreeNode.getId());
                orgTreeNode.setpId(bootStrapTreeNode.getpId());
                orgTreeNode.setName(bootStrapTreeNode.getText());
                orgTreeNodeList.add(orgTreeNode);
            }
            else
                orgTreeNodeList.addAll(releaseOneLongNodeId(bootStrapTreeNode.getlPid()));
        }
        return orgTreeNodeList;
    }

    private List<ORGTreeNode> releaseOneLongNodeId(String longNodeId) {
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        if (longNodeId.indexOf(".") > 0) {
            String[] sNodeId = longNodeId.split("\\.");
            for (int i = 0; i < sNodeId.length; i++) {
                //需要加上节点ID，父节点ID，节点名称
                ORGTreeNode orgTreeNode = orgTreeNodeMapper.selectORGInfoByNodeId(sNodeId[i + 1]);
                orgTreeNodeList.add(orgTreeNode);
                if (sNodeId.length == (i + 1 + 1)) //如果有3个，就是1-2,2-3的组合，
                    break;
            }
        } else {
            ORGTreeNode orgTreeNode = orgTreeNodeMapper.selectORGInfoByNodeId(longNodeId);
            orgTreeNodeList.add(orgTreeNode);
        }
        return orgTreeNodeList;
    }
}
