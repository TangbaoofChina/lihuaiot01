package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealOneData;
import com.system.po.Phone.PhoneSewageC212.PhoneSewageC212RealData;
import com.system.po.Phone.PhoneSewageC212.PhoneSewageC212RealOneData;

import java.util.ArrayList;
import java.util.List;

public class SewageC212DeviceMessage extends BaseDeviceMessage {
    //系统保留
    private int systemSpare;
    /************* 16个 运行状态  ******************/
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
    //SBR池搅拌机01停止/运行
    private Boolean sbrMixer01Run;
    //回转式风机1停止/运行
    private Boolean fan01Run;
    //回转式风机2停止/运行
    private Boolean fan02Run;
    //污泥泵2停止/运行
    private Boolean sludgePump02Run;
    //滗水器停止/运行
    private Boolean decanterRun;
    //SBR池搅拌机02停止/运行
    private Boolean sbrMixer02Run;
    //SBR池一次搅拌
    private Boolean sbrMixerOnceRun;
    //SBR池二次搅拌
    private Boolean sbrMixerSecRun;
    //SBR池静置
    private Boolean sbrStaticRun;
    //滗水器周期
    private Boolean decanterCycleRun;
    //活化周期
    private Boolean sbrActiveRun;
    /*********** 16+1 故障指示  *********************/
    //故障指示-2字节
    private  String faultIndication;
    //集水池搅拌机正常/故障
    private Boolean collectMixerFault;
    //除磷投加机正常/故障
    private Boolean dephosphorizeFault;
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
    //备用12.4
    private Boolean spare1204;
    //智能电表设备通讯故障
    private Boolean elecFault;
    //空气温度变送器通讯故障
    private Boolean airTempFault;
    //SBR水温变送器通讯故障
    private Boolean waterTempFault;
    /*********** 16个 公共参数 2byte *********************/
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
    //滗水器关
    private Boolean decanterOff;
    //备用14.1
    private Boolean spare1401;
    //备用14.2
    private Boolean spare1402;
    //滗水器开到位限位
    private Boolean decanterOnOK;
    //滗水器关到位限位
    private Boolean decanterOffOK;
    //备用14.5
    private Boolean spare1405;
    //备用14.6
    private Boolean spare1406;
    //备用14.7
    private Boolean spare1407;
    /*********** 10个 数据-设定时间  *********************/
    //sbr设定总时间
    private int sbrCycleSetMinute;
    //MODBUS通讯代码, 字顺序21
    private int modbusCode;
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
    /*********** 11个 数据-运行时间  *********************/
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
    //SBR池进水泵（运行时间）
    private int sbrIntakePumpRunMinute;
    /***********  4个 其他数据  *********************/
    //流量计（m³）
    private long flowmeter;
    //当日流量(m³)
    private long todayFlowmeter;
    //环境温度
    private float airTemp;
    //SBR池水温
    private float waterTemp;
    /*********** 16+2个 电能数据  *********************/
    //线电压Uab
    private float uab;
    //线电压Ubc
    private float ubc;
    //线电压Uca
    private float uca;
    //相电压Ua
    private float ua;
    //相电压Ub
    private float ub;
    //相电压Uc
    private float uc;
    //电流Ia
    private float ia;
    //电流Ib
    private float ib;
    //电流Ic
    private float ic;
    //合相有功功率
    private float pt;
    //合相无功功率
    private float qt;
    //合相视在功率
    private float st;
    //合相功率因数
    private float pft;
    //频率
    private float freq;
    //正向有功总电能
    private float impEP;
    //反向有功总电能
    private float expEP;
    //当日电量 需要运算
    private float todayEP;
    //备用133、134
    private int spare133134;
    //备用135、136
    private int spare135136;
    /*********** 11个 设备运行累计时长(小时) *********************/
    //集水池搅拌机累计时长
    private int collectMixerTotal;
    //除磷投加机累计时长
    private int dephosphorizeTotal;
    //集水池提升泵累计时长
    private int collectPumpTotal;
    //污泥泵1累计时长
    private int sludgePump01Total;
    //SBR进水泵累计时长
    private int sbrIntakePumpTotal;
    //SBR池搅拌机1累计时长
    private int sbrMixer01Total;
    //SBR池搅拌机2累计时长
    private int sbrMixer02Total;
    //回转式风机1累计时长
    private int fan01Total;
    //回转式风机2累计时长
    private int fan02Total;
    //污泥泵2累计时长
    private int sludgePump02Total;
    //滗水器累计时长
    private int decanterTotal;
    //设备发送数据时间
    private String sendDate;

    public int getSystemSpare() {
        return systemSpare;
    }

    public void setSystemSpare(int systemSpare) {
        this.systemSpare = systemSpare;
    }

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

    public Boolean getSbrMixer01Run() {
        return sbrMixer01Run;
    }

