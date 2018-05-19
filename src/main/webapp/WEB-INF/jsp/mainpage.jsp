<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" type="image/x-icon" href="/lihuaiot01/images/lihuaiotweb01.ico"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>立华牧业物联网管理系统</title>
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap-table.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap-treeview.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap-multiselect.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap-tab.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/select2/css/select2.css">
    <%--    <link rel="stylesheet" type="text/css"
              href="/lihuaiot01/bootstrap/bootstrap-select/css/bootstrap-select.min.css">--%>
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/jquery-ui.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/jquery.mloading.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/mainPage.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bidType.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/daterangepicker.css">
    <link rel="shortcut icon" href="/lihuaiot01/images/lihuaiotweb01.ico"/>

</head>
<body>

<!-- 导航栏 -->
<div id="navBar">
    <!-- 此处加载顶部导航栏 -->
    <!-- 导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <!-- 导航栏标题 -->
            <div class="navbar-header">
                <a href="javascript:void(0)" class="navbar-brand home">立华牧业物联网管理系统</a>
            </div>

            <!-- 导航栏下拉菜单；用户信息与注销登陆 -->
            <div>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle"
                           data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span>
                            <span>欢迎&nbsp;</span><span><shiro:principal/></span>
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                            <!-分割线--->
                            <li role="presentation" class="divider"></li>
                            <li>
                                <a href="javascript:void(0)" id="signOut"> <span
                                        class="glyphicon glyphicon-off pull-right"></span> &nbsp;&nbsp;注销登录
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="nav navbar-nav navbar-right" style="position: relative;">
                <div class="realAlarmCount">
                    <label id="mainRealAlarmCountlab">0</label>
                </div>
                <a href="javascript:void(0)" id="realalarmpng" class="navbar-brand"
                   name="/lihuaiot01/jsp/userpage/realalarmlist.jsp">
                    <img alt="Brand" src="images/realalarm.png" height="25">
                </a>
            </div>
        </div>
    </nav>
</div>

<div class="container-fluid" style="padding-left: 0px;">
    <div class="row">
        <!-- 左侧导航栏 -->
        <div id="sideBar" class="col-md-2 col-sm-2">
            <!--  此处加载左侧导航栏 -->
            <!-- 左侧导航栏  -->
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a href="#collapse0" data-toggle="collapse" data-parent="#accordion"
                               class="parentMenuTitle collapseHead">运营中心</a>
                            <div class="pull-right">
                                <span class="caret"></span>
                            </div>
                        </h4>
                    </div>
                    <div id="collapse0" class="panel-collapse collapse collapseBody">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a href="javascript:void(0)" id="operationcenter" class="menu_item"
                                       name="/lihuaiot01/jsp/centerpage/operationcenter.jsp">运营中心</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a href="#collapse1" data-toggle="collapse" data-parent="#accordion"
                               class="parentMenuTitle collapseHead">设备中心</a>
                            <div class="pull-right">
                                <span class="caret"></span>
                            </div>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse collapseBody in">
                        <div class="panel-body">
                            <ul class="list-group ">
                                <%--<ul class="nav nav-tabs" id="deviceCenter">--%>
                                <li class="list-group-item">
                                    <a href="javascript:void(0);" id="devicelist" class="menu_item"
                                       name="/lihuaiot01/jsp/userpage/devicelist.jsp">设备列表</a>
                                </li>
                                <li class="list-group-item">
                                    <a href="javascript:void(0);" id="realdevicelist"
                                       class="menu_item"
                                       name="/lihuaiot01/jsp/userpage/realdevicelist.jsp">实时数据</a>
                                </li>
                                <li class="list-group-item">
                                    <a href="javascript:void(0);" id="realalarmlist"
                                       class="menu_item"
                                       name="/lihuaiot01/jsp/userpage/realalarmlist.jsp">实时报警</a>
                                </li>
                                <li class="list-group-item">
                                    <a href="javascript:void(0);" id="hisdevicelist"
                                       class="menu_item"
                                       name="/lihuaiot01/jsp/userpage/hisdevicelist.jsp">历史数据</a>
                                </li>
                                <li class="list-group-item">
                                    <a href="javascript:void(0);" id="hisalarmlist"
                                       class="menu_item"
                                       name="/lihuaiot01/jsp/userpage/hisalarmlist.jsp">历史报警</a>
                                </li>
                                <li class="list-group-item">
                                    <a href="javascript:void(0);" id="hischartdevice"
                                       class="menu_item"
                                       name="/lihuaiot01/jsp/userpage/hischartdevice.jsp">历史曲线</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <shiro:hasAnyRoles  name="admin,211,111">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#collapse2" data-toggle="collapse" data-parent="#accordion"
                                   class="parentMenuTitle collapseHead">后台管理</a>
                                <div class="pull-right">
                                    <span class="caret"></span>
                                </div>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse collapseBody">
                            <div class="panel-body">

                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <a href="javascript:void(0)" id="organizemanage" class="menu_item"
                                           name="/lihuaiot01/jsp/adminpage/organizemanage.jsp">部门管理</a>
                                    </li>
                                    <%--<li class="list-group-item">
                                        <a href="javascript:void(0)" id="peoplecombineorg" class="menu_item"
                                           name="/lihuaiot01/jsp/adminpage/peoplecombineorg.jsp">人员管理</a>
                                    </li>--%>
                                    <li class="list-group-item">
                                        <a href="javascript:void(0)" id="devicecombineorg" class="menu_item"
                                           name="/lihuaiot01/jsp/adminpage/devicecombineorg.jsp">设备管理</a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="javascript:void(0)" id="devicecode" class="menu_item"
                                           name="/lihuaiot01/jsp/adminpage/devicecode.jsp">代码管理</a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="javascript:void(0)" id="rolecombinedevice" class="menu_item"
                                           name="/lihuaiot01/jsp/adminpage/rolecombinedevice.jsp">角色管理</a>
                                    </li>
                                    <li class="list-group-item">
                                        <a href="javascript:void(0)" id="rolecombinepeople" class="menu_item"
                                           name="/lihuaiot01/jsp/adminpage/rolecombinepeople.jsp">用户管理</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </shiro:hasAnyRoles>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a href="#collapse5" data-toggle="collapse" data-parent="#accordion"
                               class="parentMenuTitle collapseHead">系统维护</a>
                            <div class="pull-right	"><span class="caret"></span></div>
                        </h4>
                    </div>
                    <div id="collapse5" class="panel-collapse collapse collapseBody">
                        <div class="panel-body">
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a href="javascript:void(0)" id="loginrecord"
                                       class="menu_item" name="/lihuaiot01/jsp/systempage/loginrecord.jsp">登陆日志</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- 面板区域 -->
        <%--<div id="panel" class="col-md-10 col-sm-9">--%>
        <div id="tabContent" class="col-md-10 col-sm-9">
            <!--  此处异步加载各个面板 -->
            <!-- end -->
        </div>
    </div>
