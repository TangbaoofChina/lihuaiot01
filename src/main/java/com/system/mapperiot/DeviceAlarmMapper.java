package com.system.mapperiot;

import com.system.po.DeviceAlarmInfo;
import com.system.po.DeviceAlarmRate;
import com.system.service.DeviceAlarmService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceAlarmMapper {
    /**
     * 查找当前所有的实时报警个数
     *
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCount();

    /**
     * 根据用户权限查询当前的所有实时报警个数
     *
     * @param roleIds 用户权限
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCountByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 查询所有设备报警信息
     *
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectAlarmInfo();

    /**
     * 根据角色查询所有设备报警信息
     *
     * @param roleIds 角色
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectAlarmInfoByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 根据日期查询所有设备历史报警信息
     *
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectHisAlarmInfoByDate(@Param("sStartDate") String sStartDate, @Param("sEndDate") String sEndDate);

    /**
     * 根据角色、日期查询所有设备历史报警信息
     *
     * @param roleIds 角色
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectHisAlarmInfoByDateAndRoleId(@Param("sStartDate") String sStartDate, @Param("sEndDate") String sEndDate, @Param("roleIds") List<String> roleIds);

    /**
     * 查询所有设备报警频率前N的
     *
     * @param topN 前N个
     * @return
     */
    List<DeviceAlarmRate> selectHisAlarmTopN(@Param("sStartDate") String sStartDate, @Param("sEndDate") String sEndDate, @Param("topN") int topN);

    /**
     * 根据用户角色，查询设备报警频率前N的
     *
     * @param topN    前N个
     * @param roleIds
     * @return
     */
    List<DeviceAlarmRate> selectHisAlarmTopNByRoleId(@Param("sStartDate") String sStartDate, @Param("sEndDate") String sEndDate, @Param("topN") int topN, @Param("roleIds") List<String> roleIds);
}
