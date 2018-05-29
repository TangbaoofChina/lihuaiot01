package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.po.Device.SewageC01DMHis;
import com.system.po.Device.SewageC01DeviceMessage;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealData;
import com.system.po.Phone.PhoneSewageC01.PhoneSewageC01RealMsgInfo;
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
@RequestMapping("/phone/sewagec01")
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
            //用污水处理的admin代替
            roleInfoAdmin.setRoleId("6AE5C6025D7B1035E0536800A8C0C8FD");
            roleInfoAdmin.setRoleName("211");
            roleInfoAdmin.setRoleDescribe("污水处理");
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
            jsonString = JSON.toJSONString(sewageC01DMHisList);
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

}
