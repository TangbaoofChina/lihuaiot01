var roleTableColumns;
$(function () {
    roleInitTableHead();
});

function roleInitTableHead() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/roleCombineDev/RoleHead',
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
                    var s = '<a class = "roleChangeDevice" href="javascript:void(0)">分配</a>';
                    var d = '<a class = "roleRemoveDevice" href="javascript:void(0)">删除</a>';
                    return s + ' ' + d;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            roleTableColumns = questionColumns;
            roleInitTableContent();
        },
        error: function (XMLHttpRequest) {
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

//请求服务数据时所传参数
function roleQueryParams(params) {
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
    };
}

function roleInitTableContent() {

    $('#roleTable').bootstrapTable('destroy');

    $('#roleTable').bootstrapTable({
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
        search: false,
        //是否显示列头
        showHeader: true,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/roleCombineDev/selectRoleInfo",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: roleQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: roleTableColumns,
    });
}

function roleShowAdd() {
    $('#roleaddNew-popup').show('slow');
    roleAddNewShow();
}

/**
 * 新增页面
 * */
function roleAddNewShow() {
    //保存按钮
    /*    $('#addNew-save').bind('click', function (e) {

        });*/
    //取消按钮
    $('#addNew-cancel').bind('click', function (e) {
        $('#roleaddNew-popup').hide('slow');
    });
    //x按钮
    $('#addNew-close').bind('click', function (e) {
        $('#roleaddNew-popup').hide('slow');
    });
}
