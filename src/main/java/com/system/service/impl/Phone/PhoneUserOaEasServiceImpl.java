package com.system.service.impl.Phone;

import com.system.mappereas.UserOaEasMapper;
import com.system.po.UserOAEas;
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
}
