var hisNowTreeNode;
var hisNowTreeNodeRoot;
var hisEC01TableColumns;
var hisSewageC01TableColumns;
var hisSewageC212TableColumns;
var hisSewageC214TableColumns;
var hisScaleC01TableColumns;
var hisHj212C213TableColumns;
var hisWeighC312TableColumns;
var hisFeedC411TableColumns;
var hisLhsp05p1TableColumns;
var hisLhsf0ap1TableColumns;
var hisTreeNodes;
var hisEC01search_start_date = null;
var hisEC01search_end_date = null;
var hisSewageC01search_start_date = null;
var hisSewageC01search_end_date = null;
var hisSewageC212search_start_date = null;
var hisSewageC212search_end_date = null;
var hisSewageC214search_start_date = null;
var hisSewageC214search_end_date = null;
var hisScaleC01search_start_date = null;
var hisScaleC01search_end_date = null;
var hisHj212C213search_start_date = null;
var hisHj212C213search_end_date = null;
var hisWeighC312search_start_date = null;
var hisWeighC312search_end_date = null;
var hisFeedC411search_start_date = null;
var hisFeedC411search_end_date = null;
var hisLhsp05p1search_start_date = null;
var hisLhsp05p1search_end_date = null;
var hisLhsf0ap1search_start_date = null;
var hisLhsf0ap1search_end_date = null;

$(function () {
    hisInitTreeNode();
    hisInitTableEC01();
    hisInitTableSewageC01();
    hisInitTableSewageC212();
    hisInitTableSewageC214();
    hisInitTableScaleC01();
    hisInitTableHj212C213();
    hisInitTableWeighC312();
    hisInitTableFeedC411();
    hisInitTableLhsp05p1();
    hisInitTableLhsf0ap1();
    hisExportStorageAction();
    //hisDatePickerInit();
    hisDateRangePickerInitEC01();
    hisDateRangePickerInitSewageC01();
    hisDateRangePickerInitSewageC212();
    hisDateRangePickerInitSewageC214();
    hisDateRangePickerInitScaleC01();
    hisDateRangePickerInitHj212C213();
    hisDateRangePickerInitWeighC312();
    hisDateRangePickerInitFeedC411();
    hisDateRangePickerInitLhsp05p1();
    hisDateRangePickerInitLhsf0ap1();
    hisSearchAction();

});

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

function hisGetRootNode(tree, treeNode) {
    if (treeNode.parentId === undefined)
        hisNowTreeNodeRoot = treeNode;
        return;
    var parentNode = tree.treeview('getNode', treeNode.parentId);
    if (parentNode.parentId !== undefined)
        hisGetRootNode(tree, parentNode);
    else
        hisNowTreeNodeRoot = parentNode;
}

function hisNodeSelected(event, data) {
    hisNowTreeNode = data;
    hisGetRootNode($('#hisOrgTree'), hisNowTreeNode);
    var uiEC01List = document.getElementById("hisEC01DeviceListDiv");
    var uiSewageC01List = document.getElementById("hisSewageC01DeviceListDiv");
    var uiSewageC212List = document.getElementById("hisSewageC212DeviceListDiv");
    var uiSewageC214List = document.getElementById("hisSewageC214DeviceListDiv");
    var uiScaleC01List = document.getElementById("hisScaleC01DeviceListDiv");
    var uiHj212C213List = document.getElementById("hisHj212C213DeviceListDiv");
    var uiWeighC312List = document.getElementById("hisWeighC312DeviceListDiv");
    var uiFeedC411List = document.getElementById("hisFeedC411DeviceListDiv");
    var uiLhsp05p1List = document.getElementById("hisLhsp05p1DeviceListDiv");
    var uiLhsf0ap1List = document.getElementById("hisLhsf0ap1DeviceListDiv");
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
    var rootNodeId = hisNowTreeNodeRoot.id;
    if (rootNodeId === "111")   //种禽环控器
    {
        uiEC01List.style.display = "block";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "211")  //立华禽环保1.0
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "block";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "212")  //立华禽环保2.0
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "block";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "214")  //立华禽环保3.0
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "block";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "311")  //自动称重
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "block";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "312")  //种禽散装料塔称重1.0
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "block";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "213" )  //水质在线监测
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "block";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "411" )  //饲料部筒仓测温1.0
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "block";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
        hisInitTableFeedC41102(data.id);
    }
    else if (rootNodeId === "LHSP05p1" )  //立华食品-冷库测温
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "block";
        uiLhsf0ap1List.style.display = "none";
    }
    else if (rootNodeId === "LHSF0Ap1" )  //立华生防-物资熏蒸
    {
        uiEC01List.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsf0ap1List.style.display = "block";
    }
}

