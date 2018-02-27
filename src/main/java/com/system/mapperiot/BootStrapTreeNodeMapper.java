package com.system.mapperiot;

import com.system.po.BootStrapTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BootStrapTreeNodeMapper {
    List<BootStrapTreeNode>  selectORGInfoByParentId(@Param("parentId") String parentId);
    BootStrapTreeNode  selectORGInfoByNodeId(@Param("nodeId") String nodeId);

    List<BootStrapTreeNode> selectORGInfo();
    void insertORGInfo(@Param("parentId") String parentId, @Param("childName") String childName);
    List<BootStrapTreeNode> selectORGInfoByNameAndParentId(@Param("parentId") String parentId,@Param("sNodeName") String sNodeName);
    void deleteORGInfoByNodeId(@Param("nodeId") String nodeId);
    void updateORGInfoByNodeId(@Param("nodeId")String nodeId,@Param("nodeName")String nodeName);
}
