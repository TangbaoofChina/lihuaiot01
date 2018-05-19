<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <%--<div class="tab-pane">--%>
    <%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
            <li>实时数据信息</li>
        </ol>--%>
    <div class="panel-body">
        <%--<div class="columns-left">
            <div class="zTreeDemoBackground left col-md-2" style="width:230px;height: 410px;overflow: scroll">
                <div>
                    <input class="text-input" type="text" style="width:120px;" id="txtSearchTreeNode">
                    <button class="btn btn-default" onclick="rdlSearchTreeNode()">搜索</button>
                </div>
                <ul id="tree" class="ztree"></ul>
            </div>
        </div>--%>
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto;">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="rdlTxtSearchTreeNode">
                <button class="btn btn-default" onclick="rdlSearchTreeNode()">搜索</button>
            </div>
            <div id="rdlOrgTree" style="margin-top: 5px;white-space: nowrap;overflow: auto;"></div>
        </div>

        <div class="columns-right" id="rdlEC01DeviceListDiv" style="display: block;white-space: nowrap;">
            <div id="rdlec01toolbar" class="btn-group">
                <%--<button class="btn btn-default" style="width: 61px;height: 30px" id="refresh_button"
                        onclick="tableRefresh()">
                    <span class="glyphicon glyphicon-refresh"></span> <span>刷新</span>
                </button>--%>
                <button class="btn btn-default" id="rdlEC01Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="rdlEC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlec01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlSewageC01DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlSewageC01toolbar" class="btn-group">
                <%--<button class="btn btn-default" style="width: 61px;height: 30px" id="refresh_button"
                        onclick="tableRefresh()">
                    <span class="glyphicon glyphicon-refresh"></span> <span>刷新</span>
                </button>--%>
                <button class="btn btn-default" id="rdlSewageC01Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="rdlSewageC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlSewageC01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlEC01OneDeviceDiv" style="display:none">
            <!--主体-->
            <div class="col-md-9 col-sm-8 row" id="main">
                <!--温帘状态-->
                <div class="wetCurtainMotorState">
                    <span>温帘</span>
                    <div id="wetCurtainMotorClose" class="circleClose" style="display: block">已关闭</div>
                    <div id="wetCurtainMotorOpen" class="circleOpen" style="display: none">已开启</div>
                </div>
                <!--泵状态-->
                <div class="wetCurtainWPState">
                    <span>泵</span>
                    <div id="wetCurtainWPClose" class="circleClose" style="display: block">已关闭</div>
                    <div id="wetCurtainWPOpen" class="circleOpen" style="display: none">已开启</div>
                </div>
                <!--锅炉状态-->
                <div class="boilerState">
                    <span>锅炉</span>
                    <div id="boilerClose" class="circleClose" style="display: block">已关闭</div>
                    <div id="boilerOpen" class="circleOpen" style="display: none">已开启</div>
                </div>
                <!--风机状态-->
                <div class="fanState">
                    <span>风机1</span>
                    <div id="fan01Close" class="circleClose" style="display: block">已关闭</div>
                    <div id="fan01Open" class="circleOpen" style="display: none">已开启</div>
                    <span>风机2</span>
                    <div id="fan02Close" class="circleClose" style="display: block">已关闭</div>
                    <div id="fan02Open" class="circleOpen" style="display: none">已开启</div>
                    <span>风机3</span>
                    <div id="fan03Close" class="circleClose" style="display: block">已关闭</div>
                    <div id="fan03Open" class="circleOpen" style="display: none">已开启</div>
                    <span>风机4</span>
                    <div id="fan04Close" class="circleClose" style="display: block">已关闭</div>
                    <div id="fan04Open" class="circleOpen" style="display: none">已开启</div>
                    <span>风机5</span>
                    <div id="fan05Close" class="circleClose" style="display: block">已关闭</div>
                    <div id="fan05Open" class="circleOpen" style="display: none">已开启</div>
                </div>
                <!--温帘-->
                <div class="blind"></div>
                <!--左边-->
                <div class="leftWrap">
                    <div class="temp">
                        <div>
                            <div>
                                <p>(前)温度1</p>
                                <span id="inTemp1">28.9℃</span>
                            </div>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>(中)温度2</p>
                            <span id="inTemp2">28.9℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>(后)温度3</p>
                            <span id="inTemp3">28.9℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                    </div>
                </div>
                <!--中间-->
                <div class="mainWrap">
                    <div class="temp">
                        <div>
                            <p>平均温度</p>
                            <span id="avgTemp">31.5℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>湿度</p>
                            <span id="humidityVal">44%</span>
                            <img src="/lihuaiot01/images/onedevice/rain.png">
                        </div>
                        <div>
                            <p>光照</p>
                            <span>28.9℃</span>
                            <img src="/lihuaiot01/images/onedevice/light.png">
                        </div>
                        <div>
                            <p>氨气</p>
                            <span id="nh3Val">1.3ppm</span>
                            <img src="/lihuaiot01/images/onedevice/NH3.png">
                        </div>
                        <div>
                            <p>CO2</p>
                            <span id="co2Val">405ppm</span>
                            <img src="/lihuaiot01/images/onedevice/CO2.png">
                        </div>
                    </div>
                </div>
                <!--右边-->
                <div class="rightWrap">
                    <div class="temp">
                        <div>
                            <p>室外温度</p>
                            <span id="outTemp">28.9℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>锅炉温度</p>
                            <span id="boilerTemp">28.9℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="columns-right" id="rdlSewageC01OneDeviceDiv" style="display:none">
        </div>
    </div>
</div>
</div>
</div>

<!-- 导出设备信息模态框 -->
<div class="modal fade" id="rdlExport_modal" table-index="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title" id="myModalLabel">导出信息</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-3 col-sm-3" style="text-align: center;">
                        <img src="/lihuaiot01/images/icons/warning-icon.png" alt=""
                             style="width: 70px; height: 70px; margin-top: 20px;">
                    </div>
                    <div class="col-md-8 col-sm-8">
                        <h3>是否确认导出信息</h3>
                        <p>(注意：请确定要导出的信息，导出的内容为当前实时变化的结果)</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" type="button" data-dismiss="modal">
                    <span>取消</span>
                </button>
                <button class="btn btn-success" type="button" id="rdlExport_storage_download">
                    <span>确认下载</span>
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    //removealljsfile();
    loadjscssfile("/lihuaiot01/js/userjs/realdevicelist.js", "js");
</script>
<link rel="stylesheet" href="/lihuaiot01/css/realdevicelist.css" type="text/css">
