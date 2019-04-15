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