package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhrj0bp1DM;
import com.system.po.Device.Lhrj0bp1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhrj0bp1Mapper {
    List<Lhrj0bp1DM> selectByORGId(String ORGId);

    List<Lhrj0bp1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhrj0bp1DM selectByDeviceId(String sDeviceId);

    List<Lhrj0bp1DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

    //根据合成时间，查询饮水量
    List<Lhrj0bp1DMHis> selectByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                 @Param("startDate") String sStartTime,
                                                 @Param("endDate") String sEndDate);
}
