package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;

import java.util.ArrayList;
import java.util.List;

public class FeedC411DM extends BaseDeviceMessage {

    //筒仓编号
    String siloNum;
    //电缆数
    int cables;
    //使用状态
    int useState;
    //报警状态
    int alarmState;
    //库存
    float stock;
    //水份
    float water;
    //电缆01测温个数
    int cable01Nums;
    //电缆01在用测温点
    String cable01Used;
    //电缆01测温点故障
    String cable01Fault;
    //电缆02测温个数
    int cable02Nums;
    //电缆02在用测温点
    String cable02Used;
    //电缆02测温点故障
    String cable02Fault;
    //电缆03测温个数
    int cable03Nums;
    //电缆03在用测温点
    String cable03Used;
    //电缆03测温点故障
    String cable03Fault;
    //电缆04测温个数
    int cable04Nums;
    //电缆04在用测温点
    String cable04Used;
    //电缆04测温点故障
    String cable04Fault;
    //电缆05测温个数
    int cable05Nums;
    //电缆05在用测温点
    String cable05Used;
    //电缆05测温点故障
    String cable05Fault;
    //电缆06测温个数
    int cable06Nums;
    //电缆06在用测温点
    String cable06Used;
    //电缆06测温点故障
    String cable06Fault;
    //测温01
    float temp01;
    //测温02
    float temp02;
    //测温03
    float temp03;
    //测温04
    float temp04;
    //测温05
    float temp05;
    //测温06
    float temp06;
    //测温07
    float temp07;
    //测温08
    float temp08;
    //测温09
    float temp09;
    //测温10
    float temp10;

    //测温11
    float temp11;
    //测温12
    float temp12;
    //测温13
    float temp13;
    //测温14
    float temp14;
    //测温15
    float temp15;
    //测温16
    float temp16;
    //测温17
    float temp17;
    //测温18
    float temp18;
    //测温19
    float temp19;
    //测温20
    float temp20;

    //测温21
    float temp21;
    //测温22
    float temp22;
    //测温23
    float temp23;
    //测温24
    float temp24;
    //测温25
    float temp25;
    //测温26
    float temp26;
    //测温27
    float temp27;
    //测温28
    float temp28;
    //测温29
    float temp29;
    //测温30
    float temp30;

    //测温31
    float temp31;
    //测温32
    float temp32;
    //测温33
    float temp33;
    //测温34
    float temp34;
    //测温35
    float temp35;
    //测温36
    float temp36;
    //测温37
    float temp37;
    //测温38
    float temp38;
    //测温39
    float temp39;
    //测温40
    float temp40;

    //测温41
    float temp41;
    //测温42
    float temp42;
    //测温43
    float temp43;
    //测温44
    float temp44;
    //测温45
    float temp45;
    //测温46
    float temp46;
    //测温47
    float temp47;
    //测温48
    float temp48;
    //测温49
    float temp49;
    //测温50
    float temp50;

    //测温51
    float temp51;
    //测温52
    float temp52;
    //测温53
    float temp53;
    //测温54
    float temp54;
    //测温55
    float temp55;
    //测温56
    float temp56;
    //测温57
    float temp57;
    //测温58
    float temp58;
    //测温59
    float temp59;
    //测温60
    float temp60;
    //高温报警阈值
    float highThreshold;
    //湿度01
    float humidity01;
    //湿度02
    float humidity02;
    //湿度03
    float humidity03;
    //湿度04
    float humidity04;
    //湿度05
    float humidity05;
    //湿度06
    float humidity06;
    //环境湿度
    float envHumidity;
    //环境温度
    float envTemp;

    //设备发送数据时间
    private String sendDate;

    public String getSiloNum() {
        return siloNum;
    }

    public void setSiloNum(String siloNum) {
        this.siloNum = siloNum;
    }

    public int getCables() {
        return cables;
    }

    public void setCables(int cables) {
        this.cables = cables;
    }

    public int getUseState() {
        return useState;
    }

    public void setUseState(int useState) {
        this.useState = useState;
    }

    public int getAlarmState() {
        return alarmState;
    }

