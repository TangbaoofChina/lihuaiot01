package com.system.po.parameter;

import com.system.po.EChartsOptions.EChartsYAxis;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChartsParameters {
    private List<ParameterData> dParameterdata;
    private List<String> dParameterTime;
    private List<String> dParameterName;
    private List<EChartsYAxis> yAxis;
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

    public List<EChartsYAxis> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<EChartsYAxis> yAxis) {
        this.yAxis = yAxis;
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
            maxValues.add(parameterData.findMaxValue());
            minValues.add(parameterData.findMinValue());
        }
        this.max = DataConvertor.findMaxValue(maxValues);
        this.min = DataConvertor.findMinValue(minValues);
        this.dParameterName = deviceParameterName;
        this.dParameterTime = deviceParameterTime;
    }
}
