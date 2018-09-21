package com.system.po.ScaleC01;

import com.mysql.jdbc.StringUtils;
import com.system.po.Device.ScaleC01DeviceMessage;
import com.system.po.parameter.OneDataDetail;
import com.system.util.ScaleC01Util;

import java.util.ArrayList;
import java.util.List;

public class ScaleC01WtAnalysis {
    private int count; //上鸡数量
    private float avgWt;  //平均体重
    private float gainWt; //日增重
    private int dayAge;   //日龄
    private float uniformity;  //均匀度
    private String sDate; //日期
    private List<Integer> iDataList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getAvgWt() {
        return avgWt;
    }

    public void setAvgWt(float avgWt) {
        this.avgWt = avgWt;
    }

    public float getGainWt() {
        return gainWt;
    }

    public void setGainWt(float gainWt) {
        this.gainWt = gainWt;
    }

    public int getDayAge() {
        return dayAge;
    }

    public void setDayAge(int dayAge) {
        this.dayAge = dayAge;
    }

    public float getUniformity() {
        return uniformity;
    }

    public void setUniformity(float uniformity) {
        this.uniformity = uniformity;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public List<Integer> getiDataList() {
        return iDataList;
    }

    public void setiDataList(List<Integer> iDataList) {
        this.iDataList = iDataList;
    }

    public ScaleC01WtAnalysis() {
    }

    public ScaleC01WtAnalysis(String sDate, List<ScaleC01DeviceMessage> scaleC01DeviceMessageList, String sMaxThreshold, String sMinThreshold) {
        this.setsDate(sDate);
        List<Integer> iDataList = new ArrayList<>();
        for (ScaleC01DeviceMessage msg : scaleC01DeviceMessageList
                ) {
            //去除0
            List<Integer> iDataListZero = ScaleC01Util.getScaleC01WtsZero(msg);
            //去除阈值
            List<Integer> iDataListThreshold = ScaleC01Util.getScaleC01WtsThreshold(iDataListZero, sMaxThreshold, sMinThreshold);
            iDataList.addAll(iDataListThreshold);
        }
        this.setiDataList(iDataList);
        this.setCount(iDataList.size());
        this.setAvgWt(ScaleC01Util.getScaleC01AvgWt(iDataList));
        this.setUniformity(ScaleC01Util.getScaleC01Uniformity(this.getAvgWt(), iDataList));
    }

    public List<OneDataDetail> getWtList() {
        OneDataDetail oneDataDetail01 = new OneDataDetail();
        oneDataDetail01.setName("count");
        oneDataDetail01.setValue(String.valueOf(getCount()));

        OneDataDetail oneDataDetail02 = new OneDataDetail();
        oneDataDetail02.setName("avgWt");
        oneDataDetail02.setValue(String.valueOf(getAvgWt()));

        OneDataDetail oneDataDetail03 = new OneDataDetail();
        oneDataDetail03.setName("uniformity");
        oneDataDetail03.setValue(String.valueOf(getUniformity()));

        OneDataDetail oneDataDetail04 = new OneDataDetail();
        oneDataDetail04.setName("sDate");
        oneDataDetail04.setValue(String.valueOf(getsDate()));

        List<OneDataDetail> oneDataDetailList = new ArrayList<>();
        oneDataDetailList.add(oneDataDetail01);
        oneDataDetailList.add(oneDataDetail02);
        oneDataDetailList.add(oneDataDetail03);
        oneDataDetailList.add(oneDataDetail04);
        return oneDataDetailList;
    }

    public List<OneDataDetail> getGainWtList() {
        OneDataDetail oneDataDetail01 = new OneDataDetail();
        oneDataDetail01.setName("avgWt");
        oneDataDetail01.setValue(String.valueOf(getAvgWt()));

        OneDataDetail oneDataDetail02 = new OneDataDetail();
        oneDataDetail02.setName("gainWt");
        oneDataDetail02.setValue(String.valueOf(getGainWt()));

        OneDataDetail oneDataDetail03 = new OneDataDetail();
        oneDataDetail03.setName("dayAge");
        oneDataDetail03.setValue(String.valueOf(getDayAge()));

        OneDataDetail oneDataDetail04 = new OneDataDetail();
        oneDataDetail04.setName("sDate");
        oneDataDetail04.setValue(String.valueOf(getsDate()));

        List<OneDataDetail> oneDataDetailList = new ArrayList<>();
        oneDataDetailList.add(oneDataDetail01);
        oneDataDetailList.add(oneDataDetail02);
        oneDataDetailList.add(oneDataDetail03);
        oneDataDetailList.add(oneDataDetail04);
        return oneDataDetailList;
    }
}
