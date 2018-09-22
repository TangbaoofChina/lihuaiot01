package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import com.system.mapperiot.DeviceInfoMapper;
import com.system.mapperiot.ScaleC01DeviceMessageMapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.ScaleC01DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.ScaleC01.ScaleC01EffectiveWt;
import com.system.po.ScaleC01.ScaleC01WtAnalysis;
import com.system.po.parameter.DeviceType;
import com.system.po.parameter.OneDataDetail;
import com.system.service.DeviceTypeService;
import com.system.service.EC01DeviceMessageService;
import com.system.service.ScaleC01DeviceMessageService;
import com.system.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScaleC01DeviceMessageServiceImpl implements ScaleC01DeviceMessageService {

    @Autowired
    private ScaleC01DeviceMessageMapper scaleC01DeviceMessageMapper;
    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<ScaleC01DeviceMessage> selectScaleC01ByORGId(String ORGId) throws Exception {
        List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = scaleC01DeviceMessageMapper.selectScaleC01ByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("311");
        scaleC01DeviceMessageList = this.judgeDeviceOnlineState(scaleC01DeviceMessageList, deviceType.getDevTypeOffline());
        return scaleC01DeviceMessageList;
    }

    @Override
    public List<ScaleC01DeviceMessage> selectScaleC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = scaleC01DeviceMessageMapper.selectScaleC01ByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("311");
        scaleC01DeviceMessageList = this.judgeDeviceOnlineState(scaleC01DeviceMessageList, deviceType.getDevTypeOffline());
        return scaleC01DeviceMessageList;
    }

    @Override
    public ScaleC01DeviceMessage selectScaleC01ByDeviceId(String sDeviceId) throws Exception {
        ScaleC01DeviceMessage scaleC01DeviceMessage = scaleC01DeviceMessageMapper.selectScaleC01ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("311");
        this.judgeOneDeviceOnlineState(scaleC01DeviceMessage, deviceType.getDevTypeOffline());
        return scaleC01DeviceMessage;
    }

    @Override
    public List<ScaleC01DeviceMessage> selectScaleC01ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return scaleC01DeviceMessageMapper.selectScaleC01ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
    }

    //为历史数据界面服务
    @Override
    public DataTablePageing selectScaleC01ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = new ArrayList<ScaleC01DeviceMessage>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<ScaleC01DeviceMessage> scale01DeviceMessageListAll = scaleC01DeviceMessageMapper.selectScaleC01ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
        if (scale01DeviceMessageListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > scale01DeviceMessageListAll.size())
                bigIndex = scale01DeviceMessageListAll.size();
            scaleC01DeviceMessageList.addAll(scale01DeviceMessageListAll.subList(smallIndex, bigIndex));
        }
        //String str= JSON.toJSON(sewageC01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(scaleC01DeviceMessageList);
        dataTablePageing.setTotal(scale01DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    @Override
    public DataTablePageing selectHisScaleC01ByDateAndIDsAndPage(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        return null;
    }

    //为历史曲线界面服务-生成列表
    @Override
    public DataTablePageing selectHisScaleC01ByDateAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold, String sStartAge, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = this.getScaleC01MapByDate(sMaxThreshold, sMinThreshold, sDeviceIds, sStartDate, sEndDate);
        DataTablePageing dataTablePageing = new DataTablePageing();
        if (sQueryParam.equals("称重分析")) {
            List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(sDeviceIds[0]);
            dataTablePageing = this.getScaleC01WtAnalysisPaging(scaleC01WtAnalysisList, pageNumber, pageSize);
        } else if (sQueryParam.equals("有效体重")) { //从最早的日期开始，顺序排列
            List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(sDeviceIds[0]);
            dataTablePageing = this.getScaleC01EffectivePaging(scaleC01WtAnalysisList, pageNumber, pageSize);
        } else if (sQueryParam.equals("平均体重")) {
            List<MydataTableColumn> mydataTableColumnList = ScaleC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
            dataTablePageing = this.getScaleC01AvgWt(mydataTableColumnList, scaleC01MapByDate, pageNumber, pageSize);
        } else if (sQueryParam.equals("增重日龄")) {
            List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(sDeviceIds[0]);
            dataTablePageing = this.getScaleC01WtAge(scaleC01WtAnalysisList, sStartAge, pageNumber, pageSize);
        } else if (sQueryParam.equals("多增重日龄")) {
            List<MydataTableColumn> mydataTableColumnList = ScaleC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
            dataTablePageing = this.getScaleC01sWtAge(mydataTableColumnList, scaleC01MapByDate, sStartAge, pageNumber, pageSize);
        }
        return dataTablePageing;
    }

    //为历史曲线界面报表导出服务-生产导出list
    @Override
    public List<List<OneDataDetail>> selectHisScaleC01ByDateAndIDsTableAndThreshold(List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sStartAge, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        List<List<OneDataDetail>> dataDetailList = null;
        //这里没有进行增重日龄的计算
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = this.getScaleC01MapByDate(sMaxThreshold, sMinThreshold, sDeviceIds, sStartDate, sEndDate);
        List<MydataTableColumn> myDTCList = ScaleC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
        if (scaleC01MapByDate != null && scaleC01MapByDate.size() > 0) {
            if (sQueryParam.equals("称重分析")) {
                List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(sDeviceIds[0]);
                dataDetailList = this.getWtOrAgeDetailList(sQueryParam, scaleC01WtAnalysisList);
            } else if (sQueryParam.equals("有效体重")) { //从最早的日期开始，顺序排列
                List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(sDeviceIds[0]);
                //这里根据有效体重 生成dataDetailList 需要写方法
                List<ScaleC01EffectiveWt> scaleC01EffectiveWtList = this.getScaleC01EffWt(scaleC01WtAnalysisList);
                dataDetailList = this.getEffectiveWtDetailList(scaleC01EffectiveWtList);
            } else if (sQueryParam.equals("平均体重")) {
                dataDetailList = this.getAvgWtDetailList(myDTCList, scaleC01MapByDate);
            } else if (sQueryParam.equals("增重日龄")) {
                List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(sDeviceIds[0]);
                //这里还要进行增重日龄的计算
                this.getScaleC01WtAge(scaleC01WtAnalysisList, sStartAge);
                dataDetailList = this.getWtOrAgeDetailList(sQueryParam, scaleC01WtAnalysisList);
            } else if (sQueryParam.equals("多增重日龄")) {
                dataDetailList = this.countTableScaleC01sWtAge(myDTCList, sStartAge, scaleC01MapByDate);
            }
        }
        return dataDetailList;
    }

    //为历史曲线界面生成曲线服务
    @Override
    public Map<String, List<ScaleC01WtAnalysis>> selectHisScaleC01ByDateAndIDsChartThreshold(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sStartAge, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = null;
        if (sQueryParam.equals("平均体重")) {
            scaleC01MapByDate = this.getScaleC01MapByDate(sMaxThreshold, sMinThreshold, sDeviceIds, sStartDate, sEndDate);
        } else if (sQueryParam.equals("增重日龄") || sQueryParam.equals("多增重日龄")) {
            scaleC01MapByDate = this.getScaleC01MapByDate(sMaxThreshold, sMinThreshold, sDeviceIds, sStartDate, sEndDate);
            //这里还要进行增重日龄的计算
            if (scaleC01MapByDate != null && scaleC01MapByDate.size() > 0) {
                for (List<ScaleC01WtAnalysis> scaleC01WtAnalysisList : scaleC01MapByDate.values()) {
                    this.getScaleC01WtAge(scaleC01WtAnalysisList, sStartAge);
                }
            }
        }
        return scaleC01MapByDate;
    }

    @Override
    public List<MydataTableColumn> selectScaleC01DeviceHead() throws Exception {
        ScaleC01DeviceMessage scaleC01DeviceMessage = new ScaleC01DeviceMessage();
        List<MydataTableColumn> mydataTableColumnList = scaleC01DeviceMessage.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<ScaleC01DeviceMessage> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(ScaleC01DeviceMessage.class, storageList);
    }

    @Override
    public File exportStoragedynamic(List<MydataTableColumn> mydataTableColumnList, List<List<OneDataDetail>> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriterdynamic(ScaleC01DeviceMessage.class, mydataTableColumnList, storageList);
    }

    //************************************私有函数********************************************//
    private List<ScaleC01DeviceMessage> judgeDeviceOnlineState(List<ScaleC01DeviceMessage> scaleC01DeviceMessageList, int offline) throws Exception {
        for (BaseDeviceMessage baseDeviceMessage : scaleC01DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage, offline);
        }
        return scaleC01DeviceMessageList;
    }

    //判断设备在线/离线状态
    private void judgeOneDeviceOnlineState(BaseDeviceMessage baseDeviceMessage, int offline) throws Exception {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDate = simpleFormat.format(new Date());
        long from = simpleFormat.parse(baseDeviceMessage.getDReceiveTime()).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes > offline)
            baseDeviceMessage.setDState("离线");
        else
            baseDeviceMessage.setDState("在线");
    }

    //多个设备-按日期划分数据-并计算设备的单日的数据(设备，日期数据)-未计算增重，日龄
    private Map<String, List<ScaleC01WtAnalysis>> getScaleC01MapByDate(String sMaxThreshold, String sMinThreshold, String[] sDeviceIds, String sStartDate, String sEndDate) {
        sStartDate = sStartDate.substring(0, 10);
        sEndDate = sEndDate.substring(0, 10);
        List<ScaleC01DeviceMessage> deviceMessageList = scaleC01DeviceMessageMapper.selectScaleC01ByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
        //获取每个设备的数据(设备，设备数据)
        if (deviceMessageList == null || deviceMessageList.size() < 1) {
            return null;
        }
        Map<String, List<ScaleC01DeviceMessage>> scaleC01MapByIds = this.splitMsgByIds(deviceMessageList, sDeviceIds);
        //重新整合每个设备的数据(去除阈值，去除0)
        //多个设备-按日期划分数据-并计算设备的单日的数据(设备，日期称重分析数据list) 日期已排序 有小到大
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = this.splitMsgByDate(scaleC01MapByIds, sMaxThreshold, sMinThreshold);
        return scaleC01MapByDate;
    }

    //数据库查询的数据，按照设备进行分类
    private Map<String, List<ScaleC01DeviceMessage>> splitMsgByIds(List<ScaleC01DeviceMessage> deviceMessageList, String[] sDeviceIds) {
        Map<String, List<ScaleC01DeviceMessage>> scaleC01Map = new HashMap<>();
        for (String deviceId : sDeviceIds
                ) {
            List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = new ArrayList<>();
            for (ScaleC01DeviceMessage msg : deviceMessageList
                    ) {
                if (msg.getDSerialNum().equals(deviceId)) {
                    scaleC01DeviceMessageList.add(msg);
                }
            }
            scaleC01Map.put(deviceId, scaleC01DeviceMessageList);
        }
        return scaleC01Map;
    }

    //以设备为单位-按照日期把数据进行划分（设备，设备称重分析数据list） 日期已排序 有小到大
    private Map<String, List<ScaleC01WtAnalysis>> splitMsgByDate(Map<String, List<ScaleC01DeviceMessage>> scaleC01MapByIds, String sMaxThreshold, String sMinThreshold) {
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = new HashMap<>();
        for (Map.Entry<String, List<ScaleC01DeviceMessage>> entry : scaleC01MapByIds.entrySet()) {
            List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = entry.getValue();
            List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = this.splitDeviceMsgByDate(scaleC01DeviceMessageList, sMaxThreshold, sMinThreshold);
            scaleC01MapByDate.put(entry.getKey(), scaleC01WtAnalysisList);
        }
        return scaleC01MapByDate;
    }

    //单个设备-按照日期把数据进行划分(不区分设备，只区分日期，也可以用作单个日期+多个设备)
    private List<ScaleC01WtAnalysis> splitDeviceMsgByDate(List<ScaleC01DeviceMessage> scaleC01DeviceMessageList, String sMaxThreshold, String sMinThreshold) {
        //获取日期，已排序
        List<String> dateList = ScaleC01Util.getParameterDate(scaleC01DeviceMessageList);
        //根据日期获取对象集合（日期，对象数据）
        Map<String, List<ScaleC01DeviceMessage>> scaleMsgByDate = this.splitDeviceMsgByDate(dateList, scaleC01DeviceMessageList);
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = this.formatWtAnalysis(scaleMsgByDate, sMaxThreshold, sMinThreshold);
        return scaleC01WtAnalysisList;
    }

    //按照日期把数据进行划分(不区分设备，只区分日期，也可以用作单个日期+多个设备)
    private Map<String, List<ScaleC01DeviceMessage>> splitDeviceMsgByDate(List<String> dateList, List<ScaleC01DeviceMessage> scaleC01DeviceMessageList) {
        Map<String, List<ScaleC01DeviceMessage>> scaleMsgByDate = new HashMap<>();
        for (String date : dateList
                ) {
            List<ScaleC01DeviceMessage> scaleC01DeviceMessageList1 = new ArrayList<>();
            for (ScaleC01DeviceMessage msg : scaleC01DeviceMessageList
                    ) {
                if (msg.getDReceiveTime().substring(0, 10).equals(date)) {
                    scaleC01DeviceMessageList1.add(msg);
                }
            }
            scaleMsgByDate.put(date, scaleC01DeviceMessageList1);
        }
        return scaleMsgByDate;
    }

    //生成有效上鸡数量、平均体重、鸡群均匀度集合(上一级是单个设备，其实可以多设备)
    private List<ScaleC01WtAnalysis> formatWtAnalysis(Map<String, List<ScaleC01DeviceMessage>> scaleMsgByDate, String sMaxThreshold, String sMinThreshold) {
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = new ArrayList<>();
        for (Map.Entry<String, List<ScaleC01DeviceMessage>> entry : scaleMsgByDate.entrySet()) {
            List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = entry.getValue();
            ScaleC01WtAnalysis scaleC01WtAnalysis = new ScaleC01WtAnalysis(entry.getKey(), scaleC01DeviceMessageList, sMaxThreshold, sMinThreshold);
            scaleC01WtAnalysisList.add(scaleC01WtAnalysis);
        }
        return scaleC01WtAnalysisList;
    }

    //生成有效上鸡数量、平均体重、鸡群均匀度集合的报表
    private DataTablePageing getScaleC01WtAnalysisPaging(List<ScaleC01WtAnalysis> scaleC01WtAnalysisListAll, Integer pageNumber, Integer pageSize) {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = new ArrayList<>();
        if (scaleC01WtAnalysisListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > scaleC01WtAnalysisListAll.size())
                bigIndex = scaleC01WtAnalysisListAll.size();
            scaleC01WtAnalysisList.addAll(scaleC01WtAnalysisListAll.subList(smallIndex, bigIndex));
        }
        String str = JSON.toJSON(scaleC01WtAnalysisList).toString();
        String sReturnJson = JSON.toJSONString(scaleC01WtAnalysisList);
        dataTablePageing.setTotal(scaleC01WtAnalysisListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        return dataTablePageing;
    }

    //生成有效体重列表
    private DataTablePageing getScaleC01EffectivePaging(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList, Integer pageNumber, Integer pageSize) {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<ScaleC01EffectiveWt> scaleC01EffectiveWtListAll = this.getScaleC01EffWt(scaleC01WtAnalysisList);
        List<ScaleC01EffectiveWt> scaleC01EffectiveWtList = new ArrayList<>();
        if (scaleC01EffectiveWtListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > scaleC01EffectiveWtListAll.size())
                bigIndex = scaleC01EffectiveWtListAll.size();
            scaleC01EffectiveWtList.addAll(scaleC01EffectiveWtListAll.subList(smallIndex, bigIndex));
        }
        String sReturnJson = JSON.toJSONString(scaleC01EffectiveWtList);
        dataTablePageing.setTotal(scaleC01EffectiveWtListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        return dataTablePageing;
    }

    //对有效体重进行数据对象整合
    private List<ScaleC01EffectiveWt> getScaleC01EffWt(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        List<ScaleC01EffectiveWt> scaleC01EffectiveWtList = new ArrayList<>();
        List<Integer> scaleC01WtList = new ArrayList<>();
        for (ScaleC01WtAnalysis scaleC01WtAnalysis : scaleC01WtAnalysisList
                ) {
            scaleC01WtList.addAll(scaleC01WtAnalysis.getiDataList());
        }
        scaleC01EffectiveWtList = this.formatScaleC01EffWtList(scaleC01WtList);
        return scaleC01EffectiveWtList;
    }

    //将所有的有效数据，进行排序，放置到ScaleC01EffectiveWt对象(wt01~wt09)中
    private List<ScaleC01EffectiveWt> formatScaleC01EffWtList(List<Integer> scaleC01WtList) {
        List<ScaleC01EffectiveWt> scaleC01EffectiveWtList = new ArrayList<>();
        for (int i = 0; i < scaleC01WtList.size(); i++) {
            Integer smallIndex = i;
            Integer bigIndex = smallIndex + 9;
            if (bigIndex > scaleC01WtList.size())
                bigIndex = scaleC01WtList.size();
            scaleC01EffectiveWtList.add(new ScaleC01EffectiveWt(scaleC01WtList.subList(smallIndex, bigIndex)));
            i = i + 8;
        }
        return scaleC01EffectiveWtList;
    }

    //多设备平均体重 生成列表
    private DataTablePageing getScaleC01AvgWt(List<MydataTableColumn> tableColumnList, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate, Integer pageNumber, Integer pageSize) throws Exception {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<List<OneDataDetail>> dataDetailList = this.getAvgWtDetailList(tableColumnList, scaleC01MapByDate);
        dataTablePageing = EC01DeviceMessageServiceImpl.getDataTableAndPageing(pageNumber, pageSize, dataDetailList);
        return dataTablePageing;
    }

    //生成报表的每一行元素 为平均体重服务，表头是设备1，设备2，日期
    private List<List<OneDataDetail>> getAvgWtDetailList(List<MydataTableColumn> tableColumnList, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        List<List<OneDataDetail>> dataDetailList = new ArrayList<List<OneDataDetail>>();
        if (scaleC01MapByDate == null || scaleC01MapByDate.size() < 1) {
            return dataDetailList;
        }
        //以时间为单位，为一行
        List<String> sDateList = ScaleC01Util.getScaleC01DateList(scaleC01MapByDate);
        //以时间为基准，先填一行，再增加行
        for (int i = 0; i < sDateList.size(); i++) {
            String sDate = sDateList.get(i);
            List<OneDataDetail> dataDetails = new ArrayList<OneDataDetail>();
            //循环设备列表
            for (MydataTableColumn mydataTableColumn : tableColumnList
                    ) {
                if (mydataTableColumn.getData().equals("sDate")) {
                    continue;
                }
                OneDataDetail oneDataDetail = new OneDataDetail();
                //找到名称--填入设备序列号--填入列头信息
                oneDataDetail.setName(mydataTableColumn.getData());
                //需要遍历设备的日期数据列表，防止设备有部分日期没有数据
                List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(mydataTableColumn.getData());
                for (int j = 0; j < scaleC01WtAnalysisList.size(); j++) {
                    if (scaleC01WtAnalysisList.get(i).getsDate().equals(sDate)) {
                        oneDataDetail.setValue(String.valueOf(scaleC01WtAnalysisList.get(i).getAvgWt()));
                        break;
                    }
                }
                dataDetails.add(oneDataDetail);
            }
            //一行数据的日期数据
            OneDataDetail oneDataDetailTime = new OneDataDetail();
            oneDataDetailTime.setName("sDate");
            oneDataDetailTime.setValue(sDate);
            dataDetails.add(oneDataDetailTime);
            //一行数据完成
            dataDetailList.add(dataDetails);
        }
        return dataDetailList;
    }

    //生成增重日龄列表
    private DataTablePageing getScaleC01WtAge(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList, String sStartAge, Integer pageNumber, Integer pageSize) {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisListAll = this.getScaleC01WtAge(scaleC01WtAnalysisList, sStartAge);
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisListPage = new ArrayList<>();
        if (scaleC01WtAnalysisListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > scaleC01WtAnalysisListAll.size())
                bigIndex = scaleC01WtAnalysisListAll.size();
            scaleC01WtAnalysisListPage.addAll(scaleC01WtAnalysisListAll.subList(smallIndex, bigIndex));
        }
        String sReturnJson = JSON.toJSONString(scaleC01WtAnalysisListPage);
        dataTablePageing.setTotal(scaleC01WtAnalysisListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        return dataTablePageing;
    }

    //针对每日数据，计算出增重数据和日龄
    private List<ScaleC01WtAnalysis> getScaleC01WtAge(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList, String sStartAge) {
        if (scaleC01WtAnalysisList.size() < 1) {
            return new ArrayList<ScaleC01WtAnalysis>();
        }
        ScaleC01WtAnalysis scaleC01WtAnalysisOld = scaleC01WtAnalysisList.get(0);
        scaleC01WtAnalysisOld.setGainWt(0);
        if (!StringUtils.isNullOrEmpty(sStartAge)) {
            scaleC01WtAnalysisOld.setDayAge(Integer.valueOf(sStartAge));
        } else {
            scaleC01WtAnalysisOld.setDayAge(0);
        }
        if (scaleC01WtAnalysisList.size() < 2) {
            return scaleC01WtAnalysisList;
        }
        for (int i = 1; i < scaleC01WtAnalysisList.size(); i++) {
            scaleC01WtAnalysisList.get(i).setGainWt(scaleC01WtAnalysisList.get(i).getAvgWt() - scaleC01WtAnalysisOld.getAvgWt());
            int dAge = ScaleC01Util.getDAge(scaleC01WtAnalysisList.get(i).getsDate(), scaleC01WtAnalysisOld.getsDate());
            scaleC01WtAnalysisList.get(i).setDayAge(scaleC01WtAnalysisOld.getDayAge() + dAge);
            scaleC01WtAnalysisOld = scaleC01WtAnalysisList.get(i);
        }
        return scaleC01WtAnalysisList;
    }

    //根据获取的有效体重对象列表，合成报表的每一行，为导出报表服务
    private List<List<OneDataDetail>> getEffectiveWtDetailList(List<ScaleC01EffectiveWt> scaleC01EffectiveWtList) {
        List<List<OneDataDetail>> dataDetailList = new ArrayList<List<OneDataDetail>>();
        if (scaleC01EffectiveWtList == null || scaleC01EffectiveWtList.size() < 1) {
            return dataDetailList;
        }
        //ScaleC01EffectiveWt 一个对象为一行，从wt01~wt09，先填一行，再增加行
        for (int i = 0; i < scaleC01EffectiveWtList.size(); i++) {
            List<OneDataDetail> dataDetails = scaleC01EffectiveWtList.get(i).getDdl();
            //一行数据完成
            dataDetailList.add(dataDetails);
        }
        return dataDetailList;
    }

    //生成报表的每一行元素 为称重分析、增重日龄服务，表头是参数，日期
    private List<List<OneDataDetail>> getWtOrAgeDetailList(String sQueryParam, List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        List<List<OneDataDetail>> dataDetailList = new ArrayList<List<OneDataDetail>>();
        if (scaleC01WtAnalysisList == null || scaleC01WtAnalysisList.size() < 1) {
            return dataDetailList;
        }
        //以时间为单位，为一行
        List<String> sDateList = ScaleC01Util.getScaleC01DataList(scaleC01WtAnalysisList);
        //以时间为基准，先填一行，再增加行
        for (int i = 0; i < scaleC01WtAnalysisList.size(); i++) {
            ScaleC01WtAnalysis scaleC01WtAnalysis = scaleC01WtAnalysisList.get(i);
            List<OneDataDetail> dataDetails = new ArrayList<>();
            if (sQueryParam.equals("称重分析")) {
                dataDetails = scaleC01WtAnalysis.getWtList();
            } else if (sQueryParam.equals("增重日龄")) {
                dataDetails = scaleC01WtAnalysis.getGainWtList();
            } else {
                return dataDetailList;
            }
            //一行数据完成
            dataDetailList.add(dataDetails);
        }
        return dataDetailList;
    }

    //生成多增重日龄列表
    private DataTablePageing getScaleC01sWtAge(List<MydataTableColumn> mydataTableColumnList, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate, String sStartAge, Integer pageNumber, Integer pageSize) throws Exception {
        List<List<OneDataDetail>> dataDetailList = this.countTableScaleC01sWtAge(mydataTableColumnList, sStartAge, scaleC01MapByDate);
        DataTablePageing dataTablePageing = EC01DeviceMessageServiceImpl.getDataTableAndPageing(pageNumber, pageSize, dataDetailList);
        return dataTablePageing;
    }

    //1、计算出多增重日龄，2、生成列表/报表的每一行元素 为多增重日龄服务，表头是设备1，设备2，日龄，日期 不通用
    private List<List<OneDataDetail>> countTableScaleC01sWtAge(List<MydataTableColumn> tableColumnList, String sStartAge, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        for (List<ScaleC01WtAnalysis> scaleC01WtAnalysisList : scaleC01MapByDate.values()
                ) {
            //针对每日数据，计算出增重数据和日龄
            this.getScaleC01WtAge(scaleC01WtAnalysisList, sStartAge);
        }
        List<List<OneDataDetail>> dataDetailList = this.tableScaleC01sWtAge(tableColumnList, sStartAge, scaleC01MapByDate);
        return dataDetailList;
    }

    //生成列表/报表的每一行元素 为多增重日龄服务，表头是设备1，设备2，日龄，日期 不通用
    private List<List<OneDataDetail>> tableScaleC01sWtAge(List<MydataTableColumn> tableColumnList, String sStartAge, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        List<List<OneDataDetail>> dataDetailList = new ArrayList<List<OneDataDetail>>();
        if (scaleC01MapByDate == null || scaleC01MapByDate.size() < 1) {
            return dataDetailList;
        }
        //以时间为单位，为一行
        List<String> sDateList = ScaleC01Util.getScaleC01DateList(scaleC01MapByDate);
        List<String> sDayAgeList = ScaleC01Util.getDayAgeList(sStartAge, sDateList);
        //以时间为基准，先填一行，再增加行
        for (int i = 0; i < sDateList.size(); i++) {
            String sDate = sDateList.get(i);
            String sAge = sDayAgeList.get(i);
            List<OneDataDetail> dataDetails = new ArrayList<OneDataDetail>();
            //循环设备列表
            for (MydataTableColumn mydataTableColumn : tableColumnList
                    ) {
                if (mydataTableColumn.getData().equals("sDate")) {
                    continue;
                }
                if (mydataTableColumn.getData().equals("dayAge")) {
                    continue;
                }
                OneDataDetail oneDataDetail = new OneDataDetail();
                //找到名称--填入设备序列号--填入列头信息
                oneDataDetail.setName(mydataTableColumn.getData());
                //需要遍历设备的日期数据列表，防止设备有部分日期没有数据
                List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = scaleC01MapByDate.get(mydataTableColumn.getData());
                for (int j = 0; j < scaleC01WtAnalysisList.size(); j++) {
                    if (scaleC01WtAnalysisList.get(i).getsDate().equals(sDate)) {
                        oneDataDetail.setValue(String.valueOf(scaleC01WtAnalysisList.get(i).getGainWt()));
                        break;
                    }
                }
                dataDetails.add(oneDataDetail);
            }
            //一行数据的日龄数据
            OneDataDetail oneDataDetailAge = new OneDataDetail();
            oneDataDetailAge.setName("dayAge");
            oneDataDetailAge.setValue(sAge);
            dataDetails.add(oneDataDetailAge);
            //一行数据的日期数据
            OneDataDetail oneDataDetailTime = new OneDataDetail();
            oneDataDetailTime.setName("sDate");
            oneDataDetailTime.setValue(sDate);
            dataDetails.add(oneDataDetailTime);
            //一行数据完成
            dataDetailList.add(dataDetails);
        }
        return dataDetailList;
    }

}
