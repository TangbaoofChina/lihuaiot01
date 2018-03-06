package com.system.service;

import com.system.po.DeviceInfo;
import com.system.po.DeviceRoleInfo;

import java.util.List;

public interface DeviceRoleInfoService {
    /**
     * 更新角色设备关联表，先删除角色id所有关联设备，再插入新的关联
     * @param deviceRoleInfoList 角色设备关联列表
     */
    void deleteInsertDeviceRole(List<DeviceRoleInfo> deviceRoleInfoList) throws Exception;

    /**
     * 根据角色ID删除所有关联信息
     * @param roleId
     */
    void deleteDeviceRoleByRoleId(String roleId) throws Exception;


}
