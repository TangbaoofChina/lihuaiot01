package com.system.po.Phone.Base;

import java.util.List;

public class PhoneHis {
    private String dName;
    private String dSerialNum;
    private List<PhoneHisDataHead> phoneHisDataHeadList;
    private List<PhoneHisDataContent> phoneHisDataContentList;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdSerialNum() {
        return dSerialNum;
    }

    public void setdSerialNum(String dSerialNum) {
        this.dSerialNum = dSerialNum;
    }

    public List<PhoneHisDataHead> getPhoneHisDataHeadList() {
        return phoneHisDataHeadList;
    }

    public void setPhoneHisDataHeadList(List<PhoneHisDataHead> phoneHisDataHeadList) {
        this.phoneHisDataHeadList = phoneHisDataHeadList;
    }

    public List<PhoneHisDataContent> getPhoneHisDataContentList() {
        return phoneHisDataContentList;
    }

    public void setPhoneHisDataContentList(List<PhoneHisDataContent> phoneHisDataContentList) {
        this.phoneHisDataContentList = phoneHisDataContentList;
    }
}
