//角色管理   创建角色
var roleTableColumns;
var roleOrgTreeNodes;
var roleSelectORG;
var roleSelectRole;
$(function () {
    roleInitTableHead();
    roleOrgInitTreeNode();
    /*// 缺一不可
    $('#roleDeviceSelBefore').selectpicker('refresh');
    $('#roleDeviceSelBefore').selectpicker('render');
    // 缺一不可
    $('#roleDeviceSelEnd').selectpicker('refresh');
    $('#roleDeviceSelEnd').selectpicker('render');*/
    roleOperateDevice();
});

function roleInitTableHead() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/roleCombineDev/RoleHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            var temp1 = {
                field: 'operation',
                title: '操作',
                formatter: function (value, row, index) {
                    var s = '<a class = "roleChangeDevice" href="#">分配</a>';
                    var d = '<a class = "roleRemoveRole" href="#">删除</a>';
                    return s + ' ' + d;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            roleTableColumns = questionColumns;
            roleInitTableContent();

        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//请求服务数据时所传参数
function roleQueryParams(params) {
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
    };
}

function roleInitTableContent() {

    $('#roleTable').bootstrapTable('destroy');

    $('#roleTable').bootstrapTable({
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
        //初始化加载第一页，默认第一页
        pageNumber: 1,
        //每页的记录行数（*）
        pageSize: 100,
        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],
        //是否显示搜索
        search: true,
        //是否显示列头
        showHeader: true,
        // 显示下拉框勾选要显示的列
        showColumns: false,
        // 设置最少显示列个数
        minimumCountColumns: 3,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/roleCombineDev/selectRoleInfo",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: roleQueryParams,
        pagination:true,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: roleTableColumns,
    /*    height: 500,       //设置表格高度-固定表头生效*/
    });

}

function roleInitTableContent() {

    $('#roleTable').bootstrapTable('destroy')
        .bootstrapTable({
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
        //初始化加载第一页，默认第一页
        pageNumber: 1,
        //每页的记录行数（*）
        pageSize: 100,
        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],
        //是否显示搜索
        search: true,
        //是否显示列头
        showHeader: true,
        // 显示下拉框勾选要显示的列
        showColumns: false,
            //是否显示刷新按钮
            showRefresh: true,
        // 设置最少显示列个数
        minimumCountColumns: 3,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/roleCombineDev/selectRoleInfo",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: roleQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
            toolbar: '#roletoolbar',//指定工作栏
        height: 500,       //设置表格高度-固定表头生效
        columns: roleTableColumns
    });
}

