package com.system.po.Phone.PhoneHj212C213;

import com.system.po.Phone.PhoneSewageC01.PSC01HisDataHead;

import java.util.ArrayList;
import java.util.List;

public class PHj212C213HisMsgInfo {
    private String dName;
    private String dSerialNum;
    private List<PHj212C213HisDataHead> pHj212C213HisDataHeads;
    private List<PHj212C213HisDataContent> pHj212C213HisDataContentList;

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

    public List<PHj212C213HisDataHead> getpHj212C213HisDataHeads() {
        return pHj212C213HisDataHeads;
    }

    public void setpHj212C213HisDataHeads(List<PHj212C213HisDataHead> pHj212C213HisDataHeads) {
        this.pHj212C213HisDataHeads = pHj212C213HisDataHeads;
    }

    public List<PHj212C213HisDataContent> getpHj212C213HisDataContentList() {
        return pHj212C213HisDataContentList;
    }

    public void setpHj212C213HisDataContentList(List<PHj212C213HisDataContent> pHj212C213HisDataContentList) {
        this.pHj212C213HisDataContentList = pHj212C213HisDataContentList;
    }

    public PHj212C213HisMsgInfo(){
    }

    public PHj212C213HisMsgInfo(String devNum,String devName){
        this.setdSerialNum(devNum);
        this.setdName(devName);
        this.setpHj212C213HisDataHeads(this.getDevicePhoneHead());
    }

    private List<PHj212C213HisDataHead> getDevicePhoneHead() {
        List<PHj212C213HisDataHead> pHj212C213HisDataHeadList = new ArrayList<PHj212C213HisDataHead>();

        //时间
        PHj212C213HisDataHead pHj212C213HisDataHead01 = new PHj212C213HisDataHead("时间","0.2","date");
        pHj212C213HisDataHeadList.add(pHj212C213HisDataHead01);

        //流量
        PHj212C213HisDataHead pHj212C213HisDataHead02 = new PHj212C213HisDataHead("流量","0.1","flowrate_value");
        pHj212C213HisDataHeadList.add(pHj212C213HisDataHead02);

        //pH
        PHj212C213HisDataHead pHj212C213HisDataHead03 = new PHj212C213HisDataHead("pH","0.1","ph_value");
        pHj212C213HisDataHeadList.add(pHj212C213HisDataHead03);

        //COD
        PHj212C213HisDataHead pHj212C213HisDataHead04 = new PHj212C213HisDataHead("COD","0.1","cod_value");
        pHj212C213HisDataHeadList.add(pHj212C213HisDataHead04);

        //氨氮
        PHj212C213HisDataHead pHj212C213HisDataHead05 = new PHj212C213HisDataHead("氨氮","0.1","nh3n_value");
        pHj212C213HisDataHeadList.add(pHj212C213HisDataHead05);

        //总磷
        PHj212C213HisDataHead pHj212C213HisDataHead06 = new PHj212C213HisDataHead("总磷","0.1","tp_value");
        pHj212C213HisDataHeadList.add(pHj212C213HisDataHead06);

        return pHj212C213HisDataHeadList;
    }
}
