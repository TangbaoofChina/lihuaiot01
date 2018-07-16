package com.system.po.EChartsOptions;

import java.util.List;

public class EChartsXAxis {
    private List<String> data;
    private EcSplitLine splitLine;

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
}
