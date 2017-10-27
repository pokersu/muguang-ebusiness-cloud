package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Shop;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 16:10.
 */
public interface IShopRepository {

    Shop save(Shop shop);
    void update(Shop shop);
    List<Shop> findByDealerId(long dealerId);
    Shop findById(long id);
}
