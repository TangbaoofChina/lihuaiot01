package com.system.service.Phone;

import com.system.po.UserOAEas;
import com.system.po.UserOAEas2019;

public interface PhoneUserOaEasService {
    /**
     * 根据OA的ID获取ESA的ID
     * @param oaId OA ID
     * @return
     */
    UserOAEas selectUserOaEasByOaId(String oaId);

    /**
     * 根据新的OA的ID获取ESA的ID
     * @param oaId2019 新OA ID
     * @return
     */
    UserOAEas2019 selectUserOaEasByOaId2019(String oaId2019);

    /**
     * 根据新的OA的ID获取ESA的ID
     * @param easId 新OA ID
     * @return
     */
    UserOAEas2019 selectUserOaEasByEasId2019(String easId);

    /**
     * 根据eas的ID获取OA的ID
     * @param easId
     * @return
     */
    UserOAEas selectUserOaEasByEasId(String easId);
}
