package com.system.service;

import com.system.po.DeviceAlarmInfo;
import com.system.po.DeviceOfflineRate;
import com.system.po.RoleInfo;

import java.util.List;

public interface DeviceOfflineService {
    /**
     * 查询所有设备离线频率前N的
     * @param topN
     * @return
     * @throws Exception
     */
    List<DeviceOfflineRate> selectHisOfflineTopN(String sStartDate,
                                                 String sEndDate,int topN) throws Exception;

    /**
     * 根据用户角色，查询设备离线频率前N的
     * @param topN 前N个
     * @param roleInfoList
     * @return
     */
    List<DeviceOfflineRate> selectHisOfflineTopNByRoleId(String sStartDate,
                                                         String sEndDate,int topN,List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 查询离线个数
     * @return
     */
    int selectOfflineInfoCount();

    /**
     * 根据角色查询离线个数
     * @param roleInfoList 用户角色
     * @return
     */
    int selectOfflineInfoCountByRoleId(List<RoleInfo> roleInfoList);
}
