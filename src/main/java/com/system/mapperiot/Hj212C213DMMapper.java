package com.system.mapperiot;

import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.Device.SewageC212DeviceMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Hj212C213DMMapper {
    List<Hj212C213DeviceMessage> selectHj212C213ByORGId(String ORGId);

    List<Hj212C213DeviceMessage> selectHj212C213ByORGIdAndRoleId(@Param("orgId") String orgId, @Param("roleIds") List<String> roleIds);

    Hj212C213DeviceMessage selectHj212C213ByDeviceId(String sDeviceId);

    List<Hj212C213DeviceMessage> selectHj212C213ByDeviceIdAndDate(@Param("deviceId") String sDeviceId,
                                                                    @Param("startDate") String sStartTime,
                                                                    @Param("endDate") String sEndDate);

    //根据合成时间，查询流量和PH值
    List<Hj212C213DeviceMessage> selectHj212C213ByDeviceIdsAndDateTime(@Param("deviceIds")String[] sDeviceIds,
                                                                   @Param("startDate") String sStartTime,
                                                                   @Param("endDate") String sEndDate);

    //根据COD采样时间，查询COD值
    List<Hj212C213DeviceMessage> selectHj212C213ByDeviceIdsAndCODSampleTime(@Param("deviceIds")String[] sDeviceIds,
                                                                       @Param("startDate") String sStartTime,
                                                                       @Param("endDate") String sEndDate);

    //根据氨氮采样时间，查询氨氮值
    List<Hj212C213DeviceMessage> selectHj212C213ByDeviceIdsAndNH3NSampleTime(@Param("deviceIds")String[] sDeviceIds,
                                                                            @Param("startDate") String sStartTime,
                                                                            @Param("endDate") String sEndDate);

    //根据总磷采样时间，查询总磷值
    List<Hj212C213DeviceMessage> selectHj212C213ByDeviceIdsAndTPSampleTime(@Param("deviceIds")String[]sDeviceIds,
                                                                             @Param("startDate") String sStartTime,
                                                                             @Param("endDate") String sEndDate);

    //根据总氮采样时间，查询总氮值
    List<Hj212C213DeviceMessage> selectHj212C213ByDeviceIdsAndTNSampleTime(@Param("deviceIds")String[]sDeviceIds,
                                                                           @Param("startDate") String sStartTime,
                                                                           @Param("endDate") String sEndDate);
}
