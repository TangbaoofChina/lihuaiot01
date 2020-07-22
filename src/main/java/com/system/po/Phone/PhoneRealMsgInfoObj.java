package com.system.po.Phone;

/**
 * @ClassName PhoneRealMsgInfoObj
 * @Description 数值是对象
 * @Author tangbao
 * @Date 2020-07-20 14:15
 * @Version 1.0
 **/
public class PhoneRealMsgInfoObj {
    private String id;
    private String title;
    private Object value;
    private String flag;
    private boolean hasHis = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isHasHis() {
        return hasHis;
    }

    public void setHasHis(boolean hasHis) {
        this.hasHis = hasHis;
    }
}
