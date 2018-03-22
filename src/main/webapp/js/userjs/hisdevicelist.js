var hisNowTreeNode;
var hisTableColumns;
var hisTreeNodes;
var hissearch_start_date = null;
var hissearch_end_date = null;

$(function () {
    hisInitTreeNode();
    hisInitTable();
    hisExportStorageAction();
    //hisDatePickerInit();
    hisDateRangePickerInit();
    hisSearchAction();
    hissearch_start_date = BeforeNowtime(24);
    hissearch_end_date = GetNowtime();
    $('#hisSearch_start_date').val(hissearch_start_date);
    $('#hisSearch_end_date').val(hissearch_end_date);

});

// 日期选择器初始化
function hisDateRangePickerInit() {
    hissearch_start_date = NowWeeHours(); //凌晨
    hissearch_end_date = GetTodaytime(); //最晚时间
    $('#hisDateInterval').daterangepicker({
        "timePicker": true,
        "timePicker24Hour": true,
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hissearch_start_date = this.startDate.format(this.locale.format);
        hissearch_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTreeNode() {
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
                hisTreeNodes = json;
                /*console.log(hisTreeNodes);*/
                $('#hisOrgTree').treeview({
                    data: hisTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: hisNodeSelected,
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

function hisSearchTreeNode() {
    var txtSearch = document.getElementById("hisTxtSearchTreeNode").value;
    $('#hisOrgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes
            }]);
}

function hisNodeSelected(event, data) {
    hisNowTreeNode = data;
    $('#hisOrgTree').treeview('clearSearch');
    if (data.nodes != null) {
        var select_node = $('#hisOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#hisOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#hisOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
}

function hisInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/ec01DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisTableColumns = questionColumns;
            $('#hisDeviceList').bootstrapTable('destroy');
            $('#hisDeviceList').bootstrapTable({
                columns: questionColumns,
                // 显示下拉框勾选要显示的列
                showColumns : true,
                // 设置最少显示列个数
                minimumCountColumns: 2,
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
function hisQueryParams(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hissearch_start_date;
    var queryEndDate = hissearch_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeId() {

    $('#hisDeviceList').bootstrapTable('destroy');

    $('#hisDeviceList').bootstrapTable({
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
/*        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],*/
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns : true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //分页只显示分页不显示总页数等数据，结合本页的style
        /*paginationDetailHAlign:"right",*/
        /*onlyInfoPagination:true,*/
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/hisDeviceList/selectEC01ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisTableColumns,
    });
}

// 导出信息
function hisExportStorageAction() {
    $('#hisExport_storage').click(function () {
        $('#hisExport_modal').modal("show");
    })

    $('#hisExport_storage_download').click(function () {
        var queryParameter = hisNowTreeNode.id;
        var queryStartDate = hissearch_start_date;
        var queryEndDate = hissearch_end_date;
        if (queryParameter.length == 4) {
            var data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            }
            var url = "/lihuaiot01/hisDeviceList/exportHisDeviceList?" + $.param(data);
            window.open(url, '_blank');
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
        $('#hisExport_modal').modal("hide");
    })
}

// 日期选择器初始化
function hisDatePickerInit() {
    $('.form_date').datetimepicker({
        format: 'yyyy-mm-dd hh:ii:ss',
        language: 'zh-CN',
        endDate: new Date(),
        weekStart: 1,
        todayBtn: true,
        autoClose: true,
        todayHighlight: true,
        startView: 2,
        forceParse: true,
    });
}

// 查询操作
function hisSearchAction() {
    $('#hisQuery_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeId();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    })
}

function hisSelectTimeChange() {
    var timeSel = document.getElementById("HisDeviceTimeSelID");

    switch (timeSel.value) {
        case "0":
            hissearch_start_date = BeforeNowtime(1); //1小时
            hissearch_end_date = GetNowtime(); //当前时间
            break;
        case "1":
            hissearch_start_date = BeforeNowtime(3); //3小时
            hissearch_end_date = GetNowtime(); //当前时间
            break;
        case "2":
            hissearch_start_date = BeforeNowtime(24); //24小时
            hissearch_end_date = GetNowtime(); //当前时间
            break;
        case "3":
            hissearch_start_date = NowWeeHours(); //凌晨
            hissearch_end_date = GetNowtime(); //当前时间
            break;
        case "4":
            hissearch_start_date = YesterdayWeeHours(); //昨日凌晨
            hissearch_end_date = YesterdayMidnight(); //昨日午夜
            break;
        case "5":
            hissearch_start_date = NowWeeMonth(); //本月初
            hissearch_end_date = GetNowtime(); //当前时间
            break;
        case "6":
            hissearch_start_date = NowWeeYear(); //今年初
            hissearch_end_date = GetNowtime(); //当前时间
            break;
    }
    $('#hisSearch_start_date').val(hissearch_start_date);
    $('#hisSearch_end_date').val(hissearch_end_date);
}