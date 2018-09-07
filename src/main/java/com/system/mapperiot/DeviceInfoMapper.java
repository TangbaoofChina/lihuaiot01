package com.system.mapperiot;

import com.system.po.BootStrapTreeNode;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.ORGTreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceInfoMapper {
    List<ORGTreeNode> selectDeviceInfo();
    List<ORGTreeNode> selectDeviceByOrgId(String orgId);
    List<BootStrapTreeNode> selectBstDeviceByOrgId(String orgId);
    List<DeviceInfo> selectDeviceByORGId(String orgId);
    List<DeviceInfo> selectDeviceByORGIdAndRoleId(@Param("orgId") String orgId,@Param("roleIds") List<String> roleIds);
    List<DeviceInfoAndNode> selectDeviceAndNodeByORGId(String orgId);
    List<DeviceInfoAndNode> selectDeviceAndNodeByRoleId(@Param("roleIds") List<String> roleIds);
    List<DeviceInfo> selectDeviceInfoByIDs(@Param("deviceIds") String[] deviceIds);
    List<DeviceInfo> selectDeviceInfoByRoleId(String roleId);
    List<DeviceInfoAndNode> selectAllDeviceAndNodeInfo();
    DeviceInfo selectDeviceInfoByID(String deviceId);
    Integer updateDeviceOrgId(@Param("sSerialNum")String sSerialNum,@Param("sDeviceName")String deviceName,@Param("sOrgId")String sOrgId);
    void batchUpdateDeviceOrgId(@Param("deviceIds")String[] deviceIds,@Param("sOrgId")String sOrgId);

}
