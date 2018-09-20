package com.system.po.parameter;

public class DeviceType {
    private String sid;
    private String devType;
    private String devTypeDescribe;
    private int devTypeOffline;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getDevTypeDescribe() {
        return devTypeDescribe;
    }

    public void setDevTypeDescribe(String devTypeDescribe) {
        this.devTypeDescribe = devTypeDescribe;
    }

    public int getDevTypeOffline() {
        return devTypeOffline;
    }

    public void setDevTypeOffline(int devTypeOffline) {
        this.devTypeOffline = devTypeOffline;
    }
}
