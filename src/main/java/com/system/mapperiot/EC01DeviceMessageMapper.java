package com.system.mapperiot;

import com.system.po.EC01DeviceMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EC01DeviceMessageMapper {
    List<EC01DeviceMessage> selectEC01ByORGId(String ORGId);
    List<EC01DeviceMessage> selectEC01ByORGIdAndRoleId(@Param("orgId") String orgId,@Param("roleIds") List<String> roleIds);
    EC01DeviceMessage selectEC01ByDeviceId(String sDeviceId);
    List<EC01DeviceMessage> selectEC01ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                        @Param("startDate") String sStartTime,
                                                        @Param("endDate") String sEndDate);
    List<EC01DeviceMessage> selectEC01ByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                        @Param("startDate") String sStartTime,
                                                        @Param("endDate") String sEndDate);
}
