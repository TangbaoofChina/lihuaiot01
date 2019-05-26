package com.system.po.parameter;

import com.system.po.DeviceInfo;
import com.system.po.Device.EC01DeviceMessage;
import com.system.po.EC01.EC01DayAvgTemp;
import com.system.po.EC01.EC01DayWater;
import com.system.po.EC01.EC01DeviceDayAvgTemp;
import com.system.po.EC01.EC01DeviceDayWater;
import com.system.po.PeopleRoleInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public DeviceCharts01() {
    }

    ;

    public DeviceCharts01(List<EC01DeviceMessage> deviceMessageList) {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();

        deviceParameterName.add("舍内");
        deviceParameterName.add("舍前");
        deviceParameterName.add("舍中");
        deviceParameterName.add("舍后");
        deviceParameterName.add("舍外");
        deviceParameterName.add("水温");
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
        ParameterData01 parameterWaterTemp = new ParameterData01();
        parameterWaterTemp.setName("水温");
        ParameterData01 parameterWaterFlow = new ParameterData01();
        parameterWaterFlow.setName("饮水量");
        ParameterData01 parameterDayWaterFlow = new ParameterData01();
        parameterDayWaterFlow.setName("日饮水量");


        List<OneDataDetail> inAveTempList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp01List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp02List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> inTemp03List = new ArrayList<OneDataDetail>();
        List<OneDataDetail> outTempList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> waterTempList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> waterFlowList = new ArrayList<OneDataDetail>();
        List<OneDataDetail> dayWaterFlowList = new ArrayList<OneDataDetail>();

        for (EC01DeviceMessage deviceMessage : deviceMessageList
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

            //锅炉水温
            OneDataDetail oneDataDetailWaterTemp = new OneDataDetail();
            oneDataDetailWaterTemp.setName(deviceMessage.getSendDate());
            oneDataDetailWaterTemp.setValue(String.valueOf(deviceMessage.getBoilerTemp()));

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
            waterTempList.add(oneDataDetailWaterTemp);
            waterFlowList.add(oneDataDetailWaterFlow);
            dayWaterFlowList.add(oneDataDetailDayWaterFlow);
        }

        parameterInAveTemp.setData(inAveTempList);
        parameterInTemp1.setData(inTemp01List);
        parameterInTemp2.setData(inTemp02List);
        parameterInTemp3.setData(inTemp03List);
        parameterOutTemp.setData(outTempList);
        parameterWaterTemp.setData(waterTempList);
        parameterWaterFlow.setData(waterFlowList);
        parameterDayWaterFlow.setData(dayWaterFlowList);

        parameterDataList.add(parameterInAveTemp);
        parameterDataList.add(parameterInTemp1);
        parameterDataList.add(parameterInTemp2);
        parameterDataList.add(parameterInTemp3);
        parameterDataList.add(parameterOutTemp);
        parameterDataList.add(parameterWaterTemp);
        parameterDataList.add(parameterWaterFlow);
        parameterDataList.add(parameterDayWaterFlow);

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName(deviceMessageList.get(0).getDName());
        deviceInfo.setDSerialNum(deviceMessageList.get(0).getDSerialNum());
        this.deviceInfo = deviceInfo;
        this.chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);
    }

    /**
     * 日平均温度曲线
     *
     * @param ec01DeviceDayAvgTemp
     */
    public DeviceCharts01(EC01DeviceDayAvgTemp ec01DeviceDayAvgTemp) {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();
        deviceParameterName.add("日温饮水");
        ParameterData01 parameterDayTemp = new ParameterData01();
        parameterDayTemp.setName("日温饮水");
        List<OneDataDetail> dayTempList = new ArrayList<OneDataDetail>();
        for (EC01DayAvgTemp ec01DayAvgTemp : ec01DeviceDayAvgTemp.getEc01DayAvgTempList()
                ) {
            deviceParameterTime.add(ec01DayAvgTemp.getSendDate());

            //日温
            OneDataDetail oneDataDetailDayTemp = new OneDataDetail();
            oneDataDetailDayTemp.setName(ec01DayAvgTemp.getSendDate());
            oneDataDetailDayTemp.setValue(String.valueOf(ec01DayAvgTemp.getAvgTemp()));

            dayTempList.add(oneDataDetailDayTemp);
        }
        parameterDayTemp.setData(dayTempList);
        parameterDataList.add(parameterDayTemp);

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName(ec01DeviceDayAvgTemp.getDName() + "-日温");
        deviceInfo.setDSerialNum(ec01DeviceDayAvgTemp.getDSerialNum());
        this.deviceInfo = deviceInfo;
        this.chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);
    }

    /**
     * 日温饮水-日饮水量曲线/日饮水量曲线
     *
     * @param ec01DeviceDayWater
     */
    public DeviceCharts01(EC01DeviceDayWater ec01DeviceDayWater,String sQueryParam) {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();
        deviceParameterName.add(sQueryParam);
        ParameterData01 parameterDayWater = new ParameterData01();
        parameterDayWater.setName(sQueryParam);
        List<OneDataDetail> dayWaterList = new ArrayList<OneDataDetail>();
        for (EC01DayWater ec01DayWater : ec01DeviceDayWater.getEc01DayWaterList()
                ) {
            deviceParameterTime.add(ec01DayWater.getSendDate());

            //日饮水
            OneDataDetail oneDataDetailDayWater = new OneDataDetail();
            oneDataDetailDayWater.setName(ec01DayWater.getSendDate());
            oneDataDetailDayWater.setValue(String.valueOf(ec01DayWater.getWaterFlowVal()));

            dayWaterList.add(oneDataDetailDayWater);
        }
        parameterDayWater.setData(dayWaterList);
        parameterDataList.add(parameterDayWater);

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName(ec01DeviceDayWater.getDName() + "-饮水");
        deviceInfo.setDSerialNum(ec01DeviceDayWater.getDSerialNum());
        this.deviceInfo = deviceInfo;
        this.chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);
    }

    /**
     * 获取单个设备、单日的曲线
     *
     * @param deviceMessageList
     * @param sDateTime
     * @param sQueryParam
     */
    public DeviceCharts01(List<EC01DeviceMessage> deviceMessageList, String sDateTime, String sQueryParam) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName(deviceMessageList.get(0).getDName() + "-" + sDateTime);
        deviceInfo.setDSerialNum(deviceMessageList.get(0).getDSerialNum());
        this.deviceInfo = deviceInfo;
        if (sQueryParam.equals("单舍饮水量")) {
            this.chartsParameters01 = this.getChartByOneDeviceWaterAndDt(deviceMessageList, sDateTime);
        } else if (sQueryParam.equals("单舍温度")) {
            this.chartsParameters01 = this.getChartByOneDeviceTempAndDt(deviceMessageList, sDateTime);
        }
    }

    /**
     * 获取多个设备日饮水量累加的曲线
     *
     * @param ec01DeviceDate
     * @param deviceMessageList
     */
    public DeviceCharts01(List<String> ec01DeviceDate, List<EC01DeviceMessage> deviceMessageList) {
        Map<String, Float> dayWaterMap = new HashMap<String, Float>();
        for (String sDate : ec01DeviceDate
                ) {
            float fDayWater = 0;
            for (EC01DeviceMessage ec01DeviceMessage : deviceMessageList
                    ) {
                String sMsgDate = ec01DeviceMessage.getSendDate().substring(0, 10);
                if (sDate.equals(sMsgDate)) {
                    fDayWater = fDayWater + ec01DeviceMessage.getWaterFlowVal();
                }
            }
            dayWaterMap.put(sDate, fDayWater);
        }
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();
        deviceParameterName.add("多舍日饮水量");
        ParameterData01 parameterOneDevice = new ParameterData01();
        parameterOneDevice.setName("多舍日饮水量");
        List<OneDataDetail> oneDataDetailList = new ArrayList<OneDataDetail>();
        for (Map.Entry<String, Float> entry : dayWaterMap.entrySet()) {
            String sOneDateTime = entry.getKey();
            deviceParameterTime.add(sOneDateTime);

            //日饮水数据
            OneDataDetail oneDataDetail = new OneDataDetail();
            oneDataDetail.setName(sOneDateTime);
            oneDataDetail.setValue(String.valueOf(entry.getValue()));
            oneDataDetailList.add(oneDataDetail);
        }
        parameterOneDevice.setData(oneDataDetailList);
        parameterDataList.add(parameterOneDevice);
        this.chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDName("多舍日饮水量");
        this.deviceInfo = deviceInfo;
    }

    private ChartsParameters01 getChartByOneDeviceWaterAndDt(List<EC01DeviceMessage> deviceMessageList, String sDateTime) {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();
        deviceParameterName.add("单舍饮水量");
        ParameterData01 parameterOneDevice = new ParameterData01();
        parameterOneDevice.setName("单舍饮水量");
        List<OneDataDetail> oneDataDetailList = new ArrayList<OneDataDetail>();
        for (EC01DeviceMessage ec01DeviceMessage : deviceMessageList
                ) {
            String sOneDateTime = ec01DeviceMessage.getSendDate().substring(11, 19);
            deviceParameterTime.add(sOneDateTime);

            //饮水数据
            OneDataDetail oneDataDetail = new OneDataDetail();
            oneDataDetail.setName(sOneDateTime);
            oneDataDetail.setValue(String.valueOf(ec01DeviceMessage.getWaterFlowVal()));

            oneDataDetailList.add(oneDataDetail);
        }
        parameterOneDevice.setData(oneDataDetailList);
        parameterDataList.add(parameterOneDevice);

        ChartsParameters01 chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);

        return chartsParameters01;
    }

    private ChartsParameters01 getChartByOneDeviceTempAndDt(List<EC01DeviceMessage> deviceMessageList, String sDateTime) {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();
        deviceParameterName.add("单舍温度");
        ParameterData01 parameterOneDevice = new ParameterData01();
        parameterOneDevice.setName("单舍温度");
        List<OneDataDetail> oneDataDetailList = new ArrayList<OneDataDetail>();
        for (EC01DeviceMessage ec01DeviceMessage : deviceMessageList
                ) {
            String sOneDateTime = ec01DeviceMessage.getSendDate().substring(11, 19);
            deviceParameterTime.add(sOneDateTime);

            //温度数据
            OneDataDetail oneDataDetail = new OneDataDetail();
            oneDataDetail.setName(sOneDateTime);
            oneDataDetail.setValue(String.valueOf(ec01DeviceMessage.getInAveTemp()));

            oneDataDetailList.add(oneDataDetail);
        }
        parameterOneDevice.setData(oneDataDetailList);
        parameterDataList.add(parameterOneDevice);


        ChartsParameters01 chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);

        return chartsParameters01;
    }

}


