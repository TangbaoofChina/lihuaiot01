package com.system.service;

import com.system.po.RoleInfo;

import java.util.List;

public interface RoleInfoService {
    List<RoleInfo> selectRoleInfo() throws Exception;
    List<RoleInfo> selectRoleInfoByRoleName(String roleName) throws Exception;
    void insertNewRoleInfo(RoleInfo roleInfo) throws Exception;
    void updateRoleInfoByRoleId(RoleInfo roleInfo) throws Exception;
    void deleteRoleInfoByRoleId(String roleId) throws Exception;
}
