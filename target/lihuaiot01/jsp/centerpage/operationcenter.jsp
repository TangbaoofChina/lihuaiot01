<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<style type="text/css">
    #centerBaiDuMap {
        width: 100%;
        height: 400px;
        overflow: hidden;
        margin: 0;
        font-family: "微软雅黑";
    }
</style>

<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>运营中心信息</li>
    </ol>
    <div class="panel-body">
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height: 410px;overflow: scroll">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="centerTxtSearchTreeNode">
                <button class="btn btn-default" onclick="centerSearchTreeNode()">搜索</button>
            </div>
            <div id="centerOrgTree" style="margin-right: 12px;margin-top: 5px;"></div>
        </div>
        <div class="columns-right">
            <div class="col-md-9 col-sm-8" >
                <div id="centerBaiDuMap"></div>
            </div>
        </div>
    </div>
</div>

<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/centerjs/operationcenter.js", "js");
</script>
