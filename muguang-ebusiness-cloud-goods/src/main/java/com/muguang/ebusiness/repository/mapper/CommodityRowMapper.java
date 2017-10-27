package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Commodity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 15:05.
 */
public class CommodityRowMapper implements RowMapper<Commodity>{
    @Override
    public Commodity mapRow(ResultSet rs, int i) throws SQLException {
        Commodity commodity = null;
        long id = rs.getLong("id");
        if (id!=0){
            commodity = new Commodity();
            commodity.setId(id);
            commodity.setBarcode(rs.getString("barcode"));
            commodity.setOutCode(rs.getString("out_code"));
            commodity.setCategoryId(rs.getLong("category_id"));
            commodity.setName(rs.getString("name"));
            commodity.setPic(rs.getString("pic"));
            commodity.setBasePrice(rs.getInt("base_price"));
            commodity.setBaseWeight(rs.getInt("base_weight"));
            commodity.setType(rs.getInt("type"));
        }
        return commodity;
    }
}
