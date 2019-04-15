package com.system.controller.util;

import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.parameter.ParameterData;
import com.system.util.DataConvertor;
import com.system.util.EChartsUtil;
import com.system.util.Hj212C213Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 单曲线(可以多设备)
 */
@Controller
public class Hj212C213Chart {
    //生成曲线
    public PhoneEChartsOptions getECharts(String sQueryParam, Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = null;
        if (sQueryParam.equals("流量")) {
            phoneEChartsOptions = this.getFlowrateCharts(deviceInfoMap, hj212C213MapByDate);
        }else if (sQueryParam.equals("pH")) {
            phoneEChartsOptions = this.getPhCharts(deviceInfoMap, hj212C213MapByDate);
        }else if (sQueryParam.equals("COD")) {
            phoneEChartsOptions = this.getCODCharts(deviceInfoMap, hj212C213MapByDate);
        } else if (sQueryParam.equals("氨氮")) {
            phoneEChartsOptions = this.getNh3nCharts(deviceInfoMap, hj212C213MapByDate);
        } else if (sQueryParam.equals("总磷")) {
            phoneEChartsOptions = this.getTPCharts(deviceInfoMap, hj212C213MapByDate);
        } else if (sQueryParam.equals("总氮")) {
            phoneEChartsOptions = this.getTNCharts(deviceInfoMap, hj212C213MapByDate);
        }
        return phoneEChartsOptions;
    }

