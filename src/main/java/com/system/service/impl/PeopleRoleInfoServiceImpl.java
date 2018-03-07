package com.system.service.impl;

import com.system.mapperiot.PeopleRoleInfoMapper;
import com.system.po.PeopleRoleInfo;
import com.system.service.PeopleRoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleRoleInfoServiceImpl implements PeopleRoleInfoService {
    private static Logger logger = LoggerFactory.getLogger("PeopleRoleInfoServiceImpl");
    @Autowired
    private PeopleRoleInfoMapper peopleRoleInfoMapper;

    @Override
    public List<PeopleRoleInfo> selectPeopleRoleInfo() throws Exception {
        return peopleRoleInfoMapper.selectPeopleRoleInfo();
    }

    @Override
    public void insertUpdatePeopleRole(PeopleRoleInfo peopleRoleInfo) throws Exception {
        try {
            if (peopleRoleInfoMapper.selectPeopleRoleInfoByPeopleId(peopleRoleInfo.getUserId()).size() >0)
                peopleRoleInfoMapper.updatePeopleRoleInfoByPeopleId(peopleRoleInfo);
            else
                peopleRoleInfoMapper.insertPeopleRoleInfo(peopleRoleInfo);
        }catch (Exception ex) {
            if (ex.getMessage().contains("java.sql.SQLIntegrityConstraintViolationException")) {
                peopleRoleInfoMapper.updatePeopleRoleInfoByPeopleId(peopleRoleInfo);
            }
            else
                logger.error("insertUpdatePeopleRole出错："+ex.getMessage());
        }
    }

    @Override
    public void deletePeopleRoleInfoByPeopleId(String userId) throws Exception {
        peopleRoleInfoMapper.deletePeopleRoleInfoByPeopleId(userId);
    }
}
