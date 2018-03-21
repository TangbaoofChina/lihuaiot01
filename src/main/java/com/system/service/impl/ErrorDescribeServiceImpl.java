package com.system.service.impl;

import com.system.mapperiot.ErrorDescribeMapper;
import com.system.po.ErrorDescribe;
import com.system.service.ErrorDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorDescribeServiceImpl implements ErrorDescribeService {

    @Autowired
    private ErrorDescribeMapper errorDescribeMapper;

    @Override
    public ErrorDescribe selectErrorDescribeByCodeAndType(String devType, String errorCode) {
        return errorDescribeMapper.selectErrorDescribeByCodeAndType(devType, errorCode);
    }

    @Override
    public List<ErrorDescribe> selectErrorDescribeByType(String devType) {
        return errorDescribeMapper.selectErrorDescribeByType(devType);
    }

    @Override
    public void insertErrorDescribe(ErrorDescribe errorDescribe) {
        errorDescribeMapper.insertErrorDescribe(errorDescribe);
    }

    @Override
    public void updateErrorDescribeByTypeAndCode(ErrorDescribe errorDescribe) {
        errorDescribeMapper.updateErrorDescribeByTypeAndCode(errorDescribe);
    }

    @Override
    public void deleteErrorDescribeByTypeAndCode(ErrorDescribe errorDescribe) {
        errorDescribeMapper.deleteErrorDescribeByTypeAndCode(errorDescribe);
    }
}
