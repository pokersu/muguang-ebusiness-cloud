package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.UserInfo;
import com.muguang.ebusiness.repository.IUserInfoRepository;
import com.muguang.ebusiness.repository.mapper.UserInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

/**
 * @author muguang
 * @date 2017/3/6 12:06.
 */
@Repository
public class UserInfoRepository implements IUserInfoRepository{

    private static final String FindById = "select * from user_info where id=?";
    private static final String FindByUserId = "select * from user_info where user_id=?";
    private static final String Upate = "update user_info set realname=?, birth=?, idno=?, occupation=?, school=?, company=?, hometown=?, country=?, province=?, city=?, district=?, address=? where id=?";
    private static final String Save = "insert into user_info(user_id, realname, birth, idno, occupation, school, company, hometown, country, province, city, district, address, lastlogin_time, lastlogin_ip) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public UserInfo findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new UserInfoRowMapper());
    }

    @Override
    public UserInfo findByUserId(long userId) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{userId}, new UserInfoRowMapper());
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, userInfo.getUserId());
                ps.setString(2, userInfo.getRealname());
                if (userInfo.getBirth()!=null){
                    ps.setDate(3, new Date(userInfo.getBirth().getTime()));
                }else{
                    ps.setDate(3, null);
                }
                ps.setString(4, userInfo.getIdno());
                ps.setString(5, userInfo.getOccupation());
                ps.setString(6, userInfo.getSchool());
                ps.setString(7, userInfo.getCompany());
                ps.setString(8, userInfo.getHometown());
                ps.setString(9, userInfo.getCountry());
                ps.setString(10, userInfo.getProvince());
                ps.setString(11, userInfo.getCity());
                ps.setString(12, userInfo.getDistrict());
                ps.setString(13, userInfo.getAddress());
                if (userInfo.getLastloginTime()!=null){
                    ps.setDate(14, new Date(userInfo.getLastloginTime().getTime()));
                }else{
                    ps.setDate(14, null);
                }
                ps.setString(15, userInfo.getLastloginIp());
                return ps;
            }
        }, keyHolder);
        userInfo.setId(keyHolder.getKey().longValue());
        return userInfo;
    }

    @Override
    public void update(UserInfo userInfo) {
        jdbcTemplate.update(Upate, new Object[]{userInfo.getRealname(), userInfo.getBirth(), userInfo.getIdno(), userInfo.getOccupation(), userInfo.getSchool(), userInfo.getCompany(), userInfo.getHometown(), userInfo.getCountry(), userInfo.getProvince(), userInfo.getCity(), userInfo.getDistrict(), userInfo.getAddress(), userInfo.getId()});
    }
}
