package com.system.controller.user.hj212C213;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.Device.Hj212C213DeviceMessage;
import com.system.po.DeviceInfoAndNode;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.DeviceInfoService;
import com.system.service.Hj212C213DMService;
import com.system.util.DeviceUtil;
import com.system.util.RoleInfoListUtil;
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
@RequestMapping("/hisDeviceList")
public class HisDeviceListHj212213Controller {
    @Autowired
    private Hj212C213DMService hj212C213DMService;

    /*****************************Hj212213***************************************/
    @RequestMapping(value = "selectHj212C213ByDevNumAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectHj212C213ByDevNumAndDateAndPaging(Integer pageNumber,Integer pageSize,String sDeviceId,String sStartDate,String sEndDate) throws Exception {
        String jsonString = "[]";
        if (sDeviceId !=null) {
            DataTablePageing dataTablePageing = hj212C213DMService.selectHj212C213ByDeviceIdAndDateAndPaging(pageNumber,pageSize,sDeviceId,sStartDate,sEndDate);
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

    @RequestMapping(value = "exportHisHj212C213DeviceList", method = RequestMethod.GET)
    public void exportHisHj212C213DeviceList(String sDeviceId,
                                            String sStartDate,
                                            String sEndDate,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        String fileName = "hisHj212C213devicelist.xlsx";
        List<Hj212C213DeviceMessage> hj212C213DeviceMessageList = null;
        if (sDeviceId !=null) {
            hj212C213DeviceMessageList = hj212C213DMService.selectHj212C213ByDevNumAndDate(sDeviceId,sStartDate,sEndDate);
        }
        File file = hj212C213DMService.exportStorage(hj212C213DeviceMessageList);
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

    @RequestMapping(value="/hj212C213DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String hj212C213DeviceHead() throws Exception{

        List<MydataTableColumn> hj212C213HeadColumnList =  hj212C213DMService.selectHj212C213DeviceHead();

        String jsonString = JSON.toJSONString(hj212C213HeadColumnList);

        return jsonString;
    }



}
