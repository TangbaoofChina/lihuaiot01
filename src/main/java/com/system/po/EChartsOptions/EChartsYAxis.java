package com.system.po.EChartsOptions;

import com.system.po.EC01.EC01DeviceDayAvgTemp;
import com.system.po.EC01.EC01DeviceDayWater;
import com.system.po.EChartsOptions.EChartsParts.ECAxisLabel;
import com.system.po.EChartsOptions.EChartsParts.ECAxisLine;
import com.system.po.EChartsOptions.EChartsParts.ECLineStyle;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

public class EChartsYAxis {
    private String name;
    private String position;
    private String offset;
    private ECAxisLine axisLine;
    private ECAxisLabel axisLabel;
    private String splitNumber;
    private String interval;
    private String minInterval;
    private String min;
    private String max;
    private String type;
    private EcSplitLine splitLine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public ECAxisLine getAxisLine() {
        return axisLine;
    }

    public void setAxisLine(ECAxisLine axisLine) {
        this.axisLine = axisLine;
    }

    public ECAxisLabel getAxisLabel() {
        return axisLabel;
    }

    public void setAxisLabel(ECAxisLabel axisLabel) {
        this.axisLabel = axisLabel;
    }

    public String getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(String splitNumber) {
        this.splitNumber = splitNumber;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getMinInterval() {
        return minInterval;
    }

    public void setMinInterval(String minInterval) {
        this.minInterval = minInterval;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EcSplitLine getSplitLine() {
        return splitLine;
    }

    public void setSplitLine(EcSplitLine splitLine) {
        this.splitLine = splitLine;
    }

    public EChartsYAxis() {
    }

    public EChartsYAxis(EC01DeviceDayAvgTemp ec01DeviceDayAvgTemp) {
        this.setName("日温");
        this.setPosition("left");
        this.setType("value");
        this.setSplitNumber("10");

        this.setMin(String.valueOf((int) (Float.parseFloat(ec01DeviceDayAvgTemp.getMin()) - 3)));
        String sMax = String.valueOf((int) (Float.parseFloat(ec01DeviceDayAvgTemp.getMax()) + 3));
        ECAxisLine ecAxisLine = new ECAxisLine();
        ECLineStyle ecLineStyle = new ECLineStyle();
        ecLineStyle.setColor("#FF6347");
        ecLineStyle.setColor("#FF6347");
        ecAxisLine.setLineStyle(ecLineStyle);
        this.setAxisLine(ecAxisLine);

        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} °C");
        this.setAxisLabel(ecAxisLabel);

        EcSplitLine ecySplitLine = new EcSplitLine();
        this.setSplitLine(ecySplitLine);

        this.setInterval(DataConvertor.findInterval(sMax, this.getMin(), this.getSplitNumber()));

        this.setMax(DataConvertor.findMaxValue(this.getMin(), this.getInterval(), this.getSplitNumber()));

    }

    public EChartsYAxis(List<EC01DeviceDayWater> ec01DeviceDayWaterList, String position) {
        this.setName("饮水量");
        this.setPosition(position);
        this.setType("value");
        this.setSplitNumber("10");

        ECAxisLine ecAxisLine = new ECAxisLine();
        ECLineStyle ecLineStyle = new ECLineStyle();
        ecLineStyle.setColor("#675bba");
        ecAxisLine.setLineStyle(ecLineStyle);
        this.setAxisLine(ecAxisLine);

        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} m³");
        this.setAxisLabel(ecAxisLabel);

        EcSplitLine ecySplitLine = new EcSplitLine();
        this.setSplitLine(ecySplitLine);
        List<String> maxValues = new ArrayList<>();
        List<String> minValues = new ArrayList<>();
        for (EC01DeviceDayWater ec01DeviceDayWater : ec01DeviceDayWaterList
                ) {
            maxValues.add(ec01DeviceDayWater.getMax());
            minValues.add(ec01DeviceDayWater.getMin());
        }
        String sMax = String.valueOf((int) (Float.parseFloat(DataConvertor.findMaxValue(maxValues)) + 3));
        this.setMin(String.valueOf((int) (Float.parseFloat(DataConvertor.findMinValue(minValues)) - 3)));
        this.setInterval(DataConvertor.findInterval(sMax, this.getMin(), this.getSplitNumber()));
        this.setMax(DataConvertor.findMaxValue(this.getMin(), this.getInterval(), this.getSplitNumber()));

    }
}
