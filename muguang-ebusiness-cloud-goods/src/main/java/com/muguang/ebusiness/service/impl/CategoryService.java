package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Category;
import com.muguang.ebusiness.repository.impl.CategoryRepository;
import com.muguang.ebusiness.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017-3-7 21:32
 */
@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
