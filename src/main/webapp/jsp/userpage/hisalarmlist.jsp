<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <div class="panel-body">
        <div class="btn-group" id="hatoolbar">
            <div class="form-inline">
                <label>时间：</label>
                <div class="btn-group">
                    <input type="text" id="haDateInterval" class="form-control" style="width: 320px;">
                </div>
                <div class="input-group">
                    <label>参数：</label>
                    <select name="haSelName_Param" id="haSelId_Param" class="input-sm">
                        <option value="0" selected="selected">全部</option>
                        <option value="1">报警</option>
                        <option value="2">离线</option>
                        <%--<option value="3">错误</option>--%>
                    </select>
                </div>
                <button class="btn btn-default" id="haQuery_storage">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                </button>
                <button class="btn btn-default" id="haExport_storage">
                    <span class="glyphicon glyphicon-export" aria-hidden="true"></span>导出
                </button>
            </div>
        </div>
        <div class="container col-md-11">
            <table id="haDeviceList">
            </table>
        </div>
        <%--</div>--%>
    </div>
</div>

<!-- 导出设备信息模态框 -->
<div class="modal fade" id="haExport_modal" table-index="-1" role="dialog"
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
                <button class="btn btn-success" type="button" id="haExport_storage_download">
                    <span>确认下载</span>
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    loadjscssfile("/lihuaiot01/js/userjs/hisalarmlist.js", "js");
</script>
