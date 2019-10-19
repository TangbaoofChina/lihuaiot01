package com.system.po.FeedC411;

import com.system.po.Device.FeedC411DM;
import com.system.util.DataConvertor;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 筒仓温度点
 */
public class FC411Temp {
    /**
     * 温度值
     */
    float temp;
    /**
     * 是否启用 0：启用；1：禁用
     */
    boolean enable;
    /**
     * 是否正常 0：正常；1：故障
     */
    boolean normal;
    /**
     * 测温点编号
     */
    int num;
    /**
     * 测温点报警颜色
     */
    String color;
    /**
     *实际温度名称与采集温度名称关系
     */
    FC411TempNameRelation nameRelation;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isNormal() {
        return normal;
    }

    public void setNormal(boolean normal) {
        this.normal = normal;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FC411TempNameRelation getNameRelation() {
        return nameRelation;
    }

    public void setNameRelation(FC411TempNameRelation nameRelation) {
        this.nameRelation = nameRelation;
    }

    public FC411Temp(){}

    public FC411Temp(int num, float temp, String usedState, String faultState, float high){
        this.setNum(num);
        this.setTemp(temp);
        //0：启用；1：禁用 需要取反
        this.setEnable(!DataConvertor.Hex2Bool(usedState,num-1));
        //0：正常；1：故障 需要取反
        this.setNormal(!DataConvertor.Hex2Bool(faultState,num-1));
        if(temp > high)
            this.setColor("FF0000");
        else
            this.setColor("000000");
    }

    /**
     * 合成温度点
     * @param index 电缆序号
     * @param num 电缆温度序号
     * @param feedC411DM 筒仓测温对象
     */
    public FC411Temp(int index,int num,FeedC411DM feedC411DM){
        String usedState = "";
        String faultState = "";
        int indexAll = 0;
        switch (index) {
            case 1:
                usedState = feedC411DM.getCable01Used();
                faultState = feedC411DM.getCable01Fault();
                getTempValue(1, num, indexAll + num + 1, feedC411DM);
                break;
            case 2:
                usedState = feedC411DM.getCable02Used();
                faultState = feedC411DM.getCable02Fault();
                indexAll = indexAll + feedC411DM.getCable01Nums();
                getTempValue(2, num, indexAll + num + 1, feedC411DM);
                break;
            case 3:
                usedState = feedC411DM.getCable03Used();
                faultState = feedC411DM.getCable03Fault();
                indexAll = indexAll + feedC411DM.getCable02Nums() + feedC411DM.getCable01Nums();
                getTempValue(3, num, indexAll + num + 1, feedC411DM);
                break;
            case 4:
                usedState = feedC411DM.getCable04Used();
                faultState = feedC411DM.getCable04Fault();
                indexAll = indexAll + feedC411DM.getCable03Nums() + feedC411DM.getCable02Nums() + feedC411DM.getCable01Nums();
                getTempValue(4, num, indexAll + num + 1, feedC411DM);
                break;
            case 5:
                usedState = feedC411DM.getCable05Used();
                faultState = feedC411DM.getCable05Fault();
                indexAll = indexAll + feedC411DM.getCable04Nums() + feedC411DM.getCable03Nums() + feedC411DM.getCable02Nums() + feedC411DM.getCable01Nums();
                getTempValue(5, num, indexAll + num + 1, feedC411DM);
                break;
            case 6:
                usedState = feedC411DM.getCable06Used();
                faultState = feedC411DM.getCable06Fault();
                indexAll = indexAll + feedC411DM.getCable04Nums() + feedC411DM.getCable04Nums() + feedC411DM.getCable03Nums() + feedC411DM.getCable02Nums() + feedC411DM.getCable01Nums();
                getTempValue(6, num, indexAll + num + 1, feedC411DM);
                break;
        }
        this.setNum(num+1);
        //0：启用；1：禁用 需要取反
        this.setEnable(!DataConvertor.Hex2Bool(usedState,num));
        //0：正常；1：故障 需要取反
        this.setNormal(!DataConvertor.Hex2Bool(faultState,num));
    }

    /**
     * //生成测温点对象
     * @param cableNum
     * @param feedC411DM
     * @return
     */
    private void getTempValue(int cableNum,int num,int indexAll, FeedC411DM feedC411DM) {
        String aColor = "000000";
        float aTemp = 0;
        String realName = String.valueOf(cableNum) + "-" + String.valueOf(num + 1);
        String communicateName = "temp" + DataConvertor.formatZero(indexAll, 2);
        switch (indexAll) {
            case 1:
                aTemp = feedC411DM.getTemp01();
                break;
            case 2:
                aTemp = feedC411DM.getTemp02();
                break;
            case 3:
                aTemp = feedC411DM.getTemp03();
                break;
            case 4:
                aTemp = feedC411DM.getTemp04();
                break;
            case 5:
                aTemp = feedC411DM.getTemp05();
                break;
            case 6:
                aTemp = feedC411DM.getTemp06();
                break;
            case 7:
                aTemp = feedC411DM.getTemp07();
                break;
            case 8:
                aTemp = feedC411DM.getTemp08();
                break;
            case 9:
                aTemp = feedC411DM.getTemp09();
                break;
            case 10:
                aTemp = feedC411DM.getTemp10();
                break;
            case 11:
                aTemp = feedC411DM.getTemp11();
                break;
            case 12:
                aTemp = feedC411DM.getTemp12();
                break;
            case 13:
                aTemp = feedC411DM.getTemp13();
                break;
            case 14:
                aTemp = feedC411DM.getTemp14();
                break;
            case 15:
                aTemp = feedC411DM.getTemp15();
                break;
            case 16:
                aTemp = feedC411DM.getTemp16();
                break;
            case 17:
                aTemp = feedC411DM.getTemp17();
                break;
            case 18:
                aTemp = feedC411DM.getTemp18();
                break;
            case 19:
                aTemp = feedC411DM.getTemp19();
                break;
            case 20:
                aTemp = feedC411DM.getTemp20();
                break;
            case 21:
                aTemp = feedC411DM.getTemp21();
                break;
            case 22:
                aTemp = feedC411DM.getTemp22();
                break;
            case 23:
                aTemp = feedC411DM.getTemp23();
                break;
            case 24:
                aTemp = feedC411DM.getTemp24();
                break;
            case 25:
                aTemp = feedC411DM.getTemp25();
                break;
            case 26:
                aTemp = feedC411DM.getTemp26();
                break;
            case 27:
                aTemp = feedC411DM.getTemp27();
                break;
            case 28:
                aTemp = feedC411DM.getTemp28();
                break;
            case 29:
                aTemp = feedC411DM.getTemp29();
                break;
            case 30:
                aTemp = feedC411DM.getTemp30();
                break;
            case 31:
                aTemp = feedC411DM.getTemp31();
                break;
            case 32:
                aTemp = feedC411DM.getTemp32();
                break;
            case 33:
                aTemp = feedC411DM.getTemp33();
                break;
            case 34:
                aTemp = feedC411DM.getTemp34();
                break;
            case 35:
                aTemp = feedC411DM.getTemp35();
                break;
            case 36:
                aTemp = feedC411DM.getTemp36();
                break;
            case 37:
                aTemp = feedC411DM.getTemp37();
                break;
            case 38:
                aTemp = feedC411DM.getTemp38();
                break;
            case 39:
                aTemp = feedC411DM.getTemp39();
                break;
            case 40:
                aTemp = feedC411DM.getTemp40();
                break;
            case 41:
                aTemp = feedC411DM.getTemp41();
                break;
            case 42:
                aTemp = feedC411DM.getTemp42();
                break;
            case 43:
                aTemp = feedC411DM.getTemp43();
                break;
            case 44:
                aTemp = feedC411DM.getTemp44();
                break;
            case 45:
                aTemp = feedC411DM.getTemp45();
                break;
            case 46:
                aTemp = feedC411DM.getTemp46();
                break;
            case 47:
                aTemp = feedC411DM.getTemp47();
                break;
            case 48:
                aTemp = feedC411DM.getTemp48();
                break;
            case 49:
                aTemp = feedC411DM.getTemp49();
                break;
            case 50:
                aTemp = feedC411DM.getTemp50();
                break;
            case 51:
                aTemp = feedC411DM.getTemp51();
                break;
            case 52:
                aTemp = feedC411DM.getTemp52();
                break;
            case 53:
                aTemp = feedC411DM.getTemp53();
                break;
            case 54:
                aTemp = feedC411DM.getTemp54();
                break;
            case 55:
                aTemp = feedC411DM.getTemp55();
                break;
            case 56:
                aTemp = feedC411DM.getTemp56();
                break;
            case 57:
                aTemp = feedC411DM.getTemp57();
                break;
            case 58:
                aTemp = feedC411DM.getTemp58();
                break;
            case 59:
                aTemp = feedC411DM.getTemp59();
                break;
            case 60:
                aTemp = feedC411DM.getTemp60();
                break;
        }
        if (aTemp > feedC411DM.getHighThreshold())
            aColor = "FF0000";
        this.setTemp(aTemp);
        this.setColor(aColor);
        FC411TempNameRelation fc411TempNameRelation = new FC411TempNameRelation();
        fc411TempNameRelation.setRealName(realName);
        fc411TempNameRelation.setCommunicatName(communicateName);
        this.setNameRelation(fc411TempNameRelation);
    }
}
