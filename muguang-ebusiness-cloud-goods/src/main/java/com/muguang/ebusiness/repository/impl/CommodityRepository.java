package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Commodity;
import com.muguang.ebusiness.repository.ICommodityRepository;
import com.muguang.ebusiness.repository.mapper.CommodityRowMapper;
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
 * @date 2017/3/7 15:00.
 */
@Repository
public class CommodityRepository implements ICommodityRepository {


    private static final String FindAll = "select * from commodity";
    private static final String FindByCategoryId = "select * from commodity where category_id=?";
    private static final String FindById = "select * from commodity where id=?";
    private static final String Update = "update commodity set barcode=?, out_code=?, category_id=?, name=?, pic=?, base_price=?, base_weight=?, type=? where id=?";
    private static final String Save = "insert into commodity(barcode, out_code, category_id, name, pic, base_price, base_weight, type) value(?, ?, ?, ?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Commodity> findAll() {
        return jdbcTemplate.query(FindAll, new CommodityRowMapper());
    }

    @Override
    public List<Commodity> findByCategoryId(long categoryId) {
        return jdbcTemplate.query(FindByCategoryId, new CommodityRowMapper());
    }

    @Override
    public Commodity findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new CommodityRowMapper());
    }

    @Override
    public void update(Commodity commodity) {
        jdbcTemplate.update(Update, new Object[]{commodity.getBarcode(), commodity.getOutCode(), commodity.getCategoryId(), commodity.getName(), commodity.getPic(), commodity.getBasePrice(), commodity.getBaseWeight(), commodity.getType(), commodity.getId()});
    }

    @Override
    public Commodity save(Commodity commodity) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, commodity.getBarcode());
                ps.setString(2, commodity.getOutCode());
                ps.setLong(3, commodity.getCategoryId());
                ps.setString(4, commodity.getName());
                ps.setString(5, commodity.getPic());
                ps.setInt(6, commodity.getBasePrice());
                ps.setInt(7, commodity.getBaseWeight());
                ps.setInt(8, commodity.getType());
                return ps;
            }
        }, keyHolder);
        long autoIncId = keyHolder.getKey().longValue();
        commodity.setId(autoIncId);
        return commodity;
    }
}
