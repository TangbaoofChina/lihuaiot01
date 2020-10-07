package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lhslzlp1DM
 * @Description 立华饲料部 制粒机
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
@Data
public class Lhslzlp1DM extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //喂料器频率
    float frequency;
    //蒸汽阀开度
    float opening;
    //调制器温度
    float temp;
    //主机总电流
    float eleCurrent;
    //蒸汽压力
    float pressure;
    //ETC1
    float etc01;
    //ETC2
    float etc02;

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

        //喂料器频率
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("frequency");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("喂料器频率");
        mdtc10.setVisible(true);
        myDTCList.add(mdtc10);

        //蒸汽阀开度
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("opening");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("蒸汽阀开度");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        //调制器温度
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("temp");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("调制器温度");
        mdtc12.setVisible(true);
        myDTCList.add(mdtc12);

        //主机总电流
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("eleCurrent");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("主机总电流");
        mdtc13.setVisible(true);
        myDTCList.add(mdtc13);

        //蒸汽压力
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("pressure");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("蒸汽压力");
        mdtc14.setVisible(true);
        myDTCList.add(mdtc14);

        //ETC01
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("etc01");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("ETC01");
        mdtc15.setVisible(true);
        myDTCList.add(mdtc15);

        //ETC02
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("etc02");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("ETC02");
        mdtc16.setVisible(true);
        myDTCList.add(mdtc16);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("frequency");
        phoneRealMsgInfo01.setTitle("喂料器频率");
        phoneRealMsgInfo01.setValue(String.valueOf(this.getFrequency()));
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("opening");
        phoneRealMsgInfo02.setTitle("蒸汽阀开度");
        phoneRealMsgInfo02.setValue(String.valueOf(this.getOpening()));
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("temp");
        phoneRealMsgInfo03.setTitle("调制器温度");
        phoneRealMsgInfo03.setValue(String.valueOf(this.getTemp()));
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfo03.setHasHis(true);
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("eleCurrent");
        phoneRealMsgInfo04.setTitle("主机总电流");
        phoneRealMsgInfo04.setValue(String.valueOf(this.getEleCurrent()));
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("pressure");
        phoneRealMsgInfo05.setTitle("蒸汽压力");
        phoneRealMsgInfo05.setValue(String.valueOf(this.getPressure()));
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("etc01");
        phoneRealMsgInfo06.setTitle("ETC01");
        phoneRealMsgInfo06.setValue(String.valueOf(this.getEtc01()));
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("etc02");
        phoneRealMsgInfo07.setTitle("ETC02");
        phoneRealMsgInfo07.setValue(String.valueOf(this.getEtc02()));
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        return phoneRealMsgInfoList;
    }
}
