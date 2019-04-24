package com.system.controller.util;

import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartTtip.EcttipAxisPointer;
import com.system.po.EChartsOptions.EChartsParts.ECAxisLabel;
import com.system.po.EChartsOptions.EChartsParts.ECAxisLine;
import com.system.po.EChartsOptions.EChartsParts.ECLineStyle;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.Hj212C213.Hj212C213Threshold;
import com.system.po.Phone.PhoneEChartsOptionsY;
import com.system.po.parameter.ParameterData;
import com.system.util.DataConvertor;
import com.system.util.EChartsUtil;
import com.system.util.Hj212C213Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 单设备 双曲线
 */
@Controller
public class Hj212C213ChartTwoParam {
    private Hj212C213Threshold hj212C213Threshold = new Hj212C213Threshold();

    //生成曲线
    public PhoneEChartsOptionsY getECharts(String sQueryParam, Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = null;
        if (sQueryParam.equals("流量/COD")) {
            phoneEChartsOptionsY = this.getFlowrateCod(hj212C213DayDataMap);
        } else if (sQueryParam.equals("流量/氨氮")) {
            phoneEChartsOptionsY = this.getFlowrateNh3N(hj212C213DayDataMap);
        } else if (sQueryParam.equals("流量/总磷")) {
            phoneEChartsOptionsY = this.getFlowrateTp(hj212C213DayDataMap);
        } else if (sQueryParam.equals("COD/氨氮")) {
            phoneEChartsOptionsY = this.getCodNh3n(hj212C213DayDataMap);
        } else if (sQueryParam.equals("COD/总磷")) {
            phoneEChartsOptionsY = this.getCodTp(hj212C213DayDataMap);
        } else if (sQueryParam.equals("氨氮/总磷")) {
            phoneEChartsOptionsY = this.getNh3nTp(hj212C213DayDataMap);
        }
        return phoneEChartsOptionsY;
    }

