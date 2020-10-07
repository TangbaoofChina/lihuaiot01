package com.system.po.Phone.Pswg215;

import com.system.po.Device.SewageC214DMHis;
import com.system.po.Device.SwgC215DMHis;
import com.system.po.Phone.PhoneSewageC01.PSC01HisDataContent;
import lombok.Data;

@Data
public class PSC215HisDataContent extends PSC01HisDataContent{

    //当日电量 需要运算
    private float todayEP;
    //流量计（m³）
    private long flowmeter;
    //正向有功总电能
    private float impEP;
    //环境温度
    private float airTemp;

    public PSC215HisDataContent(SwgC215DMHis dmHis) {
        super();
        //累计流量
        this.setFlowmeter(dmHis.getFlowmeter());
        //当日流量(m³)
        super.setTodayFlowmeter(dmHis.getTodayFlowmeter());
        //累计电量
        this.setImpEP(dmHis.getImpEP());
        //当日电量
        this.setTodayEP(dmHis.getTodayEP());
        //SBR池水温
        super.setWaterTemp(dmHis.getWaterTemp01());
        //环境温度
        this.setAirTemp(dmHis.getAirTemp01());
        /***********  数据-设定时间  *********************/

        /***********  数据-运行时间  *********************/

        //设备发送数据时间
        super.setSendDate(dmHis.getSendDate());
    }
}
