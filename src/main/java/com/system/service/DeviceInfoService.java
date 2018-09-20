package com.system.service;

import com.system.exception.BootStrapTreeViewException;
import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.RoleInfo;

import java.io.File;
import java.util.List;

public interface DeviceInfoService {

    List<DeviceInfo> selectDeviceInfoByORGId(String orgId) throws Exception;
    List<DeviceInfo> selectDeviceInfoByORGIdAndRoleId(String orgId,List<RoleInfo> roleInfoList) throws Exception;
    List<DeviceInfo> selectDeviceInfoByIDs(String[] sDeviceIds) throws Exception;
    //查询该节点以及下层所有子节点的设备
    List<DeviceInfoAndNode> selectDeviceInfoByOrgIdAll(String orgId) throws Exception;
    //查询该用户角色下所有设备
    List<DeviceInfoAndNode> selectDeviceInfoByRoleIdAll(List<RoleInfo> roleInfoList) throws Exception;
    //查询所有设备
    List<DeviceInfoAndNode> selectAllDeviceAndNodeInfo()throws Exception;
    /**
     * 根据角色ID查找所有相关联的设备信息
     * @return 返回设备信息
     * @throws Exception
     */
    List<DeviceInfo> selectDeviceInfoByRoleId(String roleId) throws Exception;

    /**
     * 更新设备信息，设备名称，组织ID
     * @param sSerialNum
     * @param deviceName
     * @param sOrgId
     * @return
     * @throws Exception
     */
    int updateDeviceOrgId(String sSerialNum,String deviceName,String sOrgId) throws Exception;

    /**
     * 更新 设备名称，设备所在鸡舍ID，设备所在鸡舍名称，设备所在鸡舍组织路径
     * @param deviceId
     * @param deviceName
     * @param deviceEasFId
     * @param deviceEasFName
     * @param deviceEasFDisplayName
     * @throws Exception
     */
    void updateDeviceInfo(String deviceId, String deviceName, String deviceEasFId,String deviceEasFName,String deviceEasFDisplayName) throws Exception;

    /**
     * 批量更新设备组织
     * @param deviceIds
     * @param sOrgId
     * @throws Exception
     */
    void batchUpdateDeviceOrgId(String[] deviceIds,String sOrgId) throws Exception;
    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<DeviceInfo> storageList);
}
