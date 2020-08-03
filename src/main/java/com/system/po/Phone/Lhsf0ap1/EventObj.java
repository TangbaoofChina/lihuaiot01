package com.system.po.Phone.Lhsf0ap1;

import com.system.po.Phone.PhoneRealMsgInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName EventObj
 * @Description TODO
 * @Author tangbao
 * @Date 2020-07-20 11:40
 * @Version 1.0
 **/
public class EventObj {
    //事件
    String event;
    //描述
    String describe;
    //事件发生时间
    String eventTime;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("event");
        phoneRealMsgInfo03.setTitle("代码：");
        phoneRealMsgInfo03.setValue(this.getEvent());
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("describe");
        phoneRealMsgInfo04.setTitle("描述：");
        phoneRealMsgInfo04.setValue(this.getDescribe());
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("eventTime");
        phoneRealMsgInfo07.setTitle("事件时间：");
        phoneRealMsgInfo07.setValue(this.getEventTime());
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        return phoneRealMsgInfoList;
    }
}