    //生成流量曲线
    private PhoneEChartsOptions getFlowrateCharts(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("流量(m³/h)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : hj212C213MapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-流量(m³/h)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213Date01List(hj212C213MapByDate);
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
        if (hj212C213MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinFlowrate(hj212C213MapByDate));
            eChartsYAxis.setMax(this.getMaxFlowrate(hj212C213MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getFlowrateSeries(deviceInfoMap, hj212C213MapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //生成PH曲线
    private PhoneEChartsOptions getPhCharts(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("pH");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : hj212C213MapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-pH";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213Date01List(hj212C213MapByDate);
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
        if (hj212C213MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinPh(hj212C213MapByDate));
            eChartsYAxis.setMax(this.getMaxPh(hj212C213MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getpHSeries(deviceInfoMap, hj212C213MapByDate));
        //显示平均值 或者 显示最大最小值
        phoneEChartsOptions.showPoint(false, true);
        return phoneEChartsOptions;
    }

    //生成COD曲线
    private PhoneEChartsOptions getCODCharts(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("COD(mg/l)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : hj212C213MapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-COD";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DateCODList(hj212C213MapByDate);
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
        if (hj212C213MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinCOD(hj212C213MapByDate));
            eChartsYAxis.setMax(this.getMaxCOD(hj212C213MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getCODSeries(deviceInfoMap, hj212C213MapByDate));
        //显示平均值 或者 显示最大最小值
        phoneEChartsOptions.showPoint(false, true);
        return phoneEChartsOptions;
    }

    //生成氨氮曲线
    private PhoneEChartsOptions getNh3nCharts(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("氨氮(mg/l)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : hj212C213MapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-氨氮";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DateNh3nList(hj212C213MapByDate);
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
        if (hj212C213MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinNh3n(hj212C213MapByDate));
            eChartsYAxis.setMax(this.getMaxNh3n(hj212C213MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getNh3nSeries(deviceInfoMap, hj212C213MapByDate));
        //显示平均值 或者 显示最大最小值
        phoneEChartsOptions.showPoint(false, true);
        return phoneEChartsOptions;
    }

    //生成总磷曲线
    private PhoneEChartsOptions getTPCharts(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("总磷(mg/l)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : hj212C213MapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-总磷";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DateTPList(hj212C213MapByDate);
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
        if (hj212C213MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinTP(hj212C213MapByDate));
            eChartsYAxis.setMax(this.getMaxTP(hj212C213MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTPSeries(deviceInfoMap, hj212C213MapByDate));
        //显示平均值 或者 显示最大最小值
        phoneEChartsOptions.showPoint(false, true);
        return phoneEChartsOptions;
    }

    //生成总氮曲线
    private PhoneEChartsOptions getTNCharts(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("总氮");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : hj212C213MapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-总氮";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Hj212C213Util.getHj212C213DateTNList(hj212C213MapByDate);
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
        if (hj212C213MapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinTN(hj212C213MapByDate));
            eChartsYAxis.setMax(this.getMaxTN(hj212C213MapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTNSeries(deviceInfoMap, hj212C213MapByDate));
        //显示平均值 或者 显示最大最小值
        phoneEChartsOptions.showPoint(false, false);
        return phoneEChartsOptions;
    }

    /********************流量曲线私有函数 开始****************************/
    //获取流量的曲线
    private List<ParameterData> getFlowrateSeries(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-流量(m³/h)";
            parameterData.setName(parameterName);
            List<Hj212C213DeviceMessage> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getFlowrate_value()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取流量的最小值
    private String getMinFlowrate(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getFlowrate_value());
            break;
        }
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getFlowrate_value()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getFlowrate_value());
                }
            }
        }
        minValue = minValue - 3;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取流量的最大值
    private String getMaxFlowrate(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getFlowrate_value()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getFlowrate_value());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************流量曲线私有函数 结束****************************/

    /********************Ph曲线私有函数 开始****************************/
    //获取ph的曲线
    private List<ParameterData> getpHSeries(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-pH";
            parameterData.setName(parameterName);
            List<Hj212C213DeviceMessage> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getPh_value()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            //基本线配置
            EcsMarkLine ecsMarkLine = new EcsMarkLine();
            EcsmplData ecsmplData6 = new EcsmplData();
            ecsmplData6.setName("基准线-6");
            ecsmplData6.setType("line");
            ecsmplData6.setyAxis("6");
            EcsmplData ecsmplData9 = new EcsmplData();
            ecsmplData9.setName("基准线-9");
            ecsmplData9.setType("line");
            ecsmplData9.setyAxis("9");
            List<EcsmplData> ecsmplDataList = new ArrayList<>();
            ecsmplDataList.add(ecsmplData6);
            ecsmplDataList.add(ecsmplData9);
            ecsMarkLine.setData(ecsmplDataList);
            parameterData.setMarkLine(ecsMarkLine);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取ph的最小值
    private String getMinPh(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getPh_value());
            break;
        }
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getPh_value()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getPh_value());
                }
            }
        }
        minValue = minValue - 0.3f;
        if (minValue > 6f) {  //为最小基准线服务
            minValue = 5.9f;
        }
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取ph的最大值
    private String getMaxPh(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getPh_value()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getPh_value());
                }
            }
        }
        maxValue = maxValue+0.3f;
        if (maxValue < 9f) { //为最大基准线服务
            maxValue = 9.1f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue,1));
    }
    /********************Ph曲线私有函数 结束****************************/

