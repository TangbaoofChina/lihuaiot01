package com.system.po.FeedC411;

import java.util.List;

/**
 * 手机端筒仓测温信息对象
 */
public class PFC411TempInfo {
    //筒仓编号
    String num;
    //筒仓状态
    String useState;
    //筒仓层数
    int floorNum;
    //最高温
    PFC411Temp high;
    //最低温
    PFC411Temp low;
    //平均温
    PFC411Temp avg;
    //库存
    String stock;
    //水份
    String water;
    //湿度
    String humidity;
    //环境湿度
    String envHumidity;
    //电缆集合
    List<PFC411Cable> cables;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUseState() {
        return useState;
    }

    public void setUseState(String useState) {
        this.useState = useState;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public PFC411Temp getHigh() {
        return high;
    }

    public void setHigh(PFC411Temp high) {
        this.high = high;
    }

    public PFC411Temp getLow() {
        return low;
    }

    public void setLow(PFC411Temp low) {
        this.low = low;
    }

    public PFC411Temp getAvg() {
        return avg;
    }

    public void setAvg(PFC411Temp avg) {
        this.avg = avg;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getEnvHumidity() {
        return envHumidity;
    }

    public void setEnvHumidity(String envHumidity) {
        this.envHumidity = envHumidity;
    }

    public List<PFC411Cable> getCables() {
        return cables;
    }

    public void setCables(List<PFC411Cable> cables) {
        this.cables = cables;
    }

}
