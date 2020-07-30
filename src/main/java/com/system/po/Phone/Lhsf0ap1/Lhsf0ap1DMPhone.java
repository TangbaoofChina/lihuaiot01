package com.system.po.Phone.Lhsf0ap1;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.Phone.PhoneRealMsgInfoObj;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lhsf0ap1DMPhone
 * @Description TODO
 * @Author tangbao
 * @Date 2020-07-20 13:48
 * @Version 1.0
 **/
public class Lhsf0ap1DMPhone extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //温度
    Float temp;
    //湿度
    Float humidity;
    //事件
    EventObj eventObj;

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

    public EventObj getEventObj() {
        return eventObj;
    }

    public void setEventObj(EventObj eventObj) {
        this.eventObj = eventObj;
    }

    public Lhsf0ap1DMPhone(){}

    public Lhsf0ap1DMPhone(Lhsf0ap1DM dm){

        this.setDSerialNum(dm.getDSerialNum());
        this.setdSerialNumDec(dm.getDSerialNumDec());
        this.setDName(dm.getDName());
        this.setDReceiveTime(dm.getDReceiveTime());
        this.setDState(dm.getDState());

        this.setSendDate(dm.getSendDate());
        this.setTemp(dm.getTemp());
        this.setHumidity(dm.getHumidity());
        EventObj eventObj = new EventObj();
        eventObj.setEvent(dm.getEvent());
        eventObj.setDescribe(dm.getDescribe());
        eventObj.setEventTime(dm.getEventTime());
        this.setEventObj(eventObj);
    }

    public List<PhoneRealMsgInfoObj> getPhoneRealMsgInfoObjSummary() {
        List<PhoneRealMsgInfoObj> PhoneRealMsgInfoObjList = new ArrayList<PhoneRealMsgInfoObj>();
        PhoneRealMsgInfoObj PhoneRealMsgInfoObj01 = new PhoneRealMsgInfoObj();
        PhoneRealMsgInfoObj01.setId("temp");
        PhoneRealMsgInfoObj01.setTitle("温度：");
        PhoneRealMsgInfoObj01.setValue(String.valueOf(this.getTemp())+ "℃");
        PhoneRealMsgInfoObj01.setFlag("0");
        PhoneRealMsgInfoObjList.add(PhoneRealMsgInfoObj01);

        PhoneRealMsgInfoObj PhoneRealMsgInfoObj02 = new PhoneRealMsgInfoObj();
        PhoneRealMsgInfoObj02.setId("humidity");
        PhoneRealMsgInfoObj02.setTitle("湿度：");
        PhoneRealMsgInfoObj02.setValue(String.valueOf(this.getHumidity())+ "%");
        PhoneRealMsgInfoObj02.setFlag("0");
        PhoneRealMsgInfoObjList.add(PhoneRealMsgInfoObj02);

        PhoneRealMsgInfoObj PhoneRealMsgInfoObj03 = new PhoneRealMsgInfoObj();
        PhoneRealMsgInfoObj03.setId("eventObj");
        PhoneRealMsgInfoObj03.setTitle("事件：");
        PhoneRealMsgInfoObj03.setValue(this.eventObj.getPhoneRealMsgInfoSummary());
        PhoneRealMsgInfoObj03.setFlag("0");
        PhoneRealMsgInfoObjList.add(PhoneRealMsgInfoObj03);

        PhoneRealMsgInfoObj PhoneRealMsgInfoObj06 = new PhoneRealMsgInfoObj();
        PhoneRealMsgInfoObj06.setId("sendDate");
        PhoneRealMsgInfoObj06.setTitle("消息时间");
        PhoneRealMsgInfoObj06.setValue(this.getSendDate());
        PhoneRealMsgInfoObj06.setFlag("0");
        PhoneRealMsgInfoObjList.add(PhoneRealMsgInfoObj06);

        return PhoneRealMsgInfoObjList;
    }
}