    //生成流量+COD曲线
    private PhoneEChartsOptionsY getFlowrateCod(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendFlowrate = "流量(m³/d)";
        String legendCod = "COD(mg/l)";
        legendDataList.add(legendFlowrate);
        legendDataList.add(legendCod);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getFlowrateYAxis(hj212C213DayDataMap));
        eChartsYAxisList.add(this.getCodYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getFlowrateSeries(sDateList,hj212C213DayDataMap));
            parameterDataList.add(this.getCodSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    //生成流量+氨氮曲线
    private PhoneEChartsOptionsY getFlowrateNh3N(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendFlowrate = "流量(m³/d)";
        String legendNh3n = "氨氮(mg/l)";
        legendDataList.add(legendFlowrate);
        legendDataList.add(legendNh3n);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getFlowrateYAxis(hj212C213DayDataMap));
        eChartsYAxisList.add(this.getNh3nYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getFlowrateSeries(sDateList,hj212C213DayDataMap));
            parameterDataList.add(this.getNh3nSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    //生成流量+总磷曲线
    private PhoneEChartsOptionsY getFlowrateTp(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendFlowrate = "流量(m³/d)";
        String legendTp = "总磷(mg/l)";
        legendDataList.add(legendFlowrate);
        legendDataList.add(legendTp);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getFlowrateYAxis(hj212C213DayDataMap));
        eChartsYAxisList.add(this.getTpYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getFlowrateSeries(sDateList,hj212C213DayDataMap));
            parameterDataList.add(this.getTpSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    //生成流量+总氮曲线
    private PhoneEChartsOptionsY getFlowrateTn(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendFlowrate = "流量(m³/d)";
        String legendTn = "总氮(mg/l)";
        legendDataList.add(legendFlowrate);
        legendDataList.add(legendTn);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getFlowrateYAxis(hj212C213DayDataMap));
        eChartsYAxisList.add(this.getTnYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getFlowrateSeries(sDateList,hj212C213DayDataMap));
            parameterDataList.add(this.getTnSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    //生成COD+氨氮曲线
    private PhoneEChartsOptionsY getCodNh3n(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendCod = "COD(mg/l)";
        String legendNh3n = "氨氮(mg/l)";
        legendDataList.add(legendCod);
        legendDataList.add(legendNh3n);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getCodYAxis(hj212C213DayDataMap,"left"));
        eChartsYAxisList.add(this.getNh3nYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getCodSeries(sDateList,hj212C213DayDataMap,"0"));
            parameterDataList.add(this.getNh3nSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    //生成COD+总磷曲线
    private PhoneEChartsOptionsY getCodTp(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendCod = "COD(mg/l)";
        String legendTp = "总磷(mg/l)";
        legendDataList.add(legendCod);
        legendDataList.add(legendTp);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getCodYAxis(hj212C213DayDataMap,"left"));
        eChartsYAxisList.add(this.getTpYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getCodSeries(sDateList,hj212C213DayDataMap,"0"));
            parameterDataList.add(this.getTpSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    //生成氨氮+总磷曲线
    private PhoneEChartsOptionsY getNh3nTp(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        PhoneEChartsOptionsY phoneEChartsOptionsY = new PhoneEChartsOptionsY();
        phoneEChartsOptionsY.setColor(EChartsUtil.Color());
        //添加标题
        EChartsTitle eChartsTitle = new EChartsTitle();
        for (String key : hj212C213DayDataMap.keySet()) {
            eChartsTitle.setText(hj212C213DayDataMap.get(key).getName());
            break;
        }
        eChartsTitle.setSubtext("");
        phoneEChartsOptionsY.setTitle(eChartsTitle);
        //tooltip
        EChartsTooltip eChartsTooltip = new EChartsTooltip();
        eChartsTooltip.setTrigger("axis");
        EcttipAxisPointer ecttipAxisPointer = new EcttipAxisPointer();
        ecttipAxisPointer.setType("cross");
        eChartsTooltip.setAxisPointer(ecttipAxisPointer);
        phoneEChartsOptionsY.setTooltip(eChartsTooltip);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        String legendNh3n = "氨氮(mg/l)";
        String legendTp = "总磷(mg/l)";
        legendDataList.add(legendNh3n);
        legendDataList.add(legendTp);
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptionsY.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213DayDataMap);
        eChartsXAxis.setData(sDateList);
        //分割线
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        //坐标轴刻度标签--X轴
        ECxAxisAxisLabel eCxAxisAxisLabel = new ECxAxisAxisLabel();
        //eCxAxisAxisLabel.setInterval("0");
        eCxAxisAxisLabel.setRotate("0");
        eChartsXAxis.setAxisLabel(eCxAxisAxisLabel);
        phoneEChartsOptionsY.setxAxis(eChartsXAxis);
        //Y轴线
        List<EChartsYAxis> eChartsYAxisList = new ArrayList<>();
        eChartsYAxisList.add(this.getNh3nYAxis(hj212C213DayDataMap,"left"));
        eChartsYAxisList.add(this.getTpYAxis(hj212C213DayDataMap, "right"));
        phoneEChartsOptionsY.setyAxis(eChartsYAxisList);
        //双曲线
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213DayDataMap.size() > 0) {
            parameterDataList.add(this.getNh3nSeries(sDateList,hj212C213DayDataMap,"0"));
            parameterDataList.add(this.getTpSeries(sDateList,hj212C213DayDataMap,"1"));
        }
        phoneEChartsOptionsY.setSeries(parameterDataList);

        phoneEChartsOptionsY.showPoint(false, false);
        return phoneEChartsOptionsY;
    }

    private EChartsYAxis getFlowrateYAxis(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (hj212C213DayDataMap.size() > 0) {
            eChartsYAxis.setMin(this.getMinFlowrate(hj212C213DayDataMap));
            eChartsYAxis.setMax(this.getMaxFlowrate(hj212C213DayDataMap));
        }
        eChartsYAxis.setType("value");
        eChartsYAxis.setPosition("left");
        eChartsYAxis.setName("流量");
        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} m³/d");
        eChartsYAxis.setAxisLabel(ecAxisLabel);

        ECAxisLine ecAxisLine = new ECAxisLine();
        ECLineStyle ecLineStyle = new ECLineStyle();
        ecLineStyle.setColor("#675bba");
        ecAxisLine.setLineStyle(ecLineStyle);
        eChartsYAxis.setAxisLine(ecAxisLine);

        //EcSplitLine ecySplitLine = new EcSplitLine();
        //eChartsYAxis.setSplitLine(ecySplitLine);
        return eChartsYAxis;
    }

    //hashmap是无序的，要注意取值
    private ParameterData getFlowrateSeries(List<String> sDateList,Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        ParameterData parameterData = new ParameterData();
        String parameterName = "流量(m³/d)";
        parameterData.setName(parameterName);
        List<String> dataList = new ArrayList<>();
        for (String sDate:sDateList
                ) {
            dataList.add(hj212C213DayDataMap.get(sDate).getFlowrate());
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        parameterData.setShowAllSymbol(false);
        return parameterData;
    }

    //获取流量的最小值
    private String getMinFlowrate(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            minValue = Float.valueOf(value.getFlowrate());
            break;
        }
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getFlowrate()) < minValue) {
                minValue = Float.valueOf(value.getFlowrate());
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取流量的最大值
    private String getMaxFlowrate(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getFlowrate()) > maxValue) {
                maxValue = Float.valueOf(value.getFlowrate());
            }
        }
        maxValue = maxValue + 3f;
        return String.valueOf(maxValue);
    }
    /********************COD 开始***********************************/
    private EChartsYAxis getCodYAxis(Map<String, Hj212C213DayData> hj212C213DayDataMap, String position) {
        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (hj212C213DayDataMap.size() > 0) {
            eChartsYAxis.setMin(this.getMinCod(hj212C213DayDataMap));
            eChartsYAxis.setMax(this.getMaxCod(hj212C213DayDataMap));
        }
        eChartsYAxis.setType("value");
        eChartsYAxis.setPosition(position);
        eChartsYAxis.setName("COD(mg/l)");
        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} mg/l");
        eChartsYAxis.setAxisLabel(ecAxisLabel);
        //EcSplitLine ecySplitLine = new EcSplitLine();
        //eChartsYAxis.setSplitLine(ecySplitLine);
        return eChartsYAxis;
    }

    private ParameterData getCodSeries(List<String> sDateList,Map<String, Hj212C213DayData> hj212C213DayDataMap,String yAxisIndex) {
        ParameterData parameterData = new ParameterData();
        String parameterName = "COD(mg/l)";
        parameterData.setName(parameterName);
        List<String> dataList = new ArrayList<>();
        for (String sDate:sDateList
             ) {
            dataList.add(hj212C213DayDataMap.get(sDate).getCod());
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        parameterData.setyAxisIndex(yAxisIndex);
        parameterData.setShowAllSymbol(false);
        return parameterData;
    }

    //获取COD的最小值
    private String getMinCod(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if(value.getCod().equals("NaN"))
                continue;
            minValue = Float.valueOf(value.getCod());
            break;
        }
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getCod()) < minValue) {
                minValue = Float.valueOf(value.getCod());
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取COD的最大值
    private String getMaxCod(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getCod()) > maxValue) {
                maxValue = Float.valueOf(value.getCod());
            }
        }
        maxValue = maxValue + 3f;
        if (maxValue < hj212C213Threshold.getMaxCOD()) { //为最大基准线服务
            maxValue = hj212C213Threshold.getMaxCOD() + 1f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue, 1));
    }
    /********************COD 结束***********************************/

    /********************氨氮 开始***********************************/
    private EChartsYAxis getNh3nYAxis(Map<String, Hj212C213DayData> hj212C213DayDataMap, String position) {
        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (hj212C213DayDataMap.size() > 0) {
            eChartsYAxis.setMin(this.getMinNh3n(hj212C213DayDataMap));
            eChartsYAxis.setMax(this.getMaxNh3n(hj212C213DayDataMap));
        }
        eChartsYAxis.setType("value");
        eChartsYAxis.setPosition(position);
        eChartsYAxis.setName("氨氮(mg/l)");
        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} mg/l");
        eChartsYAxis.setAxisLabel(ecAxisLabel);
        //EcSplitLine ecySplitLine = new EcSplitLine();
        //eChartsYAxis.setSplitLine(ecySplitLine);
        return eChartsYAxis;
    }

    private ParameterData getNh3nSeries(List<String> sDateList,Map<String, Hj212C213DayData> hj212C213DayDataMap,String yAxisIndex) {
        ParameterData parameterData = new ParameterData();
        String parameterName = "氨氮(mg/l)";
        parameterData.setName(parameterName);
        List<String> dataList = new ArrayList<>();
        for (String sDate:sDateList
                ) {
            dataList.add(hj212C213DayDataMap.get(sDate).getNh3n());
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        parameterData.setyAxisIndex(yAxisIndex);
        parameterData.setShowAllSymbol(false);
        return parameterData;
    }

    //获取Nh3n的最小值
    private String getMinNh3n(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if(value.getNh3n().equals("NaN"))
                continue;
            minValue = Float.valueOf(value.getNh3n());
            break;
        }
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getNh3n()) < minValue) {
                minValue = Float.valueOf(value.getNh3n());
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取Nh3N的最大值
    private String getMaxNh3n(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getNh3n()) > maxValue) {
                maxValue = Float.valueOf(value.getNh3n());
            }
        }
        maxValue = maxValue + 3f;
        if (maxValue < hj212C213Threshold.getMaxNh3N()) { //为最大基准线服务
            maxValue = hj212C213Threshold.getMaxNh3N() + 1f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue, 1));
    }
    /********************氨氮 结束***********************************/

    /********************总磷 开始***********************************/
    private EChartsYAxis getTpYAxis(Map<String, Hj212C213DayData> hj212C213DayDataMap, String position) {
        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (hj212C213DayDataMap.size() > 0) {
            eChartsYAxis.setMin(this.getMinTp(hj212C213DayDataMap));
            eChartsYAxis.setMax(this.getMaxTp(hj212C213DayDataMap));
        }
        eChartsYAxis.setType("value");
        eChartsYAxis.setPosition(position);
        eChartsYAxis.setName("总磷(mg/l)");
        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} mg/l");
        eChartsYAxis.setAxisLabel(ecAxisLabel);
        //EcSplitLine ecySplitLine = new EcSplitLine();
        //eChartsYAxis.setSplitLine(ecySplitLine);
        return eChartsYAxis;
    }

    private ParameterData getTpSeries(List<String> sDateList,Map<String, Hj212C213DayData> hj212C213DayDataMap,String yAxisIndex) {
        ParameterData parameterData = new ParameterData();
        String parameterName = "总磷(mg/l)";
        parameterData.setName(parameterName);
        List<String> dataList = new ArrayList<>();
        for (String sDate:sDateList
                ) {
            dataList.add(hj212C213DayDataMap.get(sDate).getTp());
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        parameterData.setyAxisIndex(yAxisIndex);
        parameterData.setShowAllSymbol(false);
        return parameterData;
    }

    //获取总磷的最小值
    private String getMinTp(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if(value.getTp().equals("NaN"))
                continue;
            minValue = Float.valueOf(value.getTp());
            break;
        }
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getTp()) < minValue) {
                minValue = Float.valueOf(value.getTp());
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取总磷的最大值
    private String getMaxTp(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getTp()) > maxValue) {
                maxValue = Float.valueOf(value.getTp());
            }
        }
        maxValue = maxValue + 0.3f;
        if (maxValue < hj212C213Threshold.getMaxTp()) { //为最大基准线服务
            maxValue = hj212C213Threshold.getMaxTp() + 0.1f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue, 1));
    }
    /********************总磷 结束***********************************/

    /********************总氮 开始***********************************/
    private EChartsYAxis getTnYAxis(Map<String, Hj212C213DayData> hj212C213DayDataMap, String position) {
        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin("0");
        eChartsYAxis.setMax("1");
        if (hj212C213DayDataMap.size() > 0) {
            eChartsYAxis.setMin(this.getMinTn(hj212C213DayDataMap));
            eChartsYAxis.setMax(this.getMaxTn(hj212C213DayDataMap));
        }
        eChartsYAxis.setType("value");
        eChartsYAxis.setPosition(position);
        eChartsYAxis.setName("总氮(mg/l)");
        ECAxisLabel ecAxisLabel = new ECAxisLabel();
        ecAxisLabel.setFormatter("{value} mg/l");
        eChartsYAxis.setAxisLabel(ecAxisLabel);
        //EcSplitLine ecySplitLine = new EcSplitLine();
        //eChartsYAxis.setSplitLine(ecySplitLine);
        return eChartsYAxis;
    }

    private ParameterData getTnSeries(List<String> sDateList,Map<String, Hj212C213DayData> hj212C213DayDataMap,String yAxisIndex) {
        ParameterData parameterData = new ParameterData();
        String parameterName = "总氮(mg/l)";
        parameterData.setName(parameterName);
        List<String> dataList = new ArrayList<>();
        for (String sDate:sDateList
                ) {
            dataList.add(hj212C213DayDataMap.get(sDate).getTn());
        }
        parameterData.setData(dataList);
        parameterData.setType("line");
        parameterData.setyAxisIndex(yAxisIndex);
        parameterData.setShowAllSymbol(false);
        return parameterData;
    }

    //获取总氮的最小值
    private String getMinTn(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if(value.getTn().equals("NaN"))
                continue;
            minValue = Float.valueOf(value.getTn());
            break;
        }
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getTn()) < minValue) {
                minValue = Float.valueOf(value.getTn());
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取总氮的最大值
    private String getMaxTn(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (Hj212C213DayData value : hj212C213DayDataMap.values()) {
            if (Float.valueOf(value.getTn()) > maxValue) {
                maxValue = Float.valueOf(value.getTn());
            }
        }
        maxValue = maxValue + 0.3f;
        return String.valueOf(DataConvertor.formatFloat(maxValue, 1));
    }
    /********************总磷 结束***********************************/
}
