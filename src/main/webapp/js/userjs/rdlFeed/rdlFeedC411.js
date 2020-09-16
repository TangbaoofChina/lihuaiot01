//************************FeedC411 start******************************/

function rdlSelectInfoByDeviceIdAndFeedC411(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectFeedC411ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                // console.log(result);
                //仓号
                var feedC411SiloNum = document.getElementById("feedC411SiloNum");
                //仓号
                feedC411SiloNum.innerHTML = result.siloNum;
                //时间
                var feedC411sendDate = document.getElementById("feedC411sendDate");
                //时间
                feedC411sendDate.innerHTML = result.sendDate;
                //使用状态
                var feedC411UseState01 = document.getElementById("feedC411UseState01");
                var feedC411UseState02 = document.getElementById("feedC411UseState02");
                if (result.useState === 0) {
                    feedC411UseState01.style.color = '#FF0000';
                    feedC411UseState02.style.color = '#D3D3D3';
                } else {
                    feedC411UseState01.style.color = '#D3D3D3';
                    feedC411UseState02.style.color = '#FF0000';
                }

                var cable01ps = result.cable01Nums;
                var cable02ps = result.cable02Nums;
                var cable03ps = result.cable03Nums;
                var cable04ps = result.cable04Nums;
                var cable05ps = result.cable05Nums;
                var cable06ps = result.cable06Nums;
                feedC411CableDisplay(1,cable01ps);
                feedC411CableDisplay(2,cable02ps);
                feedC411CableDisplay(3,cable03ps);
                feedC411CableDisplay(4,cable04ps);
                feedC411CableDisplay(5,cable05ps);
                feedC411CableDisplay(6,cable06ps);
                // 控制最高、最低、平均温度 -层- 的显示
                var maxFloor = getMaxFloor(cable01ps,cable02ps,cable03ps,cable04ps,cable05ps,cable06ps);
                for(var i = 1;i< 17;i++){
                    feedC411FloorDisplay(i,maxFloor);
                }
                //具体温度显示
                for (var i = 0; i < result.cableList.length; i++) {
                    var cable = result.cableList[i];
                    releaseFeedC411Cable(cable);
                }
                for (var i = 0; i < result.floors.length; i++) {
                    var floor = result.floors[i];
                    releaseFeedC411Floor(floor);
                }
                releaseFeedC411Resume(result);
            } else {
                var type = 'error';
                var msg = '未查询到设备数据';
                var append = '对不起，未查询到该设备的实时数据';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            if (realid_of_setintervalDeviceOne !== undefined) {
                clearInterval(realid_of_setintervalDeviceOne);
            }
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

/*****************解析电缆 开始*********************/

//判断最长的层，为最高、最低、平均值的显示服务
function getMaxFloor(cable01ps,cable02ps,cable03ps,cable04ps,cable05ps,cable06ps) {
    var maxFloor = cable01ps;
    if(maxFloor < cable02ps){
        maxFloor = cable02ps;
    }
    if(maxFloor < cable03ps){
        maxFloor = cable02ps;
    }
    if(maxFloor < cable04ps){
        maxFloor = cable02ps;
    }
    if(maxFloor < cable05ps){
        maxFloor = cable02ps;
    }
    if(maxFloor < cable06ps){
        maxFloor = cable02ps;
    }
    return maxFloor;
}

//判断行的显示
function feedC411CableDisplay(index,cableps) {
    if(cableps < 1){
        var element = "feedC411-div-0" + index;
        var feedC411div = document.getElementById(element);
        feedC411div.style.display = 'none';
    }else{
        var element = "feedC411-div-0" + index;
        var feedC411div = document.getElementById(element);
        feedC411div.style.display = 'flex';
    }
}

function feedC411FloorDisplay(index,maxFloor) {
    var highElement = "feedC411-High-01";
    var lowElement = "feedC411-Low-01";
    var avgElement = "feedC411-Avg-01";
    if(index > 9){
        highElement = "feedC411-High-" + index;
        lowElement = "feedC411-Low-" + index;
        avgElement = "feedC411-Avg-" + index;
    }else{
        highElement = "feedC411-High-0" + index;
        lowElement = "feedC411-Low-0" + index;
        avgElement = "feedC411-Avg-0" + index;
    }
    var high = document.getElementById(highElement);
    var low = document.getElementById(lowElement);
    var avg = document.getElementById(avgElement);
    if(index <= maxFloor){
        high.style.display = 'block';
        low.style.display = 'block';
        avg.style.display = 'block';
    }else {
        high.style.display = 'none';
        low.style.display = 'none';
        avg.style.display = 'none';
    }
}

function releaseFeedC411Cable(cable) {
    if (cable.num === 1) {
        releaseFeedC411Cable01(cable)
    } else if (cable.num === 2) {
        releaseFeedC411Cable02(cable)
    } else if (cable.num === 3) {
        releaseFeedC411Cable03(cable)
    } else if (cable.num === 4) {
        releaseFeedC411Cable04(cable)
    }else if (cable.num === 5) {
        releaseFeedC411Cable05(cable)
    }else if (cable.num === 6) {
        releaseFeedC411Cable06(cable)
    }
}

//第一根
function releaseFeedC411Cable01(cable) {
    for(var i=1;i<=cable.quantity;i++) {
        var element = "feedC411-01-01";
        if(i>9){
            element = "feedC411-01" + "-" + i;
        }else {
            element = "feedC411-01" + "-0" + i;
        }
        var feedC41101 = document.getElementById(element);
        feedC41101.style.display = 'block';
        var temp = getFeedC411Temp(cable.temps, i);
        formatFeedC411Temp(feedC41101, temp);
    }
    for(var i= cable.quantity+1;i<=16;i++){
        var element = "feedC411-01-01";
        if(i>9){
            element = "feedC411-01" + "-" + i;
        }else {
            element = "feedC411-01" + "-0" + i;
        }
        var feedC41101 = document.getElementById(element);
        feedC41101.style.display = 'none';
    }
}

//第二根
function releaseFeedC411Cable02(cable) {
    for(var i=1;i<=cable.quantity;i++) {
        var element = "feedC411-02-01";
        if(i>9){
            element = "feedC411-02" + "-" + i;
        }else {
            element = "feedC411-02" + "-0" + i;
        }
        var feedC41102 = document.getElementById(element);
        feedC41102.style.display = 'block';
        var temp = getFeedC411Temp(cable.temps, i);
        formatFeedC411Temp(feedC41102, temp);
    }
    for(var i= cable.quantity+1;i<=16;i++){
        var element = "feedC411-02-01";
        if(i>9){
            element = "feedC411-02" + "-" + i;
        }else {
            element = "feedC411-02" + "-0" + i;
        }
        var feedC41102 = document.getElementById(element);
        feedC41102.style.display = 'none';
    }
}

//第三根
function releaseFeedC411Cable03(cable) {
    for(var i=1;i<=cable.quantity;i++) {
        var element = "feedC411-03-01";
        if(i>9){
            element = "feedC411-03" + "-" + i;
        }else {
            element = "feedC411-03" + "-0" + i;
        }
        var feedC41103 = document.getElementById(element);
        feedC41103.style.display = 'block';
        var temp = getFeedC411Temp(cable.temps, i);
        formatFeedC411Temp(feedC41103, temp);
    }
    for(var i= cable.quantity+1;i<=16;i++){
        var element = "feedC411-03-01";
        if(i>9){
            element = "feedC411-03" + "-" + i;
        }else {
            element = "feedC411-03" + "-0" + i;
        }
        var feedC41103 = document.getElementById(element);
        feedC41103.style.display = 'none';
    }
}

//第四根
function releaseFeedC411Cable04(cable) {
    for(var i=1;i<=cable.quantity;i++) {
        var element = "feedC411-04-01";
        if(i>9){
            element = "feedC411-04" + "-" + i;
        }else {
            element = "feedC411-04" + "-0" + i;
        }
        var feedC41104 = document.getElementById(element);
        feedC41104.style.display = 'block';
        var temp = getFeedC411Temp(cable.temps, i);
        formatFeedC411Temp(feedC41104, temp);
    }
    for(var i= cable.quantity+1;i<=16;i++){
        var element = "feedC411-04-01";
        if(i>9){
            element = "feedC411-04" + "-" + i;
        }else {
            element = "feedC411-04" + "-0" + i;
        }
        var feedC41104 = document.getElementById(element);
        feedC41104.style.display = 'none';
    }
}

//第五根
function releaseFeedC411Cable05(cable) {
    for(var i=1;i<=cable.quantity;i++) {
        var element = "feedC411-05-01";
        if(i>9){
            element = "feedC411-05" + "-" + i;
        }else {
            element = "feedC411-05" + "-0" + i;
        }
        var feedC41105 = document.getElementById(element);
        feedC41105.style.display = 'block';
        var temp = getFeedC411Temp(cable.temps, i);
        formatFeedC411Temp(feedC41105, temp);
    }
    for(var i= cable.quantity+1;i<=16;i++){
        var element = "feedC411-05-01";
        if(i>9){
            element = "feedC411-05" + "-" + i;
        }else {
            element = "feedC411-05" + "-0" + i;
        }
        var feedC41105 = document.getElementById(element);
        feedC41105.style.display = 'none';
    }
}

//第六根
function releaseFeedC411Cable06(cable) {
    for(var i=1;i<=cable.quantity;i++) {
        var element = "feedC411-06-01";
        if(i>9){
            element = "feedC411-06" + "-" + i;
        }else {
            element = "feedC411-06" + "-0" + i;
        }
        var feedC41106 = document.getElementById(element);
        feedC41106.style.display = 'block';
        var temp = getFeedC411Temp(cable.temps, i);
        formatFeedC411Temp(feedC41106, temp);
    }
    for(var i= cable.quantity+1;i<=16;i++){
        var element = "feedC411-06-01";
        if(i>9){
            element = "feedC411-06" + "-" + i;
        }else {
            element = "feedC411-06" + "-0" + i;
        }
        var feedC41106 = document.getElementById(element);
        feedC41106.style.display = 'none';
    }
}

function getFeedC411Temp(temps, num) {
    var temp;
    for (var i = 0; i < temps.length; i++) {
        temp = temps[i];
        if (temp.num === num) {
            return temp;
        }
    }
    return temp;
}

function formatFeedC411Temp(obj, temp) {

    obj.innerHTML = temp.temp;
    obj.style.color = "#" + temp.color;
    if (temp.enable === false) {
        obj.style.color = '#D3D3D3';
    }
}

/*****************解析电缆 结束*********************/

/**************解析每一层 开始*************************/

function releaseFeedC411Floor(floor) {
    if (floor.num === 1) {
        releaseFeedC411Floor01(floor)
    }
    if (floor.num === 2) {
        releaseFeedC411Floor02(floor)
    }
    if (floor.num === 3) {
        releaseFeedC411Floor03(floor)
    }
    if (floor.num === 4) {
        releaseFeedC411Floor04(floor)
    }
    if (floor.num === 5) {
        releaseFeedC411Floor05(floor)
    }
    if (floor.num === 6) {
        releaseFeedC411Floor06(floor)
    }
    if (floor.num === 7) {
        releaseFeedC411Floor07(floor)
    }
    if (floor.num === 8) {
        releaseFeedC411Floor08(floor)
    }
    if (floor.num === 9) {
        releaseFeedC411Floor09(floor)
    }
    if (floor.num === 10) {
        releaseFeedC411Floor10(floor)
    }
    if (floor.num === 11) {
        releaseFeedC411Floor11(floor)
    }
    if (floor.num === 12) {
        releaseFeedC411Floor12(floor)
    }
    if (floor.num === 13) {
        releaseFeedC411Floor13(floor)
    }
    if (floor.num === 14) {
        releaseFeedC411Floor14(floor)
    }
    if (floor.num === 15) {
        releaseFeedC411Floor15(floor)
    }
    if (floor.num === 16) {
        releaseFeedC411Floor16(floor)
    }
}

function releaseFeedC411Floor01(floor) {
    var high = document.getElementById("feedC411-High-01");
    var low = document.getElementById("feedC411-Low-01");
    var avg = document.getElementById("feedC411-Avg-01");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor02(floor) {
    var high = document.getElementById("feedC411-High-02");
    var low = document.getElementById("feedC411-Low-02");
    var avg = document.getElementById("feedC411-Avg-02");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor03(floor) {
    var high = document.getElementById("feedC411-High-03");
    var low = document.getElementById("feedC411-Low-03");
    var avg = document.getElementById("feedC411-Avg-03");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor04(floor) {
    var high = document.getElementById("feedC411-High-04");
    var low = document.getElementById("feedC411-Low-04");
    var avg = document.getElementById("feedC411-Avg-04");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor05(floor) {
    var high = document.getElementById("feedC411-High-05");
    var low = document.getElementById("feedC411-Low-05");
    var avg = document.getElementById("feedC411-Avg-05");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor06(floor) {
    var high = document.getElementById("feedC411-High-06");
    var low = document.getElementById("feedC411-Low-06");
    var avg = document.getElementById("feedC411-Avg-06");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor07(floor) {
    var high = document.getElementById("feedC411-High-07");
    var low = document.getElementById("feedC411-Low-07");
    var avg = document.getElementById("feedC411-Avg-07");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor08(floor) {
    var high = document.getElementById("feedC411-High-08");
    var low = document.getElementById("feedC411-Low-08");
    var avg = document.getElementById("feedC411-Avg-08");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor09(floor) {
    var high = document.getElementById("feedC411-High-09");
    var low = document.getElementById("feedC411-Low-09");
    var avg = document.getElementById("feedC411-Avg-09");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor10(floor) {
    var high = document.getElementById("feedC411-High-10");
    var low = document.getElementById("feedC411-Low-10");
    var avg = document.getElementById("feedC411-Avg-10");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor11(floor) {
    var high = document.getElementById("feedC411-High-11");
    var low = document.getElementById("feedC411-Low-11");
    var avg = document.getElementById("feedC411-Avg-11");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor12(floor) {
    var high = document.getElementById("feedC411-High-12");
    var low = document.getElementById("feedC411-Low-12");
    var avg = document.getElementById("feedC411-Avg-12");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor13(floor) {
    var high = document.getElementById("feedC411-High-13");
    var low = document.getElementById("feedC411-Low-13");
    var avg = document.getElementById("feedC411-Avg-13");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor14(floor) {
    var high = document.getElementById("feedC411-High-14");
    var low = document.getElementById("feedC411-Low-14");
    var avg = document.getElementById("feedC411-Avg-14");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor15(floor) {
    var high = document.getElementById("feedC411-High-15");
    var low = document.getElementById("feedC411-Low-15");
    var avg = document.getElementById("feedC411-Avg-15");
    formatFeedC411FTemp(high, low, avg, floor)
}

function releaseFeedC411Floor16(floor) {
    var high = document.getElementById("feedC411-High-16");
    var low = document.getElementById("feedC411-Low-16");
    var avg = document.getElementById("feedC411-Avg-16");
    formatFeedC411FTemp(high, low, avg, floor)
}

function formatFeedC411FTemp(high, low, avg, fTemp) {
    high.innerHTML = fTemp.high;
    high.style.color = "#" + fTemp.highColor;

    low.innerHTML = fTemp.low;
    low.style.color = "#" + fTemp.lowColor;

    avg.innerHTML = fTemp.avg;
    avg.style.color = "#" + fTemp.avgColor;
}

/**************解析每一层 结束*************************/

/*****************解析全仓 开始************************/

function releaseFeedC411Resume(result) {
    var high = document.getElementById("feedC411-High");
    var low = document.getElementById("feedC411-Low");
    var avg = document.getElementById("feedC411-Avg");
    var stock = document.getElementById("feedC411-Stock");
    var water = document.getElementById("feedC411-Water");
    var humidity01 = document.getElementById("feedC411-humidity01");
    var envHumidity = document.getElementById("feedC411-envHumidity");
    var highThreshold = document.getElementById("feedC411-highThreshold");
    high.innerHTML = result.high;
    high.style.color = "#" + result.highColor;
    low.innerHTML = result.low;
    low.style.color = "#" + result.lowColor;
    avg.innerHTML = result.avg;
    avg.style.color = "#" + result.avgColor;
    stock.innerHTML = result.stock;
    water.innerHTML = result.water;
    humidity01.innerHTML = result.humidity01;
    envHumidity.innerHTML = result.envHumidity;
    highThreshold.innerHTML = result.highThreshold;
}

/*****************解析全仓 结束************************/
function rdlInitTableFeedC411() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {devId: ""},
        url: '/lihuaiot01/realDeviceList/feedC411DeviceHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                if (json[i].data === "dState") {
                    temp = {
                        field: json[i].data,
                        title: json[i].title,
                        align: json[i].align,
                        formatter: rdlChangeTableColor
                    };//手动拼接columns
                } else {
                    temp = {
                        field: json[i].data,
                        title: json[i].title,
                        align: json[i].align,
                        visible: json[i].visible
                    };//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlFeedC411TableColumns = questionColumns;
            $('#rdlFeedC411DeviceList').bootstrapTable('destroy');
            $('#rdlFeedC411DeviceList').bootstrapTable({
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



function rdlSelectDeviceByTreeIdFeedC411() {

    $('#rdlFeedC411DeviceList').bootstrapTable('destroy');

    $('#rdlFeedC411DeviceList').bootstrapTable({
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
        pageSize: 50,
        //可供选择的每页的行数（*）
        pageList: [8, 10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectFeedC411ByORGId",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: rdlQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        columns: rdlFeedC411TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************FeedC411 end******************************/