var hisChartNowDeviceIds = [];
var hisChartSelectDeviceIds = [];
var hisChartNowDataTimeList = [];
var hisChartTableColumns;
var hisChartbeginTimeStore = '';
var hisChartendTimeStore = '';
var hisChartTreeNodes;
var hisChart;
var hisChartScaleC01;
var hisChartNowTreeNodeRoot;
var hisChartNowTreeNode;
var hisChartScaleC01TableColumns;
var hisChartScaleC01search_start_date;
var hisChartScaleC01search_end_date;
var hisChartHj212C213;
var hisChartHj212C213search_start_date;
var hisChartHj212C213search_end_date;
var hisChartFeedC411;
var hisChartFeedC411search_start_date;
var hisChartFeedC411search_end_date;
var hisChartLhsp05p1;
var hisChartLhsp05p1search_start_date;
var hisChartLhsp05p1search_end_date;
var hisChartLhfh05p1;
var hisChartLhfh05p1search_start_date;
var hisChartLhfh05p1search_end_date;

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
};

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

    hisChartScaleC01InitChart(hisChartoptionInit);
    hisChartDateRangePickerInitScaleC01();
    $("#hisChartScaleC01TableDiv").width(window.innerWidth * 0.6 + 'px');
    hisChartScaleC01InitTable();

    hisChartHj212C213InitChart(hisChartoptionInit);
    hisChartDateRangePickerInitHj212C213();

    hisChartFeedC411InitChart(hisChartoptionInit);
    hisChartDateRangePickerInitFeedC411();

    hisChartLhsp05p1InitChart(hisChartoptionInit);
    hisChartDateRangePickerInitLhsp05p1();

    hisChartLhfh05p1InitChart(hisChartoptionInit);
    hisChartDateRangePickerInitLhfh05p1();
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

function hisChartGetRootNode(tree, treeNode) {
    if (treeNode.parentId === undefined) {
        hisChartNowTreeNodeRoot = treeNode;
        return;
    }
    var parentNode = tree.treeview('getNode', treeNode.parentId);
    if (parentNode.parentId !== undefined)
        hisChartGetRootNode(tree, parentNode);
    else {
        hisChartNowTreeNodeRoot = parentNode;
    }
}

