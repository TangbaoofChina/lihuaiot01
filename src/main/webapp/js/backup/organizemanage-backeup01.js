var orgparentNode;
var orgnextNode;
var orgnowTreeNode;
var orgtreeNodes;
var orgsetting = {
    view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false,
        fontCss: orggetFontCss
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
            var zTree = $.fn.zTree.getZTreeObj("orgtree");
            var inputFather = document.getElementById("orginputFather");
            var inputFatherId = document.getElementById("orginputFatherId");
            inputFather.value = treeNode.name;
            inputFatherId.value = treeNode.id;
            orgnextNode = treeNode.getNextNode();
            orgparentNode = treeNode.getParentNode();
            orgnowTreeNode = treeNode;
            orgtreeNodeHighLightClear();
            if (treeNode.isParent) {
                zTree.expandNode(treeNode);
            } else {
            }
        }
    }
};

$(function () {
    orgFindZTreeNode("");
});

function orgFindZTreeNode(txtSearch) {
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
                orgtreeNodes = json;
                $.fn.zTree.init($("#orgtree"), orgsetting, orgtreeNodes);
                orgsearchTreeNodeByName(txtSearch);
            } else {
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

function orgsearchTreeNode() {
    var txtSearch = document.getElementById("orgtxtSearchTreeNode").value;
    orgsearchTreeNodeByName("");
    orgsearchTreeNodeByName(txtSearch);
}

function orgsearchTreeNodeByName(txtSearch) {
    var zTree = $.fn.zTree.getZTreeObj("orgtree");
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
        var node = zTree.getNodeByParam("id", "001");//获取id为001的点
        zTree.selectNode(node);//选择点
        zTree.setting.callback.beforeClick(zTree.setting.treeId, node);//调用事件
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

function orggetFontCss(treeId, treeNode) {
    return (!!treeNode.highlight) ? {color: "#A60000", "font-weight": "bold"} : {
        color: "#333",
        "font-weight": "normal"
    };
}

function orgtreeNodeHighLightClear() {
    var zTree = $.fn.zTree.getZTreeObj("orgtree");
    var nodeList = [];
    nodeList = zTree.getNodesByParamFuzzy("name", "");
    for (var i = 0, l = nodeList.length; i < l; i++) {
        nodeList[i].highlight = false;
        zTree.updateNode(nodeList[i]);
    }
}

function orgaddNewChildNode() {
    var inputFather = document.getElementById("orginputFather");
    var inputFatherId = document.getElementById("orginputFatherId");
    var inputChild = document.getElementById("orginputSon");
    var inputFatherVal = inputFather.value;
    var inputFatherIdVal = inputFatherId.value;
    var inputChildVal = inputChild.value;
    $.ajax({
        url: "/lihuaiot01/treeNode/addZTreeNodeChild",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {parentId: inputFatherIdVal, childName: inputChildVal},
        success: function (result) {
            var json = eval(result); //数组
            orgFindZTreeNode(inputChildVal);
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
    $.ajax({
        url: "/lihuaiot01/treeNode/removeZTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
// 要传递的数据
        data: {nodeId: inputFatherIdVal},
        success: function (result) {
            if (result === "删除成功") {
                if (orgparentNode != null) {
                    orgFindZTreeNode(orgparentNode.name);
                }
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
    $.ajax({
        url: "/lihuaiot01/treeNode/renameZTreeNode",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "text",
// 要传递的数据
        data: {nodeId: inputFatherIdVal, nodeName: inputFatherVal},
        success: function (result) {
            if (result === "修改成功") {
                orgFindZTreeNode(inputFatherVal);
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