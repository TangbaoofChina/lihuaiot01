package com.system.po.FeedC411;

import com.system.util.DataConvertor;

import java.awt.*;

/**
 * 筒仓温度点
 */
public class SiloTemp {
    /**
     * 温度值
     */
    float temp;
    /**
     * 是否启用 0：启用；1：禁用
     */
    boolean enable;
    /**
     * 是否正常 0：正常；1：故障
     */
    boolean normal;
    /**
     * 测温点编号
     */
    int num;
    /**
     * 测温点报警颜色
     */
    String color;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isNormal() {
        return normal;
    }

    public void setNormal(boolean normal) {
        this.normal = normal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public SiloTemp(){}

    public SiloTemp(int num,float temp,String usedState,String faultState,float high){
        this.setNum(num);
        this.setTemp(temp);
        //0：启用；1：禁用 需要取反
        this.setEnable(!DataConvertor.Hex2Bool(usedState,num-1));
        //0：正常；1：故障 需要取反
        this.setNormal(!DataConvertor.Hex2Bool(faultState,num-1));
        if(temp > high)
            this.setColor("FF0000");
        else
            this.setColor("000000");
    }
}
