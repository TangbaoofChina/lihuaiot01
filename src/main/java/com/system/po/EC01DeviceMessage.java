package com.system.po;

import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EC01DeviceMessage extends BaseDeviceMessage {
    //室内温度1
    private float inTemp1;
    //室内温度2
    private float inTemp2;
    //室内温度3
    private float inTemp3;
    //室内温度4
    private float inTemp4;
    //室内温度5
    private float inTemp5;
    //室内温度6
    private float inTemp6;
    //室外温度
    private float outTemp;
    //锅炉温度
    private float boilerTemp;
    //湿度
    private float humidityVal;
    //二氧化碳
    private float co2Val;
    //水流量-饮水
    private float waterFlowVal;
    //室内平均温度
    private float inAveTemp;
    //温度曲线运行到第几天
    private int tempCurveRunDays;
    //温度曲线运行到第几阶段
    private Byte tempCurveRunStage;
    //目标温度(参考温度，标准温度)
    private float standardTemp;
    //通风级别
    private Byte airLevel;
    //小窗开启百分比
    private Byte windowPct;
    //导流板1开启百分比
    private Byte guidePlate01Pct;
    //导流板2开启百分比
    private Byte guidePlate02Pct;
    //日龄
    private int chickenAge;
    //NH3
    private float nh3Val;
    //H2S
    private float h2sVal;
    //负压
    private float negativePressure;
    //光照强度
    private float lightIntensity;
    //换气量
    private float ventilationVolume;
    //信号强度
    private Byte signalIntensity;
    //继电器9含义
    private Byte relay09;
    //继电器10含义
    private Byte relay10;
    //继电器11含义
    private Byte relay11;
    //继电器12含义
    private Byte relay12;
    //继电器13含义
    private Byte relay13;
    //继电器14含义
    private Byte relay14;
    //风机1状态
    private Boolean fan01On;
    //风机2状态
    private Boolean fan02On;
    //风机3状态
    private Boolean fan03On;
    //风机4状态
    private Boolean fan04On;
    //风机5状态
    private Boolean fan05On;
    //风机6状态
    private Boolean fan06On;
    //风机7状态
    private Boolean fan07On;
    //风机8状态
    private Boolean fan08On;
    //继电器9状态
    private Boolean relay09On;
    //继电器10状态
    private Boolean relay10On;
    //继电器11状态
    private Boolean relay11On;
    //继电器12状态
    private Boolean relay12On;
    //继电器13状态
    private Boolean relay13On;
    //继电器14状态
    private Boolean relay14On;
    //湿帘水泵状态
    private Boolean wetCurtainOn;
    //报警状态
    private Boolean alarmOn;
    //风机定时使能 只对风机1和风机2有效
    private Boolean fanClockEnable;
    //风机切换使能
    private Boolean fanChangeEnable;
    //湿帘水泵使能
    private Boolean wetCurtainWPEnable;
    //温度曲线使能
    private Boolean tempCurveEnable;
    //最小通风曲线使能
    private Boolean minAirCurveEnable;
    //预留2.5
    private Boolean spare05On;
    //预留2.6
    private Boolean spare06On;
    //预留2.7
    private Boolean spare07On;
    //设备发送数据时间
    private String sendDate;
    //报警故障代码
    private String alarmErrorCode;
    //备用1
    private int spareCode01;
    //备用2
    private int spareCode02;
    //备用3
    private int spareCode03;
    //备用4
    private int spareCode04;

    public float getInTemp1() {
        return inTemp1;
    }

    public void setInTemp1(float inTemp1) {
        this.inTemp1 = inTemp1;
    }

    public float getInTemp2() {
        return inTemp2;
    }

    public void setInTemp2(float inTemp2) {
        this.inTemp2 = inTemp2;
    }

    public float getInTemp3() {
        return inTemp3;
    }

    public void setInTemp3(float inTemp3) {
        this.inTemp3 = inTemp3;
    }

    public float getInTemp4() {
        return inTemp4;
    }

    public void setInTemp4(float inTemp4) {
        this.inTemp4 = inTemp4;
    }

    public float getInTemp5() {
        return inTemp5;
    }

    public void setInTemp5(float inTemp5) {
        this.inTemp5 = inTemp5;
    }

    public float getInTemp6() {
        return inTemp6;
    }

    public void setInTemp6(float inTemp6) {
        this.inTemp6 = inTemp6;
    }

    public float getOutTemp() {
        return outTemp;
    }

    public void setOutTemp(float outTemp) {
        this.outTemp = outTemp;
    }

    public float getBoilerTemp() {
        return boilerTemp;
    }

    public void setBoilerTemp(float boilerTemp) {
        this.boilerTemp = boilerTemp;
    }

    public float getHumidityVal() {
        return humidityVal;
    }

    public void setHumidityVal(float humidityVal) {
        this.humidityVal = humidityVal;
    }

    public float getCo2Val() {
        return co2Val;
    }

    public void setCo2Val(float co2Val) {
        this.co2Val = co2Val;
    }

    public float getWaterFlowVal() {
        return waterFlowVal;
    }

    public void setWaterFlowVal(float waterFlowVal) {
        this.waterFlowVal = waterFlowVal;
    }

    public float getInAveTemp() {
        return inAveTemp;
    }

    public void setInAveTemp(float inAveTemp) {
        this.inAveTemp = inAveTemp;
    }

    public int getTempCurveRunDays() {
        return tempCurveRunDays;
    }

    public void setTempCurveRunDays(int tempCurveRunDays) {
        this.tempCurveRunDays = tempCurveRunDays;
    }

    public Byte getTempCurveRunStage() {
        return tempCurveRunStage;
    }

    public void setTempCurveRunStage(Byte tempCurveRunStage) {
        this.tempCurveRunStage = tempCurveRunStage;
    }

    public float getStandardTemp() {
        return standardTemp;
    }

    public void setStandardTemp(float standardTemp) {
        this.standardTemp = standardTemp;
    }

    public Byte getAirLevel() {
        return airLevel;
    }

    public void setAirLevel(Byte airLevel) {
        this.airLevel = airLevel;
    }

    public Byte getWindowPct() {
        return windowPct;
    }

    public void setWindowPct(Byte windowPct) {
        this.windowPct = windowPct;
    }

    public Byte getGuidePlate01Pct() {
        return guidePlate01Pct;
    }

    public void setGuidePlate01Pct(Byte guidePlate01Pct) {
        this.guidePlate01Pct = guidePlate01Pct;
    }

    public Byte getGuidePlate02Pct() {
        return guidePlate02Pct;
    }

    public void setGuidePlate02Pct(Byte guidePlate02Pct) {
        this.guidePlate02Pct = guidePlate02Pct;
    }

    public int getChickenAge() {
        return chickenAge;
    }

    public void setChickenAge(int chickenAge) {
        this.chickenAge = chickenAge;
    }

    public float getNh3Val() {
        return nh3Val;
    }

    public void setNh3Val(float nh3Val) {
        this.nh3Val = nh3Val;
    }

    public float getH2sVal() {
        return h2sVal;
    }

    public void setH2sVal(float h2sVal) {
        this.h2sVal = h2sVal;
    }

    public float getNegativePressure() {
        return negativePressure;
    }

    public void setNegativePressure(float negativePressure) {
        this.negativePressure = negativePressure;
    }

    public float getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(float lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public float getVentilationVolume() {
        return ventilationVolume;
    }

    public void setVentilationVolume(float ventilationVolume) {
        this.ventilationVolume = ventilationVolume;
    }

    public Byte getSignalIntensity() {
        return signalIntensity;
    }

    public void setSignalIntensity(Byte signalIntensity) {
        this.signalIntensity = signalIntensity;
    }

    public Byte getRelay09() {
        return relay09;
    }

    public void setRelay09(Byte relay09) {
        this.relay09 = relay09;
    }

    public Byte getRelay10() {
        return relay10;
    }

    public void setRelay10(Byte relay10) {
        this.relay10 = relay10;
    }

    public Byte getRelay11() {
        return relay11;
    }

    public void setRelay11(Byte relay11) {
        this.relay11 = relay11;
    }

    public Byte getRelay12() {
        return relay12;
    }

    public void setRelay12(Byte relay12) {
        this.relay12 = relay12;
    }

    public Byte getRelay13() {
        return relay13;
    }

    public void setRelay13(Byte relay13) {
        this.relay13 = relay13;
    }

    public Byte getRelay14() {
        return relay14;
    }

    public void setRelay14(Byte relay14) {
        this.relay14 = relay14;
    }

    public Boolean getFan01On() {
        return fan01On;
    }

    public void setFan01On(Boolean fan01On) {
        this.fan01On = fan01On;
    }

    public Boolean getFan02On() {
        return fan02On;
    }

    public void setFan02On(Boolean fan02On) {
        this.fan02On = fan02On;
    }

    public Boolean getFan03On() {
        return fan03On;
    }

    public void setFan03On(Boolean fan03On) {
        this.fan03On = fan03On;
    }

    public Boolean getFan04On() {
        return fan04On;
    }

    public void setFan04On(Boolean fan04On) {
        this.fan04On = fan04On;
    }

    public Boolean getFan05On() {
        return fan05On;
    }

    public void setFan05On(Boolean fan05On) {
        this.fan05On = fan05On;
    }

    public Boolean getFan06On() {
        return fan06On;
    }

    public void setFan06On(Boolean fan06On) {
        this.fan06On = fan06On;
    }

    public Boolean getFan07On() {
        return fan07On;
    }

    public void setFan07On(Boolean fan07On) {
        this.fan07On = fan07On;
    }

    public Boolean getFan08On() {
        return fan08On;
    }

    public void setFan08On(Boolean fan08On) {
        this.fan08On = fan08On;
    }

    public Boolean getRelay09On() {
        return relay09On;
    }

    public void setRelay09On(Boolean relay09On) {
        this.relay09On = relay09On;
    }

    public Boolean getRelay10On() {
        return relay10On;
    }

    public void setRelay10On(Boolean relay10On) {
        this.relay10On = relay10On;
    }

    public Boolean getRelay11On() {
        return relay11On;
    }

    public void setRelay11On(Boolean relay11On) {
        this.relay11On = relay11On;
    }

    public Boolean getRelay12On() {
        return relay12On;
    }

    public void setRelay12On(Boolean relay12On) {
        this.relay12On = relay12On;
    }

    public Boolean getRelay13On() {
        return relay13On;
    }

    public void setRelay13On(Boolean relay13On) {
        this.relay13On = relay13On;
    }

    public Boolean getRelay14On() {
        return relay14On;
    }

    public void setRelay14On(Boolean relay14On) {
        this.relay14On = relay14On;
    }

    public Boolean getWetCurtainOn() {
        return wetCurtainOn;
    }

    public void setWetCurtainOn(Boolean wetCurtainOn) {
        this.wetCurtainOn = wetCurtainOn;
    }

    public Boolean getAlarmOn() {
        return alarmOn;
    }

    public void setAlarmOn(Boolean alarmOn) {
        this.alarmOn = alarmOn;
    }

    public Boolean getFanClockEnable() {
        return fanClockEnable;
    }

    public void setFanClockEnable(Boolean fanClockEnable) {
        this.fanClockEnable = fanClockEnable;
    }

    public Boolean getFanChangeEnable() {
        return fanChangeEnable;
    }

    public void setFanChangeEnable(Boolean fanChangeEnable) {
        this.fanChangeEnable = fanChangeEnable;
    }

    public Boolean getWetCurtainWPEnable() {
        return wetCurtainWPEnable;
    }

    public void setWetCurtainWPEnable(Boolean wetCurtainWPEnable) {
        this.wetCurtainWPEnable = wetCurtainWPEnable;
    }

    public Boolean getTempCurveEnable() {
        return tempCurveEnable;
    }

    public void setTempCurveEnable(Boolean tempCurveEnable) {
        this.tempCurveEnable = tempCurveEnable;
    }

    public Boolean getMinAirCurveEnable() {
        return minAirCurveEnable;
    }

    public void setMinAirCurveEnable(Boolean minAirCurveEnable) {
        this.minAirCurveEnable = minAirCurveEnable;
    }

    public Boolean getSpare05On() {
        return spare05On;
    }

    public void setSpare05On(Boolean spare05On) {
        this.spare05On = spare05On;
    }

    public Boolean getSpare06On() {
        return spare06On;
    }

    public void setSpare06On(Boolean spare06On) {
        this.spare06On = spare06On;
    }

    public Boolean getSpare07On() {
        return spare07On;
    }

    public void setSpare07On(Boolean spare07On) {
        this.spare07On = spare07On;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getAlarmErrorCode() {
        return alarmErrorCode;
    }

    public void setAlarmErrorCode(String alarmErrorCode) {
        this.alarmErrorCode = alarmErrorCode;
    }

    public int getSpareCode01() {
        return spareCode01;
    }

    public void setSpareCode01(int spareCode01) {
        this.spareCode01 = spareCode01;
    }

    public int getSpareCode02() {
        return spareCode02;
    }

    public void setSpareCode02(int spareCode02) {
        this.spareCode02 = spareCode02;
    }

    public int getSpareCode03() {
        return spareCode03;
    }

    public void setSpareCode03(int spareCode03) {
        this.spareCode03 = spareCode03;
    }

    public int getSpareCode04() {
        return spareCode04;
    }

    public void setSpareCode04(int spareCode04) {
        this.spareCode04 = spareCode04;
    }

    public List<MydataTableColumn> getDeviceHead()
    {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNum");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("inTemp1");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("舍前");

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("inTemp2");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("舍中");

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("inTemp3");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("舍后");

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("outTemp");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("舍外");

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("boilerTemp");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("水温");
        mdtc7.setVisible(false);

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("humidityVal");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("湿度");
        mdtc8.setVisible(false);

        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("co2Val");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("CO2");
        mdtc9.setVisible(false);

        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("waterFlowVal");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("饮水");

        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("inAveTemp");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("舍内");

        //温度曲线运行到第几天
/*        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("tempCurveRunDays");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("天数");*/

        //温度曲线运行到第几阶段
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("tempCurveRunStage");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("温曲");
        mdtc13.setVisible(true);

        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("standardTemp");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("目标温度");

        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("airLevel");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("通风级别");
        mdtc15.setVisible(false);

        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("windowPct");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("小窗");
        mdtc16.setVisible(true);

        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("guidePlate01Pct");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("导流板1");
        mdtc17.setVisible(true);

        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("guidePlate02Pct");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("导流板2");
        mdtc18.setVisible(true);

        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("chickenAge");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("日龄");
        mdtc19.setVisible(true);

        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("nh3Val");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("NH3");
        mdtc20.setVisible(false);

        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("h2sVal");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("H2S");
        mdtc21.setVisible(false);

        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("negativePressure");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("负压");
        mdtc22.setVisible(false);

        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("lightIntensity");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("光照强度");
        mdtc23.setVisible(false);

        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("ventilationVolume");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("换气量");
        mdtc24.setVisible(true);

        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("signalIntensity");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("信号强度");
        mdtc25.setVisible(false);

        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("relay09");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("继电器9含义");
        mdtc26.setVisible(false);

        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("relay10");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("继电器10含义");
        mdtc27.setVisible(false);

        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("relay11");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("继电器11含义");
        mdtc28.setVisible(false);

        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("relay12");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("继电器12含义");
        mdtc29.setVisible(false);

        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("relay13");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("继电器13含义");
        mdtc30.setVisible(false);

        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("relay14");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("继电器14含义");
        mdtc31.setVisible(false);

        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("fan01On");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("风机1");
        mdtc32.setVisible(false);

        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("fan02On");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("风机2");
        mdtc33.setVisible(false);

        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("fan03On");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("风机3");
        mdtc34.setVisible(false);

        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("fan04On");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("风机4");
        mdtc35.setVisible(false);

        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("fan05On");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("风机5");
        mdtc36.setVisible(false);

        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("fan06On");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("风机6");
        mdtc37.setVisible(false);

        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("fan07On");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("风机7");
        mdtc38.setVisible(false);

        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("fan08On");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("风机8");
        mdtc39.setVisible(false);

        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("relay09On");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("继电器9状态");
        mdtc40.setVisible(false);

        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("relay10On");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("继电器10状态");
        mdtc41.setVisible(false);

        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("relay11On");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("继电器11状态");
        mdtc42.setVisible(false);

        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("relay12On");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("继电器12状态");
        mdtc43.setVisible(false);

        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("relay13On");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("继电器13状态");
        mdtc44.setVisible(false);

        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("relay14On");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("继电器14状态");
        mdtc45.setVisible(false);

        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("wetCurtainOn");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("湿帘水泵");
        mdtc46.setVisible(false);

        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("alarmOn");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("报警状态");
        mdtc47.setVisible(false);

        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("fanClockEnable");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("风机定时使能");
        mdtc48.setVisible(false);

        MydataTableColumn mdtc49 = new MydataTableColumn();
        mdtc49.setData("fanChangeEnable");
        mdtc49.setDefaultContent("49");
        mdtc49.setTitle("风机切换使能");
        mdtc49.setVisible(false);

        MydataTableColumn mdtc50 = new MydataTableColumn();
        mdtc50.setData("wetCurtainWPEnable");
        mdtc50.setDefaultContent("50");
        mdtc50.setTitle("湿帘水泵使能");
        mdtc50.setVisible(false);

        MydataTableColumn mdtc51 = new MydataTableColumn();
        mdtc51.setData("tempCurveEnable");
        mdtc51.setDefaultContent("51");
        mdtc51.setTitle("温度曲线使能");
        mdtc51.setVisible(false);

        MydataTableColumn mdtc52 = new MydataTableColumn();
        mdtc52.setData("minAirCurveEnable");
        mdtc52.setDefaultContent("52");
        mdtc52.setTitle("最小通风曲线使能");
        mdtc52.setVisible(false);

        MydataTableColumn mdtc53 = new MydataTableColumn();
        mdtc53.setData("alarmErrorCode");
        mdtc53.setDefaultContent("53");
        mdtc53.setTitle("错误");

        MydataTableColumn mdtc54 = new MydataTableColumn();
        mdtc54.setData("sendDate");
        mdtc54.setDefaultContent("54");
        mdtc54.setTitle("时间");

        MydataTableColumn mdtc55 = new MydataTableColumn();
        mdtc55.setData("dReceiveTime");
        mdtc55.setDefaultContent("55");
        mdtc55.setTitle("接收");

        MydataTableColumn mdtc56 = new MydataTableColumn();
        mdtc56.setData("dState");
        mdtc56.setDefaultContent("56");
        mdtc56.setTitle("状态");

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //状态
        myDTCList.add(mdtc56);
        //发送
        myDTCList.add(mdtc54);
/*        //天数
        myDTCList.add(mdtc12);*/
       //日龄
        myDTCList.add(mdtc19);
        //目标温度
        myDTCList.add(mdtc14);
        //阶段-温曲
        myDTCList.add(mdtc13);
        //舍内平均
        myDTCList.add(mdtc11);
        //舍前
        myDTCList.add(mdtc3);
        //舍中
        myDTCList.add(mdtc4);
        //舍后
        myDTCList.add(mdtc5);
        //舍外
        myDTCList.add(mdtc6);
        //饮水
        myDTCList.add(mdtc10);
        //换气量
        myDTCList.add(mdtc24);
        //小窗
        myDTCList.add(mdtc16);
        //导板1
        myDTCList.add(mdtc17);
        //导板2
        myDTCList.add(mdtc18);
        //炉温
        myDTCList.add(mdtc7);
        //湿度
        myDTCList.add(mdtc8);
        //二氧化碳
        myDTCList.add(mdtc9);
        //通风级别
        myDTCList.add(mdtc15);
        //NH3
        myDTCList.add(mdtc20);
        //H2S
        myDTCList.add(mdtc21);
        //负压
        myDTCList.add(mdtc22);
        //光照强度
        myDTCList.add(mdtc23);
        //信号强度
        myDTCList.add(mdtc25);
        //继电器9含义
        myDTCList.add(mdtc26);
        //继电器10含义
        myDTCList.add(mdtc27);
        //继电器11含义
        myDTCList.add(mdtc28);
        //继电器12含义
        myDTCList.add(mdtc29);
        //继电器13含义
        myDTCList.add(mdtc30);
        //继电器14含义
        myDTCList.add(mdtc31);
        //风机1
        myDTCList.add(mdtc32);
        //风机2
        myDTCList.add(mdtc33);
        //风机3
        myDTCList.add(mdtc34);
        //风机4
        myDTCList.add(mdtc35);
        //风机5
        myDTCList.add(mdtc36);
        //风机6
        myDTCList.add(mdtc37);
        //风机7
        myDTCList.add(mdtc38);
        //风机8
        myDTCList.add(mdtc39);
        //继电器9状态
        myDTCList.add(mdtc40);
        //继电器10状态
        myDTCList.add(mdtc41);
        //继电器11状态
        myDTCList.add(mdtc42);
        //继电器12状态
        myDTCList.add(mdtc43);
        //继电器13状态
        myDTCList.add(mdtc44);
        //继电器14状态
        myDTCList.add(mdtc45);
        //湿帘水泵
        myDTCList.add(mdtc46);
        //报警状态
        myDTCList.add(mdtc47);
        //风机定时
        myDTCList.add(mdtc48);
        //风机切换
        myDTCList.add(mdtc49);
        //湿帘水泵
        myDTCList.add(mdtc50);
        //温度曲线
        myDTCList.add(mdtc51);
        //最小通风曲线
        myDTCList.add(mdtc52);
        //报警
        myDTCList.add(mdtc53);
        //接收
        myDTCList.add(mdtc55);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoDetail()
    {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("chickenAge");
        phoneRealMsgInfo06.setTitle("日龄：");
        phoneRealMsgInfo06.setValue(String.valueOf(chickenAge)+ "天");
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo16 = new PhoneRealMsgInfo();
        phoneRealMsgInfo16.setId("standardTemp");
        phoneRealMsgInfo16.setTitle("目标温度：");
        phoneRealMsgInfo16.setValue(String.valueOf(standardTemp)+ "℃");
        phoneRealMsgInfo16.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo16);

        PhoneRealMsgInfo phoneRealMsgInfo17 = new PhoneRealMsgInfo();
        phoneRealMsgInfo17.setId("tempCurveRunStage");
        phoneRealMsgInfo17.setTitle("温曲：");
        phoneRealMsgInfo17.setValue(String.valueOf(tempCurveRunStage)+ "");
        phoneRealMsgInfo17.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo17);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("inAveTemp");
        phoneRealMsgInfo04.setTitle("舍内：");
        phoneRealMsgInfo04.setValue(String.valueOf(inAveTemp)+ "℃");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfo04.setHasHis(true);
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("inTemp1");
        phoneRealMsgInfo01.setTitle("舍前：");
        phoneRealMsgInfo01.setValue(String.valueOf(inTemp1) + "℃");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfo01.setHasHis(true);
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("inTemp2");
        phoneRealMsgInfo02.setTitle("舍中：");
        phoneRealMsgInfo02.setValue(String.valueOf(inTemp2)+ "℃");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("inTemp3");
        phoneRealMsgInfo03.setTitle("舍后：");
        phoneRealMsgInfo03.setValue(String.valueOf(inTemp3)+ "℃");
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo015 = new PhoneRealMsgInfo();
        phoneRealMsgInfo015.setId("outTemp");
        phoneRealMsgInfo015.setTitle("舍外：");
        phoneRealMsgInfo015.setValue(String.valueOf(outTemp)+ "℃");
        phoneRealMsgInfo015.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo015);

        PhoneRealMsgInfo phoneRealMsgInfo13 = new PhoneRealMsgInfo();
        phoneRealMsgInfo13.setId("negativePressure");
        phoneRealMsgInfo13.setTitle("饮水：");
        phoneRealMsgInfo13.setValue(String.valueOf(waterFlowVal) + "m³");
        phoneRealMsgInfo13.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo13);

        PhoneRealMsgInfo phoneRealMsgInfo18 = new PhoneRealMsgInfo();
        phoneRealMsgInfo18.setId("ventilationVolume");
        phoneRealMsgInfo18.setTitle("换气量：");
        phoneRealMsgInfo18.setValue(String.valueOf(ventilationVolume) + "m³/h");
        phoneRealMsgInfo18.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo18);

        PhoneRealMsgInfo phoneRealMsgInfo19 = new PhoneRealMsgInfo();
        phoneRealMsgInfo19.setId("windowPct");
        phoneRealMsgInfo19.setTitle("小窗：");
        phoneRealMsgInfo19.setValue(String.valueOf(windowPct) + "%");
        phoneRealMsgInfo19.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo19);

        PhoneRealMsgInfo phoneRealMsgInfo20 = new PhoneRealMsgInfo();
        phoneRealMsgInfo20.setId("guidePlate01Pct");
        phoneRealMsgInfo20.setTitle("导板1：");
        phoneRealMsgInfo20.setValue(String.valueOf(guidePlate01Pct) + "%");
        phoneRealMsgInfo20.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo20);

        PhoneRealMsgInfo phoneRealMsgInfo21 = new PhoneRealMsgInfo();
        phoneRealMsgInfo21.setId("guidePlate02Pct");
        phoneRealMsgInfo21.setTitle("导板2：");
        phoneRealMsgInfo21.setValue(String.valueOf(guidePlate02Pct) + "%");
        phoneRealMsgInfo21.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo21);

