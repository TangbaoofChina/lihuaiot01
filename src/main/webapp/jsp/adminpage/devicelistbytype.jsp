<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>设备清单信息</li>
    </ol>
    <div class="panel-body">
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto">
            <div id="dlbtTree" style="margin-top: 5px;"></div>
        </div>
        <div class="columns-right">
            <div id="dlbttoolbar" class="btn-group">
                <button class="btn btn-default" id="dlbtExport_storage">
                    <span class="glyphicon glyphicon-export"></span> <span>导出</span>
                </button>
            </div>
            <div class="container col-md-9">
                <table class="table table-striped" id="dlbtTable" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#dlbttoolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
    </div>
</div>

<!-- 导出设备信息模态框 -->
<div class="modal fade" id="dlbtExport_modal" table-index="-1" role="dialog"
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
                <button class="btn btn-success" type="button" id="dlbtExport_storage_download">
                    <span>确认下载</span>
                </button>
            </div>
        </div>
    </div>
</div>

<!-- /.modal -->
<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/devicelistbytype.js", "js");
</script>
