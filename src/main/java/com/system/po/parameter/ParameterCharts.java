package com.system.po.parameter;

import com.system.po.Device.EC01DeviceMessage;
import com.system.po.EChartsOptions.EChartsYAxis;

import java.util.ArrayList;
import java.util.List;

public class ParameterCharts {
    private ChartsParameters chartsParameters;
    private List<EChartsYAxis> eChartsYAxisList;
    private ChartsParameters01 chartsParameters01;

    public ChartsParameters getChartsParameters() {
        return chartsParameters;
    }

    public void setChartsParameters(ChartsParameters chartsParameters) {
        this.chartsParameters = chartsParameters;
    }

    public ChartsParameters01 getChartsParameters01() {
        return chartsParameters01;
    }

    public void setChartsParameters01(ChartsParameters01 chartsParameters01) {
        this.chartsParameters01 = chartsParameters01;
    }

    public List<EChartsYAxis> geteChartsYAxisList() {
        return eChartsYAxisList;
    }

    public void seteChartsYAxisList(List<EChartsYAxis> eChartsYAxisList) {
        this.eChartsYAxisList = eChartsYAxisList;
    }

    public ParameterCharts(List<DeviceCharts01> deviceChartsList, String sQueryParam) {
        List<String> deviceParameterName = new ArrayList<String>();
        List<String> deviceParameterTime = new ArrayList<String>();
        List<ParameterData01> parameterDataList = new ArrayList<ParameterData01>();

        for (DeviceCharts01 deviceChats : deviceChartsList
                ) {
            deviceParameterName.add(deviceChats.getDeviceInfo().getDName());
            deviceParameterTime.addAll(deviceChats.getChartsParameters01().getdParameterTime());

            ParameterData01 parameterData01 = new ParameterData01();
            parameterData01.setName(deviceChats.getDeviceInfo().getDName());
            List<OneDataDetail> dataList = new ArrayList<OneDataDetail>();
            for (ParameterData01 parameterData1 : deviceChats.getChartsParameters01().getdParameterdata()
                    ) {
                if (parameterData1.getName().equals(sQueryParam))
                    dataList = parameterData1.getData();
            }
            ;
            parameterData01.setData(dataList);
            parameterDataList.add(parameterData01);
        }

        this.chartsParameters01 = new ChartsParameters01(deviceParameterName, parameterDataList, deviceParameterTime);

    }

    public ParameterCharts(List<DeviceCharts01> deviceChartsList, String sQueryParam, List<String> deviceParameterTime) {
        //曲线的名称
        List<String> deviceParameterName = new ArrayList<String>();
        //曲线的时间轴
        //List<String> deviceParameterTime = new ArrayList<String>();
        //曲线的series
        List<ParameterData> parameterDataList = new ArrayList<ParameterData>();

        //根据时间序列，生成新的ParameterData的list；parameterDataList即为曲线中对应的series
        for (DeviceCharts01 deviceChats : deviceChartsList
                ) {
            deviceParameterName.add(deviceChats.getDeviceInfo().getDName());

            ParameterData parameterData = new ParameterData();
            parameterData.setName(deviceChats.getDeviceInfo().getDName());
            if(sQueryParam.equals("日温饮水")) {
                if (parameterData.getName().indexOf("-饮水") > -1) {
                    parameterData.setyAxisIndex("1");
                }
            }
            List<String> dataList = new ArrayList<String>();
            List<OneDataDetail> oneDataDetailList = new ArrayList<OneDataDetail>();
            //一个设备有多个参数，每个参数都有一个ParameterData01
            for (ParameterData01 parameterData1 : deviceChats.getChartsParameters01().getdParameterdata()
                    ) {
                //第一步：找到需要对比的参数
                oneDataDetailList.clear();
                oneDataDetailList.addAll(parameterData1.getData());
                if (parameterData1.getName().equals(sQueryParam)) {
                    //第二步：取出总的时间轴
                    for (String str : deviceParameterTime
                            ) {
                        //第三步：时间轴时间点与数据的时间点对比，合成与时间轴一致的数据个数
                        //与所有数据对比，相同的才添加，不同的添加NaN;
                        //测试过程中，同一个设备的两个数据时间完全相同，后一个数据会将前一个数据替换，
                        // 可以用list remove的方法
                        String sSameTimeValue = "NaN";
                        for (OneDataDetail oDD : oneDataDetailList
                                ) {
                            //时间轴和具体的数值对比，如果数值存在就赋值，如果数值不存在就给NaN
                            if (str.equals(oDD.getName())) {
                                sSameTimeValue = oDD.getValue();
                                oneDataDetailList.remove(oDD);
                                break;
                            }
                        }
                        dataList.add(sSameTimeValue);
                    }
                    break;
                }
            }

            parameterData.setData(dataList);  //单个series
            if (sQueryParam.equals("日饮水量")) {
                parameterData.setShowAllSymbol(true);
            } else {
                parameterData.setShowAllSymbol(false);
            }
            parameterDataList.add(parameterData);//多个series
        }

        this.chartsParameters = new ChartsParameters(deviceParameterName, parameterDataList, deviceParameterTime);

    }
}
