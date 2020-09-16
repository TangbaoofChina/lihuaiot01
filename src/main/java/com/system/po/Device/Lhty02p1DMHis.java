package com.system.po.Device;

import com.system.po.MydataTableColumn;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lhty02p1DM
 * @Description 立华断电报警器
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
@Data
public class Lhty02p1DMHis extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //温度A
    Float tempA;
    //湿度A
    Float humiA;
    //温度B
    Float tempB;
    //湿度B
    Float humiB;
    //电压A
    int volA;
    //电压B
    int volB;
    //电压C
    int volC;
    //高温报警
    int high;
    //低温报警
    int low;
    //缺相报警
    int lack;
    //偏相报警
    int unbalance;
    //烟感报警
    int smoke;
    //断电报警
    int cutOut;
    //自测报警
    int test;
    //总报警状态
    int total;

}
