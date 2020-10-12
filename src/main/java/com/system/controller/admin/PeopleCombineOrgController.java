package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.*;
import com.system.service.ORGTreeNodeService;
import com.system.service.PeopleCombineOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//用户绑定组织-暂停使用
@Controller
@RequestMapping("/peopleCombineOrg")
public class PeopleCombineOrgController {
    @Autowired
    private PeopleCombineOrgService peopleCombineOrgService;
    @Autowired
    private ORGTreeNodeService orgTreeNodeService;

    @RequestMapping(value = "selectPeopleByORGId", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectDeviceByORGId(Integer pageNumber, Integer pageSize, String sORGId) throws Exception {
        String jsonString = "[]";
        if (sORGId != null) {
            DataTablePageing dataTablePageing = peopleCombineOrgService.selectPeopleByORGIdPaging(pageNumber, pageSize, sORGId);
            jsonString = "{";
            jsonString += "\"" + "total" + "\"";
            jsonString += ":";
            jsonString += "\"" + dataTablePageing.getTotal() + "\"";
            jsonString += ",";
            jsonString += "\"" + "rows" + "\"";
            jsonString += ":";
            jsonString += dataTablePageing.getsReturnJson();
            jsonString += "}";
        }
        return jsonString;
    }

    @RequestMapping(value = "selectZTreeNode", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectZTreeNode() throws Exception {

        List<ORGTreeNode> zTreeNodeList = orgTreeNodeService.selectORGInfo();

        String jsonString = JSON.toJSONString(zTreeNodeList);

        return jsonString;
    }

    @RequestMapping(value = "selectPeopleInfo", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectPeopleInfo() throws Exception {

        List<PeopleInfoEas> peopleInfoList = peopleCombineOrgService.selectAllPeopleInfo();

        String jsonString = JSON.toJSONString(peopleInfoList);

        return jsonString;
    }

    @RequestMapping(value="/peopleCombineOrgUpdate",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String peopleCombineOrgUpdate(String personId,String personName,String orgId,String orgName) throws Exception{
        PeopleInfo peopleInfo = new PeopleInfo();
        peopleInfo.setPersonId(personId);
        peopleInfo.setPersonName(personName);
        peopleInfo.setOrgId(orgId);
        peopleInfo.setOrgName(orgName);
        peopleCombineOrgService.insertUpdatePeople(peopleInfo);
        String jsonString = "修改成功";
        return jsonString;
    }

    @RequestMapping(value="/peopleCombineOrgDelete",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String peopleCombineOrgDelete(String peopleId) throws Exception{

        peopleCombineOrgService.deletePeopleByPeopleId(peopleId);
        String jsonString = "删除成功";
        return jsonString;
    }

    @RequestMapping(value = "/PeopleHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String PeopleHead() throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("personName");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("用户");

        myDTCList.add(mdtc1);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
