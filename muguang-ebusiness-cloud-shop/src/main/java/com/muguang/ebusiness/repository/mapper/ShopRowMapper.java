package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Shop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 16:12.
 */
public class ShopRowMapper implements RowMapper<Shop>{
    @Override
    public Shop mapRow(ResultSet rs, int i) throws SQLException {
        Shop shop = null;
        long id = rs.getLong("id");
        if (id!=0){
            shop = new Shop();
            shop.setId(id);
            shop.setName(rs.getString("name"));
            shop.setAddressId(rs.getLong("address_id"));
            shop.setDealerId(rs.getLong("dealer_id"));
        }
        return shop;
    }
}