    public void setSbrMixer01Run(Boolean sbrMixer01Run) {
        this.sbrMixer01Run = sbrMixer01Run;
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

    public Boolean getSbrMixer02Run() {
        return sbrMixer02Run;
    }

    public void setSbrMixer02Run(Boolean sbrMixer02Run) {
        this.sbrMixer02Run = sbrMixer02Run;
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

    public String getFaultIndication() {
        return faultIndication;
    }

    public void setFaultIndication(String faultIndication) {
        this.faultIndication = faultIndication;
    }

    public Boolean getCollectMixerFault() {
        return collectMixerFault;
    }

    public void setCollectMixerFault(Boolean collectMixerFault) {
        this.collectMixerFault = collectMixerFault;
    }

    public Boolean getDephosphorizeFault() {
        return dephosphorizeFault;
    }

    public void setDephosphorizeFault(Boolean dephosphorizeFault) {
        this.dephosphorizeFault = dephosphorizeFault;
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

    public Boolean getSpare1204() {
        return spare1204;
    }

    public void setSpare1204(Boolean spare1204) {
        this.spare1204 = spare1204;
    }

    public Boolean getElecFault() {
        return elecFault;
    }

    public void setElecFault(Boolean elecFault) {
        this.elecFault = elecFault;
    }

    public Boolean getAirTempFault() {
        return airTempFault;
    }

    public void setAirTempFault(Boolean airTempFault) {
        this.airTempFault = airTempFault;
    }

    public Boolean getWaterTempFault() {
        return waterTempFault;
    }

    public void setWaterTempFault(Boolean waterTempFault) {
        this.waterTempFault = waterTempFault;
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

    public Boolean getDecanterOff() {
        return decanterOff;
    }

    public void setDecanterOff(Boolean decanterOff) {
        this.decanterOff = decanterOff;
    }

    public Boolean getSpare1401() {
        return spare1401;
    }

    public void setSpare1401(Boolean spare1401) {
        this.spare1401 = spare1401;
    }

    public Boolean getSpare1402() {
        return spare1402;
    }

    public void setSpare1402(Boolean spare1402) {
        this.spare1402 = spare1402;
    }

    public Boolean getDecanterOnOK() {
        return decanterOnOK;
    }

    public void setDecanterOnOK(Boolean decanterOnOK) {
        this.decanterOnOK = decanterOnOK;
    }

    public Boolean getDecanterOffOK() {
        return decanterOffOK;
    }

    public void setDecanterOffOK(Boolean decanterOffOK) {
        this.decanterOffOK = decanterOffOK;
    }

    public Boolean getSpare1405() {
        return spare1405;
    }

    public void setSpare1405(Boolean spare1405) {
        this.spare1405 = spare1405;
    }

    public Boolean getSpare1406() {
        return spare1406;
    }

    public void setSpare1406(Boolean spare1406) {
        this.spare1406 = spare1406;
    }

    public Boolean getSpare1407() {
        return spare1407;
    }

    public void setSpare1407(Boolean spare1407) {
        this.spare1407 = spare1407;
    }

    public int getSbrCycleSetMinute() {
        return sbrCycleSetMinute;
    }

    public void setSbrCycleSetMinute(int sbrCycleSetMinute) {
        this.sbrCycleSetMinute = sbrCycleSetMinute;
    }

    public int getModbusCode() {
        return modbusCode;
    }

    public void setModbusCode(int modbusCode) {
        this.modbusCode = modbusCode;
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

    public long getTodayFlowmeter() {
        return todayFlowmeter;
    }

    public void setTodayFlowmeter(long todayFlowmeter) {
        this.todayFlowmeter = todayFlowmeter;
    }

    public float getAirTemp() {
        return airTemp;
    }

    public void setAirTemp(float airTemp) {
        this.airTemp = airTemp;
    }

    public float getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(float waterTemp) {
        this.waterTemp = waterTemp;
    }

    public float getUab() {
        return uab;
    }

    public void setUab(float uab) {
        this.uab = uab;
    }

    public float getUbc() {
        return ubc;
    }

    public void setUbc(float ubc) {
        this.ubc = ubc;
    }

    public float getUca() {
        return uca;
    }

    public void setUca(float uca) {
        this.uca = uca;
    }

    public float getUa() {
        return ua;
    }

    public void setUa(float ua) {
        this.ua = ua;
    }

    public float getUb() {
        return ub;
    }

    public void setUb(float ub) {
        this.ub = ub;
    }

    public float getUc() {
        return uc;
    }

    public void setUc(float uc) {
        this.uc = uc;
    }

    public float getIa() {
        return ia;
    }

    public void setIa(float ia) {
        this.ia = ia;
    }

    public float getIb() {
        return ib;
    }

    public void setIb(float ib) {
        this.ib = ib;
    }

    public float getIc() {
        return ic;
    }

    public void setIc(float ic) {
        this.ic = ic;
    }

    public float getPt() {
        return pt;
    }

    public void setPt(float pt) {
        this.pt = pt;
    }

    public float getQt() {
        return qt;
    }

    public void setQt(float qt) {
        this.qt = qt;
    }

    public float getSt() {
        return st;
    }

    public void setSt(float st) {
        this.st = st;
    }

    public float getPft() {
        return pft;
    }

    public void setPft(float pft) {
        this.pft = pft;
    }

    public float getFreq() {
        return freq;
    }

    public void setFreq(float freq) {
        this.freq = freq;
    }

    public float getImpEP() {
        return impEP;
    }

    public void setImpEP(float impEP) {
        this.impEP = impEP;
    }

    public float getExpEP() {
        return expEP;
    }

    public void setExpEP(float expEP) {
        this.expEP = expEP;
    }

    public float getTodayEP() {
        return todayEP;
    }

    public void setTodayEP(float todayEP) {
        this.todayEP = todayEP;
    }

    public int getSpare133134() {
        return spare133134;
    }

    public void setSpare133134(int spare133134) {
        this.spare133134 = spare133134;
    }

    public int getSpare135136() {
        return spare135136;
    }

    public void setSpare135136(int spare135136) {
        this.spare135136 = spare135136;
    }

    public int getCollectMixerTotal() {
        return collectMixerTotal;
    }

    public void setCollectMixerTotal(int collectMixerTotal) {
        this.collectMixerTotal = collectMixerTotal;
    }

    public int getDephosphorizeTotal() {
        return dephosphorizeTotal;
    }

    public void setDephosphorizeTotal(int dephosphorizeTotal) {
        this.dephosphorizeTotal = dephosphorizeTotal;
    }

    public int getCollectPumpTotal() {
        return collectPumpTotal;
    }

    public void setCollectPumpTotal(int collectPumpTotal) {
        this.collectPumpTotal = collectPumpTotal;
    }

    public int getSludgePump01Total() {
        return sludgePump01Total;
    }

    public void setSludgePump01Total(int sludgePump01Total) {
        this.sludgePump01Total = sludgePump01Total;
    }

    public int getSbrIntakePumpTotal() {
        return sbrIntakePumpTotal;
    }

    public void setSbrIntakePumpTotal(int sbrIntakePumpTotal) {
        this.sbrIntakePumpTotal = sbrIntakePumpTotal;
    }

    public int getSbrMixer01Total() {
        return sbrMixer01Total;
    }

    public void setSbrMixer01Total(int sbrMixer01Total) {
        this.sbrMixer01Total = sbrMixer01Total;
    }

    public int getSbrMixer02Total() {
        return sbrMixer02Total;
    }

    public void setSbrMixer02Total(int sbrMixer02Total) {
        this.sbrMixer02Total = sbrMixer02Total;
    }

    public int getFan01Total() {
        return fan01Total;
    }

    public void setFan01Total(int fan01Total) {
        this.fan01Total = fan01Total;
    }

    public int getFan02Total() {
        return fan02Total;
    }

    public void setFan02Total(int fan02Total) {
        this.fan02Total = fan02Total;
    }

    public int getSludgePump02Total() {
        return sludgePump02Total;
    }

    public void setSludgePump02Total(int sludgePump02Total) {
        this.sludgePump02Total = sludgePump02Total;
    }

    public int getDecanterTotal() {
        return decanterTotal;
    }

    public void setDecanterTotal(int decanterTotal) {
        this.decanterTotal = decanterTotal;
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

        /************* 16个 运行状态  ******************/
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
        //污泥泵01停止/运行
        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("sludgePump01Run");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("污泥泵01运行");
        mdtc6.setVisible(false);
        //SBR进水泵停止/运行
        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("sbrIntakePumpRun");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("SBR进水泵运行");
        mdtc7.setVisible(false);
        //SBR池搅拌机01停止/运行
        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("sbrMixer01Run");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("SBR池搅拌机01运行");
        mdtc8.setVisible(false);
        //回转式风机01停止/运行
        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("fan01Run");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("回转式风机01运行");
        mdtc9.setVisible(false);
        //回转式风机02停止/运行
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("fan02Run");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("回转式风机02运行");
        mdtc10.setVisible(false);
        //污泥泵02停止/运行
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("sludgePump02Run");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("污泥泵02运行");
        mdtc11.setVisible(false);
        //滗水器停止/运行
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("decanterRun");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("滗水器运行");
        mdtc12.setVisible(false);
        //SBR池搅拌机02停止/运行
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("sbrMixer02Run");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("SBR池搅拌机02运行");
        mdtc13.setVisible(false);
        //SBR池一次搅拌
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("sbrMixerOnceRun");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("SBR池一次搅拌运行");
        mdtc14.setVisible(false);
        //SBR池二次搅拌
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("sbrMixerSecRun");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("SBR池二次搅拌运行");
        mdtc15.setVisible(false);
        //SBR池静置
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("sbrStaticRun");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("SBR池静置运行");
        mdtc16.setVisible(false);
        //滗水器周期
        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("decanterCycleRun");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("滗水器周期运行");
        mdtc17.setVisible(false);
        //活化周期
        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("sbrActiveRun");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("活化周期运行");
        mdtc18.setVisible(false);

        /*********** 16+1 故障指示  *********************/
        //集水池搅拌机正常/故障
        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("collectMixerFault");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("集水池搅拌机故障");
        mdtc19.setVisible(false);
        //除磷投加机正常/故障
        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("dephosphorizeFault");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("除磷投加机故障");
        mdtc20.setVisible(false);
        //集水池提升泵正常/故障
        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("collectPumpFault");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("集水池提升泵故障");
        mdtc21.setVisible(false);
        //污泥泵01正常/故障
        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("sludgePump01Fault");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("污泥泵01故障");
        mdtc22.setVisible(false);
        //SBR进水泵正常/故障
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("sbrIntakePumpFault");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("SBR进水泵故障");
        mdtc23.setVisible(false);
        //SBR池搅拌机1正常/故障
        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("sbrMixer01Fault");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("SBR池搅拌机01故障");
        mdtc24.setVisible(false);
        //SBR池搅拌机2正常/故障
        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("sbrMixer02Fault");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("SBR池搅拌机02故障");
        mdtc25.setVisible(false);
        //回转式风机1正常/故障
        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("fan01Fault");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("回转式风机01故障");
        mdtc26.setVisible(false);
        //回转式风机2正常/故障
        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("fan02Fault");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("回转式风机02故障");
        mdtc27.setVisible(false);
        //污泥泵2正常/故障
        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("sludgePump02Fault");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("污泥泵02故障");
        mdtc28.setVisible(false);
        //滗水器正常/故障
        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("decanterFault");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("滗水器故障");
        mdtc29.setVisible(false);
        //PLC电量不足
        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("plcElecLack");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("PLC电量不足");
        mdtc30.setVisible(false);
        //智能电表设备通讯故障
        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("elecFault");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("智能电表通讯故障");
        mdtc31.setVisible(false);
        //空气温度变送器通讯故障
        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("airTempFault");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("空气温度变送器通讯故障");
        mdtc32.setVisible(false);
        //SBR水温变送器通讯故障
        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("waterTempFault");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("SBR水温变送器通讯故障");
        mdtc33.setVisible(false);

        /*********** 16个 公共参数 2byte *********************/
        //系统手动模式/自动模式
        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("systemAuto");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("自动模式");
        mdtc34.setVisible(true);
        //SBR周期运行标识
        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("sbrCycle");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("SBR周期运行");
        mdtc35.setVisible(true);
        //集水池液位高未到/到了
        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("collectHighOn");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("集水池液位高到了");
        mdtc36.setVisible(false);
        //集水池液位低未到/到了
        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("collectLowOn");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("集水池液位低到了");
        mdtc37.setVisible(false);
        //调节池液位高未到/到了
        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("regulatHighOn");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("调节池液位高到了");
        mdtc38.setVisible(false);
        //调节池液位低未到/到了
        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("regulatLowOn");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("调节池液位低到了");
        mdtc39.setVisible(false);
        //SBR池液位高未到/到了
        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("sbrHighOn");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("SBR池液位高到了");
        mdtc40.setVisible(false);
        //SBR池液位低未到/到了
        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("sbrLowOn");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("SBR池液位低高到了");
        mdtc41.setVisible(false);
        //滗水器关
        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("decanterOff");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("滗水器关");
        mdtc42.setVisible(false);
        //滗水器开到位限位
        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("decanterOnOK");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("滗水器开到位");
        mdtc43.setVisible(false);
        //滗水器关到位限位
        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("decanterOffOK");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("滗水器关到位");
        mdtc44.setVisible(false);

        //sbr设定总时间
        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("sbrCycleSetMinute");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("sbr设定总时间");
        mdtc45.setVisible(true);
        //除磷投加机时间 （设定分钟）
        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("dephosphorizeSetMinute");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("除磷投加机设定时间");
        mdtc46.setVisible(false);
        //污泥泵1（设定分钟）
        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("sludgePump01SetMinute");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("污泥泵01设定时间");
        mdtc47.setVisible(false);
        //SBR一次搅拌（设定分钟）
        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("sbrMixerOnceSetMinute");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("SBR一次搅拌设定时间");
        mdtc48.setVisible(false);
        //SBR曝气（设定分钟）
        MydataTableColumn mdtc49 = new MydataTableColumn();
        mdtc49.setData("fanSetMinute");
        mdtc49.setDefaultContent("49");
        mdtc49.setTitle("SBR曝气设定时间");
        mdtc49.setVisible(false);
        //SBR混合（设定分钟）
        MydataTableColumn mdtc50 = new MydataTableColumn();
        mdtc50.setData("sbrMixerSetMinute");
        mdtc50.setDefaultContent("50");
        mdtc50.setTitle("SBR混合设定时间");
        mdtc50.setVisible(false);
        //SBR静置（设定分钟）
        MydataTableColumn mdtc51 = new MydataTableColumn();
        mdtc51.setData("sbrStaticSetMinute");
        mdtc51.setDefaultContent("51");
        mdtc51.setTitle("SBR静置设定时间");
        mdtc51.setVisible(false);
        //SBR污泥泵2（设定分钟）
        MydataTableColumn mdtc52 = new MydataTableColumn();
        mdtc52.setData("sludgePump02SetMinute");
        mdtc52.setDefaultContent("52");
        mdtc52.setTitle("SBR污泥泵02设定时间");
        mdtc52.setVisible(false);
        //SBR活化（设定分钟）
        MydataTableColumn mdtc53 = new MydataTableColumn();
        mdtc53.setData("sbrActiveSetMinute");
        mdtc53.setDefaultContent("53");
        mdtc53.setTitle("SBR活化设定时间");
        mdtc53.setVisible(false);
        /*********** 11个 数据-运行时间  *********************/
        //除磷投加机时间 （运行分钟）
        MydataTableColumn mdtc54 = new MydataTableColumn();
        mdtc54.setData("dephosphorizeRunMinute");
        mdtc54.setDefaultContent("54");
        mdtc54.setTitle("除磷投加机运行时间");
        mdtc54.setVisible(true);
        //污泥泵1（运行分钟）
        MydataTableColumn mdtc55 = new MydataTableColumn();
        mdtc55.setData("sludgePump01RunMinute");
        mdtc55.setDefaultContent("55");
        mdtc55.setTitle("污泥泵01运行时间");
        mdtc55.setVisible(true);
        //SBR一次搅拌（运行分钟）
        MydataTableColumn mdtc56 = new MydataTableColumn();
        mdtc56.setData("sbrMixerOnceRunMinute");
        mdtc56.setDefaultContent("56");
        mdtc56.setTitle("SBR一次搅拌运行时间");
        mdtc56.setVisible(true);
        //SBR曝气（运行分钟）
        MydataTableColumn mdtc57 = new MydataTableColumn();
        mdtc57.setData("fanRunMinute");
        mdtc57.setDefaultContent("57");
        mdtc57.setTitle("SBR曝气运行时间");
        mdtc57.setVisible(true);
        //SBR混合（运行分钟）
        MydataTableColumn mdtc58 = new MydataTableColumn();
        mdtc58.setData("sbrMixerRunMinute");
        mdtc58.setDefaultContent("58");
        mdtc58.setTitle("SBR混合运行时间");
        mdtc58.setVisible(true);
        //SBR静置（运行分钟）
        MydataTableColumn mdtc59 = new MydataTableColumn();
        mdtc59.setData("sbrStaticRunMinute");
        mdtc59.setDefaultContent("59");
        mdtc59.setTitle("SBR静置运行时间");
        mdtc59.setVisible(true);
        //SBR污泥泵2（运行分钟）
        MydataTableColumn mdtc60 = new MydataTableColumn();
        mdtc60.setData("sludgePump02RunMinute");
        mdtc60.setDefaultContent("60");
        mdtc60.setTitle("污泥泵02运行时间");
        mdtc60.setVisible(true);
        //SBR活化（运行分钟）
        MydataTableColumn mdtc61 = new MydataTableColumn();
        mdtc61.setData("sbrActiveRunMinute");
        mdtc61.setDefaultContent("61");
        mdtc61.setTitle("SBR活化运行时间");
        mdtc61.setVisible(true);
        //集水池搅拌机（运行时间）
        MydataTableColumn mdtc62 = new MydataTableColumn();
        mdtc62.setData("collectMixerRunMinute");
        mdtc62.setDefaultContent("62");
        mdtc62.setTitle("集水池搅拌机运行时间");
        mdtc62.setVisible(true);
        //集水池提升泵时间（运行分钟）
        MydataTableColumn mdtc63 = new MydataTableColumn();
        mdtc63.setData("collectPumpRunMinute");
        mdtc63.setDefaultContent("63");
        mdtc63.setTitle("集水池提升泵运行时间");
        mdtc63.setVisible(true);
        //SBR池进水泵（运行时间）
        MydataTableColumn mdtc64 = new MydataTableColumn();
        mdtc64.setData("sbrIntakePumpRunMinute");
        mdtc64.setDefaultContent("44");
        mdtc64.setTitle("SBR池进水泵运行时间");
        mdtc64.setVisible(true);

        //流量计（m³）
        MydataTableColumn mdtc65 = new MydataTableColumn();
        mdtc65.setData("flowmeter");
        mdtc65.setDefaultContent("65");
        mdtc65.setTitle("流量计");
        mdtc65.setVisible(true);
        //当日流量(m³)
        MydataTableColumn mdtc66 = new MydataTableColumn();
        mdtc66.setData("todayFlowmeter");
        mdtc66.setDefaultContent("66");
        mdtc66.setTitle("当日流量");
        mdtc66.setVisible(true);
        //环境温度
        MydataTableColumn mdtc67 = new MydataTableColumn();
        mdtc67.setData("airTemp");
        mdtc67.setDefaultContent("67");
        mdtc67.setTitle("环境温度");
        mdtc67.setVisible(true);
        //SBR池水温
        MydataTableColumn mdtc68 = new MydataTableColumn();
        mdtc68.setData("waterTemp");
        mdtc68.setDefaultContent("68");
        mdtc68.setTitle("SBR池水温");
        mdtc68.setVisible(true);

        /*********** 16+2个 电能数据  *********************/
        //线电压Uab
        MydataTableColumn mdtc69 = new MydataTableColumn();
        mdtc69.setData("uab");
        mdtc69.setDefaultContent("69");
        mdtc69.setTitle("线电压Uab");
        mdtc69.setVisible(false);
        //线电压Ubc
        MydataTableColumn mdtc70 = new MydataTableColumn();
        mdtc70.setData("ubc");
        mdtc70.setDefaultContent("70");
        mdtc70.setTitle("线电压Ubc");
        mdtc70.setVisible(false);
        //线电压Uca
        MydataTableColumn mdtc71 = new MydataTableColumn();
        mdtc71.setData("uca");
        mdtc71.setDefaultContent("71");
        mdtc71.setTitle("线电压Uca");
        mdtc71.setVisible(false);
        //相电压Ua
        MydataTableColumn mdtc72 = new MydataTableColumn();
        mdtc72.setData("ua");
        mdtc72.setDefaultContent("72");
        mdtc72.setTitle("相电压Ua");
        mdtc72.setVisible(false);
        //相电压Ub
        MydataTableColumn mdtc73 = new MydataTableColumn();
        mdtc73.setData("ub");
        mdtc73.setDefaultContent("73");
        mdtc73.setTitle("相电压Ub");
        mdtc73.setVisible(false);
        //相电压Uc
        MydataTableColumn mdtc74 = new MydataTableColumn();
        mdtc74.setData("uc");
        mdtc74.setDefaultContent("74");
        mdtc74.setTitle("相电压Uc");
        mdtc74.setVisible(false);
        //电流Ia
        MydataTableColumn mdtc75 = new MydataTableColumn();
        mdtc75.setData("ia");
        mdtc75.setDefaultContent("75");
        mdtc75.setTitle("电流Ia");
        mdtc75.setVisible(false);
        //电流Ib
        MydataTableColumn mdtc76 = new MydataTableColumn();
        mdtc76.setData("ib");
        mdtc76.setDefaultContent("76");
        mdtc76.setTitle("电流Ib");
        mdtc76.setVisible(false);
        //电流Ic
        MydataTableColumn mdtc77 = new MydataTableColumn();
        mdtc77.setData("ic");
        mdtc77.setDefaultContent("77");
        mdtc77.setTitle("电流Ic");
        mdtc77.setVisible(false);
        //合相有功功率
        MydataTableColumn mdtc78 = new MydataTableColumn();
        mdtc78.setData("pt");
        mdtc78.setDefaultContent("78");
        mdtc78.setTitle("合相有功功率");
        mdtc78.setVisible(false);
        //合相无功功率
        MydataTableColumn mdtc79 = new MydataTableColumn();
        mdtc79.setData("qt");
        mdtc79.setDefaultContent("79");
        mdtc79.setTitle("合相无功功率");
        mdtc79.setVisible(false);
        //合相视在功率
        MydataTableColumn mdtc80 = new MydataTableColumn();
        mdtc80.setData("st");
        mdtc80.setDefaultContent("80");
        mdtc80.setTitle("合相视在功率");
        mdtc80.setVisible(false);
        //合相功率因数
        MydataTableColumn mdtc81 = new MydataTableColumn();
        mdtc81.setData("pft");
        mdtc81.setDefaultContent("81");
        mdtc81.setTitle("合相功率因数");
        mdtc81.setVisible(false);
        //频率
        MydataTableColumn mdtc82 = new MydataTableColumn();
        mdtc82.setData("freq");
        mdtc82.setDefaultContent("82");
        mdtc82.setTitle("频率");
        mdtc82.setVisible(false);
        //正向有功总电能
        MydataTableColumn mdtc83 = new MydataTableColumn();
        mdtc83.setData("impEP");
        mdtc83.setDefaultContent("83");
        mdtc83.setTitle("正向有功总电能");
        mdtc83.setVisible(true);
        //反向有功总电能
        MydataTableColumn mdtc84 = new MydataTableColumn();
        mdtc84.setData("expEP");
        mdtc84.setDefaultContent("84");
        mdtc84.setTitle("反向有功总电能");
        mdtc84.setVisible(false);
        //当日电量
        MydataTableColumn mdtc98 = new MydataTableColumn();
        mdtc98.setData("todayEP");
        mdtc98.setDefaultContent("98");
        mdtc98.setTitle("当日电量");
        mdtc98.setVisible(true);
        /*********** 11个 设备运行累计时长(小时) *********************/
        //集水池搅拌机累计时长
        MydataTableColumn mdtc85 = new MydataTableColumn();
        mdtc85.setData("collectMixerTotal");
        mdtc85.setDefaultContent("85");
        mdtc85.setTitle("集水池搅拌机累计时长");
        mdtc85.setVisible(false);
        //除磷投加机累计时长
        MydataTableColumn mdtc86 = new MydataTableColumn();
        mdtc86.setData("dephosphorizeTotal");
        mdtc86.setDefaultContent("86");
        mdtc86.setTitle("除磷投加机累计时长");
        mdtc86.setVisible(false);
        //集水池提升泵累计时长
        MydataTableColumn mdtc87 = new MydataTableColumn();
        mdtc87.setData("collectPumpTotal");
        mdtc87.setDefaultContent("87");
        mdtc87.setTitle("集水池提升泵累计时长");
        mdtc87.setVisible(false);
        //污泥泵1累计时长
        MydataTableColumn mdtc88 = new MydataTableColumn();
        mdtc88.setData("sludgePump01Total");
        mdtc88.setDefaultContent("88");
        mdtc88.setTitle("污泥泵01累计时长");
        mdtc88.setVisible(false);
        //SBR进水泵累计时长
        MydataTableColumn mdtc89 = new MydataTableColumn();
        mdtc89.setData("sbrIntakePumpTotal");
        mdtc89.setDefaultContent("89");
        mdtc89.setTitle("SBR进水泵累计时长");
        mdtc89.setVisible(false);
        //SBR池搅拌机1累计时长
        MydataTableColumn mdtc90 = new MydataTableColumn();
        mdtc90.setData("sbrMixer01Total");
        mdtc90.setDefaultContent("90");
        mdtc90.setTitle("SBR池搅拌机01累计时长");
        mdtc90.setVisible(false);
        //SBR池搅拌机2累计时长
        MydataTableColumn mdtc91 = new MydataTableColumn();
        mdtc91.setData("sbrMixer02Total");
        mdtc91.setDefaultContent("91");
        mdtc91.setTitle("SBR池搅拌机02累计时长");
        mdtc91.setVisible(false);
        //回转式风机1累计时长
        MydataTableColumn mdtc92 = new MydataTableColumn();
        mdtc92.setData("fan01Total");
        mdtc92.setDefaultContent("92");
        mdtc92.setTitle("回转式风机01累计时长");
        mdtc92.setVisible(false);
        //回转式风机2累计时长
        MydataTableColumn mdtc93 = new MydataTableColumn();
        mdtc93.setData("fan02Total");
        mdtc93.setDefaultContent("93");
        mdtc93.setTitle("回转式风机02累计时长");
        mdtc93.setVisible(false);
        //污泥泵2累计时长
        MydataTableColumn mdtc94 = new MydataTableColumn();
        mdtc94.setData("sludgePump02Total");
        mdtc94.setDefaultContent("94");
        mdtc94.setTitle("污泥泵02累计时长");
        mdtc94.setVisible(false);
        //滗水器累计时长
        MydataTableColumn mdtc95 = new MydataTableColumn();
        mdtc95.setData("decanterTotal");
        mdtc95.setDefaultContent("95");
        mdtc95.setTitle("滗水器累计时长");
        mdtc95.setVisible(false);

        //设备发送数据时间
        MydataTableColumn mdtc96 = new MydataTableColumn();
        mdtc96.setData("sendDate");
        mdtc96.setDefaultContent("96");
        mdtc96.setTitle("时间");
        mdtc96.setVisible(true);

        //设备在线状态
        MydataTableColumn mdtc97 = new MydataTableColumn();
        mdtc97.setData("dState");
        mdtc97.setDefaultContent("97");
        mdtc97.setTitle("状态");
        mdtc97.setVisible(true);

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //设备在线状态
        myDTCList.add(mdtc97);
        //设备发送数据时间
        myDTCList.add(mdtc96);
        //流量计（m³）
        myDTCList.add(mdtc65);
        //当日流量(m³)
        myDTCList.add(mdtc66);
        //正向有功总电能
        myDTCList.add(mdtc83);
        //当日电量
        myDTCList.add(mdtc98);
        //环境温度
        myDTCList.add(mdtc67);
        //SBR池水温
        myDTCList.add(mdtc68);
        /************* 16个 运行状态  ******************/
        //集水池搅拌机停止/运行
        myDTCList.add(mdtc3);
        //除磷投加机停止/运行
        myDTCList.add(mdtc4);
        //集水池提升泵停止/运行
        myDTCList.add(mdtc5);
        //污泥泵01停止/运行
        myDTCList.add(mdtc6);
        //SBR进水泵停止/运行
        myDTCList.add(mdtc7);
        //SBR池搅拌机01停止/运行
        myDTCList.add(mdtc8);
        //回转式风机01停止/运行
        myDTCList.add(mdtc9);
        //回转式风机02停止/运行
        myDTCList.add(mdtc10);
        //污泥泵02停止/运行
        myDTCList.add(mdtc11);
        //滗水器停止/运行
        myDTCList.add(mdtc12);
        //SBR池搅拌机02停止/运行
        myDTCList.add(mdtc13);
        //SBR池一次搅拌
        myDTCList.add(mdtc14);
        //SBR池二次搅拌
        myDTCList.add(mdtc15);
        //SBR池静置
        myDTCList.add(mdtc16);
        //滗水器周期
        myDTCList.add(mdtc17);
        //活化周期
        myDTCList.add(mdtc18);

        /*********** 16+1 故障指示  *********************/
        //集水池搅拌机正常/故障
        myDTCList.add(mdtc19);
        //除磷投加机正常/故障
        myDTCList.add(mdtc20);
        //集水池提升泵正常/故障
        myDTCList.add(mdtc21);
        //污泥泵01正常/故障
        myDTCList.add(mdtc22);
        //SBR进水泵正常/故障
        myDTCList.add(mdtc23);
        //SBR池搅拌机1正常/故障
        myDTCList.add(mdtc24);
        //SBR池搅拌机2正常/故障
        myDTCList.add(mdtc25);
        //回转式风机1正常/故障
        myDTCList.add(mdtc26);
        //回转式风机2正常/故障
        myDTCList.add(mdtc27);
        //污泥泵2正常/故障
        myDTCList.add(mdtc28);
        //滗水器正常/故障
        myDTCList.add(mdtc29);
        //PLC电量不足
        myDTCList.add(mdtc30);
        //智能电表设备通讯故障
        myDTCList.add(mdtc31);
        //空气温度变送器通讯故障
        myDTCList.add(mdtc32);
        //SBR水温变送器通讯故障
        myDTCList.add(mdtc33);

        /*********** 16个 公共参数 2byte *********************/
        //系统手动模式/自动模式
        myDTCList.add(mdtc34);
        //SBR周期运行标识
        myDTCList.add(mdtc35);
        //集水池液位高未到/到了
        myDTCList.add(mdtc36);
        //集水池液位低未到/到了
        myDTCList.add(mdtc37);
        //调节池液位高未到/到了
        myDTCList.add(mdtc38);
        //调节池液位低未到/到了
        myDTCList.add(mdtc39);
        //SBR池液位高未到/到了
        myDTCList.add(mdtc40);
        //SBR池液位低未到/到了
        myDTCList.add(mdtc41);
        //滗水器关
        myDTCList.add(mdtc42);
        //滗水器开到位限位
        myDTCList.add(mdtc43);
        //滗水器关到位限位
        myDTCList.add(mdtc44);

        //sbr设定总时间
        myDTCList.add(mdtc45);
        //除磷投加机时间 （设定分钟）
        myDTCList.add(mdtc46);
        //污泥泵1（设定分钟）
        myDTCList.add(mdtc47);
        //SBR一次搅拌（设定分钟）
        myDTCList.add(mdtc48);
        //SBR曝气（设定分钟）
        myDTCList.add(mdtc49);
        //SBR混合（设定分钟）
        myDTCList.add(mdtc50);
        //SBR静置（设定分钟）
        myDTCList.add(mdtc51);
        //SBR污泥泵2（设定分钟）
        myDTCList.add(mdtc52);
        //SBR活化（设定分钟）
        myDTCList.add(mdtc53);
        /*********** 11个 数据-运行时间  *********************/
        //除磷投加机时间 （运行分钟）
        myDTCList.add(mdtc54);
        //污泥泵1（运行分钟）
        myDTCList.add(mdtc55);
        //SBR一次搅拌（运行分钟）
        myDTCList.add(mdtc56);
        //SBR曝气（运行分钟）
        myDTCList.add(mdtc57);
        //SBR混合（运行分钟）
        myDTCList.add(mdtc58);
        //SBR静置（运行分钟）
        myDTCList.add(mdtc59);
        //SBR污泥泵2（运行分钟）
        myDTCList.add(mdtc60);
        //SBR活化（运行分钟）
        myDTCList.add(mdtc61);
        //集水池搅拌机（运行时间）
        myDTCList.add(mdtc62);
        //集水池提升泵时间（运行分钟）
        myDTCList.add(mdtc63);
        //SBR池进水泵（运行时间）
        myDTCList.add(mdtc64);



        /*********** 16+2个 电能数据  *********************/
        //线电压Uab
        myDTCList.add(mdtc69);
        //线电压Ubc
        myDTCList.add(mdtc70);
        //线电压Uca
        myDTCList.add(mdtc71);
        //相电压Ua
        myDTCList.add(mdtc72);
        //相电压Ub
        myDTCList.add(mdtc73);
        //相电压Uc
        myDTCList.add(mdtc74);
        //电流Ia
        myDTCList.add(mdtc75);
        //电流Ib
        myDTCList.add(mdtc76);
        //电流Ic
        myDTCList.add(mdtc77);
        //合相有功功率
        myDTCList.add(mdtc78);
        //合相无功功率
        myDTCList.add(mdtc79);
        //合相视在功率
        myDTCList.add(mdtc80);
        //合相功率因数
        myDTCList.add(mdtc81);
        //频率
        myDTCList.add(mdtc82);

        //反向有功总电能
        myDTCList.add(mdtc84);

        /*********** 11个 设备运行累计时长(小时) *********************/
        //集水池搅拌机累计时长
        myDTCList.add(mdtc85);
        //除磷投加机累计时长
        myDTCList.add(mdtc86);
        //集水池提升泵累计时长
        myDTCList.add(mdtc87);
        //污泥泵1累计时长
        myDTCList.add(mdtc88);
        //SBR进水泵累计时长
        myDTCList.add(mdtc89);
        //SBR池搅拌机1累计时长
        myDTCList.add(mdtc90);
        //SBR池搅拌机2累计时长
        myDTCList.add(mdtc91);
        //回转式风机1累计时长
        myDTCList.add(mdtc92);
        //回转式风机2累计时长
        myDTCList.add(mdtc93);
        //污泥泵2累计时长
        myDTCList.add(mdtc94);
        //滗水器累计时长
        myDTCList.add(mdtc95);

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

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("waterTemp");
        phoneRealMsgInfo07.setTitle("SBR池水温：");
        phoneRealMsgInfo07.setValue(String.valueOf(waterTemp) + "℃");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

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

    public List<PhoneSewageC212RealData> getPhoneRealMsgInfoDetail212() {
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PhoneSewageC212RealData> phoneSewageC212RealDataList = new ArrayList<PhoneSewageC212RealData>();

        //第一部分的两列
        PhoneSewageC212RealData phoneSewageC212RealData01 = new PhoneSewageC212RealData();
        phoneSewageC212RealData01.setColumn(2);
        phoneSewageC212RealData01.setScale("0.5,0.5");
        phoneSewageC212RealData01.setTitle("总体信息");
        List<PhoneSewageC212RealOneData> phoneSewageC212RealOneDataList01 = new ArrayList<PhoneSewageC212RealOneData>();
        PhoneSewageC212RealOneData phoneSewageC212RealOneData01 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData01.setTitle("时间：");
        phoneSewageC212RealOneData01.setValue1(sendDate);
        phoneSewageC212RealOneData01.setColor1(defaultColor);
        phoneSewageC212RealOneDataList01.add(phoneSewageC212RealOneData01);

        //累计流量（m³）
        PhoneSewageC212RealOneData phoneSewageC212RealOneData02 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData02.setTitle("累计流量：");
        phoneSewageC212RealOneData02.setValue1(String.valueOf(flowmeter) + "m³");
        phoneSewageC212RealOneData02.setColor1(defaultColor);
        phoneSewageC212RealOneDataList01.add(phoneSewageC212RealOneData02);

        //当日流量(m³)
        PhoneSewageC212RealOneData phoneSewageC212RealOneData03 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData03.setTitle("当日流量：");
        phoneSewageC212RealOneData03.setValue1(String.valueOf(todayFlowmeter) + "m³");
        phoneSewageC212RealOneData03.setColor1(defaultColor);
        phoneSewageC212RealOneDataList01.add(phoneSewageC212RealOneData03);

        //系统自动模式
        PhoneSewageC212RealOneData phoneSewageC212RealOneData04 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData04.setTitle("系统自动模式：");
        if (systemAuto) {
            phoneSewageC212RealOneData04.setValue1("自动");
            phoneSewageC212RealOneData04.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData04.setValue1("手动");
            phoneSewageC212RealOneData04.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneDataList01.add(phoneSewageC212RealOneData04);

        //SBR周期运行
        PhoneSewageC212RealOneData phoneSewageC212RealOneData05 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData05.setTitle("SBR周期运行：");
        if (sbrCycle) {
            phoneSewageC212RealOneData05.setValue1("运行");
            phoneSewageC212RealOneData05.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData05.setValue1("停止");
            phoneSewageC212RealOneData05.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneDataList01.add(phoneSewageC212RealOneData05);
        //第一部分两列收尾
        phoneSewageC212RealData01.setPhoneSewageC212RealOneDataList(phoneSewageC212RealOneDataList01);
        phoneSewageC212RealDataList.add(phoneSewageC212RealData01);

        //第二部分的三列
        PhoneSewageC212RealData phoneSewageC212RealData02 = new PhoneSewageC212RealData();
        phoneSewageC212RealData02.setColumn(3);
        phoneSewageC212RealData02.setScale("0.5,0.3,0.2");
        phoneSewageC212RealData02.setTitle("SBR污水处理控制系统(分钟)");
        List<PhoneSewageC212RealOneData> phoneSewageC212RealOneDataList02 = new ArrayList<PhoneSewageC212RealOneData>();
        //除磷投加机
        PhoneSewageC212RealOneData phoneSewageC212RealOneData06 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData06.setTitle("除磷投加机：");
        if (dephosphorizeRun) {
            phoneSewageC212RealOneData06.setValue1("运行");
            phoneSewageC212RealOneData06.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData06.setValue1("停止");
            phoneSewageC212RealOneData06.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData06.setValue2(String.valueOf(dephosphorizeRunMinute) + "");
        phoneSewageC212RealOneData06.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData06);

        //污泥泵1
        PhoneSewageC212RealOneData phoneSewageC212RealOneData07 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData07.setTitle("污泥泵1：");
        if (sludgePump01Run) {
            phoneSewageC212RealOneData07.setValue1("运行");
            phoneSewageC212RealOneData07.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData07.setValue1("停止");
            phoneSewageC212RealOneData07.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData07.setValue2(String.valueOf(sludgePump01RunMinute) + "");
        phoneSewageC212RealOneData07.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData07);

        //SBR池进水泵
        PhoneSewageC212RealOneData phoneSewageC212RealOneData08 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData08.setTitle("SBR池进水泵：");
        if (sbrIntakePumpRun) {
            phoneSewageC212RealOneData08.setValue1("运行");
            phoneSewageC212RealOneData08.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData08.setValue1("停止");
            phoneSewageC212RealOneData08.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData08.setValue2(String.valueOf(sbrIntakePumpRunMinute) + "");
        phoneSewageC212RealOneData08.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData08);

        //SBR一次搅拌
        PhoneSewageC212RealOneData phoneSewageC212RealOneData09 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData09.setTitle("SBR一次搅拌：");
        if (sbrMixerOnceRun) {
            phoneSewageC212RealOneData09.setValue1("运行");
            phoneSewageC212RealOneData09.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData09.setValue1("停止");
            phoneSewageC212RealOneData09.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData09.setValue2(String.valueOf(sbrMixerOnceRunMinute) + "");
        phoneSewageC212RealOneData09.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData09);

        //SBR曝气
        PhoneSewageC212RealOneData phoneSewageC212RealOneData10 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData10.setTitle("SBR曝气：");
        if (fan01Run || fan02Run) {
            phoneSewageC212RealOneData10.setValue1("运行");
            phoneSewageC212RealOneData10.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData10.setValue1("停止");
            phoneSewageC212RealOneData10.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData10.setValue2(String.valueOf(fanRunMinute) + "");
        phoneSewageC212RealOneData10.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData10);

        //SBR二次搅拌
        PhoneSewageC212RealOneData phoneSewageC212RealOneData11 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData11.setTitle("SBR二次搅拌：");
        if (sbrMixerSecRun) {
            phoneSewageC212RealOneData11.setValue1("运行");
            phoneSewageC212RealOneData11.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData11.setValue1("停止");
            phoneSewageC212RealOneData11.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData11.setValue2(String.valueOf(sbrMixerRunMinute) + "");
        phoneSewageC212RealOneData11.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData11);

        //SBR静置
        PhoneSewageC212RealOneData phoneSewageC212RealOneData12 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData12.setTitle("SBR静置：");
        if (sbrStaticRun) {
            phoneSewageC212RealOneData12.setValue1("运行");
            phoneSewageC212RealOneData12.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData12.setValue1("停止");
            phoneSewageC212RealOneData12.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData12.setValue2(String.valueOf(sbrStaticRunMinute) + "");
        phoneSewageC212RealOneData12.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData12);

        //SBR污泥泵2
        PhoneSewageC212RealOneData phoneSewageC212RealOneData13 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData13.setTitle("SBR污泥泵2：");
        if (sludgePump02Run) {
            phoneSewageC212RealOneData13.setValue1("运行");
            phoneSewageC212RealOneData13.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData13.setValue1("停止");
            phoneSewageC212RealOneData13.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData13.setValue2(String.valueOf(sludgePump02RunMinute) + "");
        phoneSewageC212RealOneData13.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData13);

        //滗水器(排水)
        PhoneSewageC212RealOneData phoneSewageC212RealOneData14 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData14.setTitle("滗水器(排水)：");
        if (decanterCycleRun) {
            phoneSewageC212RealOneData14.setValue1("运行");
            phoneSewageC212RealOneData14.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData14.setValue1("停止");
            phoneSewageC212RealOneData14.setColor1(normalStopColor);
        }
        if (decanterRun) {
            phoneSewageC212RealOneData14.setValue2("运行");
            phoneSewageC212RealOneData14.setColor2(normalRunColor);
        } else {
            phoneSewageC212RealOneData14.setValue2("停止");
            phoneSewageC212RealOneData14.setColor2(normalStopColor);
        }
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData14);

        //SBR静置活化
        PhoneSewageC212RealOneData phoneSewageC212RealOneData15 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData15.setTitle("SBR静置活化：");
        if (sbrActiveRun) {
            phoneSewageC212RealOneData15.setValue1("运行");
            phoneSewageC212RealOneData15.setColor1(normalRunColor);
        } else {
            phoneSewageC212RealOneData15.setValue1("停止");
            phoneSewageC212RealOneData15.setColor1(normalStopColor);
        }
        phoneSewageC212RealOneData15.setValue2(String.valueOf(sbrActiveRunMinute) + "");
        phoneSewageC212RealOneData15.setColor2(defaultColor);
        phoneSewageC212RealOneDataList02.add(phoneSewageC212RealOneData15);
        //第二部分三列收尾
        phoneSewageC212RealData02.setPhoneSewageC212RealOneDataList(phoneSewageC212RealOneDataList02);
        phoneSewageC212RealDataList.add(phoneSewageC212RealData02);

        //第三部分的两列--设定时间
        PhoneSewageC212RealData phoneSewageC212RealData03 = new PhoneSewageC212RealData();
        phoneSewageC212RealData03.setColumn(2);
        phoneSewageC212RealData03.setScale("0.5,0.5");
        phoneSewageC212RealData03.setTitle("SBR工艺流程设定时间(分钟)");
        List<PhoneSewageC212RealOneData> phoneSewageC212RealOneDataList03 = new ArrayList<PhoneSewageC212RealOneData>();

        //除磷投加机
        PhoneSewageC212RealOneData phoneSewageC212RealOneData16 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData16.setTitle("除磷投加机：");
        phoneSewageC212RealOneData16.setValue1(String.valueOf(dephosphorizeSetMinute));
        phoneSewageC212RealOneData16.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData16);

        //污泥泵1
        PhoneSewageC212RealOneData phoneSewageC212RealOneData17 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData17.setTitle("污泥泵1：");
        phoneSewageC212RealOneData17.setValue1(String.valueOf(sludgePump01SetMinute));
        phoneSewageC212RealOneData17.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData17);

        //SBR设定周期
        PhoneSewageC212RealOneData phoneSewageC212RealOneData18 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData18.setTitle("SBR设定周期：");
        phoneSewageC212RealOneData18.setValue1(String.valueOf(sbrCycleSetMinute));
        phoneSewageC212RealOneData18.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData18);

        //SBR一次搅拌
        PhoneSewageC212RealOneData phoneSewageC212RealOneData19 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData19.setTitle("SBR一次搅拌：");
        phoneSewageC212RealOneData19.setValue1(String.valueOf(sbrMixerOnceSetMinute));
        phoneSewageC212RealOneData19.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData19);

        //SBR曝气
        PhoneSewageC212RealOneData phoneSewageC212RealOneData20 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData20.setTitle("SBR曝气：");
        phoneSewageC212RealOneData20.setValue1(String.valueOf(fanSetMinute));
        phoneSewageC212RealOneData20.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData20);

        //SBR二次搅拌
        PhoneSewageC212RealOneData phoneSewageC212RealOneData21 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData21.setTitle("SBR二次搅拌：");
        phoneSewageC212RealOneData21.setValue1(String.valueOf(sbrMixerSetMinute));
        phoneSewageC212RealOneData21.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData21);

        //SBR静置
        PhoneSewageC212RealOneData phoneSewageC212RealOneData22 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData22.setTitle("SBR静置：");
        phoneSewageC212RealOneData22.setValue1(String.valueOf(sbrStaticSetMinute));
        phoneSewageC212RealOneData22.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData22);

        //SBR污泥泵2
        PhoneSewageC212RealOneData phoneSewageC212RealOneData23 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData23.setTitle("SBR污泥泵2：");
        phoneSewageC212RealOneData23.setValue1(String.valueOf(sludgePump02SetMinute));
        phoneSewageC212RealOneData23.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData23);

