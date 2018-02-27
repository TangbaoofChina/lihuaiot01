package com.system.service;

import com.system.po.DataTablePageing;
import com.system.po.Userlogin;

/**
 *
 *
 */
public interface UserloginService {
    //根据名字查找用户-立华用户表
    Userlogin findByNameLiHua(String name) throws Exception;

    void insertLoginRecord(Userlogin userlogin,String loginType,String loginIp) throws Exception;

    DataTablePageing selectLoginInfoByUserIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String[] sUserIds, String sStartDate, String sEndDate) throws Exception;
}
