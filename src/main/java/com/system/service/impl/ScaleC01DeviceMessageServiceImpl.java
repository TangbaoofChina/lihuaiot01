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
import com.system.util.EJConvertor;
import com.system.util.RoleInfoListUtil;
import com.system.util.ScaleC01Util;
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
        scaleC01DeviceMessageList = judgeDeviceOnlineState(scaleC01DeviceMessageList, deviceType.getDevTypeOffline());
        return scaleC01DeviceMessageList;
    }

    @Override
    public List<ScaleC01DeviceMessage> selectScaleC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<ScaleC01DeviceMessage> scaleC01DeviceMessageList = scaleC01DeviceMessageMapper.selectScaleC01ByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("311");
        scaleC01DeviceMessageList = judgeDeviceOnlineState(scaleC01DeviceMessageList, deviceType.getDevTypeOffline());
        return scaleC01DeviceMessageList;
    }

    @Override
    public ScaleC01DeviceMessage selectScaleC01ByDeviceId(String sDeviceId) throws Exception {
        ScaleC01DeviceMessage scaleC01DeviceMessage = scaleC01DeviceMessageMapper.selectScaleC01ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("311");
        judgeOneDeviceOnlineState(scaleC01DeviceMessage, deviceType.getDevTypeOffline());
        return scaleC01DeviceMessage;
    }

    @Override
    public List<ScaleC01DeviceMessage> selectScaleC01ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return scaleC01DeviceMessageMapper.selectScaleC01ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
    }

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

    @Override
    public DataTablePageing selectHisScaleC01ByDateAndIDsAndPageAndThreshold(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String sMaxThreshold, String sMinThreshold, String sStartAge, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        sStartDate = sStartDate.substring(0, 10);
        sEndDate = sEndDate.substring(0, 10);
        List<ScaleC01DeviceMessage> deviceMessageList = scaleC01DeviceMessageMapper.selectScaleC01ByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
        //获取每个设备的数据(设备，设备数据)
        Map<String, List<ScaleC01DeviceMessage>> scaleC01MapByIds = this.splitMsgByIds(deviceMessageList, sDeviceIds);
        //重新整合每个设备的数据(去除阈值，去除0)
        //多个设备-按日期划分数据-并计算设备的单日的数据(设备，日期数据)
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = this.splitMsgByDate(scaleC01MapByIds, sMaxThreshold, sMinThreshold);
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
        }
        return dataTablePageing;
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

    //************************************私有函数********************************************//
    private List<ScaleC01DeviceMessage> judgeDeviceOnlineState(List<ScaleC01DeviceMessage> scaleC01DeviceMessageList, int offline) throws Exception {
        for (BaseDeviceMessage baseDeviceMessage : scaleC01DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage, offline);
        }
        return scaleC01DeviceMessageList;
    }

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

    //以设备为单位-按照日期把数据进行划分
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
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = new ArrayList<>();
        //获取日期
        List<String> dateList = ScaleC01Util.getParameterDate(scaleC01DeviceMessageList);
        //根据日期获取对象集合
        Map<String, List<ScaleC01DeviceMessage>> scaleMsgByDate = this.splitDeviceMsgByDate(dateList, scaleC01DeviceMessageList);
        scaleC01WtAnalysisList = formatWtAnalysis(scaleMsgByDate, sMaxThreshold, sMinThreshold);
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

    //生成有效上鸡数量、平均体重、鸡群均匀度集合
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

    //生成有效体重报表
    private DataTablePageing getScaleC01EffectivePaging(List<ScaleC01WtAnalysis> scaleC01WtAnalyses, Integer pageNumber, Integer pageSize) {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<ScaleC01EffectiveWt> scaleC01EffectiveWtListAll = this.getScaleC01EffWt(scaleC01WtAnalyses);
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
    private List<ScaleC01EffectiveWt> getScaleC01EffWt(List<ScaleC01WtAnalysis> scaleC01WtAnalyses) {
        List<ScaleC01EffectiveWt> scaleC01EffectiveWtList = new ArrayList<>();
        List<Integer> scaleC01WtList = new ArrayList<>();
        for (ScaleC01WtAnalysis scaleC01WtAnalysis : scaleC01WtAnalyses
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

    //多设备平均体重 生成报表
    private DataTablePageing getScaleC01AvgWt(List<MydataTableColumn> tableColumnList, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate, Integer pageNumber, Integer pageSize) throws Exception {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<List<OneDataDetail>> dataDetailList = getDataDetailListByParam(tableColumnList, scaleC01MapByDate);
        dataTablePageing = EC01DeviceMessageServiceImpl.getDataTableAndPageing(pageNumber, pageSize, dataDetailList);
        return dataTablePageing;
    }

    //生成报表的每一行元素
    private List<List<OneDataDetail>> getDataDetailListByParam(List<MydataTableColumn> tableColumnList, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
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

    //生成增重日龄报表
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
        for (int i = 1; i < scaleC01WtAnalysisList.size(); i++) {
            scaleC01WtAnalysisList.get(i).setGainWt(scaleC01WtAnalysisList.get(i).getAvgWt() - scaleC01WtAnalysisOld.getAvgWt());
            int dAge = ScaleC01Util.getDAge(scaleC01WtAnalysisList.get(i).getsDate(), scaleC01WtAnalysisOld.getsDate());
            scaleC01WtAnalysisList.get(i).setDayAge(scaleC01WtAnalysisOld.getDayAge() + dAge);
            scaleC01WtAnalysisOld = scaleC01WtAnalysisList.get(i);
        }
        return scaleC01WtAnalysisList;
    }
}
