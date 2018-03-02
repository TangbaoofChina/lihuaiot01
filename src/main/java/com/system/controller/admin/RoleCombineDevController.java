package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.MydataTableColumn;
import com.system.po.RoleInfo;
import com.system.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/roleCombineDev")
public class RoleCombineDevController {

    @Autowired
    private RoleInfoService roleInfoService;

    @RequestMapping(value = "selectRoleInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRoleInfo() throws Exception {
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfo();
        String jsonString = JSON.toJSONString(roleInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/RoleHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String RoleHead() throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("roleName");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("角色");

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("roleDescribe");
        mdtc2.setDefaultContent("2");
        mdtc2.setTitle("数据范围");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
