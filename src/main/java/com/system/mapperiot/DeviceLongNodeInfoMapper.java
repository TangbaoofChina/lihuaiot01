package com.system.mapperiot;

import com.system.po.DeviceLongNodeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceLongNodeInfoMapper {
    List<DeviceLongNodeInfo> selectDeviceLongNodeInfoByDeviceNum(String deviceNum);
    void insertDeviceLongNodeInfo(@Param("deviceLongNodeInfo") DeviceLongNodeInfo deviceLongNodeInfo);
    void updateDeviceLongNodeInfoByDeviceNum(@Param("deviceLongNodeInfo") DeviceLongNodeInfo deviceLongNodeInfo);
    void batchUpdateDeviceLongNodeInfoByDeviceNum(@Param("deviceNums")String[] deviceNums,@Param("sOrgId")String sOrgId);
}
