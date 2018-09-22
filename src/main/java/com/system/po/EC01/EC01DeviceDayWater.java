package com.system.po.EC01;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.EC01DeviceMessage;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EC01DeviceDayWater extends BaseDeviceMessage {
    private List<EC01DayWater> ec01DayWaterList;
    private String min;
    private String max;

    public List<EC01DayWater> getEc01DayWaterList() {
        return ec01DayWaterList;
    }

    public void setEc01DayWaterList(List<EC01DayWater> ec01DayWaterList) {
        this.ec01DayWaterList = ec01DayWaterList;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public EC01DeviceDayWater() {
    }

    public EC01DeviceDayWater(String dSerialNum, List<EC01DeviceMessage> ec01DeviceMessageList) {
        this.setDSerialNum(dSerialNum);
        List<EC01DayWater> ec01DayWaters = new ArrayList<>();
        List<String> maxValues = new ArrayList<>();
        List<String> minValues = new ArrayList<>();
        for (EC01DeviceMessage ec01DeviceMessage : ec01DeviceMessageList
                ) {
                this.setDName(ec01DeviceMessage.getDName());
                EC01DayWater ec01DayWater = new EC01DayWater(ec01DeviceMessage);
                ec01DayWaters.add(ec01DayWater);
                maxValues.add(String.valueOf(ec01DayWater.getWaterFlowVal()));
                minValues.add(String.valueOf(ec01DayWater.getWaterFlowVal()));
        }
        this.setEc01DayWaterList(ec01DayWaters);
        this.setMax(DataConvertor.findMaxValue(maxValues));
        this.setMin(DataConvertor.findMinValue(minValues));
    }
}
