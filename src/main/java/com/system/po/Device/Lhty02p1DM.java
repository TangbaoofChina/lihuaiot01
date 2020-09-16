package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lhty02p1DM
 * @Description 立华断电报警器
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
@Data
public class Lhty02p1DM extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //温度A
    Float tempA;
    //湿度A
    Float humiA;
    //温度B
    Float tempB;
    //湿度B
    Float humiB;
    //电压A
    int volA;
    //电压B
    int volB;
    //电压C
    int volC;
    //高温报警
    int high;
    //低温报警
    int low;
    //缺相报警
    int lack;
    //偏相报警
    int unbalance;
    //烟感报警
    int smoke;
    //断电报警
    int cutOut;
    //自测报警
    int test;
    //总报警状态
    int total;

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

        //温度A
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("tempA");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("温度01");
        mdtc10.setVisible(true);
        myDTCList.add(mdtc10);

        //湿度A
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("humiA");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("湿度A");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        //温度B
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("tempB");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("温度B");
        mdtc12.setVisible(true);
        myDTCList.add(mdtc12);

        //湿度B
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("humiB");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("湿度B");
        mdtc13.setVisible(true);
        myDTCList.add(mdtc13);

        //电压A
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("volA");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("电压A");
        mdtc14.setVisible(true);
        myDTCList.add(mdtc14);

        //电压B
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("volB");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("电压B");
        mdtc15.setVisible(true);
        myDTCList.add(mdtc15);

        //电压C
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("volC");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("电压C");
        mdtc16.setVisible(true);
        myDTCList.add(mdtc16);

        //高温报警
        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("high");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("高温");
        mdtc17.setVisible(true);
        myDTCList.add(mdtc17);

        //低温报警
        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("low");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("低温");
        mdtc18.setVisible(true);
        myDTCList.add(mdtc18);

        //缺相报警
        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("lack");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("缺相");
        mdtc19.setVisible(true);
        myDTCList.add(mdtc19);

        //偏相报警
        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("unbalance");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("偏相");
        mdtc20.setVisible(true);
        myDTCList.add(mdtc20);

        //烟感报警
        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("smoke");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("烟感");
        mdtc21.setVisible(true);
        myDTCList.add(mdtc21);

        //断电报警
        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("cutOut");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("断电");
        mdtc22.setVisible(true);
        myDTCList.add(mdtc22);

        //自测报警
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("test");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("自测");
        mdtc23.setVisible(true);
        myDTCList.add(mdtc23);

        //总报警状态
        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("total");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("总报警");
        mdtc24.setVisible(true);
        myDTCList.add(mdtc24);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("tempA");
        phoneRealMsgInfo01.setTitle("温度A");
        phoneRealMsgInfo01.setValue(String.valueOf(this.getTempA())+ "℃");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("humiA");
        phoneRealMsgInfo02.setTitle("湿度A");
        phoneRealMsgInfo02.setValue(String.valueOf(this.getHumiA())+ "%");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("tempB");
        phoneRealMsgInfo03.setTitle("温度B");
        phoneRealMsgInfo03.setValue(String.valueOf(this.getTempB())+ "℃");
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("humiB");
        phoneRealMsgInfo04.setTitle("湿度B");
        phoneRealMsgInfo04.setValue(String.valueOf(this.getHumiB())+ "%");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("volA");
        phoneRealMsgInfo05.setTitle("电压A");
        phoneRealMsgInfo05.setValue(String.valueOf(this.getVolA())+ "%");
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("volB");
        phoneRealMsgInfo06.setTitle("电压B");
        phoneRealMsgInfo06.setValue(String.valueOf(this.getVolB())+ "%");
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("volC");
        phoneRealMsgInfo07.setTitle("电压C");
        phoneRealMsgInfo07.setValue(String.valueOf(this.getVolC())+ "%");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        return phoneRealMsgInfoList;
    }
}
