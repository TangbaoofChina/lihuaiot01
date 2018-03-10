package com.system.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Userlogin implements Serializable {
    private String userid;

    private String username;

    private String password;

    /**
     * 是否为初次登陆
     */
    private boolean firstLogin;
    /**
     * 用户登陆的IP
     */
    private String accessIP;

    /**
     * 用户角色
     */
    private List<RoleInfo> roleInfoList = new ArrayList<RoleInfo>();

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getAccessIP() {
        return accessIP;
    }

    public void setAccessIP(String accessIP) {
        this.accessIP = accessIP;
    }

    public List<RoleInfo> getRoleInfoList() {
        return roleInfoList;
    }

    public void setRoleInfoList(List<RoleInfo> roleInfoList) {
        this.roleInfoList = roleInfoList;
    }
}