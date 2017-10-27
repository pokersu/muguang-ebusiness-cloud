package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.GlobalConstant;
import com.muguang.ebusiness.entity.User;
import com.muguang.ebusiness.service.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author muguang
 * @date 2017/3/6 13:54.
 */
@Service
public class AuthorizationService implements IAuthorizationService{

    @Autowired
    private UserService userService;

    @Override
    public String auth(String name, String password) {
        List<User> users = userService.match(name, password);
        if (users.size()!=1){
            throw new RuntimeException("login failure");
        }
        String token = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        GlobalConstant.tokencache.put(token, users.get(0).getId());
        return token;
    }

    @Override
    public void deAuth(String token) {
        GlobalConstant.tokencache.remove(token);
    }
}
