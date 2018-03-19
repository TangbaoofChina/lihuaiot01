package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.AlarmErrorOfflineMapper;
import com.system.mapperiot.DeviceAlarmMapper;
import com.system.mapperiot.DeviceErrorMapper;
import com.system.mapperiot.DeviceOfflineMapper;
import com.system.po.DataTablePageing;
import com.system.po.DeviceAlarmInfo;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.service.DeviceAlarmService;
import com.system.util.EJConvertor;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceAlarmServiceImpl implements DeviceAlarmService {
    @Autowired
    private DeviceAlarmMapper deviceAlarmMapper;
    @Autowired
    private DeviceErrorMapper deviceErrorMapper;
    @Autowired
    private DeviceOfflineMapper deviceOfflineMapper;
    @Autowired
    private AlarmErrorOfflineMapper alarmErrorOfflineMapper;
    @Autowired
    private EJConvertor ejConvertor;

    @Override
    public int selectDeviceRealAlarmCount() throws Exception {
        int realAlarmCount = deviceAlarmMapper.selectDeviceRealAlarmCount();
        int realErrorCount = deviceErrorMapper.selectErrorInfoCount();
        int realOfflineCount = deviceOfflineMapper.selectOfflineInfoCount();
        return realAlarmCount + realErrorCount + realOfflineCount;
    }

    @Override
    public int selectDeviceRealAlarmCountByRoleId(List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        int realAlarmCount = deviceAlarmMapper.selectDeviceRealAlarmCountByRoleId(roleIds);
        int realErrorCount = deviceErrorMapper.selectErrorInfoCountByRoleId(roleIds);
        int realOfflineCount = deviceOfflineMapper.selectOfflineInfoCountByRoleId(roleIds);
        return realAlarmCount + realErrorCount + realOfflineCount;
    }

    @Override
    public List<DeviceAlarmInfo> selectDeviceAlarmInfo() throws Exception {
        /*List<DeviceAlarmInfo> deviceAlarmInfoListAlarm = deviceAlarmMapper.selectAlarmInfo();
        List<DeviceAlarmInfo> deviceAlarmInfoListError = deviceErrorMapper.selectErrorInfo();
        List<DeviceAlarmInfo> deviceAlarmInfoListOffline = deviceOfflineMapper.selectOfflineInfo();
        List<DeviceAlarmInfo> deviceAlarmInfoList = deviceAlarmInfoListAlarm;
        deviceAlarmInfoList.addAll(deviceAlarmInfoListError);
        deviceAlarmInfoList.addAll(deviceAlarmInfoListOffline);*/
        List<DeviceAlarmInfo> deviceAlarmInfoList = alarmErrorOfflineMapper.selectDeviceAlarmInfoList();
        return deviceAlarmInfoList;
    }

    @Override
    public List<DeviceAlarmInfo> selectDeviceAlarmInfoByRoleId(List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        /*List<DeviceAlarmInfo> deviceAlarmInfoListAlarm = deviceAlarmMapper.selectAlarmInfoByRoleId(roleIds);
        List<DeviceAlarmInfo> deviceAlarmInfoListError = deviceErrorMapper.selectErrorInfoByRoleId(roleIds);
        List<DeviceAlarmInfo> deviceAlarmInfoListOffline = deviceOfflineMapper.selectOfflineInfoByRoleId(roleIds);
        List<DeviceAlarmInfo> deviceAlarmInfoList = deviceAlarmInfoListAlarm;
        deviceAlarmInfoList.addAll(deviceAlarmInfoListError);
        deviceAlarmInfoList.addAll(deviceAlarmInfoListOffline);*/
        List<DeviceAlarmInfo> deviceAlarmInfoList = alarmErrorOfflineMapper.selectDeviceAlarmInfoByRoleId(roleIds);
        return deviceAlarmInfoList;
    }

    @Override
    public DataTablePageing selectDeviceHisAlarmInfoAndPaging(Integer pageNumber, Integer pageSize, String alarmType, String sStartDate, String sEndDate) throws Exception {
        List<DeviceAlarmInfo> deviceAlarmInfoList = selectDeviceHisAlarmInfo(alarmType,sStartDate,sEndDate);
        return deviceHisAlarmInfoListPaging(pageNumber, pageSize, deviceAlarmInfoList);
    }

    @Override
    public DataTablePageing selectDeviceHisAlarmInfoByRoleIdAndPaging(Integer pageNumber, Integer pageSize, String alarmType, String sStartDate, String sEndDate, List<RoleInfo> roleInfoList) throws Exception {
        List<DeviceAlarmInfo> deviceAlarmInfoList = selectDeviceHisAlarmInfoByRoleId(alarmType,sStartDate,sEndDate,roleInfoList);
        return deviceHisAlarmInfoListPaging(pageNumber, pageSize, deviceAlarmInfoList);
    }

    @Override
    public List<DeviceAlarmInfo> selectDeviceHisAlarmInfo(String alarmType,String sStartDate, String sEndDate) throws Exception {
        List<DeviceAlarmInfo> deviceAlarmInfoList = new ArrayList<DeviceAlarmInfo>();
        switch (alarmType) {
            case "全部":
                deviceAlarmInfoList = alarmErrorOfflineMapper.selectDeviceHisAlarmInfoList(sStartDate,sEndDate);
                break;
            case "报警":
                deviceAlarmInfoList = deviceAlarmMapper.selectHisAlarmInfoByDate(sStartDate, sEndDate);
                break;
            case "错误":
                deviceAlarmInfoList = deviceErrorMapper.selectHisErrorInfoByDate(sStartDate, sEndDate);
                break;
            case "离线":
                deviceAlarmInfoList = deviceOfflineMapper.selectHisOfflineInfoByDate(sStartDate, sEndDate);
                break;
        }
        return deviceAlarmInfoList;
    }

    @Override
    public List<DeviceAlarmInfo> selectDeviceHisAlarmInfoByRoleId(String alarmType, String sStartDate, String sEndDate, List<RoleInfo> roleInfoList) throws Exception {
        List<DeviceAlarmInfo> deviceAlarmInfoList = new ArrayList<DeviceAlarmInfo>();
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        switch (alarmType) {
            case "全部":
                deviceAlarmInfoList = alarmErrorOfflineMapper.selectDeviceHisAlarmInfoListByRoleId(sStartDate,sEndDate,roleIds);
                break;
            case "报警":
                deviceAlarmInfoList = deviceAlarmMapper.selectHisAlarmInfoByDateAndRoleId(sStartDate, sEndDate, roleIds);
                break;
            case "错误":
                deviceAlarmInfoList = deviceErrorMapper.selectHisErrorInfoByDateAndRoleId(sStartDate, sEndDate, roleIds);
                break;
            case "离线":
                deviceAlarmInfoList = deviceOfflineMapper.selectHisOfflineInfoByDateAndRoleId(sStartDate, sEndDate, roleIds);
                break;
        }
        return deviceAlarmInfoList;
    }

    @Override
    public File exportStorage(List<DeviceAlarmInfo> storageList) throws Exception {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(DeviceAlarmInfo.class, storageList);
    }

    @Override
    public List<MydataTableColumn> selectDeviceAlarmHead() throws Exception {
        DeviceAlarmInfo deviceAlarmInfo = new DeviceAlarmInfo();
        List<MydataTableColumn> mydataTableColumnList = deviceAlarmInfo.getDeviceAlarmHead();
        return mydataTableColumnList;
    }

    private DataTablePageing deviceHisAlarmInfoListPaging(Integer pageNumber, Integer pageSize, List<DeviceAlarmInfo> deviceAlarmInfoList) {
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<DeviceAlarmInfo> deviceAlarmInfoListPaging = new ArrayList<DeviceAlarmInfo>();
        if (deviceAlarmInfoList.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > deviceAlarmInfoList.size())
                bigIndex = deviceAlarmInfoList.size();
            deviceAlarmInfoListPaging.addAll(deviceAlarmInfoList.subList(smallIndex, bigIndex));
        }
        String sReturnJson = JSON.toJSONString(deviceAlarmInfoListPaging);
        dataTablePageing.setTotal(deviceAlarmInfoList.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        return dataTablePageing;
    }
}
