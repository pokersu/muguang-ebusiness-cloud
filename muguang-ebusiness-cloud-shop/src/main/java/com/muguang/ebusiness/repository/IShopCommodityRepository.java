package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.ShopCommodity;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 16:10.
 */
public interface IShopCommodityRepository {

    List<ShopCommodity> findByShopId(long shopId);
    ShopCommodity findById(long scId);
    void update(ShopCommodity sc);
    ShopCommodity save(ShopCommodity sc);

    List<ShopCommodity> findAll();
}
