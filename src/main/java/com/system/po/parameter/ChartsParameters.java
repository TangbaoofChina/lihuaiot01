package com.system.po.parameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartsParameters {
    private List<ParameterData> dParameterdata;
    private List<String> dParameterTime;
    private List<String> dParameterName;

    private String min;
    private String max;

    public List<ParameterData> getdParameterdata() {
        return dParameterdata;
    }

    public void setdParameterdata(List<ParameterData> dParameterdata) {
        this.dParameterdata = dParameterdata;
    }

    public List<String> getdParameterTime() {
        return dParameterTime;
    }

    public void setdParameterTime(List<String> dParameterTime) {
        this.dParameterTime = dParameterTime;
    }

    public List<String> getdParameterName() {
        return dParameterName;
    }

    public void setdParameterName(List<String> dParameterName) {
        this.dParameterName = dParameterName;
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

    public ChartsParameters(List<String> deviceParameterName, List<ParameterData> parameterDataList, List<String> deviceParameterTime) {
        this.dParameterdata = parameterDataList;
        List<String> maxValues = new ArrayList<>();
        List<String> minValues = new ArrayList<>();
        for (ParameterData parameterData : parameterDataList
                ) {
            maxValues.add(parameterData.getMaxValue());
            minValues.add(parameterData.getMinValue());
        }
        this.max = Collections.max(maxValues);
        this.min = Collections.min(minValues);
        this.dParameterName = deviceParameterName;
        this.dParameterTime = deviceParameterTime;
    }
}
