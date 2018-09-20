package com.system.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DataConvertor {

    public static String getByteState(Byte byteValue) {
        if (byteValue == 1)
            return "开";
        else return "关";
    }

    public static String getBoolState(boolean bValue) {
        if (bValue == true)
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
        String sReturnValue = FormatZero(sDecValue, iNeedLen);
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
        String sReturnValue = FormatZero(sHex, iNeedLen);
        return sReturnValue;
    }

    /**
     * 10进制字符串数组转换成十六进制字符串数组，
     *
     * @param sDecs    十进制进制字符串
     * @param iNeedLen 十六进制字符串长度
     * @return
     */
    public static String[] ConvertDecsToHexs(String[] sDecs, int iNeedLen) {
        String sHexs[] = new String[sDecs.length];
        for (int i = 0; i < sDecs.length; i++) {
            int iDec = Integer.valueOf(sDecs[i]);
            String sHex = Integer.toHexString(iDec);
            sHexs[i] = FormatZero(sHex, iNeedLen);
        }
        return sHexs;
    }

    public static String FormatZero(String sVaule, int iNeedLen) {
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

    public static String findMaxValue(List<String> maxValues) {
        if (maxValues.size() < 1)
            return "0";
        float max = Float.valueOf(maxValues.get(0));
        for (int i = 0; i < maxValues.size(); i++) {
            float nowValue = Float.valueOf(maxValues.get(i));
            if (max < nowValue) {
                max = nowValue;
            }
        }
        return String.valueOf(max);
    }

    public static String findMinValue(List<String> minValues) {
        if (minValues.size() < 1)
            return "0";
        float min = Float.valueOf(minValues.get(0));
        for (int i = 0; i < minValues.size(); i++) {
            float nowValue = Float.valueOf(minValues.get(i));
            if (min > nowValue) {
                min = nowValue;
            }
        }
        return String.valueOf(min);
    }

    /**
     * 根据最大值、最小值、间隔数，求出间隔距离
     *
     * @param max
     * @param min
     * @param splitNum
     * @return
     */
    public static String findInterval(String max, String min, String splitNum) {
        float fmax = Float.parseFloat(max);
        float fmin = Float.parseFloat(min);
        float fdistance = fmax - fmin;
        float fInterval = fdistance / Integer.valueOf(splitNum);
        int iInterval = (int) Math.ceil(fInterval);
        /*DecimalFormat df = new DecimalFormat("#.00");
        String f2Interval = df.format(fInterval);*/
        return String.valueOf(iInterval);
    }

    /**
     * 根据最小值，间隔，间隔数，求出最大值。
     *
     * @param min
     * @param interval
     * @param splitNum
     * @return
     */
    public static String findMaxValue(String min, String interval, String splitNum) {
        float finterval = Float.parseFloat(interval);
        float fmin = Float.parseFloat(min);
        float fmax = fmin + finterval * Integer.valueOf(splitNum);
        return String.valueOf(fmax);
    }

    //合成浮点数小数位数
    public static float formatFloat(float fvalue, int decimalDigit) {
        int scale = decimalDigit;//设置位数
        int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal((double) fvalue);
        bd = bd.setScale(scale, roundingMode);
        fvalue = bd.floatValue();
        return fvalue;
    }

    public static long DateCompare(String s1, String s2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = sdf.parse(s1);
            Date d2 = sdf.parse(s2);
            return (d1.getTime() - d2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
