package com.system.po;

import com.system.po.parameter.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class AlarmDescribe extends DeviceType {
    private String alarmCode;
    private String alarmDescribe;

    public String getAlarmCode() {
        return alarmCode;
    }

    public void setAlarmCode(String alarmCode) {
        this.alarmCode = alarmCode;
    }


    public String getAlarmDescribe() {
        return alarmDescribe;
    }

    public void setAlarmDescribe(String alarmDescribe) {
        this.alarmDescribe = alarmDescribe;
    }

    public List<MydataTableColumn> getAlarmDescribeHead()
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
        mdtc3.setData("alarmCode");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("报警代码");


        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("alarmDescribe");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("报警注释");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);

        return myDTCList;
    }
}
