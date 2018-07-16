var haTableColumns;
var hasearch_start_date = null;
var hasearch_end_date = null;
$(function () {
    haInitTable();
    haExportStorageAction();
    haDateRangePickerInit();
    haSearchAction();
    hasearch_start_date = BeforeNowtime(24);
    hasearch_end_date = GetNowtime();
    $('#haSearch_start_date').val(hasearch_start_date);
    $('#haSearch_end_date').val(hasearch_end_date);
});

function haInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisAlarm/alarmHead',
        dataType: "json",
        success: function (result) {
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            haTableColumns = questionColumns;
            haInitTableContent();
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function haInitTableContent() {

    $('#haDeviceList').bootstrapTable('destroy');

    $('#haDeviceList').bootstrapTable({
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
        //是否显示刷新按钮
        showRefresh: true,
        //是否显示全屏按钮
        showFullscreen: false,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/hisAlarm/selectHisAlarmInfo",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: haQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        toolbar: '#hatoolbar',//指定工作栏
        columns: haTableColumns,
    });
}

//请求服务数据时所传参数
function haQueryParams(params) {
    var queryStartDate = hasearch_start_date;
    var queryEndDate = hasearch_end_date;
    var queryParamObj = document.getElementById("haSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryAlarmType = queryParamObj.options[queryParamIndex].text; // 选中文本
    return {
        /*pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,*/
        alarmType: queryAlarmType,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

// 日期选择器初始化
function haDateRangePickerInit() {
    $('#haDateInterval').daterangepicker({
        "timePicker": true,
        "timePicker24Hour": true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'right',    // 日期选择框的弹出位置
        separator: ' 至 ',
        "locale": {
            format: 'YYYY/MM/DD HH:mm:ss',
            separator: ' ~ ',
            applyLabel: "应用",
            cancelLabel: "取消",
            resetLabel: "重置",
            fromLabel: '起始时间',
            toLabel: '结束时间',
            customRangeLabel: '自定义',
            firstDay: 1,
            daysOfWeek: ["日", "一", "二", "三", "四", "五", "六"],
            monthNames: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        },
        ranges: {
            '最近1小时': [moment().subtract(1, 'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1, 'days').startOf('day'), moment().subtract(1, 'days').endOf('day')],
            '最近7日': [moment().subtract(6, 'days'), moment()],
            '最近30日': [moment().subtract(29, 'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hasearch_start_date = this.startDate.format(this.locale.format);
        hasearch_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

// 查询操作
function haSearchAction() {
    $('#haQuery_storage').click(function () {
        haInitTableContent();
    })
}

// 导出库存信息
function haExportStorageAction() {
    $('#haExport_storage').click(function () {
        $('#haExport_modal').modal("show");
    })

    $('#haExport_storage_download').click(function () {
        var queryStartDate = hasearch_start_date;
        var queryEndDate = hasearch_end_date;
        var queryParamObj = document.getElementById("haSelId_Param"); //定位选择参数
        var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
        var queryAlarmType = queryParamObj.options[queryParamIndex].text; // 选中文本
        var data = {
            alarmType: queryAlarmType,
            sStartDate: queryStartDate,
            sEndDate: queryEndDate,
        };
        var url = "/lihuaiot01/hisAlarm/exportHisAlarmList?"+ $.param(data);
        window.open(url, '_blank');
        $('#haExport_modal').modal("hide");
    })
}