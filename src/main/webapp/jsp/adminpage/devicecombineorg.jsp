<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>设备管理信息</li>
    </ol>
    <div class="panel-body">
<%--        <div class="columns-left">
            <div class="zTreeDemoBackground left col-md-2" style="width:230px;height: 410px;overflow: scroll">
                <div>
                    <input class="text-input" type="text" style="width:120px;" id="deviceOrgTxtSearchTreeNode">
                    <button class="btn btn-default" onclick="deviceOrgSearchTreeNode()">搜索</button>
                </div>
                <ul id="deviceOrgTree" class="ztree"></ul>
            </div>
        </div>--%>
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="deviceOrgTxtSearchTreeNode">
                <button class="btn btn-default" onclick="deviceOrgSearchTreeNode()">搜索</button>
            </div>
            <div id="deviceOrgTree" style="margin-top: 5px;"></div>
        </div>
        <div class="columns-right">
            <div id="deviceOrgtoolbar" class="btn-group">
                <button class="btn btn-default btnwidth" onclick="deviceOrgBatchTransfer()">批量转移</button>
            </div>
            <div class="container col-md-9">
                <table class="table table-striped" id="deviceOrgTable" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#deviceOrgtoolbar"<%--设置装按钮的容器为id为toolbar--%>
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
            <h3 id="addNew-title">转移设备</h3>
            <button class="close" id="addNew-close">&times;</button>
        </div>
        <div class="addNew-content">
            <form action="" method="post">
                <div class="form-num">
                    <label for="deviceOrgNum">序号</label>
                    <input type="text" class="input-sm" disabled="true" name="deviceOrgNum" id="deviceOrgNum"/>
                </div>
                <div class="form-name">
                    <label for="deviceOrgName">名称</label>
                    <input type="text" class="input-sm" name="deviceOrgName" id="deviceOrgName"/>
                </div>
                <div class="form-org">
                    <div class="row">
                        <label for="deviceOrgOrg" style="margin-left: 17px;margin-top: 26px">组织</label>
                        <div class="input-group" style="width:240px;margin-left: 50px;margin-top: -30px">
                            <input type="text" class="form-control" id="deviceOrgOrg"
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
            <button class="btn btn-danger" id="addNew-save" onclick="deviceOrgUpdateDeviceOrg()">保存</button>
            <button class="btn btn-default" id="addNew-cancel">取消</button>
        </div>
    </div>
</div>--%>

<div class="delete-popup" id="deviceOrgaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="deviceOrgaddNew-title">转移设备</h3>
            <button class="close" id="deviceOrgaddNew-close">&times;</button>
        </div>
        <div class="addNew-content">
            <%--<form action="" method="post">--%>
                <div class="form-num">
                    <label for="deviceOrgNum">序号</label>
                    <input type="text" class="input-sm" disabled="true" name="deviceOrgNum" id="deviceOrgNum"/>
                </div>
                <div class="form-name">
                    <label for="deviceOrgName">名称</label>
                    <input type="text" class="input-sm" name="deviceOrgName" id="deviceOrgName"/>
                </div>
                <div class="form-org">
                    <div class="row">
                        <label for="deviceOrgTree01" style="margin-left: 17px;margin-top: 26px">组织</label>
                        <div style="margin-top: -30px;margin-left:70px;width:240px;height: 150px;overflow: auto">
                            <div id="deviceOrgTree01" ></div>
                        </div>
                    </div>
                </div>
            <%--</form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="deviceOrgaddNew-save" onclick="deviceOrgUpdateDeviceOrg()">保存</button>
            <button class="btn btn-default" id="deviceOrgaddNew-cancel">取消</button>
        </div>
    </div>
</div>

<div class="delete-popup" id="deviceOrgaddNew-popup02">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="deviceOrgaddNew-title02">转移设备</h3>
            <button class="close" id="deviceOrgaddNew-close02">&times;</button>
        </div>
        <div class="addNew-content">
            <%--<form action="" method="post">--%>
                <div class="form-org">
                    <div class="row">
                        <label for="deviceOrgTree02" style="margin-left: 17px;margin-top: 26px">组织</label>
                        <div style="margin-top: -30px;margin-left:70px;width:240px;height: 250px;overflow: auto">
                            <div id="deviceOrgTree02" ></div>
                        </div>
                    </div>
                </div>
            <%--</form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="deviceOrgaddNew-save02" onclick="deviceOrgUpdateDeviceOrg02()">保存</button>
            <button class="btn btn-default" id="deviceOrgaddNew-cancel02">取消</button>
        </div>
    </div>
</div>

<!-- /.modal -->
<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/devicecombineorg.js", "js");
</script>
