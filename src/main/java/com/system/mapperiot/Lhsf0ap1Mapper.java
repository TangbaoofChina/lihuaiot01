package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.Device.Lhsf0ap1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhsf0ap1Mapper {
    List<Lhsf0ap1DM> selectByORGId(String ORGId);

    List<Lhsf0ap1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhsf0ap1DM selectByDeviceId(String sDeviceId);

    List<Lhsf0ap1DMHis> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                @Param("startDate") String sStartTime,
                                                @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                                 @Param("startDate") String sStartDate,
                                                                 @Param("endDate") String sEndDate);
}
