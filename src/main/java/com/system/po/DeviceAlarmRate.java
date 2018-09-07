package com.system.po;

import com.system.po.parameter.ParameterData;

import java.util.ArrayList;
import java.util.List;

public class DeviceAlarmRate {
    private String alarmTimes;
    private String serialNum;
    private String name;
    private String orgId;
    private String orgName;
    private String alarmType;

    public String getAlarmTimes() {
        return alarmTimes;
    }

    public void setAlarmTimes(String alarmTimes) {
        this.alarmTimes = alarmTimes;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public static List<String> getAlarmData(List<DeviceAlarmRate> deviceAlarmRateList) {
        List<String> alarmList = new ArrayList<>();
        for (DeviceAlarmRate deviceAlarmRate : deviceAlarmRateList
                ) {
            alarmList.add(deviceAlarmRate.getName());
        }
        return alarmList;
    }

    public static List<ParameterData> getdParameterdata(List<DeviceAlarmRate> deviceAlarmRateList) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        ParameterData parameterData = new ParameterData();
        List<String> dataList = new ArrayList<>();
        for (DeviceAlarmRate deviceAlarmRate : deviceAlarmRateList
                ) {
            dataList.add(deviceAlarmRate.getAlarmTimes());
        }
        parameterData.setData(dataList);
        parameterData.setType("bar");
        parameterDataList.add(parameterData);
        return parameterDataList;
    }
}
