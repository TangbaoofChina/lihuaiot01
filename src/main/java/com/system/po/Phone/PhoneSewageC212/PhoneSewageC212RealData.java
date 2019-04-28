package com.system.po.Phone.PhoneSewageC212;

import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealOneData;

import java.util.List;

public class PhoneSewageC212RealData {
    private int column;
    private String scale;
    private String title;
    private List<PhoneSewageC212RealOneData> phoneSewageC212RealOneDataList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public List<PhoneSewageC212RealOneData> getPhoneSewageC212RealOneDataList() {
        return phoneSewageC212RealOneDataList;
    }

    public void setPhoneSewageC212RealOneDataList(List<PhoneSewageC212RealOneData> phoneSewageC212RealOneDataList) {
        this.phoneSewageC212RealOneDataList = phoneSewageC212RealOneDataList;
    }
}