/*        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("humidityVal");
        phoneRealMsgInfo05.setTitle("湿度：");
        phoneRealMsgInfo05.setValue(String.valueOf(humidityVal)+ "%");
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);*/



/*        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("nh3Val");
        phoneRealMsgInfo07.setTitle("氨气：");
        phoneRealMsgInfo07.setValue(String.valueOf(nh3Val)+"PPM");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);*/

/*        PhoneRealMsgInfo phoneRealMsgInfo08 = new PhoneRealMsgInfo();
        phoneRealMsgInfo08.setId("negativePressure");
        phoneRealMsgInfo08.setTitle("负压：");
        phoneRealMsgInfo08.setValue(String.valueOf(negativePressure)+"Pa");
        phoneRealMsgInfo08.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo08);*/

        PhoneRealMsgInfo phoneRealMsgInfo09 = new PhoneRealMsgInfo();
        phoneRealMsgInfo09.setId("fan01On");
        phoneRealMsgInfo09.setTitle("风机1：");
        phoneRealMsgInfo09.setValue(String.valueOf(fan01On));
        phoneRealMsgInfo09.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo09);

        PhoneRealMsgInfo phoneRealMsgInfo10 = new PhoneRealMsgInfo();
        phoneRealMsgInfo10.setId("fan02On");
        phoneRealMsgInfo10.setTitle("风机2：");
        phoneRealMsgInfo10.setValue(String.valueOf(fan02On));
        phoneRealMsgInfo10.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo10);

        PhoneRealMsgInfo phoneRealMsgInfo11 = new PhoneRealMsgInfo();
        phoneRealMsgInfo11.setId("fan03On");
        phoneRealMsgInfo11.setTitle("风机3：");
        phoneRealMsgInfo11.setValue(String.valueOf(fan03On));
        phoneRealMsgInfo11.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo11);

        PhoneRealMsgInfo phoneRealMsgInfo12 = new PhoneRealMsgInfo();
        phoneRealMsgInfo12.setId("fan04On");
        phoneRealMsgInfo12.setTitle("风机4：");
        phoneRealMsgInfo12.setValue(String.valueOf(fan04On));
        phoneRealMsgInfo12.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo12);

        PhoneRealMsgInfo phoneRealMsgInfo22 = new PhoneRealMsgInfo();
        phoneRealMsgInfo22.setId("fan05On");
        phoneRealMsgInfo22.setTitle("风机5：");
        phoneRealMsgInfo22.setValue(String.valueOf(fan05On));
        phoneRealMsgInfo22.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo22);

        PhoneRealMsgInfo phoneRealMsgInfo14 = new PhoneRealMsgInfo();
        phoneRealMsgInfo14.setId("dState");
        phoneRealMsgInfo14.setTitle("状态：");
        phoneRealMsgInfo14.setValue(getDState());
        phoneRealMsgInfo14.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo14);

        PhoneRealMsgInfo phoneRealMsgInfo15 = new PhoneRealMsgInfo();
        phoneRealMsgInfo15.setId("sendDate");
        phoneRealMsgInfo15.setTitle("时间：");
        phoneRealMsgInfo15.setValue(getSendDate());
        phoneRealMsgInfo15.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo15);

        return phoneRealMsgInfoList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary()
    {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("chickenAge");
        phoneRealMsgInfo06.setTitle("日龄：");
        phoneRealMsgInfo06.setValue(String.valueOf(chickenAge)+ "天");
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo16 = new PhoneRealMsgInfo();
        phoneRealMsgInfo16.setId("standardTemp");
        phoneRealMsgInfo16.setTitle("目标温度：");
        phoneRealMsgInfo16.setValue(String.valueOf(standardTemp)+ "℃");
        phoneRealMsgInfo16.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo16);

        PhoneRealMsgInfo phoneRealMsgInfo17 = new PhoneRealMsgInfo();
        phoneRealMsgInfo17.setId("tempCurveRunStage");
        phoneRealMsgInfo17.setTitle("温曲：");
        phoneRealMsgInfo17.setValue(String.valueOf(tempCurveRunStage)+ "");
        phoneRealMsgInfo17.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo17);

        phoneRealMsgInfo04.setId("inAveTemp");
        phoneRealMsgInfo04.setTitle("舍内：");
        phoneRealMsgInfo04.setValue(String.valueOf(inAveTemp)+ "℃");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

