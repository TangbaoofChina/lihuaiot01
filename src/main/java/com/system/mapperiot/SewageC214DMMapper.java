package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SewageC214DMHis;
import com.system.po.Device.SewageC214DM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SewageC214DMMapper {
    List<SewageC214DM> selectSewageC214ByORGId(String ORGId);

    List<SewageC214DM> selectSewageC214ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    SewageC214DM selectSewageC214ByDeviceId(String sDeviceId);

    List<SewageC214DM> selectSewageC214ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                                    @Param("startDate") String sStartTime,
                                                                    @Param("endDate") String sEndDate);
    List<BaseDeviceMessage> selectPhoneHisSewageC214ByDateAndId(@Param("deviceId") String sDeviceId,
                                                                @Param("startDate") String sStartDate,
                                                                @Param("endDate") String sEndDate);
}
