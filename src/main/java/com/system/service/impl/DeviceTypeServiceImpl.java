package com.system.service.impl;

import com.system.mapperiot.DeviceTypeMapper;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;

    @Override
    public void insertDeviceType(DeviceType deviceType) {
        deviceTypeMapper.insertDeviceType(deviceType);
    }
}
