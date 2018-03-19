package com.system.mapperiot;

import com.system.po.DeviceAlarmInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmErrorOfflineMapper {
    /**
     * 查询实时报警信息 报警+错误+离线
     * @return
     */
    List<DeviceAlarmInfo> selectDeviceAlarmInfoList();

    /**
     * 根据角色查询实时报警信息 报警+错误+离线
     * @return
     */
    List<DeviceAlarmInfo> selectDeviceAlarmInfoByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 查询历史报警信息 报警+错误+离线
     * @return
     */
    List<DeviceAlarmInfo> selectDeviceHisAlarmInfoList(@Param("sStartDate") String sStartDate,@Param("sEndDate") String sEndDate);

    /**
     * 根据角色查询历史报警信息 报警+错误+离线
     * @return
     */
    List<DeviceAlarmInfo> selectDeviceHisAlarmInfoListByRoleId(@Param("sStartDate") String sStartDate,@Param("sEndDate")  String sEndDate,@Param("roleIds") List<String> roleIds);
}
