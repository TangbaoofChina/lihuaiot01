package com.system.po.Device;

import com.system.po.MydataTableColumn;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealOneData;
import com.system.po.Phone.Pswg215.PSwg215OneParam;
import com.system.po.Phone.Pswg215.PSwg215OnePart;
import com.system.util.Swg215Util;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SwgC215DM
 * @Description TODO
 * @Author tangbao
 * @Date 2020-08-31 8:28
 * @Version 1.0
 **/
@Data
public class SwgC215DM extends BaseDeviceMessage {
    //设备发送数据时间
    private String sendDate;

    //系统保留
    private int systemSpare;
    /************* 43个 运行状态  ******************/
    //机械格栅 停止/运行
    Boolean ydsgsRun;
    //集水井提升泵 停止/运行
    Boolean collectWellPumpRun;
    //集水池搅拌机1 停止/运行
    Boolean collectMixer01Run;
    //集水池搅拌机2 停止/运行
    Boolean collectMixer02Run;
    //除磷投加机 停止/运行
    Boolean dephosphorizeRun;
    //集水池提升泵 停止/运行
    Boolean collectPumpRun;
    //固液分离机 停止/运行
    Boolean solLiqRun;
    //混合池1搅拌机 停止/运行
    Boolean bldMixer01Run;
    //混反池1搅拌机 停止/运行
    Boolean bldOpstMixer01Run;
    //混沉池污泥泵 停止/运行
    Boolean bldSinkPumpRun;
    //    混凝剂1搅拌机停止/运行
    Boolean bldCglMixer01Run;
    //    混凝剂1加药泵 停止/运行
    Boolean bldCglDosing01Run;
    //    助凝剂1搅拌机 停止/运行
    Boolean astCglMixer01Run;
    //    助凝剂1加药泵 停止/运行
    Boolean astCglDosing01Run;
    //    污泥池搅拌机 停止/运行
    Boolean sludgeMixerRun;
    //    泥水分离机进泥泵 停止/运行
    Boolean slySeprtInPumpRun;
    //    絮凝剂加药泵 停止/运行
    Boolean flocltDosingRun;
    //    絮凝剂搅拌机 停止/运行
    Boolean flocltMixerRun;
    //    泥水分离机 停止/运行
    Boolean slySeprtRun;
    //    调节初沉池污泥泵 停止/运行
    Boolean pmySinkPumpRun;
    //    SBR池进水泵 停止/运行
    Boolean sbrIntakePumpRun;
    //    风机1 停止/运行
    Boolean fan01Run;
    //    风机2 停止/运行
    Boolean fan02Run;
    //    SBR池污泥泵 停止/运行
    Boolean sbrSludegPumpRun;
    //    电动排水阀 停止/运行
    Boolean eleDrainRun;
    //    SBR池搅拌机1 停止/运行
    Boolean sbrMixer01Run;
    //    SBR池搅拌机2 停止/运行
    Boolean sbrMixer02Run;
    //    厌氧池进水泵 停止/运行
    Boolean uasbInPumpRun;
    //    内回流泵 停止/运行
    Boolean inBfPumpRun;
    //    外回流泵 停止/运行
    Boolean outBfPumpRun;
    //    厌氧池搅拌机  停止/运行
    Boolean uasbMixerRun;
    //    缺氧池搅拌机 停止/运行
    Boolean anoxiaMixerRun;
    //    二沉池污泥泵停止/运行
    Boolean secSinkPumpRun;
    //    混凝剂2搅拌机 停止/运行
    Boolean bldCglMixer02Run;
    //    助凝剂2搅拌机 停止/运行
    Boolean astCglMixer02Run;
    //    除磷剂搅拌机  停止/运行
    Boolean ppRmvMixerRun;
    //    混凝剂2加药泵停止/运行
    Boolean bldCglDosing02Run;
    //    助凝剂2加药泵停止/运行
    Boolean astCglDosing02Run;
    //    除磷剂加药泵 停止/运行
    Boolean ppRmvDosingRun;
    //    混反池2搅拌机 停止/运行
    Boolean bldOpstMixer02Run;
    //    混合池2搅拌机 停止/运行
    Boolean bldMixer02Run;
    //    除磷池搅拌机  停止/运行
    Boolean ppRmvTankMixerRun;
    //    终沉池污泥泵 停止/运行
    Boolean finalSinkPumpRun;

    //备用1403
    Boolean spare1403;
    //备用1404
    Boolean spare1404;
    //备用1405
    Boolean spare1405;
    //备用1406
    Boolean spare1406;
    //备用1407
    Boolean spare1407;

    /*********** 15个 公共参数 2byte *********************/
    //    集水井液位控制仪高 未到/到了
    Boolean collectWellHighOn;
    //    集水井液位控制仪低 未到/到了
    Boolean collectWellLowOn;
    //    集水池液位控制器高 未到/到了
    Boolean collectHighOn;
    //    集水池液位控制器低 未到/到了
    Boolean collectLowOn;
    //    调节池液位控制器高 未到/到了
    Boolean regulatHighOn;
    //    调节池液位控制器低 未到/到了
    Boolean regulatLowOn;
    //    SBR池液位控制器仪高 未到/到了
    Boolean sbrHighOn;
    //    SBR池液位控制器仪低 未到/到了
    Boolean sbrLowOn;
    //    排水阀开未到/到位
    Boolean decanterOnOK;
    //    排水阀关未到/到位
    Boolean decanterOffOK;
    //    电能表通讯故障
    Boolean elecFault;
    //    空气温度变送器通讯故障
    Boolean airTempFault;
    //    SBR水温变送器通讯故障
    Boolean waterTempFault;
    //    PLC电量不足
    Boolean plcElecLack;
    //    SBR手自动状态 手动/自动
    Boolean systemAuto;

    //备用16.7
    Boolean spare1607;
    /*********** 10个 工艺流程状态  *********************/
//    进水泵工作状态
    Boolean inPumpState;
    //    首次启动SBR池搅拌机状态
    Boolean firstSbrMixerState;
    //    罗茨风机1状态
    Boolean fan01State;
    //    罗茨风机2状态
    Boolean fan02State;
    //    二次启动SBR池搅拌机状态
    Boolean secSbrMixerState;
    //    静置沉淀状态
    Boolean sbrStaticState;
    //    污泥泵状态
    Boolean sludgePumpState;
    //    电动排水阀开状态
    Boolean decanterOnState;
    //    电动排水阀关状态
    Boolean decanterOffState;
    //    静置活化状态
    Boolean sbrActiveState;
    //备用18.2
    Boolean spare1802;
    //备用18.3
    Boolean spare1803;
    //备用18.4
    Boolean spare1804;
    //备用18.5
    Boolean spare1805;
    //备用18.6
    Boolean spare1806;
    //备用18.7
    Boolean spare1807;
    //备用19.0
    Boolean spare1900;
    //备用19.1
    Boolean spare1901;
    //备用19.2
    Boolean spare1902;
    //备用19.3
    Boolean spare1903;
    //备用19.4
    Boolean spare1904;
    //备用19.5
    Boolean spare1905;
    //备用19.6
    Boolean spare1906;
    //备用19.7
    Boolean spare1907;

    //备用20.0
    Boolean spare2000;
    //备用20.1
    Boolean spare2001;
    //备用20.2
    Boolean spare2002;
    //备用20.3
    Boolean spare2003;
    //备用20.4
    Boolean spare2004;
    //备用20.5
    Boolean spare2005;
    //备用20.6
    Boolean spare2006;
    //备用20.7
    Boolean spare2007;


    /*********** 6+1个 数据-工艺设定时间  *********************/
    //MODBUS通讯代码, 字顺序21
    int modbusCode;
    //    SBR池一次搅拌设定时间.单位分钟，字节顺序21
    int sbrMixerOnceSetMinute;
    //
//    曝气设定时间.单位分钟，字节顺序21
    int fanSetMinute;
    //
//    SBR池二次搅拌设定时间.单位分钟，字节顺序21
    int sbrMixerSecSetMinute;
    //
//    静置沉淀设定时间.单位分钟，字节顺序21
    int sbrStaticSetMinute;
    //
//    排泥设定时间.单位分钟，字节顺序21
    int sludgePumpSetMinute;
    //
//    静置活化设定时间.单位分钟，字节顺序21
    int sbrActiveSetMinute;
    //备用35、36
    int spare3536;

    //备用37、38
    int spare3738;
    //备用39、40
    int spare3940;
    //备用41、42
    int spare4142;
    /*********** 43个 数据-运行时间  *********************/
//    机械格栅   单次运行时间.单位分钟，字节顺序21
    int ydsgsRunMin;
    //
//    集水井提升泵  单次运行时间.单位分钟，字节顺序21
    int collectWellPumpRunMin;
    //
//    集水池搅拌机1  单次运行时间.单位分钟，字节顺序21
    int collectMixer01RunMin;
    //
//    集水池搅拌机2  单次运行时间.单位分钟，字节顺序21
    int collectMixer02RunMin;
    //
//    除磷投加机   单次运行时间.单位分钟，字节顺序21
    int dephosphorizeRunMin;
    //
//    集水池提升泵    单次运行时间.单位分钟，字节顺序21
    int collectPumpRunMin;
    //
//    固液分离机 单次运行时间.单位分钟，，字节顺序21
    int solLiqRunMin;
    //
//    混合池1搅拌机 单次运行时间.单位分钟，字节顺序21
    int bldMixer01RunMin;
    //
//    混反池1搅拌机单次运行时间.单位分钟，字节顺序21
    int bldOpstMixer01RunMin;
    //
//    混沉池污泥泵  单次运行时间.单位分钟，字节顺序21
    int bldSinkPumpRunMin;
    //
//    混凝剂1搅拌机 单次运行时间.单位分钟，字节顺序21
    int bldCglMixer01RunMin;
    //
//    混凝剂1加药泵 单次运行时间.单位分钟，字节顺序21
    int bldCglDosing01RunMin;
    //
//    助凝剂1搅拌机 单次运行时间.单位分钟，字节顺序21
    int astCglMixer01RunMin;
    //
//    助凝剂1加药泵 单次运行时间.单位分钟，字节顺序21
    int astCglDosing01RunMin;
    //
//    污泥池搅拌机单次运行时间.单位分钟，字节顺序21
    int sludgeMixerRunMin;
    //
//    泥水分离机进泥泵 单次运行时间.单位分钟，字节顺序21
    int slySeprtInPumpRunMin;
    //
//    絮凝剂加药泵 单次运行时间.单位分钟，字节顺序21
    int flocltDosingRunMin;
    //
//    絮凝剂搅拌机 单次运行时间.单位分钟，字节顺序21
    int flocltMixerRunMin;
    //
//    泥水分离机 单次运行时间.单位分钟，字节顺序21
    int slySeprtRunMin;
    //
//    调节初沉池污泥泵 单次运行时间.单位分钟，字节顺序21
    int pmySinkPumpRunMin;
    //
//    SBR池进水泵 单次运行时间.单位分钟，字节顺序21
    int sbrIntakePumpRunMin;
    //
//    风机1  单次运行时间.单位分钟，字节顺序2
    int fan01RunMin;
    //
//    风机2 单次运行时间.单位分钟，字节顺序21
    int fan02RunMin;
    //
//    SBR池污泥泵 单次运行时间.单位分钟，字节顺序21
    int sbrSludegPumpRunMin;
    //
//    电动排水阀 单次运行时间.单位分钟，字节顺序21
    int eleDrainRunMin;
    //
//    SBR池搅拌机1 单次运行时间.单位分钟，字节顺序21
    int sbrMixer01RunMin;
    //
//    SBR池搅拌机2 单次运行时间.单位分钟，字节顺序21
    int sbrMixer02RunMin;
    //
//    厌氧池进水泵 单次运行时间.单位分钟，字节顺序21
    int uasbInPumpRunMin;
    //
//    内回流泵 单次运行时间.单位分钟，字节顺序21
    int inBfPumpRunMin;
    //
//    外回流泵  单次运行时间.单位分钟，字节顺序21
    int outBfPumpRunMin;
    //
//    厌氧池搅拌机   单次运行时间.单位分钟，字节顺序21
    int uasbMixerRunMin;
    //
//    缺氧池搅拌机 单次运行时间.单位分钟，字节顺序21
    int anoxiaMixerRunMin;
    //
//    二沉池污泥泵 单次运行时间.单位分钟，字节顺序21
    int secSinkPumpRunMin;
    //
//    混凝剂2搅拌机 单次运行时间.单位分钟，字节顺序21
    int bldCglMixer02RunMin;
    //
//    助凝剂2搅拌机  单次运行时间.单位分钟，字节顺序21
    int astCglMixer02RunMin;
    //
//    除磷剂搅拌机  单次运行时间.单位分钟，字节顺21
    int ppRmvMixerRunMin;
    //
//    混凝剂2加药泵 单次运行时间.单位分钟，字节顺序21
    int bldCglDosing02RunMin;
    //
//    助凝剂2加药泵 单次运行时间.单位分钟，字节顺序21
    int astCglDosing02RunMin;
    //
//    除磷剂加药泵  单次运行时间.单位分钟，字节顺序21
    int ppRmvDosingRunMin;
    //
//    混反池2搅拌机 单次运行时间.单位分钟，字节顺序21
    int bldOpstMixer02RunMin;
    //
//    混合池2搅拌机 单次运行时间.单位分钟，字节顺序21
    int bldMixer02RunMin;
    //
//    除磷池搅拌机  单次运行时间.单位分钟，字节顺序21
    int ppRmvTankMixerRunMin;
//

    //    终沉池污泥泵  单次运行时间.单位分钟，字节顺序21
    int finalSinkPumpRunMin;
    //
    // 备用129、130
    int spare129130;
    // 备用131、132
    int spare131132;
    // 备用133、134
    int spare133134;
    // 备用135、136
    int spare135136;
    // 备用137、138
    int spare137138;

    /***********  10个 其他数据  *********************/
    //流量计（m³）
    long flowmeter;
    //当日流量(m³) 需要运算
    long todayFlowmeter;
    //内回流量计（m³）
    long inFlowmeter;
    //外回流量计（m³）
    long outFlowmeter;
    // 备用151、152、153、154
    long spare151152153154;
    // 备用155、156、157、158
    long spare155156157158;
    //环境温度01
    float airTemp01;
    //SBR池水温01
    float waterTemp01;
    //环境温度02
    float airTemp02;
    //SBR池水温02
    float waterTemp02;
    /*********** 16+2个(一个备用，一个是滗水器的) 电能数据  *********************/
    //线电压Uab
    float uab;
    //线电压Ubc
    float ubc;
    //线电压Uca
    float uca;
    //相电压Ua
    float ua;
    //相电压Ub
    float ub;
    //相电压Uc
    float uc;
    //电流Ia
    float ia;
    //电流Ib
    float ib;
    //电流Ic
    float ic;
    //合相有功功率
    float pt;
    //合相无功功率
    float qt;
    //合相视在功率
    float st;
    //合相功率因数
    float pft;
    //频率
    float freq;
    //正向有功总电能
    float impEP;
    //反向有功总电能
    float expEP;
    //当日电量 需要运算
    float todayEP;
    //备用237、238
    int spare237238;
    //备用239、240
    int spare239240;
    /*********** 43个 设备运行累计时长(小时) *********************/
    //    机械格栅   设备运行时间累积，小时，字节顺序21
    int ydsgsRunTotal;
    //
//    集水井提升泵  设备运行时间累积，小时，字节顺序21
    int collectWellPumpRunTotal;
    //
//    集水池搅拌机1  设备运行时间累积，小时，字节顺序21
    int collectMixer01RunTotal;
    //
//    集水池搅拌机2  设备运行时间累积，小时，字节顺序21
    int collectMixer02RunTotal;
    //
//    除磷投加机   设备运行时间累积，小时，字节顺序21
    int dephosphorizeRunTotal;
    //
//    集水池提升泵    设备运行时间累积，小时，字节顺序21
    int collectPumpRunTotal;
    //
//    固液分离机 设备运行时间累积，小时，，字节顺序21
    int solLiqRunTotal;
    //
//    混合池1搅拌机 设备运行时间累积，小时，字节顺序21
    int bldMixer01RunTotal;
    //
//    混反池1搅拌机设备运行时间累积，小时，字节顺序21
    int bldOpstMixer01RunTotal;
    //
//    混沉池污泥泵  设备运行时间累积，小时，字节顺序21
    int bldSinkPumpRunTotal;
    //
//    混凝剂1搅拌机 设备运行时间累积，小时，字节顺序21
    int bldCglMixer01RunTotal;
    //
//    混凝剂1加药泵 设备运行时间累积，小时，字节顺序21
    int bldCglDosing01RunTotal;
    //
//    助凝剂1搅拌机 设备运行时间累积，小时，字节顺序21
    int astCglMixer01RunTotal;
    //
//    助凝剂1加药泵 设备运行时间累积，小时，字节顺序21
    int astCglDosing01RunTotal;
    //
//    污泥池搅拌机设备运行时间累积，小时，字节顺序21
    int sludgeMixerRunTotal;
    //
//    泥水分离机进泥泵 设备运行时间累积，小时，字节顺序21
    int slySeprtInPumpRunTotal;
    //
//    絮凝剂加药泵 设备运行时间累积，小时，字节顺序21
    int flocltDosingRunTotal;
    //
//    絮凝剂搅拌机 设备运行时间累积，小时，字节顺序21
    int flocltMixerRunTotal;
    //
//    泥水分离机 设备运行时间累积，小时，字节顺序21
    int slySeprtRunTotal;
    //
//    调节初沉池污泥泵 设备运行时间累积，小时，字节顺序21
    int pmySinkPumpRunTotal;
    //
//    SBR池进水泵 设备运行时间累积，小时，字节顺序21
    int sbrIntakePumpRunTotal;
    //
//    风机1  设备运行时间累积，小时，字节顺序2
    int fan01RunTotal;
    //
//    风机2 设备运行时间累积，小时，字节顺序21
    int fan02RunTotal;
    //
//    SBR池污泥泵 设备运行时间累积，小时，字节顺序21
    int sbrSludegPumpRunTotal;
    //
//    电动排水阀 设备运行时间累积，小时，字节顺序21
    int eleDrainRunTotal;
    //
//    SBR池搅拌机1 设备运行时间累积，小时，字节顺序21
    int sbrMixer01RunTotal;
    //
//    SBR池搅拌机2 设备运行时间累积，小时，字节顺序21
    int sbrMixer02RunTotal;
    //
//    厌氧池进水泵 设备运行时间累积，小时，字节顺序21
    int uasbInPumpRunTotal;
    //
//    内回流泵 设备运行时间累积，小时，字节顺序21
    int inBfPumpRunTotal;
    //
//    外回流泵  设备运行时间累积，小时，字节顺序21
    int outBfPumpRunTotal;
    //
//    厌氧池搅拌机   设备运行时间累积，小时，字节顺序21
    int uasbMixerRunTotal;
    //
//    缺氧池搅拌机 设备运行时间累积，小时，字节顺序21
    int anoxiaMixerRunTotal;
    //
//    二沉池污泥泵 设备运行时间累积，小时，字节顺序21
    int secSinkPumpRunTotal;
    //
//    混凝剂2搅拌机 设备运行时间累积，小时，字节顺序21
    int bldCglMixer02RunTotal;
    //
//    助凝剂2搅拌机  设备运行时间累积，小时，字节顺序21
    int astCglMixer02RunTotal;
    //
//    除磷剂搅拌机  设备运行时间累积，小时，字节顺21
    int ppRmvMixerRunTotal;
    //
//    混凝剂2加药泵 设备运行时间累积，小时，字节顺序21
    int bldCglDosing02RunTotal;
    //
//    助凝剂2加药泵 设备运行时间累积，小时，字节顺序21
    int astCglDosing02RunTotal;
    //
//    除磷剂加药泵  设备运行时间累积，小时，字节顺序21
    int ppRmvDosingRunTotal;
    //
//    混反池2搅拌机 设备运行时间累积，小时，字节顺序21
    int bldOpstMixer02RunTotal;
    //
//    混合池2搅拌机 设备运行时间累积，小时，字节顺序21
    int bldMixer02RunTotal;
    //
//    除磷池搅拌机  设备运行时间累积，小时，字节顺序21
    int ppRmvTankMixerRunTotal;
//

