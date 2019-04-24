package com.system.po.Device;

import com.system.po.Hj212C213.Hj212C213Threshold;
import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneHj212C213.PhoneHj212C213RealData;
import com.system.po.Phone.PhoneHj212C213.PhoneHj212C213RealMsgInfo;
import com.system.po.Phone.PhoneHj212C213.PhoneHj212C213RealOneData;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

public class Hj212C213DeviceMessage extends BaseDeviceMessage {
    //命令时间戳 精确到毫秒的时间戳:QN=YYYYMMDDhhmmsszzz;
    private String qn;
    //系统编码 - 32
    private String st;
    //命令编码 - 2011/2051
    private String cn;
    //访问密码 - 123456
    private String pw;
    //设备唯一标识-对应serialnum
    private String mn;
    //拆分包及应答标志 - 4
    private String flag;
    //指令参数 - 数据内容
    private String cp;
    //命令合成时间
    private String datatime;
    //瞬时流量-值
    private String flowrate_value;
    //瞬时流量-采样状态
    private String flowrate_flag;
    //瞬时流量-采样时间
    private String flowrate_sampletime;
    //ph-值
    private String ph_value;
    //ph-采样状态
    private String ph_flag;
    //ph-采样时间
    private String ph_sampletime;
    //cod-值
    private String cod_value;
    //cod-采样状态
    private String cod_flag;
    //cod-采样时间
    private String cod_sampletime;
    //氨氮-值
    private String nh3n_value;
    //氨氮-采样状态
    private String nh3n_flag;
    //氨氮-采样时间
    private String nh3n_sampletime;
    //总磷-值
    private String tp_value;
    //总磷-采样状态
    private String tp_flag;
    //总磷-采样时间
    private String tp_sampletime;
    //总氮-值
    private String tn_value;
    //总氮-采样状态
    private String tn_flag;
    //总氮-采样时间
    private String tn_sampletime;
    //设备发送数据时间
    private String sendDate;

    public String getQn() {
        return qn;
    }

