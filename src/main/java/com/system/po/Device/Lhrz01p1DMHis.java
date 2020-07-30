package com.system.po.Device;

import com.system.po.MydataTableColumn;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lhrz01p1DM
 * @Description 猪用环控器
 * @Author tangbao
 * @Date 2020-07-27 17:10
 * @Version 1.0
 **/
@Data
public class Lhrz01p1DMHis extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //工作模式
    Byte workMode;
    //动物日龄
    Integer age;
    //当前温度
    Float nowTemp;
    //舍外温度
    Float outTemp;
    //目标温度
    Float targetTemp;
    //通风级别
    Byte airLevel;
    //通风量 int
    Integer airVolume;
    //温度01 float
    Float temp01;
    //温度02 float
    Float temp02;
    //温度03 float
    Float temp03;
    //湿度 int
    Integer humidity;
    //负压 float
    float pressure;
    //风速 float
    float speed;
    //氨气 float
    float nh3;
    //噪音 int
    Integer noise;
    //二氧化碳 int
    Integer co2;
    //光照强度 int
    Integer light;
    //风机01
    Boolean fan01;
    //风机02
    Boolean fan02;
    //风机03
    Boolean fan03;
    //风机04
    Boolean fan04;
    //风机05
    Boolean fan05;
    //风机06
    Boolean fan06;
    //风机07
    Boolean fan07;
    //风机08
    Boolean fan08;
    //风机09
    Boolean fan09;
    //湿帘
    Boolean wetCurtain;
    //加热1
    Boolean heating01;
    //加热2
    Boolean heating02;
    //加热3
    Boolean heating03;
    //照明
    Boolean lamp;
    //喂料
    Boolean feed;
    //清粪
    Boolean dung;
    //喷淋
    Boolean spray;
    //报警
    Boolean buzzer;
    //变速1速度
    int speed01;
    //变速2速度
    int speed02;
    //小窗开度
    int winPct;
    //风门开度
    int airDoorPct;
    //卷帘开度
    int rollingPct;
    //总耗水量
    long totalWater;
    //总耗气量
    long totalGas;
    //存栏量
    int inventory;

}
