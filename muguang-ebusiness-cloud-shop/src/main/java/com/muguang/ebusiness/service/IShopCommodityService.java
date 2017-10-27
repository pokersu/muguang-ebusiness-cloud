package com.muguang.ebusiness.service;

import com.muguang.ebusiness.controller.input.CreateShopCommodityParam;
import com.muguang.ebusiness.entity.ShopCommodity;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:13.
 */
public interface IShopCommodityService {
    ShopCommodity save(ShopCommodity sc);

    void updateStatus(long shopcommodityId, int status);

    ShopCommodity createCommodityGoods(CreateShopCommodityParam param);

    List<ShopCommodity> findAll();
}
