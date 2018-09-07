package com.system.po.EChartsOptions;

public class EChartsTooltip {
    private String trigger = "axis";
    private String formatter;

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
}
