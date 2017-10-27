package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.OrderItem;
import com.muguang.ebusiness.repository.IOrderItemRepository;
import com.muguang.ebusiness.repository.mapper.OrderItemRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * @author muguang
 * @date 2017-3-7 21:51
 */
@Repository
public class OrderItemRepository implements IOrderItemRepository{


    private static final String FindByOrderId = "select * from order_item where order_id=?";
    private static final String FindById = "select * from order_item where id=?";
    private static final String Save = "insert into order_item (order_id, shop_id, dealer_id, commodity_id, commodity_name, goods_id, goods_name, price, amount, createat) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<OrderItem> findByOrderId(long orderId) {
        return jdbcTemplate.query(FindByOrderId, new Object[]{orderId}, new OrderItemRowMapper());
    }

    @Override
    public OrderItem findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new OrderItemRowMapper());
    }

    @Override
    public OrderItem save(OrderItem item) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setLong(1, item.getOrderId());
                ps.setLong(2, item.getShopId());
                ps.setLong(3, item.getDealerId());
                ps.setLong(4, item.getCommodityId());
                ps.setString(5, item.getCommodityName());
                ps.setLong(6, item.getGoodsId());
                ps.setString(7, item.getGoodsName());
                ps.setInt(8, item.getPrice());
                ps.setInt(9, item.getAmount());
                if (item.getCreateat()!=null){
                    ps.setTimestamp(10, new Timestamp(item.getCreateat().getTime()));
                }else{
                    ps.setTimestamp(10, null);
                }

                return ps;
            }
        }, keyHolder);
        item.setId(keyHolder.getKey().longValue());
        return item;
    }

}
