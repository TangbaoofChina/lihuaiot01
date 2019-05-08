<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>

    .btnwidth {
        width: 100px;
    }
</style>
<div class="panel panel-default">
<%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>角色管理信息</li>
    </ol>--%>
    <div class="panel-body">
        <div id="roletoolbar" class="btn-group">
            <button class="btn btn-default btnwidth" onclick="roleShowAdd()">新增</button>
        </div>
        <div class="container col-md-11">
            <table id="roleTable">
            </table>
<%--            <table class="table table-striped" id="roleTable" align="center"
                   striped="true" data-click-to-select="true"
                   data-toolbar="#roletoolbar"&lt;%&ndash;设置装按钮的容器为id为toolbar&ndash;%&gt;
                   data-show-refresh="true" &lt;%&ndash;设置刷新按钮&ndash;%&gt;>
            </table>--%>
        </div>
    </div>
</div>

<div class="delete-popup" id="roleModify-popup">
    <div class="roleModify-wrap">
        <div class="delete-point">
            <h3 id="roleModify-title">授权角色</h3>
            <button class="close" id="roleModify-close">&times;</button>
        </div>
        <div class="roleModify-content">
            <%--   <form action="" method="post">--%>
            <div class="roleform-name">
                <div class="row" style="margin-top: 10px;margin-left: 0px;">
                    <label class="col-md-1" for="roleModifyName">角色</label>
                    <div class="col-md-10" class="input-group" style="width:240px;">
                        <input type="text" class="form-control" id="roleModifyName"
                               style="width:240px;margin-right:0px">
                        <%-- <div class="input-group-btn" style="width:1px;">
                             <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                         </div>--%>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px;margin-left: 0px;">
                    <label class="col-md-1" for="roleModifyDescribe">描述</label>
                    <div class="col-md-10" class="input-group" style="width:240px;">
                        <input type="text" class="form-control" id="roleModifyDescribe"
                               style="width:240px;margin-right:0px">
                        <%--<div class="input-group-btn" style="width:1px;">
                            <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                        </div>--%>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px;margin-left: 0px;">
                    <label class="col-sm-1" for="roleOrgTree01">组织</label>
                    <div class="col-md-3"
                         style="width:240px;height: 150px;overflow: auto">
                        <div id="roleOrgTree01"></div>
                    </div>

                    <%--<select class="selectpicker" id="roleDeviceSelBefore" multiple="true" data-size="10"
                            style="overflow: auto;height: 100px;">--%>
                    <select class="col-md-3" id="roleDeviceSelBefore" size="10" multiple="multiple"
                            style="overflow: auto;">
                    </select>
                    <div class="col-md-1" style="text-align: center;">
                        <div class="row">
                            <button class="btn btn-default" style="width: 42px;" type="button"
                                    onclick="roleOneDeviceToRight()"> >
                            </button>
                        </div>
                        <div class="row" style="height: 10px;">
                        </div>
                        <div class="row">
                            <button class="btn btn-default" style="width: 42px;" type="button"
                                    onclick="roleAllDeviceToRight()"> >>
                            </button>
                        </div>
                        <div class="row" style="height: 10px;">
                        </div>
                        <div class="row">
                            <button class="btn btn-default" style="width: 42px;" type="button"
                                    onclick="roleOneDeviceToLeft()"> <
                            </button>
                        </div>
                        <div class="row" style="height: 10px;">
                        </div>
                        <div class="row">
                            <button class="btn btn-default" style="width: 42px;" type="button"
                                    onclick="roleAllDeviceToLeft()"> <<
                            </button>
                        </div>
                    </div>
                    <%--<button class="btn" style="height: 20px;width: 20px;">></button>--%>
                    <%--<select class="selectpicker" name="list02" multiple="true" size="10" style="overflow: auto;">--%>
                    <select class="col-md-3" id="roleDeviceSelEnd" size="10" multiple="multiple"
                            style="overflow: auto;">
                    </select>
                </div>
            </div>
            <%--  </form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="roleModify-save" onclick="roleUpdateRoleDevice()">保存</button>
            <button class="btn btn-default" id="roleModify-cancel">取消</button>
        </div>
    </div>
</div>

<div class="delete-popup" id="roleaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="addNew-title">授权角色</h3>
            <button class="close" id="roleaddNew-close">&times;</button>
        </div>
        <div class="addNew-content">
            <%--   <form action="" method="post">--%>
            <div class="form-num">
                <label for="roleNewName">角色</label>
                <input type="text" class="form-control" id="roleNewName"/>
            </div>
            <div class="form-name">
                <label for="roleNewDescribe">描述</label>
                <input type="text" class="form-control" id="roleNewDescribe"/>
            </div>
            <div class="form-name">
                <label for="roleAdminType">类型</label>
                <select name="roleAdminType" id="roleAdminType" class="input-sm">
                    <shiro:hasAnyRoles name="admin,111">
                        <option value="111" selected="selected">种禽环控器</option>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin,211">
                        <option value="211">立华禽环保1.0</option>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin,212">
                        <option value="212">立华禽环保2.0</option>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin,213">
                        <option value="213">立华水质</option>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin,311">
                        <option value="311">自动称重</option>
                    </shiro:hasAnyRoles>
                    <shiro:hasAnyRoles name="admin">
                        <option value="admin">管理员</option>
                    </shiro:hasAnyRoles>
                </select>
            </div>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="addNew-save" onclick="roleInsertRoleInfo()">保存</button>
            <button class="btn btn-default" id="roleaddNew-cancel">取消</button>
        </div>
    </div>
</div>

<!-- 信息删除确认 -->
<div class="modal fade" id="roledelcfmModel">
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
                <a onclick="roleDeleteRole()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/rolecombinedevice.js", "js");
</script>
