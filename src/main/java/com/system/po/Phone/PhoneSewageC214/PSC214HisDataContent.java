package com.system.po.Phone.PhoneSewageC214;

import com.system.po.Device.SewageC212DMHis;
import com.system.po.Device.SewageC214DMHis;
import com.system.po.Phone.PhoneSewageC01.PSC01HisDataContent;

public class PSC214HisDataContent extends PSC01HisDataContent{

    //当日电量 需要运算
    private float todayEP;
    //流量计（m³）
    private long flowmeter;
    //正向有功总电能
    private float impEP;
    //环境温度
    private float airTemp;

    public long getFlowmeter() {
        return flowmeter;
    }

    public void setFlowmeter(long flowmeter) {
        this.flowmeter = flowmeter;
    }

    public float getImpEP() {
        return impEP;
    }

    public void setImpEP(float impEP) {
        this.impEP = impEP;
    }

    public float getTodayEP() {
        return todayEP;
    }

    public void setTodayEP(float todayEP) {
        this.todayEP = todayEP;
    }

    public float getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(float airTemp) {
        this.airTemp = airTemp;
    }

    public PSC214HisDataContent(SewageC214DMHis sewageC214DMHis) {
        super();
        //累计流量
        this.setFlowmeter(sewageC214DMHis.getFlowmeter());
        //当日流量(m³)
        super.setTodayFlowmeter(sewageC214DMHis.getTodayFlowmeter());
        //累计电量
        this.setImpEP(sewageC214DMHis.getImpEP());
        //当日电量
        this.setTodayEP(sewageC214DMHis.getTodayEP());
        //SBR池水温
        super.setWaterTemp(sewageC214DMHis.getWaterTemp());
        //环境温度
        this.setAirTemp(sewageC214DMHis.getAirTemp());
        /***********  数据-设定时间  *********************/

        /***********  数据-运行时间  *********************/

        //设备发送数据时间
        super.setSendDate(sewageC214DMHis.getSendDate());
    }
}
