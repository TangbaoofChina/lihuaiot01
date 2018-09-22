package com.system.po.parameter;

import com.system.po.EChartsOptions.EcsMarkLine;
import com.system.po.EChartsOptions.EcsMarkPoint;

import java.util.ArrayList;
import java.util.List;

public class ParameterBase {
    private String name;
    private String type = "line";
    private String yAxisIndex = "0";
    private String connectNulls = "true";
    private String symbol = "circle";//拐点样式
    private int symbolSize = 8;//拐点大小
    private Boolean showAllSymbol = true; //是否显示拐点
    private EcsMarkPoint markPoint;
    private EcsMarkLine markLine;

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

    public String getyAxisIndex() {
        return yAxisIndex;
    }

    public void setyAxisIndex(String yAxisIndex) {
        this.yAxisIndex = yAxisIndex;
    }

    public String getConnectNulls() {
        return connectNulls;
    }

    public void setConnectNulls(String connectNulls) {
        this.connectNulls = connectNulls;
    }

    public EcsMarkPoint getMarkPoint() {
        return markPoint;
    }

    public void setMarkPoint(EcsMarkPoint markPoint) {
        this.markPoint = markPoint;
    }

    public EcsMarkLine getMarkLine() {
        return markLine;
    }

    public void setMarkLine(EcsMarkLine markLine) {
        this.markLine = markLine;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getSymbolSize() {
        return symbolSize;
    }

    public void setSymbolSize(int symbolSize) {
        this.symbolSize = symbolSize;
    }

    public Boolean getShowAllSymbol() {
        return showAllSymbol;
    }

    public void setShowAllSymbol(Boolean showAllSymbol) {
        this.showAllSymbol = showAllSymbol;
    }
}
