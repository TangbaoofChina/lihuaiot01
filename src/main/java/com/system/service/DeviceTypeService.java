package com.system.service;

import com.system.po.DeviceCfgInfo;
import com.system.po.parameter.DeviceType;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface DeviceTypeService {
    void insertDeviceType(DeviceType deviceType);

    List<DeviceType> selectDeviceTypeList();

    DeviceType selectDeviceTypeByTypeNum(String devType);

    Map<String,Integer> selectDevTypeOfflineMap(List<DeviceType> deviceTypeList);

    /**
     * 根据设备型号，查找设备清单
     * @param devType
     * @return
     */
    List<DeviceCfgInfo> selectDeviceListByType(String devType);

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<DeviceCfgInfo> storageList);
}
