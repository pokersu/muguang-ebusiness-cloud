package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.ShopCommodity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 16:13.
 */
public class ShopCommodityRowMapper implements RowMapper<ShopCommodity> {
    @Override
    public ShopCommodity mapRow(ResultSet rs, int i) throws SQLException {
        ShopCommodity shopCommodity = null;
        long id = rs.getLong("id");
        if (id!=0){
            shopCommodity = new ShopCommodity();
            shopCommodity.setId(id);
            shopCommodity.setShopId(rs.getLong("shop_id"));
            shopCommodity.setName(rs.getString("name"));
            shopCommodity.setStatus(rs.getInt("status"));
            shopCommodity.setCommodityId(rs.getLong("commodity_id"));
        }
        return shopCommodity;
    }
}
