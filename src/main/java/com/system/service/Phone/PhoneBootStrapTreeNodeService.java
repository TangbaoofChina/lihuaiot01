package com.system.service.Phone;

import com.system.po.ORGTreeNode;
import com.system.po.RoleInfo;

import java.util.List;

public interface PhoneBootStrapTreeNodeService {
    /**
     * 查询所有组织信息
     * @return
     */
    List<ORGTreeNode> selectOrgTreeNodeInfo();

    /**
     * 查询所有组织信息
     * @return
     */
    List<ORGTreeNode> selectOrgTreeNodeInfoByRoleId(List<RoleInfo> roleInfoList);
}
