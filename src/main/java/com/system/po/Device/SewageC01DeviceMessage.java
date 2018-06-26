package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealOneData;

import java.util.ArrayList;
import java.util.List;

/**
 * 污水站控制器01信息-徐州吕滩污水项目
 */
public class SewageC01DeviceMessage extends BaseDeviceMessage {
    /*************  运行状态  ******************/
    //集水池搅拌机停止/运行
    private Boolean collectMixerRun;
    //除磷投加机停止/运行
    private Boolean dephosphorizeRun;
    //集水池提升泵停止/运行
    private Boolean collectPumpRun;
    //污泥泵1停止/运行
    private Boolean sludgePump01Run;
    //SBR进水泵停止/运行
    private Boolean sbrIntakePumpRun;
    //SBR池搅拌机停止/运行
    private Boolean sbrMixerRun;
    //回转式风机1停止/运行
    private Boolean fan01Run;
    //回转式风机2停止/运行
    private Boolean fan02Run;
    //污泥泵2停止/运行
    private Boolean sludgePump02Run;
    //滗水器停止/运行
    private Boolean decanterRun;
    //备用82   未启用
    //备用83   SBR池一次搅拌
    private Boolean sbrMixerOnceRun = false;
    //备用84   SBR池二次搅拌
    private Boolean sbrMixerSecRun = false;
    //备用85   SBR池静置
    private Boolean sbrStaticRun = false;
    //备用86   滗水器周期
    private Boolean decanterCycleRun = false;
    //备用87   活化周期
    private Boolean sbrActiveRun = false;

    /***********  故障指示  *********************/
    //集水池搅拌机正常/故障
    private Boolean collectMixerFault;
    //备用91
    private Boolean spare91;
    //集水池提升泵正常/故障
    private Boolean collectPumpFault;
    //污泥泵1正常/故障
    private Boolean sludgePump01Fault;
    //SBR进水泵正常/故障
    private Boolean sbrIntakePumpFault;
    //SBR池搅拌机1正常/故障
    private Boolean sbrMixer01Fault;
    //SBR池搅拌机2正常/故障
    private Boolean sbrMixer02Fault;
    //回转式风机1正常/故障
    private Boolean fan01Fault;
    //回转式风机2正常/故障
    private Boolean fan02Fault;
    //污泥泵2正常/故障
    private Boolean sludgePump02Fault;
    //滗水器正常/故障
    private Boolean decanterFault;
    //PLC电量不足
    private Boolean plcElecLack;
    /***********  公共参数  *********************/
    //系统手动模式/自动模式
    private Boolean systemAuto;
    //SBR周期运行标识
    private Boolean sbrCycle;
    //集水池液位高未到/到了
    private Boolean collectHighOn;
    //集水池液位低未到/到了
    private Boolean collectLowOn;
    //调节池液位高未到/到了
    private Boolean regulatHighOn;
    //调节池液位低未到/到了
    private Boolean regulatLowOn;
    //SBR池液位高未到/到了
    private Boolean sbrHighOn;
    //SBR池液位低未到/到了
    private Boolean sbrLowOn;

    /***********  数据-设定时间  *********************/
    //sbr设定总时间
    private int sbrCycleSetMinute;
    //除磷投加机时间 （设定分钟）
    private int dephosphorizeSetMinute;
    //污泥泵1（设定分钟）
    private int sludgePump01SetMinute;
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
    //除磷投加机时间 （运行分钟）
    private int dephosphorizeRunMinute;
    //污泥泵1（运行分钟）
    private int sludgePump01RunMinute;
    //SBR一次搅拌（运行分钟）
    private int sbrMixerOnceRunMinute;
    //SBR曝气（运行分钟）
    private int fanRunMinute;
    //SBR混合（运行分钟）
    private int sbrMixerRunMinute;
    //SBR静置（运行分钟）
    private int sbrStaticRunMinute;
    //SBR污泥泵2（运行分钟）
    private int sludgePump02RunMinute;
    //SBR活化（运行分钟）
    private int sbrActiveRunMinute;
    //集水池搅拌机（运行时间）
    private int collectMixerRunMinute;
    //集水池提升泵时间（运行分钟）
    private int collectPumpRunMinute;
    //SBR进水泵（运行时间）
    private int sbrIntakePumpRunMinute;
    //流量计（m³）
    private long flowmeter;
    //当日流量(m³)
    private long todayFlowmeter;
    //设备发送数据时间
    private String sendDate;

    public Boolean getCollectMixerRun() {
        return collectMixerRun;
    }

    public void setCollectMixerRun(Boolean collectMixerRun) {
        this.collectMixerRun = collectMixerRun;
    }

    public Boolean getDephosphorizeRun() {
        return dephosphorizeRun;
    }

    public void setDephosphorizeRun(Boolean dephosphorizeRun) {
        this.dephosphorizeRun = dephosphorizeRun;
    }

    public Boolean getCollectPumpRun() {
        return collectPumpRun;
    }

    public void setCollectPumpRun(Boolean collectPumpRun) {
        this.collectPumpRun = collectPumpRun;
    }

    public Boolean getSludgePump01Run() {
        return sludgePump01Run;
    }

