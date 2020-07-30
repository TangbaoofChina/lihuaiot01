package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhrz01p1DM;
import com.system.po.Device.Lhrz01p1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhrz01p1Mapper {
    List<Lhrz01p1DM> selectByORGId(String ORGId);

    List<Lhrz01p1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhrz01p1DM selectByDeviceId(String sDeviceId);

    List<Lhrz01p1DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

    //根据合成时间，查询温度
    List<Lhrz01p1DMHis> selectByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                 @Param("startDate") String sStartTime,
                                                 @Param("endDate") String sEndDate);
}
