<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>

    .btnwidth {
        width: 100px;
    }
</style>
<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>角色管理信息</li>
    </ol>
    <div class="panel-body">
        <div id="roletoolbar" class="btn-group">
            <button class="btn btn-default btnwidth" onclick="roleShowAdd()">新增</button>
        </div>
        <div class="container col-md-11">
            <table class="table table-striped" id="roleTable" align="center"
                   striped="true" data-click-to-select="true"
                   data-toolbar="#roletoolbar"<%--设置装按钮的容器为id为toolbar--%>
                   data-pagination="true"<%--设置是否显示页码数--%>
                   data-showColumns="true">
            </table>
        </div>
    </div>
</div>

<div class="delete-popup" id="roleaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="addNew-title">授权角色</h3>
            <button class="close" id="addNew-close">&times;</button>
        </div>
        <div class="addNew-content">
            <%--   <form action="" method="post">--%>
            <div class="form-name">
                <div class="row">
                    <label for="roleName" style="margin-left: 17px;margin-top: 26px">角色名称</label>
                    <div class="input-group" style="width:240px;margin-left: 50px;margin-top: -30px">
                        <input type="text" class="form-control" id="roleName"
                               style="width:240px;margin-right:0px">
                        <div class="input-group-btn" style="width:1px;">
                            <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-org">

            </div>
            <%--  </form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="addNew-save" onclick="roleUpdateRoleDevice()">保存</button>
            <button class="btn btn-default" id="addNew-cancel">取消</button>
        </div>
    </div>
</div>

<!-- 信息删除确认 -->
<div class="modal fade" id="delcfmModel">
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
