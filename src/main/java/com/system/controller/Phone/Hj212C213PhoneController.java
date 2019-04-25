package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.Hj212C213Chart;
import com.system.po.*;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.Phone.*;
import com.system.po.Phone.PhoneHj212C213.*;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.Hj212C213Util;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/hj212C213")
public class Hj212C213PhoneController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private Hj212C213DMService hj212C213DMService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private DeviceUtilController deviceUtilController;
    @Autowired
    private Hj212C213Chart hj212C213Chart;
    @Autowired
    private DeviceInfoService deviceInfoService;

    @RequestMapping(value = "login", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String login(String userName, String userPwd) throws Exception {
        String jsonString = "[]";
        Userlogin userlogin = userloginService.findByNameLiHua(userName);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userlogin.getUserid());
        PhoneLoginMsg phoneLoginMsg = new PhoneLoginMsg();
        if (roleInfoList.size() > 0) //如果物联网系统中已经配置
        {
            userlogin.setRoleInfoList(roleInfoList);
        } else {
            userlogin = null;
            phoneLoginMsg.setOaId("");
            phoneLoginMsg.setMessage("无登录权限");
        }
        if (userlogin != null) {
            //获取正式的密码(立华牧业用户表)
            String realPassword = MdPasswordUtil.encodePassword(userlogin.getUserid(), userPwd);
            if (!realPassword.equals(userlogin.getPassword())) {
                //密码错误
                userlogin = null;
                phoneLoginMsg.setOaId("");
                phoneLoginMsg.setMessage("密码错误");
            } else {
                Subject currentSubject = SecurityUtils.getSubject();
                Session session = currentSubject.getSession();
                // 清除 session 中的 userInfo 密码敏感信息
                userlogin.setPassword(null);
                // 设置用户信息到 Session
                session.setAttribute("userInfo", userlogin);
                UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByEasId(userlogin.getUserid());

                phoneLoginMsg.setOaId(userOAEas.getOaId());
                phoneLoginMsg.setMessage("登录成功");
            }
        }
        jsonString = JSON.toJSONString(phoneLoginMsg);
        return jsonString;
    }

    @RequestMapping(value = "selectOrgByUserId", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
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
            //用污水处理的admin代替
            roleInfoAdmin.setRoleId("8689127E814746B6E0536800A8C0FDA4");
            roleInfoAdmin.setRoleName("213");
            roleInfoAdmin.setRoleDescribe("立华水质");
            List<RoleInfo> roleInfoListAdmin = new ArrayList<RoleInfo>();
            roleInfoListAdmin.add(roleInfoAdmin);
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("213", roleInfoListAdmin);
        } else {
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("213", roleInfoList);
        }
        String jsonString = JSON.toJSONString(orgTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<Hj212C213DeviceMessage> sewageC01DeviceMessageList = getRealHj212C213DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (sewageC01DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(sewageC01DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        Hj212C213DeviceMessage hj212C213DeviceMessage = getRealHj212C213DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (hj212C213DeviceMessage != null) {
            PhoneHj212C213RealMsgInfo phoneHj212C213RealMsgInfo = getOneRealDeviceInfoDetail(hj212C213DeviceMessage);
            jsonString = JSON.toJSONString(phoneHj212C213RealMsgInfo);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHisChart", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisChart(String userId, String sQueryParam, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (devNum == null || devNum.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";

        //获取时间-start
        //正式时间
        int mDay = Integer.parseInt(day);
        mDay = -1 * mDay;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sEndDate = simpleFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, mDay);
        date = calendar.getTime();
        String sStartDate = simpleFormat.format(date);
        //获取时间-end

        String[] sDeviceIds = new String[1];
        sDeviceIds[0] = devNum;
        String jsonString = "[]";
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            jsonString = this.getOneParamChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    jsonString = this.getOneParamChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
                    break;
                }
            }
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHisData", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisData(String userId, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (devNum == null || devNum.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";

        //获取时间-start
        //正式时间
        int mDay = Integer.parseInt(day);
        mDay = -1 * mDay;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String sEndDate = simpleFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, mDay);
        date = calendar.getTime();
        String sStartDate = simpleFormat.format(date);
        //获取时间-end

        String jsonString = "[]";
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            jsonString = this.getOneParamData(devNum, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    jsonString = this.getOneParamData(devNum, sStartDate, sEndDate);
                    break;
                }
            }
        }
        return jsonString;
    }

    /**
     * 通过用户ID和组织ID查询设备实时数据-概要信息
     *
     * @param userId
     * @param orgId
     * @return
     * @throws Exception
     */
    private List<Hj212C213DeviceMessage> getRealHj212C213DeviceMessageByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = new ArrayList<Hj212C213DeviceMessage>();
        if (userId == null || userId.equals(""))
            return hj212C213DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return hj212C213DeviceMessageList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return hj212C213DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            hj212C213DeviceMessageList = hj212C213DMService.selectHj212C213ByORGId(orgId);
        } else {
            hj212C213DeviceMessageList = hj212C213DMService.selectHj212C213ByORGIdAndRoleId(orgId, roleInfoList);
        }
        return hj212C213DeviceMessageList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<Hj212C213DeviceMessage> hj212C213DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (Hj212C213DeviceMessage hj212C213DeviceMessage : hj212C213DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(hj212C213DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(Hj212C213DeviceMessage hj212C213DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = hj212C213DeviceMessage.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(hj212C213DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(hj212C213DeviceMessage.getDName());
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }

    /**
     * 通过用户ID和设备ID查询设备实时数据-详细信息
     *
     * @param userId
     * @param devNum
     * @return
     */
    private Hj212C213DeviceMessage getRealHj212C213DeviceMessageByUserIdAndDevNum(String userId, String devNum) throws Exception {
        Hj212C213DeviceMessage hj212C213DeviceMessage = null;
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
            hj212C213DeviceMessage = hj212C213DMService.selectHj212C213ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    hj212C213DeviceMessage = hj212C213DMService.selectHj212C213ByDeviceId(devNum);
                    break;
                }
            }
        }
        return hj212C213DeviceMessage;
    }

    private PhoneHj212C213RealMsgInfo getOneRealDeviceInfoDetail(Hj212C213DeviceMessage hj212C213DeviceMessage) {
        PhoneHj212C213RealMsgInfo phoneHj212C213RealMsgInfo = new PhoneHj212C213RealMsgInfo();

        //形成信号信息
        List<PhoneHj212C213RealData> phoneHj212C213RealDataList = hj212C213DeviceMessage.getPhoneRealMsgInfoDetail();
        //形成设备信息
        phoneHj212C213RealMsgInfo.setDevName(hj212C213DeviceMessage.getDName());
        phoneHj212C213RealMsgInfo.setDevNum(hj212C213DeviceMessage.getDSerialNum());
        phoneHj212C213RealMsgInfo.setPhoneHj212C213RealDataList(phoneHj212C213RealDataList);
        return phoneHj212C213RealMsgInfo;
    }

    private String getOneParamChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate = hj212C213DMService.selectHisHj212C213ByDateAndIDs(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (hj212C213MapByDate == null || hj212C213MapByDate.size() < 1)
            return "[]";
        List<DeviceInfo> deviceInfoList = deviceUtilController.getDeviceInfoList(sDeviceIds);
        if (deviceInfoList == null || deviceInfoList.size() < 1)
            return "[]";
        Map<String, String> deviceInfoMap = deviceUtilController.getDeviceInfoMap(deviceInfoList);
        PhoneEChartsOptions phoneEChartsOptions = hj212C213Chart.getECharts(sQueryParam, deviceInfoMap, hj212C213MapByDate);
        if (phoneEChartsOptions == null)
            return "[]";
        String jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }

    private String getOneParamData(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        String[] sDeviceIds = new String[1];
        sDeviceIds[0] = sDeviceId;
        Map<String, Hj212C213DayData> hj212C213MapByDate = hj212C213DMService.selectHisHj212C213ByDateAndIDsTwoParam(sDeviceIds, sStartDate, sEndDate);
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213MapByDate);
        List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByIDs(sDeviceIds);
        List<PHj212C213HisDataContent> pHj212C213HisDataContentList = new ArrayList<>();
        if (deviceInfoList.size() < 1)
            return "[]";
        for (String sDate : sDateList
                ) {
            Hj212C213DayData hj212C213DayData = hj212C213MapByDate.get(sDate);
            PHj212C213HisDataContent pHj212C213HisDataContent = new PHj212C213HisDataContent(hj212C213DayData);
            pHj212C213HisDataContentList.add(pHj212C213HisDataContent);
        }
        PHj212C213HisMsgInfo pHj212C213HisMsgInfo = new PHj212C213HisMsgInfo(deviceInfoList.get(0).getDSerialNum(), deviceInfoList.get(0).getDName());
        pHj212C213HisMsgInfo.setpHj212C213HisDataContentList(pHj212C213HisDataContentList);
        String jsonString = JSON.toJSONString(pHj212C213HisMsgInfo);
        return jsonString;
    }
}
