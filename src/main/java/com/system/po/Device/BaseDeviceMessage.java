package com.system.po.Device;

import com.system.util.DataConvertor;

public class BaseDeviceMessage{
    private String dSerialNum;
    private String dSerialNumDec;
    private String dName;
    private String dReceiveTime;
    private String dState = "在线";

    public String getDSerialNum() {
        return dSerialNum;
    }

    public void setDSerialNum(String dSerialNum) {
        this.dSerialNum = dSerialNum;
    }

    public String getDSerialNumDec() {
        if (dSerialNumDec.length() > 4)
            return dSerialNumDec;
        else
            return DataConvertor.convertHexToDec(dSerialNumDec, 5);
    }

    public void setdSerialNumDec(String dSerialNumDec) {
        this.dSerialNumDec = dSerialNumDec;
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
