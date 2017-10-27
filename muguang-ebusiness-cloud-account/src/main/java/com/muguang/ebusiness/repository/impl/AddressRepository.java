package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Address;
import com.muguang.ebusiness.repository.IAddressRepository;
import com.muguang.ebusiness.repository.mapper.AddressRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 18:10.
 */

@Repository
public class AddressRepository implements IAddressRepository {

    private static final String FindDefaultByUserId = "select * from address where user_id=? and isdefault=1";
    private static final String FindByUserId = "select * from address where user_id=?";
    private static final String Save = "insert into address(user_id, province, city, district, address, status, isdefault) value(?, ?, ?, ?, ?, ?, ?)";
    private static final String Upate = "update address set province=?, city=?, district=?, address=?, status=?, isdefault=? where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Address> findByUserId(long userId) {
        return jdbcTemplate.query(FindByUserId, new Object[]{userId}, new AddressRowMapper());
    }

    @Override
    public Address save(Address address) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, address.getUserId());
                ps.setString(2, address.getProvince());
                ps.setString(3, address.getCity());
                ps.setString(4, address.getDistrict());
                ps.setString(5, address.getAddress());
                ps.setInt(6, address.getStatus());
                ps.setInt(7, address.getIsdefault());
                return ps;
            }
        }, keyHolder);
        address.setId(keyHolder.getKey().longValue());
        return address;
    }

    @Override
    public void update(Address address) {
        jdbcTemplate.update(Upate, new Object[]{address.getProvince(), address.getCity(), address.getDistrict(), address.getAddress(), address.getStatus(), address.getIsdefault(), address.getId()});
    }

    @Override
    public Address findDefaultByUserId(long userId) {
        return jdbcTemplate.queryForObject(FindDefaultByUserId, new Object[]{userId}, new AddressRowMapper());
    }
}
