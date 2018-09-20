package com.system.po.Device;

import com.system.po.MydataTableColumn;

import java.util.ArrayList;
import java.util.List;

public class ScaleC01DeviceMessage extends BaseDeviceMessage {
    //辅助序号
    private String assistSerialNum;
    //系统电压
    private float systemVoltage;
    //称体温度
    private float temp;
    //起始序号
    private int startNum;
    //数量
    private int numData;
    //体重数据
    private int weight01;
    private int weight02;
    private int weight03;
    private int weight04;
    private int weight05;
    private int weight06;
    private int weight07;
    private int weight08;
    private int weight09;
    private int weight10;
    private int weight11;
    private int weight12;
    private int weight13;
    private int weight14;
    private int weight15;
    private int weight16;
    private int weight17;
    private int weight18;
    private int weight19;
    private int weight20;
    private int spareCode01;

    public String getAssistSerialNum() {
        return assistSerialNum;
    }

    public void setAssistSerialNum(String assistSerialNum) {
        this.assistSerialNum = assistSerialNum;
    }

    public float getSystemVoltage() {
        return systemVoltage;
    }

    public void setSystemVoltage(float systemVoltage) {
        this.systemVoltage = systemVoltage;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public int getNumData() {
        return numData;
    }

    public void setNumData(int numData) {
        this.numData = numData;
    }

    public int getWeight01() {
        return weight01;
    }

    public void setWeight01(int weight01) {
        this.weight01 = weight01;
    }

    public int getWeight02() {
        return weight02;
    }

    public void setWeight02(int weight02) {
        this.weight02 = weight02;
    }

    public int getWeight03() {
        return weight03;
    }

    public void setWeight03(int weight03) {
        this.weight03 = weight03;
    }

    public int getWeight04() {
        return weight04;
    }

    public void setWeight04(int weight04) {
        this.weight04 = weight04;
    }

    public int getWeight05() {
        return weight05;
    }

    public void setWeight05(int weight05) {
        this.weight05 = weight05;
    }

    public int getWeight06() {
        return weight06;
    }

    public void setWeight06(int weight06) {
        this.weight06 = weight06;
    }

    public int getWeight07() {
        return weight07;
    }

    public void setWeight07(int weight07) {
        this.weight07 = weight07;
    }

    public int getWeight08() {
        return weight08;
    }

    public void setWeight08(int weight08) {
        this.weight08 = weight08;
    }

    public int getWeight09() {
        return weight09;
    }

    public void setWeight09(int weight09) {
        this.weight09 = weight09;
    }

    public int getWeight10() {
        return weight10;
    }

    public void setWeight10(int weight10) {
        this.weight10 = weight10;
    }

    public int getWeight11() {
        return weight11;
    }

    public void setWeight11(int weight11) {
        this.weight11 = weight11;
    }

    public int getWeight12() {
        return weight12;
    }

    public void setWeight12(int weight12) {
        this.weight12 = weight12;
    }

    public int getWeight13() {
        return weight13;
    }

    public void setWeight13(int weight13) {
        this.weight13 = weight13;
    }

    public int getWeight14() {
        return weight14;
    }

    public void setWeight14(int weight14) {
        this.weight14 = weight14;
    }

    public int getWeight15() {
        return weight15;
    }

    public void setWeight15(int weight15) {
        this.weight15 = weight15;
    }

    public int getWeight16() {
        return weight16;
    }

    public void setWeight16(int weight16) {
        this.weight16 = weight16;
    }

    public int getWeight17() {
        return weight17;
    }

    public void setWeight17(int weight17) {
        this.weight17 = weight17;
    }

    public int getWeight18() {
        return weight18;
    }

    public void setWeight18(int weight18) {
        this.weight18 = weight18;
    }

    public int getWeight19() {
        return weight19;
    }

    public void setWeight19(int weight19) {
        this.weight19 = weight19;
    }

    public int getWeight20() {
        return weight20;
    }

    public void setWeight20(int weight20) {
        this.weight20 = weight20;
    }

    public int getSpareCode01() {
        return spareCode01;
    }

    public void setSpareCode01(int spareCode01) {
        this.spareCode01 = spareCode01;
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

        //系统电压
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("systemVoltage");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("电压");
        mdtc3.setVisible(true);

        //称体温度
        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("temp");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("温度");
        mdtc4.setVisible(true);

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("weight01");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("体重01");
        mdtc5.setVisible(true);

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("weight02");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("体重02");
        mdtc6.setVisible(true);

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("weight03");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("体重03");
        mdtc7.setVisible(true);

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("weight04");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("体重04");
        mdtc8.setVisible(true);

        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("weight05");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("体重05");
        mdtc9.setVisible(true);

        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("weight06");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("体重06");
        mdtc10.setVisible(true);

        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("weight07");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("体重07");
        mdtc11.setVisible(true);

        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("weight08");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("体重08");
        mdtc12.setVisible(true);

        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("weight09");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("体重09");
        mdtc13.setVisible(true);

        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("weight10");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("体重10");
        mdtc14.setVisible(true);

        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("weight11");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("体重11");
        mdtc15.setVisible(false);

        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("weight12");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("体重12");
        mdtc16.setVisible(false);

        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("weight13");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("体重13");
        mdtc17.setVisible(false);

        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("weight14");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("体重14");
        mdtc18.setVisible(false);

        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("weight15");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("体重15");
        mdtc19.setVisible(false);

        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("weight16");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("体重16");
        mdtc20.setVisible(false);

        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("weight17");
        mdtc21.setDefaultContent("20");
        mdtc21.setTitle("体重17");
        mdtc21.setVisible(false);

        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("weight18");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("体重18");
        mdtc22.setVisible(false);

        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("weight19");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("体重19");
        mdtc23.setVisible(false);

        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("weight20");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("体重20");
        mdtc24.setVisible(false);

        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("spareCode01");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("备用");
        mdtc25.setVisible(false);

        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("dReceiveTime");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("接收");

        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("dState");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("状态");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc27);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);
        myDTCList.add(mdtc5);
        myDTCList.add(mdtc6);
        myDTCList.add(mdtc7);
        myDTCList.add(mdtc8);
        myDTCList.add(mdtc9);
        myDTCList.add(mdtc10);
        myDTCList.add(mdtc11);
        myDTCList.add(mdtc12);
        myDTCList.add(mdtc13);
        myDTCList.add(mdtc14);
        myDTCList.add(mdtc15);
        myDTCList.add(mdtc16);
        myDTCList.add(mdtc17);
        myDTCList.add(mdtc18);
        myDTCList.add(mdtc19);
        myDTCList.add(mdtc20);
        myDTCList.add(mdtc21);
        myDTCList.add(mdtc22);
        myDTCList.add(mdtc23);
        myDTCList.add(mdtc24);
        myDTCList.add(mdtc25);
        myDTCList.add(mdtc26);



        return  myDTCList;
    }
}
