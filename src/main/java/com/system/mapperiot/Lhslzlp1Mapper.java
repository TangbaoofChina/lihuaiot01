package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhslzlp1DM;
import com.system.po.Device.Lhslzlp1DMHis;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Lhslzlp1Mapper {
    List<Lhslzlp1DM> selectByORGId(String ORGId);

    List<Lhslzlp1DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Lhslzlp1DM selectByDeviceId(String sDeviceId);

    List<Lhslzlp1DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

    //根据合成时间，查询历史曲线
    List<Lhslzlp1DMHis> selectByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                 @Param("startDate") String sStartTime,
                                                 @Param("endDate") String sEndDate);
}
