<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>
    .btnwidth {
        width: 100px;
    }
</style>
<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>用户管理信息</li>
    </ol>
    <div class="panel-body">
        <div id="rolePeopletoolbar" class="btn-group">
            <button class="btn btn-default btnwidth" onclick="rolePeopleShowAdd()">新增</button>
        </div>
        <div class="container col-md-11">
            <table class="table table-striped" id="rolePeopleTable" align="center"
                   striped="true" data-click-to-select="true"
                   data-toolbar="#rolePeopletoolbar"<%--设置装按钮的容器为id为toolbar--%>
                   data-pagination="true"<%--设置是否显示页码数--%>
                   data-show-refresh="true" <%--设置刷新按钮--%>
                   data-showColumns="true">
            </table>
        </div>
    </div>
</div>

<div class="delete-popup" id="rolePeopleaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="addNew-title">授权用户</h3>
            <button class="close" id="rolePeopleaddNew-close">&times;</button>
        </div>
        <div class="rolePeopleaddNew-content">
            <%--   <form action="" method="post">--%>
            <div class="rolePeopleform-name">
                <label class="col-md-2" for="rolePeoplePeopleName">用户名</label>
                <%--<input type="text" class="form-control" id="rolePeoplePeopleName"/>--%>
                <div class="col-md-8 input-group">
                    <input type="text" class="form-control" id="rolePeoplePeopleName"
                           style="width:240px;">
                    <div class="input-group-btn" style="width:20px;">
                        <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                    </div>
                </div>
            </div>
            <%--            <div class="form-name">
                            <label for="rolePeopleRoleName">角色名</label>
                            &lt;%&ndash;<input type="text" class="form-control" id="rolePeopleRoleName"/>&ndash;%&gt;
                            <div class="input-group">
                                <input type="text" class="form-control" id="rolePeopleRoleName"
                                       style="width:240px;margin-right:0px">
                                <div class="input-group-btn" style="width:20px;">
                                    <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                                </div>
                            </div>
                        </div>--%>
            <div class="rolePeopleform-name">
                <label class="col-md-2" for="rolePeopleRoleName_search">角色名</label>
                <%--<input type="text" class="form-control" id="rolePeopleRoleName"/>--%>
                <div class="col-md-8 input-group">
                    <select class="form-control" id="rolePeopleRoleName_search" multiple="multiple">
                    </select>
                </div>
            </div>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="addNew-save" onclick="rolePeopleSaveRolePeople()">保存</button>
            <button class="btn btn-default" id="rolePeopleaddNew-cancel">取消</button>
        </div>
    </div>
</div>

<!-- 信息删除确认 -->
<div class="modal fade" id="rolePeopledelcfmModel">
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
                <a onclick="rolePeopleDeletePeopleRole()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/rolecombinepeople.js", "js");
</script>
