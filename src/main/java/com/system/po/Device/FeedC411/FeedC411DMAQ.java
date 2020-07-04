package com.system.po.Device.FeedC411;

import com.system.po.MydataTableColumn;
import com.system.util.DataConvertor;

import java.util.ArrayList;
import java.util.List;

/**
 * 安庆分公司-饲料部
 */
public class FeedC411DMAQ {

    public List<MydataTableColumn> getDeviceHead(int cable01,int cable02,int cable03,int cable04,int cable05,int cable06) {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNumDec");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("humidity01");
        mdtc33.setDefaultContent("仓内湿度");
        mdtc33.setTitle("仓内湿度");
        mdtc33.setVisible(true);

        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("envHumidity");
        mdtc34.setDefaultContent("环境湿度");
        mdtc34.setTitle("环境湿度");
        mdtc34.setVisible(true);

        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("useState");
        mdtc35.setDefaultContent("使用状态");
        mdtc35.setTitle("使用状态");
        mdtc35.setVisible(true);

        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("stock");
        mdtc36.setDefaultContent("库存");
        mdtc36.setTitle("库存");
        mdtc36.setVisible(true);

        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("water");
        mdtc37.setDefaultContent("水份");
        mdtc37.setTitle("水份");
        mdtc37.setVisible(true);

        //设备发送数据时间
        MydataTableColumn mdtc109 = new MydataTableColumn();
        mdtc109.setData("sendDate");
        mdtc109.setDefaultContent("109");
        mdtc109.setTitle("时间");
        mdtc109.setVisible(true);

        //设备在线状态
        MydataTableColumn mdtc110 = new MydataTableColumn();
        mdtc110.setData("dState");
        mdtc110.setDefaultContent("110");
        mdtc110.setTitle("状态");
        mdtc110.setVisible(true);

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //设备在线状态
        myDTCList.add(mdtc110);
        //设备发送数据时间
        myDTCList.add(mdtc109);
        //仓内湿度
        myDTCList.add(mdtc33);
        //环境湿度
        myDTCList.add(mdtc34);
        //使用状态
        myDTCList.add(mdtc35);
        //库存
        myDTCList.add(mdtc36);
        //水份
        myDTCList.add(mdtc37);

         //电缆1
        for(int i =1;i<=cable01;i++){
            MydataTableColumn mdtc_cable = new MydataTableColumn();
            String sDate = "temp" + DataConvertor.formatZero(i,2);
            mdtc_cable.setData(sDate);
            String sContent = "1-" + DataConvertor.formatZero(i,2);
            mdtc_cable.setDefaultContent(sContent);
            mdtc_cable.setTitle(sContent);
            mdtc_cable.setVisible(true);
            myDTCList.add(mdtc_cable);
        }


        //电缆2
        for(int i =1;i<=cable02;i++){
            MydataTableColumn mdtc_cable = new MydataTableColumn();
            String sDate = "temp" + DataConvertor.formatZero(i+cable01,2);
            mdtc_cable.setData(sDate);
            String sContent = "2-" + DataConvertor.formatZero(i,2);
            mdtc_cable.setDefaultContent(sContent);
            mdtc_cable.setTitle(sContent);
            mdtc_cable.setVisible(true);
            myDTCList.add(mdtc_cable);
        }

        //电缆3
        for(int i =1;i<=cable03;i++){
            MydataTableColumn mdtc_cable = new MydataTableColumn();
            String sDate = "temp" + DataConvertor.formatZero(i+cable01+cable02,2);
            mdtc_cable.setData(sDate);
            String sContent = "3-" + DataConvertor.formatZero(i,2);
            mdtc_cable.setDefaultContent(sContent);
            mdtc_cable.setTitle(sContent);
            mdtc_cable.setVisible(true);
            myDTCList.add(mdtc_cable);
        }

        //电缆4
        for(int i =1;i<=cable04;i++){
            MydataTableColumn mdtc_cable = new MydataTableColumn();
            String sDate = "temp" + DataConvertor.formatZero(i+cable01+cable02+cable03,2);
            mdtc_cable.setData(sDate);
            String sContent = "4-" + DataConvertor.formatZero(i,2);
            mdtc_cable.setDefaultContent(sContent);
            mdtc_cable.setTitle(sContent);
            mdtc_cable.setVisible(true);
            myDTCList.add(mdtc_cable);
        }

        //电缆5
        for(int i =1;i<=cable05;i++){
            MydataTableColumn mdtc_cable = new MydataTableColumn();
            String sDate = "temp" + DataConvertor.formatZero(i+cable01+cable02+cable03+cable04,2);
            mdtc_cable.setData(sDate);
            String sContent = "5-" + DataConvertor.formatZero(i,2);
            mdtc_cable.setDefaultContent(sContent);
            mdtc_cable.setTitle(sContent);
            mdtc_cable.setVisible(true);
            myDTCList.add(mdtc_cable);
        }

        //电缆6
        for(int i =1;i<=cable06;i++){
            MydataTableColumn mdtc_cable = new MydataTableColumn();
            String sDate = "temp" + DataConvertor.formatZero(i+cable01+cable02+cable03+cable04+cable05,2);
            mdtc_cable.setData(sDate);
            String sContent = "6-" + DataConvertor.formatZero(i,2);
            mdtc_cable.setDefaultContent(sContent);
            mdtc_cable.setTitle(sContent);
            mdtc_cable.setVisible(true);
            myDTCList.add(mdtc_cable);
        }

        return myDTCList;
    }

}
