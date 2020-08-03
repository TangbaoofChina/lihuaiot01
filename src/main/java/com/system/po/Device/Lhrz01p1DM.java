package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.Base.PhoneOneData;
import com.system.po.Phone.Base.PhonePartDetail;
import com.system.po.Phone.Lhrz01p1.PLhrz01p1PartDetail;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.util.DeviceUtil;
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
public class Lhrz01p1DM extends BaseDeviceMessage {
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
    int inventory=0;

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

        //工作模式
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("workMode");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("工作模式");
        mdtc10.setVisible(true);
        myDTCList.add(mdtc10);

        //动物日龄
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("age");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("日龄");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        //存栏量
        MydataTableColumn mdtc60 = new MydataTableColumn();
        mdtc60.setData("inventory");
        mdtc60.setDefaultContent("60");
        mdtc60.setTitle("存栏");
        mdtc60.setVisible(true);
        myDTCList.add(mdtc60);

        //当前温度
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("nowTemp");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("当前温度");
        mdtc12.setVisible(true);
        myDTCList.add(mdtc12);

        //舍外温度
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("outTemp");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("舍外温度");
        mdtc13.setVisible(true);
        myDTCList.add(mdtc13);

        //目标温度
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("targetTemp");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("目标温度");
        mdtc14.setVisible(true);
        myDTCList.add(mdtc14);

        //通风级别
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("airLevel");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("通风级别");
        mdtc15.setVisible(true);
        myDTCList.add(mdtc15);

        //通风量
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("airVolume");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("通风量");
        mdtc16.setVisible(true);
        myDTCList.add(mdtc16);

        //温度01
        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("temp01");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("温度01");
        mdtc17.setVisible(true);
        myDTCList.add(mdtc17);

        //温度02
        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("temp02");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("温度02");
        mdtc18.setVisible(true);
        myDTCList.add(mdtc18);

        //温度03
        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("temp03");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("温度03");
        mdtc19.setVisible(true);
        myDTCList.add(mdtc19);

        //湿度
        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("humidity");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("湿度");
        mdtc20.setVisible(true);
        myDTCList.add(mdtc20);

        //负压
        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("pressure");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("负压");
        mdtc21.setVisible(true);
        myDTCList.add(mdtc21);

        //风速
        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("speed");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("风速");
        mdtc22.setVisible(true);
        myDTCList.add(mdtc22);

        //氨气
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("nh3");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("氨气");
        mdtc23.setVisible(true);
        myDTCList.add(mdtc23);

        //噪音
        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("noise");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("噪音");
        mdtc24.setVisible(true);
        myDTCList.add(mdtc24);

        //二氧化碳
        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("co2");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("CO2");
        mdtc25.setVisible(true);
        myDTCList.add(mdtc25);

        //光照强度
        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("light");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("光照强度");
        mdtc26.setVisible(true);
        myDTCList.add(mdtc26);

        //风机01
        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("fan01");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("风机01");
        mdtc27.setVisible(true);
        myDTCList.add(mdtc27);

        //风机02
        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("fan02");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("风机02");
        mdtc28.setVisible(true);
        myDTCList.add(mdtc28);

        //风机03
        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("fan03");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("风机03");
        mdtc29.setVisible(true);
        myDTCList.add(mdtc29);

        //风机04
        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("fan04");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("风机04");
        mdtc30.setVisible(true);
        myDTCList.add(mdtc30);

        //风机05
        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("fan05");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("风机04");
        mdtc31.setVisible(true);
        myDTCList.add(mdtc31);

        //风机06
        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("fan06");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("风机06");
        mdtc32.setVisible(true);
        myDTCList.add(mdtc32);

        //风机07
        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("fan07");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("风机07");
        mdtc33.setVisible(true);
        myDTCList.add(mdtc33);

        //风机08
        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("fan08");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("风机08");
        mdtc34.setVisible(true);
        myDTCList.add(mdtc34);

        //风机09
        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("fan09");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("风机09");
        mdtc35.setVisible(true);
        myDTCList.add(mdtc35);

