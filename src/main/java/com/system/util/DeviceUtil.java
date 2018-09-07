package com.system.util;

import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceUtil {

    public static final int dOffline111 = 45;
    public static final int dOffline211 = 15;


    public static List<DeviceInfoAndNode> judgeDeviceOnlineState(List<DeviceInfoAndNode> deviceInfoAndNodeList, int offlineMinute) throws Exception {
        for (DeviceInfoAndNode deviceInfoAndNode : deviceInfoAndNodeList
                ) {
            SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String toDate = simpleFormat.format(new Date());
            long from = simpleFormat.parse(deviceInfoAndNode.getDReceiveTime()).getTime();
            long to = simpleFormat.parse(toDate).getTime();
            int minutes = (int) ((to - from) / (1000 * 60));
            if (minutes > offlineMinute)
                deviceInfoAndNode.setDState("离线");
            else
                deviceInfoAndNode.setDState("在线");
        }
        return deviceInfoAndNodeList;
    }

    public static List<DeviceInfoAndNode> splitDeviceByDevType(List<DeviceInfoAndNode> deviceInfoAndNodeList, String devType) {
        List<DeviceInfoAndNode> newDeviceInfoAndNodeList = new ArrayList<>();
        for (DeviceInfoAndNode deviceInfoAndNode : deviceInfoAndNodeList
                ) {
            if (deviceInfoAndNode.getDDevType().equals(devType)) {
                newDeviceInfoAndNodeList.add(deviceInfoAndNode);
            }
        }
        return newDeviceInfoAndNodeList;
    }
}
