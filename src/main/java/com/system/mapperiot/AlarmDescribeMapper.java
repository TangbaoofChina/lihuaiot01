package com.system.mapperiot;

import com.system.po.AlarmDescribe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmDescribeMapper {
    AlarmDescribe selectAlarmDescribeByCodeAndType(@Param("devType") String devType, @Param("alarmCode") String alarmCode);
    List<AlarmDescribe> selectAlarmDescribeByType(String devType);
    void insertAlarmDescribe(AlarmDescribe alarmDescribe);
    void updateAlarmDescribeByTypeAndCode( AlarmDescribe alarmDescribe);
    void deleteAlarmDescribeByTypeAndCode(AlarmDescribe alarmDescribe);
}
