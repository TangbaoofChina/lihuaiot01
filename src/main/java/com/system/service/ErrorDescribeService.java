package com.system.service;

import com.system.po.AlarmDescribe;
import com.system.po.ErrorDescribe;

import java.util.List;

public interface ErrorDescribeService {
    /**
     * 查询设备错误代码信息
     * @param devType 设备类型
     * @param errorCode 错误代码
     * @return
     */
    ErrorDescribe selectErrorDescribeByCodeAndType(String devType, String errorCode);

    /**
     * 查询设备错误代码信息
     * @param devType 设备类型
     * @return 设备错误信息列表
     */
    List<ErrorDescribe> selectErrorDescribeByType(String devType);

    /**
     * 插入错误描述信息
     * @param errorDescribe
     */
    void insertErrorDescribe(ErrorDescribe errorDescribe);

    /**
     * 根据错误代码和设备类型修改错误描述
     * @param errorDescribe
     */
    void updateErrorDescribeByTypeAndCode(ErrorDescribe errorDescribe);

    /**
     * 根据错误代码和设备类型删除错误描述
     * @param errorDescribe
     */
    void deleteErrorDescribeByTypeAndCode(ErrorDescribe errorDescribe);
}
