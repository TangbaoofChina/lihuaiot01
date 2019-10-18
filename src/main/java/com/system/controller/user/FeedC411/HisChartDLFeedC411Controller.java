package com.system.controller.user.FeedC411;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.DeviceUtilController;
import com.system.controller.util.FeedC411Chart;
import com.system.po.FeedC411.SiloHisTemp;
import com.system.po.FeedC411.SiloTempNameRelation;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.service.DeviceInfoService;
import com.system.service.FeedC411DMService;
import com.system.service.Hj212C213DMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hisChartDevice")
public class HisChartDLFeedC411Controller {
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private DeviceUtilController deviceUtilController;
    @Autowired
    private FeedC411DMService feedC411DMService;
    @Autowired
    private FeedC411Chart feedC411Chart;

    @RequestMapping(value = "/selectFeedC411ParamsById", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectFeedC411ParamsById(String devId) throws Exception {
        String jsonString = "[]";
        List<SiloTempNameRelation> sTNRs = feedC411DMService.selectParamsById(devId);
        jsonString = JSON.toJSONString(sTNRs);
        return jsonString;
    }

    @RequestMapping(value = "/selectFeedC411ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectFeedC411ByIdsAndDateChart(String[] sDeviceIds,
                                                   String sQueryParam01,
                                                   String sQueryParam02,
                                                   String sStartDate,
                                                   String sEndDate) throws Exception {
        String jsonString = "[]";
        List<SiloHisTemp> siloHisTempList = feedC411DMService.selectTempByDeviceIdAndDate(sDeviceIds[0],sQueryParam01,sStartDate,sEndDate);
        PhoneEChartsOptions phoneEChartsOptions = feedC411Chart.getECharts(sQueryParam02, siloHisTempList);
        if (phoneEChartsOptions == null)
            return "[]";
        jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }


}
