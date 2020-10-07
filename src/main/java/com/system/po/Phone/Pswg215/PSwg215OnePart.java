package com.system.po.Phone.Pswg215;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PSwg215OnePart
 * @Description 每一部分
 * @Author tangbao
 * @Date 2020-10-07 9:29
 * @Version 1.0
 **/
@Data
public class PSwg215OnePart {
    int row;  //有几行
    String title;
    //每一行的数据
    List<PSwg215OneParam> pSwg215OneParams;
}
