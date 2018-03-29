package com.system.po;

public class BaseDeviceMessage {
    private String dSerialNum;
    private String dName;
    private String dReceiveTime;
    private String dState = "在线";

    public String getDSerialNum() {
        return dSerialNum;
    }

    public void setDSerialNum(String dSerialNum) {
        this.dSerialNum = dSerialNum;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getDReceiveTime() {
        return dReceiveTime;
    }

    public void setDReceiveTime(String dReceiveTime) {
        this.dReceiveTime = dReceiveTime;
    }

    public String getDState() {
        return dState;
    }

    public void setDState(String dState) {
        this.dState = dState;
    }
}
