package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhty02p1DM;
import com.system.po.Device.Lhty02p1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhty02p1Mapper {
    List<Lhty02p1DM> selectByORGId(String ORGId);

    List<Lhty02p1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhty02p1DM selectByDeviceId(String sDeviceId);

    List<Lhty02p1DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

    //根据合成时间，查询温度
    List<Lhty02p1DMHis> selectByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                 @Param("startDate") String sStartTime,
                                                 @Param("endDate") String sEndDate);
}
