package com.system.mapperiot;

import com.system.po.RoleDeviceOrgInfo;

import java.util.List;

public interface RoleDeviceOrgInfoMapper {
    List<RoleDeviceOrgInfo> selectRoleDeviceOrgInfoByRoleId(String roleId);
}
