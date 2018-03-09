package com.system.service;

import com.system.po.DeviceLongNodeInfo;

public interface DeviceLongNodeInfoService {
    void updateDeviceLongNodeInfo(DeviceLongNodeInfo deviceLongNodeInfo);
    void batchUpdateDeviceLongNodeInfo(String[] deviceNum,String orgId);
}
