package com.system.po.Phone;

import java.util.Date;

/**
 * @ClassName MobMessageDetail
 * @Description TODO
 * @Author tangbao
 * @Date 2020-03-31 16:41
 * @Version 1.0
 **/
public class MobMsgObj implements Cloneable{
    private String sid;
    //标题
    private String title;
    //副标题
    private String briefContent;
    //详细信息
    private String  detailContent;

    private Boolean isRead = false;

    private Date createTime = new Date();


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefContent() {
        return briefContent;
    }

    public void setBriefContent(String briefContent) {
        this.briefContent = briefContent;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
