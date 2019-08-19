package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PWeighC312.PWeighC312OneData;
import com.system.po.Phone.PWeighC312.PWeighC312PartDetail;
import com.system.po.Phone.Base.PhoneOneData;
import com.system.po.Phone.Base.PhonePartDetail;
import com.system.util.DeviceUtil;

import java.util.ArrayList;
import java.util.List;

public class WeighC312DM extends BaseDeviceMessage {
    //净重
    private float netW;
    //毛重
    private float grossW;
    //投料
    private int increase;
    //放料
    private int decrease;
    //投料净重
    private float inNetW;
    //投料开始时间
    private String inStartDate;
    //投料截止时间
    private String inEndDate;
    //放料净重
    private float deNetW;
    //放料开始时间
    private String deStartDate;
    //放料截止时间
    private String deEndDate;
    //设备发送数据时间
    private String sendDate;

    public float getNetW() {
        return netW;
    }

    public void setNetW(float netW) {
        this.netW = netW;
    }

    public float getGrossW() {
        return grossW;
    }

    public void setGrossW(float grossW) {
        this.grossW = grossW;
    }

    public int getIncrease() {
        return increase;
    }

    public void setIncrease(int increase) {
        this.increase = increase;
    }

    public int getDecrease() {
        return decrease;
    }

    public void setDecrease(int decrease) {
        this.decrease = decrease;
    }

    public float getInNetW() {
        return inNetW;
    }

    public void setInNetW(float inNetW) {
        this.inNetW = inNetW;
    }

    public float getDeNetW() {
        return deNetW;
    }

    public void setDeNetW(float deNetW) {
        this.deNetW = deNetW;
    }

    public String getInStartDate() {
        return inStartDate;
    }

    public void setInStartDate(String inStartDate) {
        this.inStartDate = inStartDate;
    }

    public String getInEndDate() {
        return inEndDate;
    }

    public void setInEndDate(String inEndDate) {
        this.inEndDate = inEndDate;
    }

    public String getDeStartDate() {
        return deStartDate;
    }

    public void setDeStartDate(String deStartDate) {
        this.deStartDate = deStartDate;
    }

    public String getDeEndDate() {
        return deEndDate;
    }

    public void setDeEndDate(String deEndDate) {
        this.deEndDate = deEndDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
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

        //净重
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("netW");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("净重");
        mdtc3.setVisible(true);
        //毛重
        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("grossW");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("毛重");
        mdtc4.setVisible(false);
        //投料
        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("increase");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("投料");
        mdtc5.setVisible(true);
        //放料
        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("decrease");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("放料");
        mdtc6.setVisible(true);
        //投料净重
        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("inNetW");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("投料净重");
        mdtc7.setVisible(true);
        //投料开始时间
        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("inStartDate");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("投料开始");
        mdtc8.setVisible(true);
        //投料截止时间
        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("inEndDate");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("投料结束");
        mdtc9.setVisible(true);
        //放料净重
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("deNetW");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("放料净重");
        mdtc10.setVisible(true);
        //放料开始时间
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("deStartDate");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("放料开始");
        mdtc11.setVisible(true);
        //放料截止时间
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("deEndDate");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("放料结束");
        mdtc12.setVisible(true);

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
        //净重
        myDTCList.add(mdtc3);
        //投料
        myDTCList.add(mdtc5);
        //放料
        myDTCList.add(mdtc6);
        //投料净重
        myDTCList.add(mdtc7);
        //投料开始时间
        myDTCList.add(mdtc8);
        //投料截止时间
        myDTCList.add(mdtc9);
        //放料净重
        myDTCList.add(mdtc10);
        //放料开始时间
        myDTCList.add(mdtc11);
        //放料截止时间
        myDTCList.add(mdtc12);
        //毛重
        myDTCList.add(mdtc4);

        return myDTCList;
    }

    public List<PhoneOneData> getPhoneSummary() {
        List<PhoneOneData> pWeighC312OneDataList = new ArrayList<PhoneOneData>();
        PhoneOneData pWeighC312OneData01 = new PWeighC312OneData();
        pWeighC312OneData01.setTitle("净重：");
        pWeighC312OneData01.setValue1(String.valueOf(netW) + "kg");
        pWeighC312OneData01.setColor1(DeviceUtil.defaultColor);
        pWeighC312OneDataList.add(pWeighC312OneData01);

        PhoneOneData pWeighC312OneData02 = new PWeighC312OneData();
        pWeighC312OneData02.setTitle("空值：");
        pWeighC312OneData02.setColor1(DeviceUtil.defaultColor);
        pWeighC312OneDataList.add(pWeighC312OneData02);

        PhoneOneData pWeighC312OneData03 = new PWeighC312OneData();
        pWeighC312OneData03.setTitle("投料净重：");
        pWeighC312OneData03.setValue1(String.valueOf(inNetW) + "kg");
        pWeighC312OneData03.setColor1(DeviceUtil.defaultColor);
        pWeighC312OneDataList.add(pWeighC312OneData03);

        PhoneOneData pWeighC312OneData04 = new PWeighC312OneData();
        pWeighC312OneData04.setTitle("放料净重：");
        pWeighC312OneData04.setValue1(String.valueOf(deNetW) + "kg");
        pWeighC312OneData04.setColor1(DeviceUtil.defaultColor);
        pWeighC312OneDataList.add(pWeighC312OneData04);

        return pWeighC312OneDataList;
    }

