package com.system.service.impl;

import com.system.mapperiot.DeviceAlarmMapper;
import com.system.service.DeviceAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceAlarmServiceImpl implements DeviceAlarmService {
    @Autowired
    private DeviceAlarmMapper deviceAlarmMapper;

    @Override
    public int selectDeviceRealAlarmCount() {
        return deviceAlarmMapper.selectDeviceRealAlarmCount();
    }

    @Override
    public int selectDeviceRealAlarmCountByRoleId(String roleId) {
        return deviceAlarmMapper.selectDeviceRealAlarmCountByRoleId(roleId);
    }
}
