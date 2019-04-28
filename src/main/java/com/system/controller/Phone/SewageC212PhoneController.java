package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Device.SewageC212DMHis;
import com.system.po.Device.SewageC212DeviceMessage;
import com.system.po.Phone.PhoneLoginMsg;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC212.PSC212HisMsgInfo;
import com.system.po.Phone.PhoneSewageC212.PhoneSewageC212RealData;
import com.system.po.Phone.PhoneSewageC212.PhoneSewageC212RealMsgInfo;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.DeviceRoleInfoService;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.service.RoleInfoService;
import com.system.service.SewageC212DMService;
import com.system.service.UserloginService;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/sewagec212")
public class SewageC212PhoneController {
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private SewageC212DMService sewageC212DMService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;

    @RequestMapping(value = "login", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
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

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = getRealSewageC212DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (sewageC212DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(sewageC212DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        SewageC212DeviceMessage sewageC212DeviceMessage = getRealSewageC212DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (sewageC212DeviceMessage != null) {
            PhoneSewageC212RealMsgInfo phoneSewageC212RealMsgInfo = getOneRealDeviceInfoDetail(sewageC212DeviceMessage);
            jsonString = JSON.toJSONString(phoneSewageC212RealMsgInfo);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHisDeviceInfo", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
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
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = new ArrayList<SewageC212DeviceMessage>();
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
        List<SewageC212DMHis> sewageC212DMHisList = new ArrayList<SewageC212DMHis>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC212DMHisList = sewageC212DMService.selectPhoneHisSewageC212ByDateAndId(devNum, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC212DMHisList = sewageC212DMService.selectPhoneHisSewageC212ByDateAndId(devNum, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString = "[]";
        if (sewageC212DMHisList.size() > 0) {
            PSC212HisMsgInfo psc212HisMsgInfo = new PSC212HisMsgInfo(sewageC212DMHisList);
            jsonString = JSON.toJSONString(psc212HisMsgInfo);
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
    private List<SewageC212DeviceMessage> getRealSewageC212DeviceMessageByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = new ArrayList<SewageC212DeviceMessage>();
        if (userId == null || userId.equals(""))
            return sewageC212DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return sewageC212DeviceMessageList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return sewageC212DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC212DeviceMessageList = sewageC212DMService.selectSewageC212ByORGId(orgId);
        } else {
            sewageC212DeviceMessageList = sewageC212DMService.selectSewageC212ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return sewageC212DeviceMessageList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<SewageC212DeviceMessage> sewageC212DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (SewageC212DeviceMessage sewageC212DeviceMessage : sewageC212DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(sewageC212DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(SewageC212DeviceMessage sewageC212DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = sewageC212DeviceMessage.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(sewageC212DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(sewageC212DeviceMessage.getDName());
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
    private SewageC212DeviceMessage getRealSewageC212DeviceMessageByUserIdAndDevNum(String userId, String devNum) throws Exception {
        SewageC212DeviceMessage sewageC212DeviceMessage = null;
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
            sewageC212DeviceMessage = sewageC212DMService.selectSewageC212ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC212DeviceMessage = sewageC212DMService.selectSewageC212ByDeviceId(devNum);
                    break;
                }
            }
        }
        return sewageC212DeviceMessage;
    }

    private PhoneSewageC212RealMsgInfo getOneRealDeviceInfoDetail(SewageC212DeviceMessage sewageC212DeviceMessage) {
        PhoneSewageC212RealMsgInfo phoneSewageC212RealMsgInfo = new PhoneSewageC212RealMsgInfo();

        //形成信号信息
        List<PhoneSewageC212RealData> phoneSewageC212RealDataList = sewageC212DeviceMessage.getPhoneRealMsgInfoDetail212();
        //形成设备信息
        phoneSewageC212RealMsgInfo.setDevName(sewageC212DeviceMessage.getDName());
        phoneSewageC212RealMsgInfo.setDevNum(sewageC212DeviceMessage.getDSerialNum());
        phoneSewageC212RealMsgInfo.setPhoneSewageC212RealDataList(phoneSewageC212RealDataList);
        return phoneSewageC212RealMsgInfo;
    }
}
