package com.system.po.Device.FeedC411;

import com.system.po.Device.FeedC411DM;
import com.system.po.FeedC411.SiloCable;
import com.system.po.FeedC411.SiloFloor;
import com.system.po.FeedC411.SiloTemp;
import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 * 安徽阜阳分公司-饲料部
 */
public class FeedC411DMFY {

    FeedC411DM feedC411DM;
    /**
     * 筒仓电缆
     */
    List<SiloCable> cableList;
    /**
     * 筒仓层
     */
    List<SiloFloor> floors;

    /**最高温*/
    float high;
    /**最低温*/
    float low;
    /**平均温*/
    float avg;
    /**
     * 最高温颜色
     */
    String highColor;
    /**
     * 最低温颜色
     */
    String lowColor;
    /**
     * 平均温颜色
     */
    String avgColor;

    public FeedC411DM getFeedC411DM() {
        return feedC411DM;
    }

    public void setFeedC411DM(FeedC411DM feedC411DM) {
        this.feedC411DM = feedC411DM;
    }

    public List<SiloCable> getCableList() {
        return cableList;
    }

    public void setCableList(List<SiloCable> cableList) {
        this.cableList = cableList;
    }

    public List<SiloFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<SiloFloor> floors) {
        this.floors = floors;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getHighColor() {
        return highColor;
    }

    public void setHighColor(String highColor) {
        this.highColor = highColor;
    }

    public String getLowColor() {
        return lowColor;
    }

    public void setLowColor(String lowColor) {
        this.lowColor = lowColor;
    }

    public String getAvgColor() {
        return avgColor;
    }

    public void setAvgColor(String avgColor) {
        this.avgColor = avgColor;
    }

    public FeedC411DMFY(){}

    public FeedC411DMFY(FeedC411DM feedC411DM){
        this.setFeedC411DM(feedC411DM);
        this.formatTemp();
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

        //电缆1
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("temp01");
        mdtc3.setDefaultContent("1-01");
        mdtc3.setTitle("1-01");
        mdtc3.setVisible(true);

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("temp02");
        mdtc4.setDefaultContent("1-02");
        mdtc4.setTitle("1-02");
        mdtc4.setVisible(true);

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("temp03");
        mdtc5.setDefaultContent("1-03");
        mdtc5.setTitle("1-03");
        mdtc5.setVisible(true);

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("temp04");
        mdtc6.setDefaultContent("1-04");
        mdtc6.setTitle("1-04");
        mdtc6.setVisible(true);

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("temp05");
        mdtc7.setDefaultContent("1-05");
        mdtc7.setTitle("1-05");
        mdtc7.setVisible(true);

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("temp06");
        mdtc8.setDefaultContent("1-06");
        mdtc8.setTitle("1-06");
        mdtc8.setVisible(true);

        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("temp07");
        mdtc9.setDefaultContent("1-07");
        mdtc9.setTitle("1-07");
        mdtc9.setVisible(true);

        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("temp08");
        mdtc10.setDefaultContent("1-08");
        mdtc10.setTitle("1-08");
        mdtc10.setVisible(true);

        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("temp09");
        mdtc11.setDefaultContent("1-09");
        mdtc11.setTitle("1-09");
        mdtc11.setVisible(true);

        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("temp10");
        mdtc12.setDefaultContent("1-10");
        mdtc12.setTitle("1-10");
        mdtc12.setVisible(true);

        //电缆2
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("temp11");
        mdtc13.setDefaultContent("2-01");
        mdtc13.setTitle("2-01");
        mdtc13.setVisible(true);

        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("temp12");
        mdtc14.setDefaultContent("2-02");
        mdtc14.setTitle("2-02");
        mdtc14.setVisible(true);

        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("temp13");
        mdtc15.setDefaultContent("2-03");
        mdtc15.setTitle("2-03");
        mdtc15.setVisible(true);

        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("temp14");
        mdtc16.setDefaultContent("2-04");
        mdtc16.setTitle("2-04");
        mdtc16.setVisible(true);

        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("temp15");
        mdtc17.setDefaultContent("2-05");
        mdtc17.setTitle("2-05");
        mdtc17.setVisible(true);

        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("temp16");
        mdtc18.setDefaultContent("2-06");
        mdtc18.setTitle("2-06");
        mdtc18.setVisible(true);

        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("temp17");
        mdtc19.setDefaultContent("2-07");
        mdtc19.setTitle("2-07");
        mdtc19.setVisible(true);

        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("temp18");
        mdtc20.setDefaultContent("2-08");
        mdtc20.setTitle("2-08");
        mdtc20.setVisible(true);

        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("temp19");
        mdtc21.setDefaultContent("2-09");
        mdtc21.setTitle("2-09");
        mdtc21.setVisible(true);

        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("temp20");
        mdtc22.setDefaultContent("2-10");
        mdtc22.setTitle("2-10");
        mdtc22.setVisible(true);

        //电缆3
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("temp21");
        mdtc23.setDefaultContent("3-01");
        mdtc23.setTitle("3-01");
        mdtc23.setVisible(true);

        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("temp22");
        mdtc24.setDefaultContent("3-02");
        mdtc24.setTitle("3-02");
        mdtc24.setVisible(true);

        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("temp23");
        mdtc25.setDefaultContent("3-03");
        mdtc25.setTitle("3-03");
        mdtc25.setVisible(true);

        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("temp24");
        mdtc26.setDefaultContent("3-04");
        mdtc26.setTitle("3-04");
        mdtc26.setVisible(true);

        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("temp25");
        mdtc27.setDefaultContent("3-05");
        mdtc27.setTitle("3-05");
        mdtc27.setVisible(true);

        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("temp26");
        mdtc28.setDefaultContent("3-06");
        mdtc28.setTitle("3-06");
        mdtc28.setVisible(true);

        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("temp27");
        mdtc29.setDefaultContent("3-07");
        mdtc29.setTitle("3-07");
        mdtc29.setVisible(true);

        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("temp28");
        mdtc30.setDefaultContent("3-08");
        mdtc30.setTitle("3-08");
        mdtc30.setVisible(true);

        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("temp29");
        mdtc31.setDefaultContent("3-09");
        mdtc31.setTitle("3-09");
        mdtc31.setVisible(true);

        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("temp30");
        mdtc32.setDefaultContent("3-10");
        mdtc32.setTitle("3-10");
        mdtc32.setVisible(true);

        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("humidity01");
        mdtc33.setDefaultContent("仓内湿度");
        mdtc33.setTitle("仓内湿度");
        mdtc33.setVisible(true);

        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("envHumidity");
        mdtc34.setDefaultContent("环境湿度");
        mdtc34.setTitle("环境湿度");
        mdtc34.setVisible(true);

        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("useState");
        mdtc35.setDefaultContent("使用状态");
        mdtc35.setTitle("使用状态");
        mdtc35.setVisible(true);

        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("stock");
        mdtc36.setDefaultContent("库存");
        mdtc36.setTitle("库存");
        mdtc36.setVisible(true);

        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("water");
        mdtc37.setDefaultContent("水份");
        mdtc37.setTitle("水份");
        mdtc37.setVisible(true);

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
        //仓内湿度
        myDTCList.add(mdtc33);
        //环境湿度
        myDTCList.add(mdtc34);
        //使用状态
        myDTCList.add(mdtc35);
        //库存
        myDTCList.add(mdtc36);
        //水份
        myDTCList.add(mdtc37);
        //电缆01
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
        //电缆02
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
        //电缆03
        myDTCList.add(mdtc23);
        myDTCList.add(mdtc24);
        myDTCList.add(mdtc25);
        myDTCList.add(mdtc26);
        myDTCList.add(mdtc27);
        myDTCList.add(mdtc28);
        myDTCList.add(mdtc29);
        myDTCList.add(mdtc30);
        myDTCList.add(mdtc31);
        myDTCList.add(mdtc32);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("useState");
        phoneRealMsgInfo01.setTitle("状态：");
        if(this.getFeedC411DM().getUseState() == 1){
            phoneRealMsgInfo01.setValue("缓用");
        }else{
            phoneRealMsgInfo01.setValue("使用");
        }
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("avg");
        phoneRealMsgInfo02.setTitle("平均温：");
        phoneRealMsgInfo02.setValue(String.valueOf(this.getAvg())+ "℃");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("high");
        phoneRealMsgInfo03.setTitle("最高温：");
        phoneRealMsgInfo03.setValue(String.valueOf(this.getHigh())+ "℃");
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("low");
        phoneRealMsgInfo04.setTitle("最低温：");
        phoneRealMsgInfo04.setValue(String.valueOf(this.getLow())+ "℃");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("stock");
        phoneRealMsgInfo07.setTitle("库存：");
        phoneRealMsgInfo07.setValue(String.valueOf(this.getFeedC411DM().getStock()) + "吨");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        PhoneRealMsgInfo phoneRealMsgInfo08 = new PhoneRealMsgInfo();
        phoneRealMsgInfo08.setId("water");
        phoneRealMsgInfo08.setTitle("水份：");
        phoneRealMsgInfo08.setValue(String.valueOf(this.getFeedC411DM().getWater()) + "%");
        phoneRealMsgInfo08.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo08);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("dState");
        phoneRealMsgInfo05.setTitle("状态：");
        phoneRealMsgInfo05.setValue(this.getFeedC411DM().getSendDate());
        phoneRealMsgInfo05.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("sendDate");
        phoneRealMsgInfo06.setTitle("");
        phoneRealMsgInfo06.setValue(this.getFeedC411DM().getSendDate());
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        return phoneRealMsgInfoList;
    }

    private void formatTemp(){
        //判断电缆数
        if(this.getFeedC411DM().getCables() < 1)
            return;
        if(this.getFeedC411DM().getCable01Nums() > 0){
            //筒仓电缆
            this.setCableList(formatSC());
            //每一层 这里一共10层，为了显示服务
            this.setFloors(formatFloor());
            //全仓最高温
            this.setHigh(countHigh(this.getCableList()));
            //全仓最低温
            this.setLow(countLow(this.getCableList()));
            //全仓平均温度
            this.setAvg(countAvg(this.getCableList()));
            if(this.getHigh() > this.getFeedC411DM().getHighThreshold())
                this.setHighColor("FF0000");
            else
                this.setHighColor("000000");
            if(this.getLow() > this.getFeedC411DM().getHighThreshold())
                this.setLowColor("FF0000");
            else
                this.setLowColor("000000");
            if(this.getAvg() > this.getFeedC411DM().getHighThreshold())
                this.setAvgColor("FF0000");
            else
                this.setAvgColor("000000");
        }
    }

    /**
     * 所有电缆的温度值获取,阜阳就3个电缆
     * @return
     */
    private List<SiloCable> formatSC(){
        List<SiloCable> siloCableList = new ArrayList<>();
        //第一根电缆
        SiloCable siloCable01 = new SiloCable(1,this.getFeedC411DM().getCable01Nums(),formatST01());
        //第二根电缆
        SiloCable siloCable02 = new SiloCable(2,this.getFeedC411DM().getCable02Nums(),formatST02());
        //第三根电缆
        SiloCable siloCable03 = new SiloCable(3,this.getFeedC411DM().getCable03Nums(),formatST03());
        siloCableList.add(siloCable01);
        siloCableList.add(siloCable02);
        siloCableList.add(siloCable03);
        return siloCableList;
    }

    //获取第一根电缆的温度值
    private List<SiloTemp> formatST01(){
        List<SiloTemp> siloTempList = new ArrayList<>();
        SiloTemp siloTemp01 = new SiloTemp(1,this.getFeedC411DM().getTemp01(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp02 = new SiloTemp(2,this.getFeedC411DM().getTemp02(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp03 = new SiloTemp(3,this.getFeedC411DM().getTemp03(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp04 = new SiloTemp(4,this.getFeedC411DM().getTemp04(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp05 = new SiloTemp(5,this.getFeedC411DM().getTemp05(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp06 = new SiloTemp(6,this.getFeedC411DM().getTemp06(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp07 = new SiloTemp(7,this.getFeedC411DM().getTemp07(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp08 = new SiloTemp(8,this.getFeedC411DM().getTemp08(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp09 = new SiloTemp(9,this.getFeedC411DM().getTemp09(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp10 = new SiloTemp(10,this.getFeedC411DM().getTemp10(),this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        siloTempList.add(siloTemp01);
        siloTempList.add(siloTemp02);
        siloTempList.add(siloTemp03);
        siloTempList.add(siloTemp04);
        siloTempList.add(siloTemp05);
        siloTempList.add(siloTemp06);
        siloTempList.add(siloTemp07);
        siloTempList.add(siloTemp08);
        siloTempList.add(siloTemp09);
        siloTempList.add(siloTemp10);
        return siloTempList;
    }

    //获取第二根电缆的温度值
    private List<SiloTemp> formatST02(){
        List<SiloTemp> siloTempList = new ArrayList<>();
        SiloTemp siloTemp01 = new SiloTemp(1,this.getFeedC411DM().getTemp11(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp02 = new SiloTemp(2,this.getFeedC411DM().getTemp12(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp03 = new SiloTemp(3,this.getFeedC411DM().getTemp13(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp04 = new SiloTemp(4,this.getFeedC411DM().getTemp14(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp05 = new SiloTemp(5,this.getFeedC411DM().getTemp15(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp06 = new SiloTemp(6,this.getFeedC411DM().getTemp16(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp07 = new SiloTemp(7,this.getFeedC411DM().getTemp17(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp08 = new SiloTemp(8,this.getFeedC411DM().getTemp18(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp09 = new SiloTemp(9,this.getFeedC411DM().getTemp19(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp10 = new SiloTemp(10,this.getFeedC411DM().getTemp20(),this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        siloTempList.add(siloTemp01);
        siloTempList.add(siloTemp02);
        siloTempList.add(siloTemp03);
        siloTempList.add(siloTemp04);
        siloTempList.add(siloTemp05);
        siloTempList.add(siloTemp06);
        siloTempList.add(siloTemp07);
        siloTempList.add(siloTemp08);
        siloTempList.add(siloTemp09);
        siloTempList.add(siloTemp10);
        return siloTempList;
    }

    //获取第三根电缆的温度值
    private List<SiloTemp> formatST03(){
        List<SiloTemp> siloTempList = new ArrayList<>();
        SiloTemp siloTemp01 = new SiloTemp(1,this.getFeedC411DM().getTemp21(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp02 = new SiloTemp(2,this.getFeedC411DM().getTemp22(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp03 = new SiloTemp(3,this.getFeedC411DM().getTemp23(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp04 = new SiloTemp(4,this.getFeedC411DM().getTemp24(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp05 = new SiloTemp(5,this.getFeedC411DM().getTemp25(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp06 = new SiloTemp(6,this.getFeedC411DM().getTemp26(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp07 = new SiloTemp(7,this.getFeedC411DM().getTemp27(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp08 = new SiloTemp(8,this.getFeedC411DM().getTemp28(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp09 = new SiloTemp(9,this.getFeedC411DM().getTemp29(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        SiloTemp siloTemp10 = new SiloTemp(10,this.getFeedC411DM().getTemp30(),this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        siloTempList.add(siloTemp01);
        siloTempList.add(siloTemp02);
        siloTempList.add(siloTemp03);
        siloTempList.add(siloTemp04);
        siloTempList.add(siloTemp05);
        siloTempList.add(siloTemp06);
        siloTempList.add(siloTemp07);
        siloTempList.add(siloTemp08);
        siloTempList.add(siloTemp09);
        siloTempList.add(siloTemp10);
        return siloTempList;
    }

    private List<SiloFloor> formatFloor(){
        List<SiloFloor> siloFloorList = new ArrayList<>();
        SiloFloor siloFloor01 = new SiloFloor(1,
                formatFloorTemp(1,this.getFeedC411DM().getTemp01(),this.getFeedC411DM().getTemp11(),this.getFeedC411DM().getTemp21()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor02 = new SiloFloor(2,
                formatFloorTemp(2,this.getFeedC411DM().getTemp02(),this.getFeedC411DM().getTemp12(),this.getFeedC411DM().getTemp22()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor03 = new SiloFloor(3,
                formatFloorTemp(3,this.getFeedC411DM().getTemp03(),this.getFeedC411DM().getTemp13(),this.getFeedC411DM().getTemp23()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor04 = new SiloFloor(4,
                formatFloorTemp(4,this.getFeedC411DM().getTemp04(),this.getFeedC411DM().getTemp14(),this.getFeedC411DM().getTemp24()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor05 = new SiloFloor(5,
                formatFloorTemp(5,this.getFeedC411DM().getTemp05(),this.getFeedC411DM().getTemp15(),this.getFeedC411DM().getTemp25()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor06 = new SiloFloor(6,
                formatFloorTemp(6,this.getFeedC411DM().getTemp06(),this.getFeedC411DM().getTemp16(),this.getFeedC411DM().getTemp26()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor07 = new SiloFloor(7,
                formatFloorTemp(7,this.getFeedC411DM().getTemp07(),this.getFeedC411DM().getTemp17(),this.getFeedC411DM().getTemp27()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor08 = new SiloFloor(8,
                formatFloorTemp(8,this.getFeedC411DM().getTemp08(),this.getFeedC411DM().getTemp18(),this.getFeedC411DM().getTemp28()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor09 = new SiloFloor(9,
                formatFloorTemp(9,this.getFeedC411DM().getTemp09(),this.getFeedC411DM().getTemp19(),this.getFeedC411DM().getTemp29()),
                this.getFeedC411DM().getHighThreshold());
        SiloFloor siloFloor10 = new SiloFloor(10,
                formatFloorTemp(10,this.getFeedC411DM().getTemp10(),this.getFeedC411DM().getTemp20(),this.getFeedC411DM().getTemp30()),
                this.getFeedC411DM().getHighThreshold());
        siloFloorList.add(siloFloor01);
        siloFloorList.add(siloFloor02);
        siloFloorList.add(siloFloor03);
        siloFloorList.add(siloFloor04);
        siloFloorList.add(siloFloor05);
        siloFloorList.add(siloFloor06);
        siloFloorList.add(siloFloor07);
        siloFloorList.add(siloFloor08);
        siloFloorList.add(siloFloor09);
        siloFloorList.add(siloFloor10);
        return siloFloorList;
    }

    /**
     * 第N层
     * @return
     */
    private List<SiloTemp> formatFloorTemp(int num,float temp1,float temp2,float temp3){
        List<SiloTemp> siloTempList = new ArrayList<>();
        //new对象的时候方便计算不同位置上的温度状态，这里的序号无效
        SiloTemp siloTemp01 = new SiloTemp(num,temp1,this.getFeedC411DM().getCable01Used(),this.getFeedC411DM().getCable01Fault(),this.getFeedC411DM().getHighThreshold());
        //重新赋值序号
        siloTemp01.setNum(1);
        //new对象的时候方便计算不同位置上的温度状态，这里的序号无效
        SiloTemp siloTemp02 = new SiloTemp(num,temp2,this.getFeedC411DM().getCable02Used(),this.getFeedC411DM().getCable02Fault(),this.getFeedC411DM().getHighThreshold());
        //重新赋值序号
        siloTemp02.setNum(2);
        //new对象的时候方便计算不同位置上的温度状态，这里的序号无效
        SiloTemp siloTemp03 = new SiloTemp(num,temp3,this.getFeedC411DM().getCable03Used(),this.getFeedC411DM().getCable03Fault(),this.getFeedC411DM().getHighThreshold());
        //重新赋值序号
        siloTemp03.setNum(3);
        siloTempList.add(siloTemp01);
        siloTempList.add(siloTemp02);
        siloTempList.add(siloTemp03);
        return siloTempList;
    }

    /**
     * 计算最高温
     * @return
     */
    private float countHigh(List<SiloCable> siloCableList){
        float high = -100;
        for (SiloCable sc:siloCableList
             ) {
            if(sc.getHigh() > high)
                high = sc.getHigh();
        }
        return high;
    }

    /**
     * 计算最低温
     * @param siloCableList
     * @return
     */
    private float countLow(List<SiloCable> siloCableList){
        float low= 100;
        for (SiloCable sc:siloCableList
             ) {
            if(low > sc.getLow())
                low=sc.getLow();
        }
        return low;
    }

    /**
     * 计算平均温
     * @param siloCableList
     * @return
     */
    private float countAvg(List<SiloCable> siloCableList){
        float avg = 0;
        float accum = 0;
        int icount = 0;
        for (SiloCable sc:siloCableList
        ) {
            if(sc.getAvg() > 0) {
                accum = sc.getAvg();
                icount = icount + 1;
            }
        }
        if(accum > 0)
            avg = accum / icount;
        return DataConvertor.formatFloat(avg,1);
    }
}
