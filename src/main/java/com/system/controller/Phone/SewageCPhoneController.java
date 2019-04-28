package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC01DeviceMessage;
import com.system.po.Device.SewageC212DMHis;
import com.system.po.Device.SewageC212DeviceMessage;
import com.system.po.Phone.PhoneLoginMsg;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PSC01HisMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealMsgInfo;
import com.system.po.Phone.PhoneSewageC212.PSC212HisMsgInfo;
import com.system.po.Phone.PhoneSewageC212.PhoneSewageC212RealData;
import com.system.po.Phone.PhoneSewageC212.PhoneSewageC212RealMsgInfo;
import com.system.po.Phone.PhoneTree;
import com.system.security.realms.MdPasswordUtil;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.DeviceUtil;
import com.system.util.PhoneTreeNodeMerger;
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
@RequestMapping("/phone/sewagec01")
public class SewageCPhoneController {

    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private SewageC01DeviceMessageService sewageC01DMService;
    @Autowired
    private SewageC212DMService sewageC212DMService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;

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
        List<ORGTreeNode> orgTreeNodeList211 = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList212 = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin211 = roleInfoService.selectRoleInfoByRoleName("211");
            List<RoleInfo> roleInfoListAdmin212 = roleInfoService.selectRoleInfoByRoleName("212");
            orgTreeNodeList211 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("211", roleInfoListAdmin211);
            orgTreeNodeList212 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("212", roleInfoListAdmin212);
            orgTreeNodeList.addAll(orgTreeNodeList211);
            orgTreeNodeList.addAll(orgTreeNodeList212);
        } else {
            orgTreeNodeList211 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("211", roleInfoList);
            orgTreeNodeList212 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("212", roleInfoList);
            orgTreeNodeList.addAll(orgTreeNodeList211);
            orgTreeNodeList.addAll(orgTreeNodeList212);
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
        String jsonString = "[]";
        if (devNum.equals("2001")) {
            jsonString = this.selectHisDeviceInfo211(userId, devNum, day);
        } else {
            jsonString = this.selectHisDeviceInfo212(userId, devNum, day);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoDetail", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        String jsonString = "[]";
        if (devNum.equals("2001")) {
            jsonString = this.selectRealDeviceInfoDetail211(userId, devNum);
        } else {
            jsonString = this.selectRealDeviceInfoDetail212(userId, devNum);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<ORGTreeNode> orgTreeNodeList = orgTreeNodeService.selectORGInfoByOrgId(orgId);
        String root = "";
        String jsonString = "[]";
        for (ORGTreeNode orgTreeNode : orgTreeNodeList
                ) {
            if (orgTreeNode.getpId().equals("-1")) {
                root = orgTreeNode.getId();
                break;
            }
        }
        if (root.equals(""))
            return "[]";
        if (root.equals("211")) {
            jsonString = this.selectRealDeviceInfoSummary211(userId, orgId);
        } else {
            jsonString = this.selectRealDeviceInfoSummary212(userId, orgId);
        }
        return jsonString;
    }

    private String selectRealDeviceInfoSummary211(String userId, String orgId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = getRealSewageC01DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (sewageC01DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary211(sewageC01DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    private String selectRealDeviceInfoSummary212(String userId, String orgId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = getRealSewageC212DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (sewageC212DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary212(sewageC212DeviceMessageList);
            jsonString = JSON.toJSONString(phoneRealDeviceInfoList);
        }
        return jsonString;
    }

    /**
     * 211设备-只有徐州吕滩
     *
     * @param userId
     * @param devNum
     * @return
     * @throws Exception
     */
    private String selectRealDeviceInfoDetail211(String userId, String devNum) throws Exception {
        SewageC01DeviceMessage sewageC01DeviceMessage = getRealSewageC01DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (sewageC01DeviceMessage != null) {
            PhoneSewageC01RealMsgInfo phoneSewageC01RealMsgInfo = getOneRealDeviceInfoDetail(sewageC01DeviceMessage);
            jsonString = JSON.toJSONString(phoneSewageC01RealMsgInfo);
        }
        return jsonString;
    }

    /**
     * 212设备-常州建春种鸡场
     *
     * @param userId
     * @param devNum
     * @return
     * @throws Exception
     */
    private String selectRealDeviceInfoDetail212(String userId, String devNum) throws Exception {
        SewageC212DeviceMessage sewageC212DeviceMessage = getRealSewageC212DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (sewageC212DeviceMessage != null) {
            PhoneSewageC01RealMsgInfo phoneSewageC212RealMsgInfo = getOneRealDeviceInfoDetail212(sewageC212DeviceMessage);
            jsonString = JSON.toJSONString(phoneSewageC212RealMsgInfo);
        }
        return jsonString;
    }

    private String selectHisDeviceInfo211(String userId, String devNum, String day) throws Exception {
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
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
            sewageC01DMHisList = sewageC01DMService.selectPhoneHisSewageC01ByDateAndId(devNum, sStartDate, sEndDate);
            //ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(deviceId, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            //ec01DeviceMessageList =  ec01DeviceMessageService.selectEC01ByByORGIdAndRoleId(deviceId, sStartDate,sEndDate);;
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC01DMHisList = sewageC01DMService.selectPhoneHisSewageC01ByDateAndId(devNum, sStartDate, sEndDate);
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

    private String selectHisDeviceInfo212(String userId, String devNum, String day) throws Exception {
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
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
            PSC01HisMsgInfo psc01HisMsgInfo = new PSC01HisMsgInfo(sewageC212DMHisList,"212");
            jsonString = JSON.toJSONString(psc01HisMsgInfo);
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
            sewageC01DeviceMessage = sewageC01DMService.selectSewageC01ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC01DeviceMessage = sewageC01DMService.selectSewageC01ByDeviceId(devNum);
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
            sewageC01DeviceMessageList = sewageC01DMService.selectSewageC01ByORGId(orgId);
        } else {
            sewageC01DeviceMessageList = sewageC01DMService.selectSewageC01ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return sewageC01DeviceMessageList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary211(List<SewageC01DeviceMessage> sewageC01DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (SewageC01DeviceMessage sewageC01DeviceMessage : sewageC01DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary211(sewageC01DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary211(SewageC01DeviceMessage sewageC01DeviceMessage) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = sewageC01DeviceMessage.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(sewageC01DeviceMessage.getDSerialNum());
        phoneRealDeviceInfo.setTitle(sewageC01DeviceMessage.getDName());
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
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

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary212(List<SewageC212DeviceMessage> sewageC212DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (SewageC212DeviceMessage sewageC212DeviceMessage : sewageC212DeviceMessageList
                ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary212(sewageC212DeviceMessage);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary212(SewageC212DeviceMessage sewageC212DeviceMessage) {
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

    private PhoneSewageC01RealMsgInfo getOneRealDeviceInfoDetail212(SewageC212DeviceMessage sewageC212DeviceMessage) {
        PhoneSewageC01RealMsgInfo phoneSewageC01RealMsgInfo = new PhoneSewageC01RealMsgInfo();

        //形成信号信息
        List<PhoneSewageC01RealData> phoneSewageC01RealDataList = sewageC212DeviceMessage.getPhoneRealMsgInfoDetail();
        //形成设备信息
        phoneSewageC01RealMsgInfo.setDevName(sewageC212DeviceMessage.getDName());
        phoneSewageC01RealMsgInfo.setDevNum(sewageC212DeviceMessage.getDSerialNum());
        phoneSewageC01RealMsgInfo.setPhoneSewageC01RealDataList(phoneSewageC01RealDataList);
        return phoneSewageC01RealMsgInfo;
    }
}
