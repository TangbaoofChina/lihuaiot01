package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.Device.FeedC411.FeedC411DMFY;
import com.system.po.Device.FeedC411DM;
import com.system.po.MydataTableColumn;
import com.system.service.FeedC411DMService;
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
public class FeedC411HDLController {
    @Autowired
    private FeedC411DMService feedC411DMService;

    /*********************FeedC411*******************************/
    @RequestMapping(value = "selectFeedC411ByDevNumAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectFeedC411ByDevNumAndDateAndPaging(Integer pageNumber,Integer pageSize,String sDeviceId,String sStartDate,String sEndDate) throws Exception {
        String jsonString = "[]";
        if (sDeviceId !=null) {
            DataTablePageing dataTablePageing = feedC411DMService.selectByDeviceIdAndDateAndPaging(pageNumber,pageSize,sDeviceId,sStartDate,sEndDate);
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

    @RequestMapping(value = "exportHisFeedC411DeviceList", method = RequestMethod.GET)
    public void exportHisFeedC411DeviceList(String sDeviceId,
                                             String sStartDate,
                                             String sEndDate,
                                             HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {
        String fileName = "hisfeedc411devicelist.xlsx";
        List<FeedC411DM> feedC411DMList = null;
        if (sDeviceId !=null) {
            feedC411DMList = feedC411DMService.selectByDevNumAndDate(sDeviceId,sStartDate,sEndDate);
        }
        File file = feedC411DMService.exportStorage(feedC411DMList);
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

    @RequestMapping(value="/feedC411DeviceHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String feedC411DeviceHead() throws Exception{

        //List<MydataTableColumn> feedC411HeadColumnList =  feedC411DMService.selectDeviceHead();
        //返回阜阳的筒仓测温表头，后面要考虑怎么区分
        FeedC411DMFY feedC411DMFY = new FeedC411DMFY();
        List<MydataTableColumn> headColumnList = feedC411DMFY.getDeviceHead();
        String jsonString = JSON.toJSONString(headColumnList);

        return jsonString;
    }
}