    public void setSludgePump01Run(Boolean sludgePump01Run) {
        this.sludgePump01Run = sludgePump01Run;
    }

    public Boolean getSbrIntakePumpRun() {
        return sbrIntakePumpRun;
    }

    public void setSbrIntakePumpRun(Boolean sbrIntakePumpRun) {
        this.sbrIntakePumpRun = sbrIntakePumpRun;
    }

    public Boolean getSbrMixerRun() {
        return sbrMixerRun;
    }

    public void setSbrMixerRun(Boolean sbrMixerRun) {
        this.sbrMixerRun = sbrMixerRun;
    }

    public Boolean getFan01Run() {
        return fan01Run;
    }

    public void setFan01Run(Boolean fan01Run) {
        this.fan01Run = fan01Run;
    }

    public Boolean getFan02Run() {
        return fan02Run;
    }

    public void setFan02Run(Boolean fan02Run) {
        this.fan02Run = fan02Run;
    }

    public Boolean getSludgePump02Run() {
        return sludgePump02Run;
    }

    public void setSludgePump02Run(Boolean sludgePump02Run) {
        this.sludgePump02Run = sludgePump02Run;
    }

    public Boolean getDecanterRun() {
        return decanterRun;
    }

    public void setDecanterRun(Boolean decanterRun) {
        this.decanterRun = decanterRun;
    }

    public Boolean getSbrMixerOnceRun() {
        return sbrMixerOnceRun;
    }

    public void setSbrMixerOnceRun(Boolean sbrMixerOnceRun) {
        this.sbrMixerOnceRun = sbrMixerOnceRun;
    }

    public Boolean getSbrMixerSecRun() {
        return sbrMixerSecRun;
    }

    public void setSbrMixerSecRun(Boolean sbrMixerSecRun) {
        this.sbrMixerSecRun = sbrMixerSecRun;
    }

    public Boolean getSbrStaticRun() {
        return sbrStaticRun;
    }

    public void setSbrStaticRun(Boolean sbrStaticRun) {
        this.sbrStaticRun = sbrStaticRun;
    }

    public Boolean getDecanterCycleRun() {
        return decanterCycleRun;
    }

    public void setDecanterCycleRun(Boolean decanterCycleRun) {
        this.decanterCycleRun = decanterCycleRun;
    }

    public Boolean getSbrActiveRun() {
        return sbrActiveRun;
    }

    public void setSbrActiveRun(Boolean sbrActiveRun) {
        this.sbrActiveRun = sbrActiveRun;
    }

    public Boolean getCollectMixerFault() {
        return collectMixerFault;
    }

    public void setCollectMixerFault(Boolean collectMixerFault) {
        this.collectMixerFault = collectMixerFault;
    }

    public Boolean getSpare91() {
        return spare91;
    }

    public void setSpare91(Boolean spare91) {
        this.spare91 = spare91;
    }

    public Boolean getCollectPumpFault() {
        return collectPumpFault;
    }

    public void setCollectPumpFault(Boolean collectPumpFault) {
        this.collectPumpFault = collectPumpFault;
    }

    public Boolean getSludgePump01Fault() {
        return sludgePump01Fault;
    }

    public void setSludgePump01Fault(Boolean sludgePump01Fault) {
        this.sludgePump01Fault = sludgePump01Fault;
    }

    public Boolean getSbrIntakePumpFault() {
        return sbrIntakePumpFault;
    }

    public void setSbrIntakePumpFault(Boolean sbrIntakePumpFault) {
        this.sbrIntakePumpFault = sbrIntakePumpFault;
    }

    public Boolean getSbrMixer01Fault() {
        return sbrMixer01Fault;
    }

    public void setSbrMixer01Fault(Boolean sbrMixer01Fault) {
        this.sbrMixer01Fault = sbrMixer01Fault;
    }

    public Boolean getSbrMixer02Fault() {
        return sbrMixer02Fault;
    }

    public void setSbrMixer02Fault(Boolean sbrMixer02Fault) {
        this.sbrMixer02Fault = sbrMixer02Fault;
    }

    public Boolean getFan01Fault() {
        return fan01Fault;
    }

    public void setFan01Fault(Boolean fan01Fault) {
        this.fan01Fault = fan01Fault;
    }

    public Boolean getFan02Fault() {
        return fan02Fault;
    }

    public void setFan02Fault(Boolean fan02Fault) {
        this.fan02Fault = fan02Fault;
    }

    public Boolean getSludgePump02Fault() {
        return sludgePump02Fault;
    }

    public void setSludgePump02Fault(Boolean sludgePump02Fault) {
        this.sludgePump02Fault = sludgePump02Fault;
    }

    public Boolean getDecanterFault() {
        return decanterFault;
    }

    public void setDecanterFault(Boolean decanterFault) {
        this.decanterFault = decanterFault;
    }

    public Boolean getPlcElecLack() {
        return plcElecLack;
    }

    public void setPlcElecLack(Boolean plcElecLack) {
        this.plcElecLack = plcElecLack;
    }

    public Boolean getSystemAuto() {
        return systemAuto;
    }

