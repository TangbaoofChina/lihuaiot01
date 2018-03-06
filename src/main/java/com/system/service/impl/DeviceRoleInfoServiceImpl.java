package com.system.service.impl;

import com.system.mapperiot.DeviceRoleInfoMapper;
import com.system.po.DeviceInfo;
import com.system.po.DeviceRoleInfo;
import com.system.service.DeviceRoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceRoleInfoServiceImpl implements DeviceRoleInfoService {
    @Autowired
    private DeviceRoleInfoMapper deviceRoleInfoMapper;

    @Override
    public void deleteInsertDeviceRole(List<DeviceRoleInfo> deviceRoleInfoList)throws Exception{
        deviceRoleInfoMapper.deleteDeviceRoleInfoByRoleId(deviceRoleInfoList.get(0).getRoleId());
        deviceRoleInfoMapper.insertDeviceRoleInfo(deviceRoleInfoList);
    }

    @Override
    public void deleteDeviceRoleByRoleId(String roleId) throws Exception{
        deviceRoleInfoMapper.deleteDeviceRoleInfoByRoleId(roleId);
    }

}
