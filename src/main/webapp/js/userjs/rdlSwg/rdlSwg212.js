
//************************SewageC212 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC212(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSewageC212ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                /*************抬头***************/
                    //水流量
                var flowmeter212 = document.getElementById("flowmeter212");
                //时间
                var sewagec212sendDate = document.getElementById("sewagec212sendDate");
                //水流量
                flowmeter212.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec212sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter212 = document.getElementById("todayFlowmeter212");
                //当日水流量
                todayFlowmeter212.innerHTML = result.todayFlowmeter + "m³";
                //累计电量
                var totalEp212 = document.getElementById("totalEp212");
                //累计电量
                totalEp212.innerHTML = result.impEP + "";
                //当日电量
                var todayEp212 = document.getElementById("todayEp212");
                //当日电量
                todayEp212.innerHTML = result.todayEP + "";
                //环境温度
                var airTemp212 = document.getElementById("airTemp212");
                //环境温度
                airTemp212.innerHTML = result.airTemp + "℃";
                //SBR水温
                var waterTemp212 = document.getElementById("waterTemp212");
                //SBR水温
                waterTemp212.innerHTML = result.waterTemp + "℃";
                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRun212 = document.getElementById("collectMixerRun212");
                var collectMixerStop212 = document.getElementById("collectMixerStop212");
                //除磷投加机
                var dephosphorizeRun212 = document.getElementById("dephosphorizeRun212");
                var dephosphorizeStop212 = document.getElementById("dephosphorizeStop212");
                //集水池提升泵
                var collectPumpRun212 = document.getElementById("collectPumpRun212");
                var collectPumpStop212 = document.getElementById("collectPumpStop212");
                //污泥泵1
                var sludgePump01Run212 = document.getElementById("sludgePump01Run212");
                var sludgePump01Stop212 = document.getElementById("sludgePump01Stop212");
                if (result.collectMixerRun === false)  //集水池搅拌机
                {
                    collectMixerRun212.style.display = "none";
                    collectMixerStop212.style.display = "block";
                } else {
                    collectMixerRun212.style.display = "block";
                    collectMixerStop212.style.display = "none";
                }
                if (result.dephosphorizeRun === false)  //除磷投加机
                {
                    dephosphorizeRun212.style.display = "none";
                    dephosphorizeStop212.style.display = "block";
                } else {
                    dephosphorizeRun212.style.display = "block";
                    dephosphorizeStop212.style.display = "none";
                }
                if (result.collectPumpRun === false)  //集水池提升泵
                {
                    collectPumpRun212.style.display = "none";
                    collectPumpStop212.style.display = "block";
                } else {
                    collectPumpRun212.style.display = "block";
                    collectPumpStop212.style.display = "none";
                }
                if (result.sludgePump01Run === false)  //污泥泵1
                {
                    sludgePump01Run212.style.display = "none";
                    sludgePump01Stop212.style.display = "block";
                } else {
                    sludgePump01Run212.style.display = "block";
                    sludgePump01Stop212.style.display = "none";
                }
                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRunMinute212 = document.getElementById("collectMixerRunMinute212");
                //除磷投加机
                var dephosphorizeRunMinute212 = document.getElementById("dephosphorizeRunMinute212");
                //集水池提升泵
                var collectPumpRunMinute212 = document.getElementById("collectPumpRunMinute212");
                //污泥泵1
                var sludgePump01RunMinute212 = document.getElementById("sludgePump01RunMinute212");
                //集水池搅拌机
                collectMixerRunMinute212.innerText = result.collectMixerRunMinute;
                //除磷投加机
                dephosphorizeRunMinute212.innerText = result.dephosphorizeRunMinute;
                //集水池提升泵
                collectPumpRunMinute212.innerText = result.collectPumpRunMinute;
                //污泥泵1
                sludgePump01RunMinute212.innerText = result.sludgePump01RunMinute;
                /*************SBR污水处理控制系统***************/
                    //系统自动模式
                var systemAutoRun212 = document.getElementById("systemAutoRun212");
                var systemAutoStop212 = document.getElementById("systemAutoStop212");
                if (result.systemAuto === false) {
                    systemAutoRun212.style.display = "none";
                    systemAutoStop212.style.display = "block";
                } else {
                    systemAutoRun212.style.display = "block";
                    systemAutoStop212.style.display = "none";
                }
                //SBR周期运行
                var sbrCycleRun212 = document.getElementById("sbrCycleRun212");
                var sbrCycleStop212 = document.getElementById("sbrCycleStop212");
                if (result.sbrCycle === false) {
                    sbrCycleRun212.style.display = "none";
                    sbrCycleStop212.style.display = "block";
                } else {
                    sbrCycleRun212.style.display = "block";
                    sbrCycleStop212.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpRun212 = document.getElementById("sbrIntakePumpRun212");
                var sbrIntakePumpStop212 = document.getElementById("sbrIntakePumpStop212");
                //SBR池一次搅拌
                var sbrMixerOnceRun212 = document.getElementById("sbrMixerOnceRun212");
                var sbrMixerOnceStop212 = document.getElementById("sbrMixerOnceStop212");
                //SBR曝气
                var fanRun212 = document.getElementById("fanRun212");
                var fanStop212 = document.getElementById("fanStop212");
                //SBR二次搅拌
                var sbrMixerSecRun212 = document.getElementById("sbrMixerSecRun212");
                var sbrMixerSecStop212 = document.getElementById("sbrMixerSecStop212");
                //SBR静置
                var sbrStaticRun212 = document.getElementById("sbrStaticRun212");
                var sbrStaticStop212 = document.getElementById("sbrStaticStop212");
                //SBR污泥泵2
                var sludgePump02Run212 = document.getElementById("sludgePump02Run212");
                var sludgePump02Stop212 = document.getElementById("sludgePump02Stop212");
                //滗水器周期
                var decanterCycleRun212 = document.getElementById("decanterCycleRun212");
                var decanterCycleStop212 = document.getElementById("decanterCycleStop212");
                //SBR活化
                var sbrActiveRun212 = document.getElementById("sbrActiveRun212");
                var sbrActiveStop212 = document.getElementById("sbrActiveStop212");
                if (result.sbrIntakePumpRun === false)  //SBR池进水泵
                {
                    sbrIntakePumpRun212.style.display = "none";
                    sbrIntakePumpStop212.style.display = "block";
                } else {
                    sbrIntakePumpRun212.style.display = "block";
                    sbrIntakePumpStop212.style.display = "none";
                }
                if (result.sbrMixerOnceRun === false)  //SBR池一次搅拌
                {
                    sbrMixerOnceRun212.style.display = "none";
                    sbrMixerOnceStop212.style.display = "block";
                } else {
                    sbrMixerOnceRun212.style.display = "block";
                    sbrMixerOnceStop212.style.display = "none";
                }
                //SBR曝气
                if (result.fan01Run === false && result.fan02Run === false) {
                    fanRun212.style.display = "none";
                    fanStop212.style.display = "block";
                } else {
                    fanRun212.style.display = "block";
                    fanStop212.style.display = "none";
                }
                if (result.sbrMixerSecRun === false)  //SBR池二次搅拌
                {
                    sbrMixerSecRun212.style.display = "none";
                    sbrMixerSecStop212.style.display = "block";
                } else {
                    sbrMixerSecRun212.style.display = "block";
                    sbrMixerSecStop212.style.display = "none";
                }
                if (result.sbrStaticRun === false)  //SBR池静置
                {
                    sbrStaticRun212.style.display = "none";
                    sbrStaticStop212.style.display = "block";
                } else {
                    sbrStaticRun212.style.display = "block";
                    sbrStaticStop212.style.display = "none";
                }
                if (result.sludgePump02Run === false)  //SBR污泥泵2
                {
                    sludgePump02Run212.style.display = "none";
                    sludgePump02Stop212.style.display = "block";
                } else {
                    sludgePump02Run212.style.display = "block";
                    sludgePump02Stop212.style.display = "none";
                }
                if (result.decanterCycleRun === false)  //SBR池滗水器周期
                {
                    decanterCycleRun212.style.display = "none";
                    decanterCycleStop212.style.display = "block";
                } else {
                    decanterCycleRun212.style.display = "block";
                    decanterCycleStop212.style.display = "none";
                }
                if (result.sbrActiveRun === false)  //SBR池活化
                {
                    sbrActiveRun212.style.display = "none";
                    sbrActiveStop212.style.display = "block";
                } else {
                    sbrActiveRun212.style.display = "block";
                    sbrActiveStop212.style.display = "none";
                }
                /*************SBR污水处理控制系统***************/
                    //SBR池进水泵
                var sbrIntakePumpRunMinute212 = document.getElementById("sbrIntakePumpRunMinute212");
                //SBR一次搅拌
                var sbrMixerOnceRunMinute212 = document.getElementById("sbrMixerOnceRunMinute212");
                //SBR曝气
                var fanRunMinute212 = document.getElementById("fanRunMinute212");
                //SBR混合
                var sbrMixerRunMinute212 = document.getElementById("sbrMixerRunMinute212");
                //SBR静置
                var sbrStaticRunMinute212 = document.getElementById("sbrStaticRunMinute212");
                //SBR污泥泵2
                var sludgePump02RunMinute212 = document.getElementById("sludgePump02RunMinute212");
                //SBR活化
                var sbrActiveRunMinute212 = document.getElementById("sbrActiveRunMinute212");
                //SBR池进水泵
                sbrIntakePumpRunMinute212.innerText = result.sbrIntakePumpRunMinute;
                //SBR一次搅拌
                sbrMixerOnceRunMinute212.innerText = result.sbrMixerOnceRunMinute;
                //SBR曝气
                fanRunMinute212.innerText = result.fanRunMinute;
                //SBR混合
                sbrMixerRunMinute212.innerText = result.sbrMixerRunMinute;
                //SBR静置
                sbrStaticRunMinute212.innerText = result.sbrStaticRunMinute;
                //SBR污泥泵2
                sludgePump02RunMinute212.innerText = result.sludgePump02RunMinute;
                //SBR活化
                sbrActiveRunMinute212.innerText = result.sbrActiveRunMinute;
                //滗水器设备
                var decanterRun212 = document.getElementById("decanterRun212");
                var decanterStop212 = document.getElementById("decanterStop212");
                if (result.decanterRun === false)  //滗水器
                {
                    decanterRun212.style.display = "none";
                    decanterStop212.style.display = "block";
                } else {
                    decanterRun212.style.display = "block";
                    decanterStop212.style.display = "none";
                }
                /***************工艺流程设定时间*************************/
                    //除磷投加机
                var dephosphorizeSetMinute212 = document.getElementById("dephosphorizeSetMinute212");
                dephosphorizeSetMinute212.innerText = result.dephosphorizeSetMinute;
                //污泥泵1
                var sludgePump01SetMinute212 = document.getElementById("sludgePump01SetMinute212");
                sludgePump01SetMinute212.innerText = result.sludgePump01SetMinute;
                //SBR设定时间
                var sbrCycleSetMinute212 = document.getElementById("sbrCycleSetMinute212");
                sbrCycleSetMinute212.innerText = result.sbrCycleSetMinute;
                //SBR一次搅拌
                var sbrMixerOnceSetMinute212 = document.getElementById("sbrMixerOnceSetMinute212");
                sbrMixerOnceSetMinute212.innerText = result.sbrMixerOnceSetMinute;
                //SBR曝气
                var fanSetMinute212 = document.getElementById("fanSetMinute212");
                fanSetMinute212.innerText = result.fanSetMinute;
                //SBR混合
                var sbrMixerSetMinute212 = document.getElementById("sbrMixerSetMinute212");
                sbrMixerSetMinute212.innerText = result.sbrMixerSetMinute;
                //SBR静置
                var sbrStaticSetMinute212 = document.getElementById("sbrStaticSetMinute212");
                sbrStaticSetMinute212.innerText = result.sbrStaticSetMinute;
                //SBR污泥泵2
                var sludgePump02SetMinute212 = document.getElementById("sludgePump02SetMinute212");
                sludgePump02SetMinute212.innerText = result.sludgePump02SetMinute;
                //SBR活化
                var sbrActiveSetMinute212 = document.getElementById("sbrActiveSetMinute212");
                sbrActiveSetMinute212.innerText = result.sbrActiveSetMinute;
                /***************设备运行状态*************************/
                    //回转式风机1
                var fan01Run212 = document.getElementById("fan01Run212");
                var fan01Stop212 = document.getElementById("fan01Stop212");
                //回转式风机2
                var fan02Run212 = document.getElementById("fan02Run212");
                var fan02Stop212 = document.getElementById("fan02Stop212");
                //SBR池搅拌机01
                var sbrMixer01Run212 = document.getElementById("sbrMixer01Run212");
                var sbrMixer01Stop212 = document.getElementById("sbrMixer01Stop212");
                //SBR池搅拌机02
                var sbrMixer02Run212 = document.getElementById("sbrMixer02Run212");
                var sbrMixer02Stop212 = document.getElementById("sbrMixer02Stop212");
                if (result.fan01Run === false)  //回转式风机1
                {
                    fan01Run212.style.display = "none";
                    fan01Stop212.style.display = "block";
                } else {
                    fan01Run212.style.display = "block";
                    fan01Stop212.style.display = "none";
                }
                if (result.fan02Run === false)  //回转式风机2
                {
                    fan02Run212.style.display = "none";
                    fan02Stop212.style.display = "block";
                } else {
                    fan02Run212.style.display = "block";
                    fan02Stop212.style.display = "none";
                }
                if (result.sbrMixer01Run === false)  //SBR池搅拌机01
                {
                    sbrMixer01Run212.style.display = "none";
                    sbrMixer01Stop212.style.display = "block";
                } else {
                    sbrMixer01Run212.style.display = "block";
                    sbrMixer01Stop212.style.display = "none";
                }
                if (result.sbrMixer02Run === false)  //SBR池搅拌机02
                {
                    sbrMixer02Run212.style.display = "none";
                    sbrMixer02Stop212.style.display = "block";
                } else {
                    sbrMixer02Run212.style.display = "block";
                    sbrMixer02Stop212.style.display = "none";
                }
                /***************公共参数*************************/
                    //集水池液位高
                var collectHighOn212 = document.getElementById("collectHighOn212");
                var collectHighOff212 = document.getElementById("collectHighOff212");
                if (result.collectHighOn === false) {
                    collectHighOn212.style.display = "none";
                    collectHighOff212.style.display = "block";
                } else {
                    collectHighOn212.style.display = "block";
                    collectHighOff212.style.display = "none";
                }
                //集水池液位低
                var collectLowOn212 = document.getElementById("collectLowOn212");
                var collectLowOff212 = document.getElementById("collectLowOff212");
                if (result.collectLowOn === false) {
                    collectLowOn212.style.display = "none";
                    collectLowOff212.style.display = "block";
                } else {
                    collectLowOn212.style.display = "block";
                    collectLowOff212.style.display = "none";
                }
                //调节池液位高
                var regulatHighOn212 = document.getElementById("regulatHighOn212");
                var regulatHighOff212 = document.getElementById("regulatHighOff212");
                if (result.regulatHighOn === false) {
                    regulatHighOn212.style.display = "none";
                    regulatHighOff212.style.display = "block";
                } else {
                    regulatHighOn212.style.display = "block";
                    regulatHighOff212.style.display = "none";
                }
                //调节池液位低
                var regulatLowOn212 = document.getElementById("regulatLowOn212");
                var regulatLowOff212 = document.getElementById("regulatLowOff212");
                if (result.regulatLowOn === false) {
                    regulatLowOn212.style.display = "none";
                    regulatLowOff212.style.display = "block";
                } else {
                    regulatLowOn212.style.display = "block";
                    regulatLowOff212.style.display = "none";
                }
                //SBR池液位高
                var sbrHighOn212 = document.getElementById("sbrHighOn212");
                var sbrHighOff212 = document.getElementById("sbrHighOff212");
                if (result.sbrHighOn === false) {
                    sbrHighOn212.style.display = "none";
                    sbrHighOff212.style.display = "block";
                } else {
                    sbrHighOn212.style.display = "block";
                    sbrHighOff212.style.display = "none";
                }
                //SBR池液位低
                var sbrLowOn212 = document.getElementById("sbrLowOn212");
                var sbrLowOff212 = document.getElementById("sbrLowOff212");
                if (result.sbrLowOn === false) {
                    sbrLowOn212.style.display = "none";
                    sbrLowOff212.style.display = "block";
                } else {
                    sbrLowOn212.style.display = "block";
                    sbrLowOff212.style.display = "none";
                }
                /***************故障状态*************************/
                    //集水池搅拌机
                var collectMixerNormal212 = document.getElementById("collectMixerNormal212");
                var collectMixerFault212 = document.getElementById("collectMixerFault212");
                if (result.collectMixerFault === true) {
                    collectMixerNormal212.style.display = "none";
                    collectMixerFault212.style.display = "block";
                } else {
                    collectMixerNormal212.style.display = "block";
                    collectMixerFault212.style.display = "none";
                }
                //集水池提升泵
                var collectPumpNormal212 = document.getElementById("collectPumpNormal212");
                var collectPumpFault212 = document.getElementById("collectPumpFault212");
                if (result.collectPumpFault === true) {
                    collectPumpNormal212.style.display = "none";
                    collectPumpFault212.style.display = "block";
                } else {
                    collectPumpNormal212.style.display = "block";
                    collectPumpFault212.style.display = "none";
                }
                //污泥泵1
                var sludgePump01Normal212 = document.getElementById("sludgePump01Normal212");
                var sludgePump01Fault212 = document.getElementById("sludgePump01Fault212");
                if (result.sludgePump01Fault === true) {
                    sludgePump01Normal212.style.display = "none";
                    sludgePump01Fault212.style.display = "block";
                } else {
                    sludgePump01Normal212.style.display = "block";
                    sludgePump01Fault212.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpNormal212 = document.getElementById("sbrIntakePumpNormal212");
                var sbrIntakePumpFault212 = document.getElementById("sbrIntakePumpFault212");
                if (result.sbrIntakePumpFault === true) {
                    sbrIntakePumpNormal212.style.display = "none";
                    sbrIntakePumpFault212.style.display = "block";
                } else {
                    sbrIntakePumpNormal212.style.display = "block";
                    sbrIntakePumpFault212.style.display = "none";
                }
                //SBR池搅拌机01
                var sbrMixer01Normal212 = document.getElementById("sbrMixer01Normal212");
                var sbrMixer01Fault212 = document.getElementById("sbrMixer01Fault212");
                if (result.sbrMixer01Fault === true) {
                    sbrMixer01Normal212.style.display = "none";
                    sbrMixer01Fault212.style.display = "block";
                } else {
                    sbrMixer01Normal212.style.display = "block";
                    sbrMixer01Fault212.style.display = "none";
                }
                //SBR池搅拌机2
                var sbrMixer02Normal212 = document.getElementById("sbrMixer02Normal212");
                var sbrMixer02Fault212 = document.getElementById("sbrMixer02Fault212");
                if (result.sbrMixer02Fault === true) {
                    sbrMixer02Normal212.style.display = "none";
                    sbrMixer02Fault212.style.display = "block";
                } else {
                    sbrMixer02Normal212.style.display = "block";
                    sbrMixer02Fault212.style.display = "none";
                }
                //回转式风机1
                var fan01Normal212 = document.getElementById("fan01Normal212");
                var fan01Fault212 = document.getElementById("fan01Fault212");
                if (result.fan01Fault === true) {
                    fan01Normal212.style.display = "none";
                    fan01Fault212.style.display = "block";
                } else {
                    fan01Normal212.style.display = "block";
                    fan01Fault212.style.display = "none";
                }
                //回转式风机2
                var fan02Normal212 = document.getElementById("fan02Normal212");
                var fan02Fault212 = document.getElementById("fan02Fault212");
                if (result.fan02Fault === true) {
                    fan02Normal212.style.display = "none";
                    fan02Fault212.style.display = "block";
                } else {
                    fan02Normal212.style.display = "block";
                    fan02Fault212.style.display = "none";
                }
                //污泥泵2
                var sludgePump02Normal212 = document.getElementById("sludgePump02Normal212");
                var sludgePump02Fault212 = document.getElementById("sludgePump02Fault212");
                if (result.sludgePump02Fault === true) {
                    sludgePump02Normal212.style.display = "none";
                    sludgePump02Fault212.style.display = "block";
                } else {
                    sludgePump02Normal212.style.display = "block";
                    sludgePump02Fault212.style.display = "none";
                }
                //滗水器
                var decanterNormal212 = document.getElementById("decanterNormal212");
                var decanterFault212 = document.getElementById("decanterFault212");
                if (result.decanterFault === true) {
                    decanterNormal212.style.display = "none";
                    decanterFault212.style.display = "block";
                } else {
                    decanterNormal212.style.display = "block";
                    decanterFault212.style.display = "none";
                }
                //PLC电量
                var plcElecNormal212 = document.getElementById("plcElecNormal212");
                var plcElecLack212 = document.getElementById("plcElecLack212");
                if (result.plcElecLack === true) {
                    plcElecNormal212.style.display = "none";
                    plcElecLack212.style.display = "block";
                } else {
                    plcElecNormal212.style.display = "block";
                    plcElecLack212.style.display = "none";
                }
                //除磷投加机
                var dephosphorizeNormal212 = document.getElementById("dephosphorizeNormal212");
                var dephosphorizeFault212 = document.getElementById("dephosphorizeFault212");
                if (result.dephosphorizeFault === true) {
                    dephosphorizeNormal212.style.display = "none";
                    dephosphorizeFault212.style.display = "block";
                } else {
                    dephosphorizeNormal212.style.display = "block";
                    dephosphorizeFault212.style.display = "none";
                }
                //智能电表
                var elecNormal212 = document.getElementById("elecNormal212");
                var elecFault212 = document.getElementById("elecFault212");
                if (result.elecFault === true) {
                    elecNormal212.style.display = "none";
                    elecFault212.style.display = "block";
                } else {
                    elecNormal212.style.display = "block";
                    elecFault212.style.display = "none";
                }
                //环境温度
                var airTempNormal212 = document.getElementById("airTempNormal212");
                var airTempFault212 = document.getElementById("airTempFault212");
                if (result.airTempFault === true) {
                    airTempNormal212.style.display = "none";
                    airTempFault212.style.display = "block";
                } else {
                    airTempNormal212.style.display = "block";
                    airTempFault212.style.display = "none";
                }
                //SBR池水温
                var waterTempNormal212 = document.getElementById("waterTempNormal212");
                var waterTempFault212 = document.getElementById("waterTempFault212");
                if (result.waterTempFault === true) {
                    waterTempNormal212.style.display = "none";
                    waterTempFault212.style.display = "block";
                } else {
                    waterTempNormal212.style.display = "block";
                    waterTempFault212.style.display = "none";
                }
                /***************电能数据*************************/
                    //线电压Uab
                var uab212 = document.getElementById("uab212");
                //线电压Ubc
                var ubc212 = document.getElementById("ubc212");
                //线电压Uca
                var uca212 = document.getElementById("uca212");
                //相电压Ua
                var ua212 = document.getElementById("ua212");
                //相电压Ub
                var ub212 = document.getElementById("ub212");
                //相电压Uc
                var uc212 = document.getElementById("uc212");
                //电流Ia
                var ia212 = document.getElementById("ia212");
                //电流Ib
                var ib212 = document.getElementById("ib212");
                //电流Ic
                var ic212 = document.getElementById("ic212");
                //合相有功功率
                var pt212 = document.getElementById("pt212");
                //合相无功功率
                var qt212 = document.getElementById("qt212");
                //合相视在功率
                var st212 = document.getElementById("st212");
                //合相功率因数
                var pft212 = document.getElementById("pft212");
                //正向有功总电能
                var impEP212 = document.getElementById("impEP212");
                //反向有功总电能
                var expEP212 = document.getElementById("expEP212");
                //频率
                var freq212 = document.getElementById("freq212");
                //线电压Uab
                uab212.innerText = result.uab;
                //线电压Ubc
                ubc212.innerText = result.ubc;
                //线电压Uca
                uca212.innerText = result.uca;
                //相电压Ua
                ua212.innerText = result.ua;
                //相电压Ub
                ub212.innerText = result.ub;
                //相电压Uc
                uc212.innerText = result.uc;
                //电流Ia
                ia212.innerText = result.ia;
                //电流Ib
                ib212.innerText = result.ib;
                //电流Ic
                ic212.innerText = result.ic;
                //合相有功功率
                pt212.innerText = result.pt;
                //合相无功功率
                qt212.innerText = result.qt;
                //合相视在功率
                st212.innerText = result.st;
                //合相功率因数
                pft212.innerText = result.pft;
                //正向有功总电能
                impEP212.innerText = result.impEP;
                //反向有功总电能
                expEP212.innerText = result.expEP;
                //频率
                freq212.innerText = result.freq;
                /***************设备运行累计时长*************************/
                    //集水池搅拌机
                var collectMixerTotal212 = document.getElementById("collectMixerTotal212");
                //除磷投加机
                var dephosphorizeTotal212 = document.getElementById("dephosphorizeTotal212");
                //集水池提升泵
                var collectPumpTotal212 = document.getElementById("collectPumpTotal212");
                //污泥泵01
                var sludgePump01Total212 = document.getElementById("sludgePump01Total212");
                //SBR进水泵
                var sbrIntakePumpTotal212 = document.getElementById("sbrIntakePumpTotal212");
                //SBR池搅拌机01
                var sbrMixer01Total212 = document.getElementById("sbrMixer01Total212");
                //SBR池搅拌机02
                var sbrMixer02Total212 = document.getElementById("sbrMixer02Total212");
                //回转式风机01
                var fan01Total212 = document.getElementById("fan01Total212");
                //回转式风机02
                var fan02Total212 = document.getElementById("fan02Total212");
                //污泥泵02
                var sludgePump02Total212 = document.getElementById("sludgePump02Total212");
                //滗水器
                var decanterTotal212 = document.getElementById("decanterTotal212");
                //集水池搅拌机
                collectMixerTotal212.innerText = result.collectMixerTotal;
                //除磷投加机
                dephosphorizeTotal212.innerText = result.dephosphorizeTotal;
                //集水池提升泵
                collectPumpTotal212.innerText = result.collectPumpTotal;
                //污泥泵01
                sludgePump01Total212.innerText = result.sludgePump01Total;
                //SBR进水泵
                sbrIntakePumpTotal212.innerText = result.sbrIntakePumpTotal;
                //SBR池搅拌机01
                sbrMixer01Total212.innerText = result.sbrMixer01Total;
                //SBR池搅拌机02
                sbrMixer02Total212.innerText = result.sbrMixer02Total;
                //回转式风机01
                fan01Total212.innerText = result.fan01Total;
                //回转式风机02
                fan02Total212.innerText = result.fan02Total;
                //污泥泵02
                sludgePump02Total212.innerText = result.sludgePump02Total;
                //滗水器
                decanterTotal212.innerText = result.decanterTotal;
            } else {
                var type = 'error';
                var msg = '未查询到设备数据';
                var append = '对不起，未查询到该设备的实时数据';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (realid_of_setintervalDeviceOne !== undefined) {
                clearInterval(realid_of_setintervalDeviceOne);
            }
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}


function rdlSelectDeviceByTreeIdSewageC212() {

    $('#rdlSewageC212DeviceList').bootstrapTable('destroy');

    $('#rdlSewageC212DeviceList').bootstrapTable({
        //是否显示行间隔色
        striped: true,
        //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        cache: false,
        //是否显示分页（*）
        pagination: true,
        //是否启用排序
        sortable: false,
        //排序方式
        sortOrder: "asc",
        //每页的记录行数（*）
        pageSize: 8,
        //可供选择的每页的行数（*）
        pageList: [8, 10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectSewageC212ByORGId",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: rdlQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        columns: rdlSewageC212TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************SewageC212 end******************************/