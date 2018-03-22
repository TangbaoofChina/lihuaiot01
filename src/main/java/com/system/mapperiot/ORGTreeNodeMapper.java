package com.system.mapperiot;

import com.system.po.ORGTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ORGTreeNodeMapper {
    List<ORGTreeNode> selectORGInfo();

    List<ORGTreeNode> selectORGInfoByNameAndParentId(@Param("parentId") String parentId, @Param("sNodeName") String sNodeName);

    ORGTreeNode selectORGInfoByNodeId(@Param("nodeId") String nodeId);

    List<ORGTreeNode> selectORGInfoByParentId(@Param("nodeId") String nodeId);

    int insertORGInfo(@Param("parentId") String parentId, @Param("childName") String childName);

    int deleteORGInfoByNodeId(@Param("nodeId") String nodeId);

    int updateORGInfoByNodeId(@Param("nodeId") String nodeId, @Param("nodeName") String nodeName);
}