//*****************EC01 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitEC01() {
    hisEC01search_start_date = NowWeeHours(); //凌晨
    hisEC01search_end_date = GetTodaytime(); //最晚时间
    $('#hisEC01DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisEC01search_start_date = this.startDate.format(this.locale.format);
        hisEC01search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableEC01() {
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
            hisEC01TableColumns = questionColumns;
            $('#hisEC01DeviceList').bootstrapTable('destroy');
            $('#hisEC01DeviceList').bootstrapTable({
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
function hisQueryParamsEC01(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisEC01search_start_date;
    var queryEndDate = hisEC01search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdEC01() {

    $('#hisEC01DeviceList').bootstrapTable('destroy');

    $('#hisEC01DeviceList').bootstrapTable({
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
        queryParams: hisQueryParamsEC01,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisEC01TableColumns,
        height: 500,             //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//*****************EC01 end*********************/
//*****************Sewage01 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitSewageC01() {
    hisSewageC01search_start_date = NowWeeHours(); //凌晨
    hisSewageC01search_end_date = GetTodaytime(); //最晚时间
    $('#hisSewageC01DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisSewageC01search_start_date = this.startDate.format(this.locale.format);
        hisSewageC01search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableSewageC01() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/sewagec01DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisSewageC01TableColumns = questionColumns;
            $('#hisSewageC01DeviceList').bootstrapTable('destroy');
            $('#hisSewageC01DeviceList').bootstrapTable({
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
function hisQueryParamsSewageC01(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisSewageC01search_start_date;
    var queryEndDate = hisSewageC01search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdSewageC01() {

    $('#hisSewageC01DeviceList').bootstrapTable('destroy');

    $('#hisSewageC01DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectSewageC01ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsSewageC01,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisSewageC01TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Sewage01 end*********************/
//*****************Sewage212 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitSewageC212() {
    hisSewageC212search_start_date = NowWeeHours(); //凌晨
    hisSewageC212search_end_date = GetTodaytime(); //最晚时间
    $('#hisSewageC212DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisSewageC212search_start_date = this.startDate.format(this.locale.format);
        hisSewageC212search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableSewageC212() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/sewagec212DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisSewageC212TableColumns = questionColumns;
            $('#hisSewageC212DeviceList').bootstrapTable('destroy');
            $('#hisSewageC212DeviceList').bootstrapTable({
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
function hisQueryParamsSewageC212(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisSewageC212search_start_date;
    var queryEndDate = hisSewageC212search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdSewageC212() {

    $('#hisSewageC212DeviceList').bootstrapTable('destroy');

    $('#hisSewageC212DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectSewageC212ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsSewageC212,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisSewageC212TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Sewage212 end*********************/

//*****************Sewage214 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitSewageC214() {
    hisSewageC214search_start_date = NowWeeHours(); //凌晨
    hisSewageC214search_end_date = GetTodaytime(); //最晚时间
    $('#hisSewageC214DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisSewageC214search_start_date = this.startDate.format(this.locale.format);
        hisSewageC214search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableSewageC214() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/sewagec214DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisSewageC214TableColumns = questionColumns;
            $('#hisSewageC214DeviceList').bootstrapTable('destroy');
            $('#hisSewageC214DeviceList').bootstrapTable({
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
function hisQueryParamsSewageC214(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisSewageC214search_start_date;
    var queryEndDate = hisSewageC214search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdSewageC214() {

    $('#hisSewageC214DeviceList').bootstrapTable('destroy');

    $('#hisSewageC214DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectSewageC214ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsSewageC214,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisSewageC214TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Sewage214 end*********************/

//*****************Scale start*********************/
// 日期选择器初始化
function hisDateRangePickerInitScaleC01() {
    hisScaleC01search_start_date = NowWeeHours(); //凌晨
    hisScaleC01search_end_date = GetTodaytime(); //最晚时间
    $('#hisScaleC01DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisScaleC01search_start_date = this.startDate.format(this.locale.format);
        hisScaleC01search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableScaleC01() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/scalec01DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisScaleC01TableColumns = questionColumns;
            $('#hisScaleC01DeviceList').bootstrapTable('destroy');
            $('#hisScaleC01DeviceList').bootstrapTable({
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
function hisQueryParamsScaleC01(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisScaleC01search_start_date;
    var queryEndDate = hisScaleC01search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdScaleC01() {

    $('#hisScaleC01DeviceList').bootstrapTable('destroy');

    $('#hisScaleC01DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectScaleC01ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsScaleC01,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisScaleC01TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Scale end*********************/

//*****************Hj212C213 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitHj212C213() {
    hisHj212C213search_start_date = NowWeeHours(); //凌晨
    hisHj212C213search_end_date = GetTodaytime(); //最晚时间
    $('#hisHj212C213DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisHj212C213search_start_date = this.startDate.format(this.locale.format);
        hisHj212C213search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableHj212C213() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/hj212C213DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisHj212C213TableColumns = questionColumns;
            $('#hisHj212C213DeviceList').bootstrapTable('destroy');
            $('#hisHj212C213DeviceList').bootstrapTable({
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
function hisQueryParamsHj212C213(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisHj212C213search_start_date;
    var queryEndDate = hisHj212C213search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdHj212C213() {

    $('#hisHj212C213DeviceList').bootstrapTable('destroy');

    $('#hisHj212C213DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectHj212C213ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsHj212C213,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisHj212C213TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Hj212C213 end*********************/

//*****************WeighC312 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitWeighC312() {
    hisWeighC312search_start_date = NowWeeHours(); //凌晨
    hisWeighC312search_end_date = GetTodaytime(); //最晚时间
    $('#hisWeighC312DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisWeighC312search_start_date = this.startDate.format(this.locale.format);
        hisWeighC312search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableWeighC312() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/weighc312DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisWeighC312TableColumns = questionColumns;
            $('#hisWeighC312DeviceList').bootstrapTable('destroy');
            $('#hisWeighC312DeviceList').bootstrapTable({
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
function hisQueryParamsWeighC312(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisWeighC312search_start_date;
    var queryEndDate = hisWeighC312search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdWeighC312() {

    $('#hisWeighC312DeviceList').bootstrapTable('destroy');

    $('#hisWeighC312DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectWeighC312ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsWeighC312,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisWeighC312TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************WeighC312 end*********************/

//*****************FeedC411 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitFeedC411() {
    hisFeedC411search_start_date = NowWeeHours(); //凌晨
    hisFeedC411search_end_date = GetTodaytime(); //最晚时间
    $('#hisFeedC411DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisFeedC411search_start_date = this.startDate.format(this.locale.format);
        hisFeedC411search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableFeedC411() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {devId:"411"},
        url: '/lihuaiot01/hisDeviceList/feedC411DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisFeedC411TableColumns = questionColumns;
            $('#hisFeedC411DeviceList').bootstrapTable('destroy');
            $('#hisFeedC411DeviceList').bootstrapTable({
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

function hisInitTableFeedC41102(devId) {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {devId:devId},
        url: '/lihuaiot01/hisDeviceList/feedC411DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisFeedC411TableColumns = questionColumns;
            $('#hisFeedC411DeviceList').bootstrapTable('destroy');
            $('#hisFeedC411DeviceList').bootstrapTable({
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
function hisQueryParamsFeedC411(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisFeedC411search_start_date;
    var queryEndDate = hisFeedC411search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdFeedC411() {

    $('#hisFeedC411DeviceList').bootstrapTable('destroy');

    $('#hisFeedC411DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectFeedC411ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsFeedC411,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisFeedC411TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//*****************FeedC411 end*********************/

//*****************Lhsp05p1 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitLhsp05p1() {
    hisLhsp05p1search_start_date = NowWeeHours(); //凌晨
    hisLhsp05p1search_end_date = GetTodaytime(); //最晚时间
    $('#hisLhsp05p1DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisLhsp05p1search_start_date = this.startDate.format(this.locale.format);
        hisLhsp05p1search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableLhsp05p1() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/lhsp05p1DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisLhsp05p1TableColumns = questionColumns;
            $('#hisLhsp05p1DeviceList').bootstrapTable('destroy');
            $('#hisLhsp05p1DeviceList').bootstrapTable({
                columns: questionColumns,
                // 显示下拉框勾选要显示的列
                showColumns : true,
                // 设置最少显示列个数
                minimumCountColumns: 2
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
function hisQueryParamsLhsp05p1(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisLhsp05p1search_start_date;
    var queryEndDate = hisLhsp05p1search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdLhsp05p1() {

    $('#hisLhsp05p1DeviceList').bootstrapTable('destroy');

    $('#hisLhsp05p1DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectLhsp05p1ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsLhsp05p1,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisLhsp05p1TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Lhsp05p1 end*********************/


//*****************Lhsf0ap1 start*********************/
// 日期选择器初始化
function hisDateRangePickerInitLhsf0ap1() {
    hisLhsf0ap1search_start_date = NowWeeHours(); //凌晨
    hisLhsf0ap1search_end_date = GetTodaytime(); //最晚时间
    $('#hisLhsf0ap1DateInterval').daterangepicker({
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
            '最近1小时': [moment().subtract(1,'hours'), moment()],
            '今日': [moment().startOf('day'), moment()],
            '昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
            '最近7日': [moment().subtract(6,'days'), moment()],
            '最近30日': [moment().subtract(29,'days'), moment()],
            '本月': [moment().startOf("month"), moment().endOf("month")],
            '上个月': [moment().subtract(1, "month").startOf("month"), moment().subtract(1, "month").endOf("month")]
        },
    }, function (start, end, label) {
        hisLhsf0ap1search_start_date = this.startDate.format(this.locale.format);
        hisLhsf0ap1search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisInitTableLhsf0ap1() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/hisDeviceList/lhsf0ap1DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align,visible:json[i].visible};//手动拼接columns
                questionColumns.push(temp);
            }
            hisLhsf0ap1TableColumns = questionColumns;
            $('#hisLhsf0ap1DeviceList').bootstrapTable('destroy');
            $('#hisLhsf0ap1DeviceList').bootstrapTable({
                columns: questionColumns,
                // 显示下拉框勾选要显示的列
                showColumns : true,
                // 设置最少显示列个数
                minimumCountColumns: 2
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
function hisQueryParamsLhsf0ap1(params) {
    var queryParameter = hisNowTreeNode.id;
    var queryStartDate = hisLhsf0ap1search_start_date;
    var queryEndDate = hisLhsf0ap1search_end_date;
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceId: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate,
    };
}

function hisSelectDeviceByTreeIdLhsf0ap1() {

    $('#hisLhsf0ap1DeviceList').bootstrapTable('destroy');

    $('#hisLhsf0ap1DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisDeviceList/selectLhsf0ap1ByDevNumAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisQueryParamsLhsf0ap1,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisLhsf0ap1TableColumns,
        height: 500,      //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//*****************Lhsf0ap1 end*********************/

// 导出信息
function hisExportStorageAction() {
    $('#hisEC01Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisSewageC01Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisSewageC212Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisSewageC214Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisScaleC01Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisHj212C213Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisWeighC312Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisFeedC411Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisLhsp05p1Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });
    $('#hisLhsf0ap1Export_storage').click(function () {
        $('#hisExport_modal').modal("show");
    });

    $('#hisExport_storage_download').click(function () {
        var queryParameter = hisNowTreeNode.id;
        var rootNodeId = hisNowTreeNodeRoot.id;
        var queryStartDate = hisEC01search_start_date;
        var queryEndDate = hisEC01search_end_date;
        var data = {
            sDeviceId: queryParameter,
            sStartDate: queryStartDate,
            sEndDate: queryEndDate
        };
        var url = "/lihuaiot01/hisDeviceList/exportHisEC01DeviceList?" + $.param(data);
        if (rootNodeId === "111")   //鸡舍环控器
        {
            //默认鸡舍环控器
        }
        else if (rootNodeId === "211")  //立华禽环保1.0
        {
            queryStartDate = hisSewageC01search_start_date;
            queryEndDate = hisSewageC01search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisSewageC01DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "212")  //立华禽环保2.0
        {
            queryStartDate = hisSewageC212search_start_date;
            queryEndDate = hisSewageC212search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisSewageC212DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "214")  //立华禽环保3.0
        {
            queryStartDate = hisSewageC214search_start_date;
            queryEndDate = hisSewageC214search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisSewageC214DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "311")  //自动称重
        {
            queryStartDate = hisScaleC01search_start_date;
            queryEndDate = hisScaleC01search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisScaleC01DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "312")  //种禽散装料塔称重1.0
        {
            queryStartDate = hisWeighC312search_start_date;
            queryEndDate = hisWeighC312search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisWeighC312DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "411")  //饲料部-筒仓测温1.0
        {
            queryStartDate = hisFeedC411search_start_date;
            queryEndDate = hisFeedC411search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisFeedC411DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "213")  //自动称重
        {
            queryStartDate = hisHj212C213search_start_date;
            queryEndDate = hisHj212C213search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisHj212C213DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "LHSP05p1")  //立华食品-冷库测温
        {
            queryStartDate = hisLhsp05p1search_start_date;
            queryEndDate = hisLhsp05p1search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisLhsp05p1DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "LHSF0Ap1")  //立华生防-物资熏蒸
        {
            queryStartDate = hisLhsf0ap1search_start_date;
            queryEndDate = hisLhsf0ap1search_end_date;
            data = {
                sDeviceId: queryParameter,
                sStartDate: queryStartDate,
                sEndDate: queryEndDate
            };
            url = "/lihuaiot01/hisDeviceList/exportHisLhsf0ap1DeviceList?" + $.param(data);
        }
        if (queryParameter.length == 4) {
            window.open(url, '_blank');
        }else if(queryParameter.length >= 14 && queryParameter.length <= 30) { //水质在线监测设备
            window.open(url, '_blank');
        } else if(queryParameter.length === 7 && rootNodeId === "411") { //饲料部-筒仓测温
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

// 查询操作
function hisSearchAction() {
    $('#hisEC01Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdEC01();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisSewageC01Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdSewageC01();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisSewageC212Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdSewageC212();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisSewageC214Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdSewageC214();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisScaleC01Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdScaleC01();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisHj212C213Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length >= 14 && queryParameter.length <= 30) {  //水质在线监测设备
            hisSelectDeviceByTreeIdHj212C213();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisWeighC312Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdWeighC312();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisFeedC411Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 7) {
            hisSelectDeviceByTreeIdFeedC411();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisLhsp05p1Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdLhsp05p1();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });

    $('#hisLhsf0ap1Query_storage').click(function () {
        var queryParameter = hisNowTreeNode.id;
        if (queryParameter.length == 4) {
            hisSelectDeviceByTreeIdLhsf0ap1();
        } else {
            var type = 'error';
            var msg = '未选择设备';
            var append = '对不起，您未选择具体设备，请重新选择';
            showMsg(type, msg, append);
        }
    });
}
