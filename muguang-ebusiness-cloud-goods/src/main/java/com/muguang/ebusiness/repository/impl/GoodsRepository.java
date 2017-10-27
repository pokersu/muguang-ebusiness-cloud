package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Goods;
import com.muguang.ebusiness.repository.IGoodsRepository;
import com.muguang.ebusiness.repository.mapper.GoodsRowMapper;
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
public class GoodsRepository implements IGoodsRepository{

    private static final String FindByCommodityId = "select * from goods where commodity_id=?";
    private static final String FindById = "select * from goods where id=?";
    private static final String Update = "update goods set code=?, commodity_id=?, specifications=?, price=?, weight=? where id=?";
    private static final String Save = "insert into goods(code, commodity_id, specifications, price, weight) value(?, ?, ?, ?, ?)";


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Goods> findByCommodityId(long commodityId) {
        return jdbcTemplate.query(FindByCommodityId, new Object[]{commodityId}, new GoodsRowMapper());
    }

    @Override
    public Goods findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new GoodsRowMapper());
    }

    @Override
    public Goods save(Goods goods) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, goods.getCode());
                ps.setLong(2, goods.getCommodityId());
                ps.setString(3, goods.getSpecifications());
                ps.setInt(4, goods.getPrice());
                ps.setInt(5, goods.getWeight());
                return ps;
            }
        }, keyHolder);
        goods.setId(keyHolder.getKey().longValue());
        return goods;
    }

    @Override
    public void update(Goods goods) {
        jdbcTemplate.update(Update, new Object[]{goods.getCode(), goods.getCommodityId(), goods.getSpecifications(), goods.getPrice(), goods.getWeight(), goods.getId()});
    }
}
