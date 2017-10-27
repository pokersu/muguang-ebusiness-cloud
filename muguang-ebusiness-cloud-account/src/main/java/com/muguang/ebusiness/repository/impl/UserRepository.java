package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.User;
import com.muguang.ebusiness.repository.IUserRepository;
import com.muguang.ebusiness.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * @author muguang
 * @date 2017/3/6 12:06.
 */
@Repository
public class UserRepository implements IUserRepository{

    private static final String FindById = "select * from user where id=?";
    private static final String FindByName = "select * from user where name=?";
    private static final String Save = "insert into user(name, password, salt, nickname, sex, age, mobile, mobile_status, email, email_status, usertype, createat, superior) value(?,?,?,?,?,?,?,?,?,?,?,?,?)";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public List<User> findByName(String name) {
        return jdbcTemplate.query(FindByName, new Object[]{name}, new UserRowMapper());
    }

    @Override
    public User save(User user) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, user.getName());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getSalt());
                ps.setString(4, user.getNickname());
                ps.setShort(5, user.getSex());
                ps.setShort(6, user.getAge());
                ps.setString(7, user.getMobile());
                ps.setShort(8, user.getMobileStatus());
                ps.setString(9, user.getEmail());
                ps.setShort(10, user.getEmailStatus());
                ps.setInt(11, user.getUsertype());
                ps.setDate(12, new Date(user.getCreateAt().getTime()));
                ps.setInt(13, user.getSuperior());
                return ps;
            }
        }, keyHolder);
        user.setId(keyHolder.getKey().longValue());
        return user;
    }
}
