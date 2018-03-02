package com.system.mapperiot;

public interface DeviceAlarmMapper {
    /**
     * 查找当前所有的实时报警个数
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCount();
}
