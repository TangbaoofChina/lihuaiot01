package com.system.po.EC01;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.parameter.ParameterData;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EC01DeviceDayAvgTemp extends BaseDeviceMessage {
    private List<EC01DayAvgTemp> ec01DayAvgTempList;
    private String min;
    private String max;

    public List<EC01DayAvgTemp> getEc01DayAvgTempList() {
        return ec01DayAvgTempList;
    }

    public void setEc01DayAvgTempList(List<EC01DayAvgTemp> ec01DayAvgTempList) {
        this.ec01DayAvgTempList = ec01DayAvgTempList;
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

    public EC01DeviceDayAvgTemp() {
    }

    public EC01DeviceDayAvgTemp(DeviceInfo deviceInfo, List<EC01DayAvgTemp> ec01DayAvgTemps) {
        this.setDSerialNum(deviceInfo.getDSerialNum());
        this.setDName(deviceInfo.getDName());
        List<String> maxValues = new ArrayList<>();
        List<String> minValues = new ArrayList<>();
        //取出年-月-日
        for (EC01DayAvgTemp ec01DayAvgTemp : ec01DayAvgTemps
                ) {
            String sendDate = ec01DayAvgTemp.getSendDate();
            ec01DayAvgTemp.setSendDate(sendDate.substring(0, 10));
            maxValues.add(String.valueOf(ec01DayAvgTemp.getAvgTemp()));
            minValues.add(String.valueOf(ec01DayAvgTemp.getAvgTemp()));
        }
        this.setEc01DayAvgTempList(ec01DayAvgTemps);
        this.setMax(DataConvertor.findMaxValue(maxValues));
        this.setMin(DataConvertor.findMinValue(minValues));
    }
}
