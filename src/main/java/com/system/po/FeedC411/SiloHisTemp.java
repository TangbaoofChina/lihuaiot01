package com.system.po.FeedC411;

import com.system.po.Device.BaseDeviceMessage;

//为单温度曲线服务
public class SiloHisTemp extends BaseDeviceMessage {
    //温度值
    private String temp;
    //设备发送数据时间
    private String sendDate;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }
}
