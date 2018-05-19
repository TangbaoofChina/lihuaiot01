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
        //立华牧业节点-鸡舍环控器
        BootStrapTreeNode bootStrapTreeNode1 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("111");
        List<BootStrapTreeNode> bootStrapTreeNodeChildList1 = getChildNode("111");
        bootStrapTreeNode1.setNodes(bootStrapTreeNodeChildList1);
        //立华牧业节点-污水控制器
        BootStrapTreeNode bootStrapTreeNode2 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("211");
        List<BootStrapTreeNode> bootStrapTreeNodeChildList2 = getChildNode("211");
        bootStrapTreeNode2.setNodes(bootStrapTreeNodeChildList2);
        /*//未分组节点-鸡舍环控器
        BootStrapTreeNode bootStrapTreeNode3 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("101");
        //未分组节点-污水控制器
        BootStrapTreeNode bootStrapTreeNode4 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("201");*/
        //未分组放在上面
        /*bootStrapTreeNodeList.add(bootStrapTreeNode3);
        bootStrapTreeNodeList.add(bootStrapTreeNode4);*/
        bootStrapTreeNodeList.add(bootStrapTreeNode1);
        bootStrapTreeNodeList.add(bootStrapTreeNode2);
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
        //立华牧业节点-鸡舍环控器
        BootStrapTreeNode bootStrapTreeNode01 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("111");
        //获取根节点下挂的设备
        List<BootStrapTreeNode> deviceNodeList01 = getDevicesList("111");
        List<BootStrapTreeNode> bootStrapTreeNodeChildList01 = getChildNodeAndDevice("111");
        //添加设备
        if (deviceNodeList01.size() > 0)
            bootStrapTreeNodeChildList01.addAll(deviceNodeList01);
        if (bootStrapTreeNodeChildList01.size() > 0)
            bootStrapTreeNode01.setNodes(bootStrapTreeNodeChildList01);

        //未分组节点-鸡舍环控器
        /*BootStrapTreeNode bootStrapTreeNode02 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("101");
        List<BootStrapTreeNode> deviceNodeList02 = getDevicesList("101");
        //添加设备
        if (deviceNodeList02.size() > 0)
            bootStrapTreeNode02.setNodes(deviceNodeList02);*/

        //立华牧业节点-污水控制器
        BootStrapTreeNode bootStrapTreeNode03 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("211");
        //获取根节点下挂的设备
        List<BootStrapTreeNode> deviceNodeList03 = getDevicesList("211");
        List<BootStrapTreeNode> bootStrapTreeNodeChildList03 = getChildNodeAndDevice("211");
        //添加设备
        if (deviceNodeList03.size() > 0)
            bootStrapTreeNodeChildList03.addAll(deviceNodeList03);
        if (bootStrapTreeNodeChildList03.size() > 0)
            bootStrapTreeNode03.setNodes(bootStrapTreeNodeChildList03);

        //未分组节点-污水控制器
        /*BootStrapTreeNode bootStrapTreeNode04 = bootStrapTreeNodeMapper.selectORGInfoByNodeId("201");
        List<BootStrapTreeNode> deviceNodeList04 = getDevicesList("201");
        //添加设备
        if (deviceNodeList04.size() > 0)
            bootStrapTreeNode04.setNodes(deviceNodeList04);*/

        //未分组放在上面
        /*bootStrapTreeNodeList.add(bootStrapTreeNode02);
        bootStrapTreeNodeList.add(bootStrapTreeNode04);*/
        bootStrapTreeNodeList.add(bootStrapTreeNode01);
        bootStrapTreeNodeList.add(bootStrapTreeNode03);

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