</div>

<!--自定义右键菜单html代码-->
<%--<div id="miantabmenu" style="display: none; z-index: 9999;">
    <ul style="width: 100px;height: 100px;background: aliceblue;">
        <li><a tabindex="-1" href="#">关闭</a></li>
        <li><a tabindex="-1" href="#">全部关闭</a></li>
        <li><a tabindex="-1" href="#">关闭其他</a></li>
    </ul>
</div>--%>

<ul id="miantabmenu" class="dropdown-menu" role="menu" style="display: none;width: 100px;height: 100px;z-index: 9999;">
    <li><a tabindex="-1" href="#" onclick="mainTabClose()">关闭</a></li>
    <li><a tabindex="-1" href="#" onclick="mainAllTabClose()">全部关闭</a></li>
    <li><a tabindex="-1" href="#" onclick="mainOthersTabClose()">关闭其他</a></li>
</ul>

<%--<div id="maincontext-menu">
    <ul class="dropdown-menu" role="menu">
        <li><a tabindex="-1" href="#">关闭</a></li>
        <li><a tabindex="-1" href="#">全部关闭</a></li>
        <li><a tabindex="-1" href="#">除此之外全部关闭</a></li>
    </ul>
</div>--%>

<!-- 提示消息模态框 -->
<div class="modal fade" id="global_info_modal" table-index="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal"
                        aria-hidden="true">&times;
                </button>
                <h4 class="modal-title" id="myModalLabel">信息</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-4 col-sm-4"></div>
                    <div class="col-md-4 col-sm-4">
                        <div id="info_success" class=" hide" style="text-align: center;">
                            <img src="/lihuaiot01/images/icons/success-icon.png" alt=""
                                 style="width: 100px; height: 100px;">
                        </div>
                        <div id="info_error" style="text-align: center;">
                            <img src="/lihuaiot01/images/icons/error-icon.png" alt=""
                                 style="width: 100px; height: 100px;">
                        </div>
                        <div id="info_warning" style="text-align: center;">
                            <img src="/lihuaiot01/images/icons/warning-icon.png" alt=""
                                 style="width: 100px; height: 100px;">
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4"></div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="text-align: center;">
                        <h4 id="info_summary"></h4>
                    </div>
                    <div class="col-md-3"></div>
                </div>
                <dic class="row" style="margin-top: 10px">
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="text-align: center;">
                        <p id='info_content'></p>
                    </div>
                    <div class="col-md-3"></div>
                </dic>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" type="button" data-dismiss="modal">
                    <span>&nbsp;&nbsp;&nbsp;关闭&nbsp;&nbsp;&nbsp;</span>
                </button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript"
        src="/lihuaiot01/js/jquery-3.2.1.min.js"></script>


<script type="text/javascript"
        src="/lihuaiot01/js/jquery.md5.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/jquery.mloading.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/jquery-ui.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/ajaxfileupload.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-treeview.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-table.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-datetimepicker.zh-CN.js"></script>
<%--daterangepicker--%>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/moment.js"></script>
<script
        src="/lihuaiot01/bootstrap/daterangepicker.js"></script>
<!-- 引入bootstrap-suggest.js-->
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-suggest.js"></script>
<%--bootstrap-multiselect--%>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-multiselect.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-tab.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/select2/js/select2.js"></script>
<%--<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-select/js/bootstrap-select.min.js"></script>--%>
<%--contextmenu start 与 tab有冲突--%>
<%--<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap-contextmenu.js"></script>--%>
<%--<script type="text/javascript"
        src="/lihuaiot01/js/prettify.js"></script>--%>
<%--contextmenu end--%>
<script type="text/javascript"
        src="/lihuaiot01/js/timeFormat.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/ztree/js/jquery.ztree.core.js"></script>
<!-- echarts -->
<script type="text/javascript"
        src="/lihuaiot01/echarts/echarts.js"></script>
<!-- echarts 主题-->
<script type="text/javascript"
        src="/lihuaiot01/echarts/macarons.js"></script>
<%--<script type="text/javascript"
        src="http://api.map.baidu.com/api?v=3.0&ak=VdkQgOMbzVx1lQlgjhDdcySmyPXWyK6i"></script>--%>
<script type="text/javascript"
        src="http://api.map.baidu.com/getscript?v=3.0&ak=VdkQgOMbzVx1lQlgjhDdcySmyPXWyK6i&services=&t=20180201100256"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/lihuaiotutil.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/mainPage.js"></script>
</body>
</html>