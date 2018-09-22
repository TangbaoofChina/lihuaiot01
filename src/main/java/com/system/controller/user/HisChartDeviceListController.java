package com.system.controller.user;

import com.alibaba.fastjson.JSON;
import com.system.controller.util.ScaleC01Chart;
import com.system.po.*;
import com.system.po.EChartsOptions.EChartsParts.ECxAxisAxisLabel;
import com.system.po.EChartsOptions.EChartsTitle;
import com.system.po.EChartsOptions.EChartsXAxis;
import com.system.po.EChartsOptions.EChartsYAxis;
import com.system.po.EChartsOptions.EcSplitLine;
import com.system.po.Phone.PhoneEChartsOptions;
import com.system.po.ScaleC01.ScaleC01WtAnalysis;
import com.system.po.parameter.OneDataDetail;
import com.system.po.parameter.ParameterCharts;
import com.system.service.DeviceInfoService;
import com.system.service.EC01DeviceMessageService;
import com.system.service.ScaleC01DeviceMessageService;
import com.system.util.EC01Util;
import com.system.util.EChartsUtil;
import com.system.util.RoleInfoListUtil;
import com.system.util.ScaleC01Util;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hisChartDevice")
public class HisChartDeviceListController {

    @Autowired
    private EC01DeviceMessageService ec01DeviceMessageService;
    @Autowired
    private ScaleC01DeviceMessageService scaleC01DeviceMessageService;
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private ScaleC01Chart scaleC01Chart;

/*    @RequestMapping(value = "selectDevices", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevices() throws Exception {
        String jsonString = "[]";
        List<DeviceInfo> deviceInfoList = deviceInfoService.selectDeviceInfoByORGId("002");
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }*/

