<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="panel panel-default">
    <div class="panel-body">
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="hisTxtSearchTreeNode">
                <button class="btn btn-default" onclick="hisSearchTreeNode()">搜索</button>
            </div>
            <div id="hisOrgTree" style="white-space: nowrap;margin-top: 5px;"></div>
        </div>
        <div class="columns-right" id="hisEC01DeviceListDiv" style="white-space: nowrap;display: block">
            <div id="hisEC01toolbar" class="btn-group">
                <%--<button class="btn btn-default" style="width: 61px;height: 30px" id="refresh_button"
                        onclick="tableRefresh()">
                    <span class="glyphicon glyphicon-refresh"></span> <span>刷新</span>
                </button>--%>
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisEC01DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisEC01Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisEC01Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisEC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisEC01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>

        </div>
        <div class="columns-right" id="hisSewageC01DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisSewageC01toolbar" class="btn-group">
                <%--<button class="btn btn-default" style="width: 61px;height: 30px" id="refresh_button"
                        onclick="tableRefresh()">
                    <span class="glyphicon glyphicon-refresh"></span> <span>刷新</span>
                </button>--%>
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisSewageC01DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisSewageC01Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisSewageC01Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisSewageC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisSewageC01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisSewageC212DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisSewageC212toolbar" class="btn-group">
                <%--<button class="btn btn-default" style="width: 61px;height: 30px" id="refresh_button"
                        onclick="tableRefresh()">
                    <span class="glyphicon glyphicon-refresh"></span> <span>刷新</span>
                </button>--%>
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisSewageC212DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisSewageC212Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisSewageC212Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisSewageC212DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisSewageC212toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisSewageC214DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisSewageC214toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisSewageC214DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisSewageC214Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisSewageC214Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisSewageC214DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisSewageC214toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisSewageC215DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisSewageC215toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisSewageC215DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisSewageC215Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisSewageC215Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisSewageC215DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisSewageC215toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisScaleC01DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisScaleC01toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisScaleC01DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisScaleC01Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisScaleC01Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisScaleC01DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisScaleC01toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>

        </div>
        <div class="columns-right" id="hisHj212C213DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisHj212C213toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisHj212C213DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisHj212C213Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisHj212C213Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisHj212C213DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisHj212C213toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>

        </div>

        <div class="columns-right" id="hisWeighC312DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisWeighC312toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisWeighC312DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisWeighC312Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisWeighC312Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisWeighC312DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisWeighC312toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
        <div class="columns-right" id="hisFeedC411DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisFeedC411toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisFeedC411DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisFeedC411Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisFeedC411Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisFeedC411DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisFeedC411toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
        <div class="columns-right" id="hisLhfh05p1DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisLhfh05p1toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisLhfh05p1DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisLhfh05p1Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisLhfh05p1Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisLhfh05p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisLhfh05p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisLhsp05p1DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisLhsp05p1toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisLhsp05p1DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisLhsp05p1Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisLhsp05p1Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisLhsp05p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisLhsp05p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisLhsf0ap1DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisLhsf0ap1toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisLhsf0ap1DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisLhsf0ap1Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisLhsf0ap1Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisLhsf0ap1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisLhsf0ap1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisLhrz01p1DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisLhrz01p1toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisLhrz01p1DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisLhrz01p1Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisLhrz01p1Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisLhrz01p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisLhrz01p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-show-refresh="true" <%--设置刷新按钮--%>
                       data-show-toggle="true" <%--设置数据显示格式--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>

        <div class="columns-right" id="hisLhty02p1DeviceListDiv" style="white-space: nowrap;display: none">
            <div id="hisLhty02p1toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="hisLhty02p1DateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="hisLhty02p1Query_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                    <button class="btn btn-default" id="hisLhty02p1Export_storage">
                        <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                    </button>
                </div>
            </div>

            <div class="col-md-9 col-sm-8">
                <table class="table table-striped" id="hisLhty02p1DeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#hisLhty02p1toolbar"<%--设置装按钮的容器为id为toolbar--%>
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
