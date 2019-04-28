package com.system.mapperiot;

import com.system.po.Device.SewageC212DMHis;
import com.system.po.Device.SewageC212DeviceMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SewageC212DMMapper {
    List<SewageC212DeviceMessage> selectSewageC212ByORGId(String ORGId);

    List<SewageC212DeviceMessage> selectSewageC212ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    SewageC212DeviceMessage selectSewageC212ByDeviceId(String sDeviceId);

    List<SewageC212DeviceMessage> selectSewageC212ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                                  @Param("startDate") String sStartTime,
                                                                  @Param("endDate") String sEndDate);
    List<SewageC212DMHis> selectPhoneHisSewageC212ByDateAndId(@Param("deviceId") String sDeviceId,
                                                              @Param("startDate") String sStartDate,
                                                              @Param("endDate") String sEndDate);
}
