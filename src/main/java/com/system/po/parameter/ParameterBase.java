package com.system.po.parameter;

import com.system.po.EChartsOptions.EcsMarkLine;
import com.system.po.EChartsOptions.EcsMarkPoint;

import java.util.ArrayList;
import java.util.List;

public class ParameterBase {
    private String name;
    private String type="line";
    private String connectNulls="true";
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

}
