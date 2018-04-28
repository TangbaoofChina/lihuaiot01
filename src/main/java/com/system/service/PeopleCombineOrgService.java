package com.system.service;

import com.system.exception.BootStrapTreeViewException;
import com.system.po.DataTablePageing;
import com.system.po.PeopleInfo;
import com.system.po.PeopleInfoEas;

import java.util.List;

public interface PeopleCombineOrgService {
    DataTablePageing selectPeopleByORGIdPaging(Integer pageNumber, Integer pageSize, String orgId) throws Exception;
    List<PeopleInfo> selectPeopleByORGId(String orgId) throws BootStrapTreeViewException;
    List<PeopleInfoEas> selectAllPeopleInfo() throws Exception;
    Integer insertUpdatePeople(PeopleInfo peopleInfo);
    Integer deletePeopleByPeopleId(String peopleId) throws Exception;
}