    /********************COD曲线私有函数 开始****************************/
    //获取COD的曲线
    private List<ParameterData> getCODSeries(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-COD";
            parameterData.setName(parameterName);
            List<Hj212C213DeviceMessage> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getCod_value()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            //基本线配置
            EcsMarkLine ecsMarkLine = new EcsMarkLine();
            EcsmplData ecsmplData = new EcsmplData();
            ecsmplData.setName("基准线-COD");
            ecsmplData.setType("line");
            ecsmplData.setyAxis("70");
            List<EcsmplData> ecsmplDataList = new ArrayList<>();
            ecsmplDataList.add(ecsmplData);
            ecsMarkLine.setData(ecsmplDataList);
            parameterData.setMarkLine(ecsMarkLine);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取COD的最小值
    private String getMinCOD(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getCod_value());
            break;
        }
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getCod_value()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getCod_value());
                }
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取COD的最大值
    private String getMaxCOD(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getCod_value()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getCod_value());
                }
            }
        }
        maxValue = maxValue+ 3f;
        if (maxValue < 70f) { //为最大基准线服务
            maxValue = 71f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue,1));
    }
    /********************COD曲线私有函数 结束****************************/

    /********************氨氮曲线私有函数 开始****************************/
    //获取氨氮的曲线
    private List<ParameterData> getNh3nSeries(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-氨氮";
            parameterData.setName(parameterName);
            List<Hj212C213DeviceMessage> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getNh3n_value()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            //基本线配置
            EcsMarkLine ecsMarkLine = new EcsMarkLine();
            EcsmplData ecsmplData = new EcsmplData();
            ecsmplData.setName("基准线-氨氮");
            ecsmplData.setType("line");
            ecsmplData.setyAxis("15");
            List<EcsmplData> ecsmplDataList = new ArrayList<>();
            ecsmplDataList.add(ecsmplData);
            ecsMarkLine.setData(ecsmplDataList);
            parameterData.setMarkLine(ecsMarkLine);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取氨氮的最小值
    private String getMinNh3n(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getNh3n_value());
            break;
        }
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getNh3n_value()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getNh3n_value());
                }
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取氨氮的最大值
    private String getMaxNh3n(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getNh3n_value()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getNh3n_value());
                }
            }
        }
        maxValue = maxValue+ 3f;
        if (maxValue < 15f) { //为最大基准线服务
            maxValue = 16f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue,1));
    }
    /********************氨氮曲线私有函数 结束****************************/

    /********************总磷曲线私有函数 开始****************************/
    //获取总磷的曲线
    private List<ParameterData> getTPSeries(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-总磷";
            parameterData.setName(parameterName);
            List<Hj212C213DeviceMessage> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTp_value()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            //基本线配置
            EcsMarkLine ecsMarkLine = new EcsMarkLine();
            EcsmplData ecsmplData = new EcsmplData();
            ecsmplData.setName("基准线-总磷");
            ecsmplData.setType("line");
            ecsmplData.setyAxis("0.5");
            List<EcsmplData> ecsmplDataList = new ArrayList<>();
            ecsmplDataList.add(ecsmplData);
            ecsMarkLine.setData(ecsmplDataList);
            parameterData.setMarkLine(ecsMarkLine);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取总磷的最小值
    private String getMinTP(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTp_value());
            break;
        }
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTp_value()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTp_value());
                }
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取总磷的最大值
    private String getMaxTP(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getTp_value()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getTp_value());
                }
            }
        }
        maxValue = maxValue+ 0.3f;
        if (maxValue < 0.5f) { //为最大基准线服务
            maxValue = 0.6f;
        }
        return String.valueOf(DataConvertor.formatFloat(maxValue,1));
    }
    /********************总磷曲线私有函数 结束****************************/

    /********************总氮曲线私有函数 开始****************************/
    //获取总氮的曲线
    private List<ParameterData> getTNSeries(Map<String, String> deviceInfoMap, Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (hj212C213MapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-总氮";
            parameterData.setName(parameterName);
            List<Hj212C213DeviceMessage> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTp_value()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            //基本线配置--总氮没有
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取总氮的最小值
    private String getMinTN(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float minValue = 0;
        //取出第一个值，防止默认值0最小
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTn_value());
            break;
        }
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTn_value()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTn_value());
                }
            }
        }
        minValue = minValue - 3f;
        if (minValue < 0) {
            minValue = 0;
        }
        return String.valueOf(minValue);
    }

    //获取总氮的最大值
    private String getMaxTN(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        //遍历map中的值
        float maxValue = 0; //这里不需要取出第一个值
        for (List<Hj212C213DeviceMessage> value : hj212C213MapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getTn_value()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getTn_value());
                }
            }
        }
        maxValue = maxValue+ 0.3f;
        return String.valueOf(DataConvertor.formatFloat(maxValue,1));
    }
    /********************总氮曲线私有函数 结束****************************/
}
