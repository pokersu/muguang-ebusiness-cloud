package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.Account;
import com.muguang.ebusiness.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author muguang
 * @date 2017/3/7 14:11.
 */
@RestController
@RequestMapping("/account")
@RefreshScope
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Value("${test}")
    private String property;


    @GetMapping("/prop")
    public String prop(){
        return property;
    }

    @GetMapping("/user/{userId}")
    public Account findByUserId(@PathVariable Long userId){
        return accountService.findByUserId(userId);
    }

    @PostMapping
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @PostMapping("/balance")
    public void updateBalance(long userId, int amount){
        accountService.updateBalance(userId, amount);
    }
}
