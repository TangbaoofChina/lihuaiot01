package com.system.service;

import com.system.po.RoleInfo;

import java.util.List;

public interface RoleInfoService {
    List<RoleInfo> selectRoleInfo() throws Exception;
}
