package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.Lhrz01p1Chart;
import com.system.po.Device.Lhrz01p1DM;
import com.system.po.Device.Lhrz01p1DMHis;
import com.system.po.DeviceInfo;
import com.system.po.DeviceRoleInfo;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.Lhrz01p1.PLhrz01p1PartDetail;
import com.system.po.Phone.Lhrz01p1.PLhrz01p1Detail;
import com.system.po.Phone.Lhrz01p1.PLhrz01p1Summary;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneTree;
import com.system.po.RoleInfo;
import com.system.po.parameter.ParameterCharts;
import com.system.service.DeviceRoleInfoService;
import com.system.service.Lhrz01p1DMService;
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

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Lhrz01p1PhoneController
 * @Description 猪用环控器
 * @Author tangbao
 * @Date 2020-07-28 18:50
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/lhrz01p1")
public class Lhrz01p1PhoneController extends BaseController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private Lhrz01p1DMService dmService;
    @Autowired
    private DeviceUtilController deviceUtilController;
    @Autowired
    private Lhrz01p1Chart dmChart;

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
            List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName("LHRZ01p1");
            oTL = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("LHRZ01p1", roleInfoListAdmin);
        } else {
            oTL = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("LHRZ01p1", roleInfoList);
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
    @RequestMapping(value = "selectSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary01(String userId, String orgId) throws Exception {
        List<Lhrz01p1DM> dmList = getRealDMByUserIdAndOrgId(userId, orgId);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (dmList.size() > 0) {
            List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = getPhoneRealDeviceInfoSummary(dmList);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfoList));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectDetail", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoDetail(String userId, String devNum) throws Exception {
        Lhrz01p1DM dm = getRealDMByUserIdAndDevNum(userId, devNum);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (dm != null) {
            PLhrz01p1Detail pRDI = getOneRealDeviceInfoDetail(dm);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(pRDI));
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


    /**
     * 通过用户ID和组织ID查询设备实时数据-概要信息
     *
     * @param userId
     * @param orgId
     * @return
     * @throws Exception
     */
    private List<Lhrz01p1DM> getRealDMByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<Lhrz01p1DM> dmList = new ArrayList<>();
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

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<Lhrz01p1DM> dmList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (Lhrz01p1DM dm : dmList
        ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(dm);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(Lhrz01p1DM dm) {
        PLhrz01p1Summary summary = new PLhrz01p1Summary();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = dm.getPhoneRealMsgInfoSummary();
        //形成设备信息
        summary.setDevNum(dm.getDSerialNum());
        summary.setTitle(dm.getDName());
        summary.setDate(dm.getSendDate());
        if(dm.getDState().equals("在线")){
            summary.setState("1");
        }else{
            summary.setState("0");
        }
        summary.setData(phoneRealMsgInfoList);
        return summary;
    }

    /**
     * 通过用户ID和设备ID查询设备实时数据-详细信息
     *
     * @param userId
     * @param devNum
     * @return
     */
    private Lhrz01p1DM getRealDMByUserIdAndDevNum(String userId, String devNum) throws Exception {
        Lhrz01p1DM dm = null;
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            dm = dmService.selectByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    dm = dmService.selectByDeviceId(devNum);
                    break;
                }
            }
        }
        return dm;
    }

    private PLhrz01p1Detail getOneRealDeviceInfoDetail(Lhrz01p1DM dm) {
        PLhrz01p1Detail pRDI = new PLhrz01p1Detail();
        //形成信号信息
        List<PLhrz01p1PartDetail> partDetails = dm.getPhoneDetail();
        //形成设备信息
        pRDI.setDevNum(dm.getDSerialNum());
        pRDI.setTitle(dm.getDName());
        pRDI.setDate(dm.getSendDate());
        if(dm.getDState().equals("在线")){
            pRDI.setState("1");
        }else{
            pRDI.setState("0");
        }
        pRDI.setData(partDetails);
        return pRDI;
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
        Map<String, List<Lhrz01p1DMHis>> dmMap = dmService.selectHisByDateAndIDs(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        if (dmMap == null || dmMap.size() < 1)
            return null;
        List<DeviceInfo> deviceInfoList = deviceUtilController.getDeviceInfoList(sDeviceIds);
        if (deviceInfoList == null || deviceInfoList.size() < 1)
            return null;
        Map<String, String> deviceInfoMap = deviceUtilController.getDeviceInfoMap(deviceInfoList);
        PhoneEChartsOptions phoneEChartsOptions = dmChart.getECharts(sQueryParam, deviceInfoMap, dmMap);
        if (phoneEChartsOptions == null)
            return null;
        return phoneEChartsOptions;
    }
}
