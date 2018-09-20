package com.system.util;

import com.system.po.RoleInfo;
import com.system.po.parameter.DeviceType;

import java.util.ArrayList;
import java.util.List;

public class RoleInfoListUtil {
    public static Boolean checkIsAdmin(List<RoleInfo> roleInfoList) {
        Boolean isAdmin = false;
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleName().equals("admin")) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    public static Boolean checkIsECAdmin(List<RoleInfo> roleInfoList) {
        Boolean isAdmin = false;
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleName().equals("111")) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    public static Boolean checkIsSewageCAdmin(List<RoleInfo> roleInfoList) {
        Boolean isAdmin = false;
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleName().equals("211")) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    public static Boolean checkIsControllerAdmin(List<RoleInfo> roleInfoList, String deviceType) {
        Boolean isAdmin = false;
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleName().equals(deviceType)) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    //查询权限列表中的该设备类型的权限对象
    public static RoleInfo getRoleAdminByDevtype(List<RoleInfo> roleInfoList, String deviceType) {
        RoleInfo roleInfo01 = null;
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleName().equals(deviceType)) {
                roleInfo01 = roleInfo;
            }
        }
        return roleInfo01;
    }

    public static Boolean checkIsScaleCAdmin(List<RoleInfo> roleInfoList) {
        Boolean isAdmin = false;
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleName().equals("311")) {
                isAdmin = true;
            }
        }
        return isAdmin;
    }

    public static List<String> getRoleIdsFromRoleInfoList(List<RoleInfo> roleInfoList) {
        List<String> roleIds = new ArrayList<String>();
        for (RoleInfo roleInfo : roleInfoList
                ) {
            roleIds.add(roleInfo.getRoleId());
        }
        return roleIds;
    }

    public static List<RoleInfo> getRoleInfoFromRoleInfoListByDevtype(List<RoleInfo> roleInfoList, String devType) {
        List<RoleInfo> roleInfos = new ArrayList<>();
        for (RoleInfo roleInfo : roleInfoList
                ) {
            if (roleInfo.getRoleBelong().equals(devType)) {
                roleInfos.add(roleInfo);
            }
        }
        return roleInfos;
    }
}
