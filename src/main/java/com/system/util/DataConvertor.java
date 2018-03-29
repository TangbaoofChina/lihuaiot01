package com.system.util;

public class DataConvertor {

    public static String getBoolState01On(Byte byteValue)
    {
        if (byteValue == 1)
            return "开";
        else return "关";
    }

}