    public void setQn(String qn) {
        this.qn = qn;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getDatatime() {
        return DataConvertor.formatTime(datatime);
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public String getFlowrate_value() {
        return DataConvertor.stringMultiple(flowrate_value, 3.6f, 1);
    }

    public void setFlowrate_value(String flowrate_value) {
        this.flowrate_value = flowrate_value;
    }

    public String getFlowrate_flag() {
        return flowrate_flag;
    }

    public void setFlowrate_flag(String flowrate_flag) {
        this.flowrate_flag = flowrate_flag;
    }

    public String getFlowrate_sampletime() {
        return DataConvertor.formatTime(flowrate_sampletime);
    }

    public void setFlowrate_sampletime(String flowrate_sampletime) {
        this.flowrate_sampletime = flowrate_sampletime;
    }

    public String getPh_value() {
        return ph_value;
    }

    public void setPh_value(String ph_value) {
        this.ph_value = ph_value;
    }

    public String getPh_flag() {
        return ph_flag;
    }

    public void setPh_flag(String ph_flag) {
        this.ph_flag = ph_flag;
    }

    public String getPh_sampletime() {
        return DataConvertor.formatTime(ph_sampletime);
    }

    public void setPh_sampletime(String ph_sampletime) {
        this.ph_sampletime = ph_sampletime;
    }

    public String getCod_value() {
        return cod_value;
    }

    public void setCod_value(String cod_value) {
        this.cod_value = cod_value;
    }

    public String getCod_flag() {
        return cod_flag;
    }

    public void setCod_flag(String cod_flag) {
        this.cod_flag = cod_flag;
    }

    public String getCod_sampletime() {
        return DataConvertor.formatTime(cod_sampletime);
    }

    public void setCod_sampletime(String cod_sampletime) {
        this.cod_sampletime = cod_sampletime;
    }

    public String getNh3n_value() {
        return nh3n_value;
    }

    public void setNh3n_value(String nh3n_value) {
        this.nh3n_value = nh3n_value;
    }

    public String getNh3n_flag() {
        return nh3n_flag;
    }

    public void setNh3n_flag(String nh3n_flag) {
        this.nh3n_flag = nh3n_flag;
    }

    public String getNh3n_sampletime() {
        return DataConvertor.formatTime(nh3n_sampletime);
    }

    public void setNh3n_sampletime(String nh3n_sampletime) {
        this.nh3n_sampletime = nh3n_sampletime;
    }

    public String getTp_value() {
        return tp_value;
    }

    public void setTp_value(String tp_value) {
        this.tp_value = tp_value;
    }

    public String getTp_flag() {
        return tp_flag;
    }

    public void setTp_flag(String tp_flag) {
        this.tp_flag = tp_flag;
    }

    public String getTp_sampletime() {
        return DataConvertor.formatTime(tp_sampletime);
    }

    public void setTp_sampletime(String tp_sampletime) {
        this.tp_sampletime = tp_sampletime;
    }

    public String getTn_value() {
        return tn_value;
    }

    public void setTn_value(String tn_value) {
        this.tn_value = tn_value;
    }

    public String getTn_flag() {
        return tn_flag;
    }

    public void setTn_flag(String tn_flag) {
        this.tn_flag = tn_flag;
    }

    public String getTn_sampletime() {
        return DataConvertor.formatTime(tn_sampletime);
    }

    public void setTn_sampletime(String tn_sampletime) {
        this.tn_sampletime = tn_sampletime;
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
        mdtc2.setVisible(true);

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("datatime");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("合成时间");
        mdtc3.setVisible(true);

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("sendDate");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("发送时间");
        mdtc4.setVisible(true);

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("flowrate_value");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("瞬时流量(m³/h)");
        mdtc5.setVisible(true);

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("ph_value");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("pH");
        mdtc6.setVisible(true);

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("cod_value");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("COD");
        mdtc7.setVisible(true);

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("cod_sampletime");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("COD采样时间");
        mdtc8.setVisible(true);

        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("nh3n_value");
        mdtc9.setDefaultContent("9");
        mdtc9.setTitle("氨氮");
        mdtc9.setVisible(true);

        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("nh3n_sampletime");
        mdtc10.setDefaultContent("10");
        mdtc10.setTitle("氨氮采样时间");
        mdtc10.setVisible(true);

        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("tp_value");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("总磷");
        mdtc11.setVisible(true);

        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("tp_sampletime");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("总磷采样时间");
        mdtc12.setVisible(true);

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
        //状态
        myDTCList.add(mdtc97);
        //发送时间
        myDTCList.add(mdtc4);
        //合成时间
        myDTCList.add(mdtc3);
        //瞬时流量值
        myDTCList.add(mdtc5);
        //ph值
        myDTCList.add(mdtc6);
        //COD值
        myDTCList.add(mdtc7);
        //COD采样时间
        myDTCList.add(mdtc8);
        //氨氮值
        myDTCList.add(mdtc9);
        //氨氮采样时间
        myDTCList.add(mdtc10);
        //总磷值
        myDTCList.add(mdtc11);
        //总磷采样时间
        myDTCList.add(mdtc12);
        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("flowrate");
        phoneRealMsgInfo01.setTitle("流量：");
        phoneRealMsgInfo01.setValue(this.getFlowrate_value() + "m³/h");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("pH");
        phoneRealMsgInfo02.setTitle("pH：");
        phoneRealMsgInfo02.setValue(this.getFlowrate_value());
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("COD");
        phoneRealMsgInfo03.setTitle("COD：");
        phoneRealMsgInfo03.setValue(this.getCod_value() + "mg/l");
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("Nh3N");
        phoneRealMsgInfo04.setTitle("氨氮：");
        phoneRealMsgInfo04.setValue(this.getNh3n_value() + "mg/l");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("Tp");
        phoneRealMsgInfo05.setTitle("总磷：");
        phoneRealMsgInfo05.setValue(this.getTp_value() + "mg/l");
        phoneRealMsgInfo05.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("dState");
        phoneRealMsgInfo06.setTitle("状态：");
        phoneRealMsgInfo06.setValue(getDState());
        phoneRealMsgInfo06.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("sendDate");
        phoneRealMsgInfo07.setTitle("");
        phoneRealMsgInfo07.setValue(this.getSendDate());
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        return phoneRealMsgInfoList;
    }

    public List<PhoneHj212C213RealData> getPhoneRealMsgInfoDetail() {
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        Hj212C213Threshold hj212C213Threshold = new Hj212C213Threshold();
        List<PhoneHj212C213RealData> phoneHj212C213RealDataList = new ArrayList<>();

        PhoneHj212C213RealData phoneHj212C213RealData = new PhoneHj212C213RealData();
        phoneHj212C213RealData.setColumn(2);
        phoneHj212C213RealData.setScale("0.5,0.5");
        phoneHj212C213RealData.setTitle("总体信息");
        List<PhoneHj212C213RealOneData> phoneHj212C213RealOneDataList = new ArrayList<PhoneHj212C213RealOneData>();
        PhoneHj212C213RealOneData phoneHj212C213RealOneData01 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData01.setTitle("时间：");
        phoneHj212C213RealOneData01.setValue1(sendDate);
        phoneHj212C213RealOneData01.setColor1(defaultColor);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData01);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData02 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData02.setTitle("状态：");
        if (getDState().equals("离线")) {
            phoneHj212C213RealOneData02.setValue1(getDState());
            phoneHj212C213RealOneData02.setColor1(alarmColor);
        } else {
            phoneHj212C213RealOneData02.setValue1(getDState());
            phoneHj212C213RealOneData02.setColor1(defaultColor);
        }
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData02);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData03 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData03.setTitle("流量：");
        phoneHj212C213RealOneData03.setValue1(this.getFlowrate_value() + "m³/h");
        phoneHj212C213RealOneData03.setColor1(defaultColor);
        phoneHj212C213RealOneData03.setHasHis(true);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData03);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData04 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData04.setTitle("pH：");
        if ((Float.valueOf(this.getPh_value()) < hj212C213Threshold.getMinPh()) ||
                (Float.valueOf(this.getPh_value()) > hj212C213Threshold.getMaxPh())) {
            phoneHj212C213RealOneData04.setValue1(this.getPh_value());
            phoneHj212C213RealOneData04.setColor1(alarmColor);
        } else {
            phoneHj212C213RealOneData04.setValue1(this.getPh_value());
            phoneHj212C213RealOneData04.setColor1(defaultColor);
        }
        phoneHj212C213RealOneData04.setHasHis(true);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData04);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData05 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData05.setTitle("COD：");
        if ((Float.valueOf(this.getCod_value()) > hj212C213Threshold.getMaxCOD())) {
            phoneHj212C213RealOneData05.setValue1(this.getCod_value() + "mg/l");
            phoneHj212C213RealOneData05.setColor1(alarmColor);
        } else {
            phoneHj212C213RealOneData05.setValue1(this.getCod_value() + "mg/l");
            phoneHj212C213RealOneData05.setColor1(defaultColor);
        }
        phoneHj212C213RealOneData05.setHasHis(true);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData05);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData0501 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData0501.setTitle("采样：");
        phoneHj212C213RealOneData0501.setValue1(this.getCod_sampletime());
        phoneHj212C213RealOneData0501.setColor1(defaultColor);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData0501);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData06 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData06.setTitle("氨氮：");
        if ((Float.valueOf(this.getNh3n_value()) > hj212C213Threshold.getMaxNh3N())) {
            phoneHj212C213RealOneData06.setValue1(this.getNh3n_value() + "mg/l");
            phoneHj212C213RealOneData06.setColor1(alarmColor);
        } else {
            phoneHj212C213RealOneData06.setValue1(this.getNh3n_value() + "mg/l");
            phoneHj212C213RealOneData06.setColor1(defaultColor);
        }
        phoneHj212C213RealOneData06.setHasHis(true);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData06);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData0601 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData0601.setTitle("采样：");
        phoneHj212C213RealOneData0601.setValue1(this.getNh3n_sampletime());
        phoneHj212C213RealOneData0601.setColor1(defaultColor);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData0601);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData07 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData07.setTitle("总磷：");
        if ((Float.valueOf(this.getTp_value()) > hj212C213Threshold.getMaxTp())) {
            phoneHj212C213RealOneData07.setValue1(this.getTp_value() + "mg/l");
            phoneHj212C213RealOneData07.setColor1(alarmColor);
        } else {
            phoneHj212C213RealOneData07.setValue1(this.getTp_value() + "mg/l");
            phoneHj212C213RealOneData07.setColor1(defaultColor);
        }
        phoneHj212C213RealOneData07.setHasHis(true);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData07);

        PhoneHj212C213RealOneData phoneHj212C213RealOneData0701 = new PhoneHj212C213RealOneData();
        phoneHj212C213RealOneData0701.setTitle("采样：");
        phoneHj212C213RealOneData0701.setValue1(this.getTp_sampletime());
        phoneHj212C213RealOneData0701.setColor1(defaultColor);
        phoneHj212C213RealOneDataList.add(phoneHj212C213RealOneData0701);

        phoneHj212C213RealData.setPhoneHj212C213RealOneDataList(phoneHj212C213RealOneDataList);
        phoneHj212C213RealDataList.add(phoneHj212C213RealData);
        return phoneHj212C213RealDataList;
    }
}
