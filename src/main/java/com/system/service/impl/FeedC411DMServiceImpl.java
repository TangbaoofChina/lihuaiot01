package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.FeedC411DMMapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.FeedC411DM;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.FeedC411DMService;
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
public class FeedC411DMServiceImpl implements FeedC411DMService{
    @Autowired
    private FeedC411DMMapper feedC411DMMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<FeedC411DM> selectByORGId(String ORGId) throws Exception {
        List<FeedC411DM> dmList = feedC411DMMapper.selectByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("411");
        dmList = judgeDeviceOnlineState(dmList,deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public List<FeedC411DM> selectByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<FeedC411DM> dmList = feedC411DMMapper.selectByORGIdAndRoleId(ORGId,roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("411");
        dmList = judgeDeviceOnlineState(dmList,deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public FeedC411DM selectByDeviceId(String sDeviceId) throws Exception {
        FeedC411DM dm = feedC411DMMapper.selectByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("411");
        judgeOneDeviceOnlineState(dm,deviceType.getDevTypeOffline());
        return dm;
    }

    @Override
    public List<FeedC411DM> selectByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return feedC411DMMapper.selectByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
    }

    @Override
    public List<BaseDeviceMessage> selectPhoneHisByDateAndId(String sDeviceId, String type, String sStartDate, String sEndDate) throws Exception {
        return feedC411DMMapper.selectPhoneHisByDateAndId(sDeviceId,sStartDate,sEndDate);
    }

    @Override
    public DataTablePageing selectByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<FeedC411DM> dmList = new ArrayList<FeedC411DM>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<FeedC411DM> dmListAll = feedC411DMMapper.selectByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
        if (dmListAll.size() > 0)
        {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber-1;
            bigIndex = smallIndex + pageSize;
            if(bigIndex > dmListAll.size())
                bigIndex = dmListAll.size();
            dmList.addAll(dmListAll.subList(smallIndex,bigIndex));
        }
        //String str= JSON.toJSON(sewageC01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(dmList);
        dataTablePageing.setTotal(dmListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    @Override
    public List<MydataTableColumn> selectDeviceHead() throws Exception {
        FeedC411DM dm = new FeedC411DM();
        List<MydataTableColumn> mydataTableColumnList = dm.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<FeedC411DM> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(FeedC411DM.class, storageList);
    }

    //************************************私有函数********************************************//
    private List<FeedC411DM> judgeDeviceOnlineState(List<FeedC411DM> dmList,int offline) throws Exception
    {
        for (BaseDeviceMessage baseDeviceMessage:dmList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage,offline);
        }
        return dmList;
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