    //    终沉池污泥泵  设备运行时间累积，小时，字节顺序21
    int finalSinkPumpRunTotal;
    //备用327、328
    int spare327328;
    //备用329、330
    int spare329330;
    //备用331、332
    int spare331332;
    //备用333、334
    int spare333334;
    //备用335、336
    int spare335336;

    /*********** 43个 设备开始运行时间 时*********************/
    //    机械格栅   开始运行时间，XX时
    int ydsgsRunSHour;
    //
//    集水井提升泵  开始运行时间，XX时
    int collectWellPumpRunSHour;
    //
//    集水池搅拌机1  开始运行时间，XX时
    int collectMixer01RunSHour;
    //
//    集水池搅拌机2  开始运行时间，XX时
    int collectMixer02RunSHour;
    //
//    除磷投加机   开始运行时间，XX时
    int dephosphorizeRunSHour;
    //
//    集水池提升泵    开始运行时间，XX时
    int collectPumpRunSHour;
    //
//    固液分离机 开始运行时间，XX时，
    int solLiqRunSHour;
    //
//    混合池1搅拌机 开始运行时间，XX时
    int bldMixer01RunSHour;
    //
//    混反池1搅拌机开始运行时间，XX时
    int bldOpstMixer01RunSHour;
    //
//    混沉池污泥泵  开始运行时间，XX时
    int bldSinkPumpRunSHour;
    //
//    混凝剂1搅拌机 开始运行时间，XX时
    int bldCglMixer01RunSHour;
    //
//    混凝剂1加药泵 开始运行时间，XX时
    int bldCglDosing01RunSHour;
    //
//    助凝剂1搅拌机 开始运行时间，XX时
    int astCglMixer01RunSHour;
    //
//    助凝剂1加药泵 开始运行时间，XX时
    int astCglDosing01RunSHour;
    //
//    污泥池搅拌机开始运行时间，XX时
    int sludgeMixerRunSHour;
    //
//    泥水分离机进泥泵 开始运行时间，XX时
    int slySeprtInPumpRunSHour;
    //
//    絮凝剂加药泵 开始运行时间，XX时
    int flocltDosingRunSHour;
    //
//    絮凝剂搅拌机 开始运行时间，XX时
    int flocltMixerRunSHour;
    //
//    泥水分离机 开始运行时间，XX时
    int slySeprtRunSHour;
    //
//    调节初沉池污泥泵 开始运行时间，XX时
    int pmySinkPumpRunSHour;
    //
//    SBR池进水泵 开始运行时间，XX时
    int sbrIntakePumpRunSHour;
    //
//    风机1  开始运行时间，XX时，字节顺序2
    int fan01RunSHour;
    //
//    风机2 开始运行时间，XX时
    int fan02RunSHour;
    //
//    SBR池污泥泵 开始运行时间，XX时
    int sbrSludegPumpRunSHour;
    //
//    电动排水阀 开始运行时间，XX时
    int eleDrainRunSHour;
    //
//    SBR池搅拌机1 开始运行时间，XX时
    int sbrMixer01RunSHour;
    //
//    SBR池搅拌机2 开始运行时间，XX时
    int sbrMixer02RunSHour;
    //
//    厌氧池进水泵 开始运行时间，XX时
    int uasbInPumpRunSHour;
    //
//    内回流泵 开始运行时间，XX时
    int inBfPumpRunSHour;
    //
//    外回流泵  开始运行时间，XX时
    int outBfPumpRunSHour;
    //
//    厌氧池搅拌机   开始运行时间，XX时
    int uasbMixerRunSHour;
    //
//    缺氧池搅拌机 开始运行时间，XX时
    int anoxiaMixerRunSHour;
    //
//    二沉池污泥泵 开始运行时间，XX时
    int secSinkPumpRunSHour;
    //
//    混凝剂2搅拌机 开始运行时间，XX时
    int bldCglMixer02RunSHour;
    //
//    助凝剂2搅拌机  开始运行时间，XX时
    int astCglMixer02RunSHour;
    //
//    除磷剂搅拌机  开始运行时间，XX时
    int ppRmvMixerRunSHour;
    //
//    混凝剂2加药泵 开始运行时间，XX时
    int bldCglDosing02RunSHour;
    //
//    助凝剂2加药泵 开始运行时间，XX时
    int astCglDosing02RunSHour;
    //
//    除磷剂加药泵  开始运行时间，XX时
    int ppRmvDosingRunSHour;
    //
//    混反池2搅拌机 开始运行时间，XX时
    int bldOpstMixer02RunSHour;
    //
//    混合池2搅拌机 开始运行时间，XX时
    int bldMixer02RunSHour;
    //
//    除磷池搅拌机  开始运行时间，XX时
    int ppRmvTankMixerRunSHour;
//

    //    终沉池污泥泵  开始运行时间，XX时
    int finalSinkPumpRunSHour;
    /*********** 43个 设备开始运行时间 分*********************/
    //    机械格栅   开始运行时间，XX分
    int ydsgsRunSMin;
    //
//    集水井提升泵  开始运行时间，XX分
    int collectWellPumpRunSMin;
    //
//    集水池搅拌机1  开始运行时间，XX分
    int collectMixer01RunSMin;
    //
//    集水池搅拌机2  开始运行时间，XX分
    int collectMixer02RunSMin;
    //
//    除磷投加机   开始运行时间，XX分
    int dephosphorizeRunSMin;
    //
//    集水池提升泵    开始运行时间，XX分
    int collectPumpRunSMin;
    //
//    固液分离机 开始运行时间，XX分，
    int solLiqRunSMin;
    //
//    混合池1搅拌机 开始运行时间，XX分
    int bldMixer01RunSMin;
    //
//    混反池1搅拌机开始运行时间，XX分
    int bldOpstMixer01RunSMin;
    //
//    混沉池污泥泵  开始运行时间，XX分
    int bldSinkPumpRunSMin;
    //
//    混凝剂1搅拌机 开始运行时间，XX分
    int bldCglMixer01RunSMin;
    //
//    混凝剂1加药泵 开始运行时间，XX分
    int bldCglDosing01RunSMin;
    //
//    助凝剂1搅拌机 开始运行时间，XX分
    int astCglMixer01RunSMin;
    //
//    助凝剂1加药泵 开始运行时间，XX分
    int astCglDosing01RunSMin;
    //
//    污泥池搅拌机开始运行时间，XX分
    int sludgeMixerRunSMin;
    //
//    泥水分离机进泥泵 开始运行时间，XX分
    int slySeprtInPumpRunSMin;
    //
//    絮凝剂加药泵 开始运行时间，XX分
    int flocltDosingRunSMin;
    //
//    絮凝剂搅拌机 开始运行时间，XX分
    int flocltMixerRunSMin;
    //
//    泥水分离机 开始运行时间，XX分
    int slySeprtRunSMin;
    //
//    调节初沉池污泥泵 开始运行时间，XX分
    int pmySinkPumpRunSMin;
    //
//    SBR池进水泵 开始运行时间，XX分
    int sbrIntakePumpRunSMin;
    //
//    风机1  开始运行时间，XX分
    int fan01RunSMin;
    //
//    风机2 开始运行时间，XX分
    int fan02RunSMin;
    //
//    SBR池污泥泵 开始运行时间，XX分
    int sbrSludegPumpRunSMin;
    //
//    电动排水阀 开始运行时间，XX分
    int eleDrainRunSMin;
    //
//    SBR池搅拌机1 开始运行时间，XX分
    int sbrMixer01RunSMin;
    //
//    SBR池搅拌机2 开始运行时间，XX分
    int sbrMixer02RunSMin;
    //
//    厌氧池进水泵 开始运行时间，XX分
    int uasbInPumpRunSMin;
    //
//    内回流泵 开始运行时间，XX分
    int inBfPumpRunSMin;
    //
//    外回流泵  开始运行时间，XX分
    int outBfPumpRunSMin;
    //
//    厌氧池搅拌机   开始运行时间，XX分
    int uasbMixerRunSMin;
    //
//    缺氧池搅拌机 开始运行时间，XX分
    int anoxiaMixerRunSMin;
    //
//    二沉池污泥泵 开始运行时间，XX分
    int secSinkPumpRunSMin;
    //
//    混凝剂2搅拌机 开始运行时间，XX分
    int bldCglMixer02RunSMin;
    //
//    助凝剂2搅拌机  开始运行时间，XX分
    int astCglMixer02RunSMin;
    //
//    除磷剂搅拌机  开始运行时间，XX分
    int ppRmvMixerRunSMin;
    //
//    混凝剂2加药泵 开始运行时间，XX分
    int bldCglDosing02RunSMin;
    //
//    助凝剂2加药泵 开始运行时间，XX分
    int astCglDosing02RunSMin;
    //
//    除磷剂加药泵  开始运行时间，XX分
    int ppRmvDosingRunSMin;
    //
//    混反池2搅拌机 开始运行时间，XX分
    int bldOpstMixer02RunSMin;
    //
//    混合池2搅拌机 开始运行时间，XX分
    int bldMixer02RunSMin;
    //
//    除磷池搅拌机  开始运行时间，XX分
    int ppRmvTankMixerRunSMin;
//

    //    终沉池污泥泵  开始运行时间，XX分
    int finalSinkPumpRunSMin;

    /*********** 8个 备用 *********************/
    //备用 425
    int spare425;
    //备用 426
    int spare426;
    //备用 427
    int spare427;
    //备用 428
    int spare428;
    //备用 429
    int spare429;
    //备用 430
    int spare430;
    //备用 431
    int spare431;
    //备用 432
    int spare432;
    /*********** 9个 单个工艺流程运行时间 *********************/
//    进水泵工作状态运行时间，分钟，字节顺序21
    int inPumpRunMin;
    //
//    SBR池一次搅拌 运行时间，分钟，字节顺序21
    int sbrMixerOnceRunMin;
    //
//    风机运行时间，分钟，字节顺序21
    int fanRunMin;
    //
//    SBR池二次搅拌 运行时间，分钟，字节顺序21
    int sbrMixerSecRunMin;
    //
//    静置沉淀状态持续时间，分钟，字节顺序21
    int sbrStaticRunMin;
    //
//    污泥泵运行时间，分钟，字节顺序21
    int sludgePumpRunMin;
    //
//    电动排水阀开状态持续时间，分钟，字节顺序21
    int decanterOnRunMin;
    //
//    电动排水阀关状态持续时间，分钟，字节顺序21
    int decanterOffRunMin;
    //
//    静止活化状态持续时间，分钟，字节顺序21
    int sbrActiveRunMin;

    //备用 451452
    int spare451452;
    //备用 453454
    int spare453454;
    //备用 455456
    int spare455456;
    //备用 457458
    int spare457458;
    //备用 459460
    int spare459460;
    //备用 461462
    int spare461462;
    //备用 463464
    int spare463464;
    /*********** 43+1 故障指示  *********************/
    //故障指示-6字节
    String faultIndication;
    //    机械格栅   正常/故障
    Boolean ydsgsFault;
    //
//    集水井提升泵  正常/故障
    Boolean collectWellPumpFault;
    //
//    集水池搅拌机1  正常/故障
    Boolean collectMixer01Fault;
    //
//    集水池搅拌机2  正常/故障
    Boolean collectMixer02Fault;
    //
//    除磷投加机   正常/故障
    Boolean dephosphorizeFault;
    //
//    集水池提升泵    正常/故障
    Boolean collectPumpFault;
    //
//    固液分离机 正常/故障，
    Boolean solLiqFault;
    //
//    混合池1搅拌机 正常/故障
    Boolean bldMixer01Fault;
    //
//    混反池1搅拌机正常/故障
    Boolean bldOpstMixer01Fault;
    //
//    混沉池污泥泵  正常/故障
    Boolean bldSinkPumpFault;
    //
//    混凝剂1搅拌机 正常/故障
    Boolean bldCglMixer01Fault;
    //
//    混凝剂1加药泵 正常/故障
    Boolean bldCglDosing01Fault;
    //
//    助凝剂1搅拌机 正常/故障
    Boolean astCglMixer01Fault;
    //
//    助凝剂1加药泵 正常/故障
    Boolean astCglDosing01Fault;
    //
//    污泥池搅拌机正常/故障
    Boolean sludgeMixerFault;
    //
//    泥水分离机进泥泵 正常/故障
    Boolean slySeprtInPumpFault;
    //
//    絮凝剂加药泵 正常/故障
    Boolean flocltDosingFault;
    //
//    絮凝剂搅拌机 正常/故障
    Boolean flocltMixerFault;
    //
//    泥水分离机 正常/故障
    Boolean slySeprtFault;
    //
//    调节初沉池污泥泵 正常/故障
    Boolean pmySinkPumpFault;
    //
//    SBR池进水泵 正常/故障
    Boolean sbrIntakePumpFault;
    //
//    风机1  正常/故障
    Boolean fan01Fault;
    //
//    风机2 正常/故障
    Boolean fan02Fault;
    //
//    SBR池污泥泵 正常/故障
    Boolean sbrSludegPumpFault;
    //
//    电动排水阀 正常/故障
    Boolean eleDrainFault;
    //
//    SBR池搅拌机1 正常/故障
    Boolean sbrMixer01Fault;
    //
//    SBR池搅拌机2 正常/故障
    Boolean sbrMixer02Fault;
    //
//    厌氧池进水泵 正常/故障
    Boolean uasbInPumpFault;
    //
//    内回流泵 正常/故障
    Boolean inBfPumpFault;
    //
//    外回流泵  正常/故障
    Boolean outBfPumpFault;
    //
//    厌氧池搅拌机   正常/故障
    Boolean uasbMixerFault;
    //
//    缺氧池搅拌机 正常/故障
    Boolean anoxiaMixerFault;
    //
//    二沉池污泥泵 正常/故障
    Boolean secSinkPumpFault;
    //
//    混凝剂2搅拌机 正常/故障
    Boolean bldCglMixer02Fault;
    //
//    助凝剂2搅拌机  正常/故障
    Boolean astCglMixer02Fault;
    //
//    除磷剂搅拌机  正常/故障
    Boolean ppRmvMixerFault;
    //
//    混凝剂2加药泵 正常/故障
    Boolean bldCglDosing02Fault;
    //
//    助凝剂2加药泵 正常/故障
    Boolean astCglDosing02Fault;
    //
//    除磷剂加药泵  正常/故障
    Boolean ppRmvDosingFault;
    //
//    混反池2搅拌机 正常/故障
    Boolean bldOpstMixer02Fault;
    //
//    混合池2搅拌机 正常/故障
    Boolean bldMixer02Fault;
    //
//    除磷池搅拌机  正常/故障
    Boolean ppRmvTankMixerFault;
//

    //    终沉池污泥泵  正常/故障
    Boolean finalSinkPumpFault;
    //备用 470.3
    Boolean spare470p3;
    //备用 470.4
    Boolean spare470p4;
    //备用 470.5
    Boolean spare470p5;
    //备用 470.6
    Boolean spare470p6;
    //备用 470.7
    Boolean spare470p7;
    /*********** 其他参数  *********************/
    //GPS数据上传时间设置参数.单位秒
    int ackSeconds;
    //设备地址设置参数
    int plcAddress;
    //备用 475、476
    int spare475476;

