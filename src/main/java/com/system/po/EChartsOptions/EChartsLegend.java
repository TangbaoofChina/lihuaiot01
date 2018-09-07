package com.system.po.EChartsOptions;

import com.system.po.DeviceOfflineRate;

import java.util.ArrayList;
import java.util.List;

public class EChartsLegend {
    private List<String> data;
    private String bottom = "auto";
    private String left = "auto";

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

}
