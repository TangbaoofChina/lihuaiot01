var lrTreeNodes;
var lrNowTreeNode;
var lrTableColumns;
var lrSearch_start_date = null;
var lrSearch_end_date = null;
var lrNowSelectPeople = [];

$(function () {
    lrInitTreeNode();
    lrInitTable();
    lrDateRangePickerInit();
    lrSearchAction();
});

function lrInitTreeNode() {
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
                lrTreeNodes = json;
                $('#lrTree').treeview({
                    data: lrTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: lrNodeSelected,
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

function lrNodeSelected(event, data) {
    //console.log(data);
    lrNowTreeNode = data;
    $('#lrTree').treeview('clearSearch');
    if (data.nodes != null) {
        var select_node = $('#lrTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#lrTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#lrTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    lrSelectPeopleByOrgId();
}

function lrSearchTreeNode() {
    var txtSearch = document.getElementById("lrTxtSearchTreeNode").value;
    $('#lrTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes

            }]);
}

function lrSelectPeopleByOrgId() {
    var sORGId = lrNowTreeNode.id;
    $.ajax({
        url: "/lihuaiot01/loginRecord/selectPeopleByORGId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {sORGId: sORGId},
        success: function (result) {
            $('#lrPeopleSelect').empty();
            if (JSON.stringify(result) !== '[]') {
                /*console.log(result);*/
                for (var i = 0; i < result.length; i++) {
                    //先创建好select里面的option元素
                    var option = document.createElement("option");
                    //转换DOM对象为JQ对象,好用JQ里面提供的方法 给option的value赋值
                    $(option).val(result[i].personId);
                    //给option的text赋值,这就是你点开下拉框能够看到的东西
                    $(option).text(result[i].personName);
                    //获取select 下拉框对象,并将option添加进select
                    $('#lrPeopleSelect').append(option);
                }
            }
            /*else {
                //alert("未查询到树形组织数据");
                var type = 'warning';
                var msg = '未查询到注册用户数据';
                var append = '对不起，未查询到您要的注册用户数据';
                showMsg(type, msg, append);
            }*/
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            //alert(XMLHttpRequest.status);
            handleAjaxError(XMLHttpRequest.status);
            //alert(XMLHttpRequest.readyState);
            //alert(textStatus);
        }
    });
}

function lrInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/loginRecord/loginHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                if (json[i].data === "loginType") {
                    temp = {
                        field: json[i].data,
                        title: json[i].title,
                        align: json[i].align,
                        formatter: lrChangeTableText
                    };//手动拼接columns
                }else
                {
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            lrTableColumns = questionColumns;
            $('#lrDeviceList').bootstrapTable('destroy');
            $('#lrDeviceList').bootstrapTable({
                columns: questionColumns,
                // 显示下拉框勾选要显示的列
                showColumns: true,
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

function lrChangeTableText(value, row, index) {
    //通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
    var a = "";
    if (value == "login") {
        var a = '<span style="color:#00ff00">' + '登入' + '</span>';
    } else if (value == "logout") {
        var a = '<span style="color:#0000ff">' + '登出' + '</span>';
    } else {
        var a = '<span>' + value + '</span>';
    }
    return a;
}

// 日期选择器初始化
function lrDateRangePickerInit() {
    lrSearch_start_date = NowWeeHours(); //凌晨
    lrSearch_end_date = GetTodaytime(); //最晚时间
    $('#lrDateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1, 'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1, 'days').startOf('day'), moment().subtract(1, 'days').endOf('day')],
            '最近7日': [moment().subtract(6, 'days'), moment()],
            '最近30日': [moment().subtract(29, 'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        lrSearch_start_date = this.startDate.format(this.locale.format);
        lrSearch_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

// 查询操作
function lrSearchAction() {
    $('#lrQuery_storage').click(function () {
        var queryParameter = [];
        var objSelect = document.getElementById("lrPeopleSelect");
        if (null != objSelect && typeof(objSelect) != "undefined") {
            for (var i = 0; i < objSelect.options.length; i++) {
                if (objSelect.options[i].selected) {
                   /* console.log(objSelect.options[i]);*/
                    queryParameter.push(objSelect.options[i].value);
                }
            }
        }
        lrNowSelectPeople = queryParameter;
        if (queryParameter.length > 0) {
            lrSelectDeviceByTreeId();
        } else {
            var type = 'error';
            var msg = '未选择用户';
            var append = '对不起，您未选择用户，请重新选择';
            showMsg(type, msg, append);
        }
    })
}


//请求服务数据时所传参数
function lrQueryParams(params) {
    var queryParameter = lrNowSelectPeople;
    var queryStartDate = lrSearch_start_date;
    var queryEndDate = lrSearch_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sUserIds: queryParameter.join(','),
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function lrSelectDeviceByTreeId() {

    $('#lrDeviceList').bootstrapTable('destroy');

    $('#lrDeviceList').bootstrapTable({
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
        /*        //可供选择的每页的行数（*）
                pageList: [10, 25, 50, 100],*/
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //分页只显示分页不显示总页数等数据，结合本页的style，分页详细信息移动到右边
        paginationDetailHAlign:"right",
        /*onlyInfoPagination:true,*/
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/loginRecord/selectLoginInfoByUserIdsAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: lrQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: lrTableColumns,
    });
}
