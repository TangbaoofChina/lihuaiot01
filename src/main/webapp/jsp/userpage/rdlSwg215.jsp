<%--
  Created by IntelliJ IDEA.
  User: tangbao
  Date: 2020-09-02
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="columns-right" id="rdlSwgC215OneDeviceDiv" style="display:none;">
    <!--主体-->
    <div class="col-md-9 col-sm-9 row" id="swgC215Main" style="text-align: center;margin-left: 20px;">
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>时间</span>
            </div>
            <div class="col-md-5 col-sm-5 SwgC215border">
                <span id="sewagec215sendDate">2020-08-31 12:21:12</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>累计流量(m³)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="flowmeter215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>当日流量(m³)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="todayFlowmeter215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>内回流量(m³)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="inFlowmeter215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>外回流量(m³)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="outFlowmeter215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>累计电量</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="totalEp215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>当日电量</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="todayEp215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>环境温度01(℃)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="airTemp01215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>水温01(℃)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="waterTemp01215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>环境温度02(℃)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="airTemp02215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>水温02(℃)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="waterTemp02215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold"></span>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">设备运行状态</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>设备</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span>运</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>运行时间(分)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>设备</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span>运</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>运行时间</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>机械格栅</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="ydsgsStop215" class="rectangleClose" style="display: block">停</div>
                <div id="ydsgsRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ydsgsRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水井提升泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="collectWellPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="collectWellPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="collectWellPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机01</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="collectMixer01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="collectMixer01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="collectMixer01RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机02</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="collectMixer02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="collectMixer02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="collectMixer02RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷投加机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="dephosphorizeStop215" class="rectangleClose" style="display: block">停</div>
                <div id="dephosphorizeRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="dephosphorizeRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池提升泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="collectPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="collectPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="collectPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>固液分离机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="solLiqStop215" class="rectangleClose" style="display: block">停</div>
                <div id="solLiqRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="solLiqRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池01搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldMixer01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldMixer01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldMixer01RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池01搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldOpstMixer01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldOpstMixer01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldOpstMixer01RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混沉池污泥泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldSinkPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldSinkPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldSinkPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldCglMixer01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldCglMixer01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldCglMixer01RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01加药泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldCglDosing01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldCglDosing01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldCglDosing01RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="astCglMixer01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="astCglMixer01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="astCglMixer01RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01加药泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="astCglDosing01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="astCglDosing01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="astCglDosing01RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>污泥池搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sludgeMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="sludgeMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sludgeMixerRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机进泥泵 </span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="slySeprtInPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="slySeprtInPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="slySeprtInPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂加药泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="flocltDosingStop215" class="rectangleClose" style="display: block">停</div>
                <div id="flocltDosingRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="flocltDosingRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂搅拌机 </span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="flocltMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="flocltMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="flocltMixerRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="slySeprtStop215" class="rectangleClose" style="display: block">停</div>
                <div id="slySeprtRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="slySeprtRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>调节初沉池污泥泵 </span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="pmySinkPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="pmySinkPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="pmySinkPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池进水泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sbrIntakePumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="sbrIntakePumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrIntakePumpRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机01 </span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="fan01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="fan01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="fan01RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机02</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="fan02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="fan02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="fan02RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池污泥泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sbrSludegPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="sbrSludegPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrSludegPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>电动排水阀</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="eleDrainStop215" class="rectangleClose" style="display: block">停</div>
                <div id="eleDrainRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="eleDrainRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机01</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sbrMixer01Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="sbrMixer01Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrMixer01RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机02</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sbrMixer02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="sbrMixer02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrMixer02RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池进水泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="uasbInPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="uasbInPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="uasbInPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>内回流泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="inBfPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="inBfPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="inBfPumpRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>外回流泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="outBfPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="outBfPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="outBfPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="uasbMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="uasbMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="uasbMixerRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>缺氧池搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="anoxiaMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="anoxiaMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="anoxiaMixerRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>二沉池污泥泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="secSinkPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="secSinkPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="secSinkPumpRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldCglMixer02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldCglMixer02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldCglMixer02RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="astCglMixer02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="astCglMixer02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="astCglMixer02RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="ppRmvMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="ppRmvMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ppRmvMixerRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02加药泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldCglDosing02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldCglDosing02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldCglDosing02RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02加药泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="astCglDosing02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="astCglDosing02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="astCglDosing02RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂加药泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="ppRmvDosingStop215" class="rectangleClose" style="display: block">停</div>
                <div id="ppRmvDosingRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ppRmvDosingRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池02搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldOpstMixer02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldOpstMixer02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldOpstMixer02RunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池02搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="bldMixer02Stop215" class="rectangleClose" style="display: block">停</div>
                <div id="bldMixer02Run215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="bldMixer02RunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷池搅拌机</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="ppRmvTankMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="ppRmvTankMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ppRmvTankMixerRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>终沉池污泥泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="finalSinkPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="finalSinkPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="finalSinkPumpRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">公共参数</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水井高液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectWellHighOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="collectWellHighOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水井低液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectWellLowOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="collectWellLowOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池高液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectHighOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="collectHighOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池低液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectLowOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="collectLowOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>调节池高液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="regulatHighOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="regulatHighOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>调节池低液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="regulatLowOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="regulatLowOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池高液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sbrHighOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="sbrHighOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池低液位</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sbrLowOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="sbrLowOn215" class="rectangle02Open" style="display: none">到了</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>排水阀开</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="decanterOnOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="decanterOnOn215" class="rectangle02Open" style="display: none">到位</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>排水阀关</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="decanterOffOff215" class="rectangle02Close" style="display: block">未到</div>
                <div id="decanterOffOn215" class="rectangle02Open" style="display: none">到位</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">工艺运行状态</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>工艺流程</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span>运</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>运行时间(分)</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>工艺流程</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span>运</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>运行时间</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>进水泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="inPumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="inPumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="inPumpRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR一次搅拌</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="firstSbrMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="firstSbrMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="firstSbrMixerRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机01</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="fan01SStop215" class="rectangleClose" style="display: block">停</div>
                <div id="fan01SRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="fan01SRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机02</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="fan02SStop215" class="rectangleClose" style="display: block">停</div>
                <div id="fan02SRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="fan02SRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR二次搅拌</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="secSbrMixerStop215" class="rectangleClose" style="display: block">停</div>
                <div id="secSbrMixerRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="secSbrMixerRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>静置沉淀</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sbrStaticStop215" class="rectangleClose" style="display: block">停</div>
                <div id="sbrStaticRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrStaticRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>污泥泵</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sludgePumpStop215" class="rectangleClose" style="display: block">停</div>
                <div id="sludgePumpRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sludgePumpSRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>排水阀开</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="decanterOnStop215" class="rectangleClose" style="display: block">停</div>
                <div id="decanterOnRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="decanterOnRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>排水阀关</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="decanterOffStop215" class="rectangleClose" style="display: block">停</div>
                <div id="decanterOffRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="decanterOffRunMin215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>静置活化</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <div id="sbrActiveStop215" class="rectangleClose" style="display: block">停</div>
                <div id="sbrActiveRun215" class="rectangleOpen" style="display: none">运</div>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrActiveRunMin215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">工艺流程设定时间(分钟)</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>工艺流程</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span>启</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>设定时间</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>工艺流程</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span>启</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>设定时间</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR一次搅拌</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span id="sbrMixerOnceSTime215">10:00</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrMixerOnceSetMinute215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>曝气</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span id="fanSTime215">10:00</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="fanSetMinute215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR二次搅拌</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span id="sbrMixerSecSTime215">10:00</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrMixerSecSetMinute215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>静止沉淀</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span id="sbrStaticSTime215">05:40</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrStaticSetMinute215">123</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>排泥</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span id="sludgePumpSTime215">10:00</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sludgePumpSetMinute215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>静置活化</span>
            </div>
            <div class="col-md-1 col-sm-1 SwgC215border">
                <span id="sbrActiveSTime215">05:40</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="sbrActiveSetMinute215">123</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">故障状态</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>智能电表设备通讯</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="elecNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="elecFault215" class="rectangle02Close" style="display: none">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>PLC电量不足</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="plcElecNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="plcElecLack215" class="rectangle02Close" style="display: none">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR水温变送器</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="waterTempNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="waterTempFault215" class="rectangle02Close" style="display: none">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>空气温度变送器</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="airTempNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="airTempFault215" class="rectangle02Close" style="display: none">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>机械格栅</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="ydsgsNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="ydsgsFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水井提升泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectWellPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="collectWellPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机01</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectMixer01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="collectMixer01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectMixer02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="collectMixer02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷投加机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="dephosphorizeNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="dephosphorizeFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池提升泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="collectPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="collectPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>固液分离机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="solLiqNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="solLiqFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldMixer01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldMixer01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldOpstMixer01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldOpstMixer01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldSinkPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldSinkPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldCglMixer01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldCglMixer01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldCglDosing01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldCglDosing01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="astCglMixer01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="astCglMixer01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="astCglDosing01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="astCglDosing01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>污泥池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sludgeMixerNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="sludgeMixerFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机进泥泵 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="slySeprtInPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="slySeprtInPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="flocltDosingNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="flocltDosingFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂搅拌机 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="flocltMixerNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="flocltMixerFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="slySeprtNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="slySeprtFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>调节初沉池污泥泵 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="pmySinkPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="pmySinkPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池进水泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sbrIntakePumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="sbrIntakePumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机01 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="fan01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="fan01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="fan02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="fan02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sbrSludegPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="sbrSludegPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>电动排水阀</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="eleDrainNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="eleDrainFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机01</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sbrMixer01Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="sbrMixer01Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="sbrMixer02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="sbrMixer02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池进水泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="uasbInPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="uasbInPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>内回流泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="inBfPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="inBfPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>外回流泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="outBfPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="outBfPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="uasbMixerNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="uasbMixerFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>缺氧池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="anoxiaMixerNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="anoxiaMixerFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>二沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="secSinkPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="secSinkPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldCglMixer02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldCglMixer02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="astCglMixer02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="astCglMixer02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="ppRmvMixerNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="ppRmvMixerFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldCglDosing02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldCglDosing02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="astCglDosing02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="astCglDosing02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="ppRmvDosingNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="ppRmvDosingFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldOpstMixer02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldOpstMixer02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="bldMixer02Normal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="bldMixer02Fault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="ppRmvTankMixerNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="ppRmvTankMixerFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>终沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <div id="finalSinkPumpNormal215" class="rectangle02Open" style="display: block">正常</div>
                <div id="finalSinkPumpFault215" class="rectangle02Close" style="display: block">故障</div>
            </div>
        </div>

        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">电能数据</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>线Uab</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="uab215">150.22</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>线Ubc</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ubc215">150.22</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>线Uca</span>
            </div>
            <div class="col-sm-2 col-sm-2 SwgC215border">
                <span id="uca215">150.22</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>相Ua</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ua215">150.22</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>相Ub</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ub215">150.22</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>相Uc</span>
            </div>
            <div class="col-sm-2 col-sm-2 SwgC215border">
                <span id="uc215">150.22</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>Ia</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ia215">150.22</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>Ib</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span id="ib215">150.22</span>
            </div>
            <div class="col-md-2 col-sm-2 SwgC215border">
                <span>Ic</span>
            </div>
            <div class="col-sm-2 col-sm-2 SwgC215border">
                <span id="ic215">150.22</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>合相有功功率</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="pt215">150.22</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>合相无功功率</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="qt215">150.22</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>合相视在功率</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="st215">150.22</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>合相功率因数</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="pft215">150.22</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>正向有功总电能</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="impEP215">150.22</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>反向有功总电能</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="expEP215">150.22</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>频率</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="freq215">30</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">设备启动时间(时+分)</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>机械格栅</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ydsgsRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水井提升泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectWellPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机01</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectMixer01RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectMixer02RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷投加机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="dephosphorizeRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池提升泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>固液分离机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="solLiqRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldMixer01RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldOpstMixer01RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldSinkPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglMixer01RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglDosing01RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglMixer01RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglDosing01RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>污泥池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sludgeMixerRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机进泥泵 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="slySeprtInPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="flocltDosingRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂搅拌机 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="flocltMixerRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="slySeprtRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>调节初沉池污泥泵 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="pmySinkPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池进水泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrIntakePumpRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机01 </span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="fan01RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机02</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="fan02RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池污泥泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrSludegPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>电动排水阀</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="eleDrainRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机01</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrMixer01RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrMixer02RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池进水泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="uasbInPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>内回流泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="inBfPumpRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>外回流泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="outBfPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="uasbMixerRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>缺氧池搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="anoxiaMixerRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>二沉池污泥泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="secSinkPumpRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglMixer02RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglMixer02RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ppRmvMixerRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02加药泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglDosing02RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglDosing02RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ppRmvDosingRunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldOpstMixer02RunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldMixer02RunTime215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ppRmvTankMixerRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>终沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="finalSinkPumpRunTime215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row" style="text-align: left;">
            <span style="font-weight: bold">设备运行累计时长(时)</span>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>机械格栅</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ydsgsRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水井提升泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectWellPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机01</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectMixer01RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池搅拌机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectMixer02RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷投加机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="dephosphorizeRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>集水池提升泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="collectPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>固液分离机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="solLiqRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldMixer01RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldOpstMixer01RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldSinkPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglMixer01RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂01加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglDosing01RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglMixer01RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂01加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglDosing01RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>污泥池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sludgeMixerRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机进泥泵 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="slySeprtInPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="flocltDosingRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>絮凝剂搅拌机 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="flocltMixerRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>泥水分离机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="slySeprtRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>调节初沉池污泥泵 </span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="pmySinkPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池进水泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrIntakePumpRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机01 </span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="fan01RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>风机02</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="fan02RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池污泥泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrSludegPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>电动排水阀</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="eleDrainRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机01</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrMixer01RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>SBR池搅拌机02</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="sbrMixer02RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池进水泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="uasbInPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>内回流泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="inBfPumpRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>外回流泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="outBfPumpRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>厌氧池搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="uasbMixerRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>缺氧池搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="anoxiaMixerRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>二沉池污泥泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="secSinkPumpRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglMixer02RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglMixer02RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂搅拌机</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ppRmvMixerRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混凝剂02加药泵</span>
            </div>

            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldCglDosing02RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>助凝剂02加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="astCglDosing02RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷剂加药泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ppRmvDosingRunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混反池02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldOpstMixer02RunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>混合池02搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="bldMixer02RunTotal215">50</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>除磷池搅拌机</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="ppRmvTankMixerRunTotal215">50</span>
            </div>
        </div>
        <div class="col-md-9 col-sm-9 row">
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span>终沉池污泥泵</span>
            </div>
            <div class="col-md-3 col-sm-3 SwgC215border">
                <span id="finalSinkPumpRunTotal215">50</span>
            </div>
        </div>
    </div>
</div>
<link rel="stylesheet" href="/lihuaiot01/css/realdevicelist.css" type="text/css">

