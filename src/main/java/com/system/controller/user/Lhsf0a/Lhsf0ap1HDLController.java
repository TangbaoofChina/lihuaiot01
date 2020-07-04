package com.system.controller.user.Lhsf0a;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.Device.Lhsf0ap1DM;
import com.system.po.Device.Lhsf0ap1DMHis;
import com.system.po.MydataTableColumn;
import com.system.service.Lhsf0ap1DMService;
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
public class Lhsf0ap1HDLController {
    @Autowired
    private Lhsf0ap1DMService dmService;

    @RequestMapping(value = "selectLhsf0ap1ByDevNumAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectLhsf0ap1ByDevNumAndDateAndPaging(Integer pageNumber,Integer pageSize,String sDeviceId,String sStartDate,String sEndDate) throws Exception {
        String jsonString = "[]";
        if (sDeviceId !=null) {
            DataTablePageing dataTablePageing = dmService.selectByDeviceIdAndDateAndPaging(pageNumber,pageSize,sDeviceId,sStartDate,sEndDate);
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

    @RequestMapping(value = "exportHisLhsf0ap1DeviceList", method = RequestMethod.GET)
    public void exportHisLhsf0ap1DeviceList(String sDeviceId,
                                            String sStartDate,
                                            String sEndDate,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        String fileName = "hisLhsf0ap1devicelist.xlsx";
        List<Lhsf0ap1DMHis> dmList = null;
        if (sDeviceId !=null) {
            dmList = dmService.selectByDevNumAndDate(sDeviceId,sStartDate,sEndDate);
        }
        File file = dmService.exportStorageHis(dmList);
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

    @RequestMapping(value="lhsf0ap1DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String lhsf0ap1DeviceHead(String devId) throws Exception{

        List<MydataTableColumn> hCList =  dmService.selectDeviceHead(devId);

        String jsonString = JSON.toJSONString(hCList);

        return jsonString;
    }



}
