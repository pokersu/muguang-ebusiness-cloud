package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.UserInfo;
import com.muguang.ebusiness.service.impl.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户信息
 * @author muguang
 * @date 2017/3/6 15:10.
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/user_id/{userId}")
    public UserInfo findById(@PathVariable long userId){
        return userInfoService.findByUserId(userId);
    }

    @PutMapping
    public void update(UserInfo userInfo){
        userInfoService.update(userInfo);
    }
}
