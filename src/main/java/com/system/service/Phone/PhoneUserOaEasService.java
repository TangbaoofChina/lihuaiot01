package com.system.service.Phone;

import com.system.po.UserOAEas;

public interface PhoneUserOaEasService {
    /**
     * 根据OA的ID获取ESA的ID
     * @param oaId OA ID
     * @return
     */
    UserOAEas selectUserOaEasByOaId(String oaId);
}
