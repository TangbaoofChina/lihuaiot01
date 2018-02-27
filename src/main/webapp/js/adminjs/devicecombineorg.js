var deviceOrgNowTreeNode;
var deviceOrgTreeNodes;
var deviceOrgTableColumns;
var deviceOrgSelectORG;
var deviceOrgSelectDevice;
var deviceOrgTableChecked = new Array();  //全局数组

$(function () {
    deviceOrgInitTreeNode();
    deviceOrgInitTable();
    deviceOrgInitORG();
    deviceOrgBatchTransferInit();
    $('#deviceOrgTable').on('uncheck.bs.table check.bs.table check-all.bs.table uncheck-all.bs.table', function (e, rows) {
        var datas = $.isArray(rows) ? rows : [rows];        // 点击时获取选中的行或取消选中的行
        examine(e.type, datas);                              // 保存到全局 Array() 里
    });
});

function examine(type, datas) {
    if (type.indexOf('uncheck') == -1) {
        $.each(datas, function (i, v) {
            // 添加时，判断一行或多行的 id 是否已经在数组里 不存则添加　
            deviceOrgTableChecked.indexOf(v.dSerialNum) == -1 ? deviceOrgTableChecked.push(v.dSerialNum) : -1;
        });
    } else {
        $.each(datas, function (i, v) {
            deviceOrgTableChecked.splice(deviceOrgTableChecked.indexOf(v.dSerialNum), 1);    //删除取消选中行
        });
    }
}

