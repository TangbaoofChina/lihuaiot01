package com.system.po;

public class PeopleRoleInfo {
    private String userId;
    private String userName;
    private boolean userMsgPush;
    private String roleId;
    private String roleName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isUserMsgPush() {
        return userMsgPush;
    }

    public void setUserMsgPush(boolean userMsgPush) {
        this.userMsgPush = userMsgPush;
    }

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
}
