package com.system.service.impl;

import com.system.mapperiot.DeviceAlarmMapper;
import com.system.po.RoleInfo;
import com.system.service.DeviceAlarmService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceAlarmServiceImpl implements DeviceAlarmService {
    @Autowired
    private DeviceAlarmMapper deviceAlarmMapper;

    @Override
    public int selectDeviceRealAlarmCount() {
        return deviceAlarmMapper.selectDeviceRealAlarmCount();
    }

    @Override
    public int selectDeviceRealAlarmCountByRoleId(List<RoleInfo> roleInfoList) {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        return deviceAlarmMapper.selectDeviceRealAlarmCountByRoleId(roleIds);
    }
}