        //湿帘
        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("wetCurtain");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("湿帘");
        mdtc36.setVisible(true);
        myDTCList.add(mdtc36);

        //加热01
        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("heating01");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("加热01");
        mdtc37.setVisible(true);
        myDTCList.add(mdtc37);

        //加热02
        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("heating02");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("加热02");
        mdtc38.setVisible(true);
        myDTCList.add(mdtc38);

        //加热03
        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("heating03");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("加热03");
        mdtc39.setVisible(true);
        myDTCList.add(mdtc39);

        //照明
        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("lamp");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("照明");
        mdtc40.setVisible(true);
        myDTCList.add(mdtc40);

        //喂料
        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("feed");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("喂料");
        mdtc41.setVisible(true);
        myDTCList.add(mdtc41);

        //清粪
        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("dung");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("清粪");
        mdtc42.setVisible(true);
        myDTCList.add(mdtc42);

        //喷淋
        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("spray");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("喷淋");
        mdtc43.setVisible(true);
        myDTCList.add(mdtc43);

        //报警
        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("buzzer");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("报警");
        mdtc44.setVisible(true);
        myDTCList.add(mdtc44);

        //变速1速度
        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("speed01");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("变速01");
        mdtc45.setVisible(true);
        myDTCList.add(mdtc45);

        //变速2速度
        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("speed02");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("变速02");
        mdtc46.setVisible(true);
        myDTCList.add(mdtc46);

        //小窗开度
        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("winPct");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("小窗");
        mdtc47.setVisible(true);
        myDTCList.add(mdtc47);

        //风门开度
        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("airDoorPct");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("风门");
        mdtc48.setVisible(true);
        myDTCList.add(mdtc48);

        //卷帘开度
        MydataTableColumn mdtc49 = new MydataTableColumn();
        mdtc49.setData("rollingPct");
        mdtc49.setDefaultContent("49");
        mdtc49.setTitle("卷帘");
        mdtc49.setVisible(true);
        myDTCList.add(mdtc49);

        //总耗水量
        MydataTableColumn mdtc50 = new MydataTableColumn();
        mdtc50.setData("totalWater");
        mdtc50.setDefaultContent("50");
        mdtc50.setTitle("总耗水量");
        mdtc50.setVisible(true);
        myDTCList.add(mdtc50);

