package com.system.service.impl;

import com.system.mapperiot.DeviceLongNodeInfoMapper;
import com.system.po.DeviceLongNodeInfo;
import com.system.service.DeviceLongNodeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceLongNodeInfoServiceImpl implements DeviceLongNodeInfoService {
    @Autowired
    private DeviceLongNodeInfoMapper deviceLongNodeInfoMapper;

    @Override
    public void updateDeviceLongNodeInfo(DeviceLongNodeInfo deviceLongNodeInfo) {
        deviceLongNodeInfoMapper.updateDeviceLongNodeInfoByDeviceNum(deviceLongNodeInfo);
    }

    @Override
    public void batchUpdateDeviceLongNodeInfo(String[] deviceNums, String orgId) {
        deviceLongNodeInfoMapper.batchUpdateDeviceLongNodeInfoByDeviceNum(deviceNums, orgId);
    }
}
