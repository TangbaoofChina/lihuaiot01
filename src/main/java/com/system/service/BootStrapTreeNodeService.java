package com.system.service;

import com.system.exception.BootStrapTreeViewException;
import com.system.po.BootStrapTreeNode;

import java.util.List;

public interface BootStrapTreeNodeService {
    //查询所有的组织信息
    List<BootStrapTreeNode> selectORGInfo() throws Exception;
    //通过组织ID，查询所有该ID的父节点信息和该ID的子信息
    BootStrapTreeNode selectORGInfoByOrgId(String orgId) throws Exception;
    //查询当前节点及以上至根节点的ID组合
    String selectParentLongIdByOrgId(String orgId) throws Exception;
    //判断是否是当前用户节点的父节点ID
    Boolean isParentId(String ordId,String userOrgId) throws Exception;
    //查询所有的组织信息和设备信息
    List<BootStrapTreeNode> selectORGAndDeviceInfo() throws Exception;
    //通过组织ID，查询该ID的一条信息
    BootStrapTreeNode  selectORGInfoByNodeId(String nodeId) throws BootStrapTreeViewException;
    //通过组织ID，以该组织ID为父ID的一层子节点信息
    List<BootStrapTreeNode>  selectORGInfoByParentId(String nodeId) throws BootStrapTreeViewException;
    //通过组织ID，查询所有该ID的父信息和该ID的子信息,还有该ID关联的设备以及下层子节点的设备
    BootStrapTreeNode selectORGAndDeviceByOrgId(String orgId) throws Exception;

    List<BootStrapTreeNode> selectORGInfoByNameAndParentId( String parentId,String sNodeName) throws Exception;
    void insertORGInfo(String parentId,String childName) throws Exception;
    void deleteORGInfoByNodeId(String nodeId) throws BootStrapTreeViewException;
    void updateORGInfoByNodeId(String nodeId,String nodeName) throws Exception;
}
