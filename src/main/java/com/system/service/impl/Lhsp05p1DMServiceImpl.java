package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.Lhsp05p1Mapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhsp05p1DM;
import com.system.po.Device.Lhsp05p1DMHis;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.Lhsp05p1DMService;
import com.system.util.EJConvertor;
import com.system.util.Lhsp05p1Util;
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
 * @ClassName Lhsf0ap1DMServiceImpl
 * @Description TODO
 * @Author tangbao
 * @Date 2020-05-23 10:08
 * @Version 1.0
 **/
@Service
public class Lhsp05p1DMServiceImpl implements Lhsp05p1DMService {
    @Autowired
    private Lhsp05p1Mapper dmMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<Lhsp05p1DM> selectByORGId(String ORGId) throws Exception {
        List<Lhsp05p1DM> dmList = dmMapper.selectByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHSP05p1");
        dmList = judgeDeviceOnlineState(dmList, deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public List<Lhsp05p1DM> selectByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<Lhsp05p1DM> dmList = dmMapper.selectByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHSP05p1");
        dmList = judgeDeviceOnlineState(dmList, deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public Lhsp05p1DM selectByDeviceId(String sDeviceId) throws Exception {
        Lhsp05p1DM dm = dmMapper.selectByDeviceId(sDeviceId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHSP05p1");
        judgeOneDeviceOnlineState(dm, deviceType.getDevTypeOffline());
        return dm;
    }

    @Override
    public List<Lhsp05p1DM> selectByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        return dmMapper.selectByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public List<BaseDeviceMessage> selectPhoneHisByDateAndId(String sDeviceId, String type, String sStartDate, String sEndDate) throws Exception {
        return dmMapper.selectPhoneHisByDateAndId(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public DataTablePageing selectByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<Lhsp05p1DM> dmList = new ArrayList<Lhsp05p1DM>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<Lhsp05p1DM> dmListAll = dmMapper.selectByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
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

        List<MydataTableColumn> headColumnList = (new Lhsp05p1DM()).getDeviceHead();

        return headColumnList;
    }

    @Override
    public File exportStorage(List<Lhsp05p1DM> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(Lhsp05p1DM.class, storageList);
    }

    @Override
    public Map<String, List<Lhsp05p1DMHis>> selectHisByDateAndIDs(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<Lhsp05p1DMHis>> dmMapByIds = null;
        List<Lhsp05p1DMHis> dmList = null;
        if (sQueryParam.equals("温度01") || sQueryParam.equals("温度02") || sQueryParam.equals("温度03") || sQueryParam.equals("温度04")) {
            dmList = dmMapper.selectByDeviceIdsAndDate(sDeviceIds, sStartDate, sEndDate);
        }
        //获取每个设备的数据(设备，设备数据)
        if (dmList == null || dmList.size() < 1) {
            return null;
        }
        dmMapByIds = Lhsp05p1Util.splitMsgByIds(dmList, sDeviceIds);
        return dmMapByIds;
    }

    //************************************私有函数********************************************//
    private List<Lhsp05p1DM> judgeDeviceOnlineState(List<Lhsp05p1DM> dmList, int offline) throws Exception {
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
