package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 18:10.
 */
public class AddressRowMapper implements RowMapper<Address>{
    @Override
    public Address mapRow(ResultSet rs, int i) throws SQLException {
        Address address = null;
        long id = rs.getLong("id");
        if (id!=0){
            address = new Address();
            address.setId(id);
            address.setUserId(rs.getLong("user_id"));
            address.setAddress(rs.getString("address"));
            address.setProvince(rs.getString("province"));
            address.setCity(rs.getString("city"));
            address.setDistrict(rs.getString("district"));
            address.setIsdefault(rs.getInt("isdefault"));
            address.setStatus(rs.getInt("status"));
        }
        return address;
    }
}
