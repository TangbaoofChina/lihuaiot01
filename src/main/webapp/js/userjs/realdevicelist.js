var rdlNowTreeNode;
var rdlTableColumns;
var rdlTreeNodes;
var realid_of_setintervalDeviceList;
var realid_of_setintervalDeviceOne;
$(function () {
    rdlInitTreeNode();
    rdlInitTable();
    rdlExportStorageAction();
    //定时刷新数据
    realid_of_setintervalDeviceList = setInterval(function () {
        rdlTableRefresh();
    }, 3000);
    realid_of_setintervalDeviceOne = setInterval(function () {
        rdlSelectInfoByDeviceId();
    }, 3000);
})

function rdlInitTreeNode() {
    // Some logic to retrieve, or generate tree structure
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/selectORGAndDeviceTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                var json = eval(result); //数组
                rdlTreeNodes = json;
                /*console.log(rdlTreeNodes);*/
                $('#rdlOrgTree').treeview({
                    data: rdlTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: rdlNodeSelected,
                });
            } else {
                //alert("未查询到树形组织数据");
                var type = 'warning';
                var msg = '未查询到树形组织数据';
                var append = '对不起，未查询到您要的树形组织数据';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //alert(XMLHttpRequest.status);
            handleAjaxError(XMLHttpRequest.status);
            //alert(XMLHttpRequest.readyState);
            //alert(textStatus);
        }
    });
}

function rdlSearchTreeNode() {
    var txtSearch = document.getElementById("rdlTxtSearchTreeNode").value;
    $('#rdlOrgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes
            }]);
}

function rdlNodeSelected(event, data) {
    rdlNowTreeNode = data;
    $('#rdlOrgTree').treeview('clearSearch');
    var queryParameter = rdlNowTreeNode.id;
    var ui1 = document.getElementById("rdlDeviceListDiv");
    var ui2 = document.getElementById("rdlOneDeviceDiv");
    if (queryParameter.length == 4) {
        ui1.style.display = "none";
        ui2.style.display = "block";
    }
    else {
        ui1.style.display = "block";
        ui2.style.display = "none";
    }
    if (data.nodes != null) {
        var select_node = $('#rdlOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#rdlOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#rdlOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    rdlSelectDeviceByTreeId();
    rdlSelectInfoByDeviceId();
}

function rdlSelectInfoByDeviceId() {
    if(typeof(rdlNowTreeNode)=="undefined")
        return;
    var wetCurtainMotorOpen = document.getElementById("wetCurtainMotorOpen");
    if(wetCurtainMotorOpen === null)
        return;
    var queryParameter = rdlNowTreeNode.id;
    if (queryParameter.length !== 4) {
        return;
    }
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectEC01ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                console.log(result);
                var wetCurtainMotorOpen = document.getElementById("wetCurtainMotorOpen");
                var wetCurtainMotorClose = document.getElementById("wetCurtainMotorClose");
                var wetCurtainWPOpen = document.getElementById("wetCurtainWPOpen");
                var wetCurtainWPClose = document.getElementById("wetCurtainWPClose");
                var boilerOpen = document.getElementById("boilerOpen");
                var boilerClose = document.getElementById("boilerClose");
                var fan01Open = document.getElementById("fan01Open");
                var fan01Close = document.getElementById("fan01Close");
                var fan02Open = document.getElementById("fan02Open");
                var fan02Close = document.getElementById("fan02Close");
                var fan03Open = document.getElementById("fan03Open");
                var fan03Close = document.getElementById("fan03Close");
                var fan04Open = document.getElementById("fan04Open");
                var fan04Close = document.getElementById("fan04Close");
                var fan05Open = document.getElementById("fan05Open");
                var fan05Close = document.getElementById("fan05Close");
                if (result.wetCurtainMotorOn === 0)  //湿帘电机
                {
                    wetCurtainMotorOpen.style.display = "none";
                    wetCurtainMotorClose.style.display = "block";
                } else {
                    wetCurtainMotorOpen.style.display = "block";
                    wetCurtainMotorClose.style.display = "none";
                }
                if (result.wetCurtainWPEnable === 0)  //湿帘水泵
                {
                    wetCurtainWPOpen.style.display = "none";
                    wetCurtainWPClose.style.display = "block";
                } else {
                    wetCurtainWPOpen.style.display = "block";
                    wetCurtainWPClose.style.display = "none";
                }
                if (result.boilerOn === 0)  //锅炉
                {
                    boilerOpen.style.display = "none";
                    boilerClose.style.display = "block";
                } else {
                    boilerOpen.style.display = "block";
                    boilerClose.style.display = "none";
                }
                if (result.fan1On === 0)  //风机1
                {
                    fan01Open.style.display = "none";
                    fan01Close.style.display = "block";
                } else {
                    fan01Open.style.display = "block";
                    fan01Close.style.display = "none";
                }
                if (result.fan2On === 0)  //风机2
                {
                    fan02Open.style.display = "none";
                    fan02Close.style.display = "block";
                } else {
                    fan02Open.style.display = "block";
                    fan02Close.style.display = "none";
                }
                if (result.fan3On === 0)  //风机3
                {
                    fan03Open.style.display = "none";
                    fan03Close.style.display = "block";
                } else {
                    fan03Open.style.display = "block";
                    fan03Close.style.display = "none";
                }
                if (result.fan4On === 0)  //风机4
                {
                    fan04Open.style.display = "none";
                    fan04Close.style.display = "block";
                } else {
                    fan04Open.style.display = "block";
                    fan04Close.style.display = "none";
                }
                if (result.fan5On === 0)  //风机5
                {
                    fan05Open.style.display = "none";
                    fan05Close.style.display = "block";
                } else {
                    fan05Open.style.display = "block";
                    fan05Close.style.display = "none";
                }
                var inTemp1 = document.getElementById("inTemp1");
                var inTemp2 = document.getElementById("inTemp2");
                var inTemp3 = document.getElementById("inTemp3");
                var outTemp = document.getElementById("outTemp");
                var boilerTemp = document.getElementById("boilerTemp");
                var avgTemp = document.getElementById("avgTemp");
                var humidityVal = document.getElementById("humidityVal");
                var nh3Val = document.getElementById("nh3Val");
                var co2Val = document.getElementById("co2Val");
                inTemp1.innerHTML = result.inTemp1 + " ℃";
                inTemp2.innerHTML = result.inTemp2 + " ℃";
                inTemp3.innerHTML = result.inTemp3 + " ℃";
                outTemp.innerHTML = result.outTemp4 + " ℃";
                boilerTemp.innerHTML = result.boilerTemp5 + " ℃";
                avgTemp.innerHTML = result.inAveTemp + " ℃";
                humidityVal.innerHTML = result.humidityVal + " %";
                nh3Val.innerHTML = result.nh3Val + " ppm";
                co2Val.innerHTML = result.co2Val + " ppm";

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
            //alert(XMLHttpRequest.status);
            handleAjaxError(XMLHttpRequest.status);
            //alert(XMLHttpRequest.readyState);
            //alert(textStatus);
        }
    });
}


function rdlInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/ec01DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                if (json[i].data === "dState") {
                    temp = {
                        field: json[i].data,
                        title: json[i].title,
                        align: json[i].align,
                        formatter: rdlChangeTableColor
                    };//手动拼接columns
                } else {
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlTableColumns = questionColumns;
            $('#rdlDeviceList').bootstrapTable('destroy');
            $('#rdlDeviceList').bootstrapTable({
                columns: questionColumns,
            });
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//请求服务数据时所传参数
function rdlQueryParams(params) {
    var queryParameter = rdlNowTreeNode.id;
    return {
        sORGId: queryParameter,
    };
}

// 表格刷新
function rdlTableRefresh() {
    if(typeof(rdlNowTreeNode)=="undefined")
        return;
    var rdlDeviceList = document.getElementById("rdlDeviceList");
    if(rdlDeviceList === null)
        return;
    var queryParameter = rdlNowTreeNode.id;
    if (queryParameter.length === 4) {
        return;
    }
    try {
        $('#rdlDeviceList').bootstrapTable('refresh', {
            query: {},
            silent: true,
        });
    }
    catch(err){
        if (realid_of_setintervalDeviceList !== undefined) {
            clearInterval(realid_of_setintervalDeviceList);
        }
        var type = 'error';
        var msg = '实时数据列表定时刷新出错';
        var append = '对不起，实时数据列表定时刷新出错:'+err;
        showMsg(type, msg, append);
    }

}

function rdlSelectDeviceByTreeId() {

    $('#rdlDeviceList').bootstrapTable('destroy');

    $('#rdlDeviceList').bootstrapTable({
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
        pageSize: 4,
        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns : true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectEC01ByORGId",
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
        columns: rdlTableColumns,
    });
}

function rdlChangeTableColor(value, row, index) {
    //通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
    var a = "";
    if (value == "在线") {
        var a = '<span style="color:#00ff00">' + value + '</span>';
    } else if (value == "已分派") {
        var a = '<span style="color:#0000ff">' + value + '</span>';
    } else if (value == "离线") {
        var a = '<span style="color:#FF0000">' + value + '</span>';
    } else {
        var a = '<span>' + value + '</span>';
    }
    return a;
}

// 导出信息
function rdlExportStorageAction() {
    $('#rdlExport_storage').click(function () {
        $('#rdlExport_modal').modal("show");
    })

    $('#rdlExport_storage_download').click(function () {
        var queryParameter = rdlNowTreeNode.id;
        var data = {
            sORGId: queryParameter
        }
        var url = "/lihuaiot01/realDeviceList/exportRealDeviceList?" + $.param(data)
        window.open(url, '_blank');
        $('#rdlExport_modal').modal("hide");
    })
}