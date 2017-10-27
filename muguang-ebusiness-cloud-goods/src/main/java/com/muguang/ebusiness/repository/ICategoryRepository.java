package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Category;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 15:01.
 */
public interface ICategoryRepository {
    Category save(Category category);
    List<Category> findAll();
    Category findById(long id);
    void update(Category category);
}
