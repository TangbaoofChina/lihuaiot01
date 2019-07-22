package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealOneData;

import java.util.ArrayList;
import java.util.List;

public class SewageC214DM extends BaseDeviceMessage {
    //系统保留
    private int systemSpare;
    /************* 12个 运行状态  ******************/
    //收集池搅拌机停止/运行
    private Boolean collectMixerRun;
    //加药泵 停止/运行
    private Boolean dosingPumpRun;
    //集水井提升泵 停止/运行
    private Boolean collectWellPumpRun;
    //污泥泵 停止/运行
    private Boolean sludgePumpRun;
    //除磷池提升泵 停止/运行
    private Boolean dephosphorizePumpRun;
    //SBR池搅拌机01停止/运行
    private Boolean sbrMixer01Run;
    //回转式风机1停止/运行
    private Boolean fan01Run;
    //回转式风机2停止/运行
    private Boolean fan02Run;
    //收集池提升泵 停止/运行
    private Boolean collectPumpRun;
    //滗水器电磁阀开 停止/运行
    private Boolean decanterRun;
    //SBR池搅拌机02停止/运行
    private Boolean sbrMixer02Run;
    //加药罐搅拌机 停止/运行
    private Boolean dosingMixerRun;
    //备用1004
    private Boolean spare1004;
    //备用1005
    private Boolean spare1005;
    //备用1006
    private Boolean spare1006;
    //备用1007
    private Boolean spare1007;
    /*********** 16+1 故障指示  *********************/
    //故障指示-2字节
    private  String faultIndication;
    //收集池搅拌机 正常/故障
    private Boolean collectMixerFault;
    //加药泵 正常/故障
    private Boolean dosingPumpFault;
    //集水井提升泵 正常/故障
    private Boolean collectWellPumpFault;
    //污泥泵 正常/故障
    private Boolean sludgePumpFault;
    //除磷池提升泵 正常/故障
    private Boolean dephosphorizePumpFault;
    //SBR池搅拌机01 正常/故障
    private Boolean sbrMixer01Fault;
    //SBR池搅拌机02 正常/故障
    private Boolean sbrMixer02Fault;
    //风机01 正常/故障
    private Boolean fan01Fault;
    //风机02 正常/故障
    private Boolean fan02Fault;
    //收集池提升泵 正常/故障
    private Boolean collectPumpFault;
    //滗水器 正常/故障
    private Boolean decanterFault;
    //PLC电量不足
    private Boolean plcElecLack;
    //加药罐搅拌机 正常/故障
    private Boolean dosingMixerFault;
    //智能电表设备通讯故障
    private Boolean elecFault;
    //空气温度变送器通讯故障
    private Boolean airTempFault;
    //SBR水温变送器通讯故障
    private Boolean waterTempFault;
    /*********** 9个 公共参数 2byte *********************/
    //备用13.0
    private Boolean spare1300;
    //备用13.1
    private Boolean spare1301;
    //收集池液位高未到/到了
    private Boolean collectHighOn;
    //收集池液位低未到/到了
    private Boolean collectLowOn;
    //除磷池液位高未到/到了
    private Boolean dephosphorizeHighOn;
    //除磷池液位低未到/到了
    private Boolean dephosphorizeLowOn;
    //SBR池液位高未到/到了
    private Boolean sbrHighOn;
    //SBR池液位低未到/到了
    private Boolean sbrLowOn;
    //滗水器电磁阀关 停止/运行
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
    /*********** 12个 数据-设定时间  *********************/
    //MODBUS通讯代码, 字顺序21
    private int modbusCode;
    //风机 设定运行时间 （设定分钟）
    private int fanSetMinute;
    //SBR搅拌机01 设定运行时间
    private int sbrMixer01SetMinute;
    //SBR搅拌机02 设定运行时间
    private int sbrMixer02SetMinute;
    //收集池提升泵 设定运行时间
    private int collectPumpSetMinute;
    //污泥泵（设定分钟）
    private int sludgePumpSetMinute;
    //除磷池提升泵 设定运行时间
    private int dephosphorizePumpSetMinute;
    //滗水器 设定运行时间
    private int decanterSetMinute;
    //收集池搅拌机 设定运行时间
    private int collectMixerSetMinute;
    //加药泵 设定运行时间
    private int dosingPumpSetMinute;
    //加药罐搅拌机 设定运行时间
    private int dosingMixerSetMinute;
    //集水井提升泵 设定运行时间
    private int collectWellPumpSetMinute;
    /*********** 12个 数据-运行时间  *********************/
    //加药泵 运行时间
    private int dosingPumpRunMinute;
    //污泥泵 （运行分钟）
    private int sludgePumpRunMinute;
    //SBR搅拌机01 运行时间
    private int sbrMixer01RunMinute;
    //风机1 运行时间 （运行分钟）
    private int fan01RunMinute;
    //SBR搅拌机02 运行时间
    private int sbrMixer02RunMinute;
    //加药罐搅拌机 运行时间
    private int dosingMixerRunMinute;
    //收集池提升泵 运行时间
    private int collectPumpRunMinute;
    //风机2 运行时间 （运行分钟）
    private int fan02RunMinute;
    //收集池搅拌机 运行时间
    private int collectMixerRunMinute;
    //集水井提升泵 运行时间
    private int collectWellPumpRunMinute;
    //除磷池提升泵 运行时间
    private int dephosphorizePumpRunMinute;

    //滗水器 运行时间
    private int decanterRunMinute;

    /***********  4个 其他数据  *********************/
    //流量计（m³）
    private long flowmeter;
    //当日流量(m³)
    private long todayFlowmeter;
    //环境温度
    private float airTemp;
    //SBR池水温
    private float waterTemp;
    /*********** 16+2个(一个备用，一个是滗水器的) 电能数据  *********************/
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
    //备用135、136
    private int spare135136;
    /*********** 12个 设备运行累计时长(小时) *********************/
    //收集池搅拌机 设备运行时间累积
    private int collectMixerTotal;
    //加药泵 设备运行时间累积
    private int dosingPumpTotal;
    //集水井提升泵 设备运行时间累积
    private int collectWellPumpTotal;
    //污泥泵 设备运行时间累积
    private int sludgePumpTotal;
    //除磷池提升泵 设备运行时间累积
    private int dephosphorizePumpTotal;
    //SBR池搅拌机01 设备运行时间累积
    private int sbrMixer01Total;
    //SBR池搅拌机02 设备运行时间累积
    private int sbrMixer02Total;
    //风机01 设备运行时间累积
    private int fan01Total;
    //风机02 设备运行时间累积
    private int fan02Total;
    //收集池提升泵 设备运行时间累积
    private int collectPumpTotal;
    //加药罐搅拌机 设备运行时间累积
    private int dosingMixerTotal;
    //滗水器 设备运行时间累积
    private int decanterTotal;
    /*********** 24个 设备自动启动时间点 *********************/
    //收集池提升泵 开始运行时间 时
    private int collectPumpSHour;
    //收集池提升泵 开始运行时间 分
    private int collectPumpSMinute;
    //风机01 开始运行时间 时
    private int fan01SHour;
    //风机01 开始运行时间 分
    private int fan01SMinute;
    //风机02 开始运行时间 时
    private int fan02SHour;
    //风机02 开始运行时间 分
    private int fan02SMinute;
    //收集池搅拌机 开始运行时间 时
    private int collectMixerSHour;
    //收集池搅拌机 开始运行时间 分
    private int collectMixerSMinute;
    //集水井提升泵 开始运行时间 时
    private int collectWellPumpSHour;
    //集水井提升泵 开始运行时间 分
    private int collectWellPumpSMinute;
    //SBR池搅拌机01 开始运行时间 时
    private int sbrMixer01SHour;
    //SBR池搅拌机01 开始运行时间 分
    private int sbrMixer01SMinute;
    //SBR池搅拌机02 开始运行时间 时
    private int sbrMixer02SHour;
    //SBR池搅拌机02 开始运行时间 分
    private int sbrMixer02SMinute;
    //污泥泵 开始运行时间 时
    private int sludgePumpSHour;
    //污泥泵 开始运行时间 分
    private int sludgePumpSMinute;
    //除磷池提升泵 开始运行时间 时
    private int dephosphorizePumpSHour;
    //除磷池提升泵 开始运行时间 分
    private int dephosphorizePumpSMinute;
    //滗水器 开始运行时间 时
    private int decanterSHour;
    //滗水器 开始运行时间 分
    private int decanterSMinute;
    //加药泵 开始运行时间 时
    private int dosingPumpSHour;
    //加药泵 开始运行时间 分
    private int dosingPumpSMinute;
    //加药罐搅拌机 开始运行时间 时
    private int dosingMixerSHour;
    //加药罐搅拌机 开始运行时间 分
    private int dosingMixerSMinute;
    /*********** 14个 备用 *********************/
    //备用 191
    private int spare191;
    //备用 192
    private int spare192;
    //备用 193
    private int spare193;
    //备用 194
    private int spare194;
    //备用 195
    private int spare195;
    //备用 196
    private int spare196;
    //备用 197
    private int spare197;
    //备用 198
    private int spare198;
    //备用 199
    private int spare199;
    //备用 200
    private int spare200;
    //备用 201
    private int spare201;
    //备用 202
    private int spare202;
    //GPS数据上传时间设置参数.单位秒
    private int ackSeconds;
    //设备地址设置参数
    private int plcAddress;
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

