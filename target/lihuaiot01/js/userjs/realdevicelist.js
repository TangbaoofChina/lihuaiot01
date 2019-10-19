var rdlNowTreeNode;
var rdlNowTreeNodeRoot;
var rdlTableColumns;
var rdlSewageC01TableColumns;
var rdlSewageC212TableColumns;
var rdlSewageC214TableColumns;
var rdlScaleC01TableColumns;
var rdlHj212C213TableColumns;
var rdlWeighC312TableColumns;
var rdlFeedC411TableColumns;
var rdlTreeNodes;
var realid_of_setintervalDeviceList;
var realid_of_setintervalDeviceOne;
$(function () {
    rdlInitTreeNode();
    rdlInitTableEC01();
    rdlInitTableSewageC01();
    rdlInitTableSewageC212();
    rdlInitTableSewageC214();
    rdlInitTableScaleC01();
    rdlInitTableHj212C213();
    rdlInitTableWeighC312();
    rdlInitTableFeedC411();
    rdlExportStorageAction();
    //定时刷新数据
    realid_of_setintervalDeviceList = setInterval(function () {
        rdlTableRefresh();
    }, 3000);
    realid_of_setintervalDeviceOne = setInterval(function () {
        rdlSelectInfoByDeviceIdAndType();
    }, 3000);
});

