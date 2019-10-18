package com.system.util;

import com.system.po.FeedC411.SiloHisTemp;

import java.util.ArrayList;
import java.util.List;

public class FeedC411Util {
    public static List<String> getDate01List(List<SiloHisTemp> siloHisTempList){
        List<String> sDateList = new ArrayList<>();
        for (int i=0;i<siloHisTempList.size();i++){
            if(!sDateList.contains(siloHisTempList.get(i).getSendDate())){
                sDateList.add(siloHisTempList.get(i).getSendDate());
            }
        }
        List<String> newDateList = sDateList;
        return newDateList;
    }
}
