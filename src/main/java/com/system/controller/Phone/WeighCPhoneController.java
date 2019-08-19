package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.WeighC312DM;
import com.system.po.Phone.Base.*;
import com.system.po.Phone.PWeighC312.PWeighC312Detail;
import com.system.po.Phone.PWeighC312.PWeighC312His;
import com.system.po.Phone.PWeighC312.PWeighC312Summary;
import com.system.service.*;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.util.RoleInfoListUtil;
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
@RequestMapping("/phone/weighc")
public class WeighCPhoneController {

    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;
    @Autowired
    private WeighC312DMService weighC312DMService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;

    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        List<ORGTreeNode> orgTreeNodeList = new ArrayList<ORGTreeNode>();
        List<ORGTreeNode> orgTreeNodeList312 = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin312 = roleInfoService.selectRoleInfoByRoleName("312");
            orgTreeNodeList312 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("312", roleInfoListAdmin312);
            orgTreeNodeList.addAll(orgTreeNodeList312);
        } else {
            orgTreeNodeList312 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("312", roleInfoList);
            orgTreeNodeList.addAll(orgTreeNodeList312);
        }
        String jsonString = "[]";
        if (orgTreeNodeList.size() > 0) {
            jsonString = JSON.toJSONString(orgTreeNodeList);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSummary(String userId, String orgId) throws Exception {
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
        if (root.equals("312")) {
            jsonString = this.selectRealDeviceInfoSummary312(userId, orgId);
        }

        return jsonString;
    }

    @RequestMapping(value = "selectDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDetail(String userId, String devNum) throws Exception {
        String jsonString = "[]";
        if(0x4000 <= Integer.parseInt(devNum,16) && Integer.parseInt(devNum,16) <= 0x47FF) {
            jsonString = this.selectRealDeviceInfoDetail312(userId, devNum);
        }else {
            jsonString = this.selectRealDeviceInfoDetail312(userId, devNum);
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHis", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHis(String userId, String devNum, String day,String type) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        if (devNum == null || devNum.equals(""))
            return "[]";
        String jsonString = "[]";
        if (0x4000 <= Integer.parseInt(devNum, 16) && Integer.parseInt(devNum, 16) <= 0x47FF) {
            jsonString = this.selectHis312(userId, devNum, day,type);
        } else {
            jsonString = this.selectHis312(userId, devNum, day,type);
        }
        return jsonString;
    }

    /*****************************WeighC312 Start*********************************/
    private String selectRealDeviceInfoSummary312(String userId, String orgId) throws Exception {
        List<WeighC312DM> weighC312DMList = getRealWeighC312DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = "[]";
        if (weighC312DMList.size() > 0) {
            List<PhoneSummary> phoneSummaryList = getPhoneRealDeviceInfoSummary312(weighC312DMList);
            jsonString = JSON.toJSONString(phoneSummaryList);
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
    private List<WeighC312DM> getRealWeighC312DeviceMessageByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<WeighC312DM> weighC312DMList = new ArrayList<WeighC312DM>();
        if (userId == null || userId.equals(""))
            return weighC312DMList;
        if (orgId == null || orgId.equals(""))
            return weighC312DMList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return weighC312DMList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            weighC312DMList = weighC312DMService.selectWeighC312ByORGId(orgId);
        } else {
            weighC312DMList = weighC312DMService.selectWeighC312ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return weighC312DMList;
    }

    private List<PhoneSummary> getPhoneRealDeviceInfoSummary312(List<WeighC312DM> weighC312DMList) {
        List<PhoneSummary> phoneSummaryList = new ArrayList<PhoneSummary>();
        for (WeighC312DM weighC312DM : weighC312DMList
                ) {
            PhoneSummary phoneSummary = getOneRealDeviceInfoSummary312(weighC312DM);
            phoneSummaryList.add(phoneSummary);
        }
        return phoneSummaryList;
    }

    private PhoneSummary getOneRealDeviceInfoSummary312(WeighC312DM weighC312DM) {
        PhoneSummary phoneSummary = new PWeighC312Summary();
        //形成信号信息
        List<PhoneOneData> phoneOneDataList = weighC312DM.getPhoneSummary();
        //形成设备信息
        phoneSummary.setDevNum(weighC312DM.getDSerialNum());
        phoneSummary.setTitle(weighC312DM.getDName());
        phoneSummary.setSenddate(weighC312DM.getSendDate());
        phoneSummary.setState(weighC312DM.getDState());
        phoneSummary.setData(phoneOneDataList);
        return phoneSummary;
    }

    /**
     * 312设备-散装料塔称重
     *
     * @param userId
     * @param devNum
     * @return
     * @throws Exception
     */
    private String selectRealDeviceInfoDetail312(String userId, String devNum) throws Exception {
        WeighC312DM weighC312DM = getRealWeighC312DMByUserIdAndDevNum(userId, devNum);
        String jsonString = "[]";
        if (weighC312DM != null) {
            PhoneDetail phoneDetail = getOneRealDeviceInfoDetail312(weighC312DM);
            jsonString = JSON.toJSONString(phoneDetail);
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
    private WeighC312DM getRealWeighC312DMByUserIdAndDevNum(String userId, String devNum) throws Exception {
        WeighC312DM weighC312DM = null;
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
            weighC312DM = weighC312DMService.selectWeighC312ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    weighC312DM = weighC312DMService.selectWeighC312ByDeviceId(devNum);
                    break;
                }
            }
        }
        return weighC312DM;
    }

    private PhoneDetail getOneRealDeviceInfoDetail312(WeighC312DM weighC312DM) {
        PhoneDetail phoneDetail = new PWeighC312Detail();

        //形成信号信息
        List<PhonePartDetail> phonePartDetailList = weighC312DM.getPhoneDetail();
        //形成设备信息
        phoneDetail.setDevName(weighC312DM.getDName());
        phoneDetail.setDevNum(weighC312DM.getDSerialNum());
        phoneDetail.setPhonePartDetailList(phonePartDetailList);
        return phoneDetail;
    }

    /**
     *
     * @param userId
     * @param devNum
     * @param day
     * @param type 0：投料历史数据；1：放料历史数据
     * @return
     * @throws Exception
     */
    private String selectHis312(String userId, String devNum, String day,String type) throws Exception {
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
        sEndDate = sEndDate + " 23:59:59";
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, mDay);
        date = calendar.getTime();
        String sStartDate = simpleFormat.format(date);
        sStartDate = sStartDate + " 00:00:00";
        //获取时间-end
        List<BaseDeviceMessage> weighc312DMHisList = new ArrayList<BaseDeviceMessage>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            weighc312DMHisList = weighC312DMService.selectPhoneHisWeighC312ByDateAndId(devNum,type, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
                    ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    weighc312DMHisList = weighC312DMService.selectPhoneHisWeighC312ByDateAndId(devNum,type, sStartDate, sEndDate);
                    break;
                }
            }
        }
        String jsonString = "[]";
        if (weighc312DMHisList.size() > 0) {
            PhoneHis phoneHis = new PWeighC312His(weighc312DMHisList,type);
            jsonString = JSON.toJSONString(phoneHis);
        }
        return jsonString;
    }
    /***************************WeighC312 End***************************************/
}
