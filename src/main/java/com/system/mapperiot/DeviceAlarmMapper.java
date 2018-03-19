package com.system.mapperiot;

import com.system.po.DeviceAlarmInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceAlarmMapper {
    /**
     * 查找当前所有的实时报警个数
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCount();

    /**
     * 根据用户权限查询当前的所有实时报警个数
     * @param roleIds 用户权限
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCountByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 查询所有设备报警信息
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectAlarmInfo();

    /**
     * 根据角色查询所有设备报警信息
     * @param roleIds 角色
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectAlarmInfoByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 根据日期查询所有设备历史报警信息
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectHisAlarmInfoByDate(@Param("sStartDate") String sStartDate,@Param("sEndDate") String sEndDate);

    /**
     * 根据角色、日期查询所有设备历史报警信息
     * @param roleIds 角色
     * @return 报警信息
     */
    List<DeviceAlarmInfo> selectHisAlarmInfoByDateAndRoleId(@Param("sStartDate") String sStartDate,@Param("sEndDate")  String sEndDate,@Param("roleIds") List<String> roleIds);

}
