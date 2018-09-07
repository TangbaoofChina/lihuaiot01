var hisChartNowDeviceIds = [];
var hisChartSelectDeviceIds = [];
var hisChartNowDataTimeList = [];
var hisChartTableColumns;
var hisChartbeginTimeStore = '';
var hisChartendTimeStore = '';
var hisChartTreeNodes;
var hisChart;
// 指定图表的配置项和数据
var hisChartoptionInit = {
    title: {
        text: '示例曲线'
    },
    tooltip: {trigger: 'axis'},
    toolbox: {
        show: true,
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ["line", "bar"]},
            restore: {show: false},
            saveAsImage: {show: true}
        }
    },
    legend: {
        data: ['销量1']
    },
    xAxis: {
        data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
    },
    yAxis: {
        min: function (value) {
            return value.min - 5;
        },
        max: function (value) {
            return value.max + 5;
        }
    },
    series: [{
        name: '销量1',
        type: 'line',
        symbol: 'circle',
        symbolSize: 8,
        data: [5, 20, 36, 10, 10, 20]
    }]
};

// 指定图表的配置项和数据
var hisChartoption = {
    title: {
        text: '历史曲线'
    },
    tooltip: {trigger: 'axis'},
    toolbox: {
        show: true,
        feature: {
            mark: {show: true},
            dataView: {show: true, readOnly: false},
            magicType: {show: true, type: ["line", "bar"]},
            restore: {show: false},
            saveAsImage: {show: true}
        }
    },
    legend: {
        data: []
    },
    xAxis: {
        data: [],
        axisLabel: {
            formatter: function (category) {
                return category.substring(0, 16);
            }
        }
    },
    yAxis: {
        min: function (value) {
            return Math.floor(value.min - 3);
        },
        max: function (value) {
            return Math.floor(value.max + 3);
        }
    },
    series: []
};

var chartYAxis = {
    min: function (value) {
        return Math.floor(value.min - 3);
    },
    max: function (value) {
        return Math.floor(value.max + 3);
    }
}


var hisChartMultiselectset = {
    enableFiltering: true,//搜索
    includeSelectAllOption: true,//全选
    nonSelectedText: '请选择...',//没有值的时候button显示值
    inheritClass: true,//继承原来select的button的class
    buttonContainer: '<div class="btn-group" />',//承载按钮和下拉框
    selectedClass: 'multiselect-selected',//选中项样式
    nSelectedText: '个被选中',//有n个值的时候显示n个被选中
    allSelectedText: '全选',//所有被选中的时候 全选（n）
    buttonWidth: '320px',//button宽度
    numberDisplayed: 11,//当超过10个标签的时候显示n个被选中
    selectAllText: '全选',
    disableIfEmpty: true,//没有选项时readonly
    templates: {
        button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown" style="text-align:center;background-color: #ffffff;border: 1px solid #e5e5e5;"><span class="multiselect-selected-text"></span></button>',
        ul: '<ul class="multiselect-container dropdown-menu" style="max-height: 200px;overflow-x: hidden;overflow-y: auto;-webkit-tap-highlight-color: rgba(0,0,0,0);"></ul>',
        filter: '<li class="multiselect-item multiselect-filter"><div class="input-group"><span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
        filterClearBtn: '<span class="input-group-btn"></span>',
        li: '<li><a tabindex="0"><label style="margin-left:2%;"></label></a></li>',
        divider: '<li class="multiselect-item divider"></li>',
        liGroup: '<li class="multiselect-item multiselect-group"><label></label></li>'
    }
};

$(function () {
    hisChartInitMultiselect();
    //hisChartInitBootstrapSuggest();
    hisChartInitTreeNode();
    hisChartInitChart(hisChartoptionInit);
    /*var myDiv = document.getElementById("hisChartTableDiv");
    myDiv.style.width = window.innerWidth * 0.7 + 'px';*/
    $("#hisChartTableDiv").width(window.innerWidth * 0.6 + 'px');
    hisChartInitTable();
    hisChartExportStorageAction();
    hisChartDateRangePickerInit();
    hisChartSearchAction();
    hisChartDatePickerInit();
});

// 日期选择器初始化
function hisChartDatePickerInit() {
    $("#hisChartSelectDate").datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        minView: 2,//设置只显示到天
        endDate: new Date(),
        weekStart: 1,
        todayBtn: true,
        autoClose: true,
        todayHighlight: true,
        startView: 2,
        forceParse: true
    });
}

