package com.system.util;

import com.system.po.Device.SwgC215DM;
import com.system.po.Phone.Pswg215.PSwg215OneParam;
import com.system.po.Phone.Pswg215.PSwg215OnePart;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Swg215Util
 * @Description TODO
 * @Author tangbao
 * @Date 2020-10-07 14:44
 * @Version 1.0
 **/
public class Swg215Util {

    public static List<PSwg215OnePart> formatSBR(SwgC215DM dm) {
        List<PSwg215OnePart> pSwg215OneParts = new ArrayList<PSwg215OnePart>();

        //第一部分 基本信息
        PSwg215OnePart pSwg215OnePart01 = new PSwg215OnePart();
        pSwg215OnePart01.setRow(9);
        pSwg215OnePart01.setTitle("基本信息");
        List<PSwg215OneParam> pSwg215OneParams01 = formatPart01("SBR",dm);
        pSwg215OnePart01.setPSwg215OneParams(pSwg215OneParams01);
        pSwg215OneParts.add(pSwg215OnePart01);

        //第二部分 预处理系统
        PSwg215OnePart pSwg215OnePart02 = new PSwg215OnePart();
        pSwg215OnePart02.setRow(15);
        pSwg215OnePart02.setTitle("预处理系统");
        List<PSwg215OneParam> pSwg215OneParams02 = formatPart02("SBR",dm);
        pSwg215OnePart02.setPSwg215OneParams(pSwg215OneParams02);
        pSwg215OneParts.add(pSwg215OnePart02);

        //第三部分 泥水分离系统
        PSwg215OnePart pSwg215OnePart03 = new PSwg215OnePart();
        pSwg215OnePart03.setRow(5);
        pSwg215OnePart03.setTitle("泥水分离系统");
        List<PSwg215OneParam> pSwg215OneParams03 = formatPart03("SBR",dm);
        pSwg215OnePart03.setPSwg215OneParams(pSwg215OneParams03);
        pSwg215OneParts.add(pSwg215OnePart03);

        //第四部分 工艺运行状态
        PSwg215OnePart pSwg215OnePart04 = new PSwg215OnePart();
        pSwg215OnePart04.setRow(10);
        pSwg215OnePart04.setTitle("工艺运行状态");
        List<PSwg215OneParam> pSwg215OneParams04 = formatSBRPart04(dm);
        pSwg215OnePart04.setPSwg215OneParams(pSwg215OneParams04);
        pSwg215OneParts.add(pSwg215OnePart04);

        //第五部分 工艺流程设定时间(分钟)
        PSwg215OnePart pSwg215OnePart05 = new PSwg215OnePart();
        pSwg215OnePart05.setRow(6);
        pSwg215OnePart05.setTitle("工艺流程设定时间(分钟)");
        List<PSwg215OneParam> pSwg215OneParams05 = formatSBRPart05(dm);
        pSwg215OnePart05.setPSwg215OneParams(pSwg215OneParams05);
        pSwg215OneParts.add(pSwg215OnePart05);

        return pSwg215OneParts;
    }

    public static List<PSwg215OnePart> formatA2O(SwgC215DM dm) {
        List<PSwg215OnePart> pSwg215OneParts = new ArrayList<PSwg215OnePart>();

        //第一部分 基本信息
        PSwg215OnePart pSwg215OnePart01 = new PSwg215OnePart();
        pSwg215OnePart01.setRow(9);
        pSwg215OnePart01.setTitle("基本信息");
        List<PSwg215OneParam> pSwg215OneParams01 = formatPart01("A2O",dm);
        pSwg215OnePart01.setPSwg215OneParams(pSwg215OneParams01);
        pSwg215OneParts.add(pSwg215OnePart01);

        //第二部分 预处理系统
        PSwg215OnePart pSwg215OnePart02 = new PSwg215OnePart();
        pSwg215OnePart02.setRow(14);
        pSwg215OnePart02.setTitle("预处理系统");
        List<PSwg215OneParam> pSwg215OneParams02 = formatPart02("A2O",dm);
        pSwg215OnePart02.setPSwg215OneParams(pSwg215OneParams02);
        pSwg215OneParts.add(pSwg215OnePart02);

        //第三部分 泥水分离系统
        PSwg215OnePart pSwg215OnePart03 = new PSwg215OnePart();
        pSwg215OnePart03.setRow(5);
        pSwg215OnePart03.setTitle("泥水分离系统");
        List<PSwg215OneParam> pSwg215OneParams03 = formatPart03("A2O",dm);
        pSwg215OnePart03.setPSwg215OneParams(pSwg215OneParams03);
        pSwg215OneParts.add(pSwg215OnePart03);

        //第四部分 A2O工艺
        PSwg215OnePart pSwg215OnePart04 = new PSwg215OnePart();
        pSwg215OnePart04.setRow(5);
        pSwg215OnePart04.setTitle("A2O工艺");
        List<PSwg215OneParam> pSwg215OneParams04 = formatA2OPart04(dm);
        pSwg215OnePart04.setPSwg215OneParams(pSwg215OneParams04);
        pSwg215OneParts.add(pSwg215OnePart04);

        //第五部分 末端混凝系统
        PSwg215OnePart pSwg215OnePart05 = new PSwg215OnePart();
        pSwg215OnePart05.setRow(10);
        pSwg215OnePart05.setTitle("末端混凝系统");
        List<PSwg215OneParam> pSwg215OneParams05 = formatA2OPart05(dm);
        pSwg215OnePart05.setPSwg215OneParams(pSwg215OneParams05);
        pSwg215OneParts.add(pSwg215OnePart05);

        return pSwg215OneParts;
    }

