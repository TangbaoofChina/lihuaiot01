package com.system.po.Phone.PhoneSewageC01;

import com.system.po.Device.SewageC01DMHis;

public class PSC01HisDataContent {
    /***********  数据-设定时间  *********************/
    //sbr设定总时间
    private int sbrCycleSetMinute;
    //SBR一次搅拌（设定分钟）
    private int sbrMixerOnceSetMinute;
    //SBR曝气（设定分钟）
    private int fanSetMinute;
    //SBR混合（设定分钟）
    private int sbrMixerSetMinute;
    //SBR静置（设定分钟）
    private int sbrStaticSetMinute;
    //SBR污泥泵2（设定分钟）
    private int sludgePump02SetMinute;
    //SBR活化（设定分钟）
    private int sbrActiveSetMinute;
    /***********  数据-运行时间  *********************/
    //当日流量(m³)
    private long todayFlowmeter;
    //设备发送数据时间
    private String sendDate;

    public int getSbrCycleSetMinute() {
        return sbrCycleSetMinute;
    }

    public void setSbrCycleSetMinute(int sbrCycleSetMinute) {
        this.sbrCycleSetMinute = sbrCycleSetMinute;
    }

    public int getSbrMixerOnceSetMinute() {
        return sbrMixerOnceSetMinute;
    }

    public void setSbrMixerOnceSetMinute(int sbrMixerOnceSetMinute) {
        this.sbrMixerOnceSetMinute = sbrMixerOnceSetMinute;
    }

    public int getFanSetMinute() {
        return fanSetMinute;
    }

    public void setFanSetMinute(int fanSetMinute) {
        this.fanSetMinute = fanSetMinute;
    }

    public int getSbrMixerSetMinute() {
        return sbrMixerSetMinute;
    }

    public void setSbrMixerSetMinute(int sbrMixerSetMinute) {
        this.sbrMixerSetMinute = sbrMixerSetMinute;
    }

    public int getSbrStaticSetMinute() {
        return sbrStaticSetMinute;
    }

    public void setSbrStaticSetMinute(int sbrStaticSetMinute) {
        this.sbrStaticSetMinute = sbrStaticSetMinute;
    }

    public int getSludgePump02SetMinute() {
        return sludgePump02SetMinute;
    }

    public void setSludgePump02SetMinute(int sludgePump02SetMinute) {
        this.sludgePump02SetMinute = sludgePump02SetMinute;
    }

    public int getSbrActiveSetMinute() {
        return sbrActiveSetMinute;
    }

    public void setSbrActiveSetMinute(int sbrActiveSetMinute) {
        this.sbrActiveSetMinute = sbrActiveSetMinute;
    }

    public long getTodayFlowmeter() {
        return todayFlowmeter;
    }

    public void setTodayFlowmeter(long todayFlowmeter) {
        this.todayFlowmeter = todayFlowmeter;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public PSC01HisDataContent(SewageC01DMHis sewageC01DMHis) {
        //当日流量(m³)
        this.todayFlowmeter = sewageC01DMHis.getTodayFlowmeter();
        /***********  数据-设定时间  *********************/
        //sbr设定总时间
        this.sbrCycleSetMinute = sewageC01DMHis.getSbrCycleSetMinute();
        //SBR一次搅拌（设定分钟）
        this.sbrMixerOnceSetMinute = sewageC01DMHis.getSbrMixerOnceSetMinute();
        //SBR曝气（设定分钟）
        this.fanSetMinute = sewageC01DMHis.getFanSetMinute();
        //SBR混合（设定分钟）
        this.sbrMixerSetMinute = sewageC01DMHis.getSbrMixerSetMinute();
        //SBR静置（设定分钟）
        this.sbrStaticSetMinute = sewageC01DMHis.getSbrStaticSetMinute();
        //SBR污泥泵2（设定分钟）
        this.sludgePump02SetMinute = sewageC01DMHis.getSludgePump02SetMinute();
        //SBR活化（设定分钟）
        this.sbrActiveSetMinute = sewageC01DMHis.getSbrActiveSetMinute();
        /***********  数据-运行时间  *********************/

        //设备发送数据时间
        this.sendDate = sewageC01DMHis.getSendDate();
    }
}
