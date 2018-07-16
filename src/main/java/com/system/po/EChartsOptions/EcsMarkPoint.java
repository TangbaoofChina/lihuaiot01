package com.system.po.EChartsOptions;

import java.util.ArrayList;
import java.util.List;

public class EcsMarkPoint {
    private List<EcsmplData> data;

    public List<EcsmplData> getData() {
        return data;
    }

    public void setData(List<EcsmplData> data) {
        this.data = data;
    }

    public EcsMarkPoint() {
        data = new ArrayList<>();
        EcsmplData ecsmplDataMax = new EcsmplData();
        ecsmplDataMax.setType("max");
        ecsmplDataMax.setName("最大值");
        data.add(ecsmplDataMax);

        EcsmplData ecsmplDataMin = new EcsmplData();
        ecsmplDataMin.setType("min");
        ecsmplDataMin.setName("最小值");
        data.add(ecsmplDataMin);
    }
}
