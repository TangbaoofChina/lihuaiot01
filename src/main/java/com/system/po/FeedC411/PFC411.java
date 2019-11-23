package com.system.po.FeedC411;

/**
 * 饲料部-筒仓测温 手机端信息
 */
public class PFC411 {
    private String devNum;
    private String devName;
    //发送时间
    private String sendDate;
    PFC411TempInfo siloTempInfo;

    public String getDevNum() {
        return devNum;
    }

    public void setDevNum(String devNum) {
        this.devNum = devNum;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public PFC411TempInfo getSiloTempInfo() {
        return siloTempInfo;
    }

    public void setSiloTempInfo(PFC411TempInfo siloTempInfo) {
        this.siloTempInfo = siloTempInfo;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }
}
