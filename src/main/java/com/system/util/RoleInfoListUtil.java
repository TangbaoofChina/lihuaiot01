package com.system.util;

import com.system.po.RoleInfo;

import java.util.ArrayList;
import java.util.List;

public class RoleInfoListUtil {
    public static Boolean checkIsAdmin(List<RoleInfo> roleInfoList)
    {
        Boolean isAdmin = false;
        for (RoleInfo roleInfo:roleInfoList
                ) {
                if(roleInfo.getRoleName().equals("admin"))
                {
                    isAdmin = true;
                }
        }
        return isAdmin;
    }

    public static List<String> getRoleIdsFromRoleInfoList(List<RoleInfo> roleInfoList)
    {
        List<String> roleIds = new ArrayList<String>();
        for (RoleInfo roleInfo:roleInfoList
                ) {
            roleIds.add(roleInfo.getRoleId());
        }
        return roleIds;
    }
}
