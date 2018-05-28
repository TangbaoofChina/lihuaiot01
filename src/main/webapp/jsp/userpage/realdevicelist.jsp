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

            <div class="col-md-9 col-sm-9">
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

            <div class="col-md-9 col-sm-9">
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
            <div class="col-md-9 col-sm-9 row" id="main">
                <%--<!--温帘状态-->
                <div class="wetCurtainMotorState">
                    <span>温帘</span>
                    <div id="wetCurtainMotorClose" class="circleClose" style="display: block">已关闭</div>
                    <div id="wetCurtainMotorOpen" class="circleOpen" style="display: none">已开启</div>
                </div>--%>
                <!--泵状态-->
                <div class="wetCurtainWPState">
                    <span>泵</span>
                    <div id="wetCurtainWPClose" class="circleClose" style="display: block">已关闭</div>
                    <div id="wetCurtainWPOpen" class="circleOpen" style="display: none">已开启</div>
                </div>
                <%--<!--锅炉状态-->
                <div class="boilerState">
                    <span>锅炉</span>
                    <div id="boilerClose" class="circleClose" style="display: block">已关闭</div>
                    <div id="boilerOpen" class="circleOpen" style="display: none">已开启</div>
                </div>--%>
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
                            <!--<div>-->
                            <p>(前)温度1</p>
                            <span id="inTemp1">0℃</span>
                            <!--</div>-->
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>(中)温度2</p>
                            <span id="inTemp2">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>(后)温度3</p>
                            <span id="inTemp3">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                    </div>
                </div>
                <!--中间-->
                <div class="mainWrap">
                    <div class="temp">
                        <div>
                            <p>平均温度</p>
                            <span id="avgTemp">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>湿度</p>
                            <span id="humidityVal">0%</span>
                            <img src="/lihuaiot01/images/onedevice/rain.png">
                        </div>
                        <div>
                            <p>光照</p>
                            <span id="lightIntensity">0Lux</span>
                            <img src="/lihuaiot01/images/onedevice/light.png">
                        </div>
                        <div>
                            <p>氨气</p>
                            <span id="nh3Val">0ppm</span>
                            <img src="/lihuaiot01/images/onedevice/NH3.png">
                        </div>
                        <div>
                            <p>CO2</p>
                            <span id="co2Val">0ppm</span>
                            <img src="/lihuaiot01/images/onedevice/CO2.png">
                        </div>
                    </div>
                </div>
                <!--右边-->
                <div class="rightWrap">
                    <div class="temp">
                        <div>
                            <p>室外温度</p>
                            <span id="outTemp">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>锅炉水温</p>
                            <span id="boilerTemp">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <!--<div>-->
                            <p>时间</p>
                            <span id="sc01date">2018-05-23 01:01:01</span>
                            <!--</div>-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="columns-right" id="rdlSewageC01OneDeviceDiv" style="display:none">
            <!--主体-->
            <div class="col-md-9 col-sm-9 row" id="sewageC01Main" style="text-align: center;">
                <div class="col-md-9 col-sm-9 row">
                <div class="col-md-2 col-sm-2 SewageC01border">
                    <span>时间</span>
                </div>
                <div class="col-md-5 col-sm-5 SewageC01border">
                    <span id="sewagec01sendDate">2018-05-19 12:21:12</span>
                </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>累计流量(m³)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="flowmeter">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>当日流量(m³)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="todayFlowmeter">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold"></span>
                </div>

                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">污水处理前期工艺(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>集水池搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="collectMixerStop" class="rectangleClose" style="display: block">停</div>
                        <div id="collectMixerRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="collectMixerRunMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>除磷投加机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="dephosphorizeStop" class="rectangleClose" style="display: block">停</div>
                        <div id="dephosphorizeRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="dephosphorizeRunMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>集水池提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="collectPumpStop" class="rectangleClose" style="display: block">停</div>
                        <div id="collectPumpRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="collectPumpRunMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>污泥泵1</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sludgePump01Stop" class="rectangleClose" style="display: block">停</div>
                        <div id="sludgePump01Run" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sludgePump01RunMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">SBR污水处理控制系统(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>系统自动模式</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="systemAutoStop" class="rectangle02Close" style="display: block">手动</div>
                        <div id="systemAutoRun" class="rectangle02Open" style="display: none">自动</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR周期运行</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sbrCycleStop" class="rectangle02Close" style="display: block">停止</div>
                        <div id="sbrCycleRun" class="rectangle02Open" style="display: none">周期</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池进水泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sbrIntakePumpStop" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrIntakePumpRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sbrIntakePumpRunMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR静置</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sbrStaticStop" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrStaticRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sbrStaticRunMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR一次搅拌</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sbrMixerOnceStop" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixerOnceRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sbrMixerOnceRunMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR污泥泵2</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sludgePump02Stop" class="rectangleClose" style="display: block">停</div>
                        <div id="sludgePump02Run" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sludgePump02RunMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR曝气</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="fanStop" class="rectangleClose" style="display: block">停</div>
                        <div id="fanRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="fanRunMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>滗水器(排水)</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="decanterCycleStop" class="rectangleClose" style="display: block">停</div>
                        <div id="decanterCycleRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border" style="position: center">
                        <div id="decanterStop" class="rectangleClose" style="display: block">停</div>
                        <div id="decanterRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR二次搅拌</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sbrMixerSecStop" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixerSecRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sbrMixerRunMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR静置活化</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sbrActiveStop" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrActiveRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span id="sbrActiveRunMinute">50</span>
                    </div>
                </div>

                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">工艺流程设定时间(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>除磷投加机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="dephosphorizeSetMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>污泥泵1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sludgePump01SetMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR设定周期</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sbrCycleSetMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR一次搅拌</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sbrMixerOnceSetMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR静置</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sbrStaticSetMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR曝气</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="fanSetMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR污泥泵2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sludgePump02SetMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR二次搅拌</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sbrMixerSetMinute">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR活化</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span id="sbrActiveSetMinute">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">设备运行状态</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>回转式风机1</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="fan01Stop" class="rectangleClose" style="display: block">停</div>
                        <div id="fan01Run" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>/</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>回转式风机2</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="fan02Stop" class="rectangleClose" style="display: block">停</div>
                        <div id="fan02Run" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>/</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC01border">
                        <div id="sbrMixerStop" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixerRun" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC01border">
                        <span>/</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">公共参数</span>
                </div>

                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>集水池液位高</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="collectHighOff" class="rectangle02Close" style="display: block">未到</div>
                        <div id="collectHighOn" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>集水池液位低</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="collectLowOff" class="rectangle02Close" style="display: block">未到</div>
                        <div id="collectLowOn" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>调节池液位高</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="regulatHighOff" class="rectangle02Close" style="display: block">未到</div>
                        <div id="regulatHighOn" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>调节池液位低</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="regulatLowOff" class="rectangle02Close" style="display: block">未到</div>
                        <div id="regulatLowOn" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池液位高</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sbrHighOff" class="rectangle02Close" style="display: block">未到</div>
                        <div id="sbrHighOn" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池液位低</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sbrLowOff" class="rectangle02Close" style="display: block">未到</div>
                        <div id="sbrLowOn" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">故障状态</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>集水池搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="collectMixerNormal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectMixerFault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>集水池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="collectPumpNormal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectPumpFault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>污泥泵1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sludgePump01Normal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sludgePump01Fault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池进水泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sbrIntakePumpNormal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrIntakePumpFault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池搅拌机1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sbrMixer01Normal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrMixer01Fault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>SBR池搅拌机2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sbrMixer02Normal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrMixer02Fault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>回转式风机1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="fan01Normal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="fan01Fault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>回转式风机2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="fan02Normal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="fan02Fault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>污泥泵2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="sludgePump02Normal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sludgePump02Fault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="decanterNormal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="decanterFault" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <span>PLC电量</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC01border">
                        <div id="plcElecNormal" class="rectangle02Open" style="display: block">正常</div>
                        <div id="plcElecLack" class="rectangle02Close" style="display: none">不足</div>
                    </div>
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
