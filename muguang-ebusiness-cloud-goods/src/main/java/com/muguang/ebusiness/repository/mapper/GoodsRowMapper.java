package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Goods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 15:03.
 */
public class GoodsRowMapper implements RowMapper<Goods>{
    @Override
    public Goods mapRow(ResultSet rs, int i) throws SQLException {
        Goods goods = null;
        long id = rs.getLong("id");
        if (id!=0){
            goods = new Goods();
            goods.setId(id);
            goods.setCommodityId(rs.getLong("commodity_id"));
            goods.setPrice(rs.getInt("price"));
            goods.setWeight(rs.getInt("weight"));
            goods.setSpecifications(rs.getString("specifications"));
        }
        return goods;
    }
}
