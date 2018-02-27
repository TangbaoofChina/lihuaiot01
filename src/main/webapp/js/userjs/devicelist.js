
var dlNowTreeNode;
var dlTreeNodes;
var dlTableColumns;

$(function () {
    dlInitTreeNode();
    dlInitTable();
    dlExportStorageAction();
});

function dlInitTreeNode() {
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
                dlTreeNodes = json;
                $('#dlOrgTree').treeview({
                    data: dlTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: dlNodeSelected,
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

function dlNodeSelected(event, data) {
    dlNowTreeNode = data;
    $('#dlOrgTree').treeview('clearSearch');
    if (data.nodes != null) {
        var select_node = $('#dlOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#dlOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#dlOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    dlSelectDeviceByTreeId();
}

function dlSearchTreeNode() {
    var txtSearch = document.getElementById("dlTxtSearchTreeNode").value;
    $('#dlOrgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes
            }]);
}


function dlInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/deviceList/DeviceHead',
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
                        formatter: dlChangeTableColor
                    };//手动拼接columns
                } else {
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            dlTableColumns = questionColumns;
            $('#dlDeviceList').bootstrapTable('destroy');
            $('#dlDeviceList').bootstrapTable({
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
function dlQueryParams(params) {
    var queryParameter = dlNowTreeNode.id;
    return {
        sORGId: queryParameter,
    };
}

function dlSelectDeviceByTreeId() {

    $('#dlDeviceList').bootstrapTable('destroy');

    $('#dlDeviceList').bootstrapTable({
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
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/deviceList/selectDeviceByORGId",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: dlQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        //toolbar: '#toolbar',//指定工作栏
        columns: dlTableColumns,
    });
}

function dlChangeTableColor(value, row, index) {
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

// 导出库存信息
function dlExportStorageAction() {
    $('#dlExport_storage').click(function () {
        $('#dlExport_modal').modal("show");
    })

    $('#dlExport_storage_download').click(function () {
        var queryParameter = dlNowTreeNode.id;
        var data = {
            sORGId: queryParameter
        }
        var url = "/lihuaiot01/deviceList/exportDeviceList?" + $.param(data)
        window.open(url, '_blank');
        $('#dlExport_modal').modal("hide");
    })
}