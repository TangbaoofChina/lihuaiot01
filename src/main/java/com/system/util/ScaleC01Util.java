package com.system.util;

import com.mysql.jdbc.StringUtils;
import com.system.po.Device.ScaleC01DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.MydataTableColumn;
import com.system.po.ScaleC01.ScaleC01WtAnalysis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScaleC01Util {

    //多台秤日平均体重
    public static List<MydataTableColumn> getScaleC01DeviceHead(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        if (deviceInfoList.size() > 0) {
            for (DeviceInfo deviceInfo : deviceInfoList
                    ) {
                MydataTableColumn mdtc = new MydataTableColumn();
                mdtc.setData(deviceInfo.getDSerialNum());
                mdtc.setTitle(deviceInfo.getDName() + "-均重");
                myDTCList.add(mdtc);
            }
        }

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sDate");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("时间");
        myDTCList.add(mdtcTime);

        return myDTCList;
    }

    //有效上鸡数量、平均体重、鸡群均匀度
    public static List<MydataTableColumn> getScaleC01WtAnalysis(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc01 = new MydataTableColumn();
        mdtc01.setData("count");
        mdtc01.setTitle("上鸡数量");
        myDTCList.add(mdtc01);

        MydataTableColumn mdtc02 = new MydataTableColumn();
        mdtc02.setData("avgWt");
        mdtc02.setTitle("平均体重");
        myDTCList.add(mdtc02);

        MydataTableColumn mdtc03 = new MydataTableColumn();
        mdtc03.setData("uniformity");
        mdtc03.setTitle("均匀度");
        myDTCList.add(mdtc03);

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sDate");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("时间");
        myDTCList.add(mdtcTime);

        return myDTCList;
    }

    //有效体重
    public static List<MydataTableColumn> getScaleC01EffectiveWt(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        for (int i = 1; i < 10; i++) {
            MydataTableColumn mdtc01 = new MydataTableColumn();
            mdtc01.setData("weight0" + String.valueOf(i));
            mdtc01.setTitle("体重0" + String.valueOf(i));
            myDTCList.add(mdtc01);
        }

        return myDTCList;
    }

    //增重日龄
    public static List<MydataTableColumn> getScaleC01WtAge(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc01 = new MydataTableColumn();
        mdtc01.setData("avgWt");
        mdtc01.setTitle("均重");
        myDTCList.add(mdtc01);

        MydataTableColumn mdtc02 = new MydataTableColumn();
        mdtc02.setData("gainWt");
        mdtc02.setTitle("增重");
        myDTCList.add(mdtc02);

        MydataTableColumn mdtc03 = new MydataTableColumn();
        mdtc03.setData("dayAge");
        mdtc03.setTitle("日龄");
        myDTCList.add(mdtc03);

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sDate");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("时间");
        myDTCList.add(mdtcTime);

        return myDTCList;
    }

    //多增重日龄
    public static List<MydataTableColumn> getScaleC01sWtAge(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        for (int i = 0; i < deviceInfoList.size(); i++) {
            MydataTableColumn mdtc = new MydataTableColumn();
            mdtc.setData(deviceInfoList.get(i).getDSerialNum());
            mdtc.setTitle(deviceInfoList.get(i).getDName() + "-增重");
            myDTCList.add(mdtc);
        }

        MydataTableColumn mdtc01 = new MydataTableColumn();
        mdtc01.setData("dayAge");
        mdtc01.setTitle("日龄");
        myDTCList.add(mdtc01);

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sDate");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("时间");
        myDTCList.add(mdtcTime);

        return myDTCList;
    }

    public static List<MydataTableColumn> getMyDataTableColumn(String sQueryParam, List<DeviceInfo> deviceInfoList,
                                                               String[] sDateTimeList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<>();
        if (sQueryParam.equals("称重分析")) {
            myDTCList = ScaleC01Util.getScaleC01WtAnalysis(deviceInfoList);
        } else if (sQueryParam.equals("有效体重")) {
            myDTCList = ScaleC01Util.getScaleC01EffectiveWt(deviceInfoList);
        } else if (sQueryParam.equals("增重日龄")) {
            myDTCList = ScaleC01Util.getScaleC01WtAge(deviceInfoList);
        } else if (sQueryParam.equals("平均体重")) {
            myDTCList = ScaleC01Util.getScaleC01DeviceHead(deviceInfoList);
        } else if (sQueryParam.equals("多增重日龄")) {
            myDTCList = ScaleC01Util.getScaleC01sWtAge(deviceInfoList);
        } else {
            myDTCList = ScaleC01Util.getScaleC01DeviceHead(deviceInfoList);
        }
        return myDTCList;
    }

    //生成日期 由小到大排序
    public static List<String> getParameterDate(List<ScaleC01DeviceMessage> deviceMessageList) {
        List<String> deviceDateList = new ArrayList<String>();
        //日期序列生成
        for (ScaleC01DeviceMessage deviceMessage : deviceMessageList
                ) {
            if (deviceDateList.contains(deviceMessage.getDReceiveTime().substring(0, 10))) {
                continue;
            } else {
                deviceDateList.add(deviceMessage.getDReceiveTime().substring(0, 10));
            }
        }
        List<String> newDeviceDateList = dateSort01(deviceDateList);
        return newDeviceDateList;
    }

    //获取对象的value值，去除0值
    public static List<Integer> getScaleC01WtsZero(ScaleC01DeviceMessage msg) {
        List<Integer> iDataList = new ArrayList<>();
        if (msg.getWeight01() > 0) {
            iDataList.add(msg.getWeight01());
        }
        if (msg.getWeight02() > 0) {
            iDataList.add(msg.getWeight02());
        }
        if (msg.getWeight03() > 0) {
            iDataList.add(msg.getWeight03());
        }
        if (msg.getWeight04() > 0) {
            iDataList.add(msg.getWeight04());
        }
        if (msg.getWeight05() > 0) {
            iDataList.add(msg.getWeight05());
        }
        if (msg.getWeight06() > 0) {
            iDataList.add(msg.getWeight06());
        }
        if (msg.getWeight07() > 0) {
            iDataList.add(msg.getWeight07());
        }
        if (msg.getWeight08() > 0) {
            iDataList.add(msg.getWeight08());
        }
        if (msg.getWeight09() > 0) {
            iDataList.add(msg.getWeight09());
        }
        if (msg.getWeight10() > 0) {
            iDataList.add(msg.getWeight10());
        }
        if (msg.getWeight11() > 0) {
            iDataList.add(msg.getWeight11());
        }
        if (msg.getWeight12() > 0) {
            iDataList.add(msg.getWeight12());
        }
        if (msg.getWeight13() > 0) {
            iDataList.add(msg.getWeight13());
        }
        if (msg.getWeight14() > 0) {
            iDataList.add(msg.getWeight14());
        }
        if (msg.getWeight15() > 0) {
            iDataList.add(msg.getWeight15());
        }
        if (msg.getWeight16() > 0) {
            iDataList.add(msg.getWeight16());
        }
        if (msg.getWeight17() > 0) {
            iDataList.add(msg.getWeight17());
        }
        if (msg.getWeight18() > 0) {
            iDataList.add(msg.getWeight18());
        }
        if (msg.getWeight19() > 0) {
            iDataList.add(msg.getWeight19());
        }
        if (msg.getWeight20() > 0) {
            iDataList.add(msg.getWeight20());
        }
        return iDataList;
    }

    //获取对象的value值，去除最大阈值和最小阈值
    public static List<Integer> getScaleC01WtsThreshold(List<Integer> iDataList, String sMaxThreshold, String sMinThreshold) {
        List<Integer> iDateListThreshold = new ArrayList<>();
        if (!StringUtils.isNullOrEmpty(sMaxThreshold) && !StringUtils.isNullOrEmpty(sMinThreshold)) {
            int iMaxThreshold = Integer.valueOf(sMaxThreshold);
            int iMinThreshold = Integer.valueOf(sMinThreshold);
            for (int i = 0; i < iDataList.size(); i++) {
                if (iDataList.get(i) >= iMinThreshold && iDataList.get(i) <= iMaxThreshold) {
                    iDateListThreshold.add(iDataList.get(i));
                }
            }
        } else if (!StringUtils.isNullOrEmpty(sMinThreshold)) {
            int iMinThreshold = Integer.valueOf(sMinThreshold);
            for (int i = 0; i < iDataList.size(); i++) {
                if (iDataList.get(i) >= iMinThreshold) {
                    iDateListThreshold.add(iDataList.get(i));
                }
            }
        } else if (!StringUtils.isNullOrEmpty(sMaxThreshold)) {
            int iMaxThreshold = Integer.valueOf(sMaxThreshold);
            for (int i = 0; i < iDataList.size(); i++) {
                if (iDataList.get(i) <= iMaxThreshold) {
                    iDateListThreshold.add(iDataList.get(i));
                }
            }
        } else {
            iDateListThreshold.addAll(iDataList);
        }
        return iDateListThreshold;
    }

    //根据数值，计算平均体重
    public static float getScaleC01AvgWt(List<Integer> iDataList) {
        Long lWt = (long) 0;
        for (int i = 0; i < iDataList.size(); i++) {
            lWt = lWt + iDataList.get(i);
        }
        float fWt = 0;
        if (iDataList.size() > 0) {
            fWt = (float) lWt / iDataList.size();
        }
        return DataConvertor.formatFloat(fWt, 2);
    }

    //根据数值，计算均匀度
    public static float getScaleC01Uniformity(float avgWt, List<Integer> iDataList) {
        float fUniformity = 0.0f;
        float count = iDataList.size();
        double highWt = avgWt + avgWt * 0.1;
        double lowWt = avgWt - avgWt * 0.1;
        if (lowWt < 0) {
            lowWt = 0;
        }
        float exCount = 0;
        for (int i = 0; i < count; i++) {
            if (highWt > iDataList.get(i) && iDataList.get(i) > lowWt) {
                exCount = exCount + 1;
            }
        }
        if (count > 0) {
            fUniformity = exCount / count;
        }
        return DataConvertor.formatFloat(fUniformity, 2);
    }

    //根据设备日期分类，先获取日期list，为多台秤日均重报表服务
    public static List<String> getScaleC01DateList(Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<ScaleC01WtAnalysis>> entry : scaleC01MapByDate.entrySet()) {
            for (ScaleC01WtAnalysis scaleC01WtAnalysis : entry.getValue()
                    ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(scaleC01WtAnalysis.getsDate())) {
                    sDateList.add(scaleC01WtAnalysis.getsDate());
                }
            }
        }
        List<String> newDateList = dateSort01(sDateList);
        return newDateList;
    }

    //获取单设备日期list，为增重日龄报表服务
    public static List<String> getScaleC01DataList(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        List<String> sDateList = new ArrayList<>();
        for (ScaleC01WtAnalysis scaleC01WtAnalysis : scaleC01WtAnalysisList
                ) {
            if (!sDateList.contains(scaleC01WtAnalysis.getsDate())) {
                sDateList.add(scaleC01WtAnalysis.getsDate());
            }
        }
        //日期排序 从小到大
        List<String> newDateList = dateSort01(sDateList);
        return newDateList;
    }

    //计算日龄
    public static Integer getDAge(String endDate, String startDate) {
        long dTime = DataConvertor.DateCompare(endDate, startDate);
        long day = dTime / (24 * 60 * 60 * 1000);
        return (int) day;
    }

    //根据起始日龄，根据日期列表，计算出日龄列表
    public static List<String> getDayAgeList(String sStartAge, List<String> sDateList) {
        List<String> dayAgeList = new ArrayList<>();
        if (sDateList == null || sDateList.size() < 1) {
            return dayAgeList;
        }
        if (StringUtils.isNullOrEmpty(sStartAge)) {
            sStartAge = "0";
        }
        if (sDateList.size() < 2) {
            dayAgeList.add(sStartAge);
            return dayAgeList;
        }
        dayAgeList.add(sStartAge);
        sDateList = dateSort01(sDateList);
        String oldDate = sDateList.get(0);
        int oldAge = Integer.valueOf(sStartAge);
        for (int i = 1; i < sDateList.size(); i++) {
            int dAge = ScaleC01Util.getDAge(sDateList.get(i), oldDate);
            dayAgeList.add(String.valueOf(oldAge + dAge));
            oldDate = sDateList.get(i);
            oldAge = oldAge + dAge;
        }
        return dayAgeList;
    }

    public static List<ScaleC01WtAnalysis>  scaleC01WtAnalysisSort(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList){
        List<ScaleC01WtAnalysis> scaleC01WtAnalysisList01 = new ArrayList<ScaleC01WtAnalysis>();
        List<String> sDateList = getScaleC01DataList(scaleC01WtAnalysisList);
        for (String sDate:sDateList  //根据日期，对list进行重新排序
                ) {
            for(int i=0;i<scaleC01WtAnalysisList.size();i++){
                if(sDate.equals(scaleC01WtAnalysisList.get(i).getsDate())){
                    scaleC01WtAnalysisList01.add(scaleC01WtAnalysisList.get(i));
                }
            }
        }
        return scaleC01WtAnalysisList01;
    }


    //日期排序 yyyy-MM-dd   日期从小到大排序
    public static List<String> dateSort01(List<String> sDateList){
        List<String> newDateList = new ArrayList<String>();
        for (int i = 0; i < sDateList.size(); i++) {
            if (!newDateList.contains(sDateList.get(i))) {
                newDateList.add(sDateList.get(i));
            }
        }
        String tmp;
        for (int i = 1; i < newDateList.size(); i++) {
            tmp = newDateList.get(i);
            int j = i - 1;
            for (; j >= 0 && (DataConvertor.DateCompare(tmp, newDateList.get(j)) < 0); j--) {
                newDateList.set(j + 1, newDateList.get(j));
            }
            newDateList.set(j + 1, tmp);
        }
        return newDateList;
    }
}
