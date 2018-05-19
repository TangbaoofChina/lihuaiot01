<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>

    .btnwidth {
        width: 100px;
    }
</style>
<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>设备代码信息</li>
    </ol>
    <div class="panel-body">
        <div id="dctoolbar" class="form-inline">
            <div class="input-group">
                <label>类型：</label>
                <select name="dcDeviceType" id="dcDeviceType" class="input-sm">
                    <shiro:hasAnyRoles name="admin,111">
                        <option value="111" selected="selected">鸡舍环控器</option>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin,211">
                        <option value="211">污水控制器</option>
                    </shiro:hasAnyRoles>
                </select>
            </div>
            <div class="input-group">
                <label>消息：</label>
                <select name="dcDeviceMessage" id="dcDeviceMessage" class="input-sm">
                    <option value="01" selected="selected">报警</option>
                    <option value="02">错误</option>
                </select>
            </div>
            <button class="btn btn-default btnwidth" onclick="dcSearch()">查询</button>
            <button class="btn btn-default btnwidth" onclick="dcShowAdd()">新增</button>
            <button class="btn btn-default btnwidth" style="display: none" onclick="dcAddDeviceType()">新增类型</button>
        </div>
        <div class="container col-md-11">
            <table class="table table-striped" id="dcTable" align="center"
                   striped="true" data-click-to-select="true"
                   data-toolbar="#dctoolbar"<%--设置装按钮的容器为id为toolbar--%>
                   data-pagination="true"<%--设置是否显示页码数--%>
                   data-show-refresh="true" <%--设置刷新按钮--%>
                   data-showColumns="true">
            </table>
        </div>
    </div>
</div>

<div class="delete-popup" id="dcModify-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="dcModify-title">代码定义</h3>
            <button class="close" id="dcModify-close">&times;</button>
        </div>
        <div class="addNew-content">
            <%--   <form action="" method="post">--%>
            <div class="form-num input-group" disabled="false">
                <label>类型：</label>
                <select name="dcDeviceTypeNew" id="dcDeviceTypeUpdate" class="input-sm">
                    <option value="111">纳捷环控器</option>
                    <option value="211">污水环控器</option>
                </select>
            </div>
            <div class="form-num input-group" disabled="false">
                <label>消息：</label>
                <select name="dcDeviceMessageNew" id="dcDeviceMessageUpdate" class="input-sm">
                    <option value="01">报警</option>
                    <option value="02">错误</option>
                </select>
            </div>
            <div class="form-num">
                <label for="dcModifyCode">代码</label>
                <input type="text" class="form-control" id="dcModifyCode">
            </div>
            <div class="form-num">
                <label for="dcModifyDescribe">描述</label>
                <input type="text" class="form-control" id="dcModifyDescribe">
            </div>
            <%--  </form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="dcModify-save" onclick="dcUpdateDeviceCode()">保存</button>
            <button class="btn btn-default" id="dcModify-cancel">取消</button>
        </div>
    </div>
</div>

<div class="delete-popup" id="dcaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="addNew-title">代码定义</h3>
            <button class="close" id="dcaddNew-close">&times;</button>
        </div>
        <div class="addNew-content">
            <%--   <form action="" method="post">--%>
            <div class="form-num input-group">
                <label>类型：</label>
                <select name="dcDeviceTypeNew" id="dcDeviceTypeNew" class="input-sm">
                    <option value="111">纳捷环控器</option>
                    <option value="211">污水环控器</option>
                </select>
            </div>
            <div class="form-num input-group">
                <label>消息：</label>
                <select name="dcDeviceMessageNew" id="dcDeviceMessageNew" class="input-sm">
                    <option value="01">报警</option>
                    <option value="02">错误</option>
                </select>
            </div>
            <div class="form-num">
                <label for="dcNewCode">代码</label>
                <input type="text" class="form-control" id="dcNewCode"/>
            </div>
            <div class="form-name">
                <label for="dcNewDescribe">描述</label>
                <input type="text" class="form-control" id="dcNewDescribe"/>
            </div>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="addNew-save" onclick="dcInsertDeviceCode()">保存</button>
            <button class="btn btn-default" id="dcaddNew-cancel">取消</button>
        </div>
    </div>
</div>

<!-- 信息删除确认 -->
<div class="modal fade" id="dcdelcfmModel">
    <div class="modal-dialog">
        <div class="modal-content message_align">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">×</span></button>
                <h4 class="modal-title">提示信息</h4>
            </div>
            <div class="modal-body">
                <p>您确认要删除吗？</p>
            </div>
            <div class="modal-footer">
                <input type="hidden" id="url"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <a onclick="dcDeleteDeviceCode()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/devicecode.js", "js");
</script>
