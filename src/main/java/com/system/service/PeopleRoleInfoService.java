package com.system.service;

import com.system.po.PeopleRoleInfo;

import java.util.List;

public interface PeopleRoleInfoService {
    List<PeopleRoleInfo> selectPeopleRoleInfo() throws Exception;
    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleId(String userId) throws Exception;
    List<PeopleRoleInfo> selectPeopleRoleInfoDistinct() throws Exception;
    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleIdDistinct(String userId) throws Exception;
    void insertUpdatePeopleRoles(List<PeopleRoleInfo> peopleRoleInfoList) throws Exception;
    void deletePeopleRoleInfoByPeopleIdAndRoleId(String userId,String roleId) throws Exception;
}
