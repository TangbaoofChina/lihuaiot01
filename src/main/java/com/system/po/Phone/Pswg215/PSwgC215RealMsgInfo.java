package com.system.po.Phone.Pswg215;

import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import lombok.Data;

import java.util.List;

@Data
public class PSwgC215RealMsgInfo {
    private String devNum;
    private String devName;
    private List<PSwg215OnePart> pSwg215OneParts;

}
