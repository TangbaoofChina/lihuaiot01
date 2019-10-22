package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.RoleInfo;
import com.system.po.UserOAEas2019;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.service.RoleInfoService;
import com.system.util.msg.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;

    /**
     * 查询用户权限
     * @param userId
     * @return
     * @throws Exception
     */
    public List<RoleInfo> selectRoleInfos(String userId) throws Exception {
        UserOAEas2019 userOAEas2019 = phoneUserOaEasService.selectUserOaEasByOaId2019(userId);
        if (userOAEas2019 == null)
            return new ArrayList<RoleInfo>();
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas2019.getEasId());
        if (roleInfoList.size() < 1)
            return new ArrayList<RoleInfo>();
        return roleInfoList;
    }
}
