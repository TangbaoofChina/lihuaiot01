package com.system.mappereas;

import com.system.po.PeopleInfo;
import com.system.po.PeopleInfoEas;

import java.util.List;

public interface PeopleInfoMapperLiHua {
    List<PeopleInfo> selectAllPeopleInfoOld();
    List<PeopleInfoEas> selectAllPeopleInfo();
}
