var welOnLineChart;
var welOffRateChart;
var welAlarmRateChart;
var wel_Offline_start_date;
var wel_Offline_end_date;
var wel_Alarm_start_date;
var wel_Alarm_end_date;

// 日期选择器初始化
function welOfflineRangePickerInit() {
    $('#welOfflineFilterTime').daterangepicker({
        timePicker: true,      // 是否显示小时和分钟选择条件
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
            separator: ' - ',
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
        startDate: NowWeeMonth(),
        endDate: GetNowtime()
    }, function (start, end, label) {
        wel_Offline_start_date = this.startDate.format(this.locale.format);
        wel_Offline_end_date = this.endDate.format(this.locale.format);
        welGetOfflineRate();
    });
}


// 日期选择器初始化
function welAlarmRangePickerInit() {
    $('#welAlarmFilterTime').daterangepicker({
        timePicker: true,      // 是否显示小时和分钟选择条件
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
            separator: ' - ',
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
        startDate: NowWeeMonth(),
        endDate: GetNowtime()
    }, function (start, end, label) {
        wel_Alarm_start_date = this.startDate.format(this.locale.format);
        wel_Alarm_end_date = this.endDate.format(this.locale.format);
        welGetAlarmRate();
    });
}

function welGetOnlineOffline() {
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/welcome/selectOnline',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                welInitOnlineChart(result);
            } else {
                var type = 'warning';
                var msg = '未查询到设备在线数据';
                var append = '对不起，未查询到您要的数据，请重新刷新界面';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function welGetOfflineRate() {
    var queryStartDate = wel_Offline_start_date;
    var queryEndDate = wel_Offline_end_date;
    var data = {
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/welcome/selectOfflineRate',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                welInitOfflineRateChart(result);
            } else {
                var type = 'warning';
                var msg = '未查询到设备离线数据';
                var append = '对不起，未查询到您要的数据，请重新刷新界面';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function welGetAlarmRate() {
    var queryStartDate = wel_Alarm_start_date;
    var queryEndDate = wel_Alarm_end_date;
    var data = {
        sStartDate: queryStartDate,
        sEndDate: queryEndDate
    };
    $.ajax({
        type: 'POST',
        url: '/lihuaiot01/welcome/selectAlarmRate',
        dataType: 'json',
        async: true,   // 轻轻方式-异步
        data: data,
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                welInitAlarmRateChart(result);
            } else {
                var type = 'warning';
                var msg = '未查询到设备离线数据';
                var append = '对不起，未查询到您要的数据，请重新刷新界面';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function welInitOnlineChart(welChartOption) {
    var mainContainer = document.getElementById('WelDeviceOnLine');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.25 + 'px';
        mainContainer.style.height = window.innerHeight * 0.5 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    welOnLineChart = echarts.init(mainContainer);
    welOnLineChart.clear();
    welOnLineChart.setOption(welChartOption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        welOnLineChart.resize();
    });
}

function welInitOfflineRateChart(welChartOption) {
    var mainContainer = document.getElementById('WelDeviceOfflineRate');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.25 + 'px';
        mainContainer.style.height = window.innerHeight * 0.5 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    welOffRateChart = echarts.init(mainContainer);
    welOffRateChart.clear();
    welOffRateChart.setOption(welChartOption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        welOffRateChart.resize();
    });
}

function welInitAlarmRateChart(welChartOption) {
    var mainContainer = document.getElementById('WelDeviceAlarmRate');
    //用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    var resizeMainContainer = function () {
        mainContainer.style.width = window.innerWidth * 0.25 + 'px';
        mainContainer.style.height = window.innerHeight * 0.5 + 'px';
        /*mainContainer.height = window.innerWidth * 0.7 + 'px';
        mainContainer.width = window.innerHeight * 0.42 + 'px';*/
    };
    resizeMainContainer();
    // 初始化图表
    //hisChart = echarts.init(mainContainer, 'macarons');
    // 初始化图表-不带主题
    welAlarmRateChart = echarts.init(mainContainer);
    welAlarmRateChart.clear();
    welAlarmRateChart.setOption(welChartOption);
    $(window).on('resize', function () {//
        //屏幕大小自适应，重置容器高宽
        resizeMainContainer();
        welAlarmRateChart.resize();
    });
}


$(function () {
    wel_Offline_start_date = NowWeeMonth();
    wel_Offline_end_date = GetNowtime();
    wel_Alarm_start_date = NowWeeMonth();
    wel_Alarm_end_date = GetNowtime();
    welOfflineRangePickerInit();
    welAlarmRangePickerInit();
    welGetOnlineOffline();
    welGetOfflineRate();
    welGetAlarmRate();
    //WelInitChart(option);
});
