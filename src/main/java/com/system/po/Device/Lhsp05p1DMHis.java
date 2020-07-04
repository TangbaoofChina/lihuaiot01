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
public class Lhsp05p1DMHis extends BaseDeviceMessage {
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

}
