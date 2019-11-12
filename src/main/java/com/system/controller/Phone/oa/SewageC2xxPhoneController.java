package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.*;
import com.system.po.DeviceRoleInfo;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PSC01HisMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealMsgInfo;
import com.system.po.Phone.PhoneTree;
import com.system.po.RoleInfo;
import com.system.po.UserOAEas;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.util.DeviceUtil;
import com.system.util.PhoneTreeNodeMerger;
import com.system.util.RoleInfoListUtil;
import com.system.util.msg.ResponseUtil;
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

/**
 * @ClassName SewageC2XXPhoneController
 * @Description 环保室污水站211,212,214系列协议接口
 * @Author tangbao
 * @Date 2019-11-01 8:50
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/sewageC2")
public class SewageC2xxPhoneController extends BaseController{

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private SewageC01DeviceMessageService sewageC211DMService;
    @Autowired
    private SewageC212DMService sewageC212DMService;
    @Autowired
    private SewageC214DMService sewageC214DMService;

    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild());;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));;
        List<ORGTreeNode> orgTreeNodeList211 = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList212 = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList214 = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin211 = roleInfoService.selectRoleInfoByRoleName("211");
            List<RoleInfo> roleInfoListAdmin212 = roleInfoService.selectRoleInfoByRoleName("212");
            List<RoleInfo> roleInfoListAdmin214 = roleInfoService.selectRoleInfoByRoleName("214");
            orgTreeNodeList211 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("211", roleInfoListAdmin211);
            orgTreeNodeList212 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("212", roleInfoListAdmin212);
            orgTreeNodeList214 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("214", roleInfoListAdmin214);
        } else {
            orgTreeNodeList211 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("211", roleInfoList);
            orgTreeNodeList212 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("212", roleInfoList);
            orgTreeNodeList214 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("214", roleInfoList);
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        List<PhoneTree> phoneTrees = new ArrayList<>();
        if (orgTreeNodeList211.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList211);
            PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
            phoneTrees.add(phoneTree);
        }
        if (orgTreeNodeList212.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList212);
            PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
            phoneTrees.add(phoneTree);
        }
        if (orgTreeNodeList214.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList214);
            PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
            phoneTrees.add(phoneTree);
        }
        if(phoneTrees.size() > 0)
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneTrees));
        return jsonString;
    }

    @RequestMapping(value = "selectSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<ORGTreeNode> orgTreeNodeList = orgTreeNodeService.selectORGInfoByOrgId(orgId);
        String root = "";
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild());
        for (ORGTreeNode orgTreeNode : orgTreeNodeList
        ) {
            if (orgTreeNode.getpId().equals("-1")) {
                root = orgTreeNode.getId();
                break;
            }
        }
        if (root.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
        if (root.equals("211")) {
            jsonString = this.selectRealDeviceInfoSummary211(userId, orgId);
        } else if(root.equals("212")){
            jsonString = this.selectRealDeviceInfoSummary212(userId, orgId);
        } else if(root.equals("214")){
            jsonString = this.selectRealDeviceInfoSummary214(userId, orgId);
        }else{
            jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备类型！"));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备详细信息！"));
        if (devNum.equals("2001")) {
            jsonString = this.selectRealDeviceInfoDetail211(userId, devNum);
        } else if (0x2001 < Integer.parseInt(devNum, 16) && Integer.parseInt(devNum, 16) < 0x2800) {
            jsonString = this.selectRealDeviceInfoDetail212(userId, devNum);
        } else if (0x27FF < Integer.parseInt(devNum, 16) && Integer.parseInt(devNum, 16) < 0x3000) {
            jsonString = this.selectRealDeviceInfoDetail214(userId, devNum);
        } else {
            jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备详细信息！"));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHis", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户为空！"));
        if (devNum == null || devNum.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("设备为空！"));
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild());
        if (devNum.equals("2001")) {
            jsonString = this.selectHisDeviceInfo211(userId, devNum, day);
        } else if (0x2001 < Integer.parseInt(devNum, 16) && Integer.parseInt(devNum, 16) < 0x2800) {
            jsonString = this.selectHisDeviceInfo212(userId, devNum, day);
        } else if (0x27FF < Integer.parseInt(devNum, 16) && Integer.parseInt(devNum, 16) < 0x3000) {
            jsonString = this.selectHisDeviceInfo214(userId, devNum, day);
        } else {
            jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备详细信息！"));
        }
        return jsonString;
    }

    /**************************************211 start*************************/
    private String selectRealDeviceInfoSummary211(String userId, String orgId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = getRealSewageC211DMByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC01DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary211(sewageC01DeviceMessageList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
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
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC01DeviceMessage != null) {
            PhoneSewageC01RealMsgInfo phoneSewageC211RealMsgInfo = getOneRealDeviceInfoDetail211(sewageC01DeviceMessage);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneSewageC211RealMsgInfo));
        }
        return jsonString;
    }

    private String selectHisDeviceInfo211(String userId, String devNum, String day) throws Exception {
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
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
        List<SewageC01DMHis> sewageC01DMHisList = new ArrayList<SewageC01DMHis>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC01DMHisList = sewageC211DMService.selectPhoneHisSewageC01ByDateAndId(devNum, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC01DMHisList = sewageC211DMService.selectPhoneHisSewageC01ByDateAndId(devNum, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到历史数据！"));
        if (sewageC01DMHisList.size() > 0) {
            PSC01HisMsgInfo psc01HisMsgInfo = new PSC01HisMsgInfo(sewageC01DMHisList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(psc01HisMsgInfo));
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
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC01DeviceMessage = sewageC211DMService.selectSewageC01ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC01DeviceMessage = sewageC211DMService.selectSewageC01ByDeviceId(devNum);
                    break;
                }
            }
        }
        return sewageC01DeviceMessage;
    }

    private PhoneSewageC01RealMsgInfo getOneRealDeviceInfoDetail211(SewageC01DeviceMessage sewageC01DeviceMessage) {
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
    private List<SewageC01DeviceMessage> getRealSewageC211DMByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<SewageC01DeviceMessage> sewageC01DeviceMessageList = new ArrayList<SewageC01DeviceMessage>();
        if (userId == null || userId.equals(""))
            return sewageC01DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return sewageC01DeviceMessageList;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return sewageC01DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC01DeviceMessageList = sewageC211DMService.selectSewageC01ByORGId(orgId);
        } else {
            sewageC01DeviceMessageList = sewageC211DMService.selectSewageC01ByByORGIdAndRoleId(orgId, roleInfoList);
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
        if(sewageC01DeviceMessage.getDState().equals("在线")){
            phoneRealDeviceInfo.setState("1");
        }else{
            phoneRealDeviceInfo.setState("0");
        }
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }
    /**************************************211 end*************************/

    /**************************************212 start*************************/
    private String selectRealDeviceInfoSummary212(String userId, String orgId) throws Exception {
        List<SewageC212DeviceMessage> sewageC212DeviceMessageList = getRealSewageC212DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC212DeviceMessageList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary212(sewageC212DeviceMessageList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
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
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC212DeviceMessage != null) {
            PhoneSewageC01RealMsgInfo phoneSewageC212RealMsgInfo = getOneRealDeviceInfoDetail212(sewageC212DeviceMessage);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneSewageC212RealMsgInfo));
        }
        return jsonString;
    }

    private String selectHisDeviceInfo212(String userId, String devNum, String day) throws Exception {
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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
        List<BaseDeviceMessage> sewageC212DMHisList = new ArrayList<BaseDeviceMessage>();
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
        String jsonString =  JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC212DMHisList.size() > 0) {
            PSC01HisMsgInfo psc01HisMsgInfo = new PSC01HisMsgInfo(sewageC212DMHisList,"212");
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(psc01HisMsgInfo));
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
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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
        if(sewageC212DeviceMessage.getDState().equals("在线")){
            phoneRealDeviceInfo.setState("1");
        }else{
            phoneRealDeviceInfo.setState("0");
        }
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
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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
    /**************************************212 end*************************/

    /**************************************214 start*************************/
    private String selectRealDeviceInfoSummary214(String userId, String orgId) throws Exception {
        List<SewageC214DM> sewageC214DMList = getRealSewageC214DMByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC214DMList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary214(sewageC214DMList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
        }
        return jsonString;
    }

    /**
     * 214设备-徐州邳城种鸡场
     *
     * @param userId
     * @param devNum
     * @return
     * @throws Exception
     */
    private String selectRealDeviceInfoDetail214(String userId, String devNum) throws Exception {
        SewageC214DM sewageC214DM = getRealSewageC214DMByUserIdAndDevNum(userId, devNum);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC214DM != null) {
            PhoneSewageC01RealMsgInfo phoneSewageC214RealMsgInfo = getOneRealDeviceInfoDetail214(sewageC214DM);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneSewageC214RealMsgInfo));
        }
        return jsonString;
    }

    private String selectHisDeviceInfo214(String userId, String devNum, String day) throws Exception {
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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
        List<BaseDeviceMessage> sewageC214DMHisList = new ArrayList<BaseDeviceMessage>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC214DMHisList = sewageC214DMService.selectPhoneHisSewageC214ByDateAndId(devNum, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC214DMHisList = sewageC214DMService.selectPhoneHisSewageC214ByDateAndId(devNum, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString =  JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (sewageC214DMHisList.size() > 0) {
            PSC01HisMsgInfo psc01HisMsgInfo = new PSC01HisMsgInfo(sewageC214DMHisList,"214");
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(psc01HisMsgInfo));
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
    private List<SewageC214DM> getRealSewageC214DMByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<SewageC214DM> sewageC214DMList = new ArrayList<SewageC214DM>();
        if (userId == null || userId.equals(""))
            return sewageC214DMList;
        if (orgId == null || orgId.equals(""))
            return sewageC214DMList;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return sewageC214DMList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC214DMList = sewageC214DMService.selectSewageC214ByORGId(orgId);
        } else {
            sewageC214DMList = sewageC214DMService.selectSewageC214ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return sewageC214DMList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary214(List<SewageC214DM> sewageC214DMList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (SewageC214DM sewageC214DM : sewageC214DMList
        ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary214(sewageC214DM);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary214(SewageC214DM sewageC214DM) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = sewageC214DM.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(sewageC214DM.getDSerialNum());
        phoneRealDeviceInfo.setTitle(sewageC214DM.getDName());
        if(sewageC214DM.getDState().equals("在线")){
            phoneRealDeviceInfo.setState("1");
        }else{
            phoneRealDeviceInfo.setState("0");
        }
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
    private SewageC214DM getRealSewageC214DMByUserIdAndDevNum(String userId, String devNum) throws Exception {
        SewageC214DM sewageC214DM = null;
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            sewageC214DM = sewageC214DMService.selectSewageC214ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    sewageC214DM = sewageC214DMService.selectSewageC214ByDeviceId(devNum);
                    break;
                }
            }
        }
        return sewageC214DM;
    }

    private PhoneSewageC01RealMsgInfo getOneRealDeviceInfoDetail214(SewageC214DM sewageC214DM) {
        PhoneSewageC01RealMsgInfo phoneSewageC01RealMsgInfo = new PhoneSewageC01RealMsgInfo();

        //形成信号信息
        List<PhoneSewageC01RealData> phoneSewageC01RealDataList = sewageC214DM.getPhoneRealMsgInfoDetail();
        //形成设备信息
        phoneSewageC01RealMsgInfo.setDevName(sewageC214DM.getDName());
        phoneSewageC01RealMsgInfo.setDevNum(sewageC214DM.getDSerialNum());
        phoneSewageC01RealMsgInfo.setPhoneSewageC01RealDataList(phoneSewageC01RealDataList);
        return phoneSewageC01RealMsgInfo;
    }
    /**************************************214 end*************************/
}
