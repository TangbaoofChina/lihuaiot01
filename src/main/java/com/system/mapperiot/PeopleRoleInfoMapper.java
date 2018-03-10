package com.system.mapperiot;

import com.system.po.PeopleRoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleRoleInfoMapper {
    List<PeopleRoleInfo> selectPeopleRoleInfo();
    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleId(String userId);
    List<PeopleRoleInfo> selectPeopleRoleInfoDistinct();
    List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleIdDistinct(String userId);
    void insertPeopleRoleInfo(@Param("peopleRoleInfoList") List<PeopleRoleInfo> peopleRoleInfoList);
    void deletePeopleRoleInfoByPeopleId(String userId);
    void deletePeopleRoleInfoByPeopleIdAndRoleId(@Param("userId") String userId,@Param("roleId") String roleId);
}
