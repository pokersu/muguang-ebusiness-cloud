package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.Inventory;
import com.muguang.ebusiness.service.impl.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:15.
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/shopcommodity/{shopCommodityId}")
    public List<Inventory> findByShopCommodityId(@PathVariable long shopCommodityId){
        return inventoryService.findByShopCommodityId(shopCommodityId);
    }

    @GetMapping("/id/{}")
    public Inventory findById(long id){
        return inventoryService.findById(id);
    }

}
