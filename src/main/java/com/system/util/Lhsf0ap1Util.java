package com.system.util;

import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.Device.Lhsf0ap1DMHis;

import java.util.List;

/**
 * @ClassName Lhsf0ap1Util
 * @Description TODO
 * @Author tangbao
 * @Date 2020-06-22 15:20
 * @Version 1.0
 **/
public class Lhsf0ap1Util {
    public  static String getEventDescribe(String event){
        String describe = "";
        switch (event){
            case "00":
                describe = "空";
                break;
            case "01":
                describe = "薰蒸脏区开门";
                break;
            case "02":
                describe = "薰蒸开始";
                break;
            case "03":
                describe = "薰蒸结束";
                break;
            case "04":
                describe = "薰蒸净区开门";
                break;
            case "05":
                describe = "疫苗脏区开门";
                break;
            case "06":
                describe = "疫苗静置开始";
                break;
            case "07":
                describe = "疫苗静置结束";
                break;
            case "08":
                describe = "疫苗净区开门";
                break;
            case "09":
                describe = "净区物资开门";
                break;
            case "0A":
                describe = "脏区物资开门";
                break;
            case "0B":
                describe = "脏区端报警";
                break;
            case "0C":
                describe = "灰区报警";
                break;
            case "0D":
                describe = "净区报警";
                break;
            case "20":
                describe = "断电报警";
                break;
        }
        return describe;
    }

    //有一个事件描述属性，防止意外没有生成事件描述内容，设定以下这个方法，
    // 目前测试都有事件描述，该方法暂时屏蔽
//    public static void formatDescribeHis(List<Lhsf0ap1DMHis> dmList){
//        if(dmList == null){
//            return;
//        }
//        for(int i=0;i< dmList.size();i++){
//            Lhsf0ap1DMHis dm = dmList.get(i);
//            dm.setDescribe("");
//        }
//    }
}
