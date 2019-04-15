package com.system.po.Phone;

import com.system.po.EChartsOptions.*;
import com.system.po.parameter.ParameterData;

import java.util.List;

public class PhoneEChartsOptionsY {
    private EChartsTitle title;
    private EChartsTooltip tooltip;
    private EChartsToolBox toolbox;
    private EChartsLegend legend;
    private EChartsXAxis xAxis;
    private List<EChartsYAxis> yAxis;
    private List<ParameterData> series;
    private String[] color;

    public EChartsTitle getTitle() {
        return title;
    }

    public void setTitle(EChartsTitle title) {
        this.title = title;
    }

    public EChartsTooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(EChartsTooltip tooltip) {
        this.tooltip = tooltip;
    }

    public EChartsToolBox getToolbox() {
        return toolbox;
    }

    public void setToolbox(EChartsToolBox toolbox) {
        this.toolbox = toolbox;
    }

    public EChartsLegend getLegend() {
        return legend;
    }

    public void setLegend(EChartsLegend legend) {
        this.legend = legend;
    }

    public EChartsXAxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(EChartsXAxis xAxis) {
        this.xAxis = xAxis;
    }

    public List<EChartsYAxis> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<EChartsYAxis> yAxis) {
        this.yAxis = yAxis;
    }

    public List<ParameterData> getSeries() {
        return series;
    }

    public void setSeries(List<ParameterData> series) {
        this.series = series;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public PhoneEChartsOptionsY() {
        this.setTooltip(new EChartsTooltip());
        this.setToolbox(new EChartsToolBox());
        String[] myColor = new String[2];
        myColor[0] = "#c23531";
        myColor[1] = "#2f4554";
        this.color = myColor;
    }

    public void showPoint(boolean showAvgPoint, boolean showMaxMinPoint) {
        if (showMaxMinPoint) {
            for (ParameterData parameterData : series
                    ) {
                parameterData.setMarkPoint(new EcsMarkPoint());
            }
        }
        if (showAvgPoint) {
            for (ParameterData parameterData : series
                    ) {
                parameterData.setMarkLine(new EcsMarkLine());
            }
        }
    }
}
