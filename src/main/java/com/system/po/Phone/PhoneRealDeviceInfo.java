package com.system.po.Phone;

import java.util.List;

public class PhoneRealDeviceInfo {
    private String devNum;
    private String title;
    private List<PhoneRealMsgInfo> data;

    public String getDevNum() {
        return devNum;
    }

    public void setDevNum(String devNum) {
        this.devNum = devNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PhoneRealMsgInfo> getData() {
        return data;
    }

    public void setData(List<PhoneRealMsgInfo> data) {
        this.data = data;
    }
}
