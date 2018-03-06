package com.system.mapperiot;

import com.system.po.DeviceInfo;
import com.system.po.DeviceRoleInfo;
import com.system.po.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceRoleInfoMapper {

    void deleteDeviceRoleInfoByRoleId(String roleId);
    void insertDeviceRoleInfo(@Param("deviceRoleInfoList") List<DeviceRoleInfo> deviceRoleInfoList);
}
