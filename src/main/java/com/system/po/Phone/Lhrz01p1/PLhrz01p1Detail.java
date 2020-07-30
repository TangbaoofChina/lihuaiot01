package com.system.po.Phone.Lhrz01p1;

import lombok.Data;

import java.util.List;

/**
 * @ClassName PLhrz01p1RDI
 * @Description TODO
 * @Author tangbao
 * @Date 2020-07-30 14:19
 * @Version 1.0
 **/
@Data
public class PLhrz01p1Detail {
    private String devNum;
    private String title;
    private String state;
    private String date;
    private List<PLhrz01p1PartDetail> data;
}
