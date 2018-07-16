package com.system.po.parameter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ParameterData extends ParameterBase {

    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public String getMaxValue() {
        return Collections.max(data);
    }

    public String getMinValue() {
        return Collections.min(data);
    }
}
