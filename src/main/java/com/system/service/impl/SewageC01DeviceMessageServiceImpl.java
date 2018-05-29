package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.DeviceInfoMapper;
import com.system.mapperiot.SewageC01DeviceMessageMapper;
import com.system.po.*;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC01DeviceMessage;
import com.system.service.SewageC01DeviceMessageService;
import com.system.util.EJConvertor;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SewageC01DeviceMessageServiceImpl implements SewageC01DeviceMessageService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Autowired
    private SewageC01DeviceMessageMapper sewageC01DeviceMessageMapper;
    @Autowired
    private EJConvertor ejConvertor;

    @Override
    public List<SewageC01DeviceMessage> selectSewageC01ByORGId(String ORGId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = sewageC01DeviceMessageMapper.selectSewageC01ByORGId(ORGId);
        sewageC01DeviceMessageList = judgeDeviceOnlineState(sewageC01DeviceMessageList);
        return sewageC01DeviceMessageList;
    }

    @Override
    public List<SewageC01DeviceMessage> selectSewageC01ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = sewageC01DeviceMessageMapper.selectSewageC01ByORGIdAndRoleId(ORGId,roleIds);
        sewageC01DeviceMessageList = judgeDeviceOnlineState(sewageC01DeviceMessageList);
        return sewageC01DeviceMessageList;
    }

    @Override
    public SewageC01DeviceMessage selectSewageC01ByDeviceId(String sDeviceId) throws Exception {
        SewageC01DeviceMessage sewageC01DeviceMessage = sewageC01DeviceMessageMapper.selectSewageC01ByDeviceId(sDeviceId);
        judgeOneDeviceOnlineState(sewageC01DeviceMessage);
        return sewageC01DeviceMessage;
    }

    @Override
    public List<MydataTableColumn> selectSewageC01DeviceHead() throws Exception {
        SewageC01DeviceMessage sewageC01DeviceMessage = new SewageC01DeviceMessage();
        List<MydataTableColumn> mydataTableColumnList = sewageC01DeviceMessage.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public List<SewageC01DeviceMessage> selectSewageC01ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return sewageC01DeviceMessageMapper.selectSewageC01ByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
    }

    @Override
    public DataTablePageing selectSewageC01ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = new ArrayList<SewageC01DeviceMessage>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<SewageC01DeviceMessage> ewagec01DeviceMessageListAll = sewageC01DeviceMessageMapper.selectSewageC01ByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
        if (ewagec01DeviceMessageListAll.size() > 0)
        {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber-1;
            bigIndex = smallIndex + pageSize;
            if(bigIndex > ewagec01DeviceMessageListAll.size())
                bigIndex = ewagec01DeviceMessageListAll.size();
            sewageC01DeviceMessageList.addAll(ewagec01DeviceMessageListAll.subList(smallIndex,bigIndex));
        }
        String str= JSON.toJSON(sewageC01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(sewageC01DeviceMessageList);
        dataTablePageing.setTotal(ewagec01DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    @Override
    public DataTablePageing selectHisSewageC01ByDateAndIDsAndPage(Integer pageNumber, Integer pageSize, List<DeviceInfo> deviceInfoList, String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        return null;
    }

    @Override
    public File exportStorage(List<SewageC01DeviceMessage> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(SewageC01DeviceMessage.class, storageList);
    }

    @Override
    public List<SewageC01DMHis> selectPhoneHisSewageC01ByDateAndId(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return sewageC01DeviceMessageMapper.selectPhoneHisSewageC01ByDateAndId(sDeviceId,sStartDate,sEndDate);
    }

    //************************************私有函数********************************************//
    private List<SewageC01DeviceMessage> judgeDeviceOnlineState(List<SewageC01DeviceMessage> sewageC01DeviceMessageList) throws Exception
    {
        for (BaseDeviceMessage baseDeviceMessage:sewageC01DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage);
        }
        return sewageC01DeviceMessageList;
    }

    private void judgeOneDeviceOnlineState(BaseDeviceMessage baseDeviceMessage) throws Exception
    {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDate = simpleFormat.format(new Date());
        long from =  simpleFormat.parse(baseDeviceMessage.getDReceiveTime()).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes > 15)
            baseDeviceMessage.setDState("离线");
        else
            baseDeviceMessage.setDState("在线");
    }
}
