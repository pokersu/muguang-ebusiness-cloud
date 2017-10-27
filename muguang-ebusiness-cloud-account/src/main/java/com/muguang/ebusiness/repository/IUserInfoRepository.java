package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.UserInfo;

/**
 *
 * 用户详细信息
 * @author muguang
 * @date 2017/3/6 11:35.
 */
public interface IUserInfoRepository {

    UserInfo findById(long id);
    UserInfo findByUserId(long userId);
    UserInfo save(UserInfo userInfo);
    void update(UserInfo userInfo);
}
