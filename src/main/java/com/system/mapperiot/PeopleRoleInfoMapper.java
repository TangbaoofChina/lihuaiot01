package com.system.mapperiot;

import com.system.po.PeopleRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleRoleInfoMapper {
    List<PeopleRoleInfo> selectPeopleRoleInfo();

    List<PeopleRoleInfo> selectPeopleRoleInfoByRoleAdmin(String roleAdmin);

    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleId(String userId);

    List<PeopleRoleInfo> selectPeopleRoleInfoByRoleId(String roleId);

    List<PeopleRoleInfo> selectPeopleRoleInfoByUserIdAndRoleId(@Param("userId") String userId, @Param("roleId") String roleId);

    List<PeopleRoleInfo> selectPeopleRoleInfoDistinct();

    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleIdDistinct(String userId);

    void insertPeopleRoleInfo(@Param("peopleRoleInfoList") List<PeopleRoleInfo> peopleRoleInfoList);

    void insertOnePeopleRoleInfo(PeopleRoleInfo peopleRoleInfo);

    void updatePeopleRoleInfo(PeopleRoleInfo peopleRoleInfo);

    void deletePeopleRoleInfoByPeopleId(String userId);

    void deletePeopleRoleInfoByPeopleIdAndRoleId(@Param("userId") String userId, @Param("roleId") String roleId);
}
