package com.system.po.parameter;

import com.system.util.DataConvertor;

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

    public String findMaxValue() {
        return DataConvertor.findMaxValue(data);
    }

    public String findMinValue() {
        return DataConvertor.findMinValue(data);
    }
}