function rdlInitTreeNode() {
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
                rdlTreeNodes = json;
                /*console.log(rdlTreeNodes);*/
                $('#rdlOrgTree').treeview({
                    data: rdlTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: rdlNodeSelected,
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

function rdlSearchTreeNode() {
    var txtSearch = document.getElementById("rdlTxtSearchTreeNode").value;
    $('#rdlOrgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes
            }]);
}

function rdlGetRootNode(tree, treeNode) {
    if (treeNode.parentId === undefined) {
        rdlNowTreeNodeRoot = treeNode;
        return;
    }
    var parentNode = tree.treeview('getNode', treeNode.parentId);
    if (parentNode.parentId !== undefined)
        rdlGetRootNode(tree, parentNode);
    else {
        rdlNowTreeNodeRoot = parentNode;
    }
}

function rdlNodeSelected(event, data) {
    rdlNowTreeNode = data;
    rdlGetRootNode($('#rdlOrgTree'), rdlNowTreeNode);
    $('#rdlOrgTree').treeview('clearSearch');
    var queryParameter = rdlNowTreeNode.id;
    var uiEC01List = document.getElementById("rdlEC01DeviceListDiv");
    var uiEC01One = document.getElementById("rdlEC01OneDeviceDiv");
    var uiSewageC01List = document.getElementById("rdlSewageC01DeviceListDiv");
    var uiSewageC01One = document.getElementById("rdlSewageC01OneDeviceDiv");
    var uiSewageC212List = document.getElementById("rdlSewageC212DeviceListDiv");
    var uiSewageC212One = document.getElementById("rdlSewageC212OneDeviceDiv");
    var uiSewageC214List = document.getElementById("rdlSewageC214DeviceListDiv");
    var uiSewageC214One = document.getElementById("rdlSewageC214OneDeviceDiv");
    var uiScaleC01List = document.getElementById("rdlScaleC01DeviceListDiv");
    var uiScaleC01One = document.getElementById("rdlScaleC01OneDeviceDiv");
    var uiHj212C213List = document.getElementById("rdlHj212C213DeviceListDiv");
    var uiHj212C213One = document.getElementById("rdlHj212C213OneDeviceDiv");
    var uiWeighC312List = document.getElementById("rdlWeighC312DeviceListDiv");
    var uiWeighC312One = document.getElementById("rdlWeighC312OneDeviceDiv");
    var uiFeedC411List = document.getElementById("rdlFeedC411DeviceListDiv");
    var uiFeedC411One = document.getElementById("rdlFeedC411OneDeviceDiv");
    var rootNodeId = rdlNowTreeNodeRoot.id;
    if (queryParameter.length == 4) {
        if (rootNodeId === "111")   //种禽环控器
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "block";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "211")  //立华禽环保1.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "block";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "212")  //立华禽环保2.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "block";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "214")  //立华禽环保2.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "block";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "311")  //自动称重
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "block";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "312")  //种禽料塔称重1.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "block";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
    } else if(rootNodeId === "213" && queryParameter.length == 14){
        uiEC01List.style.display = "none";
        uiEC01One.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC01One.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC212One.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiSewageC214One.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiScaleC01One.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiHj212C213One.style.display = "block";
        uiWeighC312List.style.display = "none";
        uiWeighC312One.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiFeedC411One.style.display = "none";
    } else if(rootNodeId === "411" && queryParameter.length == 7){
        uiEC01List.style.display = "none";
        uiEC01One.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC01One.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC212One.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiSewageC214One.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiScaleC01One.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiHj212C213One.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiWeighC312One.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiFeedC411One.style.display = "block";
    } else {
        if (rootNodeId === "111")   //种禽环控器
        {
            uiEC01List.style.display = "block";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "211")  //立华禽环保1.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "block";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "212")  //立华禽环保2.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "block";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "214")  //立华禽环保3.0
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "block";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "311")  //商品鸡自动称重
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "block";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if (rootNodeId === "312")  //种鸡散装料塔称重
        {
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "block";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if(rootNodeId === "213"){ //水质在线监测
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "block";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "none";
            uiFeedC411One.style.display = "none";
        }
        else if(rootNodeId === "411"){ //饲料部筒仓测温
            uiEC01List.style.display = "none";
            uiEC01One.style.display = "none";
            uiSewageC01List.style.display = "none";
            uiSewageC01One.style.display = "none";
            uiSewageC212List.style.display = "none";
            uiSewageC212One.style.display = "none";
            uiSewageC214List.style.display = "none";
            uiSewageC214One.style.display = "none";
            uiScaleC01List.style.display = "none";
            uiScaleC01One.style.display = "none";
            uiHj212C213List.style.display = "none";
            uiHj212C213One.style.display = "none";
            uiWeighC312List.style.display = "none";
            uiWeighC312One.style.display = "none";
            uiFeedC411List.style.display = "block";
            uiFeedC411One.style.display = "none";
        }
    }
    if (data.nodes != null) {
        var select_node = $('#rdlOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#rdlOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#rdlOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    if (rootNodeId === "111")   //种禽环控器
    {
        rdlSelectDeviceByTreeIdEC01();
    }
    else if (rootNodeId === "211")  //立华禽环保1.0
    {
        rdlSelectDeviceByTreeIdSewageC01();
    }
    else if (rootNodeId === "212")  //立华禽环保2.0
    {
        rdlSelectDeviceByTreeIdSewageC212();
    }
    else if (rootNodeId === "214")  //立华禽环保3.0
    {
        rdlSelectDeviceByTreeIdSewageC214();
    }
    else if (rootNodeId === "311")  //污水控制器
    {
        rdlSelectDeviceByTreeIdScaleC01();
    }
    else if (rootNodeId === "312")  //种禽散装料塔称重1.0
    {
        rdlSelectDeviceByTreeIdWeighC312();
    }
    else if (rootNodeId === "213")  //水质在线监测
    {
        rdlSelectDeviceByTreeIdHj212C213();
    }
    else if (rootNodeId === "411")  //饲料部筒仓测温
    {
        rdlInitTableFeedC41102(queryParameter);
        setTimeout("rdlSelectDeviceByTreeIdFeedC411()",300);
    }
    rdlSelectInfoByDeviceIdAndType();
}

//图表刷新
function rdlSelectInfoByDeviceIdAndType() {
    if (typeof(rdlNowTreeNode) == "undefined")
        return;
    var queryParameter = rdlNowTreeNode.id;
    var rootNodeId = rdlNowTreeNodeRoot.id;
    if(rootNodeId === "411" && queryParameter.length === 7){
        rdlSelectInfoByDeviceIdAndFeedC411(queryParameter)
    }
    if (queryParameter.length !== 4) {
        return;
    }
    if (rootNodeId === "111")   //种禽环控器
    {
        rdlSelectInfoByDeviceIdAndEC01(queryParameter)
    }
    else if (rootNodeId === "211")  //立华禽环保1.0
    {
        rdlSelectInfoByDeviceIdAndSewageC01(queryParameter)
    }
    else if (rootNodeId === "212")  //立华禽环保2.0
    {
        rdlSelectInfoByDeviceIdAndSewageC212(queryParameter)
    }
    else if (rootNodeId === "214")  //立华禽环保4.0
    {
        rdlSelectInfoByDeviceIdAndSewageC214(queryParameter)
    }
}

// 表格刷新
function rdlTableRefresh() {
    if (typeof(rdlNowTreeNode) == "undefined")
        return;
    /*    var rdlDeviceList = document.getElementById("rdlDeviceList");
        if (rdlDeviceList === null)
            return;*/
    var queryParameter = rdlNowTreeNode.id;
    var rootNodeId = rdlNowTreeNodeRoot.id;
    if (queryParameter.length === 4) { //单个设备界面不需要刷新
        return;
    }
    if (rootNodeId === "411" && queryParameter.length === 7) { //单个设备界面不需要刷新
        return;
    }
    try {
        if (rootNodeId === "111")   //种禽环控器
        {
            $('#rdlEC01DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if (rootNodeId === "211")  //立华禽环保1.0
        {
            $('#rdlSewageC01DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if (rootNodeId === "212")  //立华禽环保2.0
        {
            $('#rdlSewageC212DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if (rootNodeId === "214")  //立华禽环保3.0
        {
            $('#rdlSewageC214DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if (rootNodeId === "311")  //自动称重
        {
            $('#rdlScaleC01DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if ( rootNodeId === "312")  //自动称重
        {
            $('#rdlWeighC312DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if (rootNodeId === "213")  //水质在线监测
        {
            $('#rdlHj212C213DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
        else if (rootNodeId === "411")  //饲料部-筒仓测温
        {
            $('#rdlFeedC411DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
    }
    catch (err) {
        if (realid_of_setintervalDeviceList !== undefined) {
            clearInterval(realid_of_setintervalDeviceList);
        }
        var type = 'error';
        var msg = '实时数据列表定时刷新出错';
        var append = '对不起，实时数据列表定时刷新出错:' + err;
        showMsg(type, msg, append);
    }
}

//************************EC01 start******************************/
function rdlSelectInfoByDeviceIdAndEC01(queryParameter) {
    var wetCurtainWPOpenDiv = document.getElementById("wetCurtainWPOpen");
    if (wetCurtainWPOpenDiv === null)
        return;
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectEC01ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                var wetCurtainWPOpen = document.getElementById("wetCurtainWPOpen");
                var wetCurtainWPClose = document.getElementById("wetCurtainWPClose");
                var fan01Open = document.getElementById("fan01Open");
                var fan01Close = document.getElementById("fan01Close");
                var fan02Open = document.getElementById("fan02Open");
                var fan02Close = document.getElementById("fan02Close");
                var fan03Open = document.getElementById("fan03Open");
                var fan03Close = document.getElementById("fan03Close");
                var fan04Open = document.getElementById("fan04Open");
                var fan04Close = document.getElementById("fan04Close");
                var fan05Open = document.getElementById("fan05Open");
                var fan05Close = document.getElementById("fan05Close");
                if (result.wetCurtainOn === "关")  //湿帘水泵
                {
                    wetCurtainWPOpen.style.display = "none";
                    wetCurtainWPClose.style.display = "block";
                } else {
                    wetCurtainWPOpen.style.display = "block";
                    wetCurtainWPClose.style.display = "none";
                }
                if (result.fan01On === "关")  //风机1
                {
                    fan01Open.style.display = "none";
                    fan01Close.style.display = "block";
                } else {
                    fan01Open.style.display = "block";
                    fan01Close.style.display = "none";
                }
                if (result.fan02On === "关")  //风机2
                {
                    fan02Open.style.display = "none";
                    fan02Close.style.display = "block";
                } else {
                    fan02Open.style.display = "block";
                    fan02Close.style.display = "none";
                }
                if (result.fan03On === "关")  //风机3
                {
                    fan03Open.style.display = "none";
                    fan03Close.style.display = "block";
                } else {
                    fan03Open.style.display = "block";
                    fan03Close.style.display = "none";
                }
                if (result.fan04On === "关")  //风机4
                {
                    fan04Open.style.display = "none";
                    fan04Close.style.display = "block";
                } else {
                    fan04Open.style.display = "block";
                    fan04Close.style.display = "none";
                }
                if (result.fan05On === "关")  //风机5
                {
                    fan05Open.style.display = "none";
                    fan05Close.style.display = "block";
                } else {
                    fan05Open.style.display = "block";
                    fan05Close.style.display = "none";
                }
                var inTemp1 = document.getElementById("inTemp1");
                var inTemp2 = document.getElementById("inTemp2");
                var inTemp3 = document.getElementById("inTemp3");
                var outTemp = document.getElementById("outTemp");
                var boilerTemp = document.getElementById("boilerTemp");
                var avgTemp = document.getElementById("avgTemp");
                var humidityVal = document.getElementById("humidityVal");
                var nh3Val = document.getElementById("nh3Val");
                var co2Val = document.getElementById("co2Val");
                var lightIntensity = document.getElementById("lightIntensity");
                var waterFlowVal = document.getElementById("waterFlowVal");
                var sc01date = document.getElementById("sc01date");
                inTemp1.innerHTML = result.inTemp1 + " ℃";
                inTemp2.innerHTML = result.inTemp2 + " ℃";
                inTemp3.innerHTML = result.inTemp3 + " ℃";
                outTemp.innerHTML = result.outTemp + " ℃";
                boilerTemp.innerHTML = result.boilerTemp + " ℃";
                avgTemp.innerHTML = result.inAveTemp + " ℃";
                humidityVal.innerHTML = result.humidityVal + " %";
                nh3Val.innerHTML = result.nh3Val + " ppm";
                co2Val.innerHTML = result.co2Val + " ppm";
                sc01date.innerHTML = result.sendDate;
                lightIntensity.innerHTML = result.lightIntensity + " Lux";
                waterFlowVal.innerHTML = result.waterFlowVal + " L";
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
            //alert(XMLHttpRequest.status);
            handleAjaxError(XMLHttpRequest.status);
            //alert(XMLHttpRequest.readyState);
            //alert(textStatus);
        }
    });
}

function rdlInitTableEC01() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/ec01DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlTableColumns = questionColumns;
            $('#rdlEC01DeviceList').bootstrapTable('destroy');
            $('#rdlEC01DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdEC01() {

    $('#rdlEC01DeviceList').bootstrapTable('destroy');

    $('#rdlEC01DeviceList').bootstrapTable({
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
        pageSize: 100,
        //可供选择的每页的行数（*）
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectEC01ByORGId",
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
        columns: rdlTableColumns,
        height: 500,               //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************EC01 end******************************/

//************************SewageC01 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC01(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSewageC01ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRun = document.getElementById("collectMixerRun");
                var collectMixerStop = document.getElementById("collectMixerStop");
                //除磷投加机
                var dephosphorizeRun = document.getElementById("dephosphorizeRun");
                var dephosphorizeStop = document.getElementById("dephosphorizeStop");
                //集水池提升泵
                var collectPumpRun = document.getElementById("collectPumpRun");
                var collectPumpStop = document.getElementById("collectPumpStop");
                //污泥泵1
                var sludgePump01Run = document.getElementById("sludgePump01Run");
                var sludgePump01Stop = document.getElementById("sludgePump01Stop");
                if (result.collectMixerRun === false)  //集水池搅拌机
                {
                    collectMixerRun.style.display = "none";
                    collectMixerStop.style.display = "block";
                } else {
                    collectMixerRun.style.display = "block";
                    collectMixerStop.style.display = "none";
                }
                if (result.dephosphorizeRun === false)  //除磷投加机
                {
                    dephosphorizeRun.style.display = "none";
                    dephosphorizeStop.style.display = "block";
                } else {
                    dephosphorizeRun.style.display = "block";
                    dephosphorizeStop.style.display = "none";
                }
                if (result.collectPumpRun === false)  //集水池提升泵
                {
                    collectPumpRun.style.display = "none";
                    collectPumpStop.style.display = "block";
                } else {
                    collectPumpRun.style.display = "block";
                    collectPumpStop.style.display = "none";
                }
                if (result.sludgePump01Run === false)  //污泥泵1
                {
                    sludgePump01Run.style.display = "none";
                    sludgePump01Stop.style.display = "block";
                } else {
                    sludgePump01Run.style.display = "block";
                    sludgePump01Stop.style.display = "none";
                }
                /*************SBR污水处理控制系统***************/
                    //SBR池进水泵
                var sbrIntakePumpRun = document.getElementById("sbrIntakePumpRun");
                var sbrIntakePumpStop = document.getElementById("sbrIntakePumpStop");
                //SBR池搅拌机
                var sbrMixerRun = document.getElementById("sbrMixerRun");
                var sbrMixerStop = document.getElementById("sbrMixerStop");
                //回转式风机1
                var fan01Run = document.getElementById("fan01Run");
                var fan01Stop = document.getElementById("fan01Stop");
                //回转式风机2
                var fan02Run = document.getElementById("fan02Run");
                var fan02Stop = document.getElementById("fan02Stop");
                //SBR曝气
                var fanRun = document.getElementById("fanRun");
                var fanStop = document.getElementById("fanStop");
                //SBR污泥泵2
                var sludgePump02Run = document.getElementById("sludgePump02Run");
                var sludgePump02Stop = document.getElementById("sludgePump02Stop");
                //滗水器设备
                var decanterRun = document.getElementById("decanterRun");
                var decanterStop = document.getElementById("decanterStop");

                if (result.sbrIntakePumpRun === false)  //SBR池进水泵
                {
                    sbrIntakePumpRun.style.display = "none";
                    sbrIntakePumpStop.style.display = "block";
                } else {
                    sbrIntakePumpRun.style.display = "block";
                    sbrIntakePumpStop.style.display = "none";
                }
                if (result.sbrMixerRun === false)  //SBR池搅拌机
                {
                    sbrMixerRun.style.display = "none";
                    sbrMixerStop.style.display = "block";
                } else {
                    sbrMixerRun.style.display = "block";
                    sbrMixerStop.style.display = "none";
                }
                if (result.fan01Run === false)  //回转式风机1
                {
                    fan01Run.style.display = "none";
                    fan01Stop.style.display = "block";
                } else {
                    fan01Run.style.display = "block";
                    fan01Stop.style.display = "none";
                }
                if (result.fan02Run === false)  //回转式风机2
                {
                    fan02Run.style.display = "none";
                    fan02Stop.style.display = "block";
                } else {
                    fan02Run.style.display = "block";
                    fan02Stop.style.display = "none";
                }
                //SBR曝气
                if (result.fan01Run === false && result.fan02Run === false) {
                    fanRun.style.display = "none";
                    fanStop.style.display = "block";
                } else {
                    fanRun.style.display = "block";
                    fanStop.style.display = "none";
                }
                if (result.sludgePump02Run === false)  //SBR污泥泵2
                {
                    sludgePump02Run.style.display = "none";
                    sludgePump02Stop.style.display = "block";
                } else {
                    sludgePump02Run.style.display = "block";
                    sludgePump02Stop.style.display = "none";
                }
                if (result.decanterRun === false)  //滗水器
                {
                    decanterRun.style.display = "none";
                    decanterStop.style.display = "block";
                } else {
                    decanterRun.style.display = "block";
                    decanterStop.style.display = "none";
                }

                //SBR池一次搅拌
                var sbrMixerOnceRun = document.getElementById("sbrMixerOnceRun");
                var sbrMixerOnceStop = document.getElementById("sbrMixerOnceStop");
                if (result.sbrMixerOnceRun === false)  //SBR池一次搅拌
                {
                    sbrMixerOnceRun.style.display = "none";
                    sbrMixerOnceStop.style.display = "block";
                } else {
                    sbrMixerOnceRun.style.display = "block";
                    sbrMixerOnceStop.style.display = "none";
                }

                //SBR二次搅拌
                var sbrMixerSecRun = document.getElementById("sbrMixerSecRun");
                var sbrMixerSecStop = document.getElementById("sbrMixerSecStop");
                if (result.sbrMixerSecRun === false)  //SBR池一次搅拌
                {
                    sbrMixerSecRun.style.display = "none";
                    sbrMixerSecStop.style.display = "block";
                } else {
                    sbrMixerSecRun.style.display = "block";
                    sbrMixerSecStop.style.display = "none";
                }

                //SBR静置
                var sbrStaticRun = document.getElementById("sbrStaticRun");
                var sbrStaticStop = document.getElementById("sbrStaticStop");
                if (result.sbrStaticRun === false)  //SBR池一次搅拌
                {
                    sbrStaticRun.style.display = "none";
                    sbrStaticStop.style.display = "block";
                } else {
                    sbrStaticRun.style.display = "block";
                    sbrStaticStop.style.display = "none";
                }

                //滗水器周期
                var decanterCycleRun = document.getElementById("decanterCycleRun");
                var decanterCycleStop = document.getElementById("decanterCycleStop");
                if (result.decanterCycleRun === false)  //SBR池一次搅拌
                {
                    decanterCycleRun.style.display = "none";
                    decanterCycleStop.style.display = "block";
                } else {
                    decanterCycleRun.style.display = "block";
                    decanterCycleStop.style.display = "none";
                }

                //SBR活化
                var sbrActiveRun = document.getElementById("sbrActiveRun");
                var sbrActiveStop = document.getElementById("sbrActiveStop");
                if (result.sbrActiveRun === false)  //SBR池一次搅拌
                {
                    sbrActiveRun.style.display = "none";
                    sbrActiveStop.style.display = "block";
                } else {
                    sbrActiveRun.style.display = "block";
                    sbrActiveStop.style.display = "none";
                }

                //水流量
                var flowmeter = document.getElementById("flowmeter");
                //时间
                var sewagec01sendDate = document.getElementById("sewagec01sendDate");
                //水流量
                flowmeter.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec01sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter = document.getElementById("todayFlowmeter");
                //当日水流量
                todayFlowmeter.innerHTML = result.todayFlowmeter + "m³";

                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRunMinute = document.getElementById("collectMixerRunMinute");
                //除磷投加机
                var dephosphorizeRunMinute = document.getElementById("dephosphorizeRunMinute");
                //集水池提升泵
                var collectPumpRunMinute = document.getElementById("collectPumpRunMinute");
                //污泥泵1
                var sludgePump01RunMinute = document.getElementById("sludgePump01RunMinute");
                //集水池搅拌机
                collectMixerRunMinute.innerText = result.collectMixerRunMinute;
                //除磷投加机
                dephosphorizeRunMinute.innerText = result.dephosphorizeRunMinute;
                //集水池提升泵
                collectPumpRunMinute.innerText = result.collectPumpRunMinute;
                //污泥泵1
                sludgePump01RunMinute.innerText = result.sludgePump01RunMinute;
                /*************SBR污水处理控制系统***************/
                    //SBR池进水泵
                var sbrIntakePumpRunMinute = document.getElementById("sbrIntakePumpRunMinute");
                //SBR一次搅拌
                var sbrMixerOnceRunMinute = document.getElementById("sbrMixerOnceRunMinute");
                //SBR曝气
                var fanRunMinute = document.getElementById("fanRunMinute");
                //SBR混合
                var sbrMixerRunMinute = document.getElementById("sbrMixerRunMinute");
                //SBR静置
                var sbrStaticRunMinute = document.getElementById("sbrStaticRunMinute");
                //SBR污泥泵2
                var sludgePump02RunMinute = document.getElementById("sludgePump02RunMinute");
                //SBR活化
                var sbrActiveRunMinute = document.getElementById("sbrActiveRunMinute");
                //SBR池进水泵
                sbrIntakePumpRunMinute.innerText = result.sbrIntakePumpRunMinute;
                //SBR一次搅拌
                sbrMixerOnceRunMinute.innerText = result.sbrMixerOnceRunMinute;
                //SBR曝气
                fanRunMinute.innerText = result.fanRunMinute;
                //SBR混合
                sbrMixerRunMinute.innerText = result.sbrMixerRunMinute;
                //SBR静置
                sbrStaticRunMinute.innerText = result.sbrStaticRunMinute;
                //SBR污泥泵2
                sludgePump02RunMinute.innerText = result.sludgePump02RunMinute;
                //SBR活化
                sbrActiveRunMinute.innerText = result.sbrActiveRunMinute;
                /***************工艺流程设定时间*************************/
                    //除磷投加机
                var dephosphorizeSetMinute = document.getElementById("dephosphorizeSetMinute");
                dephosphorizeSetMinute.innerText = result.dephosphorizeSetMinute;
                //污泥泵1
                var sludgePump01SetMinute = document.getElementById("sludgePump01SetMinute");
                sludgePump01SetMinute.innerText = result.sludgePump01SetMinute;
                //SBR设定时间
                var sbrCycleSetMinute = document.getElementById("sbrCycleSetMinute");
                sbrCycleSetMinute.innerText = result.sbrCycleSetMinute;
                //SBR一次搅拌
                var sbrMixerOnceSetMinute = document.getElementById("sbrMixerOnceSetMinute");
                sbrMixerOnceSetMinute.innerText = result.sbrMixerOnceSetMinute;
                //SBR曝气
                var fanSetMinute = document.getElementById("fanSetMinute");
                fanSetMinute.innerText = result.fanSetMinute;
                //SBR混合
                var sbrMixerSetMinute = document.getElementById("sbrMixerSetMinute");
                sbrMixerSetMinute.innerText = result.sbrMixerSetMinute;
                //SBR静置
                var sbrStaticSetMinute = document.getElementById("sbrStaticSetMinute");
                sbrStaticSetMinute.innerText = result.sbrStaticSetMinute;
                //SBR污泥泵2
                var sludgePump02SetMinute = document.getElementById("sludgePump02SetMinute");
                sludgePump02SetMinute.innerText = result.sludgePump02SetMinute;
                //SBR活化
                var sbrActiveSetMinute = document.getElementById("sbrActiveSetMinute");
                sbrActiveSetMinute.innerText = result.sbrActiveSetMinute;
                /***************公共参数*************************/
                    //系统自动模式
                var systemAutoRun = document.getElementById("systemAutoRun");
                var systemAutoStop = document.getElementById("systemAutoStop");
                if (result.systemAuto === false) {
                    systemAutoRun.style.display = "none";
                    systemAutoStop.style.display = "block";
                } else {
                    systemAutoRun.style.display = "block";
                    systemAutoStop.style.display = "none";
                }
                //SBR周期运行
                var sbrCycleRun = document.getElementById("sbrCycleRun");
                var sbrCycleStop = document.getElementById("sbrCycleStop");
                if (result.sbrCycle === false) {
                    sbrCycleRun.style.display = "none";
                    sbrCycleStop.style.display = "block";
                } else {
                    sbrCycleRun.style.display = "block";
                    sbrCycleStop.style.display = "none";
                }
                //集水池液位高
                var collectHighOn = document.getElementById("collectHighOn");
                var collectHighOff = document.getElementById("collectHighOff");
                if (result.collectHighOn === false) {
                    collectHighOn.style.display = "none";
                    collectHighOff.style.display = "block";
                } else {
                    collectHighOn.style.display = "block";
                    collectHighOff.style.display = "none";
                }
                //集水池液位低
                var collectLowOn = document.getElementById("collectLowOn");
                var collectLowOff = document.getElementById("collectLowOff");
                if (result.collectLowOn === false) {
                    collectLowOn.style.display = "none";
                    collectLowOff.style.display = "block";
                } else {
                    collectLowOn.style.display = "block";
                    collectLowOff.style.display = "none";
                }
                //调节池液位高
                var regulatHighOn = document.getElementById("regulatHighOn");
                var regulatHighOff = document.getElementById("regulatHighOff");
                if (result.regulatHighOn === false) {
                    regulatHighOn.style.display = "none";
                    regulatHighOff.style.display = "block";
                } else {
                    regulatHighOn.style.display = "block";
                    regulatHighOff.style.display = "none";
                }
                //调节池液位低
                var regulatLowOn = document.getElementById("regulatLowOn");
                var regulatLowOff = document.getElementById("regulatLowOff");
                if (result.regulatLowOn === false) {
                    regulatLowOn.style.display = "none";
                    regulatLowOff.style.display = "block";
                } else {
                    regulatLowOn.style.display = "block";
                    regulatLowOff.style.display = "none";
                }
                //SBR池液位高
                var sbrHighOn = document.getElementById("sbrHighOn");
                var sbrHighOff = document.getElementById("sbrHighOff");
                if (result.sbrHighOn === false) {
                    sbrHighOn.style.display = "none";
                    sbrHighOff.style.display = "block";
                } else {
                    sbrHighOn.style.display = "block";
                    sbrHighOff.style.display = "none";
                }
                //SBR池液位低
                var sbrLowOn = document.getElementById("sbrLowOn");
                var sbrLowOff = document.getElementById("sbrLowOff");
                if (result.sbrLowOn === false) {
                    sbrLowOn.style.display = "none";
                    sbrLowOff.style.display = "block";
                } else {
                    sbrLowOn.style.display = "block";
                    sbrLowOff.style.display = "none";
                }
                /***************故障状态*************************/
                    //集水池搅拌机
                var collectMixerNormal = document.getElementById("collectMixerNormal");
                var collectMixerFault = document.getElementById("collectMixerFault");
                if (result.collectMixerFault === true) {
                    collectMixerNormal.style.display = "none";
                    collectMixerFault.style.display = "block";
                } else {
                    collectMixerNormal.style.display = "block";
                    collectMixerFault.style.display = "none";
                }
                //集水池提升泵
                var collectPumpNormal = document.getElementById("collectPumpNormal");
                var collectPumpFault = document.getElementById("collectPumpFault");
                if (result.collectPumpFault === true) {
                    collectPumpNormal.style.display = "none";
                    collectPumpFault.style.display = "block";
                } else {
                    collectPumpNormal.style.display = "block";
                    collectPumpFault.style.display = "none";
                }
                //污泥泵1
                var sludgePump01Normal = document.getElementById("sludgePump01Normal");
                var sludgePump01Fault = document.getElementById("sludgePump01Fault");
                if (result.sludgePump01Fault === true) {
                    sludgePump01Normal.style.display = "none";
                    sludgePump01Fault.style.display = "block";
                } else {
                    sludgePump01Normal.style.display = "block";
                    sludgePump01Fault.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpNormal = document.getElementById("sbrIntakePumpNormal");
                var sbrIntakePumpFault = document.getElementById("sbrIntakePumpFault");
                if (result.sbrIntakePumpFault === true) {
                    sbrIntakePumpNormal.style.display = "none";
                    sbrIntakePumpFault.style.display = "block";
                } else {
                    sbrIntakePumpNormal.style.display = "block";
                    sbrIntakePumpFault.style.display = "none";
                }
                //SBR池搅拌机1
                var sbrMixer01Normal = document.getElementById("sbrMixer01Normal");
                var sbrMixer01Fault = document.getElementById("sbrMixer01Fault");
                if (result.sbrMixer01Fault === true) {
                    sbrMixer01Normal.style.display = "none";
                    sbrMixer01Fault.style.display = "block";
                } else {
                    sbrMixer01Normal.style.display = "block";
                    sbrMixer01Fault.style.display = "none";
                }
                //SBR池搅拌机2
                var sbrMixer02Normal = document.getElementById("sbrMixer02Normal");
                var sbrMixer02Fault = document.getElementById("sbrMixer02Fault");
                if (result.sbrMixer02Fault === true) {
                    sbrMixer02Normal.style.display = "none";
                    sbrMixer02Fault.style.display = "block";
                } else {
                    sbrMixer02Normal.style.display = "block";
                    sbrMixer02Fault.style.display = "none";
                }
                //回转式风机1
                var fan01Normal = document.getElementById("fan01Normal");
                var fan01Fault = document.getElementById("fan01Fault");
                if (result.fan01Fault === true) {
                    fan01Normal.style.display = "none";
                    fan01Fault.style.display = "block";
                } else {
                    fan01Normal.style.display = "block";
                    fan01Fault.style.display = "none";
                }
                //回转式风机2
                var fan02Normal = document.getElementById("fan02Normal");
                var fan02Fault = document.getElementById("fan02Fault");
                if (result.fan02Fault === true) {
                    fan02Normal.style.display = "none";
                    fan02Fault.style.display = "block";
                } else {
                    fan02Normal.style.display = "block";
                    fan02Fault.style.display = "none";
                }
                //污泥泵2
                var sludgePump02Normal = document.getElementById("sludgePump02Normal");
                var sludgePump02Fault = document.getElementById("sludgePump02Fault");
                if (result.sludgePump02Fault === true) {
                    sludgePump02Normal.style.display = "none";
                    sludgePump02Fault.style.display = "block";
                } else {
                    sludgePump02Normal.style.display = "block";
                    sludgePump02Fault.style.display = "none";
                }
                //滗水器
                var decanterNormal = document.getElementById("decanterNormal");
                var decanterFault = document.getElementById("decanterFault");
                if (result.decanterFault === true) {
                    decanterNormal.style.display = "none";
                    decanterFault.style.display = "block";
                } else {
                    decanterNormal.style.display = "block";
                    decanterFault.style.display = "none";
                }
                //PLC电量
                var plcElecNormal = document.getElementById("plcElecNormal");
                var plcElecLack = document.getElementById("plcElecLack");
                if (result.plcElecLack === true) {
                    plcElecNormal.style.display = "none";
                    plcElecLack.style.display = "block";
                } else {
                    plcElecNormal.style.display = "block";
                    plcElecLack.style.display = "none";
                }
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

function rdlInitTableSewageC01() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/sewagec01DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlSewageC01TableColumns = questionColumns;
            $('#rdlSewageC01DeviceList').bootstrapTable('destroy');
            $('#rdlSewageC01DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdSewageC01() {

    $('#rdlSewageC01DeviceList').bootstrapTable('destroy');

    $('#rdlSewageC01DeviceList').bootstrapTable({
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
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectSewageC01ByORGId",
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
        columns: rdlSewageC01TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//************************SewageC01 end******************************/

//************************SewageC212 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC212(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSewageC212ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                /*************抬头***************/
                    //水流量
                var flowmeter212 = document.getElementById("flowmeter212");
                //时间
                var sewagec212sendDate = document.getElementById("sewagec212sendDate");
                //水流量
                flowmeter212.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec212sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter212 = document.getElementById("todayFlowmeter212");
                //当日水流量
                todayFlowmeter212.innerHTML = result.todayFlowmeter + "m³";
                //累计电量
                var totalEp212 = document.getElementById("totalEp212");
                //累计电量
                totalEp212.innerHTML = result.impEP + "";
                //当日电量
                var todayEp212 = document.getElementById("todayEp212");
                //当日电量
                todayEp212.innerHTML = result.todayEP + "";
                //环境温度
                var airTemp212 = document.getElementById("airTemp212");
                //环境温度
                airTemp212.innerHTML = result.airTemp + "℃";
                //SBR水温
                var waterTemp212 = document.getElementById("waterTemp212");
                //SBR水温
                waterTemp212.innerHTML = result.waterTemp + "℃";
                /*************污水处理前期工艺***************/
                //集水池搅拌机
                var collectMixerRun212 = document.getElementById("collectMixerRun212");
                var collectMixerStop212 = document.getElementById("collectMixerStop212");
                //除磷投加机
                var dephosphorizeRun212 = document.getElementById("dephosphorizeRun212");
                var dephosphorizeStop212 = document.getElementById("dephosphorizeStop212");
                //集水池提升泵
                var collectPumpRun212 = document.getElementById("collectPumpRun212");
                var collectPumpStop212 = document.getElementById("collectPumpStop212");
                //污泥泵1
                var sludgePump01Run212 = document.getElementById("sludgePump01Run212");
                var sludgePump01Stop212 = document.getElementById("sludgePump01Stop212");
                if (result.collectMixerRun === false)  //集水池搅拌机
                {
                    collectMixerRun212.style.display = "none";
                    collectMixerStop212.style.display = "block";
                } else {
                    collectMixerRun212.style.display = "block";
                    collectMixerStop212.style.display = "none";
                }
                if (result.dephosphorizeRun === false)  //除磷投加机
                {
                    dephosphorizeRun212.style.display = "none";
                    dephosphorizeStop212.style.display = "block";
                } else {
                    dephosphorizeRun212.style.display = "block";
                    dephosphorizeStop212.style.display = "none";
                }
                if (result.collectPumpRun === false)  //集水池提升泵
                {
                    collectPumpRun212.style.display = "none";
                    collectPumpStop212.style.display = "block";
                } else {
                    collectPumpRun212.style.display = "block";
                    collectPumpStop212.style.display = "none";
                }
                if (result.sludgePump01Run === false)  //污泥泵1
                {
                    sludgePump01Run212.style.display = "none";
                    sludgePump01Stop212.style.display = "block";
                } else {
                    sludgePump01Run212.style.display = "block";
                    sludgePump01Stop212.style.display = "none";
                }
                /*************污水处理前期工艺***************/
                    //集水池搅拌机
                var collectMixerRunMinute212 = document.getElementById("collectMixerRunMinute212");
                //除磷投加机
                var dephosphorizeRunMinute212 = document.getElementById("dephosphorizeRunMinute212");
                //集水池提升泵
                var collectPumpRunMinute212 = document.getElementById("collectPumpRunMinute212");
                //污泥泵1
                var sludgePump01RunMinute212 = document.getElementById("sludgePump01RunMinute212");
                //集水池搅拌机
                collectMixerRunMinute212.innerText = result.collectMixerRunMinute;
                //除磷投加机
                dephosphorizeRunMinute212.innerText = result.dephosphorizeRunMinute;
                //集水池提升泵
                collectPumpRunMinute212.innerText = result.collectPumpRunMinute;
                //污泥泵1
                sludgePump01RunMinute212.innerText = result.sludgePump01RunMinute;
                /*************SBR污水处理控制系统***************/
                //系统自动模式
                var systemAutoRun212 = document.getElementById("systemAutoRun212");
                var systemAutoStop212 = document.getElementById("systemAutoStop212");
                if (result.systemAuto === false) {
                    systemAutoRun212.style.display = "none";
                    systemAutoStop212.style.display = "block";
                } else {
                    systemAutoRun212.style.display = "block";
                    systemAutoStop212.style.display = "none";
                }
                //SBR周期运行
                var sbrCycleRun212 = document.getElementById("sbrCycleRun212");
                var sbrCycleStop212 = document.getElementById("sbrCycleStop212");
                if (result.sbrCycle === false) {
                    sbrCycleRun212.style.display = "none";
                    sbrCycleStop212.style.display = "block";
                } else {
                    sbrCycleRun212.style.display = "block";
                    sbrCycleStop212.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpRun212 = document.getElementById("sbrIntakePumpRun212");
                var sbrIntakePumpStop212 = document.getElementById("sbrIntakePumpStop212");
                //SBR池一次搅拌
                var sbrMixerOnceRun212 = document.getElementById("sbrMixerOnceRun212");
                var sbrMixerOnceStop212 = document.getElementById("sbrMixerOnceStop212");
                //SBR曝气
                var fanRun212 = document.getElementById("fanRun212");
                var fanStop212 = document.getElementById("fanStop212");
                //SBR二次搅拌
                var sbrMixerSecRun212 = document.getElementById("sbrMixerSecRun212");
                var sbrMixerSecStop212 = document.getElementById("sbrMixerSecStop212");
                //SBR静置
                var sbrStaticRun212 = document.getElementById("sbrStaticRun212");
                var sbrStaticStop212 = document.getElementById("sbrStaticStop212");
                //SBR污泥泵2
                var sludgePump02Run212 = document.getElementById("sludgePump02Run212");
                var sludgePump02Stop212 = document.getElementById("sludgePump02Stop212");
                //滗水器周期
                var decanterCycleRun212 = document.getElementById("decanterCycleRun212");
                var decanterCycleStop212 = document.getElementById("decanterCycleStop212");
                //SBR活化
                var sbrActiveRun212 = document.getElementById("sbrActiveRun212");
                var sbrActiveStop212 = document.getElementById("sbrActiveStop212");
                if (result.sbrIntakePumpRun === false)  //SBR池进水泵
                {
                    sbrIntakePumpRun212.style.display = "none";
                    sbrIntakePumpStop212.style.display = "block";
                } else {
                    sbrIntakePumpRun212.style.display = "block";
                    sbrIntakePumpStop212.style.display = "none";
                }
                if (result.sbrMixerOnceRun === false)  //SBR池一次搅拌
                {
                    sbrMixerOnceRun212.style.display = "none";
                    sbrMixerOnceStop212.style.display = "block";
                } else {
                    sbrMixerOnceRun212.style.display = "block";
                    sbrMixerOnceStop212.style.display = "none";
                }
                //SBR曝气
                if (result.fan01Run === false && result.fan02Run === false) {
                    fanRun212.style.display = "none";
                    fanStop212.style.display = "block";
                } else {
                    fanRun212.style.display = "block";
                    fanStop212.style.display = "none";
                }
                if (result.sbrMixerSecRun === false)  //SBR池二次搅拌
                {
                    sbrMixerSecRun212.style.display = "none";
                    sbrMixerSecStop212.style.display = "block";
                } else {
                    sbrMixerSecRun212.style.display = "block";
                    sbrMixerSecStop212.style.display = "none";
                }
                if (result.sbrStaticRun === false)  //SBR池静置
                {
                    sbrStaticRun212.style.display = "none";
                    sbrStaticStop212.style.display = "block";
                } else {
                    sbrStaticRun212.style.display = "block";
                    sbrStaticStop212.style.display = "none";
                }
                if (result.sludgePump02Run === false)  //SBR污泥泵2
                {
                    sludgePump02Run212.style.display = "none";
                    sludgePump02Stop212.style.display = "block";
                } else {
                    sludgePump02Run212.style.display = "block";
                    sludgePump02Stop212.style.display = "none";
                }
                if (result.decanterCycleRun === false)  //SBR池滗水器周期
                {
                    decanterCycleRun212.style.display = "none";
                    decanterCycleStop212.style.display = "block";
                } else {
                    decanterCycleRun212.style.display = "block";
                    decanterCycleStop212.style.display = "none";
                }
                if (result.sbrActiveRun === false)  //SBR池活化
                {
                    sbrActiveRun212.style.display = "none";
                    sbrActiveStop212.style.display = "block";
                } else {
                    sbrActiveRun212.style.display = "block";
                    sbrActiveStop212.style.display = "none";
                }
                /*************SBR污水处理控制系统***************/
                    //SBR池进水泵
                var sbrIntakePumpRunMinute212 = document.getElementById("sbrIntakePumpRunMinute212");
                //SBR一次搅拌
                var sbrMixerOnceRunMinute212 = document.getElementById("sbrMixerOnceRunMinute212");
                //SBR曝气
                var fanRunMinute212 = document.getElementById("fanRunMinute212");
                //SBR混合
                var sbrMixerRunMinute212 = document.getElementById("sbrMixerRunMinute212");
                //SBR静置
                var sbrStaticRunMinute212 = document.getElementById("sbrStaticRunMinute212");
                //SBR污泥泵2
                var sludgePump02RunMinute212 = document.getElementById("sludgePump02RunMinute212");
                //SBR活化
                var sbrActiveRunMinute212 = document.getElementById("sbrActiveRunMinute212");
                //SBR池进水泵
                sbrIntakePumpRunMinute212.innerText = result.sbrIntakePumpRunMinute;
                //SBR一次搅拌
                sbrMixerOnceRunMinute212.innerText = result.sbrMixerOnceRunMinute;
                //SBR曝气
                fanRunMinute212.innerText = result.fanRunMinute;
                //SBR混合
                sbrMixerRunMinute212.innerText = result.sbrMixerRunMinute;
                //SBR静置
                sbrStaticRunMinute212.innerText = result.sbrStaticRunMinute;
                //SBR污泥泵2
                sludgePump02RunMinute212.innerText = result.sludgePump02RunMinute;
                //SBR活化
                sbrActiveRunMinute212.innerText = result.sbrActiveRunMinute;
                //滗水器设备
                var decanterRun212 = document.getElementById("decanterRun212");
                var decanterStop212 = document.getElementById("decanterStop212");
                if (result.decanterRun === false)  //滗水器
                {
                    decanterRun212.style.display = "none";
                    decanterStop212.style.display = "block";
                } else {
                    decanterRun212.style.display = "block";
                    decanterStop212.style.display = "none";
                }
                /***************工艺流程设定时间*************************/
                    //除磷投加机
                var dephosphorizeSetMinute212 = document.getElementById("dephosphorizeSetMinute212");
                dephosphorizeSetMinute212.innerText = result.dephosphorizeSetMinute;
                //污泥泵1
                var sludgePump01SetMinute212 = document.getElementById("sludgePump01SetMinute212");
                sludgePump01SetMinute212.innerText = result.sludgePump01SetMinute;
                //SBR设定时间
                var sbrCycleSetMinute212 = document.getElementById("sbrCycleSetMinute212");
                sbrCycleSetMinute212.innerText = result.sbrCycleSetMinute;
                //SBR一次搅拌
                var sbrMixerOnceSetMinute212 = document.getElementById("sbrMixerOnceSetMinute212");
                sbrMixerOnceSetMinute212.innerText = result.sbrMixerOnceSetMinute;
                //SBR曝气
                var fanSetMinute212 = document.getElementById("fanSetMinute212");
                fanSetMinute212.innerText = result.fanSetMinute;
                //SBR混合
                var sbrMixerSetMinute212 = document.getElementById("sbrMixerSetMinute212");
                sbrMixerSetMinute212.innerText = result.sbrMixerSetMinute;
                //SBR静置
                var sbrStaticSetMinute212 = document.getElementById("sbrStaticSetMinute212");
                sbrStaticSetMinute212.innerText = result.sbrStaticSetMinute;
                //SBR污泥泵2
                var sludgePump02SetMinute212 = document.getElementById("sludgePump02SetMinute212");
                sludgePump02SetMinute212.innerText = result.sludgePump02SetMinute;
                //SBR活化
                var sbrActiveSetMinute212 = document.getElementById("sbrActiveSetMinute212");
                sbrActiveSetMinute212.innerText = result.sbrActiveSetMinute;
                /***************设备运行状态*************************/
                //回转式风机1
                var fan01Run212 = document.getElementById("fan01Run212");
                var fan01Stop212 = document.getElementById("fan01Stop212");
                //回转式风机2
                var fan02Run212 = document.getElementById("fan02Run212");
                var fan02Stop212 = document.getElementById("fan02Stop212");
                //SBR池搅拌机01
                var sbrMixer01Run212 = document.getElementById("sbrMixer01Run212");
                var sbrMixer01Stop212 = document.getElementById("sbrMixer01Stop212");
                //SBR池搅拌机02
                var sbrMixer02Run212 = document.getElementById("sbrMixer02Run212");
                var sbrMixer02Stop212 = document.getElementById("sbrMixer02Stop212");
                if (result.fan01Run === false)  //回转式风机1
                {
                    fan01Run212.style.display = "none";
                    fan01Stop212.style.display = "block";
                } else {
                    fan01Run212.style.display = "block";
                    fan01Stop212.style.display = "none";
                }
                if (result.fan02Run === false)  //回转式风机2
                {
                    fan02Run212.style.display = "none";
                    fan02Stop212.style.display = "block";
                } else {
                    fan02Run212.style.display = "block";
                    fan02Stop212.style.display = "none";
                }
                if (result.sbrMixer01Run === false)  //SBR池搅拌机01
                {
                    sbrMixer01Run212.style.display = "none";
                    sbrMixer01Stop212.style.display = "block";
                } else {
                    sbrMixer01Run212.style.display = "block";
                    sbrMixer01Stop212.style.display = "none";
                }
                if (result.sbrMixer02Run === false)  //SBR池搅拌机02
                {
                    sbrMixer02Run212.style.display = "none";
                    sbrMixer02Stop212.style.display = "block";
                } else {
                    sbrMixer02Run212.style.display = "block";
                    sbrMixer02Stop212.style.display = "none";
                }
                /***************公共参数*************************/
                //集水池液位高
                var collectHighOn212 = document.getElementById("collectHighOn212");
                var collectHighOff212 = document.getElementById("collectHighOff212");
                if (result.collectHighOn === false) {
                    collectHighOn212.style.display = "none";
                    collectHighOff212.style.display = "block";
                } else {
                    collectHighOn212.style.display = "block";
                    collectHighOff212.style.display = "none";
                }
                //集水池液位低
                var collectLowOn212 = document.getElementById("collectLowOn212");
                var collectLowOff212 = document.getElementById("collectLowOff212");
                if (result.collectLowOn === false) {
                    collectLowOn212.style.display = "none";
                    collectLowOff212.style.display = "block";
                } else {
                    collectLowOn212.style.display = "block";
                    collectLowOff212.style.display = "none";
                }
                //调节池液位高
                var regulatHighOn212 = document.getElementById("regulatHighOn212");
                var regulatHighOff212 = document.getElementById("regulatHighOff212");
                if (result.regulatHighOn === false) {
                    regulatHighOn212.style.display = "none";
                    regulatHighOff212.style.display = "block";
                } else {
                    regulatHighOn212.style.display = "block";
                    regulatHighOff212.style.display = "none";
                }
                //调节池液位低
                var regulatLowOn212 = document.getElementById("regulatLowOn212");
                var regulatLowOff212 = document.getElementById("regulatLowOff212");
                if (result.regulatLowOn === false) {
                    regulatLowOn212.style.display = "none";
                    regulatLowOff212.style.display = "block";
                } else {
                    regulatLowOn212.style.display = "block";
                    regulatLowOff212.style.display = "none";
                }
                //SBR池液位高
                var sbrHighOn212 = document.getElementById("sbrHighOn212");
                var sbrHighOff212 = document.getElementById("sbrHighOff212");
                if (result.sbrHighOn === false) {
                    sbrHighOn212.style.display = "none";
                    sbrHighOff212.style.display = "block";
                } else {
                    sbrHighOn212.style.display = "block";
                    sbrHighOff212.style.display = "none";
                }
                //SBR池液位低
                var sbrLowOn212 = document.getElementById("sbrLowOn212");
                var sbrLowOff212 = document.getElementById("sbrLowOff212");
                if (result.sbrLowOn === false) {
                    sbrLowOn212.style.display = "none";
                    sbrLowOff212.style.display = "block";
                } else {
                    sbrLowOn212.style.display = "block";
                    sbrLowOff212.style.display = "none";
                }
                /***************故障状态*************************/
                //集水池搅拌机
                var collectMixerNormal212 = document.getElementById("collectMixerNormal212");
                var collectMixerFault212 = document.getElementById("collectMixerFault212");
                if (result.collectMixerFault === true) {
                    collectMixerNormal212.style.display = "none";
                    collectMixerFault212.style.display = "block";
                } else {
                    collectMixerNormal212.style.display = "block";
                    collectMixerFault212.style.display = "none";
                }
                //集水池提升泵
                var collectPumpNormal212 = document.getElementById("collectPumpNormal212");
                var collectPumpFault212 = document.getElementById("collectPumpFault212");
                if (result.collectPumpFault === true) {
                    collectPumpNormal212.style.display = "none";
                    collectPumpFault212.style.display = "block";
                } else {
                    collectPumpNormal212.style.display = "block";
                    collectPumpFault212.style.display = "none";
                }
                //污泥泵1
                var sludgePump01Normal212 = document.getElementById("sludgePump01Normal212");
                var sludgePump01Fault212 = document.getElementById("sludgePump01Fault212");
                if (result.sludgePump01Fault === true) {
                    sludgePump01Normal212.style.display = "none";
                    sludgePump01Fault212.style.display = "block";
                } else {
                    sludgePump01Normal212.style.display = "block";
                    sludgePump01Fault212.style.display = "none";
                }
                //SBR池进水泵
                var sbrIntakePumpNormal212 = document.getElementById("sbrIntakePumpNormal212");
                var sbrIntakePumpFault212 = document.getElementById("sbrIntakePumpFault212");
                if (result.sbrIntakePumpFault === true) {
                    sbrIntakePumpNormal212.style.display = "none";
                    sbrIntakePumpFault212.style.display = "block";
                } else {
                    sbrIntakePumpNormal212.style.display = "block";
                    sbrIntakePumpFault212.style.display = "none";
                }
                //SBR池搅拌机01
                var sbrMixer01Normal212 = document.getElementById("sbrMixer01Normal212");
                var sbrMixer01Fault212 = document.getElementById("sbrMixer01Fault212");
                if (result.sbrMixer01Fault === true) {
                    sbrMixer01Normal212.style.display = "none";
                    sbrMixer01Fault212.style.display = "block";
                } else {
                    sbrMixer01Normal212.style.display = "block";
                    sbrMixer01Fault212.style.display = "none";
                }
                //SBR池搅拌机2
                var sbrMixer02Normal212 = document.getElementById("sbrMixer02Normal212");
                var sbrMixer02Fault212 = document.getElementById("sbrMixer02Fault212");
                if (result.sbrMixer02Fault === true) {
                    sbrMixer02Normal212.style.display = "none";
                    sbrMixer02Fault212.style.display = "block";
                } else {
                    sbrMixer02Normal212.style.display = "block";
                    sbrMixer02Fault212.style.display = "none";
                }
                //回转式风机1
                var fan01Normal212 = document.getElementById("fan01Normal212");
                var fan01Fault212 = document.getElementById("fan01Fault212");
                if (result.fan01Fault === true) {
                    fan01Normal212.style.display = "none";
                    fan01Fault212.style.display = "block";
                } else {
                    fan01Normal212.style.display = "block";
                    fan01Fault212.style.display = "none";
                }
                //回转式风机2
                var fan02Normal212 = document.getElementById("fan02Normal212");
                var fan02Fault212 = document.getElementById("fan02Fault212");
                if (result.fan02Fault === true) {
                    fan02Normal212.style.display = "none";
                    fan02Fault212.style.display = "block";
                } else {
                    fan02Normal212.style.display = "block";
                    fan02Fault212.style.display = "none";
                }
                //污泥泵2
                var sludgePump02Normal212 = document.getElementById("sludgePump02Normal212");
                var sludgePump02Fault212 = document.getElementById("sludgePump02Fault212");
                if (result.sludgePump02Fault === true) {
                    sludgePump02Normal212.style.display = "none";
                    sludgePump02Fault212.style.display = "block";
                } else {
                    sludgePump02Normal212.style.display = "block";
                    sludgePump02Fault212.style.display = "none";
                }
                //滗水器
                var decanterNormal212 = document.getElementById("decanterNormal212");
                var decanterFault212 = document.getElementById("decanterFault212");
                if (result.decanterFault === true) {
                    decanterNormal212.style.display = "none";
                    decanterFault212.style.display = "block";
                } else {
                    decanterNormal212.style.display = "block";
                    decanterFault212.style.display = "none";
                }
                //PLC电量
                var plcElecNormal212 = document.getElementById("plcElecNormal212");
                var plcElecLack212 = document.getElementById("plcElecLack212");
                if (result.plcElecLack === true) {
                    plcElecNormal212.style.display = "none";
                    plcElecLack212.style.display = "block";
                } else {
                    plcElecNormal212.style.display = "block";
                    plcElecLack212.style.display = "none";
                }
                //除磷投加机
                var dephosphorizeNormal212 = document.getElementById("dephosphorizeNormal212");
                var dephosphorizeFault212 = document.getElementById("dephosphorizeFault212");
                if (result.dephosphorizeFault === true) {
                    dephosphorizeNormal212.style.display = "none";
                    dephosphorizeFault212.style.display = "block";
                } else {
                    dephosphorizeNormal212.style.display = "block";
                    dephosphorizeFault212.style.display = "none";
                }
                //智能电表
                var elecNormal212 = document.getElementById("elecNormal212");
                var elecFault212 = document.getElementById("elecFault212");
                if (result.elecFault === true) {
                    elecNormal212.style.display = "none";
                    elecFault212.style.display = "block";
                } else {
                    elecNormal212.style.display = "block";
                    elecFault212.style.display = "none";
                }
                //环境温度
                var airTempNormal212 = document.getElementById("airTempNormal212");
                var airTempFault212 = document.getElementById("airTempFault212");
                if (result.airTempFault === true) {
                    airTempNormal212.style.display = "none";
                    airTempFault212.style.display = "block";
                } else {
                    airTempNormal212.style.display = "block";
                    airTempFault212.style.display = "none";
                }
                //SBR池水温
                var waterTempNormal212 = document.getElementById("waterTempNormal212");
                var waterTempFault212 = document.getElementById("waterTempFault212");
                if (result.waterTempFault === true) {
                    waterTempNormal212.style.display = "none";
                    waterTempFault212.style.display = "block";
                } else {
                    waterTempNormal212.style.display = "block";
                    waterTempFault212.style.display = "none";
                }
                /***************电能数据*************************/
                //线电压Uab
                var uab212 = document.getElementById("uab212");
                //线电压Ubc
                var ubc212 = document.getElementById("ubc212");
                //线电压Uca
                var uca212 = document.getElementById("uca212");
                //相电压Ua
                var ua212 = document.getElementById("ua212");
                //相电压Ub
                var ub212 = document.getElementById("ub212");
                //相电压Uc
                var uc212 = document.getElementById("uc212");
                //电流Ia
                var ia212 = document.getElementById("ia212");
                //电流Ib
                var ib212 = document.getElementById("ib212");
                //电流Ic
                var ic212 = document.getElementById("ic212");
                //合相有功功率
                var pt212 = document.getElementById("pt212");
                //合相无功功率
                var qt212 = document.getElementById("qt212");
                //合相视在功率
                var st212 = document.getElementById("st212");
                //合相功率因数
                var pft212 = document.getElementById("pft212");
                //正向有功总电能
                var impEP212 = document.getElementById("impEP212");
                //反向有功总电能
                var expEP212 = document.getElementById("expEP212");
                //频率
                var freq212 = document.getElementById("freq212");
                //线电压Uab
                uab212.innerText = result.uab;
                //线电压Ubc
                ubc212.innerText = result.ubc;
                //线电压Uca
                uca212.innerText = result.uca;
                //相电压Ua
                ua212.innerText = result.ua;
                //相电压Ub
                ub212.innerText = result.ub;
                //相电压Uc
                uc212.innerText = result.uc;
                //电流Ia
                ia212.innerText = result.ia;
                //电流Ib
                ib212.innerText = result.ib;
                //电流Ic
                ic212.innerText = result.ic;
                //合相有功功率
                pt212.innerText = result.pt;
                //合相无功功率
                qt212.innerText = result.qt;
                //合相视在功率
                st212.innerText = result.st;
                //合相功率因数
                pft212.innerText = result.pft;
                //正向有功总电能
                impEP212.innerText = result.impEP;
                //反向有功总电能
                expEP212.innerText = result.expEP;
                //频率
                freq212.innerText = result.freq;
                /***************设备运行累计时长*************************/
                //集水池搅拌机
                var collectMixerTotal212 = document.getElementById("collectMixerTotal212");
                //除磷投加机
                var dephosphorizeTotal212 = document.getElementById("dephosphorizeTotal212");
                //集水池提升泵
                var collectPumpTotal212 = document.getElementById("collectPumpTotal212");
                //污泥泵01
                var sludgePump01Total212 = document.getElementById("sludgePump01Total212");
                //SBR进水泵
                var sbrIntakePumpTotal212 = document.getElementById("sbrIntakePumpTotal212");
                //SBR池搅拌机01
                var sbrMixer01Total212 = document.getElementById("sbrMixer01Total212");
                //SBR池搅拌机02
                var sbrMixer02Total212 = document.getElementById("sbrMixer02Total212");
                //回转式风机01
                var fan01Total212 = document.getElementById("fan01Total212");
                //回转式风机02
                var fan02Total212 = document.getElementById("fan02Total212");
                //污泥泵02
                var sludgePump02Total212 = document.getElementById("sludgePump02Total212");
                //滗水器
                var decanterTotal212 = document.getElementById("decanterTotal212");
                //集水池搅拌机
                collectMixerTotal212.innerText = result.collectMixerTotal;
                //除磷投加机
                dephosphorizeTotal212.innerText = result.dephosphorizeTotal;
                //集水池提升泵
                collectPumpTotal212.innerText = result.collectPumpTotal;
                //污泥泵01
                sludgePump01Total212.innerText = result.sludgePump01Total;
                //SBR进水泵
                sbrIntakePumpTotal212.innerText = result.sbrIntakePumpTotal;
                //SBR池搅拌机01
                sbrMixer01Total212.innerText = result.sbrMixer01Total;
                //SBR池搅拌机02
                sbrMixer02Total212.innerText = result.sbrMixer02Total;
                //回转式风机01
                fan01Total212.innerText = result.fan01Total;
                //回转式风机02
                fan02Total212.innerText = result.fan02Total;
                //污泥泵02
                sludgePump02Total212.innerText = result.sludgePump02Total;
                //滗水器
                decanterTotal212.innerText = result.decanterTotal;
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

function rdlInitTableSewageC212() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/sewagec212DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlSewageC212TableColumns = questionColumns;
            $('#rdlSewageC212DeviceList').bootstrapTable('destroy');
            $('#rdlSewageC212DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdSewageC212() {

    $('#rdlSewageC212DeviceList').bootstrapTable('destroy');

    $('#rdlSewageC212DeviceList').bootstrapTable({
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
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectSewageC212ByORGId",
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
        columns: rdlSewageC212TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//************************SewageC212 end******************************/

//************************SewageC214 start******************************/
function rdlSelectInfoByDeviceIdAndSewageC214(queryParameter) {
    $.ajax({
        url: "/lihuaiot01/realDeviceList/selectSewageC214ByDeviceId",
// 数据发送方式
        type: "POST",
// 接受数据格式
        dataType: "json",
// 要传递的数据
        data: {sDeviceId: queryParameter},
        success: function (result) {
            if (JSON.stringify(result) !== '[]') {
                //console.log(result);
                /*************抬头***************/
                //水流量
                var flowmeter214 = document.getElementById("flowmeter214");
                //时间
                var sewagec214sendDate = document.getElementById("sewagec214sendDate");
                //水流量
                flowmeter214.innerHTML = result.flowmeter + "m³";
                //时间
                sewagec214sendDate.innerHTML = result.sendDate;
                //当日水流量
                var todayFlowmeter214 = document.getElementById("todayFlowmeter214");
                //当日水流量
                todayFlowmeter214.innerHTML = result.todayFlowmeter + "m³";
                //累计电量
                var totalEp214 = document.getElementById("totalEp214");
                //累计电量
                totalEp214.innerHTML = result.impEP + "";
                //当日电量
                var todayEp214 = document.getElementById("todayEp214");
                //当日电量
                todayEp214.innerHTML = result.todayEP + "";
                //环境温度
                var airTemp214 = document.getElementById("airTemp214");
                //环境温度
                airTemp214.innerHTML = result.airTemp + "℃";
                //SBR水温
                var waterTemp214 = document.getElementById("waterTemp214");
                //SBR水温
                waterTemp214.innerHTML = result.waterTemp + "℃";
                /*************污水处理前期工艺 运行状态***************/
                //集水井提升泵
                var collectWellPumpRun214 = document.getElementById("collectWellPumpRun214");
                var collectWellPumpStop214 = document.getElementById("collectWellPumpStop214");
                if (result.collectWellPumpRun === false)  //集水井提升泵
                {
                    collectWellPumpRun214.style.display = "none";
                    collectWellPumpStop214.style.display = "block";
                } else {
                    collectWellPumpRun214.style.display = "block";
                    collectWellPumpStop214.style.display = "none";
                }
                //收集池搅拌机
                var collectMixerRun214 = document.getElementById("collectMixerRun214");
                var collectMixerStop214 = document.getElementById("collectMixerStop214");
                if (result.collectMixerRun === false)  //收集池搅拌机
                {
                    collectMixerRun214.style.display = "none";
                    collectMixerStop214.style.display = "block";
                } else {
                    collectMixerRun214.style.display = "block";
                    collectMixerStop214.style.display = "none";
                }
                //收集池提升泵
                var collectPumpRun214 = document.getElementById("collectPumpRun214");
                var collectPumpStop214 = document.getElementById("collectPumpStop214");
                if (result.collectPumpRun === false)  //收集池提升泵
                {
                    collectPumpRun214.style.display = "none";
                    collectPumpStop214.style.display = "block";
                } else {
                    collectPumpRun214.style.display = "block";
                    collectPumpStop214.style.display = "none";
                }
                /*************污水处理前期工艺 运行时间***************/
                //集水井提升泵
                var collectWellPumpRunMinute214 = document.getElementById("collectWellPumpRunMinute214");
                //集水井提升泵
                collectWellPumpRunMinute214.innerText = result.collectWellPumpRunMinute;
                //收集池搅拌机
                var collectMixerRunMinute214 = document.getElementById("collectMixerRunMinute214");
                //收集池搅拌机
                collectMixerRunMinute214.innerText = result.collectMixerRunMinute;
                //收集池提升泵
                var collectPumpRunMinute214 = document.getElementById("collectPumpRunMinute214");
                //收集池提升泵
                collectPumpRunMinute214.innerText = result.collectPumpRunMinute;
                /*************SBR污水处理控制系统 运行状态***************/
                //SBR搅拌机01
                var sbrMixer01Run214 = document.getElementById("sbrMixer01Run214");
                var sbrMixer01Stop214 = document.getElementById("sbrMixer01Stop214");
                if (result.sbrMixer01Run === false)  //SBR搅拌机01
                {
                    sbrMixer01Run214.style.display = "none";
                    sbrMixer01Stop214.style.display = "block";
                } else {
                    sbrMixer01Run214.style.display = "block";
                    sbrMixer01Stop214.style.display = "none";
                }
                //风机02
                var fan02Run214 = document.getElementById("fan02Run214");
                var fan02Stop214 = document.getElementById("fan02Stop214");
                if (result.fan02Run === false)  //风机02
                {
                    fan02Run214.style.display = "none";
                    fan02Stop214.style.display = "block";
                } else {
                    fan02Run214.style.display = "block";
                    fan02Stop214.style.display = "none";
                }
                //污泥泵
                var sludgePumpRun214 = document.getElementById("sludgePumpRun214");
                var sludgePumpStop214 = document.getElementById("sludgePumpStop214");
                if (result.sludgePumpRun === false)  //污泥泵
                {
                    sludgePumpRun214.style.display = "none";
                    sludgePumpStop214.style.display = "block";
                } else {
                    sludgePumpRun214.style.display = "block";
                    sludgePumpStop214.style.display = "none";
                }
                //滗水器
                var decanterRun214 = document.getElementById("decanterRun214");
                var decanterStop214 = document.getElementById("decanterStop214");
                if (result.decanterRun === true || result.decanterOff == true )  //滗水器
                {
                    decanterRun214.style.display = "block";
                    decanterStop214.style.display = "none";
                }else{
                    decanterRun214.style.display = "none";
                    decanterStop214.style.display = "block";
                }
                //风机01
                var fan01Run214 = document.getElementById("fan01Run214");
                var fan01Stop214 = document.getElementById("fan01Stop214");
                if (result.fan01Run === false)  //风机01
                {
                    fan01Run214.style.display = "none";
                    fan01Stop214.style.display = "block";
                } else {
                    fan01Run214.style.display = "block";
                    fan01Stop214.style.display = "none";
                }
                //SBR搅拌机02
                var sbrMixer02Run214 = document.getElementById("sbrMixer02Run214");
                var sbrMixer02Stop214 = document.getElementById("sbrMixer02Stop214");
                if (result.sbrMixer02Run === false)  //SBR搅拌机02
                {
                    sbrMixer02Run214.style.display = "none";
                    sbrMixer02Stop214.style.display = "block";
                } else {
                    sbrMixer02Run214.style.display = "block";
                    sbrMixer02Stop214.style.display = "none";
                }
                /*************SBR污水处理控制系统 运行时间***************/
                //SBR搅拌机01
                var fanMixer01RunMinute214 = document.getElementById("fanMixer01RunMinute214");
                //SBR搅拌机01
                fanMixer01RunMinute214.innerText = result.sbrMixer01RunMinute;
                //风机02
                var fan02RunMinute214 = document.getElementById("fan02RunMinute214");
                //风机02
                fan02RunMinute214.innerText = result.fan02RunMinute;
                //污泥泵
                var sludgePumpRunMinute214 = document.getElementById("sludgePumpRunMinute214");
                //污泥泵
                sludgePumpRunMinute214.innerText = result.sludgePumpRunMinute;
                //滗水器
                var decanterRunMinute214 = document.getElementById("decanterRunMinute214");
                //滗水器
                decanterRunMinute214.innerText = result.decanterRunMinute;
                //风机01
                var fan01RunMinute214 = document.getElementById("fan01RunMinute214");
                //风机01
                fan01RunMinute214.innerText = result.fan01RunMinute;
                //SBR搅拌机02
                var fanMixer02RunMinute214 = document.getElementById("fanMixer02RunMinute214");
                //SBR搅拌机02
                fanMixer02RunMinute214.innerText = result.sbrMixer02RunMinute;
                /*************除磷控制系统 运行状态***************/
                //1#加药泵
                var dosingPumpRun214 = document.getElementById("dosingPumpRun214");
                var dosingPumpStop214 = document.getElementById("dosingPumpStop214");
                if (result.dosingPumpRun === false)  //SBR搅拌机01
                {
                    dosingPumpRun214.style.display = "none";
                    dosingPumpStop214.style.display = "block";
                } else {
                    dosingPumpRun214.style.display = "block";
                    dosingPumpStop214.style.display = "none";
                }
                //除磷池提升泵
                var dephosphorizePumpRun214 = document.getElementById("dephosphorizePumpRun214");
                var dephosphorizePumpStop214 = document.getElementById("dephosphorizePumpStop214");
                if (result.dephosphorizePumpRun === false)  //除磷池提升泵
                {
                    dephosphorizePumpRun214.style.display = "none";
                    dephosphorizePumpStop214.style.display = "block";
                } else {
                    dephosphorizePumpRun214.style.display = "block";
                    dephosphorizePumpStop214.style.display = "none";
                }
                //加药罐搅拌机
                var dosingMixerRun214 = document.getElementById("dosingMixerRun214");
                var dosingMixerStop214 = document.getElementById("dosingMixerStop214");
                if (result.dosingMixerRun === false)  //加药罐搅拌机
                {
                    dosingMixerRun214.style.display = "none";
                    dosingMixerStop214.style.display = "block";
                } else {
                    dosingMixerRun214.style.display = "block";
                    dosingMixerStop214.style.display = "none";
                }
                /*************除磷控制系统 运行时间***************/
                //加药泵
                var dosingPumpRunMinute214 = document.getElementById("dosingPumpRunMinute214");
                //加药泵
                dosingPumpRunMinute214.innerText = result.dosingPumpRunMinute;
                //除磷池提升泵
                var dephosphorizePumpRunMinute214 = document.getElementById("dephosphorizePumpRunMinute214");
                //除磷池提升泵
                dephosphorizePumpRunMinute214.innerText = result.dephosphorizePumpRunMinute;
                //加药罐搅拌机
                var dosingMixerRunMinute214 = document.getElementById("dosingMixerRunMinute214");
                //加药罐搅拌机
                dosingMixerRunMinute214.innerText = result.dosingMixerRunMinute;
                /***************工艺流程设定时间 开始时间*************************/
                //集水井提升泵
                var collectWellPumpSTime214 = document.getElementById("collectWellPumpSTime214");
                collectWellPumpSTime214.innerText = formatTime214(result.collectWellPumpSHour)+":"+formatTime214(result.collectWellPumpSMinute);
                //风机02
                var fan02STime214 = document.getElementById("fan02STime214");
                fan02STime214.innerText =formatTime214(result.fan02SHour)+":"+formatTime214(result.fan02SMinute);
                //收集池提升泵
                var collectPumpSTime214 = document.getElementById("collectPumpSTime214");
                collectPumpSTime214.innerText = formatTime214(result.collectPumpSHour)+":"+formatTime214(result.collectPumpSMinute);
                //静止沉淀
                var staticSTime214 = document.getElementById("staticSTime214");
                staticSTime214.innerText = "05:40";
                //收集池搅拌机
                var collectMixerSTime214 = document.getElementById("collectMixerSTime214");
                collectMixerSTime214.innerText = formatTime214(result.collectMixerSHour)+":"+formatTime214(result.collectMixerSMinute);
                //滗水器
                var decanterSTime214 = document.getElementById("decanterSTime214");
                decanterSTime214.innerText = formatTime214(result.decanterSHour)+":"+formatTime214(result.decanterSMinute);
                //SBR搅拌机01
                var fanMixer01STime214 = document.getElementById("fanMixer01STime214");
                fanMixer01STime214.innerText = formatTime214(result.sbrMixer01SHour)+":"+formatTime214(result.sbrMixer01SMinute);
                //加药泵
                var dosingPumpSTime214 = document.getElementById("dosingPumpSTime214");
                dosingPumpSTime214.innerText = formatTime214(result.dosingPumpSHour)+":"+formatTime214(result.dosingPumpSMinute);
                //污泥泵
                var sludgePumpSTime214 = document.getElementById("sludgePumpSTime214");
                sludgePumpSTime214.innerText = formatTime214(result.sludgePumpSHour)+":"+formatTime214(result.sludgePumpSMinute);
                //加药罐搅拌机
                var dosingMixerSTime214 = document.getElementById("dosingMixerSTime214");
                dosingMixerSTime214.innerText = formatTime214(result.dosingMixerSHour)+":"+formatTime214(result.dosingMixerSMinute);
                //风机01
                var fanSTime214 = document.getElementById("fanSTime214");
                fanSTime214.innerText = formatTime214(result.fan01SHour)+":"+formatTime214(result.fan01SMinute);
                //除磷池提升泵
                var dephosphorizePumpSTime214 = document.getElementById("dephosphorizePumpSTime214");
                dephosphorizePumpSTime214.innerText = formatTime214(result.dephosphorizePumpSHour)+":"+formatTime214(result.dephosphorizePumpSMinute);
                //SBR搅拌机02
                var fanMixer02STime214 = document.getElementById("fanMixer02STime214");
                fanMixer02STime214.innerText = formatTime214(result.sbrMixer02SHour)+":"+formatTime214(result.sbrMixer02SMinute);
                /***************工艺流程设定时间 时间段*************************/
                 //集水井提升泵
                var collectWellPumpSetMinute214 = document.getElementById("collectWellPumpSetMinute214");
                collectWellPumpSetMinute214.innerText = result.collectWellPumpSetMinute;
                //风机02
                var fan02SetMinute214 = document.getElementById("fan02SetMinute214");
                fan02SetMinute214.innerText = result.fanSetMinute;
                //收集池提升泵
                var collectPumpSetMinute214 = document.getElementById("collectPumpSetMinute214");
                collectPumpSetMinute214.innerText = result.collectPumpSetMinute;
                //静止沉淀
                var staticSetMinute214 = document.getElementById("staticSetMinute214");
                staticSetMinute214.innerText = "123";
                //收集池搅拌机
                var collectMixerSetMinute214 = document.getElementById("collectMixerSetMinute214");
                collectMixerSetMinute214.innerText = result.collectMixerSetMinute;
                //滗水器
                var decanterSetMinute214 = document.getElementById("decanterSetMinute214");
                decanterSetMinute214.innerText = result.decanterSetMinute;
                //SBR搅拌机01
                var fanMixer01SetMinute214 = document.getElementById("fanMixer01SetMinute214");
                fanMixer01SetMinute214.innerText = result.sbrMixer01SetMinute;
                //加药泵
                var dosingPumpSetMinute214 = document.getElementById("dosingPumpSetMinute214");
                dosingPumpSetMinute214.innerText = result.dosingPumpSetMinute;
                //污泥泵
                var sludgePumpSetMinute214 = document.getElementById("sludgePumpSetMinute214");
                sludgePumpSetMinute214.innerText = result.sludgePumpSetMinute;
                //加药罐搅拌机
                var dosingMixerSetMinute214 = document.getElementById("dosingMixerSetMinute214");
                dosingMixerSetMinute214.innerText = result.dosingMixerSetMinute;
                //风机01
                var fan01SetMinute214 = document.getElementById("fan01SetMinute214");
                fan01SetMinute214.innerText = result.fanSetMinute;
                //除磷池提升泵
                var dephosphorizePumpSetMinute214 = document.getElementById("dephosphorizePumpSetMinute214");
                dephosphorizePumpSetMinute214.innerText = result.dephosphorizePumpSetMinute;
                //SBR搅拌机02
                var fanMixer02SetMinute214 = document.getElementById("fanMixer02SetMinute214");
                fanMixer02SetMinute214.innerText = result.sbrMixer02SetMinute;
                /***************公共参数*************************/
                //收集池高液位
                var collectHighOn214 = document.getElementById("collectHighOn214");
                var collectHighOff214 = document.getElementById("collectHighOff214");
                if (result.collectHighOn === false) {
                    collectHighOn214.style.display = "none";
                    collectHighOff214.style.display = "block";
                } else {
                    collectHighOn214.style.display = "block";
                    collectHighOff214.style.display = "none";
                }
                //SBR池高液位
                var sbrHighOn214 = document.getElementById("sbrHighOn214");
                var sbrHighOff214 = document.getElementById("sbrHighOff214");
                if (result.sbrHighOn === false) {
                    sbrHighOn214.style.display = "none";
                    sbrHighOff214.style.display = "block";
                } else {
                    sbrHighOn214.style.display = "block";
                    sbrHighOff214.style.display = "none";
                }
                //收集池低液位
                var collectLowOn214 = document.getElementById("collectLowOn214");
                var collectLowOff214 = document.getElementById("collectLowOff214");
                if (result.collectLowOn === false) {
                    collectLowOn214.style.display = "none";
                    collectLowOff214.style.display = "block";
                } else {
                    collectLowOn214.style.display = "block";
                    collectLowOff214.style.display = "none";
                }
                //SBR池低液位
                var sbrLowOn214 = document.getElementById("sbrLowOn214");
                var sbrLowOff214 = document.getElementById("sbrLowOff214");
                if (result.sbrLowOn === false) {
                    sbrLowOn214.style.display = "none";
                    sbrLowOff214.style.display = "block";
                } else {
                    sbrLowOn214.style.display = "block";
                    sbrLowOff214.style.display = "none";
                }
                //除磷池高液位
                var dephosphorizeHighOn214 = document.getElementById("dephosphorizeHighOn214");
                var dephosphorizeHighOff214 = document.getElementById("dephosphorizeHighOff214");
                if (result.dephosphorizeHighOn === false) {
                    dephosphorizeHighOn214.style.display = "none";
                    dephosphorizeHighOff214.style.display = "block";
                } else {
                    dephosphorizeHighOn214.style.display = "block";
                    dephosphorizeHighOff214.style.display = "none";
                }
                //滗水器开到位
                var decanterOnOK214 = document.getElementById("decanterOnOK214");
                var decanterOnOff214 = document.getElementById("decanterOnOff214");
                if (result.decanterOnOK === false) {
                    decanterOnOK214.style.display = "none";
                    decanterOnOff214.style.display = "block";
                } else {
                    decanterOnOK214.style.display = "block";
                    decanterOnOff214.style.display = "none";
                }
                //除磷池低液位
                var dephosphorizeLowOn214 = document.getElementById("dephosphorizeLowOn214");
                var dephosphorizeLowOff214 = document.getElementById("dephosphorizeLowOff214");
                if (result.dephosphorizeLowOn === false) {
                    dephosphorizeLowOn214.style.display = "none";
                    dephosphorizeLowOff214.style.display = "block";
                } else {
                    dephosphorizeLowOn214.style.display = "block";
                    dephosphorizeLowOff214.style.display = "none";
                }
                //滗水器关到位
                var decanterOffOK214 = document.getElementById("decanterOffOK214");
                var decanterOffOff214 = document.getElementById("decanterOffOff214");
                if (result.decanterOffOK === false) {
                    decanterOffOK214.style.display = "none";
                    decanterOffOff214.style.display = "block";
                } else {
                    decanterOffOK214.style.display = "block";
                    decanterOffOff214.style.display = "none";
                }
                /***************故障状态*************************/
                //集水井提升泵
                var collectWellPumpNormal214 = document.getElementById("collectWellPumpNormal214");
                var collectWellPumpFault214 = document.getElementById("collectWellPumpFault214");
                if (result.collectWellPumpFault === true) {
                    collectWellPumpNormal214.style.display = "none";
                    collectWellPumpFault214.style.display = "block";
                } else {
                    collectWellPumpNormal214.style.display = "block";
                    collectWellPumpFault214.style.display = "none";
                }
                //滗水器
                var decanterNormal214 = document.getElementById("decanterNormal214");
                var decanterFault214 = document.getElementById("decanterFault214");
                if (result.decanterFault === true) {
                    decanterNormal214.style.display = "none";
                    decanterFault214.style.display = "block";
                } else {
                    decanterNormal214.style.display = "block";
                    decanterFault214.style.display = "none";
                }
                //收集池提升泵
                var collectPumpNormal214 = document.getElementById("collectPumpNormal214");
                var collectPumpFault214 = document.getElementById("collectPumpFault214");
                if (result.collectPumpFault === true) {
                    collectPumpNormal214.style.display = "none";
                    collectPumpFault214.style.display = "block";
                } else {
                    collectPumpNormal214.style.display = "block";
                    collectPumpFault214.style.display = "none";
                }
                //加药泵
                var dosingPumpNormal214 = document.getElementById("dosingPumpNormal214");
                var dosingPumpFault214 = document.getElementById("dosingPumpFault214");
                if (result.dosingPumpFault === true) {
                    dosingPumpNormal214.style.display = "none";
                    dosingPumpFault214.style.display = "block";
                } else {
                    dosingPumpNormal214.style.display = "block";
                    dosingPumpFault214.style.display = "none";
                }
                //收集池搅拌机
                var collectMixerNormal214 = document.getElementById("collectMixerNormal214");
                var collectMixerFault214 = document.getElementById("collectMixerFault214");
                if (result.collectMixerFault === true) {
                    collectMixerNormal214.style.display = "none";
                    collectMixerFault214.style.display = "block";
                } else {
                    collectMixerNormal214.style.display = "block";
                    collectMixerFault214.style.display = "none";
                }
                //加药罐搅拌机
                var dosingMixerNormal214 = document.getElementById("dosingMixerNormal214");
                var dosingMixerFault214 = document.getElementById("dosingMixerFault214");
                if (result.dosingMixerFault === true) {
                    dosingMixerNormal214.style.display = "none";
                    dosingMixerFault214.style.display = "block";
                } else {
                    dosingMixerNormal214.style.display = "block";
                    dosingMixerFault214.style.display = "none";
                }
                //SBR搅拌机01
                var sbrMixer01Normal214 = document.getElementById("sbrMixer01Normal214");
                var sbrMixer01Fault214 = document.getElementById("sbrMixer01Fault214");
                if (result.sbrMixer01Fault === true) {
                    sbrMixer01Normal214.style.display = "none";
                    sbrMixer01Fault214.style.display = "block";
                } else {
                    sbrMixer01Normal214.style.display = "block";
                    sbrMixer01Fault214.style.display = "none";
                }
                //除磷池提升泵
                var dephosphorizePumpNormal214 = document.getElementById("dephosphorizePumpNormal214");
                var dephosphorizePumpFault214 = document.getElementById("dephosphorizePumpFault214");
                if (result.dephosphorizePumpFault === true) {
                    dephosphorizePumpNormal214.style.display = "none";
                    dephosphorizePumpFault214.style.display = "block";
                } else {
                    dephosphorizePumpNormal214.style.display = "block";
                    dephosphorizePumpFault214.style.display = "none";
                }
                //污泥泵
                var sludgePumpNormal214 = document.getElementById("sludgePumpNormal214");
                var sludgePumpFault214 = document.getElementById("sludgePumpFault214");
                if (result.sludgePumpFault === true) {
                    sludgePumpNormal214.style.display = "none";
                    sludgePumpFault214.style.display = "block";
                } else {
                    sludgePumpNormal214.style.display = "block";
                    sludgePumpFault214.style.display = "none";
                }
                //PLC电量不足
                var plcElecNormal214 = document.getElementById("plcElecNormal214");
                var plcElecLack214 = document.getElementById("plcElecLack214");
                if (result.plcElecLack === true) {
                    plcElecNormal214.style.display = "none";
                    plcElecLack214.style.display = "block";
                } else {
                    plcElecNormal214.style.display = "block";
                    plcElecLack214.style.display = "none";
                }
                //风机01
                var fan01Normal214 = document.getElementById("fan01Normal214");
                var fan01Fault214 = document.getElementById("fan01Fault214");
                if (result.fan01Fault === true) {
                    fan01Normal214.style.display = "none";
                    fan01Fault214.style.display = "block";
                } else {
                    fan01Normal214.style.display = "block";
                    fan01Fault214.style.display = "none";
                }
                //智能电表设备通讯
                var elecNormal214 = document.getElementById("elecNormal214");
                var elecFault214 = document.getElementById("elecFault214");
                if (result.elecFault === true) {
                    elecNormal214.style.display = "none";
                    elecFault214.style.display = "block";
                } else {
                    elecNormal214.style.display = "block";
                    elecFault214.style.display = "none";
                }
                //SBR搅拌机02
                var sbrMixer02Normal214 = document.getElementById("sbrMixer02Normal214");
                var sbrMixer02Fault214 = document.getElementById("sbrMixer02Fault214");
                if (result.sbrMixer02Fault === true) {
                    sbrMixer02Normal214.style.display = "none";
                    sbrMixer02Fault214.style.display = "block";
                } else {
                    sbrMixer02Normal214.style.display = "block";
                    sbrMixer02Fault214.style.display = "none";
                }
                //空气温度变送器
                var airTempNormal214 = document.getElementById("airTempNormal214");
                var airTempFault214 = document.getElementById("airTempFault214");
                if (result.airTempFault === true) {
                    airTempNormal214.style.display = "none";
                    airTempFault214.style.display = "block";
                } else {
                    airTempNormal214.style.display = "block";
                    airTempFault214.style.display = "none";
                }
                //风机02
                var fan02Normal214 = document.getElementById("fan02Normal214");
                var fan02Fault214 = document.getElementById("fan02Fault214");
                if (result.fan02Fault === true) {
                    fan02Normal214.style.display = "none";
                    fan02Fault214.style.display = "block";
                } else {
                    fan02Normal214.style.display = "block";
                    fan02Fault214.style.display = "none";
                }
                //SBR水温变送器
                var waterTempNormal214 = document.getElementById("waterTempNormal214");
                var waterTempFault214 = document.getElementById("waterTempFault214");
                if (result.waterTempFault === true) {
                    waterTempNormal214.style.display = "none";
                    waterTempFault214.style.display = "block";
                } else {
                    waterTempNormal214.style.display = "block";
                    waterTempFault214.style.display = "none";
                }
                /***************电能数据*************************/
                //线电压Uab
                var uab214 = document.getElementById("uab214");
                //线电压Ubc
                var ubc214 = document.getElementById("ubc214");
                //线电压Uca
                var uca214 = document.getElementById("uca214");
                //相电压Ua
                var ua214 = document.getElementById("ua214");
                //相电压Ub
                var ub214 = document.getElementById("ub214");
                //相电压Uc
                var uc214 = document.getElementById("uc214");
                //电流Ia
                var ia214 = document.getElementById("ia214");
                //电流Ib
                var ib214 = document.getElementById("ib214");
                //电流Ic
                var ic214 = document.getElementById("ic214");
                //合相有功功率
                var pt214 = document.getElementById("pt214");
                //合相无功功率
                var qt214 = document.getElementById("qt214");
                //合相视在功率
                var st214 = document.getElementById("st214");
                //合相功率因数
                var pft214 = document.getElementById("pft214");
                //正向有功总电能
                var impEP214 = document.getElementById("impEP214");
                //反向有功总电能
                var expEP214 = document.getElementById("expEP214");
                //频率
                var freq214 = document.getElementById("freq214");
                //线电压Uab
                uab214.innerText = result.uab;
                //线电压Ubc
                ubc214.innerText = result.ubc;
                //线电压Uca
                uca214.innerText = result.uca;
                //相电压Ua
                ua214.innerText = result.ua;
                //相电压Ub
                ub214.innerText = result.ub;
                //相电压Uc
                uc214.innerText = result.uc;
                //电流Ia
                ia214.innerText = result.ia;
                //电流Ib
                ib214.innerText = result.ib;
                //电流Ic
                ic214.innerText = result.ic;
                //合相有功功率
                pt214.innerText = result.pt;
                //合相无功功率
                qt214.innerText = result.qt;
                //合相视在功率
                st214.innerText = result.st;
                //合相功率因数
                pft214.innerText = result.pft;
                //正向有功总电能
                impEP214.innerText = result.impEP;
                //反向有功总电能
                expEP214.innerText = result.expEP;
                //频率
                freq214.innerText = result.freq;
                /***************设备运行累计时长*************************/
                //集水井提升泵
                var collectWellPumpTotal214 = document.getElementById("collectWellPumpTotal214");
                //集水井提升泵
                collectWellPumpTotal214.innerText = result.collectWellPumpTotal;
                //SBR搅拌机02
                var sbrMixer02Total214 = document.getElementById("sbrMixer02Total214");
                //SBR搅拌机02
                sbrMixer02Total214.innerText = result.sbrMixer02Total;
                //收集池提升泵
                var collectPumpTotal214 = document.getElementById("collectPumpTotal214");
                //收集池提升泵
                collectPumpTotal214.innerText = result.collectPumpTotal;
                //风机02
                var fan02Total214 = document.getElementById("fan02Total214");
                //风机02
                fan02Total214.innerText = result.fan02Total;
                //收集池搅拌机
                var collectMixerTotal214 = document.getElementById("collectMixerTotal214");
                //收集池搅拌机
                collectMixerTotal214.innerText = result.collectMixerTotal;
                //滗水器
                var decanterTotal214 = document.getElementById("decanterTotal214");
                //滗水器
                decanterTotal214.innerText = result.decanterTotal;
                //SBR搅拌机01
                var sbrMixer01Total214 = document.getElementById("sbrMixer01Total214");
                //SBR搅拌机01
                sbrMixer01Total214.innerText = result.sbrMixer01Total;
                //加药泵
                var dosingPumpTotal214 = document.getElementById("dosingPumpTotal214");
                //加药泵
                dosingPumpTotal214.innerText = result.dosingPumpTotal;
                //污泥泵
                var sludgePumpTotal214 = document.getElementById("sludgePumpTotal214");
                //污泥泵
                sludgePumpTotal214.innerText = result.sludgePumpTotal;
                //加药罐搅拌机
                var dosingMixerTotal214 = document.getElementById("dosingMixerTotal214");
                //加药罐搅拌机
                dosingMixerTotal214.innerText = result.dosingMixerTotal;
                //风机01
                var fan01Total214 = document.getElementById("fan01Total214");
                //风机01
                fan01Total214.innerText = result.fan01Total;
                //除磷池提升泵
                var dephosphorizePumpTotal214 = document.getElementById("dephosphorizePumpTotal214");
                //除磷池提升泵
                dephosphorizePumpTotal214.innerText = result.dephosphorizePumpTotal;
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

function rdlInitTableSewageC214() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/sewagec214DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlSewageC214TableColumns = questionColumns;
            $('#rdlSewageC214DeviceList').bootstrapTable('destroy');
            $('#rdlSewageC214DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdSewageC214() {

    $('#rdlSewageC214DeviceList').bootstrapTable('destroy');

    $('#rdlSewageC214DeviceList').bootstrapTable({
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
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectSewageC214ByORGId",
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
        columns: rdlSewageC214TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

function formatTime214(value) {
    if(value.toString().length ===1)
        return "0"+value.toString();
    return value.toString();
}


//************************SewageC214 end******************************/

//************************ScaleC01 start******************************/
function rdlInitTableScaleC01() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/scalec01DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlScaleC01TableColumns = questionColumns;
            $('#rdlScaleC01DeviceList').bootstrapTable('destroy');
            $('#rdlScaleC01DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdScaleC01() {

    $('#rdlScaleC01DeviceList').bootstrapTable('destroy');

    $('#rdlScaleC01DeviceList').bootstrapTable({
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
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectScaleC01ByORGId",
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
        columns: rdlScaleC01TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//************************ScaleC01 end******************************/

//************************Hj212C213 start******************************/
function rdlInitTableHj212C213() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/hj212C213DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlHj212C213TableColumns = questionColumns;
            $('#rdlHj212C213DeviceList').bootstrapTable('destroy');
            $('#rdlHj212C213DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdHj212C213() {

    $('#rdlHj212C213DeviceList').bootstrapTable('destroy');

    $('#rdlHj212C213DeviceList').bootstrapTable({
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
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectHj212C213ByORGId",
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
        columns: rdlHj212C213TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}
//************************Hj212C213 end******************************/

//************************WeighC312 start******************************/
function rdlSelectInfoByDeviceIdAndWeighC312(queryParameter) {

}

function rdlInitTableWeighC312() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/weighC312DeviceHead',
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
                    temp = {field: json[i].data, title: json[i].title, align: json[i].align, visible: json[i].visible};//手动拼接columns
                }
                questionColumns.push(temp);
            }
            rdlWeighC312TableColumns = questionColumns;
            $('#rdlWeighC312DeviceList').bootstrapTable('destroy');
            $('#rdlWeighC312DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdWeighC312() {

    $('#rdlWeighC312DeviceList').bootstrapTable('destroy');

    $('#rdlWeighC312DeviceList').bootstrapTable({
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
        pageList: [8,10, 25, 50, 100],
        //是否显示搜索
        search: false,
        // 显示下拉框勾选要显示的列
        showColumns: true,
        // 设置最少显示列个数
        minimumCountColumns: 2,
        //data:json,
        //这个接口需要处理bootstrap table传递的固定参数,并返回特定格式的json数据
        url: "/lihuaiot01/realDeviceList/selectWeighC312ByORGId",
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
        columns: rdlWeighC312TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************WeighC312 end******************************/

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
                    //console.log(result);
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

        function releaseFeedC411Cable(cable) {
            if (cable.num === 1) {
                releaseFeedC411Cable01(cable)
            } else if (cable.num === 2) {
                releaseFeedC411Cable02(cable)
            } else if (cable.num === 3) {
                releaseFeedC411Cable03(cable)
            }
        }

//第一根
        function releaseFeedC411Cable01(cable) {
            var feedC4110101 = document.getElementById("feedC411-01-01");
            var temp = getFeedC411Temp(cable.temps, 1);
            formatFeedC411Temp(feedC4110101, temp);

            var feedC4110102 = document.getElementById("feedC411-01-02");
            var temp = getFeedC411Temp(cable.temps, 2);
            formatFeedC411Temp(feedC4110102, temp);

            var feedC4110103 = document.getElementById("feedC411-01-03");
            var temp = getFeedC411Temp(cable.temps, 3);
            formatFeedC411Temp(feedC4110103, temp);

            var feedC4110104 = document.getElementById("feedC411-01-04");
            var temp = getFeedC411Temp(cable.temps, 4);
            formatFeedC411Temp(feedC4110104, temp);

            var feedC4110105 = document.getElementById("feedC411-01-05");
            var temp = getFeedC411Temp(cable.temps, 5);
            formatFeedC411Temp(feedC4110105, temp);

            var feedC4110106 = document.getElementById("feedC411-01-06");
            var temp = getFeedC411Temp(cable.temps, 6);
            formatFeedC411Temp(feedC4110106, temp);

            var feedC4110107 = document.getElementById("feedC411-01-07");
            var temp = getFeedC411Temp(cable.temps, 7);
            formatFeedC411Temp(feedC4110107, temp);

            var feedC4110108 = document.getElementById("feedC411-01-08");
            var temp = getFeedC411Temp(cable.temps, 8);
            formatFeedC411Temp(feedC4110108, temp);

            var feedC4110109 = document.getElementById("feedC411-01-09");
            var temp = getFeedC411Temp(cable.temps, 9);
            formatFeedC411Temp(feedC4110109, temp);

            var feedC4110110 = document.getElementById("feedC411-01-10");
            var temp = getFeedC411Temp(cable.temps, 10);
            formatFeedC411Temp(feedC4110110, temp);
        }

//第二根
        function releaseFeedC411Cable02(cable) {
            var feedC4110201 = document.getElementById("feedC411-02-01");
            var temp = getFeedC411Temp(cable.temps, 1);
            formatFeedC411Temp(feedC4110201, temp);

            var feedC4110202 = document.getElementById("feedC411-02-02");
            var temp = getFeedC411Temp(cable.temps, 2);
            formatFeedC411Temp(feedC4110202, temp);

            var feedC4110203 = document.getElementById("feedC411-02-03");
            var temp = getFeedC411Temp(cable.temps, 3);
            formatFeedC411Temp(feedC4110203, temp);

            var feedC4110204 = document.getElementById("feedC411-02-04");
            var temp = getFeedC411Temp(cable.temps, 4);
            formatFeedC411Temp(feedC4110204, temp);

            var feedC4110205 = document.getElementById("feedC411-02-05");
            var temp = getFeedC411Temp(cable.temps, 5);
            formatFeedC411Temp(feedC4110205, temp);

            var feedC4110206 = document.getElementById("feedC411-02-06");
            var temp = getFeedC411Temp(cable.temps, 6);
            formatFeedC411Temp(feedC4110206, temp);

            var feedC4110207 = document.getElementById("feedC411-02-07");
            var temp = getFeedC411Temp(cable.temps, 7);
            formatFeedC411Temp(feedC4110207, temp);

            var feedC4110208 = document.getElementById("feedC411-02-08");
            var temp = getFeedC411Temp(cable.temps, 8);
            formatFeedC411Temp(feedC4110208, temp);

            var feedC4110209 = document.getElementById("feedC411-02-09");
            var temp = getFeedC411Temp(cable.temps, 9);
            formatFeedC411Temp(feedC4110209, temp);

            var feedC4110210 = document.getElementById("feedC411-02-10");
            var temp = getFeedC411Temp(cable.temps, 10);
            formatFeedC411Temp(feedC4110210, temp);
        }

//第三根
        function releaseFeedC411Cable03(cable) {
            var feedC4110301 = document.getElementById("feedC411-03-01");
            var temp = getFeedC411Temp(cable.temps, 1);
            formatFeedC411Temp(feedC4110301, temp);

            var feedC4110302 = document.getElementById("feedC411-03-02");
            var temp = getFeedC411Temp(cable.temps, 2);
            formatFeedC411Temp(feedC4110302, temp);

            var feedC4110303 = document.getElementById("feedC411-03-03");
            var temp = getFeedC411Temp(cable.temps, 3);
            formatFeedC411Temp(feedC4110303, temp);

            var feedC4110304 = document.getElementById("feedC411-03-04");
            var temp = getFeedC411Temp(cable.temps, 4);
            formatFeedC411Temp(feedC4110304, temp);

            var feedC4110305 = document.getElementById("feedC411-03-05");
            var temp = getFeedC411Temp(cable.temps, 5);
            formatFeedC411Temp(feedC4110305, temp);

            var feedC4110306 = document.getElementById("feedC411-03-06");
            var temp = getFeedC411Temp(cable.temps, 6);
            formatFeedC411Temp(feedC4110306, temp);

            var feedC4110307 = document.getElementById("feedC411-03-07");
            var temp = getFeedC411Temp(cable.temps, 7);
            formatFeedC411Temp(feedC4110307, temp);

            var feedC4110308 = document.getElementById("feedC411-03-08");
            var temp = getFeedC411Temp(cable.temps, 8);
            formatFeedC411Temp(feedC4110308, temp);

            var feedC4110309 = document.getElementById("feedC411-03-09");
            var temp = getFeedC411Temp(cable.temps, 9);
            formatFeedC411Temp(feedC4110309, temp);

            var feedC4110310 = document.getElementById("feedC411-03-10");
            var temp = getFeedC411Temp(cable.temps, 10);
            formatFeedC411Temp(feedC4110310, temp);
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
        }

    /*****************解析全仓 结束************************/
    function rdlInitTableFeedC411() {
        var questionColumns = [];
        $.ajax({
            type: 'POST',
            data: {devId:""},
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

function rdlInitTableFeedC41102(devId) {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {devId:devId},
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

//请求服务数据时所传参数
function rdlQueryParams(params) {
    var queryParameter = rdlNowTreeNode.id;
    return {
        sORGId: queryParameter,
    };
}

function rdlChangeTableColor(value, row, index) {
    //通过判断单元格的值，来格式化单元格，返回的值即为格式化后包含的元素
    var a = "";
    if (value == "在线") {
        var a = '<span style="color:#00ff00">' + value + '</span>';
    } else if (value == "已分派") {
        var a = '<span style="color:#0000ff">' + value + '</span>';
    } else if (value == "离线") {
        var a = '<span style="color:#FF0000">' + value + '</span>';
    } else {
        var a = '<span>' + value + '</span>';
    }
    return a;
}

// 导出信息
function rdlExportStorageAction() {
    $('#rdlEC01Export_storage').click(function () { //种禽环控器
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlSewageC01Export_storage').click(function () { //立华禽环保1.0
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlSewageC212Export_storage').click(function () { //立华禽环保2.0
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlSewageC214Export_storage').click(function () { //立华禽环保3.0
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlScaleC01Export_storage').click(function () { //自动称重
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlHj212C213Export_storage').click(function () { //水质在线监测
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlWeighC312Export_storage').click(function () { //种鸡散装料塔称重1.0
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlFeedC411Export_storage').click(function () { //饲料部筒仓测温
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlExport_storage_download').click(function () {
        var queryParameter = rdlNowTreeNode.id;
        var data = {
            sORGId: queryParameter
        };
        var rootNodeId = rdlNowTreeNodeRoot.id;
        var url = "";
        if ( rootNodeId === "111")   //种禽环控器
        {
            url = "/lihuaiot01/realDeviceList/exportEC01DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "211")  //立华禽环保1.0
        {
            url = "/lihuaiot01/realDeviceList/exportSewageC01DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "212")  //立华禽环保2.0
        {
            url = "/lihuaiot01/realDeviceList/exportSewageC212DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "214")  //立华禽环保3.0
        {
            url = "/lihuaiot01/realDeviceList/exportSewageC214DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "311")  //自动称重
        {
            url = "/lihuaiot01/realDeviceList/exportScaleC01DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "312")  //种鸡散装料塔称重
        {
            url = "/lihuaiot01/realDeviceList/exportWeighC312DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "411")  //饲料部筒仓测温
        {
            url = "/lihuaiot01/realDeviceList/exportFeedC411DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "213")  //水质在线监测
        {
            url = "/lihuaiot01/realDeviceList/exportHj212C213DeviceList?" + $.param(data);
        }
        window.open(url, '_blank');
        $('#rdlExport_modal').modal("hide");
    })
}