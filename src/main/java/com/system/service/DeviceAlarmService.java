package com.system.service;

public interface DeviceAlarmService {
    /**
     * 读取实时报警数据个数
     * @return 报警个数
     */
    int selectDeviceRealAlarmCount();
}
