package com.system.po.Phone.PhoneSewageC212;

import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC212DMHis;
import com.system.po.Phone.PhoneSewageC01.PSC01HisDataContent;

public class PSC212HisDataContent extends PSC01HisDataContent{

    public PSC212HisDataContent(SewageC212DMHis sewageC212DMHis) {
        super();
        //当日流量(m³)
        super.setTodayFlowmeter(sewageC212DMHis.getTodayFlowmeter());
        //SBR池水温
        super.setWaterTemp(sewageC212DMHis.getWaterTemp());
        /***********  数据-设定时间  *********************/
        //sbr设定总时间
        super.setSbrCycleSetMinute(sewageC212DMHis.getSbrCycleSetMinute());
        //SBR一次搅拌（设定分钟）
        super.setSbrMixerOnceSetMinute(sewageC212DMHis.getSbrMixerOnceSetMinute());
        //SBR曝气（设定分钟）
        super.setFanSetMinute(sewageC212DMHis.getFanSetMinute());
        //SBR混合（设定分钟）
        super.setSbrMixerSetMinute(sewageC212DMHis.getSbrMixerSetMinute());
        //SBR静置（设定分钟）
        super.setSbrStaticSetMinute(sewageC212DMHis.getSbrStaticSetMinute());
        //SBR污泥泵2（设定分钟）
        super.setSludgePump02SetMinute(sewageC212DMHis.getSludgePump02SetMinute());
        //SBR活化（设定分钟）
        super.setSbrActiveSetMinute(sewageC212DMHis.getSbrActiveSetMinute());
        /***********  数据-运行时间  *********************/

        //设备发送数据时间
        super.setSendDate(sewageC212DMHis.getSendDate());
    }
}
