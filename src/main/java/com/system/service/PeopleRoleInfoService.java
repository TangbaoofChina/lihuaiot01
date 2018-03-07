package com.system.service;

import com.system.po.PeopleRoleInfo;

import java.util.List;

public interface PeopleRoleInfoService {
    List<PeopleRoleInfo> selectPeopleRoleInfo() throws Exception;
    void insertUpdatePeopleRole(PeopleRoleInfo peopleRoleInfo) throws Exception;
    void deletePeopleRoleInfoByPeopleId(String userId) throws Exception;
}
