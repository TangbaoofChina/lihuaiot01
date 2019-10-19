package com.system.po.FeedC411;

import org.bouncycastle.asn1.x9.OtherInfo;

/**
 * 手机端单测温点数据
 */
public class PFC411Temp {
    //温度值
    String temp;
    //字体颜色
    String color;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PFC411Temp(){}

    public PFC411Temp(String temp, String color){
        this.setTemp(temp);
        this.setColor(color);
    }
}
