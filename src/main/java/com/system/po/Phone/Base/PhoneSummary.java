package com.system.po.Phone.Base;

import java.util.List;

/**
 * 手机端：概要信息对象 20190815
 */
public class PhoneSummary {
    private String devNum;
    private String title;
    private String state;
    private String senddate;
    private List<PhoneOneData> data;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSenddate() {
        return senddate;
    }

    public void setSenddate(String senddate) {
        this.senddate = senddate;
    }

    public List<PhoneOneData> getData() {
        return data;
    }

    public void setData(List<PhoneOneData> data) {
        this.data = data;
    }
}
