var peopleOrgParentNode;
var peopleOrgNowTreeNode;
var peopleOrgNextNode;
var peopleOrgTreeNodes;
var peopleOrgTableColumns;
var peopleOrgSelectORG;
var peopleOrgSelectPerson;
var peopleOrgSetting = {
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false,
        fontCss: peopleOrgGetFontCss
    },
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pId",
            rootPId: ""
        }
    },
    callback: {
        beforeClick: function (treeId, treeNode) {
            var zTree = $.fn.zTree.getZTreeObj("peopleOrgTree");
            peopleOrgNextNode = treeNode.getNextNode();
            peopleOrgParentNode = treeNode.getParentNode();
            peopleOrgNowTreeNode = treeNode;
            peopleOrgSelectORG = treeNode;
            peopleOrgTreeNodeHighLightClear();
            peopleOrgSelectPeopleByTreeId();
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);

            } else {

            }
        }
    }
};

$(function () {
    peopleOrgFindZTreeNode("");
    peopleOrgInitTable();
    peopleOrgInitPeople();
    peopleOrgInitORG();
});

function peopleOrgFindZTreeNode(txtSearch) {
    $.ajax({
        url: "/lihuaiot01/treeNode/selectTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                var json = eval(result); //数组
                peopleOrgTreeNodes = json;
                $.fn.zTree.init($("#peopleOrgTree"), peopleOrgSetting, peopleOrgTreeNodes);
                peopleOrgSearchTreeNodeByName(txtSearch);
            } else {
                var type = 'warning';
                var msg = '未查询到树形组织数据';
                var append = '对不起，未查询到您要的树形组织数据';
                showMsg(type, msg, append);
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

function peopleOrgGetFontCss(treeId, treeNode) {
    return (!!treeNode.highlight) ? {color: "#A60000", "font-weight": "bold"} : {
        color: "#333",
        "font-weight": "normal"
    };
}

function peopleOrgSearchTreeNode() {
    var txtSearch = document.getElementById("peopleOrgTxtSearchTreeNode").value;
    peopleOrgSearchTreeNodeByName("");
    peopleOrgSearchTreeNodeByName(txtSearch);
}

function peopleOrgTreeNodeHighLightClear() {
    var zTree = $.fn.zTree.getZTreeObj("peopleOrgTree");
    var nodeList = [];
    nodeList = zTree.getNodesByParamFuzzy("name", "");
    for (var i = 0, l = nodeList.length; i < l; i++) {
        nodeList[i].highlight = false;
        zTree.updateNode(nodeList[i]);
    }
}

function peopleOrgSearchTreeNodeByName(txtSearch) {
    var zTree = $.fn.zTree.getZTreeObj("peopleOrgTree");
    var nodeList = [];
    nodeList = zTree.getNodesByParamFuzzy("name", txtSearch);
    if (txtSearch === "") {
        for (var i = 0, l = nodeList.length; i < l; i++) {
            nodeList[i].highlight = false;
            zTree.updateNode(nodeList[i]);
        }
        zTree.setting.view.expandSpeed = "";
        zTree.expandAll(false);
        zTree.setting.view.expandSpeed = "fast";
    }
    else {
        for (var i = 0, l = nodeList.length; i < l; i++) {
            nodeList[i].highlight = true;
            zTree.updateNode(nodeList[i]);
            zTree.expandNode(nodeList[i], true);
            zTree.selectNode(nodeList[i]);
        }
    }
}

//请求服务数据时所传参数
function peopleOrgQueryParams(params) {
    var queryParameter;
    //console.log(peopleOrgNowTreeNode);
    if(typeof(peopleOrgNowTreeNode) !== "undefined"){
        queryParameter = peopleOrgNowTreeNode.id;
    }
    //console.log(peopleOrgNowTreeNode.name);
    return {
        pageNumber: params.offset + 1,
        //每页多少条数据
        pageSize: params.limit,
        sORGId: queryParameter,
    };
}

function peopleOrgSelectPeopleByTreeId() {

    $('#peopleOrgTable').bootstrapTable('destroy');

    $('#peopleOrgTable').bootstrapTable({
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
        url: "/lihuaiot01/peopleCombineOrg/selectPeopleByORGId",
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        method: 'post',                      //请求方式（*）
        dataType: "json",
        //默认值为 'limit',传给服务端的参数为：limit, offset, search, sort, order Else
        //queryParamsType:'',
        ////查询参数,每次调用是会带上这个参数，可自定义
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: peopleOrgQueryParams,
        //分页方式：client客户端分页，server服务端分页（*）
        sidePagination: "server",
        locale: 'zh-CN',//中文支持
        /* toolbar: '#toolbar',//指定工作栏*/
        columns: peopleOrgTableColumns,
    });
}

function peopleOrgInitTable() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/peopleCombineOrg/PeopleHead',
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
                    var s = '<a class = "peopleOrgChangeORG" href="javascript:void(0)">转移</a>';
                    var d = '<a class = "peopleOrgRemoveORG" href="javascript:void(0)">删除</a>';
                    return s + ' ' + d;
                },
                events: 'operateEvents'
            };
            questionColumns.push(temp1);
            peopleOrgTableColumns = questionColumns;
            $('#peopleOrgTable').bootstrapTable('destroy');
            $('#peopleOrgTable').bootstrapTable({
                columns: questionColumns,
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

function peopleOrgShowAdd() {
    if(typeof(peopleOrgNowTreeNode) !== "undefined"){
        $("#peopleOrgOrg").val(peopleOrgNowTreeNode.name);
    }
    $('#addNew-popup').show('slow');
    peopleOrgAddNewShow();
}

/**
 * 新增页面
 * */
function peopleOrgAddNewShow() {
    //保存按钮
/*    $('#addNew-save').bind('click', function (e) {

    });*/
    //取消按钮
    $('#addNew-cancel').bind('click', function (e) {
        $('#addNew-popup').hide('slow');
    });
    //x按钮
    $('#addNew-close').bind('click', function (e) {
        $('#addNew-popup').hide('slow');
    });
}


function peopleOrgInitPeople() {
    $("#peopleOrgPeople").bsSuggest('init', {
        effectiveFieldsAlias: { personName: "人员",orgName:"部门"},
        searchFields: ["personName","orgName"],
        effectiveFields: ["personName","orgName"],
        showHeader: true,//显示 header
        url: "/lihuaiot01/peopleCombineOrg/selectPeopleInfo",
        idField: "personId",
        keyField: "personName",
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
                    "personName": json[i].personName,
                    "personId": json[i].personId,
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
        peopleOrgSelectPerson = data;
    }).on('onUnsetSelectValue', function () {
        //console.log('onUnsetSelectValue');
    });
}

function peopleOrgInitORG() {
    $("#peopleOrgOrg").bsSuggest('init', {
        effectiveFieldsAlias: { name: "部门" },
        searchFields: ["name"],
        effectiveFields: ["name"],
        showHeader: true,//显示 header
        url: "/lihuaiot01/peopleCombineOrg/selectZTreeNode",
        idField: "id",
        keyField: "name",
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
                    "name": json[i].name,
                    "id": json[i].id,
                });
            }
            //console.log(data);
            return data;
        }
    }).on('onDataRequestSuccess', function (e, result) {
        //console.log('onDataRequestSuccess: ', result);
    }).on('onSetSelectValue', function (e, keyword, data) {
        //console.log('onSetSelectValue: ', keyword, data);
        peopleOrgSelectORG = data;
    }).on('onUnsetSelectValue', function () {
        //console.log('onUnsetSelectValue');
    });
}

