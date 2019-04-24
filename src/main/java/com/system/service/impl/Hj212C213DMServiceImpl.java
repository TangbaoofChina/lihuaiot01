package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.Hj212C213DMMapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.DeviceInfo;
import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.po.parameter.OneDataDetail;
import com.system.service.DeviceTypeService;
import com.system.service.Hj212C213DMService;
import com.system.util.EJConvertor;
import com.system.util.Hj212C213Util;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Hj212C213DMServiceImpl implements Hj212C213DMService {
    @Autowired
    private Hj212C213DMMapper hj212C213DMMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<Hj212C213DeviceMessage> selectHj212C213ByORGId(String ORGId) throws Exception {
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = hj212C213DMMapper.selectHj212C213ByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("213");
        hj212C213DeviceMessageList = judgeDeviceOnlineState(hj212C213DeviceMessageList, deviceType.getDevTypeOffline());
        return hj212C213DeviceMessageList;
    }

    @Override
    public List<Hj212C213DeviceMessage> selectHj212C213ByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = hj212C213DMMapper.selectHj212C213ByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("212");
        hj212C213DeviceMessageList = judgeDeviceOnlineState(hj212C213DeviceMessageList, deviceType.getDevTypeOffline());
        return hj212C213DeviceMessageList;
    }

    @Override
    public Hj212C213DeviceMessage selectHj212C213ByDeviceId(String sDeviceId) throws Exception {
        Hj212C213DeviceMessage hj212C2123DeviceMessage = hj212C213DMMapper.selectHj212C213ByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("212");
        judgeOneDeviceOnlineState(hj212C2123DeviceMessage, deviceType.getDevTypeOffline());
        return hj212C2123DeviceMessage;
    }

    @Override
    public List<Hj212C213DeviceMessage> selectHj212C213ByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return hj212C213DMMapper.selectHj212C213ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public DataTablePageing selectHj212C213ByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = new ArrayList<Hj212C213DeviceMessage>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageListAll = hj212C213DMMapper.selectHj212C213ByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
        if (hj212C213DeviceMessageListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > hj212C213DeviceMessageListAll.size())
                bigIndex = hj212C213DeviceMessageListAll.size();
            hj212C213DeviceMessageList.addAll(hj212C213DeviceMessageListAll.subList(smallIndex, bigIndex));
        }
        //String str= JSON.toJSON(sewageC01DeviceMessageList).toString();
        String sReturnJson = JSON.toJSONString(hj212C213DeviceMessageList);
        dataTablePageing.setTotal(hj212C213DeviceMessageListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }

    @Override
    public List<MydataTableColumn> selectHj212C213DeviceHead() throws Exception {
        Hj212C213DeviceMessage hj212C213DeviceMessage = new Hj212C213DeviceMessage();
        List<MydataTableColumn> mydataTableColumnList = hj212C213DeviceMessage.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<Hj212C213DeviceMessage> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(Hj212C213DeviceMessage.class, storageList);
    }

    @Override
    public Map<String, List<Hj212C213DeviceMessage>> selectHisHj212C213ByDateAndIDs(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByIds = null;
        List<Hj212C213DeviceMessage> hj212C213DMList = null;
        if (sQueryParam.equals("流量") || sQueryParam.equals("pH")) {
            hj212C213DMList = hj212C213DMMapper.selectHj212C213ByDeviceIdsAndDateTime(sDeviceIds, sStartDate, sEndDate);
        } else if (sQueryParam.equals("COD")) {
            hj212C213DMList = hj212C213DMMapper.selectHj212C213ByDeviceIdsAndCODSampleTime(sDeviceIds, sStartDate, sEndDate);
        } else if (sQueryParam.equals("氨氮")) {
            hj212C213DMList = hj212C213DMMapper.selectHj212C213ByDeviceIdsAndNH3NSampleTime(sDeviceIds, sStartDate, sEndDate);
        } else if (sQueryParam.equals("总磷")) {
            hj212C213DMList = hj212C213DMMapper.selectHj212C213ByDeviceIdsAndTPSampleTime(sDeviceIds, sStartDate, sEndDate);
        } else if (sQueryParam.equals("总氮")) {
            hj212C213DMList = hj212C213DMMapper.selectHj212C213ByDeviceIdsAndTNSampleTime(sDeviceIds, sStartDate, sEndDate);
        }
        //获取每个设备的数据(设备，设备数据)
        if (hj212C213DMList == null || hj212C213DMList.size() < 1) {
            return null;
        }
        hj212C213MapByIds = Hj212C213Util.splitMsgByIds(hj212C213DMList, sDeviceIds);
        return hj212C213MapByIds;
    }

    /**
     * 两两参数对比曲线数据，以 日 为单位，这里不考虑多设备情况-无法为多设备服务
     * @param sDeviceIds
     * @param sStartDate
     * @param sEndDate
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Hj212C213DayData> selectHisHj212C213ByDateAndIDsTwoParam(String[] sDeviceIds, String sStartDate, String sEndDate) throws Exception {
        List<Hj212C213DeviceMessage> hj212C213DMList = hj212C213DMMapper.selectHj212C213ByDeviceIdsAndDateTime(sDeviceIds, sStartDate, sEndDate);
        Map<String, List<Hj212C213DeviceMessage>> hj212C213Map = Hj212C213Util.splitHj212C213DMByDate(hj212C213DMList);
        Map<String,Hj212C213DayData> hj212C213DayDataMap = new HashMap<>();
        for (Map.Entry<String, List<Hj212C213DeviceMessage>> entry : hj212C213Map.entrySet()) {
            Hj212C213DayData hj212C213DayData = new Hj212C213DayData(entry.getValue(),entry.getKey());
            hj212C213DayData.findCOD(hj212C213DMList,entry.getKey());
            hj212C213DayData.findNh3N(hj212C213DMList,entry.getKey());
            hj212C213DayData.findTP(hj212C213DMList,entry.getKey());
            hj212C213DayDataMap.put(entry.getKey(),hj212C213DayData);
        }
        return hj212C213DayDataMap;
    }

    //************************************私有函数********************************************//
    private List<Hj212C213DeviceMessage> judgeDeviceOnlineState(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList, int offline) throws Exception {
        for (BaseDeviceMessage baseDeviceMessage : hj212C213DeviceMessageList
                ) {
            judgeOneDeviceOnlineState(baseDeviceMessage, offline);
        }
        return hj212C213DeviceMessageList;
    }

    private void judgeOneDeviceOnlineState(BaseDeviceMessage baseDeviceMessage, int offline) throws Exception {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String toDate = simpleFormat.format(new Date());
        long from = simpleFormat.parse(baseDeviceMessage.getDReceiveTime()).getTime();
        long to = simpleFormat.parse(toDate).getTime();
        int minutes = (int) ((to - from) / (1000 * 60));
        if (minutes > offline)
            baseDeviceMessage.setDState("离线");
        else
            baseDeviceMessage.setDState("在线");
    }

}
