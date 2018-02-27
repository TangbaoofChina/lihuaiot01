package com.system.mapperiot;

import com.system.po.LoginRecordInfo;
import com.system.po.Userlogin;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LoginRecordMapper {
    void insertLoginRecord(@Param("userlogin")Userlogin userlogin, @Param("loginType")String loginType,
                           @Param("loginDate")Date loginDate,@Param("loginIp")String loginIp);

    List<LoginRecordInfo> selectLoginByUserIdsAndDate(@Param("userIds") String[] sUserIds,
                                                       @Param("startDate") String sStartTime,
                                                       @Param("endDate") String sEndDate);
}
