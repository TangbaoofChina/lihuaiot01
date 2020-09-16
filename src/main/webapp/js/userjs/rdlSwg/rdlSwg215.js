//************************SewageC215 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC215(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSwgC215ByDeviceId",
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
                var flowmeter215 = document.getElementById("flowmeter215");
                //时间
                var sewagec215sendDate = document.getElementById("sewagec215sendDate");
                //水流量
                flowmeter215.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec215sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter215 = document.getElementById("todayFlowmeter215");
                //当日水流量
                todayFlowmeter215.innerHTML = result.todayFlowmeter + "m³";
                //内回流量
                var inFlowmeter215 = document.getElementById("inFlowmeter215");
                //内回流量
                inFlowmeter215.innerHTML = result.inFlowmeter + "m³";
                //外回流量
                var outFlowmeter215 = document.getElementById("outFlowmeter215");
                //外回流量
                outFlowmeter215.innerHTML = result.outFlowmeter + "m³";
                //累计电量
                var totalEp215 = document.getElementById("totalEp215");
                //累计电量
                totalEp215.innerHTML = result.impEP + "";
                //当日电量
                var todayEp215 = document.getElementById("todayEp215");
                //当日电量
                todayEp215.innerHTML = result.todayEP + "";
                //环境温度
                var airTemp01215 = document.getElementById("airTemp01215");
                //环境温度
                airTemp01215.innerHTML = result.airTemp01 + "℃";
                //SBR水温
                var waterTemp01215 = document.getElementById("waterTemp01215");
                //SBR水温
                waterTemp01215.innerHTML = result.waterTemp01 + "℃";
                //环境温度
                var airTemp02215 = document.getElementById("airTemp02215");
                //环境温度
                airTemp02215.innerHTML = result.airTemp02 + "℃";
                //SBR水温
                var waterTemp02215 = document.getElementById("waterTemp02215");
                //SBR水温
                waterTemp02215.innerHTML = result.waterTemp02 + "℃";
                /*************设备 运行状态***************/
                    //机械格栅
                var ydsgsRun215 = document.getElementById("ydsgsRun215");
                var ydsgsStop215 = document.getElementById("ydsgsStop215");
                if (result.ydsgsRun === false)  //集水井提升泵
                {
                    ydsgsRun215.style.display = "none";
                    ydsgsStop215.style.display = "block";
                } else {
                    ydsgsRun215.style.display = "block";
                    ydsgsStop215.style.display = "none";
                }
                //集水井提升泵
                var collectWellPumpRun215 = document.getElementById("collectWellPumpRun215");
                var collectWellPumpStop215 = document.getElementById("collectWellPumpStop215");
                if (result.collectWellPumpRun === false)  //集水井提升泵
                {
                    collectWellPumpRun215.style.display = "none";
                    collectWellPumpStop215.style.display = "block";
                } else {
                    collectWellPumpRun215.style.display = "block";
                    collectWellPumpStop215.style.display = "none";
                }
                //集水池搅拌机1
                var collectMixer01Run215 = document.getElementById("collectMixer01Run215");
                var collectMixer01Stop215 = document.getElementById("collectMixer01Stop215");
                if (result.collectMixer01Run === false)  //集水井提升泵
                {
                    collectMixer01Run215.style.display = "none";
                    collectMixer01Stop215.style.display = "block";
                } else {
                    collectMixer01Run215.style.display = "block";
                    collectMixer01Stop215.style.display = "none";
                }
                //集水池搅拌机2
                var collectMixer02Run215 = document.getElementById("collectMixer02Run215");
                var collectMixer02Stop215 = document.getElementById("collectMixer02Stop215");
                if (result.collectMixer02Run === false)  //集水井提升泵
                {
                    collectMixer02Run215.style.display = "none";
                    collectMixer02Stop215.style.display = "block";
                } else {
                    collectMixer02Run215.style.display = "block";
                    collectMixer02Stop215.style.display = "none";
                }
                //除磷投加机
                var dephosphorizeRun215 = document.getElementById("dephosphorizeRun215");
                var dephosphorizeStop215 = document.getElementById("dephosphorizeStop215");
                if (result.dephosphorizeRun === false)  //集水井提升泵
                {
                    dephosphorizeRun215.style.display = "none";
                    dephosphorizeStop215.style.display = "block";
                } else {
                    dephosphorizeRun215.style.display = "block";
                    dephosphorizeStop215.style.display = "none";
                }
                //集水池提升泵
                var collectPumpRun215 = document.getElementById("collectPumpRun215");
                var collectPumpStop215 = document.getElementById("collectPumpStop215");
                if (result.collectPumpRun === false)  //集水井提升泵
                {
                    collectPumpRun215.style.display = "none";
                    collectPumpStop215.style.display = "block";
                } else {
                    collectPumpRun215.style.display = "block";
                    collectPumpStop215.style.display = "none";
                }
                //固液分离机
                var solLiqRun215 = document.getElementById("solLiqRun215");
                var solLiqStop215 = document.getElementById("solLiqStop215");
                if (result.solLiqRun === false)  //集水井提升泵
                {
                    solLiqRun215.style.display = "none";
                    solLiqStop215.style.display = "block";
                } else {
                    solLiqRun215.style.display = "block";
                    solLiqStop215.style.display = "none";
                }
                //混合池1搅拌机
                var bldMixer01Run215 = document.getElementById("bldMixer01Run215");
                var bldMixer01Stop215 = document.getElementById("bldMixer01Stop215");
                if (result.bldMixer01Run === false)  //集水井提升泵
                {
                    bldMixer01Run215.style.display = "none";
                    bldMixer01Stop215.style.display = "block";
                } else {
                    bldMixer01Run215.style.display = "block";
                    bldMixer01Stop215.style.display = "none";
                }
                //混反池1搅拌机
                var bldOpstMixer01Run215 = document.getElementById("bldOpstMixer01Run215");
                var bldOpstMixer01Stop215 = document.getElementById("bldOpstMixer01Stop215");
                if (result.bldOpstMixer01Run === false)  //集水井提升泵
                {
                    bldOpstMixer01Run215.style.display = "none";
                    bldOpstMixer01Stop215.style.display = "block";
                } else {
                    bldOpstMixer01Run215.style.display = "block";
                    bldOpstMixer01Stop215.style.display = "none";
                }
                //混沉池污泥泵
                var bldSinkPumpRun215 = document.getElementById("bldSinkPumpRun215");
                var bldSinkPumpStop215 = document.getElementById("bldSinkPumpStop215");
                if (result.bldSinkPumpRun === false)  //集水井提升泵
                {
                    bldSinkPumpRun215.style.display = "none";
                    bldSinkPumpStop215.style.display = "block";
                } else {
                    bldSinkPumpRun215.style.display = "block";
                    bldSinkPumpStop215.style.display = "none";
                }
                //混凝剂1搅拌机
                var bldCglMixer01Run215 = document.getElementById("bldCglMixer01Run215");
                var bldCglMixer01Stop215 = document.getElementById("bldCglMixer01Stop215");
                if (result.bldCglMixer01Run === false)  //集水井提升泵
                {
                    bldCglMixer01Run215.style.display = "none";
                    bldCglMixer01Stop215.style.display = "block";
                } else {
                    bldCglMixer01Run215.style.display = "block";
                    bldCglMixer01Stop215.style.display = "none";
                }

                //混凝剂1加药泵
                var bldCglDosing01Run215 = document.getElementById("bldCglDosing01Run215");
                var bldCglDosing01Stop215 = document.getElementById("bldCglDosing01Stop215");
                if (result.bldCglDosing01Run === false)  //集水井提升泵
                {
                    bldCglDosing01Run215.style.display = "none";
                    bldCglDosing01Stop215.style.display = "block";
                } else {
                    bldCglDosing01Run215.style.display = "block";
                    bldCglDosing01Stop215.style.display = "none";
                }
                //助凝剂1搅拌机
                var astCglMixer01Run215 = document.getElementById("astCglMixer01Run215");
                var astCglMixer01Stop215 = document.getElementById("astCglMixer01Stop215");
                if (result.astCglMixer01Run === false)  //集水井提升泵
                {
                    astCglMixer01Run215.style.display = "none";
                    astCglMixer01Stop215.style.display = "block";
                } else {
                    astCglMixer01Run215.style.display = "block";
                    astCglMixer01Stop215.style.display = "none";
                }
                //助凝剂1加药泵
                var astCglDosing01Run215 = document.getElementById("astCglDosing01Run215");
                var astCglDosing01Stop215 = document.getElementById("astCglDosing01Stop215");
                if (result.astCglDosing01Run === false)  //集水井提升泵
                {
                    astCglDosing01Run215.style.display = "none";
                    astCglDosing01Stop215.style.display = "block";
                } else {
                    astCglDosing01Run215.style.display = "block";
                    astCglDosing01Stop215.style.display = "none";
                }
                //污泥池搅拌机
                var sludgeMixerRun215 = document.getElementById("sludgeMixerRun215");
                var sludgeMixerStop215 = document.getElementById("sludgeMixerStop215");
                if (result.sludgeMixerRun === false)  //集水井提升泵
                {
                    sludgeMixerRun215.style.display = "none";
                    sludgeMixerStop215.style.display = "block";
                } else {
                    sludgeMixerRun215.style.display = "block";
                    sludgeMixerStop215.style.display = "none";
                }
                //泥水分离机进泥泵
                var slySeprtInPumpRun215 = document.getElementById("slySeprtInPumpRun215");
                var slySeprtInPumpStop215 = document.getElementById("slySeprtInPumpStop215");
                if (result.slySeprtInPumpRun === false)  //集水井提升泵
                {
                    slySeprtInPumpRun215.style.display = "none";
                    slySeprtInPumpStop215.style.display = "block";
                } else {
                    slySeprtInPumpRun215.style.display = "block";
                    slySeprtInPumpStop215.style.display = "none";
                }
                //絮凝剂加药泵
                var flocltDosingRun215 = document.getElementById("flocltDosingRun215");
                var flocltDosingStop215 = document.getElementById("flocltDosingStop215");
                if (result.flocltDosingRun === false)  //集水井提升泵
                {
                    flocltDosingRun215.style.display = "none";
                    flocltDosingStop215.style.display = "block";
                } else {
                    flocltDosingRun215.style.display = "block";
                    flocltDosingStop215.style.display = "none";
                }
                //絮凝剂搅拌机
                var flocltMixerRun215 = document.getElementById("flocltMixerRun215");
                var flocltMixerStop215 = document.getElementById("flocltMixerStop215");
                if (result.flocltMixerRun === false)  //集水井提升泵
                {
                    flocltMixerRun215.style.display = "none";
                    flocltMixerStop215.style.display = "block";
                } else {
                    flocltMixerRun215.style.display = "block";
                    flocltMixerStop215.style.display = "none";
                }
                //泥水分离机
                var slySeprtRun215 = document.getElementById("slySeprtRun215");
                var slySeprtStop215 = document.getElementById("slySeprtStop215");
                if (result.slySeprtRun === false)  //集水井提升泵
                {
                    slySeprtRun215.style.display = "none";
                    slySeprtStop215.style.display = "block";
                } else {
                    slySeprtRun215.style.display = "block";
                    slySeprtStop215.style.display = "none";
                }
                //调节初沉池污泥泵
                var pmySinkPumpRun215 = document.getElementById("pmySinkPumpRun215");
                var pmySinkPumpStop215 = document.getElementById("pmySinkPumpStop215");
                if (result.pmySinkPumpRun === false)  //集水井提升泵
                {
                    pmySinkPumpRun215.style.display = "none";
                    pmySinkPumpStop215.style.display = "block";
                } else {
                    pmySinkPumpRun215.style.display = "block";
                    pmySinkPumpStop215.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpRun215 = document.getElementById("sbrIntakePumpRun215");
                var sbrIntakePumpStop215 = document.getElementById("sbrIntakePumpStop215");
                if (result.sbrIntakePumpRun === false)  //集水井提升泵
                {
                    sbrIntakePumpRun215.style.display = "none";
                    sbrIntakePumpStop215.style.display = "block";
                } else {
                    sbrIntakePumpRun215.style.display = "block";
                    sbrIntakePumpStop215.style.display = "none";
                }

                //风机1
                var fan01Run215 = document.getElementById("fan01Run215");
                var fan01Stop215 = document.getElementById("fan01Stop215");
                if (result.fan01Run === false)  //集水井提升泵
                {
                    fan01Run215.style.display = "none";
                    fan01Stop215.style.display = "block";
                } else {
                    fan01Run215.style.display = "block";
                    fan01Stop215.style.display = "none";
                }
                //风机2
                var fan02Run215 = document.getElementById("fan02Run215");
                var fan02Stop215 = document.getElementById("fan02Stop215");
                if (result.fan02Run === false)  //集水井提升泵
                {
                    fan02Run215.style.display = "none";
                    fan02Stop215.style.display = "block";
                } else {
                    fan02Run215.style.display = "block";
                    fan02Stop215.style.display = "none";
                }
                //SBR池污泥泵
                var sbrSludegPumpRun215 = document.getElementById("sbrSludegPumpRun215");
                var sbrSludegPumpStop215 = document.getElementById("sbrSludegPumpStop215");
                if (result.sbrSludegPumpRun === false)  //集水井提升泵
                {
                    sbrSludegPumpRun215.style.display = "none";
                    sbrSludegPumpStop215.style.display = "block";
                } else {
                    sbrSludegPumpRun215.style.display = "block";
                    sbrSludegPumpStop215.style.display = "none";
                }
                //电动排水阀
                var eleDrainRun215 = document.getElementById("eleDrainRun215");
                var eleDrainStop215 = document.getElementById("eleDrainStop215");
                if (result.eleDrainRun === false)  //集水井提升泵
                {
                    eleDrainRun215.style.display = "none";
                    eleDrainStop215.style.display = "block";
                } else {
                    eleDrainRun215.style.display = "block";
                    eleDrainStop215.style.display = "none";
                }
                //SBR池搅拌机1
                var sbrMixer01Run215 = document.getElementById("sbrMixer01Run215");
                var sbrMixer01Stop215 = document.getElementById("sbrMixer01Stop215");
                if (result.sbrMixer01Run === false)  //集水井提升泵
                {
                    sbrMixer01Run215.style.display = "none";
                    sbrMixer01Stop215.style.display = "block";
                } else {
                    sbrMixer01Run215.style.display = "block";
                    sbrMixer01Stop215.style.display = "none";
                }
                //SBR池搅拌机2
                var sbrMixer02Run215 = document.getElementById("sbrMixer02Run215");
                var sbrMixer02Stop215 = document.getElementById("sbrMixer02Stop215");
                if (result.sbrMixer02Run === false)  //集水井提升泵
                {
                    sbrMixer02Run215.style.display = "none";
                    sbrMixer02Stop215.style.display = "block";
                } else {
                    sbrMixer02Run215.style.display = "block";
                    sbrMixer02Stop215.style.display = "none";
                }
                //厌氧池进水泵
                var uasbInPumpRun215 = document.getElementById("uasbInPumpRun215");
                var uasbInPumpStop215 = document.getElementById("uasbInPumpStop215");
                if (result.uasbInPumpRun === false)  //集水井提升泵
                {
                    uasbInPumpRun215.style.display = "none";
                    uasbInPumpStop215.style.display = "block";
                } else {
                    uasbInPumpRun215.style.display = "block";
                    uasbInPumpStop215.style.display = "none";
                }
                //内回流泵
                var inBfPumpRun215 = document.getElementById("inBfPumpRun215");
                var inBfPumpStop215 = document.getElementById("inBfPumpStop215");
                if (result.inBfPumpRun === false)  //集水井提升泵
                {
                    inBfPumpRun215.style.display = "none";
                    inBfPumpStop215.style.display = "block";
                } else {
                    inBfPumpRun215.style.display = "block";
                    inBfPumpStop215.style.display = "none";
                }
                //外回流泵
                var outBfPumpRun215 = document.getElementById("outBfPumpRun215");
                var outBfPumpStop215 = document.getElementById("outBfPumpStop215");
                if (result.outBfPumpRun === false)  //集水井提升泵
                {
                    outBfPumpRun215.style.display = "none";
                    outBfPumpStop215.style.display = "block";
                } else {
                    outBfPumpRun215.style.display = "block";
                    outBfPumpStop215.style.display = "none";
                }
                //厌氧池搅拌机
                var uasbMixerRun215 = document.getElementById("uasbMixerRun215");
                var uasbMixerStop215 = document.getElementById("uasbMixerStop215");
                if (result.uasbMixerRun === false)  //集水井提升泵
                {
                    uasbMixerRun215.style.display = "none";
                    uasbMixerStop215.style.display = "block";
                } else {
                    uasbMixerRun215.style.display = "block";
                    uasbMixerStop215.style.display = "none";
                }

                //缺氧池搅拌机
                var anoxiaMixerRun215 = document.getElementById("anoxiaMixerRun215");
                var anoxiaMixerStop215 = document.getElementById("anoxiaMixerStop215");
                if (result.anoxiaMixerRun === false)  //集水井提升泵
                {
                    anoxiaMixerRun215.style.display = "none";
                    anoxiaMixerStop215.style.display = "block";
                } else {
                    anoxiaMixerRun215.style.display = "block";
                    anoxiaMixerStop215.style.display = "none";
                }
                //二沉池污泥泵
                var secSinkPumpRun215 = document.getElementById("secSinkPumpRun215");
                var secSinkPumpStop215 = document.getElementById("secSinkPumpStop215");
                if (result.secSinkPumpRun === false)  //集水井提升泵
                {
                    secSinkPumpRun215.style.display = "none";
                    secSinkPumpStop215.style.display = "block";
                } else {
                    secSinkPumpRun215.style.display = "block";
                    secSinkPumpStop215.style.display = "none";
                }
                //混凝剂2搅拌机
                var bldCglMixer02Run215 = document.getElementById("bldCglMixer02Run215");
                var bldCglMixer02Stop215 = document.getElementById("bldCglMixer02Stop215");
                if (result.bldCglMixer02Run === false)  //集水井提升泵
                {
                    bldCglMixer02Run215.style.display = "none";
                    bldCglMixer02Stop215.style.display = "block";
                } else {
                    bldCglMixer02Run215.style.display = "block";
                    bldCglMixer02Stop215.style.display = "none";
                }
                //助凝剂2搅拌机
                var astCglMixer02Run215 = document.getElementById("astCglMixer02Run215");
                var astCglMixer02Stop215 = document.getElementById("astCglMixer02Stop215");
                if (result.astCglMixer02Run === false)  //集水井提升泵
                {
                    astCglMixer02Run215.style.display = "none";
                    astCglMixer02Stop215.style.display = "block";
                } else {
                    astCglMixer02Run215.style.display = "block";
                    astCglMixer02Stop215.style.display = "none";
                }
                //除磷剂搅拌机
                var ppRmvMixerRun215 = document.getElementById("ppRmvMixerRun215");
                var ppRmvMixerStop215 = document.getElementById("ppRmvMixerStop215");
                if (result.ppRmvMixerRun === false)  //集水井提升泵
                {
                    ppRmvMixerRun215.style.display = "none";
                    ppRmvMixerStop215.style.display = "block";
                } else {
                    ppRmvMixerRun215.style.display = "block";
                    ppRmvMixerStop215.style.display = "none";
                }
                //混凝剂2加药泵
                var bldCglDosing02Run215 = document.getElementById("bldCglDosing02Run215");
                var bldCglDosing02Stop215 = document.getElementById("bldCglDosing02Stop215");
                if (result.bldCglDosing02Run === false)  //集水井提升泵
                {
                    bldCglDosing02Run215.style.display = "none";
                    bldCglDosing02Stop215.style.display = "block";
                } else {
                    bldCglDosing02Run215.style.display = "block";
                    bldCglDosing02Stop215.style.display = "none";
                }
                //助凝剂2加药泵
                var astCglDosing02Run215 = document.getElementById("astCglDosing02Run215");
                var astCglDosing02Stop215 = document.getElementById("astCglDosing02Stop215");
                if (result.astCglDosing02Run === false)  //集水井提升泵
                {
                    astCglDosing02Run215.style.display = "none";
                    astCglDosing02Stop215.style.display = "block";
                } else {
                    astCglDosing02Run215.style.display = "block";
                    astCglDosing02Stop215.style.display = "none";
                }
                //除磷剂加药泵
                var ppRmvDosingRun215 = document.getElementById("ppRmvDosingRun215");
                var ppRmvDosingStop215 = document.getElementById("ppRmvDosingStop215");
                if (result.ppRmvDosingRun === false)  //集水井提升泵
                {
                    ppRmvDosingRun215.style.display = "none";
                    ppRmvDosingStop215.style.display = "block";
                } else {
                    ppRmvDosingRun215.style.display = "block";
                    ppRmvDosingStop215.style.display = "none";
                }
                //混反池2搅拌机
                var bldOpstMixer02Run215 = document.getElementById("bldOpstMixer02Run215");
                var bldOpstMixer02Stop215 = document.getElementById("bldOpstMixer02Stop215");
                if (result.bldOpstMixer02Run === false)  //集水井提升泵
                {
                    bldOpstMixer02Run215.style.display = "none";
                    bldOpstMixer02Stop215.style.display = "block";
                } else {
                    bldOpstMixer02Run215.style.display = "block";
                    bldOpstMixer02Stop215.style.display = "none";
                }
                //混合池2搅拌机
                var bldMixer02Run215 = document.getElementById("bldMixer02Run215");
                var bldMixer02Stop215 = document.getElementById("bldMixer02Stop215");
                if (result.bldMixer02Run === false)  //集水井提升泵
                {
                    bldMixer02Run215.style.display = "none";
                    bldMixer02Stop215.style.display = "block";
                } else {
                    bldMixer02Run215.style.display = "block";
                    bldMixer02Stop215.style.display = "none";
                }

                //除磷池搅拌机
                var ppRmvTankMixerRun215 = document.getElementById("ppRmvTankMixerRun215");
                var ppRmvTankMixerStop215 = document.getElementById("ppRmvTankMixerStop215");
                if (result.ppRmvTankMixerRun === false)  //集水井提升泵
                {
                    ppRmvTankMixerRun215.style.display = "none";
                    ppRmvTankMixerStop215.style.display = "block";
                } else {
                    ppRmvTankMixerRun215.style.display = "block";
                    ppRmvTankMixerStop215.style.display = "none";
                }
                //终沉池污泥泵
                var finalSinkPumpRun215 = document.getElementById("finalSinkPumpRun215");
                var finalSinkPumpStop215 = document.getElementById("finalSinkPumpStop215");
                if (result.finalSinkPumpRun === false)  //集水井提升泵
                {
                    finalSinkPumpRun215.style.display = "none";
                    finalSinkPumpStop215.style.display = "block";
                } else {
                    finalSinkPumpRun215.style.display = "block";
                    finalSinkPumpStop215.style.display = "none";
                }
                /*************设备 运行时间***************/
                    //机械格栅
                var ydsgsRunMin215 = document.getElementById("ydsgsRunMin215");
                //机械格栅
                ydsgsRunMin215.innerText = result.ydsgsRunMin;

                //集水井提升泵
                var collectWellPumpRunMin215 = document.getElementById("collectWellPumpRunMin215");
                //集水井提升泵
                collectWellPumpRunMin215.innerText = result.collectWellPumpRunMin;
                //集水池搅拌机1
                var collectMixer01RunMin215 = document.getElementById("collectMixer01RunMin215");
                //集水池搅拌机1
                collectMixer01RunMin215.innerText = result.collectMixer01RunMin;
                //集水池搅拌机2
                var collectMixer02RunMin215 = document.getElementById("collectMixer02RunMin215");
                //集水池搅拌机2
                collectMixer02RunMin215.innerText = result.collectMixer02RunMin;
                //除磷投加机
                var dephosphorizeRunMin215 = document.getElementById("dephosphorizeRunMin215");
                //除磷投加机
                dephosphorizeRunMin215.innerText = result.dephosphorizeRunMin;
                //集水池提升泵
                var collectPumpRunMin215 = document.getElementById("collectPumpRunMin215");
                //集水池提升泵
                collectPumpRunMin215.innerText = result.collectPumpRunMin;
                //固液分离机
                var solLiqRunMin215 = document.getElementById("solLiqRunMin215");
                //固液分离机
                solLiqRunMin215.innerText = result.solLiqRunMin;
                //混合池1搅拌机
                var bldMixer01RunMin215 = document.getElementById("bldMixer01RunMin215");
                //混合池1搅拌机
                bldMixer01RunMin215.innerText = result.bldMixer01RunMin;
                //混反池1搅拌机
                var bldOpstMixer01RunMin215 = document.getElementById("bldOpstMixer01RunMin215");
                //混反池1搅拌机
                bldOpstMixer01RunMin215.innerText = result.bldOpstMixer01RunMin;
                //混沉池污泥泵
                var bldSinkPumpRunMin215 = document.getElementById("bldSinkPumpRunMin215");
                //混沉池污泥泵
                bldSinkPumpRunMin215.innerText = result.bldSinkPumpRunMin;
                //混凝剂1搅拌机
                var bldCglMixer01RunMin215 = document.getElementById("bldCglMixer01RunMin215");
                //混凝剂1搅拌机
                bldCglMixer01RunMin215.innerText = result.bldCglMixer01RunMin;

                //混凝剂1加药泵
                var bldCglDosing01RunMin215 = document.getElementById("bldCglDosing01RunMin215");
                //混凝剂1加药泵
                bldCglDosing01RunMin215.innerText = result.bldCglDosing01RunMin;
                //助凝剂1搅拌机
                var astCglMixer01RunMin215 = document.getElementById("astCglMixer01RunMin215");
                //助凝剂1搅拌机
                astCglMixer01RunMin215.innerText = result.astCglMixer01RunMin;
                //助凝剂1加药泵
                var astCglDosing01RunMin215 = document.getElementById("astCglDosing01RunMin215");
                //助凝剂1加药泵
                astCglDosing01RunMin215.innerText = result.astCglDosing01RunMin;
                //污泥池搅拌机
                var sludgeMixerRunMin215 = document.getElementById("sludgeMixerRunMin215");
                //污泥池搅拌机
                sludgeMixerRunMin215.innerText = result.sludgeMixerRunMin;
                //泥水分离机进泥泵
                var slySeprtInPumpRunMin215 = document.getElementById("slySeprtInPumpRunMin215");
                //泥水分离机进泥泵
                slySeprtInPumpRunMin215.innerText = result.slySeprtInPumpRunMin;
                //絮凝剂加药泵
                var flocltDosingRunMin215 = document.getElementById("flocltDosingRunMin215");
                //絮凝剂加药泵
                flocltDosingRunMin215.innerText = result.flocltDosingRunMin;
                //絮凝剂搅拌机
                var flocltMixerRunMin215 = document.getElementById("flocltMixerRunMin215");
                //絮凝剂搅拌机
                flocltMixerRunMin215.innerText = result.flocltMixerRunMin;
                //泥水分离机
                var slySeprtRunMin215 = document.getElementById("slySeprtRunMin215");
                //泥水分离机
                slySeprtRunMin215.innerText = result.slySeprtRunMin;
                //调节初沉池污泥泵
                var pmySinkPumpRunMin215 = document.getElementById("pmySinkPumpRunMin215");
                //调节初沉池污泥泵
                pmySinkPumpRunMin215.innerText = result.pmySinkPumpRunMin;
                //SBR池进水泵
                var sbrIntakePumpRunMin215 = document.getElementById("sbrIntakePumpRunMin215");
                //SBR池进水泵
                sbrIntakePumpRunMin215.innerText = result.sbrIntakePumpRunMin;

                //风机1
                var fan01RunMin215 = document.getElementById("fan01RunMin215");
                //风机1
                fan01RunMin215.innerText = result.fan01RunMin;
                //风机2
                var fan02RunMin215 = document.getElementById("fan02RunMin215");
                //风机2
                fan02RunMin215.innerText = result.fan02RunMin;
                //SBR池污泥泵
                var sbrSludegPumpRunMin215 = document.getElementById("sbrSludegPumpRunMin215");
                //SBR池污泥泵
                sbrSludegPumpRunMin215.innerText = result.sbrSludegPumpRunMin;
                //电动排水阀
                var eleDrainRunMin215 = document.getElementById("eleDrainRunMin215");
                //电动排水阀
                eleDrainRunMin215.innerText = result.eleDrainRunMin;
                //SBR池搅拌机1
                var sbrMixer01RunMin215 = document.getElementById("sbrMixer01RunMin215");
                //SBR池搅拌机1
                sbrMixer01RunMin215.innerText = result.sbrMixer01RunMin;
                //SBR池搅拌机2
                var sbrMixer02RunMin215 = document.getElementById("sbrMixer02RunMin215");
                //SBR池搅拌机2
                sbrMixer02RunMin215.innerText = result.sbrMixer02RunMin;
                //厌氧池进水泵
                var uasbInPumpRunMin215 = document.getElementById("uasbInPumpRunMin215");
                //厌氧池进水泵
                uasbInPumpRunMin215.innerText = result.uasbInPumpRunMin;
                //内回流泵
                var inBfPumpRunMin215 = document.getElementById("inBfPumpRunMin215");
                //内回流泵
                inBfPumpRunMin215.innerText = result.inBfPumpRunMin;
                //外回流泵
                var outBfPumpRunMin215 = document.getElementById("outBfPumpRunMin215");
                //外回流泵
                outBfPumpRunMin215.innerText = result.outBfPumpRunMin;
                //厌氧池搅拌机
                var uasbMixerRunMin215 = document.getElementById("uasbMixerRunMin215");
                //厌氧池搅拌机
                uasbMixerRunMin215.innerText = result.uasbMixerRunMin;

                //缺氧池搅拌机
                var anoxiaMixerRunMin215 = document.getElementById("anoxiaMixerRunMin215");
                //缺氧池搅拌机
                anoxiaMixerRunMin215.innerText = result.anoxiaMixerRunMin;
                //二沉池污泥泵
                var secSinkPumpRunMin215 = document.getElementById("secSinkPumpRunMin215");
                //二沉池污泥泵
                secSinkPumpRunMin215.innerText = result.secSinkPumpRunMin;
                //混凝剂2搅拌机
                var bldCglMixer02RunMin215 = document.getElementById("bldCglMixer02RunMin215");
                //混凝剂2搅拌机
                bldCglMixer02RunMin215.innerText = result.bldCglMixer02RunMin;
                //助凝剂2搅拌机
                var astCglMixer02RunMin215 = document.getElementById("astCglMixer02RunMin215");
                //助凝剂2搅拌机
                astCglMixer02RunMin215.innerText = result.astCglMixer02RunMin;
                //除磷剂搅拌机
                var ppRmvMixerRunMin215 = document.getElementById("ppRmvMixerRunMin215");
                //除磷剂搅拌机
                ppRmvMixerRunMin215.innerText = result.ppRmvMixerRunMin;
                //混凝剂2加药泵
                var bldCglDosing02RunMin215 = document.getElementById("bldCglDosing02RunMin215");
                //混凝剂2加药泵
                bldCglDosing02RunMin215.innerText = result.bldCglDosing02RunMin;
                //助凝剂2加药泵
                var astCglDosing02RunMin215 = document.getElementById("astCglDosing02RunMin215");
                //助凝剂2加药泵
                astCglDosing02RunMin215.innerText = result.astCglDosing02RunMin;
                //除磷剂加药泵
                var ppRmvDosingRunMin215 = document.getElementById("ppRmvDosingRunMin215");
                //除磷剂加药泵
                ppRmvDosingRunMin215.innerText = result.ppRmvDosingRunMin;
                //混反池2搅拌机
                var bldOpstMixer02RunMin215 = document.getElementById("bldOpstMixer02RunMin215");
                //混反池2搅拌机
                bldOpstMixer02RunMin215.innerText = result.bldOpstMixer02RunMin;
                //混合池2搅拌机
                var bldMixer02RunMin215 = document.getElementById("bldMixer02RunMin215");
                //混合池2搅拌机
                bldMixer02RunMin215.innerText = result.bldMixer02RunMin;
                //除磷池搅拌机
                var ppRmvTankMixerRunMin215 = document.getElementById("ppRmvTankMixerRunMin215");
                //除磷池搅拌机
                ppRmvTankMixerRunMin215.innerText = result.ppRmvTankMixerRunMin;
                //终沉池污泥泵
                var finalSinkPumpRunMin215 = document.getElementById("finalSinkPumpRunMin215");
                //终沉池污泥泵
                finalSinkPumpRunMin215.innerText = result.finalSinkPumpRunMin;

                /***************电能数据*************************/
                    //线电压Uab
                var uab215 = document.getElementById("uab215");
                //线电压Ubc
                var ubc215 = document.getElementById("ubc215");
                //线电压Uca
                var uca215 = document.getElementById("uca215");
                //相电压Ua
                var ua215 = document.getElementById("ua215");
                //相电压Ub
                var ub215 = document.getElementById("ub215");
                //相电压Uc
                var uc215 = document.getElementById("uc215");
                //电流Ia
                var ia215 = document.getElementById("ia215");
                //电流Ib
                var ib215 = document.getElementById("ib215");
                //电流Ic
                var ic215 = document.getElementById("ic215");
                //合相有功功率
                var pt215 = document.getElementById("pt215");
                //合相无功功率
                var qt215 = document.getElementById("qt215");
                //合相视在功率
                var st215 = document.getElementById("st215");
                //合相功率因数
                var pft215 = document.getElementById("pft215");
                //正向有功总电能
                var impEP215 = document.getElementById("impEP215");
                //反向有功总电能
                var expEP215 = document.getElementById("expEP215");
                //频率
                var freq215 = document.getElementById("freq215");
                //线电压Uab
                uab215.innerText = result.uab;
                //线电压Ubc
                ubc215.innerText = result.ubc;
                //线电压Uca
                uca215.innerText = result.uca;
                //相电压Ua
                ua215.innerText = result.ua;
                //相电压Ub
                ub215.innerText = result.ub;
                //相电压Uc
                uc215.innerText = result.uc;
                //电流Ia
                ia215.innerText = result.ia;
                //电流Ib
                ib215.innerText = result.ib;
                //电流Ic
                ic215.innerText = result.ic;
                //合相有功功率
                pt215.innerText = result.pt;
                //合相无功功率
                qt215.innerText = result.qt;
                //合相视在功率
                st215.innerText = result.st;
                //合相功率因数
                pft215.innerText = result.pft;
                //正向有功总电能
                impEP215.innerText = result.impEP;
                //反向有功总电能
                expEP215.innerText = result.expEP;
                //频率
                freq215.innerText = result.freq;


                /***************设备运行累计时长*************************/
                    //机械格栅
                var ydsgsRunTotal215 = document.getElementById("ydsgsRunTotal215");
                //机械格栅
                ydsgsRunTotal215.innerText = result.ydsgsRunTotal;

                //集水井提升泵
                var collectWellPumpRunTotal215 = document.getElementById("collectWellPumpRunTotal215");
                //集水井提升泵
                collectWellPumpRunTotal215.innerText = result.collectWellPumpRunTotal;
                //集水池搅拌机1
                var collectMixer01RunTotal215 = document.getElementById("collectMixer01RunTotal215");
                //集水池搅拌机1
                collectMixer01RunTotal215.innerText = result.collectMixer01RunTotal;
                //集水池搅拌机2
                var collectMixer02RunTotal215 = document.getElementById("collectMixer02RunTotal215");
                //集水池搅拌机2
                collectMixer02RunTotal215.innerText = result.collectMixer02RunTotal;
                //除磷投加机
                var dephosphorizeRunTotal215 = document.getElementById("dephosphorizeRunTotal215");
                //除磷投加机
                dephosphorizeRunTotal215.innerText = result.dephosphorizeRunTotal;
                //集水池提升泵
                var collectPumpRunTotal215 = document.getElementById("collectPumpRunTotal215");
                //集水池提升泵
                collectPumpRunTotal215.innerText = result.collectPumpRunTotal;
                //固液分离机
                var solLiqRunTotal215 = document.getElementById("solLiqRunTotal215");
                //固液分离机
                solLiqRunTotal215.innerText = result.solLiqRunTotal;
                //混合池1搅拌机
                var bldMixer01RunTotal215 = document.getElementById("bldMixer01RunTotal215");
                //混合池1搅拌机
                bldMixer01RunTotal215.innerText = result.bldMixer01RunTotal;
                //混反池1搅拌机
                var bldOpstMixer01RunTotal215 = document.getElementById("bldOpstMixer01RunTotal215");
                //混反池1搅拌机
                bldOpstMixer01RunTotal215.innerText = result.bldOpstMixer01RunTotal;
                //混沉池污泥泵
                var bldSinkPumpRunTotal215 = document.getElementById("bldSinkPumpRunTotal215");
                //混沉池污泥泵
                bldSinkPumpRunTotal215.innerText = result.bldSinkPumpRunTotal;
                //混凝剂1搅拌机
                var bldCglMixer01RunTotal215 = document.getElementById("bldCglMixer01RunTotal215");
                //混凝剂1搅拌机
                bldCglMixer01RunTotal215.innerText = result.bldCglMixer01RunTotal;

                //混凝剂1加药泵
                var bldCglDosing01RunTotal215 = document.getElementById("bldCglDosing01RunTotal215");
                //混凝剂1加药泵
                bldCglDosing01RunTotal215.innerText = result.bldCglDosing01RunTotal;
                //助凝剂1搅拌机
                var astCglMixer01RunTotal215 = document.getElementById("astCglMixer01RunTotal215");
                //助凝剂1搅拌机
                astCglMixer01RunTotal215.innerText = result.astCglMixer01RunTotal;
                //助凝剂1加药泵
                var astCglDosing01RunTotal215 = document.getElementById("astCglDosing01RunTotal215");
                //助凝剂1加药泵
                astCglDosing01RunTotal215.innerText = result.astCglDosing01RunTotal;
                //污泥池搅拌机
                var sludgeMixerRunTotal215 = document.getElementById("sludgeMixerRunTotal215");
                //污泥池搅拌机
                sludgeMixerRunTotal215.innerText = result.sludgeMixerRunTotal;
                //泥水分离机进泥泵
                var slySeprtInPumpRunTotal215 = document.getElementById("slySeprtInPumpRunTotal215");
                //泥水分离机进泥泵
                slySeprtInPumpRunTotal215.innerText = result.slySeprtInPumpRunTotal;
                //絮凝剂加药泵
                var flocltDosingRunTotal215 = document.getElementById("flocltDosingRunTotal215");
                //絮凝剂加药泵
                flocltDosingRunTotal215.innerText = result.flocltDosingRunTotal;
                //絮凝剂搅拌机
                var flocltMixerRunTotal215 = document.getElementById("flocltMixerRunTotal215");
                //絮凝剂搅拌机
                flocltMixerRunTotal215.innerText = result.flocltMixerRunTotal;
                //泥水分离机
                var slySeprtRunTotal215 = document.getElementById("slySeprtRunTotal215");
                //泥水分离机
                slySeprtRunTotal215.innerText = result.slySeprtRunTotal;
                //调节初沉池污泥泵
                var pmySinkPumpRunTotal215 = document.getElementById("pmySinkPumpRunTotal215");
                //调节初沉池污泥泵
                pmySinkPumpRunTotal215.innerText = result.pmySinkPumpRunTotal;
                //SBR池进水泵
                var sbrIntakePumpRunTotal215 = document.getElementById("sbrIntakePumpRunTotal215");
                //SBR池进水泵
                sbrIntakePumpRunTotal215.innerText = result.sbrIntakePumpRunTotal;

                //风机1
                var fan01RunTotal215 = document.getElementById("fan01RunTotal215");
                //风机1
                fan01RunTotal215.innerText = result.fan01RunTotal;
                //风机2
                var fan02RunTotal215 = document.getElementById("fan02RunTotal215");
                //风机2
                fan02RunTotal215.innerText = result.fan02RunTotal;
                //SBR池污泥泵
                var sbrSludegPumpRunTotal215 = document.getElementById("sbrSludegPumpRunTotal215");
                //SBR池污泥泵
                sbrSludegPumpRunTotal215.innerText = result.sbrSludegPumpRunTotal;
                //电动排水阀
                var eleDrainRunTotal215 = document.getElementById("eleDrainRunTotal215");
                //电动排水阀
                eleDrainRunTotal215.innerText = result.eleDrainRunTotal;
                //SBR池搅拌机1
                var sbrMixer01RunTotal215 = document.getElementById("sbrMixer01RunTotal215");
                //SBR池搅拌机1
                sbrMixer01RunTotal215.innerText = result.sbrMixer01RunTotal;
                //SBR池搅拌机2
                var sbrMixer02RunTotal215 = document.getElementById("sbrMixer02RunTotal215");
                //SBR池搅拌机2
                sbrMixer02RunTotal215.innerText = result.sbrMixer02RunTotal;
                //厌氧池进水泵
                var uasbInPumpRunTotal215 = document.getElementById("uasbInPumpRunTotal215");
                //厌氧池进水泵
                uasbInPumpRunTotal215.innerText = result.uasbInPumpRunTotal;
                //内回流泵
                var inBfPumpRunTotal215 = document.getElementById("inBfPumpRunTotal215");
                //内回流泵
                inBfPumpRunTotal215.innerText = result.inBfPumpRunTotal;
                //外回流泵
                var outBfPumpRunTotal215 = document.getElementById("outBfPumpRunTotal215");
                //外回流泵
                outBfPumpRunTotal215.innerText = result.outBfPumpRunTotal;
                //厌氧池搅拌机
                var uasbMixerRunTotal215 = document.getElementById("uasbMixerRunTotal215");
                //厌氧池搅拌机
                uasbMixerRunTotal215.innerText = result.uasbMixerRunTotal;

                //缺氧池搅拌机
                var anoxiaMixerRunTotal215 = document.getElementById("anoxiaMixerRunTotal215");
                //缺氧池搅拌机
                anoxiaMixerRunTotal215.innerText = result.anoxiaMixerRunTotal;
                //二沉池污泥泵
                var secSinkPumpRunTotal215 = document.getElementById("secSinkPumpRunTotal215");
                //二沉池污泥泵
                secSinkPumpRunTotal215.innerText = result.secSinkPumpRunTotal;
                //混凝剂2搅拌机
                var bldCglMixer02RunTotal215 = document.getElementById("bldCglMixer02RunTotal215");
                //混凝剂2搅拌机
                bldCglMixer02RunTotal215.innerText = result.bldCglMixer02RunTotal;
                //助凝剂2搅拌机
                var astCglMixer02RunTotal215 = document.getElementById("astCglMixer02RunTotal215");
                //助凝剂2搅拌机
                astCglMixer02RunTotal215.innerText = result.astCglMixer02RunTotal;
                //除磷剂搅拌机
                var ppRmvMixerRunTotal215 = document.getElementById("ppRmvMixerRunTotal215");
                //除磷剂搅拌机
                ppRmvMixerRunTotal215.innerText = result.ppRmvMixerRunTotal;
                //混凝剂2加药泵
                var bldCglDosing02RunTotal215 = document.getElementById("bldCglDosing02RunTotal215");
                //混凝剂2加药泵
                bldCglDosing02RunTotal215.innerText = result.bldCglDosing02RunTotal;
                //助凝剂2加药泵
                var astCglDosing02RunTotal215 = document.getElementById("astCglDosing02RunTotal215");
                //助凝剂2加药泵
                astCglDosing02RunTotal215.innerText = result.astCglDosing02RunTotal;
                //除磷剂加药泵
                var ppRmvDosingRunTotal215 = document.getElementById("ppRmvDosingRunTotal215");
                //除磷剂加药泵
                ppRmvDosingRunTotal215.innerText = result.ppRmvDosingRunTotal;
                //混反池2搅拌机
                var bldOpstMixer02RunTotal215 = document.getElementById("bldOpstMixer02RunTotal215");
                //混反池2搅拌机
                bldOpstMixer02RunTotal215.innerText = result.bldOpstMixer02RunTotal;
                //混合池2搅拌机
                var bldMixer02RunTotal215 = document.getElementById("bldMixer02RunTotal215");
                //混合池2搅拌机
                bldMixer02RunTotal215.innerText = result.bldMixer02RunTotal;
                //除磷池搅拌机
                var ppRmvTankMixerRunTotal215 = document.getElementById("ppRmvTankMixerRunTotal215");
                //除磷池搅拌机
                ppRmvTankMixerRunTotal215.innerText = result.ppRmvTankMixerRunTotal;
                //终沉池污泥泵
                var finalSinkPumpRunTotal215 = document.getElementById("finalSinkPumpRunTotal215");
                //终沉池污泥泵
                finalSinkPumpRunTotal215.innerText = result.finalSinkPumpRunTotal;

                /***************设备运行时间(时+分)*************************/
                    //机械格栅
                var ydsgsRunTime215 = document.getElementById("ydsgsRunTime215");
                //机械格栅
                ydsgsRunTime215.innerText = formatTime215(result.ydsgsRunSHour) + ":" + formatTime215(result.ydsgsRunSMin);

                //集水井提升泵
                var collectWellPumpRunTime215 = document.getElementById("collectWellPumpRunTime215");
                //集水井提升泵
                collectWellPumpRunTime215.innerText = formatTime215(result.collectWellPumpRunSHour) + ":" + formatTime215(result.collectWellPumpRunSMin);
                //集水池搅拌机1
                var collectMixer01RunTime215 = document.getElementById("collectMixer01RunTime215");
                //集水池搅拌机1
                collectMixer01RunTime215.innerText = formatTime215(result.collectMixer01RunSHour) + ":" + formatTime215(result.collectMixer01RunSMin);
                //集水池搅拌机2
                var collectMixer02RunTime215 = document.getElementById("collectMixer02RunTime215");
                //集水池搅拌机2
                collectMixer02RunTime215.innerText = formatTime215(result.collectMixer02RunSHour) + ":" + formatTime215(result.collectMixer02RunSMin);
                //除磷投加机
                var dephosphorizeRunTime215 = document.getElementById("dephosphorizeRunTime215");
                //除磷投加机
                dephosphorizeRunTime215.innerText = formatTime215(result.dephosphorizeRunSHour) + ":" + formatTime215(result.dephosphorizeRunSMin);
                //集水池提升泵
                var collectPumpRunTime215 = document.getElementById("collectPumpRunTime215");
                //集水池提升泵
                collectPumpRunTime215.innerText = formatTime215(result.collectPumpRunSHour) + ":" + formatTime215(result.collectPumpRunSMin);
                //固液分离机
                var solLiqRunTime215 = document.getElementById("solLiqRunTime215");
                //固液分离机
                solLiqRunTime215.innerText = formatTime215(result.solLiqRunSHour) + ":" + formatTime215(result.solLiqRunSMin);
                //混合池1搅拌机
                var bldMixer01RunTime215 = document.getElementById("bldMixer01RunTime215");
                //混合池1搅拌机
                bldMixer01RunTime215.innerText = formatTime215(result.bldMixer01RunSHour) + ":" + formatTime215(result.bldMixer01RunSMin);
                //混反池1搅拌机
                var bldOpstMixer01RunTime215 = document.getElementById("bldOpstMixer01RunTime215");
                //混反池1搅拌机
                bldOpstMixer01RunTime215.innerText = formatTime215(result.bldOpstMixer01RunSHour) + ":" + formatTime215(result.bldOpstMixer01RunSMin);
                //混沉池污泥泵
                var bldSinkPumpRunTime215 = document.getElementById("bldSinkPumpRunTime215");
                //混沉池污泥泵
                bldSinkPumpRunTime215.innerText = formatTime215(result.bldSinkPumpRunSHour) + ":" + formatTime215(result.bldSinkPumpRunSMin);
                //混凝剂1搅拌机
                var bldCglMixer01RunTime215 = document.getElementById("bldCglMixer01RunTime215");
                //混凝剂1搅拌机
                bldCglMixer01RunTime215.innerText = formatTime215(result.bldCglMixer01RunSHour) + ":" + formatTime215(result.bldCglMixer01RunSMin);

                //混凝剂1加药泵
                var bldCglDosing01RunTime215 = document.getElementById("bldCglDosing01RunTime215");
                //混凝剂1加药泵
                bldCglDosing01RunTime215.innerText = formatTime215(result.bldCglDosing01RunSHour) + ":" + formatTime215(result.bldCglDosing01RunSMin);
                //助凝剂1搅拌机
                var astCglMixer01RunTime215 = document.getElementById("astCglMixer01RunTime215");
                //助凝剂1搅拌机
                astCglMixer01RunTime215.innerText = formatTime215(result.astCglMixer01RunSHour) + ":" + formatTime215(result.astCglMixer01RunSMin);
                //助凝剂1加药泵
                var astCglDosing01RunTime215 = document.getElementById("astCglDosing01RunTime215");
                //助凝剂1加药泵
                astCglDosing01RunTime215.innerText = formatTime215(result.astCglDosing01RunSHour) + ":" + formatTime215(result.astCglDosing01RunSMin);
                //污泥池搅拌机
                var sludgeMixerRunTime215 = document.getElementById("sludgeMixerRunTime215");
                //污泥池搅拌机
                sludgeMixerRunTime215.innerText = formatTime215(result.sludgeMixerRunSHour) + ":" + formatTime215(result.sludgeMixerRunSMin);
                //泥水分离机进泥泵
                var slySeprtInPumpRunTime215 = document.getElementById("slySeprtInPumpRunTime215");
                //泥水分离机进泥泵
                slySeprtInPumpRunTime215.innerText = formatTime215(result.slySeprtInPumpRunSHour) + ":" + formatTime215(result.slySeprtInPumpRunSMin);
                //絮凝剂加药泵
                var flocltDosingRunTime215 = document.getElementById("flocltDosingRunTime215");
                //絮凝剂加药泵
                flocltDosingRunTime215.innerText = formatTime215(result.flocltDosingRunSHour) + ":" + formatTime215(result.flocltDosingRunSMin);
                //絮凝剂搅拌机
                var flocltMixerRunTime215 = document.getElementById("flocltMixerRunTime215");
                //絮凝剂搅拌机
                flocltMixerRunTime215.innerText = formatTime215(result.flocltMixerRunSHour) + ":" + formatTime215(result.flocltMixerRunSMin);
                //泥水分离机
                var slySeprtRunTime215 = document.getElementById("slySeprtRunTime215");
                //泥水分离机
                slySeprtRunTime215.innerText = formatTime215(result.slySeprtRunSHour) + ":" + formatTime215(result.slySeprtRunSMin);
                //调节初沉池污泥泵
                var pmySinkPumpRunTime215 = document.getElementById("pmySinkPumpRunTime215");
                //调节初沉池污泥泵
                pmySinkPumpRunTime215.innerText = formatTime215(result.pmySinkPumpRunSHour) + ":" + formatTime215(result.pmySinkPumpRunSMin);
                //SBR池进水泵
                var sbrIntakePumpRunTime215 = document.getElementById("sbrIntakePumpRunTime215");
                //SBR池进水泵
                sbrIntakePumpRunTime215.innerText = formatTime215(result.sbrIntakePumpRunSHour) + ":" + formatTime215(result.sbrIntakePumpRunSMin);

                //风机1
                var fan01RunTime215 = document.getElementById("fan01RunTime215");
                //风机1
                fan01RunTime215.innerText = formatTime215(result.fan01RunSHour) + ":" + formatTime215(result.fan01RunSMin);
                //风机2
                var fan02RunTime215 = document.getElementById("fan02RunTime215");
                //风机2
                fan02RunTime215.innerText = formatTime215(result.fan02RunSHour) + ":" + formatTime215(result.fan02RunSMin);
                //SBR池污泥泵
                var sbrSludegPumpRunTime215 = document.getElementById("sbrSludegPumpRunTime215");
                //SBR池污泥泵
                sbrSludegPumpRunTime215.innerText = formatTime215(result.sbrSludegPumpRunSHour) + ":" + formatTime215(result.sbrSludegPumpRunSMin);
                //电动排水阀
                var eleDrainRunTime215 = document.getElementById("eleDrainRunTime215");
                //电动排水阀
                eleDrainRunTime215.innerText = formatTime215(result.eleDrainRunSHour) + ":" + formatTime215(result.eleDrainRunSMin);
                //SBR池搅拌机1
                var sbrMixer01RunTime215 = document.getElementById("sbrMixer01RunTime215");
                //SBR池搅拌机1
                sbrMixer01RunTime215.innerText = formatTime215(result.sbrMixer01RunSHour) + ":" + formatTime215(result.sbrMixer01RunSMin);
                //SBR池搅拌机2
                var sbrMixer02RunTime215 = document.getElementById("sbrMixer02RunTime215");
                //SBR池搅拌机2
                sbrMixer02RunTime215.innerText = formatTime215(result.sbrMixer02RunSHour) + ":" + formatTime215(result.sbrMixer02RunSMin);
                //厌氧池进水泵
                var uasbInPumpRunTime215 = document.getElementById("uasbInPumpRunTime215");
                //厌氧池进水泵
                uasbInPumpRunTime215.innerText = formatTime215(result.uasbInPumpRunSHour) + ":" + formatTime215(result.uasbInPumpRunSMin);
                //内回流泵
                var inBfPumpRunTime215 = document.getElementById("inBfPumpRunTime215");
                //内回流泵
                inBfPumpRunTime215.innerText = formatTime215(result.inBfPumpRunSHour) + ":" + formatTime215(result.inBfPumpRunSMin);
                //外回流泵
                var outBfPumpRunTime215 = document.getElementById("outBfPumpRunTime215");
                //外回流泵
                outBfPumpRunTime215.innerText = formatTime215(result.outBfPumpRunSHour) + ":" + formatTime215(result.outBfPumpRunSMin);
                //厌氧池搅拌机
                var uasbMixerRunTime215 = document.getElementById("uasbMixerRunTime215");
                //厌氧池搅拌机
                uasbMixerRunTime215.innerText = formatTime215(result.uasbMixerRunSHour) + ":" + formatTime215(result.uasbMixerRunSMin);

                //缺氧池搅拌机
                var anoxiaMixerRunTime215 = document.getElementById("anoxiaMixerRunTime215");
                //缺氧池搅拌机
                anoxiaMixerRunTime215.innerText = formatTime215(result.anoxiaMixerRunSHour) + ":" + formatTime215(result.anoxiaMixerRunSMin);
                //二沉池污泥泵
                var secSinkPumpRunTime215 = document.getElementById("secSinkPumpRunTime215");
                //二沉池污泥泵
                secSinkPumpRunTime215.innerText = formatTime215(result.secSinkPumpRunSHour) + ":" + formatTime215(result.secSinkPumpRunSMin);
                //混凝剂2搅拌机
                var bldCglMixer02RunTime215 = document.getElementById("bldCglMixer02RunTime215");
                //混凝剂2搅拌机
                bldCglMixer02RunTime215.innerText = formatTime215(result.bldCglMixer02RunSHour) + ":" + formatTime215(result.bldCglMixer02RunSMin);
                //助凝剂2搅拌机
                var astCglMixer02RunTime215 = document.getElementById("astCglMixer02RunTime215");
                //助凝剂2搅拌机
                astCglMixer02RunTime215.innerText = formatTime215(result.astCglMixer02RunSHour) + ":" + formatTime215(result.astCglMixer02RunSMin);
                //除磷剂搅拌机
                var ppRmvMixerRunTime215 = document.getElementById("ppRmvMixerRunTime215");
                //除磷剂搅拌机
                ppRmvMixerRunTime215.innerText = formatTime215(result.ppRmvMixerRunSHour) + ":" + formatTime215(result.ppRmvMixerRunSMin);
                //混凝剂2加药泵
                var bldCglDosing02RunTime215 = document.getElementById("bldCglDosing02RunTime215");
                //混凝剂2加药泵
                bldCglDosing02RunTime215.innerText = formatTime215(result.bldCglDosing02RunSHour) + ":" + formatTime215(result.bldCglDosing02RunSMin);
                //助凝剂2加药泵
                var astCglDosing02RunTime215 = document.getElementById("astCglDosing02RunTime215");
                //助凝剂2加药泵
                astCglDosing02RunTime215.innerText = formatTime215(result.astCglDosing02RunSHour) + ":" + formatTime215(result.astCglDosing02RunSMin);
                //除磷剂加药泵
                var ppRmvDosingRunTime215 = document.getElementById("ppRmvDosingRunTime215");
                //除磷剂加药泵
                ppRmvDosingRunTime215.innerText = formatTime215(result.ppRmvDosingRunSHour) + ":" + formatTime215(result.ppRmvDosingRunSMin);
                //混反池2搅拌机
                var bldOpstMixer02RunTime215 = document.getElementById("bldOpstMixer02RunTime215");
                //混反池2搅拌机
                bldOpstMixer02RunTime215.innerText = formatTime215(result.bldOpstMixer02RunSHour) + ":" + formatTime215(result.bldOpstMixer02RunSMin);
                //混合池2搅拌机
                var bldMixer02RunTime215 = document.getElementById("bldMixer02RunTime215");
                //混合池2搅拌机
                bldMixer02RunTime215.innerText = formatTime215(result.bldMixer02RunSHour) + ":" + formatTime215(result.bldMixer02RunSMin);
                //除磷池搅拌机
                var ppRmvTankMixerRunTime215 = document.getElementById("ppRmvTankMixerRunTime215");
                //除磷池搅拌机
                ppRmvTankMixerRunTime215.innerText = formatTime215(result.ppRmvTankMixerRunSHour) + ":" + formatTime215(result.ppRmvTankMixerRunSMin);
                //终沉池污泥泵
                var finalSinkPumpRunTime215 = document.getElementById("finalSinkPumpRunTime215");
                //终沉池污泥泵
                finalSinkPumpRunTime215.innerText = formatTime215(result.finalSinkPumpRunSHour) + ":" + formatTime215(result.finalSinkPumpRunSMin);

                /*************单个工艺流程运行时间 运行时间***************/
                    //进水泵
                var inPumpRunMin215 = document.getElementById("inPumpRunMin215");
                //进水泵
                inPumpRunMin215.innerText = result.inPumpRunMin;
                //sbr一次搅拌
                var firstSbrMixerRunMin215 = document.getElementById("firstSbrMixerRunMin215");
                //sbr一次搅拌
                firstSbrMixerRunMin215.innerText = result.firstSbrMixerRunMin;
                //风机01
                var fan01SRunMin215 = document.getElementById("fan01SRunMin215");
                //风机01
                fan01SRunMin215.innerText = result.fanRunMin;
                //风机02
                var fan02SRunMin215 = document.getElementById("fan02SRunMin215");
                //风机02
                fan02SRunMin215.innerText = result.fanRunMin;
                //SBR池二次搅拌
                var secSbrMixerRunMin215 = document.getElementById("secSbrMixerRunMin215");
                //SBR池二次搅拌
                secSbrMixerRunMin215.innerText = result.sbrMixerSecRunMin;
                //静置沉淀
                var sbrStaticRunMin215 = document.getElementById("sbrStaticRunMin215");
                //静置沉淀
                sbrStaticRunMin215.innerText = result.sbrStaticRunMin;
                //污泥泵
                var sludgePumpSRunMin215 = document.getElementById("sludgePumpSRunMin215");
                //污泥泵
                sludgePumpSRunMin215.innerText = result.sludgePumpRunMin;
                //排水阀开
                var decanterOnRunMin215 = document.getElementById("decanterOnRunMin215");
                //排水阀开
                decanterOnRunMin215.innerText = result.decanterOnRunMin;
                //排水阀关
                var decanterOffRunMin215 = document.getElementById("decanterOffRunMin215");
                //排水阀关
                decanterOffRunMin215.innerText = result.decanterOffRunMin;
                //静置活化
                var sbrActiveRunMin215 = document.getElementById("sbrActiveRunMin215");
                //静置活化
                sbrActiveRunMin215.innerText = result.sbrActiveRunMin;

                /*************单个工艺流程 运行状态***************/
                    //进水泵
                var inPumpRun215 = document.getElementById("inPumpRun215");
                var inPumpStop215 = document.getElementById("inPumpStop215");
                if (result.inPumpState === false)  //集水井提升泵
                {
                    inPumpRun215.style.display = "none";
                    inPumpStop215.style.display = "block";
                } else {
                    inPumpRun215.style.display = "block";
                    inPumpStop215.style.display = "none";
                }
                //sbr一次搅拌
                var firstSbrMixerRun215 = document.getElementById("firstSbrMixerRun215");
                var firstSbrMixerStop215 = document.getElementById("firstSbrMixerStop215");
                if (result.firstSbrMixerState === false)  //集水井提升泵
                {
                    firstSbrMixerRun215.style.display = "none";
                    firstSbrMixerStop215.style.display = "block";
                } else {
                    firstSbrMixerRun215.style.display = "block";
                    firstSbrMixerStop215.style.display = "none";
                }
                //风机01
                var fan01Run215 = document.getElementById("fan01Run215");
                var fan01Stop215 = document.getElementById("fan01Stop215");
                if (result.fan01State === false)  //集水井提升泵
                {
                    fan01Run215.style.display = "none";
                    fan01Stop215.style.display = "block";
                } else {
                    fan01Run215.style.display = "block";
                    fan01Stop215.style.display = "none";
                }
                //风机02
                var fan02Run215 = document.getElementById("fan02Run215");
                var fan02Stop215 = document.getElementById("fan02Stop215");
                if (result.fan02State === false)  //集水井提升泵
                {
                    fan02Run215.style.display = "none";
                    fan02Stop215.style.display = "block";
                } else {
                    fan02Run215.style.display = "block";
                    fan02Stop215.style.display = "none";
                }
                //sbr二次搅拌
                var secSbrMixerRun215 = document.getElementById("secSbrMixerRun215");
                var secSbrMixerStop215 = document.getElementById("secSbrMixerStop215");
                if (result.secSbrMixerState === false)  //集水井提升泵
                {
                    secSbrMixerRun215.style.display = "none";
                    secSbrMixerStop215.style.display = "block";
                } else {
                    secSbrMixerRun215.style.display = "block";
                    secSbrMixerStop215.style.display = "none";
                }
                //静置沉淀
                var sbrStaticRun215 = document.getElementById("sbrStaticRun215");
                var sbrStaticStop215 = document.getElementById("sbrStaticStop215");
                if (result.sbrStaticState === false)  //集水井提升泵
                {
                    sbrStaticRun215.style.display = "none";
                    sbrStaticStop215.style.display = "block";
                } else {
                    sbrStaticRun215.style.display = "block";
                    sbrStaticStop215.style.display = "none";
                }
                //污泥泵
                var sludgePumpRun215 = document.getElementById("sludgePumpRun215");
                var sludgePumpStop215 = document.getElementById("sludgePumpStop215");
                if (result.sludgePumpState === false)  //集水井提升泵
                {
                    sludgePumpRun215.style.display = "none";
                    sludgePumpStop215.style.display = "block";
                } else {
                    sludgePumpRun215.style.display = "block";
                    sludgePumpStop215.style.display = "none";
                }
                //排水阀开
                var decanterOnRun215 = document.getElementById("decanterOnRun215");
                var decanterOnStop215 = document.getElementById("decanterOnStop215");
                if (result.decanterOnState === false)  //集水井提升泵
                {
                    decanterOnRun215.style.display = "none";
                    decanterOnStop215.style.display = "block";
                } else {
                    decanterOnRun215.style.display = "block";
                    decanterOnStop215.style.display = "none";
                }
                //排水阀关
                var decanterOffRun215 = document.getElementById("decanterOffRun215");
                var decanterOffStop215 = document.getElementById("decanterOffStop215");
                if (result.decanterOffState === false)  //集水井提升泵
                {
                    decanterOffRun215.style.display = "none";
                    decanterOffStop215.style.display = "block";
                } else {
                    decanterOffRun215.style.display = "block";
                    decanterOffStop215.style.display = "none";
                }
                //静置活化
                var sbrActiveRun215 = document.getElementById("sbrActiveRun215");
                var sbrActiveStop215 = document.getElementById("sbrActiveStop215");
                if (result.sbrActiveState === false)  //集水井提升泵
                {
                    sbrActiveRun215.style.display = "none";
                    sbrActiveStop215.style.display = "block";
                } else {
                    sbrActiveRun215.style.display = "block";
                    sbrActiveStop215.style.display = "none";
                }

                /***************工艺流程设定时间 开始时间*************************/
                //     //sbr一次搅拌
                // var collectWellPumpSTime215 = document.getElementById("collectWellPumpSTime215");
                // collectWellPumpSTime215.innerText = "00:00";
                // //曝气
                // var fan02STime215 = document.getElementById("fan02STime215");
                // fan02STime215.innerText = "00:00";
                // //sbr二次搅拌
                // var collectPumpSTime215 = document.getElementById("collectPumpSTime215");
                // collectPumpSTime215.innerText = "00:00";
                // //静止沉淀
                // var staticSTime215 = document.getElementById("staticSTime215");
                // staticSTime215.innerText = "00:00";
                // //排泥
                // var collectMixerSTime215 = document.getElementById("collectMixerSTime215");
                // collectMixerSTime215.innerText = "00:00";
                // //静置活化
                // var fanMixer01STime215 = document.getElementById("fanMixer01STime215");
                // fanMixer01STime215.innerText = "00:00";

                /***************工艺流程设定时间 时间段*************************/
                    //sbr一次搅拌
                var sbrMixerOnceSetMinute215 = document.getElementById("sbrMixerOnceSetMinute215");
                sbrMixerOnceSetMinute215.innerText = result.sbrMixerOnceSetMinute;
                //曝气
                var fanSetMinute215 = document.getElementById("fanSetMinute215");
                fanSetMinute215.innerText = result.fanSetMinute;
                //sbr二次搅拌
                var sbrMixerSecSetMinute215 = document.getElementById("sbrMixerSecSetMinute215");
                sbrMixerSecSetMinute215.innerText = result.sbrMixerSecSetMinute;
                //静止沉淀
                var sbrStaticSetMinute215 = document.getElementById("sbrStaticSetMinute215");
                sbrStaticSetMinute215.innerText = result.sbrStaticSetMinute;
                //排泥
                var sludgePumpSetMinute215 = document.getElementById("sludgePumpSetMinute215");
                sludgePumpSetMinute215.innerText = result.sludgePumpSetMinute;
                //静置活化
                var sbrActiveSetMinute215 = document.getElementById("sbrActiveSetMinute215");
                sbrActiveSetMinute215.innerText = result.sbrActiveSetMinute;
                /***************公共参数*************************/
                    //集水井液位控制仪高
                var collectWellHighOn215 = document.getElementById("collectWellHighOn215");
                var collectWellHighOff215 = document.getElementById("collectWellHighOff215");
                if (result.collectWellHighOn === false)  //集水井提升泵
                {
                    collectWellHighOn215.style.display = "none";
                    collectWellHighOff215.style.display = "block";
                } else {
                    collectWellHighOn215.style.display = "block";
                    collectWellHighOff215.style.display = "none";
                }
                //集水井液位控制仪低
                var collectWellLowOn215 = document.getElementById("collectWellLowOn215");
                var collectWellLowOff215 = document.getElementById("collectWellLowOff215");
                if (result.collectWellLowOn === false)  //集水井提升泵
                {
                    collectWellLowOn215.style.display = "none";
                    collectWellLowOff215.style.display = "block";
                } else {
                    collectWellLowOn215.style.display = "block";
                    collectWellLowOff215.style.display = "none";
                }
                //集水池液位控制器高
                var collectHighOn215 = document.getElementById("collectHighOn215");
                var collectHighOff215 = document.getElementById("collectHighOff215");
                if (result.collectHighOn === false)  //集水井提升泵
                {
                    collectHighOn215.style.display = "none";
                    collectHighOff215.style.display = "block";
                } else {
                    collectHighOn215.style.display = "block";
                    collectHighOff215.style.display = "none";
                }
                //集水池液位控制器低
                var collectLowOn215 = document.getElementById("collectLowOn215");
                var collectLowOff215 = document.getElementById("collectLowOff215");
                if (result.collectLowOn === false)  //集水井提升泵
                {
                    collectLowOn215.style.display = "none";
                    collectLowOff215.style.display = "block";
                } else {
                    collectLowOn215.style.display = "block";
                    collectLowOff215.style.display = "none";
                }
                //调节池液位控制器高
                var regulatHighOn215 = document.getElementById("regulatHighOn215");
                var regulatHighOff215 = document.getElementById("regulatHighOff215");
                if (result.regulatHighOn === false)  //集水井提升泵
                {
                    regulatHighOn215.style.display = "none";
                    regulatHighOff215.style.display = "block";
                } else {
                    regulatHighOn215.style.display = "block";
                    regulatHighOff215.style.display = "none";
                }
                //调节池液位控制器低
                var regulatLowOn215 = document.getElementById("regulatLowOn215");
                var regulatLowOff215 = document.getElementById("regulatLowOff215");
                if (result.regulatLowOn === false)  //集水井提升泵
                {
                    regulatLowOn215.style.display = "none";
                    regulatLowOff215.style.display = "block";
                } else {
                    regulatLowOn215.style.display = "block";
                    regulatLowOff215.style.display = "none";
                }
                //SBR池液位控制器仪高
                var sbrHighOn215 = document.getElementById("sbrHighOn215");
                var sbrHighOff215 = document.getElementById("sbrHighOff215");
                if (result.sbrHighOn === false)  //集水井提升泵
                {
                    sbrHighOn215.style.display = "none";
                    sbrHighOff215.style.display = "block";
                } else {
                    sbrHighOn215.style.display = "block";
                    sbrHighOff215.style.display = "none";
                }
                //SBR池液位控制器仪低
                var sbrLowOn215 = document.getElementById("sbrLowOn215");
                var sbrLowOff215 = document.getElementById("sbrLowOff215");
                if (result.sbrLowOn === false)  //集水井提升泵
                {
                    sbrLowOn215.style.display = "none";
                    sbrLowOff215.style.display = "block";
                } else {
                    sbrLowOn215.style.display = "block";
                    sbrLowOff215.style.display = "none";
                }
                //排水阀开
                var decanterOnOn215 = document.getElementById("decanterOnOn215");
                var decanterOnOff215 = document.getElementById("decanterOnOff215");
                if (result.decanterOnOK === false)  //集水井提升泵
                {
                    decanterOnOn215.style.display = "none";
                    decanterOnOff215.style.display = "block";
                } else {
                    decanterOnOn215.style.display = "block";
                    decanterOnOff215.style.display = "none";
                }
                //排水阀关
                var decanterOffOn215 = document.getElementById("decanterOffOn215");
                var decanterOffOff215 = document.getElementById("decanterOffOff215");
                if (result.decanterOffOK === false)  //集水井提升泵
                {
                    decanterOffOn215.style.display = "none";
                    decanterOffOff215.style.display = "block";
                } else {
                    decanterOffOn215.style.display = "block";
                    decanterOffOff215.style.display = "none";
                }
                /***************故障状态*************************/
                    //电能表通讯故障
                var elecNormal215 = document.getElementById("elecNormal215");
                var elecFault215 = document.getElementById("elecFault215");
                if (result.elecFault === true)
                {
                    elecNormal215.style.display = "none";
                    elecFault215.style.display = "block";
                } else {
                    elecNormal215.style.display = "block";
                    elecFault215.style.display = "none";
                }
                //空气温度变送器通讯故障
                var airTempNormal215 = document.getElementById("airTempNormal215");
                var airTempFault215 = document.getElementById("airTempFault215");
                if (result.airTempFault === true)
                {
                    airTempNormal215.style.display = "none";
                    airTempFault215.style.display = "block";
                } else {
                    airTempNormal215.style.display = "block";
                    airTempFault215.style.display = "none";
                }
                //SBR水温变送器通讯故障
                var waterTempNormal215 = document.getElementById("waterTempNormal215");
                var waterTempFault215 = document.getElementById("waterTempFault215");
                if (result.waterTempFault === true)
                {
                    waterTempNormal215.style.display = "none";
                    waterTempFault215.style.display = "block";
                } else {
                    waterTempNormal215.style.display = "block";
                    waterTempFault215.style.display = "none";
                }
                //PLC电量不足
                var plcElecNormal215 = document.getElementById("plcElecNormal215");
                var plcElecLack215 = document.getElementById("plcElecLack215");
                if (result.plcElecLack === true)
                {
                    plcElecNormal215.style.display = "none";
                    plcElecLack215.style.display = "block";
                } else {
                    plcElecNormal215.style.display = "block";
                    plcElecLack215.style.display = "none";
                }

                    //机械格栅
                var ydsgsNormal215 = document.getElementById("ydsgsNormal215");
                var ydsgsFault215 = document.getElementById("ydsgsFault215");
                if (result.ydsgsFault === true)  //集水井提升泵
                {
                    ydsgsNormal215.style.display = "none";
                    ydsgsFault215.style.display = "block";
                } else {
                    ydsgsNormal215.style.display = "block";
                    ydsgsFault215.style.display = "none";
                }
                //集水井提升泵
                var collectWellPumpNormal215 = document.getElementById("collectWellPumpNormal215");
                var collectWellPumpFault215 = document.getElementById("collectWellPumpFault215");
                if (result.collectWellPumpFault === true)  //集水井提升泵
                {
                    collectWellPumpNormal215.style.display = "none";
                    collectWellPumpFault215.style.display = "block";
                } else {
                    collectWellPumpNormal215.style.display = "block";
                    collectWellPumpFault215.style.display = "none";
                }
                //集水池搅拌机1
                var collectMixer01Normal215 = document.getElementById("collectMixer01Normal215");
                var collectMixer01Fault215 = document.getElementById("collectMixer01Fault215");
                if (result.collectMixer01Fault === true)  //集水井提升泵
                {
                    collectMixer01Normal215.style.display = "none";
                    collectMixer01Fault215.style.display = "block";
                } else {
                    collectMixer01Normal215.style.display = "block";
                    collectMixer01Fault215.style.display = "none";
                }
                //集水池搅拌机2
                var collectMixer02Normal215 = document.getElementById("collectMixer02Normal215");
                var collectMixer02Fault215 = document.getElementById("collectMixer02Fault215");
                if (result.collectMixer02Fault === true)  //集水井提升泵
                {
                    collectMixer02Normal215.style.display = "none";
                    collectMixer02Fault215.style.display = "block";
                } else {
                    collectMixer02Normal215.style.display = "block";
                    collectMixer02Fault215.style.display = "none";
                }
                //除磷投加机
                var dephosphorizeNormal215 = document.getElementById("dephosphorizeNormal215");
                var dephosphorizeFault215 = document.getElementById("dephosphorizeFault215");
                if (result.dephosphorizeFault === true)  //集水井提升泵
                {
                    dephosphorizeNormal215.style.display = "none";
                    dephosphorizeFault215.style.display = "block";
                } else {
                    dephosphorizeNormal215.style.display = "block";
                    dephosphorizeFault215.style.display = "none";
                }
                //集水池提升泵
                var collectPumpNormal215 = document.getElementById("collectPumpNormal215");
                var collectPumpFault215 = document.getElementById("collectPumpFault215");
                if (result.collectPumpFault === true)  //集水井提升泵
                {
                    collectPumpNormal215.style.display = "none";
                    collectPumpFault215.style.display = "block";
                } else {
                    collectPumpNormal215.style.display = "block";
                    collectPumpFault215.style.display = "none";
                }
                //固液分离机
                var solLiqNormal215 = document.getElementById("solLiqNormal215");
                var solLiqFault215 = document.getElementById("solLiqFault215");
                if (result.solLiqFault === true)  //集水井提升泵
                {
                    solLiqNormal215.style.display = "none";
                    solLiqFault215.style.display = "block";
                } else {
                    solLiqNormal215.style.display = "block";
                    solLiqFault215.style.display = "none";
                }
                //混合池1搅拌机
                var bldMixer01Normal215 = document.getElementById("bldMixer01Normal215");
                var bldMixer01Fault215 = document.getElementById("bldMixer01Fault215");
                if (result.bldMixer01Fault === true)  //集水井提升泵
                {
                    bldMixer01Normal215.style.display = "none";
                    bldMixer01Fault215.style.display = "block";
                } else {
                    bldMixer01Normal215.style.display = "block";
                    bldMixer01Fault215.style.display = "none";
                }
                //混反池1搅拌机
                var bldOpstMixer01Normal215 = document.getElementById("bldOpstMixer01Normal215");
                var bldOpstMixer01Fault215 = document.getElementById("bldOpstMixer01Fault215");
                if (result.bldOpstMixer01Fault === true)  //集水井提升泵
                {
                    bldOpstMixer01Normal215.style.display = "none";
                    bldOpstMixer01Fault215.style.display = "block";
                } else {
                    bldOpstMixer01Normal215.style.display = "block";
                    bldOpstMixer01Fault215.style.display = "none";
                }
                //混沉池污泥泵
                var bldSinkPumpNormal215 = document.getElementById("bldSinkPumpNormal215");
                var bldSinkPumpFault215 = document.getElementById("bldSinkPumpFault215");
                if (result.bldSinkPumpFault === true)  //集水井提升泵
                {
                    bldSinkPumpNormal215.style.display = "none";
                    bldSinkPumpFault215.style.display = "block";
                } else {
                    bldSinkPumpNormal215.style.display = "block";
                    bldSinkPumpFault215.style.display = "none";
                }
                //混凝剂1搅拌机
                var bldCglMixer01Normal215 = document.getElementById("bldCglMixer01Normal215");
                var bldCglMixer01Fault215 = document.getElementById("bldCglMixer01Fault215");
                if (result.bldCglMixer01Fault === true)  //集水井提升泵
                {
                    bldCglMixer01Normal215.style.display = "none";
                    bldCglMixer01Fault215.style.display = "block";
                } else {
                    bldCglMixer01Normal215.style.display = "block";
                    bldCglMixer01Fault215.style.display = "none";
                }

                //混凝剂1加药泵
                var bldCglDosing01Normal215 = document.getElementById("bldCglDosing01Normal215");
                var bldCglDosing01Fault215 = document.getElementById("bldCglDosing01Fault215");
                if (result.bldCglDosing01Fault === true)  //集水井提升泵
                {
                    bldCglDosing01Normal215.style.display = "none";
                    bldCglDosing01Fault215.style.display = "block";
                } else {
                    bldCglDosing01Normal215.style.display = "block";
                    bldCglDosing01Fault215.style.display = "none";
                }
                //助凝剂1搅拌机
                var astCglMixer01Normal215 = document.getElementById("astCglMixer01Normal215");
                var astCglMixer01Fault215 = document.getElementById("astCglMixer01Fault215");
                if (result.astCglMixer01Fault === true)  //集水井提升泵
                {
                    astCglMixer01Normal215.style.display = "none";
                    astCglMixer01Fault215.style.display = "block";
                } else {
                    astCglMixer01Normal215.style.display = "block";
                    astCglMixer01Fault215.style.display = "none";
                }
                //助凝剂1加药泵
                var astCglDosing01Normal215 = document.getElementById("astCglDosing01Normal215");
                var astCglDosing01Fault215 = document.getElementById("astCglDosing01Fault215");
                if (result.astCglDosing01Fault === true)  //集水井提升泵
                {
                    astCglDosing01Normal215.style.display = "none";
                    astCglDosing01Fault215.style.display = "block";
                } else {
                    astCglDosing01Normal215.style.display = "block";
                    astCglDosing01Fault215.style.display = "none";
                }
                //污泥池搅拌机
                var sludgeMixerNormal215 = document.getElementById("sludgeMixerNormal215");
                var sludgeMixerFault215 = document.getElementById("sludgeMixerFault215");
                if (result.sludgeMixerFault === true)  //集水井提升泵
                {
                    sludgeMixerNormal215.style.display = "none";
                    sludgeMixerFault215.style.display = "block";
                } else {
                    sludgeMixerNormal215.style.display = "block";
                    sludgeMixerFault215.style.display = "none";
                }
                //泥水分离机进泥泵
                var slySeprtInPumpNormal215 = document.getElementById("slySeprtInPumpNormal215");
                var slySeprtInPumpFault215 = document.getElementById("slySeprtInPumpFault215");
                if (result.slySeprtInPumpFault === true)  //集水井提升泵
                {
                    slySeprtInPumpNormal215.style.display = "none";
                    slySeprtInPumpFault215.style.display = "block";
                } else {
                    slySeprtInPumpNormal215.style.display = "block";
                    slySeprtInPumpFault215.style.display = "none";
                }
                //絮凝剂加药泵
                var flocltDosingNormal215 = document.getElementById("flocltDosingNormal215");
                var flocltDosingFault215 = document.getElementById("flocltDosingFault215");
                if (result.flocltDosingFault === true)  //集水井提升泵
                {
                    flocltDosingNormal215.style.display = "none";
                    flocltDosingFault215.style.display = "block";
                } else {
                    flocltDosingNormal215.style.display = "block";
                    flocltDosingFault215.style.display = "none";
                }
                //絮凝剂搅拌机
                var flocltMixerNormal215 = document.getElementById("flocltMixerNormal215");
                var flocltMixerFault215 = document.getElementById("flocltMixerFault215");
                if (result.flocltMixerFault === true)  //集水井提升泵
                {
                    flocltMixerNormal215.style.display = "none";
                    flocltMixerFault215.style.display = "block";
                } else {
                    flocltMixerNormal215.style.display = "block";
                    flocltMixerFault215.style.display = "none";
                }
                //泥水分离机
                var slySeprtNormal215 = document.getElementById("slySeprtNormal215");
                var slySeprtFault215 = document.getElementById("slySeprtFault215");
                if (result.slySeprtFault === true)  //集水井提升泵
                {
                    slySeprtNormal215.style.display = "none";
                    slySeprtFault215.style.display = "block";
                } else {
                    slySeprtNormal215.style.display = "block";
                    slySeprtFault215.style.display = "none";
                }
                //调节初沉池污泥泵
                var pmySinkPumpNormal215 = document.getElementById("pmySinkPumpNormal215");
                var pmySinkPumpFault215 = document.getElementById("pmySinkPumpFault215");
                if (result.pmySinkPumpFault === true)  //集水井提升泵
                {
                    pmySinkPumpNormal215.style.display = "none";
                    pmySinkPumpFault215.style.display = "block";
                } else {
                    pmySinkPumpNormal215.style.display = "block";
                    pmySinkPumpFault215.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpNormal215 = document.getElementById("sbrIntakePumpNormal215");
                var sbrIntakePumpFault215 = document.getElementById("sbrIntakePumpFault215");
                if (result.sbrIntakePumpFault === true)  //集水井提升泵
                {
                    sbrIntakePumpNormal215.style.display = "none";
                    sbrIntakePumpFault215.style.display = "block";
                } else {
                    sbrIntakePumpNormal215.style.display = "block";
                    sbrIntakePumpFault215.style.display = "none";
                }

                //风机1
                var fan01Normal215 = document.getElementById("fan01Normal215");
                var fan01Fault215 = document.getElementById("fan01Fault215");
                if (result.fan01Fault === true)  //集水井提升泵
                {
                    fan01Normal215.style.display = "none";
                    fan01Fault215.style.display = "block";
                } else {
                    fan01Normal215.style.display = "block";
                    fan01Fault215.style.display = "none";
                }
                //风机2
                var fan02Normal215 = document.getElementById("fan02Normal215");
                var fan02Fault215 = document.getElementById("fan02Fault215");
                if (result.fan02Fault === true)  //集水井提升泵
                {
                    fan02Normal215.style.display = "none";
                    fan02Fault215.style.display = "block";
                } else {
                    fan02Normal215.style.display = "block";
                    fan02Fault215.style.display = "none";
                }
                //SBR池污泥泵
                var sbrSludegPumpNormal215 = document.getElementById("sbrSludegPumpNormal215");
                var sbrSludegPumpFault215 = document.getElementById("sbrSludegPumpFault215");
                if (result.sbrSludegPumpFault === true)  //集水井提升泵
                {
                    sbrSludegPumpNormal215.style.display = "none";
                    sbrSludegPumpFault215.style.display = "block";
                } else {
                    sbrSludegPumpNormal215.style.display = "block";
                    sbrSludegPumpFault215.style.display = "none";
                }
                //电动排水阀
                var eleDrainNormal215 = document.getElementById("eleDrainNormal215");
                var eleDrainFault215 = document.getElementById("eleDrainFault215");
                if (result.eleDrainFault === true)  //集水井提升泵
                {
                    eleDrainNormal215.style.display = "none";
                    eleDrainFault215.style.display = "block";
                } else {
                    eleDrainNormal215.style.display = "block";
                    eleDrainFault215.style.display = "none";
                }
                //SBR池搅拌机1
                var sbrMixer01Normal215 = document.getElementById("sbrMixer01Normal215");
                var sbrMixer01Fault215 = document.getElementById("sbrMixer01Fault215");
                if (result.sbrMixer01Fault === true)  //集水井提升泵
                {
                    sbrMixer01Normal215.style.display = "none";
                    sbrMixer01Fault215.style.display = "block";
                } else {
                    sbrMixer01Normal215.style.display = "block";
                    sbrMixer01Fault215.style.display = "none";
                }
                //SBR池搅拌机2
                var sbrMixer02Normal215 = document.getElementById("sbrMixer02Normal215");
                var sbrMixer02Fault215 = document.getElementById("sbrMixer02Fault215");
                if (result.sbrMixer02Fault === true)  //集水井提升泵
                {
                    sbrMixer02Normal215.style.display = "none";
                    sbrMixer02Fault215.style.display = "block";
                } else {
                    sbrMixer02Normal215.style.display = "block";
                    sbrMixer02Fault215.style.display = "none";
                }
                //厌氧池进水泵
                var uasbInPumpNormal215 = document.getElementById("uasbInPumpNormal215");
                var uasbInPumpFault215 = document.getElementById("uasbInPumpFault215");
                if (result.uasbInPumpFault === true)  //集水井提升泵
                {
                    uasbInPumpNormal215.style.display = "none";
                    uasbInPumpFault215.style.display = "block";
                } else {
                    uasbInPumpNormal215.style.display = "block";
                    uasbInPumpFault215.style.display = "none";
                }
                //内回流泵
                var inBfPumpNormal215 = document.getElementById("inBfPumpNormal215");
                var inBfPumpFault215 = document.getElementById("inBfPumpFault215");
                if (result.inBfPumpFault === true)  //集水井提升泵
                {
                    inBfPumpNormal215.style.display = "none";
                    inBfPumpFault215.style.display = "block";
                } else {
                    inBfPumpNormal215.style.display = "block";
                    inBfPumpFault215.style.display = "none";
                }
                //外回流泵
                var outBfPumpNormal215 = document.getElementById("outBfPumpNormal215");
                var outBfPumpFault215 = document.getElementById("outBfPumpFault215");
                if (result.outBfPumpFault === true)  //集水井提升泵
                {
                    outBfPumpNormal215.style.display = "none";
                    outBfPumpFault215.style.display = "block";
                } else {
                    outBfPumpNormal215.style.display = "block";
                    outBfPumpFault215.style.display = "none";
                }
                //厌氧池搅拌机
                var uasbMixerNormal215 = document.getElementById("uasbMixerNormal215");
                var uasbMixerFault215 = document.getElementById("uasbMixerFault215");
                if (result.uasbMixerFault === true)  //集水井提升泵
                {
                    uasbMixerNormal215.style.display = "none";
                    uasbMixerFault215.style.display = "block";
                } else {
                    uasbMixerNormal215.style.display = "block";
                    uasbMixerFault215.style.display = "none";
                }

                //缺氧池搅拌机
                var anoxiaMixerNormal215 = document.getElementById("anoxiaMixerNormal215");
                var anoxiaMixerFault215 = document.getElementById("anoxiaMixerFault215");
                if (result.anoxiaMixerFault === true)  //集水井提升泵
                {
                    anoxiaMixerNormal215.style.display = "none";
                    anoxiaMixerFault215.style.display = "block";
                } else {
                    anoxiaMixerNormal215.style.display = "block";
                    anoxiaMixerFault215.style.display = "none";
                }
                //二沉池污泥泵
                var secSinkPumpNormal215 = document.getElementById("secSinkPumpNormal215");
                var secSinkPumpFault215 = document.getElementById("secSinkPumpFault215");
                if (result.secSinkPumpFault === true)  //集水井提升泵
                {
                    secSinkPumpNormal215.style.display = "none";
                    secSinkPumpFault215.style.display = "block";
                } else {
                    secSinkPumpNormal215.style.display = "block";
                    secSinkPumpFault215.style.display = "none";
                }
                //混凝剂2搅拌机
                var bldCglMixer02Normal215 = document.getElementById("bldCglMixer02Normal215");
                var bldCglMixer02Fault215 = document.getElementById("bldCglMixer02Fault215");
                if (result.bldCglMixer02Fault === true)  //集水井提升泵
                {
                    bldCglMixer02Normal215.style.display = "none";
                    bldCglMixer02Fault215.style.display = "block";
                } else {
                    bldCglMixer02Normal215.style.display = "block";
                    bldCglMixer02Fault215.style.display = "none";
                }
                //助凝剂2搅拌机
                var astCglMixer02Normal215 = document.getElementById("astCglMixer02Normal215");
                var astCglMixer02Fault215 = document.getElementById("astCglMixer02Fault215");
                if (result.astCglMixer02Fault === true)  //集水井提升泵
                {
                    astCglMixer02Normal215.style.display = "none";
                    astCglMixer02Fault215.style.display = "block";
                } else {
                    astCglMixer02Normal215.style.display = "block";
                    astCglMixer02Fault215.style.display = "none";
                }
                //除磷剂搅拌机
                var ppRmvMixerNormal215 = document.getElementById("ppRmvMixerNormal215");
                var ppRmvMixerFault215 = document.getElementById("ppRmvMixerFault215");
                if (result.ppRmvMixerFault === true)  //集水井提升泵
                {
                    ppRmvMixerNormal215.style.display = "none";
                    ppRmvMixerFault215.style.display = "block";
                } else {
                    ppRmvMixerNormal215.style.display = "block";
                    ppRmvMixerFault215.style.display = "none";
                }
                //混凝剂2加药泵
                var bldCglDosing02Normal215 = document.getElementById("bldCglDosing02Normal215");
                var bldCglDosing02Fault215 = document.getElementById("bldCglDosing02Fault215");
                if (result.bldCglDosing02Fault === true)  //集水井提升泵
                {
                    bldCglDosing02Normal215.style.display = "none";
                    bldCglDosing02Fault215.style.display = "block";
                } else {
                    bldCglDosing02Normal215.style.display = "block";
                    bldCglDosing02Fault215.style.display = "none";
                }
                //助凝剂2加药泵
                var astCglDosing02Normal215 = document.getElementById("astCglDosing02Normal215");
                var astCglDosing02Fault215 = document.getElementById("astCglDosing02Fault215");
                if (result.astCglDosing02Fault === true)  //集水井提升泵
                {
                    astCglDosing02Normal215.style.display = "none";
                    astCglDosing02Fault215.style.display = "block";
                } else {
                    astCglDosing02Normal215.style.display = "block";
                    astCglDosing02Fault215.style.display = "none";
                }
                //除磷剂加药泵
                var ppRmvDosingNormal215 = document.getElementById("ppRmvDosingNormal215");
                var ppRmvDosingFault215 = document.getElementById("ppRmvDosingFault215");
                if (result.ppRmvDosingFault === true)  //集水井提升泵
                {
                    ppRmvDosingNormal215.style.display = "none";
                    ppRmvDosingFault215.style.display = "block";
                } else {
                    ppRmvDosingNormal215.style.display = "block";
                    ppRmvDosingFault215.style.display = "none";
                }
                //混反池2搅拌机
                var bldOpstMixer02Normal215 = document.getElementById("bldOpstMixer02Normal215");
                var bldOpstMixer02Fault215 = document.getElementById("bldOpstMixer02Fault215");
                if (result.bldOpstMixer02Fault === true)  //集水井提升泵
                {
                    bldOpstMixer02Normal215.style.display = "none";
                    bldOpstMixer02Fault215.style.display = "block";
                } else {
                    bldOpstMixer02Normal215.style.display = "block";
                    bldOpstMixer02Fault215.style.display = "none";
                }
                //混合池2搅拌机
                var bldMixer02Normal215 = document.getElementById("bldMixer02Normal215");
                var bldMixer02Fault215 = document.getElementById("bldMixer02Fault215");
                if (result.bldMixer02Fault === true)  //集水井提升泵
                {
                    bldMixer02Normal215.style.display = "none";
                    bldMixer02Fault215.style.display = "block";
                } else {
                    bldMixer02Normal215.style.display = "block";
                    bldMixer02Fault215.style.display = "none";
                }

                //除磷池搅拌机
                var ppRmvTankMixerNormal215 = document.getElementById("ppRmvTankMixerNormal215");
                var ppRmvTankMixerFault215 = document.getElementById("ppRmvTankMixerFault215");
                if (result.ppRmvTankMixerFault === true)  //集水井提升泵
                {
                    ppRmvTankMixerNormal215.style.display = "none";
                    ppRmvTankMixerFault215.style.display = "block";
                } else {
                    ppRmvTankMixerNormal215.style.display = "block";
                    ppRmvTankMixerFault215.style.display = "none";
                }
                //终沉池污泥泵
                var finalSinkPumpNormal215 = document.getElementById("finalSinkPumpNormal215");
                var finalSinkPumpFault215 = document.getElementById("finalSinkPumpFault215");
                if (result.finalSinkPumpFault === true)  //集水井提升泵
                {
                    finalSinkPumpNormal215.style.display = "none";
                    finalSinkPumpFault215.style.display = "block";
                } else {
                    finalSinkPumpNormal215.style.display = "block";
                    finalSinkPumpFault215.style.display = "none";
                }


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



function rdlSelectDeviceByTreeIdSewageC215() {

    $('#rdlSwgC215DeviceList').bootstrapTable('destroy');

    $('#rdlSwgC215DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectSwgC215ByORGId",
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
        columns: rdlSewageC215TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

function formatTime215(value) {
    if (value.toString().length === 1)
        return "0" + value.toString();
    return value.toString();
}

//************************SewageC215 end******************************/