    public void setSystemAuto(Boolean systemAuto) {
        this.systemAuto = systemAuto;
    }

    public Boolean getSbrCycle() {
        return sbrCycle;
    }

    public void setSbrCycle(Boolean sbrCycle) {
        this.sbrCycle = sbrCycle;
    }

    public Boolean getCollectHighOn() {
        return collectHighOn;
    }

    public void setCollectHighOn(Boolean collectHighOn) {
        this.collectHighOn = collectHighOn;
    }

    public Boolean getCollectLowOn() {
        return collectLowOn;
    }

    public void setCollectLowOn(Boolean collectLowOn) {
        this.collectLowOn = collectLowOn;
    }

    public Boolean getRegulatHighOn() {
        return regulatHighOn;
    }

    public void setRegulatHighOn(Boolean regulatHighOn) {
        this.regulatHighOn = regulatHighOn;
    }

    public Boolean getRegulatLowOn() {
        return regulatLowOn;
    }

    public void setRegulatLowOn(Boolean regulatLowOn) {
        this.regulatLowOn = regulatLowOn;
    }

    public Boolean getSbrHighOn() {
        return sbrHighOn;
    }

    public void setSbrHighOn(Boolean sbrHighOn) {
        this.sbrHighOn = sbrHighOn;
    }

    public Boolean getSbrLowOn() {
        return sbrLowOn;
    }

    public void setSbrLowOn(Boolean sbrLowOn) {
        this.sbrLowOn = sbrLowOn;
    }

    public int getDephosphorizeSetMinute() {
        return dephosphorizeSetMinute;
    }

    public void setDephosphorizeSetMinute(int dephosphorizeSetMinute) {
        this.dephosphorizeSetMinute = dephosphorizeSetMinute;
    }

    public int getSludgePump01SetMinute() {
        return sludgePump01SetMinute;
    }

