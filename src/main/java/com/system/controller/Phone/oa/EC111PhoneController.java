package com.system.controller.Phone.oa;

import com.alibaba.fastjson.JSON;
import com.system.controller.Phone.oa.BaseController;
import com.system.po.Device.EC01DeviceMessage;
import com.system.po.DeviceRoleInfo;
import com.system.po.EChartsOptions.*;
import com.system.po.ORGTreeNode;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.Phone.PhoneRealDeviceInfo;
import com.system.po.Phone.PhoneRealMsgInfo;
import com.system.po.Phone.PhoneTree;
import com.system.po.RoleInfo;
import com.system.po.parameter.ChartsParameters;
import com.system.po.parameter.ParameterCharts;
import com.system.service.DeviceRoleInfoService;
import com.system.service.EC01DeviceMessageService;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EC111PhoneController
 * @Description 种禽环控器手机端
 * @Author tangbao
 * @Date 2019-10-31 15:15
 * @Version 1.0
 **/
@Controller
@CrossOrigin(maxAge = 3600)   //解决跨域问题
@RequestMapping("/phone/eC111")
public class EC111PhoneController extends BaseController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneBootStrapTreeNodeService phoneBootStrapTreeNodeService;
    @Autowired
    private DeviceRoleInfoService deviceRoleInfoService;
    @Autowired
    private EC01DeviceMessageService ec01DMService;


    /**
     * 查询组织
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectOrg", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrg(String userId) throws Exception {
        if (userId == null || userId.equals(""))
            return JSON.toJSONString(ResponseUtil.setResponsFaild());;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return JSON.toJSONString(ResponseUtil.setResponsFaild("用户不存在或无权限！"));;
        List<ORGTreeNode> orgTreeNodeList111 = new ArrayList<ORGTreeNode>();
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            List<RoleInfo> roleInfoListAdmin = roleInfoService.selectRoleInfoByRoleName("111");
            orgTreeNodeList111 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("111", roleInfoListAdmin);
        } else {
            orgTreeNodeList111 = phoneBootStrapTreeNodeService.selectOrgTreeNodeInfoByRoleId("111", roleInfoList);
        }
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        List<PhoneTree> phoneTrees = new ArrayList<>();
        if (orgTreeNodeList111.size() > 0) {
            List<PhoneTree> phoneTreeList411 = DeviceUtil.getPhoneTreeList(orgTreeNodeList111);
            PhoneTree phoneTree411 = PhoneTreeNodeMerger.merge(phoneTreeList411);
            phoneTrees.add(phoneTree411);
        }
        if(phoneTrees.size() > 0)
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneTrees));
        return jsonString;
    }

    @RequestMapping(value = "selectSummary", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRealDeviceInfoSummary(String userId, String orgId) throws Exception {
        List<EC01DeviceMessage> dmList = getRealDMByUserIdAndOrgId(userId, orgId);
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
        EC01DeviceMessage dm = getRealDMByUserIdAndDevNum(userId, devNum);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (dm != null) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoDetail(dm);
            jsonString = JSON.toJSONString(ResponseUtil.setResponseOk(phoneRealDeviceInfo));
        }
        return jsonString;
    }

    @RequestMapping(value = "selectECharts", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHisDeviceInfo(String userId, String sQueryParam, String devNum, String day) throws Exception {
        ParameterCharts parameterCharts = getParameterCharts(userId, sQueryParam, devNum, day);
        String jsonString = JSON.toJSONString(ResponseUtil.setResponsFaild("未获取到有效数据"));
        if (parameterCharts != null) {
            PhoneEChartsOptions phoneEChartsOptions = fromatEChartsOptions(parameterCharts.getChartsParameters());
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
    private List<EC01DeviceMessage> getRealDMByUserIdAndOrgId(String userId, String orgId) throws Exception {
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
        if (userId == null || userId.equals(""))
            return ec01DeviceMessageList;
        if (orgId == null || orgId.equals(""))
            return ec01DeviceMessageList;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return ec01DeviceMessageList;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            ec01DeviceMessageList = ec01DMService.selectEC01ByORGId(orgId);
        } else {
            ec01DeviceMessageList = ec01DMService.selectEC01ByByORGIdAndRoleId(orgId, roleInfoList);
        }
        return ec01DeviceMessageList;
    }

    private List<PhoneRealDeviceInfo> getPhoneRealDeviceInfoSummary(List<EC01DeviceMessage> ec01DeviceMessageList) {
        List<PhoneRealDeviceInfo> phoneRealDeviceInfoList = new ArrayList<PhoneRealDeviceInfo>();
        for (EC01DeviceMessage msg : ec01DeviceMessageList
        ) {
            PhoneRealDeviceInfo phoneRealDeviceInfo = getOneRealDeviceInfoSummary(msg);
            phoneRealDeviceInfoList.add(phoneRealDeviceInfo);
        }
        return phoneRealDeviceInfoList;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoSummary(EC01DeviceMessage msg) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = msg.getPhoneRealMsgInfoSummary();
        //形成设备信息
        phoneRealDeviceInfo.setDevNum(msg.getDSerialNum());
        phoneRealDeviceInfo.setTitle(msg.getDName());
        if(msg.getDState().equals("在线")){
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
    private EC01DeviceMessage getRealDMByUserIdAndDevNum(String userId, String devNum) throws Exception {
        EC01DeviceMessage dm = null;
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            dm = ec01DMService.selectEC01ByDeviceId(devNum);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    dm = ec01DMService.selectEC01ByDeviceId(devNum);
                    break;
                }
            }
        }
        return dm;
    }

    private PhoneRealDeviceInfo getOneRealDeviceInfoDetail(EC01DeviceMessage dm) {
        PhoneRealDeviceInfo phoneRealDeviceInfo = new PhoneRealDeviceInfo();
        //形成信号信息
        List<PhoneRealMsgInfo> phoneRealMsgInfoList = dm.getPhoneRealMsgInfoDetail();
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

    private ParameterCharts getParameterCharts(String userId, String sQueryParam, String devNum, String day) throws Exception {
        EC01DeviceMessage dm = null;
        if (userId == null || userId.equals(""))
            return null;
        if (devNum == null || devNum.equals(""))
            return null;
        //OAID转换为EASID
        List<RoleInfo> roleInfoList = this.selectRoleInfos(userId);
        if (roleInfoList.size() < 1)
            return null;
        List<EC01DeviceMessage> ec01DeviceMessageList = new ArrayList<EC01DeviceMessage>();
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
        String[] deviceNums = new String[1];
        deviceNums[0] = devNum;
        ParameterCharts parameterCharts = null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            parameterCharts = ec01DMService.selectHisEC01ByDateAndIDsChart(deviceNums, sQueryParam, sStartDate, sEndDate);
        } else {
            //查询该用户是否有权限查看该设备
            //如果有权限，就继续查询该设备
            List<DeviceRoleInfo> deviceRoleInfoList = deviceRoleInfoService.selectDeviceRoleInfoByRoleIds(roleInfoList);
            for (DeviceRoleInfo deviceRoleInfo : deviceRoleInfoList
            ) {
                if (deviceRoleInfo.getDevNum().equals(devNum)) {
                    parameterCharts = ec01DMService.selectHisEC01ByDateAndIDsChart(deviceNums, sQueryParam, sStartDate, sEndDate);
                    break;
                }
            }
        }
        return parameterCharts;
    }

    private PhoneEChartsOptions fromatEChartsOptions(ChartsParameters chartsParameters) {
        //默认一天
        PhoneEChartsOptions phoneEChartsOptions = new PhoneEChartsOptions();
        /*String getTime =  chartsParameters.getdParameterTime().get(0);
        String getTimeDate = getTime.substring(0,getTime.indexOf(" "));
        String getTimeTime = getTime.substring(getTime.indexOf(" ")+1,getTime.length());*/
        EChartsTitle eChartsTitle = new EChartsTitle();
        eChartsTitle.setText("数据曲线");
        eChartsTitle.setSubtext("");
        phoneEChartsOptions.setTitle(eChartsTitle);

        EChartsLegend eChartsLegend = new EChartsLegend();
        eChartsLegend.setData(chartsParameters.getdParameterName());
        eChartsLegend.setLeft("center");
        phoneEChartsOptions.setLegend(eChartsLegend);

        EChartsXAxis eChartsXAxis = new EChartsXAxis();
        eChartsXAxis.setData(chartsParameters.getdParameterTime());
        EcSplitLine ecxSplitLine = new EcSplitLine();
        ecxSplitLine.setShow(false);
        eChartsXAxis.setSplitLine(ecxSplitLine);
        phoneEChartsOptions.setxAxis(eChartsXAxis);

        EChartsYAxis eChartsYAxis = new EChartsYAxis();
        eChartsYAxis.setMin(String.valueOf((int) (Float.parseFloat(chartsParameters.getMin()) - 3)));
        eChartsYAxis.setMax(String.valueOf((int) (Float.parseFloat(chartsParameters.getMax()) + 3)));
        eChartsYAxis.setType("value");
        EcSplitLine ecySplitLine = new EcSplitLine();
        eChartsYAxis.setSplitLine(ecySplitLine);
        phoneEChartsOptions.setyAxis(eChartsYAxis);

        phoneEChartsOptions.setSeries(chartsParameters.getdParameterdata());
        phoneEChartsOptions.showPoint(false, false);
        return phoneEChartsOptions;
    }

}
