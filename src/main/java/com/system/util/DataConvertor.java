package com.system.util;

import java.text.DecimalFormat;

public class DataConvertor {

    public static String getBoolState01On(Byte byteValue) {
        if (byteValue == 1)
            return "开";
        else return "关";
    }

    /**
     * 十六进制字符串转换成10进制字符串，
     *
     * @param sHex     十六进制字符串
     * @param iNeedLen 10进制字符串长度
     * @return
     */
    public static String ConvertHexToDec(String sHex, int iNeedLen) {
        int iDecValue = Integer.valueOf(sHex, 16);
        String sDecValue = String.valueOf(iDecValue);
        String sReturnValue = FormatZero(sDecValue,iNeedLen);
        return sReturnValue;
    }

    /**
     * 10进制字符串转换成十六进制字符串，
     *
     * @param sDec     十进制进制字符串
     * @param iNeedLen 16进制字符串长度
     * @return
     */
    public static String ConvertDecToHex(String sDec, int iNeedLen) {
        int iDec = Integer.valueOf(sDec);
        String sHex = Integer.toHexString(iDec);
        String sReturnValue = FormatZero(sHex,iNeedLen);
        return sReturnValue;
    }

    /**
     * 10进制字符串数组转换成十六进制字符串数组，
     *
     * @param sDecs 十进制进制字符串
     *              @param iNeedLen 十六进制字符串长度
     * @return
     */
    public static String[] ConvertDecsToHexs(String[] sDecs,int iNeedLen) {
        String sHexs[] = new String[sDecs.length];
        for (int i = 0; i < sDecs.length; i++) {
            int iDec = Integer.valueOf(sDecs[i]);
            String sHex = Integer.toHexString(iDec);
            sHexs[i] = FormatZero(sHex,iNeedLen);
        }
        return sHexs;
    }

    public static String FormatZero(String sVaule,int iNeedLen){
        int iNowLen = sVaule.length();
        String sReturnValue = sVaule;
        if (iNowLen > iNeedLen)
            sReturnValue = sVaule.substring(iNowLen - iNeedLen, iNowLen);
        else if (iNeedLen > iNowLen) {
            for (int i = 0; i < (iNeedLen - iNowLen); i++)
                sReturnValue = "0" + sReturnValue;
        }
        return sReturnValue;
    }

}
