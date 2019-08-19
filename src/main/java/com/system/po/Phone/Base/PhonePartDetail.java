package com.system.po.Phone.Base;

import java.util.List;

/**
 * 手机端-详细信息分段部分的显示，有2列部分，有3列部分等 20190815
 */
public class PhonePartDetail {
    private int column;
    private String scale;
    private String title;
    private List<PhoneOneData> phoneOneDataList;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PhoneOneData> getPhoneOneDataList() {
        return phoneOneDataList;
    }

    public void setPhoneOneDataList(List<PhoneOneData> phoneOneDataList) {
        this.phoneOneDataList = phoneOneDataList;
    }
}
