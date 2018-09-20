package com.system.mappereas;

import com.system.po.Eas.ChickenRoom;

import java.util.List;

public interface ChickenRoomMapper {
    /**
     * 查询EAS中的所有鸡舍信息
     * @return
     */
    public List<ChickenRoom> selectAllChickenRoom();
}
