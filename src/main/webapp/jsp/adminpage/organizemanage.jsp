<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<style>

    .btnwidth {
        width: 100px;
    }
</style>
<div class="panel panel-default">
    <ol class="breadcrumb" style="margin-bottom: 0px;">
        <li>部门管理信息</li>
    </ol>
    <div class="panel-body">
<%--        <div class="columns-left">
            <div class="zTreeDemoBackground left col-md-2" style="width:230px;height: 410px;overflow: scroll">
                <div>
                    <input class="text-input" type="text" style="width:120px;" id="orgtxtSearchTreeNode">
                    <button class="btn btn-default" onclick="orgsearchTreeNode()">搜索</button>
                </div>
                <ul id="orgtree" class="ztree"></ul>
            </div>
        </div>--%>
        <div class="columns-left col-md-2" style="margin-left:-15px;width:230px;height:410px;overflow: auto">
            <div class="input-group">
                <input class="text-input" type="text" style="width:120px;margin-right: 2px;"
                       id="orgTxtSearchTreeNode">
                <button class="btn btn-default" onclick="orgSearchTreeNode()">搜索</button>
            </div>
            <div id="orgTree" style="margin-top: 5px;"></div>
        </div>
        <div class="columns-right">
            <div class="container col-md-9">

                <div class=" form-inline">
                    <label>父节点：</label>
                    <div class="input-group">
                        <input type="text" id="orginputFatherId" style="display: none">
                        <input type="text" class="form-control" name="orginputFather" id="orginputFather"
                               placeholder="请选择父节点">
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-default btnwidth" onclick="orgremoveSelectNode()">删除节点</button>
                        <button class="btn btn-default btnwidth" onclick="orgrenameSelectNode()">重命名节点</button>
                    </div>
                </div>
                <div class=" form-inline" style="margin-top: 10px;">
                    <label>子节点：</label>
                    <div class="input-group">
                        <input type="text" name="orginputSon" class="form-control" id="orginputSon"
                               placeholder="请输入子节点">
                    </div>
                    <div class="btn-group">
                        <button class="btn btn-default btnwidth" name="btnwidth" onclick="orgaddNewChildNode()">新增子节点
                        </button>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    /*removealljsfile();*/
    loadjscssfile("/lihuaiot01/js/adminjs/organizemanage.js", "js");
</script>
