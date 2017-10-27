package com.muguang.ebusiness.repository.mapper;

import com.muguang.ebusiness.entity.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author muguang
 * @date 2017/3/7 15:01.
 */
public class CategoryRowMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
        Category category = null;
        long id = rs.getLong("id");
        if (id!=0){
            category = new Category();
            category.setId(id);
            category.setName(rs.getString("name"));
            category.setHot(rs.getLong("hot"));
            category.setLogo(rs.getString("logo"));
            category.setRecommend(rs.getLong("recommend"));
        }
        return category;
    }
}
