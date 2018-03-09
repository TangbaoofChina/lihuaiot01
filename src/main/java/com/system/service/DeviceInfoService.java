package com.system.service;

import com.system.exception.BootStrapTreeViewException;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;

import java.io.File;
import java.util.List;

public interface DeviceInfoService {

    List<DeviceInfo> selectDeviceInfoByORGId(String orgId) throws Exception;
    List<DeviceInfo> selectDeviceInfoByORGIdAndRoleId(String orgId,String roleId) throws Exception;
    List<DeviceInfo> selectDeviceInfoByIDs(String[] sDeviceIds) throws Exception;
    //查询该节点以及下层所有子节点的设备
    List<DeviceInfoAndNode> selectDeviceInfoByOrgIdAll(String orgId) throws Exception;
    //查询该用户角色下所有设备
    List<DeviceInfoAndNode> selectDeviceInfoByRoleIdAll(String roleId) throws Exception;
    /**
     * 根据角色ID查找所有相关联的设备信息
     * @return 返回设备信息
     * @throws Exception
     */
    List<DeviceInfo> selectDeviceInfoByRoleId(String roleId) throws Exception;

    int updateDeviceOrgId(String sSerialNum,String deviceName,String sOrgId) throws Exception;
    void batchUpdateDeviceOrgId(String[] deviceIds,String sOrgId) throws Exception;
    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<DeviceInfo> storageList);
}
