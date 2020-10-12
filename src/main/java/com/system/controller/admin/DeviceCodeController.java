package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.AlarmDescribe;
import com.system.po.ErrorDescribe;
import com.system.po.MydataTableColumn;
import com.system.po.parameter.DeviceType;
import com.system.service.AlarmDescribeService;
import com.system.service.DeviceAlarmService;
import com.system.service.DeviceTypeService;
import com.system.service.ErrorDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//报警代码管理-暂停使用
@Controller
@RequestMapping("/deviceCode")
public class DeviceCodeController {
    @Autowired
    private AlarmDescribeService alarmDescribeService;
    @Autowired
    private ErrorDescribeService errorDescribeService;
    @Autowired
    private DeviceTypeService deviceTypeService;

    /***************************报警部分-Start****************8*************/
    @RequestMapping(value = "selectAlarmDescribeByDevType", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectAlarmDescribeByDevType(String deviceType) throws Exception {
        String jsonString = "[]";
        if (deviceType != null) {
            //获取用户角色
            List<AlarmDescribe> alarmDescribeList = new ArrayList<AlarmDescribe>();
            alarmDescribeList = alarmDescribeService.selectAlarmDescribeByType(deviceType);
            if (alarmDescribeList.size() > 0)
                jsonString = JSON.toJSONString(alarmDescribeList);
        }
        return jsonString;
    }

    @RequestMapping(value = "insertAlarmDescribeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertAlarmDescribeInfo(String deviceType, String alarmCode, String sAlarmDescribe) throws Exception {
        String jsonString = "新增完成";
        if (deviceType != null) {
            AlarmDescribe alarmDescribe = new AlarmDescribe();
            alarmDescribe.setDevType(deviceType);
            alarmDescribe.setAlarmCode(alarmCode);
            alarmDescribe.setAlarmDescribe(sAlarmDescribe);
            AlarmDescribe existAlarmDescribe = alarmDescribeService.selectAlarmDescribeByCodeAndType(deviceType, alarmCode);
            if (existAlarmDescribe == null)
                alarmDescribeService.insertAlarmDescribe(alarmDescribe);
            else
                jsonString = "代码已存在";
        }
        return jsonString;
    }

    @RequestMapping(value = "updateAlarmDescribeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateAlarmDescribeInfo(String deviceType, String alarmCode, String sAlarmDescribe) throws Exception {
        String jsonString = "更新完成";
        if (deviceType != null) {
            AlarmDescribe alarmDescribe = new AlarmDescribe();
            alarmDescribe.setDevType(deviceType);
            alarmDescribe.setAlarmCode(alarmCode);
            alarmDescribe.setAlarmDescribe(sAlarmDescribe);
            alarmDescribeService.updateAlarmDescribeByTypeAndCode(alarmDescribe);
        }
        return jsonString;
    }

    @RequestMapping(value = "deleteAlarmDescribeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteAlarmDescribeInfo(String deviceType, String alarmCode) throws Exception {
        String jsonString = "删除完成";
        if (deviceType != null) {
            AlarmDescribe alarmDescribe = new AlarmDescribe();
            alarmDescribe.setDevType(deviceType);
            alarmDescribe.setAlarmCode(alarmCode);
            alarmDescribeService.deleteAlarmDescribeByTypeAndCode(alarmDescribe);
        }
        return jsonString;
    }

    @RequestMapping(value = "AlarmDescribeHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String AlarmDescribeHead() throws Exception {
        AlarmDescribe alarmDescribe = new AlarmDescribe();

        List<MydataTableColumn> myDTCList = alarmDescribe.getAlarmDescribeHead();

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
    /***************************报警部分-End****************8*************/

    /***************************错误部分-Start****************8*************/
    @RequestMapping(value = "selectErrorDescribeByDevType", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectErrorDescribeByDevType(String deviceType) throws Exception {
        String jsonString = "[]";
        if (deviceType != null) {
            //获取用户角色
            List<ErrorDescribe> errorDescribeList = new ArrayList<ErrorDescribe>();
            errorDescribeList = errorDescribeService.selectErrorDescribeByType(deviceType);
            if (errorDescribeList.size() > 0)
                jsonString = JSON.toJSONString(errorDescribeList);
        }
        return jsonString;
    }

    @RequestMapping(value = "insertErrorDescribeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertErrorDescribeInfo(String deviceType, String errorCode, String sErrorDescribe) throws Exception {
        String jsonString = "新增完成";
        if (deviceType != null) {
            ErrorDescribe errorDescribe = new ErrorDescribe();
            errorDescribe.setDevType(deviceType);
            errorDescribe.setErrorCode(errorCode);
            errorDescribe.setErrorDescribe(sErrorDescribe);
            ErrorDescribe existErrorDescribe = errorDescribeService.selectErrorDescribeByCodeAndType(deviceType, errorCode);
            if (existErrorDescribe == null)
                errorDescribeService.insertErrorDescribe(errorDescribe);
            else
                jsonString = "代码已存在";
        }
        return jsonString;
    }

    @RequestMapping(value = "updateErrorDescribeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String updateErrorDescribeInfo(String deviceType, String errorCode, String sErrorDescribe) throws Exception {
        String jsonString = "更新完成";
        if (deviceType != null) {
            ErrorDescribe errorDescribe = new ErrorDescribe();
            errorDescribe.setDevType(deviceType);
            errorDescribe.setErrorCode(errorCode);
            errorDescribe.setErrorDescribe(sErrorDescribe);
            errorDescribeService.updateErrorDescribeByTypeAndCode(errorDescribe);
        }
        return jsonString;
    }

    @RequestMapping(value = "deleteErrorDescribeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteErrorDescribeInfo(String deviceType, String errorCode) throws Exception {
        String jsonString = "删除完成";
        if (deviceType != null) {
            ErrorDescribe errorDescribe = new ErrorDescribe();
            errorDescribe.setDevType(deviceType);
            errorDescribe.setErrorCode(errorCode);
            errorDescribeService.deleteErrorDescribeByTypeAndCode(errorDescribe);
        }
        return jsonString;
    }

    @RequestMapping(value = "ErrorDescribeHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String ErrorDescribeHead() throws Exception {
        ErrorDescribe errorDescribe = new ErrorDescribe();

        List<MydataTableColumn> myDTCList = errorDescribe.getErrorDescribeHead();

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
    /***************************错误部分-End****************8*************/
    @RequestMapping(value = "insertDeviceTypeInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insertDeviceTypeInfo(String sDevType, String sDevTypeDescribe) throws Exception {
        String jsonString = "新增完成";
        if (sDevType != null) {
            DeviceType deviceType = new DeviceType();
            deviceType.setDevType(sDevType);
            deviceType.setDevTypeDescribe(sDevTypeDescribe);
            deviceTypeService.insertDeviceType(deviceType);
        }
        return jsonString;
    }


}
