package com.system.po.Phone.PhoneSewageC01;

public class PSC01HisDataHead {
    private String title;
    private String width;
    private String dataName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public PSC01HisDataHead(String sTitle, String sWidth, String sDataName) {
        this.setTitle(sTitle);
        this.setWidth(sWidth);
        this.setDataName(sDataName);
    }
}
