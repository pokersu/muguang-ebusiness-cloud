package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.Goods;
import com.muguang.ebusiness.service.impl.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muguang
 * @date 2017/3/7 15:30.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping
    public Goods save(@RequestBody Goods goods){
        return goodsService.save(goods);
    }
}
