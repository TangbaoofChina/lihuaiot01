<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 欢迎界面 -->
<div class="panel panel-default">
    <div class="panel-body">
        <div class="row" style="margin-top: 100px; margin-bottom: 100px">
            <div class="col-md-1"></div>
            <div class="col-md-10" style="text-align: center">
                <div class="col-md-4 col-sm-4">
                    <a href="javascript:void(0)" class="thumbnail shortcut"> <img
                            src="/lihuaiot01/images/icons/stock_search-512.png" alt="设备列表"
                            class="img-rounded link" style="width: 150px; height: 150px;">
                        <div class="caption">
                            <h3 class="title">设备列表</h3>
                        </div>
                    </a>
                </div>
                <div class="col-md-4 col-sm-4">
                    <a href="javascript:void(0)" class="thumbnail shortcut"> <img
                            src="/lihuaiot01/images/icons/stock_in-512.png" alt="实时数据"
                            class="img-rounded link" style="width: 150px; height: 150px;">
                        <div class="caption">
                            <h3 class="title">实时数据</h3>
                        </div>
                    </a>
                </div>
                <div class="col-md-4 col-sm-4">
                    <a href="javascript:void(0)" class="thumbnail shortcut"> <img
                            src="/lihuaiot01/images/icons/stock_out-512.png" alt="历史数据"
                            class="img-rounded link" style="width: 150px; height: 150px;">
                        <div class="caption">
                            <h3 class="title">历史数据</h3>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>
<script>
    //removealljsfile();
    loadjscssfile("/lihuaiot01/js/userjs/welcomepage.js", "js");
</script>