package com.system.mapperiot;

import com.system.po.EC01DeviceMessage;
import com.system.po.SewageC01DeviceMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SewageC01DeviceMessageMapper {
    List<SewageC01DeviceMessage> selectSewageC01ByORGId(String ORGId);
    List<SewageC01DeviceMessage> selectSewageC01ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);
    SewageC01DeviceMessage selectSewageC01ByDeviceId(String sDeviceId);
    List<SewageC01DeviceMessage> selectSewageC01ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                        @Param("startDate") String sStartTime,
                                                        @Param("endDate") String sEndDate);
    List<SewageC01DeviceMessage> selectSewageC01ByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                         @Param("startDate") String sStartTime,
                                                         @Param("endDate") String sEndDate);
}
