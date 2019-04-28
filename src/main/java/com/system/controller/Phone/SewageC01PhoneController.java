package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC01DeviceMessage;
import com.system.po.Phone.PhoneLoginMsg;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PSC01HisMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealMsgInfo;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/phone/sewagec")
public class SewageC01PhoneController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private SewageC01DeviceMessageService sewageC01DeviceMessageService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private UserloginService userloginService;

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
                UserOAEas userOAEas =  phoneUserOaEasService.selectUserOaEasByEasId(userlogin.getUserid());

                phoneLoginMsg.setOaId(userOAEas.getOaId());
                phoneLoginMsg.setMessage("登录成功");
            }
        }
        jsonString = JSON.toJSONString(phoneLoginMsg);
        return jsonString;
    }

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
            //用污水处理的admin代替
            roleInfoAdmin.setRoleId("6AE5C6025D7B1035E0536800A8C0C8FD");
            roleInfoAdmin.setRoleName("211");
            roleInfoAdmin.setRoleDescribe("立华禽环保1.0");
            List<RoleInfo> roleInfoListAdmin = new ArrayList<RoleInfo>();
            roleInfoListAdmin.add(roleInfoAdmin);
            //orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfo();
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("211",roleInfoListAdmin);
        } else {
            orgTreeNodeList = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("211",roleInfoList);
        }
        String jsonString = JSON.toJSONString(orgTreeNodeList);
        return jsonString;
    }

    @RequestMapping(value = "selectHisDeviceInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (devNum == null || devNum.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = new ArrayList<SewageC01DeviceMessage>();
        //获取时间-start
        //正式时间
        int mDay = Integer.parseInt(day);
        mDay = -1 * mDay;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String sEndDate = simpleFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, mDay);
        date = calendar.getTime();
        String sStartDate = simpleFormat.format(date);
        /*String sEndDate = "2017/12/30 23:59:59";
        String sStartDate = "2017/12/01 00:00:00";*/
        //获取时间-end
        List<SewageC01DMHis> sewageC01DMHisList = new ArrayList<SewageC01DMHis>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC01DMHisList = sewageC01DeviceMessageService.selectPhoneHisSewageC01ByDateAndId(devNum, sStartDate, sEndDate);
            //ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(deviceId, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            //ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(deviceId, sStartDate,sEndDate);;
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC01DMHisList = sewageC01DeviceMessageService.selectPhoneHisSewageC01ByDateAndId(devNum, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString = "[]";
        if (sewageC01DMHisList.size() > 0) {
            PSC01HisMsgInfo psc01HisMsgInfo = new PSC01HisMsgInfo(sewageC01DMHisList);
            jsonString = JSON.toJSONString(psc01HisMsgInfo);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoDetail", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        SewageC01DeviceMessage sewageC01DeviceMessage = getRealSewageC01DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (sewageC01DeviceMessage != null) {
            PhoneSewageC01RealMsgInfo phoneSewageC01RealMsgInfo = getOneRealDeviceInfoDetail(sewageC01DeviceMessage);
            jsonString = JSON.toJSONString(phoneSewageC01RealMsgInfo);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = getRealSewageC01DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (sewageC01DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(sewageC01DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    /**
     * 通过用户ID和设备ID查询设备实时数据-详细信息
     *
     * @param userId
     * @param devNum
     * @return
     */
    private SewageC01DeviceMessage getRealSewageC01DeviceMessageByUserIdAndDevNum(String userId, String devNum) throws Exception {
        SewageC01DeviceMessage sewageC01DeviceMessage = null;
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
            sewageC01DeviceMessage = sewageC01DeviceMessageService.selectSewageC01ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC01DeviceMessage = sewageC01DeviceMessageService.selectSewageC01ByDeviceId(devNum);
                    break;
                }
            }
        }
        return sewageC01DeviceMessage;
    }

    private PhoneSewageC01RealMsgInfo getOneRealDeviceInfoDetail(SewageC01DeviceMessage sewageC01DeviceMessage) {
        PhoneSewageC01RealMsgInfo phoneSewageC01RealMsgInfo = new PhoneSewageC01RealMsgInfo();

        //形成信号信息
        List<PhoneSewageC01RealData> phoneSewageC01RealDataList = sewageC01DeviceMessage.getPhoneRealMsgInfoDetail();
        //形成设备信息
        phoneSewageC01RealMsgInfo.setDevName(sewageC01DeviceMessage.getDName());
        phoneSewageC01RealMsgInfo.setDevNum(sewageC01DeviceMessage.getDSerialNum());
        phoneSewageC01RealMsgInfo.setPhoneSewageC01RealDataList(phoneSewageC01RealDataList);
        return phoneSewageC01RealMsgInfo;
    }

    /**
     * 通过用户ID和组织ID查询设备实时数据-概要信息
     *
     * @param userId
     * @param orgId
     * @return
     * @throws Exception
     */
    private List<SewageC01DeviceMessage> getRealSewageC01DeviceMessageByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = new ArrayList<SewageC01DeviceMessage>();
        if (userId == null || userId.equals(""))
            return sewageC01DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return sewageC01DeviceMessageList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return sewageC01DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC01DeviceMessageList = sewageC01DeviceMessageService.selectSewageC01ByORGId(orgId);
        } else {
            sewageC01DeviceMessageList = sewageC01DeviceMessageService.selectSewageC01ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return sewageC01DeviceMessageList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<SewageC01DeviceMessage> sewageC01DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (SewageC01DeviceMessage sewageC01DeviceMessage : sewageC01DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(sewageC01DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(SewageC01DeviceMessage sewageC01DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = sewageC01DeviceMessage.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(sewageC01DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(sewageC01DeviceMessage.getDName());
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }


}
