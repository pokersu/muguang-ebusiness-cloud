package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.UserType;
import com.muguang.ebusiness.repository.IUserTypeRepository;
import com.muguang.ebusiness.repository.mapper.UserTypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/6 12:07.
 */
@Repository
public class UserTypeRepository implements IUserTypeRepository {

    private static final String FindAll = "select * from user_type";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<UserType> findAll() {
        return jdbcTemplate.query(FindAll, new UserTypeRowMapper());
    }
}
