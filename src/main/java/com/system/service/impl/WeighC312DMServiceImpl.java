package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.WeighC312DMMapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.WeighC312DM;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.WeighC312DMService;
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
public class WeighC312DMServiceImpl implements WeighC312DMService {
    @Autowired
    private WeighC312DMMapper weighC312DMMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<WeighC312DM> selectWeighC312ByORGId(String ORGId) throws Exception {
        List<WeighC312DM> weighC312DMList = weighC312DMMapper.selectWeighC312ByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("312");
        weighC312DMList = judgeDeviceOnlineState(weighC312DMList,deviceType.getDevTypeOffline());
        return weighC312DMList;
    }

    @Override
    public List<WeighC312DM> selectWeighC312ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<WeighC312DM> weighC312DMList = weighC312DMMapper.selectWeighC312ByORGIdAndRoleId(ORGId,roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("312");
        weighC312DMList = judgeDeviceOnlineState(weighC312DMList,deviceType.getDevTypeOffline());
        return weighC312DMList;
    }

    @Override
    public WeighC312DM selectWeighC312ByDeviceId(String sDeviceId) throws Exception {
        WeighC312DM weighC312DM = weighC312DMMapper.selectWeighC312ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("312");
        judgeOneDeviceOnlineState(weighC312DM,deviceType.getDevTypeOffline());
        return weighC312DM;
    }

    @Override
    public List<WeighC312DM> selectWeighC312ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return weighC312DMMapper.selectWeighC312ByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
    }

    @Override
    public List<BaseDeviceMessage> selectPhoneHisWeighC312ByDateAndId(String sDeviceId,String type, String sStartDate, String sEndDate) throws Exception {
        if(type.equals("0")) { //投料
            return weighC312DMMapper.selectPhoneHisInWeighC312ByDateAndId(sDeviceId,sStartDate,sEndDate);
        }else{ // 放料
            return weighC312DMMapper.selectPhoneHisDeWeighC312ByDateAndId(sDeviceId,sStartDate,sEndDate);
        }
    }

    @Override
    public DataTablePageing selectWeighC312ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<WeighC312DM> weighC312DMList = new ArrayList<WeighC312DM>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<WeighC312DM> ewagec214DeviceMessageListAll = weighC312DMMapper.selectWeighC312ByDeviceIdAndDate(sDeviceId,sStartDate,sEndDate);
        if (ewagec214DeviceMessageListAll.size() > 0)
        {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber-1;
            bigIndex = smallIndex + pageSize;
            if(bigIndex > ewagec214DeviceMessageListAll.size())
                bigIndex = ewagec214DeviceMessageListAll.size();
            weighC312DMList.addAll(ewagec214DeviceMessageListAll.subList(smallIndex,bigIndex));
        }
        //String str= JSON.toJSON(sewageC01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(weighC312DMList);
        dataTablePageing.setTotal(ewagec214DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    @Override
    public List<MydataTableColumn> selectWeighC312DeviceHead() throws Exception {
        WeighC312DM weighC312DM = new WeighC312DM();
        List<MydataTableColumn> mydataTableColumnList = weighC312DM.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<WeighC312DM> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(WeighC312DM.class, storageList);
    }

    //************************************私有函数********************************************//
    private List<WeighC312DM> judgeDeviceOnlineState(List<WeighC312DM> dmList,int offline) throws Exception
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
