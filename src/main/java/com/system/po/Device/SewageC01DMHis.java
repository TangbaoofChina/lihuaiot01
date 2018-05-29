package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 污水站控制器01信息-徐州吕滩污水项目
 */
public class SewageC01DMHis extends BaseDeviceMessage {


    /***********  数据-设定时间  *********************/
    //sbr设定总时间
    private int sbrCycleSetMinute;
    //SBR一次搅拌（设定分钟）
    private int sbrMixerOnceSetMinute;
    //SBR曝气（设定分钟）
    private int fanSetMinute;
    //SBR混合（设定分钟）
    private int sbrMixerSetMinute;
    //SBR静置（设定分钟）
    private int sbrStaticSetMinute;
    //SBR污泥泵2（设定分钟）
    private int sludgePump02SetMinute;
    //SBR活化（设定分钟）
    private int sbrActiveSetMinute;
    /***********  数据-运行时间  *********************/
    //当日流量(m³)
    private long todayFlowmeter;
    //设备发送数据时间
    private String sendDate;

    public int getSbrCycleSetMinute() {
        return sbrCycleSetMinute;
    }

    public void setSbrCycleSetMinute(int sbrCycleSetMinute) {
        this.sbrCycleSetMinute = sbrCycleSetMinute;
    }

    public int getSbrMixerOnceSetMinute() {
        return sbrMixerOnceSetMinute;
    }

    public void setSbrMixerOnceSetMinute(int sbrMixerOnceSetMinute) {
        this.sbrMixerOnceSetMinute = sbrMixerOnceSetMinute;
    }

    public int getFanSetMinute() {
        return fanSetMinute;
    }

    public void setFanSetMinute(int fanSetMinute) {
        this.fanSetMinute = fanSetMinute;
    }

    public int getSbrMixerSetMinute() {
        return sbrMixerSetMinute;
    }

    public void setSbrMixerSetMinute(int sbrMixerSetMinute) {
        this.sbrMixerSetMinute = sbrMixerSetMinute;
    }

    public int getSbrStaticSetMinute() {
        return sbrStaticSetMinute;
    }

    public void setSbrStaticSetMinute(int sbrStaticSetMinute) {
        this.sbrStaticSetMinute = sbrStaticSetMinute;
    }

    public int getSludgePump02SetMinute() {
        return sludgePump02SetMinute;
    }

    public void setSludgePump02SetMinute(int sludgePump02SetMinute) {
        this.sludgePump02SetMinute = sludgePump02SetMinute;
    }

    public int getSbrActiveSetMinute() {
        return sbrActiveSetMinute;
    }

    public void setSbrActiveSetMinute(int sbrActiveSetMinute) {
        this.sbrActiveSetMinute = sbrActiveSetMinute;
    }

    public long getTodayFlowmeter() {
        return todayFlowmeter;
    }

    public void setTodayFlowmeter(long todayFlowmeter) {
        this.todayFlowmeter = todayFlowmeter;
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
        mdtc1.setData("dSerialNum");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");


        //sbr设定总时间
        MydataTableColumn mdtc59 = new MydataTableColumn();
        mdtc59.setData("sbrCycleSetMinute");
        mdtc59.setDefaultContent("59");
        mdtc59.setTitle("sbr设定周期时间");

        //SBR一次搅拌（设定分钟）
        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("sbrMixerOnceSetMinute");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("SBR一次搅拌设定时间");

        //SBR曝气（设定分钟）
        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("fanSetMinute");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("SBR曝气设定时间");

        //SBR混合（设定分钟）
        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("sbrMixerSetMinute");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("SBR混合设定时间");

        //SBR静置（设定分钟）
        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("sbrStaticSetMinute");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("SBR静置设定时间");

        //SBR污泥泵2（设定分钟）
        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("sludgePump02SetMinute");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("SBR污泥泵2设定时间");

        //SBR活化（设定分钟）
        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("sbrActiveSetMinute");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("SBR活化设定时间");

        //当日流量(m³)
        MydataTableColumn mdtc60 = new MydataTableColumn();
        mdtc60.setData("todayFlowmeter");
        mdtc60.setDefaultContent("60");
        mdtc60.setTitle("当日流量");

        //设备发送数据时间
        MydataTableColumn mdtc52 = new MydataTableColumn();
        mdtc52.setData("sendDate");
        mdtc52.setDefaultContent("52");
        mdtc52.setTitle("时间");

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);

        //设备发送数据时间
        myDTCList.add(mdtc52);
        //当日流量
        myDTCList.add(mdtc60);

        /***********  数据-运行时间  *********************/

        /***********  数据-设定时间  *********************/

        //SBR设定周期时间
        myDTCList.add(mdtc59);
        //SBR一次搅拌（设定分钟）
        myDTCList.add(mdtc34);
        //SBR曝气（设定分钟）
        myDTCList.add(mdtc35);
        //SBR混合（设定分钟）
        myDTCList.add(mdtc36);
        //SBR静置（设定分钟）
        myDTCList.add(mdtc37);
        //SBR污泥泵2（设定分钟）
        myDTCList.add(mdtc38);
        //SBR活化（设定分钟）
        myDTCList.add(mdtc39);
        /***********设备运行状态*********************************/

        /***********  故障指示  *********************/

        /***********  公共参数  *********************/

        return myDTCList;
    }

}
