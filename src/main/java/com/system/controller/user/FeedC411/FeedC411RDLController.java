package com.system.controller.user.FeedC411;

import com.alibaba.fastjson.JSON;
import com.system.po.Device.FeedC411.FeedC411DMFY;
import com.system.po.Device.FeedC411DM;
import com.system.po.MydataTableColumn;
import com.system.po.Userlogin;
import com.system.service.FeedC411DMService;
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

/**
 * 饲料部-筒仓测温项目
 */
@Controller
@RequestMapping("/realDeviceList")
public class FeedC411RDLController {

    @Autowired
    private FeedC411DMService feedC411DMService;
    /*************************FeedC411 筒仓测温 411*********************************************/

    @RequestMapping(value = "selectFeedC411ByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectFeedC411ByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            List<FeedC411DM> dmList = selectFeedC411DMList(sORGId);
            if (dmList.size() > 0)
                jsonString = JSON.toJSONString(dmList);
        }
        return jsonString;
    }

    @RequestMapping(value = "/feedC411DeviceHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String feedC411DeviceHead() throws Exception {
        //List<MydataTableColumn> headColumnList = feedC411DMService.selectDeviceHead();
        //返回阜阳的筒仓测温表头，后面要考虑怎么区分
        FeedC411DMFY feedC411DMFY = new FeedC411DMFY();
        List<MydataTableColumn> headColumnList = feedC411DMFY.getDeviceHead();
        String jsonString = JSON.toJSONString(headColumnList);
        return jsonString;
    }

    @RequestMapping(value = "selectFeedC411ByDeviceId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectFeedC411ByDeviceId(String sDeviceId) throws Exception {
        String jsonString = "[]";
        if (sDeviceId != null) {
            FeedC411DM dm = feedC411DMService.selectByDeviceId(sDeviceId);
            //阜阳-筒仓测温
            if (sDeviceId.contains("4800")) {
                if (dm != null) {
                    FeedC411DMFY dmfy = new FeedC411DMFY(dm);
                    jsonString = JSON.toJSONString(dmfy);
                    return jsonString;
                }
            }
            if (dm != null)
                jsonString = JSON.toJSONString(dm);
        }
        return jsonString;
    }

    @RequestMapping(value = "exportFeedC411DeviceList", method = RequestMethod.GET)
    public void exportFeedC411DeviceList(String sORGId,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        String fileName = "realFeedC411devicelist.xlsx";
        List<FeedC411DM> dmList = null;
        if (sORGId != null) {
            dmList = selectFeedC411DMList(sORGId);
        }
        File file = feedC411DMService.exportStorage(dmList);
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

    private List<FeedC411DM> selectFeedC411DMList(String sORGId) throws Exception {
        List<FeedC411DM> dmList = new ArrayList<FeedC411DM>();
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            dmList = feedC411DMService.selectByORGId(sORGId);
        } else {
            dmList = feedC411DMService.selectByORGIdAndRoleId(sORGId, userlogin.getRoleInfoList());
        }
        return dmList;
    }
}
