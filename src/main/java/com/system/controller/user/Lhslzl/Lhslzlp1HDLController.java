package com.system.controller.user.Lhslzl;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;

import com.system.po.Device.Lhslzlp1DM;
import com.system.po.MydataTableColumn;

import com.system.service.Lhslzlp1DMService;
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
public class Lhslzlp1HDLController {
    @Autowired
    private Lhslzlp1DMService dmService;

    @RequestMapping(value = "selectLhslzlp1ByDevNumAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectLhslzlp1ByDevNumAndDateAndPaging(Integer pageNumber,Integer pageSize,String sDeviceId,String sStartDate,String sEndDate) throws Exception {
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

    @RequestMapping(value = "exportHisLhslzlp1DeviceList", method = RequestMethod.GET)
    public void exportHisLhslzlp1DeviceList(String sDeviceId,
                                            String sStartDate,
                                            String sEndDate,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        String fileName = "hisLhslzlp1devicelist.xlsx";
        List<Lhslzlp1DM> dmList = null;
        if (sDeviceId !=null) {
            dmList = dmService.selectByDevNumAndDate(sDeviceId,sStartDate,sEndDate);
        }
        File file = dmService.exportStorage(dmList);
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

    @RequestMapping(value="lhslzlp1DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String lhslzlp1DeviceHead() throws Exception{

        List<MydataTableColumn> hCList =  dmService.selectDeviceHead();

        String jsonString = JSON.toJSONString(hCList);

        return jsonString;
    }



}
