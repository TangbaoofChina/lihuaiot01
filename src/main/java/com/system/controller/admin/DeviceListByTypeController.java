package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.DeviceCfgInfo;
import com.system.po.DeviceInfo;
import com.system.po.MydataTableColumn;
import com.system.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

//设备清单
@Controller
@RequestMapping("/devicelistbytype")
public class DeviceListByTypeController {
    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping(value = "selectDeviceByTypeId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByTypeId(String sTypeId) throws Exception {
        String jsonString = "[]";
        List<DeviceCfgInfo> deviceCfgInfoList = new ArrayList<>();
        if (sTypeId != null) {
            deviceCfgInfoList = deviceTypeService.selectDeviceListByType(sTypeId);
            if (deviceCfgInfoList.size() > 0)
                jsonString = JSON.toJSONString(deviceCfgInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportDeviceList", method = RequestMethod.GET)
    public void exportDeviceList(String sTypeId,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String fileName = "devicelistbytype.xlsx";
        List<DeviceCfgInfo> deviceCfgInfoList = new ArrayList<>();
        if (sTypeId != null) {
            deviceCfgInfoList = deviceTypeService.selectDeviceListByType(sTypeId);
        }
        File file = deviceTypeService.exportStorage(deviceCfgInfoList);
        if (file != null) {
            // 设置响应头
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            FileInputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[8192];

            int len;
            while ((len = inputStream.read(buffer, 0, buffer.length)) > 0) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }

            inputStream.close();
            outputStream.close();
        }
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
        mdtc4.setData("dCfgUrl");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("路径");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

}
