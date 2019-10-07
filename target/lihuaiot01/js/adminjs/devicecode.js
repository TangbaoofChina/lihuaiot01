//设备代码
var dcAlarmTableColumns;
var dcErrorTableColumns;
var dcSelectRole;
$(function () {
    dcInitAlarmTableHead();
});

function dcInitAlarmTableHead() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/deviceCode/AlarmDescribeHead',
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
                    var s = '<a class = "dcChangeCodeDescribe" href="#">修改</a>';
                    var d = '<a class = "dcRemoveCode" href="#">删除</a>';
                    return s + ' ' + d;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            dcAlarmTableColumns = questionColumns;
            dcInitAlarmTableContent();
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}


//请求服务数据时所传参数
function dcTableColumns(params) {
    var dcmDevType = $('#dcDeviceType').val();
    return {
        /*pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,*/
        deviceType: dcmDevType
    };
}

function dcInitAlarmTableContent() {

    $('#dcTable').bootstrapTable('destroy');

    $('#dcTable').bootstrapTable({
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
        search: true,
        //是否显示列头
        showHeader: true,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/deviceCode/selectAlarmDescribeByDevType",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: dcTableColumns,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: dcAlarmTableColumns,
    });
}

function dcInsertAlarmDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe) {
    $.ajax({
        type: 'POST',
        data: {deviceType: dcmDevType, alarmCode: dcmDevCode, sAlarmDescribe: dcmDevDescribe},
        url: '/lihuaiot01/deviceCode/insertAlarmDescribeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "新增完成") {
                var type = 'warning';
                var msg = '新增错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
            else {
                dcInitAlarmTableContent();
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcUpdateAlarmDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe) {
    $.ajax({
        type: 'POST',
        data: {deviceType: dcmDevType, alarmCode: dcmDevCode, sAlarmDescribe: dcmDevDescribe},
        url: '/lihuaiot01/deviceCode/updateAlarmDescribeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "更新完成") {
                var type = 'warning';
                var msg = '更新错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
            else {
                dcInitAlarmTableContent();
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcDeleteAlarmDeviceCode(dcmDevType, dcmDevCode) {
    $.ajax({
        type: 'POST',
        data: {deviceType: dcmDevType, alarmCode: dcmDevCode},
        url: '/lihuaiot01/deviceCode/deleteAlarmDescribeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "删除完成") {
                var type = 'warning';
                var msg = '更新错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
            else {
                dcInitAlarmTableContent();
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcAddDeviceType() {
    $.ajax({
        type: 'POST',
        data: {sDevType: "111", sDevTypeDescribe: "纳捷环控器"},
        url: '/lihuaiot01/deviceCode/insertDeviceTypeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "新增完成") {
                var type = 'warning';
                var msg = '新增错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcInsertDeviceCode() {
    var dcmDevType = $('#dcDeviceTypeNew').val();
    var dcmDevMsg = $('#dcDeviceMessageNew').val();
    var dcmDevCode = $('#dcNewCode').val();
    var dcmDevDescribe = $('#dcNewDescribe').val();
    if (dcmDevMsg === "01") {
        dcInsertAlarmDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe);
    } else if (dcmDevMsg === "02") {
        dcInsertErrorDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe);
    }
    $('#dcaddNew-popup').hide('slow');
}

function dcUpdateDeviceCode() {
    var dcmDevType = $('#dcDeviceTypeUpdate').val();
    var dcmDevMsg = $('#dcDeviceMessageUpdate').val();
    var dcmDevCode = $('#dcModifyCode').val();
    var dcmDevDescribe = $('#dcModifyDescribe').val();
    if (dcmDevMsg === "01") {
        dcUpdateAlarmDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe);
    } else if (dcmDevMsg === "02") {
        dcUpdateErrorDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe);
    }
    $('#dcModify-popup').hide('slow');
}

function dcDeleteDeviceCode() {
    var dcmDevType = dcSelectRole.devType;
    var dcmDevMsg = $('#dcDeviceMessage').val();
    if (dcmDevMsg === "01") {
        var dcmDevCode = dcSelectRole.alarmCode;
        dcDeleteAlarmDeviceCode(dcmDevType, dcmDevCode);
    } else if (dcmDevMsg === "02") {
        var dcmDevCode = dcSelectRole.errorCode;
        dcDeleteErrorDeviceCode(dcmDevType, dcmDevCode);
    }
}

function dcSearch() {
    var dcDevMsg = $('#dcDeviceMessage').val();
    if (dcDevMsg === "01") {
        dcInitAlarmTableHead();
    } else if (dcDevMsg === "02") {
        dcInitErrorTableHead();
    }
}

function dcShowAdd() {
    $('#dcaddNew-popup').show('slow');
    var dcDevType = $('#dcDeviceType').val();
    var dcDevMsg = $('#dcDeviceMessage').val();
    $('#dcDeviceTypeNew').val(dcDevType);
    $('#dcDeviceMessageNew').val(dcDevMsg);
    dcAddNewShow();
}

/**
 * 新增页面
 * */
function dcAddNewShow() {
    //取消按钮
    $('#dcaddNew-cancel').bind('click', function (e) {
        $('#dcaddNew-popup').hide('slow');
    });
    //x按钮
    $('#dcaddNew-close').bind('click', function (e) {
        $('#dcaddNew-popup').hide('slow');
    });
}

function dcShowModify() {
    $('#dcModify-popup').show('slow');
    dcModifyShow();
}

/**
 * 修改页面
 * */
function dcModifyShow() {
    //取消按钮
    $('#dcModify-cancel').bind('click', function (e) {
        $('#dcModify-popup').hide('slow');
    });
    //x按钮
    $('#dcModify-close').bind('click', function (e) {
        $('#dcModify-popup').hide('slow');
    });
}

/************** 错误部分***********************/

function dcInitErrorTableHead() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/deviceCode/ErrorDescribeHead',
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
                    var s = '<a class = "dcChangeCodeDescribe" href="#">修改</a>';
                    var d = '<a class = "dcRemoveCode" href="#">删除</a>';
                    return s + ' ' + d;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            dcErrorTableColumns = questionColumns;
            dcInitErrorTableContent();
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcInitErrorTableContent() {

    $('#dcTable').bootstrapTable('destroy');

    $('#dcTable').bootstrapTable({
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
        search: true,
        //是否显示列头
        showHeader: true,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/deviceCode/selectErrorDescribeByDevType",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: dcTableColumns,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: dcErrorTableColumns,
    });
}

function dcInsertErrorDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe) {
    $.ajax({
        type: 'POST',
        data: {deviceType: dcmDevType, errorCode: dcmDevCode, sErrorDescribe: dcmDevDescribe},
        url: '/lihuaiot01/deviceCode/insertErrorDescribeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "新增完成") {
                var type = 'warning';
                var msg = '新增错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
            else {
                if (dcErrorTableColumns === undefined) {
                    dcInitErrorTableHead()
                } else {
                    dcInitErrorTableContent();
                }
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcUpdateErrorDeviceCode(dcmDevType, dcmDevCode, dcmDevDescribe) {
    $.ajax({
        type: 'POST',
        data: {deviceType: dcmDevType, errorCode: dcmDevCode, sErrorDescribe: dcmDevDescribe},
        url: '/lihuaiot01/deviceCode/updateErrorDescribeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "更新完成") {
                var type = 'warning';
                var msg = '更新错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
            else {
                if (dcErrorTableColumns === undefined) {
                    dcInitErrorTableHead()
                } else {
                    dcInitErrorTableContent();
                }
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function dcDeleteErrorDeviceCode(dcmDevType, dcmDevCode) {
    $.ajax({
        type: 'POST',
        data: {deviceType: dcmDevType, errorCode: dcmDevCode},
        url: '/lihuaiot01/deviceCode/deleteErrorDescribeInfo',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            if (result !== "删除完成") {
                var type = 'warning';
                var msg = '更新错误';
                var append = '对不起，' + result;
                showMsg(type, msg, append);
            }
            else {
                if (dcErrorTableColumns === undefined) {
                    dcInitErrorTableHead()
                } else {
                    dcInitErrorTableContent();
                }
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}
