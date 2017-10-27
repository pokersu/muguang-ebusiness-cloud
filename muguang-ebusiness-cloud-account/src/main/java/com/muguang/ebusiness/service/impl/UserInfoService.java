package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.UserInfo;
import com.muguang.ebusiness.repository.impl.UserInfoRepository;
import com.muguang.ebusiness.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017/3/6 11:38.
 */
@Service
public class UserInfoService implements IUserInfoService{

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUserId(long userId) {
        return userInfoRepository.findByUserId(userId);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoRepository.update(userInfo);
    }
}
