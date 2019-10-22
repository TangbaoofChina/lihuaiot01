package com.system.service.impl.Phone;

import com.system.mappereas.UserOaEasMapper;
import com.system.po.UserOAEas;
import com.system.po.UserOAEas2019;
import com.system.service.Phone.PhoneUserOaEasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneUserOaEasServiceImpl implements PhoneUserOaEasService {

    @Autowired
    private UserOaEasMapper userOaEasMapper;

    @Override
    public UserOAEas selectUserOaEasByOaId(String oaId) {
        return userOaEasMapper.selectUserOaEasByOaId(oaId);
    }

    @Override
    public UserOAEas2019 selectUserOaEasByOaId2019(String oaId2019) {
        return userOaEasMapper.selectUserOaEasByOaId2019(oaId2019);
    }

    @Override
    public UserOAEas selectUserOaEasByEasId(String easId) {
        return userOaEasMapper.selectUserOaEasByEasId(easId);
    }
}
