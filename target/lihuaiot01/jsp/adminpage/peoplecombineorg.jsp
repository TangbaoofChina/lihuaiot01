<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>

    .btnwidth {
        width: 100px;
    }
</style>
<div class="panel panel-default">
<%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>人员管理信息</li>
    </ol>--%>
    <div class="panel-body">
<%--        <div class="columns-left">
            <div class="zTreeDemoBackground left col-md-2" style="width:230px;height: 410px;overflow: scroll">
                <div>
                    <input class="text-input" type="text" style="width:120px;" id="peopleOrgTxtSearchTreeNode">
                    <button class="btn btn-default" onclick="peopleOrgSearchTreeNode()">搜索</button>
                </div>
                <ul id="peopleOrgTree" class="ztree"></ul>
            </div>
        </div>--%>
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="peopleOrgTxtSearchTreeNode">
                <button class="btn btn-default" onclick="peopleOrgSearchTreeNode()">搜索</button>
            </div>
            <div id="peopleOrgTree" style="margin-top: 5px;"></div>
        </div>
        <div class="columns-right">
            <div id="peopleOrgtoolbar" class="btn-group">
                <button class="btn btn-default btnwidth" onclick="peopleOrgShowAdd()">新增</button>
            </div>
            <div class="container col-md-9">
                <table class="table table-striped" id="peopleOrgTable" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#peopleOrgtoolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
    </div>
</div>
<%--转移设备--%>
<!--新增页面-->
<%--<div class="delete-popup" id="addNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="addNew-title">授权人员</h3>
            <button class="close" id="addNew-close">&times;</button>
        </div>
        <div class="addNew-content">
            <form action="" method="post">
                <div class="form-name">
                    <div class="row">
                        <label for="peopleOrgPeople" style="margin-left: 17px;margin-top: 26px">人员</label>
                        <div class="input-group" style="width:240px;margin-left: 50px;margin-top: -30px">
                            <input type="text" class="form-control" id="peopleOrgPeople"
                                   style="width:240px;margin-right:0px">
                            <div class="input-group-btn" style="width:1px;">
                                <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-org">
                    <div class="row">
                        <label for="peopleOrgOrg" style="margin-left: 17px;margin-top: 26px">组织</label>
                        <div class="input-group" style="width:240px;margin-left: 50px;margin-top: -30px">
                            <input type="text" class="form-control" id="peopleOrgOrg"
                                   style="width:240px;margin-right:0px">
                            <div class="input-group-btn" style="width:1px;">
                                <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="addNew-save" onclick="peopleOrgUpdatePeopleOrg()">保存</button>
            <button class="btn btn-default" id="addNew-cancel">取消</button>
        </div>
    </div>
</div>--%>

<div class="delete-popup" id="peopleOrgaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="addNew-title">授权人员</h3>
            <button class="close" id="peopleOrgaddNew-close">&times;</button>
        </div>
        <div class="addNew-content">
         <%--   <form action="" method="post">--%>
                <div class="form-name">
                    <div class="row">
                        <label for="peopleOrgPeople" style="margin-left: 17px;margin-top: 26px">人员</label>
                        <div class="input-group" style="width:240px;margin-left: 50px;margin-top: -30px">
                            <input type="text" class="form-control" id="peopleOrgPeople"
                                   style="width:240px;margin-right:0px">
                            <div class="input-group-btn" style="width:1px;">
                                <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-org">
                    <div class="row">
                        <label for="peopleOrgTree01" style="margin-left: 17px;margin-top: 26px">组织</label>
                        <div style="margin-top: -30px;margin-left:70px;width:240px;height: 150px;overflow: auto">
                            <div id="peopleOrgTree01" ></div>
                        </div>
                    </div>
                </div>
          <%--  </form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="addNew-save" onclick="peopleOrgUpdatePeopleOrg()">保存</button>
            <button class="btn btn-default" id="peopleOrgaddNew-cancel">取消</button>
        </div>
    </div>
</div>

<!-- 信息删除确认 -->
<div class="modal fade" id="peopleOrgdelcfmModel">
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
                <a onclick="peopleOrgDeletePeople()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/peoplecombineorg.js", "js");
</script>