    public void setSludgePump01SetMinute(int sludgePump01SetMinute) {
        this.sludgePump01SetMinute = sludgePump01SetMinute;
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

    public int getDephosphorizeRunMinute() {
        return dephosphorizeRunMinute;
    }

    public void setDephosphorizeRunMinute(int dephosphorizeRunMinute) {
        this.dephosphorizeRunMinute = dephosphorizeRunMinute;
    }

    public int getSludgePump01RunMinute() {
        return sludgePump01RunMinute;
    }

    public void setSludgePump01RunMinute(int sludgePump01RunMinute) {
        this.sludgePump01RunMinute = sludgePump01RunMinute;
    }

    public int getSbrMixerOnceRunMinute() {
        return sbrMixerOnceRunMinute;
    }

    public void setSbrMixerOnceRunMinute(int sbrMixerOnceRunMinute) {
        this.sbrMixerOnceRunMinute = sbrMixerOnceRunMinute;
    }

    public int getFanRunMinute() {
        return fanRunMinute;
    }

    public void setFanRunMinute(int fanRunMinute) {
        this.fanRunMinute = fanRunMinute;
    }

    public int getSbrMixerRunMinute() {
        return sbrMixerRunMinute;
    }

    public void setSbrMixerRunMinute(int sbrMixerRunMinute) {
        this.sbrMixerRunMinute = sbrMixerRunMinute;
    }

    public int getSbrStaticRunMinute() {
        return sbrStaticRunMinute;
    }

    public void setSbrStaticRunMinute(int sbrStaticRunMinute) {
        this.sbrStaticRunMinute = sbrStaticRunMinute;
    }

    public int getSludgePump02RunMinute() {
        return sludgePump02RunMinute;
    }

    public void setSludgePump02RunMinute(int sludgePump02RunMinute) {
        this.sludgePump02RunMinute = sludgePump02RunMinute;
    }

    public int getSbrActiveRunMinute() {
        return sbrActiveRunMinute;
    }

    public void setSbrActiveRunMinute(int sbrActiveRunMinute) {
        this.sbrActiveRunMinute = sbrActiveRunMinute;
    }

    public int getCollectMixerRunMinute() {
        return collectMixerRunMinute;
    }

    public void setCollectMixerRunMinute(int collectMixerRunMinute) {
        this.collectMixerRunMinute = collectMixerRunMinute;
    }

    public int getCollectPumpRunMinute() {
        return collectPumpRunMinute;
    }

    public void setCollectPumpRunMinute(int collectPumpRunMinute) {
        this.collectPumpRunMinute = collectPumpRunMinute;
    }

    public int getSbrIntakePumpRunMinute() {
        return sbrIntakePumpRunMinute;
    }

    public void setSbrIntakePumpRunMinute(int sbrIntakePumpRunMinute) {
        this.sbrIntakePumpRunMinute = sbrIntakePumpRunMinute;
    }

    public long getFlowmeter() {
        return flowmeter;
    }

    public void setFlowmeter(long flowmeter) {
        this.flowmeter = flowmeter;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public int getSbrCycleSetMinute() {
        return sbrCycleSetMinute;
    }

    public void setSbrCycleSetMinute(int sbrCycleSetMinute) {
        this.sbrCycleSetMinute = sbrCycleSetMinute;
    }

    public long getTodayFlowmeter() {
        return todayFlowmeter;
    }

    public void setTodayFlowmeter(long todayFlowmeter) {
        this.todayFlowmeter = todayFlowmeter;
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

        //集水池搅拌机停止/运行
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("collectMixerRun");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("集水池搅拌机运行");
        mdtc3.setVisible(false);

        //除磷投加机停止/运行
        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dephosphorizeRun");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("除磷投加机运行");
        mdtc4.setVisible(false);

        //集水池提升泵停止/运行
        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("collectPumpRun");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("集水池提升泵运行");
        mdtc5.setVisible(false);

        //污泥泵1停止/运行
        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("sludgePump01Run");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("污泥泵1运行");
        mdtc6.setVisible(false);

        //SBR进水泵停止/运行
        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("sbrIntakePumpRun");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("SBR池进水泵运行");
        mdtc7.setVisible(false);

        //SBR池搅拌机停止/运行
        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("sbrMixerRun");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("SBR池搅拌机运行");
        mdtc8.setVisible(false);

        //回转式风机1停止/运行
        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("fan01Run");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("回转式风机1运行");
        mdtc9.setVisible(false);

        //回转式风机2停止/运行
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("fan02Run");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("回转式风机2运行");
        mdtc10.setVisible(false);

        //污泥泵2停止/运行
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("sludgePump02Run");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("污泥泵2运行");
        mdtc11.setVisible(false);

        //滗水器停止/运行
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("decanterRun");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("滗水器运行");
        mdtc12.setVisible(false);

        //备用83   SBR池一次搅拌
        MydataTableColumn mdtc54 = new MydataTableColumn();
        mdtc54.setData("sbrMixerOnceRun");
        mdtc54.setDefaultContent("54");
        mdtc54.setTitle("SBR池一次搅拌");
        mdtc54.setVisible(false);

        //备用84   SBR池二次搅拌
        MydataTableColumn mdtc55 = new MydataTableColumn();
        mdtc55.setData("sbrMixerSecRun");
        mdtc55.setDefaultContent("55");
        mdtc55.setTitle("SBR池二次搅拌");
        mdtc55.setVisible(false);
        //备用85   SBR池静置
        MydataTableColumn mdtc56 = new MydataTableColumn();
        mdtc56.setData("sbrStaticRun");
        mdtc56.setDefaultContent("56");
        mdtc56.setTitle("SBR池静置");
        mdtc56.setVisible(false);
        //备用86   滗水器周期
        MydataTableColumn mdtc57 = new MydataTableColumn();
        mdtc57.setData("decanterCycleRun");
        mdtc57.setDefaultContent("57");
        mdtc57.setTitle("滗水器周期");
        mdtc57.setVisible(false);
        //备用87   活化周期
        MydataTableColumn mdtc58 = new MydataTableColumn();
        mdtc58.setData("sbrActiveRun");
        mdtc58.setDefaultContent("58");
        mdtc58.setTitle("活化周期");
        mdtc58.setVisible(false);

        //集水池搅拌机正常/故障
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("collectMixerFault");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("集水池搅拌机故障");
        mdtc13.setVisible(false);

        //集水池提升泵正常/故障
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("collectPumpFault");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("集水池提升泵故障");
        mdtc14.setVisible(false);

        //污泥泵1正常/故障
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("sludgePump01Fault");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("污泥泵1故障");
        mdtc15.setVisible(false);

        //SBR进水泵正常/故障
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("sbrIntakePumpFault");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("SBR池进水泵故障");
        mdtc16.setVisible(false);

        //SBR池搅拌机1正常/故障
        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("sbrMixer01Fault");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("SBR池搅拌机1故障");
        mdtc17.setVisible(false);

        //SBR池搅拌机2正常/故障
        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("sbrMixer02Fault");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("SBR池搅拌机2故障");
        mdtc18.setVisible(false);

        //回转式风机1正常/故障
        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("fan01Fault");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("回转式风机1故障");
        mdtc19.setVisible(false);

        //回转式风机2正常/故障
        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("fan02Fault");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("回转式风机2故障");
        mdtc20.setVisible(false);

        //污泥泵2正常/故障
        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("sludgePump02Fault");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("污泥泵2故障");
        mdtc21.setVisible(false);

        //滗水器正常/故障
        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("decanterFault");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("滗水器故障");
        mdtc22.setVisible(false);

        //PLC电量不足
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("plcElecLack");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("PLC电量不足");
        mdtc23.setVisible(false);

        //系统手动模式/自动模式
        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("systemAuto");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("自动模式");

        //SBR周期运行标识
        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("sbrCycle");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("SBR周期运行");

        //集水池液位高未到/到了
        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("collectHighOn");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("集水池液位高到了");
        mdtc26.setVisible(false);

        //集水池液位低未到/到了
        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("collectLowOn");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("集水池液位低到了");
        mdtc27.setVisible(false);

        //调节池液位高未到/到了
        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("regulatHighOn");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("调节池液位高到了");
        mdtc28.setVisible(false);

        //调节池液位低未到/到了
        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("regulatLowOn");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("调节池液位低到了");
        mdtc29.setVisible(false);

        //SBR池液位高未到/到了
        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("sbrHighOn");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("SBR池液位高到了");
        mdtc30.setVisible(false);

        //SBR池液位低未到/到了
        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("sbrLowOn");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("SBR池液位低到了");
        mdtc31.setVisible(false);

        //除磷投加机时间 （设定分钟）
        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("dephosphorizeSetMinute");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("除磷投加机设定时间");

        //污泥泵1（设定分钟）
        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("sludgePump01SetMinute");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("污泥泵1设定时间");

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

        //除磷投加机时间 （运行分钟）
        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("dephosphorizeRunMinute");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("除磷投加机运行时间");

        //污泥泵1（运行分钟）
        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("sludgePump01RunMinute");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("污泥泵1运行时间");

        //SBR一次搅拌（运行分钟）
        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("sbrMixerOnceRunMinute");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("SBR一次搅拌运行时间");

        //SBR曝气（运行分钟）
        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("fanRunMinute");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("SBR曝气运行时间");

        //SBR混合（运行分钟）
        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("sbrMixerRunMinute");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("SBR混合运行时间");

        //SBR静置（运行分钟）
        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("sbrStaticRunMinute");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("SBR静置运行时间");

        //SBR污泥泵2（运行分钟）
        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("sludgePump02RunMinute");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("SBR污泥泵2运行时间");

        //SBR活化（运行分钟）
        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("sbrActiveRunMinute");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("SBR活化运行时间");

        //集水池搅拌机（运行时间）
        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("collectMixerRunMinute");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("集水池搅拌机运行时间");

        //集水池提升泵时间（运行分钟）
        MydataTableColumn mdtc49 = new MydataTableColumn();
        mdtc49.setData("collectPumpRunMinute");
        mdtc49.setDefaultContent("49");
        mdtc49.setTitle("集水池提升泵运行时间");

        //SBR进水泵（运行时间）
        MydataTableColumn mdtc50 = new MydataTableColumn();
        mdtc50.setData("sbrIntakePumpRunMinute");
        mdtc50.setDefaultContent("50");
        mdtc50.setTitle("SBR池进水泵运行时间");

        //流量计（m³）
        MydataTableColumn mdtc51 = new MydataTableColumn();
        mdtc51.setData("flowmeter");
        mdtc51.setDefaultContent("51");
        mdtc51.setTitle("累积流量");

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

        MydataTableColumn mdtc53 = new MydataTableColumn();
        mdtc53.setData("dState");
        mdtc53.setDefaultContent("53");
        mdtc53.setTitle("状态");

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //状态
        myDTCList.add(mdtc53);
        //设备发送数据时间
        myDTCList.add(mdtc52);
        //累计流量计（m³）
        myDTCList.add(mdtc51);
        //当日流量
        myDTCList.add(mdtc60);
        //系统手动模式/自动模式
        myDTCList.add(mdtc24);
        /***********  数据-运行时间  *********************/
        //SBR周期运行标识
        myDTCList.add(mdtc25);
        //SBR进水泵（运行时间）
        myDTCList.add(mdtc50);
        //SBR一次搅拌（运行分钟）
        myDTCList.add(mdtc42);
        //SBR曝气（运行分钟）
        myDTCList.add(mdtc43);
        //SBR混合（运行分钟）
        myDTCList.add(mdtc44);
        //SBR静置（运行分钟）
        myDTCList.add(mdtc45);
        //SBR污泥泵2（运行分钟）
        myDTCList.add(mdtc46);
        //SBR活化（运行分钟）
        myDTCList.add(mdtc47);
        //集水池搅拌机（运行时间）
        myDTCList.add(mdtc48);
        //集水池提升泵时间（运行分钟）
        myDTCList.add(mdtc49);
        //除磷投加机时间 （运行分钟）
        myDTCList.add(mdtc40);
        //污泥泵1（运行分钟）
        myDTCList.add(mdtc41);
/***********  数据-设定时间  *********************/
        //除磷投加机时间 （设定分钟）
        myDTCList.add(mdtc32);
        //污泥泵1（设定分钟）
        myDTCList.add(mdtc33);
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
        //SBR进水泵停止/运行
        myDTCList.add(mdtc7);
        //备用83   SBR池一次搅拌
        myDTCList.add(mdtc54);
        //回转式风机1停止/运行
        myDTCList.add(mdtc9);
        //回转式风机2停止/运行
        myDTCList.add(mdtc10);
        //备用84   SBR池二次搅拌
        myDTCList.add(mdtc55);
        //备用85   SBR池静置
        myDTCList.add(mdtc56);
        //污泥泵2停止/运行
        myDTCList.add(mdtc11);
        //备用86   滗水器周期
        myDTCList.add(mdtc57);
        //备用87   活化周期
        myDTCList.add(mdtc58);
        //集水池搅拌机停止/运行
        myDTCList.add(mdtc3);
        //除磷投加机停止/运行
        myDTCList.add(mdtc4);
        //集水池提升泵停止/运行
        myDTCList.add(mdtc5);
        //污泥泵1停止/运行
        myDTCList.add(mdtc6);
        //SBR池搅拌机停止/运行
        myDTCList.add(mdtc8);
        //滗水器停止/运行
        myDTCList.add(mdtc12);
        /***********  故障指示  *********************/
        //集水池搅拌机正常/故障
        myDTCList.add(mdtc13);
        //集水池提升泵正常/故障
        myDTCList.add(mdtc14);
        //污泥泵1正常/故障
        myDTCList.add(mdtc15);
        //SBR进水泵正常/故障
        myDTCList.add(mdtc16);
        //SBR池搅拌机1正常/故障
        myDTCList.add(mdtc17);
        //SBR池搅拌机2正常/故障
        myDTCList.add(mdtc18);
        //回转式风机1正常/故障
        myDTCList.add(mdtc19);
        //回转式风机2正常/故障
        myDTCList.add(mdtc20);
        //污泥泵2正常/故障
        myDTCList.add(mdtc21);
        //滗水器正常/故障
        myDTCList.add(mdtc22);
        //PLC电量不足
        myDTCList.add(mdtc23);
        /***********  公共参数  *********************/


        //集水池液位高未到/到了
        myDTCList.add(mdtc26);
        //集水池液位低未到/到了
        myDTCList.add(mdtc27);
        //调节池液位高未到/到了
        myDTCList.add(mdtc28);
        //调节池液位低未到/到了
        myDTCList.add(mdtc29);
        //SBR池液位高未到/到了
        myDTCList.add(mdtc30);
        //SBR池液位低未到/到了
        myDTCList.add(mdtc31);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("flowmeter");
        phoneRealMsgInfo01.setTitle("累计流量：");
        phoneRealMsgInfo01.setValue(String.valueOf(flowmeter) + "m³");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("todayFlowmeter");
        phoneRealMsgInfo02.setTitle("当日流量：");
        phoneRealMsgInfo02.setValue(String.valueOf(todayFlowmeter) + "m³");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("systemAuto");
        phoneRealMsgInfo03.setTitle("自动模式：");
        if (systemAuto) {
            phoneRealMsgInfo03.setValue("自动");
        } else {
            phoneRealMsgInfo03.setValue("手动");
        }
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("sbrCycle");
        phoneRealMsgInfo04.setTitle("SBR周期运行：");
        if (sbrCycle) {
            phoneRealMsgInfo04.setValue("运行");
        } else {
            phoneRealMsgInfo04.setValue("停止");
        }
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("dState");
        phoneRealMsgInfo05.setTitle("状态：");
        phoneRealMsgInfo05.setValue(getDState());
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

    public List<PhoneSewageC01RealData> getPhoneRealMsgInfoDetail() {
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PhoneSewageC01RealData> phoneSewageC01RealDataList = new ArrayList<PhoneSewageC01RealData>();

        //第一部分的两列
        PhoneSewageC01RealData phoneSewageC01RealData01 = new PhoneSewageC01RealData();
        phoneSewageC01RealData01.setColumn(2);
        phoneSewageC01RealData01.setScale("0.5,0.5");
        phoneSewageC01RealData01.setTitle("总体信息");
        List<PhoneSewageC01RealOneData> phoneSewageC01RealOneDataList01 = new ArrayList<PhoneSewageC01RealOneData>();
        PhoneSewageC01RealOneData phoneSewageC01RealOneData01 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData01.setTitle("时间：");
        phoneSewageC01RealOneData01.setValue1(sendDate);
        phoneSewageC01RealOneData01.setColor1(defaultColor);
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData01);

        //累计流量（m³）
        PhoneSewageC01RealOneData phoneSewageC01RealOneData02 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData02.setTitle("累计流量：");
        phoneSewageC01RealOneData02.setValue1(String.valueOf(flowmeter) + "m³");
        phoneSewageC01RealOneData02.setColor1(defaultColor);
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData02);

        //当日流量(m³)
        PhoneSewageC01RealOneData phoneSewageC01RealOneData03 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData03.setTitle("当日流量：");
        phoneSewageC01RealOneData03.setValue1(String.valueOf(todayFlowmeter) + "m³");
        phoneSewageC01RealOneData03.setColor1(defaultColor);
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData03);

        //系统自动模式
        PhoneSewageC01RealOneData phoneSewageC01RealOneData04 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData04.setTitle("系统自动模式：");
        if (systemAuto) {
            phoneSewageC01RealOneData04.setValue1("自动");
            phoneSewageC01RealOneData04.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData04.setValue1("手动");
            phoneSewageC01RealOneData04.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData04);

        //SBR周期运行
        PhoneSewageC01RealOneData phoneSewageC01RealOneData05 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData05.setTitle("SBR周期运行：");
        if (sbrCycle) {
            phoneSewageC01RealOneData05.setValue1("运行");
            phoneSewageC01RealOneData05.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData05.setValue1("停止");
            phoneSewageC01RealOneData05.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData05);
        //第一部分两列收尾
        phoneSewageC01RealData01.setPhoneSewageC01RealOneDataList(phoneSewageC01RealOneDataList01);
        phoneSewageC01RealDataList.add(phoneSewageC01RealData01);

        //第二部分的三列
        PhoneSewageC01RealData phoneSewageC01RealData02 = new PhoneSewageC01RealData();
        phoneSewageC01RealData02.setColumn(3);
        phoneSewageC01RealData02.setScale("0.5,0.3,0.2");
        phoneSewageC01RealData02.setTitle("SBR污水处理控制系统(分钟)");
        List<PhoneSewageC01RealOneData> phoneSewageC01RealOneDataList02 = new ArrayList<PhoneSewageC01RealOneData>();
        //除磷投加机
        PhoneSewageC01RealOneData phoneSewageC01RealOneData06 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData06.setTitle("除磷投加机：");
        if (dephosphorizeRun) {
            phoneSewageC01RealOneData06.setValue1("运行");
            phoneSewageC01RealOneData06.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData06.setValue1("停止");
            phoneSewageC01RealOneData06.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData06.setValue2(String.valueOf(dephosphorizeRunMinute) + "");
        phoneSewageC01RealOneData06.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData06);

        //污泥泵1
        PhoneSewageC01RealOneData phoneSewageC01RealOneData07 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData07.setTitle("污泥泵1：");
        if (sludgePump01Run) {
            phoneSewageC01RealOneData07.setValue1("运行");
            phoneSewageC01RealOneData07.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData07.setValue1("停止");
            phoneSewageC01RealOneData07.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData07.setValue2(String.valueOf(sludgePump01RunMinute) + "");
        phoneSewageC01RealOneData07.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData07);

        //SBR池进水泵
        PhoneSewageC01RealOneData phoneSewageC01RealOneData08 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData08.setTitle("SBR池进水泵：");
        if (sbrIntakePumpRun) {
            phoneSewageC01RealOneData08.setValue1("运行");
            phoneSewageC01RealOneData08.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData08.setValue1("停止");
            phoneSewageC01RealOneData08.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData08.setValue2(String.valueOf(sbrIntakePumpRunMinute) + "");
        phoneSewageC01RealOneData08.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData08);

        //SBR一次搅拌
        PhoneSewageC01RealOneData phoneSewageC01RealOneData09 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData09.setTitle("SBR一次搅拌：");
        if (sbrMixerOnceRun) {
            phoneSewageC01RealOneData09.setValue1("运行");
            phoneSewageC01RealOneData09.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData09.setValue1("停止");
            phoneSewageC01RealOneData09.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData09.setValue2(String.valueOf(sbrMixerOnceRunMinute) + "");
        phoneSewageC01RealOneData09.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData09);

        //SBR曝气
        PhoneSewageC01RealOneData phoneSewageC01RealOneData10 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData10.setTitle("SBR曝气：");
        if (fan01Run || fan02Run) {
            phoneSewageC01RealOneData10.setValue1("运行");
            phoneSewageC01RealOneData10.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData10.setValue1("停止");
            phoneSewageC01RealOneData10.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData10.setValue2(String.valueOf(fanRunMinute) + "");
        phoneSewageC01RealOneData10.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData10);

        //SBR二次搅拌
        PhoneSewageC01RealOneData phoneSewageC01RealOneData11 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData11.setTitle("SBR二次搅拌：");
        if (sbrMixerSecRun) {
            phoneSewageC01RealOneData11.setValue1("运行");
            phoneSewageC01RealOneData11.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData11.setValue1("停止");
            phoneSewageC01RealOneData11.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData11.setValue2(String.valueOf(sbrMixerRunMinute) + "");
        phoneSewageC01RealOneData11.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData11);

        //SBR静置
        PhoneSewageC01RealOneData phoneSewageC01RealOneData12 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData12.setTitle("SBR静置：");
        if (sbrStaticRun) {
            phoneSewageC01RealOneData12.setValue1("运行");
            phoneSewageC01RealOneData12.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData12.setValue1("停止");
            phoneSewageC01RealOneData12.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData12.setValue2(String.valueOf(sbrStaticRunMinute) + "");
        phoneSewageC01RealOneData12.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData12);

        //SBR污泥泵2
        PhoneSewageC01RealOneData phoneSewageC01RealOneData13 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData13.setTitle("SBR污泥泵2：");
        if (sludgePump02Run) {
            phoneSewageC01RealOneData13.setValue1("运行");
            phoneSewageC01RealOneData13.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData13.setValue1("停止");
            phoneSewageC01RealOneData13.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData13.setValue2(String.valueOf(sludgePump02RunMinute) + "");
        phoneSewageC01RealOneData13.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData13);

        //滗水器(排水)
        PhoneSewageC01RealOneData phoneSewageC01RealOneData14 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData14.setTitle("滗水器(排水)：");
        if (decanterCycleRun) {
            phoneSewageC01RealOneData14.setValue1("运行");
            phoneSewageC01RealOneData14.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData14.setValue1("停止");
            phoneSewageC01RealOneData14.setColor1(normalStopColor);
        }
        if (decanterRun) {
            phoneSewageC01RealOneData14.setValue2("运行");
            phoneSewageC01RealOneData14.setColor2(normalRunColor);
        } else {
            phoneSewageC01RealOneData14.setValue2("停止");
            phoneSewageC01RealOneData14.setColor2(normalStopColor);
        }
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData14);