    public Boolean getDosingPumpRun() {
        return dosingPumpRun;
    }

    public void setDosingPumpRun(Boolean dosingPumpRun) {
        this.dosingPumpRun = dosingPumpRun;
    }

    public Boolean getCollectWellPumpRun() {
        return collectWellPumpRun;
    }

    public void setCollectWellPumpRun(Boolean collectWellPumpRun) {
        this.collectWellPumpRun = collectWellPumpRun;
    }

    public Boolean getSludgePumpRun() {
        return sludgePumpRun;
    }

    public void setSludgePumpRun(Boolean sludgePumpRun) {
        this.sludgePumpRun = sludgePumpRun;
    }

    public Boolean getDephosphorizePumpRun() {
        return dephosphorizePumpRun;
    }

    public void setDephosphorizePumpRun(Boolean dephosphorizePumpRun) {
        this.dephosphorizePumpRun = dephosphorizePumpRun;
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

    public Boolean getCollectPumpRun() {
        return collectPumpRun;
    }

    public void setCollectPumpRun(Boolean collectPumpRun) {
        this.collectPumpRun = collectPumpRun;
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

    public Boolean getDosingMixerRun() {
        return dosingMixerRun;
    }

    public void setDosingMixerRun(Boolean dosingMixerRun) {
        this.dosingMixerRun = dosingMixerRun;
    }

    public Boolean getSpare1004() {
        return spare1004;
    }

    public void setSpare1004(Boolean spare1004) {
        this.spare1004 = spare1004;
    }

    public Boolean getSpare1005() {
        return spare1005;
    }

    public void setSpare1005(Boolean spare1005) {
        this.spare1005 = spare1005;
    }

    public Boolean getSpare1006() {
        return spare1006;
    }

    public void setSpare1006(Boolean spare1006) {
        this.spare1006 = spare1006;
    }

    public Boolean getSpare1007() {
        return spare1007;
    }

    public void setSpare1007(Boolean spare1007) {
        this.spare1007 = spare1007;
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

    public Boolean getDosingPumpFault() {
        return dosingPumpFault;
    }

    public void setDosingPumpFault(Boolean dosingPumpFault) {
        this.dosingPumpFault = dosingPumpFault;
    }

    public Boolean getCollectWellPumpFault() {
        return collectWellPumpFault;
    }

    public void setCollectWellPumpFault(Boolean collectWellPumpFault) {
        this.collectWellPumpFault = collectWellPumpFault;
    }

    public Boolean getSludgePumpFault() {
        return sludgePumpFault;
    }

    public void setSludgePumpFault(Boolean sludgePumpFault) {
        this.sludgePumpFault = sludgePumpFault;
    }

    public Boolean getDephosphorizePumpFault() {
        return dephosphorizePumpFault;
    }

    public void setDephosphorizePumpFault(Boolean dephosphorizePumpFault) {
        this.dephosphorizePumpFault = dephosphorizePumpFault;
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

    public Boolean getCollectPumpFault() {
        return collectPumpFault;
    }

    public void setCollectPumpFault(Boolean collectPumpFault) {
        this.collectPumpFault = collectPumpFault;
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

    public Boolean getDosingMixerFault() {
        return dosingMixerFault;
    }

    public void setDosingMixerFault(Boolean dosingMixerFault) {
        this.dosingMixerFault = dosingMixerFault;
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

    public Boolean getSpare1300() {
        return spare1300;
    }

    public void setSpare1300(Boolean spare1300) {
        this.spare1300 = spare1300;
    }

    public Boolean getSpare1301() {
        return spare1301;
    }

    public void setSpare1301(Boolean spare1301) {
        this.spare1301 = spare1301;
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

    public Boolean getDephosphorizeHighOn() {
        return dephosphorizeHighOn;
    }

    public void setDephosphorizeHighOn(Boolean dephosphorizeHighOn) {
        this.dephosphorizeHighOn = dephosphorizeHighOn;
    }

    public Boolean getDephosphorizeLowOn() {
        return dephosphorizeLowOn;
    }

    public void setDephosphorizeLowOn(Boolean dephosphorizeLowOn) {
        this.dephosphorizeLowOn = dephosphorizeLowOn;
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

    public int getModbusCode() {
        return modbusCode;
    }

    public void setModbusCode(int modbusCode) {
        this.modbusCode = modbusCode;
    }

    public int getFanSetMinute() {
        return fanSetMinute;
    }

    public void setFanSetMinute(int fanSetMinute) {
        this.fanSetMinute = fanSetMinute;
    }

    public int getSbrMixer01SetMinute() {
        return sbrMixer01SetMinute;
    }

    public void setSbrMixer01SetMinute(int sbrMixer01SetMinute) {
        this.sbrMixer01SetMinute = sbrMixer01SetMinute;
    }

    public int getSbrMixer02SetMinute() {
        return sbrMixer02SetMinute;
    }

    public void setSbrMixer02SetMinute(int sbrMixer02SetMinute) {
        this.sbrMixer02SetMinute = sbrMixer02SetMinute;
    }

    public int getCollectPumpSetMinute() {
        return collectPumpSetMinute;
    }

    public void setCollectPumpSetMinute(int collectPumpSetMinute) {
        this.collectPumpSetMinute = collectPumpSetMinute;
    }

    public int getSludgePumpSetMinute() {
        return sludgePumpSetMinute;
    }

    public void setSludgePumpSetMinute(int sludgePumpSetMinute) {
        this.sludgePumpSetMinute = sludgePumpSetMinute;
    }

    public int getDephosphorizePumpSetMinute() {
        return dephosphorizePumpSetMinute;
    }

    public void setDephosphorizePumpSetMinute(int dephosphorizePumpSetMinute) {
        this.dephosphorizePumpSetMinute = dephosphorizePumpSetMinute;
    }

    public int getDecanterSetMinute() {
        return decanterSetMinute;
    }

    public void setDecanterSetMinute(int decanterSetMinute) {
        this.decanterSetMinute = decanterSetMinute;
    }

    public int getCollectMixerSetMinute() {
        return collectMixerSetMinute;
    }

    public void setCollectMixerSetMinute(int collectMixerSetMinute) {
        this.collectMixerSetMinute = collectMixerSetMinute;
    }

    public int getDosingPumpSetMinute() {
        return dosingPumpSetMinute;
    }

    public void setDosingPumpSetMinute(int dosingPumpSetMinute) {
        this.dosingPumpSetMinute = dosingPumpSetMinute;
    }

    public int getDosingMixerSetMinute() {
        return dosingMixerSetMinute;
    }

    public void setDosingMixerSetMinute(int dosingMixerSetMinute) {
        this.dosingMixerSetMinute = dosingMixerSetMinute;
    }

    public int getCollectWellPumpSetMinute() {
        return collectWellPumpSetMinute;
    }

    public void setCollectWellPumpSetMinute(int collectWellPumpSetMinute) {
        this.collectWellPumpSetMinute = collectWellPumpSetMinute;
    }

    public int getDosingPumpRunMinute() {
        return dosingPumpRunMinute;
    }

    public void setDosingPumpRunMinute(int dosingPumpRunMinute) {
        this.dosingPumpRunMinute = dosingPumpRunMinute;
    }

    public int getSludgePumpRunMinute() {
        return sludgePumpRunMinute;
    }

    public void setSludgePumpRunMinute(int sludgePumpRunMinute) {
        this.sludgePumpRunMinute = sludgePumpRunMinute;
    }

    public int getSbrMixer01RunMinute() {
        return sbrMixer01RunMinute;
    }

    public void setSbrMixer01RunMinute(int sbrMixer01RunMinute) {
        this.sbrMixer01RunMinute = sbrMixer01RunMinute;
    }

    public int getFan01RunMinute() {
        return fan01RunMinute;
    }

    public void setFan01RunMinute(int fan01RunMinute) {
        this.fan01RunMinute = fan01RunMinute;
    }

    public int getSbrMixer02RunMinute() {
        return sbrMixer02RunMinute;
    }

    public void setSbrMixer02RunMinute(int sbrMixer02RunMinute) {
        this.sbrMixer02RunMinute = sbrMixer02RunMinute;
    }

    public int getDosingMixerRunMinute() {
        return dosingMixerRunMinute;
    }

    public void setDosingMixerRunMinute(int dosingMixerRunMinute) {
        this.dosingMixerRunMinute = dosingMixerRunMinute;
    }

    public int getCollectPumpRunMinute() {
        return collectPumpRunMinute;
    }

    public void setCollectPumpRunMinute(int collectPumpRunMinute) {
        this.collectPumpRunMinute = collectPumpRunMinute;
    }

    public int getFan02RunMinute() {
        return fan02RunMinute;
    }

    public void setFan02RunMinute(int fan02RunMinute) {
        this.fan02RunMinute = fan02RunMinute;
    }

    public int getCollectMixerRunMinute() {
        return collectMixerRunMinute;
    }

    public void setCollectMixerRunMinute(int collectMixerRunMinute) {
        this.collectMixerRunMinute = collectMixerRunMinute;
    }

    public int getCollectWellPumpRunMinute() {
        return collectWellPumpRunMinute;
    }

    public void setCollectWellPumpRunMinute(int collectWellPumpRunMinute) {
        this.collectWellPumpRunMinute = collectWellPumpRunMinute;
    }

    public int getDephosphorizePumpRunMinute() {
        return dephosphorizePumpRunMinute;
    }

    public void setDephosphorizePumpRunMinute(int dephosphorizePumpRunMinute) {
        this.dephosphorizePumpRunMinute = dephosphorizePumpRunMinute;
    }

    public int getDecanterRunMinute() {
        return decanterRunMinute;
    }

    public void setDecanterRunMinute(int decanterRunMinute) {
        this.decanterRunMinute = decanterRunMinute;
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

    public int getDosingPumpTotal() {
        return dosingPumpTotal;
    }

    public void setDosingPumpTotal(int dosingPumpTotal) {
        this.dosingPumpTotal = dosingPumpTotal;
    }

    public int getCollectWellPumpTotal() {
        return collectWellPumpTotal;
    }

    public void setCollectWellPumpTotal(int collectWellPumpTotal) {
        this.collectWellPumpTotal = collectWellPumpTotal;
    }

    public int getSludgePumpTotal() {
        return sludgePumpTotal;
    }

    public void setSludgePumpTotal(int sludgePumpTotal) {
        this.sludgePumpTotal = sludgePumpTotal;
    }

    public int getDephosphorizePumpTotal() {
        return dephosphorizePumpTotal;
    }

    public void setDephosphorizePumpTotal(int dephosphorizePumpTotal) {
        this.dephosphorizePumpTotal = dephosphorizePumpTotal;
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

    public int getCollectPumpTotal() {
        return collectPumpTotal;
    }

    public void setCollectPumpTotal(int collectPumpTotal) {
        this.collectPumpTotal = collectPumpTotal;
    }

    public int getDosingMixerTotal() {
        return dosingMixerTotal;
    }

    public void setDosingMixerTotal(int dosingMixerTotal) {
        this.dosingMixerTotal = dosingMixerTotal;
    }

    public int getDecanterTotal() {
        return decanterTotal;
    }

    public void setDecanterTotal(int decanterTotal) {
        this.decanterTotal = decanterTotal;
    }

    public int getCollectPumpSHour() {
        return collectPumpSHour;
    }

    public void setCollectPumpSHour(int collectPumpSHour) {
        this.collectPumpSHour = collectPumpSHour;
    }

    public int getCollectPumpSMinute() {
        return collectPumpSMinute;
    }

    public void setCollectPumpSMinute(int collectPumpSMinute) {
        this.collectPumpSMinute = collectPumpSMinute;
    }

    public int getFan01SHour() {
        return fan01SHour;
    }

    public void setFan01SHour(int fan01SHour) {
        this.fan01SHour = fan01SHour;
    }

    public int getFan01SMinute() {
        return fan01SMinute;
    }

    public void setFan01SMinute(int fan01SMinute) {
        this.fan01SMinute = fan01SMinute;
    }

    public int getFan02SHour() {
        return fan02SHour;
    }

    public void setFan02SHour(int fan02SHour) {
        this.fan02SHour = fan02SHour;
    }

    public int getFan02SMinute() {
        return fan02SMinute;
    }

    public void setFan02SMinute(int fan02SMinute) {
        this.fan02SMinute = fan02SMinute;
    }

    public int getCollectMixerSHour() {
        return collectMixerSHour;
    }

    public void setCollectMixerSHour(int collectMixerSHour) {
        this.collectMixerSHour = collectMixerSHour;
    }

    public int getCollectMixerSMinute() {
        return collectMixerSMinute;
    }

    public void setCollectMixerSMinute(int collectMixerSMinute) {
        this.collectMixerSMinute = collectMixerSMinute;
    }

    public int getCollectWellPumpSHour() {
        return collectWellPumpSHour;
    }

    public void setCollectWellPumpSHour(int collectWellPumpSHour) {
        this.collectWellPumpSHour = collectWellPumpSHour;
    }

    public int getCollectWellPumpSMinute() {
        return collectWellPumpSMinute;
    }

    public void setCollectWellPumpSMinute(int collectWellPumpSMinute) {
        this.collectWellPumpSMinute = collectWellPumpSMinute;
    }

    public int getSbrMixer01SHour() {
        return sbrMixer01SHour;
    }

    public void setSbrMixer01SHour(int sbrMixer01SHour) {
        this.sbrMixer01SHour = sbrMixer01SHour;
    }

    public int getSbrMixer01SMinute() {
        return sbrMixer01SMinute;
    }

    public void setSbrMixer01SMinute(int sbrMixer01SMinute) {
        this.sbrMixer01SMinute = sbrMixer01SMinute;
    }

    public int getSbrMixer02SHour() {
        return sbrMixer02SHour;
    }

    public void setSbrMixer02SHour(int sbrMixer02SHour) {
        this.sbrMixer02SHour = sbrMixer02SHour;
    }

    public int getSbrMixer02SMinute() {
        return sbrMixer02SMinute;
    }

    public void setSbrMixer02SMinute(int sbrMixer02SMinute) {
        this.sbrMixer02SMinute = sbrMixer02SMinute;
    }

    public int getSludgePumpSHour() {
        return sludgePumpSHour;
    }

    public void setSludgePumpSHour(int sludgePumpSHour) {
        this.sludgePumpSHour = sludgePumpSHour;
    }

    public int getSludgePumpSMinute() {
        return sludgePumpSMinute;
    }

    public void setSludgePumpSMinute(int sludgePumpSMinute) {
        this.sludgePumpSMinute = sludgePumpSMinute;
    }

    public int getDephosphorizePumpSHour() {
        return dephosphorizePumpSHour;
    }

    public void setDephosphorizePumpSHour(int dephosphorizePumpSHour) {
        this.dephosphorizePumpSHour = dephosphorizePumpSHour;
    }

    public int getDephosphorizePumpSMinute() {
        return dephosphorizePumpSMinute;
    }

    public void setDephosphorizePumpSMinute(int dephosphorizePumpSMinute) {
        this.dephosphorizePumpSMinute = dephosphorizePumpSMinute;
    }

    public int getDecanterSHour() {
        return decanterSHour;
    }

    public void setDecanterSHour(int decanterSHour) {
        this.decanterSHour = decanterSHour;
    }

    public int getDecanterSMinute() {
        return decanterSMinute;
    }

    public void setDecanterSMinute(int decanterSMinute) {
        this.decanterSMinute = decanterSMinute;
    }

    public int getDosingPumpSHour() {
        return dosingPumpSHour;
    }

    public void setDosingPumpSHour(int dosingPumpSHour) {
        this.dosingPumpSHour = dosingPumpSHour;
    }

    public int getDosingPumpSMinute() {
        return dosingPumpSMinute;
    }

    public void setDosingPumpSMinute(int dosingPumpSMinute) {
        this.dosingPumpSMinute = dosingPumpSMinute;
    }

    public int getDosingMixerSHour() {
        return dosingMixerSHour;
    }

    public void setDosingMixerSHour(int dosingMixerSHour) {
        this.dosingMixerSHour = dosingMixerSHour;
    }

    public int getDosingMixerSMinute() {
        return dosingMixerSMinute;
    }

    public void setDosingMixerSMinute(int dosingMixerSMinute) {
        this.dosingMixerSMinute = dosingMixerSMinute;
    }

    public int getSpare191() {
        return spare191;
    }

    public void setSpare191(int spare191) {
        this.spare191 = spare191;
    }

    public int getSpare192() {
        return spare192;
    }

    public void setSpare192(int spare192) {
        this.spare192 = spare192;
    }

    public int getSpare193() {
        return spare193;
    }

    public void setSpare193(int spare193) {
        this.spare193 = spare193;
    }

    public int getSpare194() {
        return spare194;
    }

    public void setSpare194(int spare194) {
        this.spare194 = spare194;
    }

    public int getSpare195() {
        return spare195;
    }

    public void setSpare195(int spare195) {
        this.spare195 = spare195;
    }

    public int getSpare196() {
        return spare196;
    }

    public void setSpare196(int spare196) {
        this.spare196 = spare196;
    }

    public int getSpare197() {
        return spare197;
    }

    public void setSpare197(int spare197) {
        this.spare197 = spare197;
    }

    public int getSpare198() {
        return spare198;
    }

    public void setSpare198(int spare198) {
        this.spare198 = spare198;
    }

    public int getSpare199() {
        return spare199;
    }

    public void setSpare199(int spare199) {
        this.spare199 = spare199;
    }

    public int getSpare200() {
        return spare200;
    }

    public void setSpare200(int spare200) {
        this.spare200 = spare200;
    }

    public int getSpare201() {
        return spare201;
    }

    public void setSpare201(int spare201) {
        this.spare201 = spare201;
    }

    public int getSpare202() {
        return spare202;
    }

    public void setSpare202(int spare202) {
        this.spare202 = spare202;
    }

    public int getAckSeconds() {
        return ackSeconds;
    }

    public void setAckSeconds(int ackSeconds) {
        this.ackSeconds = ackSeconds;
    }

    public int getPlcAddress() {
        return plcAddress;
    }

    public void setPlcAddress(int plcAddress) {
        this.plcAddress = plcAddress;
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

        /************* 12个 运行状态  ******************/
        //收集池搅拌机停止/运行
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("collectMixerRun");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("收集池搅拌机运行");
        mdtc3.setVisible(false);
        //加药泵 停止/运行
        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dosingPumpRun");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("加药泵运行");
        mdtc4.setVisible(false);
        //集水井提升泵 停止/运行
        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("collectWellPumpRun");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("集水井提升泵运行");
        mdtc5.setVisible(false);
        //污泥泵 停止/运行
        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("sludgePumpRun");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("污泥泵运行");
        mdtc6.setVisible(false);
        //除磷池提升泵 停止/运行
        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("dephosphorizePumpRun");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("除磷池提升泵运行");
        mdtc7.setVisible(false);
        //SBR池搅拌机01停止/运行
        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("sbrMixer01Run");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("SBR池搅拌机01运行");
        mdtc8.setVisible(false);
        //回转式风机1停止/运行
        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("fan01Run");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("风机01运行");
        mdtc9.setVisible(false);
        //回转式风机2停止/运行
        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("fan02Run");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("风机02运行");
        mdtc10.setVisible(false);
        //收集池提升泵 停止/运行
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("collectPumpRun");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("收集池提升泵运行");
        mdtc11.setVisible(false);
        //滗水器电磁阀停止/运行
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("decanterRun");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("滗水器开");
        mdtc12.setVisible(false);
        //SBR池搅拌机02停止/运行
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("sbrMixer02Run");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("SBR池搅拌机02运行");
        mdtc13.setVisible(false);
        //加药罐搅拌机 停止/运行
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("dosingMixerRun");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("加药罐搅拌机运行");
        mdtc14.setVisible(false);

        /*********** 16+1 故障指示  *********************/

        //收集池搅拌机 正常/故障
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("collectMixerFault");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("收集池搅拌机故障");
        mdtc15.setVisible(false);
        //加药泵 正常/故障
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("dosingPumpFault");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("加药泵故障");
        mdtc16.setVisible(false);
        //集水井提升泵 正常/故障
        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("collectWellPumpFault");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("集水井提升泵故障");
        mdtc17.setVisible(false);
        //污泥泵 正常/故障
        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("sludgePumpFault");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("污泥泵故障");
        mdtc18.setVisible(false);
        //除磷池提升泵 正常/故障
        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("dephosphorizePumpFault");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("除磷池提升泵故障");
        mdtc19.setVisible(false);
        //SBR池搅拌机01 正常/故障
        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("sbrMixer01Fault");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("SBR池搅拌机01故障");
        mdtc20.setVisible(false);
        //SBR池搅拌机02 正常/故障
        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("sbrMixer02Fault");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("SBR池搅拌机02故障");
        mdtc21.setVisible(false);
        //风机01 正常/故障
        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("fan01Fault");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("风机01故障");
        mdtc22.setVisible(false);
        //风机02 正常/故障
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("fan02Fault");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("风机02故障");
        mdtc23.setVisible(false);
        //收集池提升泵 正常/故障
        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("collectPumpFault");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("收集池提升泵故障");
        mdtc24.setVisible(false);
        //滗水器 正常/故障
        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("decanterFault");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("滗水器故障");
        mdtc25.setVisible(false);
        //PLC电量不足
        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("plcElecLack");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("PLC电量不足");
        mdtc26.setVisible(false);
        //加药罐搅拌机 正常/故障
        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("dosingMixerFault");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("加药罐搅拌机故障");
        mdtc27.setVisible(false);
        //智能电表设备通讯故障
        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("elecFault");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("智能电表故障");
        mdtc28.setVisible(false);
        //空气温度变送器通讯故障
        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("airTempFault");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("环境温度故障");
        mdtc29.setVisible(false);
        //SBR水温变送器通讯故障
        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("waterTempFault");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("SBR水温故障");
        mdtc30.setVisible(false);
        /*********** 9个 公共参数 2byte *********************/
        //收集池液位高未到/到了
        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("collectHighOn");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("收集池液位高到了");
        mdtc31.setVisible(false);
        //收集池液位低未到/到了
        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("collectLowOn");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("收集池液位低到了");
        mdtc32.setVisible(false);
        //除磷池液位高未到/到了
        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("dephosphorizeHighOn");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("除磷池液位高到了");
        mdtc33.setVisible(false);
        //除磷池液位低未到/到了
        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("dephosphorizeLowOn");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("除磷池液位低到了");
        mdtc34.setVisible(false);
        //SBR池液位高未到/到了
        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("sbrHighOn");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("SBR池液位高到了");
        mdtc35.setVisible(false);
        //SBR池液位低未到/到了
        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("sbrLowOn");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("SBR池液位低到了");
        mdtc36.setVisible(false);
        //滗水器电磁阀关 停止/运行
        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("decanterOff");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("滗水器电磁阀关");
        mdtc37.setVisible(false);
        //滗水器开到位限位
        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("decanterOnOK");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("滗水器开到位");
        mdtc38.setVisible(false);
        //滗水器关到位限位
        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("decanterOffOK");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("滗水器关到位");
        mdtc39.setVisible(false);
        /*********** 12个 数据-设定时间  *********************/
        //风机 设定运行时间 （设定分钟）
        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("fanSetMinute");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("风机设定分钟");
        mdtc40.setVisible(false);
        //SBR搅拌机01 设定运行时间
        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("sbrMixer01SetMinute");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("SBR搅拌机01设定分钟");
        mdtc41.setVisible(false);
        //SBR搅拌机02 设定运行时间
        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("sbrMixer02SetMinute");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("SBR搅拌机02设定分钟");
        mdtc42.setVisible(false);
        //收集池提升泵 设定运行时间
        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("collectPumpSetMinute");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("收集池提升泵设定分钟");
        mdtc43.setVisible(false);
        //污泥泵（设定分钟）
        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("sludgePumpSetMinute");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("污泥泵设定分钟");
        mdtc44.setVisible(false);
        //除磷池提升泵 设定运行时间
        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("dephosphorizePumpSetMinute");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("除磷池提升泵设定分钟");
        mdtc45.setVisible(false);
        //滗水器 设定运行时间
        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("decanterSetMinute");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("滗水器设定分钟");
        mdtc46.setVisible(false);
        //收集池搅拌机 设定运行时间
        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("collectMixerSetMinute");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("收集池搅拌机设定分钟");
        mdtc47.setVisible(false);
        //加药泵 设定运行时间
        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("dosingPumpSetMinute");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("加药泵设定分钟");
        mdtc48.setVisible(false);
        //加药罐搅拌机 设定运行时间
        MydataTableColumn mdtc49 = new MydataTableColumn();
        mdtc49.setData("dosingMixerSetMinute");
        mdtc49.setDefaultContent("49");
        mdtc49.setTitle("加药罐搅拌机设定分钟");
        mdtc49.setVisible(false);
        //集水井提升泵 设定运行时间
        MydataTableColumn mdtc50 = new MydataTableColumn();
        mdtc50.setData("collectWellPumpSetMinute");
        mdtc50.setDefaultContent("50");
        mdtc50.setTitle("集水井提升泵设定分钟");
        mdtc50.setVisible(false);
        /*********** 12个 数据-运行时间  *********************/
        //加药泵 运行时间
        MydataTableColumn mdtc51 = new MydataTableColumn();
        mdtc51.setData("dosingPumpRunMinute");
        mdtc51.setDefaultContent("51");
        mdtc51.setTitle("加药泵运行分钟");
        mdtc51.setVisible(false);
        //污泥泵 （运行分钟）
        MydataTableColumn mdtc52 = new MydataTableColumn();
        mdtc52.setData("sludgePumpRunMinute");
        mdtc52.setDefaultContent("52");
        mdtc52.setTitle("污泥泵运行分钟");
        mdtc52.setVisible(false);
        //SBR搅拌机01 运行时间
        MydataTableColumn mdtc53 = new MydataTableColumn();
        mdtc53.setData("sbrMixer01RunMinute");
        mdtc53.setDefaultContent("53");
        mdtc53.setTitle("SBR搅拌机01运行分钟");
        mdtc53.setVisible(false);
        //风机1 运行时间 （运行分钟）
        MydataTableColumn mdtc54 = new MydataTableColumn();
        mdtc54.setData("fan01RunMinute");
        mdtc54.setDefaultContent("54");
        mdtc54.setTitle("风机01运行分钟");
        mdtc54.setVisible(false);
        //SBR搅拌机02 运行时间
        MydataTableColumn mdtc55 = new MydataTableColumn();
        mdtc55.setData("sbrMixer02RunMinute");
        mdtc55.setDefaultContent("55");
        mdtc55.setTitle("SBR搅拌机02运行分钟");
        mdtc55.setVisible(false);
        //加药罐搅拌机 运行时间
        MydataTableColumn mdtc56 = new MydataTableColumn();
        mdtc56.setData("dosingMixerRunMinute");
        mdtc56.setDefaultContent("56");
        mdtc56.setTitle("加药罐搅拌机运行分钟");
        mdtc56.setVisible(false);
        //收集池提升泵 运行时间
        MydataTableColumn mdtc57 = new MydataTableColumn();
        mdtc57.setData("collectPumpRunMinute");
        mdtc57.setDefaultContent("57");
        mdtc57.setTitle("收集池提升泵运行分钟");
        mdtc57.setVisible(false);
        //风机2 运行时间 （运行分钟）
        MydataTableColumn mdtc58 = new MydataTableColumn();
        mdtc58.setData("fan02RunMinute");
        mdtc58.setDefaultContent("58");
        mdtc58.setTitle("风机02运行分钟");
        mdtc58.setVisible(false);
        //收集池搅拌机 运行时间
        MydataTableColumn mdtc59 = new MydataTableColumn();
        mdtc59.setData("collectMixerRunMinute");
        mdtc59.setDefaultContent("59");
        mdtc59.setTitle("收集池搅拌机运行分钟");
        mdtc59.setVisible(false);
        //集水井提升泵 运行时间
        MydataTableColumn mdtc60 = new MydataTableColumn();
        mdtc60.setData("collectWellPumpRunMinute");
        mdtc60.setDefaultContent("60");
        mdtc60.setTitle("集水井提升泵运行分钟");
        mdtc60.setVisible(false);
        //除磷池提升泵 运行时间
        MydataTableColumn mdtc61 = new MydataTableColumn();
        mdtc61.setData("dephosphorizePumpRunMinute");
        mdtc61.setDefaultContent("61");
        mdtc61.setTitle("除磷池提升泵运行分钟");
        mdtc61.setVisible(false);
        //滗水器 运行时间
        MydataTableColumn mdtc62 = new MydataTableColumn();
        mdtc62.setData("decanterRunMinute");
        mdtc62.setDefaultContent("62");
        mdtc62.setTitle("滗水器运行分钟");
        mdtc62.setVisible(false);

        /***********  4个 其他数据  *********************/
        //流量计（m³）
        MydataTableColumn mdtc63 = new MydataTableColumn();
        mdtc63.setData("flowmeter");
        mdtc63.setDefaultContent("63");
        mdtc63.setTitle("流量计");
        mdtc63.setVisible(true);
        //当日流量(m³)
        MydataTableColumn mdtc64 = new MydataTableColumn();
        mdtc64.setData("todayFlowmeter");
        mdtc64.setDefaultContent("64");
        mdtc64.setTitle("当日流量");
        mdtc64.setVisible(true);
        //环境温度
        MydataTableColumn mdtc65 = new MydataTableColumn();
        mdtc65.setData("airTemp");
        mdtc65.setDefaultContent("65");
        mdtc65.setTitle("环境温度");
        mdtc65.setVisible(true);
        //SBR池水温
        MydataTableColumn mdtc66 = new MydataTableColumn();
        mdtc66.setData("waterTemp");
        mdtc66.setDefaultContent("66");
        mdtc66.setTitle("SBR池水温");
        mdtc66.setVisible(true);

        /*********** 16+2个 电能数据  *********************/
        //线电压Uab
        MydataTableColumn mdtc67 = new MydataTableColumn();
        mdtc67.setData("uab");
        mdtc67.setDefaultContent("67");
        mdtc67.setTitle("线电压Uab");
        mdtc67.setVisible(false);
        //线电压Ubc
        MydataTableColumn mdtc68 = new MydataTableColumn();
        mdtc68.setData("ubc");
        mdtc68.setDefaultContent("68");
        mdtc68.setTitle("线电压Ubc");
        mdtc68.setVisible(false);
        //线电压Uca
        MydataTableColumn mdtc69 = new MydataTableColumn();
        mdtc69.setData("uca");
        mdtc69.setDefaultContent("69");
        mdtc69.setTitle("线电压Uca");
        mdtc69.setVisible(false);
        //相电压Ua
        MydataTableColumn mdtc70 = new MydataTableColumn();
        mdtc70.setData("ua");
        mdtc70.setDefaultContent("70");
        mdtc70.setTitle("相电压Ua");
        mdtc70.setVisible(false);
        //相电压Ub
        MydataTableColumn mdtc71 = new MydataTableColumn();
        mdtc71.setData("ub");
        mdtc71.setDefaultContent("71");
        mdtc71.setTitle("相电压Ub");
        mdtc71.setVisible(false);
        //相电压Uc
        MydataTableColumn mdtc72 = new MydataTableColumn();
        mdtc72.setData("uc");
        mdtc72.setDefaultContent("72");
        mdtc72.setTitle("相电压Uc");
        mdtc72.setVisible(false);
        //电流Ia
        MydataTableColumn mdtc73 = new MydataTableColumn();
        mdtc73.setData("ia");
        mdtc73.setDefaultContent("73");
        mdtc73.setTitle("电流Ia");
        mdtc73.setVisible(false);
        //电流Ib
        MydataTableColumn mdtc74 = new MydataTableColumn();
        mdtc74.setData("ib");
        mdtc74.setDefaultContent("74");
        mdtc74.setTitle("电流Ib");
        mdtc74.setVisible(false);
        //电流Ic
        MydataTableColumn mdtc75 = new MydataTableColumn();
        mdtc75.setData("ic");
        mdtc75.setDefaultContent("75");
        mdtc75.setTitle("电流Ic");
        mdtc75.setVisible(false);
        //合相有功功率
        MydataTableColumn mdtc76 = new MydataTableColumn();
        mdtc76.setData("pt");
        mdtc76.setDefaultContent("76");
        mdtc76.setTitle("合相有功功率");
        mdtc76.setVisible(false);
        //合相无功功率
        MydataTableColumn mdtc77 = new MydataTableColumn();
        mdtc77.setData("qt");
        mdtc77.setDefaultContent("77");
        mdtc77.setTitle("合相无功功率");
        mdtc77.setVisible(false);
        //合相视在功率
        MydataTableColumn mdtc78 = new MydataTableColumn();
        mdtc78.setData("st");
        mdtc78.setDefaultContent("78");
        mdtc78.setTitle("合相视在功率");
        mdtc78.setVisible(false);
        //合相功率因数
        MydataTableColumn mdtc79 = new MydataTableColumn();
        mdtc79.setData("pft");
        mdtc79.setDefaultContent("79");
        mdtc79.setTitle("合相功率因数");
        mdtc79.setVisible(false);
        //频率
        MydataTableColumn mdtc80 = new MydataTableColumn();
        mdtc80.setData("freq");
        mdtc80.setDefaultContent("80");
        mdtc80.setTitle("频率");
        mdtc80.setVisible(false);
        //正向有功总电能
        MydataTableColumn mdtc81 = new MydataTableColumn();
        mdtc81.setData("impEP");
        mdtc81.setDefaultContent("81");
        mdtc81.setTitle("正向有功总电能");
        mdtc81.setVisible(true);
        //反向有功总电能
        MydataTableColumn mdtc82 = new MydataTableColumn();
        mdtc82.setData("expEP");
        mdtc82.setDefaultContent("82");
        mdtc82.setTitle("反向有功总电能");
        mdtc82.setVisible(false);
        //当日电量
        MydataTableColumn mdtc124 = new MydataTableColumn();
        mdtc124.setData("todayEP");
        mdtc124.setDefaultContent("124");
        mdtc124.setTitle("当日电量");
        mdtc124.setVisible(true);
        /*********** 24个 设备自动启动时间点 *********************/
        //收集池提升泵 开始运行时间 时
        MydataTableColumn mdtc83 = new MydataTableColumn();
        mdtc83.setData("collectPumpSHour");
        mdtc83.setDefaultContent("83");
        mdtc83.setTitle("收集池提升泵-时");
        mdtc83.setVisible(false);
        //收集池提升泵 开始运行时间 分
        MydataTableColumn mdtc84 = new MydataTableColumn();
        mdtc84.setData("collectPumpSMinute");
        mdtc84.setDefaultContent("84");
        mdtc84.setTitle("收集池提升泵-分");
        mdtc84.setVisible(false);
        //风机01 开始运行时间 时
        MydataTableColumn mdtc85 = new MydataTableColumn();
        mdtc85.setData("fan01SHour");
        mdtc85.setDefaultContent("85");
        mdtc85.setTitle("风机01-时");
        mdtc85.setVisible(false);
        //风机01 开始运行时间 分
        MydataTableColumn mdtc86 = new MydataTableColumn();
        mdtc86.setData("fan01SMinute");
        mdtc86.setDefaultContent("86");
        mdtc86.setTitle("风机01-分");
        mdtc86.setVisible(false);
        //风机02 开始运行时间 时
        MydataTableColumn mdtc87 = new MydataTableColumn();
        mdtc87.setData("fan02SHour");
        mdtc87.setDefaultContent("87");
        mdtc87.setTitle("风机02-时");
        mdtc87.setVisible(false);
        //风机02 开始运行时间 分
        MydataTableColumn mdtc88 = new MydataTableColumn();
        mdtc88.setData("fan02SMinute");
        mdtc88.setDefaultContent("88");
        mdtc88.setTitle("风机02-分");
        mdtc88.setVisible(false);
        //收集池搅拌机 开始运行时间 时
        MydataTableColumn mdtc89 = new MydataTableColumn();
        mdtc89.setData("collectMixerSHour");
        mdtc89.setDefaultContent("89");
        mdtc89.setTitle("收集池搅拌机-时");
        mdtc89.setVisible(false);
        //收集池搅拌机 开始运行时间 分
        MydataTableColumn mdtc90 = new MydataTableColumn();
        mdtc90.setData("collectMixerSMinute");
        mdtc90.setDefaultContent("90");
        mdtc90.setTitle("收集池搅拌机-分");
        mdtc90.setVisible(false);
        //集水井提升泵 开始运行时间 时
        MydataTableColumn mdtc91 = new MydataTableColumn();
        mdtc91.setData("collectWellPumpSHour");
        mdtc91.setDefaultContent("91");
        mdtc91.setTitle("集水井提升泵-时");
        mdtc91.setVisible(false);
        //集水井提升泵 开始运行时间 分
        MydataTableColumn mdtc92 = new MydataTableColumn();
        mdtc92.setData("collectWellPumpSMinute");
        mdtc92.setDefaultContent("92");
        mdtc92.setTitle("集水井提升泵-分");
        mdtc92.setVisible(false);
        //SBR池搅拌机01 开始运行时间 时
        MydataTableColumn mdtc93 = new MydataTableColumn();
        mdtc93.setData("sbrMixer01SHour");
        mdtc93.setDefaultContent("93");
        mdtc93.setTitle("SBR池搅拌机01-时");
        mdtc93.setVisible(false);
        //SBR池搅拌机01 开始运行时间 分
        MydataTableColumn mdtc94 = new MydataTableColumn();
        mdtc94.setData("sbrMixer01SMinute");
        mdtc94.setDefaultContent("94");
        mdtc94.setTitle("SBR池搅拌机01-分");
        mdtc94.setVisible(false);
        //SBR池搅拌机02 开始运行时间 时
        MydataTableColumn mdtc95 = new MydataTableColumn();
        mdtc95.setData("sbrMixer02SHour");
        mdtc95.setDefaultContent("95");
        mdtc95.setTitle("SBR池搅拌机02-时");
        mdtc95.setVisible(false);
        //SBR池搅拌机02 开始运行时间 分
        MydataTableColumn mdtc96 = new MydataTableColumn();
        mdtc96.setData("sbrMixer02SMinute");
        mdtc96.setDefaultContent("96");
        mdtc96.setTitle("SBR池搅拌机02-分");
        mdtc96.setVisible(false);
        //污泥泵 开始运行时间 时
        MydataTableColumn mdtc97 = new MydataTableColumn();
        mdtc97.setData("sludgePumpSHour");
        mdtc97.setDefaultContent("97");
        mdtc97.setTitle("污泥泵-时");
        mdtc97.setVisible(false);
        //污泥泵 开始运行时间 分
        MydataTableColumn mdtc98 = new MydataTableColumn();
        mdtc98.setData("sludgePumpSMinute");
        mdtc98.setDefaultContent("98");
        mdtc98.setTitle("污泥泵-分");
        mdtc98.setVisible(false);
        //除磷池提升泵 开始运行时间 时
        MydataTableColumn mdtc99 = new MydataTableColumn();
        mdtc99.setData("dephosphorizePumpSHour");
        mdtc99.setDefaultContent("99");
        mdtc99.setTitle("除磷池提升泵-时");
        mdtc99.setVisible(false);
        //除磷池提升泵 开始运行时间 分
        MydataTableColumn mdtc100 = new MydataTableColumn();
        mdtc100.setData("dephosphorizePumpSMinute");
        mdtc100.setDefaultContent("100");
        mdtc100.setTitle("除磷池提升泵-分");
        mdtc100.setVisible(false);
        //滗水器 开始运行时间 时
        MydataTableColumn mdtc101 = new MydataTableColumn();
        mdtc101.setData("decanterSHour");
        mdtc101.setDefaultContent("101");
        mdtc101.setTitle("滗水器-时");
        mdtc101.setVisible(false);
        //滗水器 开始运行时间 分
        MydataTableColumn mdtc102 = new MydataTableColumn();
        mdtc102.setData("decanterSMinute");
        mdtc102.setDefaultContent("102");
        mdtc102.setTitle("滗水器-分");
        mdtc102.setVisible(false);
        //加药泵 开始运行时间 时
        MydataTableColumn mdtc103 = new MydataTableColumn();
        mdtc103.setData("dosingPumpSHour");
        mdtc103.setDefaultContent("103");
        mdtc103.setTitle("加药泵-时");
        mdtc103.setVisible(false);
        //加药泵 开始运行时间 分
        MydataTableColumn mdtc104 = new MydataTableColumn();
        mdtc104.setData("dosingPumpSMinute");
        mdtc104.setDefaultContent("104");
        mdtc104.setTitle("加药泵-分");
        mdtc104.setVisible(false);
        //加药罐搅拌机 开始运行时间 时
        MydataTableColumn mdtc105 = new MydataTableColumn();
        mdtc105.setData("dosingMixerSHour");
        mdtc105.setDefaultContent("105");
        mdtc105.setTitle("加药罐搅拌机-时");
        mdtc105.setVisible(false);
        //加药罐搅拌机 开始运行时间 分
        MydataTableColumn mdtc106 = new MydataTableColumn();
        mdtc106.setData("dosingMixerSMinute");
        mdtc106.setDefaultContent("106");
        mdtc106.setTitle("加药罐搅拌机-分");
        mdtc106.setVisible(false);
        /*********** 12个 设备运行累计时长(小时) *********************/
        //收集池搅拌机 设备运行时间累积
        MydataTableColumn mdtc111 = new MydataTableColumn();
        mdtc111.setData("collectMixerTotal");
        mdtc111.setDefaultContent("111");
        mdtc111.setTitle("收集池搅拌机累计");
        mdtc111.setVisible(false);
        //加药泵 设备运行时间累积
        MydataTableColumn mdtc112 = new MydataTableColumn();
        mdtc112.setData("dosingPumpTotal");
        mdtc112.setDefaultContent("112");
        mdtc112.setTitle("加药泵累计");
        mdtc112.setVisible(false);
        //集水井提升泵 设备运行时间累积
        MydataTableColumn mdtc113 = new MydataTableColumn();
        mdtc113.setData("collectWellPumpTotal");
        mdtc113.setDefaultContent("113");
        mdtc113.setTitle("集水井提升泵累计");
        mdtc113.setVisible(false);
        //污泥泵 设备运行时间累积
        MydataTableColumn mdtc114 = new MydataTableColumn();
        mdtc114.setData("sludgePumpTotal");
        mdtc114.setDefaultContent("114");
        mdtc114.setTitle("污泥泵累计");
        mdtc114.setVisible(false);
        //除磷池提升泵 设备运行时间累积
        MydataTableColumn mdtc115 = new MydataTableColumn();
        mdtc115.setData("dephosphorizePumpTotal");
        mdtc115.setDefaultContent("115");
        mdtc115.setTitle("除磷池提升泵累计");
        mdtc115.setVisible(false);
        //SBR池搅拌机01 设备运行时间累积
        MydataTableColumn mdtc116 = new MydataTableColumn();
        mdtc116.setData("sbrMixer01Total");
        mdtc116.setDefaultContent("116");
        mdtc116.setTitle("SBR池搅拌机01累计");
        mdtc116.setVisible(false);
        //SBR池搅拌机02 设备运行时间累积
        MydataTableColumn mdtc117 = new MydataTableColumn();
        mdtc117.setData("sbrMixer02Total");
        mdtc117.setDefaultContent("117");
        mdtc117.setTitle("SBR池搅拌机02累计");
        mdtc117.setVisible(false);
        //风机01 设备运行时间累积
        MydataTableColumn mdtc118 = new MydataTableColumn();
        mdtc118.setData("fan01Total");
        mdtc118.setDefaultContent("118");
        mdtc118.setTitle("风机01累计");
        mdtc118.setVisible(false);
        //风机02 设备运行时间累积
        MydataTableColumn mdtc119 = new MydataTableColumn();
        mdtc119.setData("fan02Total");
        mdtc119.setDefaultContent("119");
        mdtc119.setTitle("风机02累计");
        mdtc119.setVisible(false);
        //收集池提升泵 设备运行时间累积
        MydataTableColumn mdtc120 = new MydataTableColumn();
        mdtc120.setData("collectPumpTotal");
        mdtc120.setDefaultContent("120");
        mdtc120.setTitle("收集池提升泵累计");
        mdtc120.setVisible(false);
        //加药罐搅拌机 设备运行时间累积
        MydataTableColumn mdtc121 = new MydataTableColumn();
        mdtc121.setData("dosingMixerTotal");
        mdtc121.setDefaultContent("122");
        mdtc121.setTitle("加药罐搅拌机累计");
        mdtc121.setVisible(false);
        //滗水器 设备运行时间累积
        MydataTableColumn mdtc123 = new MydataTableColumn();
        mdtc123.setData("decanterTotal");
        mdtc123.setDefaultContent("123");
        mdtc123.setTitle("滗水器累计");
        mdtc123.setVisible(false);
        /*********** 2个 备用 *********************/
        //GPS数据上传时间设置参数.单位秒
        MydataTableColumn mdtc107 = new MydataTableColumn();
        mdtc107.setData("ackSeconds");
        mdtc107.setDefaultContent("107");
        mdtc107.setTitle("数据频率s");
        mdtc107.setVisible(false);
        //设备地址设置参数
        MydataTableColumn mdtc108 = new MydataTableColumn();
        mdtc108.setData("plcAddress");
        mdtc108.setDefaultContent("108");
        mdtc108.setTitle("设备地址");
        mdtc108.setVisible(false);

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
        //流量计（m³）
        myDTCList.add(mdtc63);
        //当日流量(m³)
        myDTCList.add(mdtc64);
        //当日电量()
        myDTCList.add(mdtc124);
        //环境温度
        myDTCList.add(mdtc65);
        //SBR池水温
        myDTCList.add(mdtc66);
        /************* 12个 运行状态  ******************/
        //收集池搅拌机停止/运行
        myDTCList.add(mdtc3);
        //加药泵 停止/运行
        myDTCList.add(mdtc4);
        //集水井提升泵 停止/运行
        myDTCList.add(mdtc5);
        //污泥泵 停止/运行
        myDTCList.add(mdtc6);
        //除磷池提升泵 停止/运行
        myDTCList.add(mdtc7);
        //SBR池搅拌机01停止/运行
        myDTCList.add(mdtc8);
        //回转式风机1停止/运行
        myDTCList.add(mdtc9);
        //回转式风机2停止/运行
        myDTCList.add(mdtc10);
        //收集池提升泵 停止/运行
        myDTCList.add(mdtc11);
        //滗水器电磁阀停止/运行
        myDTCList.add(mdtc12);
        //SBR池搅拌机02停止/运行
        myDTCList.add(mdtc13);
        //加药罐搅拌机 停止/运行
        myDTCList.add(mdtc14);
        /*********** 16 故障指示  *********************/
        //收集池搅拌机 正常/故障
        myDTCList.add(mdtc15);
        //加药泵 正常/故障
        myDTCList.add(mdtc16);
        //集水井提升泵 正常/故障
        myDTCList.add(mdtc17);
        //污泥泵 正常/故障
        myDTCList.add(mdtc18);
        //除磷池提升泵 正常/故障
        myDTCList.add(mdtc19);
        //SBR池搅拌机01 正常/故障
        myDTCList.add(mdtc20);
        //SBR池搅拌机02 正常/故障
        myDTCList.add(mdtc21);
        //风机01 正常/故障
        myDTCList.add(mdtc22);
        //风机02 正常/故障
        myDTCList.add(mdtc23);
        //收集池提升泵 正常/故障
        myDTCList.add(mdtc24);
        //滗水器 正常/故障
        myDTCList.add(mdtc25);
        //PLC电量不足
        myDTCList.add(mdtc26);
        //加药罐搅拌机 正常/故障
        myDTCList.add(mdtc27);
        //智能电表设备通讯故障
        myDTCList.add(mdtc28);
        //空气温度变送器通讯故障
        myDTCList.add(mdtc29);
        //SBR水温变送器通讯故障
        myDTCList.add(mdtc30);
        /*********** 9个 公共参数 2byte *********************/
        //收集池液位高未到/到了
        myDTCList.add(mdtc31);
        //收集池液位低未到/到了
        myDTCList.add(mdtc32);
        //除磷池液位高未到/到了
        myDTCList.add(mdtc33);
        //除磷池液位低未到/到了
        myDTCList.add(mdtc34);
        //SBR池液位高未到/到了
        myDTCList.add(mdtc35);
        //SBR池液位低未到/到了
        myDTCList.add(mdtc36);
        //滗水器电磁阀关 停止/运行
        myDTCList.add(mdtc37);
        //滗水器开到位限位
        myDTCList.add(mdtc38);
        //滗水器关到位限位
        myDTCList.add(mdtc39);
        /*********** 11个 数据-设定时间  *********************/
        //风机 设定运行时间 （设定分钟）
        myDTCList.add(mdtc40);
        //SBR搅拌机01 设定运行时间
        myDTCList.add(mdtc41);
        //SBR搅拌机02 设定运行时间
        myDTCList.add(mdtc42);
        //收集池提升泵 设定运行时间
        myDTCList.add(mdtc43);
        //污泥泵（设定分钟）
        myDTCList.add(mdtc44);
        //除磷池提升泵 设定运行时间
        myDTCList.add(mdtc45);
        //滗水器 设定运行时间
        myDTCList.add(mdtc46);
        //收集池搅拌机 设定运行时间
        myDTCList.add(mdtc47);
        //加药泵 设定运行时间
        myDTCList.add(mdtc48);
        //加药罐搅拌机 设定运行时间
        myDTCList.add(mdtc49);
        //集水井提升泵 设定运行时间
        myDTCList.add(mdtc50);
        /*********** 12个 数据-运行时间  *********************/
        //加药泵 运行时间
        myDTCList.add(mdtc51);
        //污泥泵 （运行分钟）
        myDTCList.add(mdtc52);
        //SBR搅拌机01 运行时间
        myDTCList.add(mdtc53);
        //风机1 运行时间 （运行分钟）
        myDTCList.add(mdtc54);
        //SBR搅拌机02 运行时间
        myDTCList.add(mdtc55);
        //加药罐搅拌机 运行时间
        myDTCList.add(mdtc56);
        //收集池提升泵 运行时间
        myDTCList.add(mdtc57);
        //风机2 运行时间 （运行分钟）
        myDTCList.add(mdtc58);
        //收集池搅拌机 运行时间
        myDTCList.add(mdtc59);
        //集水井提升泵 运行时间
        myDTCList.add(mdtc60);
        //除磷池提升泵 运行时间
        myDTCList.add(mdtc61);
        //滗水器 运行时间
        myDTCList.add(mdtc62);
        /*********** 16 电能数据  *********************/
        //线电压Uab
        myDTCList.add(mdtc67);
        //线电压Ubc
        myDTCList.add(mdtc68);
        //线电压Uca
        myDTCList.add(mdtc69);
        //相电压Ua
        myDTCList.add(mdtc70);
        //相电压Ub
        myDTCList.add(mdtc71);
        //相电压Uc
        myDTCList.add(mdtc72);
        //电流Ia
        myDTCList.add(mdtc73);
        //电流Ib
        myDTCList.add(mdtc74);
        //电流Ic
        myDTCList.add(mdtc75);
        //合相有功功率
        myDTCList.add(mdtc76);
        //合相无功功率
        myDTCList.add(mdtc77);
        //合相视在功率
        myDTCList.add(mdtc78);
        //合相功率因数
        myDTCList.add(mdtc79);
        //频率
        myDTCList.add(mdtc80);
        //正向有功总电能
        myDTCList.add(mdtc81);
        //反向有功总电能
        myDTCList.add(mdtc82);
        /*********** 12个 设备运行累计时长(小时) *********************/
        //收集池搅拌机 设备运行时间累积
        myDTCList.add(mdtc111);
        //加药泵 设备运行时间累积
        myDTCList.add(mdtc112);
        //集水井提升泵 设备运行时间累积
        myDTCList.add(mdtc113);
        //污泥泵 设备运行时间累积
        myDTCList.add(mdtc114);
        //除磷池提升泵 设备运行时间累积
        myDTCList.add(mdtc115);
        //SBR池搅拌机01 设备运行时间累积
        myDTCList.add(mdtc116);
        //SBR池搅拌机02 设备运行时间累积
        myDTCList.add(mdtc117);
        //风机01 设备运行时间累积
        myDTCList.add(mdtc118);
        //风机02 设备运行时间累积
        myDTCList.add(mdtc119);
        //收集池提升泵 设备运行时间累积
        myDTCList.add(mdtc120);
        //加药罐搅拌机 设备运行时间累积
        myDTCList.add(mdtc121);
        //滗水器 设备运行时间累积
        myDTCList.add(mdtc123);
        /*********** 24个 设备自动启动时间点 *********************/
        //收集池提升泵 开始运行时间 时
        myDTCList.add(mdtc83);
        //收集池提升泵 开始运行时间 分
        myDTCList.add(mdtc84);
        //风机01 开始运行时间 时
        myDTCList.add(mdtc85);
        //风机01 开始运行时间 分
        myDTCList.add(mdtc86);
        //风机02 开始运行时间 时
        myDTCList.add(mdtc87);
        //风机02 开始运行时间 分
        myDTCList.add(mdtc88);
        //收集池搅拌机 开始运行时间 时
        myDTCList.add(mdtc89);
        //收集池搅拌机 开始运行时间 分
        myDTCList.add(mdtc90);
        //集水井提升泵 开始运行时间 时
        myDTCList.add(mdtc91);
        //集水井提升泵 开始运行时间 分
        myDTCList.add(mdtc92);
        //SBR池搅拌机01 开始运行时间 时
        myDTCList.add(mdtc93);
        //SBR池搅拌机01 开始运行时间 分
        myDTCList.add(mdtc94);
        //SBR池搅拌机02 开始运行时间 时
        myDTCList.add(mdtc95);
        //SBR池搅拌机02 开始运行时间 分
        myDTCList.add(mdtc96);
        //污泥泵 开始运行时间 时
        myDTCList.add(mdtc97);
        //污泥泵 开始运行时间 分
        myDTCList.add(mdtc98);
        //除磷池提升泵 开始运行时间 时
        myDTCList.add(mdtc99);
        //除磷池提升泵 开始运行时间 分
        myDTCList.add(mdtc100);
        //滗水器 开始运行时间 时
        myDTCList.add(mdtc101);
        //滗水器 开始运行时间 分
        myDTCList.add(mdtc102);
        //加药泵 开始运行时间 时
        myDTCList.add(mdtc103);
        //加药泵 开始运行时间 分
        myDTCList.add(mdtc104);
        //加药罐搅拌机 开始运行时间 时
        myDTCList.add(mdtc105);
        //加药罐搅拌机 开始运行时间 分
        myDTCList.add(mdtc106);
        /*********** 2个 备用 *********************/
        //GPS数据上传时间设置参数.单位秒
        myDTCList.add(mdtc107);
        //设备地址设置参数
        myDTCList.add(mdtc108);

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
        phoneRealMsgInfo03.setValue("自动");
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("sbrCycle");
        phoneRealMsgInfo04.setTitle("SBR周期运行：");
        phoneRealMsgInfo04.setValue("运行");
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
        phoneSewageC01RealOneDataList01.add(phoneSewageC01RealOneData25);

        //第一部分两列收尾
        phoneSewageC01RealData01.setPhoneSewageC01RealOneDataList(phoneSewageC01RealOneDataList01);
        phoneSewageC01RealDataList.add(phoneSewageC01RealData01);

        return phoneSewageC01RealDataList;
    }
}
