package com.system.service.impl;

import com.system.exception.BootStrapTreeViewException;
import com.system.mapperiot.BootStrapTreeNodeMapper;
import com.system.mapperiot.DeviceInfoMapper;
import com.system.po.BootStrapTreeNode;
import com.system.po.BootStrapTreeNodeState;
import com.system.service.BootStrapTreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootStrapTreeNodeServiceImpl implements BootStrapTreeNodeService {

    @Autowired
    private BootStrapTreeNodeMapper bootStrapTreeNodeMapper;
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public List<BootStrapTreeNode> selectORGInfo() throws Exception {
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        //立华牧业节点
        BootStrapTreeNode bootStrapTreeNode1 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("001");
        List<BootStrapTreeNode> bootStrapTreeNodeChildList = getChildNode("001");
        bootStrapTreeNode1.setNodes(bootStrapTreeNodeChildList);
        //未分组节点
        BootStrapTreeNode bootStrapTreeNode2 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("002");
        //未分组放在上面
        bootStrapTreeNodeList.add(bootStrapTreeNode2);
        bootStrapTreeNodeList.add(bootStrapTreeNode1);
        return bootStrapTreeNodeList;
    }

    @Override
    public BootStrapTreeNode selectORGInfoByOrgId(String orgId) throws Exception {
        String myOrgId = orgId;
        BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
        /*List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        bootStrapTreeNodeList.add(bootStrapTreeNode);
        if (bootStrapTreeNode.getpId() != "") {
            //取出当前节点的上级节点
            List<BootStrapTreeNode> bootStrapTreeNodeParentList = getParentNode(bootStrapTreeNode.getpId());
        }*/

        //取出当前节点的下级节点
        List<BootStrapTreeNode> bootStrapTreeNodeChildList = getChildNode(orgId);
        if (bootStrapTreeNodeChildList.size() > 0) {
            bootStrapTreeNode.setNodes(bootStrapTreeNodeChildList);
        }
        //取出当前节点的上级节点
        BootStrapTreeNode bootStrapTreeNodeParent = getParentNode(bootStrapTreeNode);
        return bootStrapTreeNodeParent;
    }

    @Override
    public Boolean isParentId(String ordId, String userOrgId) throws Exception {
        return checkIsParentId(ordId,userOrgId);
    }

    @Override
    public List<BootStrapTreeNode> selectORGAndDeviceInfo() throws Exception {
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        //立华牧业节点
        BootStrapTreeNode bootStrapTreeNode01 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("001");
        List<BootStrapTreeNode> deviceNodeList01 = getDevicesList("001");
        List<BootStrapTreeNode> bootStrapTreeNodeChildList = getChildNodeAndDevice("001");
        //添加设备
        bootStrapTreeNodeChildList.addAll(deviceNodeList01);
        bootStrapTreeNode01.setNodes(bootStrapTreeNodeChildList);

        //未分组节点
        BootStrapTreeNode bootStrapTreeNode02 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("002");
        List<BootStrapTreeNode> deviceNodeList02 = getDevicesList("002");
        //添加设备
        bootStrapTreeNode02.setNodes(deviceNodeList02);
        //未分组放在上面
        bootStrapTreeNodeList.add(bootStrapTreeNode02);
        bootStrapTreeNodeList.add(bootStrapTreeNode01);
        return bootStrapTreeNodeList;
    }

    @Override
    public BootStrapTreeNode selectORGAndDeviceByOrgId(String orgId) throws Exception {
        String myOrgId = orgId;
        BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
        List<BootStrapTreeNode> deviceNodeList = getDevicesList(myOrgId);
        //取出当前节点的下级节点
        List<BootStrapTreeNode> bootStrapTreeNodeChildList = getChildNodeAndDevice(orgId);
        //添加设备
        if (deviceNodeList.size() > 0) {
            bootStrapTreeNodeChildList.addAll(deviceNodeList);
        }
        if (bootStrapTreeNodeChildList.size() > 0) {
            bootStrapTreeNode.setNodes(bootStrapTreeNodeChildList);
        }
        //取出当前节点的上级节点
        BootStrapTreeNode bootStrapTreeNodeParent = getParentNode(bootStrapTreeNode);
        return bootStrapTreeNodeParent;
    }

    @Override
    public BootStrapTreeNode selectORGInfoByNodeId(String nodeId) throws BootStrapTreeViewException {
        return bootStrapTreeNodeMapper.selectORGInfoByNodeId(nodeId);
    }

    @Override
    public List<BootStrapTreeNode> selectORGInfoByParentId(String nodeId) throws BootStrapTreeViewException {
        return bootStrapTreeNodeMapper.selectORGInfoByParentId(nodeId);
    }

    @Override
    public List<BootStrapTreeNode> selectORGInfoByNameAndParentId(String parentId, String sNodeName) throws Exception {
        return bootStrapTreeNodeMapper.selectORGInfoByNameAndParentId(parentId, sNodeName);
    }

    @Override
    public void insertORGInfo(String parentId, String childName) throws Exception {
        bootStrapTreeNodeMapper.insertORGInfo(parentId, childName);
    }

    @Override
    public void deleteORGInfoByNodeId(String nodeId) throws BootStrapTreeViewException {
        bootStrapTreeNodeMapper.deleteORGInfoByNodeId(nodeId);
    }

    @Override
    public void updateORGInfoByNodeId(String nodeId, String nodeName) throws Exception {
        bootStrapTreeNodeMapper.updateORGInfoByNodeId(nodeId, nodeName);
    }

    //***************私有方法*************************/
    private BootStrapTreeNode getParentNode(BootStrapTreeNode bootStrapTreeNode) throws Exception {
        BootStrapTreeNode bootStrapTreeNodeParent = bootStrapTreeNode;
        while (bootStrapTreeNodeParent.getpId() != null && !bootStrapTreeNodeParent.getpId().equals("")) {
            List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
            bootStrapTreeNodeList.add(bootStrapTreeNodeParent);
            String myOrgId = bootStrapTreeNodeParent.getpId();
            bootStrapTreeNodeParent = bootStrapTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
            if (bootStrapTreeNodeParent != null) {
                bootStrapTreeNodeParent.setNodes(bootStrapTreeNodeList);
                BootStrapTreeNodeState bootStrapTreeNodeState = new BootStrapTreeNodeState();
                bootStrapTreeNodeState.setExpanded(true);
                bootStrapTreeNodeParent.setState(bootStrapTreeNodeState);
            } else {
                break;
            }
        }
        return bootStrapTreeNodeParent;
    }

    private List<BootStrapTreeNode> getChildNode(String parentId) throws Exception {
        List<BootStrapTreeNode> rootList = new ArrayList<BootStrapTreeNode>();
        //根据父Id获取子节点
        List<BootStrapTreeNode> nodelist = getEntityList(parentId);
        if (nodelist != null && nodelist.size() > 0) {
            rootList = new ArrayList<BootStrapTreeNode>();
            BootStrapTreeNode node = null;
            List<BootStrapTreeNode> childList = null;
            for (BootStrapTreeNode bootStrapTreeNode : nodelist) {
                node = new BootStrapTreeNode();
                node.setId(bootStrapTreeNode.getId());
                node.setText(bootStrapTreeNode.getText());
                node.setpId(bootStrapTreeNode.getpId());
                childList = getChildNode(bootStrapTreeNode.getId());
                if (childList != null && childList.size() > 0)
                    node.setNodes(childList);
                rootList.add(node);
            }
        }
        return rootList;
    }

    private List<BootStrapTreeNode> getChildNodeAndDevice(String parentId) throws Exception {
        List<BootStrapTreeNode> rootList = new ArrayList<BootStrapTreeNode>();
        //根据父Id获取子节点
        List<BootStrapTreeNode> nodelist = getEntityList(parentId);
        if (nodelist != null && nodelist.size() > 0) {
            rootList = new ArrayList<BootStrapTreeNode>();
            BootStrapTreeNode node = null;
            List<BootStrapTreeNode> deviceList = null;
            List<BootStrapTreeNode> childList = null;
            for (BootStrapTreeNode bootStrapTreeNode : nodelist) {
                node = new BootStrapTreeNode();
                node.setId(bootStrapTreeNode.getId());
                node.setText(bootStrapTreeNode.getText());
                node.setpId(bootStrapTreeNode.getpId());
                deviceList = getDevicesList(bootStrapTreeNode.getId());
                childList = getChildNodeAndDevice(bootStrapTreeNode.getId());
                if (childList != null && childList.size() > 0) {
                    if (deviceList != null && deviceList.size() > 0)
                        childList.addAll(deviceList);
                    node.setNodes(childList);
                }
                rootList.add(node);
            }
        }
        return rootList;
    }

    private List<BootStrapTreeNode> getEntityList(String parentId) throws Exception {
        List<BootStrapTreeNode> rootList = bootStrapTreeNodeMapper.selectORGInfoByParentId(parentId);
        return rootList;
    }

    private List<BootStrapTreeNode> getDevicesList(String orgId) throws Exception {
        List<BootStrapTreeNode> devicelist = deviceInfoMapper.selectBstDeviceByOrgId(orgId);
        for (BootStrapTreeNode bootStrapTreeNode : devicelist) {
            bootStrapTreeNode.setIcon("glyphicon glyphicon-inbox");
        }
        return devicelist;
    }

    private List<BootStrapTreeNode> expentChildNodeByOrgId(List<BootStrapTreeNode> bootStrapTreeNodeChildList, String expendOrgId) throws Exception {
        for (BootStrapTreeNode bootStrapTreeNode : bootStrapTreeNodeChildList
                ) {
            if (bootStrapTreeNode.getNodes() != null && bootStrapTreeNode.getNodes().size() > 0) {
                expentChildNodeByOrgId(bootStrapTreeNode.getNodes(), expendOrgId);
            }
            if (bootStrapTreeNode.getId().equals(expendOrgId)) {
                BootStrapTreeNodeState bootStrapTreeNodeState = new BootStrapTreeNodeState();
                bootStrapTreeNodeState.setExpanded(true);
                bootStrapTreeNode.setState(bootStrapTreeNodeState);
            }
        }
        return bootStrapTreeNodeChildList;
    }

    private boolean checkIsParentId(String parentOrgId, String myOrgId) throws Exception {
        BootStrapTreeNode bootStrapTreeNodeParent = bootStrapTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
        if (bootStrapTreeNodeParent != null) {
            if ( bootStrapTreeNodeParent.getpId() != null && !bootStrapTreeNodeParent.getpId().equals("")) {
                if (bootStrapTreeNodeParent.getpId().equals(parentOrgId))
                    return true;
                else
                    checkIsParentId(parentOrgId, bootStrapTreeNodeParent.getpId());
            }
        }
        return false;
    }
}
