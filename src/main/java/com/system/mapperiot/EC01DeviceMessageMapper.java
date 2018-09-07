package com.system.mapperiot;

import com.system.po.Device.EC01DeviceMessage;
import com.system.po.EC01.EC01DayAvgTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EC01DeviceMessageMapper {
    List<EC01DeviceMessage> selectEC01ByORGId(String ORGId);

    List<EC01DeviceMessage> selectEC01ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    EC01DeviceMessage selectEC01ByDeviceId(String sDeviceId);

    List<EC01DeviceMessage> selectEC01ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                        @Param("startDate") String sStartTime,
                                                        @Param("endDate") String sEndDate);

    List<EC01DeviceMessage> selectEC01ByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                         @Param("startDate") String sStartTime,
                                                         @Param("endDate") String sEndDate);

    List<EC01DeviceMessage> selectEC01WaterByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                              @Param("startDate") String sStartTime,
                                                              @Param("endDate") String sEndDate);

    List<EC01DayAvgTemp> selectEC01DayAvgTempByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                               @Param("startDate") String sStartTime,
                                                               @Param("endDate") String sEndDate);

    List<EC01DeviceMessage> selectEC01ByDeviceIdsAndDtl(@Param("deviceIds") String[] sDeviceIds,
                                                             @Param("dateTimeList") String[] sDateTimeList);

    List<EC01DeviceMessage> selectEC01ByDeviceIdAndDt(@Param("deviceId") String sDeviceId,
                                                        @Param("dateTime") String sDateTime);

}
