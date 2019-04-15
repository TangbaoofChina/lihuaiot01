package com.system.po;

import com.system.util.DataConvertor;

public class DeviceInfo {
    private String dSerialNum;
    private String dSerialNumDec;
    private String dName = "";
    private String dIp = "";
    private String dPort = "";
    private String dDevType = "";
    private String dProtocol = "";
    private String dSendTime = "";
    private String dReceiveTime = "";
    private String dState = "";
    private String dEasFId = "";
    private String dEasFName = "";
    private String dEasFDisplayName = "";
    private boolean dDeactive = false;  //是否停用

    //get后面首字母大写，否则不符合json规则
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
            return DataConvertor.ConvertHexToDec(dSerialNumDec, 5);
    }

    public void setDSerialNumDec(String dSerialNumDec) {
        this.dSerialNumDec = dSerialNumDec;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getDIp() {
        return dIp;
    }

    public void setDIp(String dIp) {
        this.dIp = dIp;
    }

    public String getDPort() {
        return dPort;
    }

    public void setDPort(String dPort) {
        this.dPort = dPort;
    }

    public String getDProtocol() {
        return dProtocol;
    }

    public void setDProtocol(String dProtocol) {
        this.dProtocol = dProtocol;
    }

    public String getDSendTime() {
        return dSendTime;
    }

    public void setDSendTime(String dSendTime) {
        this.dSendTime = dSendTime;
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

    public String getDDevType() {
        return dDevType;
    }

    public void setDDevType(String dDevType) {
        this.dDevType = dDevType;
    }

    public String getDEasFId() {
        return dEasFId;
    }

    public void setDEasFId(String dEasFId) {
        this.dEasFId = dEasFId;
    }

    public String getDEasFName() {
        return dEasFName;
    }

    public void setDEasFName(String dEasFName) {
        this.dEasFName = dEasFName;
    }

    public String getDEasFDisplayName() {
        return dEasFDisplayName;
    }

    public void setDEasFDisplayName(String dEasFDisplayName) {
        this.dEasFDisplayName = dEasFDisplayName;
    }

    public boolean isDDeactive() {
        return dDeactive;
    }

    public void setDDeactive(boolean dDeactive) {
        this.dDeactive = dDeactive;
    }
}