function deviceOrgInitTreeNode() {
    // Some logic to retrieve, or generate tree structure
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/selectTreeNode",
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
                deviceOrgTreeNodes = json;
                $('#deviceOrgTree').treeview({
                    data: deviceOrgTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: deviceOrgNodeSelected,
                });
                $('#deviceOrgTree01').treeview({
                    data: deviceOrgTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: deviceOrgNodeSelected01,
                });
                $('#deviceOrgTree02').treeview({
                    data: deviceOrgTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: deviceOrgNodeSelected02,
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

function deviceOrgNodeSelected(event, data) {
    deviceOrgNowTreeNode = data;
    $('#deviceOrgTree').treeview('clearSearch');
    if (data.nodes != null) {
        var select_node = $('#deviceOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#deviceOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#deviceOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    deviceOrgSelectDeviceByTreeId();
}

function deviceOrgNodeSelected01(event, data) {
    deviceOrgSelectORG = data;
    if (data.nodes != null) {
        var select_node = $('#deviceOrgTree01').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#deviceOrgTree01').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#deviceOrgTree01').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
}

function deviceOrgNodeSelected02(event, data) {
    deviceOrgSelectORG = data;
    if (data.nodes != null) {
        var select_node = $('#deviceOrgTree02').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#deviceOrgTree02').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#deviceOrgTree02').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
}

function deviceOrgSearchTreeNode() {
    var txtSearch = document.getElementById("deviceOrgTxtSearchTreeNode").value;
    $('#deviceOrgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes
            }]);
}


//请求服务数据时所传参数
function deviceOrgQueryParams(params) {
    var queryParameter;
    if (typeof(deviceOrgNowTreeNode) !== "undefined") {
        queryParameter = deviceOrgNowTreeNode.id;
    }
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sORGId: queryParameter,
    };
}

function deviceOrgSelectDeviceByTreeId() {

    $('#deviceOrgTable').bootstrapTable('destroy');

    $('#deviceOrgTable').bootstrapTable({
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
        pageList: [10, 25, 50, 100],
        //是否显示搜索
        search: false,
        //是否显示列头
        showHeader: true,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/deviceCombineOrg/selectDeviceByORGId",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: deviceOrgQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: deviceOrgTableColumns,
    });
}

function deviceOrgInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/deviceCombineOrg/DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            var temp0 = {field: 'checkStatus', checkbox: true};
            questionColumns.push(temp0)
            for (var i = 0; i < json.length; i++) {
                var temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                questionColumns.push(temp);
            }
            var temp1 = {
                field: 'operation',
                title: '操作',
                formatter: function (value, row, index) {
                    var s = '<a class = "deviceOrgChangeORG" href="javascript:void(0)">转移/重命名</a>';
                    return s;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            deviceOrgTableColumns = questionColumns;
            $('#deviceOrgTable').bootstrapTable('destroy');
            $('#deviceOrgTable').bootstrapTable({
                locale: 'zh-CN',//中文支持
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

function deviceOrgShowAdd() {
    if (typeof(deviceOrgNowTreeNode) !== "undefined") {
        $("#deviceOrgOrg").val(deviceOrgNowTreeNode.name);
    }
    $('#deviceOrgaddNew-popup').show('slow');
    deviceOrgAddNewInit();
}

function deviceOrgBatchTransfer() {
    $('#deviceOrgaddNew-popup02').show('slow');
}

/**
 * 新增页面
 * */
function deviceOrgAddNewInit() {
    //保存按钮
    /*    $('#addNew-save').bind('click', function (e) {

        });*/
    //取消按钮
    $('#deviceOrgaddNew-cancel').bind('click', function (e) {
        $('#deviceOrgaddNew-popup').hide('slow');
    });
    //x按钮
    $('#deviceOrgaddNew-close').bind('click', function (e) {
        $('#deviceOrgaddNew-popup').hide('slow');
    });
}

/**
 * 新增页面
 * */
function deviceOrgBatchTransferInit() {
    //保存按钮
    /*    $('#addNew-save').bind('click', function (e) {

        });*/
    //取消按钮
    $('#deviceOrgaddNew-cancel02').bind('click', function (e) {
        $('#deviceOrgaddNew-popup02').hide('slow');
    });
    //x按钮
    $('#deviceOrgaddNew-close02').bind('click', function (e) {
        $('#deviceOrgaddNew-popup02').hide('slow');
    });
}

function deviceOrgInitORG() {
    $("#deviceOrgOrg").bsSuggest('init', {
        effectiveFieldsAlias: {name: "部门"},
        searchFields: ["name"],
        effectiveFields: ["name"],
        showHeader: true,//显示 header
        url: "/lihuaiot01/deviceCombineOrg/selectZTreeNode",
        idField: "id",
        keyField: "name",
        inputWarnColor: 'rgba(255,0,0,.1)', //输入框内容不是下拉列表选择时的警告色
        listStyle: {
            'padding-top': 0,
            'max-height': '250px',
            'max-width': '800px',
            'overflow': 'auto',
            'width': 'auto',
            'transition': '0.3s',
            '-webkit-transition': '0.3s',
            '-moz-transition': '0.3s',
            '-o-transition': '0.3s'
        },               //列表的样式控制
        processData: function (json) {// url 获取数据时，对数据的处理，作为 getData 的回调函数
            var i, len, data = {value: []};
            if (!json || json.length == 0) {
                return false;
            }
            len = json.length;
            for (i = 0; i < len; i++) {
                data.value.push({
                    "name": json[i].name,
                    "id": json[i].id,
                });
            }
            //console.log(data);
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        //console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        //console.log('onSetSelectValue: ', keyword, data);
        deviceOrgSelectORG = data;
    }).on('onUnsetSelectValue', function () {
        //console.log('onUnsetSelectValue');
    });
}

window.operateEvents = {
    'click .deviceOrgChangeORG': function (e, value, row, index) {
        deviceOrgShowAdd();
        var $txt = $('.addNew-content').find('input');
        $($txt[0]).val(row.dSerialNum);
        $($txt[1]).val(row.dName);
        deviceOrgSelectDevice = row;
    },
    'click .deviceOrgRemoveORG': function (e, value, row, index) {
        deviceOrgSelectDevice = row;
        $('#delcfmModel').modal();
    }
};

function deviceOrgUpdateDeviceOrg() {
    var deviceId = deviceOrgSelectDevice.dSerialNum;
    var deviceName = $('#deviceOrgName').val();
    var orgId = deviceOrgSelectORG.id;
    $.ajax({
        type: 'POST',
        data: {deviceId: deviceId, deviceName: deviceName, orgId: orgId},
        url: '/lihuaiot01/deviceCombineOrg/deviceCombineOrgUpdate',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            //alert(result);
            deviceOrgSelectDeviceByTreeId();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
    $('#deviceOrgaddNew-popup').hide('slow');
}

function deviceOrgUpdateDeviceOrg02() {
    var deviceIds = deviceOrgTableChecked;
    if (deviceIds.length <1) {
        showMsg("error", "未选择设备", "请先选择批量转移设备");
        return;
    }
    if (deviceOrgSelectORG == null) {
        showMsg("error", "未选择根节点", "请先选择根节点");
        return;
    }
    var orgId = deviceOrgSelectORG.id;
    $.ajax({
        type: 'POST',
        data: {deviceIds: deviceIds.join(','), orgId: orgId},
        url: '/lihuaiot01/deviceCombineOrg/deviceCombineOrgBatchUpdate',
        dataType: "text",
        success: function (result) {
            deviceOrgSelectDeviceByTreeId();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });

    $('#deviceOrgaddNew-popup02').hide('slow');
}

