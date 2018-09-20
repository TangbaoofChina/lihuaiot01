package com.system.service.impl;

import com.system.mapperiot.DeviceTypeMapper;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;

    @Override
    public void insertDeviceType(DeviceType deviceType) {
        deviceTypeMapper.insertDeviceType(deviceType);
    }

    @Override
    public List<DeviceType> selectDeviceTypeList() {
        return deviceTypeMapper.selectDeviceTypeList();
    }

    @Override
    public DeviceType selectDeviceTypeByTypeNum(String devType) {
        return deviceTypeMapper.selectDeviceTypeByTypeNum(devType);
    }

    @Override
    public Map<String, Integer> selectDevTypeOfflineMap(List<DeviceType> deviceTypeList) {
        Map<String, Integer> deviceTypeOfflineMap = new HashMap<>();
        for (DeviceType deviceType : deviceTypeList
                ) {
            deviceTypeOfflineMap.put(deviceType.getDevType(), deviceType.getDevTypeOffline());
        }
        return deviceTypeOfflineMap;
    }
}
