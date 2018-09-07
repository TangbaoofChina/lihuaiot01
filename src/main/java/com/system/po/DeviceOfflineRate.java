package com.system.po;

import com.system.po.parameter.ParameterData;

import java.util.ArrayList;
import java.util.List;

public class DeviceOfflineRate {
    private String offlineTimes;
    private String serialNum;
    private String name;
    private String orgId;
    private String orgName;
    private String alarmType;

    public String getOfflineTimes() {
        return offlineTimes;
    }

    public void setOfflineTimes(String offlineTimes) {
        this.offlineTimes = offlineTimes;
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

    public static List<String> getOfflineData(List<DeviceOfflineRate> deviceOfflineRateList) {
        List<String> offlineList = new ArrayList<>();
        for (DeviceOfflineRate deviceOfflineRate : deviceOfflineRateList
                ) {
            offlineList.add(deviceOfflineRate.getName());
        }
        return offlineList;
    }

    public static List<ParameterData> getdParameterdata(List<DeviceOfflineRate> deviceOfflineRateList){
        List<ParameterData> parameterDataList = new ArrayList<>();
        ParameterData parameterData = new ParameterData();
        List<String> dataList = new ArrayList<>();
        for (DeviceOfflineRate deviceOfflineRate : deviceOfflineRateList
                ) {
            dataList.add(deviceOfflineRate.getOfflineTimes());
        }
        parameterData.setData(dataList);
        parameterData.setType("bar");
        parameterDataList.add(parameterData);
        return parameterDataList;
    }
}