        //SBR静置活化
        PhoneSewageC212RealOneData phoneSewageC212RealOneData24 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData24.setTitle("SBR静置活化：");
        phoneSewageC212RealOneData24.setValue1(String.valueOf(sbrActiveSetMinute));
        phoneSewageC212RealOneData24.setColor1(defaultColor);
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData24);

        //状态
        PhoneSewageC212RealOneData phoneSewageC212RealOneData25 = new PhoneSewageC212RealOneData();
        phoneSewageC212RealOneData25.setTitle("状态：");
        if (getDState().equals("离线") ) {
            phoneSewageC212RealOneData25.setValue1(getDState());
            phoneSewageC212RealOneData25.setColor1(alarmColor);
        } else {
            phoneSewageC212RealOneData25.setValue1(getDState());
            phoneSewageC212RealOneData25.setColor1(defaultColor);
        }
        phoneSewageC212RealOneDataList03.add(phoneSewageC212RealOneData25);

        //第三部分两列收尾
        phoneSewageC212RealData03.setPhoneSewageC212RealOneDataList(phoneSewageC212RealOneDataList03);
        phoneSewageC212RealDataList.add(phoneSewageC212RealData03);

        return phoneSewageC212RealDataList;
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

        //SBR池水温(℃)
        PhoneSewageC01RealOneData phoneSewageC01RealOneData26 = new PhoneSewageC01RealOneData();
        phoneSewageC01RealOneData26.setTitle("SBR池水温：");
        phoneSewageC01RealOneData26.setValue1(String.valueOf(waterTemp) + "℃");
        phoneSewageC01RealOneData26.setColor1(defaultColor);
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData26);

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
