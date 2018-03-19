package com.system.mapperiot;

import com.system.po.DeviceAlarmInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceErrorMapper {

    /**
     * 查询错误个数
     * @return
     */
    int selectErrorInfoCount();

    /**
     * 根据角色查询错误个数
     * @param roleIds 用户角色
     * @return
     */
    int selectErrorInfoCountByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 查询所有设备错误信息
     * @return 错误信息
     */
    List<DeviceAlarmInfo> selectErrorInfo();

    /**
     * 根据角色查询所有设备错误信息
     * @param roleIds 角色
     * @return 错误信息
     */
    List<DeviceAlarmInfo> selectErrorInfoByRoleId(@Param("roleIds") List<String> roleIds);

    /**
     * 根据日期查询所有设备历史错误信息
     * @return 错误信息
     */
    List<DeviceAlarmInfo> selectHisErrorInfoByDate(@Param("sStartDate") String sStartDate,@Param("sEndDate") String sEndDate);

    /**
     * 根据角色、日期查询所有设备历史错误信息
     * @param roleIds 角色
     * @return 错误信息
     */
    List<DeviceAlarmInfo> selectHisErrorInfoByDateAndRoleId(@Param("sStartDate") String sStartDate,@Param("sEndDate")  String sEndDate,@Param("roleIds") List<String> roleIds);

}
