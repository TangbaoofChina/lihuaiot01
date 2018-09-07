package com.system.service;

import com.system.po.*;
import org.apache.ibatis.annotations.Param;

import java.io.File;
import java.util.List;

public interface DeviceAlarmService {
    /**
     * 读取实时报警数据个数
     *
     * @return 报警个数
     */
    int selectDeviceRealAlarmCount() throws Exception;

    /**
     * 根据用户权限读取实时报警数据个数
     *
     * @param roleInfoList 用户权限
     * @return 报警个数
     */
    int selectDeviceRealAlarmCountByRoleId(List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 读取实时报警数据
     *
     * @return
     */
    List<DeviceAlarmInfo> selectDeviceAlarmInfo() throws Exception;

    /**
     * 根据用户权限读取实时报警数据
     *
     * @param roleInfoList 用户权限
     * @return 报警数据
     */
    List<DeviceAlarmInfo> selectDeviceAlarmInfoByRoleId(List<RoleInfo> roleInfoList) throws Exception;


    /**
     * 读取历史报警数据-分页
     *
     * @return
     */
    DataTablePageing selectDeviceHisAlarmInfoAndPaging(Integer pageNumber,
                                                       Integer pageSize,
                                                       String alarmType,
                                                       String sStartDate,
                                                       String sEndDate) throws Exception;

    /**
     * 根据用户权限读取历史报警数据-分页
     *
     * @param roleInfoList 用户权限
     * @return 报警数据
     */
    DataTablePageing selectDeviceHisAlarmInfoByRoleIdAndPaging(Integer pageNumber,
                                                               Integer pageSize,
                                                               String alarmType,
                                                               String sStartDate,
                                                               String sEndDate,
                                                               List<RoleInfo> roleInfoList) throws Exception;


    /**
     * 读取历史报警数据-不分页
     *
     * @return
     */
    List<DeviceAlarmInfo> selectDeviceHisAlarmInfo(String alarmType,
                                                   String sStartDate,
                                                   String sEndDate) throws Exception;

    /**
     * 根据用户权限读取历史报警数据-不分页
     *
     * @param roleInfoList 用户权限
     * @return 报警数据
     */
    List<DeviceAlarmInfo> selectDeviceHisAlarmInfoByRoleId(String alarmType,
                                                           String sStartDate,
                                                           String sEndDate,
                                                           List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 查询所有设备报警频率前N的
     *
     * @param topN
     * @return
     * @throws Exception
     */
    List<DeviceAlarmRate> selectHisAlarmTopN(String sStartDate,
                                             String sEndDate, int topN) throws Exception;

    /**
     * 根据用户角色，查询设备报警频率前N的
     *
     * @param topN         前N个
     * @param roleInfoList
     * @return
     */
    List<DeviceAlarmRate> selectHisAlarmTopNByRoleId(String sStartDate,
                                                     String sEndDate, int topN, List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<DeviceAlarmInfo> storageList) throws Exception;

    List<MydataTableColumn> selectDeviceAlarmHead() throws Exception;
}