    public static List<PSwg215OneParam> formatPart01(String sbrA2o,SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();

        //时间
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("时间：","left",0.5f,1,"center");
        pSwg215OneParam01.setValue01(dm.getSendDate());
        pSwg215OneParam01.setColor01(defaultColor);
        pSwg215OneParam01.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam01);

        //累计流量（m³）
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("累计流量：","left",0.5f,1,"center");
        pSwg215OneParam02.setValue01(String.valueOf(dm.getFlowmeter()) + "m³");
        pSwg215OneParam02.setColor01(defaultColor);
        pSwg215OneParam02.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam02);

        //当日流量(m³)
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("当日流量：","left",0.5f,1,"center");
        pSwg215OneParam03.setValue01(String.valueOf(dm.getTodayFlowmeter()) + "m³");
        pSwg215OneParam03.setColor01(defaultColor);
        pSwg215OneParam03.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam03);

        //累计电量
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("累计电量：","left",0.5f,1,"center");
        pSwg215OneParam04.setValue01(String.valueOf(dm.getImpEP()) + " ");
        pSwg215OneParam04.setColor01(defaultColor);
        pSwg215OneParam04.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam04);

        //当日电量
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("当日电量：","left",0.5f,1,"center");
        pSwg215OneParam05.setValue01(String.valueOf(dm.getTodayEP()) + " ");
        pSwg215OneParam05.setColor01(defaultColor);
        pSwg215OneParam05.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam05);

        //水温
        PSwg215OneParam pSwg215OneParam06 = new PSwg215OneParam("水温：","left",0.5f,1,"center");
        pSwg215OneParam06.setValue01(String.valueOf(dm.getWaterTemp01()) + " ");
        pSwg215OneParam06.setColor01(defaultColor);
        pSwg215OneParam06.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam06);
        //环境温度
        PSwg215OneParam pSwg215OneParam07 = new PSwg215OneParam("环境温度：","left",0.5f,1,"center");
        pSwg215OneParam07.setValue01(String.valueOf(dm.getAirTemp01()) + " ");
        pSwg215OneParam07.setColor01(defaultColor);
        pSwg215OneParam07.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam07);
        //设备在线状态
        PSwg215OneParam pSwg215OneParam08 = new PSwg215OneParam("状态：","left",0.5f,1,"center");
        if (dm.getDState().equals("离线") ) {
            pSwg215OneParam08.setValue01(dm.getDState());
            pSwg215OneParam08.setColor01(alarmColor);
        } else {
            pSwg215OneParam08.setValue01(dm.getDState());
            pSwg215OneParam08.setColor01(defaultColor);
        }
        pSwg215OneParam08.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam08);
        //主要工艺
        PSwg215OneParam pSwg215OneParam09 = new PSwg215OneParam("工艺：","left",0.5f,1,"center");
        if (sbrA2o .equals("SBR")) {
            pSwg215OneParam09.setValue01("SBR");
        } else {
            pSwg215OneParam09.setValue01("A2O");
        }
        pSwg215OneParam09.setColor01(defaultColor);
        pSwg215OneParam09.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam09);

        return pSwg215OneParams;
    }

    public static List<PSwg215OneParam> formatPart02(String sbrA2o,SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();

        //机械格栅
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("机械格栅：","left",0.4f,2,"center");
        if (dm.getYdsgsRun()) {
            pSwg215OneParam01.setValue01("运行");
            pSwg215OneParam01.setColor01(normalRunColor);
        } else {
            pSwg215OneParam01.setValue01("停止");
            pSwg215OneParam01.setColor01(normalStopColor);
        }
        pSwg215OneParam01.setValue01Scale(0.3f);
        pSwg215OneParam01.setValue02(String.valueOf(dm.getYdsgsRunMin()));
        pSwg215OneParam01.setColor02(defaultColor);
        pSwg215OneParam01.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam01);
        //集水井提升泵
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("集水井提升泵：","left",0.4f,2,"center");
        if (dm.getCollectWellPumpRun()) {
            pSwg215OneParam02.setValue01("运行");
            pSwg215OneParam02.setColor01(normalRunColor);
        } else {
            pSwg215OneParam02.setValue01("停止");
            pSwg215OneParam02.setColor01(normalStopColor);
        }
        pSwg215OneParam02.setValue01Scale(0.3f);
        pSwg215OneParam02.setValue02(String.valueOf(dm.getCollectWellPumpRunMin()));
        pSwg215OneParam02.setColor02(defaultColor);
        pSwg215OneParam02.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam02);
        //集水池搅拌机01
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("集水池搅拌机01：","left",0.4f,2,"center");
        if (dm.getCollectMixer01Run()) {
            pSwg215OneParam03.setValue01("运行");
            pSwg215OneParam03.setColor01(normalRunColor);
        } else {
            pSwg215OneParam03.setValue01("停止");
            pSwg215OneParam03.setColor01(normalStopColor);
        }
        pSwg215OneParam03.setValue01Scale(0.3f);
        pSwg215OneParam03.setValue02(String.valueOf(dm.getCollectMixer01RunMin()));
        pSwg215OneParam03.setColor02(defaultColor);
        pSwg215OneParam03.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam03);
        //集水池搅拌机02
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("集水池搅拌机02：","left",0.4f,2,"center");
        if (dm.getCollectMixer02Run()) {
            pSwg215OneParam04.setValue01("运行");
            pSwg215OneParam04.setColor01(normalRunColor);
        } else {
            pSwg215OneParam04.setValue01("停止");
            pSwg215OneParam04.setColor01(normalStopColor);
        }
        pSwg215OneParam04.setValue01Scale(0.3f);
        pSwg215OneParam04.setValue02(String.valueOf(dm.getCollectMixer02RunMin()));
        pSwg215OneParam04.setColor02(defaultColor);
        pSwg215OneParam04.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam04);
        //除磷投加机
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("除磷投加机：","left",0.4f,2,"center");
        if (dm.getDephosphorizeRun()) {
            pSwg215OneParam05.setValue01("运行");
            pSwg215OneParam05.setColor01(normalRunColor);
        } else {
            pSwg215OneParam05.setValue01("停止");
            pSwg215OneParam05.setColor01(normalStopColor);
        }
        pSwg215OneParam05.setValue01Scale(0.3f);
        pSwg215OneParam05.setValue02(String.valueOf(dm.getDephosphorizeRunMin()));
        pSwg215OneParam05.setColor02(defaultColor);
        pSwg215OneParam05.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam05);
        //集水池提升泵
        PSwg215OneParam pSwg215OneParam06 = new PSwg215OneParam("集水池提升泵：","left",0.4f,2,"center");
        if (dm.getCollectPumpRun()) {
            pSwg215OneParam06.setValue01("运行");
            pSwg215OneParam06.setColor01(normalRunColor);
        } else {
            pSwg215OneParam06.setValue01("停止");
            pSwg215OneParam06.setColor01(normalStopColor);
        }
        pSwg215OneParam06.setValue01Scale(0.3f);
        pSwg215OneParam06.setValue02(String.valueOf(dm.getCollectPumpRunMin()));
        pSwg215OneParam06.setColor02(defaultColor);
        pSwg215OneParam06.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam06);
        //固液分离机
        PSwg215OneParam pSwg215OneParam07 = new PSwg215OneParam("固液分离机：","left",0.4f,2,"center");
        if (dm.getSolLiqRun()) {
            pSwg215OneParam07.setValue01("运行");
            pSwg215OneParam07.setColor01(normalRunColor);
        } else {
            pSwg215OneParam07.setValue01("停止");
            pSwg215OneParam07.setColor01(normalStopColor);
        }
        pSwg215OneParam07.setValue01Scale(0.3f);
        pSwg215OneParam07.setValue02(String.valueOf(dm.getSolLiqRunMin()));
        pSwg215OneParam07.setColor02(defaultColor);
        pSwg215OneParam07.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam07);
        //混合池01搅拌机
        PSwg215OneParam pSwg215OneParam08 = new PSwg215OneParam("混合池01搅拌机：","left",0.4f,2,"center");
        if (dm.getBldMixer01Run()) {
            pSwg215OneParam08.setValue01("运行");
            pSwg215OneParam08.setColor01(normalRunColor);
        } else {
            pSwg215OneParam08.setValue01("停止");
            pSwg215OneParam08.setColor01(normalStopColor);
        }
        pSwg215OneParam08.setValue01Scale(0.3f);
        pSwg215OneParam08.setValue02(String.valueOf(dm.getBldMixer01RunMin()));
        pSwg215OneParam08.setColor02(defaultColor);
        pSwg215OneParam08.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam08);
        //混反池搅拌机
        PSwg215OneParam pSwg215OneParam09 = new PSwg215OneParam("混反池搅拌机：","left",0.4f,2,"center");
        if (dm.getBldOpstMixer01Run()) {
            pSwg215OneParam09.setValue01("运行");
            pSwg215OneParam09.setColor01(normalRunColor);
        } else {
            pSwg215OneParam09.setValue01("停止");
            pSwg215OneParam09.setColor01(normalStopColor);
        }
        pSwg215OneParam09.setValue01Scale(0.3f);
        pSwg215OneParam09.setValue02(String.valueOf(dm.getBldOpstMixer01RunMin()));
        pSwg215OneParam09.setColor02(defaultColor);
        pSwg215OneParam09.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam09);
        //混沉池污泥泵
        PSwg215OneParam pSwg215OneParam10 = new PSwg215OneParam("混沉池污泥泵：","left",0.4f,2,"center");
        if (dm.getBldSinkPumpRun()) {
            pSwg215OneParam10.setValue01("运行");
            pSwg215OneParam10.setColor01(normalRunColor);
        } else {
            pSwg215OneParam10.setValue01("停止");
            pSwg215OneParam10.setColor01(normalStopColor);
        }
        pSwg215OneParam10.setValue01Scale(0.3f);
        pSwg215OneParam10.setValue02(String.valueOf(dm.getBldSinkPumpRunMin()));
        pSwg215OneParam10.setColor02(defaultColor);
        pSwg215OneParam10.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam10);
        //混凝剂01搅拌机
        PSwg215OneParam pSwg215OneParam11 = new PSwg215OneParam("混凝剂01搅拌机：","left",0.4f,2,"center");
        if (dm.getBldCglMixer01Run()) {
            pSwg215OneParam11.setValue01("运行");
            pSwg215OneParam11.setColor01(normalRunColor);
        } else {
            pSwg215OneParam11.setValue01("停止");
            pSwg215OneParam11.setColor01(normalStopColor);
        }
        pSwg215OneParam11.setValue01Scale(0.3f);
        pSwg215OneParam11.setValue02(String.valueOf(dm.getBldCglMixer01RunMin()));
        pSwg215OneParam11.setColor02(defaultColor);
        pSwg215OneParam11.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam11);
        //混凝剂01加药泵
        PSwg215OneParam pSwg215OneParam12 = new PSwg215OneParam("混凝剂01加药泵：","left",0.4f,2,"center");
        if (dm.getBldCglDosing01Run()) {
            pSwg215OneParam12.setValue01("运行");
            pSwg215OneParam12.setColor01(normalRunColor);
        } else {
            pSwg215OneParam12.setValue01("停止");
            pSwg215OneParam12.setColor01(normalStopColor);
        }
        pSwg215OneParam12.setValue01Scale(0.3f);
        pSwg215OneParam12.setValue02(String.valueOf(dm.getBldCglDosing01RunMin()));
        pSwg215OneParam12.setColor02(defaultColor);
        pSwg215OneParam12.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam12);
        //助凝剂01搅拌机
        PSwg215OneParam pSwg215OneParam13 = new PSwg215OneParam("助凝剂01搅拌机：","left",0.4f,2,"center");
        if (dm.getAstCglMixer01Run()) {
            pSwg215OneParam13.setValue01("运行");
            pSwg215OneParam13.setColor01(normalRunColor);
        } else {
            pSwg215OneParam13.setValue01("停止");
            pSwg215OneParam13.setColor01(normalStopColor);
        }
        pSwg215OneParam13.setValue01Scale(0.3f);
        pSwg215OneParam13.setValue02(String.valueOf(dm.getAstCglMixer01RunMin()));
        pSwg215OneParam13.setColor02(defaultColor);
        pSwg215OneParam13.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam13);
        //助凝剂01加药泵
        PSwg215OneParam pSwg215OneParam14 = new PSwg215OneParam("助凝剂01加药泵：","left",0.4f,2,"center");
        if (dm.getAstCglDosing01Run()) {
            pSwg215OneParam14.setValue01("运行");
            pSwg215OneParam14.setColor01(normalRunColor);
        } else {
            pSwg215OneParam14.setValue01("停止");
            pSwg215OneParam14.setColor01(normalStopColor);
        }
        pSwg215OneParam14.setValue01Scale(0.3f);
        pSwg215OneParam14.setValue02(String.valueOf(dm.getAstCglDosing01RunMin()));
        pSwg215OneParam14.setColor02(defaultColor);
        pSwg215OneParam14.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam14);
        //调节初沉池污泥泵-sbr
        if(sbrA2o .equals("SBR")) {
            PSwg215OneParam pSwg215OneParam15 = new PSwg215OneParam("调节初沉池污泥泵：", "left", 0.4f, 2, "center");
            if (dm.getPmySinkPumpRun()) {
                pSwg215OneParam15.setValue01("运行");
                pSwg215OneParam15.setColor01(normalRunColor);
            } else {
                pSwg215OneParam15.setValue01("停止");
                pSwg215OneParam15.setColor01(normalStopColor);
            }
            pSwg215OneParam15.setValue01Scale(0.3f);
            pSwg215OneParam15.setValue02(String.valueOf(dm.getPmySinkPumpRunMin()));
            pSwg215OneParam15.setColor02(defaultColor);
            pSwg215OneParam15.setValue02Scale(0.3f);
            pSwg215OneParams.add(pSwg215OneParam15);
        }

        return pSwg215OneParams;
    }

    public static List<PSwg215OneParam> formatPart03(String sbrA2o,SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();

        //污泥池搅拌机
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("污泥池搅拌机：","left",0.4f,2,"center");
        if (dm.getSludgeMixerRun()) {
            pSwg215OneParam01.setValue01("运行");
            pSwg215OneParam01.setColor01(normalRunColor);
        } else {
            pSwg215OneParam01.setValue01("停止");
            pSwg215OneParam01.setColor01(normalStopColor);
        }
        pSwg215OneParam01.setValue01Scale(0.3f);
        pSwg215OneParam01.setValue02(String.valueOf(dm.getSludgeMixerRunMin()));
        pSwg215OneParam01.setColor02(defaultColor);
        pSwg215OneParam01.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam01);
        //泥水分离机进泥泵
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("泥水分离机进泥泵：","left",0.4f,2,"center");
        if (dm.getSlySeprtInPumpRun()) {
            pSwg215OneParam02.setValue01("运行");
            pSwg215OneParam02.setColor01(normalRunColor);
        } else {
            pSwg215OneParam02.setValue01("停止");
            pSwg215OneParam02.setColor01(normalStopColor);
        }
        pSwg215OneParam02.setValue01Scale(0.3f);
        pSwg215OneParam02.setValue02(String.valueOf(dm.getSlySeprtInPumpRunMin()));
        pSwg215OneParam02.setColor02(defaultColor);
        pSwg215OneParam02.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam02);
        //絮凝剂加药泵
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("絮凝剂加药泵：","left",0.4f,2,"center");
        if (dm.getFlocltDosingRun()) {
            pSwg215OneParam03.setValue01("运行");
            pSwg215OneParam03.setColor01(normalRunColor);
        } else {
            pSwg215OneParam03.setValue01("停止");
            pSwg215OneParam03.setColor01(normalStopColor);
        }
        pSwg215OneParam03.setValue01Scale(0.3f);
        pSwg215OneParam03.setValue02(String.valueOf(dm.getFlocltDosingRunMin()));
        pSwg215OneParam03.setColor02(defaultColor);
        pSwg215OneParam03.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam03);
        //絮凝剂搅拌机
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("絮凝剂搅拌机：","left",0.4f,2,"center");
        if (dm.getFlocltMixerRun()) {
            pSwg215OneParam04.setValue01("运行");
            pSwg215OneParam04.setColor01(normalRunColor);
        } else {
            pSwg215OneParam04.setValue01("停止");
            pSwg215OneParam04.setColor01(normalStopColor);
        }
        pSwg215OneParam04.setValue01Scale(0.3f);
        pSwg215OneParam04.setValue02(String.valueOf(dm.getFlocltMixerRunMin()));
        pSwg215OneParam04.setColor02(defaultColor);
        pSwg215OneParam04.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam04);
        //泥水分离机
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("泥水分离机：","left",0.4f,2,"center");
        if (dm.getSlySeprtRun()) {
            pSwg215OneParam05.setValue01("运行");
            pSwg215OneParam05.setColor01(normalRunColor);
        } else {
            pSwg215OneParam05.setValue01("停止");
            pSwg215OneParam05.setColor01(normalStopColor);
        }
        pSwg215OneParam05.setValue01Scale(0.3f);
        pSwg215OneParam05.setValue02(String.valueOf(dm.getSlySeprtRunMin()));
        pSwg215OneParam05.setColor02(defaultColor);
        pSwg215OneParam05.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam05);

        return pSwg215OneParams;
    }

    public static  List<PSwg215OneParam> formatA2OPart04(SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();

        //厌氧池进水泵
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("厌氧池进水泵：","left",0.4f,2,"center");
        if (dm.getUasbInPumpRun()) {
            pSwg215OneParam01.setValue01("运行");
            pSwg215OneParam01.setColor01(normalRunColor);
        } else {
            pSwg215OneParam01.setValue01("停止");
            pSwg215OneParam01.setColor01(normalStopColor);
        }
        pSwg215OneParam01.setValue01Scale(0.3f);
        pSwg215OneParam01.setValue02(String.valueOf(dm.getUasbInPumpRunMin()));
        pSwg215OneParam01.setColor02(defaultColor);
        pSwg215OneParam01.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam01);
        //内回流泵
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("内回流泵：","left",0.4f,2,"center");
        if (dm.getInBfPumpRun()) {
            pSwg215OneParam02.setValue01("运行");
            pSwg215OneParam02.setColor01(normalRunColor);
        } else {
            pSwg215OneParam02.setValue01("停止");
            pSwg215OneParam02.setColor01(normalStopColor);
        }
        pSwg215OneParam02.setValue01Scale(0.3f);
        pSwg215OneParam02.setValue02(String.valueOf(dm.getInBfPumpRunMin()));
        pSwg215OneParam02.setColor02(defaultColor);
        pSwg215OneParam02.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam02);
        //外回流泵
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("外回流泵：","left",0.4f,2,"center");
        if (dm.getOutBfPumpRun()) {
            pSwg215OneParam03.setValue01("运行");
            pSwg215OneParam03.setColor01(normalRunColor);
        } else {
            pSwg215OneParam03.setValue01("停止");
            pSwg215OneParam03.setColor01(normalStopColor);
        }
        pSwg215OneParam03.setValue01Scale(0.3f);
        pSwg215OneParam03.setValue02(String.valueOf(dm.getOutBfPumpRunMin()));
        pSwg215OneParam03.setColor02(defaultColor);
        pSwg215OneParam03.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam03);
        //厌氧池搅拌机
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("厌氧池搅拌机：","left",0.4f,2,"center");
        if (dm.getUasbMixerRun()) {
            pSwg215OneParam04.setValue01("运行");
            pSwg215OneParam04.setColor01(normalRunColor);
        } else {
            pSwg215OneParam04.setValue01("停止");
            pSwg215OneParam04.setColor01(normalStopColor);
        }
        pSwg215OneParam04.setValue01Scale(0.3f);
        pSwg215OneParam04.setValue02(String.valueOf(dm.getUasbMixerRunMin()));
        pSwg215OneParam04.setColor02(defaultColor);
        pSwg215OneParam04.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam04);
        //缺氧池搅拌机
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("缺氧池搅拌机：","left",0.4f,2,"center");
        if (dm.getAnoxiaMixerRun()) {
            pSwg215OneParam05.setValue01("运行");
            pSwg215OneParam05.setColor01(normalRunColor);
        } else {
            pSwg215OneParam05.setValue01("停止");
            pSwg215OneParam05.setColor01(normalStopColor);
        }
        pSwg215OneParam05.setValue01Scale(0.3f);
        pSwg215OneParam05.setValue02(String.valueOf(dm.getAnoxiaMixerRunMin()));
        pSwg215OneParam05.setColor02(defaultColor);
        pSwg215OneParam05.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam05);
        //二沉池污泥泵
        PSwg215OneParam pSwg215OneParam06 = new PSwg215OneParam("二沉池污泥泵：","left",0.4f,2,"center");
        if (dm.getSecSinkPumpRun()) {
            pSwg215OneParam06.setValue01("运行");
            pSwg215OneParam06.setColor01(normalRunColor);
        } else {
            pSwg215OneParam06.setValue01("停止");
            pSwg215OneParam06.setColor01(normalStopColor);
        }
        pSwg215OneParam06.setValue01Scale(0.3f);
        pSwg215OneParam06.setValue02(String.valueOf(dm.getSecSinkPumpRunMin()));
        pSwg215OneParam06.setColor02(defaultColor);
        pSwg215OneParam06.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam06);

        return pSwg215OneParams;
    }

    public static  List<PSwg215OneParam> formatA2OPart05(SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();

        //混凝剂02搅拌机
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("混凝剂02搅拌机：","left",0.4f,2,"center");
        if (dm.getBldCglMixer02Run()) {
            pSwg215OneParam01.setValue01("运行");
            pSwg215OneParam01.setColor01(normalRunColor);
        } else {
            pSwg215OneParam01.setValue01("停止");
            pSwg215OneParam01.setColor01(normalStopColor);
        }
        pSwg215OneParam01.setValue01Scale(0.3f);
        pSwg215OneParam01.setValue02(String.valueOf(dm.getBldCglMixer02RunMin()));
        pSwg215OneParam01.setColor02(defaultColor);
        pSwg215OneParam01.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam01);
        //助凝剂02搅拌机
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("助凝剂02搅拌机：","left",0.4f,2,"center");
        if (dm.getAstCglMixer02Run()) {
            pSwg215OneParam02.setValue01("运行");
            pSwg215OneParam02.setColor01(normalRunColor);
        } else {
            pSwg215OneParam02.setValue01("停止");
            pSwg215OneParam02.setColor01(normalStopColor);
        }
        pSwg215OneParam02.setValue01Scale(0.3f);
        pSwg215OneParam02.setValue02(String.valueOf(dm.getAstCglMixer02RunMin()));
        pSwg215OneParam02.setColor02(defaultColor);
        pSwg215OneParam02.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam02);
        //除磷剂搅拌机
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("除磷剂搅拌机：","left",0.4f,2,"center");
        if (dm.getPpRmvMixerRun()) {
            pSwg215OneParam03.setValue01("运行");
            pSwg215OneParam03.setColor01(normalRunColor);
        } else {
            pSwg215OneParam03.setValue01("停止");
            pSwg215OneParam03.setColor01(normalStopColor);
        }
        pSwg215OneParam03.setValue01Scale(0.3f);
        pSwg215OneParam03.setValue02(String.valueOf(dm.getPpRmvMixerRunMin()));
        pSwg215OneParam03.setColor02(defaultColor);
        pSwg215OneParam03.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam03);
        //混凝剂02加药泵
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("混凝剂02加药泵：","left",0.4f,2,"center");
        if (dm.getBldCglDosing02Run()) {
            pSwg215OneParam04.setValue01("运行");
            pSwg215OneParam04.setColor01(normalRunColor);
        } else {
            pSwg215OneParam04.setValue01("停止");
            pSwg215OneParam04.setColor01(normalStopColor);
        }
        pSwg215OneParam04.setValue01Scale(0.3f);
        pSwg215OneParam04.setValue02(String.valueOf(dm.getBldCglDosing02RunMin()));
        pSwg215OneParam04.setColor02(defaultColor);
        pSwg215OneParam04.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam04);
        //助凝剂02加药泵
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("助凝剂02加药泵：","left",0.4f,2,"center");
        if (dm.getAstCglDosing02Run()) {
            pSwg215OneParam05.setValue01("运行");
            pSwg215OneParam05.setColor01(normalRunColor);
        } else {
            pSwg215OneParam05.setValue01("停止");
            pSwg215OneParam05.setColor01(normalStopColor);
        }
        pSwg215OneParam05.setValue01Scale(0.3f);
        pSwg215OneParam05.setValue02(String.valueOf(dm.getAstCglDosing02RunMin()));
        pSwg215OneParam05.setColor02(defaultColor);
        pSwg215OneParam05.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam05);
        //除磷剂加药泵
        PSwg215OneParam pSwg215OneParam06 = new PSwg215OneParam("除磷剂加药泵：","left",0.4f,2,"center");
        if (dm.getPpRmvDosingRun()) {
            pSwg215OneParam06.setValue01("运行");
            pSwg215OneParam06.setColor01(normalRunColor);
        } else {
            pSwg215OneParam06.setValue01("停止");
            pSwg215OneParam06.setColor01(normalStopColor);
        }
        pSwg215OneParam06.setValue01Scale(0.3f);
        pSwg215OneParam06.setValue02(String.valueOf(dm.getPpRmvDosingRunMin()));
        pSwg215OneParam06.setColor02(defaultColor);
        pSwg215OneParam06.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam06);
        //混反池02搅拌机
        PSwg215OneParam pSwg215OneParam07 = new PSwg215OneParam("混反池02搅拌机：","left",0.4f,2,"center");
        if (dm.getBldOpstMixer02Run()) {
            pSwg215OneParam07.setValue01("运行");
            pSwg215OneParam07.setColor01(normalRunColor);
        } else {
            pSwg215OneParam07.setValue01("停止");
            pSwg215OneParam07.setColor01(normalStopColor);
        }
        pSwg215OneParam07.setValue01Scale(0.3f);
        pSwg215OneParam07.setValue02(String.valueOf(dm.getBldOpstMixer02RunMin()));
        pSwg215OneParam07.setColor02(defaultColor);
        pSwg215OneParam07.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam07);
        //混合池02搅拌机
        PSwg215OneParam pSwg215OneParam08 = new PSwg215OneParam("混合池02搅拌机：","left",0.4f,2,"center");
        if (dm.getBldMixer02Run()) {
            pSwg215OneParam08.setValue01("运行");
            pSwg215OneParam08.setColor01(normalRunColor);
        } else {
            pSwg215OneParam08.setValue01("停止");
            pSwg215OneParam08.setColor01(normalStopColor);
        }
        pSwg215OneParam08.setValue01Scale(0.3f);
        pSwg215OneParam08.setValue02(String.valueOf(dm.getBldMixer02RunMin()));
        pSwg215OneParam08.setColor02(defaultColor);
        pSwg215OneParam08.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam08);
        //除磷池搅拌机
        PSwg215OneParam pSwg215OneParam09 = new PSwg215OneParam("除磷池搅拌机：","left",0.4f,2,"center");
        if (dm.getPpRmvTankMixerRun()) {
            pSwg215OneParam09.setValue01("运行");
            pSwg215OneParam09.setColor01(normalRunColor);
        } else {
            pSwg215OneParam09.setValue01("停止");
            pSwg215OneParam09.setColor01(normalStopColor);
        }
        pSwg215OneParam09.setValue01Scale(0.3f);
        pSwg215OneParam09.setValue02(String.valueOf(dm.getPpRmvTankMixerRunMin()));
        pSwg215OneParam09.setColor02(defaultColor);
        pSwg215OneParam09.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam09);
        //终沉池污泥泵
        PSwg215OneParam pSwg215OneParam10 = new PSwg215OneParam("终沉池污泥泵：","left",0.4f,2,"center");
        if (dm.getFinalSinkPumpRun()) {
            pSwg215OneParam10.setValue01("运行");
            pSwg215OneParam10.setColor01(normalRunColor);
        } else {
            pSwg215OneParam10.setValue01("停止");
            pSwg215OneParam10.setColor01(normalStopColor);
        }
        pSwg215OneParam10.setValue01Scale(0.3f);
        pSwg215OneParam10.setValue02(String.valueOf(dm.getFinalSinkPumpRunMin()));
        pSwg215OneParam10.setColor02(defaultColor);
        pSwg215OneParam10.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam10);
        //次氯酸钠加药泵（暂无）

        return pSwg215OneParams;
    }

    public static  List<PSwg215OneParam> formatSBRPart04(SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();
        //进水泵
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("进水泵：","left",0.4f,2,"center");
        if (dm.getInPumpState()) {
            pSwg215OneParam01.setValue01("运行");
            pSwg215OneParam01.setColor01(normalRunColor);
        } else {
            pSwg215OneParam01.setValue01("停止");
            pSwg215OneParam01.setColor01(normalStopColor);
        }
        pSwg215OneParam01.setValue01Scale(0.3f);
        pSwg215OneParam01.setValue02(String.valueOf(dm.getInPumpRunMin()));
        pSwg215OneParam01.setColor02(defaultColor);
        pSwg215OneParam01.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam01);
        //SBR一次搅拌
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("SBR一次搅拌：","left",0.4f,2,"center");
        if (dm.getFirstSbrMixerState()) {
            pSwg215OneParam02.setValue01("运行");
            pSwg215OneParam02.setColor01(normalRunColor);
        } else {
            pSwg215OneParam02.setValue01("停止");
            pSwg215OneParam02.setColor01(normalStopColor);
        }
        pSwg215OneParam02.setValue01Scale(0.3f);
        pSwg215OneParam02.setValue02(String.valueOf(dm.getSbrMixerOnceRunMin()));
        pSwg215OneParam02.setColor02(defaultColor);
        pSwg215OneParam02.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam02);
        //风机01
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("风机01：","left",0.4f,2,"center");
        if (dm.getFan01State()) {
            pSwg215OneParam03.setValue01("运行");
            pSwg215OneParam03.setColor01(normalRunColor);
        } else {
            pSwg215OneParam03.setValue01("停止");
            pSwg215OneParam03.setColor01(normalStopColor);
        }
        pSwg215OneParam03.setValue01Scale(0.3f);
        pSwg215OneParam03.setValue02(String.valueOf(dm.getFanRunMin()));
        pSwg215OneParam03.setColor02(defaultColor);
        pSwg215OneParam03.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam03);
        //风机02
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("风机02：","left",0.4f,2,"center");
        if (dm.getFan02State()) {
            pSwg215OneParam04.setValue01("运行");
            pSwg215OneParam04.setColor01(normalRunColor);
        } else {
            pSwg215OneParam04.setValue01("停止");
            pSwg215OneParam04.setColor01(normalStopColor);
        }
        pSwg215OneParam04.setValue01Scale(0.3f);
        pSwg215OneParam04.setValue02(String.valueOf(dm.getFanRunMin()));
        pSwg215OneParam04.setColor02(defaultColor);
        pSwg215OneParam04.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam04);
        //SBR二次搅拌
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("SBR二次搅拌：","left",0.4f,2,"center");
        if (dm.getSecSbrMixerState()) {
            pSwg215OneParam05.setValue01("运行");
            pSwg215OneParam05.setColor01(normalRunColor);
        } else {
            pSwg215OneParam05.setValue01("停止");
            pSwg215OneParam05.setColor01(normalStopColor);
        }
        pSwg215OneParam05.setValue01Scale(0.3f);
        pSwg215OneParam05.setValue02(String.valueOf(dm.getSbrMixerSecRunMin()));
        pSwg215OneParam05.setColor02(defaultColor);
        pSwg215OneParam05.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam05);
        //静置沉淀
        PSwg215OneParam pSwg215OneParam06 = new PSwg215OneParam("静置沉淀：","left",0.4f,2,"center");
        if (dm.getSbrStaticState()) {
            pSwg215OneParam06.setValue01("运行");
            pSwg215OneParam06.setColor01(normalRunColor);
        } else {
            pSwg215OneParam06.setValue01("停止");
            pSwg215OneParam06.setColor01(normalStopColor);
        }
        pSwg215OneParam06.setValue01Scale(0.3f);
        pSwg215OneParam06.setValue02(String.valueOf(dm.getSbrStaticRunMin()));
        pSwg215OneParam06.setColor02(defaultColor);
        pSwg215OneParam06.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam06);
        //污泥泵
        PSwg215OneParam pSwg215OneParam07 = new PSwg215OneParam("污泥泵：","left",0.4f,2,"center");
        if (dm.getSludgePumpState()) {
            pSwg215OneParam07.setValue01("运行");
            pSwg215OneParam07.setColor01(normalRunColor);
        } else {
            pSwg215OneParam07.setValue01("停止");
            pSwg215OneParam07.setColor01(normalStopColor);
        }
        pSwg215OneParam07.setValue01Scale(0.3f);
        pSwg215OneParam07.setValue02(String.valueOf(dm.getSludgePumpRunMin()));
        pSwg215OneParam07.setColor02(defaultColor);
        pSwg215OneParam07.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam07);
        //排水阀开
        PSwg215OneParam pSwg215OneParam08 = new PSwg215OneParam("排水阀开：","left",0.4f,2,"center");
        if (dm.getDecanterOnState()) {
            pSwg215OneParam08.setValue01("运行");
            pSwg215OneParam08.setColor01(normalRunColor);
        } else {
            pSwg215OneParam08.setValue01("停止");
            pSwg215OneParam08.setColor01(normalStopColor);
        }
        pSwg215OneParam08.setValue01Scale(0.3f);
        pSwg215OneParam08.setValue02(String.valueOf(dm.getDecanterOnRunMin()));
        pSwg215OneParam08.setColor02(defaultColor);
        pSwg215OneParam08.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam08);
        //排水阀关
        PSwg215OneParam pSwg215OneParam09 = new PSwg215OneParam("排水阀关：","left",0.4f,2,"center");
        if (dm.getDecanterOffState()) {
            pSwg215OneParam09.setValue01("运行");
            pSwg215OneParam09.setColor01(normalRunColor);
        } else {
            pSwg215OneParam09.setValue01("停止");
            pSwg215OneParam09.setColor01(normalStopColor);
        }
        pSwg215OneParam09.setValue01Scale(0.3f);
        pSwg215OneParam09.setValue02(String.valueOf(dm.getDecanterOffRunMin()));
        pSwg215OneParam09.setColor02(defaultColor);
        pSwg215OneParam09.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam09);
        //静置活化
        PSwg215OneParam pSwg215OneParam10 = new PSwg215OneParam("静置活化：","left",0.4f,2,"center");
        if (dm.getSbrActiveState()) {
            pSwg215OneParam10.setValue01("运行");
            pSwg215OneParam10.setColor01(normalRunColor);
        } else {
            pSwg215OneParam10.setValue01("停止");
            pSwg215OneParam10.setColor01(normalStopColor);
        }
        pSwg215OneParam10.setValue01Scale(0.3f);
        pSwg215OneParam10.setValue02(String.valueOf(dm.getSbrActiveRunMin()));
        pSwg215OneParam10.setColor02(defaultColor);
        pSwg215OneParam10.setValue02Scale(0.3f);
        pSwg215OneParams.add(pSwg215OneParam10);

        return pSwg215OneParams;
    }

    public static  List<PSwg215OneParam> formatSBRPart05(SwgC215DM dm){
        String defaultColor = "#000000"; //Black
        String normalRunColor = "#00FF00"; //Green
        String normalStopColor = "#FFA500"; //Orange
        String alarmColor = "#CDCD00";   //LightYellow
        List<PSwg215OneParam> pSwg215OneParams = new ArrayList<>();
        //SBR一次搅拌
        PSwg215OneParam pSwg215OneParam01 = new PSwg215OneParam("SBR一次搅拌：","left",0.5f,1,"center");
        pSwg215OneParam01.setValue01(String.valueOf(dm.getSbrMixerOnceSetMinute()));
        pSwg215OneParam01.setColor01(defaultColor);
        pSwg215OneParam01.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam01);
        //曝气
        PSwg215OneParam pSwg215OneParam02 = new PSwg215OneParam("曝气：","left",0.5f,1,"center");
        pSwg215OneParam02.setValue01(String.valueOf(dm.getFanSetMinute()));
        pSwg215OneParam02.setColor01(defaultColor);
        pSwg215OneParam02.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam02);
        //sbr二次搅拌
        PSwg215OneParam pSwg215OneParam03 = new PSwg215OneParam("sbr二次搅拌：","left",0.5f,1,"center");
        pSwg215OneParam03.setValue01(String.valueOf(dm.getSbrMixerSecSetMinute()));
        pSwg215OneParam03.setColor01(defaultColor);
        pSwg215OneParam03.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam03);
        //静置沉淀
        PSwg215OneParam pSwg215OneParam04 = new PSwg215OneParam("静置沉淀：","left",0.5f,1,"center");
        pSwg215OneParam04.setValue01(String.valueOf(dm.getSbrStaticSetMinute()));
        pSwg215OneParam04.setColor01(defaultColor);
        pSwg215OneParam04.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam04);
        //排泥
        PSwg215OneParam pSwg215OneParam05 = new PSwg215OneParam("排泥：","left",0.5f,1,"center");
        pSwg215OneParam05.setValue01(String.valueOf(dm.getSludgePumpSetMinute()));
        pSwg215OneParam05.setColor01(defaultColor);
        pSwg215OneParam05.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam05);
        //静置活化
        PSwg215OneParam pSwg215OneParam06 = new PSwg215OneParam("静置活化：","left",0.5f,1,"center");
        pSwg215OneParam06.setValue01(String.valueOf(dm.getSbrActiveSetMinute()));
        pSwg215OneParam06.setColor01(defaultColor);
        pSwg215OneParam06.setValue01Scale(0.5f);
        pSwg215OneParams.add(pSwg215OneParam06);
        return pSwg215OneParams;
    }
}
