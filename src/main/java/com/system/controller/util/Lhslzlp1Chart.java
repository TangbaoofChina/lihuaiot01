package com.system.controller.util;

import com.system.po.Device.Lhslzlp1DMHis;
import com.system.po.EChartsOptions.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.parameter.ParameterData;
import com.system.util.EChartsUtil;
import com.system.util.Lhslzlp1Util;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Lhslzlp1Chart
 * @Description TODO
 * @Author tangbao
 * @Date 2020-06-21 10:26
 * @Version 1.0
 **/
@Controller
public class Lhslzlp1Chart {
    //生成曲线
    public PhoneEChartsOptions getECharts(String sQueryParam, Map<String, String> deviceInfoMap, Map<String, List<Lhslzlp1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = null;
        if (sQueryParam.equals("调制器温度")) {
            phoneEChartsOptions = this.getTemp01Charts(deviceInfoMap, dmMapByDate);
        }
        return phoneEChartsOptions;
    }

    //生成温度01曲线
    private PhoneEChartsOptions getTemp01Charts(Map<String, String> deviceInfoMap, Map<String, List<Lhslzlp1DMHis>> dmMapByDate) {
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        phoneEChartsOptions.setColor(EChartsUtil.Color());

        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("调制器温度(℃)");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        //添加图例
        EChartsLegend eChartsLegend = new EChartsLegend();
        List<String> legendDataList = new ArrayList<>();
        for (String key : dmMapByDate.keySet()) {
            String legendName = deviceInfoMap.get(key) + "-调制器温度(℃)";
            if (!legendDataList.contains(legendName)) {
                legendDataList.add(legendName);
            }
        }
        eChartsLegend.setData(legendDataList);
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);
        //X轴坐标
        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        List<String> sDateList = Lhslzlp1Util.getDate01List(dmMapByDate);
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

    /********************调制器温度(℃)曲线私有函数 开始****************************/
    //获取XXX的曲线
    private List<ParameterData> getTemp01Series(Map<String, String> deviceInfoMap, Map<String, List<Lhslzlp1DMHis>> dmMapByDate) {
        List<ParameterData> parameterDataList = new ArrayList<>();
        if (dmMapByDate.size() < 1) {
            return parameterDataList;
        }
        for (Map.Entry<String, List<Lhslzlp1DMHis>> entry : dmMapByDate.entrySet()) {
            ParameterData parameterData = new ParameterData();
            String parameterName = deviceInfoMap.get(entry.getKey()) + "-调制器温度(℃)";
            parameterData.setName(parameterName);
            List<Lhslzlp1DMHis> value = entry.getValue();
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < value.size(); i++) {
                dataList.add(String.valueOf(value.get(i).getTemp()));
            }
            parameterData.setData(dataList);
            parameterData.setType("line");
            parameterData.setShowAllSymbol(false);
            parameterDataList.add(parameterData);
        }
        return parameterDataList;
    }

    //获取xxx的最小值
    private String getMinTemp01(Map<String, List<Lhslzlp1DMHis>> dmMapByDate) {
        //遍历map中的值
        float minValue = 20000;
        //取出第一个值，防止默认值0最小
        for (List<Lhslzlp1DMHis> value : dmMapByDate.values()) {
            minValue = Float.valueOf( value.get(0).getTemp());
            break;
        }
        for (List<Lhslzlp1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf(value.get(i).getTemp()) < minValue) {
                    minValue = Float.valueOf(value.get(i).getTemp());
                }
            }
        }
        minValue = minValue - 3;
//        if (minValue < 0) {
//            minValue = 0;
//        }
        return String.valueOf(minValue);
    }

    //获取xxx的最大值
    private String getMaxTemp01(Map<String, List<Lhslzlp1DMHis>> dmMapByDate) {
        //遍历map中的值
        float maxValue = -100; //这里不需要取出第一个值
        for (List<Lhslzlp1DMHis> value : dmMapByDate.values()) {
            for (int i = 0; i < value.size(); i++) {
                if (Float.valueOf( value.get(i).getTemp()) > maxValue) {
                    maxValue = Float.valueOf( value.get(i).getTemp());
                }
            }
        }
        maxValue = maxValue+3f;
        return String.valueOf(maxValue);
    }
    /********************饮水量曲线私有函数 结束****************************/

}
