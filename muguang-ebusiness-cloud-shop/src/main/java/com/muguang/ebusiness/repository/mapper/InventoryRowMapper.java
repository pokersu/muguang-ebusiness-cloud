package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Inventory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 16:13.
 */
public class InventoryRowMapper implements RowMapper<Inventory>{
    @Override
    public Inventory mapRow(ResultSet rs, int i) throws SQLException {
        Inventory inventory = null;
        long id = rs.getLong("id");
        if (id!=0){
            inventory = new Inventory();
            inventory.setId(id);
            inventory.setShopCommodityId(rs.getLong("shop_commodity_id"));
            inventory.setGoodsId(rs.getLong("goods_id"));
            inventory.setPrice(rs.getInt("price"));
            inventory.setAmount(rs.getInt("amount"));
            inventory.setStatus(rs.getInt("status"));
            inventory.setWeight(rs.getInt("weight"));
        }
        return inventory;
    }
}
