package com.system.mapperiot;

import com.system.po.Device.ScaleC01DeviceMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScaleC01DeviceMessageMapper {
    List<ScaleC01DeviceMessage> selectScaleC01ByORGId(String ORGId);

    List<ScaleC01DeviceMessage> selectScaleC01ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    ScaleC01DeviceMessage selectScaleC01ByDeviceId(String sDeviceId);

    List<ScaleC01DeviceMessage> selectScaleC01ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                                  @Param("startDate") String sStartTime,
                                                                  @Param("endDate") String sEndDate);

    List<ScaleC01DeviceMessage> selectScaleC01ByDeviceIdsAndDate(@Param("deviceIds") String[] sDeviceIds,
                                                                   @Param("startDate") String sStartTime,
                                                                   @Param("endDate") String sEndDate);

}
