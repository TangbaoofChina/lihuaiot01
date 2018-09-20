package com.system.service;

import com.system.po.parameter.DeviceType;

import java.util.List;
import java.util.Map;

public interface DeviceTypeService {
    void insertDeviceType(DeviceType deviceType);

    List<DeviceType> selectDeviceTypeList();

    DeviceType selectDeviceTypeByTypeNum(String devType);

    Map<String,Integer> selectDevTypeOfflineMap(List<DeviceType> deviceTypeList);
}
