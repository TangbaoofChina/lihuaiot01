//************************SewageC01 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC01(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSewageC01ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRun = document.getElementById("collectMixerRun");
                var collectMixerStop = document.getElementById("collectMixerStop");
                //除磷投加机
                var dephosphorizeRun = document.getElementById("dephosphorizeRun");
                var dephosphorizeStop = document.getElementById("dephosphorizeStop");
                //集水池提升泵
                var collectPumpRun = document.getElementById("collectPumpRun");
                var collectPumpStop = document.getElementById("collectPumpStop");
                //污泥泵1
                var sludgePump01Run = document.getElementById("sludgePump01Run");
                var sludgePump01Stop = document.getElementById("sludgePump01Stop");
                if (result.collectMixerRun === false)  //集水池搅拌机
                {
                    collectMixerRun.style.display = "none";
                    collectMixerStop.style.display = "block";
                } else {
                    collectMixerRun.style.display = "block";
                    collectMixerStop.style.display = "none";
                }
                if (result.dephosphorizeRun === false)  //除磷投加机
                {
                    dephosphorizeRun.style.display = "none";
                    dephosphorizeStop.style.display = "block";
                } else {
                    dephosphorizeRun.style.display = "block";
                    dephosphorizeStop.style.display = "none";
                }
                if (result.collectPumpRun === false)  //集水池提升泵
                {
                    collectPumpRun.style.display = "none";
                    collectPumpStop.style.display = "block";
                } else {
                    collectPumpRun.style.display = "block";
                    collectPumpStop.style.display = "none";
                }
                if (result.sludgePump01Run === false)  //污泥泵1
                {
                    sludgePump01Run.style.display = "none";
                    sludgePump01Stop.style.display = "block";
                } else {
                    sludgePump01Run.style.display = "block";
                    sludgePump01Stop.style.display = "none";
                }
                /*************SBR污水处理控制系统***************/
                    //SBR池进水泵
                var sbrIntakePumpRun = document.getElementById("sbrIntakePumpRun");
                var sbrIntakePumpStop = document.getElementById("sbrIntakePumpStop");
                //SBR池搅拌机
                var sbrMixerRun = document.getElementById("sbrMixerRun");
                var sbrMixerStop = document.getElementById("sbrMixerStop");
                //回转式风机1
                var fan01Run = document.getElementById("fan01Run");
                var fan01Stop = document.getElementById("fan01Stop");
                //回转式风机2
                var fan02Run = document.getElementById("fan02Run");
                var fan02Stop = document.getElementById("fan02Stop");
                //SBR曝气
                var fanRun = document.getElementById("fanRun");
                var fanStop = document.getElementById("fanStop");
                //SBR污泥泵2
                var sludgePump02Run = document.getElementById("sludgePump02Run");
                var sludgePump02Stop = document.getElementById("sludgePump02Stop");
                //滗水器设备
                var decanterRun = document.getElementById("decanterRun");
                var decanterStop = document.getElementById("decanterStop");

                if (result.sbrIntakePumpRun === false)  //SBR池进水泵
                {
                    sbrIntakePumpRun.style.display = "none";
                    sbrIntakePumpStop.style.display = "block";
                } else {
                    sbrIntakePumpRun.style.display = "block";
                    sbrIntakePumpStop.style.display = "none";
                }
                if (result.sbrMixerRun === false)  //SBR池搅拌机
                {
                    sbrMixerRun.style.display = "none";
                    sbrMixerStop.style.display = "block";
                } else {
                    sbrMixerRun.style.display = "block";
                    sbrMixerStop.style.display = "none";
                }
                if (result.fan01Run === false)  //回转式风机1
                {
                    fan01Run.style.display = "none";
                    fan01Stop.style.display = "block";
                } else {
                    fan01Run.style.display = "block";
                    fan01Stop.style.display = "none";
                }
                if (result.fan02Run === false)  //回转式风机2
                {
                    fan02Run.style.display = "none";
                    fan02Stop.style.display = "block";
                } else {
                    fan02Run.style.display = "block";
                    fan02Stop.style.display = "none";
                }
                //SBR曝气
                if (result.fan01Run === false && result.fan02Run === false) {
                    fanRun.style.display = "none";
                    fanStop.style.display = "block";
                } else {
                    fanRun.style.display = "block";
                    fanStop.style.display = "none";
                }
                if (result.sludgePump02Run === false)  //SBR污泥泵2
                {
                    sludgePump02Run.style.display = "none";
                    sludgePump02Stop.style.display = "block";
                } else {
                    sludgePump02Run.style.display = "block";
                    sludgePump02Stop.style.display = "none";
                }
                if (result.decanterRun === false)  //滗水器
                {
                    decanterRun.style.display = "none";
                    decanterStop.style.display = "block";
                } else {
                    decanterRun.style.display = "block";
                    decanterStop.style.display = "none";
                }

                //SBR池一次搅拌
                var sbrMixerOnceRun = document.getElementById("sbrMixerOnceRun");
                var sbrMixerOnceStop = document.getElementById("sbrMixerOnceStop");
                if (result.sbrMixerOnceRun === false)  //SBR池一次搅拌
                {
                    sbrMixerOnceRun.style.display = "none";
                    sbrMixerOnceStop.style.display = "block";
                } else {
                    sbrMixerOnceRun.style.display = "block";
                    sbrMixerOnceStop.style.display = "none";
                }

                //SBR二次搅拌
                var sbrMixerSecRun = document.getElementById("sbrMixerSecRun");
                var sbrMixerSecStop = document.getElementById("sbrMixerSecStop");
                if (result.sbrMixerSecRun === false)  //SBR池一次搅拌
                {
                    sbrMixerSecRun.style.display = "none";
                    sbrMixerSecStop.style.display = "block";
                } else {
                    sbrMixerSecRun.style.display = "block";
                    sbrMixerSecStop.style.display = "none";
                }

                //SBR静置
                var sbrStaticRun = document.getElementById("sbrStaticRun");
                var sbrStaticStop = document.getElementById("sbrStaticStop");
                if (result.sbrStaticRun === false)  //SBR池一次搅拌
                {
                    sbrStaticRun.style.display = "none";
                    sbrStaticStop.style.display = "block";
                } else {
                    sbrStaticRun.style.display = "block";
                    sbrStaticStop.style.display = "none";
                }

                //滗水器周期
                var decanterCycleRun = document.getElementById("decanterCycleRun");
                var decanterCycleStop = document.getElementById("decanterCycleStop");
                if (result.decanterCycleRun === false)  //SBR池一次搅拌
                {
                    decanterCycleRun.style.display = "none";
                    decanterCycleStop.style.display = "block";
                } else {
                    decanterCycleRun.style.display = "block";
                    decanterCycleStop.style.display = "none";
                }

                //SBR活化
                var sbrActiveRun = document.getElementById("sbrActiveRun");
                var sbrActiveStop = document.getElementById("sbrActiveStop");
                if (result.sbrActiveRun === false)  //SBR池一次搅拌
                {
                    sbrActiveRun.style.display = "none";
                    sbrActiveStop.style.display = "block";
                } else {
                    sbrActiveRun.style.display = "block";
                    sbrActiveStop.style.display = "none";
                }

                //水流量
                var flowmeter = document.getElementById("flowmeter");
                //时间
                var sewagec01sendDate = document.getElementById("sewagec01sendDate");
                //水流量
                flowmeter.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec01sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter = document.getElementById("todayFlowmeter");
                //当日水流量
                todayFlowmeter.innerHTML = result.todayFlowmeter + "m³";

                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRunMinute = document.getElementById("collectMixerRunMinute");
                //除磷投加机
                var dephosphorizeRunMinute = document.getElementById("dephosphorizeRunMinute");
                //集水池提升泵
                var collectPumpRunMinute = document.getElementById("collectPumpRunMinute");
                //污泥泵1
                var sludgePump01RunMinute = document.getElementById("sludgePump01RunMinute");
                //集水池搅拌机
                collectMixerRunMinute.innerText = result.collectMixerRunMinute;
                //除磷投加机
                dephosphorizeRunMinute.innerText = result.dephosphorizeRunMinute;
                //集水池提升泵
                collectPumpRunMinute.innerText = result.collectPumpRunMinute;
                //污泥泵1
                sludgePump01RunMinute.innerText = result.sludgePump01RunMinute;
                /*************SBR污水处理控制系统***************/
                    //SBR池进水泵
                var sbrIntakePumpRunMinute = document.getElementById("sbrIntakePumpRunMinute");
                //SBR一次搅拌
                var sbrMixerOnceRunMinute = document.getElementById("sbrMixerOnceRunMinute");
                //SBR曝气
                var fanRunMinute = document.getElementById("fanRunMinute");
                //SBR混合
                var sbrMixerRunMinute = document.getElementById("sbrMixerRunMinute");
                //SBR静置
                var sbrStaticRunMinute = document.getElementById("sbrStaticRunMinute");
                //SBR污泥泵2
                var sludgePump02RunMinute = document.getElementById("sludgePump02RunMinute");
                //SBR活化
                var sbrActiveRunMinute = document.getElementById("sbrActiveRunMinute");
                //SBR池进水泵
                sbrIntakePumpRunMinute.innerText = result.sbrIntakePumpRunMinute;
                //SBR一次搅拌
                sbrMixerOnceRunMinute.innerText = result.sbrMixerOnceRunMinute;
                //SBR曝气
                fanRunMinute.innerText = result.fanRunMinute;
                //SBR混合
                sbrMixerRunMinute.innerText = result.sbrMixerRunMinute;
                //SBR静置
                sbrStaticRunMinute.innerText = result.sbrStaticRunMinute;
                //SBR污泥泵2
                sludgePump02RunMinute.innerText = result.sludgePump02RunMinute;
                //SBR活化
                sbrActiveRunMinute.innerText = result.sbrActiveRunMinute;
                /***************工艺流程设定时间*************************/
                    //除磷投加机
                var dephosphorizeSetMinute = document.getElementById("dephosphorizeSetMinute");
                dephosphorizeSetMinute.innerText = result.dephosphorizeSetMinute;
                //污泥泵1
                var sludgePump01SetMinute = document.getElementById("sludgePump01SetMinute");
                sludgePump01SetMinute.innerText = result.sludgePump01SetMinute;
                //SBR设定时间
                var sbrCycleSetMinute = document.getElementById("sbrCycleSetMinute");
                sbrCycleSetMinute.innerText = result.sbrCycleSetMinute;
                //SBR一次搅拌
                var sbrMixerOnceSetMinute = document.getElementById("sbrMixerOnceSetMinute");
                sbrMixerOnceSetMinute.innerText = result.sbrMixerOnceSetMinute;
                //SBR曝气
                var fanSetMinute = document.getElementById("fanSetMinute");
                fanSetMinute.innerText = result.fanSetMinute;
                //SBR混合
                var sbrMixerSetMinute = document.getElementById("sbrMixerSetMinute");
                sbrMixerSetMinute.innerText = result.sbrMixerSetMinute;
                //SBR静置
                var sbrStaticSetMinute = document.getElementById("sbrStaticSetMinute");
                sbrStaticSetMinute.innerText = result.sbrStaticSetMinute;
                //SBR污泥泵2
                var sludgePump02SetMinute = document.getElementById("sludgePump02SetMinute");
                sludgePump02SetMinute.innerText = result.sludgePump02SetMinute;
                //SBR活化
                var sbrActiveSetMinute = document.getElementById("sbrActiveSetMinute");
                sbrActiveSetMinute.innerText = result.sbrActiveSetMinute;
                /***************公共参数*************************/
                    //系统自动模式
                var systemAutoRun = document.getElementById("systemAutoRun");
                var systemAutoStop = document.getElementById("systemAutoStop");
                if (result.systemAuto === false) {
                    systemAutoRun.style.display = "none";
                    systemAutoStop.style.display = "block";
                } else {
                    systemAutoRun.style.display = "block";
                    systemAutoStop.style.display = "none";
                }
                //SBR周期运行
                var sbrCycleRun = document.getElementById("sbrCycleRun");
                var sbrCycleStop = document.getElementById("sbrCycleStop");
                if (result.sbrCycle === false) {
                    sbrCycleRun.style.display = "none";
                    sbrCycleStop.style.display = "block";
                } else {
                    sbrCycleRun.style.display = "block";
                    sbrCycleStop.style.display = "none";
                }
                //集水池液位高
                var collectHighOn = document.getElementById("collectHighOn");
                var collectHighOff = document.getElementById("collectHighOff");
                if (result.collectHighOn === false) {
                    collectHighOn.style.display = "none";
                    collectHighOff.style.display = "block";
                } else {
                    collectHighOn.style.display = "block";
                    collectHighOff.style.display = "none";
                }
                //集水池液位低
                var collectLowOn = document.getElementById("collectLowOn");
                var collectLowOff = document.getElementById("collectLowOff");
                if (result.collectLowOn === false) {
                    collectLowOn.style.display = "none";
                    collectLowOff.style.display = "block";
                } else {
                    collectLowOn.style.display = "block";
                    collectLowOff.style.display = "none";
                }
                //调节池液位高
                var regulatHighOn = document.getElementById("regulatHighOn");
                var regulatHighOff = document.getElementById("regulatHighOff");
                if (result.regulatHighOn === false) {
                    regulatHighOn.style.display = "none";
                    regulatHighOff.style.display = "block";
                } else {
                    regulatHighOn.style.display = "block";
                    regulatHighOff.style.display = "none";
                }
                //调节池液位低
                var regulatLowOn = document.getElementById("regulatLowOn");
                var regulatLowOff = document.getElementById("regulatLowOff");
                if (result.regulatLowOn === false) {
                    regulatLowOn.style.display = "none";
                    regulatLowOff.style.display = "block";
                } else {
                    regulatLowOn.style.display = "block";
                    regulatLowOff.style.display = "none";
                }
                //SBR池液位高
                var sbrHighOn = document.getElementById("sbrHighOn");
                var sbrHighOff = document.getElementById("sbrHighOff");
                if (result.sbrHighOn === false) {
                    sbrHighOn.style.display = "none";
                    sbrHighOff.style.display = "block";
                } else {
                    sbrHighOn.style.display = "block";
                    sbrHighOff.style.display = "none";
                }
                //SBR池液位低
                var sbrLowOn = document.getElementById("sbrLowOn");
                var sbrLowOff = document.getElementById("sbrLowOff");
                if (result.sbrLowOn === false) {
                    sbrLowOn.style.display = "none";
                    sbrLowOff.style.display = "block";
                } else {
                    sbrLowOn.style.display = "block";
                    sbrLowOff.style.display = "none";
                }
                /***************故障状态*************************/
                    //集水池搅拌机
                var collectMixerNormal = document.getElementById("collectMixerNormal");
                var collectMixerFault = document.getElementById("collectMixerFault");
                if (result.collectMixerFault === true) {
                    collectMixerNormal.style.display = "none";
                    collectMixerFault.style.display = "block";
                } else {
                    collectMixerNormal.style.display = "block";
                    collectMixerFault.style.display = "none";
                }
                //集水池提升泵
                var collectPumpNormal = document.getElementById("collectPumpNormal");
                var collectPumpFault = document.getElementById("collectPumpFault");
                if (result.collectPumpFault === true) {
                    collectPumpNormal.style.display = "none";
                    collectPumpFault.style.display = "block";
                } else {
                    collectPumpNormal.style.display = "block";
                    collectPumpFault.style.display = "none";
                }
                //污泥泵1
                var sludgePump01Normal = document.getElementById("sludgePump01Normal");
                var sludgePump01Fault = document.getElementById("sludgePump01Fault");
                if (result.sludgePump01Fault === true) {
                    sludgePump01Normal.style.display = "none";
                    sludgePump01Fault.style.display = "block";
                } else {
                    sludgePump01Normal.style.display = "block";
                    sludgePump01Fault.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpNormal = document.getElementById("sbrIntakePumpNormal");
                var sbrIntakePumpFault = document.getElementById("sbrIntakePumpFault");
                if (result.sbrIntakePumpFault === true) {
                    sbrIntakePumpNormal.style.display = "none";
                    sbrIntakePumpFault.style.display = "block";
                } else {
                    sbrIntakePumpNormal.style.display = "block";
                    sbrIntakePumpFault.style.display = "none";
                }
                //SBR池搅拌机1
                var sbrMixer01Normal = document.getElementById("sbrMixer01Normal");
                var sbrMixer01Fault = document.getElementById("sbrMixer01Fault");
                if (result.sbrMixer01Fault === true) {
                    sbrMixer01Normal.style.display = "none";
                    sbrMixer01Fault.style.display = "block";
                } else {
                    sbrMixer01Normal.style.display = "block";
                    sbrMixer01Fault.style.display = "none";
                }
                //SBR池搅拌机2
                var sbrMixer02Normal = document.getElementById("sbrMixer02Normal");
                var sbrMixer02Fault = document.getElementById("sbrMixer02Fault");
                if (result.sbrMixer02Fault === true) {
                    sbrMixer02Normal.style.display = "none";
                    sbrMixer02Fault.style.display = "block";
                } else {
                    sbrMixer02Normal.style.display = "block";
                    sbrMixer02Fault.style.display = "none";
                }
                //回转式风机1
                var fan01Normal = document.getElementById("fan01Normal");
                var fan01Fault = document.getElementById("fan01Fault");
                if (result.fan01Fault === true) {
                    fan01Normal.style.display = "none";
                    fan01Fault.style.display = "block";
                } else {
                    fan01Normal.style.display = "block";
                    fan01Fault.style.display = "none";
                }
                //回转式风机2
                var fan02Normal = document.getElementById("fan02Normal");
                var fan02Fault = document.getElementById("fan02Fault");
                if (result.fan02Fault === true) {
                    fan02Normal.style.display = "none";
                    fan02Fault.style.display = "block";
                } else {
                    fan02Normal.style.display = "block";
                    fan02Fault.style.display = "none";
                }
                //污泥泵2
                var sludgePump02Normal = document.getElementById("sludgePump02Normal");
                var sludgePump02Fault = document.getElementById("sludgePump02Fault");
                if (result.sludgePump02Fault === true) {
                    sludgePump02Normal.style.display = "none";
                    sludgePump02Fault.style.display = "block";
                } else {
                    sludgePump02Normal.style.display = "block";
                    sludgePump02Fault.style.display = "none";
                }
                //滗水器
                var decanterNormal = document.getElementById("decanterNormal");
                var decanterFault = document.getElementById("decanterFault");
                if (result.decanterFault === true) {
                    decanterNormal.style.display = "none";
                    decanterFault.style.display = "block";
                } else {
                    decanterNormal.style.display = "block";
                    decanterFault.style.display = "none";
                }
                //PLC电量
                var plcElecNormal = document.getElementById("plcElecNormal");
                var plcElecLack = document.getElementById("plcElecLack");
                if (result.plcElecLack === true) {
                    plcElecNormal.style.display = "none";
                    plcElecLack.style.display = "block";
                } else {
                    plcElecNormal.style.display = "block";
                    plcElecLack.style.display = "none";
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



function rdlSelectDeviceByTreeIdSewageC01() {

    $('#rdlSewageC01DeviceList').bootstrapTable('destroy');

    $('#rdlSewageC01DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectSewageC01ByORGId",
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
        columns: rdlSewageC01TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************SewageC01 end******************************/