function roleOrgInitTreeNode() {
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
                roleOrgTreeNodes = json;
                $('#roleOrgTree01').treeview({
                    data: roleOrgTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: roleOrgNodeSelected01,
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

function roleOrgNodeSelected01(event, data) {
    roleSelectORG = data;
    if (data.nodes != null) {
        var select_node = $('#roleOrgTree01').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#roleOrgTree01').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#roleOrgTree01').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    roleSelectDeviceByOrgId();
}

function roleSelectDeviceByOrgId() {
    var sORGId;
    if (typeof(roleSelectORG) !== "undefined") {
        sORGId = roleSelectORG.id;
    } else
        return;
    $.ajax({
        url: "/lihuaiot01/roleCombineDev/selectDeviceByORGId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {sORGId: sORGId},
        success: function (result) {
            $('#roleDeviceSelBefore').empty();
            if (JSON.stringify(result) !== '[]') {
                /*console.log(result);*/
                for (var i = 0; i < result.length; i++) {
                    //先创建好select里面的option元素
                    //var length = $("#").find("option[value=0001]").size();
                    var selEndlength = $("option[value=" + result[i].dSerialNum + "]", "#roleDeviceSelEnd").length;
                    if (selEndlength > 0)
                        continue;
                    var option = document.createElement("option");
                    //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                    $(option).val(result[i].dSerialNum);
                    //给option的text赋值,这就是你点开下拉框能够看到的东西
                    $(option).attr("title", result[i].dName);
                    $(option).text(result[i].dName);
                    //获取select 下拉框对象,并将option添加进select
                    $('#roleDeviceSelBefore').append(option);
                }
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function roleOperateDevice() {
    $('#roleDeviceSelBefore').dblclick(function () {
        var operationBefore = $('#roleDeviceSelBefore option:selected');
        operationBefore[0].selected = false;
        $('#roleDeviceSelEnd').append(operationBefore);
        $('#roleDeviceSelBefore option:selected').remove();
    });
    $('#roleDeviceSelEnd').dblclick(function () {
        var operationEnd = $('#roleDeviceSelEnd option:selected');
        operationEnd[0].selected = false;
        $('#roleDeviceSelBefore').append(operationEnd);
        $('#roleDeviceSelEnd option:selected').remove();
    });
}

function roleOneDeviceToRight() {
    var operationBefore = $('#roleDeviceSelBefore option:selected');
    for (i = 0; i < operationBefore.length; i++) {
        operationBefore[i].selected = false;
    }
    $('#roleDeviceSelEnd').append(operationBefore);
    $('#roleDeviceSelBefore option:selected').remove();
}

function roleAllDeviceToRight() {
    var operationBefore = $('#roleDeviceSelBefore option');
    for (i = 0; i < operationBefore.length; i++) {
        operationBefore[i].selected = false;
        $('#roleDeviceSelEnd').append(operationBefore[i]);
    }
    /*    $("#roleDeviceSelBefore option").each(function (){
            $(this).selected = false;
            $('#roleDeviceSelEnd').append($(this));
        });*/
    $('#roleDeviceSelBefore').empty();
}

function roleOneDeviceToLeft() {
    var operationEnd = $('#roleDeviceSelEnd option:selected');
    for (i = 0; i < operationEnd.length; i++) {
        operationEnd[i].selected = false;
    }
    $('#roleDeviceSelBefore').append(operationEnd);
    $('#roleDeviceSelEnd option:selected').remove();
}

function roleAllDeviceToLeft() {
    var operationEnd = $('#roleDeviceSelEnd option');
    for (i = 0; i < operationEnd.length; i++) {
        operationEnd[i].selected = false;
        $('#roleDeviceSelBefore').append(operationEnd[i]);
    }
    /*$("#roleDeviceSelEnd option").each(function (){
        $(this).selected = false;
        $('#roleDeviceSelBefore').append($(this));
    });*/
    $('#roleDeviceSelEnd').empty();
}

function roleShowAdd() {
    $('#roleaddNew-popup').show('slow');
    roleAddNewShow();
}

/**
 * 新增页面
 * */
function roleAddNewShow() {
    //取消按钮
    $('#roleaddNew-cancel').bind('click', function (e) {
        $('#roleaddNew-popup').hide('slow');
    });
    //x按钮
    $('#roleaddNew-close').bind('click', function (e) {
        $('#roleaddNew-popup').hide('slow');
    });
}

function roleInsertRoleInfo() {
    var mRoleName = $('#roleNewName').val();
    var mRoleDescribe = $('#roleNewDescribe').val();
    var mRoleAdmin = $('#roleAdminType').val();
    $.ajax({
        url: "/lihuaiot01/roleCombineDev/insertRoleInfo",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {roleNewName: mRoleName, roleNewDescribe: mRoleDescribe,roleBelong:mRoleAdmin},
        success: function (result) {
            roleInitTableContent();
            if (result !== "新增完成") {
                var type = 'warning';
                var msg = '新增角色失败';
                var append = '对不起，新增角色失败：' + result;
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
    $('#roleaddNew-popup').hide('slow');
}

function roleShowModify() {
    $('#roleModify-popup').show('slow');
    roleModifyShow();
}

/**
 * 修改页面
 * */
function roleModifyShow() {
    //取消按钮
    $('#roleModify-cancel').bind('click', function (e) {
        $('#roleModify-popup').hide('slow');
    });
    //x按钮
    $('#roleModify-close').bind('click', function (e) {
        $('#roleModify-popup').hide('slow');
    });
}

function roleUpdateRoleDevice() {
    var mRoleId = roleSelectRole.roleId;
    var mRoleName = $('#roleModifyName').val();
    var mRoleDescribe = $('#roleModifyDescribe').val();
    var operationEnd = $('#roleDeviceSelEnd option');
    var deviceList = new Array();
    $('#roleModify-popup').hide('slow');
    if (operationEnd.length === 0)
        return;
    $.each(operationEnd, function (id, obj) {
        var object = new Object();
        object.devNum = obj.value;
        object.devName = obj.text;
        object.roleId = mRoleId;
        object.roleName = mRoleName;
        object.roleDescribe = mRoleDescribe;
        deviceList.push(object);
    });
    $.ajax({
        url: "/lihuaiot01/roleCombineDev/insertUpdateRoleDeviceList",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
        contentType: 'application/json;charset=utf-8', //设置请求头信息
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: JSON.stringify(deviceList),
        success: function (result) {
            roleInitTableContent();
            if (result !== "更新角色完成") {
                var type = 'warning';
                var msg = '更新角色失败';
                var append = '对不起，更新角色失败：' + result;
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function updateRoleDeviceSelEnd() {
    var mRoleId = roleSelectRole.roleId;
    $.ajax({
        url: "/lihuaiot01/roleCombineDev/selectDeviceByRoleId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {roleId: mRoleId},
        success: function (result) {
            $('#roleDeviceSelEnd').empty();
            if (JSON.stringify(result) !== '[]') {
                /*console.log(result);*/
                for (var i = 0; i < result.length; i++) {
                    //先创建好select里面的option元素
                    var option = document.createElement("option");
                    //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                    $(option).val(result[i].dSerialNum);
                    //给option的text赋值,这就是你点开下拉框能够看到的东西
                    $(option).attr("title", result[i].dName);
                    $(option).text(result[i].dName);
                    //获取select 下拉框对象,并将option添加进select
                    $('#roleDeviceSelEnd').append(option);
                }
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function roleDeleteRole() {
    var mRoleId = roleSelectRole.roleId;
    var mRoleName = roleSelectRole.roleName;
    if (mRoleName === "admin") {
        return;
    }
    $.ajax({
        url: "/lihuaiot01/roleCombineDev/deleteRoleInfo",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {roleId: mRoleId, roleName: mRoleName},
        success: function (result) {
            if (result === "删除成功") {
                roleInitTableContent();
            }else{
                var type = 'warning';
                var msg = '删除失败';
                var append = '对不起，删除角色失败：' + result;
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}