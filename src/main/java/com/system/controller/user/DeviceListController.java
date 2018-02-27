package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.DeviceInfo;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.DeviceInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @Autowired
    private BootStrapTreeNodeService bootStrapTreeNodeService;

    @RequestMapping(value = "selectDeviceByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            //获取用户角色
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
            List<DeviceInfo> deviceInfoList = new ArrayList<DeviceInfo>();
            if (userlogin.getOrgid().equals("002")) {
                deviceInfoList = deviceInfoService.selectDeviceInfoByORGId(sORGId);
            } else {
                if(userlogin.getOrgid().equals(sORGId) || !bootStrapTreeNodeService.isParentId(sORGId,userlogin.getOrgid())) {
                    deviceInfoList = deviceInfoService.selectDeviceInfoByORGId(sORGId);
                }
            }
            if (deviceInfoList.size() > 0)
                jsonString = JSON.toJSONString(deviceInfoList);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportDeviceList", method = RequestMethod.GET)
    public void exportDeviceList(String sORGId,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String fileName = "devicelist.xlsx";
        List<DeviceInfo> deviceInfoList = null;
        if (sORGId != null) {
            deviceInfoList = deviceInfoService.selectDeviceInfoByORGId(sORGId);
        }
        File file = deviceInfoService.exportStorage(deviceInfoList);
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

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("dName");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("dIp");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("连接IP");

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("dPort");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("连接端口");

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("dProtocol");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("连接协议");

        MydataTableColumn mdtc6 = new MydataTableColumn();
        mdtc6.setData("dSendTime");
        mdtc6.setDefaultContent("6");
        mdtc6.setTitle("发送时间");

        MydataTableColumn mdtc7 = new MydataTableColumn();
        mdtc7.setData("dReceiveTime");
        mdtc7.setDefaultContent("7");
        mdtc7.setTitle("接收时间");

        MydataTableColumn mdtc8 = new MydataTableColumn();
        mdtc8.setData("dState");
        mdtc8.setDefaultContent("8");
        mdtc8.setTitle("状态");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);
        myDTCList.add(mdtc5);
        myDTCList.add(mdtc6);
        myDTCList.add(mdtc7);
        myDTCList.add(mdtc8);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
