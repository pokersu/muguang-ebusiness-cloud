package com.muguang.ebusiness.service;

import com.muguang.ebusiness.entity.User;
import com.muguang.ebusiness.entity.UserInfo;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/6 11:37.
 */
public interface IUserService {

    User findById(Long id);
    List<User> match(String name, String password);
    User register(User user, UserInfo userInfo);
}
