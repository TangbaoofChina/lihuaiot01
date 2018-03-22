package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.EC01DeviceMessage;
import com.system.po.MydataTableColumn;
import com.system.service.EC01DeviceMessageService;
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
import java.util.List;

@Controller
@RequestMapping("/hisDeviceList")
public class HisDeviceListController {

    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;

    @RequestMapping(value = "selectEC01ByDevNumAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByDevNumAndDateAndPaging(Integer pageNumber,Integer pageSize,String sDeviceId,String sStartDate,String sEndDate) throws Exception {
        String jsonString = "[]";
        if (sDeviceId !=null) {
            DataTablePageing dataTablePageing = ec01DeviceMessageService.selectEC01ByDeviceIdAndDateAndPaging(pageNumber,pageSize,sDeviceId,sStartDate,sEndDate);
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

    @RequestMapping(value = "exportHisDeviceList", method = RequestMethod.GET)
    public void exportDeviceList(String sDeviceId,
                                 String sStartDate,
                                 String sEndDate,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String fileName = "hisdevicelist.xlsx";
        List<EC01DeviceMessage> ec01DeviceMessageList = null;
        if (sDeviceId !=null) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectEC01ByDevNumAndDate(sDeviceId,sStartDate,sEndDate);
        }
        File file = ec01DeviceMessageService.exportStorage(ec01DeviceMessageList);
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

    @RequestMapping(value="/ec01DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String ec01DeviceHead() throws Exception{

        List<MydataTableColumn> ec01HeadColumnList =  ec01DeviceMessageService.selectEC01DeviceHead();

        String jsonString = JSON.toJSONString(ec01HeadColumnList);

        return jsonString;
    }
}
