package com.system.po.FeedC411;

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
}
