var orgParentNode;
var orgNowTreeNode;
var orgTreeNodes;

$(function () {
    orgInitTreeNode();
});

function orgInitTreeNode() {
    // Some logic to retrieve, or generate tree structure
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/selectTreeNode",
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
                orgTreeNodes = json;
                $('#orgTree').treeview({
                    data: orgTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: orgNodeSelected,
                });
                if (orgParentNode !== undefined) {
                    if (orgParentNode.nodeId !== null) {
                        expendTreeNode(orgParentNode.nodeId);
                    }
                }

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

function expendTreeNode(orgExpendNodeId) {
    orgExpendNode = $('#orgTree').treeview('getNode', orgExpendNodeId);
    $('#orgTree').treeview('expandNode', orgExpendNode);
    if (orgExpendNode.parentId !== undefined && orgExpendNode.parentId !== null) {
        expendTreeNode(orgExpendNode.parentId);
    }
}

function orgInitTreeNodeExpendOrgId(expendOrgId) {
    // Some logic to retrieve, or generate tree structure
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/selectTreeNodeExpend",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
        async: true,   // 轻轻方式-异步
// 要传递的数据
        data: {expendOrgId: expendOrgId},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                var json = eval(result); //数组
                orgTreeNodes = json;
                $('#orgTree').treeview({
                    data: orgTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: orgNodeSelected,
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


function orgNodeSelected(event, data) {
    orgNowTreeNode = data;
    orgParentNode = $('#orgTree').treeview('getParent', data.nodeId);
    $('#orgTree').treeview('clearSearch');
    var zTree = $.fn.zTree.getZTreeObj("orgtree");
    var inputFather = document.getElementById("orginputFather");
    var inputFatherId = document.getElementById("orginputFatherId");
    inputFather.value = orgNowTreeNode.text;
    inputFatherId.value = orgNowTreeNode.id;
    if (data.nodes != null) {
        var select_node = $('#orgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#orgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#orgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
}

function orgSearchTreeNode() {
    var txtSearch = document.getElementById("orgTxtSearchTreeNode").value;
    orgSearchByName(txtSearch);
}

function orgSearchByName(txtSearch) {
    $('#orgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes
            }]);
}

function orgaddNewChildNode() {
    var inputFather = document.getElementById("orginputFather");
    var inputFatherId = document.getElementById("orginputFatherId");
    var inputChild = document.getElementById("orginputSon");
    var inputFatherVal = inputFather.value;
    var inputFatherIdVal = inputFatherId.value;
    var inputChildVal = inputChild.value;
    if (inputFatherIdVal.length == 0)
    {
        showMsg("error", "父节点为空", "请先选择父节点");
        return;
    }
    if (inputChildVal.length == 0)
    {
        showMsg("error", "子节点为空", "请输入子节点名称");
        return;
    }
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/addZTreeNodeChild",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {parentId: inputFatherIdVal, childName: inputChildVal},
        success: function (result) {
            var json = eval(result); //数组
            //orgFindZTreeNode(inputChildVal);
            orgParentNode = orgNowTreeNode;
            orgInitTreeNode();
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            /*alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);*/
            handleAjaxError(XMLHttpRequest.status);
        }
    });

}

function orgremoveSelectNode() {
    var inputFatherId = document.getElementById("orginputFatherId");
    var inputFatherIdVal = inputFatherId.value;
    if (inputFatherIdVal.length == 0)
    {
        showMsg("error", "父节点为空", "请先选择父节点");
        return;
    }
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/removeZTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
// 要传递的数据
        data: {nodeId: inputFatherIdVal},
        success: function (result) {
            if (result === "删除成功") {
                $("#orginputFatherId").val("");
                $("#orginputFather").val("");
                orgInitTreeNode();
            }
            else {
                showMsg("error", result, result);
                //alert(result);
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

function orgrenameSelectNode() {
    var inputFather = document.getElementById("orginputFather");
    var inputFatherId = document.getElementById("orginputFatherId");
    var inputFatherVal = inputFather.value;
    var inputFatherIdVal = inputFatherId.value;
    if (inputFatherIdVal.length == 0)
    {
        showMsg("error", "父节点为空", "请先选择父节点");
        return;
    }
    if (inputFatherVal.length == 0)
    {
        showMsg("error", "父节点名称为空", "请输入修改后的父节点名称");
        return;
    }
    $.ajax({
        url: "/lihuaiot01/bootStrapTreeNode/renameZTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
// 要传递的数据
        data: {nodeId: inputFatherIdVal, nodeName: inputFatherVal},
        success: function (result) {
            if (result === "修改成功") {
                orgInitTreeNode();
            }
            else {
                showMsg("error", result, result);
                //alert(result);
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