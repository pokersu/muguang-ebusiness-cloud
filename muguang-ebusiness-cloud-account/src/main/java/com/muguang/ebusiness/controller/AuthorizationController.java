package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.service.impl.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 认证
 * @author muguang
 * @date 2017/3/6 13:50.
 */
@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping
    public String auth(ModelMap model, String name, String password){
        String token = authorizationService.auth(name, password);
        return token;
    }

    @DeleteMapping
    public void deAuth(@RequestHeader("Authorization") String token){
        authorizationService.deAuth(token);
    }
}
