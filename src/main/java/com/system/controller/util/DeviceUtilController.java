package com.system.controller.util;

import com.system.po.DeviceInfo;
import com.system.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceUtilController {
    @Autowired
    private DeviceInfoService deviceInfoService;

    public List<DeviceInfo> getDeviceInfoList(String[] sDeviceIds) throws Exception {
        //为了防止排序
        //日温饮水 排序，先取出第一个设备的信息，再取出后续的设备的信息
        List<DeviceInfo> deviceInfoList = new ArrayList<>();
        if (sDeviceIds.length < 1) {
            return deviceInfoList;
        }
        String[] sDeviceIdsFirst = new String[1];
        sDeviceIdsFirst[0] = sDeviceIds[0];
        List<DeviceInfo> deviceInfoListFirst = deviceInfoService.selectDeviceInfoByIDs(sDeviceIdsFirst);
        deviceInfoList.addAll(deviceInfoListFirst);
        if (sDeviceIds.length > 1) {
            List<String> sDeviceIdsSecond = new ArrayList<>();
            for (int i = 1; i < sDeviceIds.length; i++) {
                sDeviceIdsSecond.add(sDeviceIds[i]);
            }
            List<DeviceInfo> deviceInfoListSecond = deviceInfoService.selectDeviceInfoByIDs(sDeviceIdsSecond.toArray(new String[sDeviceIdsSecond.size()]));

            deviceInfoList.addAll(deviceInfoListSecond);
        }
        return deviceInfoList;
    }

    //根据设备列表，生成设备的MAP，为曲线的图例服务，显示设备名称(设备序号，设备名称)
    public Map<String, String> getDeviceInfoMap(List<DeviceInfo> deviceInfoList) {
        Map<String, String> deviceInfoMap = new HashMap<>();
        for (int i = 0; i < deviceInfoList.size(); i++) {
            deviceInfoMap.put(deviceInfoList.get(i).getDSerialNum(), deviceInfoList.get(i).getDName());
        }
        return deviceInfoMap;
    }
}
