package com.system.po.Phone.Base;

import java.util.List;

public class PhoneDetail {
    private String devNum;
    private String devName;
    private List<PhonePartDetail> phonePartDetailList;

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

    public List<PhonePartDetail> getPhonePartDetailList() {
        return phonePartDetailList;
    }

    public void setPhonePartDetailList(List<PhonePartDetail> phonePartDetailList) {
        this.phonePartDetailList = phonePartDetailList;
    }
}
