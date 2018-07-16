package com.system.po.EChartsOptions;

import java.util.ArrayList;
import java.util.List;

public class EcsMarkLine {
    private List<EcsmplData> data;

    public List<EcsmplData> getData() {
        return data;
    }

    public void setData(List<EcsmplData> data) {
        this.data = data;
    }

    public EcsMarkLine() {
        data = new ArrayList<>();
        EcsmplData ecsmplData = new EcsmplData();
        ecsmplData.setType("average");
        ecsmplData.setName("平均值");
        data.add(ecsmplData);
    }
}
