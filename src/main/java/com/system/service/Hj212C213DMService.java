package com.system.service;

import com.system.po.DataTablePageing;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.OneDataDetail;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface Hj212C213DMService {
    /**
     * 获取设备数据-管理员权限
     * @param ORGId 组织ID
     * @return
     * @throws Exception
     */
    List<Hj212C213DeviceMessage> selectHj212C213ByORGId(String ORGId) throws Exception;

    /**
     * 获取设备数据-用户权限
     * @param ORGId 组织ID
     * @param roleInfoList 用户权限内的设备列表
     * @return
     * @throws Exception
     */
    List<Hj212C213DeviceMessage> selectHj212C213ByByORGIdAndRoleId(String ORGId,List<RoleInfo> roleInfoList) throws Exception;

    /**
     * 获取单设备数据
     * @param sDeviceId 设备ID
     * @return
     * @throws Exception
     */
    Hj212C213DeviceMessage selectHj212C213ByDeviceId(String sDeviceId) throws Exception;

    /**
     * 一个设备时间段内的数据;不分页
     * @param sDeviceId
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    List<Hj212C213DeviceMessage> selectHj212C213ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception;

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
    DataTablePageing selectHj212C213ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception;


    /**
     * 污水控制器表头
     * @return
     * @throws Exception
     */
    List<MydataTableColumn> selectHj212C213DeviceHead() throws Exception;

    /**
     * 导出记录
     *
     * @param storageList 保存有信息记录的List
     * @return excel 文件
     */
    File exportStorage(List<Hj212C213DeviceMessage> storageList);

    /*******************曲线部分 Start*******************************************/
    //根据查询参数生成;
    Map<String,List<Hj212C213DeviceMessage>>  selectHisHj212C213ByDateAndIDs(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;
    Map<String,Hj212C213DayData>  selectHisHj212C213ByDateAndIDsTwoParam(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception;
    /*******************曲线部分 End*******************************************/
}
