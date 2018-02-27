<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<style>
    .pull-right.pagination-detail{
        display:none;
    }
</style>
<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>登陆日志信息</li>
    </ol>
    <div class="panel-body">
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height: 410px;overflow: auto">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;" id="lrTxtSearchTreeNode">
                <button class="btn btn-default" onclick="lrSearchTreeNode()">搜索</button>
            </div>
            <div id="lrTree" style="margin-right: 12px;margin-top: 5px;"></div>
        </div>
        <div class="columns-right">
            <div class="col-md-2">
                <label>用户：</label>
                <select id="lrPeopleSelect" style="height: 380px;width: 160px;overflow: auto;" multiple="multiple">
                </select>
            </div>
            <div id="toolbar" class="btn-group">
                <div class="form-inline">
                    <label>时间：</label>
                    <div class="btn-group">
                        <input type="text" id="lrDateInterval" class="form-control" style="width: 320px;">
                    </div>
                    <button class="btn btn-default" id="lrQuery_storage">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                </div>
            </div>
            <div class="col-md-7 col-sm-6" >
                <table class="table table-striped" id="lrDeviceList" align="center"
                       striped="true" data-click-to-select="true"
                       data-toolbar="#toolbar"<%--设置装按钮的容器为id为toolbar--%>
                       data-pagination="true"<%--设置是否显示页码数--%>
                       data-showColumns="true">
                </table>
            </div>
        </div>
    </div>
</div>

<script>
/*    removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/systemjs/loginrecord.js", "js");
</script>