function hisChartAddDateToList() {
    var selectDate = $("#hisChartSelectDate").val();
    if (selectDate === "")
        return;
    var dateTimeList = $("#hisChartDateTimeList");
    dateTimeList.append("<option value='" + selectDate + "'>" + selectDate + "</option>");
    $("#hisChartDateTimeList option").each(function () {
        var val = selectDate;
        if ($("#hisChartDateTimeList option[value='" + selectDate + "']").length > 1) {
            $("#hisChartDateTimeList option[value='" + selectDate + "']:gt(0)").remove();
        }
    });
}

function hisChartRemoveDateToList() {
    var selectDate = $("#hisChartDateTimeList").val();
    var dateTimeList = $("#hisChartDateTimeList");
    $("#hisChartDateTimeList option").each(function () {
        var val = selectDate;
        if ($("#hisChartDateTimeList option[value='" + selectDate + "']").length > 0) {
            $("#hisChartDateTimeList option[value='" + selectDate + "']").remove();
        }
    });
}

function hisChartClearDateToList() {
    $("#hisChartDateTimeList").empty();
}

function hisChartQueryDateToList() {
    var dateTimeList = new Array();
    $("#hisChartDateTimeList option").each(function () {
        var text = $(this).text();
        if (text != '') {
            dateTimeList.push(text);
        }
    });
    if (dateTimeList.length < 1)
        return;
    hisChartNowDeviceIds = [];
    var selectValueStr = [];
    $("#hisChartsel_search option:selected").each(function () {
        selectValueStr.push($(this).val());
    });
    hisChartNowDeviceIds = selectValueStr;
    if (hisChartNowDeviceIds.length != 1) {
        var type = 'warning';
        var msg = '只能选择一个设备';
        var append = '对不起，这是同一设备不同日期间的比较';
        showMsg(type, msg, append);
        return;
    }
    hisChartNowDataTimeList = dateTimeList;
    hisChartQueryHisDataByIdAndDateTime();
    hisChartReSelectHisDataByIdAndDateTimeTableHead();
}

