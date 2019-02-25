package com.system.service;

import com.system.po.DataTablePageing;
import com.system.po.Device.SewageC212DeviceMessage;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;

import java.io.File;
import java.util.List;

public interface SewageC212DMService {
    /**
     * 获取设备数据-管理员权限
     * @param ORGId 组织ID
     * @return
     * @throws Exception
     */
    List<SewageC212DeviceMessage> selectSewageC212ByORGId(String ORGId) throws Exception;

    /**
     * 获取设备数据-用户权限
     * @param ORGId 组织ID
     * @param roleInfoList 用户权限内的设备列表
     * @return
     * @throws Exception
     */
    List<SewageC212DeviceMessage> selectSewageC212ByByORGIdAndRoleId(String ORGId,List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 获取单设备数据
     * @param sDeviceId 设备ID
     * @return
     * @throws Exception
     */
    SewageC212DeviceMessage selectSewageC212ByDeviceId(String sDeviceId) throws Exception;

    /**
     * 一个设备时间段内的数据;不分页
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    List<SewageC212DeviceMessage> selectSewageC212ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception;

    /**
     * 一个设备时间段内的数据;分页
     * @param pageNumber
     * @param pageSize
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    DataTablePageing selectSewageC212ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception;


    /**
     * 污水控制器表头
     * @return
     * @throws Exception
     */
    List<MydataTableColumn> selectSewageC212DeviceHead() throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<SewageC212DeviceMessage> storageList);
}
