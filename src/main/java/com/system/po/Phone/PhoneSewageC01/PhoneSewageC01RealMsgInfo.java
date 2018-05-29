package com.system.po.Phone.PhoneSewageC01;

import java.util.List;

public class PhoneSewageC01RealMsgInfo {
    private String devNum;
    private String devName;
    private List<PhoneSewageC01RealData> phoneSewageC01RealDataList;

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

    public List<PhoneSewageC01RealData> getPhoneSewageC01RealDataList() {
        return phoneSewageC01RealDataList;
    }

    public void setPhoneSewageC01RealDataList(List<PhoneSewageC01RealData> phoneSewageC01RealDataList) {
        this.phoneSewageC01RealDataList = phoneSewageC01RealDataList;
    }
}
