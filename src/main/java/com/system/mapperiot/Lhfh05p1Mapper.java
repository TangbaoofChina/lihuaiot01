package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;

import com.system.po.Device.Lhfh05p1DM;
import com.system.po.Device.Lhfh05p1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhfh05p1Mapper {
    List<Lhfh05p1DM> selectByORGId(String ORGId);

    List<Lhfh05p1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhfh05p1DM selectByDeviceId(String sDeviceId);

    List<Lhfh05p1DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

    //根据合成时间，查询温度
    List<Lhfh05p1DMHis> selectByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                 @Param("startDate") String sStartTime,
                                                 @Param("endDate") String sEndDate);
}
