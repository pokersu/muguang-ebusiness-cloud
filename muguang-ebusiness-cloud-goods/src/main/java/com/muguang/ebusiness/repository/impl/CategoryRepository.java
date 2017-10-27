package com.muguang.ebusiness.repository.impl;

import com.muguang.ebusiness.entity.Category;
import com.muguang.ebusiness.repository.ICategoryRepository;
import com.muguang.ebusiness.repository.mapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 15:01.
 */
@Repository
public class CategoryRepository implements ICategoryRepository {

    private static final String Save = "insert into category(name, logo, hot, recommend) value(?,?,?,?)";
    private static final String FindAll = "select * from category";
    private static final String FindById = "select * from category where id=?";
    private static final String Upate ="update category set name=?, logo=?, hot=?, recommend=? where id=?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Category save(Category category) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(Save, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, category.getName());
                ps.setString(2, category.getLogo());
                ps.setLong(3, category.getHot());
                ps.setLong(4, category.getRecommend());
                return ps;
            }
        }, keyHolder);
        long autoIncId = keyHolder.getKey().longValue();
        category.setId(autoIncId);
        return category;
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query(FindAll, new Object[]{}, new CategoryRowMapper());
    }

    @Override
    public Category findById(long id) {
        return jdbcTemplate.queryForObject(FindById, new Object[]{id}, new CategoryRowMapper());
    }

    @Override
    public void update(Category category) {
        jdbcTemplate.update(Upate, new Object[]{category.getName(), category.getLogo(), category.getHot(), category.getRecommend(), category.getId()});
    }
}
