package com.system.service.impl;

import com.system.mapperiot.SewageC212DMMapper;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SewageC212DeviceMessage;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.SewageC212DMService;
import com.system.util.EJConvertor;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SewageC212DMServiceImpl implements SewageC212DMService {
    @Autowired
    private SewageC212DMMapper sewageC212DeviceMessageMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<SewageC212DeviceMessage> selectSewageC212ByORGId(String ORGId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = sewageC212DeviceMessageMapper.selectSewageC212ByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("212");
        sewageC212DeviceMessageList = judgeDeviceOnlineState(sewageC212DeviceMessageList,deviceType.getDevTypeOffline());
        return sewageC212DeviceMessageList;
    }

    @Override
    public List<SewageC212DeviceMessage> selectSewageC212ByByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = sewageC212DeviceMessageMapper.selectSewageC212ByORGIdAndRoleId(ORGId,roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("212");
        sewageC212DeviceMessageList = judgeDeviceOnlineState(sewageC212DeviceMessageList,deviceType.getDevTypeOffline());
        return sewageC212DeviceMessageList;
    }

    @Override
    public SewageC212DeviceMessage selectSewageC212ByDeviceId(String sDeviceId) throws Exception {
        SewageC212DeviceMessage sewageC212DeviceMessage = sewageC212DeviceMessageMapper.selectSewageC212ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("212");
        judgeOneDeviceOnlineState(sewageC212DeviceMessage,deviceType.getDevTypeOffline());
        return sewageC212DeviceMessage;
    }

    @Override
    public List<MydataTableColumn> selectSewageC212DeviceHead() throws Exception {
        SewageC212DeviceMessage sewageC212DeviceMessage = new SewageC212DeviceMessage();
        List<MydataTableColumn> mydataTableColumnList = sewageC212DeviceMessage.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<SewageC212DeviceMessage> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(SewageC212DeviceMessage.class, storageList);
    }

    //************************************私有函数********************************************//
    private List<SewageC212DeviceMessage> judgeDeviceOnlineState(List<SewageC212DeviceMessage> sewageC212DeviceMessageList,int offline) throws Exception
    {
        for (BaseDeviceMessage baseDeviceMessage:sewageC212DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage,offline);
        }
        return sewageC212DeviceMessageList;
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
