package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.FeedC411DM;
import com.system.po.FeedC411.FC411HisTemp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedC411DMMapper {
    List<FeedC411DM> selectByORGId(String ORGId);

    List<FeedC411DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    FeedC411DM selectByDeviceId(String sDeviceId);

    List<FeedC411DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                       @Param("startDate") String sStartTime,
                                                       @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                                 @Param("startDate") String sStartDate,
                                                                 @Param("endDate") String sEndDate);

    List<FC411HisTemp> selectTempByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                   @Param("tempName") String sTempName,
                                                   @Param("startDate") String sStartTime,
                                                   @Param("endDate") String sEndDate);
}
