package com.system.controller.system;

import com.alibaba.fastjson.JSON;
import com.system.po.DataTablePageing;
import com.system.po.MydataTableColumn;
import com.system.po.PeopleInfo;
import com.system.po.Userlogin;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.PeopleCombineOrgService;
import com.system.service.UserloginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/loginRecord")
public class LoginRecordController {
    @Autowired
    private PeopleCombineOrgService peopleCombineOrgService;
    @Autowired
    private UserloginService userloginService;
    @Autowired
    private BootStrapTreeNodeService bootStrapTreeNodeService;

    @RequestMapping(value = "selectPeopleByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByORGId(String sORGId) throws Exception {
        String jsonString = "[]";
        //获取用户角色
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<PeopleInfo> peopleInfoList = new ArrayList<PeopleInfo>();
        if (userlogin.getOrgid().equals("002")) {
            peopleInfoList = peopleCombineOrgService.selectPeopleByORGId(sORGId);
        } else {
            if(userlogin.getOrgid().equals(sORGId) || !bootStrapTreeNodeService.isParentId(sORGId,userlogin.getOrgid())) {
                peopleInfoList = peopleCombineOrgService.selectPeopleByORGId(sORGId);
            }
        }
        if (peopleInfoList.size()>0)
            jsonString = JSON.toJSONString(peopleInfoList);
        return jsonString;
    }

    @RequestMapping(value = "selectLoginInfoByUserIdsAndDateAndPaging", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectLoginInfoByUserIdsAndDateAndPaging(Integer pageNumber,Integer pageSize,String[] sUserIds,String sStartDate,String sEndDate) throws Exception {
        String jsonString = "[]";
        if (sUserIds !=null) {
            DataTablePageing dataTablePageing = userloginService.selectLoginInfoByUserIdAndDateAndPaging(pageNumber,pageSize,sUserIds,sStartDate,sEndDate);
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

    @RequestMapping(value="/loginHead",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String LoginHead() throws Exception{
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("userid");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("序号");
        mdtc1.setVisible(false);

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("username");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("名称");

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("loginType");
        mdtc3.setDefaultContent("3");
        mdtc3.setTitle("操作");

        MydataTableColumn mdtc4 = new MydataTableColumn();
        mdtc4.setData("loginDate");
        mdtc4.setDefaultContent("4");
        mdtc4.setTitle("时间");

        MydataTableColumn mdtc5 = new MydataTableColumn();
        mdtc5.setData("loginDate");
        mdtc5.setDefaultContent("5");
        mdtc5.setTitle("登陆IP");
        mdtc5.setVisible(false);

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);
        myDTCList.add(mdtc4);
        myDTCList.add(mdtc5);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }

}
