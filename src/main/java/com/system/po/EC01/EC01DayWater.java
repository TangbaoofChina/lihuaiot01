package com.system.po.EC01;

import com.system.po.Device.EC01DeviceMessage;

public class EC01DayWater {
    private String sendDate;
    private float waterFlowVal;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public float getWaterFlowVal() {
        return waterFlowVal;
    }

    public void setWaterFlowVal(float waterFlowVal) {
        this.waterFlowVal = waterFlowVal;
    }

    public EC01DayWater() {
    }

    public EC01DayWater(EC01DeviceMessage ec01DeviceMessage) {
        this.setSendDate(ec01DeviceMessage.getSendDate().substring(0, 10));
        this.setWaterFlowVal(ec01DeviceMessage.getWaterFlowVal());
    }
}
