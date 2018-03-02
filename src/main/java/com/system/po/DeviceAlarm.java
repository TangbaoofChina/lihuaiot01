package com.system.po;

public class DeviceAlarm {
    private String sid;

    private EC01DeviceMessage ec01DeviceMessage;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public EC01DeviceMessage getEc01DeviceMessage() {
        return ec01DeviceMessage;
    }

    public void setEc01DeviceMessage(EC01DeviceMessage ec01DeviceMessage) {
        this.ec01DeviceMessage = ec01DeviceMessage;
    }
}