    public List<MydataTableColumn> getDeviceHead() {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();

        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNumDec");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        //设备发送数据时间
        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("sendDate");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("时间");
        mdtc3.setVisible(true);

        //设备在线状态
        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dState");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("状态");
        mdtc4.setVisible(true);

        //序号
        myDTCList.add(mdtc1);
        //名称
        myDTCList.add(mdtc2);
        //设备在线状态
        myDTCList.add(mdtc3);
        //设备发送数据时间
        myDTCList.add(mdtc4);

        /************* 43个 运行状态  ******************/
        //机械格栅 停止/运行
        MydataTableColumn mdtc11 = new MydataTableColumn();
        mdtc11.setData("ydsgsRun");
        mdtc11.setDefaultContent("11");
        mdtc11.setTitle("机械格栅运行");
        mdtc11.setVisible(true);
        myDTCList.add(mdtc11);

        //集水井提升泵 停止/运行
        MydataTableColumn mdtc12 = new MydataTableColumn();
        mdtc12.setData("collectWellPumpRun");
        mdtc12.setDefaultContent("12");
        mdtc12.setTitle("集水井提升泵运行");
        mdtc12.setVisible(true);
        myDTCList.add(mdtc12);

        //集水池搅拌机1 停止/运行
        MydataTableColumn mdtc13 = new MydataTableColumn();
        mdtc13.setData("collectMixer01Run");
        mdtc13.setDefaultContent("13");
        mdtc13.setTitle("集水池搅拌机1运行");
        mdtc13.setVisible(true);
        myDTCList.add(mdtc13);

        //集水池搅拌机2 停止/运行
        MydataTableColumn mdtc14 = new MydataTableColumn();
        mdtc14.setData("collectMixer02Run");
        mdtc14.setDefaultContent("14");
        mdtc14.setTitle("集水池搅拌机2运行");
        mdtc14.setVisible(true);
        myDTCList.add(mdtc14);

        //除磷投加机 停止/运行
        MydataTableColumn mdtc15 = new MydataTableColumn();
        mdtc15.setData("dephosphorizeRun");
        mdtc15.setDefaultContent("15");
        mdtc15.setTitle("除磷投加机运行");
        mdtc15.setVisible(true);
        myDTCList.add(mdtc15);

        //集水池提升泵 停止/运行
        MydataTableColumn mdtc16 = new MydataTableColumn();
        mdtc16.setData("collectPumpRun");
        mdtc16.setDefaultContent("16");
        mdtc16.setTitle("集水池提升泵运行");
        mdtc16.setVisible(true);
        myDTCList.add(mdtc16);

        //固液分离机 停止/运行
        MydataTableColumn mdtc17 = new MydataTableColumn();
        mdtc17.setData("solLiqRun");
        mdtc17.setDefaultContent("17");
        mdtc17.setTitle("固液分离机运行");
        mdtc17.setVisible(true);
        myDTCList.add(mdtc17);

        //混合池1搅拌机 停止/运行
        MydataTableColumn mdtc18 = new MydataTableColumn();
        mdtc18.setData("bldMixer01Run");
        mdtc18.setDefaultContent("18");
        mdtc18.setTitle("混合池1搅拌机运行");
        mdtc18.setVisible(true);
        myDTCList.add(mdtc18);

        //混反池1搅拌机 停止/运行
        MydataTableColumn mdtc19 = new MydataTableColumn();
        mdtc19.setData("bldOpstMixer01Run");
        mdtc19.setDefaultContent("19");
        mdtc19.setTitle("混反池1搅拌机运行");
        mdtc19.setVisible(true);
        myDTCList.add(mdtc19);

        //混沉池污泥泵 停止/运行
        MydataTableColumn mdtc20 = new MydataTableColumn();
        mdtc20.setData("bldSinkPumpRun");
        mdtc20.setDefaultContent("20");
        mdtc20.setTitle("混沉池污泥泵运行");
        mdtc20.setVisible(true);
        myDTCList.add(mdtc20);

        //混凝剂1搅拌机停止/运行
        MydataTableColumn mdtc21 = new MydataTableColumn();
        mdtc21.setData("bldCglMixer01Run");
        mdtc21.setDefaultContent("21");
        mdtc21.setTitle("混凝剂1搅拌机运行");
        mdtc21.setVisible(true);
        myDTCList.add(mdtc21);

        //混凝剂1加药泵 停止/运行
        MydataTableColumn mdtc22 = new MydataTableColumn();
        mdtc22.setData("bldCglDosing01Run");
        mdtc22.setDefaultContent("22");
        mdtc22.setTitle("混凝剂1加药泵运行");
        mdtc22.setVisible(true);
        myDTCList.add(mdtc22);

        //助凝剂1搅拌机 停止/运行
        MydataTableColumn mdtc23 = new MydataTableColumn();
        mdtc23.setData("astCglMixer01Run");
        mdtc23.setDefaultContent("23");
        mdtc23.setTitle("助凝剂1搅拌机运行");
        mdtc23.setVisible(true);
        myDTCList.add(mdtc23);

        //助凝剂1加药泵 停止/运行
        MydataTableColumn mdtc24 = new MydataTableColumn();
        mdtc24.setData("astCglDosing01Run");
        mdtc24.setDefaultContent("24");
        mdtc24.setTitle("助凝剂1加药泵运行");
        mdtc24.setVisible(true);
        myDTCList.add(mdtc24);

        //污泥池搅拌机 停止/运行
        MydataTableColumn mdtc25 = new MydataTableColumn();
        mdtc25.setData("sludgeMixerRun");
        mdtc25.setDefaultContent("25");
        mdtc25.setTitle("污泥池搅拌机运行");
        mdtc25.setVisible(true);
        myDTCList.add(mdtc25);

        //泥水分离机进泥泵 停止/运行
        MydataTableColumn mdtc26 = new MydataTableColumn();
        mdtc26.setData("slySeprtInPumpRun");
        mdtc26.setDefaultContent("26");
        mdtc26.setTitle("泥水分离机进泥泵运行");
        mdtc26.setVisible(true);
        myDTCList.add(mdtc26);

        //絮凝剂加药泵 停止/运行
        MydataTableColumn mdtc27 = new MydataTableColumn();
        mdtc27.setData("flocltDosingRun");
        mdtc27.setDefaultContent("27");
        mdtc27.setTitle("絮凝剂加药泵运行");
        mdtc27.setVisible(true);
        myDTCList.add(mdtc27);

        //絮凝剂搅拌机 停止/运行
        MydataTableColumn mdtc28 = new MydataTableColumn();
        mdtc28.setData("flocltMixerRun");
        mdtc28.setDefaultContent("28");
        mdtc28.setTitle("絮凝剂搅拌机运行");
        mdtc28.setVisible(true);
        myDTCList.add(mdtc28);

        //泥水分离机 停止/运行
        MydataTableColumn mdtc29 = new MydataTableColumn();
        mdtc29.setData("slySeprtRun");
        mdtc29.setDefaultContent("29");
        mdtc29.setTitle("泥水分离机 运行");
        mdtc29.setVisible(true);
        myDTCList.add(mdtc29);

        //调节初沉池污泥泵 停止/运行
        MydataTableColumn mdtc30 = new MydataTableColumn();
        mdtc30.setData("pmySinkPumpRun");
        mdtc30.setDefaultContent("30");
        mdtc30.setTitle("调节初沉池污泥泵运行");
        mdtc30.setVisible(true);
        myDTCList.add(mdtc30);

        // SBR池进水泵 停止/运行
        MydataTableColumn mdtc31 = new MydataTableColumn();
        mdtc31.setData("sbrIntakePumpRun");
        mdtc31.setDefaultContent("31");
        mdtc31.setTitle("SBR池进水泵运行");
        mdtc31.setVisible(true);
        myDTCList.add(mdtc31);

        //风机1 停止/运行
        MydataTableColumn mdtc32 = new MydataTableColumn();
        mdtc32.setData("fan01Run");
        mdtc32.setDefaultContent("32");
        mdtc32.setTitle("风机01运行");
        mdtc32.setVisible(true);
        myDTCList.add(mdtc32);

        // 风机2 停止/运行
        MydataTableColumn mdtc33 = new MydataTableColumn();
        mdtc33.setData("fan02Run");
        mdtc33.setDefaultContent("33");
        mdtc33.setTitle("风机02运行");
        mdtc33.setVisible(true);
        myDTCList.add(mdtc33);

        //SBR池污泥泵 停止/运行
        MydataTableColumn mdtc34 = new MydataTableColumn();
        mdtc34.setData("sbrSludegPumpRun");
        mdtc34.setDefaultContent("34");
        mdtc34.setTitle("SBR池污泥泵运行");
        mdtc34.setVisible(true);
        myDTCList.add(mdtc34);

        //电动排水阀 停止/运行
        MydataTableColumn mdtc35 = new MydataTableColumn();
        mdtc35.setData("eleDrainRun");
        mdtc35.setDefaultContent("35");
        mdtc35.setTitle("电动排水阀运行");
        mdtc35.setVisible(true);
        myDTCList.add(mdtc35);

        // SBR池搅拌机1 停止/运行
        MydataTableColumn mdtc36 = new MydataTableColumn();
        mdtc36.setData("sbrMixer01Run");
        mdtc36.setDefaultContent("36");
        mdtc36.setTitle("SBR池搅拌机01运行");
        mdtc36.setVisible(true);
        myDTCList.add(mdtc36);

        //SBR池搅拌机2 停止/运行
        MydataTableColumn mdtc37 = new MydataTableColumn();
        mdtc37.setData("sbrMixer02Run");
        mdtc37.setDefaultContent("37");
        mdtc37.setTitle("SBR池搅拌机02运行");
        mdtc37.setVisible(true);
        myDTCList.add(mdtc37);

        //厌氧池进水泵 停止/运行
        MydataTableColumn mdtc38 = new MydataTableColumn();
        mdtc38.setData("uasbInPumpRun");
        mdtc38.setDefaultContent("38");
        mdtc38.setTitle("厌氧池进水泵运行");
        mdtc38.setVisible(true);
        myDTCList.add(mdtc38);

        //内回流泵 停止/运行
        MydataTableColumn mdtc39 = new MydataTableColumn();
        mdtc39.setData("inBfPumpRun");
        mdtc39.setDefaultContent("39");
        mdtc39.setTitle("内回流泵运行");
        mdtc39.setVisible(true);
        myDTCList.add(mdtc39);

        //外回流泵 停止/运行
        MydataTableColumn mdtc40 = new MydataTableColumn();
        mdtc40.setData("outBfPumpRun");
        mdtc40.setDefaultContent("40");
        mdtc40.setTitle("外回流泵运行");
        mdtc40.setVisible(true);
        myDTCList.add(mdtc40);

        //厌氧池搅拌机  停止/运行
        MydataTableColumn mdtc41 = new MydataTableColumn();
        mdtc41.setData("uasbMixerRun");
        mdtc41.setDefaultContent("41");
        mdtc41.setTitle("厌氧池搅拌机运行");
        mdtc41.setVisible(true);
        myDTCList.add(mdtc41);

        //缺氧池搅拌机 停止/运行
        MydataTableColumn mdtc42 = new MydataTableColumn();
        mdtc42.setData("anoxiaMixerRun");
        mdtc42.setDefaultContent("42");
        mdtc42.setTitle("缺氧池搅拌机运行");
        mdtc42.setVisible(true);
        myDTCList.add(mdtc42);

        //二沉池污泥泵停止/运行
        MydataTableColumn mdtc43 = new MydataTableColumn();
        mdtc43.setData("secSinkPumpRun");
        mdtc43.setDefaultContent("43");
        mdtc43.setTitle("二沉池污泥泵运行");
        mdtc43.setVisible(true);
        myDTCList.add(mdtc43);

        //混凝剂2搅拌机 停止/运行
        MydataTableColumn mdtc44 = new MydataTableColumn();
        mdtc44.setData("bldCglMixer02Run");
        mdtc44.setDefaultContent("44");
        mdtc44.setTitle("混凝剂2搅拌机运行");
        mdtc44.setVisible(true);
        myDTCList.add(mdtc44);

        // 助凝剂2搅拌机 停止/运行
        MydataTableColumn mdtc45 = new MydataTableColumn();
        mdtc45.setData("astCglMixer02Run");
        mdtc45.setDefaultContent("45");
        mdtc45.setTitle("助凝剂2搅拌机运行");
        mdtc45.setVisible(true);
        myDTCList.add(mdtc45);

        //除磷剂搅拌机  停止/运行
        MydataTableColumn mdtc46 = new MydataTableColumn();
        mdtc46.setData("ppRmvMixerRun");
        mdtc46.setDefaultContent("46");
        mdtc46.setTitle("除磷剂搅拌机运行");
        mdtc46.setVisible(true);
        myDTCList.add(mdtc46);

        //混凝剂2加药泵停止/运行
        MydataTableColumn mdtc47 = new MydataTableColumn();
        mdtc47.setData("bldCglDosing02Run");
        mdtc47.setDefaultContent("47");
        mdtc47.setTitle("混凝剂02加药泵运行");
        mdtc47.setVisible(true);
        myDTCList.add(mdtc47);

        //助凝剂2加药泵停止/运行
        MydataTableColumn mdtc48 = new MydataTableColumn();
        mdtc48.setData("astCglDosing02Run");
        mdtc48.setDefaultContent("48");
        mdtc48.setTitle("助凝剂02加药泵停运行");
        mdtc48.setVisible(true);
        myDTCList.add(mdtc48);

        // 除磷剂加药泵 停止/运行
        MydataTableColumn mdtc49 = new MydataTableColumn();
        mdtc49.setData("ppRmvDosingRun");
        mdtc49.setDefaultContent("49");
        mdtc49.setTitle("除磷剂加药泵运行");
        mdtc49.setVisible(true);
        myDTCList.add(mdtc49);

        //混反池2搅拌机 停止/运行
        MydataTableColumn mdtc50 = new MydataTableColumn();
        mdtc50.setData("bldOpstMixer02Run");
        mdtc50.setDefaultContent("50");
        mdtc50.setTitle("混反池02搅拌机运行");
        mdtc50.setVisible(true);
        myDTCList.add(mdtc50);

        //混合池2搅拌机 停止/运行
        MydataTableColumn mdtc51 = new MydataTableColumn();
        mdtc51.setData("bldMixer02Run");
        mdtc51.setDefaultContent("51");
        mdtc51.setTitle("混合池02搅拌机运行");
        mdtc51.setVisible(true);
        myDTCList.add(mdtc51);

        // 除磷池搅拌机  停止/运行
        MydataTableColumn mdtc52 = new MydataTableColumn();
        mdtc52.setData("ppRmvTankMixerRun");
        mdtc52.setDefaultContent("52");
        mdtc52.setTitle("除磷池搅拌机运行");
        mdtc52.setVisible(true);
        myDTCList.add(mdtc52);

        //终沉池污泥泵 停止/运行
        MydataTableColumn mdtc53 = new MydataTableColumn();
        mdtc53.setData("finalSinkPumpRun");
        mdtc53.setDefaultContent("53");
        mdtc53.setTitle("终沉池污泥泵运行");
        mdtc53.setVisible(true);
        myDTCList.add(mdtc53);

        /*********** 15个 公共参数 2byte *********************/
        //    集水井液位控制仪高 未到/到了
        MydataTableColumn mdtc54 = new MydataTableColumn();
        mdtc54.setData("collectWellHighOn");
        mdtc54.setDefaultContent("54");
        mdtc54.setTitle("集水井液位控制仪高到了");
        mdtc54.setVisible(true);
        myDTCList.add(mdtc54);

        //    集水井液位控制仪低 未到/到了
        MydataTableColumn mdtc55 = new MydataTableColumn();
        mdtc55.setData("collectWellHighOn");
        mdtc55.setDefaultContent("55");
        mdtc55.setTitle("集水井液位控制仪低到了");
        mdtc55.setVisible(true);
        myDTCList.add(mdtc55);

        //    集水池液位控制器高 未到/到了
        MydataTableColumn mdtc56 = new MydataTableColumn();
        mdtc56.setData("collectWellHighOn");
        mdtc56.setDefaultContent("56");
        mdtc56.setTitle("集水池液位控制器高到了");
        mdtc56.setVisible(true);
        myDTCList.add(mdtc56);

        //     集水池液位控制器低 未到/到了
        MydataTableColumn mdtc57 = new MydataTableColumn();
        mdtc57.setData("collectWellHighOn");
        mdtc57.setDefaultContent("57");
        mdtc57.setTitle("集水池液位控制器低到了");
        mdtc57.setVisible(true);
        myDTCList.add(mdtc57);

        //    调节池液位控制器高 未到/到了
        MydataTableColumn mdtc58 = new MydataTableColumn();
        mdtc58.setData("collectWellHighOn");
        mdtc58.setDefaultContent("58");
        mdtc58.setTitle("调节池液位控制器高到了");
        mdtc58.setVisible(true);
        myDTCList.add(mdtc58);

        //    调节池液位控制器低 未到/到了
        MydataTableColumn mdtc59 = new MydataTableColumn();
        mdtc59.setData("collectWellHighOn");
        mdtc59.setDefaultContent("59");
        mdtc59.setTitle("调节池液位控制器低到了");
        mdtc59.setVisible(true);
        myDTCList.add(mdtc59);

        //    SBR池液位控制器仪高 未到/到了
        MydataTableColumn mdtc60 = new MydataTableColumn();
        mdtc60.setData("collectWellHighOn");
        mdtc60.setDefaultContent("60");
        mdtc60.setTitle("SBR池液位控制器仪高到了");
        mdtc60.setVisible(true);
        myDTCList.add(mdtc60);

        //    SBR池液位控制器仪低 未到/到了
        MydataTableColumn mdtc61 = new MydataTableColumn();
        mdtc61.setData("collectWellHighOn");
        mdtc61.setDefaultContent("61");
        mdtc61.setTitle("SBR池液位控制器仪低到了");
        mdtc61.setVisible(true);
        myDTCList.add(mdtc61);

        //    排水阀开未到/到位
        MydataTableColumn mdtc62 = new MydataTableColumn();
        mdtc62.setData("collectWellHighOn");
        mdtc62.setDefaultContent("62");
        mdtc62.setTitle("排水阀开到位");
        mdtc62.setVisible(true);
        myDTCList.add(mdtc62);

        //    排水阀关未到/到位
        MydataTableColumn mdtc63 = new MydataTableColumn();
        mdtc63.setData("collectWellHighOn");
        mdtc63.setDefaultContent("63");
        mdtc63.setTitle("排水阀关到位");
        mdtc63.setVisible(true);
        myDTCList.add(mdtc63);

        //    电能表通讯故障
        MydataTableColumn mdtc64 = new MydataTableColumn();
        mdtc64.setData("collectWellHighOn");
        mdtc64.setDefaultContent("64");
        mdtc64.setTitle("电能表通讯故障");
        mdtc64.setVisible(true);
        myDTCList.add(mdtc64);

        //    空气温度变送器通讯故障
        MydataTableColumn mdtc65 = new MydataTableColumn();
        mdtc65.setData("collectWellHighOn");
        mdtc65.setDefaultContent("65");
        mdtc65.setTitle("空气温度变送器通讯故障");
        mdtc65.setVisible(true);
        myDTCList.add(mdtc65);

        //   SBR水温变送器通讯故障
        MydataTableColumn mdtc66 = new MydataTableColumn();
        mdtc66.setData("collectWellHighOn");
        mdtc66.setDefaultContent("66");
        mdtc66.setTitle("SBR水温变送器通讯故障");
        mdtc66.setVisible(true);
        myDTCList.add(mdtc66);

        //    PLC电量不足
        MydataTableColumn mdtc67 = new MydataTableColumn();
        mdtc67.setData("collectWellHighOn");
        mdtc67.setDefaultContent("67");
        mdtc67.setTitle("PLC电量不足");
        mdtc67.setVisible(true);
        myDTCList.add(mdtc67);

        //    SBR手自动状态 手动/自动
        MydataTableColumn mdtc68 = new MydataTableColumn();
        mdtc68.setData("collectWellHighOn");
        mdtc68.setDefaultContent("68");
        mdtc68.setTitle("SBR手自动状态");
        mdtc68.setVisible(true);
        myDTCList.add(mdtc68);

        /*********** 10个 工艺流程状态  *********************/
        //   进水泵工作状态
        MydataTableColumn mdtc69 = new MydataTableColumn();
        mdtc69.setData("inPumpState");
        mdtc69.setDefaultContent("69");
        mdtc69.setTitle("进水泵工作状态");
        mdtc69.setVisible(true);
        myDTCList.add(mdtc69);

        //   首次启动SBR池搅拌机状态
        MydataTableColumn mdtc70 = new MydataTableColumn();
        mdtc70.setData("firstSbrMixerState");
        mdtc70.setDefaultContent("70");
        mdtc70.setTitle("首次启动SBR池搅拌机状态");
        mdtc70.setVisible(true);
        myDTCList.add(mdtc70);

        //   罗茨风机1状态
        MydataTableColumn mdtc71 = new MydataTableColumn();
        mdtc71.setData("fan01State");
        mdtc71.setDefaultContent("71");
        mdtc71.setTitle("罗茨风机1状态");
        mdtc71.setVisible(true);
        myDTCList.add(mdtc71);

        //   罗茨风机2状态
        MydataTableColumn mdtc72 = new MydataTableColumn();
        mdtc72.setData("fan02State");
        mdtc72.setDefaultContent("72");
        mdtc72.setTitle("罗茨风机2状态");
        mdtc72.setVisible(true);
        myDTCList.add(mdtc72);

        //   二次启动SBR池搅拌机状态
        MydataTableColumn mdtc73 = new MydataTableColumn();
        mdtc73.setData("secSbrMixerState");
        mdtc73.setDefaultContent("73");
        mdtc73.setTitle("二次启动SBR池搅拌机状态");
        mdtc73.setVisible(true);
        myDTCList.add(mdtc73);

        //   静置沉淀状态
        MydataTableColumn mdtc74 = new MydataTableColumn();
        mdtc74.setData("sbrStaticState");
        mdtc74.setDefaultContent("74");
        mdtc74.setTitle("静置沉淀状态");
        mdtc74.setVisible(true);
        myDTCList.add(mdtc74);

        //   污泥泵状态
        MydataTableColumn mdtc75 = new MydataTableColumn();
        mdtc75.setData("sludgePumpState");
        mdtc75.setDefaultContent("75");
        mdtc75.setTitle("污泥泵状态");
        mdtc75.setVisible(true);
        myDTCList.add(mdtc75);

        //   电动排水阀开状态
        MydataTableColumn mdtc76 = new MydataTableColumn();
        mdtc76.setData("decanterOnState");
        mdtc76.setDefaultContent("76");
        mdtc76.setTitle("电动排水阀开状态");
        mdtc76.setVisible(true);
        myDTCList.add(mdtc76);

        //   电动排水阀关状态
        MydataTableColumn mdtc77 = new MydataTableColumn();
        mdtc77.setData("decanterOffState");
        mdtc77.setDefaultContent("77");
        mdtc77.setTitle("电动排水阀关状态");
        mdtc77.setVisible(true);
        myDTCList.add(mdtc77);

        //   静置活化状态
        MydataTableColumn mdtc78 = new MydataTableColumn();
        mdtc78.setData("sbrActiveState");
        mdtc78.setDefaultContent("78");
        mdtc78.setTitle("静置活化状态");
        mdtc78.setVisible(true);
        myDTCList.add(mdtc78);

        /*********** 6+1个 数据-工艺设定时间  *********************/
        MydataTableColumn mdtc79 = new MydataTableColumn();
        mdtc79.setData("sbrMixerOnceSetMinute");
        mdtc79.setDefaultContent("79");
        mdtc79.setTitle("SBR池一次搅拌设定时间");
        mdtc79.setVisible(true);
        myDTCList.add(mdtc79);

        MydataTableColumn mdtc80 = new MydataTableColumn();
        mdtc80.setData("fanSetMinute");
        mdtc80.setDefaultContent("80");
        mdtc80.setTitle("曝气设定时间");
        mdtc80.setVisible(true);
        myDTCList.add(mdtc80);

        MydataTableColumn mdtc81 = new MydataTableColumn();
        mdtc81.setData("sbrMixerSecSetMinute");
        mdtc81.setDefaultContent("81");
        mdtc81.setTitle("SBR池二次搅拌设定时间");
        mdtc81.setVisible(true);
        myDTCList.add(mdtc81);

        MydataTableColumn mdtc82 = new MydataTableColumn();
        mdtc82.setData("sbrStaticSetMinute");
        mdtc82.setDefaultContent("82");
        mdtc82.setTitle("静置沉淀设定时间");
        mdtc82.setVisible(true);
        myDTCList.add(mdtc82);

        MydataTableColumn mdtc83 = new MydataTableColumn();
        mdtc83.setData("sludgePumpSetMinute");
        mdtc83.setDefaultContent("83");
        mdtc83.setTitle("排泥设定时间");
        mdtc83.setVisible(true);
        myDTCList.add(mdtc83);

        MydataTableColumn mdtc84 = new MydataTableColumn();
        mdtc84.setData("sbrActiveSetMinute");
        mdtc84.setDefaultContent("84");
        mdtc84.setTitle("静置活化设定时间");
        mdtc84.setVisible(true);
        myDTCList.add(mdtc84);

        /*********** 43个 数据-运行时间  *********************/
        //机械格栅 单次运行时间.单位分钟
        MydataTableColumn mdtc91 = new MydataTableColumn();
        mdtc91.setData("ydsgsRun");
        mdtc91.setDefaultContent("91");
        mdtc91.setTitle("机械格栅单次");
        mdtc91.setVisible(true);
        myDTCList.add(mdtc91);

        //集水井提升泵 单次运行时间.单位分钟
        MydataTableColumn mdtc92 = new MydataTableColumn();
        mdtc92.setData("collectWellPumpRun");
        mdtc92.setDefaultContent("92");
        mdtc92.setTitle("集水井提升泵单次");
        mdtc92.setVisible(true);
        myDTCList.add(mdtc92);

        //集水池搅拌机1 单次运行时间.单位分钟
        MydataTableColumn mdtc93 = new MydataTableColumn();
        mdtc93.setData("collectMixer01Run");
        mdtc93.setDefaultContent("93");
        mdtc93.setTitle("集水池搅拌机1单次");
        mdtc93.setVisible(true);
        myDTCList.add(mdtc93);

        //集水池搅拌机2 单次运行时间.单位分钟
        MydataTableColumn mdtc94 = new MydataTableColumn();
        mdtc94.setData("collectMixer02Run");
        mdtc94.setDefaultContent("94");
        mdtc94.setTitle("集水池搅拌机2单次");
        mdtc94.setVisible(true);
        myDTCList.add(mdtc94);

        //除磷投加机 单次运行时间.单位分钟
        MydataTableColumn mdtc95 = new MydataTableColumn();
        mdtc95.setData("dephosphorizeRun");
        mdtc95.setDefaultContent("95");
        mdtc95.setTitle("除磷投加机单次");
        mdtc95.setVisible(true);
        myDTCList.add(mdtc95);

        //集水池提升泵 单次运行时间.单位分钟
        MydataTableColumn mdtc96 = new MydataTableColumn();
        mdtc96.setData("collectPumpRun");
        mdtc96.setDefaultContent("96");
        mdtc96.setTitle("集水池提升泵单次");
        mdtc96.setVisible(true);
        myDTCList.add(mdtc96);

        //固液分离机 单次运行时间.单位分钟
        MydataTableColumn mdtc97 = new MydataTableColumn();
        mdtc97.setData("solLiqRun");
        mdtc97.setDefaultContent("97");
        mdtc97.setTitle("固液分离机单次");
        mdtc97.setVisible(true);
        myDTCList.add(mdtc97);

        //混合池1搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc98 = new MydataTableColumn();
        mdtc98.setData("bldMixer01Run");
        mdtc98.setDefaultContent("98");
        mdtc98.setTitle("混合池1搅拌机单次");
        mdtc98.setVisible(true);
        myDTCList.add(mdtc98);

        //混反池1搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc99 = new MydataTableColumn();
        mdtc99.setData("bldOpstMixer01Run");
        mdtc99.setDefaultContent("99");
        mdtc99.setTitle("混反池1搅拌机单次");
        mdtc99.setVisible(true);
        myDTCList.add(mdtc99);

        //混沉池污泥泵 单次运行时间.单位分钟
        MydataTableColumn mdtc100 = new MydataTableColumn();
        mdtc100.setData("bldSinkPumpRun");
        mdtc100.setDefaultContent("100");
        mdtc100.setTitle("混沉池污泥泵单次");
        mdtc100.setVisible(true);
        myDTCList.add(mdtc100);

        //混凝剂1搅拌机单次运行时间.单位分钟
        MydataTableColumn mdtc101 = new MydataTableColumn();
        mdtc101.setData("bldCglMixer01Run");
        mdtc101.setDefaultContent("101");
        mdtc101.setTitle("混凝剂1搅拌机单次");
        mdtc101.setVisible(true);
        myDTCList.add(mdtc101);

        //混凝剂1加药泵 单次运行时间.单位分钟
        MydataTableColumn mdtc102 = new MydataTableColumn();
        mdtc102.setData("bldCglDosing01Run");
        mdtc102.setDefaultContent("102");
        mdtc102.setTitle("混凝剂1加药泵单次");
        mdtc102.setVisible(true);
        myDTCList.add(mdtc102);

        //助凝剂1搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc103 = new MydataTableColumn();
        mdtc103.setData("astCglMixer01Run");
        mdtc103.setDefaultContent("103");
        mdtc103.setTitle("助凝剂1搅拌机单次");
        mdtc103.setVisible(true);
        myDTCList.add(mdtc103);

        //助凝剂1加药泵 单次运行时间.单位分钟
        MydataTableColumn mdtc104 = new MydataTableColumn();
        mdtc104.setData("astCglDosing01Run");
        mdtc104.setDefaultContent("104");
        mdtc104.setTitle("助凝剂1加药泵单次");
        mdtc104.setVisible(true);
        myDTCList.add(mdtc104);

        //污泥池搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc105 = new MydataTableColumn();
        mdtc105.setData("sludgeMixerRun");
        mdtc105.setDefaultContent("105");
        mdtc105.setTitle("污泥池搅拌机单次");
        mdtc105.setVisible(true);
        myDTCList.add(mdtc105);

        //泥水分离机进泥泵 单次运行时间.单位分钟
        MydataTableColumn mdtc106 = new MydataTableColumn();
        mdtc106.setData("slySeprtInPumpRun");
        mdtc106.setDefaultContent("106");
        mdtc106.setTitle("泥水分离机进泥泵单次");
        mdtc106.setVisible(true);
        myDTCList.add(mdtc106);

        //絮凝剂加药泵 单次运行时间.单位分钟
        MydataTableColumn mdtc107 = new MydataTableColumn();
        mdtc107.setData("flocltDosingRun");
        mdtc107.setDefaultContent("107");
        mdtc107.setTitle("絮凝剂加药泵单次");
        mdtc107.setVisible(true);
        myDTCList.add(mdtc107);

        //絮凝剂搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc108 = new MydataTableColumn();
        mdtc108.setData("flocltMixerRun");
        mdtc108.setDefaultContent("108");
        mdtc108.setTitle("絮凝剂搅拌机单次");
        mdtc108.setVisible(true);
        myDTCList.add(mdtc108);

        //泥水分离机 单次运行时间.单位分钟
        MydataTableColumn mdtc109 = new MydataTableColumn();
        mdtc109.setData("slySeprtRun");
        mdtc109.setDefaultContent("109");
        mdtc109.setTitle("泥水分离机单次");
        mdtc109.setVisible(true);
        myDTCList.add(mdtc109);

        //调节初沉池污泥泵 单次运行时间.单位分钟
        MydataTableColumn mdtc110 = new MydataTableColumn();
        mdtc110.setData("pmySinkPumpRun");
        mdtc110.setDefaultContent("110");
        mdtc110.setTitle("调节初沉池污泥泵单次");
        mdtc110.setVisible(true);
        myDTCList.add(mdtc110);

        // SBR池进水泵 单次运行时间.单位分钟
        MydataTableColumn mdtc111 = new MydataTableColumn();
        mdtc111.setData("sbrIntakePumpRun");
        mdtc111.setDefaultContent("111");
        mdtc111.setTitle("SBR池进水泵单次");
        mdtc111.setVisible(true);
        myDTCList.add(mdtc111);

        //风机1 单次运行时间.单位分钟
        MydataTableColumn mdtc112 = new MydataTableColumn();
        mdtc112.setData("fan01Run");
        mdtc112.setDefaultContent("112");
        mdtc112.setTitle("风机01单次");
        mdtc112.setVisible(true);
        myDTCList.add(mdtc112);

        // 风机2 单次运行时间.单位分钟
        MydataTableColumn mdtc113 = new MydataTableColumn();
        mdtc113.setData("fan02Run");
        mdtc113.setDefaultContent("113");
        mdtc113.setTitle("风机02单次");
        mdtc113.setVisible(true);
        myDTCList.add(mdtc113);

        //SBR池污泥泵 单次运行时间.单位分钟
        MydataTableColumn mdtc114 = new MydataTableColumn();
        mdtc114.setData("sbrSludegPumpRun");
        mdtc114.setDefaultContent("114");
        mdtc114.setTitle("SBR池污泥泵单次");
        mdtc114.setVisible(true);
        myDTCList.add(mdtc114);

        //电动排水阀 单次运行时间.单位分钟
        MydataTableColumn mdtc115 = new MydataTableColumn();
        mdtc115.setData("eleDrainRun");
        mdtc115.setDefaultContent("115");
        mdtc115.setTitle("电动排水阀单次");
        mdtc115.setVisible(true);
        myDTCList.add(mdtc115);

        // SBR池搅拌机1 单次运行时间.单位分钟
        MydataTableColumn mdtc116 = new MydataTableColumn();
        mdtc116.setData("sbrMixer01Run");
        mdtc116.setDefaultContent("116");
        mdtc116.setTitle("SBR池搅拌机01单次");
        mdtc116.setVisible(true);
        myDTCList.add(mdtc116);

        //SBR池搅拌机2 单次运行时间.单位分钟
        MydataTableColumn mdtc117 = new MydataTableColumn();
        mdtc117.setData("sbrMixer02Run");
        mdtc117.setDefaultContent("117");
        mdtc117.setTitle("SBR池搅拌机02单次");
        mdtc117.setVisible(true);
        myDTCList.add(mdtc117);

        //厌氧池进水泵 单次运行时间.单位分钟
        MydataTableColumn mdtc118 = new MydataTableColumn();
        mdtc118.setData("uasbInPumpRun");
        mdtc118.setDefaultContent("118");
        mdtc118.setTitle("厌氧池进水泵单次");
        mdtc118.setVisible(true);
        myDTCList.add(mdtc118);

        //内回流泵 单次运行时间.单位分钟
        MydataTableColumn mdtc119 = new MydataTableColumn();
        mdtc119.setData("inBfPumpRun");
        mdtc119.setDefaultContent("119");
        mdtc119.setTitle("内回流泵单次");
        mdtc119.setVisible(true);
        myDTCList.add(mdtc119);

        //外回流泵 单次运行时间.单位分钟
        MydataTableColumn mdtc120 = new MydataTableColumn();
        mdtc120.setData("outBfPumpRun");
        mdtc120.setDefaultContent("120");
        mdtc120.setTitle("外回流泵单次");
        mdtc120.setVisible(true);
        myDTCList.add(mdtc120);

        //厌氧池搅拌机  单次运行时间.单位分钟
        MydataTableColumn mdtc121 = new MydataTableColumn();
        mdtc121.setData("uasbMixerRun");
        mdtc121.setDefaultContent("121");
        mdtc121.setTitle("厌氧池搅拌机单次");
        mdtc121.setVisible(true);
        myDTCList.add(mdtc121);

        //缺氧池搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc122 = new MydataTableColumn();
        mdtc122.setData("anoxiaMixerRun");
        mdtc122.setDefaultContent("122");
        mdtc122.setTitle("缺氧池搅拌机单次");
        mdtc122.setVisible(true);
        myDTCList.add(mdtc122);

        //二沉池污泥泵单次运行时间.单位分钟
        MydataTableColumn mdtc123 = new MydataTableColumn();
        mdtc123.setData("secSinkPumpRun");
        mdtc123.setDefaultContent("123");
        mdtc123.setTitle("二沉池污泥泵单次");
        mdtc123.setVisible(true);
        myDTCList.add(mdtc123);

        //混凝剂2搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc124 = new MydataTableColumn();
        mdtc124.setData("bldCglMixer02Run");
        mdtc124.setDefaultContent("124");
        mdtc124.setTitle("混凝剂2搅拌机单次");
        mdtc124.setVisible(true);
        myDTCList.add(mdtc124);

        // 助凝剂2搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc125 = new MydataTableColumn();
        mdtc125.setData("astCglMixer02Run");
        mdtc125.setDefaultContent("125");
        mdtc125.setTitle("助凝剂2搅拌机单次");
        mdtc125.setVisible(true);
        myDTCList.add(mdtc125);

        //除磷剂搅拌机  单次运行时间.单位分钟
        MydataTableColumn mdtc126 = new MydataTableColumn();
        mdtc126.setData("ppRmvMixerRun");
        mdtc126.setDefaultContent("126");
        mdtc126.setTitle("除磷剂搅拌机单次");
        mdtc126.setVisible(true);
        myDTCList.add(mdtc126);

        //混凝剂2加药泵单次运行时间.单位分钟
        MydataTableColumn mdtc127 = new MydataTableColumn();
        mdtc127.setData("bldCglDosing02Run");
        mdtc127.setDefaultContent("127");
        mdtc127.setTitle("混凝剂02加药泵单次");
        mdtc127.setVisible(true);
        myDTCList.add(mdtc127);

        //助凝剂2加药泵单次运行时间.单位分钟
        MydataTableColumn mdtc128 = new MydataTableColumn();
        mdtc128.setData("astCglDosing02Run");
        mdtc128.setDefaultContent("128");
        mdtc128.setTitle("助凝剂02加药泵停单次");
        mdtc128.setVisible(true);
        myDTCList.add(mdtc128);

        // 除磷剂加药泵 单次运行时间.单位分钟
        MydataTableColumn mdtc129 = new MydataTableColumn();
        mdtc129.setData("ppRmvDosingRun");
        mdtc129.setDefaultContent("129");
        mdtc129.setTitle("除磷剂加药泵单次");
        mdtc129.setVisible(true);
        myDTCList.add(mdtc129);

        //混反池2搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc130 = new MydataTableColumn();
        mdtc130.setData("bldOpstMixer02Run");
        mdtc130.setDefaultContent("130");
        mdtc130.setTitle("混反池02搅拌机单次");
        mdtc130.setVisible(true);
        myDTCList.add(mdtc130);

        //混合池2搅拌机 单次运行时间.单位分钟
        MydataTableColumn mdtc131 = new MydataTableColumn();
        mdtc131.setData("bldMixer02Run");
        mdtc131.setDefaultContent("131");
        mdtc131.setTitle("混合池02搅拌机单次");
        mdtc131.setVisible(true);
        myDTCList.add(mdtc131);

        // 除磷池搅拌机  单次运行时间.单位分钟
        MydataTableColumn mdtc132 = new MydataTableColumn();
        mdtc132.setData("ppRmvTankMixerRun");
        mdtc132.setDefaultContent("132");
        mdtc132.setTitle("除磷池搅拌机单次");
        mdtc132.setVisible(true);
        myDTCList.add(mdtc132);

        //终沉池污泥泵 单次运行时间.单位分钟
        MydataTableColumn mdtc133 = new MydataTableColumn();
        mdtc133.setData("finalSinkPumpRun");
        mdtc133.setDefaultContent("133");
        mdtc133.setTitle("终沉池污泥泵单次");
        mdtc133.setVisible(true);
        myDTCList.add(mdtc133);

        /***********  10个 其他数据  *********************/
        //流量计（m³）
        MydataTableColumn mdtc134 = new MydataTableColumn();
        mdtc134.setData("flowmeter");
        mdtc134.setDefaultContent("134");
        mdtc134.setTitle("流量计");
        mdtc134.setVisible(true);
        myDTCList.add(mdtc134);

        //当日流量（m³）
        MydataTableColumn mdtc135 = new MydataTableColumn();
        mdtc135.setData("todayFlowmeter");
        mdtc135.setDefaultContent("135");
        mdtc135.setTitle("当日流量");
        mdtc135.setVisible(true);
        myDTCList.add(mdtc135);

        //内回流量计（m³）
        MydataTableColumn mdtc136 = new MydataTableColumn();
        mdtc136.setData("inFlowmeter");
        mdtc136.setDefaultContent("136");
        mdtc136.setTitle("内回流量计");
        mdtc136.setVisible(true);
        myDTCList.add(mdtc136);

        //外回流量计（m³）
        MydataTableColumn mdtc137 = new MydataTableColumn();
        mdtc137.setData("outFlowmeter");
        mdtc137.setDefaultContent("137");
        mdtc137.setTitle("外回流量计");
        mdtc137.setVisible(true);
        myDTCList.add(mdtc137);

        //环境温度01（m³）
        MydataTableColumn mdtc138 = new MydataTableColumn();
        mdtc138.setData("airTemp01");
        mdtc138.setDefaultContent("138");
        mdtc138.setTitle("环境温度01");
        mdtc138.setVisible(true);
        myDTCList.add(mdtc138);

        //SBR池水温01（m³）
        MydataTableColumn mdtc139 = new MydataTableColumn();
        mdtc139.setData("waterTemp01");
        mdtc139.setDefaultContent("139");
        mdtc139.setTitle("SBR池水温01");
        mdtc139.setVisible(true);
        myDTCList.add(mdtc139);

        //环境温度02（m³）
        MydataTableColumn mdtc140 = new MydataTableColumn();
        mdtc140.setData("airTemp02");
        mdtc140.setDefaultContent("140");
        mdtc140.setTitle("环境温度02");
        mdtc140.setVisible(true);
        myDTCList.add(mdtc140);

        //SBR池水温02（m³）
        MydataTableColumn mdtc141 = new MydataTableColumn();
        mdtc141.setData("waterTemp02");
        mdtc141.setDefaultContent("141");
        mdtc141.setTitle("SBR池水温02");
        mdtc141.setVisible(true);
        myDTCList.add(mdtc141);

        /*********** 16个 电能数据  *********************/
        //线电压Uab
        MydataTableColumn mdtc142 = new MydataTableColumn();
        mdtc142.setData("uab");
        mdtc142.setDefaultContent("67");
        mdtc142.setTitle("线电压Uab");
        mdtc142.setVisible(false);
        myDTCList.add(mdtc142);

        //线电压Ubc
        MydataTableColumn mdtc143 = new MydataTableColumn();
        mdtc143.setData("ubc");
        mdtc143.setDefaultContent("68");
        mdtc143.setTitle("线电压Ubc");
        mdtc143.setVisible(false);
        myDTCList.add(mdtc143);
        //线电压Uca
        MydataTableColumn mdtc144 = new MydataTableColumn();
        mdtc144.setData("uca");
        mdtc144.setDefaultContent("69");
        mdtc144.setTitle("线电压Uca");
        mdtc144.setVisible(false);
        myDTCList.add(mdtc144);
        //相电压Ua
        MydataTableColumn mdtc145 = new MydataTableColumn();
        mdtc145.setData("ua");
        mdtc145.setDefaultContent("70");
        mdtc145.setTitle("相电压Ua");
        mdtc145.setVisible(false);
        myDTCList.add(mdtc145);
        //相电压Ub
        MydataTableColumn mdtc146 = new MydataTableColumn();
        mdtc146.setData("ub");
        mdtc146.setDefaultContent("71");
        mdtc146.setTitle("相电压Ub");
        mdtc146.setVisible(false);
        myDTCList.add(mdtc146);
        //相电压Uc
        MydataTableColumn mdtc147 = new MydataTableColumn();
        mdtc147.setData("uc");
        mdtc147.setDefaultContent("72");
        mdtc147.setTitle("相电压Uc");
        mdtc147.setVisible(false);
        myDTCList.add(mdtc147);
        //电流Ia
        MydataTableColumn mdtc148 = new MydataTableColumn();
        mdtc148.setData("ia");
        mdtc148.setDefaultContent("73");
        mdtc148.setTitle("电流Ia");
        mdtc148.setVisible(false);
        myDTCList.add(mdtc148);
        //电流Ib
        MydataTableColumn mdtc149 = new MydataTableColumn();
        mdtc149.setData("ib");
        mdtc149.setDefaultContent("74");
        mdtc149.setTitle("电流Ib");
        mdtc149.setVisible(false);
        myDTCList.add(mdtc149);
        //电流Ic
        MydataTableColumn mdtc150 = new MydataTableColumn();
        mdtc150.setData("ic");
        mdtc150.setDefaultContent("75");
        mdtc150.setTitle("电流Ic");
        mdtc150.setVisible(false);
        myDTCList.add(mdtc150);
        //合相有功功率
        MydataTableColumn mdtc151 = new MydataTableColumn();
        mdtc151.setData("pt");
        mdtc151.setDefaultContent("76");
        mdtc151.setTitle("合相有功功率");
        mdtc151.setVisible(false);
        myDTCList.add(mdtc151);
        //合相无功功率
        MydataTableColumn mdtc152 = new MydataTableColumn();
        mdtc152.setData("qt");
        mdtc152.setDefaultContent("77");
        mdtc152.setTitle("合相无功功率");
        mdtc152.setVisible(false);
        myDTCList.add(mdtc152);
        //合相视在功率
        MydataTableColumn mdtc153 = new MydataTableColumn();
        mdtc153.setData("st");
        mdtc153.setDefaultContent("78");
        mdtc153.setTitle("合相视在功率");
        mdtc153.setVisible(false);
        myDTCList.add(mdtc153);
        //合相功率因数
        MydataTableColumn mdtc154 = new MydataTableColumn();
        mdtc154.setData("pft");
        mdtc154.setDefaultContent("79");
        mdtc154.setTitle("合相功率因数");
        mdtc154.setVisible(false);
        myDTCList.add(mdtc154);
        //频率
        MydataTableColumn mdtc155 = new MydataTableColumn();
        mdtc155.setData("freq");
        mdtc155.setDefaultContent("80");
        mdtc155.setTitle("频率");
        mdtc155.setVisible(false);
        myDTCList.add(mdtc155);
        //正向有功总电能
        MydataTableColumn mdtc156 = new MydataTableColumn();
        mdtc156.setData("impEP");
        mdtc156.setDefaultContent("81");
        mdtc156.setTitle("正向有功总电能");
        mdtc156.setVisible(true);
        myDTCList.add(mdtc156);
        //反向有功总电能
        MydataTableColumn mdtc157 = new MydataTableColumn();
        mdtc157.setData("expEP");
        mdtc157.setDefaultContent("82");
        mdtc157.setTitle("反向有功总电能");
        mdtc157.setVisible(false);
        myDTCList.add(mdtc157);
        //当日电量
        MydataTableColumn mdtc158 = new MydataTableColumn();
        mdtc158.setData("todayEP");
        mdtc158.setDefaultContent("124");
        mdtc158.setTitle("当日电量");
        mdtc158.setVisible(true);
        myDTCList.add(mdtc158);
        /*********** 43个 设备运行累计时长(小时) *********************/
        //机械格栅 设备运行时间累积，小时
        MydataTableColumn mdtc161 = new MydataTableColumn();
        mdtc161.setData("ydsgsRunTotal");
        mdtc161.setDefaultContent("161");
        mdtc161.setTitle("机械格栅累计");
        mdtc161.setVisible(true);
        myDTCList.add(mdtc161);

        //集水井提升泵 设备运行时间累积，小时
        MydataTableColumn mdtc162 = new MydataTableColumn();
        mdtc162.setData("collectWellPumpRunTotal");
        mdtc162.setDefaultContent("162");
        mdtc162.setTitle("集水井提升泵累计");
        mdtc162.setVisible(true);
        myDTCList.add(mdtc162);

        //集水池搅拌机1 设备运行时间累积，小时
        MydataTableColumn mdtc163 = new MydataTableColumn();
        mdtc163.setData("collectMixer01RunTotal");
        mdtc163.setDefaultContent("163");
        mdtc163.setTitle("集水池搅拌机1累计");
        mdtc163.setVisible(true);
        myDTCList.add(mdtc163);

        //集水池搅拌机2 设备运行时间累积，小时
        MydataTableColumn mdtc164 = new MydataTableColumn();
        mdtc164.setData("collectMixer02RunTotal");
        mdtc164.setDefaultContent("164");
        mdtc164.setTitle("集水池搅拌机2累计");
        mdtc164.setVisible(true);
        myDTCList.add(mdtc164);

        //除磷投加机 设备运行时间累积，小时
        MydataTableColumn mdtc165 = new MydataTableColumn();
        mdtc165.setData("dephosphorizeRunTotal");
        mdtc165.setDefaultContent("165");
        mdtc165.setTitle("除磷投加机累计");
        mdtc165.setVisible(true);
        myDTCList.add(mdtc165);

        //集水池提升泵 设备运行时间累积，小时
        MydataTableColumn mdtc166 = new MydataTableColumn();
        mdtc166.setData("collectPumpRunTotal");
        mdtc166.setDefaultContent("166");
        mdtc166.setTitle("集水池提升泵累计");
        mdtc166.setVisible(true);
        myDTCList.add(mdtc166);

        //固液分离机 设备运行时间累积，小时
        MydataTableColumn mdtc167 = new MydataTableColumn();
        mdtc167.setData("solLiqRunTotal");
        mdtc167.setDefaultContent("167");
        mdtc167.setTitle("固液分离机累计");
        mdtc167.setVisible(true);
        myDTCList.add(mdtc167);

        //混合池1搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc168 = new MydataTableColumn();
        mdtc168.setData("bldMixer01RunTotal");
        mdtc168.setDefaultContent("168");
        mdtc168.setTitle("混合池1搅拌机累计");
        mdtc168.setVisible(true);
        myDTCList.add(mdtc168);

        //混反池1搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc169 = new MydataTableColumn();
        mdtc169.setData("bldOpstMixer01RunTotal");
        mdtc169.setDefaultContent("169");
        mdtc169.setTitle("混反池1搅拌机累计");
        mdtc169.setVisible(true);
        myDTCList.add(mdtc169);

        //混沉池污泥泵 设备运行时间累积，小时
        MydataTableColumn mdtc170 = new MydataTableColumn();
        mdtc170.setData("bldSinkPumpRunTotal");
        mdtc170.setDefaultContent("170");
        mdtc170.setTitle("混沉池污泥泵累计");
        mdtc170.setVisible(true);
        myDTCList.add(mdtc170);

        //混凝剂1搅拌机设备运行时间累积，小时
        MydataTableColumn mdtc171 = new MydataTableColumn();
        mdtc171.setData("bldCglMixer01RunTotal");
        mdtc171.setDefaultContent("171");
        mdtc171.setTitle("混凝剂1搅拌机累计");
        mdtc171.setVisible(true);
        myDTCList.add(mdtc171);

        //混凝剂1加药泵 设备运行时间累积，小时
        MydataTableColumn mdtc172 = new MydataTableColumn();
        mdtc172.setData("bldCglDosing01RunTotal");
        mdtc172.setDefaultContent("172");
        mdtc172.setTitle("混凝剂1加药泵累计");
        mdtc172.setVisible(true);
        myDTCList.add(mdtc172);

        //助凝剂1搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc173 = new MydataTableColumn();
        mdtc173.setData("astCglMixer01RunTotal");
        mdtc173.setDefaultContent("173");
        mdtc173.setTitle("助凝剂1搅拌机累计");
        mdtc173.setVisible(true);
        myDTCList.add(mdtc173);

        //助凝剂1加药泵 设备运行时间累积，小时
        MydataTableColumn mdtc174 = new MydataTableColumn();
        mdtc174.setData("astCglDosing01RunTotal");
        mdtc174.setDefaultContent("174");
        mdtc174.setTitle("助凝剂1加药泵累计");
        mdtc174.setVisible(true);
        myDTCList.add(mdtc174);

        //污泥池搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc175 = new MydataTableColumn();
        mdtc175.setData("sludgeMixerRunTotal");
        mdtc175.setDefaultContent("175");
        mdtc175.setTitle("污泥池搅拌机累计");
        mdtc175.setVisible(true);
        myDTCList.add(mdtc175);

        //泥水分离机进泥泵 设备运行时间累积，小时
        MydataTableColumn mdtc176 = new MydataTableColumn();
        mdtc176.setData("slySeprtInPumpRunTotal");
        mdtc176.setDefaultContent("176");
        mdtc176.setTitle("泥水分离机进泥泵累计");
        mdtc176.setVisible(true);
        myDTCList.add(mdtc176);

        //絮凝剂加药泵 设备运行时间累积，小时
        MydataTableColumn mdtc177 = new MydataTableColumn();
        mdtc177.setData("flocltDosingRunTotal");
        mdtc177.setDefaultContent("177");
        mdtc177.setTitle("絮凝剂加药泵累计");
        mdtc177.setVisible(true);
        myDTCList.add(mdtc177);

        //絮凝剂搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc178 = new MydataTableColumn();
        mdtc178.setData("flocltMixerRunTotal");
        mdtc178.setDefaultContent("178");
        mdtc178.setTitle("絮凝剂搅拌机累计");
        mdtc178.setVisible(true);
        myDTCList.add(mdtc178);

        //泥水分离机 设备运行时间累积，小时
        MydataTableColumn mdtc179 = new MydataTableColumn();
        mdtc179.setData("slySeprtRunTotal");
        mdtc179.setDefaultContent("179");
        mdtc179.setTitle("泥水分离机累计");
        mdtc179.setVisible(true);
        myDTCList.add(mdtc179);

        //调节初沉池污泥泵 设备运行时间累积，小时
        MydataTableColumn mdtc180 = new MydataTableColumn();
        mdtc180.setData("pmySinkPumpRunTotal");
        mdtc180.setDefaultContent("180");
        mdtc180.setTitle("调节初沉池污泥泵累计");
        mdtc180.setVisible(true);
        myDTCList.add(mdtc180);

        // SBR池进水泵 设备运行时间累积，小时
        MydataTableColumn mdtc181 = new MydataTableColumn();
        mdtc181.setData("sbrIntakePumpRunTotal");
        mdtc181.setDefaultContent("181");
        mdtc181.setTitle("SBR池进水泵累计");
        mdtc181.setVisible(true);
        myDTCList.add(mdtc181);

        //风机1 设备运行时间累积，小时
        MydataTableColumn mdtc182 = new MydataTableColumn();
        mdtc182.setData("fan01RunTotal");
        mdtc182.setDefaultContent("182");
        mdtc182.setTitle("风机01累计");
        mdtc182.setVisible(true);
        myDTCList.add(mdtc182);

        // 风机2 设备运行时间累积，小时
        MydataTableColumn mdtc183 = new MydataTableColumn();
        mdtc183.setData("fan02RunTotal");
        mdtc183.setDefaultContent("183");
        mdtc183.setTitle("风机02累计");
        mdtc183.setVisible(true);
        myDTCList.add(mdtc183);

        //SBR池污泥泵 设备运行时间累积，小时
        MydataTableColumn mdtc184 = new MydataTableColumn();
        mdtc184.setData("sbrSludegPumpRunTotal");
        mdtc184.setDefaultContent("184");
        mdtc184.setTitle("SBR池污泥泵累计");
        mdtc184.setVisible(true);
        myDTCList.add(mdtc184);

        //电动排水阀 设备运行时间累积，小时
        MydataTableColumn mdtc185 = new MydataTableColumn();
        mdtc185.setData("eleDrainRunTotal");
        mdtc185.setDefaultContent("185");
        mdtc185.setTitle("电动排水阀累计");
        mdtc185.setVisible(true);
        myDTCList.add(mdtc185);

        // SBR池搅拌机1 设备运行时间累积，小时
        MydataTableColumn mdtc186 = new MydataTableColumn();
        mdtc186.setData("sbrMixer01RunTotal");
        mdtc186.setDefaultContent("186");
        mdtc186.setTitle("SBR池搅拌机01累计");
        mdtc186.setVisible(true);
        myDTCList.add(mdtc186);

        //SBR池搅拌机2 设备运行时间累积，小时
        MydataTableColumn mdtc187 = new MydataTableColumn();
        mdtc187.setData("sbrMixer02RunTotal");
        mdtc187.setDefaultContent("187");
        mdtc187.setTitle("SBR池搅拌机02累计");
        mdtc187.setVisible(true);
        myDTCList.add(mdtc187);

        //厌氧池进水泵 设备运行时间累积，小时
        MydataTableColumn mdtc188 = new MydataTableColumn();
        mdtc188.setData("uasbInPumpRunTotal");
        mdtc188.setDefaultContent("188");
        mdtc188.setTitle("厌氧池进水泵累计");
        mdtc188.setVisible(true);
        myDTCList.add(mdtc188);

        //内回流泵 设备运行时间累积，小时
        MydataTableColumn mdtc189 = new MydataTableColumn();
        mdtc189.setData("inBfPumpRunTotal");
        mdtc189.setDefaultContent("189");
        mdtc189.setTitle("内回流泵累计");
        mdtc189.setVisible(true);
        myDTCList.add(mdtc189);

        //外回流泵 设备运行时间累积，小时
        MydataTableColumn mdtc190 = new MydataTableColumn();
        mdtc190.setData("outBfPumpRunTotal");
        mdtc190.setDefaultContent("190");
        mdtc190.setTitle("外回流泵累计");
        mdtc190.setVisible(true);
        myDTCList.add(mdtc190);

        //厌氧池搅拌机  设备运行时间累积，小时
        MydataTableColumn mdtc191 = new MydataTableColumn();
        mdtc191.setData("uasbMixerRunTotal");
        mdtc191.setDefaultContent("191");
        mdtc191.setTitle("厌氧池搅拌机累计");
        mdtc191.setVisible(true);
        myDTCList.add(mdtc191);

        //缺氧池搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc192 = new MydataTableColumn();
        mdtc192.setData("anoxiaMixerRunTotal");
        mdtc192.setDefaultContent("192");
        mdtc192.setTitle("缺氧池搅拌机累计");
        mdtc192.setVisible(true);
        myDTCList.add(mdtc192);

        //二沉池污泥泵设备运行时间累积，小时
        MydataTableColumn mdtc193 = new MydataTableColumn();
        mdtc193.setData("secSinkPumpRunTotal");
        mdtc193.setDefaultContent("193");
        mdtc193.setTitle("二沉池污泥泵累计");
        mdtc193.setVisible(true);
        myDTCList.add(mdtc193);

        //混凝剂2搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc194 = new MydataTableColumn();
        mdtc194.setData("bldCglMixer02RunTotal");
        mdtc194.setDefaultContent("194");
        mdtc194.setTitle("混凝剂2搅拌机累计");
        mdtc194.setVisible(true);
        myDTCList.add(mdtc194);

        // 助凝剂2搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc195 = new MydataTableColumn();
        mdtc195.setData("astCglMixer02RunTotal");
        mdtc195.setDefaultContent("195");
        mdtc195.setTitle("助凝剂2搅拌机累计");
        mdtc195.setVisible(true);
        myDTCList.add(mdtc195);

        //除磷剂搅拌机  设备运行时间累积，小时
        MydataTableColumn mdtc196 = new MydataTableColumn();
        mdtc196.setData("ppRmvMixerRunTotal");
        mdtc196.setDefaultContent("196");
        mdtc196.setTitle("除磷剂搅拌机累计");
        mdtc196.setVisible(true);
        myDTCList.add(mdtc196);

        //混凝剂2加药泵设备运行时间累积，小时
        MydataTableColumn mdtc197 = new MydataTableColumn();
        mdtc197.setData("bldCglDosing02RunTotal");
        mdtc197.setDefaultContent("197");
        mdtc197.setTitle("混凝剂02加药泵累计");
        mdtc197.setVisible(true);
        myDTCList.add(mdtc197);

        //助凝剂2加药泵设备运行时间累积，小时
        MydataTableColumn mdtc198 = new MydataTableColumn();
        mdtc198.setData("astCglDosing02RunTotal");
        mdtc198.setDefaultContent("198");
        mdtc198.setTitle("助凝剂02加药泵停累计");
        mdtc198.setVisible(true);
        myDTCList.add(mdtc198);

        // 除磷剂加药泵 设备运行时间累积，小时
        MydataTableColumn mdtc199 = new MydataTableColumn();
        mdtc199.setData("ppRmvDosingRunTotal");
        mdtc199.setDefaultContent("199");
        mdtc199.setTitle("除磷剂加药泵累计");
        mdtc199.setVisible(true);
        myDTCList.add(mdtc199);

        //混反池2搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc200 = new MydataTableColumn();
        mdtc200.setData("bldOpstMixer02RunTotal");
        mdtc200.setDefaultContent("200");
        mdtc200.setTitle("混反池02搅拌机累计");
        mdtc200.setVisible(true);
        myDTCList.add(mdtc200);

        //混合池2搅拌机 设备运行时间累积，小时
        MydataTableColumn mdtc201 = new MydataTableColumn();
        mdtc201.setData("bldMixer02RunTotal");
        mdtc201.setDefaultContent("201");
        mdtc201.setTitle("混合池02搅拌机累计");
        mdtc201.setVisible(true);
        myDTCList.add(mdtc201);

        // 除磷池搅拌机  设备运行时间累积，小时
        MydataTableColumn mdtc202 = new MydataTableColumn();
        mdtc202.setData("ppRmvTankMixerRunTotal");
        mdtc202.setDefaultContent("202");
        mdtc202.setTitle("除磷池搅拌机累计");
        mdtc202.setVisible(true);
        myDTCList.add(mdtc202);

        //终沉池污泥泵 设备运行时间累积，小时
        MydataTableColumn mdtc203 = new MydataTableColumn();
        mdtc203.setData("finalSinkPumpRunTotal");
        mdtc203.setDefaultContent("203");
        mdtc203.setTitle("终沉池污泥泵累计");
        mdtc203.setVisible(true);
        myDTCList.add(mdtc203);

        /*********** 43个 设备开始运行时间 时*********************/
        //机械格栅 开始运行时间，XX时
        MydataTableColumn mdtc211 = new MydataTableColumn();
        mdtc211.setData("ydsgsRunSHour");
        mdtc211.setDefaultContent("211");
        mdtc211.setTitle("机械格栅-时");
        mdtc211.setVisible(true);
        myDTCList.add(mdtc211);

        //集水井提升泵 开始运行时间，XX时
        MydataTableColumn mdtc212 = new MydataTableColumn();
        mdtc212.setData("collectWellPumpRunSHour");
        mdtc212.setDefaultContent("212");
        mdtc212.setTitle("集水井提升泵-时");
        mdtc212.setVisible(true);
        myDTCList.add(mdtc212);

        //集水池搅拌机1 开始运行时间，XX时
        MydataTableColumn mdtc213 = new MydataTableColumn();
        mdtc213.setData("collectMixer01RunSHour");
        mdtc213.setDefaultContent("213");
        mdtc213.setTitle("集水池搅拌机1-时");
        mdtc213.setVisible(true);
        myDTCList.add(mdtc213);

        //集水池搅拌机2 开始运行时间，XX时
        MydataTableColumn mdtc214 = new MydataTableColumn();
        mdtc214.setData("collectMixer02RunSHour");
        mdtc214.setDefaultContent("214");
        mdtc214.setTitle("集水池搅拌机2-时");
        mdtc214.setVisible(true);
        myDTCList.add(mdtc214);

        //除磷投加机 开始运行时间，XX时
        MydataTableColumn mdtc215 = new MydataTableColumn();
        mdtc215.setData("dephosphorizeRunSHour");
        mdtc215.setDefaultContent("215");
        mdtc215.setTitle("除磷投加机-时");
        mdtc215.setVisible(true);
        myDTCList.add(mdtc215);

        //集水池提升泵 开始运行时间，XX时
        MydataTableColumn mdtc216 = new MydataTableColumn();
        mdtc216.setData("collectPumpRunSHour");
        mdtc216.setDefaultContent("216");
        mdtc216.setTitle("集水池提升泵-时");
        mdtc216.setVisible(true);
        myDTCList.add(mdtc216);

        //固液分离机 开始运行时间，XX时
        MydataTableColumn mdtc217 = new MydataTableColumn();
        mdtc217.setData("solLiqRunSHour");
        mdtc217.setDefaultContent("217");
        mdtc217.setTitle("固液分离机-时");
        mdtc217.setVisible(true);
        myDTCList.add(mdtc217);

        //混合池1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc218 = new MydataTableColumn();
        mdtc218.setData("bldMixer01RunSHour");
        mdtc218.setDefaultContent("218");
        mdtc218.setTitle("混合池1搅拌机-时");
        mdtc218.setVisible(true);
        myDTCList.add(mdtc218);

        //混反池1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc219 = new MydataTableColumn();
        mdtc219.setData("bldOpstMixer01RunSHour");
        mdtc219.setDefaultContent("219");
        mdtc219.setTitle("混反池1搅拌机-时");
        mdtc219.setVisible(true);
        myDTCList.add(mdtc219);

        //混沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc220 = new MydataTableColumn();
        mdtc220.setData("bldSinkPumpRunSHour");
        mdtc220.setDefaultContent("220");
        mdtc220.setTitle("混沉池污泥泵-时");
        mdtc220.setVisible(true);
        myDTCList.add(mdtc220);

        //混凝剂1搅拌机开始运行时间，XX时
        MydataTableColumn mdtc221 = new MydataTableColumn();
        mdtc221.setData("bldCglMixer01RunSHour");
        mdtc221.setDefaultContent("221");
        mdtc221.setTitle("混凝剂1搅拌机-时");
        mdtc221.setVisible(true);
        myDTCList.add(mdtc221);

        //混凝剂1加药泵 开始运行时间，XX时
        MydataTableColumn mdtc222 = new MydataTableColumn();
        mdtc222.setData("bldCglDosing01RunSHour");
        mdtc222.setDefaultContent("222");
        mdtc222.setTitle("混凝剂1加药泵-时");
        mdtc222.setVisible(true);
        myDTCList.add(mdtc222);

        //助凝剂1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc223 = new MydataTableColumn();
        mdtc223.setData("astCglMixer01RunSHour");
        mdtc223.setDefaultContent("223");
        mdtc223.setTitle("助凝剂1搅拌机-时");
        mdtc223.setVisible(true);
        myDTCList.add(mdtc223);

        //助凝剂1加药泵 开始运行时间，XX时
        MydataTableColumn mdtc224 = new MydataTableColumn();
        mdtc224.setData("astCglDosing01RunSHour");
        mdtc224.setDefaultContent("224");
        mdtc224.setTitle("助凝剂1加药泵-时");
        mdtc224.setVisible(true);
        myDTCList.add(mdtc224);

        //污泥池搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc225 = new MydataTableColumn();
        mdtc225.setData("sludgeMixerRunSHour");
        mdtc225.setDefaultContent("225");
        mdtc225.setTitle("污泥池搅拌机-时");
        mdtc225.setVisible(true);
        myDTCList.add(mdtc225);

        //泥水分离机进泥泵 开始运行时间，XX时
        MydataTableColumn mdtc226 = new MydataTableColumn();
        mdtc226.setData("slySeprtInPumpRunSHour");
        mdtc226.setDefaultContent("226");
        mdtc226.setTitle("泥水分离机进泥泵-时");
        mdtc226.setVisible(true);
        myDTCList.add(mdtc226);

        //絮凝剂加药泵 开始运行时间，XX时
        MydataTableColumn mdtc227 = new MydataTableColumn();
        mdtc227.setData("flocltDosingRunSHour");
        mdtc227.setDefaultContent("227");
        mdtc227.setTitle("絮凝剂加药泵-时");
        mdtc227.setVisible(true);
        myDTCList.add(mdtc227);

        //絮凝剂搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc228 = new MydataTableColumn();
        mdtc228.setData("flocltMixerRunSHour");
        mdtc228.setDefaultContent("228");
        mdtc228.setTitle("絮凝剂搅拌机-时");
        mdtc228.setVisible(true);
        myDTCList.add(mdtc228);

        //泥水分离机 开始运行时间，XX时
        MydataTableColumn mdtc229 = new MydataTableColumn();
        mdtc229.setData("slySeprtRunSHour");
        mdtc229.setDefaultContent("229");
        mdtc229.setTitle("泥水分离机-时");
        mdtc229.setVisible(true);
        myDTCList.add(mdtc229);

        //调节初沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc230 = new MydataTableColumn();
        mdtc230.setData("pmySinkPumpRunSHour");
        mdtc230.setDefaultContent("230");
        mdtc230.setTitle("调节初沉池污泥泵-时");
        mdtc230.setVisible(true);
        myDTCList.add(mdtc230);

        // SBR池进水泵 开始运行时间，XX时
        MydataTableColumn mdtc231 = new MydataTableColumn();
        mdtc231.setData("sbrIntakePumpRunSHour");
        mdtc231.setDefaultContent("231");
        mdtc231.setTitle("SBR池进水泵-时");
        mdtc231.setVisible(true);
        myDTCList.add(mdtc231);

        //风机1 开始运行时间，XX时
        MydataTableColumn mdtc232 = new MydataTableColumn();
        mdtc232.setData("fan01RunSHour");
        mdtc232.setDefaultContent("232");
        mdtc232.setTitle("风机01-时");
        mdtc232.setVisible(true);
        myDTCList.add(mdtc232);

        // 风机2 开始运行时间，XX时
        MydataTableColumn mdtc233 = new MydataTableColumn();
        mdtc233.setData("fan02RunSHour");
        mdtc233.setDefaultContent("233");
        mdtc233.setTitle("风机02-时");
        mdtc233.setVisible(true);
        myDTCList.add(mdtc233);

        //SBR池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc234 = new MydataTableColumn();
        mdtc234.setData("sbrSludegPumpRunSHour");
        mdtc234.setDefaultContent("234");
        mdtc234.setTitle("SBR池污泥泵-时");
        mdtc234.setVisible(true);
        myDTCList.add(mdtc234);

        //电动排水阀 开始运行时间，XX时
        MydataTableColumn mdtc235 = new MydataTableColumn();
        mdtc235.setData("eleDrainRunSHour");
        mdtc235.setDefaultContent("235");
        mdtc235.setTitle("电动排水阀-时");
        mdtc235.setVisible(true);
        myDTCList.add(mdtc235);

        // SBR池搅拌机1 开始运行时间，XX时
        MydataTableColumn mdtc236 = new MydataTableColumn();
        mdtc236.setData("sbrMixer01RunSHour");
        mdtc236.setDefaultContent("236");
        mdtc236.setTitle("SBR池搅拌机01-时");
        mdtc236.setVisible(true);
        myDTCList.add(mdtc236);

        //SBR池搅拌机2 开始运行时间，XX时
        MydataTableColumn mdtc237 = new MydataTableColumn();
        mdtc237.setData("sbrMixer02RunSHour");
        mdtc237.setDefaultContent("237");
        mdtc237.setTitle("SBR池搅拌机02-时");
        mdtc237.setVisible(true);
        myDTCList.add(mdtc237);

        //厌氧池进水泵 开始运行时间，XX时
        MydataTableColumn mdtc238 = new MydataTableColumn();
        mdtc238.setData("uasbInPumpRunSHour");
        mdtc238.setDefaultContent("238");
        mdtc238.setTitle("厌氧池进水泵-时");
        mdtc238.setVisible(true);
        myDTCList.add(mdtc238);

        //内回流泵 开始运行时间，XX时
        MydataTableColumn mdtc239 = new MydataTableColumn();
        mdtc239.setData("inBfPumpRunSHour");
        mdtc239.setDefaultContent("239");
        mdtc239.setTitle("内回流泵-时");
        mdtc239.setVisible(true);
        myDTCList.add(mdtc239);

        //外回流泵 开始运行时间，XX时
        MydataTableColumn mdtc240 = new MydataTableColumn();
        mdtc240.setData("outBfPumpRunSHour");
        mdtc240.setDefaultContent("240");
        mdtc240.setTitle("外回流泵-时");
        mdtc240.setVisible(true);
        myDTCList.add(mdtc240);

        //厌氧池搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc241 = new MydataTableColumn();
        mdtc241.setData("uasbMixerRunSHour");
        mdtc241.setDefaultContent("241");
        mdtc241.setTitle("厌氧池搅拌机-时");
        mdtc241.setVisible(true);
        myDTCList.add(mdtc241);

        //缺氧池搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc242 = new MydataTableColumn();
        mdtc242.setData("anoxiaMixerRunSHour");
        mdtc242.setDefaultContent("242");
        mdtc242.setTitle("缺氧池搅拌机-时");
        mdtc242.setVisible(true);
        myDTCList.add(mdtc242);

        //二沉池污泥泵开始运行时间，XX时
        MydataTableColumn mdtc243 = new MydataTableColumn();
        mdtc243.setData("secSinkPumpRunSHour");
        mdtc243.setDefaultContent("243");
        mdtc243.setTitle("二沉池污泥泵-时");
        mdtc243.setVisible(true);
        myDTCList.add(mdtc243);

        //混凝剂2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc244 = new MydataTableColumn();
        mdtc244.setData("bldCglMixer02RunSHour");
        mdtc244.setDefaultContent("244");
        mdtc244.setTitle("混凝剂2搅拌机-时");
        mdtc244.setVisible(true);
        myDTCList.add(mdtc244);

        // 助凝剂2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc245 = new MydataTableColumn();
        mdtc245.setData("astCglMixer02RunSHour");
        mdtc245.setDefaultContent("245");
        mdtc245.setTitle("助凝剂2搅拌机-时");
        mdtc245.setVisible(true);
        myDTCList.add(mdtc245);

        //除磷剂搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc246 = new MydataTableColumn();
        mdtc246.setData("ppRmvMixerRunSHour");
        mdtc246.setDefaultContent("246");
        mdtc246.setTitle("除磷剂搅拌机-时");
        mdtc246.setVisible(true);
        myDTCList.add(mdtc246);

        //混凝剂2加药泵开始运行时间，XX时
        MydataTableColumn mdtc247 = new MydataTableColumn();
        mdtc247.setData("bldCglDosing02RunSHour");
        mdtc247.setDefaultContent("247");
        mdtc247.setTitle("混凝剂02加药泵-时");
        mdtc247.setVisible(true);
        myDTCList.add(mdtc247);

        //助凝剂2加药泵开始运行时间，XX时
        MydataTableColumn mdtc248 = new MydataTableColumn();
        mdtc248.setData("astCglDosing02RunSHour");
        mdtc248.setDefaultContent("248");
        mdtc248.setTitle("助凝剂02加药泵停-时");
        mdtc248.setVisible(true);
        myDTCList.add(mdtc248);

        // 除磷剂加药泵 开始运行时间，XX时
        MydataTableColumn mdtc249 = new MydataTableColumn();
        mdtc249.setData("ppRmvDosingRunSHour");
        mdtc249.setDefaultContent("249");
        mdtc249.setTitle("除磷剂加药泵-时");
        mdtc249.setVisible(true);
        myDTCList.add(mdtc249);

        //混反池2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc250 = new MydataTableColumn();
        mdtc250.setData("bldOpstMixer02RunSHour");
        mdtc250.setDefaultContent("250");
        mdtc250.setTitle("混反池02搅拌机-时");
        mdtc250.setVisible(true);
        myDTCList.add(mdtc250);

        //混合池2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc251 = new MydataTableColumn();
        mdtc251.setData("bldMixer02RunSHour");
        mdtc251.setDefaultContent("251");
        mdtc251.setTitle("混合池02搅拌机-时");
        mdtc251.setVisible(true);
        myDTCList.add(mdtc251);

        // 除磷池搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc252 = new MydataTableColumn();
        mdtc252.setData("ppRmvTankMixerRunSHour");
        mdtc252.setDefaultContent("252");
        mdtc252.setTitle("除磷池搅拌机-时");
        mdtc252.setVisible(true);
        myDTCList.add(mdtc252);

        //终沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc253 = new MydataTableColumn();
        mdtc253.setData("finalSinkPumpRunSHour");
        mdtc253.setDefaultContent("253");
        mdtc253.setTitle("终沉池污泥泵-时");
        mdtc253.setVisible(true);
        myDTCList.add(mdtc253);

        /*********** 43个 设备开始运行时间 分********************/
        //机械格栅 开始运行时间，XX时
        MydataTableColumn mdtc261 = new MydataTableColumn();
        mdtc261.setData("ydsgsRunSMin");
        mdtc261.setDefaultContent("261");
        mdtc261.setTitle("机械格栅-分");
        mdtc261.setVisible(true);
        myDTCList.add(mdtc261);

        //集水井提升泵 开始运行时间，XX时
        MydataTableColumn mdtc262 = new MydataTableColumn();
        mdtc262.setData("collectWellPumpRunSMin");
        mdtc262.setDefaultContent("262");
        mdtc262.setTitle("集水井提升泵-分");
        mdtc262.setVisible(true);
        myDTCList.add(mdtc262);

        //集水池搅拌机1 开始运行时间，XX时
        MydataTableColumn mdtc263 = new MydataTableColumn();
        mdtc263.setData("collectMixer01RunSMin");
        mdtc263.setDefaultContent("263");
        mdtc263.setTitle("集水池搅拌机1-分");
        mdtc263.setVisible(true);
        myDTCList.add(mdtc263);

        //集水池搅拌机2 开始运行时间，XX时
        MydataTableColumn mdtc264 = new MydataTableColumn();
        mdtc264.setData("collectMixer02RunSMin");
        mdtc264.setDefaultContent("264");
        mdtc264.setTitle("集水池搅拌机2-分");
        mdtc264.setVisible(true);
        myDTCList.add(mdtc264);

        //除磷投加机 开始运行时间，XX时
        MydataTableColumn mdtc265 = new MydataTableColumn();
        mdtc265.setData("dephosphorizeRunSMin");
        mdtc265.setDefaultContent("265");
        mdtc265.setTitle("除磷投加机-分");
        mdtc265.setVisible(true);
        myDTCList.add(mdtc265);

        //集水池提升泵 开始运行时间，XX时
        MydataTableColumn mdtc266 = new MydataTableColumn();
        mdtc266.setData("collectPumpRunSMin");
        mdtc266.setDefaultContent("266");
        mdtc266.setTitle("集水池提升泵-分");
        mdtc266.setVisible(true);
        myDTCList.add(mdtc266);

        //固液分离机 开始运行时间，XX时
        MydataTableColumn mdtc267 = new MydataTableColumn();
        mdtc267.setData("solLiqRunSMin");
        mdtc267.setDefaultContent("267");
        mdtc267.setTitle("固液分离机-分");
        mdtc267.setVisible(true);
        myDTCList.add(mdtc267);

        //混合池1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc268 = new MydataTableColumn();
        mdtc268.setData("bldMixer01RunSMin");
        mdtc268.setDefaultContent("268");
        mdtc268.setTitle("混合池1搅拌机-分");
        mdtc268.setVisible(true);
        myDTCList.add(mdtc268);

        //混反池1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc269 = new MydataTableColumn();
        mdtc269.setData("bldOpstMixer01RunSMin");
        mdtc269.setDefaultContent("269");
        mdtc269.setTitle("混反池1搅拌机-分");
        mdtc269.setVisible(true);
        myDTCList.add(mdtc269);

        //混沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc270 = new MydataTableColumn();
        mdtc270.setData("bldSinkPumpRunSMin");
        mdtc270.setDefaultContent("270");
        mdtc270.setTitle("混沉池污泥泵-分");
        mdtc270.setVisible(true);
        myDTCList.add(mdtc270);

        //混凝剂1搅拌机开始运行时间，XX时
        MydataTableColumn mdtc271 = new MydataTableColumn();
        mdtc271.setData("bldCglMixer01RunSMin");
        mdtc271.setDefaultContent("271");
        mdtc271.setTitle("混凝剂1搅拌机-分");
        mdtc271.setVisible(true);
        myDTCList.add(mdtc271);

        //混凝剂1加药泵 开始运行时间，XX时
        MydataTableColumn mdtc272 = new MydataTableColumn();
        mdtc272.setData("bldCglDosing01RunSMin");
        mdtc272.setDefaultContent("272");
        mdtc272.setTitle("混凝剂1加药泵-分");
        mdtc272.setVisible(true);
        myDTCList.add(mdtc272);

        //助凝剂1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc273 = new MydataTableColumn();
        mdtc273.setData("astCglMixer01RunSMin");
        mdtc273.setDefaultContent("273");
        mdtc273.setTitle("助凝剂1搅拌机-分");
        mdtc273.setVisible(true);
        myDTCList.add(mdtc273);

        //助凝剂1加药泵 开始运行时间，XX时
        MydataTableColumn mdtc274 = new MydataTableColumn();
        mdtc274.setData("astCglDosing01RunSMin");
        mdtc274.setDefaultContent("274");
        mdtc274.setTitle("助凝剂1加药泵-分");
        mdtc274.setVisible(true);
        myDTCList.add(mdtc274);

        //污泥池搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc275 = new MydataTableColumn();
        mdtc275.setData("sludgeMixerRunSMin");
        mdtc275.setDefaultContent("275");
        mdtc275.setTitle("污泥池搅拌机-分");
        mdtc275.setVisible(true);
        myDTCList.add(mdtc275);

        //泥水分离机进泥泵 开始运行时间，XX时
        MydataTableColumn mdtc276 = new MydataTableColumn();
        mdtc276.setData("slySeprtInPumpRunSMin");
        mdtc276.setDefaultContent("276");
        mdtc276.setTitle("泥水分离机进泥泵-分");
        mdtc276.setVisible(true);
        myDTCList.add(mdtc276);

        //絮凝剂加药泵 开始运行时间，XX时
        MydataTableColumn mdtc277 = new MydataTableColumn();
        mdtc277.setData("flocltDosingRunSMin");
        mdtc277.setDefaultContent("277");
        mdtc277.setTitle("絮凝剂加药泵-分");
        mdtc277.setVisible(true);
        myDTCList.add(mdtc277);

        //絮凝剂搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc278 = new MydataTableColumn();
        mdtc278.setData("flocltMixerRunSMin");
        mdtc278.setDefaultContent("278");
        mdtc278.setTitle("絮凝剂搅拌机-分");
        mdtc278.setVisible(true);
        myDTCList.add(mdtc278);

        //泥水分离机 开始运行时间，XX时
        MydataTableColumn mdtc279 = new MydataTableColumn();
        mdtc279.setData("slySeprtRunSMin");
        mdtc279.setDefaultContent("279");
        mdtc279.setTitle("泥水分离机-分");
        mdtc279.setVisible(true);
        myDTCList.add(mdtc279);

        //调节初沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc280 = new MydataTableColumn();
        mdtc280.setData("pmySinkPumpRunSMin");
        mdtc280.setDefaultContent("280");
        mdtc280.setTitle("调节初沉池污泥泵-分");
        mdtc280.setVisible(true);
        myDTCList.add(mdtc280);

        // SBR池进水泵 开始运行时间，XX时
        MydataTableColumn mdtc281 = new MydataTableColumn();
        mdtc281.setData("sbrIntakePumpRunSMin");
        mdtc281.setDefaultContent("281");
        mdtc281.setTitle("SBR池进水泵-分");
        mdtc281.setVisible(true);
        myDTCList.add(mdtc281);

        //风机1 开始运行时间，XX时
        MydataTableColumn mdtc282 = new MydataTableColumn();
        mdtc282.setData("fan01RunSMin");
        mdtc282.setDefaultContent("282");
        mdtc282.setTitle("风机01-分");
        mdtc282.setVisible(true);
        myDTCList.add(mdtc282);

        // 风机2 开始运行时间，XX时
        MydataTableColumn mdtc283 = new MydataTableColumn();
        mdtc283.setData("fan02RunSMin");
        mdtc283.setDefaultContent("283");
        mdtc283.setTitle("风机02-分");
        mdtc283.setVisible(true);
        myDTCList.add(mdtc283);

        //SBR池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc284 = new MydataTableColumn();
        mdtc284.setData("sbrSludegPumpRunSMin");
        mdtc284.setDefaultContent("284");
        mdtc284.setTitle("SBR池污泥泵-分");
        mdtc284.setVisible(true);
        myDTCList.add(mdtc284);

        //电动排水阀 开始运行时间，XX时
        MydataTableColumn mdtc285 = new MydataTableColumn();
        mdtc285.setData("eleDrainRunSMin");
        mdtc285.setDefaultContent("285");
        mdtc285.setTitle("电动排水阀-分");
        mdtc285.setVisible(true);
        myDTCList.add(mdtc285);

        // SBR池搅拌机1 开始运行时间，XX时
        MydataTableColumn mdtc286 = new MydataTableColumn();
        mdtc286.setData("sbrMixer01RunSMin");
        mdtc286.setDefaultContent("286");
        mdtc286.setTitle("SBR池搅拌机01-分");
        mdtc286.setVisible(true);
        myDTCList.add(mdtc286);

        //SBR池搅拌机2 开始运行时间，XX时
        MydataTableColumn mdtc287 = new MydataTableColumn();
        mdtc287.setData("sbrMixer02RunSMin");
        mdtc287.setDefaultContent("287");
        mdtc287.setTitle("SBR池搅拌机02-分");
        mdtc287.setVisible(true);
        myDTCList.add(mdtc287);

        //厌氧池进水泵 开始运行时间，XX时
        MydataTableColumn mdtc288 = new MydataTableColumn();
        mdtc288.setData("uasbInPumpRunSMin");
        mdtc288.setDefaultContent("288");
        mdtc288.setTitle("厌氧池进水泵-分");
        mdtc288.setVisible(true);
        myDTCList.add(mdtc288);

        //内回流泵 开始运行时间，XX时
        MydataTableColumn mdtc289 = new MydataTableColumn();
        mdtc289.setData("inBfPumpRunSMin");
        mdtc289.setDefaultContent("289");
        mdtc289.setTitle("内回流泵-分");
        mdtc289.setVisible(true);
        myDTCList.add(mdtc289);

        //外回流泵 开始运行时间，XX时
        MydataTableColumn mdtc290 = new MydataTableColumn();
        mdtc290.setData("outBfPumpRunSMin");
        mdtc290.setDefaultContent("290");
        mdtc290.setTitle("外回流泵-分");
        mdtc290.setVisible(true);
        myDTCList.add(mdtc290);

        //厌氧池搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc291 = new MydataTableColumn();
        mdtc291.setData("uasbMixerRunSMin");
        mdtc291.setDefaultContent("291");
        mdtc291.setTitle("厌氧池搅拌机-分");
        mdtc291.setVisible(true);
        myDTCList.add(mdtc291);

        //缺氧池搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc292 = new MydataTableColumn();
        mdtc292.setData("anoxiaMixerRunSMin");
        mdtc292.setDefaultContent("292");
        mdtc292.setTitle("缺氧池搅拌机-分");
        mdtc292.setVisible(true);
        myDTCList.add(mdtc292);

        //二沉池污泥泵开始运行时间，XX时
        MydataTableColumn mdtc293 = new MydataTableColumn();
        mdtc293.setData("secSinkPumpRunSMin");
        mdtc293.setDefaultContent("293");
        mdtc293.setTitle("二沉池污泥泵-分");
        mdtc293.setVisible(true);
        myDTCList.add(mdtc293);

        //混凝剂2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc294 = new MydataTableColumn();
        mdtc294.setData("bldCglMixer02RunSMin");
        mdtc294.setDefaultContent("294");
        mdtc294.setTitle("混凝剂2搅拌机-分");
        mdtc294.setVisible(true);
        myDTCList.add(mdtc294);

        // 助凝剂2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc295 = new MydataTableColumn();
        mdtc295.setData("astCglMixer02RunSMin");
        mdtc295.setDefaultContent("295");
        mdtc295.setTitle("助凝剂2搅拌机-分");
        mdtc295.setVisible(true);
        myDTCList.add(mdtc295);

        //除磷剂搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc296 = new MydataTableColumn();
        mdtc296.setData("ppRmvMixerRunSMin");
        mdtc296.setDefaultContent("296");
        mdtc296.setTitle("除磷剂搅拌机-分");
        mdtc296.setVisible(true);
        myDTCList.add(mdtc296);

        //混凝剂2加药泵开始运行时间，XX时
        MydataTableColumn mdtc297 = new MydataTableColumn();
        mdtc297.setData("bldCglDosing02RunSMin");
        mdtc297.setDefaultContent("297");
        mdtc297.setTitle("混凝剂02加药泵-分");
        mdtc297.setVisible(true);
        myDTCList.add(mdtc297);

        //助凝剂2加药泵开始运行时间，XX时
        MydataTableColumn mdtc298 = new MydataTableColumn();
        mdtc298.setData("astCglDosing02RunSMin");
        mdtc298.setDefaultContent("298");
        mdtc298.setTitle("助凝剂02加药泵停-分");
        mdtc298.setVisible(true);
        myDTCList.add(mdtc298);

        // 除磷剂加药泵 开始运行时间，XX时
        MydataTableColumn mdtc299 = new MydataTableColumn();
        mdtc299.setData("ppRmvDosingRunSMin");
        mdtc299.setDefaultContent("299");
        mdtc299.setTitle("除磷剂加药泵-分");
        mdtc299.setVisible(true);
        myDTCList.add(mdtc299);

        //混反池2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc300 = new MydataTableColumn();
        mdtc300.setData("bldOpstMixer02RunSMin");
        mdtc300.setDefaultContent("300");
        mdtc300.setTitle("混反池02搅拌机-分");
        mdtc300.setVisible(true);
        myDTCList.add(mdtc300);

        //混合池2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc301 = new MydataTableColumn();
        mdtc301.setData("bldMixer02RunSMin");
        mdtc301.setDefaultContent("301");
        mdtc301.setTitle("混合池02搅拌机-分");
        mdtc301.setVisible(true);
        myDTCList.add(mdtc301);

        // 除磷池搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc302 = new MydataTableColumn();
        mdtc302.setData("ppRmvTankMixerRunSMin");
        mdtc302.setDefaultContent("302");
        mdtc302.setTitle("除磷池搅拌机-分");
        mdtc302.setVisible(true);
        myDTCList.add(mdtc302);

        //终沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc303 = new MydataTableColumn();
        mdtc303.setData("finalSinkPumpRunSMin");
        mdtc303.setDefaultContent("303");
        mdtc303.setTitle("终沉池污泥泵-分");
        mdtc303.setVisible(true);
        myDTCList.add(mdtc303);

        /*********** 9个 单个工艺流程运行时间 *********************/
        //进水泵工作状态运行时间，分钟
        MydataTableColumn mdtc304 = new MydataTableColumn();
        mdtc304.setData("inPumpRunMin");
        mdtc304.setDefaultContent("304");
        mdtc304.setTitle("进水泵单次时间");
        mdtc304.setVisible(true);
        myDTCList.add(mdtc304);

        // SBR池一次搅拌 运行时间，分钟
        MydataTableColumn mdtc305 = new MydataTableColumn();
        mdtc305.setData("sbrMixerOnceRunMin");
        mdtc305.setDefaultContent("305");
        mdtc305.setTitle("SBR一次搅拌单次时间");
        mdtc305.setVisible(true);
        myDTCList.add(mdtc305);

        // 风机运行时间，分钟
        MydataTableColumn mdtc306 = new MydataTableColumn();
        mdtc306.setData("fanRunMin");
        mdtc306.setDefaultContent("306");
        mdtc306.setTitle("风机单次时间");
        mdtc306.setVisible(true);
        myDTCList.add(mdtc306);

        // SBR池二次搅拌 运行时间，分钟
        MydataTableColumn mdtc307 = new MydataTableColumn();
        mdtc307.setData("sbrMixerSecRunMin");
        mdtc307.setDefaultContent("307");
        mdtc307.setTitle("SBR池二次搅拌单次时间");
        mdtc307.setVisible(true);
        myDTCList.add(mdtc307);

        //静置沉淀状态持续时间 运行时间，分钟
        MydataTableColumn mdtc308 = new MydataTableColumn();
        mdtc308.setData("sbrMixerSecRunMin");
        mdtc308.setDefaultContent("308");
        mdtc308.setTitle("静置沉淀状单次时间");
        mdtc308.setVisible(true);
        myDTCList.add(mdtc308);

        //电动排水阀开状态持续时间，分钟
        MydataTableColumn mdtc309 = new MydataTableColumn();
        mdtc309.setData("sbrMixerSecRunMin");
        mdtc309.setDefaultContent("308");
        mdtc309.setTitle("电动排水阀开持续时间");
        mdtc309.setVisible(true);
        myDTCList.add(mdtc309);

        //电动排水阀关状态持续时间，分钟
        MydataTableColumn mdtc310 = new MydataTableColumn();
        mdtc310.setData("decanterOnRunMin");
        mdtc310.setDefaultContent("310");
        mdtc310.setTitle("电动排水阀关持续时间");
        mdtc310.setVisible(true);
        myDTCList.add(mdtc310);

        /*********** 43 故障指示  *********************/
        //机械格栅 开始运行时间，XX时
        MydataTableColumn mdtc311 = new MydataTableColumn();
        mdtc311.setData("ydsgsFault");
        mdtc311.setDefaultContent("311");
        mdtc311.setTitle("机械格栅故障");
        mdtc311.setVisible(true);
        myDTCList.add(mdtc311);

        //集水井提升泵 开始运行时间，XX时
        MydataTableColumn mdtc312 = new MydataTableColumn();
        mdtc312.setData("collectWellPumpFault");
        mdtc312.setDefaultContent("312");
        mdtc312.setTitle("集水井提升泵故障");
        mdtc312.setVisible(true);
        myDTCList.add(mdtc312);

        //集水池搅拌机1 开始运行时间，XX时
        MydataTableColumn mdtc313 = new MydataTableColumn();
        mdtc313.setData("collectMixer01Fault");
        mdtc313.setDefaultContent("313");
        mdtc313.setTitle("集水池搅拌机1故障");
        mdtc313.setVisible(true);
        myDTCList.add(mdtc313);

        //集水池搅拌机2 开始运行时间，XX时
        MydataTableColumn mdtc314 = new MydataTableColumn();
        mdtc314.setData("collectMixer02Fault");
        mdtc314.setDefaultContent("314");
        mdtc314.setTitle("集水池搅拌机2故障");
        mdtc314.setVisible(true);
        myDTCList.add(mdtc314);

        //除磷投加机 开始运行时间，XX时
        MydataTableColumn mdtc315 = new MydataTableColumn();
        mdtc315.setData("dephosphorizeFault");
        mdtc315.setDefaultContent("315");
        mdtc315.setTitle("除磷投加机故障");
        mdtc315.setVisible(true);
        myDTCList.add(mdtc315);

        //集水池提升泵 开始运行时间，XX时
        MydataTableColumn mdtc316 = new MydataTableColumn();
        mdtc316.setData("collectPumpFault");
        mdtc316.setDefaultContent("316");
        mdtc316.setTitle("集水池提升泵故障");
        mdtc316.setVisible(true);
        myDTCList.add(mdtc316);

        //固液分离机 开始运行时间，XX时
        MydataTableColumn mdtc317 = new MydataTableColumn();
        mdtc317.setData("solLiqFault");
        mdtc317.setDefaultContent("317");
        mdtc317.setTitle("固液分离机故障");
        mdtc317.setVisible(true);
        myDTCList.add(mdtc317);

        //混合池1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc318 = new MydataTableColumn();
        mdtc318.setData("bldMixer01Fault");
        mdtc318.setDefaultContent("318");
        mdtc318.setTitle("混合池1搅拌机故障");
        mdtc318.setVisible(true);
        myDTCList.add(mdtc318);

        //混反池1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc319 = new MydataTableColumn();
        mdtc319.setData("bldOpstMixer01Fault");
        mdtc319.setDefaultContent("319");
        mdtc319.setTitle("混反池1搅拌机故障");
        mdtc319.setVisible(true);
        myDTCList.add(mdtc319);

        //混沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc320 = new MydataTableColumn();
        mdtc320.setData("bldSinkPumpFault");
        mdtc320.setDefaultContent("320");
        mdtc320.setTitle("混沉池污泥泵故障");
        mdtc320.setVisible(true);
        myDTCList.add(mdtc320);

        //混凝剂1搅拌机开始运行时间，XX时
        MydataTableColumn mdtc321 = new MydataTableColumn();
        mdtc321.setData("bldCglMixer01Fault");
        mdtc321.setDefaultContent("321");
        mdtc321.setTitle("混凝剂1搅拌机故障");
        mdtc321.setVisible(true);
        myDTCList.add(mdtc321);

        //混凝剂1加药泵 开始运行时间，XX时
        MydataTableColumn mdtc322 = new MydataTableColumn();
        mdtc322.setData("bldCglDosing01Fault");
        mdtc322.setDefaultContent("322");
        mdtc322.setTitle("混凝剂1加药泵故障");
        mdtc322.setVisible(true);
        myDTCList.add(mdtc322);

        //助凝剂1搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc323 = new MydataTableColumn();
        mdtc323.setData("astCglMixer01Fault");
        mdtc323.setDefaultContent("323");
        mdtc323.setTitle("助凝剂1搅拌机故障");
        mdtc323.setVisible(true);
        myDTCList.add(mdtc323);

        //助凝剂1加药泵 开始运行时间，XX时
        MydataTableColumn mdtc324 = new MydataTableColumn();
        mdtc324.setData("astCglDosing01Fault");
        mdtc324.setDefaultContent("324");
        mdtc324.setTitle("助凝剂1加药泵故障");
        mdtc324.setVisible(true);
        myDTCList.add(mdtc324);

        //污泥池搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc325 = new MydataTableColumn();
        mdtc325.setData("sludgeMixerFault");
        mdtc325.setDefaultContent("325");
        mdtc325.setTitle("污泥池搅拌机故障");
        mdtc325.setVisible(true);
        myDTCList.add(mdtc325);

        //泥水分离机进泥泵 开始运行时间，XX时
        MydataTableColumn mdtc326 = new MydataTableColumn();
        mdtc326.setData("slySeprtInPumpFault");
        mdtc326.setDefaultContent("326");
        mdtc326.setTitle("泥水分离机进泥泵故障");
        mdtc326.setVisible(true);
        myDTCList.add(mdtc326);

        //絮凝剂加药泵 开始运行时间，XX时
        MydataTableColumn mdtc327 = new MydataTableColumn();
        mdtc327.setData("flocltDosingFault");
        mdtc327.setDefaultContent("327");
        mdtc327.setTitle("絮凝剂加药泵故障");
        mdtc327.setVisible(true);
        myDTCList.add(mdtc327);

        //絮凝剂搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc328 = new MydataTableColumn();
        mdtc328.setData("flocltMixerFault");
        mdtc328.setDefaultContent("328");
        mdtc328.setTitle("絮凝剂搅拌机故障");
        mdtc328.setVisible(true);
        myDTCList.add(mdtc328);

        //泥水分离机 开始运行时间，XX时
        MydataTableColumn mdtc329 = new MydataTableColumn();
        mdtc329.setData("slySeprtFault");
        mdtc329.setDefaultContent("329");
        mdtc329.setTitle("泥水分离机故障");
        mdtc329.setVisible(true);
        myDTCList.add(mdtc329);

        //调节初沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc330 = new MydataTableColumn();
        mdtc330.setData("pmySinkPumpFault");
        mdtc330.setDefaultContent("330");
        mdtc330.setTitle("调节初沉池污泥泵故障");
        mdtc330.setVisible(true);
        myDTCList.add(mdtc330);

        // SBR池进水泵 开始运行时间，XX时
        MydataTableColumn mdtc331 = new MydataTableColumn();
        mdtc331.setData("sbrIntakePumpFault");
        mdtc331.setDefaultContent("331");
        mdtc331.setTitle("SBR池进水泵故障");
        mdtc331.setVisible(true);
        myDTCList.add(mdtc331);

        //风机1 开始运行时间，XX时
        MydataTableColumn mdtc332 = new MydataTableColumn();
        mdtc332.setData("fan01Fault");
        mdtc332.setDefaultContent("332");
        mdtc332.setTitle("风机01故障");
        mdtc332.setVisible(true);
        myDTCList.add(mdtc332);

        // 风机2 开始运行时间，XX时
        MydataTableColumn mdtc333 = new MydataTableColumn();
        mdtc333.setData("fan02Fault");
        mdtc333.setDefaultContent("333");
        mdtc333.setTitle("风机02故障");
        mdtc333.setVisible(true);
        myDTCList.add(mdtc333);

        //SBR池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc334 = new MydataTableColumn();
        mdtc334.setData("sbrSludegPumpFault");
        mdtc334.setDefaultContent("334");
        mdtc334.setTitle("SBR池污泥泵故障");
        mdtc334.setVisible(true);
        myDTCList.add(mdtc334);

        //电动排水阀 开始运行时间，XX时
        MydataTableColumn mdtc335 = new MydataTableColumn();
        mdtc335.setData("eleDrainFault");
        mdtc335.setDefaultContent("335");
        mdtc335.setTitle("电动排水阀故障");
        mdtc335.setVisible(true);
        myDTCList.add(mdtc335);

        // SBR池搅拌机1 开始运行时间，XX时
        MydataTableColumn mdtc336 = new MydataTableColumn();
        mdtc336.setData("sbrMixer01Fault");
        mdtc336.setDefaultContent("336");
        mdtc336.setTitle("SBR池搅拌机01故障");
        mdtc336.setVisible(true);
        myDTCList.add(mdtc336);

        //SBR池搅拌机2 开始运行时间，XX时
        MydataTableColumn mdtc337 = new MydataTableColumn();
        mdtc337.setData("sbrMixer02Fault");
        mdtc337.setDefaultContent("337");
        mdtc337.setTitle("SBR池搅拌机02故障");
        mdtc337.setVisible(true);
        myDTCList.add(mdtc337);

        //厌氧池进水泵 开始运行时间，XX时
        MydataTableColumn mdtc338 = new MydataTableColumn();
        mdtc338.setData("uasbInPumpFault");
        mdtc338.setDefaultContent("338");
        mdtc338.setTitle("厌氧池进水泵故障");
        mdtc338.setVisible(true);
        myDTCList.add(mdtc338);

        //内回流泵 开始运行时间，XX时
        MydataTableColumn mdtc339 = new MydataTableColumn();
        mdtc339.setData("inBfPumpFault");
        mdtc339.setDefaultContent("339");
        mdtc339.setTitle("内回流泵故障");
        mdtc339.setVisible(true);
        myDTCList.add(mdtc339);

        //外回流泵 开始运行时间，XX时
        MydataTableColumn mdtc340 = new MydataTableColumn();
        mdtc340.setData("outBfPumpFault");
        mdtc340.setDefaultContent("340");
        mdtc340.setTitle("外回流泵故障");
        mdtc340.setVisible(true);
        myDTCList.add(mdtc340);

        //厌氧池搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc341 = new MydataTableColumn();
        mdtc341.setData("uasbMixerFault");
        mdtc341.setDefaultContent("341");
        mdtc341.setTitle("厌氧池搅拌机故障");
        mdtc341.setVisible(true);
        myDTCList.add(mdtc341);

        //缺氧池搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc342 = new MydataTableColumn();
        mdtc342.setData("anoxiaMixerFault");
        mdtc342.setDefaultContent("342");
        mdtc342.setTitle("缺氧池搅拌机故障");
        mdtc342.setVisible(true);
        myDTCList.add(mdtc342);

        //二沉池污泥泵开始运行时间，XX时
        MydataTableColumn mdtc343 = new MydataTableColumn();
        mdtc343.setData("secSinkPumpFault");
        mdtc343.setDefaultContent("343");
        mdtc343.setTitle("二沉池污泥泵故障");
        mdtc343.setVisible(true);
        myDTCList.add(mdtc343);

        //混凝剂2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc344 = new MydataTableColumn();
        mdtc344.setData("bldCglMixer02Fault");
        mdtc344.setDefaultContent("344");
        mdtc344.setTitle("混凝剂2搅拌机故障");
        mdtc344.setVisible(true);
        myDTCList.add(mdtc344);

        // 助凝剂2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc345 = new MydataTableColumn();
        mdtc345.setData("astCglMixer02Fault");
        mdtc345.setDefaultContent("345");
        mdtc345.setTitle("助凝剂2搅拌机故障");
        mdtc345.setVisible(true);
        myDTCList.add(mdtc345);

        //除磷剂搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc346 = new MydataTableColumn();
        mdtc346.setData("ppRmvMixerFault");
        mdtc346.setDefaultContent("346");
        mdtc346.setTitle("除磷剂搅拌机故障");
        mdtc346.setVisible(true);
        myDTCList.add(mdtc346);

        //混凝剂2加药泵开始运行时间，XX时
        MydataTableColumn mdtc347 = new MydataTableColumn();
        mdtc347.setData("bldCglDosing02Fault");
        mdtc347.setDefaultContent("347");
        mdtc347.setTitle("混凝剂02加药泵故障");
        mdtc347.setVisible(true);
        myDTCList.add(mdtc347);

        //助凝剂2加药泵开始运行时间，XX时
        MydataTableColumn mdtc348 = new MydataTableColumn();
        mdtc348.setData("astCglDosing02Fault");
        mdtc348.setDefaultContent("348");
        mdtc348.setTitle("助凝剂02加药泵停故障");
        mdtc348.setVisible(true);
        myDTCList.add(mdtc348);

        // 除磷剂加药泵 开始运行时间，XX时
        MydataTableColumn mdtc349 = new MydataTableColumn();
        mdtc349.setData("ppRmvDosingFault");
        mdtc349.setDefaultContent("349");
        mdtc349.setTitle("除磷剂加药泵故障");
        mdtc349.setVisible(true);
        myDTCList.add(mdtc349);

        //混反池2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc350 = new MydataTableColumn();
        mdtc350.setData("bldOpstMixer02Fault");
        mdtc350.setDefaultContent("350");
        mdtc350.setTitle("混反池02搅拌机故障");
        mdtc350.setVisible(true);
        myDTCList.add(mdtc350);

        //混合池2搅拌机 开始运行时间，XX时
        MydataTableColumn mdtc351 = new MydataTableColumn();
        mdtc351.setData("bldMixer02Fault");
        mdtc351.setDefaultContent("351");
        mdtc351.setTitle("混合池02搅拌机故障");
        mdtc351.setVisible(true);
        myDTCList.add(mdtc351);

        // 除磷池搅拌机  开始运行时间，XX时
        MydataTableColumn mdtc352 = new MydataTableColumn();
        mdtc352.setData("ppRmvTankMixerFault");
        mdtc352.setDefaultContent("352");
        mdtc352.setTitle("除磷池搅拌机故障");
        mdtc352.setVisible(true);
        myDTCList.add(mdtc352);

        //终沉池污泥泵 开始运行时间，XX时
        MydataTableColumn mdtc353 = new MydataTableColumn();
        mdtc353.setData("finalSinkPumpFault");
        mdtc353.setDefaultContent("353");
        mdtc353.setTitle("终沉池污泥泵故障");
        mdtc353.setVisible(true);
        myDTCList.add(mdtc353);

        return myDTCList;
    }

