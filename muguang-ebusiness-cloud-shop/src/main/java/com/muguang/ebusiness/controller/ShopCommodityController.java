package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.controller.input.CreateShopCommodityParam;
import com.muguang.ebusiness.entity.ShopCommodity;
import com.muguang.ebusiness.service.impl.ShopCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:15.
 */
@RestController
@RequestMapping("/shopcommodity")
public class ShopCommodityController {

    @Autowired
    private ShopCommodityService shopCommodityService;

    @PostMapping
    public ShopCommodity save(CreateShopCommodityParam param){
        return shopCommodityService.createCommodityGoods(param);
    }

    @GetMapping
    public List<ShopCommodity> findAll(){
        return shopCommodityService.findAll();
    }

    @PutMapping("/status")
    public HttpEntity updateStatus(long shopcommodityId, int status){
        shopCommodityService.updateStatus(shopcommodityId, status);
        return new HttpEntity("SUCCESS");
    }
}
