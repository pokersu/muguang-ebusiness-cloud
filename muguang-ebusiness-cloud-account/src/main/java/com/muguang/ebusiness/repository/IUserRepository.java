package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.User;

import java.util.List;

/**
 * 用户基本信息
 * @author muguang
 * @date 2017/3/6 11:34.
 */
public interface IUserRepository {

    User findById(Long id);
    List<User> findByName(String name);
    User save(User user);
}
