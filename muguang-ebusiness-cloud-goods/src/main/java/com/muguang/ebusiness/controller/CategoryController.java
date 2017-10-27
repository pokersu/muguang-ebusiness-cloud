package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.Category;
import com.muguang.ebusiness.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muguang
 * @date 2017/3/7 15:29.
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category save(Category category){
        return categoryService.save(category);
    }
}
