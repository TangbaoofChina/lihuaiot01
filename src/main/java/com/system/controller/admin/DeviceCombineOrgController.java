package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.DeviceLongNodeInfo;
import com.system.po.Eas.ChickenRoom;
import com.system.po.MydataTableColumn;
import com.system.po.ORGTreeNode;
import com.system.service.*;
import com.system.service.Eas.ChickenRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//设备管理
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
    @Autowired
    private ChickenRoomInfoService chickenRoomInfoService;

    @RequestMapping(value = "selectZTreeNode", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectZTreeNode() throws Exception {

        List<ORGTreeNode> zTreeNodeList = orgTreeNodeService.selectORGInfo();

        String jsonString = JSON.toJSONString(zTreeNodeList);

        return jsonString;
    }

    @RequestMapping(value = "selectDeviceByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByORGId(Integer pageNumber, Integer pageSize, String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            DataTablePageing dataTablePageing = deviceCombineOrgService.selectDeviceByORGIdPaging(pageNumber, pageSize, sORGId);
            jsonString = "{";
            jsonString += "\"" + "total" + "\"";
            jsonString += ":";
            jsonString += "\"" + dataTablePageing.getTotal() + "\"";
            jsonString += ",";
            jsonString += "\"" + "rows" + "\"";
            jsonString += ":";
            jsonString += dataTablePageing.getsReturnJson();
            jsonString += "}";
        }
        return jsonString;
    }

    //单个设备更换组织
    @RequestMapping(value = "/deviceCombineOrgUpdate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deviceCombineOrgUpdate(String deviceId, String deviceName, String orgId) throws Exception {
        deviceInfoService.updateDeviceOrgId(deviceId, deviceName, orgId);
        orgId = bootStrapTreeNodeService.selectParentLongIdByOrgId(orgId);
        DeviceLongNodeInfo deviceLongNodeInfo = new DeviceLongNodeInfo();
        deviceLongNodeInfo.setDeviceNum(deviceId);
        deviceLongNodeInfo.setLongNode(orgId);
        deviceLongNodeInfoService.updateDeviceLongNodeInfo(deviceLongNodeInfo);
        String jsonString = "修改成功";
        return jsonString;
    }

    //设备更改参数
    @RequestMapping(value = "/deviceCombineOrgUpdateDeviceInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deviceCombineOrgUpdateDeviceInfo(String deviceId, String deviceName, boolean deviceDeactive, String deviceEasFId, String deviceEasFName, String deviceEasFDisplayName) throws Exception {
        deviceInfoService.updateDeviceInfo(deviceId, deviceName, deviceDeactive, deviceEasFId, deviceEasFName, deviceEasFDisplayName);
        String jsonString = "修改成功";
        return jsonString;
    }

    //多个设备更换组织
    @RequestMapping(value = "/deviceCombineOrgBatchUpdate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deviceCombineOrgBatchUpdate(String[] deviceIds, String orgId) throws Exception {
        deviceInfoService.batchUpdateDeviceOrgId(deviceIds, orgId);
        orgId = bootStrapTreeNodeService.selectParentLongIdByOrgId(orgId);
        deviceLongNodeInfoService.batchUpdateDeviceLongNodeInfo(deviceIds, orgId);
        String jsonString = "修改成功";
        return jsonString;
    }

    @RequestMapping(value = "/selectEasRoom", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEasRoom() throws Exception {
        String jsonString = "[]";
        List<ChickenRoom> chickenRoomList = chickenRoomInfoService.selectAllChickenRoom();
        if (chickenRoomList.size() > 0) {
            jsonString = JSON.toJSONString(chickenRoomList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String DeviceHead() throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("dSerialNum");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dSerialNumDec");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("序号");

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("dName");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("名称");

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dEasFName");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("舍号");

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("dEasFDisplayName");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("路径");

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("dDeactive");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("停用");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc6);
        myDTCList.add(mdtc4);
        myDTCList.add(mdtc5);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
