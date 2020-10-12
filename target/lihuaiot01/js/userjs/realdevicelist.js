var rdlNowTreeNode;
var rdlNowTreeNodeRoot;
var rdlTableColumns;
var rdlSewageC01TableColumns;
var rdlSewageC212TableColumns;
var rdlSewageC214TableColumns;
var rdlSewageC215TableColumns;
var rdlScaleC01TableColumns;
var rdlHj212C213TableColumns;
var rdlWeighC312TableColumns;
var rdlFeedC411TableColumns;
var rdlLhsp05p1TableColumns;
var rdlLhfh05p1TableColumns;
var rdlLhsf0ap1TableColumns;
var rdlLhrz01p1TableColumns;
var rdlLhty02p1TableColumns;
var rdlLhrj0bp1TableColumns;
var rdlLhslzlp1TableColumns;
var rdlTreeNodes;
var realid_of_setintervalDeviceList;
var realid_of_setintervalDeviceOne;
$(function () {
    rdlInitTreeNode();
    rdlInitTableEC01();
    rdlInitTableSewageC01();
    rdlInitTableSewageC212();
    rdlInitTableSewageC214();
    rdlInitTableSewageC215();
    rdlInitTableScaleC01();
    rdlInitTableHj212C213();
    rdlInitTableWeighC312();
    rdlInitTableFeedC411();
    rdlInitTableLhsp05p1();
    rdlInitTableLhfh05p1();
    rdlInitTableLhrz01p1();
    rdlInitTableLhty02p1();
    rdlInitTableLhrj0bp1();
    rdlInitTableLhslzlp1();
    rdlInitTableLhsf0ap1();
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
    var uiSewageC215List = document.getElementById("rdlSwgC215DeviceListDiv");
    var uiSewageC215One = document.getElementById("rdlSwgC215OneDeviceDiv");
    var uiScaleC01List = document.getElementById("rdlScaleC01DeviceListDiv");
    var uiScaleC01One = document.getElementById("rdlScaleC01OneDeviceDiv");
    var uiHj212C213List = document.getElementById("rdlHj212C213DeviceListDiv");
    var uiHj212C213One = document.getElementById("rdlHj212C213OneDeviceDiv");
    var uiWeighC312List = document.getElementById("rdlWeighC312DeviceListDiv");
    var uiWeighC312One = document.getElementById("rdlWeighC312OneDeviceDiv");
    var uiFeedC411List = document.getElementById("rdlFeedC411DeviceListDiv");
    var uiFeedC411One = document.getElementById("rdlFeedC411OneDeviceDiv");
    var uiLhsp05p1List = document.getElementById("rdlLhsp05p1DeviceListDiv");
    var uiLhsp05p1One = document.getElementById("rdlLhsp05p1OneDeviceDiv");
    var uiLhsf0ap1List = document.getElementById("rdlLhsf0ap1DeviceListDiv");
    var uiLhsf0ap1One = document.getElementById("rdlLhsf0ap1OneDeviceDiv");
    var uiLhfh05p1List = document.getElementById("rdlLhfh05p1DeviceListDiv");
    var uiLhfh05p1One = document.getElementById("rdlLhfh05p1OneDeviceDiv");
    var uiLhrz01p1List = document.getElementById("rdlLhrz01p1DeviceListDiv");
    var uiLhrz01p1One = document.getElementById("rdlLhrz01p1OneDeviceDiv");
    var uiLhty02p1List = document.getElementById("rdlLhty02p1DeviceListDiv");
    var uiLhty02p1One = document.getElementById("rdlLhty02p1OneDeviceDiv");
    var uiLhrj0bp1List = document.getElementById("rdlLhrj0bp1DeviceListDiv");
    var uiLhrj0bp1One = document.getElementById("rdlLhrj0bp1OneDeviceDiv");
    var uiLhslzlp1List = document.getElementById("rdlLhslzlp1DeviceListDiv");
    var uiLhslzlp1One = document.getElementById("rdlLhslzlp1OneDeviceDiv");
    var rootNodeId = rdlNowTreeNodeRoot.id;
    if (queryParameter.length == 4) {
        uiEC01List.style.display = "none";
        uiEC01One.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC01One.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC212One.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiSewageC214One.style.display = "none";
        uiSewageC215List.style.display = "none";
        uiSewageC215One.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiScaleC01One.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiWeighC312One.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiFeedC411One.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsp05p1One.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
        uiLhsf0ap1One.style.display = "none";
        uiLhfh05p1List.style.display = "none";
        uiLhfh05p1One.style.display = "none";
        uiLhrz01p1List.style.display = "none";
        uiLhrz01p1One.style.display = "none";
        uiLhty02p1List.style.display = "none";
        uiLhty02p1One.style.display = "none";
        uiLhrj0bp1List.style.display = "none";
        uiLhrj0bp1One.style.display = "none";
        uiLhslzlp1List.style.display = "none";
        uiLhslzlp1One.style.display = "none";
        if (rootNodeId === "111")   //种禽环控器
        {
            uiEC01One.style.display = "block";
        } else if (rootNodeId === "211")  //立华禽环保1.0
        {
            uiSewageC01One.style.display = "block";
        } else if (rootNodeId === "212")  //立华禽环保2.0
        {
            uiSewageC212One.style.display = "block";
        } else if (rootNodeId === "214")  //立华禽环保3.0
        {
            uiSewageC214One.style.display = "block";
        } else if (rootNodeId === "215")  //立华禽环保4.0
        {
            uiSewageC215One.style.display = "block";
        } else if (rootNodeId === "311")  //自动称重
        {
            uiScaleC01One.style.display = "block";
        } else if (rootNodeId === "312")  //种禽料塔称重1.0
        {
            uiWeighC312One.style.display = "block";
        } else if (rootNodeId === "LHSP05p1")  //立华食品-冷库测温
        {
            uiLhsp05p1One.style.display = "block";
        } else if (rootNodeId === "LHSF0Ap1")  //生防-物资熏蒸
        {
            uiLhsf0ap1One.style.display = "block";
        }else if (rootNodeId === "LHFH05p1")  //立华孵化-GPS温度
        {
            uiLhfh05p1One.style.display = "block";
        }else if (rootNodeId === "LHRZ01p1")  //立华猪用环控器
        {
            uiLhrz01p1One.style.display = "block";
        }else if (rootNodeId === "LHTY02p1")  //立华断电报警器
        {
            uiLhty02p1One.style.display = "block";
        }else if (rootNodeId === "LHRJ0Bp1")  //立华肉鸡 饮水量监测
        {
            uiLhrj0bp1One.style.display = "block";
        }else if (rootNodeId === "LHSLZLp1")  //立华饲料部 制粒机
        {
            uiLhslzlp1One.style.display = "block";
        }
    } else if (rootNodeId === "213" && queryParameter.length == 14) {
        uiEC01List.style.display = "none";
        uiEC01One.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC01One.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC212One.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiSewageC214One.style.display = "none";
        uiSewageC215List.style.display = "none";
        uiSewageC215One.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiScaleC01One.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiHj212C213One.style.display = "block";
        uiWeighC312List.style.display = "none";
        uiWeighC312One.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiFeedC411One.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsp05p1One.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
        uiLhsf0ap1One.style.display = "none";
        uiLhfh05p1List.style.display = "none";
        uiLhfh05p1One.style.display = "none";
        uiLhrz01p1List.style.display = "none";
        uiLhrz01p1One.style.display = "none";
        uiLhty02p1List.style.display = "none";
        uiLhty02p1One.style.display = "none";
        uiLhrj0bp1List.style.display = "none";
        uiLhrj0bp1One.style.display = "none";
        uiLhslzlp1List.style.display = "none";
        uiLhslzlp1One.style.display = "none";
    } else if (rootNodeId === "411" && queryParameter.length == 7) {
        uiEC01List.style.display = "none";
        uiEC01One.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC01One.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC212One.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiSewageC214One.style.display = "none";
        uiSewageC215List.style.display = "none";
        uiSewageC215One.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiScaleC01One.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiHj212C213One.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiWeighC312One.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiFeedC411One.style.display = "block";
        uiLhsp05p1List.style.display = "none";
        uiLhsp05p1One.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
        uiLhsf0ap1One.style.display = "none";
        uiLhfh05p1List.style.display = "none";
        uiLhfh05p1One.style.display = "none";
        uiLhrz01p1List.style.display = "none";
        uiLhrz01p1One.style.display = "none";
        uiLhty02p1List.style.display = "none";
        uiLhty02p1One.style.display = "none";
        uiLhrj0bp1List.style.display = "none";
        uiLhrj0bp1One.style.display = "none";
        uiLhslzlp1List.style.display = "none";
        uiLhslzlp1One.style.display = "none";
    } else {
        uiEC01List.style.display = "none";
        uiEC01One.style.display = "none";
        uiSewageC01List.style.display = "none";
        uiSewageC01One.style.display = "none";
        uiSewageC212List.style.display = "none";
        uiSewageC212One.style.display = "none";
        uiSewageC214List.style.display = "none";
        uiSewageC214One.style.display = "none";
        uiSewageC215List.style.display = "none";
        uiSewageC215One.style.display = "none";
        uiScaleC01List.style.display = "none";
        uiScaleC01One.style.display = "none";
        uiHj212C213List.style.display = "none";
        uiHj212C213One.style.display = "none";
        uiWeighC312List.style.display = "none";
        uiWeighC312One.style.display = "none";
        uiFeedC411List.style.display = "none";
        uiFeedC411One.style.display = "none";
        uiLhsp05p1List.style.display = "none";
        uiLhsp05p1One.style.display = "none";
        uiLhsf0ap1List.style.display = "none";
        uiLhsf0ap1One.style.display = "none";
        uiLhfh05p1List.style.display = "none";
        uiLhfh05p1One.style.display = "none";
        uiLhrz01p1List.style.display = "none";
        uiLhrz01p1One.style.display = "none";
        uiLhty02p1List.style.display = "none";
        uiLhty02p1One.style.display = "none";
        uiLhrj0bp1List.style.display = "none";
        uiLhrj0bp1One.style.display = "none";
        uiLhslzlp1List.style.display = "none";
        uiLhslzlp1One.style.display = "none";
        if (rootNodeId === "111")   //种禽环控器
        {
            uiEC01List.style.display = "block";
        } else if (rootNodeId === "211")  //立华禽环保1.0
        {
            uiSewageC01List.style.display = "block";
        } else if (rootNodeId === "212")  //立华禽环保2.0
        {
            uiSewageC212List.style.display = "block";
        } else if (rootNodeId === "214")  //立华禽环保3.0
        {
            uiSewageC214List.style.display = "block";
        } else if (rootNodeId === "215")  //立华禽环保4.0
        {
            uiSewageC215List.style.display = "block";
        }else if (rootNodeId === "311")  //商品鸡自动称重
        {
            uiScaleC01List.style.display = "block";
        } else if (rootNodeId === "312")  //种鸡散装料塔称重
        {
            uiWeighC312List.style.display = "block";
        } else if (rootNodeId === "213") { //水质在线监测
            uiHj212C213List.style.display = "block";
        } else if (rootNodeId === "411") { //饲料部筒仓测温
            uiFeedC411List.style.display = "block";
        } else if (rootNodeId === "LHSP05p1") { //食品-冷库测温
            uiLhsp05p1List.style.display = "block";
        } else if (rootNodeId === "LHSF0Ap1") { //生防-物资熏蒸
            uiLhsf0ap1List.style.display = "block";
        } else if (rootNodeId === "LHFH05p1") { //立华孵化GPS测温
            uiLhfh05p1List.style.display = "block";
        }else if (rootNodeId === "LHRZ01p1") { //  立华猪用环控器
            uiLhrz01p1List.style.display = "block";
        }else if (rootNodeId === "LHTY02p1") { //  立华 断电报警器
            uiLhty02p1List.style.display = "block";
        }else if (rootNodeId === "LHRJ0Bp1") { //  立华 肉鸡饮水量
            uiLhrj0bp1List.style.display = "block";
        }else if (rootNodeId === "LHSLZLp1") { //  立华 饲料 制粒机
            uiLhslzlp1List.style.display = "block";
        }
    }
    if (data.nodes != null) {
        var select_node = $('#rdlOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#rdlOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        } else {
            $('#rdlOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
    if (rootNodeId === "111")   //种禽环控器
    {
        rdlSelectDeviceByTreeIdEC01();
    } else if (rootNodeId === "211")  //立华禽环保1.0
    {
        rdlSelectDeviceByTreeIdSewageC01();
    } else if (rootNodeId === "212")  //立华禽环保2.0
    {
        rdlSelectDeviceByTreeIdSewageC212();
    } else if (rootNodeId === "214")  //立华禽环保3.0
    {
        rdlSelectDeviceByTreeIdSewageC214();
    } else if (rootNodeId === "215")  //立华禽环保4.0
    {
        rdlSelectDeviceByTreeIdSewageC215();
    } else if (rootNodeId === "311")  //污水控制器
    {
        rdlSelectDeviceByTreeIdScaleC01();
    } else if (rootNodeId === "312")  //种禽散装料塔称重1.0
    {
        rdlSelectDeviceByTreeIdWeighC312();
    } else if (rootNodeId === "213")  //水质在线监测
    {
        rdlSelectDeviceByTreeIdHj212C213();
    } else if (rootNodeId === "411")  //饲料部筒仓测温
    {
        rdlInitTableFeedC41102(queryParameter);
        setTimeout("rdlSelectDeviceByTreeIdFeedC411()", 300);
    } else if (rootNodeId === "LHSP05p1")  //立华食品-冷库测温
    {
        rdlSelectDeviceByTreeIdLhsp05p1();
    } else if (rootNodeId === "LHSF0Ap1")  //生防-物资熏蒸
    {
        rdlSelectDeviceByTreeIdLhsf0ap1();
    } else if (rootNodeId === "LHFH05p1")  //立华孵化-GPS测温
    {
        rdlSelectDeviceByTreeIdLhfh05p1();
    } else if (rootNodeId === "LHRZ01p1")  //立华猪用环控器
    {
        rdlSelectDeviceByTreeIdLhrz01p1();
    } else if (rootNodeId === "LHTY02p1")  //立华断电报警器
    {
        rdlSelectDeviceByTreeIdLhty02p1();
    } else if (rootNodeId === "LHRJ0Bp1")  //立华 商品鸡 饮水量
    {
        rdlSelectDeviceByTreeIdLhrj0bp1();
    } else if (rootNodeId === "LHSLZLp1")  //立华 饲料部 制粒机
    {
        rdlSelectDeviceByTreeIdLhslzlp1();
    }
    rdlSelectInfoByDeviceIdAndType();
}

//图表刷新
function rdlSelectInfoByDeviceIdAndType() {
    if (typeof (rdlNowTreeNode) == "undefined")
        return;
    var queryParameter = rdlNowTreeNode.id;
    var rootNodeId = rdlNowTreeNodeRoot.id;
    if (rootNodeId === "411" && queryParameter.length === 7) {
        rdlSelectInfoByDeviceIdAndFeedC411(queryParameter)
    }
    if (queryParameter.length !== 4) {
        return;
    }
    if (rootNodeId === "111")   //种禽环控器
    {
        rdlSelectInfoByDeviceIdAndEC01(queryParameter)
    } else if (rootNodeId === "211")  //立华禽环保1.0
    {
        rdlSelectInfoByDeviceIdAndSewageC01(queryParameter)
    } else if (rootNodeId === "212")  //立华禽环保2.0
    {
        rdlSelectInfoByDeviceIdAndSewageC212(queryParameter)
    } else if (rootNodeId === "214")  //立华禽环保3.0
    {
        rdlSelectInfoByDeviceIdAndSewageC214(queryParameter)
    } else if (rootNodeId === "215")  //立华禽环保4.0
    {
        rdlSelectInfoByDeviceIdAndSewageC215(queryParameter)
    }
}

// 表格刷新
function rdlTableRefresh() {
    if (typeof (rdlNowTreeNode) == "undefined")
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
        } else if (rootNodeId === "211")  //立华禽环保1.0
        {
            $('#rdlSewageC01DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "212")  //立华禽环保2.0
        {
            $('#rdlSewageC212DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "214")  //立华禽环保3.0
        {
            $('#rdlSewageC214DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "215")  //立华禽环保4.0
        {
            $('#rdlSwgC215DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }else if (rootNodeId === "311")  //自动称重
        {
            $('#rdlScaleC01DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "312")  //自动称重
        {
            $('#rdlWeighC312DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "213")  //水质在线监测
        {
            $('#rdlHj212C213DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "411")  //饲料部-筒仓测温
        {
            $('#rdlFeedC411DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHSP05p1")  //立华食品-冷库测温
        {
            $('#rdlLhsp05p1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHSF0Ap1")  //生防-物资熏蒸
        {
            $('#rdlLhsf0ap1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHFH05p1")  //立华食品-冷库测温
        {
            $('#rdlLhfh05p1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHRZ01p1")  //立华猪用环控器
        {
            $('#rdlLhrz01p1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHTY02p1")  //立华断电报警器
        {
            $('#rdlLhty02p1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHRJ0Bp1")  //立华 商品鸡 饮水量
        {
            $('#rdlLhrj0bp1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        } else if (rootNodeId === "LHSLZLp1")  //立华 饲料部 制粒机
        {
            $('#rdlLhslzlp1DeviceList').bootstrapTable('refresh', {
                query: {},
                silent: true
            });
        }
    } catch (err) {
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
        pageList: [8, 10, 25, 50, 100],
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
        pageList: [8, 10, 25, 50, 100],
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
        pageList: [8, 10, 25, 50, 100],
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
        pageList: [8, 10, 25, 50, 100],
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

//************************Lhsp05p1 start******************************/
function rdlSelectInfoByDeviceIdAndLhsp05p1(queryParameter) {

}

function rdlInitTableLhsp05p1() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/lhsp05p1DeviceHead',
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
            rdlLhsp05p1TableColumns = questionColumns;
            $('#rdlLhsp05p1DeviceList').bootstrapTable('destroy');
            $('#rdlLhsp05p1DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdLhsp05p1() {

    $('#rdlLhsp05p1DeviceList').bootstrapTable('destroy');

    $('#rdlLhsp05p1DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectLhsp05p1ByORGId",
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
        columns: rdlLhsp05p1TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************Lhsp05p1 end******************************/

//************************Lhfh05p1 start******************************/
function rdlSelectInfoByDeviceIdAndLhfh05p1(queryParameter) {

}

function rdlInitTableLhfh05p1() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/lhfh05p1DeviceHead',
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
            rdlLhfh05p1TableColumns = questionColumns;
            $('#rdlLhfh05p1DeviceList').bootstrapTable('destroy');
            $('#rdlLhfh05p1DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdLhfh05p1() {

    $('#rdlLhfh05p1DeviceList').bootstrapTable('destroy');

    $('#rdlLhfh05p1DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectLhfh05p1ByORGId",
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
        columns: rdlLhfh05p1TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************Lhfh05p1 end******************************/

//************************Lhsf0ap1 start******************************/
function rdlSelectInfoByDeviceIdAndLhsf0ap1(queryParameter) {

}

function rdlInitTableLhsf0ap1() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/lhsf0ap1DeviceHead',
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
            rdlLhsf0ap1TableColumns = questionColumns;
            $('#rdlLhsf0ap1DeviceList').bootstrapTable('destroy');
            $('#rdlLhsf0ap1DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdLhsf0ap1() {

    $('#rdlLhsf0ap1DeviceList').bootstrapTable('destroy');

    $('#rdlLhsf0ap1DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectLhsf0ap1ByORGId",
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
        columns: rdlLhsf0ap1TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************Lhsf0ap1 end******************************/

//************************Lhrz01p1 start******************************/
function rdlSelectInfoByDeviceIdAndLhrz0ap1(queryParameter) {

}

function rdlInitTableLhrz01p1() {
    var questionColumns = [];
    $.ajax({
        type: 'POST',
        data: {},
        url: '/lihuaiot01/realDeviceList/lhrz01p1DeviceHead',
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
            rdlLhrz01p1TableColumns = questionColumns;
            $('#rdlLhrz01p1DeviceList').bootstrapTable('destroy');
            $('#rdlLhrz01p1DeviceList').bootstrapTable({
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

function rdlSelectDeviceByTreeIdLhrz01p1() {

    $('#rdlLhrz01p1DeviceList').bootstrapTable('destroy');

    $('#rdlLhrz01p1DeviceList').bootstrapTable({
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
        url: "/lihuaiot01/realDeviceList/selectLhrz01p1ByORGId",
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
        columns: rdlLhrz01p1TableColumns,
        height: 500,       //设置表格高度-固定表头生效
        fixedColumns: true,
        fixedNumber: 1 //固定列数
    });
}

//************************Lhrz0ap1 end******************************/



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

    $('#rdlSewageC215Export_storage').click(function () { //立华禽环保4.0
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

    $('#rdlLhsp05p1Export_storage').click(function () { //立华食品-冷库测温
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlLhfh05p1Export_storage').click(function () { //立华孵化-GPS测温
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlLhsf0ap1Export_storage').click(function () { //生防-物资熏蒸
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlLhrz01p1Export_storage').click(function () { //猪用环控器
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlLhty02p1Export_storage').click(function () { //立华 断电报警器
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlLhrj0bp1Export_storage').click(function () { //立华 商品鸡 饮水量
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlLhslzlp1Export_storage').click(function () { //立华 饲料部 制粒机
        $('#rdlExport_modal').modal("show");
    });

    $('#rdlExport_storage_download').click(function () {
        var queryParameter = rdlNowTreeNode.id;
        var data = {
            sORGId: queryParameter
        };
        var rootNodeId = rdlNowTreeNodeRoot.id;
        var url = "";
        if (rootNodeId === "111")   //种禽环控器
        {
            url = "/lihuaiot01/realDeviceList/exportEC01DeviceList?" + $.param(data);
        } else if (rootNodeId === "211")  //立华禽环保1.0
        {
            url = "/lihuaiot01/realDeviceList/exportSewageC01DeviceList?" + $.param(data);
        } else if (rootNodeId === "212")  //立华禽环保2.0
        {
            url = "/lihuaiot01/realDeviceList/exportSewageC212DeviceList?" + $.param(data);
        } else if (rootNodeId === "214")  //立华禽环保3.0
        {
            url = "/lihuaiot01/realDeviceList/exportSewageC214DeviceList?" + $.param(data);
        } else if (rootNodeId === "215")  //立华禽环保4.0
        {
            url = "/lihuaiot01/realDeviceList/exportSwgC215DeviceList?" + $.param(data);
        } else if (rootNodeId === "311")  //自动称重
        {
            url = "/lihuaiot01/realDeviceList/exportScaleC01DeviceList?" + $.param(data);
        } else if (rootNodeId === "312")  //种鸡散装料塔称重
        {
            url = "/lihuaiot01/realDeviceList/exportWeighC312DeviceList?" + $.param(data);
        } else if (rootNodeId === "411")  //饲料部筒仓测温
        {
            url = "/lihuaiot01/realDeviceList/exportFeedC411DeviceList?" + $.param(data);
        } else if (rootNodeId === "213")  //水质在线监测
        {
            url = "/lihuaiot01/realDeviceList/exportHj212C213DeviceList?" + $.param(data);
        } else if (rootNodeId === "LHSP05p1")  //立华食品-冷库测温
        {
            url = "/lihuaiot01/realDeviceList/exportLhsp05p1DeviceList?" + $.param(data);
        }
        else if (rootNodeId === "LHFH05p1")  //立华孵化-GPS测温
        {
            url = "/lihuaiot01/realDeviceList/exportLhfh05p1DeviceList?" + $.param(data);
        } else if (rootNodeId === "LHSF0Ap1")  //生防-物资熏蒸
        {
            url = "/lihuaiot01/realDeviceList/exportLhsf0ap1DeviceList?" + $.param(data);
        } else if (rootNodeId === "LHRZ01p1")  //立华猪用环控器
        {
            url = "/lihuaiot01/realDeviceList/exportLhrz01p1DeviceList?" + $.param(data);
        } else if (rootNodeId === "LHTY02p1")  //立华 断电报警器
        {
            url = "/lihuaiot01/realDeviceList/exportLhty02p1DeviceList?" + $.param(data);
        } else if (rootNodeId === "LHRJ0Bp1")  //立华 商品鸡 饮水量
        {
            url = "/lihuaiot01/realDeviceList/exportLhrj0bp1DeviceList?" + $.param(data);
        } else if (rootNodeId === "LHSLZLp1")  //立华 饲料部 制粒机
        {
            url = "/lihuaiot01/realDeviceList/exportLhslzlp1DeviceList?" + $.param(data);
        }
        window.open(url, '_blank');
        $('#rdlExport_modal').modal("hide");
    })
}