function hisChartNodeSelected(event, data) {
    hisChartNowTreeNode = data;
    hisChartGetRootNode($('#hisChartOrgTree'), hisChartNowTreeNode);
    var hcEC01DivP1 = document.getElementById("hisChartEC01DivP1");
    var hcEC01DivP2 = document.getElementById("hisChartEC01DivP2");
    var hcSewageC01Div = document.getElementById("hisChartSewageC01Div");
    var hcScaleC01DivP1 = document.getElementById("hisChartScaleC01DivP1");
    var hcScaleC01DivP2 = document.getElementById("hisChartScaleC01DivP2");
    var hcHj212C213DivP1 = document.getElementById("hisChartHj212C213DivP1");
    var hcHj212C213DivP2 = document.getElementById("hisChartHj212C213DivP2");
    var hcFeedC411DivP1 = document.getElementById("hisChartFeedC411DivP1");
    var hcFeedC411DivP2 = document.getElementById("hisChartFeedC411DivP2");
    var hcLhsp05p1DivP1 = document.getElementById("hisChartLhsp05p1DivP1");
    var hcLhsp05p1DivP2 = document.getElementById("hisChartLhsp05p1DivP2");
    var hcLhfh05p1DivP1 = document.getElementById("hisChartLhfh05p1DivP1");
    var hcLhfh05p1DivP2 = document.getElementById("hisChartLhfh05p1DivP2");
    var rootNodeId = hisChartNowTreeNodeRoot.id;
    if (rootNodeId === "111")   //种禽环控器
    {
        hcEC01DivP1.style.display = "block";
        hcEC01DivP2.style.display = "block";
        hcSewageC01Div.style.display = "none";
        hcScaleC01DivP1.style.display = "none";
        hcScaleC01DivP2.style.display = "none";
        hcHj212C213DivP1.style.display = "none";
        hcHj212C213DivP2.style.display = "none";
        hcFeedC411DivP1.style.display = "none";
        hcFeedC411DivP2.style.display = "none";
        hcLhsp05p1DivP1.style.display = "none";
        hcLhsp05p1DivP2.style.display = "none";
        hcLhfh05p1DivP1.style.display = "none";
        hcLhfh05p1DivP2.style.display = "none";
    }
    else if (rootNodeId === "211")  //立华禽环保1.0
    {
        hcEC01DivP1.style.display = "none";
        hcEC01DivP2.style.display = "none";
        hcSewageC01Div.style.display = "block";
        hcScaleC01DivP1.style.display = "none";
        hcScaleC01DivP2.style.display = "none";
        hcHj212C213DivP1.style.display = "none";
        hcHj212C213DivP2.style.display = "none";
        hcFeedC411DivP1.style.display = "none";
        hcFeedC411DivP2.style.display = "none";
        hcLhsp05p1DivP1.style.display = "none";
        hcLhsp05p1DivP2.style.display = "none";
        hcLhfh05p1DivP1.style.display = "none";
        hcLhfh05p1DivP2.style.display = "none";
    }
    else if (rootNodeId === "311")  //自动称重
    {
        hcEC01DivP1.style.display = "none";
        hcEC01DivP2.style.display = "none";
        hcSewageC01Div.style.display = "none";
        hcScaleC01DivP1.style.display = "block";
        hcScaleC01DivP2.style.display = "block";
        hcHj212C213DivP1.style.display = "none";
        hcHj212C213DivP2.style.display = "none";
        hcFeedC411DivP1.style.display = "none";
        hcFeedC411DivP2.style.display = "none";
        hcLhsp05p1DivP1.style.display = "none";
        hcLhsp05p1DivP2.style.display = "none";
        hcLhfh05p1DivP1.style.display = "none";
        hcLhfh05p1DivP2.style.display = "none";
    }
    else if (rootNodeId === "213")  //水质在线监测
    {
        hcEC01DivP1.style.display = "none";
        hcEC01DivP2.style.display = "none";
        hcSewageC01Div.style.display = "none";
        hcScaleC01DivP1.style.display = "none";
        hcScaleC01DivP2.style.display = "none";
        hcHj212C213DivP1.style.display = "block";
        hcHj212C213DivP2.style.display = "block";
        hcFeedC411DivP1.style.display = "none";
        hcFeedC411DivP2.style.display = "none";
        hcLhsp05p1DivP1.style.display = "none";
        hcLhsp05p1DivP2.style.display = "none";
        hcLhfh05p1DivP1.style.display = "none";
        hcLhfh05p1DivP2.style.display = "none";
    }
    else if (rootNodeId === "411")  //饲料部-筒仓测温
    {
        hcEC01DivP1.style.display = "none";
        hcEC01DivP2.style.display = "none";
        hcSewageC01Div.style.display = "none";
        hcScaleC01DivP1.style.display = "none";
        hcScaleC01DivP2.style.display = "none";
        hcHj212C213DivP1.style.display = "none";
        hcHj212C213DivP2.style.display = "none";
        hcFeedC411DivP1.style.display = "block";
        hcFeedC411DivP2.style.display = "block";
        hcLhsp05p1DivP1.style.display = "none";
        hcLhsp05p1DivP2.style.display = "none";
        hcLhfh05p1DivP1.style.display = "none";
        hcLhfh05p1DivP2.style.display = "none";
    }
    else if (rootNodeId === "LHSP05p1")  //立华食品-冷库测温
    {
        hcEC01DivP1.style.display = "none";
        hcEC01DivP2.style.display = "none";
        hcSewageC01Div.style.display = "none";
        hcScaleC01DivP1.style.display = "none";
        hcScaleC01DivP2.style.display = "none";
        hcHj212C213DivP1.style.display = "none";
        hcHj212C213DivP2.style.display = "none";
        hcFeedC411DivP1.style.display = "none";
        hcFeedC411DivP2.style.display = "none";
        hcLhsp05p1DivP1.style.display = "block";
        hcLhsp05p1DivP2.style.display = "block";
        hcLhfh05p1DivP1.style.display = "none";
        hcLhfh05p1DivP2.style.display = "none";
    }
    else if (rootNodeId === "LHFH05p1")  //立华孵化-GPS测温
    {
        hcEC01DivP1.style.display = "none";
        hcEC01DivP2.style.display = "none";
        hcSewageC01Div.style.display = "none";
        hcScaleC01DivP1.style.display = "none";
        hcScaleC01DivP2.style.display = "none";
        hcHj212C213DivP1.style.display = "none";
        hcHj212C213DivP2.style.display = "none";
        hcFeedC411DivP1.style.display = "none";
        hcFeedC411DivP2.style.display = "none";
        hcLhsp05p1DivP1.style.display = "none";
        hcLhsp05p1DivP2.style.display = "none";
        hcLhfh05p1DivP1.style.display = "block";
        hcLhfh05p1DivP2.style.display = "block";
    }
    var nodeId = hisChartNowTreeNode.id;
    if(rootNodeId === "411" && nodeId.length === 7){
        hisChartSelectFeedC411Params(nodeId);
    }
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
    $('#hisChartScaleC01Export_storage').click(function () {
        $('#exportScaleC01_modal').modal("show");
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
    });

    $('#hisChartScaleC01Export_storage_download').click(function () {
        HisChartScaleC01ExportData();
        $('#exportScaleC01_modal').modal("hide");
    });

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
        if (hisChartNowDeviceIds.length < 1) {
            var type = 'warning';
            var msg = '必须选择一个设备';
            var append = '未选择设备无法进行数据分析';
            showMsg(type, msg, append);
            return;
        }
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

//ec01参数发生改变
function hisChartParamChange() {
    var objS = document.getElementById("hisChartSelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    if (paramValue === "6") { //日饮水量
        $("#hisChartThresholdDiv").css("display", "block");// 最大，最小阈值
        $("#hisChartTempWaterDiv").css("display", "none");// 日温参照
        $("#hisChartDateRangeDiv").css("display", "block");// bootstrap日期范围选择控件
        $("#hisChartDateTimeDiv").css("display", "none");// 时间list 为单舍饮水量、单舍温度服务
    } else if (paramValue === "7") { //日温饮水
        $("#hisChartThresholdDiv").css("display", "block");//最大，最小阈值
        $("#hisChartTempWaterDiv").css("display", "block");//日温参照
        $("#hisChartDateRangeDiv").css("display", "block");//bootstrap日期范围选择控件
        $("#hisChartDateTimeDiv").css("display", "none");//时间list 为单舍饮水量、单舍温度服务
    } else if (paramValue === "8" || paramValue === "9") {  //单舍饮水量\单舍温度
        $("#hisChartThresholdDiv").css("display", "block");//最大，最小阈值
        $("#hisChartTempWaterDiv").css("display", "none");//日温参照
        $("#hisChartDateRangeDiv").css("display", "none");//bootstrap日期范围选择控件
        $("#hisChartDateTimeDiv").css("display", "block");//时间list 为单舍饮水量、单舍温度服务
    } else if (paramValue === "10") {  //多舍日饮水量
        $("#hisChartThresholdDiv").css("display", "block");//最大，最小阈值
        $("#hisChartTempWaterDiv").css("display", "none");//日温参照
        $("#hisChartDateRangeDiv").css("display", "block");//bootstrap日期范围选择控件
        $("#hisChartDateTimeDiv").css("display", "none");//时间list 为单舍饮水量、单舍温度服务
    } else {   //其他
        $("#hisChartThresholdDiv").css("display", "none");//最大，最小阈值
        $("#hisChartTempWaterDiv").css("display", "none");//日温参照
        $("#hisChartDateRangeDiv").css("display", "block");//bootstrap日期范围选择控件
        $("#hisChartDateTimeDiv").css("display", "none");//时间list 为单舍饮水量、单舍温度服务
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

/***************************ScaleC01 Start*********************/
function hisChartScaleC01RepaintChart(hisChartoption) {
    hisChartScaleC01.clear();
    hisChartScaleC01.setOption(hisChartoption);
}

function hisChartScaleC01InitChart(hisChartoption) {
    var mainContainer = document.getElementById('echartsScaleC01main');
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
    hisChartScaleC01 = echarts.init(mainContainer);
    hisChartScaleC01.clear();
    hisChartScaleC01.setOption(hisChartoption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        hisChartScaleC01.resize();
    });
}

// 日期选择器初始化
function hisChartDateRangePickerInitScaleC01() {
    hisChartScaleC01search_start_date = NowWeeHours(); //凌晨
    hisChartScaleC01search_end_date = GetTodaytime(); //最晚时间
    $('#hisChartScaleC01DateInterval').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'left',    // 日期选择框的弹出位置
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
        hisChartScaleC01search_start_date = this.startDate.format(this.locale.format);
        hisChartScaleC01search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisChartScaleC01InitTable() {
    var queryParamObj = document.getElementById("hisChartScaleC01SelId_Param"); //定位选择参数
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
        url: '/lihuaiot01/hisChartDevice/scalec01DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                questionColumns.push(temp);
            }
            hisChartScaleC01TableColumns = questionColumns;

            $('#hisChartScaleC01DeviceList').bootstrapTable('destroy');
            $('#hisChartScaleC01DeviceList').bootstrapTable({
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

//自动称重，查询事件
function hisChartScaleC01Query() {
    var objS = document.getElementById("hisChartScaleC01SelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    if (paramValue !== "2" && paramValue !== "4") { //平均体重 多增重日龄
        //只能选择单个设备
        if (hisChartSelectDeviceIds.length != 1) {
            var type = 'warning';
            var msg = '只能选择一个设备';
            var append = '只针对单个设备进行数据分析';
            showMsg(type, msg, append);
            return;
        }
    }else{
        if (hisChartSelectDeviceIds.length < 1) {
            var type = 'warning';
            var msg = '必须选择一个设备';
            var append = '未选择设备无法进行数据分析';
            showMsg(type, msg, append);
            return;
        }
    }
    hisChartScaleC01SelectDeviceByIdsChart();
    hisChartScaleC01SelectHisDataTableHead();
}

function hisChartScaleC01SelectDeviceByIdsChart() {
    var queryStartDate = hisChartScaleC01search_start_date;
    var queryEndDate = hisChartScaleC01search_end_date;
    var queryParamObj = document.getElementById("hisChartScaleC01SelId_Param"); //定位选择参数
    var queryParamMaxThreshold = document.getElementById("hisChartScaleC01MaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartScaleC01MinThreshold").value; //最小阈值
    var queryParamStartAge = document.getElementById("hisChartScaleC01StartAge").value; //起始日龄(增重日龄参数查询)
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sStartAge: queryParamStartAge,
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectScaleC01ByIdsAndDateChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                hisChartoption = result;
                // 使用刚指定的配置项和数据显示图表。
                hisChartScaleC01RepaintChart(hisChartoption);
            } else {
                hisChartScaleC01RepaintChart(hisChartoptionInit);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function hisChartScaleC01SelectHisDataTableHead() {
    var queryParamObj = document.getElementById("hisChartScaleC01SelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sQueryParam: queryParameter
    };
    $.ajax({
        url: "/lihuaiot01/hisChartDevice/scalec01DeviceHead",
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
            hisChartScaleC01TableColumns = questionColumns;
            hisChartScaleC01SelectDeviceByIdsTable();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//请求服务数据时所传参数
function hisChartScaleC01QueryParams(params) {
    var queryStartDate = hisChartScaleC01search_start_date;
    var queryEndDate = hisChartScaleC01search_end_date;
    var queryParamObj = document.getElementById("hisChartScaleC01SelId_Param"); //定位选择参数
    var queryParamMaxThreshold = document.getElementById("hisChartScaleC01MaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartScaleC01MinThreshold").value; //最小阈值
    var queryParamStartAge = document.getElementById("hisChartScaleC01StartAge").value; //起始日龄(增重日龄参数查询)
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sStartAge: queryParamStartAge,
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
}

function hisChartScaleC01SelectDeviceByIdsTable() {
    //table不能每次都初始化，所以每次需要先销毁
    $('#hisChartScaleC01DeviceList').bootstrapTable('destroy');

    $('#hisChartScaleC01DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/hisChartDevice/selectScaleC01ByIdsAndDateAndPaging",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: hisChartScaleC01QueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        columns: hisChartScaleC01TableColumns
    });
}

function HisChartScaleC01ExportData() {
    var queryStartDate = hisChartScaleC01search_start_date;
    var queryEndDate = hisChartScaleC01search_end_date;
    var queryParamObj = document.getElementById("hisChartScaleC01SelId_Param"); //定位选择参数
    var queryParamMaxThreshold = document.getElementById("hisChartScaleC01MaxThreshold").value; //最大阈值
    var queryParamMinThreshold = document.getElementById("hisChartScaleC01MinThreshold").value; //最小阈值
    var queryParamStartAge = document.getElementById("hisChartScaleC01StartAge").value; //起始日龄(增重日龄参数查询)
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sMaxThreshold: queryParamMaxThreshold,
        sMinThreshold: queryParamMinThreshold,
        sStartAge: queryParamStartAge,
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    var url = "/lihuaiot01/hisChartDevice/exportScaleC01HisDeviceList?" + $.param(data);
    window.open(url, '_blank');
}

/***************************ScaleC01 end*********************/

/***************************Hj212C213 start*********************/
function hisChartHj212C213InitChart(hisChartoption) {
    var mainContainer = document.getElementById('echartsHj212C213main');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.6 + 'px';
        mainContainer.style.height = window.innerHeight * 0.6 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    hisChartHj212C213 = echarts.init(mainContainer);
    hisChartHj212C213.clear();
    hisChartHj212C213.setOption(hisChartoption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        hisChartHj212C213.resize();
    });
}

// 日期选择器初始化
function hisChartDateRangePickerInitHj212C213() {
    hisChartHj212C213search_start_date = NowWeeHours(); //凌晨
    hisChartHj212C213search_end_date = GetTodaytime(); //最晚时间
    $('#hisChartHj212C213DateInterval').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'left',    // 日期选择框的弹出位置
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
        hisChartHj212C213search_start_date = this.startDate.format(this.locale.format);
        hisChartHj212C213search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisChartHj212C213RepaintChart(hisChartoption) {
    hisChartHj212C213.clear();
    hisChartHj212C213.setOption(hisChartoption);
}

function hisChartHj212C213SelectDeviceByIdsChart() {
    var queryStartDate = hisChartHj212C213search_start_date;
    var queryEndDate = hisChartHj212C213search_end_date;
    var queryParamObj = document.getElementById("hisChartHj212C213SelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectHj212C213ByIdsAndDateChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                hisChartoption = result;
                // 使用刚指定的配置项和数据显示图表。
                hisChartHj212C213RepaintChart(hisChartoption);
            } else {
                hisChartHj212C213RepaintChart(hisChartoptionInit);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//水质在线监测，查询事件
function hisChartHj212C213Query() {
    var objS = document.getElementById("hisChartHj212C213SelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    //只能选择单个设备
    if (hisChartSelectDeviceIds.length != 1) {
        var type = 'warning';
        var msg = '只能选择一个设备';
        var append = '只针对单个设备进行数据分析';
        showMsg(type, msg, append);
        return;
    }
    hisChartHj212C213SelectDeviceByIdsChart();
}
/***************************Hj212C213 end*********************/

/***************************FeedC411 start*********************/
function hisChartFeedC411InitChart(hisChartoption) {
    var mainContainer = document.getElementById('echartsFeedC411main');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.6 + 'px';
        mainContainer.style.height = window.innerHeight * 0.6 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    hisChartFeedC411 = echarts.init(mainContainer);
    hisChartFeedC411.clear();
    hisChartFeedC411.setOption(hisChartoption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        hisChartFeedC411.resize();
    });
}

// 日期选择器初始化
function hisChartDateRangePickerInitFeedC411() {
    hisChartFeedC411search_start_date = NowWeeHours(); //凌晨
    hisChartFeedC411search_end_date = GetTodaytime(); //最晚时间
    $('#hisChartFeedC411DateInterval').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'left',    // 日期选择框的弹出位置
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
        hisChartFeedC411search_start_date = this.startDate.format(this.locale.format);
        hisChartFeedC411search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisChartFeedC411RepaintChart(hisChartoption) {
    hisChartFeedC411.clear();
    hisChartFeedC411.setOption(hisChartoption);
}

function hisChartFeedC411SelectDeviceByIdsChart() {
    var queryStartDate = hisChartFeedC411search_start_date;
    var queryEndDate = hisChartFeedC411search_end_date;
    var queryParamObj = document.getElementById("hisChartFeedC411SelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter01 = queryParamObj.options[queryParamIndex].value; // 选中文本
    var queryParameter02 = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sQueryParam01: queryParameter01,
        sQueryParam02: queryParameter02,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectFeedC411ByIdsAndDateChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                hisChartoption = result;
                // 使用刚指定的配置项和数据显示图表。
                hisChartFeedC411RepaintChart(hisChartoption);
            } else {
                hisChartFeedC411RepaintChart(hisChartoptionInit);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}


//查询事件
function hisChartFeedC411Query() {
    var objS = document.getElementById("hisChartFeedC411SelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    //只能选择单个设备
    if (hisChartSelectDeviceIds.length != 1) {
        var type = 'warning';
        var msg = '只能选择一个设备';
        var append = '只针对单个设备进行数据分析';
        showMsg(type, msg, append);
        return;
    }
    hisChartFeedC411SelectDeviceByIdsChart();
}

function hisChartSelectFeedC411Params(devId) {
    var data = {
        devId: devId
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectFeedC411ParamsById',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                for(var i=0;i<result.length;i++) {
                    if(i===0){
                        nameOpt ="<option value='"+result[i].communicatName+"' selected='selected'>"+result[i].realName+"</option>";
                    }else{
                        nameOpt+="<option value='"+result[i].communicatName+"' >"+result[i].realName+"</option>";
                    }
                }
                $('#hisChartFeedC411SelId_Param').html(nameOpt);
                // 使用刚指定的配置项和数据显示图表。
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}
/***************************FeedC411s end*********************/

/***************************Lhsp05p1 start*********************/
function hisChartLhsp05p1InitChart(hisChartoption) {
    var mainContainer = document.getElementById('echartsLhsp05p1main');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.6 + 'px';
        mainContainer.style.height = window.innerHeight * 0.6 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    hisChartLhsp05p1 = echarts.init(mainContainer);
    hisChartLhsp05p1.clear();
    hisChartLhsp05p1.setOption(hisChartoption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        hisChartLhsp05p1.resize();
    });
}

// 日期选择器初始化
function hisChartDateRangePickerInitLhsp05p1() {
    hisChartLhsp05p1search_start_date = NowWeeHours(); //凌晨
    hisChartLhsp05p1search_end_date = GetTodaytime(); //最晚时间
    $('#hisChartLhsp05p1DateInterval').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'left',    // 日期选择框的弹出位置
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
        hisChartLhsp05p1search_start_date = this.startDate.format(this.locale.format);
        hisChartLhsp05p1search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisChartLhsp05p1RepaintChart(hisChartoption) {
    hisChartLhsp05p1.clear();
    hisChartLhsp05p1.setOption(hisChartoption);
}

function hisChartLhsp05p1SelectDeviceByIdsChart() {
    var queryStartDate = hisChartLhsp05p1search_start_date;
    var queryEndDate = hisChartLhsp05p1search_end_date;
    var queryParamObj = document.getElementById("hisChartLhsp05p1SelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectLhsp05p1ByIdsAndDateChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                hisChartoption = result;
                // 使用刚指定的配置项和数据显示图表。
                hisChartLhsp05p1RepaintChart(hisChartoption);
            } else {
                hisChartLhsp05p1RepaintChart(hisChartoptionInit);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//水质在线监测，查询事件
function hisChartLhsp05p1Query() {
    var objS = document.getElementById("hisChartLhsp05p1SelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    //只能选择单个设备
    if (hisChartSelectDeviceIds.length != 1) {
        var type = 'warning';
        var msg = '只能选择一个设备';
        var append = '只针对单个设备进行数据分析';
        showMsg(type, msg, append);
        return;
    }
    hisChartLhsp05p1SelectDeviceByIdsChart();
}
/***************************Lhsp05p1 end*********************/

/***************************Lhfh05p1 start*********************/
function hisChartLhfh05p1InitChart(hisChartoption) {
    var mainContainer = document.getElementById('echartsLhfh05p1main');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.6 + 'px';
        mainContainer.style.height = window.innerHeight * 0.6 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    hisChartLhfh05p1 = echarts.init(mainContainer);
    hisChartLhfh05p1.clear();
    hisChartLhfh05p1.setOption(hisChartoption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        hisChartLhfh05p1.resize();
    });
}

// 日期选择器初始化
function hisChartDateRangePickerInitLhfh05p1() {
    hisChartLhfh05p1search_start_date = NowWeeHours(); //凌晨
    hisChartLhfh05p1search_end_date = GetTodaytime(); //最晚时间
    $('#hisChartLhfh05p1DateInterval').daterangepicker({
        timePicker: true,
        timePicker24Hour: true,
        timePickerSeconds: true, //时间显示到秒
        /*"linkedCalendars": false,
        "autoUpdateInput": false,*/
        applyClass: 'btn-sm btn-success',
        cancelClass: 'btn-sm btn-default',
        opens: 'left',    // 日期选择框的弹出位置
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
        hisChartLhfh05p1search_start_date = this.startDate.format(this.locale.format);
        hisChartLhfh05p1search_end_date = this.endDate.format(this.locale.format);
        if (!this.startDate) {
            this.element.val('');
        } else {
            this.element.val(this.startDate.format(this.locale.format) + this.locale.separator + this.endDate.format(this.locale.format));
        }
    });
}

function hisChartLhfh05p1RepaintChart(hisChartoption) {
    hisChartLhfh05p1.clear();
    hisChartLhfh05p1.setOption(hisChartoption);
}

function hisChartLhfh05p1SelectDeviceByIdsChart() {
    var queryStartDate = hisChartLhfh05p1search_start_date;
    var queryEndDate = hisChartLhfh05p1search_end_date;
    var queryParamObj = document.getElementById("hisChartLhfh05p1SelId_Param"); //定位选择参数
    var queryParamIndex = queryParamObj.selectedIndex; // 选中索引
    var queryParameter = queryParamObj.options[queryParamIndex].text; // 选中文本
    var data = {
        sDeviceIds: hisChartSelectDeviceIds.join(','),
        sQueryParam: queryParameter,
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/hisChartDevice/selectLhfh05p1ByIdsAndDateChart',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                hisChartoption = result;
                // 使用刚指定的配置项和数据显示图表。
                hisChartLhfh05p1RepaintChart(hisChartoption);
            } else {
                hisChartLhfh05p1RepaintChart(hisChartoptionInit);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//水质在线监测，查询事件
function hisChartLhfh05p1Query() {
    var objS = document.getElementById("hisChartLhfh05p1SelId_Param");
    var paramValue = objS.options[objS.selectedIndex].value;
    //只能选择单个设备
    if (hisChartSelectDeviceIds.length != 1) {
        var type = 'warning';
        var msg = '只能选择一个设备';
        var append = '只针对单个设备进行数据分析';
        showMsg(type, msg, append);
        return;
    }
    hisChartLhfh05p1SelectDeviceByIdsChart();
}
/***************************Lhfh05p1 end*********************/


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
    var rootNodeId = hisChartNowTreeNodeRoot.id;
    if (queryParameter.length == 4) {
        if (!hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIds.push(queryParameter);
            var queryName = node.text;
            hisChartAddDeviceToList(queryParameter, queryName);
        }
    }else if (queryParameter.length == 14) {
        if (!hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIds.push(queryParameter);
            var queryName = node.text;
            hisChartAddDeviceToList(queryParameter, queryName);
        }
    }else if (rootNodeId === "411" && queryParameter.length == 7) {
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
    var rootNodeId = hisChartNowTreeNodeRoot.id;
    // if (rootNodeId === "111")   //种禽环控器
    if (queryParameter.length == 4) {
        hisChartSelectDeviceIdsRemove(queryParameter);
        hisChartRemoveDeviceToList(queryParameter);
    }else if (queryParameter.length == 4) {
        hisChartSelectDeviceIdsRemove(queryParameter);
        hisChartRemoveDeviceToList(queryParameter);
    }else if (rootNodeId === "411" && queryParameter.length == 7) {
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
    var rootNodeId = hisChartNowTreeNodeRoot.id;
    if (queryParameter.length == 4) {
        if (!hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIds.push(queryParameter);
            var queryName = node.text;
            hisChartAddDeviceToList(queryParameter, queryName);
        }
    }else if (queryParameter.length == 14) {
        if (!hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIds.push(queryParameter);
            var queryName = node.text;
            hisChartAddDeviceToList(queryParameter, queryName);
        }
    }else if (rootNodeId === "411" && queryParameter.length == 7) {
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
    var rootNodeId = hisChartNowTreeNodeRoot.id;
    if (queryParameter.length == 4) {
        if (hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIdsRemove(queryParameter);
            hisChartRemoveDeviceToList(queryParameter);
        }
    }else if (queryParameter.length == 14) {
        if (hisChartSelectDeviceIdsContains(queryParameter)) {
            hisChartSelectDeviceIdsRemove(queryParameter);
            hisChartRemoveDeviceToList(queryParameter);
        }
    }else if (rootNodeId === "411" && queryParameter.length == 7) {
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







