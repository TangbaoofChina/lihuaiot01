package com.system.po.Phone.PhoneSewageC212;

import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC212DMHis;
import com.system.po.Phone.PhoneSewageC01.PSC01HisDataContent;
import com.system.po.Phone.PhoneSewageC01.PSC01HisDataHead;

import java.util.ArrayList;
import java.util.List;

public class PSC212HisMsgInfo {
    private String dName;
    private String dSerialNum;
    private List<PSC212HisDataHead> psc212HisDataHeadList;
    private List<PSC212HisDataContent> psc212HisDataContentList;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdSerialNum() {
        return dSerialNum;
    }

    public void setdSerialNum(String dSerialNum) {
        this.dSerialNum = dSerialNum;
    }

    public List<PSC212HisDataHead> getPsc212HisDataHeadList() {
        return psc212HisDataHeadList;
    }

    public void setPsc212HisDataHeadList(List<PSC212HisDataHead> psc212HisDataHeadList) {
        this.psc212HisDataHeadList = psc212HisDataHeadList;
    }

    public List<PSC212HisDataContent> getPsc212HisDataContentList() {
        return psc212HisDataContentList;
    }

    public void setPsc212HisDataContentList(List<PSC212HisDataContent> psc212HisDataContentList) {
        this.psc212HisDataContentList = psc212HisDataContentList;
    }

    public PSC212HisMsgInfo(List<SewageC212DMHis> sewageC212DMHisList) {
        this.dSerialNum = sewageC212DMHisList.get(0).getDSerialNum();
        this.dName = sewageC212DMHisList.get(0).getDName();
        this.psc212HisDataHeadList = sewageC212DMHisList.get(0).getDevicePhoneHead212();
        List<PSC212HisDataContent> psc212HisDataContentList = new ArrayList<PSC212HisDataContent>();
        for (SewageC212DMHis sewageC212DMHis : sewageC212DMHisList
                ) {
            PSC212HisDataContent psc212HisDataContent = new PSC212HisDataContent(sewageC212DMHis);
            psc212HisDataContentList.add(psc212HisDataContent);
        }
        this.psc212HisDataContentList = psc212HisDataContentList;
    }
}
