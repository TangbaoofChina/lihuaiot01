package com.system.controller.util;

import com.system.po.Device.Lhrz01p1DMHis;
import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.parameter.ParameterData;
import com.system.util.EChartsUtil;
import com.system.util.Lhrz01p1Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Lhrz01p1Chart
 * @Description TODO
 * @Author tangbao
 * @Date 2020-07-30 16:09
 * @Version 1.0
 **/
@Controller
public class Lhrz01p1Chart {
    //生成曲线
    public PhoneEChartsOptions getECharts(String sQueryParam, Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = null;
        if (sQueryParam.equals("温度01")) {
            phoneEChartsOptions = this.getTemp01(deviceInfoMap, dmMapByDate);
        }else if (sQueryParam.equals("温度02")) {
            phoneEChartsOptions = this.getTemp02(deviceInfoMap, dmMapByDate);
        }else if (sQueryParam.equals("温度03")) {
            phoneEChartsOptions = this.getTemp03(deviceInfoMap, dmMapByDate);
        } else if (sQueryParam.equals("当前温度")) {
            phoneEChartsOptions = this.getNowTemp(deviceInfoMap, dmMapByDate);
        }else if (sQueryParam.equals("目标温度")) {
            phoneEChartsOptions = this.getTargetTemp(deviceInfoMap, dmMapByDate);
        }else if (sQueryParam.equals("舍外温度")) {
            phoneEChartsOptions = this.getOutTemp(deviceInfoMap, dmMapByDate);
        }
        return phoneEChartsOptions;
    }

    //生成温度01曲线
    private PhoneEChartsOptions getTemp01(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("温度01(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-温度01(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrz01p1Util.getDate01List(dmMapByDate);
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
        if (dmMapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinTemp01(dmMapByDate));
            eChartsYAxis.setMax(this.getMaxTemp01(dmMapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTemp01Series(deviceInfoMap, dmMapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //生成温度02曲线
    private PhoneEChartsOptions getTemp02(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("温度02(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-温度02(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrz01p1Util.getDate01List(dmMapByDate);
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
        if (dmMapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinTemp02(dmMapByDate));
            eChartsYAxis.setMax(this.getMaxTemp02(dmMapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTemp02Series(deviceInfoMap, dmMapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //生成温度03曲线
    private PhoneEChartsOptions getTemp03(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("温度03(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-温度03(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrz01p1Util.getDate01List(dmMapByDate);
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
        if (dmMapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinTemp03(dmMapByDate));
            eChartsYAxis.setMax(this.getMaxTemp03(dmMapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTemp03Series(deviceInfoMap, dmMapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //生成当前温度曲线
    private PhoneEChartsOptions getNowTemp(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("当前温度(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-当前温度(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrz01p1Util.getDate01List(dmMapByDate);
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
        if (dmMapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinNowTemp(dmMapByDate));
            eChartsYAxis.setMax(this.getMaxNowTemp(dmMapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getNowTempSeries(deviceInfoMap, dmMapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //生成目标温度曲线
    private PhoneEChartsOptions getTargetTemp(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("目标温度(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-目标温度(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrz01p1Util.getDate01List(dmMapByDate);
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
        if (dmMapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinTargetTemp(dmMapByDate));
            eChartsYAxis.setMax(this.getMaxTargetTemp(dmMapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getTargetTempSeries(deviceInfoMap, dmMapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    //生成舍外温度曲线
    private PhoneEChartsOptions getOutTemp(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("舍外温度(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-舍外温度(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrz01p1Util.getDate01List(dmMapByDate);
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
        if (dmMapByDate.size() > 0) {
            eChartsYAxis.setMin(this.getMinOutTemp(dmMapByDate));
            eChartsYAxis.setMax(this.getMaxOutTemp(dmMapByDate));
        }
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(this.getOutTempSeries(deviceInfoMap, dmMapByDate));
        phoneEChartsOptions.showPoint(true, true);
        return phoneEChartsOptions;
    }

    /********************温度01曲线私有函数 开始****************************/
    //获取温度的曲线
    private List<ParameterData> getTemp01Series(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-温度01(℃)";
            parameterData.setName(parameterName);
            List<Lhrz01p1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTemp01()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取温度的最小值
    private String getMinTemp01(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 100;
        //取出第一个值，防止默认值0最小
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTemp01());
            break;
        }
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTemp01()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTemp01());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取温度的最大值
    private String getMaxTemp01(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getTemp01()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getTemp01());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************温度01曲线私有函数 结束****************************/

    /********************温度02曲线私有函数 开始****************************/
    //获取温度的曲线
    private List<ParameterData> getTemp02Series(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-温度02(℃)";
            parameterData.setName(parameterName);
            List<Lhrz01p1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTemp02()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取温度的最小值
    private String getMinTemp02(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 100;
        //取出第一个值，防止默认值0最小
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTemp02());
            break;
        }
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTemp02()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTemp02());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取温度的最大值
    private String getMaxTemp02(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getTemp02()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getTemp02());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************温度02曲线私有函数 结束****************************/

    /********************温度03曲线私有函数 开始****************************/
    //获取温度的曲线
    private List<ParameterData> getTemp03Series(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-温度03(℃)";
            parameterData.setName(parameterName);
            List<Lhrz01p1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTemp03()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取温度的最小值
    private String getMinTemp03(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 100;
        //取出第一个值，防止默认值0最小
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTemp03());
            break;
        }
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTemp03()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTemp03());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取温度的最大值
    private String getMaxTemp03(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getTemp03()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getTemp03());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************温度03曲线私有函数 结束****************************/

    /********************当前温度曲线私有函数 开始****************************/
    //获取温度的曲线
    private List<ParameterData> getNowTempSeries(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-当前温度(℃)";
            parameterData.setName(parameterName);
            List<Lhrz01p1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getNowTemp()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取温度的最小值
    private String getMinNowTemp(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 100;
        //取出第一个值，防止默认值0最小
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getNowTemp());
            break;
        }
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getNowTemp()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getNowTemp());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取温度的最大值
    private String getMaxNowTemp(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getNowTemp()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getNowTemp());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************当前温度曲线私有函数 结束****************************/

    /********************目标温度曲线私有函数 开始****************************/
    //获取温度的曲线
    private List<ParameterData> getTargetTempSeries(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-目标温度(℃)";
            parameterData.setName(parameterName);
            List<Lhrz01p1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTargetTemp()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取温度的最小值
    private String getMinTargetTemp(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 100;
        //取出第一个值，防止默认值0最小
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTargetTemp());
            break;
        }
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTargetTemp()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTargetTemp());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取温度的最大值
    private String getMaxTargetTemp(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getNowTemp()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getNowTemp());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************目标温度曲线私有函数 结束****************************/

    /********************舍外温度曲线私有函数 开始****************************/
    //获取温度的曲线
    private List<ParameterData> getOutTempSeries(Map<String, String> deviceInfoMap, Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-舍外温度(℃)";
            parameterData.setName(parameterName);
            List<Lhrz01p1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getOutTemp()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取温度的最小值
    private String getMinOutTemp(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 100;
        //取出第一个值，防止默认值0最小
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getOutTemp());
            break;
        }
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getOutTemp()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getOutTemp());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取温度的最大值
    private String getMaxOutTemp(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrz01p1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getOutTemp()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getOutTemp());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************目标温度曲线私有函数 结束****************************/
}
