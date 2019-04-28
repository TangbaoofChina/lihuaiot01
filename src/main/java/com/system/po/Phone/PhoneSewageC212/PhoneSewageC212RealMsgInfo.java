package com.system.po.Phone.PhoneSewageC212;

import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;

import java.util.List;

public class PhoneSewageC212RealMsgInfo {
    private String devNum;
    private String devName;
    private List<PhoneSewageC212RealData> phoneSewageC212RealDataList;

    public String getDevNum() {
        return devNum;
    }

    public void setDevNum(String devNum) {
        this.devNum = devNum;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public List<PhoneSewageC212RealData> getPhoneSewageC212RealDataList() {
        return phoneSewageC212RealDataList;
    }

    public void setPhoneSewageC212RealDataList(List<PhoneSewageC212RealData> phoneSewageC212RealDataList) {
        this.phoneSewageC212RealDataList = phoneSewageC212RealDataList;
    }
}
