package com.system.service;

public interface DeviceAlarmService {
    /**
     * 读取实时报警数据个数
     * @return 报警个数
     */
    int selectDeviceRealAlarmCount();

    /**
     * 根据用户权限读取实时报警数据个数
     * @param roleId 用户权限
     * @return 报警个数
     */
    int selectDeviceRealAlarmCountByRoleId(String roleId);
}
