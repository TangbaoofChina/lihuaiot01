package com.system.mapperiot;

import com.system.po.PeopleRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleRoleInfoMapper {
    List<PeopleRoleInfo> selectPeopleRoleInfo();
    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleId(String userId);
    void insertPeopleRoleInfo(@Param("peopleRoleInfo") PeopleRoleInfo peopleRoleInfo);
    void updatePeopleRoleInfoByPeopleId(@Param("peopleRoleInfo") PeopleRoleInfo peopleRoleInfo);
    void deletePeopleRoleInfoByPeopleId(String userId);
}
