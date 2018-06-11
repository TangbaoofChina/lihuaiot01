package com.system.service.impl;

import com.system.mapperiot.RoleInfoMapper;
import com.system.po.RoleInfo;
import com.system.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public List<RoleInfo> selectRoleInfo() throws Exception {
        return roleInfoMapper.selectRoleInfo();
    }

    @Override
    public List<RoleInfo> selectRoleInfoByRoldAdmin(String roleAdmin) throws Exception {
        return roleInfoMapper.selectRoleInfoByRoleAdmin(roleAdmin);
    }

    @Override
    public List<RoleInfo> selectRoleInfoByRoleName(String roleName) throws Exception {
        return roleInfoMapper.selectRoleInfoByRoleName(roleName);
    }

    @Override
    public List<RoleInfo> selectRoleInfoByRoleNameAndBelong(String roleName, String roleBelong) throws Exception {
        return roleInfoMapper.selectRoleInfoByRoleNameAndBelong(roleName,roleBelong);
    }

    @Override
    public List<RoleInfo> selectRoleInfoByUserId(String userId) throws Exception {
        return roleInfoMapper.selectRoleInfoByUserId(userId);
    }

    @Override
    public void insertNewRoleInfo(RoleInfo roleInfo) throws Exception {
        roleInfoMapper.insertNewRoleInfo(roleInfo, new Date());
    }

    @Override
    public void updateRoleInfoByRoleId(RoleInfo roleInfo) throws Exception {
        roleInfoMapper.updateRoleInfoByRoleId(roleInfo, new Date());
    }

    @Override
    public void deleteRoleInfoByRoleId(String roleId) throws Exception {
        roleInfoMapper.deleteRoleInfoByRoleId(roleId);
    }
}
