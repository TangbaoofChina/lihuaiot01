package com.system.service.impl;

import com.system.exception.BootStrapTreeViewException;
import com.system.mapperiot.BootStrapTreeNodeMapper;
import com.system.mapperiot.DeviceInfoMapper;
import com.system.po.BootStrapTreeNode;
import com.system.po.BootStrapTreeNodeState;
import com.system.po.parameter.DeviceType;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.DeviceTypeService;
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
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<BootStrapTreeNode> selectORGInfo() throws Exception {
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        for (DeviceType deviceType : deviceTypeList
                ) {
            BootStrapTreeNode bootStrapTreeNode1 = bootStrapTreeNodeMapper.selectORGInfoByNodeId(deviceType.getDevType());
            List<BootStrapTreeNode> bootStrapTreeNodeChildList1 = getChildNode(deviceType.getDevType());
            bootStrapTreeNode1.setNodes(bootStrapTreeNodeChildList1);
            bootStrapTreeNodeList.add(bootStrapTreeNode1);
        }
        return bootStrapTreeNodeList;
    }

    @Override
    public BootStrapTreeNode selectORGInfoByOrgId(String orgId) throws Exception {
        String myOrgId = orgId;
        BootStrapTreeNode bootStrapTreeNode = bootStrapTreeNodeMapper.selectORGInfoByNodeId(myOrgId);

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
    public String selectParentLongIdByOrgId(String orgId) throws Exception {
        String longNodeId = orgId;
        BootStrapTreeNode bootStrapTreeNodeParent = bootStrapTreeNodeMapper.selectORGInfoByNodeId(orgId);
        while (bootStrapTreeNodeParent.getpId() != null && !bootStrapTreeNodeParent.getpId().equals("")
                && !bootStrapTreeNodeParent.getpId().equals("-1")) {
            String myOrgId = bootStrapTreeNodeParent.getpId();
            longNodeId = myOrgId + "." + longNodeId;
            bootStrapTreeNodeParent = bootStrapTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
            if (bootStrapTreeNodeParent == null) {
                break;
            }
        }
        return longNodeId;
    }

    @Override
    public Boolean isParentId(String ordId, String userOrgId) throws Exception {
        return checkIsParentId(ordId, userOrgId);
    }

    @Override
    public List<BootStrapTreeNode> selectORGAndDeviceInfo() throws Exception {
        List<BootStrapTreeNode> bootStrapTreeNodeList = new ArrayList<BootStrapTreeNode>();
        List<DeviceType> deviceTypeList = deviceTypeService.selectDeviceTypeList();
        for (DeviceType deviceType : deviceTypeList
                ) {
            //立华牧业节点-鸡舍环控器
            BootStrapTreeNode bootStrapTreeNode01 = bootStrapTreeNodeMapper.selectORGInfoByNodeId(deviceType.getDevType());
            //获取根节点下挂的设备
            List<BootStrapTreeNode> deviceNodeList01 = getDevicesList(deviceType.getDevType());
            List<BootStrapTreeNode> bootStrapTreeNodeChildList01 = getChildNodeAndDevice(deviceType.getDevType());
            //添加设备
            if (deviceNodeList01.size() > 0)
                bootStrapTreeNodeChildList01.addAll(deviceNodeList01);
            if (bootStrapTreeNodeChildList01.size() > 0)
                bootStrapTreeNode01.setNodes(bootStrapTreeNodeChildList01);
            bootStrapTreeNodeList.add(bootStrapTreeNode01);
        }

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
        while (bootStrapTreeNodeParent.getpId() != null && !bootStrapTreeNodeParent.getpId().equals("")
                && !bootStrapTreeNodeParent.getpId().equals("-1")) {
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
                if (childList != null && childList.size() > 0) { //存在子节点
                    if (deviceList != null && deviceList.size() > 0)
                        childList.addAll(deviceList);
                    node.setNodes(childList);
                } else {      //不存在子节点，存在子设备
                    if (deviceList != null && deviceList.size() > 0) {
                        childList = new ArrayList<BootStrapTreeNode>();
                        childList.addAll(deviceList);
                        node.setNodes(childList);
                    }
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
            if (bootStrapTreeNodeParent.getpId() != null && !bootStrapTreeNodeParent.getpId().equals("")
                    && !bootStrapTreeNodeParent.getpId().equals("-1")) {
                if (bootStrapTreeNodeParent.getpId().equals(parentOrgId))
                    return true;
                else
                    checkIsParentId(parentOrgId, bootStrapTreeNodeParent.getpId());
            }
        }
        return false;
    }
}
