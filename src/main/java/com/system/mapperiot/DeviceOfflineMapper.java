package com.system.mapperiot;

import com.system.po.DeviceAlarmInfo;
import com.system.po.DeviceOfflineRate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceOfflineMapper {
    /**
     * 查询离线个数
     * @return
     */
    int selectOfflineInfoCount();

    /**
     * 根据角色查询离线个数
     * @param roleIds 用户角色
     * @return
     */
    int selectOfflineInfoCountByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 查询所有设备离线信息
     * @return 设备离线信息
     */
    List<DeviceAlarmInfo> selectOfflineInfo();

    /**
     * 根据角色查询所有设备离线信息
     * @param roleIds 用户角色
     * @return 设备离线信息
     */
    List<DeviceAlarmInfo> selectOfflineInfoByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 根据日期查询所有设备历史离线信息
     * @return 离线信息
     */
    List<DeviceAlarmInfo> selectHisOfflineInfoByDate(@Param("sStartDate") String sStartDate,@Param("sEndDate") String sEndDate);

    /**
     * 根据角色、日期查询所有设备历史离线信息
     * @param roleIds 角色
     * @return 离线信息
     */
    List<DeviceAlarmInfo> selectHisOfflineInfoByDateAndRoleId(@Param("sStartDate") String sStartDate,@Param("sEndDate")  String sEndDate,@Param("roleIds") List<String> roleIds);

    /**
     * 查询所有设备离线频率前N的
     * @param topN 前N个
     * @return
     */
    List<DeviceOfflineRate> selectHisOfflineTopN(@Param("sStartDate") String sStartDate,@Param("sEndDate")  String sEndDate,@Param("topN") int topN);

    /**
     * 根据用户角色，查询设备离线频率前N的
     * @param topN 前N个
     * @param roleIds
     * @return
     */
    List<DeviceOfflineRate> selectHisOfflineTopNByRoleId(@Param("sStartDate") String sStartDate,@Param("sEndDate")  String sEndDate,@Param("topN") int topN,@Param("roleIds") List<String> roleIds);

}
