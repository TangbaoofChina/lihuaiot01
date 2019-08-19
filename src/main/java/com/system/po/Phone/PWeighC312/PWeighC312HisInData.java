package com.system.po.Phone.PWeighC312;

import com.system.po.Device.WeighC312DMHis;

public class PWeighC312HisInData extends PWeighC312HisDataContent {
    //投料净重
    private float inNetW;
    //投料开始时间
    private String inStartDate;
    //投料截止时间
    private String inEndDate;

    public float getInNetW() {
        return inNetW;
    }

    public void setInNetW(float inNetW) {
        this.inNetW = inNetW;
    }

    public String getInStartDate() {
        return inStartDate;
    }

    public void setInStartDate(String inStartDate) {
        this.inStartDate = inStartDate;
    }

    public String getInEndDate() {
        return inEndDate;
    }

    public void setInEndDate(String inEndDate) {
        this.inEndDate = inEndDate;
    }

    public PWeighC312HisInData(WeighC312DMHis weighC312DMHis) {
        super(weighC312DMHis);
        this.setInNetW(weighC312DMHis.getInNetW());
        this.setInStartDate(weighC312DMHis.getInStartDate());
        this.setInEndDate(weighC312DMHis.getInEndDate());

    }
}
