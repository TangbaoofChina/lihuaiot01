package com.system.mapperiot;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceAlarmMapper {
    /**
     * 查找当前所有的实时报警个数
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCount();

    /**
     * 根据用户权限查询当前的所有实时报警个数
     * @param roleIds 用户权限
     * @return 实时报警个数
     */
    int selectDeviceRealAlarmCountByRoleId(@Param("roleIds") List<String> roleIds);
}
