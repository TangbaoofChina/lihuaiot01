package com.system.po.EChartsOptions.EChartsPie;

import java.util.ArrayList;
import java.util.List;

public class EChartsPieOneSerie {
    private String name;
    private String type="pie";
    private List<String> radius;
    private List<String> center;
    private String selectedMode="single";
    private List<EChartsPieOneSerieData> data;
    private EChartsPieItemStyle itemStyle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getRadius() {
        return radius;
    }

    public void setRadius(List<String> radius) {
        this.radius = radius;
    }

    public List<String> getCenter() {
        return center;
    }

    public void setCenter(List<String> center) {
        this.center = center;
    }

    public String getSelectedMode() {
        return selectedMode;
    }

    public void setSelectedMode(String selectedMode) {
        this.selectedMode = selectedMode;
    }

    public List<EChartsPieOneSerieData> getData() {
        return data;
    }

    public void setData(List<EChartsPieOneSerieData> data) {
        this.data = data;
    }

    public EChartsPieItemStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(EChartsPieItemStyle itemStyle) {
        this.itemStyle = itemStyle;
    }

    public EChartsPieOneSerie(){
        List<String> mRadius = new ArrayList<>();
        mRadius.add("0%");
        mRadius.add("65%");
        this.setRadius(mRadius);
        List<String> mCenter = new ArrayList<>();
        mCenter.add("50%");
        mCenter.add("50%");
        this.setCenter(mCenter);
        this.setItemStyle(new EChartsPieItemStyle());
    }
}
