package com.system.mapperiot;

import com.system.po.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RoleInfoMapper {
    List<RoleInfo> selectRoleInfo();
    List<RoleInfo> selectRoleInfoByRoleAdmin(String roleAdmin);
    List<RoleInfo> selectRoleInfoByRoleName(String roleName);
    List<RoleInfo> selectRoleInfoByUserId(String userId);
    void insertNewRoleInfo(@Param("roleInfo") RoleInfo roleInfo, @Param("createDate") Date createDate);
    void updateRoleInfoByRoleId(@Param("roleInfo") RoleInfo roleInfo, @Param("createDate") Date createDate);
    void deleteRoleInfoByRoleId(String roleId);
}
