package com.system.mappereas;

import com.system.po.UserOAEas;
import com.system.po.UserOAEas2019;

public interface UserOaEasMapper {
    UserOAEas selectUserOaEasByOaId(String oaId);
    UserOAEas2019 selectUserOaEasByOaId2019(String oaId2019);
    UserOAEas selectUserOaEasByEasId(String easId);
}
