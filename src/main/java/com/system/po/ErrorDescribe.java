package com.system.po;

import com.system.po.parameter.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class ErrorDescribe extends DeviceType {
    private String errorCode;
    private String errorDescribe;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescribe() {
        return errorDescribe;
    }

    public void setErrorDescribe(String errorDescribe) {
        this.errorDescribe = errorDescribe;
    }

    public List<MydataTableColumn> getErrorDescribeHead()
    {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("devType");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("类型代码");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("devTypeDescribe");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("类型注释");
        mdtc2.setVisible(false);

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("errorCode");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("错误代码");


        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("errorDescribe");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("错误注释");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);

        return myDTCList;
    }
}
