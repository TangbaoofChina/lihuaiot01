package com.system.po.FeedC411;

import com.system.util.DataConvertor;

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

    public List<SiloTemp> getTemps() {
        return temps;
    }

    public void setTemps(List<SiloTemp> temps) {
        this.temps = temps;
    }

    public SiloCable(){}

    public SiloCable(int num,int quantity,List<SiloTemp> siloTempList){
        this.setNum(num);
        this.setQuantity(quantity);
        this.setTemps(siloTempList);
        //计算最高温
        this.setHigh(countHigh(siloTempList));
        //计算最低温
        this.setLow(countLow(siloTempList));
        //计算平均温
        this.setAvg(countAvg(siloTempList));
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
