package com.system.service;

import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;

import com.system.po.Device.Lhfh05p1DM;
import com.system.po.Device.Lhfh05p1DMHis;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 食品公司GPS测温
 */
public interface Lhfh05p1DMService {
    /**
     * 获取设备数据-管理员权限
     * @param ORGId 组织ID
     * @return
     * @throws Exception
     */
    List<Lhfh05p1DM> selectByORGId(String ORGId) throws Exception;

    /**
     * 获取设备数据-用户权限
     * @param ORGId 组织ID
     * @param roleInfoList 用户权限内的设备列表
     * @return
     * @throws Exception
     */
    List<Lhfh05p1DM> selectByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 获取单设备数据
     * @param sDeviceId 设备ID
     * @return
     * @throws Exception
     */
    Lhfh05p1DM selectByDeviceId(String sDeviceId) throws Exception;

    /**
     * 一个设备时间段内的数据;不分页
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    List<Lhfh05p1DM> selectByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception;

    /**
     * 手机端查询历史数据
     * @param sDeviceId 设备ID
     * @param sStartDate 起始时间
     * @param sEndDate 截止时间
     * @return
     * @throws Exception
     */
    List<BaseDeviceMessage> selectPhoneHisByDateAndId(String sDeviceId, String type, String sStartDate, String sEndDate) throws Exception;

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
    DataTablePageing selectByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception;


    /**
     * 列表表头 存在多个表头
     * @return
     * @throws Exception
     */
    List<MydataTableColumn> selectDeviceHead() throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<Lhfh05p1DM> storageList);

    /*******************曲线部分 Start*******************************************/
    //根据查询参数生成;
    Map<String,List<Lhfh05p1DMHis>> selectHisByDateAndIDs(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;
    /*******************曲线部分 End*******************************************/
}
