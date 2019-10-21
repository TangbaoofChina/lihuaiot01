package com.system.po.Phone;

import java.util.List;

public class PhoneRealDeviceInfo {
    private String devNum;
    private String title;
    private String state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
