package com.system.service.impl;

import com.system.mapperiot.AlarmDescribeMapper;
import com.system.po.AlarmDescribe;
import com.system.service.AlarmDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmDescribeServiceImpl implements AlarmDescribeService {

    @Autowired
    private AlarmDescribeMapper alarmDescribeMapper;

    @Override
    public AlarmDescribe selectAlarmDescribeByCodeAndType(String devType, String alarmCode) {
        return alarmDescribeMapper.selectAlarmDescribeByCodeAndType(devType, alarmCode);
    }

    @Override
    public List<AlarmDescribe> selectAlarmDescribeByType(String devType) {
        return alarmDescribeMapper.selectAlarmDescribeByType(devType);
    }

    @Override
    public void insertAlarmDescribe(AlarmDescribe alarmDescribe) {
        alarmDescribeMapper.insertAlarmDescribe(alarmDescribe);
    }

    @Override
    public void updateAlarmDescribeByTypeAndCode(AlarmDescribe alarmDescribe) {
        alarmDescribeMapper.updateAlarmDescribeByTypeAndCode(alarmDescribe);
    }

    @Override
    public void deleteAlarmDescribeByTypeAndCode(AlarmDescribe alarmDescribe) {
        alarmDescribeMapper.deleteAlarmDescribeByTypeAndCode(alarmDescribe);
    }
}
