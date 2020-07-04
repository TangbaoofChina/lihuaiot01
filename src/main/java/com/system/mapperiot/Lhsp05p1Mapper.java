package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhsp05p1DM;
import com.system.po.Device.Lhsp05p1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhsp05p1Mapper {
    List<Lhsp05p1DM> selectByORGId(String ORGId);

    List<Lhsp05p1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhsp05p1DM selectByDeviceId(String sDeviceId);

    List<Lhsp05p1DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

    //根据合成时间，查询温度
    List<Lhsp05p1DMHis> selectByDeviceIdsAndDate(@Param("deviceIds")String[] sDeviceIds,
                                                 @Param("startDate") String sStartTime,
                                                 @Param("endDate") String sEndDate);
}
