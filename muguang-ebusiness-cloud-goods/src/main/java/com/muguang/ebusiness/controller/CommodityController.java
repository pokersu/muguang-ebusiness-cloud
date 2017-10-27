package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.Commodity;
import com.muguang.ebusiness.service.impl.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * @author muguang
 * @date 2017/3/7 15:29.
 */
@RestController
@RequestMapping("/commodity")
@RefreshScope
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Value("${test}")
    private String property;


    @GetMapping("/prop")
    public String prop(){
        return property;
    }
    @PostMapping
    public Commodity save(@RequestBody Commodity commodity){
        return commodityService.save(commodity);
    }
}
