package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SewageC214DM;
import com.system.po.Device.WeighC312DM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeighC312DMMapper {
    List<WeighC312DM> selectWeighC312ByORGId(String ORGId);

    List<WeighC312DM> selectWeighC312ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    WeighC312DM selectWeighC312ByDeviceId(String sDeviceId);

    List<WeighC312DM> selectWeighC312ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                         @Param("startDate") String sStartTime,
                                                         @Param("endDate") String sEndDate);
    //投料手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisInWeighC312ByDateAndId(@Param("deviceId") String sDeviceId,
                                                                @Param("startDate") String sStartDate,
                                                                @Param("endDate") String sEndDate);
    //放料手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisDeWeighC312ByDateAndId(@Param("deviceId") String sDeviceId,
                                                                 @Param("startDate") String sStartDate,
                                                                 @Param("endDate") String sEndDate);
}
