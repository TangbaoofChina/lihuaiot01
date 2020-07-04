package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.util.Lhsf0ap1Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Lhsf0ap1
 * @Description 立华生物安防物资进出设备
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
public class Lhsf0ap1DM extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //温度
    Float temp;
    //湿度
    Float humidity;
    //事件
    String event;
    //事件描述
    String describe;
    //事件发生时间
    String eventTime;

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

    public void setDescribe() {
        if(this.event == null)
            return;
        String eDes= Lhsf0ap1Util.getEventDescribe(this.event);
        this.describe = eDes;
    }

    public String getDescribe() {
        String describe= Lhsf0ap1Util.getEventDescribe(this.event);
        return describe;
    }

    public void seteDescribe() {

    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public List<MydataTableColumn> getDeviceHead() {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNumDec");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        //设备发送数据时间
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("sendDate");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("时间");
        mdtc3.setVisible(true);

        //设备在线状态
        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dState");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("状态");
        mdtc4.setVisible(true);

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //设备在线状态
        myDTCList.add(mdtc3);
        //设备发送数据时间
        myDTCList.add(mdtc4);

        //温度
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("temp");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("温度");
        mdtc10.setVisible(true);
        myDTCList.add(mdtc10);

        //湿度
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("humidity");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("湿度");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        //事件代码
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("event");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("事件代码");
        mdtc12.setVisible(true);
        myDTCList.add(mdtc12);

        //事件中文
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("describe");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("事件");
        mdtc14.setVisible(true);
        myDTCList.add(mdtc14);

        //事件发生事件
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("eventTime");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("事件时间");
        mdtc13.setVisible(true);
        myDTCList.add(mdtc13);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("temp");
        phoneRealMsgInfo01.setTitle("温度：");
        phoneRealMsgInfo01.setValue(String.valueOf(this.getTemp())+ "℃");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("humidity");
        phoneRealMsgInfo02.setTitle("湿度：");
        phoneRealMsgInfo02.setValue(String.valueOf(this.getHumidity())+ "%");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("event");
        phoneRealMsgInfo03.setTitle("事件：");
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

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("sendDate");
        phoneRealMsgInfo06.setTitle("");
        phoneRealMsgInfo06.setValue(this.getSendDate());
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        return phoneRealMsgInfoList;
    }

}
