package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.system.mapperiot.DeviceInfoMapper;
import com.system.mapperiot.EC01DeviceMessageMapper;
import com.system.po.*;
import com.system.po.Device.EC01DeviceMessage;
import com.system.po.EC01.EC01DayAvgTemp;
import com.system.po.EC01.EC01DeviceDayAvgTemp;
import com.system.po.EC01.EC01DeviceDayWater;
import com.system.po.EChartsOptions.EChartsYAxis;
import com.system.po.parameter.*;
import com.system.service.DeviceTypeService;
import com.system.service.EC01DeviceMessageService;
import com.system.util.EC01Util;
import com.system.util.EJConvertor;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EC01DeviceMessageServiceImpl implements EC01DeviceMessageService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Autowired
    private DeviceTypeService deviceTypeService;
    @Autowired
    private EC01DeviceMessageMapper ec01DeviceMessageMapper;
    @Autowired
    private EJConvertor ejConvertor;

    @Override
    public List<EC01DeviceMessage> selectEC01ByORGId(String ORGId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = ec01DeviceMessageMapper.selectEC01ByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("111");
        ec01DeviceMessageList = judgeDeviceOnlineState(ec01DeviceMessageList, deviceType.getDevTypeOffline());
        return ec01DeviceMessageList;
    }

    @Override
    public List<EC01DeviceMessage> selectEC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<EC01DeviceMessage> ec01DeviceMessageList = ec01DeviceMessageMapper.selectEC01ByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("111");
        ec01DeviceMessageList = judgeDeviceOnlineState(ec01DeviceMessageList, deviceType.getDevTypeOffline());
        return ec01DeviceMessageList;
    }

    @Override
    public EC01DeviceMessage selectEC01ByDeviceId(String sDeviceId) throws Exception {
        EC01DeviceMessage ec01DeviceMessage = ec01DeviceMessageMapper.selectEC01ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("111");
        judgeOneDeviceOnlineState(ec01DeviceMessage, deviceType.getDevTypeOffline());
        return ec01DeviceMessage;
    }

    @Override
    public List<EC01DeviceMessage> selectEC01ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return ec01DeviceMessageMapper.selectEC01ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public List<MydataTableColumn> selectEC01DeviceHead() throws Exception {
        EC01DeviceMessage ec01DeviceMessage = new EC01DeviceMessage();
        List<MydataTableColumn> mydataTableColumnList = ec01DeviceMessage.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<EC01DeviceMessage> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(EC01DeviceMessage.class, storageList);
    }

    @Override
    public File exportStoragedynamic(List<MydataTableColumn> mydataTableColumnList, List<List<OneDataDetail>> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriterdynamic(EC01DeviceMessage.class, mydataTableColumnList, storageList);
    }

    @Override
    public DataTablePageing selectEC01ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<EC01DeviceMessage> ec01DeviceMessageListAll = ec01DeviceMessageMapper.selectEC01ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
        if (ec01DeviceMessageListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > ec01DeviceMessageListAll.size())
                bigIndex = ec01DeviceMessageListAll.size();
            ec01DeviceMessageList.addAll(ec01DeviceMessageListAll.subList(smallIndex, bigIndex));
        }
        String sReturnJson = JSON.toJSONString(ec01DeviceMessageList);
        dataTablePageing.setTotal(ec01DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    /**
     * 查询多个设备历史数据-曲线格式-20180907废弃不用
     *
     * @param sDeviceIds  设备ID 数组
     * @param sQueryParam 设备参数
     * @param sStartDate  起始时间
     * @param sEndDate    截止时间
     * @return 曲线历史数据
     * @throws Exception
     */
    @Override
    public ParameterCharts selectHisEC01ByDateAndIDsChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        List<EC01DeviceMessage> deviceMessageList = new ArrayList<>();
        if (sQueryParam.equals("日饮水量")) {
            sStartDate = sStartDate.substring(0, 10);
            sEndDate = sEndDate.substring(0, 10);
            deviceMessageList = ec01DeviceMessageMapper.selectEC01WaterByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
        } else {
            deviceMessageList = ec01DeviceMessageMapper.selectEC01ByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
        }
        ParameterCharts returnParamChats = getParameterChartsByDeviceMessageList(deviceMessageList, sDeviceIds, sQueryParam);
        return returnParamChats;
    }

    /**
     * 查询多个设备历史数据-曲线格式 带阈值
     *
     * @param sDeviceIds    设备IDs
     * @param sMaxThreshold 最大阈值
     * @param sMinThreshold 最小阈值
     * @param sQueryParam   查询参数
     * @param sStartDate    起始时间
     * @param sEndDate      截止时间
     * @return
     * @throws Exception
     */
    @Override
    public ParameterCharts selectHisEC01ByDateAndIDsChartThreshold(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        List<EC01DeviceMessage> deviceMessageList = new ArrayList<>();
        ParameterCharts returnParamChats = null;
        if (sQueryParam.equals("日饮水量")) {
            sStartDate = sStartDate.substring(0, 10);
            sEndDate = sEndDate.substring(0, 10);
            deviceMessageList = ec01DeviceMessageMapper.selectEC01WaterByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
            returnParamChats = getDayWaterByDeviceMessageListThreshold(deviceMessageList, sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam);
        } else if (sQueryParam.equals("日温饮水")) {
            sStartDate = sStartDate.substring(0, 10);
            sEndDate = sEndDate.substring(0, 10);
            List<EC01DayAvgTemp> ec01DayAvgTempList = ec01DeviceMessageMapper.selectEC01DayAvgTempByDeviceIdAndDate(sDeviceIds[0], sStartDate, sEndDate);
            DeviceInfo deviceInfo = deviceInfoMapper.selectDeviceInfoByID(sDeviceIds[0]);
            if (ec01DayAvgTempList.size() > 0) {
                EC01DeviceDayAvgTemp ec01DeviceDayAvgTemp = new EC01DeviceDayAvgTemp(deviceInfo, ec01DayAvgTempList);
                deviceMessageList = ec01DeviceMessageMapper.selectEC01WaterByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
                returnParamChats = getTempWaterChartsByDeviceMessageList(deviceMessageList, sMaxThreshold, sMinThreshold, ec01DeviceDayAvgTemp, sDeviceIds, sQueryParam);
            }
        } else if (sQueryParam.equals("多舍日饮水量")) {
            sStartDate = sStartDate.substring(0, 10);
            sEndDate = sEndDate.substring(0, 10);
            deviceMessageList = ec01DeviceMessageMapper.selectEC01WaterByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
            if (deviceMessageList.size() > 0) {
                returnParamChats = getMuitiDeviceWaterChartsByDml(deviceMessageList, sMaxThreshold, sMinThreshold, sDeviceIds, sQueryParam);
            }
        } else {
            deviceMessageList = ec01DeviceMessageMapper.selectEC01ByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
            returnParamChats = getParameterChartsByDeviceMessageList(deviceMessageList, sDeviceIds, sQueryParam);
        }
        return returnParamChats;
    }

    /**
     * 查询多个设备历史数据-报表格式-20180907废弃不用
     *
     * @param deviceInfoList 设备信息List
     * @param sDeviceIds     设备ID数组
     * @param sQueryParam    设备参数
     * @param sStartDate     起始时间
     * @param sEndDate       截止时间
     * @return 报表历史数据
     * @throws Exception
     */
    @Override
    public List<List<OneDataDetail>> selectHisEC01ByDateAndIDsTable(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        List<List<OneDataDetail>> dataDetailList = null;
        ParameterCharts parameterCharts = this.selectHisEC01ByDateAndIDsChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (parameterCharts != null) {
            dataDetailList = getDataDetailListByParam(sQueryParam, deviceInfoList, parameterCharts, null);
        }
        //List<List<OneDataDetail>> dataDetailList = getDataDetailList(deviceInfoList,parameterCharts);
        //String sReturnJson = formatDataDetailsToJson(dataDetailList);
        //return dataDetailList;
        return dataDetailList;
    }

    /**
     * 查询多个设备历史数据-报表格式;分页-20180907废弃不用
     *
     * @param pageNumber     分页码
     * @param pageSize       页数据长度
     * @param deviceInfoList 设备信息List
     * @param sDeviceIds     设备ID数组
     * @param sQueryParam    设备参数
     * @param sStartDate     起始时间
     * @param sEndDate       截止时间
     * @return 报表历史数据;分页
     * @throws Exception
     */
    @Override
    public DataTablePageing selectHisEC01ByDateAndIDsAndPage(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        DataTablePageing dataTablePageing = new DataTablePageing();
        ParameterCharts parameterCharts = this.selectHisEC01ByDateAndIDsChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (parameterCharts == null) {
            return dataTablePageing;
        }
        List<List<OneDataDetail>> dataDetailList = getDataDetailListByParam(sQueryParam, deviceInfoList, parameterCharts, null);
        dataTablePageing = getDataTableAndPageing(pageNumber, pageSize, dataDetailList);
        return dataTablePageing;
    }

    /**
     * 查询多个设备历史数据-报表格式;分页 含阈值
     *
     * @param pageNumber
     * @param pageSize
     * @param deviceInfoList
     * @param sMaxThreshold
     * @param sMinThreshold
     * @param sDeviceIds
     * @param sQueryParam
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    @Override
    public DataTablePageing selectHisEC01ByDateAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        DataTablePageing dataTablePageing = new DataTablePageing();
        ParameterCharts parameterCharts = this.selectHisEC01ByDateAndIDsChartThreshold(sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sStartDate, sEndDate);
        if (parameterCharts == null) {
            return dataTablePageing;
        }
        List<List<OneDataDetail>> dataDetailList = getDataDetailListByParam(sQueryParam, deviceInfoList, parameterCharts, null);
        dataTablePageing = getDataTableAndPageing(pageNumber, pageSize, dataDetailList);
        return dataTablePageing;
    }

    /**
     * 查询多个设备历史数据-报表格式；不分页 带阈值
     *
     * @param deviceInfoList
     * @param sDeviceIds
     * @param sMaxThreshold
     * @param sMinThreshold
     * @param sQueryParam
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    @Override
    public List<List<OneDataDetail>> selectHisEC01ByDateAndIDsTableAndThreshold(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        List<List<OneDataDetail>> dataDetailList = null;
        ParameterCharts parameterCharts = this.selectHisEC01ByDateAndIDsChartThreshold(sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sStartDate, sEndDate);
        if (parameterCharts != null) {
            dataDetailList = getDataDetailListByParam(sQueryParam, deviceInfoList, parameterCharts, null);
        }
        //List<List<OneDataDetail>> dataDetailList = getDataDetailList(deviceInfoList,parameterCharts);
        //String sReturnJson = formatDataDetailsToJson(dataDetailList);
        //return dataDetailList;
        return dataDetailList;
    }

    /**
     * 查询单设备，多个日期的数据，生成报表；单舍温度，单舍饮水量 含阈值
     *
     * @param deviceInfoList
     * @param sDeviceIds
     * @param sMaxThreshold
     * @param sMinThreshold
     * @param sQueryParam
     * @param sDateTimeList
     * @return
     * @throws Exception
     */
    @Override
    public List<List<OneDataDetail>> selectHisEC01TbByDtlAndIDsAndThreshold(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String[] sDateTimeList) throws Exception {
        List<List<OneDataDetail>> dataDetailList = null;
        ParameterCharts parameterCharts = this.selectHisEC01ByDtlAndId(sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sDateTimeList);
        if (parameterCharts != null) {
            dataDetailList = getDataDetailListByParam(sQueryParam, deviceInfoList, parameterCharts, sDateTimeList);
        }
        return dataDetailList;
    }

    /**
     * 一个设备，一个参数，多个日期 单舍饮水量/单舍温度
     *
     * @param sDeviceIds
     * @param sMaxThreshold
     * @param sMinThreshold
     * @param sQueryParam
     * @param sDateTimeList
     * @return
     */
    @Override
    public ParameterCharts selectHisEC01ByDtlAndId(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String[] sDateTimeList) {
        Map<String, List<EC01DeviceMessage>> deviceMsgListMap = new HashMap<>();
        for (String dateTime : sDateTimeList
                ) {
            List<EC01DeviceMessage> deviceMessageList = ec01DeviceMessageMapper.selectEC01ByDeviceIdAndDt(sDeviceIds[0], dateTime);
            if (deviceMessageList.size() > 0) {
                judgeWaterThreshold(deviceMessageList, sMaxThreshold, sMinThreshold);
                deviceMsgListMap.put(dateTime, deviceMessageList);
            }
        }
        if (deviceMsgListMap.size() > 0) {
            ParameterCharts parameterCharts = this.getOneDeviceDataSplitByDateTime(deviceMsgListMap, sQueryParam);
            return parameterCharts;
        } else return null;
    }

    @Override
    public DataTablePageing selectHisEC01ByDtlAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold, String[] sDeviceIds, String sQueryParam, String[] sDateTimeList) throws Exception {

        ParameterCharts parameterCharts = selectHisEC01ByDtlAndId(sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sDateTimeList);
        List<List<OneDataDetail>> dataDetailList = getDataDetailListByParam(sQueryParam, deviceInfoList, parameterCharts, sDateTimeList);
        DataTablePageing dataTablePageing = getDataTableAndPageing(pageNumber, pageSize, dataDetailList);
        return dataTablePageing;
    }

    //************************************私有函数********************************************//
    public static DataTablePageing getDataTableAndPageing(Integer pageNumber, Integer pageSize, List<List<OneDataDetail>> dataDetailList) throws Exception {
        DataTablePageing dataTablePageing = new DataTablePageing();
        Integer bigIndex = 0;
        Integer smallIndex = 0;
        smallIndex = pageNumber - 1;
        bigIndex = smallIndex + pageSize;
        //截取部分字符串
        List<List<OneDataDetail>> dataDetailListSub = new ArrayList<List<OneDataDetail>>();
        if (bigIndex > dataDetailList.size())
            bigIndex = dataDetailList.size();
        dataDetailListSub.addAll(dataDetailList.subList(smallIndex, bigIndex));
        String sReturnJson = formatDataDetailsToJson(dataDetailListSub);
        dataTablePageing.setTotal(dataDetailList.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    private List<EC01DeviceMessage> judgeDeviceOnlineState(List<EC01DeviceMessage> ec01DeviceMessageList, int offline) throws Exception {
        for (EC01DeviceMessage ec01DeviceMessage : ec01DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(ec01DeviceMessage, offline);
        }
        return ec01DeviceMessageList;
    }

    private void judgeOneDeviceOnlineState(EC01DeviceMessage ec01DeviceMessage, int offline) throws Exception {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDate = simpleFormat.format(new Date());
        long from = simpleFormat.parse(ec01DeviceMessage.getDReceiveTime()).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes > offline)
            ec01DeviceMessage.setDState("离线");
        else
            ec01DeviceMessage.setDState("在线");
    }

    private List<List<OneDataDetail>> getDataDetailListByParam(String sQueryParam, List<DeviceInfo> deviceInfoList, ParameterCharts parameterCharts, String[] sDateTimeList) throws Exception {
        List<MydataTableColumn> mydataTableColumnList = EC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, sDateTimeList);
        List<List<OneDataDetail>> dataDetailList = getDataDetailListByTableColumn(mydataTableColumnList, parameterCharts);
        return dataDetailList;
    }

    //根据数据生成JSON字符串，返回到datatable显示
    private static String formatDataDetailsToJson(List<List<OneDataDetail>> dataDetailList) throws Exception {
        String sHead = "[";
        String sEnd = "]";
        String sOneHead = "{";
        String sOneEnd = "}";
        String sReturnJson = sHead;
        for (List<OneDataDetail> oneDataDetailList : dataDetailList
                ) {
            String sOneLine = sOneHead;
            for (OneDataDetail oneDataDetail : oneDataDetailList
                    ) {
                sOneLine += "\"" + oneDataDetail.getName() + "\"";
                sOneLine += ":";
                sOneLine += "\"" + oneDataDetail.getValue() + "\"";
                sOneLine += ",";
            }
            sOneLine = sOneLine.substring(0, sOneLine.length() - 1);
            sOneLine += sOneEnd;
            sReturnJson += sOneLine + ",";
        }
        sReturnJson = sReturnJson.substring(0, sReturnJson.length() - 1);
        sReturnJson += sEnd;
        return sReturnJson;
    }

    //根据曲线的查询结果，转换成key/value形式，为datatable服务
    private List<List<OneDataDetail>> getDataDetailList(List<DeviceInfo> deviceInfoList, ParameterCharts parameterCharts) {
        List<List<OneDataDetail>> dataDetailList = new ArrayList<List<OneDataDetail>>();
        List<String> sTimeList = parameterCharts.getChartsParameters().getdParameterTime();
        //以时间为基准，先填一行，再增加行
        for (int i = 0; i < sTimeList.size(); i++) {
            String sTime = sTimeList.get(i);
            List<OneDataDetail> dataDetails = new ArrayList<OneDataDetail>();
            //循环设备列表
            for (DeviceInfo deviceInfo : deviceInfoList
                    ) {
                OneDataDetail oneDataDetail = new OneDataDetail();
                //找到名称--填入设备序列号
                oneDataDetail.setName(deviceInfo.getDSerialNum());
                //找到值(循环曲线 曲线中的某一条曲线中的值)
                for (ParameterData pD : parameterCharts.getChartsParameters().getdParameterdata()
                        ) {
                    // 判断设备名称是否相同
                    if (pD.getName().equals(deviceInfo.getDName())) {
                        //读取跟上面的时间相同位置的值
                        oneDataDetail.setValue(pD.getData().get(i));
                    }
                }
                dataDetails.add(oneDataDetail);
            }
            OneDataDetail oneDataDetailTime = new OneDataDetail();
            oneDataDetailTime.setName("sSendTime");
            oneDataDetailTime.setValue(sTime);
            dataDetails.add(oneDataDetailTime);
            dataDetailList.add(dataDetails);
        }
        return dataDetailList;
    }

    //根据曲线的查询结果，转换成key/value形式，为datatable服务
    private List<List<OneDataDetail>> getDataDetailListByTableColumn(List<MydataTableColumn> mydataTableColumnList, ParameterCharts parameterCharts) {
        List<List<OneDataDetail>> dataDetailList = new ArrayList<List<OneDataDetail>>();
        if (parameterCharts == null) {
            return dataDetailList;
        }
        List<String> sTimeList = parameterCharts.getChartsParameters().getdParameterTime();
        //以时间为基准，先填一行，再增加行
        for (int i = 0; i < sTimeList.size(); i++) {
            String sTime = sTimeList.get(i);
            List<OneDataDetail> dataDetails = new ArrayList<OneDataDetail>();
            //循环表头一次循环为一行数据
            for (MydataTableColumn mydataTableColumn : mydataTableColumnList
                    ) {
                if (mydataTableColumn.getTitle().equals("发送时间")) {
                    continue;
                }
                OneDataDetail oneDataDetail = new OneDataDetail();
                //找到名称--填入设备序列号--填入列头信息
                oneDataDetail.setName(mydataTableColumn.getTitle());
                //找到值(循环曲线 曲线中的某一条曲线中的值)
                for (ParameterData pD : parameterCharts.getChartsParameters().getdParameterdata()
                        ) {
                    // 判断设备名称是否相同
                    if (pD.getName().equals(mydataTableColumn.getTitle())) {
                        //读取跟上面的时间相同位置的值
                        oneDataDetail.setValue(pD.getData().get(i));
                        break;
                    }
                }
                dataDetails.add(oneDataDetail);
            }
            OneDataDetail oneDataDetailTime = new OneDataDetail();
            oneDataDetailTime.setName("sSendTime");
            oneDataDetailTime.setValue(sTime);
            dataDetails.add(oneDataDetailTime);
            dataDetailList.add(dataDetails);
        }
        return dataDetailList;
    }

    //根据设备信息，设备ID数组，查询参数，合成曲线格式的对象
    private ParameterCharts getParameterChartsByDeviceMessageList(List<EC01DeviceMessage> deviceMessageList, String[] sDeviceIds, String sQueryParam) {
        List<DeviceCharts01> deviceChartsList = new ArrayList<DeviceCharts01>();
        //将查询的数据放置到设备历史数据类
        ParameterCharts returnParamChats = null;
        if (deviceMessageList.size() > 0) {
            for (String sOneDeviceId : sDeviceIds
                    ) {
                List<EC01DeviceMessage> deviceMessageList1 = new ArrayList<EC01DeviceMessage>();
                //遍历每一行，放置到对应的设备信息类中
                for (EC01DeviceMessage deviceMessage : deviceMessageList
                        ) {
                    if (deviceMessage.getDSerialNum().equals(sOneDeviceId)) {
                        deviceMessageList1.add(deviceMessage);
                    }
                }
                if (deviceMessageList1.size() == 0) {
                    EC01DeviceMessage deviceMessage = new EC01DeviceMessage();
                    DeviceInfo deviceInfo = deviceInfoMapper.selectDeviceInfoByID(sOneDeviceId);
                    deviceMessage.setDSerialNum(deviceInfo.getDSerialNum());
                    deviceMessage.setDName(deviceInfo.getDName());
                    deviceMessageList1.add(deviceMessage);
                }

                DeviceCharts01 deviceCharts = new DeviceCharts01(deviceMessageList1);
                deviceChartsList.add(deviceCharts);
            }
            returnParamChats = new ParameterCharts(deviceChartsList, sQueryParam, EC01Util.getParameterTime(deviceMessageList));
        }
        return returnParamChats;
    }

    //根据设备信息，设备ID数组，查询参数，合成曲线格式的对象 为日饮水量服务
    private ParameterCharts getDayWaterByDeviceMessageListThreshold(List<EC01DeviceMessage> deviceMessageList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam) {
        //将查询的数据放置到设备历史数据类
        ParameterCharts returnParamChats = null;
        List<DeviceCharts01> deviceChartsList = new ArrayList<DeviceCharts01>();
        //为了饮水曲线的Y轴生成
        List<EC01DeviceDayWater> ec01DeviceDayWaterList = new ArrayList<>();
        //第一步，把设备分类，去除阈值
        Map<String, List<EC01DeviceMessage>> ec01ListMap = this.splitEC01AndThreshold(sDeviceIds, deviceMessageList, sMaxThreshold, sMinThreshold);
        //第二步，生成曲线
        for (Map.Entry<String, List<EC01DeviceMessage>> entry : ec01ListMap.entrySet()) {
            EC01DeviceDayWater ec01DeviceDayWater = new EC01DeviceDayWater(entry.getKey(), entry.getValue());
            ec01DeviceDayWaterList.add(ec01DeviceDayWater);
            //饮水量曲线生成
            DeviceCharts01 deviceChartsWater = new DeviceCharts01(ec01DeviceDayWater, sQueryParam);
            deviceChartsList.add(deviceChartsWater);
        }

        returnParamChats = new ParameterCharts(deviceChartsList, sQueryParam, EC01Util.getParameterDate(deviceMessageList));
        return returnParamChats;
    }

    //获取温度和水流量的设备曲线
    private ParameterCharts getTempWaterChartsByDeviceMessageList(List<EC01DeviceMessage> deviceMessageList, String sMaxThreshold, String sMinThreshold, EC01DeviceDayAvgTemp ec01DeviceDayAvgTemp, String[] sDeviceIds, String sQueryParam) {
        //将查询的数据放置到设备历史数据类
        ParameterCharts returnParamChats = null;
        List<DeviceCharts01> deviceChartsList = new ArrayList<DeviceCharts01>();
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        //温度曲线生成
        DeviceCharts01 deviceChartsTemp = new DeviceCharts01(ec01DeviceDayAvgTemp);
        deviceChartsList.add(deviceChartsTemp);
        //温度曲线的Y轴生成
        EChartsYAxis eChartsYAxisTemp = new EChartsYAxis(ec01DeviceDayAvgTemp);
        eChartsYAxisList.add(eChartsYAxisTemp);
        //为了饮水曲线的Y轴生成
        List<EC01DeviceDayWater> ec01DeviceDayWaterList = new ArrayList<>();
        //第一步，把设备分类，去除阈值
        Map<String, List<EC01DeviceMessage>> ec01ListMap = this.splitEC01AndThreshold(sDeviceIds, deviceMessageList, sMaxThreshold, sMinThreshold);
        //第二步，生成曲线
        for (Map.Entry<String, List<EC01DeviceMessage>> entry : ec01ListMap.entrySet()) {
            EC01DeviceDayWater ec01DeviceDayWater = new EC01DeviceDayWater(entry.getKey(), entry.getValue());
            ec01DeviceDayWaterList.add(ec01DeviceDayWater);
            //饮水量曲线生成
            DeviceCharts01 deviceChartsWater = new DeviceCharts01(ec01DeviceDayWater, sQueryParam);
            deviceChartsList.add(deviceChartsWater);
        }
        //饮水曲线的Y轴生成
        EChartsYAxis eChartsYAxisWater = new EChartsYAxis(ec01DeviceDayWaterList, "right");
        eChartsYAxisList.add(eChartsYAxisWater);

        returnParamChats = new ParameterCharts(deviceChartsList, sQueryParam, EC01Util.getParameterTime(ec01DeviceDayAvgTemp));
        returnParamChats.seteChartsYAxisList(eChartsYAxisList);
        return returnParamChats;
    }

    //单个设备按照日期划分数据，不同日期之间的数值对比
    private ParameterCharts getOneDeviceDataSplitByDateTime(Map<String, List<EC01DeviceMessage>> deviceMsgListMap, String sQueryParam) {
        ParameterCharts returnParamChats = null;
        List<DeviceCharts01> deviceChartsList = new ArrayList<DeviceCharts01>();
        for (Map.Entry<String, List<EC01DeviceMessage>> entry : deviceMsgListMap.entrySet()) {
            DeviceCharts01 deviceCharts01 = new DeviceCharts01(entry.getValue(), entry.getKey(), sQueryParam);
            deviceChartsList.add(deviceCharts01);
        }
        returnParamChats = new ParameterCharts(deviceChartsList, sQueryParam, EC01Util.getParameterTime(deviceMsgListMap));
        return returnParamChats;
    }

    //生成多舍日饮水量曲线
    private ParameterCharts getMuitiDeviceWaterChartsByDml(List<EC01DeviceMessage> deviceMessageList, String sMaxThreshold, String sMinThreshold, String[] sDeviceIds, String sQueryParam) {
        ParameterCharts returnParamChats = null;
        List<DeviceCharts01> deviceChartsList = new ArrayList<DeviceCharts01>();
        //第一步，把设备分类，去除阈值
        Map<String, List<EC01DeviceMessage>> ec01ListMap = this.splitEC01AndThreshold(sDeviceIds, deviceMessageList, sMaxThreshold, sMinThreshold);
        //重新合成list
        List<EC01DeviceMessage> ec01DeviceMessageList = this.getEC01ListByMap(ec01ListMap);
        List<String> ec01DeviceDate = EC01Util.getParameterDate(ec01DeviceMessageList);
        //多舍日饮水量
        DeviceCharts01 deviceChartsWater = new DeviceCharts01(ec01DeviceDate, ec01DeviceMessageList);
        deviceChartsList.add(deviceChartsWater);
        returnParamChats = new ParameterCharts(deviceChartsList, sQueryParam, ec01DeviceDate);
        return returnParamChats;
    }

    //按照设备分类，去除阈值
    private Map<String, List<EC01DeviceMessage>> splitEC01AndThreshold(String[] sDeviceIds, List<EC01DeviceMessage> deviceMessageList, String sMaxThreshold, String sMinThreshold) {
        Map<String, List<EC01DeviceMessage>> ec01ListMap = new HashMap<>();
        for (String sDeviceId : sDeviceIds
                ) {
            List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<>();
            for (EC01DeviceMessage ec01DeviceMessage : deviceMessageList
                    ) {
                if (ec01DeviceMessage.getDSerialNum().equals(sDeviceId)) {
                    ec01DeviceMessageList.add(ec01DeviceMessage);
                }
            }
            judgeWaterThreshold(ec01DeviceMessageList, sMaxThreshold, sMinThreshold);
            ec01ListMap.put(sDeviceId, ec01DeviceMessageList);
        }
        return ec01ListMap;
    }

    //设备分类+阈值处理完成之后，重新合成List,为多舍日饮水量服务
    private List<EC01DeviceMessage> getEC01ListByMap(Map<String, List<EC01DeviceMessage>> ec01ListMap) {
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<>();
        for (List<EC01DeviceMessage> ec01DeviceMessageList1 : ec01ListMap.values()
                ) {
            ec01DeviceMessageList.addAll(ec01DeviceMessageList1);
        }
        return ec01DeviceMessageList;
    }

    //去除饮水量的最大值、最小值以外的值。
    private void judgeWaterThreshold(List<EC01DeviceMessage> ec01DeviceMessageList, String sMaxThreshold, String sMinThreshold) {
        if (!StringUtils.isNullOrEmpty(sMaxThreshold)) {
            float fMaxThreshold = Float.valueOf(sMaxThreshold);
            for (int i = 0; i < ec01DeviceMessageList.size(); i++) {
                if (ec01DeviceMessageList.get(i).getWaterFlowVal() > fMaxThreshold) {
                    //如果有超过最大阈值的，先取前一天的数据，如果前一天没有，就取后一天的数据，如果都没有就不处理。
                    //需要取前一天的并且同一个设备
                    if (i - 1 > -1)
                        ec01DeviceMessageList.get(i).setWaterFlowVal(ec01DeviceMessageList.get(i - 1).getWaterFlowVal());
                    else if (i + 1 < ec01DeviceMessageList.size())
                        ec01DeviceMessageList.get(i).setWaterFlowVal(ec01DeviceMessageList.get(i + 1).getWaterFlowVal());
                }
            }
        }
        if (!StringUtils.isNullOrEmpty(sMinThreshold)) {
            float fMinThreshold = Float.valueOf(sMinThreshold);
            for (int i = 0; i < ec01DeviceMessageList.size(); i++) {
                //如果有小于最小阈值的，先取前一天的数据，如果前一天没有，就取后一天的数据，如果都没有就不处理。
                if (ec01DeviceMessageList.get(i).getWaterFlowVal() < fMinThreshold) {
                    if (i - 1 > -1)
                        ec01DeviceMessageList.get(i).setWaterFlowVal(ec01DeviceMessageList.get(i - 1).getWaterFlowVal());
                    else if (i + 1 < ec01DeviceMessageList.size())
                        ec01DeviceMessageList.get(i).setWaterFlowVal(ec01DeviceMessageList.get(i + 1).getWaterFlowVal());
                }
            }
        }
    }
}
