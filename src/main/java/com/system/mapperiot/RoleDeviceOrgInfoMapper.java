package com.system.mapperiot;

import com.system.po.RoleDeviceOrgInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDeviceOrgInfoMapper {
    List<RoleDeviceOrgInfo> selectRoleDeviceOrgInfoByRoleId(@Param("roleIds") List<String> roleIds);
}
