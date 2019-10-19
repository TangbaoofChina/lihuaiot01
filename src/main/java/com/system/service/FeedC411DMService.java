package com.system.service;

import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.FeedC411DM;
import com.system.po.FeedC411.FC411HisTemp;
import com.system.po.FeedC411.FC411TempNameRelation;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;

import java.io.File;
import java.util.List;

public interface FeedC411DMService {
    /**
     * 获取设备数据-管理员权限
     * @param ORGId 组织ID
     * @return
     * @throws Exception
     */
    List<FeedC411DM> selectByORGId(String ORGId) throws Exception;

    /**
     * 获取设备数据-用户权限
     * @param ORGId 组织ID
     * @param roleInfoList 用户权限内的设备列表
     * @return
     * @throws Exception
     */
    List<FeedC411DM> selectByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 获取单设备数据
     * @param sDeviceId 设备ID
     * @return
     * @throws Exception
     */
    FeedC411DM selectByDeviceId(String sDeviceId) throws Exception;

    /**
     * 一个设备时间段内的数据;不分页
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    List<FeedC411DM> selectByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception;

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
    List<MydataTableColumn> selectDeviceHead(String devId) throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<FeedC411DM> storageList);

    /**
     * 为历史曲线服务，需要知道查询哪些温度点的曲线，合成温度点LIST
     * @param devId
     * @return
     */
    List<FC411TempNameRelation> selectParamsById(String devId);

    /**
     * 某一个设备的温度点的历史数据
     * @param sDeviceId
     * @param sTempName
     * @param sStartTime
     * @param sEndDate
     * @return
     */
    List<FC411HisTemp> selectTempByDeviceIdAndDate(String sDeviceId,
                                                   String sTempName,
                                                   String sStartTime,
                                                   String sEndDate);
}
