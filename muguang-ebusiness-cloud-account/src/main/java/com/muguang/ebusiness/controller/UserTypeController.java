package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.UserType;
import com.muguang.ebusiness.service.impl.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muguang
 * @date 2017-3-7 23:05
 */
@RestController
@RequestMapping("/usertype")
public class UserTypeController {


    @Autowired
    private UserTypeService userTypeService;

    @GetMapping("/all")
    public List<UserType> findAll(){
        return userTypeService.findAll();
    }
}
