package com.system.po.Phone.PWeighC312;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.WeighC312DM;
import com.system.po.Device.WeighC312DMHis;
import com.system.po.Phone.Base.PhoneHis;
import com.system.po.Phone.Base.PhoneHisDataContent;
import com.system.po.Phone.Base.PhoneHisDataHead;

import java.util.ArrayList;
import java.util.List;

public class PWeighC312His extends PhoneHis {

    /**
     *
     * @param weighc312DMHisList
     * @param type 0：投料历史数据；1：放料历史数据
     */
    public PWeighC312His(List<BaseDeviceMessage> weighc312DMHisList, String type){
        this.setdName(weighc312DMHisList.get(0).getDName());
        this.setdSerialNum(weighc312DMHisList.get(0).getDSerialNum());
        this.setPhoneHisDataHeadList(((WeighC312DMHis)weighc312DMHisList.get(0)).getHead(type));
        List<PhoneHisDataContent> phoneHisDataContentList = new ArrayList<PhoneHisDataContent>();
        for(int i=0;i<weighc312DMHisList.size();i++)
        {
            if(type.equals("0")){ //投料
                PhoneHisDataContent phoneHisDataContent = new PWeighC312HisInData((WeighC312DMHis) weighc312DMHisList.get(i));
                phoneHisDataContentList.add(phoneHisDataContent);
            }else{
                PhoneHisDataContent phoneHisDataContent = new PWeighC312HisDeData((WeighC312DMHis) weighc312DMHisList.get(i));
                phoneHisDataContentList.add(phoneHisDataContent);
            }
        }
        this.setPhoneHisDataContentList(phoneHisDataContentList);
    }

}