function hisChartQueryHisDataByIdAndDateTime() {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var queryParamMaxThreshold = document.getElementById("hisChartMaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartMinThreshold").value; //最小阈值
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sQueryParam: queryParameter,
        sDateTimeList: hisChartNowDataTimeList.join(',')
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectEC01ByIdAndDateTimeChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                var json = eval(result); //数组
                var optionstring1 = json.chartsParameters.dParameterName;
                var optionstring2 = json.chartsParameters.dParameterTime;
                var optionstring3 = json.chartsParameters.dParameterdata;
                hisChartoption.title.text = "数据曲线";
                hisChartoption.legend.data = optionstring1;
                hisChartoption.xAxis.data = optionstring2;
                if (queryParameter === "日温饮水") {
                    hisChartoption.yAxis = json.eChartsYAxisList;
                } else {
                    hisChartoption.yAxis = chartYAxis
                }
                hisChartoption.series = [];
                for (var k = 0, length = optionstring3.length; k < length; k++) {
                    hisChartoption.series.push(optionstring3[k]);
                }
                // 使用刚指定的配置项和数据显示图表。
                //myChart.clear();
                hisChartRepaintChart(hisChartoption);
                //myChart.setOption(hisChartoption);
            } else {
                var type = 'warning';
                var msg = '未查询到历史数据';
                var append = '对不起，未查询到您要的数据，请重新选择设备或时间';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function hisChartInitTreeNode() {
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
                hisChartTreeNodes = json;
                /*console.log(rdlTreeNodes);*/
                $('#hisChartOrgTree').treeview({
                    data: hisChartTreeNodes,
                    showTags: true,
                    showCheckbox: true,
                    onNodeChecked: nodeChecked,
                    onNodeUnchecked: nodeUnchecked,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: hisChartNodeSelected
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

function hisChartNodeSelected(event, data) {
    if (data.nodes != null) {
        var select_node = $('#hisChartOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#hisChartOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#hisChartOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
}

function hisChartInitChart(hisChartoption) {
    var mainContainer = document.getElementById('echartsmain');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.6 + 'px';
        mainContainer.style.height = window.innerHeight * 0.42 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    hisChart = echarts.init(mainContainer);
    hisChart.clear();
    hisChart.setOption(hisChartoption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        hisChart.resize();
    });
}

function hisChartRepaintChart(hisChartoption) {
    hisChart.clear();
    hisChart.setOption(hisChartoption);
}

function hisChartSelectDeviceByIdsChart() {
    //var myChart = echarts.init(document.getElementById('echartsmain'), 'macarons');
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var queryParamMaxThreshold = document.getElementById("hisChartMaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartMinThreshold").value; //最小阈值
    var queryStartDate = hisChartbeginTimeStore;
    var queryEndDate = hisChartendTimeStore;
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectEC01ByIdsAndDateChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                var json = eval(result); //数组
                var optionstring1 = json.chartsParameters.dParameterName;
                var optionstring2 = json.chartsParameters.dParameterTime;
                var optionstring3 = json.chartsParameters.dParameterdata;
                hisChartoption.title.text = "数据曲线";
                hisChartoption.legend.data = optionstring1;
                hisChartoption.xAxis.data = optionstring2;
                if (queryParameter === "日温饮水") {
                    hisChartoption.yAxis = json.eChartsYAxisList;
                } else {
                    hisChartoption.yAxis = chartYAxis
                }
                hisChartoption.series = [];
                for (var k = 0, length = optionstring3.length; k < length; k++) {
                    hisChartoption.series.push(optionstring3[k]);
                }
                // 使用刚指定的配置项和数据显示图表。
                //myChart.clear();
                hisChartRepaintChart(hisChartoption);
                //myChart.setOption(hisChartoption);
            } else {
                var type = 'warning';
                var msg = '未查询到历史数据';
                var append = '对不起，未查询到您要的数据，请重新选择设备或时间';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function hisChartInitTable() {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParameter = ""; // 选中文本
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sQueryParam: queryParameter
    };
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        async: true,   // 轻轻方式-异步
        data: data,
        url: '/lihuaiot01/hisChartDevice/ec01DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                questionColumns.push(temp);
            }
            hisChartTableColumns = questionColumns;

            $('#hisChartDeviceList').bootstrapTable('destroy');
            $('#hisChartDeviceList').bootstrapTable({
                columns: questionColumns
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
function hisChartQueryParams(params) {
    var queryStartDate = hisChartbeginTimeStore;
    var queryEndDate = hisChartendTimeStore;
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamMaxThreshold = document.getElementById("hisChartMaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartMinThreshold").value; //最小阈值
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
}

//请求服务数据时所传参数
function hisChartQueryParamsDtl(params) {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var queryParamMaxThreshold = document.getElementById("hisChartMaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartMinThreshold").value; //最小阈值
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sQueryParam: queryParameter,
        sDateTimeList: hisChartNowDataTimeList.join(',')
    };
}

function hisChartReSelectHisDataTableHead() {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sQueryParam: queryParameter
    };
    $.ajax({
        url: "/lihuaiot01/hisChartDevice/ec01DeviceHead",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: data,
        success: function (result) {
            var questionColumns = [];
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                questionColumns.push(temp);
            }
            hisChartTableColumns = questionColumns;
            hisChartSelectDeviceByIdsTable();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function hisChartSelectDeviceByIdsTable() {
    //table不能每次都初始化，所以每次需要先销毁
    $('#hisChartDeviceList').bootstrapTable('destroy');

    $('#hisChartDeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisChartDevice/selectEC01ByIdsAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisChartQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisChartTableColumns
    });
}

function hisChartReSelectHisDataByIdAndDateTimeTableHead() {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sDateTimeList: hisChartNowDataTimeList.join(','),
        sQueryParam: queryParameter
    };
    $.ajax({
        url: "/lihuaiot01/hisChartDevice/ec01DeviceDataTimeHead",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: data,
        success: function (result) {
            var questionColumns = [];
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                questionColumns.push(temp);
            }
            hisChartTableColumns = questionColumns;
            hisChartReSelectHisDataByIdAndDateTimeTable();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function hisChartReSelectHisDataByIdAndDateTimeTable() {
    //table不能每次都初始化，所以每次需要先销毁
    $('#hisChartDeviceList').bootstrapTable('destroy');

    $('#hisChartDeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisChartDevice/selectEC01ByIdsAndDtlAndPg",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisChartQueryParamsDtl,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisChartTableColumns
    });
}

// 导出信息
function hisChartExportStorageAction() {
    $('#hisChartExport_storage').click(function () {
        $('#export_modal').modal("show");
    });

    $('#hisChartExport_storage_download').click(function () {
        var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
        var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
        var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
        if (queryParameter === "单舍饮水量" || queryParameter === "单舍温度") {
            HisChartExportDataDtl();
        } else {
            HisChartExportData();
        }
        $('#export_modal').modal("hide");
    })
}

function HisChartExportData() {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var queryParamMaxThreshold = document.getElementById("hisChartMaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartMinThreshold").value; //最小阈值
    var queryStartDate = hisChartbeginTimeStore;
    var queryEndDate = hisChartendTimeStore;
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    var url = "/lihuaiot01/hisChartDevice/exportHisDeviceList?" + $.param(data);
    window.open(url, '_blank');
}

function HisChartExportDataDtl() {
    var queryParamObj = document.getElementById("hisChartSelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var queryParamMaxThreshold = document.getElementById("hisChartMaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartMinThreshold").value; //最小阈值
    var data = {
        sDeviceIds: hisChartNowDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sQueryParam: queryParameter,
        sDateTimeList: hisChartNowDataTimeList.join(',')
    };
    var url = "/lihuaiot01/hisChartDevice/exportHisDeviceListDtl?" + $.param(data);
    window.open(url, '_blank');
}

// 日期选择器初始化
function hisChartDateRangePickerInit() {
    hisChartbeginTimeStore = NowWeeHours(); //凌晨
    hisChartendTimeStore = GetTodaytime(); //最晚时间
    $('#hisChartDateInterval').daterangepicker({
        "timePicker": true,
        "timePicker24Hour": true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'right',    // 日期选择框的弹出位置
        separator: ' 至 ',
        locale: {
            format: 'YYYY-MM-DD HH:mm:ss',
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
        hisChartbeginTimeStore = this.startDate.format(this.locale.format);
        hisChartendTimeStore = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

// 查询操作
function hisChartSearchAction() {
    $('#hisChartQuery_storage').click(function () {
        var selectValueStr = [];
        hisChartNowDeviceIds = [];
        var queryValue = $("#hisChartSelId_Param").val(); // 选中文本的value值
        //如果是“日温饮水”需要把参照的日温放在第一个
        if (queryValue === "7") {
            var firstVal = $("#hisChartDeviceTempSelect").val();
            selectValueStr.push(firstVal);
            $("#hisChartsel_search option:selected").each(function () {
                if ($(this).val() !== firstVal) {
                    selectValueStr.push($(this).val());
                }
            });
        } else {
            $("#hisChartsel_search option:selected").each(function () {
                selectValueStr.push($(this).val());
            });
        }
        hisChartNowDeviceIds = selectValueStr;
        hisChartSelectDeviceByIdsChart();
        hisChartReSelectHisDataTableHead();
        /*hisChartSelectDeviceByIdsChart01();*/
    })
}

function hisChartInitMultiselect() {
    //multiselect初始化
    $.ajax({
        type: 'POST',
        data: {},
        async: true,   // 轻轻方式-异步
        url: '/lihuaiot01/hisChartDevice/selectDevicesPost',
        dataType: "json",
        success: function (result) {
            $("#hisChartsel_search").html("");
            for (var i = 0; i < result.length; i++) {
                $("#hisChartsel_search").append("<option value='" + result[i].dSerialNum + "' title='" + result[i].dNodeName + "'>" + result[i].dName + "</option>");
            }
            $('#hisChartsel_search').multiselect(hisChartMultiselectset);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function hisChartParamChange() {
    var objS = document.getElementById("hisChartSelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    if (paramValue === "6") {
        $("#hisChartThresholdDiv").css("display", "block");//
    } else {
        $("#hisChartThresholdDiv").css("display", "none");//
    }
    if (paramValue === "7") {
        $("#hisChartTempWaterDiv").css("display", "block");//
    } else {
        $("#hisChartTempWaterDiv").css("display", "none");//
    }
    if (paramValue === "8" || paramValue === "9") {
        $("#hisChartDateRangeDiv").css("display", "none");//
        $("#hisChartDateTimeDiv").css("display", "block");//
    } else {
        $("#hisChartDateRangeDiv").css("display", "block");//
        $("#hisChartDateTimeDiv").css("display", "none");//
    }

}

function hisChartAddDeviceToList(selectValue, selectName) {
    if (selectValue === "")
        return;
    var deviceList = $("#hisChartDeviceTempSelect");
    deviceList.append("<option value='" + selectValue + "'>" + selectName + "</option>");
    $("#hisChartDeviceTempSelect option").each(function () {
        if ($("#hisChartDeviceTempSelect option[value='" + selectValue + "']").length > 1) {
            $("#hisChartDeviceTempSelect option[value='" + selectValue + "']:gt(0)").remove();
        }
    });
}

function hisChartRemoveDeviceToList(selectValue) {
    if (selectValue === "")
        return;
    $("#hisChartDeviceTempSelect option").each(function () {
        if ($("#hisChartDeviceTempSelect option[value='" + selectValue + "']").length > 0) {
            $("#hisChartDeviceTempSelect option[value='" + selectValue + "']").remove();
        }
    });
}

/***************************级联勾选*********************/
function hisChartSelectDeviceIdsRemove(queryParameter) {
    var index = hisChartSelectDeviceIds.indexOf(queryParameter);
    if (index > -1) {
        hisChartSelectDeviceIds.splice(index, 1);
    }
};

function hisChartSelectDeviceIdsContains(queryParameter) {
    var i = hisChartSelectDeviceIds.length;
    while (i--) {
        if (hisChartSelectDeviceIds[i] === queryParameter) {
            return true;
        }
    }
    return false;
};
var nodeCheckedSilent = false;

function nodeChecked(event, node) {
    if (nodeCheckedSilent) {
        return;
    }
    nodeCheckedSilent = true;
    var queryParameter = node.id;
    if (queryParameter.length == 4) {
        if (!hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIds.push(queryParameter);
            var queryName = node.text;
            hisChartAddDeviceToList(queryParameter, queryName);
        }
    }
    checkAllParent(node);
    checkAllSon(node);
    $("#hisChartsel_search").val(hisChartSelectDeviceIds);
    $("#hisChartsel_search").multiselect('refresh');
    nodeCheckedSilent = false;
}

var nodeUncheckedSilent = false;

function nodeUnchecked(event, node) {
    if (nodeUncheckedSilent)
        return;
    nodeUncheckedSilent = true;
    var queryParameter = node.id;
    if (queryParameter.length == 4) {
        hisChartSelectDeviceIdsRemove(queryParameter);
        hisChartRemoveDeviceToList(queryParameter);
    }
    uncheckAllParent(node);
    uncheckAllSon(node);
    $("#hisChartsel_search").val(hisChartSelectDeviceIds);
    $("#hisChartsel_search").multiselect('refresh');
    nodeUncheckedSilent = false;
}


//选中全部父节点
function checkAllParent(node) {
    $('#hisChartOrgTree').treeview('checkNode', node.nodeId, {silent: true});
    var parentNode = $('#hisChartOrgTree').treeview('getParent', node.nodeId);
    if (!("nodeId" in parentNode)) {
        return;
    } else {
        checkAllParent(parentNode);
    }
}

//取消全部父节点
function uncheckAllParent(node) {
    $('#hisChartOrgTree').treeview('uncheckNode', node.nodeId, {silent: true});
    var siblings = $('#hisChartOrgTree').treeview('getSiblings', node.nodeId);
    var parentNode = $('#hisChartOrgTree').treeview('getParent', node.nodeId);
    if (!("nodeId" in parentNode)) {
        return;
    }
    var isAllUnchecked = true;  //是否全部没选中
    for (var i in siblings) {
        if (siblings[i].state.checked) {
            isAllUnchecked = false;
            break;
        }
    }
    if (isAllUnchecked) {
        uncheckAllParent(parentNode);
    }
}

//级联选中所有子节点
function checkAllSon(node) {
    $('#hisChartOrgTree').treeview('checkNode', node.nodeId, {silent: true});
    var queryParameter = node.id;
    if (queryParameter.length == 4) {
        if (!hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIds.push(queryParameter);
            var queryName = node.text;
            hisChartAddDeviceToList(queryParameter, queryName);
        }
    }
    if (node.nodes != null && node.nodes.length > 0) {
        for (var i in node.nodes) {
            checkAllSon(node.nodes[i]);
        }
    }
}

//级联取消所有子节点
function uncheckAllSon(node) {
    $('#hisChartOrgTree').treeview('uncheckNode', node.nodeId, {silent: true});
    var queryParameter = node.id;
    if (queryParameter.length == 4) {
        if (hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIdsRemove(queryParameter);
            hisChartRemoveDeviceToList(queryParameter);
        }
    }
    if (node.nodes != null && node.nodes.length > 0) {
        for (var i in node.nodes) {
            uncheckAllSon(node.nodes[i]);
        }
    }
}







