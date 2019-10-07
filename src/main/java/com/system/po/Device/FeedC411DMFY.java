package com.system.po.Device;

import com.system.po.FeedC411.SiloCable;
import com.system.po.FeedC411.SiloFloor;
import com.system.po.MydataTableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * 安徽阜阳分公司-饲料部
 */
public class FeedC411DMFY extends FeedC411DM{

    /**
     * 筒仓电缆
     */
    List<SiloCable> cableList;
    /**
     * 筒仓层
     */
    List<SiloFloor> floors;

    /**最高温*/
    float high;
    /**最低温*/
    float low;
    /**平均温*/
    float avg;

    public List<SiloCable> getCableList() {
        return cableList;
    }

    public void setCableList(List<SiloCable> cableList) {
        this.cableList = cableList;
    }

    public List<SiloFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<SiloFloor> floors) {
        this.floors = floors;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public List<MydataTableColumn> getDeviceHead() {
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

        //电缆1
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("temp01");
        mdtc3.setDefaultContent("1-01");
        mdtc3.setTitle("1-01");
        mdtc3.setVisible(true);

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("temp02");
        mdtc4.setDefaultContent("1-02");
        mdtc4.setTitle("1-02");
        mdtc4.setVisible(true);

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("temp03");
        mdtc5.setDefaultContent("1-03");
        mdtc5.setTitle("1-03");
        mdtc5.setVisible(true);

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("temp04");
        mdtc6.setDefaultContent("1-04");
        mdtc6.setTitle("1-04");
        mdtc6.setVisible(true);

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("temp05");
        mdtc7.setDefaultContent("1-05");
        mdtc7.setTitle("1-05");
        mdtc7.setVisible(true);

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("temp06");
        mdtc8.setDefaultContent("1-06");
        mdtc8.setTitle("1-06");
        mdtc8.setVisible(true);

        MydataTableColumn mdtc9 = new MydataTableColumn();
        mdtc9.setData("temp07");
        mdtc9.setDefaultContent("1-07");
        mdtc9.setTitle("1-07");
        mdtc9.setVisible(true);

        MydataTableColumn mdtc10 = new MydataTableColumn();
        mdtc10.setData("temp08");
        mdtc10.setDefaultContent("1-08");
        mdtc10.setTitle("1-08");
        mdtc10.setVisible(true);

        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("temp09");
        mdtc11.setDefaultContent("1-09");
        mdtc11.setTitle("1-09");
        mdtc11.setVisible(true);

        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("temp10");
        mdtc12.setDefaultContent("1-10");
        mdtc12.setTitle("1-10");
        mdtc12.setVisible(true);

        //电缆2
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("temp11");
        mdtc13.setDefaultContent("2-01");
        mdtc13.setTitle("2-01");
        mdtc13.setVisible(true);

        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("temp12");
        mdtc14.setDefaultContent("2-02");
        mdtc14.setTitle("2-02");
        mdtc14.setVisible(true);

        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("temp13");
        mdtc15.setDefaultContent("2-03");
        mdtc15.setTitle("2-03");
        mdtc15.setVisible(true);

        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("temp14");
        mdtc16.setDefaultContent("2-04");
        mdtc16.setTitle("2-04");
        mdtc16.setVisible(true);

        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("temp15");
        mdtc17.setDefaultContent("2-05");
        mdtc17.setTitle("2-05");
        mdtc17.setVisible(true);

        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("temp16");
        mdtc18.setDefaultContent("2-06");
        mdtc18.setTitle("2-06");
        mdtc18.setVisible(true);

        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("temp17");
        mdtc19.setDefaultContent("2-07");
        mdtc19.setTitle("2-07");
        mdtc19.setVisible(true);

        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("temp18");
        mdtc20.setDefaultContent("2-08");
        mdtc20.setTitle("2-08");
        mdtc20.setVisible(true);

        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("temp19");
        mdtc21.setDefaultContent("2-09");
        mdtc21.setTitle("2-09");
        mdtc21.setVisible(true);

        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("temp20");
        mdtc22.setDefaultContent("2-10");
        mdtc22.setTitle("2-10");
        mdtc22.setVisible(true);

        //电缆3
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("temp21");
        mdtc23.setDefaultContent("3-01");
        mdtc23.setTitle("3-01");
        mdtc23.setVisible(true);

        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("temp22");
        mdtc24.setDefaultContent("3-02");
        mdtc24.setTitle("3-02");
        mdtc24.setVisible(true);

        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("temp23");
        mdtc25.setDefaultContent("3-03");
        mdtc25.setTitle("3-03");
        mdtc25.setVisible(true);

        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("temp24");
        mdtc26.setDefaultContent("3-04");
        mdtc26.setTitle("3-04");
        mdtc26.setVisible(true);

        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("temp25");
        mdtc27.setDefaultContent("3-05");
        mdtc27.setTitle("3-05");
        mdtc27.setVisible(true);

        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("temp26");
        mdtc28.setDefaultContent("3-06");
        mdtc28.setTitle("3-06");
        mdtc28.setVisible(true);

        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("temp27");
        mdtc29.setDefaultContent("3-07");
        mdtc29.setTitle("3-07");
        mdtc29.setVisible(true);

        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("temp28");
        mdtc30.setDefaultContent("3-08");
        mdtc30.setTitle("3-08");
        mdtc30.setVisible(true);

        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("temp29");
        mdtc31.setDefaultContent("3-09");
        mdtc31.setTitle("3-09");
        mdtc31.setVisible(true);

        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("temp30");
        mdtc32.setDefaultContent("3-10");
        mdtc32.setTitle("3-10");
        mdtc32.setVisible(true);

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
        //电缆01
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);
        myDTCList.add(mdtc5);
        myDTCList.add(mdtc6);
        myDTCList.add(mdtc7);
        myDTCList.add(mdtc8);
        myDTCList.add(mdtc9);
        myDTCList.add(mdtc10);
        myDTCList.add(mdtc11);
        myDTCList.add(mdtc12);
        //电缆02
        myDTCList.add(mdtc13);
        myDTCList.add(mdtc14);
        myDTCList.add(mdtc15);
        myDTCList.add(mdtc16);
        myDTCList.add(mdtc17);
        myDTCList.add(mdtc18);
        myDTCList.add(mdtc19);
        myDTCList.add(mdtc20);
        myDTCList.add(mdtc21);
        myDTCList.add(mdtc22);
        //电缆03
        myDTCList.add(mdtc23);
        myDTCList.add(mdtc24);
        myDTCList.add(mdtc25);
        myDTCList.add(mdtc26);
        myDTCList.add(mdtc27);
        myDTCList.add(mdtc28);
        myDTCList.add(mdtc29);
        myDTCList.add(mdtc30);
        myDTCList.add(mdtc31);
        myDTCList.add(mdtc32);

        return myDTCList;
    }

    public void getDetail(){
        if(this.getCables() < 1)
            return;
        if(this.getCable01Nums() > 0){
            SiloCable siloCable = new SiloCable();
            siloCable.setNum(1);
            siloCable.setQuantity(this.getCable01Nums());

        }
    }
}
