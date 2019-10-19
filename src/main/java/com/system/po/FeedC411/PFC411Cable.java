package com.system.po.FeedC411;

import java.util.List;

/**
 * 手机端 饲料部筒仓单根电缆
 */
public class PFC411Cable {
    //电缆编号、最高温、最低温、平均温
    String num;
    //电缆编号背景色
    String bgColor;
    //temps
    List<PFC411Temp> temps;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public List<PFC411Temp> getTemps() {
        return temps;
    }

    public void setTemps(List<PFC411Temp> temps) {
        this.temps = temps;
    }

    public PFC411Cable(){}

}
