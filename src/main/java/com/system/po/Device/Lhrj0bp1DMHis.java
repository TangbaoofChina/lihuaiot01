package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
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
public class Lhrj0bp1DMHis extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;
    //脉冲水表数据
    long water;
    //市电信号
    int ele;

}
