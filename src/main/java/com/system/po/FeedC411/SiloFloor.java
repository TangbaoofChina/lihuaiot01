package com.system.po.FeedC411;

import com.system.util.DataConvertor;

import java.util.List;

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

    /**
     * 层最高温颜色
     */
    String highColor;
    /**
     * 层最低温颜色
     */
    String lowColor;
    /**
     * 层平均温颜色
     */
    String avgColor;


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

    public String getHighColor() {
        return highColor;
    }

    public void setHighColor(String highColor) {
        this.highColor = highColor;
    }

    public String getLowColor() {
        return lowColor;
    }

    public void setLowColor(String lowColor) {
        this.lowColor = lowColor;
    }

    public String getAvgColor() {
        return avgColor;
    }

    public void setAvgColor(String avgColor) {
        this.avgColor = avgColor;
    }

    public SiloFloor(){}

    public SiloFloor(int num,List<SiloTemp> temps,float high){
        this.setNum(num);
        this.setHigh(countHigh(temps));
        this.setLow(countLow(temps));
        this.setAvg(countAvg(temps));
        if(this.getHigh() > high)
            this.setHighColor("FF0000");
        else
            this.setHighColor("000000");
        if(this.getLow() > high)
            this.setLowColor("FF0000");
        else
            this.setLowColor("000000");
        if(this.getAvg() > high)
            this.setAvgColor("FF0000");
        else
            this.setAvgColor("000000");
    }

    /**
     * 计算最高温度
     * @return
     */
    private float countHigh(List<SiloTemp> siloTempList){
        float high = -100;
        for (SiloTemp st:siloTempList
        ) {
            if((st.getTemp() > high) && st.isEnable())
                high = st.getTemp();
        }
        return high;
    }

    /**
     * 计算最低温度
     * @param siloTempList
     * @return
     */
    private float countLow(List<SiloTemp> siloTempList){
        float low = 100;
        for (SiloTemp st:siloTempList
        ) {
            if((low > st.getTemp()) && st.isEnable())
                low = st.getTemp();
        }
        return low;
    }

    /**
     * 计算平均温度
     * @param siloTempList
     * @return
     */
    private float countAvg(List<SiloTemp> siloTempList) {
        float avg = 0;
        float accum = 0;
        int iCount = 0;
        for (SiloTemp st : siloTempList
        ) {
            if (st.isEnable()) {
                accum = accum + st.getTemp();
                iCount = iCount + 1;
            }
        }
        if (accum > 0) {
            avg = accum / iCount;
        }
        return DataConvertor.formatFloat(avg,1);
    }
}
