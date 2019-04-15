package com.system.service.impl;

import com.system.mapperiot.DeviceTypeMapper;
import com.system.mapperiot.ORGTreeNodeMapper;
import com.system.po.DeviceCfgInfo;
import com.system.po.ORGTreeNode;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.util.EJConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    @Autowired
    private DeviceTypeMapper deviceTypeMapper;
    @Autowired
    private ORGTreeNodeMapper orgTreeNodeMapper;
    @Autowired
    private EJConvertor ejConvertor;

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

    @Override
    public List<DeviceCfgInfo> selectDeviceListByType(String devType){
        List<DeviceCfgInfo> deviceCfgInfoList = deviceTypeMapper.selectDeviceListByType(devType);
        List<ORGTreeNode>  orgTreeNodeList = orgTreeNodeMapper.selectORGInfo();
        for (DeviceCfgInfo dCI:deviceCfgInfoList
             ) {
            dCI.findUrl(orgTreeNodeList);
        }
        return deviceCfgInfoList;
    }

    @Override
    public File exportStorage(List<DeviceCfgInfo> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(DeviceCfgInfo.class, storageList);
    }
}
