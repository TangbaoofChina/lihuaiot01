<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="panel panel-default">
<%--<div class="tab-pane">--%>
<%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>历史数据信息</li>
    </ol>--%>
    <div class="panel-body">
        <%--        <div class="columns-left">
                    <div class="zTreeDemoBackground left col-md-2" style="width:230px;height: 410px;overflow: scroll">
                        <div>
                            <input class="text-input" type="text" style="width:120px;" id="txtSearchTreeNode">
                            <button class="btn btn-default" onclick="hisSearchTreeNode()">搜索</button>
                        </div>
                        <ul id="tree" class="ztree"></ul>
                    </div>
                </div>--%>
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="hisTxtSearchTreeNode">
                <button class="btn btn-default" onclick="hisSearchTreeNode()">搜索</button>
            </div>
            <div id="hisOrgTree" style="margin-top: 5px;"></div>
        </div>
        <div class="columns-right" id="hisDeviceListDiv" style="display: block">
            <div id="histoolbar" class="btn-group">
                <%--<button class="btn btn-default" style="width: 61px;height: 30px" id="refresh_button"
                        onclick="tableRefresh()">
                    <span class="glyphicon glyphicon-refresh"></span> <span>刷新</span>
                </button>--%>
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisDateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisQuery_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisExport_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisDeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#histoolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>

        </div>
    </div>
</div>

<!-- 导出设备信息模态框 -->
<div class="modal fade" id="hisExport_modal" table-index="-1" role="dialog"
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
                <button class="btn btn-success" type="button" id="hisExport_storage_download">
                    <span>确认下载</span>
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    //removealljsfile();
    loadjscssfile("/lihuaiot01/js/userjs/hisdevicelist.js", "js");
</script>
