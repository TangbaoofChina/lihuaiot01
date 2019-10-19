package com.system.util;

import com.system.po.FeedC411.FC411HisTemp;

import java.util.ArrayList;
import java.util.List;

public class FeedC411Util {
    public static List<String> getDate01List(List<FC411HisTemp> FC411HisTempList){
        List<String> sDateList = new ArrayList<>();
        for (int i = 0; i< FC411HisTempList.size(); i++){
            if(!sDateList.contains(FC411HisTempList.get(i).getSendDate())){
                sDateList.add(FC411HisTempList.get(i).getSendDate());
            }
        }
        List<String> newDateList = sDateList;
        return newDateList;
    }
}
