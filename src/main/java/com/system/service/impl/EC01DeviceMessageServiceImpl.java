package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.DeviceInfoMapper;
import com.system.mapperiot.EC01DeviceMessageMapper;
import com.system.po.*;
import com.system.po.Device.EC01DeviceMessage;
import com.system.po.parameter.DeviceCharts01;
import com.system.po.parameter.OneDataDetail;
import com.system.po.parameter.ParameterCharts;
import com.system.po.parameter.ParameterData;
import com.system.service.EC01DeviceMessageService;
import com.system.util.EJConvertor;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EC01DeviceMessageServiceImpl implements EC01DeviceMessageService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Autowired
    private EC01DeviceMessageMapper ec01DeviceMessageMapper;
    @Autowired
    private EJConvertor ejConvertor;

    @Override
    public List<EC01DeviceMessage> selectEC01ByORGId(String ORGId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = ec01DeviceMessageMapper.selectEC01ByORGId(ORGId);
        ec01DeviceMessageList = judgeDeviceOnlineState(ec01DeviceMessageList);
        return ec01DeviceMessageList;
    }

    @Override
    public List<EC01DeviceMessage> selectEC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<EC01DeviceMessage> ec01DeviceMessageList = ec01DeviceMessageMapper.selectEC01ByORGIdAndRoleId(ORGId, roleIds);
        ec01DeviceMessageList = judgeDeviceOnlineState(ec01DeviceMessageList);
        return ec01DeviceMessageList;
    }

    @Override
    public EC01DeviceMessage selectEC01ByDeviceId(String sDeviceId) throws Exception {
        EC01DeviceMessage ec01DeviceMessage = ec01DeviceMessageMapper.selectEC01ByDeviceId(sDeviceId);
        judgeOneDeviceOnlineState(ec01DeviceMessage);
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
        String str = JSON.toJSON(ec01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(ec01DeviceMessageList);
        dataTablePageing.setTotal(ec01DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    /**
     * 查询多个设备历史数据-曲线格式
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
        List<EC01DeviceMessage> deviceMessageList = ec01DeviceMessageMapper.selectEC01ByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
        ParameterCharts returnParamChats = getParameterChartsByDeviceMessageList(deviceMessageList, sDeviceIds, sQueryParam);
        return returnParamChats;
    }

    /**
     * 查询多个设备历史数据-报表格式
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
            dataDetailList = getDataDetailList(deviceInfoList, parameterCharts);
        }
        //List<List<OneDataDetail>> dataDetailList = getDataDetailList(deviceInfoList,parameterCharts);
        String sReturnJson = formatDataDetailsToJson(dataDetailList);
        //return dataDetailList;
        return dataDetailList;
    }

    /**
     * 查询多个设备历史数据-报表格式;分页
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
        Integer bigIndex = 0;
        Integer smallIndex = 0;
        smallIndex = pageNumber - 1;
        bigIndex = smallIndex + pageSize;
        List<List<OneDataDetail>> dataDetailList = getDataDetailList(deviceInfoList, parameterCharts);
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

    //************************************私有函数********************************************//
    private List<EC01DeviceMessage> judgeDeviceOnlineState(List<EC01DeviceMessage> ec01DeviceMessageList) throws Exception {
        for (EC01DeviceMessage ec01DeviceMessage : ec01DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(ec01DeviceMessage);
        }
        return ec01DeviceMessageList;
    }

    private void judgeOneDeviceOnlineState(EC01DeviceMessage ec01DeviceMessage) throws Exception {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDate = simpleFormat.format(new Date());
        long from = simpleFormat.parse(ec01DeviceMessage.getDReceiveTime()).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes > 15)
            ec01DeviceMessage.setDState("离线");
        else
            ec01DeviceMessage.setDState("在线");
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
            returnParamChats = new ParameterCharts(deviceChartsList, sQueryParam, deviceMessageList);
        }
        return returnParamChats;
    }
}
