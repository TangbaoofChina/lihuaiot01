package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.Lhty02p1Mapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhty02p1DM;
import com.system.po.Device.Lhty02p1DMHis;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.Lhty02p1DMService;
import com.system.util.EJConvertor;
import com.system.util.Lhty02p1Util;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Lhty02p1DMServiceImpl
 * @Description TODO
 * @Author tangbao
 * @Date 2020-09-07 17:26
 * @Version 1.0
 **/
@Service
public class Lhty02p1DMServiceImpl implements Lhty02p1DMService {
    @Autowired
    private Lhty02p1Mapper dmMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<Lhty02p1DM> selectByORGId(String ORGId) throws Exception {
        List<Lhty02p1DM> dmList = dmMapper.selectByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHTY02p1");
        dmList = judgeDeviceOnlineState(dmList, deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public List<Lhty02p1DM> selectByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<Lhty02p1DM> dmList = dmMapper.selectByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHTY02p1");
        dmList = judgeDeviceOnlineState(dmList, deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public Lhty02p1DM selectByDeviceId(String sDeviceId) throws Exception {
        Lhty02p1DM dm = dmMapper.selectByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHTY02p1");
        judgeOneDeviceOnlineState(dm, deviceType.getDevTypeOffline());
        return dm;
    }

    @Override
    public List<Lhty02p1DM> selectByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return dmMapper.selectByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public List<BaseDeviceMessage> selectPhoneHisByDateAndId(String sDeviceId, String type, String sStartDate, String sEndDate) throws Exception {
        return dmMapper.selectPhoneHisByDateAndId(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public DataTablePageing selectByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<Lhty02p1DM> dmList = new ArrayList<Lhty02p1DM>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<Lhty02p1DM> dmListAll = dmMapper.selectByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
        if (dmListAll.size() > 0) {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber - 1;
            bigIndex = smallIndex + pageSize;
            if (bigIndex > dmListAll.size())
                bigIndex = dmListAll.size();
            dmList.addAll(dmListAll.subList(smallIndex, bigIndex));
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
        List<MydataTableColumn> headColumnList = (new Lhty02p1DM()).getDeviceHead();

        return headColumnList;
    }

    @Override
    public File exportStorage(List<Lhty02p1DM> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(Lhty02p1DM.class, storageList);
    }

    @Override
    public Map<String, List<Lhty02p1DMHis>> selectHisByDateAndIDs(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<Lhty02p1DMHis>> dmMapByIds = null;
        List<Lhty02p1DMHis> dmList = null;
        switch (sQueryParam){
            case "温度A":
            case "湿度A":
            case "温度B":
            case "湿度B":
            case "电压A":
            case "电压B":
            case "电压C":
                dmList = dmMapper.selectByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
                break;
            default:
                dmList = null;
        }
        //获取每个设备的数据(设备，设备数据)
        if (dmList == null || dmList.size() < 1) {
            return null;
        }
        dmMapByIds = Lhty02p1Util.splitMsgByIds(dmList, sDeviceIds);
        return dmMapByIds;
    }

    //************************************私有函数********************************************//
    private List<Lhty02p1DM> judgeDeviceOnlineState(List<Lhty02p1DM> dmList, int offline) throws Exception {
        for (BaseDeviceMessage baseDeviceMessage : dmList
        ) {
            judgeOneDeviceOnlineState(baseDeviceMessage, offline);
        }
        return dmList;
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
