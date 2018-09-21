package com.system.controller.util;

import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.ScaleC01.ScaleC01WtAnalysis;
import com.system.po.parameter.ParameterData;
import com.system.util.EC01Util;
import com.system.util.EChartsUtil;
import com.system.util.ScaleC01Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ScaleC01Chart {

    //生成曲线
    public PhoneEChartsOptions getECharts(String sQueryParam, Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = null;
        if (sQueryParam.equals("平均体重")) {
            phoneEChartsOptions = this.getWtCharts(scaleC01MapByDate);
        } else if (sQueryParam.equals("增重日龄")) {
            //增重日龄是针对单个设备的，只需要选取一个即可
            List<ScaleC01WtAnalysis> scaleC01WtAnalysisList = null;
            for (List<ScaleC01WtAnalysis> list : scaleC01MapByDate.values()) {
                scaleC01WtAnalysisList = list;
                break;
            }
            phoneEChartsOptions = this.getAgeCharts(scaleC01WtAnalysisList);
        }
        return phoneEChartsOptions;
    }

    //生成平均体重曲线
    private PhoneEChartsOptions getWtCharts(Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("平均体重");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : scaleC01MapByDate.keySet()) {
            if (!legendDataList.contains(key)) {
                legendDataList.add(key);
            }
        }
        eChartsLegend.setData(legendDataList);
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = ScaleC01Util.getScaleC01DateList(scaleC01MapByDate);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (scaleC01MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinWt(scaleC01MapByDate));
            eChartsYAxis.setMax(this.getMaxWt(scaleC01MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getWtSeries(scaleC01MapByDate));
        phoneEChartsOptions.showPoint(false, false);
        return phoneEChartsOptions;
    }

    private PhoneEChartsOptions getAgeCharts(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("增重日龄");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        legendDataList.add("增重");
        eChartsLegend.setData(legendDataList);
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = new ArrayList<>();
        for (int i = 0; i < scaleC01WtAnalysisList.size(); i++) {
            sDateList.add(String.valueOf(scaleC01WtAnalysisList.get(i).getDayAge()));
        }
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (scaleC01WtAnalysisList.size() > 0) {
            eChartsYAxis.setMin(this.getMinGainWt(scaleC01WtAnalysisList));
            eChartsYAxis.setMax(this.getMaxGainWt(scaleC01WtAnalysisList));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        List<ParameterData> parameterDataList = new ArrayList<>();
        parameterDataList.add(this.getGainWtAgeSeries(scaleC01WtAnalysisList));
        phoneEChartsOptions.setSeries(parameterDataList);
        phoneEChartsOptions.showPoint(false, false);
        return phoneEChartsOptions;
    }

    //获取平均体重的最小值
    private String getMinWt(Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<ScaleC01WtAnalysis> value : scaleC01MapByDate.values()) {
            minValue = value.get(0).getAvgWt();
            break;
        }
        for (List<ScaleC01WtAnalysis> value : scaleC01MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).getAvgWt() < minValue) {
                    minValue = value.get(i).getAvgWt();
                }
            }
        }
        minValue = minValue - 3;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取平均体重的最大值
    private String getMaxWt(Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<ScaleC01WtAnalysis> value : scaleC01MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).getAvgWt() > maxValue) {
                    maxValue = value.get(i).getAvgWt();
                }
            }
        }
        return String.valueOf(maxValue + 3);
    }

    //获取平均体重的曲线
    private List<ParameterData> getWtSeries(Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (scaleC01MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (List<ScaleC01WtAnalysis> value : scaleC01MapByDate.values()) {
            ParameterData parameterData = new ParameterData();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getAvgWt()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取增重的最小值
    private String getMinGainWt(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        //遍历map中的值
        float minValue = scaleC01WtAnalysisList.get(0).getGainWt();
        for (int i = 1; i < scaleC01WtAnalysisList.size(); i++) {
            if (scaleC01WtAnalysisList.get(i).getGainWt() < minValue) {
                minValue = scaleC01WtAnalysisList.get(i).getGainWt();
            }
        }
        minValue = minValue - 3;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取增重的最大值
    private String getMaxGainWt(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        //遍历map中的值
        float maxValue = scaleC01WtAnalysisList.get(0).getGainWt();
        for (int i = 1; i < scaleC01WtAnalysisList.size(); i++) {
            if (scaleC01WtAnalysisList.get(i).getGainWt() > maxValue) {
                maxValue = scaleC01WtAnalysisList.get(i).getGainWt();
            }
        }
        return String.valueOf(maxValue + 3);
    }

    //获取增重的曲线（当前只看一个设备，所以只有一条曲线）
    private ParameterData getGainWtAgeSeries(List<ScaleC01WtAnalysis> scaleC01WtAnalysisList) {
        if (scaleC01WtAnalysisList.size() < 1) {
            return null;
        }
        //只有一条曲线
        ParameterData parameterData = new ParameterData();
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < scaleC01WtAnalysisList.size(); i++) {
            dataList.add(String.valueOf(scaleC01WtAnalysisList.get(i).getGainWt()));
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        return parameterData;
    }
}
