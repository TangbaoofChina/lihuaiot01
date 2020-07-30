package com.system.util;

import com.system.po.Device.Lhrz01p1DMHis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Lhfh05p1Util
 * @Description TODO
 * @Author tangbao
 * @Date 2020-06-21 10:23
 * @Version 1.0
 **/
public class Lhrz01p1Util {
    //数据库查询的数据，按照设备进行分类
    public static Map<String, List<Lhrz01p1DMHis>> splitMsgByIds(List<Lhrz01p1DMHis> dMList, String[] sDeviceIds) {
        Map<String, List<Lhrz01p1DMHis>> dmMap = new HashMap<>();
        for (String deviceId : sDeviceIds
        ) {
            List<Lhrz01p1DMHis> dmList01 = new ArrayList<>();
            for (Lhrz01p1DMHis msg : dMList
            ) {
                if (msg.getDSerialNum().equals(deviceId)) {
                    dmList01.add(msg);
                }
            }
            dmMap.put(deviceId, dmList01);
        }
        return dmMap;
    }

    //根据设备日期分类，先获取日期list，为温度曲线服务
    public static List<String> getDate01List(Map<String, List<Lhrz01p1DMHis>> dmMapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<Lhrz01p1DMHis>> entry : dmMapByDate.entrySet()) {
            for (Lhrz01p1DMHis dm : entry.getValue()
            ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(dm.getSendDate())) {
                    sDateList.add(dm.getSendDate());
                }
            }
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //日期排序 yy-MM-dd
    public static List<String> dateSort02(List<String> sDateList){
        List<String> newDateList = new ArrayList<String>();
        for (int i = 0; i < sDateList.size(); i++) {
            if (!newDateList.contains(sDateList.get(i))) {
                newDateList.add(sDateList.get(i));
            }
        }
        String tmp;
        for (int i = 1; i < newDateList.size(); i++) {
            tmp = newDateList.get(i);
            int j = i - 1;
            for (; j >= 0 && (DataConvertor.DateCompare02(tmp, newDateList.get(j)) < 0); j--) {
                newDateList.set(j + 1, newDateList.get(j));
            }
            newDateList.set(j + 1, tmp);
        }
        return newDateList;
    }
}
