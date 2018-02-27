package com.system.service.impl;

import com.system.mapperiot.DeviceInfoMapper;
import com.system.mapperiot.ORGTreeNodeMapper;
import com.system.po.ORGTreeNode;
import com.system.service.ORGTreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ORGTreeNodeServiceImpl implements ORGTreeNodeService {
    @Autowired
    private ORGTreeNodeMapper orgTreeNodeMapper;
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public List<ORGTreeNode> selectORGInfo() throws Exception {
        return orgTreeNodeMapper.selectORGInfo();
    }

    @Override
    public List<ORGTreeNode> selectORGAndDeviceInfo() throws Exception {
        List<ORGTreeNode> orgAndDeviceTreeNodeList = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> deviceTreeNodeList = new ArrayList<ORGTreeNode>();
        orgTreeNodeList = orgTreeNodeMapper.selectORGInfo();
        deviceTreeNodeList = deviceInfoMapper.selectDeviceInfo();
        orgAndDeviceTreeNodeList.addAll(orgTreeNodeList);
        orgAndDeviceTreeNodeList.addAll(deviceTreeNodeList);
        return orgAndDeviceTreeNodeList;
    }

    @Override
    public List<ORGTreeNode> selectORGInfoByOrgId(String orgId) throws Exception {
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        String myOrgId = orgId;
        ORGTreeNode orgTreeNode = orgTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
        orgTreeNodeList.add(orgTreeNode);
        //取出当前节点的上级节点
        while (orgTreeNode.getpId() != "") {
            myOrgId = orgTreeNode.getpId();
            orgTreeNode = orgTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
            if (orgTreeNode != null) {
                orgTreeNodeList.add(orgTreeNode);
            } else {
                break;
            }
        }
        //取出当前节点的下级节点
        List<ORGTreeNode> orgTreeNodeListChild = orgTreeNodeMapper.selectORGInfoByParentId(orgId);
        if (orgTreeNodeListChild.size() > 0) {
            orgTreeNodeList.addAll(orgTreeNodeListChild);
            //需要使用迭代
            List<ORGTreeNode> orgTreeNodeListChild1 = getTreeNodeChildList(orgTreeNodeListChild);
            if (orgTreeNodeListChild1 != null & orgTreeNodeListChild1.size() > 0) {
                orgTreeNodeList.addAll(orgTreeNodeListChild1);
            }
        }
        return orgTreeNodeList;
    }

    @Override
    public List<ORGTreeNode> selectORGAndDeviceByOrgId(String orgId) throws Exception {
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        String myOrgId = orgId;
        ORGTreeNode orgTreeNode = orgTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
        List<ORGTreeNode> deviceTreeNodeList = deviceInfoMapper.selectDeviceByOrgId(myOrgId);
        orgTreeNodeList.add(orgTreeNode);
        orgTreeNodeList.addAll(deviceTreeNodeList);
        //取出当前节点的上级节点
        while (orgTreeNode.getpId() != "") {
            myOrgId = orgTreeNode.getpId();
            orgTreeNode = orgTreeNodeMapper.selectORGInfoByNodeId(myOrgId);
            if (orgTreeNode != null) {
                orgTreeNodeList.add(orgTreeNode);
            } else {
                break;
            }
        }
        //取出当前节点的下级节点
        List<ORGTreeNode> orgTreeNodeListChild = orgTreeNodeMapper.selectORGInfoByParentId(orgId);
        if (orgTreeNodeListChild.size() > 0) {
            orgTreeNodeList.addAll(orgTreeNodeListChild);
            //需要使用迭代
            List<ORGTreeNode> orgTreeNodeListChild1 = getTreeNodeAndDeviceChildList(orgTreeNodeListChild);
            if (orgTreeNodeListChild1 != null & orgTreeNodeListChild1.size() > 0) {
                orgTreeNodeList.addAll(orgTreeNodeListChild1);
            }
        }
        return orgTreeNodeList;
    }

    private List<ORGTreeNode> getTreeNodeChildList(List<ORGTreeNode> orgTreeNodeList) {
        List<ORGTreeNode> orgTreeNodeListChild = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList1 = new ArrayList<ORGTreeNode>();
        String myOrgId = "";
        for (ORGTreeNode orgTreeNode : orgTreeNodeList
                ) {
            myOrgId = orgTreeNode.getId();
            //以当前节点为父节点，查询所有子节点
            orgTreeNodeList1 = orgTreeNodeMapper.selectORGInfoByParentId(myOrgId);
            if (orgTreeNodeList1.size() > 0) {
                orgTreeNodeListChild.addAll(orgTreeNodeList1);
                List<ORGTreeNode> orgTreeNodeListChild1 = getTreeNodeChildList(orgTreeNodeList1);
                if (orgTreeNodeListChild1 != null && orgTreeNodeListChild1.size() > 0) {
                    orgTreeNodeListChild.addAll(orgTreeNodeListChild1);
                }
            }
        }
        return orgTreeNodeListChild;
    }

    private List<ORGTreeNode> getTreeNodeAndDeviceChildList(List<ORGTreeNode> orgTreeNodeList){
        List<ORGTreeNode> orgTreeNodeListChild = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList1 = new ArrayList<ORGTreeNode>();
        String myOrgId = "";
        for (ORGTreeNode orgTreeNode : orgTreeNodeList
                ) {
            myOrgId = orgTreeNode.getId();
            //添加当前节点下的所有设备
            List<ORGTreeNode> deviceTreeNodeList = deviceInfoMapper.selectDeviceByOrgId(myOrgId);
            if (deviceTreeNodeList.size() > 0)
                orgTreeNodeListChild.addAll(deviceTreeNodeList);
            //以当前节点为父节点，查询所有子节点
            orgTreeNodeList1 = orgTreeNodeMapper.selectORGInfoByParentId(myOrgId);
            if (orgTreeNodeList1.size() > 0) {
                orgTreeNodeListChild.addAll(orgTreeNodeList1);
                List<ORGTreeNode> orgTreeNodeListChild1 = getTreeNodeChildList(orgTreeNodeList1);
                if (orgTreeNodeListChild1 != null && orgTreeNodeListChild1.size() > 0) {
                    orgTreeNodeListChild.addAll(orgTreeNodeListChild1);
                }
            }
        }
        return orgTreeNodeListChild;
    }

    @Override
    public List<ORGTreeNode> selectORGInfoByNameAndParentId(String parentId, String sNodeName) throws Exception {
        return orgTreeNodeMapper.selectORGInfoByNameAndParentId(parentId, sNodeName);
    }

    @Override
    public int insertORGInfo(String parentId, String childName) throws Exception {
        return orgTreeNodeMapper.insertORGInfo(parentId, childName);
    }

    @Override
    public ORGTreeNode selectORGInfoByNodeId(String nodeId) throws Exception {
        return orgTreeNodeMapper.selectORGInfoByNodeId(nodeId);
    }

    @Override
    public int deleteORGInfoByNodeId(String nodeId) throws Exception {
        return orgTreeNodeMapper.deleteORGInfoByNodeId(nodeId);
    }

    @Override
    public List<ORGTreeNode> selectORGInfoByParentId(String nodeId) throws Exception {
        return orgTreeNodeMapper.selectORGInfoByParentId(nodeId);
    }

    @Override
    public int updateORGInfoByNodeId(String nodeId, String nodeName) throws Exception {
        return orgTreeNodeMapper.updateORGInfoByNodeId(nodeId, nodeName);
    }
}
