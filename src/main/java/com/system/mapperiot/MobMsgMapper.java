package com.system.mapperiot;

import com.system.po.Phone.MobMsgObj;

public interface MobMsgMapper {
    /**
     * 根据ID查询报警信息
     * @param sid
     * @return
     */
    MobMsgObj selectAlarmMsg(String sid);
}
