package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.FeedC411.FeedC411DMFY;
import com.system.po.Device.FeedC411DM;
import com.system.po.DeviceRoleInfo;
import com.system.po.FeedC411.PFC411;
import com.system.po.FeedC411.PFC411TempInfo;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.RoleInfo;
import com.system.po.UserOAEas;
import com.system.service.DeviceRoleInfoService;
import com.system.service.FeedC411DMService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.service.RoleInfoService;
import com.system.util.RoleInfoListUtil;
import com.system.util.msg.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/feedC411")
public class FeedC411PhoneController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private FeedC411DMService feedC411DMService;

    @RequestMapping(value = "selectRealDeviceInfoSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<FeedC411DM> feedC411DMList = getRealDMByUserIdAndOrgId(userId, orgId);
        for (FeedC411DM feedC411DM:feedC411DMList
             ) {
            feedC411DM.formatTemp();
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild());
        if (feedC411DMList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(feedC411DMList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectRealDeviceInfoDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        FeedC411DM feedC411DM = getRealDMByUserIdAndDevNum(userId, devNum);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild());
        if (feedC411DM != null) {
            feedC411DM.formatTemp();
            PFC411 PFC411 = getOneRealDeviceInfoDetail(feedC411DM);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(PFC411));
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
    private List<FeedC411DM> getRealDMByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<FeedC411DM> feedC411DMList = new ArrayList<FeedC411DM>();
        if (userId == null || userId.equals(""))
            return feedC411DMList;
        if (orgId == null || orgId.equals(""))
            return feedC411DMList;
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return feedC411DMList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            feedC411DMList = feedC411DMService.selectByORGId(orgId);
        } else {
            feedC411DMList = feedC411DMService.selectByORGIdAndRoleId(orgId, roleInfoList);
        }
        return feedC411DMList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<FeedC411DM> feedC411DMList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (FeedC411DM feedC411DM : feedC411DMList
        ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(feedC411DM);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(FeedC411DM feedC411DM) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = feedC411DM.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(feedC411DM.getDSerialNum());
        phoneRealDeviceInfo.setTitle(feedC411DM.getDName());
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
    private FeedC411DM getRealDMByUserIdAndDevNum(String userId, String devNum) throws Exception {
        FeedC411DM feedC411DM = null;
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
            feedC411DM = feedC411DMService.selectByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    feedC411DM = feedC411DMService.selectByDeviceId(devNum);
                    break;
                }
            }
        }
        return feedC411DM;
    }

    private PFC411 getOneRealDeviceInfoDetail(FeedC411DM feedC411DM) {
        PFC411 pfc411 = new PFC411();

        //形成信号信息
        PFC411TempInfo siloTempInfo = feedC411DM.getPhoneRealMsgInfoDetail();
        //形成设备信息
        pfc411.setDevName(feedC411DM.getDName());
        pfc411.setDevNum(feedC411DM.getDSerialNum());
        pfc411.setSiloTempInfo(siloTempInfo);
        return pfc411;
    }
}
