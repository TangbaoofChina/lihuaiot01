package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.exception.BootStrapTreeViewException;
import com.system.mapperiot.PeopleInfoMapper;
import com.system.mappereas.PeopleInfoMapperLiHua;
import com.system.po.DataTablePageing;
import com.system.po.PeopleInfo;
import com.system.service.PeopleCombineOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleCombineOrgServiceImpl implements PeopleCombineOrgService {
    @Autowired
    private PeopleInfoMapper peopleInfoMapper;
    @Autowired
    private PeopleInfoMapperLiHua peopleInfoMapperLiHua;

    @Override
    public DataTablePageing selectPeopleByORGIdPaging(Integer pageNumber, Integer pageSize, String orgId) throws Exception {
        DataTablePageing dataTablePageing = new DataTablePageing();
        Integer bigIndex = 0;
        Integer smallIndex = 0;
        smallIndex = pageNumber-1;
        bigIndex = smallIndex + pageSize;
        List<PeopleInfo> peopleInfoList = new ArrayList<PeopleInfo>();

        peopleInfoList = peopleInfoMapper.selectPeopleInfoByORGID(orgId);
        //截取部分字符串
        List<PeopleInfo> peopleInfoListSub = new ArrayList<PeopleInfo>();
        if(bigIndex > peopleInfoList.size())
            bigIndex = peopleInfoList.size();
        peopleInfoListSub.addAll(peopleInfoList.subList(smallIndex,bigIndex));
        String jsonString = JSON.toJSONString(peopleInfoListSub);
        dataTablePageing.setTotal(peopleInfoListSub.size());
        dataTablePageing.setsReturnJson(jsonString);
        return dataTablePageing;
    }

    @Override
    public List<PeopleInfo> selectPeopleByORGId(String orgId) throws BootStrapTreeViewException {
        return peopleInfoMapper.selectPeopleInfoByORGID(orgId);
    }

    @Override
    public List<PeopleInfo> selectAllPeopleInfo() throws Exception {
        return peopleInfoMapperLiHua.selectAllPeopleInfo();
    }

    @Override
    public Integer insertUpdatePeople(PeopleInfo peopleInfo){
        try {
            if (peopleInfoMapper.selectPeopleByPeopleId(peopleInfo.getPersonId()).size() >0)
                return peopleInfoMapper.updatePeopleByPeopleId(peopleInfo);
            else
                return peopleInfoMapper.insertPeople(peopleInfo);
        }catch (Exception ex) {
            if (ex.getMessage().contains("java.sql.SQLIntegrityConstraintViolationException")) {
                return peopleInfoMapper.updatePeopleByPeopleId(peopleInfo);
            }
        }
        return 0;
    }

    @Override
    public Integer deletePeopleByPeopleId(String peopleId) throws Exception {
        return peopleInfoMapper.deletePeopleByPeopleId(peopleId);
    }
}