    @RequestMapping(value = "selectDevicesPost", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDevicesPost() throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<DeviceInfoAndNode> deviceInfoList = new ArrayList<DeviceInfoAndNode>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            //deviceInfoList = deviceInfoService.selectDeviceInfoByOrgIdAll("101");
            deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("111"));
            /*deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("201"));
            deviceInfoList.addAll(deviceInfoService.selectDeviceInfoByOrgIdAll("211"));*/
        } else {
            deviceInfoList = deviceInfoService.selectDeviceInfoByRoleIdAll(userlogin.getRoleInfoList());
        }
        jsonString = JSON.toJSONString(deviceInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/selectEC01ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByIdsAndDateChart(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        //List<DeviceMessage> deviceMessageList = deviceMessageService.selectHisDeviceMessage();
        //ParameterCharts parameterCharts = ec01DeviceMessageService.selectHisEC01ByDateAndIDsChart(sDeviceIds, sQueryParam, sStartDate, sEndDate);
        ParameterCharts parameterCharts = ec01DeviceMessageService.selectHisEC01ByDateAndIDsChartThreshold(sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sStartDate, sEndDate);
        if (parameterCharts == null)
            return "[]";
        String jsonString = JSON.toJSONString(parameterCharts);
        return jsonString;
    }

    @RequestMapping(value = "/selectEC01ByIdAndDateTimeChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByIdAndDateTimeChart(String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String[] sDateTimeList) throws Exception {
        //排序
        sDateTimeList = EC01Util.SortByDate(sDateTimeList);
        ParameterCharts parameterCharts = ec01DeviceMessageService.selectHisEC01ByDtlAndId(sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sDateTimeList);
        if (parameterCharts == null)
            return "[]";
        String jsonString = JSON.toJSONString(parameterCharts);
        return jsonString;
    }

    @RequestMapping(value = "selectEC01ByIdsAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByIdsAndDateAndPaging(Integer pageNumber, Integer pageSize, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        String sReturnJson = "[]";
        if (sDeviceIds == null) {
            return sReturnJson;
        }
        if (sDeviceIds.length > 0) {
            List<DeviceInfo> deviceInfoList = getDeviceInfoList(sDeviceIds);
            DataTablePageing dataTablePageing = ec01DeviceMessageService.selectHisEC01ByDateAndIDsAndPageAndThreshold(pageNumber, pageSize, deviceInfoList, sMaxThreshold, sMinThreshold, sDeviceIds, sQueryParam, sStartDate, sEndDate);
            sReturnJson = getReturnJson(dataTablePageing);
        }
        return sReturnJson;
    }

    @RequestMapping(value = "exportHisDeviceList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void exportHisDeviceList(String[] sDeviceIds,
                                    String sMaxThreshold,
                                    String sMinThreshold,
                                    String sQueryParam,
                                    String sStartDate,
                                    String sEndDate,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        List<List<OneDataDetail>> ec01DeviceMessageList = null;
        List<DeviceInfo> deviceInfoList = getDeviceInfoList(sDeviceIds);
        if (sDeviceIds != null && (sDeviceIds.length > 0)) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectHisEC01ByDateAndIDsTableAndThreshold(deviceInfoList, sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sStartDate, sEndDate);

            List<MydataTableColumn> myDTCList = EC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
            File file = ec01DeviceMessageService.exportStoragedynamic(myDTCList, ec01DeviceMessageList);
            ExportExcel(response, file);
        }
    }

    @RequestMapping(value = "exportHisDeviceListDtl", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void exportHisDeviceListDtl(String[] sDeviceIds,
                                       String sMaxThreshold,
                                       String sMinThreshold,
                                       String sQueryParam, String[] sDateTimeList,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        List<List<OneDataDetail>> ec01DeviceMessageList = null;
        List<DeviceInfo> deviceInfoList = getDeviceInfoList(sDeviceIds);
        if (sDeviceIds != null && (sDeviceIds.length > 0)) {
            ec01DeviceMessageList = ec01DeviceMessageService.selectHisEC01TbByDtlAndIDsAndThreshold(deviceInfoList, sDeviceIds, sMaxThreshold, sMinThreshold, sQueryParam, sDateTimeList);

            List<MydataTableColumn> myDTCList = EC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, sDateTimeList);
            File file = ec01DeviceMessageService.exportStoragedynamic(myDTCList, ec01DeviceMessageList);
            ExportExcel(response, file);
        }
    }

    @RequestMapping(value = "/ec01DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String ec01DeviceHead(String[] sDeviceIds, String sQueryParam) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<>();
        List<DeviceInfo> deviceInfoList = new ArrayList<>();
        if (sDeviceIds.length > 0) {
            deviceInfoList = getDeviceInfoList(sDeviceIds);
            myDTCList = EC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
        }

        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

    @RequestMapping(value = "/ec01DeviceDataTimeHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String ec01DeviceDataTimeHead(String[] sDeviceIds, String[] sDateTimeList, String sQueryParam) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<>();
        //排序
        sDateTimeList = EC01Util.SortByDate(sDateTimeList);
        if (sDeviceIds.length > 0) {
            List<DeviceInfo> deviceInfoList = getDeviceInfoList(sDeviceIds);
            myDTCList = EC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, sDateTimeList);
        }
        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

    @RequestMapping(value = "selectEC01ByIdsAndDtlAndPg", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectEC01ByIdsAndDtlAndPg(Integer pageNumber, Integer pageSize, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sQueryParam, String[] sDateTimeList) throws Exception {
        String sReturnJson = "[]";
        if (sDeviceIds == null) {
            return sReturnJson;
        }
        if (sDeviceIds.length > 0) {
            List<DeviceInfo> deviceInfoList = getDeviceInfoList(sDeviceIds);
            DataTablePageing dataTablePageing = ec01DeviceMessageService.selectHisEC01ByDtlAndIDsAndPageAndThreshold(pageNumber, pageSize, deviceInfoList, sMaxThreshold, sMinThreshold, sDeviceIds, sQueryParam, sDateTimeList);
            sReturnJson = getReturnJson(dataTablePageing);
        }
        return sReturnJson;
    }

    public void ExportExcel(HttpServletResponse response, File file) throws Exception {
        String fileName = "hisChartdevicelist.xlsx";
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

    /****************************ScaleC01  Start****************************************/
    @RequestMapping(value = "/selectScaleC01ByIdsAndDateChart", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectScaleC01ByIdsAndDateChart(String[] sDeviceIds,
                                                  String sMaxThreshold,
                                                  String sMinThreshold,
                                                  String sStartAge,
                                                  String sQueryParam,
                                                  String sStartDate,
                                                  String sEndDate) throws Exception {
        Map<String, List<ScaleC01WtAnalysis>> scaleC01MapByDate = scaleC01DeviceMessageService.selectHisScaleC01ByDateAndIDsChartThreshold(sDeviceIds, sMaxThreshold, sMinThreshold, sStartAge, sQueryParam, sStartDate, sEndDate);
        if (scaleC01MapByDate == null || scaleC01MapByDate.size() < 1)
            return "[]";
        List<DeviceInfo> deviceInfoList = this.getDeviceInfoList(sDeviceIds);
        if (deviceInfoList == null || deviceInfoList.size() < 1)
            return "[]";
        Map<String, String> deviceInfoMap = this.getDeviceInfoMap(deviceInfoList);
        PhoneEChartsOptions phoneEChartsOptions = scaleC01Chart.getECharts(sQueryParam, deviceInfoMap, sStartAge, scaleC01MapByDate);
        if (phoneEChartsOptions == null)
            return "[]";
        String jsonString = JSON.toJSONString(phoneEChartsOptions);
        return jsonString;
    }

    @RequestMapping(value = "/scalec01DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String scalec01DeviceHead(String[] sDeviceIds, String sQueryParam) throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<>();
        List<DeviceInfo> deviceInfoList = new ArrayList<>();
        if (sDeviceIds.length > 0) {
            deviceInfoList = getDeviceInfoList(sDeviceIds);
            myDTCList = ScaleC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
        }

        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

    @RequestMapping(value = "selectScaleC01ByIdsAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectScaleC01ByIdsAndDateAndPaging(Integer pageNumber, Integer pageSize, String[] sDeviceIds, String sMaxThreshold, String sMinThreshold, String sStartAge, String sQueryParam, String sStartDate, String sEndDate) throws Exception {
        String sReturnJson = "[]";
        if (sDeviceIds == null) {
            return sReturnJson;
        }
        if (sDeviceIds.length > 0) {
            List<DeviceInfo> deviceInfoList = getDeviceInfoList(sDeviceIds);
            DataTablePageing dataTablePageing = scaleC01DeviceMessageService.selectHisScaleC01ByDateAndIDsAndPageAndThreshold(pageNumber, pageSize, deviceInfoList, sMaxThreshold, sMinThreshold, sStartAge, sDeviceIds, sQueryParam, sStartDate, sEndDate);
            sReturnJson = getReturnJson(dataTablePageing);
        }
        return sReturnJson;
    }

    @RequestMapping(value = "exportScaleC01HisDeviceList", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void exportScaleC01HisDeviceList(String[] sDeviceIds,
                                            String sMaxThreshold,
                                            String sMinThreshold,
                                            String sStartAge,
                                            String sQueryParam,
                                            String sStartDate,
                                            String sEndDate,
                                            HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        List<List<OneDataDetail>> scalec01DeviceMessageList = null;
        List<DeviceInfo> deviceInfoList = this.getDeviceInfoList(sDeviceIds);
        if (sDeviceIds != null && (sDeviceIds.length > 0)) {
            scalec01DeviceMessageList = scaleC01DeviceMessageService.selectHisScaleC01ByDateAndIDsTableAndThreshold(deviceInfoList, sDeviceIds, sMaxThreshold, sMinThreshold, sStartAge, sQueryParam, sStartDate, sEndDate);
            List<MydataTableColumn> myDTCList = ScaleC01Util.getMyDataTableColumn(sQueryParam, deviceInfoList, null);
            File file = scaleC01DeviceMessageService.exportStoragedynamic(myDTCList, scalec01DeviceMessageList);
            ExportExcel(response, file);
        }
    }

    /****************************ScaleC01   End****************************************/
    private List<DeviceInfo> getDeviceInfoList(String[] sDeviceIds) throws Exception {
        //为了防止排序
        //日温饮水 排序，先取出第一个设备的信息，再取出后续的设备的信息
        List<DeviceInfo> deviceInfoList = new ArrayList<>();
        if (sDeviceIds.length < 1) {
            return deviceInfoList;
        }
        String[] sDeviceIdsFirst = new String[1];
        sDeviceIdsFirst[0] = sDeviceIds[0];
        List<DeviceInfo> deviceInfoListFirst = deviceInfoService.selectDeviceInfoByIDs(sDeviceIdsFirst);
        deviceInfoList.addAll(deviceInfoListFirst);
        if (sDeviceIds.length > 1) {
            List<String> sDeviceIdsSecond = new ArrayList<>();
            for (int i = 1; i < sDeviceIds.length; i++) {
                sDeviceIdsSecond.add(sDeviceIds[i]);
            }
            List<DeviceInfo> deviceInfoListSecond = deviceInfoService.selectDeviceInfoByIDs(sDeviceIdsSecond.toArray(new String[sDeviceIdsSecond.size()]));

            deviceInfoList.addAll(deviceInfoListSecond);
        }
        return deviceInfoList;
    }

    //根据设备列表，生成设备的MAP，为曲线的图例服务，显示设备名称(设备序号，设备名称)
    private Map<String, String> getDeviceInfoMap(List<DeviceInfo> deviceInfoList) {
        Map<String, String> deviceInfoMap = new HashMap<>();
        for (int i = 0; i < deviceInfoList.size(); i++) {
            deviceInfoMap.put(deviceInfoList.get(i).getDSerialNum(), deviceInfoList.get(i).getDName());
        }
        return deviceInfoMap;
    }

    private String getReturnJson(DataTablePageing dataTablePageing) {
        String sReturnJson = "[]";
        sReturnJson = "{";
        sReturnJson += "\"" + "total" + "\"";
        sReturnJson += ":";
        sReturnJson += "\"" + dataTablePageing.getTotal() + "\"";
        sReturnJson += ",";
        sReturnJson += "\"" + "rows" + "\"";
        sReturnJson += ":";
        sReturnJson += dataTablePageing.getsReturnJson();
        sReturnJson += "}";
        return sReturnJson;
    }

}
