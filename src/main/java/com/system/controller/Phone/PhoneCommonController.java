package com.system.controller.Phone;

import com.alibaba.fastjson.JSON;
import com.system.po.BootStrapTreeNode;
import com.system.po.RoleInfo;
import com.system.po.UserOAEas;
import com.system.service.BootStrapTreeNodeService;
import com.system.service.Phone.PhoneUserOaEasService;
import com.system.service.RoleDeviceOrgInfoService;
import com.system.service.RoleInfoService;
import com.system.util.RoleInfoListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/phone/common")
public class PhoneCommonController {
    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PhoneUserOaEasService phoneUserOaEasService;
    @Autowired
    private BootStrapTreeNodeService bootStrapTreeNodeService;
    @Autowired
    private RoleDeviceOrgInfoService roleDeviceOrgInfoService;

    /**
     * 获取树形结构-bootstrap格式
     * @param userId 用户ID
     * @param devType 设备类型
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectOrgByUserIdAndDevType", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String selectOrgByUserIdAndDevType(String userId,String devType) throws Exception {
        if (userId == null || userId.equals(""))
            return "[]";
        //OAID转换为EASID
        UserOAEas userOAEas = phoneUserOaEasService.selectUserOaEasByOaId(userId);
        List<RoleInfo> roleInfoList = roleInfoService.selectRoleInfoByUserId(userOAEas.getEasId());
        if (roleInfoList.size() < 1)
            return "[]";
        BootStrapTreeNode bootStrapTreeNode = null;
        if (RoleInfoListUtil.checkIsAdmin(roleInfoList)) {
            bootStrapTreeNode = bootStrapTreeNodeService.selectORGInfoByOrgId(devType);
        } else {
            bootStrapTreeNode = roleDeviceOrgInfoService.selectBstnByRoleId(roleInfoList);
        }
        if(bootStrapTreeNode == null)
            return "[]";
        String jsonString = JSON.toJSONString(bootStrapTreeNode);
        return jsonString;
    }
}
