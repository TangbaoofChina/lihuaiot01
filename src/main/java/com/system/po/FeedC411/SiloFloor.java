package com.system.po.FeedC411;

/**
 * 筒仓的层
 */
public class SiloFloor {
    /**
     * 层最高温
     */
    float high;
    /**
     * 层最低温
     */
    float low;
    /**
     * 层平均温
     */
    float avg;
    /**
     * 层号
     */
    int num;

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
