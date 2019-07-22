package com.system.po.Phone.PhoneSewageC214;

import com.system.po.Device.SewageC212DMHis;
import com.system.po.Device.SewageC214DMHis;
import com.system.po.Phone.PhoneSewageC01.PSC01HisDataContent;

public class PSC214HisDataContent extends PSC01HisDataContent{

    //当日电量 需要运算
    private float todayEP;

    public float getTodayEP() {
        return todayEP;
    }

    public void setTodayEP(float todayEP) {
        this.todayEP = todayEP;
    }

    public PSC214HisDataContent(SewageC214DMHis sewageC214DMHis) {
        super();
        //当日流量(m³)
        super.setTodayFlowmeter(sewageC214DMHis.getTodayFlowmeter());
        //当日电量
        this.setTodayEP(sewageC214DMHis.getTodayEP());
        //SBR池水温
        super.setWaterTemp(sewageC214DMHis.getWaterTemp());
        /***********  数据-设定时间  *********************/

        /***********  数据-运行时间  *********************/

        //设备发送数据时间
        super.setSendDate(sewageC214DMHis.getSendDate());
    }
}
