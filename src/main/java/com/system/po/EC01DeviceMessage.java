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
    //室外温度4
    private float outTemp4;
    //锅炉温度5
    private float boilerTemp5;
    //湿度
    private float humidityVal;
    //二氧化碳
    private float co2Val;
    //水流量
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
    //正面导流板开启百分比
    private Byte frontGuidePlatePct;
    //侧面导流板开启百分比
    private Byte sideGuidePlatePct;
    //卷帘1开启百分比
    private Byte rollerblind01Pct;
    //卷帘2开启百分比
    private Byte rollerblind02Pct;
    //湿帘水泵状态
    private String wetCurtainWP;
    //风机1状态
    private Byte fan1On;
    //风机2状态
    private Byte fan2On;
    //风机3状态
    private Byte fan3On;
    //风机4状态
    private Byte fan4On;
    //风机5状态
    private Byte fan5On;
    //风机6状态
    private Byte fan6On;
    //风机7状态
    private Byte fan7On;
    //风机8状态
    private Byte fan8On;
    //风机9状态
    private Byte fan9On;
    //风机10状态
    private Byte fan10On;
    //风机定时使能 只对风机1和风机2有效
    private Byte fanClockEnable;
    //风机切换使能
    private Byte fanChangeEnable;
    //锅炉状态
    private Byte boilerOn;
    //散热器状态
    private Byte heatSinkOn;
    //湿帘水泵使能
    private Byte wetCurtainWPEnable;
    //湿帘电机状态
    private Byte wetCurtainMotorOn;
    //定时报警使能
    private Byte alarmClockEnable;
    //温度曲线使能
    private Byte tempCurveEnable;
    //最小通风曲线使能
    private Byte minAirCurveEnable;
    //设备发送数据时间
    private String sendDate;
    //错误代码
    private String errorCode;
    //报警代码
    private String alarmCode;
    //日龄
    private int chickenAge ;
    //NH3
    private float nh3Val;
    //负压
    private float negativePressure;
    //备用
    private String prepareCode04;

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

    public float getOutTemp4() {
        return outTemp4;
    }

    public void setOutTemp4(float outTemp4) {
        this.outTemp4 = outTemp4;
    }

    public float getBoilerTemp5() {
        return boilerTemp5;
    }

    public void setBoilerTemp5(float boilerTemp5) {
        this.boilerTemp5 = boilerTemp5;
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

    public Byte getFrontGuidePlatePct() {
        return frontGuidePlatePct;
    }

    public void setFrontGuidePlatePct(Byte frontGuidePlatePct) {
        this.frontGuidePlatePct = frontGuidePlatePct;
    }

    public Byte getSideGuidePlatePct() {
        return sideGuidePlatePct;
    }

    public void setSideGuidePlatePct(Byte sideGuidePlatePct) {
        this.sideGuidePlatePct = sideGuidePlatePct;
    }

    public Byte getRollerblind01Pct() {
        return rollerblind01Pct;
    }

    public void setRollerblind01Pct(Byte rollerblind01Pct) {
        this.rollerblind01Pct = rollerblind01Pct;
    }

    public Byte getRollerblind02Pct() {
        return rollerblind02Pct;
    }

    public void setRollerblind02Pct(Byte rollerblind02Pct) {
        this.rollerblind02Pct = rollerblind02Pct;
    }

    public String getWetCurtainWP() {
        return wetCurtainWP;
    }

    public void setWetCurtainWP(String wetCurtainWP) {
        this.wetCurtainWP = wetCurtainWP;
    }

    public Byte getFan1On() {
        return fan1On;
    }

    public void setFan1On(Byte fan1On) {
        this.fan1On = fan1On;
    }

    public Byte getFan2On() {
        return fan2On;
    }

    public void setFan2On(Byte fan2On) {
        this.fan2On = fan2On;
    }

    public Byte getFan3On() {
        return fan3On;
    }

    public void setFan3On(Byte fan3On) {
        this.fan3On = fan3On;
    }

    public Byte getFan4On() {
        return fan4On;
    }

    public void setFan4On(Byte fan4On) {
        this.fan4On = fan4On;
    }

    public Byte getFan5On() {
        return fan5On;
    }

    public void setFan5On(Byte fan5On) {
        this.fan5On = fan5On;
    }

    public Byte getFan6On() {
        return fan6On;
    }

    public void setFan6On(Byte fan6On) {
        this.fan6On = fan6On;
    }

    public Byte getFan7On() {
        return fan7On;
    }

    public void setFan7On(Byte fan7On) {
        this.fan7On = fan7On;
    }

    public Byte getFan8On() {
        return fan8On;
    }

    public void setFan8On(Byte fan8On) {
        this.fan8On = fan8On;
    }

    public Byte getFan9On() {
        return fan9On;
    }

    public void setFan9On(Byte fan9On) {
        this.fan9On = fan9On;
    }

    public Byte getFan10On() {
        return fan10On;
    }

    public void setFan10On(Byte fan10On) {
        this.fan10On = fan10On;
    }

    public Byte getFanClockEnable() {
        return fanClockEnable;
    }

    public void setFanClockEnable(Byte fanClockEnable) {
        this.fanClockEnable = fanClockEnable;
    }

    public Byte getFanChangeEnable() {
        return fanChangeEnable;
    }

    public void setFanChangeEnable(Byte fanChangeEnable) {
        this.fanChangeEnable = fanChangeEnable;
    }

    public Byte getBoilerOn() {
        return boilerOn;
    }

    public void setBoilerOn(Byte boilerOn) {
        this.boilerOn = boilerOn;
    }

    public Byte getHeatSinkOn() {
        return heatSinkOn;
    }

    public void setHeatSinkOn(Byte heatSinkOn) {
        this.heatSinkOn = heatSinkOn;
    }

    public Byte getWetCurtainWPEnable() {
        return wetCurtainWPEnable;
    }

    public void setWetCurtainWPEnable(Byte wetCurtainWPEnable) {
        this.wetCurtainWPEnable = wetCurtainWPEnable;
    }

    public Byte getWetCurtainMotorOn() {
        return wetCurtainMotorOn;
    }

    public void setWetCurtainMotorOn(Byte wetCurtainMotorOn) {
        this.wetCurtainMotorOn = wetCurtainMotorOn;
    }

    public Byte getAlarmClockEnable() {
        return alarmClockEnable;
    }

    public void setAlarmClockEnable(Byte alarmClockEnable) {
        this.alarmClockEnable = alarmClockEnable;
    }

    public Byte getTempCurveEnable() {
        return tempCurveEnable;
    }

    public void setTempCurveEnable(Byte tempCurveEnable) {
        this.tempCurveEnable = tempCurveEnable;
    }

    public Byte getMinAirCurveEnable() {
        return minAirCurveEnable;
    }

    public void setMinAirCurveEnable(Byte minAirCurveEnable) {
        this.minAirCurveEnable = minAirCurveEnable;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
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

    public float getNegativePressure() {
        return negativePressure;
    }

    public void setNegativePressure(float negativePressure) {
        this.negativePressure = negativePressure;
    }

    public String getPrepareCode04() {
        return prepareCode04;
    }

    public void setPrepareCode04(String prepareCode04) {
        this.prepareCode04 = prepareCode04;
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
        mdtc6.setData("outTemp4");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("舍外");

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("boilerTemp5");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("炉温");

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("humidityVal");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("湿度");

        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("co2Val");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("CO2");

        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("waterFlowVal");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("饮水");

        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("inAveTemp");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("舍内平均");
        //温度曲线运行到第几天
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("tempCurveRunDays");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("天数");
        //温度曲线运行到第几阶段
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("tempCurveRunStage");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("阶段");

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
        mdtc16.setVisible(false);

        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("frontGuidePlatePct");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("正面导流板");
        mdtc17.setVisible(false);

        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("sideGuidePlatePct");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("侧面导流板");
        mdtc18.setVisible(false);

        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("rollerblind01Pct");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("卷帘1");
        mdtc19.setVisible(false);

        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("rollerblind02Pct");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("卷帘2");
        mdtc20.setVisible(false);

        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("wetCurtainWP");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("湿帘水泵");
        mdtc21.setVisible(false);

        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("fan1On");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("风机1");
        mdtc22.setVisible(false);

        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("fan2On");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("风机2");
        mdtc23.setVisible(false);

        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("fan3On");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("风机3");
        mdtc24.setVisible(false);

        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("fan4On");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("风机4");
        mdtc25.setVisible(false);

        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("fan5On");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("风机5");
        mdtc26.setVisible(false);

        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("fan6On");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("风机6");
        mdtc27.setVisible(false);

        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("fan7On");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("风机7");
        mdtc28.setVisible(false);

        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("fan8On");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("风机8");
        mdtc29.setVisible(false);

        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("fan9On");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("风机9");
        mdtc30.setVisible(false);

        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("fan10On");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("风机10");
        mdtc31.setVisible(false);

        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("fanClockEnable");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("风机定时");
        mdtc32.setVisible(false);

        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("fanChangeEnable");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("风机切换");
        mdtc33.setVisible(false);

        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("boilerOn");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("锅炉");
        mdtc34.setVisible(false);

        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("heatSinkOn");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("散热器");
        mdtc35.setVisible(false);

        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("wetCurtainWPEnable");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("湿帘水泵");
        mdtc36.setVisible(false);

        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("wetCurtainMotorOn");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("湿帘电机");
        mdtc37.setVisible(false);

        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("alarmClockEnable");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("定时报警");
        mdtc38.setVisible(false);

        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("tempCurveEnable");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("温度曲线");
        mdtc39.setVisible(false);

        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("minAirCurveEnable");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("最小通风曲线");
        mdtc40.setVisible(false);

        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("chickenAge");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("日龄");

        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("nh3Val");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("NH3");

        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("negativePressure");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("负压");

        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("alarmCode");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("报警");

        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("errorCode");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("错误");

        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("sendDate");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("发送");

        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("dReceiveTime");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("接收");

        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("dState");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("状态");

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //天数
        myDTCList.add(mdtc12);
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
        //湿度
        myDTCList.add(mdtc8);

        //负压
        myDTCList.add(mdtc43);
        //co2
        myDTCList.add(mdtc9);
        //nh3
        myDTCList.add(mdtc42);
        //日龄
        myDTCList.add(mdtc41);
        //目标温度
        myDTCList.add(mdtc14);
        //炉温
        myDTCList.add(mdtc7);

        //阶段
        myDTCList.add(mdtc13);

        //通风级别
        myDTCList.add(mdtc15);
        //小窗
        myDTCList.add(mdtc16);
        //正面导流板
        myDTCList.add(mdtc17);
        //侧面导流板
        myDTCList.add(mdtc18);
        //卷帘1
        myDTCList.add(mdtc19);
        //卷帘2
        myDTCList.add(mdtc20);
        //湿帘水泵
        myDTCList.add(mdtc21);
        //风机1
        myDTCList.add(mdtc22);
        //风机2
        myDTCList.add(mdtc23);
        //风机3
        myDTCList.add(mdtc24);
        //风机4
        myDTCList.add(mdtc25);
        //风机5
        myDTCList.add(mdtc26);
        //风机6
        myDTCList.add(mdtc27);
        //风机7
        myDTCList.add(mdtc28);
        //风机8
        myDTCList.add(mdtc29);
        //风机9
        myDTCList.add(mdtc30);
        //风机10
        myDTCList.add(mdtc31);
        //风机定时
        myDTCList.add(mdtc32);
        //风机切换
        myDTCList.add(mdtc33);
        //锅炉
        myDTCList.add(mdtc34);
        //散热器
        myDTCList.add(mdtc35);
        //湿帘水泵
        myDTCList.add(mdtc36);
        //湿帘电机
        myDTCList.add(mdtc37);
        //定时报警
        myDTCList.add(mdtc38);
        //温度曲线
        myDTCList.add(mdtc39);
        //最小通风曲线
        myDTCList.add(mdtc40);

        //报警
        myDTCList.add(mdtc44);
        //错误
        myDTCList.add(mdtc45);
        //发送
        myDTCList.add(mdtc46);
        //接收
        myDTCList.add(mdtc47);
        //状态
        myDTCList.add(mdtc48);
        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoDetail()
    {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("inTemp1");
        phoneRealMsgInfo01.setTitle("舍前");
        phoneRealMsgInfo01.setValue(String.valueOf(inTemp1));
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("inTemp2");
        phoneRealMsgInfo02.setTitle("舍中");
        phoneRealMsgInfo02.setValue(String.valueOf(inTemp2));
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("inTemp3");
        phoneRealMsgInfo03.setTitle("舍后");
        phoneRealMsgInfo03.setValue(String.valueOf(inTemp3));
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("inAveTemp");
        phoneRealMsgInfo04.setTitle("室内平均");
        phoneRealMsgInfo04.setValue(String.valueOf(inAveTemp));
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo015 = new PhoneRealMsgInfo();
        phoneRealMsgInfo015.setId("outTemp4");
        phoneRealMsgInfo015.setTitle("舍外");
        phoneRealMsgInfo015.setValue(String.valueOf(outTemp4));
        phoneRealMsgInfo015.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo015);


        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("humidityVal");
        phoneRealMsgInfo05.setTitle("湿度");
        phoneRealMsgInfo05.setValue(String.valueOf(humidityVal));
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("chickenAge");
        phoneRealMsgInfo06.setTitle("日龄");
        phoneRealMsgInfo06.setValue(String.valueOf(chickenAge));
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("nh3Val");
        phoneRealMsgInfo07.setTitle("氨气");
        phoneRealMsgInfo07.setValue(String.valueOf(nh3Val));
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        PhoneRealMsgInfo phoneRealMsgInfo08 = new PhoneRealMsgInfo();
        phoneRealMsgInfo08.setId("negativePressure");
        phoneRealMsgInfo08.setTitle("负压");
        phoneRealMsgInfo08.setValue(String.valueOf(negativePressure));
        phoneRealMsgInfo08.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo08);

        PhoneRealMsgInfo phoneRealMsgInfo13 = new PhoneRealMsgInfo();
        phoneRealMsgInfo13.setId("negativePressure");
        phoneRealMsgInfo13.setTitle("饮水");
        phoneRealMsgInfo13.setValue(String.valueOf(waterFlowVal));
        phoneRealMsgInfo13.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo13);

        PhoneRealMsgInfo phoneRealMsgInfo09 = new PhoneRealMsgInfo();
        phoneRealMsgInfo09.setId("fan1On");
        phoneRealMsgInfo09.setTitle("风机1");
        phoneRealMsgInfo09.setValue(String.valueOf(DataConvertor.getBoolState01On(fan1On)));
        phoneRealMsgInfo09.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo09);

        PhoneRealMsgInfo phoneRealMsgInfo10 = new PhoneRealMsgInfo();
        phoneRealMsgInfo10.setId("fan2On");
        phoneRealMsgInfo10.setTitle("风机2");
        phoneRealMsgInfo10.setValue(String.valueOf(DataConvertor.getBoolState01On(fan2On)));
        phoneRealMsgInfo10.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo10);

        PhoneRealMsgInfo phoneRealMsgInfo11 = new PhoneRealMsgInfo();
        phoneRealMsgInfo11.setId("fan3On");
        phoneRealMsgInfo11.setTitle("风机3");
        phoneRealMsgInfo11.setValue(String.valueOf(DataConvertor.getBoolState01On(fan3On)));
        phoneRealMsgInfo11.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo11);

        PhoneRealMsgInfo phoneRealMsgInfo12 = new PhoneRealMsgInfo();
        phoneRealMsgInfo12.setId("fan4On");
        phoneRealMsgInfo12.setTitle("风机4");
        phoneRealMsgInfo12.setValue(String.valueOf(DataConvertor.getBoolState01On(fan4On)));
        phoneRealMsgInfo12.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo12);

        PhoneRealMsgInfo phoneRealMsgInfo14 = new PhoneRealMsgInfo();
        phoneRealMsgInfo14.setId("dState");
        phoneRealMsgInfo14.setTitle("状态");
        phoneRealMsgInfo14.setValue(getDState());
        phoneRealMsgInfo14.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo14);

        return phoneRealMsgInfoList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary()
    {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("inAveTemp");
        phoneRealMsgInfo04.setTitle("室内平均");
        phoneRealMsgInfo04.setValue(String.valueOf(inAveTemp));
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("humidityVal");
        phoneRealMsgInfo05.setTitle("湿度");
        phoneRealMsgInfo05.setValue(String.valueOf(humidityVal));
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("chickenAge");
        phoneRealMsgInfo06.setTitle("日龄");
        phoneRealMsgInfo06.setValue(String.valueOf(chickenAge));
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo13 = new PhoneRealMsgInfo();
        phoneRealMsgInfo13.setId("negativePressure");
        phoneRealMsgInfo13.setTitle("饮水");
        phoneRealMsgInfo13.setValue(String.valueOf(waterFlowVal));
        phoneRealMsgInfo13.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo13);

        PhoneRealMsgInfo phoneRealMsgInfo09 = new PhoneRealMsgInfo();
        phoneRealMsgInfo09.setId("fan1On");
        phoneRealMsgInfo09.setTitle("风机1");
        phoneRealMsgInfo09.setValue(String.valueOf(DataConvertor.getBoolState01On(fan1On)));
        phoneRealMsgInfo09.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo09);

        PhoneRealMsgInfo phoneRealMsgInfo10 = new PhoneRealMsgInfo();
        phoneRealMsgInfo10.setId("fan2On");
        phoneRealMsgInfo10.setTitle("风机2");
        phoneRealMsgInfo10.setValue(String.valueOf(DataConvertor.getBoolState01On(fan2On)));
        phoneRealMsgInfo10.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo10);

        PhoneRealMsgInfo phoneRealMsgInfo11 = new PhoneRealMsgInfo();
        phoneRealMsgInfo11.setId("fan3On");
        phoneRealMsgInfo11.setTitle("风机3");
        phoneRealMsgInfo11.setValue(String.valueOf(DataConvertor.getBoolState01On(fan3On)));
        phoneRealMsgInfo11.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo11);

        PhoneRealMsgInfo phoneRealMsgInfo12 = new PhoneRealMsgInfo();
        phoneRealMsgInfo12.setId("fan4On");
        phoneRealMsgInfo12.setTitle("风机4");
        phoneRealMsgInfo12.setValue(String.valueOf(DataConvertor.getBoolState01On(fan4On)));
        phoneRealMsgInfo12.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo12);

        PhoneRealMsgInfo phoneRealMsgInfo14 = new PhoneRealMsgInfo();
        phoneRealMsgInfo14.setId("dState");
        phoneRealMsgInfo14.setTitle("状态");
        phoneRealMsgInfo14.setValue(getDState());
        phoneRealMsgInfo14.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo14);

        return phoneRealMsgInfoList;
    }

}
