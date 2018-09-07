package com.system.service;

import com.system.po.*;
import com.system.po.Device.EC01DeviceMessage;
import com.system.po.parameter.OneDataDetail;
import com.system.po.parameter.ParameterCharts;

import java.io.File;
import java.util.List;

public interface EC01DeviceMessageService {
    List<EC01DeviceMessage> selectEC01ByORGId(String ORGId) throws Exception;

    List<EC01DeviceMessage> selectEC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception;

    EC01DeviceMessage selectEC01ByDeviceId(String sDeviceId) throws Exception;

    //历史数据查询
    List<EC01DeviceMessage> selectEC01ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception;

    List<MydataTableColumn> selectEC01DeviceHead() throws Exception;

    DataTablePageing selectEC01ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception;

    //多个设备同一个参数的曲线
    ParameterCharts selectHisEC01ByDateAndIDsChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    //多个设备同一个参数的列表
    List<List<OneDataDetail>> selectHisEC01ByDateAndIDsTable(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    //多个设备同一个参数的列表;分页
    DataTablePageing selectHisEC01ByDateAndIDsAndPage(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<EC01DeviceMessage> storageList);

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStoragedynamic(List<MydataTableColumn> mydataTableColumnList, List<List<OneDataDetail>> storageList);

    /********************************************************/
    //多个设备同一个参数的曲线，带阈值
    ParameterCharts selectHisEC01ByDateAndIDsChartThreshold(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    //多个设备同一个参数的列表;分页
    DataTablePageing selectHisEC01ByDateAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;

    //多个设备同一个参数的列表
    List<List<OneDataDetail>> selectHisEC01ByDateAndIDsTableAndThreshold(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String sStartDate, String sEndDate) throws Exception;


    /***********************************************************/
    //一个设备，一个参数，不同日期
    ParameterCharts selectHisEC01ByDtlAndId(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String[] sDateTimeList);

    //一个设备，一个参数，不同日期报表,分页，带阈值
    DataTablePageing selectHisEC01ByDtlAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize,List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold,String[] sDeviceIds,String sQueryParam, String[] sDateTimeList) throws Exception;

    //一个设备，一个参数，不同日期报表，带阈值
    List<List<OneDataDetail>> selectHisEC01TbByDtlAndIDsAndThreshold(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam,  String[] sDateTimeList) throws Exception;

}
