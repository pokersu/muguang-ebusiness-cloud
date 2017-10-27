package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.UserType;

import java.util.List;

/**
 * 用户类型
 * @author muguang
 * @date 2017/3/6 11:35.
 */
public interface IUserTypeRepository {

    List<UserType> findAll();
}
