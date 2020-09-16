package com.system.controller.user.SwgC;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.Device.SwgC215DM;
import com.system.po.MydataTableColumn;
import com.system.service.SwgC215DMService;
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

/**
 * @ClassName SwgC215HDLController
 * @Description 立华禽环保4.0
 * @Author tangbao
 * @Date 2020-09-02 15:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/hisDeviceList")
public class SwgC215HDLController {
    @Autowired
    private SwgC215DMService dmService;

    /*********************Sewage215*******************************/
    @RequestMapping(value = "selectSwg215ByDevNumAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectSwg215ByDevNumAndDateAndPaging(Integer pageNumber,Integer pageSize,String sDeviceId,String sStartDate,String sEndDate) throws Exception {
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

    @RequestMapping(value = "exportHisSwgC215DeviceList", method = RequestMethod.GET)
    public void exportHisSwgC215DeviceList(String sDeviceId,
                                              String sStartDate,
                                              String sEndDate,
                                              HttpServletRequest request,
                                              HttpServletResponse response) throws Exception {
        String fileName = "hissewagec214devicelist.xlsx";
        List<SwgC215DM> dmList = null;
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

    @RequestMapping(value="/swgc215DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String swgc215DeviceHead() throws Exception{

        List<MydataTableColumn> headColumnList =  dmService.selectDeviceHead();

        String jsonString = JSON.toJSONString(headColumnList);

        return jsonString;
    }
}
