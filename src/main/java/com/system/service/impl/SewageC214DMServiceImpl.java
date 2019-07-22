package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.SewageC214DMMapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SewageC214DMHis;
import com.system.po.Device.SewageC214DM;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.SewageC214DMService;
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
public class SewageC214DMServiceImpl implements SewageC214DMService {
    @Autowired
    private SewageC214DMMapper SewageC214DMMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<SewageC214DM> selectSewageC214ByORGId(String ORGId) throws Exception {
        List<SewageC214DM> SewageC214DMList = SewageC214DMMapper.selectSewageC214ByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("214");
        SewageC214DMList = judgeDeviceOnlineState(SewageC214DMList,deviceType.getDevTypeOffline());
        return SewageC214DMList;
    }

    @Override
    public List<SewageC214DM> selectSewageC214ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<SewageC214DM> SewageC214DMList = SewageC214DMMapper.selectSewageC214ByORGIdAndRoleId(ORGId,roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("214");
        SewageC214DMList = judgeDeviceOnlineState(SewageC214DMList,deviceType.getDevTypeOffline());
        return SewageC214DMList;
    }

    @Override
    public SewageC214DM selectSewageC214ByDeviceId(String sDeviceId) throws Exception {
        SewageC214DM SewageC214DM = SewageC214DMMapper.selectSewageC214ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("214");
        judgeOneDeviceOnlineState(SewageC214DM,deviceType.getDevTypeOffline());
        return SewageC214DM;
    }

    @Override
    public List<SewageC214DM> selectSewageC214ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return SewageC214DMMapper.selectSewageC214ByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
    }

    @Override
    public DataTablePageing selectSewageC214ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<SewageC214DM> SewageC214DMList = new ArrayList<SewageC214DM>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<SewageC214DM> ewagec214DeviceMessageListAll = SewageC214DMMapper.selectSewageC214ByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
        if (ewagec214DeviceMessageListAll.size() > 0)
        {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber-1;
            bigIndex = smallIndex + pageSize;
            if(bigIndex > ewagec214DeviceMessageListAll.size())
                bigIndex = ewagec214DeviceMessageListAll.size();
            SewageC214DMList.addAll(ewagec214DeviceMessageListAll.subList(smallIndex,bigIndex));
        }
        //String str= JSON.toJSON(sewageC01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(SewageC214DMList);
        dataTablePageing.setTotal(ewagec214DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    @Override
    public List<BaseDeviceMessage> selectPhoneHisSewageC214ByDateAndId(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return SewageC214DMMapper.selectPhoneHisSewageC214ByDateAndId(sDeviceId,sStartDate,sEndDate);
    }

    @Override
    public List<MydataTableColumn> selectSewageC214DeviceHead() throws Exception {
        SewageC214DM SewageC214DM = new SewageC214DM();
        List<MydataTableColumn> mydataTableColumnList = SewageC214DM.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<SewageC214DM> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(SewageC214DM.class, storageList);
    }

    //************************************私有函数********************************************//
    private List<SewageC214DM> judgeDeviceOnlineState(List<SewageC214DM> SewageC214DMList,int offline) throws Exception
    {
        for (BaseDeviceMessage baseDeviceMessage:SewageC214DMList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage,offline);
        }
        return SewageC214DMList;
    }

    private void judgeOneDeviceOnlineState(BaseDeviceMessage baseDeviceMessage,int offline) throws Exception
    {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDate = simpleFormat.format(new Date());
        long from =  simpleFormat.parse(baseDeviceMessage.getDReceiveTime()).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes > offline)
            baseDeviceMessage.setDState("离线");
        else
            baseDeviceMessage.setDState("在线");
    }


}
