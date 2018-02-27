<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆</title>
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="/lihuaiot01/css/login.css">
    <link rel="shortcut icon" href="/lihuaiot01/images/lihuaiotweb01.ico" />
</head>
<body>
<!-- 定义容器 -->
<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-3"></div>

        <!-- 这一列为登陆表单 -->
        <div class="col-md-4 col-sm-6">
            <div class="panel panel-default">

                <!-- 登陆面板的标题 -->
                <div class="panel-title" style="text-align: center">
                    <h2>登录</h2>
                </div>

                <!-- 登陆面板的主体 -->
                <div class="panel-body">

                    <!-- 表单 -->
                    <form id="login_form" class="form-horizontal" style="">
                        <%--<div id="login_form" class="form-horizontal">--%>
                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4">用户ID：</label>
                            <div class="col-md-7 col-sm-7">
                                <input type="text" id="userID" class="form-control"
                                       placeholder="用户ID" name="userID"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4 col-sm-4">
                                <!-- <span class="glyphicon glyphicon-lock"></span> -->
                                密码：
                            </label>
                            <div class="col-md-7 col-sm-7">
                                <input type="password" id="password" class="form-control"
                                       placeholder="密码" name="password">
                            </div>
                        </div>

                        <div>
                            <div class="col-md-4 col-sm-4"></div>
                            <div class="col-md-4 col-sm-4">
                                <button id="submit" type="submit" class="btn btn-primary">
                                    &nbsp;&nbsp;&nbsp;&nbsp;登陆&nbsp;&nbsp;&nbsp;&nbsp;
                                </button>
                            </div>
                            <div class="col-md-4 col-sm-4"></div>
                        </div>
                    </form>
                    <%--</div>--%>
                </div>
            </div>
        </div>

        <div class="col-md-4 col-sm-3"></div>
    </div>
</div>
<!-- 引入JQuery  bootstrap.js-->
<script type="text/javascript"
        src="/lihuaiot01/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/bootstrap/bootstrapValidator.min.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/lihuaiotutil.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/security.js"></script>
<script type="text/javascript"
        src="/lihuaiot01/js/login.js"></script>
</body>
</html>