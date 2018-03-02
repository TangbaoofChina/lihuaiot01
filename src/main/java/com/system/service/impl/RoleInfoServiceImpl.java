package com.system.service.impl;

import com.system.mapperiot.RoleInfoMapper;
import com.system.po.RoleInfo;
import com.system.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public List<RoleInfo> selectRoleInfo() throws Exception{
        return roleInfoMapper.selectRoleInfo();
    }
}
