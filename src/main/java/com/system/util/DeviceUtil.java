package com.system.util;

import com.system.po.DeviceInfo;
import com.system.po.DeviceInfoAndNode;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.PhoneTree;
import com.system.po.parameter.DeviceType;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceUtil {

    public static final int defaultOffline = 30; //默认设备离线时间

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

    /**
     * 根据设备编号区分出新的设备列表
     * @param deviceInfoAndNodeList
     * @param devType
     * @return
     */
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

    //根据设备类型表，获取设备类型编码列表
    public static List<String> getDeviceTypeNum(List<DeviceType> deviceTypeList) {
        List<String> devTypeNumList = new ArrayList<>();
        for (int i = 0; i < deviceTypeList.size(); i++) {
            if (!deviceTypeList.contains(deviceTypeList.get(i).getDevType())) {
                devTypeNumList.add(deviceTypeList.get(i).getDevType());
            }
        }
        return devTypeNumList;
    }

    public static  List<PhoneTree> getPhoneTreeList(List<ORGTreeNode> orgTreeNodeList){
        List<PhoneTree> phoneTreeList = new ArrayList<>();
        for (ORGTreeNode orgTreeNode: orgTreeNodeList
             ) {
            PhoneTree phoneTree = new PhoneTree(orgTreeNode);
            phoneTreeList.add(phoneTree);
        }
        return phoneTreeList;
    }
}
