package com.system.service.Eas.impl;

import com.system.mappereas.ChickenRoomMapper;
import com.system.po.Eas.ChickenRoom;
import com.system.service.Eas.ChickenRoomInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChickenRoomInfoServiceImpl implements ChickenRoomInfoService {

    @Autowired
    private ChickenRoomMapper chickenRoomMapper;

    @Override
    public List<ChickenRoom> selectAllChickenRoom() {
        return chickenRoomMapper.selectAllChickenRoom();
    }
}
