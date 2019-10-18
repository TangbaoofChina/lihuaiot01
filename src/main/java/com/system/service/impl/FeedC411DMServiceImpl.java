package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.FeedC411DMMapper;
import com.system.po.DataTablePageing;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.FeedC411DM;
import com.system.po.Device.FeedC411.FeedC411DMFY;
import com.system.po.FeedC411.SiloHisTemp;
import com.system.po.FeedC411.SiloTempNameRelation;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;
import com.system.service.DeviceTypeService;
import com.system.service.FeedC411DMService;
import com.system.util.DataConvertor;
import com.system.util.DeviceUtil;
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
    public List<FeedC411DM> selectByORGIdAndRoleId(String ORGId, List<RoleInfo> roleInfoList) throws Exception {
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
        //这里实现子类没想到什么好方法，暂时先这么处理吧，回头再想
        //需要根据不同饲料部的测温点数，生成不同的子类对象，因此需要知道不同的饲料部，怎么区分不同饲料部呢？
        FeedC411DM dm = new FeedC411DM();
        List<MydataTableColumn> mydataTableColumnList = dm.getDeviceHead();
        return mydataTableColumnList;
    }

    @Override
    public File exportStorage(List<FeedC411DM> storageList) {
        if (storageList == null)
            return null;
        FeedC411DM feedC411DM = storageList.get(0);
        //阜阳-筒仓测温
        if(feedC411DM.getDSerialNum().contains("4800")) {
            return ejConvertor.excelWriter(FeedC411DMFY.class, storageList);
        }else{
            return ejConvertor.excelWriter(FeedC411DM.class, storageList);
        }
    }

    @Override
    public List<SiloTempNameRelation> selectParamsById(String devId) {
        FeedC411DM dm = feedC411DMMapper.selectByDeviceId(devId);
        List<SiloTempNameRelation> sTNRL01 = new ArrayList<>();
        List<SiloTempNameRelation> sTNRL02 = new ArrayList<>();
        List<SiloTempNameRelation> sTNRL03 = new ArrayList<>();
        List<SiloTempNameRelation> sTNRL04 = new ArrayList<>();
        List<SiloTempNameRelation> sTNRL05 = new ArrayList<>();
        List<SiloTempNameRelation> sTNRL06 = new ArrayList<>();
        int indexAll = 0;
        if (dm.getCable01Nums() > 0)
            sTNRL01 = formatTempRelation(1, dm.getCable01Nums(), dm.getCable01Used(),0);
        indexAll = dm.getCable01Nums();
        if (dm.getCable02Nums() > 0)
            sTNRL02 = formatTempRelation(2, dm.getCable02Nums(), dm.getCable02Used(),indexAll);
        indexAll = indexAll + dm.getCable02Nums();
        if (dm.getCable03Nums() > 0)
            sTNRL03 = formatTempRelation(3, dm.getCable03Nums(), dm.getCable03Used(),indexAll);
        indexAll = indexAll + dm.getCable03Nums();
        if (dm.getCable04Nums() > 0)
            sTNRL04 = formatTempRelation(4, dm.getCable04Nums(), dm.getCable04Used(),indexAll);
        indexAll = indexAll + dm.getCable04Nums();
        if (dm.getCable05Nums() > 0)
            sTNRL05 = formatTempRelation(5, dm.getCable05Nums(), dm.getCable05Used(),indexAll);
        indexAll = indexAll + dm.getCable05Nums();
        if (dm.getCable06Nums() > 0)
            sTNRL06 = formatTempRelation(6, dm.getCable06Nums(), dm.getCable06Used(),indexAll);
        List<SiloTempNameRelation> sTNRL = new ArrayList<>();
        if (sTNRL01.size() > 0)
            sTNRL.addAll(sTNRL01);
        if (sTNRL02.size() > 0)
            sTNRL.addAll(sTNRL02);
        if (sTNRL03.size() > 0)
            sTNRL.addAll(sTNRL03);
        if (sTNRL04.size() > 0)
            sTNRL.addAll(sTNRL04);
        if (sTNRL05.size() > 0)
            sTNRL.addAll(sTNRL05);
        if (sTNRL06.size() > 0)
            sTNRL.addAll(sTNRL06);
        return sTNRL;
    }

    @Override
    public List<SiloHisTemp> selectTempByDeviceIdAndDate(String sDeviceId, String sTempName, String sStartTime, String sEndDate) {
        return feedC411DMMapper.selectTempByDeviceIdAndDate(sDeviceId,sTempName,sStartTime,sEndDate);
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

    /**
     * 生成实际温度名称和协议温度名称关系表
     * @param cableNum
     * @param nums
     * @param used
     * @param index
     * @return
     */
    private List<SiloTempNameRelation> formatTempRelation(int cableNum,int nums,String used,int index){
        List<SiloTempNameRelation> sTNRs = new ArrayList<>();
        for(int i=0;i<nums;i++){
            if(!DataConvertor.Hex2Bool(used,i)){
                String sRealTemp = String.valueOf(cableNum) + "-" + String.valueOf(i+1);
                String sComTemp = "temp" + DataConvertor.formatZero(index+i+1,2);
                SiloTempNameRelation sTNR = new SiloTempNameRelation();
                sTNR.setRealName(sRealTemp);
                sTNR.setCommunicatName(sComTemp);
                sTNRs.add(sTNR);
            }
        }
        return sTNRs;
    }
}
