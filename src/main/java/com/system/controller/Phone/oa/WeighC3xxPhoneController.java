package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.BaseDeviceMessage;
import com.system.po.Device.WeighC312DM;
import com.system.po.DeviceRoleInfo;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.Base.*;
import com.system.po.Phone.PWeighC312.PWeighC312Detail;
import com.system.po.Phone.PWeighC312.PWeighC312His;
import com.system.po.Phone.PWeighC312.PWeighC312Summary;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneTree;
import com.system.po.RoleInfo;
import com.system.po.UserOAEas;
import com.system.service.DeviceRoleInfoService;
import com.system.service.ORGTreeNodeService;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.RoleInfoService;
import com.system.service.WeighC312DMService;
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
 * @ClassName WeighC312PhoneController
 * @Description 散装料塔称重系统
 * @Author tangbao
 * @Date 2019-11-01 11:25
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/weighC")
public class WeighC3xxPhoneController extends BaseController{
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private WeighC312DMService weighC312DMService;

    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild());
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
        List<ORGTreeNode> orgTreeNodeList312 = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName("312");
            orgTreeNodeList312 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("312", roleInfoListAdmin);
        } else {
            orgTreeNodeList312 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("312", roleInfoList);
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据"));
        List<PhoneTree> phoneTrees = new ArrayList<>();
        if (orgTreeNodeList312.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList312);
            PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
            phoneTrees.add(phoneTree);
        }
        if(phoneTrees.size() > 0)
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneTrees));
        return jsonString;
    }

    @RequestMapping(value = "selectSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSummary(String userId, String orgId) throws Exception {
        List<ORGTreeNode> orgTreeNodeList = orgTreeNodeService.selectORGInfoByOrgId(orgId);
        String root = "";
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        for (ORGTreeNode orgTreeNode : orgTreeNodeList
        ) {
            if (orgTreeNode.getpId().equals("-1")) {
                root = orgTreeNode.getId();
                break;
            }
        }
        if (root.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
        if (root.equals("312")) {
            jsonString = this.selectRealDeviceInfoSummary312(userId, orgId);
        }

        return jsonString;
    }

    @RequestMapping(value = "selectDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDetail(String userId, String devNum) throws Exception {
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if(0x4000 <= Integer.parseInt(devNum,16) && Integer.parseInt(devNum,16) <= 0x47FF) {
            jsonString = this.selectRealDeviceInfoDetail312(userId, devNum);
        }else {
            jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备详细信息！"));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHis", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHis(String userId, String devNum, String day,String type) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户为空！"));
        if (devNum == null || devNum.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("设备为空！"));
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild());
        if (0x4000 <= Integer.parseInt(devNum, 16) && Integer.parseInt(devNum, 16) <= 0x47FF) {
            jsonString = this.selectHis312(userId, devNum, day,type);
        } else {
            jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备历史数据！"));
        }
        return jsonString;
    }


    /*****************************WeighC312 Start*********************************/
    private String selectRealDeviceInfoSummary312(String userId, String orgId) throws Exception {
        List<WeighC312DM> weighC312DMList = getRealWeighC312DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        if (weighC312DMList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList  = getPhoneRealDeviceInfoSummary(weighC312DMList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
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
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return weighC312DMList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            weighC312DMList = weighC312DMService.selectWeighC312ByORGId(orgId);
        } else {
            weighC312DMList = weighC312DMService.selectWeighC312ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return weighC312DMList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<WeighC312DM> weighC312DMList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (WeighC312DM dm : weighC312DMList
        ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(dm);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(WeighC312DM weighC312DM) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = weighC312DM.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(weighC312DM.getDSerialNum());
        phoneRealDeviceInfo.setTitle(weighC312DM.getDName());
        if(weighC312DM.getDState().equals("在线")){
            phoneRealDeviceInfo.setState("1");
        }else{
            phoneRealDeviceInfo.setState("0");
        }
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
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
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到设备详细信息！"));
        if (weighC312DM != null) {
            PhoneDetail phoneDetail = getOneRealDeviceInfoDetail312(weighC312DM);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneDetail));
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
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到历史数据！"));
        if (weighc312DMHisList.size() > 0) {
            PhoneHis phoneHis = new PWeighC312His(weighc312DMHisList,type);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneHis));
        }
        return jsonString;
    }
    /***************************WeighC312 End***************************************/
}