    public void setAlarmState(int alarmState) {
        this.alarmState = alarmState;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public int getCable01Nums() {
        return cable01Nums;
    }

    public void setCable01Nums(int cable01Nums) {
        this.cable01Nums = cable01Nums;
    }

    public String getCable01Used() {
        return cable01Used;
    }

    public void setCable01Used(String cable01Used) {
        this.cable01Used = cable01Used;
    }

    public String getCable01Fault() {
        return cable01Fault;
    }

    public void setCable01Fault(String cable01Fault) {
        this.cable01Fault = cable01Fault;
    }

    public int getCable02Nums() {
        return cable02Nums;
    }

    public void setCable02Nums(int cable02Nums) {
        this.cable02Nums = cable02Nums;
    }

    public String getCable02Used() {
        return cable02Used;
    }

    public void setCable02Used(String cable02Used) {
        this.cable02Used = cable02Used;
    }

    public String getCable02Fault() {
        return cable02Fault;
    }

    public void setCable02Fault(String cable02Fault) {
        this.cable02Fault = cable02Fault;
    }

    public int getCable03Nums() {
        return cable03Nums;
    }

    public void setCable03Nums(int cable03Nums) {
        this.cable03Nums = cable03Nums;
    }

    public String getCable03Used() {
        return cable03Used;
    }

    public void setCable03Used(String cable03Used) {
        this.cable03Used = cable03Used;
    }

    public String getCable03Fault() {
        return cable03Fault;
    }

    public void setCable03Fault(String cable03Fault) {
        this.cable03Fault = cable03Fault;
    }

    public int getCable04Nums() {
        return cable04Nums;
    }

    public void setCable04Nums(int cable04Nums) {
        this.cable04Nums = cable04Nums;
    }

    public String getCable04Used() {
        return cable04Used;
    }

    public void setCable04Used(String cable04Used) {
        this.cable04Used = cable04Used;
    }

    public String getCable04Fault() {
        return cable04Fault;
    }

    public void setCable04Fault(String cable04Fault) {
        this.cable04Fault = cable04Fault;
    }

    public int getCable05Nums() {
        return cable05Nums;
    }

    public void setCable05Nums(int cable05Nums) {
        this.cable05Nums = cable05Nums;
    }

    public String getCable05Used() {
        return cable05Used;
    }

    public void setCable05Used(String cable05Used) {
        this.cable05Used = cable05Used;
    }

    public String getCable05Fault() {
        return cable05Fault;
    }

    public void setCable05Fault(String cable05Fault) {
        this.cable05Fault = cable05Fault;
    }

    public int getCable06Nums() {
        return cable06Nums;
    }

    public void setCable06Nums(int cable06Nums) {
        this.cable06Nums = cable06Nums;
    }

    public String getCable06Used() {
        return cable06Used;
    }

    public void setCable06Used(String cable06Used) {
        this.cable06Used = cable06Used;
    }

    public String getCable06Fault() {
        return cable06Fault;
    }

    public void setCable06Fault(String cable06Fault) {
        this.cable06Fault = cable06Fault;
    }

    public float getTemp01() {
        return temp01;
    }

    public void setTemp01(float temp01) {
        this.temp01 = temp01;
    }

    public float getTemp02() {
        return temp02;
    }

    public void setTemp02(float temp02) {
        this.temp02 = temp02;
    }

    public float getTemp03() {
        return temp03;
    }

    public void setTemp03(float temp03) {
        this.temp03 = temp03;
    }

    public float getTemp04() {
        return temp04;
    }

    public void setTemp04(float temp04) {
        this.temp04 = temp04;
    }

    public float getTemp05() {
        return temp05;
    }

    public void setTemp05(float temp05) {
        this.temp05 = temp05;
    }

    public float getTemp06() {
        return temp06;
    }

    public void setTemp06(float temp06) {
        this.temp06 = temp06;
    }

    public float getTemp07() {
        return temp07;
    }

    public void setTemp07(float temp07) {
        this.temp07 = temp07;
    }

    public float getTemp08() {
        return temp08;
    }

    public void setTemp08(float temp08) {
        this.temp08 = temp08;
    }

    public float getTemp09() {
        return temp09;
    }

    public void setTemp09(float temp09) {
        this.temp09 = temp09;
    }

    public float getTemp10() {
        return temp10;
    }

    public void setTemp10(float temp10) {
        this.temp10 = temp10;
    }

    public float getTemp11() {
        return temp11;
    }

    public void setTemp11(float temp11) {
        this.temp11 = temp11;
    }

    public float getTemp12() {
        return temp12;
    }

    public void setTemp12(float temp12) {
        this.temp12 = temp12;
    }

    public float getTemp13() {
        return temp13;
    }

    public void setTemp13(float temp13) {
        this.temp13 = temp13;
    }

    public float getTemp14() {
        return temp14;
    }

    public void setTemp14(float temp14) {
        this.temp14 = temp14;
    }

    public float getTemp15() {
        return temp15;
    }

    public void setTemp15(float temp15) {
        this.temp15 = temp15;
    }

    public float getTemp16() {
        return temp16;
    }

    public void setTemp16(float temp16) {
        this.temp16 = temp16;
    }

    public float getTemp17() {
        return temp17;
    }

    public void setTemp17(float temp17) {
        this.temp17 = temp17;
    }

    public float getTemp18() {
        return temp18;
    }

    public void setTemp18(float temp18) {
        this.temp18 = temp18;
    }

    public float getTemp19() {
        return temp19;
    }

    public void setTemp19(float temp19) {
        this.temp19 = temp19;
    }

    public float getTemp20() {
        return temp20;
    }

    public void setTemp20(float temp20) {
        this.temp20 = temp20;
    }

    public float getTemp21() {
        return temp21;
    }

    public void setTemp21(float temp21) {
        this.temp21 = temp21;
    }

    public float getTemp22() {
        return temp22;
    }

    public void setTemp22(float temp22) {
        this.temp22 = temp22;
    }

    public float getTemp23() {
        return temp23;
    }

    public void setTemp23(float temp23) {
        this.temp23 = temp23;
    }

    public float getTemp24() {
        return temp24;
    }

    public void setTemp24(float temp24) {
        this.temp24 = temp24;
    }

    public float getTemp25() {
        return temp25;
    }

    public void setTemp25(float temp25) {
        this.temp25 = temp25;
    }

    public float getTemp26() {
        return temp26;
    }

    public void setTemp26(float temp26) {
        this.temp26 = temp26;
    }

    public float getTemp27() {
        return temp27;
    }

    public void setTemp27(float temp27) {
        this.temp27 = temp27;
    }

    public float getTemp28() {
        return temp28;
    }

    public void setTemp28(float temp28) {
        this.temp28 = temp28;
    }

    public float getTemp29() {
        return temp29;
    }

    public void setTemp29(float temp29) {
        this.temp29 = temp29;
    }

    public float getTemp30() {
        return temp30;
    }

    public void setTemp30(float temp30) {
        this.temp30 = temp30;
    }

    public float getTemp31() {
        return temp31;
    }

    public void setTemp31(float temp31) {
        this.temp31 = temp31;
    }

    public float getTemp32() {
        return temp32;
    }

    public void setTemp32(float temp32) {
        this.temp32 = temp32;
    }

    public float getTemp33() {
        return temp33;
    }

    public void setTemp33(float temp33) {
        this.temp33 = temp33;
    }

    public float getTemp34() {
        return temp34;
    }

    public void setTemp34(float temp34) {
        this.temp34 = temp34;
    }

    public float getTemp35() {
        return temp35;
    }

    public void setTemp35(float temp35) {
        this.temp35 = temp35;
    }

    public float getTemp36() {
        return temp36;
    }

    public void setTemp36(float temp36) {
        this.temp36 = temp36;
    }

    public float getTemp37() {
        return temp37;
    }

    public void setTemp37(float temp37) {
        this.temp37 = temp37;
    }

    public float getTemp38() {
        return temp38;
    }

    public void setTemp38(float temp38) {
        this.temp38 = temp38;
    }

    public float getTemp39() {
        return temp39;
    }

    public void setTemp39(float temp39) {
        this.temp39 = temp39;
    }

    public float getTemp40() {
        return temp40;
    }

    public void setTemp40(float temp40) {
        this.temp40 = temp40;
    }

    public float getTemp41() {
        return temp41;
    }

    public void setTemp41(float temp41) {
        this.temp41 = temp41;
    }

    public float getTemp42() {
        return temp42;
    }

    public void setTemp42(float temp42) {
        this.temp42 = temp42;
    }

    public float getTemp43() {
        return temp43;
    }

    public void setTemp43(float temp43) {
        this.temp43 = temp43;
    }

    public float getTemp44() {
        return temp44;
    }

    public void setTemp44(float temp44) {
        this.temp44 = temp44;
    }

    public float getTemp45() {
        return temp45;
    }

    public void setTemp45(float temp45) {
        this.temp45 = temp45;
    }

    public float getTemp46() {
        return temp46;
    }

    public void setTemp46(float temp46) {
        this.temp46 = temp46;
    }

    public float getTemp47() {
        return temp47;
    }

    public void setTemp47(float temp47) {
        this.temp47 = temp47;
    }

    public float getTemp48() {
        return temp48;
    }

    public void setTemp48(float temp48) {
        this.temp48 = temp48;
    }

    public float getTemp49() {
        return temp49;
    }

    public void setTemp49(float temp49) {
        this.temp49 = temp49;
    }

    public float getTemp50() {
        return temp50;
    }

    public void setTemp50(float temp50) {
        this.temp50 = temp50;
    }

    public float getTemp51() {
        return temp51;
    }

    public void setTemp51(float temp51) {
        this.temp51 = temp51;
    }

    public float getTemp52() {
        return temp52;
    }

    public void setTemp52(float temp52) {
        this.temp52 = temp52;
    }

    public float getTemp53() {
        return temp53;
    }

    public void setTemp53(float temp53) {
        this.temp53 = temp53;
    }

    public float getTemp54() {
        return temp54;
    }

    public void setTemp54(float temp54) {
        this.temp54 = temp54;
    }

    public float getTemp55() {
        return temp55;
    }

    public void setTemp55(float temp55) {
        this.temp55 = temp55;
    }

    public float getTemp56() {
        return temp56;
    }

    public void setTemp56(float temp56) {
        this.temp56 = temp56;
    }

    public float getTemp57() {
        return temp57;
    }

    public void setTemp57(float temp57) {
        this.temp57 = temp57;
    }

    public float getTemp58() {
        return temp58;
    }

    public void setTemp58(float temp58) {
        this.temp58 = temp58;
    }

    public float getTemp59() {
        return temp59;
    }

    public void setTemp59(float temp59) {
        this.temp59 = temp59;
    }

    public float getTemp60() {
        return temp60;
    }

    public void setTemp60(float temp60) {
        this.temp60 = temp60;
    }

    public float getHighThreshold() {
        return highThreshold;
    }

    public void setHighThreshold(float highThreshold) {
        this.highThreshold = highThreshold;
    }

    public float getHumidity01() {
        return humidity01;
    }

    public void setHumidity01(float humidity01) {
        this.humidity01 = humidity01;
    }

    public float getHumidity02() {
        return humidity02;
    }

    public void setHumidity02(float humidity02) {
        this.humidity02 = humidity02;
    }

    public float getHumidity03() {
        return humidity03;
    }

    public void setHumidity03(float humidity03) {
        this.humidity03 = humidity03;
    }

    public float getHumidity04() {
        return humidity04;
    }

    public void setHumidity04(float humidity04) {
        this.humidity04 = humidity04;
    }

    public float getHumidity05() {
        return humidity05;
    }

    public void setHumidity05(float humidity05) {
        this.humidity05 = humidity05;
    }

    public float getHumidity06() {
        return humidity06;
    }

    public void setHumidity06(float humidity06) {
        this.humidity06 = humidity06;
    }

    public float getEnvHumidity() {
        return envHumidity;
    }

    public void setEnvHumidity(float envHumidity) {
        this.envHumidity = envHumidity;
    }

    public float getEnvTemp() {
        return envTemp;
    }

    public void setEnvTemp(float envTemp) {
        this.envTemp = envTemp;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public FeedC411DM(){}

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
        MydataTableColumn mdtc109 = new MydataTableColumn();
        mdtc109.setData("sendDate");
        mdtc109.setDefaultContent("109");
        mdtc109.setTitle("时间");
        mdtc109.setVisible(true);

        //设备在线状态
        MydataTableColumn mdtc110 = new MydataTableColumn();
        mdtc110.setData("dState");
        mdtc110.setDefaultContent("110");
        mdtc110.setTitle("状态");
        mdtc110.setVisible(true);

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //设备在线状态
        myDTCList.add(mdtc110);
        //设备发送数据时间
        myDTCList.add(mdtc109);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("useState");
        phoneRealMsgInfo01.setTitle("状态：");
        if(this.getUseState() == 1){
            phoneRealMsgInfo01.setValue("缓用");
        }else{
            phoneRealMsgInfo01.setValue("使用");
        }
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("stock");
        phoneRealMsgInfo07.setTitle("库存：");
        phoneRealMsgInfo07.setValue(String.valueOf(this.getStock()) + "吨");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        PhoneRealMsgInfo phoneRealMsgInfo08 = new PhoneRealMsgInfo();
        phoneRealMsgInfo08.setId("water");
        phoneRealMsgInfo08.setTitle("水份：");
        phoneRealMsgInfo08.setValue(String.valueOf(this.getWater()) + "%");
        phoneRealMsgInfo08.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo08);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("dState");
        phoneRealMsgInfo05.setTitle("状态：");
        phoneRealMsgInfo05.setValue(this.getSendDate());
        phoneRealMsgInfo05.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("sendDate");
        phoneRealMsgInfo06.setTitle("");
        phoneRealMsgInfo06.setValue(this.getSendDate());
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        return phoneRealMsgInfoList;
    }
}
