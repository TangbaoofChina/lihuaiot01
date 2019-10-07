//用户管理 用户关联角色
var rolePeopleTableColumns;
var rolePeopleSelectPeople;
var rolePeopleSelectRole;
var rolePeopleSelectPeopleRole;
var rolePeopleSelectPeopleRoles;
$(function () {
    rolePeopleInitTableHead();
    rolePeopleInitPeople();
    //rolePeopleInitRole();
    rolePeopleInitRoles();
});

function rolePeopleInitTableHead() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/roleCombinePeople/RolePeopleHead',
        dataType: "json",
        success: function (result) {
            /*alert("1");*/
            var json = eval(result); //数组
            for (var i = 0; i < json.length; i++) {
                var temp = "";
                if (json[i].data === "userMsgPush") {
                    temp = {
                        field: json[i].data,
                        title: json[i].title,
                        align: json[i].align,
                        formatter: rolePeopleChangeTableColor
                    };//手动拼接columns
                } else {
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            var temp1 = {
                field: 'operation',
                title: '操作',
                formatter: function (value, row, index) {
                    var s = '<a class = "rolePeopleChangeDevice" href="#">修改</a>';
                    var d = '<a class = "rolePeopleRemoveRole" href="#">删除</a>';
                    return s + ' ' + d;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            rolePeopleTableColumns = questionColumns;
            rolePeopleInitTableContent();
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//是否启用消息推送的判断显示
function rolePeopleChangeTableColor(value, row, index) {
    //通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
    var a = "";
    var run = "启";
    var stop = "停";
    if (value == "1") {
        var a = '<span style="color:#00ff00">' + run + '</span>';
    } else if (value == "0") {
        var a = '<span style="color:#FF0000">' + stop + '</span>';
    } else {
        var a = '<span>' + value + '</span>';
    }
    return a;
}


function rolePeopleInitTableContent() {

    $('#rolePeopleTable').bootstrapTable('destroy');

    $('#rolePeopleTable').bootstrapTable({
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
        //初始化加载第一页，默认第一页
        pageNumber: 1,
        //每页的记录行数（*）
        pageSize: 100,
        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100],
        //是否显示搜索
        search: true,
        //是否显示列头
        showHeader: true,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/roleCombinePeople/selectRolePeopleInfo",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        /*queryParamsType: 'limit',//查询参数组织方式
        queryParams: roleQueryParams,*/
        pagination:true,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: rolePeopleTableColumns,
        height: 500       //设置表格高度-固定表头生效
    });
}

function rolePeopleInitPeopleOld() {
    $("#rolePeoplePeopleName").bsSuggest('init', {
        effectiveFieldsAlias: {userName: "人员", orgName: "部门"},
        searchFields: ["userName", "orgName"],
        effectiveFields: ["userName", "orgName"],
        showHeader: true,//显示 header
        url: "/lihuaiot01/peopleCombineOrg/selectPeopleInfo",
        idField: "userId",
        keyField: "userName",
        inputWarnColor: 'rgba(255,0,0,.1)', //输入框内容不是下拉列表选择时的警告色
        listStyle: {
            'padding-top': 0,
            'max-height': '300px',
            'max-width': '800px',
            'overflow': 'auto',
            'width': 'auto',
            'transition': '0.3s',
            '-webkit-transition': '0.3s',
            '-moz-transition': '0.3s',
            '-o-transition': '0.3s'
        },               //列表的样式控制
        processData: function (json) {// url 获取数据时，对数据的处理，作为 getData 的回调函数
            var i, len, data = {value: []};
            if (!json || json.length == 0) {
                return false;
            }
            len = json.length;
            for (i = 0; i < len; i++) {
                data.value.push({
                    "userName": json[i].personName,
                    "userId": json[i].personId,
                    "orgName": json[i].orgName
                });
            }
            //console.log(data);
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        //console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        //console.log('onSetSelectValue: ', keyword, data);
        rolePeopleSelectPeople = data;
    }).on('onUnsetSelectValue', function () {
        //console.log('onUnsetSelectValue');
    });
}

function rolePeopleInitPeople() {
    $("#rolePeoplePeopleName").bsSuggest('init', {
        effectiveFieldsAlias: {userName: "人员", company: "公司", department: "部门"},
        searchFields: ["userName", "company", "department"],
        effectiveFields: ["userName", "company", "department"],
        showHeader: true,//显示 header
        url: "/lihuaiot01/peopleCombineOrg/selectPeopleInfo",
        idField: "userId",
        keyField: "userName",
        inputWarnColor: 'rgba(255,0,0,.1)', //输入框内容不是下拉列表选择时的警告色
        listStyle: {
            'padding-top': 0,
            'max-height': '300px',
            'max-width': '800px',
            'overflow': 'auto',
            'width': 'auto',
            'transition': '0.3s',
            '-webkit-transition': '0.3s',
            '-moz-transition': '0.3s',
            '-o-transition': '0.3s'
        },               //列表的样式控制
        processData: function (json) {// url 获取数据时，对数据的处理，作为 getData 的回调函数
            var i, len, data = {value: []};
            if (!json || json.length == 0) {
                return false;
            }
            len = json.length;
            for (i = 0; i < len; i++) {
                data.value.push({
                    "userName": json[i].personName,
                    "userId": json[i].personId,
                    "company": json[i].company,
                    "department": json[i].department
                });
            }
            //console.log(data);
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        //console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        //console.log('onSetSelectValue: ', keyword, data);
        rolePeopleSelectPeople = data;
    }).on('onUnsetSelectValue', function () {
        //console.log('onUnsetSelectValue');
    });
}

function rolePeopleInitRole() {
    $("#rolePeopleRoleName").bsSuggest('init', {
        effectiveFieldsAlias: {roleName: "角色", roleDescribe: "描述"},
        searchFields: ["roleName", "roleDescribe"],
        effectiveFields: ["roleName", "roleDescribe"],
        showHeader: true,//显示 header
        url: "/lihuaiot01/roleCombinePeople/selectRoleInfo",
        idField: "roleId",
        keyField: "roleName",
        inputWarnColor: 'rgba(255,0,0,.1)', //输入框内容不是下拉列表选择时的警告色
        listStyle: {
            'padding-top': 0,
            'max-height': '200px',
            'max-width': '800px',
            'overflow': 'auto',
            'width': 'auto',
            'transition': '0.3s',
            '-webkit-transition': '0.3s',
            '-moz-transition': '0.3s',
            '-o-transition': '0.3s'
        },               //列表的样式控制
        processData: function (json) {// url 获取数据时，对数据的处理，作为 getData 的回调函数
            var i, len, data = {value: []};
            if (!json || json.length == 0) {
                return false;
            }
            len = json.length;
            for (i = 0; i < len; i++) {
                data.value.push({
                    "roleName": json[i].roleName,
                    "roleId": json[i].roleId,
                    "roleDescribe": json[i].roleDescribe,
                });
            }
            //console.log(data);
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        //console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        //console.log('onSetSelectValue: ', keyword, data);
        rolePeopleSelectRole = data;
    }).on('onUnsetSelectValue', function () {
        //console.log('onUnsetSelectValue');
    });
}

var rolePeopleMultiselectset = {
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

function rolePeopleInitRoles() {
    $.ajax({
        type: 'GET',
        data: {},
        async: true,   // 轻轻方式-异步
        url: '/lihuaiot01/roleCombinePeople/selectRoleInfo',
        dataType: "json",
        success: function (result) {
            $("#rolePeopleRoleName_search").html("");
            for (var i = 0; i < result.length; i++) {
                $("#rolePeopleRoleName_search").append("<option value='" + result[i].roleId + "' title='" + result[i].roleDescribe + "'>" + result[i].roleName + "</option>");
            }
            $('#rolePeopleRoleName_search').multiselect(rolePeopleMultiselectset);
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function rolePeopleSaveRolePeople() {
    var selectRoles = new Array();
    var userMsgPush = 0;
    if (document.getElementById("rolePeopleMsgSend").checked) {
        userMsgPush = 1;
    }
    $("#rolePeopleRoleName_search").multiselect('enable');
    $("#rolePeopleRoleName_search option:selected").each(function () {
        var object = new Object();
        object.userId = rolePeopleSelectPeople.userId;
        object.userName = rolePeopleSelectPeople.userName;
        object.userMsgPush = userMsgPush;
        object.roleId = $(this).val();
        object.roleName = $(this).text();
        selectRoles.push(object);
    });
    $.ajax({
        type: 'POST',
        data: JSON.stringify(selectRoles),
        url: '/lihuaiot01/roleCombinePeople/roleCombinePeopleUpdate',
        contentType: 'application/json;charset=utf-8', //设置请求头信息
        async: true,   // 轻轻方式-异步
        dataType: "text",
        success: function (result) {
            rolePeopleInitTableContent();
            if (result !== "更新成功") {
                var type = 'warning';
                var msg = '更新失败';
                var append = '对不起，更新失败：' + result;
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
    $('#rolePeopleaddNew-popup').hide('slow');
}

function rolePeopleShowAdd() {
    $('#rolePeopleaddNew-popup').show('slow');
    rolePeopleAddNewShow();
}

function rolePeopleShowAddNew() {
    $("#rolePeoplePeopleName").val("");
    $("#rolePeopleRoleName_search").multiselect('enable');
    $("#rolePeopleRoleName_search").val("");
    $("#rolePeopleRoleName_search").multiselect('refresh');
    $("#rolePeopleMsgSend").prop("checked", false);
    rolePeopleShowAdd();
}

/**
 * 新增页面
 * */
function rolePeopleAddNewShow() {
    //取消按钮
    $('#rolePeopleaddNew-cancel').bind('click', function (e) {
        $('#rolePeopleaddNew-popup').hide('slow');
    });
    //x按钮
    $('#rolePeopleaddNew-close').bind('click', function (e) {
        $('#rolePeopleaddNew-popup').hide('slow');
    });
}


function rolePeopleDeletePeopleRole() {
    var mPeopleId = rolePeopleSelectPeopleRole.userId;
    var mRoleId = rolePeopleSelectPeopleRole.roleId;
    $.ajax({
        url: "/lihuaiot01/roleCombinePeople/deletePeopleRoleInfo",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {userId: mPeopleId, roleId: mRoleId},
        success: function (result) {
            if (result === "删除成功") {
                rolePeopleInitTableContent();
            }
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}