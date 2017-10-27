package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 用户详细信息 字段 -> 行映射
 * @author muguang
 * @date 2017/3/6 15:13.
 */
public class UserInfoRowMapper implements RowMapper<UserInfo> {

    @Override
    public UserInfo mapRow(ResultSet rs, int i) throws SQLException {
        UserInfo userInfo = null;
        long id = rs.getLong("id");
        if (id!=0){
            userInfo = new UserInfo();
            userInfo.setId(id);
            userInfo.setUserId(rs.getLong("user_id"));
            userInfo.setRealname(rs.getString("realname"));
            userInfo.setBirth(rs.getDate("birth"));
            userInfo.setIdno(rs.getString("idno"));
            userInfo.setOccupation(rs.getString("occupation"));
            userInfo.setSchool(rs.getString("school"));
            userInfo.setCompany(rs.getString("company"));
            userInfo.setHometown(rs.getString("hometown"));
            userInfo.setCountry(rs.getString("country"));
            userInfo.setProvince(rs.getString("province"));
            userInfo.setCity(rs.getString("city"));
            userInfo.setDistrict(rs.getString("district"));
            userInfo.setAddress(rs.getString("address"));
            userInfo.setLastloginTime(rs.getDate("lastlogin_time"));
            userInfo.setLastloginIp(rs.getString("lastlogin_ip"));
        }
        return userInfo;
    }
}
