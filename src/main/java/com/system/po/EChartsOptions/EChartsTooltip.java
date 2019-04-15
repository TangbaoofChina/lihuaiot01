package com.system.po.EChartsOptions;

import com.system.po.EChartsOptions.EChartTtip.EcttipAxisPointer;

public class EChartsTooltip {
    private String trigger = "axis";
    private String formatter;
    private EcttipAxisPointer axisPointer;

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public EcttipAxisPointer getAxisPointer() {
        return axisPointer;
    }

    public void setAxisPointer(EcttipAxisPointer axisPointer) {
        this.axisPointer = axisPointer;
    }
}
