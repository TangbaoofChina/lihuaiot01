var rolePeopleTableColumns;
var rolePeopleSelectPeople;
var rolePeopleSelectRole;
var rolePeopleSelectPeopleRole;
$(function () {
    rolePeopleInitTableHead();
    rolePeopleInitPeople();
    rolePeopleInitRole();
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
                var temp = {field: json[i].data, title: json[i].title, align: json[i].align};//手动拼接columns
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
        //每页的记录行数（*）
        pageSize: 8,
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
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "client",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: rolePeopleTableColumns,
    });
}

function rolePeopleInitPeople() {
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
                    "orgName": json[i].orgName,
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
        effectiveFieldsAlias: {roleName: "人员", roleDescribe: "部门"},
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

function rolePeopleSaveRolePeople() {
    var personId = rolePeopleSelectPeople.userId;
    var personName = rolePeopleSelectPeople.userName;
    var roleId = rolePeopleSelectRole.roleId;
    var roleName = rolePeopleSelectRole.roleName;
    $.ajax({
        type: 'POST',
        data: {personId: personId, personName: personName, roleId: roleId, roleName: roleName},
        url: '/lihuaiot01/roleCombinePeople/roleCombinePeopleUpdate',
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
    $.ajax({
        url: "/lihuaiot01/roleCombinePeople/deletePeopleRoleInfo",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {userId: mPeopleId},
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