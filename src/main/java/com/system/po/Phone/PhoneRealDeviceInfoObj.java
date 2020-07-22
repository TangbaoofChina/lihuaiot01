package com.system.po.Phone;

import java.util.List;

public class PhoneRealDeviceInfoObj {
    private String devNum;
    private String title;
    private String state;
    private List<PhoneRealMsgInfoObj> data;

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

    public List<PhoneRealMsgInfoObj> getData() {
        return data;
    }

    public void setData(List<PhoneRealMsgInfoObj> data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
