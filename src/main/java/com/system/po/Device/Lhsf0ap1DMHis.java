package com.system.po.Device;

import com.system.util.Lhsf0ap1Util;

import java.util.Date;

/**
 * @ClassName Lhsf0ap1
 * @Description 立华生物安防物资进出设备
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
public class Lhsf0ap1DMHis extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //温度
    Float temp;
    //湿度
    Float humidity;
    //事件
    String event;
    //事件发生时间
    String eventTime;
    //事件描述
    String describe;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getDescribe() {
        String describe= Lhsf0ap1Util.getEventDescribe(this.event);
        return describe;
    }

    public void setDescribe(String describe) {
        if(this.event == null)
            return;
        String eDes= Lhsf0ap1Util.getEventDescribe(this.event);
        this.describe = eDes;
    }

}
