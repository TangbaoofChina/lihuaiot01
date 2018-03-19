package com.system.po;

import java.util.ArrayList;
import java.util.List;

public class DeviceAlarmInfo {
    private String dAlarmId;
    private String dSerialNum;
    private String dName;
    private String dAlarmCode;
    private String dAlarmInfo;
    private String dAlarmTime;
    private String dOrgId;
    private String dOrgName;
    private String dAlarmType;

    public String getDAlarmId() {
        return dAlarmId;
    }

    public void setDAlarmId(String dAlarmId) {
        this.dAlarmId = dAlarmId;
    }

    public String getDSerialNum() {
        return dSerialNum;
    }

    public void setDSerialNum(String dSerialNum) {
        this.dSerialNum = dSerialNum;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getDAlarmCode() {
        return dAlarmCode;
    }

    public void setDAlarmCode(String dAlarmCode) {
        this.dAlarmCode = dAlarmCode;
    }

    public String getDAlarmInfo() {
        return dAlarmInfo;
    }

    public void setDAlarmInfo(String dAlarmInfo) {
        this.dAlarmInfo = dAlarmInfo;
    }

    public String getDAlarmTime() {
        return dAlarmTime;
    }

    public void setDAlarmTime(String dAlarmTime) {
        this.dAlarmTime = dAlarmTime;
    }

    public String getDOrgId() {
        return dOrgId;
    }

    public void setDOrgId(String dOrgId) {
        this.dOrgId = dOrgId;
    }

    public String getDOrgName() {
        return dOrgName;
    }

    public void setDOrgName(String dOrgName) {
        this.dOrgName = dOrgName;
    }

    public String getDAlarmType() {
        return dAlarmType;
    }

    public void setDAlarmType(String dAlarmType) {
        this.dAlarmType = dAlarmType;
    }

    public List<MydataTableColumn> getDeviceAlarmHead()
    {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNum");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("设备ID");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("设备");

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("dAlarmCode");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("报警代码");
        mdtc3.setVisible(false);

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dAlarmInfo");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("报警信息");

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("dAlarmTime");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("报警时间");

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("dAlarmType");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("报警类型");

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("dOrgId");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("部门ID");
        mdtc7.setVisible(false);

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("dOrgName");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("部门");

        myDTCList.add(mdtc7);
        myDTCList.add(mdtc8);
        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);
        myDTCList.add(mdtc5);
        myDTCList.add(mdtc6);
        return myDTCList;
    }
}
