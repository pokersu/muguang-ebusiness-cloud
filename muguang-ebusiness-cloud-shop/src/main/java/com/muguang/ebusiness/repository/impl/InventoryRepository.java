package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Inventory;
import com.muguang.ebusiness.repository.IInventoryRepository;
import com.muguang.ebusiness.repository.mapper.InventoryRowMapper;
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
 * @date 2017/3/7 16:11.
 */
@Repository
public class InventoryRepository implements IInventoryRepository {

    private static final String Save = "insert into inventory(shop_commodity_id, goods_id, price, weight, amount, status) value(?, ?, ?, ?, ?, ?)";
    private static final String Update = "update inventory set price=?, weight=?, amount=?, status=? where id=?";
    private static final String FindByShopCommodityId = "select * from inventory where shop_commodity_id=?";
    private static final String FindById = "select * from inventory where id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Inventory save(Inventory inventory) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, inventory.getShopCommodityId());
                ps.setLong(2, inventory.getGoodsId());
                ps.setInt(3, inventory.getPrice());
                ps.setInt(4, inventory.getWeight());
                ps.setInt(5, inventory.getAmount());
                ps.setInt(6, inventory.getStatus());
                return ps;
            }
        }, keyHolder);
        inventory.setId(keyHolder.getKey().longValue());
        return inventory;
    }

    @Override
    public List<Inventory> findByShopCommodityId(long scId) {
        return jdbcTemplate.query(FindByShopCommodityId, new Object[]{scId}, new InventoryRowMapper());
    }

    @Override
    public void update(Inventory inventory) {
        jdbcTemplate.update(Update, new Object[]{inventory.getPrice(), inventory.getWeight(), inventory.getAmount(), inventory.getStatus(), inventory.getId()});
    }

    @Override
    public Inventory findById(long inventoryId) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{inventoryId}, new InventoryRowMapper());
    }
}