        //SBR静置活化
        PhoneSewageC01RealOneData phoneSewageC01RealOneData15 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData15.setTitle("SBR静置活化：");
        if (sbrActiveRun) {
            phoneSewageC01RealOneData15.setValue1("运行");
            phoneSewageC01RealOneData15.setColor1(normalRunColor);
        } else {
            phoneSewageC01RealOneData15.setValue1("停止");
            phoneSewageC01RealOneData15.setColor1(normalStopColor);
        }
        phoneSewageC01RealOneData15.setValue2(String.valueOf(sbrActiveRunMinute) + "");
        phoneSewageC01RealOneData15.setColor2(defaultColor);
        phoneSewageC01RealOneDataList02.add(phoneSewageC01RealOneData15);
        //第二部分三列收尾
        phoneSewageC01RealData02.setPhoneSewageC01RealOneDataList(phoneSewageC01RealOneDataList02);
        phoneSewageC01RealDataList.add(phoneSewageC01RealData02);

        //第三部分的两列--设定时间
        PhoneSewageC01RealData phoneSewageC01RealData03 = new PhoneSewageC01RealData();
        phoneSewageC01RealData03.setColumn(2);
        phoneSewageC01RealData03.setScale("0.5,0.5");
        phoneSewageC01RealData03.setTitle("SBR工艺流程设定时间(分钟)");
        List<PhoneSewageC01RealOneData> phoneSewageC01RealOneDataList03 = new ArrayList<PhoneSewageC01RealOneData>();

