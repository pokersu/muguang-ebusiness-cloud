package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.controller.input.PayRequest;
import com.muguang.ebusiness.service.impl.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muguang
 * @date 2017/3/8 14:30.
 */
@RestController
@RequestMapping("/pay")
@RefreshScope
public class PayController {

    @Autowired
    private PayService payService;

    @Value("${test}")
    private String property;


    @GetMapping("/prop")
    public String prop(){
        return property;
    }
    @PutMapping
    public void pay(PayRequest request){
        payService.pay(request);
    }
}
