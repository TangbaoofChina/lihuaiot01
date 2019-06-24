<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="panel panel-default">
<%--    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>设备管理信息</li>
    </ol>--%>
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
<div class="delete-popup" id="deviceOrgaddNew-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="deviceOrgaddNew-title">转移设备</h3>
            <button class="close" id="deviceOrgaddNew-close">&times;</button>
        </div>
        <div class="addNew-content deviceOrgAddNew-Content">
            <%--<form action="" method="post">--%>
            <div class="form-org">
                <div class="row">
                    <label for="deviceOrgTree01" style="margin-left: 17px;margin-top: 26px">组织</label>
                    <div style="margin-top: -30px;margin-left:70px;width:240px;height: 150px;overflow: auto">
                        <div id="deviceOrgTree01"></div>
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
            <div class="form-org">
                <div class="row">
                    <label for="deviceOrgTree02" style="margin-left: 17px;margin-top: 26px">组织</label>
                    <div style="margin-top: -30px;margin-left:70px;width:240px;height: 250px;overflow: auto">
                        <div id="deviceOrgTree02"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="deviceOrgaddNew-save02" onclick="deviceOrgUpdateDeviceOrg02()">保存
            </button>
            <button class="btn btn-default" id="deviceOrgaddNew-cancel02">取消</button>
        </div>
    </div>
</div>
<%--修改设备信息--%>
<div class="delete-popup" id="deviceOrgModify-popup">
    <div class="addNew-wrap">
        <div class="delete-point">
            <h3 id="deviceOrgModify-title">修改设备</h3>
            <button class="close" id="deviceOrgModify-close">&times;</button>
        </div>
        <div class="addNew-content deviceOrgModify-Content">
            <%--<form action="" method="post">--%>
            <div class="form-num" style="display:none">
                <label for="deviceOrgNum">序号</label>
                <input type="text" class="input-sm" disabled="true" name="deviceOrgNum" id="deviceOrgNum"/>
            </div>
            <div class="form-num">
                <label for="deviceOrgNumDec">序号</label>
                <input type="text" class="input-sm" disabled="true" name="deviceOrgNumDec" id="deviceOrgNumDec"/>
            </div>
            <div class="form-name">
                <label for="deviceOrgName">名称</label>
                <input type="text" class="input-sm" name="deviceOrgName" id="deviceOrgName"/>
            </div>
            <div class="form-name form-inline">
                <label for="deviceOrgEasRoom">舍号</label>
                <div class="input-group">
                    <input type="text" class="input-sm" name="deviceOrgEasRoom" id="deviceOrgEasRoom">
                    <div class="input-group-btn" style="width:20px;">
                        <ul class="dropdown-menu dropdown-menu-right" role="menu"></ul>
                    </div>
                </div>
                <button class="btn btn-default" id="btnDeviceOrgEasRoomClear"  onclick="deviceOrgBtnClearEasRoom()">清空</button>
            </div>
            <div class="form-name form-inline">
                <label for="deviceOrgDeviceDisabled">停用</label>
                <div class="col-md-4 input-group">
                    <input type="checkbox" id="deviceOrgDeviceDisabled"
                           style="width: 18px;height: 18px;"/>
                </div>
            </div>
            <%--</form>--%>
        </div>
        <div class="delete-btn">
            <button class="btn btn-danger" id="deviceOrgModify-save" onclick="deviceOrgUpdateDeviceOrg03()">保存</button>
            <button class="btn btn-default" id="deviceOrgModify-cancel">取消</button>
        </div>
    </div>
</div>

<!-- 信息清空确认 -->
<div class="modal fade" id="deviceOrgdelcfmModel">
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
                <a onclick="deviceOrgClearEasRoom()" class="btn btn-success" data-dismiss="modal">确定</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/devicecombineorg.js", "js");
</script>
