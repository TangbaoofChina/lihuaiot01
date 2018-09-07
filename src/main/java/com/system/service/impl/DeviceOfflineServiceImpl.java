package com.system.service.impl;

import com.system.mapperiot.DeviceOfflineMapper;
import com.system.po.DeviceAlarmInfo;
import com.system.po.DeviceOfflineRate;
import com.system.po.RoleInfo;
import com.system.service.DeviceOfflineService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceOfflineServiceImpl implements DeviceOfflineService {
    @Autowired
    private DeviceOfflineMapper deviceOfflineMapper;

    @Override
    public List<DeviceOfflineRate> selectHisOfflineTopN(String sStartDate, String sEndDate,int topN) throws Exception {
        return deviceOfflineMapper.selectHisOfflineTopN(sStartDate,sEndDate,topN);
    }

    @Override
    public List<DeviceOfflineRate> selectHisOfflineTopNByRoleId(String sStartDate, String sEndDate,int topN, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        return deviceOfflineMapper.selectHisOfflineTopNByRoleId(sStartDate,sEndDate,topN,roleIds);
    }

    @Override
    public int selectOfflineInfoCount() {
        return deviceOfflineMapper.selectOfflineInfoCount();
    }

    @Override
    public int selectOfflineInfoCountByRoleId(List<RoleInfo> roleInfoList) {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        return deviceOfflineMapper.selectOfflineInfoCountByRoleId(roleIds);
    }
}