    public  List<PhonePartDetail>  getPhoneDetail() {
        List<PhonePartDetail> phonePartDetailList = new ArrayList<PhonePartDetail>();

        //一段数据  开始
        PhonePartDetail phonePartDetail01 = new PWeighC312PartDetail();
        phonePartDetail01.setColumn(2);
        phonePartDetail01.setScale("0.5,0.5");
        phonePartDetail01.setTitle("总体信息");
        List<PhoneOneData> phoneOneDataList = new ArrayList<PhoneOneData>();
        //一行数据  开始-时间
        PhoneOneData phoneOneData01 = new PhoneOneData();
        phoneOneData01.setTitle("时间：");
        phoneOneData01.setValue1(sendDate);
        phoneOneData01.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData01);
        //一行数据  结束-时间
        //一行数据  开始-净重
        PhoneOneData phoneOneData02 = new PhoneOneData();
        phoneOneData02.setTitle("净重：");
        phoneOneData02.setValue1(String.valueOf(netW));
        phoneOneData02.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData02);
        //一行数据  结束-净重
        //一行数据  开始-投料状态
        PhoneOneData phoneOneData09 = new PhoneOneData();
        phoneOneData09.setTitle("投料状态：");
        if (increase > 0)
            phoneOneData09.setValue1("投料中");
        else
            phoneOneData09.setValue1("停止");
        phoneOneData09.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData09);
        //一行数据  结束-投料状态
        //一行数据  开始-放料状态
        PhoneOneData phoneOneData10 = new PhoneOneData();
        phoneOneData10.setTitle("放料状态：");
        if (decrease > 0)
            phoneOneData10.setValue1("放料中");
        else
            phoneOneData10.setValue1("停止");
        phoneOneData10.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData10);
        //一行数据  结束-净重
        //一行数据  开始-投料净重
        PhoneOneData phoneOneData03 = new PhoneOneData();
        phoneOneData03.setTitle("投料净重：");
        phoneOneData03.setValue1(String.valueOf(netW));
        phoneOneData03.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData03);
        //一行数据  结束-投料净重
        //一行数据  开始-投料开始时间
        PhoneOneData phoneOneData04 = new PhoneOneData();
        phoneOneData04.setTitle("投料开始：");
        phoneOneData04.setValue1(inStartDate);
        phoneOneData04.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData04);
        //一行数据  结束-投料开始时间
        //一行数据  开始-投料结束时间
        PhoneOneData phoneOneData05 = new PhoneOneData();
        phoneOneData05.setTitle("投料结束");
        phoneOneData05.setValue1(inEndDate);
        phoneOneData05.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData05);
        //一行数据  结束-投料结束时间
        //一行数据  开始-放料净重
        PhoneOneData phoneOneData06 = new PhoneOneData();
        phoneOneData06.setTitle("放料净重");
        phoneOneData06.setValue1(String.valueOf(deNetW));
        phoneOneData06.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData06);
        //一行数据  结束-放料净重
        //一行数据  开始-放料开始时间
        PhoneOneData phoneOneData07 = new PhoneOneData();
        phoneOneData07.setTitle("放料开始");
        phoneOneData07.setValue1(deStartDate);
        phoneOneData07.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData07);
        //一行数据  结束-放料开始时间
        //一行数据  开始-放料结束时间
        PhoneOneData phoneOneData08 = new PhoneOneData();
        phoneOneData08.setTitle("放料结束");
        phoneOneData08.setValue1(deEndDate);
        phoneOneData08.setColor1(DeviceUtil.defaultColor);
        phoneOneDataList.add(phoneOneData08);
        //一行数据  结束-放料结束时间
        //添加多行数据
        phonePartDetail01.setPhoneOneDataList(phoneOneDataList);
        phonePartDetailList.add(phonePartDetail01);
        //一段数据 结束
        return phonePartDetailList;
    }
}
