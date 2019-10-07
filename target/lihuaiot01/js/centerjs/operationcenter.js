var centerTreeNodes;

$(function () {
    centerInitBaiDuMap();
    centerInitTreeNode();
});

function centerInitTreeNode() {
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
                centerTreeNodes = json;
                $('#centerOrgTree').treeview({
                    data: centerTreeNodes,
                    showTags: true,
                    highlightSelected: true,    //是否高亮选中
                    emptyIcon: '',    //没有子节点的节点图标
                    selectedBackColor: "#8D9CAA",
                    onNodeSelected: centerNodeSelected,
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

function centerNodeSelected(event, data) {
    //console.log(data);
    $('#centerOrgTree').treeview('clearSearch');
    if (data.nodes != null) {
        var select_node = $('#centerOrgTree').treeview('getSelected');
        if (select_node[0].state.expanded) {
            $('#centerOrgTree').treeview('collapseNode', select_node);
            select_node[0].state.selected = false;
        }
        else {
            $('#centerOrgTree').treeview('expandNode', select_node);
            select_node[0].state.selected = false;
        }
    }
}

function centerSearchTreeNode() {
    var txtSearch = document.getElementById("centerTxtSearchTreeNode").value;
    $('#centerOrgTree').treeview('search',
        [txtSearch,
            {
                ignoreCase: true,    //case insensitive
                exactMatch: false,   // like or equals
                revealResults: true, //reveal matching nodes

            }]);
}

function centerInitBaiDuMap() {

    // 百度地图API功能
    var map = new BMap.Map("centerBaiDuMap");    // 创建Map实例
    var point = new BMap.Point(119.887508, 31.703012);    // 创建点坐标
    map.centerAndZoom(point, 17);                     // 初始化地图,设置中心点坐标和地图级别。
    map.enableScrollWheelZoom(true);                            //启用滚轮放大缩小
    var marker = new BMap.Marker(point); // 创建点
    map.addOverlay(marker);            //增加点
    var opts = {
        position: point,    // 指定文本标注所在的地理位置
        offset: new BMap.Size(10, -20)    //设置文本偏移量
    }
    /*var label = new BMap.Label("江苏立华牧业股份有限公司", opts);  // 创建文本标注对象
    label.setStyle({
        color: "red",
        fontSize: "12px",
        height: "20px",
        lineHeight: "20px",
        fontFamily: "微软雅黑"
    });
    map.addOverlay(label);*/
    marker.addEventListener("click", getAttr);

}

function getAttr() {
    //var p = marker.getPosition();       //获取marker的位置
    //            alert("marker的位置是" + p.lng + "," + p.lat);
    window.location.href = "http://www.lihuamuye.com/culture.html";
}

