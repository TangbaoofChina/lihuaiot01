package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.Base.PhoneHisDataHead;
import com.system.po.Phone.PWeighC312.PWeighC312HisDataHead;

import java.util.ArrayList;
import java.util.List;

public class WeighC312DMHis extends BaseDeviceMessage {
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

    /**
     * 手机端历史数据抬头
     * @param type 0：投料；1：放料
     * @return
     */
    public List<PhoneHisDataHead> getHead(String type) {
        List<PhoneHisDataHead> phoneHisDataHeadList = new ArrayList<PhoneHisDataHead>();

        PhoneHisDataHead phoneHisDataHead00 = new PWeighC312HisDataHead("净重","0.2","netW");
        phoneHisDataHeadList.add(phoneHisDataHead00);

        PhoneHisDataHead phoneHisDataHead01 = new PWeighC312HisDataHead("时间","0.2","sendDate");
        phoneHisDataHeadList.add(phoneHisDataHead01);

        if(type.equals("0")) {
            PhoneHisDataHead phoneHisDataHead02 = new PWeighC312HisDataHead("投料净重", "0.2", "inNetW");
            phoneHisDataHeadList.add(phoneHisDataHead02);

            PhoneHisDataHead phoneHisDataHead03 = new PWeighC312HisDataHead("开始时间","0.2","inStartDate");
            phoneHisDataHeadList.add(phoneHisDataHead03);

            PhoneHisDataHead phoneHisDataHead04 = new PWeighC312HisDataHead("结束时间","0.2","inEndDate");
            phoneHisDataHeadList.add(phoneHisDataHead04);
        }else{
            PhoneHisDataHead phoneHisDataHead02 = new PWeighC312HisDataHead("放料净重", "0.2", "deNetW");
            phoneHisDataHeadList.add(phoneHisDataHead02);

            PhoneHisDataHead phoneHisDataHead03 = new PWeighC312HisDataHead("开始时间","0.2","deStartDate");
            phoneHisDataHeadList.add(phoneHisDataHead03);

            PhoneHisDataHead phoneHisDataHead04 = new PWeighC312HisDataHead("结束时间","0.2","deEndDate");
            phoneHisDataHeadList.add(phoneHisDataHead04);
        }

        return phoneHisDataHeadList;
    }
}
