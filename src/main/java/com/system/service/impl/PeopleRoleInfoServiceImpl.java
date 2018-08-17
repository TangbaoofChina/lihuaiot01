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
    public List<PeopleRoleInfo> selectPeopleRoleInfoByRoleAdmin(String roleAdmin) throws Exception {
        return peopleRoleInfoMapper.selectPeopleRoleInfoByRoleAdmin(roleAdmin);
    }

    @Override
    public List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleId(String userId) throws Exception {
        return peopleRoleInfoMapper.selectPeopleRoleInfoByPeopleId(userId);
    }

    @Override
    public List<PeopleRoleInfo> selectPeopleRoleInfoByRoleId(String roleId) throws Exception {
        return peopleRoleInfoMapper.selectPeopleRoleInfoByRoleId(roleId);
    }

    @Override
    public List<PeopleRoleInfo> selectPeopleRoleInfoDistinct() throws Exception {
        return peopleRoleInfoMapper.selectPeopleRoleInfoDistinct();
    }

    @Override
    public List<PeopleRoleInfo> selectPeopleRoleInfoByPeopleIdDistinct(String userId) throws Exception {
        return peopleRoleInfoMapper.selectPeopleRoleInfoByPeopleIdDistinct(userId);
    }

    @Override
    public void insertUpdatePeopleRoles(List<PeopleRoleInfo> peopleRoleInfoList) throws Exception {
        try {
            for (PeopleRoleInfo peopleRoleInfo : peopleRoleInfoList
                    ) {
                if (peopleRoleInfoMapper.selectPeopleRoleInfoByUserIdAndRoleId(peopleRoleInfo.getUserId(), peopleRoleInfo.getRoleId()).size() > 0) {
                    peopleRoleInfoMapper.updatePeopleRoleInfo(peopleRoleInfo);
                } else {
                    peopleRoleInfoMapper.insertOnePeopleRoleInfo(peopleRoleInfo);
                }
            }

        } catch (Exception ex) {
            logger.error("insertUpdatePeopleRole出错：" + ex.getMessage());
        }
    }

    @Override
    public void deletePeopleRoleInfoByPeopleIdAndRoleId(String userId, String roleId) throws Exception {
        peopleRoleInfoMapper.deletePeopleRoleInfoByPeopleIdAndRoleId(userId, roleId);
    }
}
