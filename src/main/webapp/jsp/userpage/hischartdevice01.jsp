<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default" style="height:100%;width:100%;">
    <%--<div class="tab-pane">--%>
    <%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
            <li>历史曲线信息</li>
        </ol>--%>
    <div class="panel-body" style="height:100%;width:100%;">
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto;">
            <div id="hisChartOrgTree" style="margin-top: 5px;white-space: nowrap;overflow: auto;"></div>
        </div>
        <div class="columns-right" id="hisChartEC01DivP1" style="display: block;white-space: nowrap;">
            <div class="form-inline" id="hisChartEC01Div" style="display: block;">
                <div class="input-group" style="margin-left: 15px;">
                    <label>设备：</label>
                    <select class="form-control" id="hisChartsel_search" multiple="multiple">
                    </select>
                </div>
                <div class="input-group" id="hisChartEC01Param">
                    <label>参数：</label>
                    <select name="hisChartSelName_Param" onchange="hisChartParamChange()" id="hisChartSelId_Param"
                            class="input-sm">
                        <option value="0" selected="selected">舍内</option>
                        <option value="1">舍前</option>
                        <option value="2">舍中</option>
                        <option value="3">舍后</option>
                        <option value="4">舍外</option>
                        <option value="5">饮水量</option>
                        <option value="6">日饮水量</option>
                        <option value="7">日温饮水</option>
                        <option value="8">单舍饮水量</option>
                        <option value="9">单舍温度</option>
                        <option value="10">多舍日饮水量</option>
                    </select>
                </div>
                <div id="hisChartThresholdDiv" class="form-inline"
                     style="margin-top: 10px; display: none;">
                    <div class="input-group" style="margin-left: 15px;">
                        <label>最大阈值：</label>
                        <input name="hisChartMaxThreshold" id="hisChartMaxThreshold" style="width: 50px;"
                               onkeyup="value=value.replace(/[^\d]/g,'')"/>
                    </div>
                    <div class="input-group">
                        <label>最小阈值：</label>
                        <input name="hisChartMinThreshold" id="hisChartMinThreshold" style="width: 50px;"
                               onkeyup="value=value.replace(/[^\d]/g,'')"/>
                    </div>
                </div>
                <div id="hisChartTempWaterDiv" class="form-inline" style="margin-top: 10px;display: none">
                    <div class="input-group" style="margin-left: 15px;">
                        <label>日温参照：</label>
                        <select class="input-sm" id="hisChartDeviceTempSelect" style="width: 200px;">
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-inline" id="hisChartDateRangeDiv" style="margin-top: 10px; display: block;">
                <label style="margin-left: 15px;">时间：</label>
                <div class="btn-group">
                    <input type="text" id="hisChartDateInterval" class="form-control" style="width: 320px;">
                </div>
                <button class="btn btn-default" id="hisChartQuery_storage">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                </button>
            </div>
            <div class="form-inline" id="hisChartDateTimeDiv" style="margin-top: 10px;display: none;">
                <label style="margin-left: 15px;">时间：</label>
                <input class="form_date form-control" value="" id="hisChartSelectDate" name="" placeholder="选择日期">
                <button class="btn btn-default" id="hisChartAddDate" onclick="hisChartAddDateToList()">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>增加
                </button>
                <select name="hisChartDateTimeList" id="hisChartDateTimeList" style="width: 200px;"
                        class="input-sm">
                </select>
                <button class="btn btn-default" id="hisChartRemoveDate" onclick="hisChartRemoveDateToList()">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>移除
                </button>
                <button class="btn btn-default" id="hisChartClearByDateList" onclick="hisChartClearDateToList()">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>清空
                </button>
                <button class="btn btn-default" id="hisChartQueryByDateList" onclick="hisChartQueryDateToList()">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                </button>
            </div>
        </div>
        <div class="columns-right" id="hisChartSewageC01Div" style="display: none;white-space: nowrap;">
        </div>
        <div class="columns-right" id="hisChartScaleC01DivP1" style="display: none;white-space: nowrap;">
            <div class="form-inline">
                <div class="input-group" style="margin-left: 15px;">
                    <label>参数：</label>
                    <select name="hisChartScaleC01SelName_Param"
                            id="hisChartScaleC01SelId_Param"
                            class="input-sm">
                        <option value="0" selected="selected">称重分析</option>
                        <option value="1">有效体重</option>
                        <option value="2">平均体重</option>
                        <option value="3">增重日龄</option>
                        <option value="4">多增重日龄</option>
                    </select>
                </div>
                <label>时间：</label>
                <div class="btn-group">
                    <input type="text" id="hisChartScaleC01DateInterval" class="form-control" style="width: 320px;">
                </div>
                <button class="btn btn-default" id="hisChartScaleC01Query_storage" onclick="hisChartScaleC01Query()">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                </button>
            </div>
            <div id="hisChartScaleC01ThresholdDiv" class="form-inline"
                 style="margin-top: 10px; display: block;">
                <div class="input-group" style="margin-left: 15px;">
                    <label>最大阈值：</label>
                    <input name="hisChartScaleC01MaxThreshold" id="hisChartScaleC01MaxThreshold" style="width: 50px;"
                           onkeyup="value=value.replace(/[^\d]/g,'')"/>
                </div>
                <div class="input-group">
                    <label>最小阈值：</label>
                    <input name="hisChartScaleC01MinThreshold" id="hisChartScaleC01MinThreshold" style="width: 50px;"
                           onkeyup="value=value.replace(/[^\d]/g,'')"/>
                </div>
                <div class="input-group">
                    <label>起始日龄：</label>
                    <input name="hisChartScaleC01StartAge" id="hisChartScaleC01StartAge" style="width: 50px;"
                           onkeyup="value=value.replace(/[^\d]/g,'')"/>
                </div>
            </div>
        </div>
        <%--水质在线监测第一部分--%>
        <div class="columns-right" id="hisChartHj212C213DivP1" style="display: none;white-space: nowrap;">
            <div class="form-inline" style="display: block;">
                <div class="input-group" id="hisChartHj212C213Param">
                    <label>参数：</label>
                    <select name="hisChartHj212C213SelName_Param" onchange="hisChartHj212C213ParamChange()"
                            id="hisChartHj212C213SelId_Param"
                            class="input-sm">
                        <option value="0" selected="selected">流量</option>
                        <option value="1">pH</option>
                        <option value="2">COD</option>
                        <option value="3">氨氮</option>
                        <option value="4">总磷</option>
                        <option value="5">流量/COD</option>
                        <option value="6">流量/氨氮</option>
                        <option value="7">流量/总磷</option>
                        <option value="8">COD/氨氮</option>
                        <option value="9">COD/总磷</option>
                        <option value="10">氨氮/总磷</option>
                    </select>
                </div>
                <label>时间：</label>
                <div class="btn-group">
                    <input type="text" id="hisChartHj212C213DateInterval" class="form-control" style="width: 320px;">
                </div>
                <button class="btn btn-default" id="hisChartHj212C213Query_storage" onclick="hisChartHj212C213Query()">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                </button>
            </div>
        </div>
        <div class="col-md-8 col-sm-7" id="hisChartScaleC01DivP2" style="height:100%;display: none;">
            <div id="echartsScaleC01main" style="margin-top: 15px;"></div>
            <div id="hisChartScaleC01toolbar" style="margin-left: 15px;">
                <button class="btn btn-default" id="hisChartScaleC01Export_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>
            <div class="table-responsive" id="hisChartScaleC01TableDiv">
                <table class="table table-striped" id="hisChartScaleC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisChartScaleC01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
        <div class="col-md-8 col-sm-7" id="hisChartEC01DivP2" style="height:100%;display: block;">
            <div id="echartsmain" style="margin-top: 15px;"></div>
            <div id="hisCharttoolbar">
                <button class="btn btn-default" id="hisChartExport_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>
            <div class="table-responsive" id="hisChartTableDiv">
                <table class="table table-striped" id="hisChartDeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisCharttoolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
        <div class="col-md-8 col-sm-7" id="hisChartHj212C213DivP2" style="height:100%;display: none;">
            <div id="echartsHj212C213main" style="margin-top: 15px;"></div>
        </div>
    </div>
</div>

<!-- 导出设备信息模态框 -->
<div class="modal fade" id="export_modal" table-index="-1" role="dialog"
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
                        <p>(注意：请确定要导出的信息，导出的内容为当前列表的搜索结果)</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" type="button" data-dismiss="modal">
                    <span>取消</span>
                </button>
                <button class="btn btn-success" type="button" id="hisChartExport_storage_download">
                    <span>确认下载</span>
                </button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="exportScaleC01_modal" table-index="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title" id="myScaleC01ModalLabel">导出信息</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-3 col-sm-3" style="text-align: center;">
                        <img src="/lihuaiot01/images/icons/warning-icon.png" alt=""
                             style="width: 70px; height: 70px; margin-top: 20px;">
                    </div>
                    <div class="col-md-8 col-sm-8">
                        <h3>是否确认导出信息</h3>
                        <p>(注意：请确定要导出的信息，导出的内容为当前列表的搜索结果)</p>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" type="button" data-dismiss="modal">
                    <span>取消</span>
                </button>
                <button class="btn btn-success" type="button" id="hisChartScaleC01Export_storage_download">
                    <span>确认下载</span>
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    //removealljsfile();
    loadjscssfile("/lihuaiot01/js/userjs/hischartdevice01.js", "js");
</script>

