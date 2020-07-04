package com.system.po.Device;

import com.system.po.MydataTableColumn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Lhsp05p1
 * @Description 立华冷库测温设备
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
public class Lhsp05p1DM extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //温度01
    Float temp01;
    //温度02
    Float temp02;
    //温度03
    Float temp03;
    //温度04
    Float temp04;
    //经度
    Double lng;
    //纬度
    Double lat;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public Float getTemp01() {
        return temp01;
    }

    public void setTemp01(Float temp01) {
        this.temp01 = temp01;
    }

    public Float getTemp02() {
        return temp02;
    }

    public void setTemp02(Float temp02) {
        this.temp02 = temp02;
    }

    public Float getTemp03() {
        return temp03;
    }

    public void setTemp03(Float temp03) {
        this.temp03 = temp03;
    }

    public Float getTemp04() {
        return temp04;
    }

    public void setTemp04(Float temp04) {
        this.temp04 = temp04;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
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

        //温度01
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("temp01");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("温度01");
        mdtc10.setVisible(true);
        myDTCList.add(mdtc10);

        //温度02
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("temp02");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("温度02");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        //温度03
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("temp03");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("温度03");
        mdtc12.setVisible(true);
        myDTCList.add(mdtc12);

        //温度04
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("temp04");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("温度04");
        mdtc13.setVisible(true);
        myDTCList.add(mdtc13);

        //经度
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("lng");
        mdtc14.setDefaultContent("13");
        mdtc14.setTitle("经度");
        mdtc14.setVisible(false);
        myDTCList.add(mdtc14);

        //纬度
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("lat");
        mdtc15.setDefaultContent("13");
        mdtc15.setTitle("纬度");
        mdtc15.setVisible(false);
        myDTCList.add(mdtc15);

        return myDTCList;
    }
}
