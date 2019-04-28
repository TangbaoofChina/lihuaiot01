package com.system.po.Phone.PhoneSewageC212;

public class PSC212HisDataHead {
    private String title;
    private String width;
    private String dataName;
    private String align = "left";

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

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public PSC212HisDataHead(String sTitle, String sWidth, String sDataName) {
        this.setTitle(sTitle);
        this.setWidth(sWidth);
        this.setDataName(sDataName);
    }
}
