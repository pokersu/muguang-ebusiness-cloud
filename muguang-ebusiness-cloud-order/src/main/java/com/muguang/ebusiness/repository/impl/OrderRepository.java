package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Order;
import com.muguang.ebusiness.repository.IOrderRepository;
import com.muguang.ebusiness.repository.mapper.OrderRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * @author muguang
 * @date 2017-3-7 21:50
 */
@Repository
public class OrderRepository implements IOrderRepository {

    private static final String FindById = "select * from `order` where id=?";
    private static final String FindBySerialno = "select * from `order` where serialno=?";
    private static final String FindByUserId = "select * from `order` where user_id=?";
    private static final String FindByDealerId = "select * from `order` where dealer_id=?";
    private static final String FindByShopId = "select * from `order` where shop_id=?";
    private static final String UpdateStatus = "update `order` set status=?, pay_status=? where id=?";
    private static final String Save = "insert into `order`(serialno, user_id, address_id, shop_id, need_inv, inv_id, price, amount, discount, postage, status, pay_status, create_time, pay_time, finish_time, `type`) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Order findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new OrderRowMapper());
    }

    @Override
    public List<Order> findByUserId(long userId) {
        return jdbcTemplate.query(FindByUserId, new Object[]{userId}, new OrderRowMapper());
    }

    @Override
    public List<Order> findByDealerId(long dealerId) {
        return jdbcTemplate.query(FindByDealerId, new Object[]{dealerId}, new OrderRowMapper());
    }

    @Override
    public List<Order> findByShopId(long shopId) {
        return jdbcTemplate.query(FindByShopId, new Object[]{shopId}, new OrderRowMapper());
    }

    @Override
    public Order save(Order order) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, order.getSerialno());
                ps.setLong(2, order.getUserId());
                ps.setLong(3, order.getAddressId());
                ps.setLong(4, order.getShopId());
                ps.setShort(5, order.getNeedInv());
                ps.setLong(6, order.getInvId());
                ps.setInt(7, order.getPrice());
                ps.setInt(8, order.getAmount());
                ps.setInt(9, order.getDiscount());
                ps.setInt(10, order.getPostage());
                ps.setShort(11, order.getStatus());
                ps.setShort(12, order.getPayStatus());
                if (order.getCreateTime() != null) {
                    ps.setTimestamp(13, new Timestamp(order.getCreateTime().getTime()));
                } else {
                    ps.setTimestamp(13, null);
                }
                if (order.getPayTime() != null) {
                    ps.setTimestamp(14, new Timestamp(order.getPayTime().getTime()));
                } else {
                    ps.setTimestamp(14, null);
                }
                if (order.getFinishTime() != null) {
                    ps.setTimestamp(15, new Timestamp(order.getFinishTime().getTime()));
                } else {
                    ps.setTimestamp(15, null);
                }
                ps.setShort(16, order.getType());
                return ps;
            }
        }, keyHolder);
        order.setId(keyHolder.getKey().longValue());
        return order;
    }

    @Override
    public void update(Order order) {
        jdbcTemplate.update(UpdateStatus, new Object[]{order.getStatus(), order.getPayStatus(), order.getId()});
    }

    @Override
    public Order findBySerialno(String serialno) {
        return jdbcTemplate.queryForObject(FindBySerialno, new Object[]{serialno}, new OrderRowMapper());
    }
}
