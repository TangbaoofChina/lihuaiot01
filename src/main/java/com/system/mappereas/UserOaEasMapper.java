package com.system.mappereas;

import com.system.po.UserOAEas;
import com.system.po.UserOAEas2019;

public interface UserOaEasMapper {
    UserOAEas selectUserOaEasByOaId(String oaId);
    UserOAEas2019 selectUserOaEasByOaId2019(String oaId2019);
    UserOAEas2019 selectUserOaEasByEasId2019(String easId);
    UserOAEas selectUserOaEasByEasId(String easId);
}
