package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.EChartsOptions.*;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.parameter.ChartsParameters;
import com.system.po.parameter.DeviceType;
import com.system.po.parameter.ParameterCharts;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/phone/ec01")
public class EC01PhoneController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping(value = "selectOrgByUserId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrgByUserId(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            RoleInfo roleInfoAdmin = new RoleInfo();
            //用鸡舍的admin代替
            roleInfoAdmin.setRoleId("6AE5CA02164B1046E0536800A8C06B5D");
            roleInfoAdmin.setRoleName("111");
            roleInfoAdmin.setRoleDescribe("鸡舍环控器");
            List<RoleInfo> roleInfoListAdmin = new ArrayList<RoleInfo>();
            roleInfoListAdmin.add(roleInfoAdmin);
            //orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfo();
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(roleInfoListAdmin);
        } else {
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId(roleInfoList);
        }
        String jsonString = JSON.toJSONString(orgTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfo(String userId, String orgId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = getRealEC01DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (ec01DeviceMessageList.size() > 0)
            jsonString = JSON.toJSONString(ec01DeviceMessageList);
        return jsonString;
    }

    @RequestMapping(value = "selectHisDeviceInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId,String sQueryParam, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (devNum == null || devNum.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        //获取时间-start
        /*int mDay = Integer.parseInt(day);
        mDay = -1 * mDay;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sEndDate = simpleFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, mDay);
        date = calendar.getTime();
        String sStartDate = simpleFormat.format(date);*/
        String sEndDate = "2018/05/21 23:59:59";
        String sStartDate = "2018/05/21 00:00:00";
        //获取时间-end
        String[] deviceNums = new String[1];
        deviceNums[0] = devNum;
        ParameterCharts parameterCharts = null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            parameterCharts = ec01DeviceMessageService.selectHisEC01ByDateAndIDsChart(deviceNums, sQueryParam, sStartDate, sEndDate);
            //ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(deviceId, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            //ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(deviceId, sStartDate,sEndDate);;
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    parameterCharts = ec01DeviceMessageService.selectHisEC01ByDateAndIDsChart(deviceNums, sQueryParam, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString = "[]";
        if (parameterCharts !=null) {
            PhoneEChartsOptions phoneEChartsOptions = getEChartsOptions(parameterCharts.getChartsParameters());
            jsonString = JSON.toJSONString(phoneEChartsOptions);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = getRealEC01DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (ec01DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(ec01DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoDetail", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        EC01DeviceMessage ec01DeviceMessage = getRealEC01DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (ec01DeviceMessage != null) {
            PhoneRealDeviceInfo  phoneRealDeviceInfo = getOneRealDeviceInfoDetail(ec01DeviceMessage);
            jsonString = JSON.toJSONString(phoneRealDeviceInfo);
        }
        return jsonString;
    }

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

    /**
     * 通过用户ID和组织ID查询设备实时数据-概要信息
     * @param userId
     * @param orgId
     * @return
     * @throws Exception
     */
    private List<EC01DeviceMessage> getRealEC01DeviceMessageByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        if (userId == null || userId.equals(""))
            return ec01DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return ec01DeviceMessageList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return ec01DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByORGId(orgId);
        } else {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return ec01DeviceMessageList;
    }

    /**
     * 通过用户ID和设备ID查询设备实时数据-详细信息
     * @param userId
     * @param devNum
     * @return
     */
    private EC01DeviceMessage getRealEC01DeviceMessageByUserIdAndDevNum(String userId, String devNum) throws Exception
    {
        EC01DeviceMessage ec01DeviceMessage = null;
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            ec01DeviceMessage = ec01DeviceMessageService.selectEC01ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            //ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(deviceId, sStartDate,sEndDate);;
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    ec01DeviceMessage = ec01DeviceMessageService.selectEC01ByDeviceId(devNum);
                    break;
                }
            }
        }
        return ec01DeviceMessage;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<EC01DeviceMessage> ec01DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (EC01DeviceMessage ec01DeviceMessage : ec01DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(ec01DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(EC01DeviceMessage ec01DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = ec01DeviceMessage.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(ec01DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(ec01DeviceMessage.getDName());
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoDetail(EC01DeviceMessage ec01DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = ec01DeviceMessage.getPhoneRealMsgInfoDetail();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(ec01DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(ec01DeviceMessage.getDName());
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }

    private PhoneEChartsOptions getEChartsOptions(ChartsParameters chartsParameters){
        //默认一天
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        /*String getTime =  chartsParameters.getdParameterTime().get(0);
        String getTimeDate = getTime.substring(0,getTime.indexOf(" "));
        String getTimeTime = getTime.substring(getTime.indexOf(" ")+1,getTime.length());*/
        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("温度曲线");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        EChartsLegend eChartsLegend = new EChartsLegend();
        eChartsLegend.setData(chartsParameters.getdParameterName());
        phoneEChartsOptions.setLegend(eChartsLegend);

        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        eChartsXAxis.setData(chartsParameters.getdParameterTime());
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        phoneEChartsOptions.setSeries(chartsParameters.getdParameterdata());

        return phoneEChartsOptions;
    }


}
