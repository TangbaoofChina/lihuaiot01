package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.Phone.Lhsf0ap1.Lhsf0ap1DMPhone;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.*;
import com.system.po.RoleInfo;
import com.system.service.DeviceRoleInfoService;
import com.system.service.Lhsf0ap1DMService;
import com.system.service.Phone.PhoneBootStrapTreeNodeService;
import com.system.service.RoleInfoService;
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

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Lhsf0ap1PhoneController
 * @Description 立华-生防  物资熏蒸
 * @Author tangbao
 * @Date 2020-07-02 16:53
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/lhsf0ap1")
public class Lhsf0ap1PhoneController extends BaseController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private Lhsf0ap1DMService dmService;

    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild());
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));
        List<ORGTreeNode> oTL = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName("LHSF0Ap1");
            oTL = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("LHSF0Ap1", roleInfoListAdmin);
        } else {
            oTL = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("LHSF0Ap1", roleInfoList);
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        List<PhoneTree> phoneTrees = new ArrayList<>();
        if (oTL.size() > 0) {
            List<PhoneTree> phoneTreeList = DeviceUtil.getPhoneTreeList(oTL);
            PhoneTree phoneTree = PhoneTreeNodeMerger.merge(phoneTreeList);
            phoneTrees.add(phoneTree);
        }
        if(phoneTrees.size() > 0)
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneTrees));
        return jsonString;
    }

    //获取没有经过对象转换的对象
    @RequestMapping(value = "selectSummary01", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary01(String userId, String orgId) throws Exception {
        List<Lhsf0ap1DM> dmList = getRealDMByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (dmList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary01(dmList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
        }
        return jsonString;
    }

    //获取没有经过对象转换的对象
    @RequestMapping(value = "selectSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<Lhsf0ap1DM> dmList = getRealDMByUserIdAndOrgId(userId, orgId);
        //手机端显示效果需要对对象进行修改
        List<Lhsf0ap1DMPhone> dmPhoneList = formatPhoneObj(dmList);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (dmList.size() > 0) {
            List<PhoneRealDeviceInfoObj> phoneRealDeviceInfoObjList = getPhoneRealDeviceInfoSummary(dmPhoneList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoObjList));
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
    private List<Lhsf0ap1DM> getRealDMByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<Lhsf0ap1DM> dmList = new ArrayList<>();
        if (userId == null || userId.equals(""))
            return dmList;
        if (orgId == null || orgId.equals(""))
            return dmList;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return dmList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            dmList = dmService.selectByORGId(orgId);
        } else {
            dmList = dmService.selectByORGIdAndRoleId(orgId, roleInfoList);
        }
        return dmList;
    }

    //手机端的显示格式和实例对象有点差别，需要做一下转换
    private List<Lhsf0ap1DMPhone> formatPhoneObj(List<Lhsf0ap1DM> dmList){
        List<Lhsf0ap1DMPhone> dmPhoneList = new ArrayList<>();
        for (Lhsf0ap1DM dm:dmList
             ) {
            Lhsf0ap1DMPhone dmPhone = new Lhsf0ap1DMPhone(dm);
            dmPhoneList.add(dmPhone);
        }
        return dmPhoneList;
    }

    private List<PhoneRealDeviceInfoObj> getPhoneRealDeviceInfoSummary(List<Lhsf0ap1DMPhone> dmPhoneList) {
        List<PhoneRealDeviceInfoObj> phoneRealDeviceInfoObjList = new ArrayList<>();
        for (Lhsf0ap1DMPhone dmPhone : dmPhoneList
        ) {
            PhoneRealDeviceInfoObj phoneRealDeviceInfoObj = getOneRealDeviceInfoSummary(dmPhone);
            phoneRealDeviceInfoObjList.add(phoneRealDeviceInfoObj);
        }
        return phoneRealDeviceInfoObjList;
    }

    private PhoneRealDeviceInfoObj getOneRealDeviceInfoSummary(Lhsf0ap1DMPhone dmPhone) {
        PhoneRealDeviceInfoObj phoneRealDeviceInfo = new PhoneRealDeviceInfoObj();
        //形成信号信息
        List<PhoneRealMsgInfoObj> phoneRealMsgInfoObjList = dmPhone.getPhoneRealMsgInfoObjSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(dmPhone.getDSerialNum());
        phoneRealDeviceInfo.setTitle(dmPhone.getDName());
        if(dmPhone.getDState().equals("在线")){
            phoneRealDeviceInfo.setState("1");
        }else{
            phoneRealDeviceInfo.setState("0");
        }
        phoneRealDeviceInfo.setData(phoneRealMsgInfoObjList);
        return phoneRealDeviceInfo;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary01(List<Lhsf0ap1DM> dmList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (Lhsf0ap1DM dm : dmList
        ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary01(dm);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary01(Lhsf0ap1DM dm) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = dm.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(dm.getDSerialNum());
        phoneRealDeviceInfo.setTitle(dm.getDName());
        if(dm.getDState().equals("在线")){
            phoneRealDeviceInfo.setState("1");
        }else{
            phoneRealDeviceInfo.setState("0");
        }
        phoneRealDeviceInfo.setData(phoneRealMsgInfoList);
        return phoneRealDeviceInfo;
    }



}
