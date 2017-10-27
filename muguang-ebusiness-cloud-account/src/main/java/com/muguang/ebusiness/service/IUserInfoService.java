package com.muguang.ebusiness.service;

import com.muguang.ebusiness.entity.UserInfo;

/**
 * @author muguang
 * @date 2017/3/6 11:37.
 */
public interface IUserInfoService {

    UserInfo findByUserId(long userId);
    void update(UserInfo userInfo);
}
