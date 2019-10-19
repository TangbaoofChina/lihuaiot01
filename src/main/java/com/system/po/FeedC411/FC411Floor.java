package com.system.po.FeedC411;

import com.system.po.Device.FeedC411DM;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 * 筒仓的层
 */
public class FC411Floor {
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

    public FC411Floor(){}

    /*public FC411Floor(int num, List<FC411Temp> temps, float high){
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
    }*/

    public FC411Floor(int num, List<FC411Cable> fc411CableList,float high){
        this.setNum(num);
        List<FC411Temp> temps = formatTemps(num,fc411CableList);
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
     * 合成某一层的温度list
     * @param num
     * @param fc411CableList
     * @return
     */
    private List<FC411Temp> formatTemps(int num, List<FC411Cable> fc411CableList) {
        List<FC411Temp> fc411Temps = new ArrayList<>();
        for (int i = 0; i < fc411CableList.size(); i++) {
            List<FC411Temp> fc411Temps01 = fc411CableList.get(i).getTemps();
            for (int j = 0; j < fc411Temps01.size(); j++) {
                if (fc411Temps01.get(j).getNum() == num) {
                    if (fc411Temps01.get(j).isEnable()) {
                        FC411Temp fc411Temp = fc411Temps01.get(j);
                        fc411Temps.add(fc411Temp);
                    }
                    break;
                }
            }
        }
        return fc411Temps;
    }

    /**
     * 计算最高温度
     * @return
     */
    private float countHigh(List<FC411Temp> FC411TempList){
        float high = -100;
        for (FC411Temp st: FC411TempList
        ) {
            if((st.getTemp() > high) && st.isEnable())
                high = st.getTemp();
        }
        return high;
    }

    /**
     * 计算最低温度
     * @param FC411TempList
     * @return
     */
    private float countLow(List<FC411Temp> FC411TempList){
        float low = 100;
        for (FC411Temp st: FC411TempList
        ) {
            if((low > st.getTemp()) && st.isEnable())
                low = st.getTemp();
        }
        return low;
    }

    /**
     * 计算平均温度
     * @param FC411TempList
     * @return
     */
    private float countAvg(List<FC411Temp> FC411TempList) {
        float avg = 0;
        float accum = 0;
        int iCount = 0;
        for (FC411Temp st : FC411TempList
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
