package com.system.service;

import com.system.po.DataTablePageing;
import com.system.po.Device.ScaleC01DeviceMessage;
import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC01DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.RoleInfo;
import com.system.po.ScaleC01.ScaleC01WtAnalysis;
import com.system.po.parameter.OneDataDetail;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ScaleC01DeviceMessageService {

    /**
     * 获取设备数据-管理员权限
     *
     * @param ORGId 组织ID
     * @return
     * @throws Exception
     */
    List<ScaleC01DeviceMessage> selectScaleC01ByORGId(String ORGId) throws Exception;

    /**
     * 获取设备数据-用户权限
     *
     * @param ORGId        组织ID
     * @param roleInfoList 用户权限内的设备列表
     * @return
     * @throws Exception
     */
    List<ScaleC01DeviceMessage> selectScaleC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 获取单设备数据
     *
     * @param sDeviceId 设备ID
     * @return
     * @throws Exception
     */
    ScaleC01DeviceMessage selectScaleC01ByDeviceId(String sDeviceId) throws Exception;

    /**
     * 一个设备时间段内的数据;不分页
     *
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    List<ScaleC01DeviceMessage> selectScaleC01ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception;

    /**
     * 一个设备时间段内的数据-历史数据界面;分页
     *
     * @param pageNumber
     * @param pageSize
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    DataTablePageing selectScaleC01ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception;

    /**
     * 多个设备同一个参数的列表;分页
     *
     * @param pageNumber
     * @param pageSize
     * @param deviceInfoList
     * @param sDeviceIds
     * @param sQueryParam
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    DataTablePageing selectHisScaleC01ByDateAndIDsAndPage(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    /*******************曲线部分 Start*******************************************/
    //根据查询参数生成的列表;分页
    DataTablePageing selectHisScaleC01ByDateAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold, String sStartAge, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    //根据查询参数生成的报表;不分页
    List<List<OneDataDetail>> selectHisScaleC01ByDateAndIDsTableAndThreshold(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sStartAge, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    //根据查询参数生成的曲线 平均体重曲线，增重日龄曲线
    Map<String, List<ScaleC01WtAnalysis>> selectHisScaleC01ByDateAndIDsChartThreshold(String[] sDeviceIds,
                                                                                      String sMaxThreshold,
                                                                                      String sMinThreshold,
                                                                                      String sStartAge,
                                                                                      String sQueryParam,
                                                                                      String sStartDate,
                                                                                      String sEndDate) throws Exception;
    /*******************曲线部分 End*******************************************/

    /**
     * 自动称重设备表头
     *
     * @return
     * @throws Exception
     */
    List<MydataTableColumn> selectScaleC01DeviceHead() throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<ScaleC01DeviceMessage> storageList);

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStoragedynamic(List<MydataTableColumn> mydataTableColumnList, List<List<OneDataDetail>> storageList);

}
