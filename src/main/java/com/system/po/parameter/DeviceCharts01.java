package com.system.po.parameter;

import com.system.po.DeviceInfo;
import com.system.po.EC01DeviceMessage;

import java.util.ArrayList;
import java.util.List;

public class DeviceCharts01 {
    private DeviceInfo deviceInfo;
    private ChartsParameters01 chartsParameters01;

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public ChartsParameters01 getChartsParameters01() {
        return chartsParameters01;
    }

    public void setChartsParameters01(ChartsParameters01 chartsParameters01) {
        this.chartsParameters01 = chartsParameters01;
    }

    public DeviceCharts01(List<EC01DeviceMessage> deviceMessageList)
    {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();

        deviceParameterName.add("舍内");
        deviceParameterName.add("舍前");
        deviceParameterName.add("舍中");
        deviceParameterName.add("舍后");
        deviceParameterName.add("舍外");

        ParameterData01 parameterInAveTemp = new ParameterData01();
        parameterInAveTemp.setName("舍内");
        ParameterData01 parameterInTemp1 = new ParameterData01();
        parameterInTemp1.setName("舍前");
        ParameterData01 parameterInTemp2 = new ParameterData01();
        parameterInTemp2.setName("舍中");
        ParameterData01 parameterInTemp3 = new ParameterData01();
        parameterInTemp3.setName("舍后");
        ParameterData01 parameterOutTemp = new ParameterData01();
        parameterOutTemp.setName("舍外");


        List<OneDataDetail> inAveTempList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp01List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp02List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp03List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> outTempList = new ArrayList<OneDataDetail>();


        for (EC01DeviceMessage deviceMessage:deviceMessageList
                ) {
            deviceParameterTime.add(deviceMessage.getSendDate());

            OneDataDetail oneDataDetailInAveTemp = new OneDataDetail();
            oneDataDetailInAveTemp.setName(deviceMessage.getSendDate());
            oneDataDetailInAveTemp.setValue(String.valueOf(deviceMessage.getInAveTemp()));

            OneDataDetail oneDataDetailInTemp1 = new OneDataDetail();
            oneDataDetailInTemp1.setName(deviceMessage.getSendDate());
            oneDataDetailInTemp1.setValue(String.valueOf(deviceMessage.getInTemp1()));

            OneDataDetail oneDataDetailInTemp2 = new OneDataDetail();
            oneDataDetailInTemp2.setName(deviceMessage.getSendDate());
            oneDataDetailInTemp2.setValue(String.valueOf(deviceMessage.getInTemp2()));

            OneDataDetail oneDataDetailInTemp3 = new OneDataDetail();
            oneDataDetailInTemp3.setName(deviceMessage.getSendDate());
            oneDataDetailInTemp3.setValue(String.valueOf(deviceMessage.getInTemp3()));

            OneDataDetail oneDataDetailOutTemp = new OneDataDetail();
            oneDataDetailOutTemp.setName(deviceMessage.getSendDate());
            oneDataDetailOutTemp.setValue(String.valueOf(deviceMessage.getOutTemp()));


            inAveTempList.add(oneDataDetailInAveTemp);
            inTemp01List.add(oneDataDetailInTemp1);
            inTemp02List.add(oneDataDetailInTemp2);
            inTemp03List.add(oneDataDetailInTemp3);
            outTempList.add(oneDataDetailOutTemp);

        }

        parameterInAveTemp.setData(inAveTempList);
        parameterInTemp1.setData(inTemp01List);
        parameterInTemp2.setData(inTemp02List);
        parameterInTemp3.setData(inTemp03List);
        parameterOutTemp.setData(outTempList);

        parameterDataList.add(parameterInAveTemp);
        parameterDataList.add(parameterInTemp1);
        parameterDataList.add(parameterInTemp2);
        parameterDataList.add(parameterInTemp3);
        parameterDataList.add(parameterOutTemp);

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName(deviceMessageList.get(0).getDName());
        deviceInfo.setDSerialNum(deviceMessageList.get(0).getDSerialNum());
        this.deviceInfo = deviceInfo;
        this.chartsParameters01 = new ChartsParameters01(deviceParameterName,parameterDataList,deviceParameterTime);
    }
}


