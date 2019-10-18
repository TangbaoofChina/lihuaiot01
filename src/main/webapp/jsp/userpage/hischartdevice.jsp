<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--本页面停用--%>
<div class="panel panel-default" style="height:100%;width:100%;">
    <%--<div class="tab-pane">--%>
    <%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
            <li>历史曲线信息</li>
        </ol>--%>
    <div class="panel-body" style="height:100%;width:100%;">
        <div class="form-inline">
            <div class="input-group">
                <label>设备：</label>
                <select class="form-control" id="hisChartsel_search" multiple="multiple">
                </select>
            </div>
            <div class="input-group">
                <label>参数：</label>
                <select name="hisChartSelName_Param" id="hisChartSelId_Param" class="input-sm">
                    <option value="0" selected="selected">舍内</option>
                    <option value="1">舍前</option>
                    <option value="2">舍中</option>
                    <option value="3">舍后</option>
                    <option value="4">舍外</option>
                    <option value="5">饮水量</option>
                    <option value="6">日饮水量</option>
                    <option value="7">水温</option>
                </select>
            </div>
            <label>时间：</label>
            <div class="btn-group">
                <input type="text" id="hisChartDateInterval" class="form-control" style="width: 320px;">
            </div>
            <button class="btn btn-default" id="hisChartQuery_storage">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
            </button>
        </div>

        <div class="col-md-11 col-sm-10" style="height:100%;width:100%;">
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

<script>
    //removealljsfile();
    loadjscssfile("/lihuaiot01/js/userjs/hischartdevice.js", "js");
</script>

