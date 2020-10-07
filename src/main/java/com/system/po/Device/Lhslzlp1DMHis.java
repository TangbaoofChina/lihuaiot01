package com.system.po.Device;

import lombok.Data;

/**
 * @ClassName Lhty02p1DM
 * @Description 立华断电报警器
 * @Author tangbao
 * @Date 2020-05-19 14:43
 * @Version 1.0
 **/
@Data
public class Lhslzlp1DMHis extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //喂料器频率
    float frequency;
    //蒸汽阀开度
    float opening;
    //调制器温度
    float temp;
    //主机总电流
    float eleCurrent;
    //蒸汽压力
    float pressure;
    //ETC1
    float etc01;
    //ETC2
    float etc02;

}
