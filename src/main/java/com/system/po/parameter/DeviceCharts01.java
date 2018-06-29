package com.system.po.parameter;

import com.system.po.DeviceInfo;
import com.system.po.Device.EC01DeviceMessage;

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
        deviceParameterName.add("饮水量");
        deviceParameterName.add("日饮水量");

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
        ParameterData01 parameterWaterFlow = new ParameterData01();
        parameterWaterFlow.setName("饮水量");
        ParameterData01 parameterDayWaterFlow = new ParameterData01();
        parameterDayWaterFlow.setName("日饮水量");


        List<OneDataDetail> inAveTempList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp01List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp02List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp03List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> outTempList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> waterFlowList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> dayWaterFlowList = new ArrayList<OneDataDetail>();

        for (EC01DeviceMessage deviceMessage:deviceMessageList
                ) {
            deviceParameterTime.add(deviceMessage.getSendDate());

            //舍内
            OneDataDetail oneDataDetailInAveTemp = new OneDataDetail();
            oneDataDetailInAveTemp.setName(deviceMessage.getSendDate());
            oneDataDetailInAveTemp.setValue(String.valueOf(deviceMessage.getInAveTemp()));

            //舍前
            OneDataDetail oneDataDetailInTemp1 = new OneDataDetail();
            oneDataDetailInTemp1.setName(deviceMessage.getSendDate());
            oneDataDetailInTemp1.setValue(String.valueOf(deviceMessage.getInTemp1()));

            //舍中
            OneDataDetail oneDataDetailInTemp2 = new OneDataDetail();
            oneDataDetailInTemp2.setName(deviceMessage.getSendDate());
            oneDataDetailInTemp2.setValue(String.valueOf(deviceMessage.getInTemp2()));

            //舍后
            OneDataDetail oneDataDetailInTemp3 = new OneDataDetail();
            oneDataDetailInTemp3.setName(deviceMessage.getSendDate());
            oneDataDetailInTemp3.setValue(String.valueOf(deviceMessage.getInTemp3()));

            //舍外
            OneDataDetail oneDataDetailOutTemp = new OneDataDetail();
            oneDataDetailOutTemp.setName(deviceMessage.getSendDate());
            oneDataDetailOutTemp.setValue(String.valueOf(deviceMessage.getOutTemp()));

            //饮水量
            OneDataDetail oneDataDetailWaterFlow = new OneDataDetail();
            oneDataDetailWaterFlow.setName(deviceMessage.getSendDate());
            oneDataDetailWaterFlow.setValue(String.valueOf(deviceMessage.getWaterFlowVal()));

            //日饮水量
            OneDataDetail oneDataDetailDayWaterFlow = new OneDataDetail();
            oneDataDetailDayWaterFlow.setName(deviceMessage.getSendDate());
            oneDataDetailDayWaterFlow.setValue(String.valueOf(deviceMessage.getWaterFlowVal()));

            inAveTempList.add(oneDataDetailInAveTemp);
            inTemp01List.add(oneDataDetailInTemp1);
            inTemp02List.add(oneDataDetailInTemp2);
            inTemp03List.add(oneDataDetailInTemp3);
            outTempList.add(oneDataDetailOutTemp);
            waterFlowList.add(oneDataDetailWaterFlow);
            dayWaterFlowList.add(oneDataDetailDayWaterFlow);
        }

        parameterInAveTemp.setData(inAveTempList);
        parameterInTemp1.setData(inTemp01List);
        parameterInTemp2.setData(inTemp02List);
        parameterInTemp3.setData(inTemp03List);
        parameterOutTemp.setData(outTempList);
        parameterWaterFlow.setData(waterFlowList);
        parameterDayWaterFlow.setData(dayWaterFlowList);

        parameterDataList.add(parameterInAveTemp);
        parameterDataList.add(parameterInTemp1);
        parameterDataList.add(parameterInTemp2);
        parameterDataList.add(parameterInTemp3);
        parameterDataList.add(parameterOutTemp);
        parameterDataList.add(parameterWaterFlow);
        parameterDataList.add(parameterDayWaterFlow);

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName(deviceMessageList.get(0).getDName());
        deviceInfo.setDSerialNum(deviceMessageList.get(0).getDSerialNum());
        this.deviceInfo = deviceInfo;
        this.chartsParameters01 = new ChartsParameters01(deviceParameterName,parameterDataList,deviceParameterTime);
    }
}


