package com.system.controller.admin;

import com.alibaba.fastjson.JSON;
import com.system.po.MydataTableColumn;
import com.system.po.PeopleRoleInfo;
import com.system.po.RoleInfo;
import com.system.po.Userlogin;
import com.system.service.PeopleRoleInfoService;
import com.system.service.RoleInfoService;
import com.system.util.RoleInfoListUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<PeopleRoleInfo> peopleRoleInfoList = new ArrayList<PeopleRoleInfo>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            peopleRoleInfoList = peopleRoleInfoService.selectPeopleRoleInfo();
        } else if (RoleInfoListUtil.checkIsECAdmin(userlogin.getRoleInfoList())) {
            peopleRoleInfoList = peopleRoleInfoService.selectPeopleRoleInfoByRoleAdmin("111");
        } else if (RoleInfoListUtil.checkIsSewageCAdmin(userlogin.getRoleInfoList())) {
            peopleRoleInfoList = peopleRoleInfoService.selectPeopleRoleInfoByRoleAdmin("211");
        }
        String jsonString = JSON.toJSONString(peopleRoleInfoList);
        return jsonString;
    }

    @RequestMapping(value = "selectRoleInfo", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectRoleInfo() throws Exception {
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        Userlogin userlogin = (Userlogin) session.getAttribute("userInfo");
        List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();
        if (RoleInfoListUtil.checkIsAdmin(userlogin.getRoleInfoList())) {
            roleInfoList = roleInfoService.selectRoleInfo();
        } else if (RoleInfoListUtil.checkIsECAdmin(userlogin.getRoleInfoList())) {
            roleInfoList = roleInfoService.selectRoleInfoByRoldAdmin("111");
        } else if (RoleInfoListUtil.checkIsSewageCAdmin(userlogin.getRoleInfoList())) {
            roleInfoList = roleInfoService.selectRoleInfoByRoldAdmin("211");
        }
        String jsonString = JSON.toJSONString(roleInfoList);
        return jsonString;
    }

    @RequestMapping(value = "/roleCombinePeopleUpdate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String roleCombinePeopleUpdate(@RequestBody List<PeopleRoleInfo> peopleRoleInfoList) throws Exception {
        peopleRoleInfoService.insertUpdatePeopleRoles(peopleRoleInfoList);
        String jsonString = "更新成功";
        return jsonString;
    }

    @RequestMapping(value = "/deletePeopleRoleInfo", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String deleteRoleInfo(String userId, String roleId) throws Exception {
        String jsonString = "删除成功";
        //删除用户角色关联表
        peopleRoleInfoService.deletePeopleRoleInfoByPeopleIdAndRoleId(userId, roleId);
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

        MydataTableColumn mdtc3 = new MydataTableColumn();
        mdtc3.setData("userMsgPush");
        mdtc3.setDefaultContent("1");
        mdtc3.setTitle("消息推送");

        myDTCList.add(mdtc1);
        myDTCList.add(mdtc2);
        myDTCList.add(mdtc3);

        /*String a = JSONArray.fromObject(myDTCList).toString();
        JSONArray.parseO*/
        String jsonString = JSON.toJSONString(myDTCList);

        return jsonString;
    }
}
