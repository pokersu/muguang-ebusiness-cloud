package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Shop;
import com.muguang.ebusiness.repository.IShopRepository;
import com.muguang.ebusiness.repository.mapper.ShopRowMapper;
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
 * @date 2017/3/7 16:12.
 */
@Repository
public class ShopRepository implements IShopRepository{

    private static final String Save = "insert into shop(name, dealer_id, address_id) value(?, ?, ?)";
    private static final String Update = "update shop set name=?, dealer_id=?, address_id=? where id=?";
    private static final String FindByDealerId = "select * from shop where dealer_id=?";
    private static final String FindById = "select * from shop where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Shop save(Shop shop) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, shop.getName());
                ps.setLong(2, shop.getDealerId());
                ps.setLong(3, shop.getAddressId());
                return ps;
            }
        }, keyHolder);
        shop.setId(keyHolder.getKey().longValue());
        return shop;
    }

    @Override
    public void update(Shop shop) {
        jdbcTemplate.update(Update, new Object[]{shop.getName(), shop.getDealerId(), shop.getAddressId(), shop.getId()});
    }

    @Override
    public List<Shop> findByDealerId(long dealerId) {
        return jdbcTemplate.query(FindByDealerId, new Object[]{dealerId}, new ShopRowMapper());
    }
    @Override
    public Shop findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new ShopRowMapper());
    }
}
