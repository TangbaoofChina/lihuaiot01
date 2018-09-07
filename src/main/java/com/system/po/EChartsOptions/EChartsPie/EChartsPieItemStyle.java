package com.system.po.EChartsOptions.EChartsPie;

public class EChartsPieItemStyle {
    private EChartsPieISEmphasis emphasis;

    public EChartsPieISEmphasis getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(EChartsPieISEmphasis emphasis) {
        this.emphasis = emphasis;
    }

    public EChartsPieItemStyle(){
        this.setEmphasis(new EChartsPieISEmphasis());
    }
}
