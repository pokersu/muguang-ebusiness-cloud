package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户基本信息 字段 -> 行映射
 * @author muguang
 * @date 2017/3/6 14:01.
 */
public class UserRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = null;
        long id = rs.getLong("id");
        if (id!=0){
            user = new User();
            user.setId(id);
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setSalt(rs.getString("salt"));
            user.setNickname(rs.getString("nickname"));
            user.setSex(rs.getShort("sex"));
            user.setAge(rs.getShort("age"));
            user.setMobile(rs.getString("mobile"));
            user.setMobileStatus(rs.getShort("mobile_status"));
            user.setEmail(rs.getString("email"));
            user.setEmailStatus(rs.getShort("email_status"));
            user.setUsertype(rs.getInt("usertype"));
            user.setSuperior(rs.getInt("superior"));

            user.setSexName(user.getSex()==1?"male":"female");
            user.setEmailStatusName(user.getEmailStatus()==1?"已认证":"未认证");
            user.setMobileStatusName(user.getEmailStatus()==1?"已认证":"未认证");
        }
        return user;
    }
}
