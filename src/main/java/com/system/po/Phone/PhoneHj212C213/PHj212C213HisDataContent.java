package com.system.po.Phone.PhoneHj212C213;

import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.Hj212C213.Hj212C213Threshold;

import java.util.ArrayList;
import java.util.List;

public class PHj212C213HisDataContent {
    //日期
    private String date;

    //瞬时流量-值
    private PhoneHj212C213OneParam flowrate_value;
    //ph-值
    private PhoneHj212C213OneParam ph_value;
    //cod-值
    private PhoneHj212C213OneParam cod_value;
    //氨氮-值
    private PhoneHj212C213OneParam nh3n_value;
    //总磷-值
    private PhoneHj212C213OneParam tp_value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PhoneHj212C213OneParam getFlowrate_value() {
        return flowrate_value;
    }

    public void setFlowrate_value(PhoneHj212C213OneParam flowrate_value) {
        this.flowrate_value = flowrate_value;
    }

    public PhoneHj212C213OneParam getPh_value() {
        return ph_value;
    }

    public void setPh_value(PhoneHj212C213OneParam ph_value) {
        this.ph_value = ph_value;
    }

    public PhoneHj212C213OneParam getCod_value() {
        return cod_value;
    }

    public void setCod_value(PhoneHj212C213OneParam cod_value) {
        this.cod_value = cod_value;
    }

    public PhoneHj212C213OneParam getNh3n_value() {
        return nh3n_value;
    }

    public void setNh3n_value(PhoneHj212C213OneParam nh3n_value) {
        this.nh3n_value = nh3n_value;
    }

    public PhoneHj212C213OneParam getTp_value() {
        return tp_value;
    }

    public void setTp_value(PhoneHj212C213OneParam tp_value) {
        this.tp_value = tp_value;
    }

    public PHj212C213HisDataContent(){}

    public PHj212C213HisDataContent( Hj212C213DayData hj212C213DayData){
        this.setDate(hj212C213DayData.getDateTime());
        Hj212C213Threshold hj212C213Threshold = new Hj212C213Threshold();
        this.setFlowrate_value(new PhoneHj212C213OneParam(Float.valueOf(hj212C213DayData.getFlowrate())));
        this.setPh_value(new PhoneHj212C213OneParam(Float.valueOf(hj212C213DayData.getPh()), hj212C213Threshold.getMaxPh(),hj212C213Threshold.getMinPh()));
        this.setCod_value(new PhoneHj212C213OneParam(Float.valueOf(hj212C213DayData.getCod()), hj212C213Threshold.getMaxCOD()));
        this.setNh3n_value(new PhoneHj212C213OneParam(Float.valueOf(hj212C213DayData.getNh3n()), hj212C213Threshold.getMaxNh3N()));
        this.setTp_value(new PhoneHj212C213OneParam(Float.valueOf(hj212C213DayData.getTp()), hj212C213Threshold.getMaxTp()));
    }
}
