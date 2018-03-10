package com.system.service;

import com.system.po.BootStrapTreeNode;
import com.system.po.RoleDeviceOrgInfo;
import com.system.po.RoleInfo;

import java.util.List;

public interface RoleDeviceOrgInfoService {
    List<RoleDeviceOrgInfo> selectRoleDeviceOrgInfoByRoleId(List<RoleInfo> roleInfoList);
    BootStrapTreeNode selectBstnByRoleId(List<RoleInfo> roleInfoList);
    BootStrapTreeNode selectBstnAndDeviceByRoleId(List<RoleInfo> roleInfoList);
}
