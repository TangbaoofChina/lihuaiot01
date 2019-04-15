package com.system.util;

import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.Hj212C213.Hj212C213DayData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hj212C213Util {
    //根据设备日期分类，先获取日期list，为流量曲线/pH曲线服务
    public static List<String> getHj212C213Date01List(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            for (Hj212C213DeviceMessage hj212C213DM : entry.getValue()
                    ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(hj212C213DM.getDatatime())) {
                    sDateList.add(hj212C213DM.getDatatime());
                }
            }
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //根据设备日期分类，先获取日期list，为COD曲线服务
    public static List<String> getHj212C213DateCODList(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            for (Hj212C213DeviceMessage hj212C213DM : entry.getValue()
                    ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(hj212C213DM.getCod_sampletime())) {
                    sDateList.add(hj212C213DM.getCod_sampletime());
                }
            }
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //根据设备日期分类，先获取日期list，为氨氮曲线服务
    public static List<String> getHj212C213DateNh3nList(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            for (Hj212C213DeviceMessage hj212C213DM : entry.getValue()
                    ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(hj212C213DM.getNh3n_sampletime())) {
                    sDateList.add(hj212C213DM.getNh3n_sampletime());
                }
            }
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //根据设备日期分类，先获取日期list，为总磷曲线服务
    public static List<String> getHj212C213DateTPList(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            for (Hj212C213DeviceMessage hj212C213DM : entry.getValue()
                    ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(hj212C213DM.getTp_sampletime())) {
                    sDateList.add(hj212C213DM.getTp_sampletime());
                }
            }
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //根据设备日期分类，先获取日期list，为总氮曲线服务
    public static List<String> getHj212C213DateTNList(Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213MapByDate.entrySet()) {
            for (Hj212C213DeviceMessage hj212C213DM : entry.getValue()
                    ) {
                //需要遍历所有设备的所有日期，防止有遗漏
                if (!sDateList.contains(hj212C213DM.getTn_sampletime())) {
                    sDateList.add(hj212C213DM.getTn_sampletime());
                }
            }
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //数据库查询的数据，按照设备进行分类
    public static Map<String, List<Hj212C213DeviceMessage>> splitMsgByIds(List<Hj212C213DeviceMessage> dMList, String[] sDeviceIds) {
        Map<String, List<Hj212C213DeviceMessage>> hj212C213Map = new HashMap<>();
        for (String deviceId : sDeviceIds
                ) {
            List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = new ArrayList<>();
            for (Hj212C213DeviceMessage msg : dMList
                    ) {
                if (msg.getDSerialNum().equals(deviceId)) {
                    hj212C213DeviceMessageList.add(msg);
                }
            }
            hj212C213Map.put(deviceId, hj212C213DeviceMessageList);
        }
        return hj212C213Map;
    }

    //根据日期（datatime）进行分类
    public static Map<String, List<Hj212C213DeviceMessage>> splitHj212C213DMByDate(List<Hj212C213DeviceMessage> hj212C213DMList) {
        Map<String,List<Hj212C213DeviceMessage>> hj212C213DMMap = new HashMap<>();
        List<String> dataTimeList = new ArrayList<>();
        for (Hj212C213DeviceMessage hj212C213DM:hj212C213DMList
             ) {
            String sDataTime = hj212C213DM.getDatatime().substring(0,8);
            if(dataTimeList.contains(sDataTime))
                continue;
            dataTimeList.add(sDataTime);
        }
        //这里需要对日期进行排序
        List<String> newDateList = dateSort02(dataTimeList);
        for (String sDataTime:newDateList
             ) {
            List<Hj212C213DeviceMessage> hj212C213DeviceMessages = new ArrayList<>();
            for(int i=0;i<hj212C213DMList.size();i++)
            {
                String sDataTime01 = hj212C213DMList.get(i).getDatatime().substring(0,8);
                if(sDataTime.equals(sDataTime01))
                    hj212C213DeviceMessages.add(hj212C213DMList.get(i));
            }
            if(hj212C213DeviceMessages.size() >0)
                hj212C213DMMap.put(sDataTime,hj212C213DeviceMessages);
        }
        return hj212C213DMMap;
    }

    //根据日期分类，获取日期list，为双曲线服务
    public static List<String> getHj212C213DayDate(Map<String, Hj212C213DayData> hj212C213DayDataMap) {
        List<String> sDateList = new ArrayList<>();
        for (Map.Entry<String, Hj212C213DayData> entry : hj212C213DayDataMap.entrySet()) {
            sDateList.add(entry.getKey());
        }
        List<String> newDateList = dateSort02(sDateList);
        return newDateList;
    }

    //日期排序 yyyy-MM-dd
    public static List<String> dateSort01(List<String> sDateList){
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
            for (; j >= 0 && (DataConvertor.DateCompare(tmp, newDateList.get(j)) < 0); j--) {
                newDateList.set(j + 1, newDateList.get(j));
            }
            newDateList.set(j + 1, tmp);
        }
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
