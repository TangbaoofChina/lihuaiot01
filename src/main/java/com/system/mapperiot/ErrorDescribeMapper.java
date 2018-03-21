package com.system.mapperiot;

import com.system.po.AlarmDescribe;
import com.system.po.ErrorDescribe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErrorDescribeMapper {
    ErrorDescribe selectErrorDescribeByCodeAndType(@Param("devType") String devType, @Param("errorCode") String errorCode);
    List<ErrorDescribe> selectErrorDescribeByType(String devType);
    void insertErrorDescribe(ErrorDescribe errorDescribe);
    void updateErrorDescribeByTypeAndCode(ErrorDescribe errorDescribe);
    void deleteErrorDescribeByTypeAndCode(ErrorDescribe errorDescribe);
}
