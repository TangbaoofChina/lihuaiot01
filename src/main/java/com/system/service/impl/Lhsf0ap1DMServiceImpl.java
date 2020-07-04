package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.Lhsf0ap1Mapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.Device.Lhsf0ap1DMHis;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.Lhsf0ap1DMService;
import com.system.util.EJConvertor;
import com.system.util.Lhsf0ap1Util;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Lhsf0ap1DMServiceImpl
 * @Description TODO
 * @Author tangbao
 * @Date 2020-05-23 10:08
 * @Version 1.0
 **/
@Service
public class Lhsf0ap1DMServiceImpl implements Lhsf0ap1DMService {
    @Autowired
    private Lhsf0ap1Mapper dmMapper;
    @Autowired
    private EJConvertor ejConvertor;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @Override
    public List<Lhsf0ap1DM> selectByORGId(String ORGId) throws Exception {
        List<Lhsf0ap1DM> dmList = dmMapper.selectByORGId(ORGId);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHSF0Ap1");
        dmList = judgeDeviceOnlineState(dmList, deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public List<Lhsf0ap1DM> selectByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
        List<String> roleIds = RoleInfoListUtil.getRoleIdsFromRoleInfoList(roleInfoList);
        List<Lhsf0ap1DM> dmList = dmMapper.selectByORGIdAndRoleId(ORGId, roleIds);
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHSF0Ap1");
        dmList = judgeDeviceOnlineState(dmList, deviceType.getDevTypeOffline());
        return dmList;
    }

    @Override
    public Lhsf0ap1DM selectByDeviceId(String sDeviceId) throws Exception {
        Lhsf0ap1DM dm = dmMapper.selectByDeviceId(sDeviceId);
        dm.seteDescribe();
        DeviceType deviceType = deviceTypeService.selectDeviceTypeByTypeNum("LHSF0Ap1");
        judgeOneDeviceOnlineState(dm, deviceType.getDevTypeOffline());
        return dm;
    }

    @Override
    public List<Lhsf0ap1DMHis> selectByDevNumAndDate(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<Lhsf0ap1DMHis> dmList = dmMapper.selectByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
        return dmList;
    }

    @Override
    public List<BaseDeviceMessage> selectPhoneHisByDateAndId(String sDeviceId, String type, String sStartDate, String sEndDate) throws Exception {
        return dmMapper.selectPhoneHisByDateAndId(sDeviceId, sStartDate, sEndDate);
    }

    @Override
    public DataTablePageing selectByDeviceIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        List<Lhsf0ap1DMHis> dmList = new ArrayList<Lhsf0ap1DMHis>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<Lhsf0ap1DMHis> dmListAll = dmMapper.selectByDeviceIdAndDate(sDeviceId, sStartDate, sEndDate);
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
    public List<MydataTableColumn> selectDeviceHead(String devId) throws Exception {

        List<MydataTableColumn> headColumnList = (new Lhsf0ap1DM()).getDeviceHead();

        return headColumnList;
    }

    @Override
    public File exportStorage(List<Lhsf0ap1DM> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(Lhsf0ap1DM.class, storageList);
    }

    @Override
    public File exportStorageHis(List<Lhsf0ap1DMHis> storageList) {
        if (storageList == null)
            return null;
        return ejConvertor.excelWriter(Lhsf0ap1DM.class, storageList);
    }

    //************************************私有函数********************************************//
    private List<Lhsf0ap1DM> judgeDeviceOnlineState(List<Lhsf0ap1DM> dmList, int offline) throws Exception {
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
