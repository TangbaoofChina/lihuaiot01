package com.system.po.FeedC411;

import java.util.List;

/**
 *测温电缆
 */
public class SiloCable {
    /**
     * 温度点数量
     */
    int quantity;
    /**
     * 电缆序号
     */
    int num;
    /**
     * 测温点
     */
    List<SiloTemp> temps;
    /**
     * 电缆线最高温
     */
    float high;
    /**
     * 电缆线最低温
     */
    float low;
    /**
     * 电缆线平均温
     */
    float avg;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<SiloTemp> getTemps() {
        return temps;
    }

    public void setTemps(List<SiloTemp> temps) {
        this.temps = temps;
    }
}
