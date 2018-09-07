package com.system.po.EChartsOptions;

import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;

import java.util.List;

public class EChartsXAxis {
    private List<String> data;
    private EcSplitLine splitLine;
    private ECxAxisAxisLabel axisLabel;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public EcSplitLine getSplitLine() {
        return splitLine;
    }

    public void setSplitLine(EcSplitLine splitLine) {
        this.splitLine = splitLine;
    }

    public ECxAxisAxisLabel getAxisLabel() {
        return axisLabel;
    }

    public void setAxisLabel(ECxAxisAxisLabel axisLabel) {
        this.axisLabel = axisLabel;
    }
}
