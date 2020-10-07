package com.system.po.Phone.Pswg215;

import lombok.Data;

/**
 * @ClassName PSwg215OneParam
 * @Description 单个参数
 * @Author tangbao
 * @Date 2020-10-07 9:25
 * @Version 1.0
 **/
@Data
public class PSwg215OneParam {
    String title;
    String titleAlign = "left";
    float titleScale;
    String align ="center";
    String value01;
    String color01;
    float value01Scale;
    String value02;
    String color02;
    float value02Scale;
    int valCount; //表示有几个值,0:无值，1:1个值；2:2个值

    public PSwg215OneParam(){}

    /**
     *
     * @param title 参数名称
     * @param titleAlign 参数对齐方式
     * @param titleScale 参数占用一行的百分比
     * @param align 数值的对齐方式
     */
    public PSwg215OneParam(String title,String titleAlign,float titleScale,int valCount,String align){
        this.setTitle(title);
        this.setTitleAlign(titleAlign);
        this.setTitleScale(titleScale);
        this.setValCount(valCount);
        this.setAlign(align);
    }
}
