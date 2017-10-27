package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.UserLoginLog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户登录日志 字段 -> 行 映射
 * @author muguang
 * @date 2017/3/7 11:02.
 */
public class UserLoginLogRowMapper implements RowMapper<UserLoginLog> {
    @Override
    public UserLoginLog mapRow(ResultSet rs, int i) throws SQLException {
        UserLoginLog log = null;
        long id = rs.getLong("id");
        if (id!=0){
            log = new UserLoginLog();
            log.setId(id);
            log.setLoginDevice(rs.getString("login_device"));
            log.setLoginIp(rs.getString("login_ip"));
            log.setLoginTime(rs.getDate("login_time"));
        }
        return log;
    }
}
