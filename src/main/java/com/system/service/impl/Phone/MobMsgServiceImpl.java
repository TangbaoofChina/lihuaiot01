package com.system.service.impl.Phone;

import com.system.mapperiot.MobMsgMapper;
import com.system.po.Phone.MobMsgObj;
import com.system.service.Phone.MobMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MobMsgServiceImpl
 * @Description TODO
 * @Author tangbao
 * @Date 2020-03-31 16:54
 * @Version 1.0
 **/
@Service
public class MobMsgServiceImpl implements MobMsgService {
    @Autowired
    private MobMsgMapper mobMsgMapper;

    @Override
    public MobMsgObj selectAlarmMsg(String sid) {
        return mobMsgMapper.selectAlarmMsg(sid);
    }
}
