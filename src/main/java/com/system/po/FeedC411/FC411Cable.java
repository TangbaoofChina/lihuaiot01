package com.system.po.FeedC411;

import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 *测温电缆
 */
public class FC411Cable {
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
    List<FC411Temp> temps;
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

    public List<FC411Temp> getTemps() {
        return temps;
    }

    public void setTemps(List<FC411Temp> temps) {
        this.temps = temps;
    }

    public FC411Cable(){}

    public FC411Cable(int num, int quantity, List<FC411Temp> FC411TempList){
        this.setNum(num);
        this.setQuantity(quantity);
        this.setTemps(FC411TempList);
        //计算最高温
        this.setHigh(countHigh(FC411TempList));
        //计算最低温
        this.setLow(countLow(FC411TempList));
        //计算平均温
        this.setAvg(countAvg(FC411TempList));
    }

    public PFC411Cable formatPhoneSiloCable(){
        PFC411Cable phoneSiloCable = new PFC411Cable();
        phoneSiloCable.setNum(String.valueOf(this.getNum()));
        phoneSiloCable.setBgColor("708090");

        List<PFC411Temp> phoneSiloTemps = new ArrayList<>();
        for(int i =0;i<this.getTemps().size();i++){
            FC411Temp FC411Temp = this.getTemps().get(i);
            PFC411Temp phoneSiloTemp = new PFC411Temp(String.valueOf(FC411Temp.getTemp()), FC411Temp.getColor());
            phoneSiloTemps.add(phoneSiloTemp);
        }
        phoneSiloCable.setTemps(phoneSiloTemps);
        return phoneSiloCable;
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
