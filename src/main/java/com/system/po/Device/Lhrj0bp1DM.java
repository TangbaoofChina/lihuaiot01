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
public class Lhrj0bp1DM extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //脉冲水表数据
    long water;
    //市电信号
    int ele;

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

        //脉冲水表
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("water");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("饮水量");
        mdtc10.setVisible(true);
        myDTCList.add(mdtc10);

        //市电
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("ele");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("市电");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("water");
        phoneRealMsgInfo01.setTitle("饮水量");
        phoneRealMsgInfo01.setValue(String.valueOf(this.getWater())+ "℃");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfo01.setHasHis(true);
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("ele");
        phoneRealMsgInfo02.setTitle("供电");
        if(this.getEle() == 1){
            phoneRealMsgInfo02.setValue("市电");
        }else{
            phoneRealMsgInfo02.setValue("电池");
        }
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);


        return phoneRealMsgInfoList;
    }
}
