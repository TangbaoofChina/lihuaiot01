package com.system.po.EChartsOptions.EChartsPie;

import com.system.po.EChartsOptions.EChartsLegend;
import com.system.po.EChartsOptions.EChartsTitle;
import com.system.po.EChartsOptions.EChartsTooltip;

import java.util.List;

public class EChartsPieOptions {
    private EChartsTitle title;
    private EChartsTooltip tooltip;
    private EChartsLegend legend;
    private List<EChartsPieOneSerie> series;

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

    public EChartsLegend getLegend() {
        return legend;
    }

    public void setLegend(EChartsLegend legend) {
        this.legend = legend;
    }

    public List<EChartsPieOneSerie> getSeries() {
        return series;
    }

    public void setSeries(List<EChartsPieOneSerie> series) {
        this.series = series;
    }

    public EChartsPieOptions() {
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("item");
        eChartsTooltip.setFormatter("{a} <br/>{b}: {c} ({d}%)");
        this.setTooltip(eChartsTooltip);
    }
}
