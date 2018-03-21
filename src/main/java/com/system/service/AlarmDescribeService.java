package com.system.service;

import com.system.po.AlarmDescribe;

import java.util.List;

public interface AlarmDescribeService {
    /**
     * 查询设备报警代码信息
     * @param devType 设备类型
     * @param alarmCode 报警代码
     * @return
     */
    AlarmDescribe selectAlarmDescribeByCodeAndType(String devType, String alarmCode);

    /**
     * 查询设备报警代码信息
     * @param devType 设备类型
     * @return 设备报警信息列表
     */
    List<AlarmDescribe> selectAlarmDescribeByType(String devType);

    /**
     * 插入报警描述信息
     * @param alarmDescribe
     */
    void insertAlarmDescribe(AlarmDescribe alarmDescribe);

    /**
     * 根据报警代码和设备类型修改报警描述
     * @param alarmDescribe
     */
    void updateAlarmDescribeByTypeAndCode(AlarmDescribe alarmDescribe);

    /**
     * 根据报警代码和设备类型删除报警描述
     * @param alarmDescribe
     */
    void deleteAlarmDescribeByTypeAndCode(AlarmDescribe alarmDescribe);
}
