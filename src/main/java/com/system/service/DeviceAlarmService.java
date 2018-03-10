package com.system.service;

import com.system.po.RoleInfo;

import java.util.List;

public interface DeviceAlarmService {
    /**
     * 读取实时报警数据个数
     * @return 报警个数
     */
    int selectDeviceRealAlarmCount();

    /**
     * 根据用户权限读取实时报警数据个数
     * @param roleInfoList 用户权限
     * @return 报警个数
     */
    int selectDeviceRealAlarmCountByRoleId(List<RoleInfo> roleInfoList);
}
