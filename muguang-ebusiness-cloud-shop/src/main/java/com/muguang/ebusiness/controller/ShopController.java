package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.Shop;
import com.muguang.ebusiness.service.impl.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author muguang
 * @date 2017/3/8 10:15.
 */
@RestController
@RequestMapping("/shop")
@RefreshScope
public class ShopController {

    @Autowired
    private ShopService shopService;
    @Value("${test}")
    private String property;


    @GetMapping("/prop")
    public String prop(){
        return property;
    }
    @GetMapping("/{id}")
    public Shop findById(@PathVariable long id){
        return shopService.findById(id);
    }

    @PostMapping
    public Shop save(Shop shop){
        return shopService.save(shop);
    }
}
