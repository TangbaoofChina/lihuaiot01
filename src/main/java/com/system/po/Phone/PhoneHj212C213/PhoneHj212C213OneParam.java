package com.system.po.Phone.PhoneHj212C213;

import com.system.util.DataConvertor;

import java.awt.*;

public class PhoneHj212C213OneParam {
    String value;
    String color= DataConvertor.Color2String(Color.BLACK);

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PhoneHj212C213OneParam(){}

    public PhoneHj212C213OneParam(float fparam){
        this.setValue(String.valueOf(fparam));
    }

    public PhoneHj212C213OneParam(float fParam,float fmax,float fmin){
        if(fParam > fmax)
            this.setColor(DataConvertor.Color2String(Color.RED));
        if(fParam < fmin)
            this.setColor(DataConvertor.Color2String(Color.RED));
        this.setValue(String.valueOf(fParam));
    }

    public PhoneHj212C213OneParam(float fParam,float fmax){
        if(fParam > fmax)
            this.setColor(DataConvertor.Color2String(Color.RED));
        this.setValue(String.valueOf(fParam));
    }
}
