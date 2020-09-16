
//************************SewageC214 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC214(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSewageC214ByDeviceId",
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
                var flowmeter214 = document.getElementById("flowmeter214");
                //时间
                var sewagec214sendDate = document.getElementById("sewagec214sendDate");
                //水流量
                flowmeter214.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec214sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter214 = document.getElementById("todayFlowmeter214");
                //当日水流量
                todayFlowmeter214.innerHTML = result.todayFlowmeter + "m³";
                //累计电量
                var totalEp214 = document.getElementById("totalEp214");
                //累计电量
                totalEp214.innerHTML = result.impEP + "";
                //当日电量
                var todayEp214 = document.getElementById("todayEp214");
                //当日电量
                todayEp214.innerHTML = result.todayEP + "";
                //环境温度
                var airTemp214 = document.getElementById("airTemp214");
                //环境温度
                airTemp214.innerHTML = result.airTemp + "℃";
                //SBR水温
                var waterTemp214 = document.getElementById("waterTemp214");
                //SBR水温
                waterTemp214.innerHTML = result.waterTemp + "℃";
                /*************污水处理前期工艺 运行状态***************/
                    //集水井提升泵
                var collectWellPumpRun214 = document.getElementById("collectWellPumpRun214");
                var collectWellPumpStop214 = document.getElementById("collectWellPumpStop214");
                if (result.collectWellPumpRun === false)  //集水井提升泵
                {
                    collectWellPumpRun214.style.display = "none";
                    collectWellPumpStop214.style.display = "block";
                } else {
                    collectWellPumpRun214.style.display = "block";
                    collectWellPumpStop214.style.display = "none";
                }
                //收集池搅拌机
                var collectMixerRun214 = document.getElementById("collectMixerRun214");
                var collectMixerStop214 = document.getElementById("collectMixerStop214");
                if (result.collectMixerRun === false)  //收集池搅拌机
                {
                    collectMixerRun214.style.display = "none";
                    collectMixerStop214.style.display = "block";
                } else {
                    collectMixerRun214.style.display = "block";
                    collectMixerStop214.style.display = "none";
                }
                //收集池提升泵
                var collectPumpRun214 = document.getElementById("collectPumpRun214");
                var collectPumpStop214 = document.getElementById("collectPumpStop214");
                if (result.collectPumpRun === false)  //收集池提升泵
                {
                    collectPumpRun214.style.display = "none";
                    collectPumpStop214.style.display = "block";
                } else {
                    collectPumpRun214.style.display = "block";
                    collectPumpStop214.style.display = "none";
                }
                /*************污水处理前期工艺 运行时间***************/
                    //集水井提升泵
                var collectWellPumpRunMinute214 = document.getElementById("collectWellPumpRunMinute214");
                //集水井提升泵
                collectWellPumpRunMinute214.innerText = result.collectWellPumpRunMinute;
                //收集池搅拌机
                var collectMixerRunMinute214 = document.getElementById("collectMixerRunMinute214");
                //收集池搅拌机
                collectMixerRunMinute214.innerText = result.collectMixerRunMinute;
                //收集池提升泵
                var collectPumpRunMinute214 = document.getElementById("collectPumpRunMinute214");
                //收集池提升泵
                collectPumpRunMinute214.innerText = result.collectPumpRunMinute;
                /*************SBR污水处理控制系统 运行状态***************/
                    //SBR搅拌机01
                var sbrMixer01Run214 = document.getElementById("sbrMixer01Run214");
                var sbrMixer01Stop214 = document.getElementById("sbrMixer01Stop214");
                if (result.sbrMixer01Run === false)  //SBR搅拌机01
                {
                    sbrMixer01Run214.style.display = "none";
                    sbrMixer01Stop214.style.display = "block";
                } else {
                    sbrMixer01Run214.style.display = "block";
                    sbrMixer01Stop214.style.display = "none";
                }
                //风机02
                var fan02Run214 = document.getElementById("fan02Run214");
                var fan02Stop214 = document.getElementById("fan02Stop214");
                if (result.fan02Run === false)  //风机02
                {
                    fan02Run214.style.display = "none";
                    fan02Stop214.style.display = "block";
                } else {
                    fan02Run214.style.display = "block";
                    fan02Stop214.style.display = "none";
                }
                //污泥泵
                var sludgePumpRun214 = document.getElementById("sludgePumpRun214");
                var sludgePumpStop214 = document.getElementById("sludgePumpStop214");
                if (result.sludgePumpRun === false)  //污泥泵
                {
                    sludgePumpRun214.style.display = "none";
                    sludgePumpStop214.style.display = "block";
                } else {
                    sludgePumpRun214.style.display = "block";
                    sludgePumpStop214.style.display = "none";
                }
                //滗水器
                var decanterRun214 = document.getElementById("decanterRun214");
                var decanterStop214 = document.getElementById("decanterStop214");
                if (result.decanterRun === true || result.decanterOff == true)  //滗水器
                {
                    decanterRun214.style.display = "block";
                    decanterStop214.style.display = "none";
                } else {
                    decanterRun214.style.display = "none";
                    decanterStop214.style.display = "block";
                }
                //风机01
                var fan01Run214 = document.getElementById("fan01Run214");
                var fan01Stop214 = document.getElementById("fan01Stop214");
                if (result.fan01Run === false)  //风机01
                {
                    fan01Run214.style.display = "none";
                    fan01Stop214.style.display = "block";
                } else {
                    fan01Run214.style.display = "block";
                    fan01Stop214.style.display = "none";
                }
                //SBR搅拌机02
                var sbrMixer02Run214 = document.getElementById("sbrMixer02Run214");
                var sbrMixer02Stop214 = document.getElementById("sbrMixer02Stop214");
                if (result.sbrMixer02Run === false)  //SBR搅拌机02
                {
                    sbrMixer02Run214.style.display = "none";
                    sbrMixer02Stop214.style.display = "block";
                } else {
                    sbrMixer02Run214.style.display = "block";
                    sbrMixer02Stop214.style.display = "none";
                }
                /*************SBR污水处理控制系统 运行时间***************/
                    //SBR搅拌机01
                var fanMixer01RunMinute214 = document.getElementById("fanMixer01RunMinute214");
                //SBR搅拌机01
                fanMixer01RunMinute214.innerText = result.sbrMixer01RunMinute;
                //风机02
                var fan02RunMinute214 = document.getElementById("fan02RunMinute214");
                //风机02
                fan02RunMinute214.innerText = result.fan02RunMinute;
                //污泥泵
                var sludgePumpRunMinute214 = document.getElementById("sludgePumpRunMinute214");
                //污泥泵
                sludgePumpRunMinute214.innerText = result.sludgePumpRunMinute;
                //滗水器
                var decanterRunMinute214 = document.getElementById("decanterRunMinute214");
                //滗水器
                decanterRunMinute214.innerText = result.decanterRunMinute;
                //风机01
                var fan01RunMinute214 = document.getElementById("fan01RunMinute214");
                //风机01
                fan01RunMinute214.innerText = result.fan01RunMinute;
                //SBR搅拌机02
                var fanMixer02RunMinute214 = document.getElementById("fanMixer02RunMinute214");
                //SBR搅拌机02
                fanMixer02RunMinute214.innerText = result.sbrMixer02RunMinute;
                /*************除磷控制系统 运行状态***************/
                    //1#加药泵
                var dosingPumpRun214 = document.getElementById("dosingPumpRun214");
                var dosingPumpStop214 = document.getElementById("dosingPumpStop214");
                if (result.dosingPumpRun === false)  //SBR搅拌机01
                {
                    dosingPumpRun214.style.display = "none";
                    dosingPumpStop214.style.display = "block";
                } else {
                    dosingPumpRun214.style.display = "block";
                    dosingPumpStop214.style.display = "none";
                }
                //除磷池提升泵
                var dephosphorizePumpRun214 = document.getElementById("dephosphorizePumpRun214");
                var dephosphorizePumpStop214 = document.getElementById("dephosphorizePumpStop214");
                if (result.dephosphorizePumpRun === false)  //除磷池提升泵
                {
                    dephosphorizePumpRun214.style.display = "none";
                    dephosphorizePumpStop214.style.display = "block";
                } else {
                    dephosphorizePumpRun214.style.display = "block";
                    dephosphorizePumpStop214.style.display = "none";
                }
                //加药罐搅拌机
                var dosingMixerRun214 = document.getElementById("dosingMixerRun214");
                var dosingMixerStop214 = document.getElementById("dosingMixerStop214");
                if (result.dosingMixerRun === false)  //加药罐搅拌机
                {
                    dosingMixerRun214.style.display = "none";
                    dosingMixerStop214.style.display = "block";
                } else {
                    dosingMixerRun214.style.display = "block";
                    dosingMixerStop214.style.display = "none";
                }
                /*************除磷控制系统 运行时间***************/
                    //加药泵
                var dosingPumpRunMinute214 = document.getElementById("dosingPumpRunMinute214");
                //加药泵
                dosingPumpRunMinute214.innerText = result.dosingPumpRunMinute;
                //除磷池提升泵
                var dephosphorizePumpRunMinute214 = document.getElementById("dephosphorizePumpRunMinute214");
                //除磷池提升泵
                dephosphorizePumpRunMinute214.innerText = result.dephosphorizePumpRunMinute;
                //加药罐搅拌机
                var dosingMixerRunMinute214 = document.getElementById("dosingMixerRunMinute214");
                //加药罐搅拌机
                dosingMixerRunMinute214.innerText = result.dosingMixerRunMinute;
                /***************工艺流程设定时间 开始时间*************************/
                    //集水井提升泵
                var collectWellPumpSTime214 = document.getElementById("collectWellPumpSTime214");
                collectWellPumpSTime214.innerText = formatTime214(result.collectWellPumpSHour) + ":" + formatTime214(result.collectWellPumpSMinute);
                //风机02
                var fan02STime214 = document.getElementById("fan02STime214");
                fan02STime214.innerText = formatTime214(result.fan02SHour) + ":" + formatTime214(result.fan02SMinute);
                //收集池提升泵
                var collectPumpSTime214 = document.getElementById("collectPumpSTime214");
                collectPumpSTime214.innerText = formatTime214(result.collectPumpSHour) + ":" + formatTime214(result.collectPumpSMinute);
                //静止沉淀
                var staticSTime214 = document.getElementById("staticSTime214");
                staticSTime214.innerText = "05:40";
                //收集池搅拌机
                var collectMixerSTime214 = document.getElementById("collectMixerSTime214");
                collectMixerSTime214.innerText = formatTime214(result.collectMixerSHour) + ":" + formatTime214(result.collectMixerSMinute);
                //滗水器
                var decanterSTime214 = document.getElementById("decanterSTime214");
                decanterSTime214.innerText = formatTime214(result.decanterSHour) + ":" + formatTime214(result.decanterSMinute);
                //SBR搅拌机01
                var fanMixer01STime214 = document.getElementById("fanMixer01STime214");
                fanMixer01STime214.innerText = formatTime214(result.sbrMixer01SHour) + ":" + formatTime214(result.sbrMixer01SMinute);
                //加药泵
                var dosingPumpSTime214 = document.getElementById("dosingPumpSTime214");
                dosingPumpSTime214.innerText = formatTime214(result.dosingPumpSHour) + ":" + formatTime214(result.dosingPumpSMinute);
                //污泥泵
                var sludgePumpSTime214 = document.getElementById("sludgePumpSTime214");
                sludgePumpSTime214.innerText = formatTime214(result.sludgePumpSHour) + ":" + formatTime214(result.sludgePumpSMinute);
                //加药罐搅拌机
                var dosingMixerSTime214 = document.getElementById("dosingMixerSTime214");
                dosingMixerSTime214.innerText = formatTime214(result.dosingMixerSHour) + ":" + formatTime214(result.dosingMixerSMinute);
                //风机01
                var fanSTime214 = document.getElementById("fanSTime214");
                fanSTime214.innerText = formatTime214(result.fan01SHour) + ":" + formatTime214(result.fan01SMinute);
                //除磷池提升泵
                var dephosphorizePumpSTime214 = document.getElementById("dephosphorizePumpSTime214");
                dephosphorizePumpSTime214.innerText = formatTime214(result.dephosphorizePumpSHour) + ":" + formatTime214(result.dephosphorizePumpSMinute);
                //SBR搅拌机02
                var fanMixer02STime214 = document.getElementById("fanMixer02STime214");
                fanMixer02STime214.innerText = formatTime214(result.sbrMixer02SHour) + ":" + formatTime214(result.sbrMixer02SMinute);
                /***************工艺流程设定时间 时间段*************************/
                    //集水井提升泵
                var collectWellPumpSetMinute214 = document.getElementById("collectWellPumpSetMinute214");
                collectWellPumpSetMinute214.innerText = result.collectWellPumpSetMinute;
                //风机02
                var fan02SetMinute214 = document.getElementById("fan02SetMinute214");
                fan02SetMinute214.innerText = result.fanSetMinute;
                //收集池提升泵
                var collectPumpSetMinute214 = document.getElementById("collectPumpSetMinute214");
                collectPumpSetMinute214.innerText = result.collectPumpSetMinute;
                //静止沉淀
                var staticSetMinute214 = document.getElementById("staticSetMinute214");
                staticSetMinute214.innerText = "123";
                //收集池搅拌机
                var collectMixerSetMinute214 = document.getElementById("collectMixerSetMinute214");
                collectMixerSetMinute214.innerText = result.collectMixerSetMinute;
                //滗水器
                var decanterSetMinute214 = document.getElementById("decanterSetMinute214");
                decanterSetMinute214.innerText = result.decanterSetMinute;
                //SBR搅拌机01
                var fanMixer01SetMinute214 = document.getElementById("fanMixer01SetMinute214");
                fanMixer01SetMinute214.innerText = result.sbrMixer01SetMinute;
                //加药泵
                var dosingPumpSetMinute214 = document.getElementById("dosingPumpSetMinute214");
                dosingPumpSetMinute214.innerText = result.dosingPumpSetMinute;
                //污泥泵
                var sludgePumpSetMinute214 = document.getElementById("sludgePumpSetMinute214");
                sludgePumpSetMinute214.innerText = result.sludgePumpSetMinute;
                //加药罐搅拌机
                var dosingMixerSetMinute214 = document.getElementById("dosingMixerSetMinute214");
                dosingMixerSetMinute214.innerText = result.dosingMixerSetMinute;
                //风机01
                var fan01SetMinute214 = document.getElementById("fan01SetMinute214");
                fan01SetMinute214.innerText = result.fanSetMinute;
                //除磷池提升泵
                var dephosphorizePumpSetMinute214 = document.getElementById("dephosphorizePumpSetMinute214");
                dephosphorizePumpSetMinute214.innerText = result.dephosphorizePumpSetMinute;
                //SBR搅拌机02
                var fanMixer02SetMinute214 = document.getElementById("fanMixer02SetMinute214");
                fanMixer02SetMinute214.innerText = result.sbrMixer02SetMinute;
                /***************公共参数*************************/
                    //收集池高液位
                var collectHighOn214 = document.getElementById("collectHighOn214");
                var collectHighOff214 = document.getElementById("collectHighOff214");
                if (result.collectHighOn === false) {
                    collectHighOn214.style.display = "none";
                    collectHighOff214.style.display = "block";
                } else {
                    collectHighOn214.style.display = "block";
                    collectHighOff214.style.display = "none";
                }
                //SBR池高液位
                var sbrHighOn214 = document.getElementById("sbrHighOn214");
                var sbrHighOff214 = document.getElementById("sbrHighOff214");
                if (result.sbrHighOn === false) {
                    sbrHighOn214.style.display = "none";
                    sbrHighOff214.style.display = "block";
                } else {
                    sbrHighOn214.style.display = "block";
                    sbrHighOff214.style.display = "none";
                }
                //收集池低液位
                var collectLowOn214 = document.getElementById("collectLowOn214");
                var collectLowOff214 = document.getElementById("collectLowOff214");
                if (result.collectLowOn === false) {
                    collectLowOn214.style.display = "none";
                    collectLowOff214.style.display = "block";
                } else {
                    collectLowOn214.style.display = "block";
                    collectLowOff214.style.display = "none";
                }
                //SBR池低液位
                var sbrLowOn214 = document.getElementById("sbrLowOn214");
                var sbrLowOff214 = document.getElementById("sbrLowOff214");
                if (result.sbrLowOn === false) {
                    sbrLowOn214.style.display = "none";
                    sbrLowOff214.style.display = "block";
                } else {
                    sbrLowOn214.style.display = "block";
                    sbrLowOff214.style.display = "none";
                }
                //除磷池高液位
                var dephosphorizeHighOn214 = document.getElementById("dephosphorizeHighOn214");
                var dephosphorizeHighOff214 = document.getElementById("dephosphorizeHighOff214");
                if (result.dephosphorizeHighOn === false) {
                    dephosphorizeHighOn214.style.display = "none";
                    dephosphorizeHighOff214.style.display = "block";
                } else {
                    dephosphorizeHighOn214.style.display = "block";
                    dephosphorizeHighOff214.style.display = "none";
                }
                //滗水器开到位
                var decanterOnOK214 = document.getElementById("decanterOnOK214");
                var decanterOnOff214 = document.getElementById("decanterOnOff214");
                if (result.decanterOnOK === false) {
                    decanterOnOK214.style.display = "none";
                    decanterOnOff214.style.display = "block";
                } else {
                    decanterOnOK214.style.display = "block";
                    decanterOnOff214.style.display = "none";
                }
                //除磷池低液位
                var dephosphorizeLowOn214 = document.getElementById("dephosphorizeLowOn214");
                var dephosphorizeLowOff214 = document.getElementById("dephosphorizeLowOff214");
                if (result.dephosphorizeLowOn === false) {
                    dephosphorizeLowOn214.style.display = "none";
                    dephosphorizeLowOff214.style.display = "block";
                } else {
                    dephosphorizeLowOn214.style.display = "block";
                    dephosphorizeLowOff214.style.display = "none";
                }
                //滗水器关到位
                var decanterOffOK214 = document.getElementById("decanterOffOK214");
                var decanterOffOff214 = document.getElementById("decanterOffOff214");
                if (result.decanterOffOK === false) {
                    decanterOffOK214.style.display = "none";
                    decanterOffOff214.style.display = "block";
                } else {
                    decanterOffOK214.style.display = "block";
                    decanterOffOff214.style.display = "none";
                }
                /***************故障状态*************************/
                    //集水井提升泵
                var collectWellPumpNormal214 = document.getElementById("collectWellPumpNormal214");
                var collectWellPumpFault214 = document.getElementById("collectWellPumpFault214");
                if (result.collectWellPumpFault === true) {
                    collectWellPumpNormal214.style.display = "none";
                    collectWellPumpFault214.style.display = "block";
                } else {
                    collectWellPumpNormal214.style.display = "block";
                    collectWellPumpFault214.style.display = "none";
                }
                //滗水器
                var decanterNormal214 = document.getElementById("decanterNormal214");
                var decanterFault214 = document.getElementById("decanterFault214");
                if (result.decanterFault === true) {
                    decanterNormal214.style.display = "none";
                    decanterFault214.style.display = "block";
                } else {
                    decanterNormal214.style.display = "block";
                    decanterFault214.style.display = "none";
                }
                //收集池提升泵
                var collectPumpNormal214 = document.getElementById("collectPumpNormal214");
                var collectPumpFault214 = document.getElementById("collectPumpFault214");
                if (result.collectPumpFault === true) {
                    collectPumpNormal214.style.display = "none";
                    collectPumpFault214.style.display = "block";
                } else {
                    collectPumpNormal214.style.display = "block";
                    collectPumpFault214.style.display = "none";
                }
                //加药泵
                var dosingPumpNormal214 = document.getElementById("dosingPumpNormal214");
                var dosingPumpFault214 = document.getElementById("dosingPumpFault214");
                if (result.dosingPumpFault === true) {
                    dosingPumpNormal214.style.display = "none";
                    dosingPumpFault214.style.display = "block";
                } else {
                    dosingPumpNormal214.style.display = "block";
                    dosingPumpFault214.style.display = "none";
                }
                //收集池搅拌机
                var collectMixerNormal214 = document.getElementById("collectMixerNormal214");
                var collectMixerFault214 = document.getElementById("collectMixerFault214");
                if (result.collectMixerFault === true) {
                    collectMixerNormal214.style.display = "none";
                    collectMixerFault214.style.display = "block";
                } else {
                    collectMixerNormal214.style.display = "block";
                    collectMixerFault214.style.display = "none";
                }
                //加药罐搅拌机
                var dosingMixerNormal214 = document.getElementById("dosingMixerNormal214");
                var dosingMixerFault214 = document.getElementById("dosingMixerFault214");
                if (result.dosingMixerFault === true) {
                    dosingMixerNormal214.style.display = "none";
                    dosingMixerFault214.style.display = "block";
                } else {
                    dosingMixerNormal214.style.display = "block";
                    dosingMixerFault214.style.display = "none";
                }
                //SBR搅拌机01
                var sbrMixer01Normal214 = document.getElementById("sbrMixer01Normal214");
                var sbrMixer01Fault214 = document.getElementById("sbrMixer01Fault214");
                if (result.sbrMixer01Fault === true) {
                    sbrMixer01Normal214.style.display = "none";
                    sbrMixer01Fault214.style.display = "block";
                } else {
                    sbrMixer01Normal214.style.display = "block";
                    sbrMixer01Fault214.style.display = "none";
                }
                //除磷池提升泵
                var dephosphorizePumpNormal214 = document.getElementById("dephosphorizePumpNormal214");
                var dephosphorizePumpFault214 = document.getElementById("dephosphorizePumpFault214");
                if (result.dephosphorizePumpFault === true) {
                    dephosphorizePumpNormal214.style.display = "none";
                    dephosphorizePumpFault214.style.display = "block";
                } else {
                    dephosphorizePumpNormal214.style.display = "block";
                    dephosphorizePumpFault214.style.display = "none";
                }
                //污泥泵
                var sludgePumpNormal214 = document.getElementById("sludgePumpNormal214");
                var sludgePumpFault214 = document.getElementById("sludgePumpFault214");
                if (result.sludgePumpFault === true) {
                    sludgePumpNormal214.style.display = "none";
                    sludgePumpFault214.style.display = "block";
                } else {
                    sludgePumpNormal214.style.display = "block";
                    sludgePumpFault214.style.display = "none";
                }
                //PLC电量不足
                var plcElecNormal214 = document.getElementById("plcElecNormal214");
                var plcElecLack214 = document.getElementById("plcElecLack214");
                if (result.plcElecLack === true) {
                    plcElecNormal214.style.display = "none";
                    plcElecLack214.style.display = "block";
                } else {
                    plcElecNormal214.style.display = "block";
                    plcElecLack214.style.display = "none";
                }
                //风机01
                var fan01Normal214 = document.getElementById("fan01Normal214");
                var fan01Fault214 = document.getElementById("fan01Fault214");
                if (result.fan01Fault === true) {
                    fan01Normal214.style.display = "none";
                    fan01Fault214.style.display = "block";
                } else {
                    fan01Normal214.style.display = "block";
                    fan01Fault214.style.display = "none";
                }
                //智能电表设备通讯
                var elecNormal214 = document.getElementById("elecNormal214");
                var elecFault214 = document.getElementById("elecFault214");
                if (result.elecFault === true) {
                    elecNormal214.style.display = "none";
                    elecFault214.style.display = "block";
                } else {
                    elecNormal214.style.display = "block";
                    elecFault214.style.display = "none";
                }
                //SBR搅拌机02
                var sbrMixer02Normal214 = document.getElementById("sbrMixer02Normal214");
                var sbrMixer02Fault214 = document.getElementById("sbrMixer02Fault214");
                if (result.sbrMixer02Fault === true) {
                    sbrMixer02Normal214.style.display = "none";
                    sbrMixer02Fault214.style.display = "block";
                } else {
                    sbrMixer02Normal214.style.display = "block";
                    sbrMixer02Fault214.style.display = "none";
                }
                //空气温度变送器
                var airTempNormal214 = document.getElementById("airTempNormal214");
                var airTempFault214 = document.getElementById("airTempFault214");
                if (result.airTempFault === true) {
                    airTempNormal214.style.display = "none";
                    airTempFault214.style.display = "block";
                } else {
                    airTempNormal214.style.display = "block";
                    airTempFault214.style.display = "none";
                }
                //风机02
                var fan02Normal214 = document.getElementById("fan02Normal214");
                var fan02Fault214 = document.getElementById("fan02Fault214");
                if (result.fan02Fault === true) {
                    fan02Normal214.style.display = "none";
                    fan02Fault214.style.display = "block";
                } else {
                    fan02Normal214.style.display = "block";
                    fan02Fault214.style.display = "none";
                }
                //SBR水温变送器
                var waterTempNormal214 = document.getElementById("waterTempNormal214");
                var waterTempFault214 = document.getElementById("waterTempFault214");
                if (result.waterTempFault === true) {
                    waterTempNormal214.style.display = "none";
                    waterTempFault214.style.display = "block";
                } else {
                    waterTempNormal214.style.display = "block";
                    waterTempFault214.style.display = "none";
                }
                /***************电能数据*************************/
                    //线电压Uab
                var uab214 = document.getElementById("uab214");
                //线电压Ubc
                var ubc214 = document.getElementById("ubc214");
                //线电压Uca
                var uca214 = document.getElementById("uca214");
                //相电压Ua
                var ua214 = document.getElementById("ua214");
                //相电压Ub
                var ub214 = document.getElementById("ub214");
                //相电压Uc
                var uc214 = document.getElementById("uc214");
                //电流Ia
                var ia214 = document.getElementById("ia214");
                //电流Ib
                var ib214 = document.getElementById("ib214");
                //电流Ic
                var ic214 = document.getElementById("ic214");
                //合相有功功率
                var pt214 = document.getElementById("pt214");
                //合相无功功率
                var qt214 = document.getElementById("qt214");
                //合相视在功率
                var st214 = document.getElementById("st214");
                //合相功率因数
                var pft214 = document.getElementById("pft214");
                //正向有功总电能
                var impEP214 = document.getElementById("impEP214");
                //反向有功总电能
                var expEP214 = document.getElementById("expEP214");
                //频率
                var freq214 = document.getElementById("freq214");
                //线电压Uab
                uab214.innerText = result.uab;
                //线电压Ubc
                ubc214.innerText = result.ubc;
                //线电压Uca
                uca214.innerText = result.uca;
                //相电压Ua
                ua214.innerText = result.ua;
                //相电压Ub
                ub214.innerText = result.ub;
                //相电压Uc
                uc214.innerText = result.uc;
                //电流Ia
                ia214.innerText = result.ia;
                //电流Ib
                ib214.innerText = result.ib;
                //电流Ic
                ic214.innerText = result.ic;
                //合相有功功率
                pt214.innerText = result.pt;
                //合相无功功率
                qt214.innerText = result.qt;
                //合相视在功率
                st214.innerText = result.st;
                //合相功率因数
                pft214.innerText = result.pft;
                //正向有功总电能
                impEP214.innerText = result.impEP;
                //反向有功总电能
                expEP214.innerText = result.expEP;
                //频率
                freq214.innerText = result.freq;
                /***************设备运行累计时长*************************/
                    //集水井提升泵
                var collectWellPumpTotal214 = document.getElementById("collectWellPumpTotal214");
                //集水井提升泵
                collectWellPumpTotal214.innerText = result.collectWellPumpTotal;
                //SBR搅拌机02
                var sbrMixer02Total214 = document.getElementById("sbrMixer02Total214");
                //SBR搅拌机02
                sbrMixer02Total214.innerText = result.sbrMixer02Total;
                //收集池提升泵
                var collectPumpTotal214 = document.getElementById("collectPumpTotal214");
                //收集池提升泵
                collectPumpTotal214.innerText = result.collectPumpTotal;
                //风机02
                var fan02Total214 = document.getElementById("fan02Total214");
                //风机02
                fan02Total214.innerText = result.fan02Total;
                //收集池搅拌机
                var collectMixerTotal214 = document.getElementById("collectMixerTotal214");
                //收集池搅拌机
                collectMixerTotal214.innerText = result.collectMixerTotal;
                //滗水器
                var decanterTotal214 = document.getElementById("decanterTotal214");
                //滗水器
                decanterTotal214.innerText = result.decanterTotal;
                //SBR搅拌机01
                var sbrMixer01Total214 = document.getElementById("sbrMixer01Total214");
                //SBR搅拌机01
                sbrMixer01Total214.innerText = result.sbrMixer01Total;
                //加药泵
                var dosingPumpTotal214 = document.getElementById("dosingPumpTotal214");
                //加药泵
                dosingPumpTotal214.innerText = result.dosingPumpTotal;
                //污泥泵
                var sludgePumpTotal214 = document.getElementById("sludgePumpTotal214");
                //污泥泵
                sludgePumpTotal214.innerText = result.sludgePumpTotal;
                //加药罐搅拌机
                var dosingMixerTotal214 = document.getElementById("dosingMixerTotal214");
                //加药罐搅拌机
                dosingMixerTotal214.innerText = result.dosingMixerTotal;
                //风机01
                var fan01Total214 = document.getElementById("fan01Total214");
                //风机01
                fan01Total214.innerText = result.fan01Total;
                //除磷池提升泵
                var dephosphorizePumpTotal214 = document.getElementById("dephosphorizePumpTotal214");
                //除磷池提升泵
                dephosphorizePumpTotal214.innerText = result.dephosphorizePumpTotal;
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



function rdlSelectDeviceByTreeIdSewageC214() {

    $('#rdlSewageC214DeviceList').bootstrapTable('destroy');

    $('#rdlSewageC214DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectSewageC214ByORGId",
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
        columns: rdlSewageC214TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

function formatTime214(value) {
    if (value.toString().length === 1)
        return "0" + value.toString();
    return value.toString();
}


//************************SewageC214 end******************************/
