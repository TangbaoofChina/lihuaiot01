package com.system.mapperiot;

import com.system.po.PeopleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleInfoMapper {
    List<PeopleInfo> selectPeopleInfoByORGID(@Param("nodeId") String nodeId);
    List<PeopleInfo> selectPeopleByPeopleId(@Param("peopleId") String peopleId);
    Integer updatePeopleByPeopleId(PeopleInfo peopleInfo);
    Integer insertPeople(@Param("peopleInfo") PeopleInfo peopleInfo);
    Integer deletePeopleByPeopleId(String peopleId);
}
