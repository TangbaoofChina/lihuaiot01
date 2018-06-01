package com.system.po;

import java.io.Serializable;
import java.util.Date;

public class RoleInfo implements Serializable {
    private String roleId;
    private String roleName;
    private String roleDescribe;
    private String roleCreatUserId;
    private Date roleCreatDate;
    private String roleBelong;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    public String getRoleCreatUserId() {
        return roleCreatUserId;
    }

    public void setRoleCreatUserId(String roleCreatUserId) {
        this.roleCreatUserId = roleCreatUserId;
    }

    public Date getRoleCreatDate() {
        return roleCreatDate;
    }

    public void setRoleCreatDate(Date roleCreatDate) {
        this.roleCreatDate = roleCreatDate;
    }

    public String getRoleBelong() {
        return roleBelong;
    }

    public void setRoleBelong(String roleBelong) {
        this.roleBelong = roleBelong;
    }
}
