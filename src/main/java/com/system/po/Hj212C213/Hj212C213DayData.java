package com.system.po.Hj212C213;

import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.util.DataConvertor;

import java.util.List;
import java.util.Map;

public class Hj212C213DayData {
    String dateTime;
    String flowrate;
    String cod = "NaN";
    String nh3n= "NaN";
    String tp= "NaN";
    String tn= "NaN";
    String name;
    String serialNum;
    String ph;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(String flowrate) {
        this.flowrate = flowrate;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNh3n() {
        return nh3n;
    }

    public void setNh3n(String nh3n) {
        this.nh3n = nh3n;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Hj212C213DayData(){}

    public Hj212C213DayData(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList,String sDate){
        this.setDateTime(sDate);
        this.setFlowrate(this.getDayFlowrate(hj212C213DeviceMessageList));
        this.setPh(this.getDayPH(hj212C213DeviceMessageList));
        this.setSerialNum(hj212C213DeviceMessageList.get(0).getDSerialNum());
        this.setName(hj212C213DeviceMessageList.get(0).getDName());
    }

    private String getDayFlowrate(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList){
        float fDayFlowrate = 0f;
        for (int i = 0;i<hj212C213DeviceMessageList.size();i++){
            fDayFlowrate = fDayFlowrate +  Float.valueOf( hj212C213DeviceMessageList.get(i).getFlowrate_value());
        }
        fDayFlowrate = fDayFlowrate/hj212C213DeviceMessageList.size();
        fDayFlowrate = fDayFlowrate * 24;
        fDayFlowrate = (DataConvertor.formatFloat(fDayFlowrate,2));
        return String.valueOf(fDayFlowrate) ;
    }

    private String getDayPH(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList){
        float fDayPH = 0f;
        for (int i = 0;i<hj212C213DeviceMessageList.size();i++){
            fDayPH = fDayPH +  Float.valueOf( hj212C213DeviceMessageList.get(i).getPh_value());
        }
        fDayPH = fDayPH/hj212C213DeviceMessageList.size();
        fDayPH = (DataConvertor.formatFloat(fDayPH,2));
        return String.valueOf(fDayPH) ;
    }

    /**
     *获取COD的当日值
     * @param hj212C213DeviceMessageList
     * @param sDate YY-MM-DD
     */
    public void findCOD(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList,String sDate){
        for(int i = 0;i<hj212C213DeviceMessageList.size();i++){
            if(hj212C213DeviceMessageList.get(i).getCod_flag().equals("N")) {
                String sCodDate = hj212C213DeviceMessageList.get(i).getCod_sampletime().substring(0, 8);
                if (sCodDate.equals(sDate)) {
                    this.setCod(hj212C213DeviceMessageList.get(i).getCod_value());
                    break;
                }
            }
        }
    }

    /**
     * 获取氨氮的当日值
     * @param hj212C213DeviceMessageList
     * @param sDate YY-MM-DD
     */
    public void findNh3N(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList,String sDate){
        for(int i = 0;i<hj212C213DeviceMessageList.size();i++){
            if(hj212C213DeviceMessageList.get(i).getNh3n_flag().equals("N")) {
                String sNh3NDate = hj212C213DeviceMessageList.get(i).getNh3n_sampletime().substring(0, 8);
                if (sNh3NDate.equals(sDate)) {
                    this.setNh3n(hj212C213DeviceMessageList.get(i).getNh3n_value());
                    break;
                }
            }
        }
    }

    /**
     * 获取总磷的当日值
     * @param hj212C213DeviceMessageList
     * @param sDate YY-MM-DD
     */
    public void findTP(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList,String sDate){
        for(int i = 0;i<hj212C213DeviceMessageList.size();i++){
            if(hj212C213DeviceMessageList.get(i).getTp_flag().equals("N")) {
                String sTpDate = hj212C213DeviceMessageList.get(i).getTp_sampletime().substring(0, 8);
                if (sTpDate.equals(sDate)) {
                    this.setTp(hj212C213DeviceMessageList.get(i).getTp_value());
                    break;
                }
            }
        }
    }

    /**
     * 获取总氮的当日值
     * @param hj212C213DeviceMessageList
     * @param sDate YY-MM-DD
     */
    public void findTN(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList,String sDate){
        for(int i = 0;i<hj212C213DeviceMessageList.size();i++){
            if(hj212C213DeviceMessageList.get(i).getTn_flag().equals("N")) {
                String sTnDate = hj212C213DeviceMessageList.get(i).getTn_sampletime().substring(0, 8);
                if (sTnDate.equals(sDate)) {
                    this.setTp(hj212C213DeviceMessageList.get(i).getTn_value());
                    break;
                }
            }
        }
    }
}
