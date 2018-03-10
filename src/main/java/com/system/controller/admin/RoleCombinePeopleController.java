package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.MydataTableColumn;
import com.system.po.PeopleRoleInfo;
import com.system.po.RoleInfo;
import com.system.service.PeopleRoleInfoService;
import com.system.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/roleCombinePeople")
public class RoleCombinePeopleController {
    @Autowired
    private PeopleRoleInfoService peopleRoleInfoService;
    @Autowired
    private RoleInfoService roleInfoService;

    @RequestMapping(value = "selectRolePeopleInfo", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRolePeopleInfo() throws Exception {
        List<PeopleRoleInfo> peopleRoleInfoList = peopleRoleInfoService.selectPeopleRoleInfo();
        String jsonString = JSON.toJSONString(peopleRoleInfoList);
        return jsonString;
    }

    @RequestMapping(value = "selectRoleInfo", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRoleInfo() throws Exception {
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfo();
        String jsonString = JSON.toJSONString(roleInfoList);
        return jsonString;
    }

    @RequestMapping(value="/roleCombinePeopleUpdate",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String roleCombinePeopleUpdate(@RequestBody List<PeopleRoleInfo> peopleRoleInfoList) throws Exception{
        peopleRoleInfoService.insertUpdatePeopleRoles(peopleRoleInfoList);
        String jsonString = "更新成功";
        return jsonString;
    }

    @RequestMapping(value="/deletePeopleRoleInfo",method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteRoleInfo(String userId,String roleId) throws Exception{
        String jsonString = "删除成功";
        //删除用户角色关联表
        peopleRoleInfoService.deletePeopleRoleInfoByPeopleIdAndRoleId(userId,roleId);
        return jsonString;
    }

    @RequestMapping(value = "RolePeopleHead", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String RolePeopleHead() throws Exception {
        List<MydataTableColumn> myDTCList = new ArrayList<MydataTableColumn>();
        MydataTableColumn mdtc1 = new MydataTableColumn();
        mdtc1.setData("userName");
        mdtc1.setDefaultContent("1");
        mdtc1.setTitle("用户");

        MydataTableColumn mdtc2 = new MydataTableColumn();
        mdtc2.setData("roleName");
        mdtc2.setDefaultContent("1");
        mdtc2.setTitle("角色");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
