package com.system.mapperiot;

import com.system.po.parameter.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    void insertDeviceType(DeviceType deviceType);
    List<DeviceType> selectDeviceTypeList();
    DeviceType selectDeviceTypeByTypeNum(String devType);
}
