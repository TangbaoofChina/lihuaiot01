package com.system.po.EChartsOptions;

import com.system.po.BootStrapTreeNode;

public class EChartsToolBox {
    private Boolean show = true;
    private EChartsToolBoxFeature feature;

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public EChartsToolBoxFeature getFeature() {
        return feature;
    }

    public void setFeature(EChartsToolBoxFeature feature) {
        this.feature = feature;
    }

    public EChartsToolBox()
    {
        setFeature(new EChartsToolBoxFeature());
    }
}
