package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.DeviceLongNodeInfo;
import com.system.po.MydataTableColumn;
import com.system.po.ORGTreeNode;
import com.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/deviceCombineOrg")
public class DeviceCombineOrgController {

    @Autowired
    private DeviceCombineOrgService deviceCombineOrgService;
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private BootStrapTreeNodeService bootStrapTreeNodeService;
    @Autowired
    private DeviceLongNodeInfoService deviceLongNodeInfoService;

    @RequestMapping(value = "selectZTreeNode", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectZTreeNode() throws Exception {

        List<ORGTreeNode> zTreeNodeList = orgTreeNodeService.selectORGInfo();

        String jsonString = JSON.toJSONString(zTreeNodeList);

        return jsonString;
    }

    @RequestMapping(value = "selectDeviceByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByORGId(Integer pageNumber,Integer pageSize,String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId !=null) {
            DataTablePageing dataTablePageing = deviceCombineOrgService.selectDeviceByORGIdPaging(pageNumber,pageSize,sORGId);
            jsonString = "{";
            jsonString += "\""+"total"+"\"";
            jsonString += ":";
            jsonString += "\""+dataTablePageing.getTotal()+"\"";
            jsonString += ",";
            jsonString += "\""+"rows"+"\"";
            jsonString += ":";
            jsonString += dataTablePageing.getsReturnJson();
            jsonString += "}";
        }
        return jsonString;
    }

    @RequestMapping(value="/deviceCombineOrgUpdate",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deviceCombineOrgUpdate(String deviceId,String deviceName,String orgId) throws Exception{
        deviceInfoService.updateDeviceOrgId(deviceId,deviceName,orgId);
        orgId = bootStrapTreeNodeService.selectParentLongIdByOrgId(orgId);
        DeviceLongNodeInfo deviceLongNodeInfo = new DeviceLongNodeInfo();
        deviceLongNodeInfo.setDeviceNum(deviceId);
        deviceLongNodeInfo.setLongNode(orgId);
        deviceLongNodeInfoService.updateDeviceLongNodeInfo(deviceLongNodeInfo);
        String jsonString = "修改成功";
        return jsonString;
    }

    @RequestMapping(value="/deviceCombineOrgBatchUpdate",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deviceCombineOrgBatchUpdate(String[] deviceIds,String orgId) throws Exception{
        deviceInfoService.batchUpdateDeviceOrgId(deviceIds,orgId);
        orgId = bootStrapTreeNodeService.selectParentLongIdByOrgId(orgId);
        deviceLongNodeInfoService.batchUpdateDeviceLongNodeInfo(deviceIds,orgId);
        String jsonString = "修改成功";
        return jsonString;
    }

    @RequestMapping(value="/DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String DeviceHead() throws Exception{
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNum");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
