package com.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.system.mapperiot.LoginRecordMapper;
import com.system.mappereas.UserloginMapperLiHua;
import com.system.po.DataTablePageing;
import com.system.po.LoginRecordInfo;
import com.system.po.Userlogin;
import com.system.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jacey on 2017/6/29.
 */
@Service
public class UserloginServiceImpl implements UserloginService {

    @Autowired
    private UserloginMapperLiHua userloginMapperLiHua;
    @Autowired
    private LoginRecordMapper loginRecordMapper;

    public Userlogin findByNameLiHua(String name) throws Exception {

        List<Userlogin> list = userloginMapperLiHua.selectByName(name);
        return list.get(0);
    }

    @Override
    public void insertLoginRecord(Userlogin userlogin,String loginType,String loginIp) throws Exception {
        loginRecordMapper.insertLoginRecord(userlogin,loginType,new Date(),loginIp);
    }

    @Override
    public DataTablePageing selectLoginInfoByUserIdAndDateAndPaging(Integer pageNumber, Integer pageSize, String[] sUserIds, String sStartDate, String sEndDate) throws Exception {
        List<LoginRecordInfo> loginRecordInfoList = new ArrayList<LoginRecordInfo>();
        DataTablePageing dataTablePageing = new DataTablePageing();
        List<LoginRecordInfo> loginRecordInfoListAll = loginRecordMapper.selectLoginByUserIdsAndDate(sUserIds,sStartDate,sEndDate);
        if (loginRecordInfoListAll.size() > 0)
        {
            Integer bigIndex = 0;
            Integer smallIndex = 0;
            smallIndex = pageNumber-1;
            bigIndex = smallIndex + pageSize;
            if(bigIndex > loginRecordInfoListAll.size())
                bigIndex = loginRecordInfoListAll.size();
            loginRecordInfoList.addAll(loginRecordInfoListAll.subList(smallIndex,bigIndex));
        }
        String str= JSON.toJSON(loginRecordInfoList).toString();
        String sReturnJson = JSON.toJSONString(loginRecordInfoList);
        dataTablePageing.setTotal(loginRecordInfoListAll.size());
        dataTablePageing.setsReturnJson(sReturnJson);
        //return dataDetailList;
        return dataTablePageing;
    }
}
