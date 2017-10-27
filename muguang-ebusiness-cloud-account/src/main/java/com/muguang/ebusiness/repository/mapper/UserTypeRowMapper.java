package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.UserType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户类型 字段->行 映射
 * @author muguang
 * @date 2017/3/7 11:00.
 */
public class UserTypeRowMapper implements RowMapper<UserType> {
    @Override
    public UserType mapRow(ResultSet rs, int i) throws SQLException {
        UserType userType = null;

        long id = rs.getLong("id");
        if (id!=0){
            userType = new UserType();
            userType.setId(id);
            userType.setName(rs.getString("name"));
        }
        return userType;
    }
}