/*        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("humidityVal");
        phoneRealMsgInfo05.setTitle("湿度：");
        phoneRealMsgInfo05.setValue(String.valueOf(humidityVal)+ "%");
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);*/

/*        PhoneRealMsgInfo phoneRealMsgInfo13 = new PhoneRealMsgInfo();
        phoneRealMsgInfo13.setId("negativePressure");
        phoneRealMsgInfo13.setTitle("饮水：");
        phoneRealMsgInfo13.setValue(String.valueOf(waterFlowVal)+ "L/Min");
        phoneRealMsgInfo13.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo13);*/

        PhoneRealMsgInfo phoneRealMsgInfo09 = new PhoneRealMsgInfo();
        phoneRealMsgInfo09.setId("fan01On");
        phoneRealMsgInfo09.setTitle("风机1：");
        phoneRealMsgInfo09.setValue(String.valueOf(fan01On));
        phoneRealMsgInfo09.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo09);

        PhoneRealMsgInfo phoneRealMsgInfo10 = new PhoneRealMsgInfo();
        phoneRealMsgInfo10.setId("fan02On");
        phoneRealMsgInfo10.setTitle("风机2：");
        phoneRealMsgInfo10.setValue(String.valueOf(fan02On));
        phoneRealMsgInfo10.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo10);

        PhoneRealMsgInfo phoneRealMsgInfo11 = new PhoneRealMsgInfo();
        phoneRealMsgInfo11.setId("fan03On");
        phoneRealMsgInfo11.setTitle("风机3：");
        phoneRealMsgInfo11.setValue(String.valueOf(fan03On));
        phoneRealMsgInfo11.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo11);

        PhoneRealMsgInfo phoneRealMsgInfo12 = new PhoneRealMsgInfo();
        phoneRealMsgInfo12.setId("fan04On");
        phoneRealMsgInfo12.setTitle("风机4：");
        phoneRealMsgInfo12.setValue(String.valueOf(fan04On));
        phoneRealMsgInfo12.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo12);

        PhoneRealMsgInfo phoneRealMsgInfo14 = new PhoneRealMsgInfo();
        phoneRealMsgInfo14.setId("dState");
        phoneRealMsgInfo14.setTitle("状态：");
        phoneRealMsgInfo14.setValue(getDState());
        phoneRealMsgInfo14.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo14);

        PhoneRealMsgInfo phoneRealMsgInfo15 = new PhoneRealMsgInfo();
        phoneRealMsgInfo15.setId("sendDate");
        phoneRealMsgInfo15.setTitle("");
        phoneRealMsgInfo15.setValue(this.getSendDate());
        phoneRealMsgInfo15.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo15);

        return phoneRealMsgInfoList;
    }

}
