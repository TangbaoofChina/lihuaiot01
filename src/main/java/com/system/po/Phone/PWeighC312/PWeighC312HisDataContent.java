package com.system.po.Phone.PWeighC312;

import com.system.po.Device.WeighC312DMHis;
import com.system.po.Phone.Base.PhoneHisDataContent;

import java.security.PublicKey;

/**
 * 历史数据查看统计
 */
public class PWeighC312HisDataContent extends PhoneHisDataContent{
    //净重
    private float netW;

    //设备发送数据时间
    private String sendDate;

    public float getNetW() {
        return netW;
    }

    public void setNetW(float netW) {
        this.netW = netW;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public PWeighC312HisDataContent(WeighC312DMHis weighC312DMHis){
        this.setNetW(weighC312DMHis.getNetW());
        this.setSendDate(weighC312DMHis.getSendDate());
    }
}
