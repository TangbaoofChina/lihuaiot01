package com.system.service.Eas;

import com.system.po.Eas.ChickenRoom;

import java.util.List;

public interface ChickenRoomInfoService {
    /**
     * 查询所有的鸡舍信息
     * @return
     */
    public List<ChickenRoom> selectAllChickenRoom();
}