        //除磷投加机
        PhoneSewageC01RealOneData phoneSewageC01RealOneData16 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData16.setTitle("除磷投加机：");
        phoneSewageC01RealOneData16.setValue1(String.valueOf(dephosphorizeSetMinute));
        phoneSewageC01RealOneData16.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData16);

        //污泥泵1
        PhoneSewageC01RealOneData phoneSewageC01RealOneData17 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData17.setTitle("污泥泵1：");
        phoneSewageC01RealOneData17.setValue1(String.valueOf(sludgePump01SetMinute));
        phoneSewageC01RealOneData17.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData17);

        //SBR设定周期
        PhoneSewageC01RealOneData phoneSewageC01RealOneData18 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData18.setTitle("SBR设定周期：");
        phoneSewageC01RealOneData18.setValue1(String.valueOf(sbrCycleSetMinute));
        phoneSewageC01RealOneData18.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData18);

        //SBR一次搅拌
        PhoneSewageC01RealOneData phoneSewageC01RealOneData19 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData19.setTitle("SBR一次搅拌：");
        phoneSewageC01RealOneData19.setValue1(String.valueOf(sbrMixerOnceSetMinute));
        phoneSewageC01RealOneData19.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData19);

        //SBR曝气
        PhoneSewageC01RealOneData phoneSewageC01RealOneData20 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData20.setTitle("SBR曝气：");
        phoneSewageC01RealOneData20.setValue1(String.valueOf(fanSetMinute));
        phoneSewageC01RealOneData20.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData20);

        //SBR二次搅拌
        PhoneSewageC01RealOneData phoneSewageC01RealOneData21 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData21.setTitle("SBR二次搅拌：");
        phoneSewageC01RealOneData21.setValue1(String.valueOf(sbrMixerSetMinute));
        phoneSewageC01RealOneData21.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData21);

        //SBR静置
        PhoneSewageC01RealOneData phoneSewageC01RealOneData22 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData22.setTitle("SBR静置：");
        phoneSewageC01RealOneData22.setValue1(String.valueOf(sbrStaticSetMinute));
        phoneSewageC01RealOneData22.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData22);

        //SBR污泥泵2
        PhoneSewageC01RealOneData phoneSewageC01RealOneData23 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData23.setTitle("SBR污泥泵2：");
        phoneSewageC01RealOneData23.setValue1(String.valueOf(sludgePump02SetMinute));
        phoneSewageC01RealOneData23.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData23);

        //SBR静置活化
        PhoneSewageC01RealOneData phoneSewageC01RealOneData24 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData24.setTitle("SBR静置活化：");
        phoneSewageC01RealOneData24.setValue1(String.valueOf(sbrActiveSetMinute));
        phoneSewageC01RealOneData24.setColor1(defaultColor);
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData24);

        //状态
        PhoneSewageC01RealOneData phoneSewageC01RealOneData25 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData25.setTitle("状态：");
        if (getDState().equals("离线") ) {
            phoneSewageC01RealOneData25.setValue1(getDState());
            phoneSewageC01RealOneData25.setColor1(alarmColor);
        } else {
            phoneSewageC01RealOneData25.setValue1(getDState());
            phoneSewageC01RealOneData25.setColor1(defaultColor);
        }
        phoneSewageC01RealOneDataList03.add(phoneSewageC01RealOneData25);

        //第三部分两列收尾
        phoneSewageC01RealData03.setPhoneSewageC01RealOneDataList(phoneSewageC01RealOneDataList03);
        phoneSewageC01RealDataList.add(phoneSewageC01RealData03);

        return phoneSewageC01RealDataList;
    }
}
