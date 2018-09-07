<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 欢迎界面 -->
<div class="panel panel-default">
    <div class="panel-body">
        <div class="row" style="margin-top: 50px; margin-bottom: 20px">
            <div class="col-md-4">
                <div id="WelDeviceOnLine"></div>
            </div>
            <!-- tools box -->
            <div class="col-md-4">
                <div class="box-tools" style="margin-bottom: 5px;text-align: right;">
                    <button type="button" data-toggle="tooltip"
                            id="welOfflineFilterTime">
                        <i class="fa fa-calendar"></i>
                    </button>
                </div>
                <div id="WelDeviceOfflineRate"></div>
            </div>
            <div class="col-md-4">
                <div class=" box-tools"style="margin-bottom: 5px;text-align: right;">
                    <button type="button" data-toggle="tooltip"
                            id="welAlarmFilterTime">
                        <i class="fa fa-calendar"></i>
                    </button>
                </div>
                <div id="WelDeviceAlarmRate"></div>
            </div>
        </div>
    </div>
</div>
<script>
    //removealljsfile();
    loadjscssfile("/lihuaiot01/js/userjs/welcomepage.js", "js");
</script>