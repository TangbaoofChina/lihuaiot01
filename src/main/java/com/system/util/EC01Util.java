package com.system.util;

import com.system.po.Device.EC01DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.EC01.EC01DayAvgTemp;
import com.system.po.EC01.EC01DeviceDayAvgTemp;
import com.system.po.MydataTableColumn;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EC01Util {
    /**
     * 获取时间序列-EC01设备
     *
     * @param deviceMessageList
     * @return
     */
    public static List<String> getParameterTime(List<EC01DeviceMessage> deviceMessageList) {
        List<String> deviceParameterTime = new ArrayList<String>();
        //时间序列生成
        for (EC01DeviceMessage deviceMessage : deviceMessageList
                ) {
            deviceParameterTime.add(deviceMessage.getSendDate());
        }
        return deviceParameterTime;
    }

    public static List<String> getParameterDate(List<EC01DeviceMessage> deviceMessageList) {
        List<String> deviceDateList = new ArrayList<String>();
        //日期序列生成
        for (EC01DeviceMessage deviceMessage : deviceMessageList
                ) {
            if (deviceDateList.contains(deviceMessage.getSendDate().substring(0, 10))) {
                continue;
            } else {
                deviceDateList.add(deviceMessage.getSendDate().substring(0, 10));
            }
        }
        List<String> newDeviceDateList = new ArrayList<String>();
        for (int i = 0; i < deviceDateList.size(); i++) {
            if (!newDeviceDateList.contains(deviceDateList.get(i))) {
                newDeviceDateList.add(deviceDateList.get(i));
            }
        }
        String tmp;
        for (int i = 1; i < newDeviceDateList.size(); i++) {
            tmp = newDeviceDateList.get(i);
            int j = i - 1;
            for (; j >= 0 && (DataConvertor.DateCompare(tmp, newDeviceDateList.get(j)) < 0); j--) {
                newDeviceDateList.set(j + 1, newDeviceDateList.get(j));
            }
            newDeviceDateList.set(j + 1, tmp);
        }
        return newDeviceDateList;
    }

    public static String[] SortByDate(String[] sDateTimeList) {
        List<String> newDateTimeList = new ArrayList<String>();
        for (int i = 0; i < sDateTimeList.length; i++) {
            if (!newDateTimeList.contains(sDateTimeList[i])) {
                newDateTimeList.add(sDateTimeList[i]);
            }
        }
        String tmp;
        for (int i = 1; i < newDateTimeList.size(); i++) {
            tmp = newDateTimeList.get(i);
            int j = i - 1;
            for (; j >= 0 && (DataConvertor.DateCompare(tmp, newDateTimeList.get(j)) < 0); j--) {
                newDateTimeList.set(j + 1, newDateTimeList.get(j));
            }
            newDateTimeList.set(j + 1, tmp);
        }
        String[] newDataTimeArray = newDateTimeList.toArray(new String[newDateTimeList.size()]);
        return newDataTimeArray;
    }

    /**
     * 获取短时间序列-EC01设备
     *
     * @param
     * @return
     */
    public static List<String> getParameterTime(Map<String, List<EC01DeviceMessage>> deviceMsgListMap) {
        List<String> deviceParameterTime = new ArrayList<String>();
        List<String> newDeviceParameterTime = new ArrayList<String>();
        //时间序列生成
        for (Map.Entry<String, List<EC01DeviceMessage>> entry : deviceMsgListMap.entrySet()) {
            List<EC01DeviceMessage> ec01DeviceMessageList = entry.getValue();
            for (EC01DeviceMessage ec01DeviceMsg : ec01DeviceMessageList
                    ) {
                String sDataTime = ec01DeviceMsg.getSendDate().substring(11, 19);
                if (!deviceParameterTime.contains(sDataTime)) {
                    deviceParameterTime.add(sDataTime);
                }
            }
        }
        for (int i = 0; i < deviceParameterTime.size(); i++) {
            if (!newDeviceParameterTime.contains(deviceParameterTime.get(i))) {
                newDeviceParameterTime.add(deviceParameterTime.get(i));
            }
        }
        String tmp;
        for (int i = 1; i < newDeviceParameterTime.size(); i++) {
            tmp = newDeviceParameterTime.get(i);
            int j = i - 1;
            for (; j >= 0 && (TimeCompare(tmp, newDeviceParameterTime.get(j)) < 0); j--) {
                newDeviceParameterTime.set(j + 1, newDeviceParameterTime.get(j));
            }
            newDeviceParameterTime.set(j + 1, tmp);
        }
        return newDeviceParameterTime;
    }

    public static long TimeCompare(String s1, String s2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date d1 = sdf.parse(s1);
            Date d2 = sdf.parse(s2);
            return (d1.getTime() - d2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取时间序列-EC01中的日平均温度时间
     *
     * @param ec01DeviceDayAvgTemp
     * @return
     */
    public static List<String> getParameterTime(EC01DeviceDayAvgTemp ec01DeviceDayAvgTemp) {
        List<String> deviceParameterTime = new ArrayList<String>();
        //时间序列生成
        for (EC01DayAvgTemp ec01DayAvgTemp : ec01DeviceDayAvgTemp.getEc01DayAvgTempList()
                ) {
            deviceParameterTime.add(ec01DayAvgTemp.getSendDate());
        }
        return deviceParameterTime;
    }

    public static List<MydataTableColumn> getEC01DeviceHead(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        if (deviceInfoList.size() > 0) {
            for (DeviceInfo deviceInfo : deviceInfoList
                    ) {
                MydataTableColumn mdtc = new MydataTableColumn();
                mdtc.setData(deviceInfo.getDName());
                mdtc.setTitle(deviceInfo.getDName());
                myDTCList.add(mdtc);
            }
        }

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sSendTime");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("发送时间");

        myDTCList.add(mdtcTime);
        return myDTCList;
    }

    public static List<MydataTableColumn> getEC01DeviceHeadByTempWater(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        if (deviceInfoList.size() > 0) {
            for (int i = 0; i < deviceInfoList.size(); i++) {
                if (i == 0) {
                    MydataTableColumn mdtc = new MydataTableColumn();
                    mdtc.setData(deviceInfoList.get(i).getDName() + "-日温");
                    mdtc.setTitle(deviceInfoList.get(i).getDName() + "-日温");
                    myDTCList.add(mdtc);
                }
                MydataTableColumn mdtc = new MydataTableColumn();
                mdtc.setData(deviceInfoList.get(i).getDName() + "-饮水");
                mdtc.setTitle(deviceInfoList.get(i).getDName() + "-饮水");
                myDTCList.add(mdtc);
            }
        }

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sSendTime");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("发送时间");

        myDTCList.add(mdtcTime);
        return myDTCList;
    }

    public static List<MydataTableColumn> getEC01DeviceHeadByIdsWater(List<DeviceInfo> deviceInfoList) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc = new MydataTableColumn();
        mdtc.setData("多舍日饮水量");
        mdtc.setTitle("多舍日饮水量");
        myDTCList.add(mdtc);

        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sSendTime");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("发送时间");

        myDTCList.add(mdtcTime);
        return myDTCList;
    }

    public static List<MydataTableColumn> getEC01DeviceHeadByDataTime(DeviceInfo deviceInfo, String[] sDateTimeList) {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        for (int i = 0; i < sDateTimeList.length; i++) {
            MydataTableColumn mdtc = new MydataTableColumn();
            mdtc.setData(deviceInfo.getDName() + "-" + sDateTimeList[i]);
            mdtc.setTitle(deviceInfo.getDName() + "-" + sDateTimeList[i]);
            myDTCList.add(mdtc);
        }
        MydataTableColumn mdtcTime = new MydataTableColumn();
        mdtcTime.setData("sSendTime");
        mdtcTime.setDefaultContent("时间");
        mdtcTime.setTitle("发送时间");

        myDTCList.add(mdtcTime);
        return myDTCList;
    }

    public static List<MydataTableColumn> getMyDataTableColumn(String sQueryParam,List<DeviceInfo> deviceInfoList,
                                                                 String[] sDateTimeList) throws Exception{
        List<MydataTableColumn> myDTCList = new ArrayList<>();
        if ((sQueryParam == null) || (sQueryParam.isEmpty())) {
            myDTCList = EC01Util.getEC01DeviceHead(deviceInfoList);
        } else if (sQueryParam.equals("日温饮水")) {
            myDTCList = EC01Util.getEC01DeviceHeadByTempWater(deviceInfoList);
        } else if (sQueryParam.equals("多舍日饮水量")) {
            myDTCList = EC01Util.getEC01DeviceHeadByIdsWater(deviceInfoList);
        }else if (sQueryParam.equals("单舍饮水量")) {
            myDTCList = EC01Util.getEC01DeviceHeadByDataTime(deviceInfoList.get(0), sDateTimeList);
        } else if (sQueryParam.equals("单舍温度")) {
            myDTCList = EC01Util.getEC01DeviceHeadByDataTime(deviceInfoList.get(0), sDateTimeList);
        }
        else {
            myDTCList = EC01Util.getEC01DeviceHead(deviceInfoList);
        }
        return myDTCList;
    }

}
