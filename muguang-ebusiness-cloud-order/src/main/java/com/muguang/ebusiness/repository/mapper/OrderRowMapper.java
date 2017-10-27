package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017-3-7 21:52
 */
public class OrderRowMapper implements RowMapper<Order>{
    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        Order order = null;
        long id = rs.getLong("id");
        if (id!=0){
            order = new Order();
            order.setId(id);
            order.setSerialno(rs.getString("serialno"));
            order.setUserId(rs.getLong("user_id"));
            order.setShopId(rs.getLong("shop_id"));
            order.setAddressId(rs.getLong("address_id"));
            order.setNeedInv(rs.getShort("need_inv"));
            order.setInvId(rs.getLong("inv_id"));
            order.setPrice(rs.getInt("price"));
            order.setAmount(rs.getInt("amount"));
            order.setDiscount(rs.getInt("discount"));
            order.setPostage(rs.getInt("postage"));
            order.setStatus(rs.getShort("status"));
            order.setPayStatus(rs.getShort("pay_status"));
            order.setCreateTime(rs.getDate("create_time"));
            order.setPayTime(rs.getDate("pay_time"));
            order.setFinishTime(rs.getDate("finish_time"));
            order.setType(rs.getShort("type"));
        }
        return order;
    }
}
