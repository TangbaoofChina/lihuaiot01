package com.system.service;

import com.system.po.ORGTreeNode;

import java.util.List;

public interface ORGTreeNodeService {
    //查询所有的组织信息
    List<ORGTreeNode> selectORGInfo() throws Exception;
    //通过组织ID，查询所有该ID的父信息和该ID的子信息
    List<ORGTreeNode> selectORGInfoByOrgId(String orgId) throws Exception;
    //通过组织ID，查询该ID的一条信息
    ORGTreeNode  selectORGInfoByNodeId(String nodeId) throws Exception;
    //通过组织ID，以该组织ID为父ID的一层子节点信息
    List<ORGTreeNode>  selectORGInfoByParentId(String nodeId) throws Exception;
    //查询所有的组织信息和设备信息
    List<ORGTreeNode> selectORGAndDeviceInfo() throws Exception;
    //通过组织ID，查询所有该ID的父信息和该ID的子信息,还有该ID关联的设备以及下层子节点的设备
    List<ORGTreeNode> selectORGAndDeviceByOrgId(String orgId) throws Exception;


    List<ORGTreeNode> selectORGInfoByNameAndParentId( String parentId,String sNodeName) throws Exception;
    int insertORGInfo(String parentId,String childName) throws Exception;

    int deleteORGInfoByNodeId(String nodeId) throws Exception;
    int updateORGInfoByNodeId(String nodeId,String nodeName) throws Exception;
}