        //总耗气量
        MydataTableColumn mdtc51 = new MydataTableColumn();
        mdtc51.setData("totalGas");
        mdtc51.setDefaultContent("51");
        mdtc51.setTitle("总耗气量");
        mdtc51.setVisible(true);
        myDTCList.add(mdtc51);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("age");
        phoneRealMsgInfo01.setTitle("日龄");
        phoneRealMsgInfo01.setValue(String.valueOf(this.getAge())+ "天");
        phoneRealMsgInfo01.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("workMode");
        phoneRealMsgInfo02.setTitle("工作模式");
        if(this.getWorkMode() == 0) {
            phoneRealMsgInfo02.setValue("空舍");
        }else if(this.getWorkMode() == 1){
            phoneRealMsgInfo02.setValue("护理");
        }else if(this.getWorkMode() == 2){
            phoneRealMsgInfo02.setValue("标准");
        }
        phoneRealMsgInfo02.setFlag("2");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("inventory");
        phoneRealMsgInfo03.setTitle("存栏量");
        phoneRealMsgInfo03.setValue(String.valueOf(this.getInventory())+ "头");
        phoneRealMsgInfo03.setFlag("3");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("nowTemp");
        phoneRealMsgInfo04.setTitle("当前温度");
        phoneRealMsgInfo04.setValue(String.valueOf(this.getNowTemp())+ "℃");
        phoneRealMsgInfo04.setFlag("5");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("targetTemp");
        phoneRealMsgInfo05.setTitle("目标温度");
        phoneRealMsgInfo05.setValue(String.valueOf(this.getTargetTemp())+ "℃");
        phoneRealMsgInfo05.setFlag("6");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("outTemp");
        phoneRealMsgInfo06.setTitle("舍外温度");
        phoneRealMsgInfo06.setValue(String.valueOf(this.getOutTemp())+ "℃");
        phoneRealMsgInfo06.setFlag("7");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("airLevel");
        phoneRealMsgInfo07.setTitle("通风级别");
        phoneRealMsgInfo07.setValue(String.valueOf(this.getAirLevel())+ "");
        phoneRealMsgInfo07.setFlag("4");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        return phoneRealMsgInfoList;
    }

    public  List<PLhrz01p1PartDetail>  getPhoneDetail() {
        List<PLhrz01p1PartDetail> partDetails = new ArrayList<>();

        //一段数据  开始
        PLhrz01p1PartDetail partDetail01 = new PLhrz01p1PartDetail();
        partDetail01.setTitle("概要");
        List<PhoneRealMsgInfo> phoneRealMsgInfos01 = new ArrayList<>();

        PhoneRealMsgInfo phoneRealMsgInfoA01 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA01.setId("age");
        phoneRealMsgInfoA01.setTitle("动物日龄");
        phoneRealMsgInfoA01.setFlag("1");
        phoneRealMsgInfoA01.setValue(String.valueOf(this.getAge() + "天"));
        phoneRealMsgInfoA01.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA01);

        PhoneRealMsgInfo phoneRealMsgInfoA02 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA02.setId("workMode");
        phoneRealMsgInfoA02.setTitle("工作模式");
        phoneRealMsgInfoA02.setFlag("2");
        if(this.getWorkMode() == 0) {
            phoneRealMsgInfoA02.setValue("空舍");
        }else if(this.getWorkMode() == 1){
            phoneRealMsgInfoA02.setValue("护理");
        }else if(this.getWorkMode() == 2){
            phoneRealMsgInfoA02.setValue("标准");
        }
        phoneRealMsgInfoA02.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA02);

        PhoneRealMsgInfo phoneRealMsgInfoA03 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA03.setId("inventory");
        phoneRealMsgInfoA03.setTitle("存栏量");
        phoneRealMsgInfoA03.setFlag("3");
        phoneRealMsgInfoA03.setValue(String.valueOf(this.getInventory()+ "头"));
        phoneRealMsgInfoA03.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA03);

        PhoneRealMsgInfo phoneRealMsgInfoA04 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA04.setId("nowTemp");
        phoneRealMsgInfoA04.setTitle("当前温度");
        phoneRealMsgInfoA04.setFlag("4");
        phoneRealMsgInfoA04.setValue(String.valueOf(this.getNowTemp()+ "℃"));
        phoneRealMsgInfoA04.setHasHis(true);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA04);

        PhoneRealMsgInfo phoneRealMsgInfoA05 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA05.setId("targetTemp");
        phoneRealMsgInfoA05.setTitle("目标温度");
        phoneRealMsgInfoA05.setFlag("5");
        phoneRealMsgInfoA05.setValue(String.valueOf(this.getTargetTemp()+ "℃"));
        phoneRealMsgInfoA05.setHasHis(true);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA05);

        PhoneRealMsgInfo phoneRealMsgInfoA06 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA06.setId("outTemp");
        phoneRealMsgInfoA06.setTitle("舍外温度");
        phoneRealMsgInfoA06.setFlag("6");
        phoneRealMsgInfoA06.setValue(String.valueOf(this.getOutTemp()+ "℃"));
        phoneRealMsgInfoA06.setHasHis(true);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA06);

        PhoneRealMsgInfo phoneRealMsgInfoA07 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA07.setId("airLevel");
        phoneRealMsgInfoA07.setTitle("通风级别");
        phoneRealMsgInfoA07.setFlag("7");
        phoneRealMsgInfoA07.setValue(String.valueOf(this.getAirLevel()+ "级"));
        phoneRealMsgInfoA07.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA07);

        PhoneRealMsgInfo phoneRealMsgInfoA08 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA08.setId("airVolume");
        phoneRealMsgInfoA08.setTitle("通风量");
        phoneRealMsgInfoA08.setFlag("8");
        phoneRealMsgInfoA08.setValue(String.valueOf(this.getAirVolume()+ "m³/h/头"));
        phoneRealMsgInfoA08.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA08);

        PhoneRealMsgInfo phoneRealMsgInfoA09 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA09.setId("humidity");
        phoneRealMsgInfoA09.setTitle("湿度");
        phoneRealMsgInfoA09.setFlag("9");
        phoneRealMsgInfoA09.setValue(String.valueOf(this.getHumidity()+ "%"));
        phoneRealMsgInfoA09.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA09);

        PhoneRealMsgInfo phoneRealMsgInfoA10 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA10.setId("totalWater");
        phoneRealMsgInfoA10.setTitle("总耗水量");
        phoneRealMsgInfoA10.setFlag("10");
        phoneRealMsgInfoA10.setValue(String.valueOf(this.getTotalWater() + "kg"));
        phoneRealMsgInfoA10.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA10);

        PhoneRealMsgInfo phoneRealMsgInfoA11 = new PhoneRealMsgInfo();
        phoneRealMsgInfoA11.setId("totalGas");
        phoneRealMsgInfoA11.setTitle("总耗气量");
        phoneRealMsgInfoA11.setFlag("11");
        phoneRealMsgInfoA11.setValue(String.valueOf(this.getTotalWater() + "m³"));
        phoneRealMsgInfoA11.setHasHis(false);
        phoneRealMsgInfos01.add(phoneRealMsgInfoA11);

        //二段数据 开始
        PLhrz01p1PartDetail partDetail02 = new PLhrz01p1PartDetail();
        partDetail02.setTitle("其他");
        List<PhoneRealMsgInfo> phoneRealMsgInfos02 = new ArrayList<>();

        PhoneRealMsgInfo phoneRealMsgInfoB01 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB01.setId("temp01");
        phoneRealMsgInfoB01.setTitle("温度01");
        phoneRealMsgInfoB01.setFlag("1");
        phoneRealMsgInfoB01.setValue(String.valueOf(this.getTemp01() + "℃"));
        phoneRealMsgInfoB01.setHasHis(true);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB01);

        PhoneRealMsgInfo phoneRealMsgInfoB02 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB02.setId("temp02");
        phoneRealMsgInfoB02.setTitle("温度02");
        phoneRealMsgInfoB02.setFlag("2");
        phoneRealMsgInfoB02.setValue(String.valueOf(this.getTemp02() + "℃"));
        phoneRealMsgInfoB02.setHasHis(true);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB02);

        PhoneRealMsgInfo phoneRealMsgInfoB03 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB03.setId("temp03");
        phoneRealMsgInfoB03.setTitle("温度03");
        phoneRealMsgInfoB03.setFlag("3");
        phoneRealMsgInfoB03.setValue(String.valueOf(this.getTemp03() + "℃"));
        phoneRealMsgInfoB03.setHasHis(true);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB03);

        PhoneRealMsgInfo phoneRealMsgInfoB04 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB04.setId("pressure");
        phoneRealMsgInfoB04.setTitle("负压");
        phoneRealMsgInfoB04.setFlag("4");
        phoneRealMsgInfoB04.setValue(String.valueOf(this.getPressure() + "pa"));
        phoneRealMsgInfoB04.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB04);

        PhoneRealMsgInfo phoneRealMsgInfoB05 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB05.setId("speed");
        phoneRealMsgInfoB05.setTitle("风速");
        phoneRealMsgInfoB05.setFlag("5");
        phoneRealMsgInfoB05.setValue(String.valueOf(this.getPressure() + "m/s"));
        phoneRealMsgInfoB05.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB05);

        PhoneRealMsgInfo phoneRealMsgInfoB06 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB06.setId("nh3");
        phoneRealMsgInfoB06.setTitle("氨气");
        phoneRealMsgInfoB06.setFlag("6");
        phoneRealMsgInfoB06.setValue(String.valueOf(this.getNh3() + "ppm"));
        phoneRealMsgInfoB06.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB06);

        PhoneRealMsgInfo phoneRealMsgInfoB07 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB07.setId("noise");
        phoneRealMsgInfoB07.setTitle("噪声");
        phoneRealMsgInfoB07.setFlag("7");
        phoneRealMsgInfoB07.setValue(String.valueOf(this.getNoise() + "dB"));
        phoneRealMsgInfoB07.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB07);

        PhoneRealMsgInfo phoneRealMsgInfoB08 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB08.setId("co2");
        phoneRealMsgInfoB08.setTitle("二氧化碳");
        phoneRealMsgInfoB08.setFlag("8");
        phoneRealMsgInfoB08.setValue(String.valueOf(this.getCo2() + "ppm"));
        phoneRealMsgInfoB08.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB08);

        PhoneRealMsgInfo phoneRealMsgInfoB09 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB09.setId("light");
        phoneRealMsgInfoB09.setTitle("光照强度");
        phoneRealMsgInfoB09.setFlag("9");
        phoneRealMsgInfoB09.setValue(String.valueOf(this.getLight() + "lux"));
        phoneRealMsgInfoB09.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB09);

        PhoneRealMsgInfo phoneRealMsgInfoB10 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB10.setId("speed01");
        phoneRealMsgInfoB10.setTitle("变速01");
        phoneRealMsgInfoB10.setFlag("10");
        phoneRealMsgInfoB10.setValue(String.valueOf(this.getSpeed01() + "%"));
        phoneRealMsgInfoB10.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB10);

        PhoneRealMsgInfo phoneRealMsgInfoB11 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB11.setId("speed02");
        phoneRealMsgInfoB11.setTitle("变速02");
        phoneRealMsgInfoB11.setFlag("11");
        phoneRealMsgInfoB11.setValue(String.valueOf(this.getSpeed02() + "%"));
        phoneRealMsgInfoB11.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB11);

        PhoneRealMsgInfo phoneRealMsgInfoB12 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB12.setId("winPct");
        phoneRealMsgInfoB12.setTitle("小窗开度");
        phoneRealMsgInfoB12.setFlag("12");
        phoneRealMsgInfoB12.setValue(String.valueOf(this.getWinPct() + "%"));
        phoneRealMsgInfoB12.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB12);

        PhoneRealMsgInfo phoneRealMsgInfoB13 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB13.setId("airDoorPct");
        phoneRealMsgInfoB13.setTitle("风门开度");
        phoneRealMsgInfoB13.setFlag("13");
        phoneRealMsgInfoB13.setValue(String.valueOf(this.getAirDoorPct() + "%"));
        phoneRealMsgInfoB13.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB13);

        PhoneRealMsgInfo phoneRealMsgInfoB14 = new PhoneRealMsgInfo();
        phoneRealMsgInfoB14.setId("rollingPct");
        phoneRealMsgInfoB14.setTitle("卷帘开度");
        phoneRealMsgInfoB14.setFlag("14");
        phoneRealMsgInfoB14.setValue(String.valueOf(this.getRollingPct() + "%"));
        phoneRealMsgInfoB14.setHasHis(false);
        phoneRealMsgInfos02.add(phoneRealMsgInfoB14);

        //三段数据 开始
        PLhrz01p1PartDetail partDetail03 = new PLhrz01p1PartDetail();
        partDetail03.setTitle("状态");
        List<PhoneRealMsgInfo> phoneRealMsgInfos03 = new ArrayList<>();

        PhoneRealMsgInfo phoneRealMsgInfoC01 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC01.setId("fan01");
        phoneRealMsgInfoC01.setTitle("风机01");
        phoneRealMsgInfoC01.setFlag("1");
        if(this.getFan01().equals(true)){
            phoneRealMsgInfoC01.setValue("开");
        }else{
            phoneRealMsgInfoC01.setValue("关");
        }
        phoneRealMsgInfoC01.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC01);

        PhoneRealMsgInfo phoneRealMsgInfoC02 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC02.setId("fan02");
        phoneRealMsgInfoC02.setTitle("风机02");
        phoneRealMsgInfoC02.setFlag("2");
        if(this.getFan02().equals(true)){
            phoneRealMsgInfoC02.setValue("开");
        }else{
            phoneRealMsgInfoC02.setValue("关");
        }
        phoneRealMsgInfoC02.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC02);

        PhoneRealMsgInfo phoneRealMsgInfoC03 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC03.setId("fan03");
        phoneRealMsgInfoC03.setTitle("风机03");
        phoneRealMsgInfoC03.setFlag("3");
        if(this.getFan03().equals(true)){
            phoneRealMsgInfoC03.setValue("开");
        }else{
            phoneRealMsgInfoC03.setValue("关");
        }
        phoneRealMsgInfoC03.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC03);

        PhoneRealMsgInfo phoneRealMsgInfoC04 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC04.setId("fan04");
        phoneRealMsgInfoC04.setTitle("风机04");
        phoneRealMsgInfoC04.setFlag("4");
        if(this.getFan04().equals(true)){
            phoneRealMsgInfoC04.setValue("开");
        }else{
            phoneRealMsgInfoC04.setValue("关");
        }
        phoneRealMsgInfoC04.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC04);

        PhoneRealMsgInfo phoneRealMsgInfoC05 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC05.setId("fan05");
        phoneRealMsgInfoC05.setTitle("风机05");
        phoneRealMsgInfoC05.setFlag("5");
        if(this.getFan05().equals(true)){
            phoneRealMsgInfoC05.setValue("开");
        }else{
            phoneRealMsgInfoC05.setValue("关");
        }
        phoneRealMsgInfoC05.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC05);

        PhoneRealMsgInfo phoneRealMsgInfoC06 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC06.setId("fan06");
        phoneRealMsgInfoC06.setTitle("风机06");
        phoneRealMsgInfoC06.setFlag("6");
        if(this.getFan06().equals(true)){
            phoneRealMsgInfoC06.setValue("开");
        }else{
            phoneRealMsgInfoC06.setValue("关");
        }
        phoneRealMsgInfoC06.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC06);

        PhoneRealMsgInfo phoneRealMsgInfoC07 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC07.setId("fan07");
        phoneRealMsgInfoC07.setTitle("风机07");
        phoneRealMsgInfoC07.setFlag("7");
        if(this.getFan07().equals(true)){
            phoneRealMsgInfoC07.setValue("开");
        }else{
            phoneRealMsgInfoC07.setValue("关");
        }
        phoneRealMsgInfoC07.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC07);

        PhoneRealMsgInfo phoneRealMsgInfoC08 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC08.setId("fan08");
        phoneRealMsgInfoC08.setTitle("风机08");
        phoneRealMsgInfoC08.setFlag("8");
        if(this.getFan08().equals(true)){
            phoneRealMsgInfoC08.setValue("开");
        }else{
            phoneRealMsgInfoC08.setValue("关");
        }
        phoneRealMsgInfoC08.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC08);

        PhoneRealMsgInfo phoneRealMsgInfoC09 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC09.setId("fan09");
        phoneRealMsgInfoC09.setTitle("风机09");
        phoneRealMsgInfoC09.setFlag("9");
        if(this.getFan09().equals(true)){
            phoneRealMsgInfoC09.setValue("开");
        }else{
            phoneRealMsgInfoC09.setValue("关");
        }
        phoneRealMsgInfoC09.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC09);

        PhoneRealMsgInfo phoneRealMsgInfoC10 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC10.setId("wetCurtain");
        phoneRealMsgInfoC10.setTitle("湿帘");
        phoneRealMsgInfoC10.setFlag("10");
        if(this.getWetCurtain().equals(true)){
            phoneRealMsgInfoC10.setValue("开");
        }else{
            phoneRealMsgInfoC10.setValue("关");
        }
        phoneRealMsgInfoC10.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC10);

        PhoneRealMsgInfo phoneRealMsgInfoC11 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC11.setId("lamp");
        phoneRealMsgInfoC11.setTitle("照明");
        phoneRealMsgInfoC11.setFlag("11");
        if(this.getLamp().equals(true)){
            phoneRealMsgInfoC11.setValue("开");
        }else{
            phoneRealMsgInfoC11.setValue("关");
        }
        phoneRealMsgInfoC11.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC11);

        PhoneRealMsgInfo phoneRealMsgInfoC12 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC12.setId("feed");
        phoneRealMsgInfoC12.setTitle("喂料");
        phoneRealMsgInfoC12.setFlag("12");
        if(this.getFeed().equals(true)){
            phoneRealMsgInfoC12.setValue("开");
        }else{
            phoneRealMsgInfoC12.setValue("关");
        }
        phoneRealMsgInfoC12.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC12);

        PhoneRealMsgInfo phoneRealMsgInfoC13 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC13.setId("heating01");
        phoneRealMsgInfoC13.setTitle("加热01");
        phoneRealMsgInfoC13.setFlag("13");
        if(this.getHeating01().equals(true)){
            phoneRealMsgInfoC13.setValue("开");
        }else{
            phoneRealMsgInfoC13.setValue("关");
        }
        phoneRealMsgInfoC13.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC13);

        PhoneRealMsgInfo phoneRealMsgInfoC14 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC14.setId("heating02");
        phoneRealMsgInfoC14.setTitle("加热02");
        phoneRealMsgInfoC14.setFlag("14");
        if(this.getHeating02().equals(true)){
            phoneRealMsgInfoC14.setValue("开");
        }else{
            phoneRealMsgInfoC14.setValue("关");
        }
        phoneRealMsgInfoC14.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC14);

        PhoneRealMsgInfo phoneRealMsgInfoC15 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC15.setId("heating03");
        phoneRealMsgInfoC15.setTitle("加热03");
        phoneRealMsgInfoC15.setFlag("15");
        if(this.getHeating03().equals(true)){
            phoneRealMsgInfoC15.setValue("开");
        }else{
            phoneRealMsgInfoC15.setValue("关");
        }
        phoneRealMsgInfoC15.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC15);

        PhoneRealMsgInfo phoneRealMsgInfoC16 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC16.setId("dung");
        phoneRealMsgInfoC16.setTitle("清粪");
        phoneRealMsgInfoC16.setFlag("16");
        if(this.getDung().equals(true)){
            phoneRealMsgInfoC16.setValue("开");
        }else{
            phoneRealMsgInfoC16.setValue("关");
        }
        phoneRealMsgInfoC16.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC16);

        PhoneRealMsgInfo phoneRealMsgInfoC17 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC17.setId("spray");
        phoneRealMsgInfoC17.setTitle("喷淋");
        phoneRealMsgInfoC17.setFlag("17");
        if(this.getSpray().equals(true)){
            phoneRealMsgInfoC17.setValue("开");
        }else{
            phoneRealMsgInfoC17.setValue("关");
        }
        phoneRealMsgInfoC17.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC17);

        PhoneRealMsgInfo phoneRealMsgInfoC18 = new PhoneRealMsgInfo();
        phoneRealMsgInfoC18.setId("buzzer");
        phoneRealMsgInfoC18.setTitle("报警器");
        phoneRealMsgInfoC18.setFlag("18");
        if(this.getBuzzer().equals(true)){
            phoneRealMsgInfoC18.setValue("开");
        }else{
            phoneRealMsgInfoC18.setValue("关");
        }
        phoneRealMsgInfoC18.setHasHis(false);
        phoneRealMsgInfos03.add(phoneRealMsgInfoC18);

        //添加多行数据
        partDetail01.setData(phoneRealMsgInfos01);
        partDetails.add(partDetail01);
        partDetail02.setData(phoneRealMsgInfos02);
        partDetails.add(partDetail02);
        partDetail03.setData(phoneRealMsgInfos03);
        partDetails.add(partDetail03);
        //一段数据 结束
        return partDetails;
    }
}
