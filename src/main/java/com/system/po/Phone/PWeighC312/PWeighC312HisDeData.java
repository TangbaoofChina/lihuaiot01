package com.system.po.Phone.PWeighC312;

import com.system.po.Device.WeighC312DMHis;

public class PWeighC312HisDeData extends PWeighC312HisDataContent {
    //放料净重
    private float deNetW;
    //放料开始时间
    private String deStartDate;
    //放料截止时间
    private String deEndDate;

    public float getDeNetW() {
        return deNetW;
    }

    public void setDeNetW(float deNetW) {
        this.deNetW = deNetW;
    }

    public String getDeStartDate() {
        return deStartDate;
    }

    public void setDeStartDate(String deStartDate) {
        this.deStartDate = deStartDate;
    }

    public String getDeEndDate() {
        return deEndDate;
    }

    public void setDeEndDate(String deEndDate) {
        this.deEndDate = deEndDate;
    }

    public PWeighC312HisDeData(WeighC312DMHis weighC312DMHis) {
        super(weighC312DMHis);
        this.setDeNetW(weighC312DMHis.getDeNetW());
        this.setDeStartDate(weighC312DMHis.getDeStartDate());
        this.setDeEndDate(weighC312DMHis.getDeEndDate());
    }
}