function peopleOrgUpdatePeopleOrg() {
    var personId = peopleOrgSelectPerson.personId;
    var personName = peopleOrgSelectPerson.personName;
    var orgId = peopleOrgSelectORG.id;
    var orgName = peopleOrgSelectORG.name;
    $.ajax({
        type: 'POST',
        data: {personId: personId, personName: personName, orgId: orgId, orgName: orgName},
        url: '/lihuaiot01/peopleCombineOrg/peopleCombineOrgUpdate',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            //alert(result);
            peopleOrgSelectPeopleByTreeId();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
    $('#addNew-popup').hide('slow');
}

function peopleOrgDeletePeople() {
    var peopleId = peopleOrgSelectPerson.personId;
    $.ajax({
        type: 'POST',
        data: {peopleId: peopleId},
        url: '/lihuaiot01/peopleCombineOrg/peopleCombineOrgDelete',
        dataType: "text",
        success: function (result) {
            /*alert("1");*/
            //alert(result);
            peopleOrgSelectPeopleByTreeId();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });
}

window.operateEvents = {
    'click .peopleOrgChangeORG': function (e, value, row, index) {
        peopleOrgShowAdd();
        var $txt = $('.addNew-content').find('input');
        $($txt[0]).val(row.personName);
        peopleOrgSelectPerson = row;
        if(typeof(peopleOrgNowTreeNode) !== "undefined"){
            $("#peopleOrgOrg").val(peopleOrgNowTreeNode.name);
        }
    },
    'click .peopleOrgRemoveORG': function (e, value, row, index) {
        peopleOrgSelectPerson = row;
        $('#delcfmModel').modal();
    }
};
