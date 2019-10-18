package com.system.po.FeedC411;

public class SiloTempNameRelation {
    //实际名称 1-temp01~temp10;2-temp01~temp10....
    String realName;
    //通讯名称 temp01-60
    String communicatName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCommunicatName() {
        return communicatName;
    }

    public void setCommunicatName(String communicatName) {
        this.communicatName = communicatName;
    }
}
