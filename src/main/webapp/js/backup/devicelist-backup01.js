var parentNode;
var nextNode;
var nowTreeNode;
var tableColumns;
var treeNodes;
var setting = {
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false,
        fontCss: getFontCss
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: ""
        }
    },
    callback: {
        beforeClick: function (treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("tree");
            nextNode = treeNode.getNextNode();
            parentNode = treeNode.getParentNode();
            nowTreeNode = treeNode;
            treeNodeHighLightClear();
            selectDeviceByTreeId();
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
            } else {
            }
        }
    }
};

$(function() {
    FindZTreeNode("");
    initTable();
    exportStorageAction();
});

function FindZTreeNode(txtSearch) {
    $.ajax({
        url: "/lihuaiot01/treeNode/selectTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                var json = eval(result); //数组
                treeNodes = json;
                $.fn.zTree.init($("#tree"), setting, treeNodes);
                searchTreeNodeByName(txtSearch);
            } else {
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

function searchTreeNode() {
    var txtSearch = document.getElementById("txtSearchTreeNode").value;
    searchTreeNodeByName("");
    searchTreeNodeByName(txtSearch);
}

function searchTreeNodeByName(txtSearch) {
    var zTree = $.fn.zTree.getZTreeObj("tree");
    var nodeList = [];
    nodeList = zTree.getNodesByParamFuzzy("name", txtSearch);
    if (txtSearch === "") {
        for (var i = 0, l = nodeList.length; i < l; i++) {
            nodeList[i].highlight = false;
            zTree.updateNode(nodeList[i]);
        }
        zTree.setting.view.expandSpeed = "";
        zTree.expandAll(false);
        zTree.setting.view.expandSpeed = "fast";
        var node = zTree.getNodeByParam("id","001");//获取id为001的点
        zTree.selectNode(node);//选择点
        zTree.setting.callback.beforeClick(zTree.setting.treeId, node);//调用事件
    }
    else {
        for (var i = 0, l = nodeList.length; i < l; i++) {
            nodeList[i].highlight = true;
            zTree.updateNode(nodeList[i]);
            zTree.expandNode(nodeList[i], true);
            zTree.selectNode(nodeList[i]);
        }
    }
}

function getFontCss(treeId, treeNode) {
    return (!!treeNode.highlight) ? {color: "#A60000", "font-weight": "bold"} : {
        color: "#333",
        "font-weight": "normal"
    };
}

function treeNodeHighLightClear() {
    var zTree = $.fn.zTree.getZTreeObj("tree");
    var nodeList = [];
    nodeList = zTree.getNodesByParamFuzzy("name", "");
    for (var i = 0, l = nodeList.length; i < l; i++) {
        nodeList[i].highlight = false;
        zTree.updateNode(nodeList[i]);
    }
}

function initTable() {
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
                if(json[i].data === "dState")
                {
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align,formatter:changeTableColor};//手动拼接columns
                }else
                {
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                }

                questionColumns.push(temp);
            };
            tableColumns = questionColumns;
            $('#deviceList').bootstrapTable('destroy');
            $('#deviceList').bootstrapTable({
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
function queryParams(params) {
    var queryParameter = nowTreeNode.id;
    return {
        sORGId: queryParameter,
    };
}

// 表格刷新
function tableRefresh() {
    $('#deviceList').bootstrapTable('refresh', {
        query : {}
    });
}

function selectDeviceByTreeId() {

    $('#deviceList').bootstrapTable('destroy');

    $('#deviceList').bootstrapTable({
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
        pageSize: 10,
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
        queryParams: queryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        //toolbar: '#toolbar',//指定工作栏
        columns: tableColumns,
    });
}

function changeTableColor(value,row,index) {
        //通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
        var a = "";
        if(value == "在线") {
            var a = '<span style="color:#00ff00">'+value+'</span>';
        }else if(value == "已分派"){
            var a = '<span style="color:#0000ff">'+value+'</span>';
        }else if(value == "离线") {
            var a = '<span style="color:#FF0000">'+value+'</span>';
        }else{
            var a = '<span>'+value+'</span>';
        }
        return a;
}

// 导出库存信息
function exportStorageAction() {
    $('#export_storage').click(function() {
        $('#export_modal').modal("show");
    })

    $('#export_storage_download').click(function(){
        var queryParameter = nowTreeNode.id;
        var data = {
            sORGId: queryParameter
        }
        var url = "/lihuaiot01/deviceList/exportDeviceList?" + $.param(data)
        window.open(url, '_blank');
        $('#export_modal').modal("hide");
    })
}