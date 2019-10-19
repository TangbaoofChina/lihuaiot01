var raTableColumns;
$(function () {
    raInitTable();
    raExportStorageAction();
});

function raInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realAlarm/alarmHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            raTableColumns = questionColumns;
            raInitTableContent();
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function raInitTableContent() {

    $('#raDeviceList').bootstrapTable('destroy');

    $('#raDeviceList').bootstrapTable({
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
        pageSize: 100,
        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],
        //是否显示搜索
        search: true,
        //是否显示列头
        showHeader: true,
        // 显示下拉框勾选要显示的列
        showColumns : true,
        //是否显示刷新按钮
        showRefresh: true,
        //是否显示全屏按钮
        showFullscreen:false,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realAlarm/selectRealAlarmInfo",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        /*queryParamsType: 'limit',//查询参数组织方式
        queryParams: roleQueryParams,*/
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
         toolbar: '#ratoolbar',//指定工作栏
        columns: raTableColumns,
        height: 500       //设置表格高度-固定表头生效
    });
}

// 导出库存信息
function raExportStorageAction() {
    $('#raExport_storage').click(function () {
        $('#raExport_modal').modal("show");
    })

    $('#raExport_storage_download').click(function () {
        var url = "/lihuaiot01/realAlarm/exportRealAlarmList"
        window.open(url, '_blank');
        $('#raExport_modal').modal("hide");
    })
}