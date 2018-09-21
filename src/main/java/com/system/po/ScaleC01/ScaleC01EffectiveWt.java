package com.system.po.ScaleC01;

import com.system.po.parameter.OneDataDetail;

import java.util.ArrayList;
import java.util.List;

public class ScaleC01EffectiveWt {
    private int weight01;
    private int weight02;
    private int weight03;
    private int weight04;
    private int weight05;
    private int weight06;
    private int weight07;
    private int weight08;
    private int weight09;

    public int getWeight01() {
        return weight01;
    }

    public void setWeight01(int weight01) {
        this.weight01 = weight01;
    }

    public int getWeight02() {
        return weight02;
    }

    public void setWeight02(int weight02) {
        this.weight02 = weight02;
    }

    public int getWeight03() {
        return weight03;
    }

    public void setWeight03(int weight03) {
        this.weight03 = weight03;
    }

    public int getWeight04() {
        return weight04;
    }

    public void setWeight04(int weight04) {
        this.weight04 = weight04;
    }

    public int getWeight05() {
        return weight05;
    }

    public void setWeight05(int weight05) {
        this.weight05 = weight05;
    }

    public int getWeight06() {
        return weight06;
    }

    public void setWeight06(int weight06) {
        this.weight06 = weight06;
    }

    public int getWeight07() {
        return weight07;
    }

    public void setWeight07(int weight07) {
        this.weight07 = weight07;
    }

    public int getWeight08() {
        return weight08;
    }

    public void setWeight08(int weight08) {
        this.weight08 = weight08;
    }

    public int getWeight09() {
        return weight09;
    }

    public void setWeight09(int weight09) {
        this.weight09 = weight09;
    }

    public ScaleC01EffectiveWt() {
    }

    public ScaleC01EffectiveWt(List<Integer> scaleC01WtList) {
        int count = scaleC01WtList.size();
        if (count == 1) {
            this.setWeight01(scaleC01WtList.get(0));
        } else if (count == 2) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
        } else if (count == 3) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
        } else if (count == 4) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
            this.setWeight04(scaleC01WtList.get(3));
        } else if (count == 5) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
            this.setWeight04(scaleC01WtList.get(3));
            this.setWeight05(scaleC01WtList.get(4));
        } else if (count == 6) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
            this.setWeight04(scaleC01WtList.get(3));
            this.setWeight05(scaleC01WtList.get(4));
            this.setWeight06(scaleC01WtList.get(5));
        } else if (count == 7) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
            this.setWeight04(scaleC01WtList.get(3));
            this.setWeight05(scaleC01WtList.get(4));
            this.setWeight06(scaleC01WtList.get(5));
            this.setWeight07(scaleC01WtList.get(6));
        } else if (count == 8) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
            this.setWeight04(scaleC01WtList.get(3));
            this.setWeight05(scaleC01WtList.get(4));
            this.setWeight06(scaleC01WtList.get(5));
            this.setWeight07(scaleC01WtList.get(6));
            this.setWeight08(scaleC01WtList.get(7));
        } else if (count == 9) {
            this.setWeight01(scaleC01WtList.get(0));
            this.setWeight02(scaleC01WtList.get(1));
            this.setWeight03(scaleC01WtList.get(2));
            this.setWeight04(scaleC01WtList.get(3));
            this.setWeight05(scaleC01WtList.get(4));
            this.setWeight06(scaleC01WtList.get(5));
            this.setWeight07(scaleC01WtList.get(6));
            this.setWeight08(scaleC01WtList.get(7));
            this.setWeight09(scaleC01WtList.get(8));
        }
    }

    public List<OneDataDetail> getDdl(){
        List<OneDataDetail> dataDetails = new ArrayList<>();
        OneDataDetail oneDdWt01 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt01.setName("weight01");
        //填入某一行第一列值
        oneDdWt01.setValue(String.valueOf(getWeight01()));
        OneDataDetail oneDdWt02 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt02.setName("weight02");
        //填入某一行第一列值
        oneDdWt02.setValue(String.valueOf(getWeight02()));
        OneDataDetail oneDdWt03 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt03.setName("weight03");
        //填入某一行第一列值
        oneDdWt03.setValue(String.valueOf(getWeight03()));
        OneDataDetail oneDdWt04 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt04.setName("weight04");
        //填入某一行第一列值
        oneDdWt04.setValue(String.valueOf(getWeight04()));
        OneDataDetail oneDdWt05 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt05.setName("weight05");
        //填入某一行第一列值
        oneDdWt05.setValue(String.valueOf(getWeight05()));
        OneDataDetail oneDdWt06 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt06.setName("weight06");
        //填入某一行第一列值
        oneDdWt06.setValue(String.valueOf(getWeight06()));
        OneDataDetail oneDdWt07 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt07.setName("weight07");
        //填入某一行第一列值
        oneDdWt07.setValue(String.valueOf(getWeight07()));
        OneDataDetail oneDdWt08 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt08.setName("weight08");
        //填入某一行第一列值
        oneDdWt08.setValue(String.valueOf(getWeight08()));
        OneDataDetail oneDdWt09 = new OneDataDetail();
        //填入某一行第一列重量--填入列头信息
        oneDdWt09.setName("weight09");
        //填入某一行第一列值
        oneDdWt09.setValue(String.valueOf(getWeight09()));
        dataDetails.add(oneDdWt01);
        dataDetails.add(oneDdWt02);
        dataDetails.add(oneDdWt03);
        dataDetails.add(oneDdWt04);
        dataDetails.add(oneDdWt05);
        dataDetails.add(oneDdWt06);
        dataDetails.add(oneDdWt07);
        dataDetails.add(oneDdWt08);
        dataDetails.add(oneDdWt09);
        return dataDetails;
    }

}
