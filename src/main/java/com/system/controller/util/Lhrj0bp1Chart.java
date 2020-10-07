package com.system.controller.util;

import com.system.po.Device.Lhrj0bp1DMHis;
import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.parameter.ParameterData;
import com.system.util.EChartsUtil;
import com.system.util.Lhrj0bp1Util;
import com.system.util.Lhsp05p1Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Lhsp05p1Chart
 * @Description TODO
 * @Author tangbao
 * @Date 2020-06-21 10:26
 * @Version 1.0
 **/
@Controller
public class Lhrj0bp1Chart {
    //生成曲线
    public PhoneEChartsOptions getECharts(String sQueryParam, Map<String, String> deviceInfoMap, Map<String, List<Lhrj0bp1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = null;
        if (sQueryParam.equals("饮水量")) {
            phoneEChartsOptions = this.getTemp01Charts(deviceInfoMap, dmMapByDate);
        }
        return phoneEChartsOptions;
    }

    //生成温度01曲线
    private PhoneEChartsOptions getTemp01Charts(Map<String, String> deviceInfoMap, Map<String, List<Lhrj0bp1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("饮水量(L)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-饮水量(L)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhrj0bp1Util.getDate01List(dmMapByDate);
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

    /********************饮水量曲线私有函数 开始****************************/
    //获取饮水量的曲线
    private List<ParameterData> getTemp01Series(Map<String, String> deviceInfoMap, Map<String, List<Lhrj0bp1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhrj0bp1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-饮水量(L)";
            parameterData.setName(parameterName);
            List<Lhrj0bp1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getWater()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取饮水量的最小值
    private String getMinTemp01(Map<String, List<Lhrj0bp1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 20000;
        //取出第一个值，防止默认值0最小
        for (List<Lhrj0bp1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getWater());
            break;
        }
        for (List<Lhrj0bp1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getWater()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getWater());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取饮水量的最大值
    private String getMaxTemp01(Map<String, List<Lhrj0bp1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhrj0bp1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getWater()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getWater());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************饮水量曲线私有函数 结束****************************/

}
