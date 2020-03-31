package com.system.service.Phone;

import com.system.po.Phone.MobMsgObj;

public interface MobMsgService {
    /**
     * 根据消息预警ID查询消息预警信息
     * @param sid
     * @return
     */
    MobMsgObj selectAlarmMsg(String sid);
}
