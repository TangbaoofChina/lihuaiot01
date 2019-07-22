package com.system.po.Phone.PhoneSewageC01;

import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC212DMHis;
import com.system.po.Device.SewageC214DMHis;
import com.system.po.Phone.PhoneSewageC212.PSC212HisDataContent;
import com.system.po.Phone.PhoneSewageC214.PSC214HisDataContent;

import java.util.ArrayList;
import java.util.List;

public class PSC01HisMsgInfo {
    private String dName;
    private String dSerialNum;
    private List<PSC01HisDataHead> psc01HisDataHeadList;
    private List<PSC01HisDataContent> psc01HisDataContentList;

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

    public List<PSC01HisDataHead> getPsc01HisDataHeadList() {
        return psc01HisDataHeadList;
    }

    public void setPsc01HisDataHeadList(List<PSC01HisDataHead> psc01HisDataHeadList) {
        this.psc01HisDataHeadList = psc01HisDataHeadList;
    }

    public List<PSC01HisDataContent> getPsc01HisDataContentList() {
        return psc01HisDataContentList;
    }

    public void setPsc01HisDataContentList(List<PSC01HisDataContent> psc01HisDataContentList) {
        this.psc01HisDataContentList = psc01HisDataContentList;
    }

    public PSC01HisMsgInfo(List<SewageC01DMHis> sewageC01DMHisList) {
        this.dSerialNum = sewageC01DMHisList.get(0).getDSerialNum();
        this.dName = sewageC01DMHisList.get(0).getDName();
        this.psc01HisDataHeadList = sewageC01DMHisList.get(0).getDevicePhoneHead();
        List<PSC01HisDataContent> psc01HisDataContentList = new ArrayList<PSC01HisDataContent>();
        for (SewageC01DMHis sewageC01DMHis : sewageC01DMHisList
                ) {
            PSC01HisDataContent psc01HisDataContent = new PSC01HisDataContent(sewageC01DMHis);
            psc01HisDataContentList.add(psc01HisDataContent);
        }
        this.psc01HisDataContentList = psc01HisDataContentList;
    }

    public PSC01HisMsgInfo(List<BaseDeviceMessage> sewageCDMHisList, String devType) {
        if (devType.equals("212")) {
            this.dSerialNum = ((SewageC212DMHis)sewageCDMHisList.get(0)).getDSerialNum();
            this.dName = ((SewageC212DMHis)sewageCDMHisList.get(0)).getDName();
            this.psc01HisDataHeadList = ((SewageC212DMHis)sewageCDMHisList.get(0)).getDevicePhoneHead();
            List<PSC01HisDataContent> psc01HisDataContentList = new ArrayList<PSC01HisDataContent>();
            for (Object sewageC212DMHis : sewageCDMHisList
                    ) {
                PSC01HisDataContent psc01HisDataContent = new PSC212HisDataContent((SewageC212DMHis) sewageC212DMHis);
                psc01HisDataContentList.add(psc01HisDataContent);
            }
            this.psc01HisDataContentList = psc01HisDataContentList;
        } else if (devType.equals("214")) {
            this.dSerialNum = ((SewageC214DMHis)sewageCDMHisList.get(0)).getDSerialNum();
            this.dName = ((SewageC214DMHis)sewageCDMHisList.get(0)).getDName();
            this.psc01HisDataHeadList = ((SewageC214DMHis)sewageCDMHisList.get(0)).getDevicePhoneHead();
            List<PSC01HisDataContent> psc01HisDataContentList = new ArrayList<PSC01HisDataContent>();
            for (Object sewageC214DMHis : sewageCDMHisList
                    ) {
                PSC01HisDataContent psc01HisDataContent = new PSC214HisDataContent((SewageC214DMHis)sewageC214DMHis);
                psc01HisDataContentList.add(psc01HisDataContent);
            }
            this.psc01HisDataContentList = psc01HisDataContentList;
        }
    }
}