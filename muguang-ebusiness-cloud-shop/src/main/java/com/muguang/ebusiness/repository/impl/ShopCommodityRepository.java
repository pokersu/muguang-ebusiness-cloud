package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.ShopCommodity;
import com.muguang.ebusiness.repository.IShopCommodityRepository;
import com.muguang.ebusiness.repository.mapper.ShopCommodityRowMapper;
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
public class ShopCommodityRepository implements IShopCommodityRepository{


    private static final String FindByShopId = "select * from shop_commodity where shop_id=?";
    private static final String FindAll = "select * from shop_commodity";
    private static final String FindById = "select * from shop_commodity where id=?";
    private static final String Update = "update shop_commodity set name=?, status=? where id=?";
    private static final String Save = "insert into shop_commodity(name, shop_id, commodity_id, status) value(?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<ShopCommodity> findByShopId(long shopId) {
        return jdbcTemplate.query(FindByShopId, new Object[]{shopId}, new ShopCommodityRowMapper());
    }

    @Override
    public ShopCommodity findById(long scId) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{scId}, new ShopCommodityRowMapper());
    }

    @Override
    public void update(ShopCommodity sc) {
        jdbcTemplate.update(Update, new Object[]{sc.getName(), sc.getStatus(), sc.getId()});
    }

    @Override
    public ShopCommodity save(ShopCommodity sc) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, sc.getName());
                ps.setLong(2, sc.getShopId());
                ps.setLong(3, sc.getCommodityId());
                ps.setInt(4, sc.getStatus());
                return ps;
            }
        }, keyHolder);
        sc.setId(keyHolder.getKey().longValue());
        return sc;
    }

    @Override
    public List<ShopCommodity> findAll() {
        return jdbcTemplate.query(FindAll, new ShopCommodityRowMapper());
    }
}
