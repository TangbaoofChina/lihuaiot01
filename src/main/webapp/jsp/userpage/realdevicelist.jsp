<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <div class="panel-body">

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

        <div class="columns-right" id="rdlSewageC212DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlSewageC212toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlSewageC212Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlSewageC212DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlSewageC212toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlSewageC214DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlSewageC214toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlSewageC214Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlSewageC214DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlSewageC214toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlScaleC01DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlScaleC01toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlScaleC01Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlScaleC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlScaleC01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlHj212C213DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlHj212C213toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlHj212C213Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table text-nowrap" id="rdlHj212C213DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlHj212C213toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlWeighC312DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlWeighC312toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlWeighC312Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlWeighC312DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlWeighC312toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlFeedC411DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlFeedC411toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlFeedC411Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlFeedC411DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlFeedC411toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlLhsp05p1DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlLhsp05p1toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlLhsp05p1Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlLhsp05p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlLhsp05p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlLhfh05p1DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlLhfh05p1toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlLhfh05p1Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlLhfh05p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlLhfh05p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlLhsf0ap1DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlLhsf0ap1toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlLhsf0ap1Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlLhsf0ap1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlLhsf0ap1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-toggle="table"
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="rdlLhrz01p1DeviceListDiv"
             style="display: none;white-space: nowrap;">
            <div id="rdlLhrz01p1toolbar" class="btn-group">
                <button class="btn btn-default" id="rdlLhrz01p1Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>

            <div class="col-md-9 col-sm-9">
                <table class="table table-striped" id="rdlLhrz01p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#rdlLhrz01p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
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
                            <p>舍前</p>
                            <span id="inTemp1">0℃</span>
                            <!--</div>-->
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>舍中</p>
                            <span id="inTemp2">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>舍后</p>
                            <span id="inTemp3">0℃</span>
                            <img src="/lihuaiot01/images/onedevice/temp.png">
                        </div>
                        <div>
                            <p>饮水量</p>
                            <span id="waterFlowVal">0m³/h</span>
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
        <div class="columns-right" id="rdlSewageC01OneDeviceDiv" style="display:none;">
            <!--主体-->
            <div class="col-md-9 col-sm-9 row" id="sewageC01Main" style="text-align: center;margin-left: 20px;">
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
        <div class="columns-right" id="rdlSewageC212OneDeviceDiv" style="display:none;">
            <!--主体-->
            <div class="col-md-9 col-sm-9 row" id="sewageC212Main" style="text-align: center;margin-left: 20px;">
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>时间</span>
                    </div>
                    <div class="col-md-5 col-sm-5 SewageC212border">
                        <span id="sewagec212sendDate">2018-05-19 12:21:12</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>累计流量(m³)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="flowmeter212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>当日流量(m³)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="todayFlowmeter212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>累计电量</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="totalEp212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>当日电量</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="todayEp212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>环境温度(℃)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="airTemp212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR水温(℃)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="waterTemp212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold"></span>
                </div>

                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">污水处理前期工艺(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="collectMixerStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="collectMixerRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="collectMixerRunMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>除磷投加机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="dephosphorizeStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="dephosphorizeRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="dephosphorizeRunMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="collectPumpStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="collectPumpRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="collectPumpRunMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵1</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sludgePump01Stop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sludgePump01Run212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sludgePump01RunMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">SBR污水处理控制系统(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>系统自动模式</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="systemAutoStop212" class="rectangle02Close" style="display: block">手动</div>
                        <div id="systemAutoRun212" class="rectangle02Open" style="display: none">自动</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR周期运行</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sbrCycleStop212" class="rectangle02Close" style="display: block">停止</div>
                        <div id="sbrCycleRun212" class="rectangle02Open" style="display: none">周期</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池进水泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrIntakePumpStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrIntakePumpRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sbrIntakePumpRunMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR静置</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrStaticStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrStaticRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sbrStaticRunMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR一次搅拌</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrMixerOnceStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixerOnceRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sbrMixerOnceRunMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR污泥泵2</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sludgePump02Stop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sludgePump02Run212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sludgePump02RunMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR曝气</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="fanStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="fanRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="fanRunMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>滗水器(排水)</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="decanterCycleStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="decanterCycleRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border" style="position: center">
                        <div id="decanterStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="decanterRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR二次搅拌</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrMixerSecStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixerSecRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sbrMixerRunMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR静置活化</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrActiveStop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrActiveRun212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="sbrActiveRunMinute212">50</span>
                    </div>
                </div>

                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">工艺流程设定时间(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>除磷投加机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="dephosphorizeSetMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sludgePump01SetMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR设定周期</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrCycleSetMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR一次搅拌</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrMixerOnceSetMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR静置</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrStaticSetMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR曝气</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="fanSetMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR污泥泵2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sludgePump02SetMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR二次搅拌</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrMixerSetMinute212">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR活化</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrActiveSetMinute212">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">设备运行状态</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>回转式风机1</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="fan01Stop212" class="rectangleClose" style="display: block">停</div>
                        <div id="fan01Run212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>/</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>回转式风机2</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="fan02Stop212" class="rectangleClose" style="display: block">停</div>
                        <div id="fan02Run212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>/</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池搅拌机01</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrMixer01Stop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixer01Run212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>/</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池搅拌机02</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC212border">
                        <div id="sbrMixer02Stop212" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixer02Run212" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>/</span>
                    </div>
                </div>

                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">公共参数</span>
                </div>

                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池液位高</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="collectHighOff212" class="rectangle02Close" style="display: block">未到</div>
                        <div id="collectHighOn212" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池液位低</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="collectLowOff212" class="rectangle02Close" style="display: block">未到</div>
                        <div id="collectLowOn212" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>调节池液位高</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="regulatHighOff212" class="rectangle02Close" style="display: block">未到</div>
                        <div id="regulatHighOn212" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>调节池液位低</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="regulatLowOff212" class="rectangle02Close" style="display: block">未到</div>
                        <div id="regulatLowOn212" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池液位高</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sbrHighOff212" class="rectangle02Close" style="display: block">未到</div>
                        <div id="sbrHighOn212" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池液位低</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sbrLowOff212" class="rectangle02Close" style="display: block">未到</div>
                        <div id="sbrLowOn212" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">故障状态</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="collectMixerNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectMixerFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="collectPumpNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectPumpFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sludgePump01Normal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sludgePump01Fault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池进水泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sbrIntakePumpNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrIntakePumpFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池搅拌机1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sbrMixer01Normal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrMixer01Fault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池搅拌机2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sbrMixer02Normal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrMixer02Fault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>回转式风机1</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="fan01Normal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="fan01Fault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>回转式风机2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="fan02Normal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="fan02Fault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵2</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="sludgePump02Normal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sludgePump02Fault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="decanterNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="decanterFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>PLC电量</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="plcElecNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="plcElecLack212" class="rectangle02Close" style="display: none">不足</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>除磷投加机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="dephosphorizeNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="dephosphorizeFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>智能电表</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="elecNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="elecFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>环境温度</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="airTempNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="airTempFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池水温</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <div id="waterTempNormal212" class="rectangle02Open" style="display: block">正常</div>
                        <div id="waterTempFault212" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">电能数据</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>线Uab</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="uab212">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>线Ubc</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="ubc212">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>线Uca</span>
                    </div>
                    <div class="col-sm-2 col-sm-2 SewageC212border">
                        <span id="uca212">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>相Ua</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="ua212">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>相Ub</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="ub212">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>相Uc</span>
                    </div>
                    <div class="col-sm-2 col-sm-2 SewageC212border">
                        <span id="uc212">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>Ia</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="ia212">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>Ib</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span id="ib212">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC212border">
                        <span>Ic</span>
                    </div>
                    <div class="col-sm-2 col-sm-2 SewageC212border">
                        <span id="ic212">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>合相有功功率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="pt212">150.22</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>合相无功功率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="qt212">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>合相视在功率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="st212">150.22</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>合相功率因数</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="pft212">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>正向有功总电能</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="impEP212">150.22</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>反向有功总电能</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="expEP212">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>频率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="freq212">30</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">设备运行累计时长(时)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="collectMixerTotal212">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>除磷投加机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="dephosphorizeTotal212">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="collectPumpTotal212">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sludgePump01Total212">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR进水泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrIntakePumpTotal212">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池搅拌机01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrMixer01Total212">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR池搅拌机02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrMixer02Total212">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>回转式风机01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="fan01Total212">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>回转式风机02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="fan02Total212">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sludgePump02Total212">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="decanterTotal212">15012</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="columns-right" id="rdlSewageC214OneDeviceDiv" style="display:none;">
            <!--主体-->
            <div class="col-md-9 col-sm-9 row" id="sewageC214Main" style="text-align: center;margin-left: 20px;">
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>时间</span>
                    </div>
                    <div class="col-md-5 col-sm-5 SewageC214border">
                        <span id="sewagec214sendDate">2018-05-19 12:21:12</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>累计流量(m³)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="flowmeter214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>当日流量(m³)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="todayFlowmeter214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>累计电量</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="totalEp214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>当日电量</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="todayEp214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>环境温度(℃)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="airTemp214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR水温(℃)</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="waterTemp214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold"></span>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">污水处理前期工艺(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>集水井提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="collectWellPumpStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="collectWellPumpRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="collectWellPumpRunMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="collectMixerStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="collectMixerRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="collectMixerRunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="collectPumpStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="collectPumpRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="collectPumpRunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">SBR污水处理控制系统(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR搅拌机01</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="sbrMixer01Stop214" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixer01Run214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fanMixer01RunMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>风机02</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="fan02Stop214" class="rectangleClose" style="display: block">停</div>
                        <div id="fan02Run214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fan02RunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>污泥泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="sludgePumpStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="sludgePumpRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="sludgePumpRunMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="decanterStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="decanterRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="decanterRunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>风机01</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="fan01Stop214" class="rectangleClose" style="display: block">停</div>
                        <div id="fan01Run214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fan01RunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR搅拌机02</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="sbrMixer02Stop214" class="rectangleClose" style="display: block">停</div>
                        <div id="sbrMixer02Run214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fanMixer02RunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">除磷控制系统(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>运行时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>运</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>运行时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>1#加药泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="dosingPumpStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="dosingPumpRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="dosingPumpRunMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>除磷池提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="dephosphorizePumpStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="dephosphorizePumpRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="dephosphorizePumpRunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>加药罐搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <div id="dosingMixerStop214" class="rectangleClose" style="display: block">停</div>
                        <div id="dosingMixerRun214" class="rectangleOpen" style="display: none">运</div>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="dosingMixerRunMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">工艺流程设定时间(分钟)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>启</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>设定时间</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>工艺流程</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span>启</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>设定时间</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>集水井提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="collectWellPumpSTime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="collectWellPumpSetMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>风机02</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="fan02STime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fan02SetMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="collectPumpSTime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="collectPumpSetMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>静止沉淀</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="staticSTime214">05:40</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="staticSetMinute214">123</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="collectMixerSTime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="collectMixerSetMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="decanterSTime214">05:40</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="decanterSetMinute214">123</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR搅拌机01</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="fanMixer01STime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fanMixer01SetMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>1#加药泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="dosingPumpSTime214">05:40</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="dosingPumpSetMinute214">123</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>污泥泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="sludgePumpSTime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="sludgePumpSetMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>加药罐搅拌机</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="dosingMixerSTime214">05:40</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="dosingMixerSetMinute214">123</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>风机01</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="fanSTime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fan01SetMinute214">50</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>除磷池提升泵</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="dephosphorizePumpSTime214">05:40</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="dephosphorizePumpSetMinute214">123</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR搅拌机02</span>
                    </div>
                    <div class="col-md-1 col-sm-1 SewageC214border">
                        <span id="fanMixer02STime214">10:00</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="fanMixer02SetMinute214">50</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">公共参数</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池高液位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="collectHighOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="collectHighOn214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR池高液位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="sbrHighOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="sbrHighOn214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池低液位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="collectLowOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="collectLowOn214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR池低液位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="sbrLowOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="sbrLowOn214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>除磷池高液位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="dephosphorizeHighOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="dephosphorizeHighOn214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>滗水器开到位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="decanterOnOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="decanterOnOK214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>除磷池低液位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="dephosphorizeLowOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="dephosphorizeLowOn214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>滗水器关到位</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="decanterOffOff214" class="rectangle02Close" style="display: block">未到</div>
                        <div id="decanterOffOK214" class="rectangle02Open" style="display: none">到了</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">故障状态</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>集水井提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="collectWellPumpNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectWellPumpFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="decanterNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="decanterFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="collectPumpNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectPumpFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>1#加药泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="dosingPumpNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="dosingPumpFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>收集池搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="collectMixerNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="collectMixerFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>加药罐搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="dosingMixerNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="dosingMixerFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR搅拌机01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="sbrMixer01Normal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrMixer01Fault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>除磷池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="dephosphorizePumpNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="dephosphorizePumpFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>污泥泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="sludgePumpNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sludgePumpFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>PLC电量不足</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="plcElecNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="plcElecLack214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>风机01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="fan01Normal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="fan01Fault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>智能电表设备通讯</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="elecNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="elecFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR搅拌机02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="sbrMixer02Normal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="sbrMixer02Fault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>空气温度变送器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="airTempNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="airTempFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>风机02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="fan02Normal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="fan02Fault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>SBR水温变送器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <div id="waterTempNormal214" class="rectangle02Open" style="display: block">正常</div>
                        <div id="waterTempFault214" class="rectangle02Close" style="display: none">故障</div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">电能数据</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>线Uab</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="uab214">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>线Ubc</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="ubc214">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>线Uca</span>
                    </div>
                    <div class="col-sm-2 col-sm-2 SewageC214border">
                        <span id="uca214">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>相Ua</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="ua214">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>相Ub</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="ub214">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>相Uc</span>
                    </div>
                    <div class="col-sm-2 col-sm-2 SewageC214border">
                        <span id="uc214">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>Ia</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="ia214">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>Ib</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span id="ib214">150.22</span>
                    </div>
                    <div class="col-md-2 col-sm-2 SewageC214border">
                        <span>Ic</span>
                    </div>
                    <div class="col-sm-2 col-sm-2 SewageC214border">
                        <span id="ic214">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>合相有功功率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="pt214">150.22</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>合相无功功率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="qt214">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>合相视在功率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="st214">150.22</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>合相功率因数</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="pft214">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>正向有功总电能</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="impEP214">150.22</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>反向有功总电能</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="expEP214">150.22</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span>频率</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC214border">
                        <span id="freq214">30</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row" style="text-align: left;">
                    <span style="font-weight: bold">设备运行累计时长(时)</span>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>集水井提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="collectWellPumpTotal214">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR搅拌机02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrMixer02Total214">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>收集池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="collectPumpTotal214">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>风机02</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="fan02Total214">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>收集池搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="collectMixerTotal214">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>滗水器</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="decanterTotal214">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>SBR搅拌机01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sbrMixer01Total214">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>加药泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="dosingPumpTotal214">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>污泥泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="sludgePumpTotal214">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>加药罐搅拌机</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="dosingMixerTotal214">15012</span>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 row">
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>风机01</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="fan01Total214">15012</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span>除磷池提升泵</span>
                    </div>
                    <div class="col-md-3 col-sm-3 SewageC212border">
                        <span id="dephosphorizePumpTotal214">15012</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="columns-right" id="rdlScaleC01OneDeviceDiv" style="display: none">
        </div>

        <div class="columns-right" id="rdlWeighC312OneDeviceDiv" style="display: none">

        </div>

        <div class="columns-right" id="rdlFeedC411OneDeviceDiv" style="display: none">
            <!--主体-->
            <div class="col-md-9 col-sm-9 row" id="feedC411Main" style="text-align: center;margin-left: 20px;">
                <div class="col-md-12 col-sm-12 row">
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#708090">
                        <span>仓号</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border">
                        <span id="feedC411SiloNum">1号仓</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border">
                        <span id="feedC411UseState01">使用</span>
                        <span id="feedC411UseState02">缓用</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border">
                        <span>设备时间</span>
                    </div>
                    <div class="col-md-4 col-sm-4 FeedC411border">
                        <span id="feedC411sendDate">2018-05-19 12:21:12</span>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" style="display: flex;justify-content: space-around;align-items: center;">
<%--                <div  style="display: flex;justify-content: space-around;align-items: center;">--%>
<%--                <div style="display: inline">--%>
                    <div class="FeedC411border FeedC411Width" style="background-color:#708090">
                        <span>--</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-01" style="background-color:#FFFFE0">
                        <span>1层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-02" style="background-color:#FFFFE0">
                        <span>2层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-03" style="background-color:#FFFFE0">
                        <span>3层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-04" style="background-color:#FFFFE0">
                        <span>4层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-05"  style="background-color:#FFFFE0">
                        <span>5层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-06"  style="background-color:#FFFFE0">
                        <span>6层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-07"  style="background-color:#FFFFE0">
                        <span>7层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-08"  style="background-color:#FFFFE0">
                        <span>8层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-09"  style="background-color:#FFFFE0">
                        <span>9层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-10"  style="background-color:#FFFFE0">
                        <span>10层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-11"  style="background-color:#FFFFE0">
                        <span>11层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-12"  style="background-color:#FFFFE0">
                        <span>12层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-13"  style="background-color:#FFFFE0">
                        <span>13层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-14"  style="background-color:#FFFFE0">
                        <span>14层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-15"  style="background-color:#FFFFE0">
                        <span>15层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-16"  style="background-color:#FFFFE0">
                        <span>16层</span>
                    </div>
                    <div class="FeedC411border FeedC411Width" id="feedC411-head-humi" style="background-color:#FFFFE0">
                        <span>湿度</span>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" id="feedC411-div-01" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#708090">
                        <span>1</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border" >
                        <span id="feedC411-01-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-01-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-humidity01">34.3</span>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" id="feedC411-div-02" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#708090">
                        <span>2</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-02-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border" style="background-color:#FFFFE0">
                        <span>环湿</span>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" id="feedC411-div-03" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#708090">
                        <span>3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-03-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-envHumidity">34.3</span>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" id="feedC411-div-04" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#708090">
                        <span>4</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-04-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">

                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" id="feedC411-div-05" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#708090">
                        <span>5</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-05-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">

                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" id="feedC411-div-06" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#708090">
                        <span>6</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-06-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">

                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#FF0000">
                        <span>最高</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-High-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">

                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#FFFF00">
                        <span>最低</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Low-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">

                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row" style="display: flex;justify-content: space-around;align-items: center;">
                    <div class="FeedC411Width FeedC411border" style="background-color:#00FF00">
                        <span>平均</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-01">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-02">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-03">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-04">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-05">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-06">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-07">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-08">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-09">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-10">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-11">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-12">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-13">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-14">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-15">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">
                        <span id="feedC411-Avg-16">23.3</span>
                    </div>
                    <div class="FeedC411Width FeedC411border">

                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row">
                    <div class="col-md-1 col-sm-1 FeedC411border" style="background-color:#FFFF00">
                        <span >全仓</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#FF0000">
                        <span>最高温</span>
                    </div>
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span id="feedC411-High">23.3</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#FFFF00">
                        <span>最低温</span>
                    </div>
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span id="feedC411-Low">23.3</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#00FF00">
                        <span>平均温</span>
                    </div>
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span id="feedC411-Avg">23.3</span>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 row">
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span>--</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#00FFFF">
                        <span >库存(吨)</span>
                    </div>
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span id="feedC411-Stock">23.3</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#00FFFF">
                        <span>水份(%)</span>
                    </div>
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span id="feedC411-Water">23.3</span>
                    </div>
                    <div class="col-md-2 col-sm-2 FeedC411border" style="background-color:#00FFFF">
                        <span>高温阈值</span>
                    </div>
                    <div class="col-md-1 col-sm-1 FeedC411border">
                        <span id="feedC411-highThreshold">23.3</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="columns-right" id="rdlHj212C213OneDeviceDiv" style="display: none">

        </div>

        <div class="columns-right" id="rdlLhsp05p1OneDeviceDiv" style="display: none">

        </div>

        <div class="columns-right" id="rdlLhfh05p1OneDeviceDiv" style="display: none">

        </div>

        <div class="columns-right" id="rdlLhsf0ap1OneDeviceDiv" style="display: none">

        </div>

        <div class="columns-right" id="rdlLhrz01p1OneDeviceDiv" style="display: none">

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
