package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.Hj212C213Chart;
import com.system.po.*;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.Hj212C213.Hj212C213DayData;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Phone.PhoneHj212C213.PHj212C213HisDataContent;
import com.system.po.Phone.PhoneHj212C213.PHj212C213HisMsgInfo;
import com.system.po.Phone.PhoneHj212C213.PhoneHj212C213RealData;
import com.system.po.Phone.PhoneHj212C213.PhoneHj212C213RealMsgInfo;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneTree;
import com.system.po.parameter.ParameterCharts;
import com.system.service.DeviceInfoService;
import com.system.service.DeviceRoleInfoService;
import com.system.service.Hj212C213DMService;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.RoleInfoService;
import com.system.util.DeviceUtil;
import com.system.util.Hj212C213Util;
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
import java.util.*;

/**
 * @ClassName Env212C213PhoneController
 * @Description 立华水质-环保2017
 * @Author tangbao
 * @Date 2019-11-01 13:50
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/sewageC213")
public class SewageC213PhoneController extends BaseController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private DeviceUtilController deviceUtilController;
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private Hj212C213DMService hj212C213DMService;
    @Autowired
    private Hj212C213Chart hj212C213Chart;

    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild());
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
        List<ORGTreeNode> orgTreeNodeList213 = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName("213");
            orgTreeNodeList213 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("213", roleInfoListAdmin);
        } else {
            orgTreeNodeList213 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("213", roleInfoList);
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        List<PhoneTree> phoneTrees = new ArrayList<>();
        if (orgTreeNodeList213.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(orgTreeNodeList213);
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
        List<Hj212C213DeviceMessage> hj212C213DMList = getRealHj212C213DeviceMessageByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (hj212C213DMList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(hj212C213DMList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        Hj212C213DeviceMessage hj212C213DM = getRealHj212C213DeviceMessageByUserIdAndDevNum(userId, devNum);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (hj212C213DM != null) {
            PhoneHj212C213RealMsgInfo phoneHj212C213RealMsgInfo = getOneRealDeviceInfoDetail(hj212C213DM);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneHj212C213RealMsgInfo));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectECharts", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId, String sQueryParam, String devNum, String day) throws Exception {
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        PhoneEChartsOptions phoneEChartsOptions = getParameterCharts(userId, sQueryParam, devNum, day);
        if(phoneEChartsOptions !=null) {
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneEChartsOptions));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectHis", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisData(String userId, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户为空！"));
        if (devNum == null || devNum.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild("设备为空！"));
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
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

        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未查询到有效数据！"));
        PHj212C213HisMsgInfo pHj212C213HisMsgInfo = null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            pHj212C213HisMsgInfo = this.getOneParamData(devNum, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    pHj212C213HisMsgInfo = this.getOneParamData(devNum, sStartDate, sEndDate);
                    break;
                }
            }
        }
        if(pHj212C213HisMsgInfo != null){
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(pHj212C213HisMsgInfo));
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
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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
        if(hj212C213DeviceMessage.getDState().equals("在线")){
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
    private Hj212C213DeviceMessage getRealHj212C213DeviceMessageByUserIdAndDevNum(String userId, String devNum) throws Exception {
        Hj212C213DeviceMessage hj212C213DeviceMessage = null;
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
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

    private PhoneEChartsOptions getParameterCharts(String userId, String sQueryParam, String devNum, String day) throws Exception {
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return null;

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
        PhoneEChartsOptions phoneEChartsOptions = null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            phoneEChartsOptions = this.getOneParamChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    phoneEChartsOptions = this.getOneParamChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
                    break;
                }
            }
        }
        return phoneEChartsOptions;
    }

    private PhoneEChartsOptions getOneParamChart(String[] sDeviceIds, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        Map<String, List<Hj212C213DeviceMessage>> hj212C213MapByDate = hj212C213DMService.selectHisHj212C213ByDateAndIDs(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (hj212C213MapByDate == null || hj212C213MapByDate.size() < 1)
            return null;
        List<DeviceInfo> deviceInfoList = deviceUtilController.getDeviceInfoList(sDeviceIds);
        if (deviceInfoList == null || deviceInfoList.size() < 1)
            return null;
        Map<String, String> deviceInfoMap = deviceUtilController.getDeviceInfoMap(deviceInfoList);
        PhoneEChartsOptions phoneEChartsOptions = hj212C213Chart.getECharts(sQueryParam, deviceInfoMap, hj212C213MapByDate);
        if (phoneEChartsOptions == null)
            return null;
        return phoneEChartsOptions;
    }

    private PHj212C213HisMsgInfo getOneParamData(String sDeviceId, String sStartDate, String sEndDate) throws Exception {
        String[] sDeviceIds = new String[1];
        sDeviceIds[0] = sDeviceId;
        Map<String, Hj212C213DayData> hj212C213MapByDate = hj212C213DMService.selectHisHj212C213ByDateAndIDsTwoParam(sDeviceIds, sStartDate, sEndDate);
        List<String> sDateList = Hj212C213Util.getHj212C213DayDate(hj212C213MapByDate);
        List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByIDs(sDeviceIds);
        List<PHj212C213HisDataContent> pHj212C213HisDataContentList = new ArrayList<>();
        if (deviceInfoList.size() < 1)
            return null;
        for (String sDate : sDateList
        ) {
            Hj212C213DayData hj212C213DayData = hj212C213MapByDate.get(sDate);
            PHj212C213HisDataContent pHj212C213HisDataContent = new PHj212C213HisDataContent(hj212C213DayData);
            pHj212C213HisDataContentList.add(pHj212C213HisDataContent);
        }
        PHj212C213HisMsgInfo pHj212C213HisMsgInfo = new PHj212C213HisMsgInfo(deviceInfoList.get(0).getDSerialNum(), deviceInfoList.get(0).getDName());
        pHj212C213HisMsgInfo.setpHj212C213HisDataContentList(pHj212C213HisDataContentList);
        return pHj212C213HisMsgInfo;
    }
}
