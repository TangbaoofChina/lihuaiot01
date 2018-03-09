package com.system.service;

import com.system.po.BootStrapTreeNode;
import com.system.po.RoleDeviceOrgInfo;

import java.util.List;

public interface RoleDeviceOrgInfoService {
    List<RoleDeviceOrgInfo> selectRoleDeviceOrgInfoByRoleId(String roleId);
    BootStrapTreeNode selectBstnByRoleId(String roleId);
    BootStrapTreeNode selectBstnAndDeviceByRoleId(String roleId);
}
