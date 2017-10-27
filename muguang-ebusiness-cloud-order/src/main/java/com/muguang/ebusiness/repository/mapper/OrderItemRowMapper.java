package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author muguang
 * @date 2017-3-7 21:57
 */
public class OrderItemRowMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet rs, int i) throws SQLException {
        OrderItem item = null;
        long id = rs.getLong("id");
        if (id!=0){
            item = new OrderItem();
            item.setId(id);
            item.setOrderId(rs.getLong("order_id"));
            item.setShopId(rs.getLong("shop_id"));
            item.setDealerId(rs.getLong("dealer_id"));
            item.setCommodityId(rs.getLong("commodity_id"));
            item.setCommodityName(rs.getString("commodity_name"));
            item.setGoodsId(rs.getLong("goods_id"));
            item.setGoodsName(rs.getString("goods_name"));
            item.setPrice(rs.getInt("price"));
            item.setAmount(rs.getInt("amount"));
            item.setCreateat(rs.getDate("createat"));
        }
        return item;
    }
}
