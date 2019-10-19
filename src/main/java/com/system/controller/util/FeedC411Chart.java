package com.system.controller.util;

import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.FeedC411.FC411HisTemp;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.parameter.ParameterData;
import com.system.util.EChartsUtil;
import com.system.util.FeedC411Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * 饲料部-筒仓测温
 */
@Controller
public class FeedC411Chart {

    //生成曲线
    public PhoneEChartsOptions getECharts(String sQueryParam, List<FC411HisTemp> FC411HisTempList){
        if(FC411HisTempList.size() <1)
            return null;
        FC411HisTemp FC411HisTemp01 = FC411HisTempList.get(0);
        String devName = FC411HisTemp01.getDName();
        PhoneEChartsOptions phoneEChartsOptions = getTempCharts(devName,sQueryParam, FC411HisTempList);
        return phoneEChartsOptions;
    }

    private PhoneEChartsOptions getTempCharts(String devName,String devParm,List<FC411HisTemp> FC411HisTempList){
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText(devName + "温度(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendName = devParm + "-温度(℃)";
        legendDataList.add(legendName);

        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = FeedC411Util.getDate01List(FC411HisTempList);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (FC411HisTempList.size() > 0) {
            eChartsYAxis.setMin(this.getMinTemp(FC411HisTempList));
            eChartsYAxis.setMax(this.getMaxTemp(FC411HisTempList));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTempSeries(devParm, FC411HisTempList));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //获取流量的最小值
    private String getMinTemp(List<FC411HisTemp> FC411HisTempList) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (FC411HisTemp value : FC411HisTempList) {
            minValue = Float.valueOf(value.getTemp());
            break;
        }
        for (int i = 0; i < FC411HisTempList.size(); i++) {
            if (Float.valueOf(FC411HisTempList.get(i).getTemp()) < minValue) {
                minValue = Float.valueOf(FC411HisTempList.get(i).getTemp());
            }
        }
        minValue = minValue - 3;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取流量的最大值
    private String getMaxTemp(List<FC411HisTemp> FC411HisTempList) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (int i = 0; i < FC411HisTempList.size(); i++) {
            if (Float.valueOf(FC411HisTempList.get(i).getTemp()) > maxValue) {
                maxValue = Float.valueOf(FC411HisTempList.get(i).getTemp());
            }
        }
        maxValue = maxValue + 3f;
        return String.valueOf(maxValue);
    }

    private List<ParameterData> getTempSeries(String devParm,List<FC411HisTemp> FC411HisTempList) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (FC411HisTempList.size() < 1) {
            return parameterDataList;
        }

        ParameterData parameterData = new ParameterData();
        String parameterName = devParm + "-温度(℃)";
        parameterData.setName(parameterName);
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < FC411HisTempList.size(); i++) {
            dataList.add(String.valueOf(FC411HisTempList.get(i).getTemp()));
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        parameterData.setShowAllSymbol(false);
        parameterDataList.add(parameterData);
        return parameterDataList;
    }
}
