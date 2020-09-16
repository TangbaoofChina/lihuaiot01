package com.system.mapperiot;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SwgC215DM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SwgC215Mapper {
    List<SwgC215DM> selectByORGId(String ORGId);

    List<SwgC215DM> selectByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    SwgC215DM selectByDeviceId(String sDeviceId);

    List<SwgC215DM> selectByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                             @Param("startDate") String sStartTime,
                                             @Param("endDate") String sEndDate);
    //手机端历史数据
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(@Param("deviceId") String sDeviceId,
                                                      @Param("startDate") String sStartDate,
                                                      @Param("endDate") String sEndDate);

}
