package com.system.po.EChartsOptions.EChartsTBF;

public class EctbfMagicType extends EctbfBase {
    private String[] type;

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getType() {
        String[] myType = new String[2];
        myType[0] = "line";
        myType[1] = "bar";
        return myType;
    }
}