    public List<PhoneRealMsgInfo> getPhoneRealMsgInfoSummary() {
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = new ArrayList<PhoneRealMsgInfo>();
        PhoneRealMsgInfo phoneRealMsgInfo01 = new PhoneRealMsgInfo();
        phoneRealMsgInfo01.setId("flowmeter");
        phoneRealMsgInfo01.setTitle("累计流量：");
        phoneRealMsgInfo01.setValue(String.valueOf(flowmeter) + "m³");
        phoneRealMsgInfo01.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo01);

        PhoneRealMsgInfo phoneRealMsgInfo02 = new PhoneRealMsgInfo();
        phoneRealMsgInfo02.setId("todayFlowmeter");
        phoneRealMsgInfo02.setTitle("当日流量：");
        phoneRealMsgInfo02.setValue(String.valueOf(todayFlowmeter) + "m³");
        phoneRealMsgInfo02.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo02);

        PhoneRealMsgInfo phoneRealMsgInfo03 = new PhoneRealMsgInfo();
        phoneRealMsgInfo03.setId("systemAuto");
        phoneRealMsgInfo03.setTitle("自动模式：");
        if(systemAuto == true) {
            phoneRealMsgInfo03.setValue("自动");
        }else{
            phoneRealMsgInfo03.setValue("手动");
        }
        phoneRealMsgInfo03.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo03);

        PhoneRealMsgInfo phoneRealMsgInfo04 = new PhoneRealMsgInfo();
        phoneRealMsgInfo04.setId("sbrCycle");
        phoneRealMsgInfo04.setTitle("SBR周期运行：");
        phoneRealMsgInfo04.setValue("运行");
        phoneRealMsgInfo04.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo04);

        PhoneRealMsgInfo phoneRealMsgInfo07 = new PhoneRealMsgInfo();
        phoneRealMsgInfo07.setId("waterTemp01");
        phoneRealMsgInfo07.setTitle("SBR池水温：");
        phoneRealMsgInfo07.setValue(String.valueOf(waterTemp01) + "℃");
        phoneRealMsgInfo07.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo07);

        PhoneRealMsgInfo phoneRealMsgInfo05 = new PhoneRealMsgInfo();
        phoneRealMsgInfo05.setId("dState");
        phoneRealMsgInfo05.setTitle("状态：");
        phoneRealMsgInfo05.setValue(getDState());
        phoneRealMsgInfo05.setFlag("1");
        phoneRealMsgInfoList.add(phoneRealMsgInfo05);

        PhoneRealMsgInfo phoneRealMsgInfo06 = new PhoneRealMsgInfo();
        phoneRealMsgInfo06.setId("sendDate");
        phoneRealMsgInfo06.setTitle("");
        phoneRealMsgInfo06.setValue(this.getSendDate());
        phoneRealMsgInfo06.setFlag("0");
        phoneRealMsgInfoList.add(phoneRealMsgInfo06);

        return phoneRealMsgInfoList;
    }

    public List<PSwg215OnePart> getPhoneRealMsgInfoDetail() {
        List<PSwg215OnePart> pSwg215OneParts = new ArrayList<PSwg215OnePart>();
        int sbrA2o = this.getSpare475476();
        if(sbrA2o == 0){
        //默认 SBR工艺
            pSwg215OneParts = Swg215Util.formatSBR(this);
        }else{
            pSwg215OneParts = Swg215Util.formatA2O(this);
        }
        return pSwg215OneParts;

    }

}
