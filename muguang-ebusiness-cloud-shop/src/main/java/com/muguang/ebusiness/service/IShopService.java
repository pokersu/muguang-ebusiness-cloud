package com.muguang.ebusiness.service;

import com.muguang.ebusiness.entity.Shop;

/**
 * @author muguang
 * @date 2017/3/8 10:13.
 */
public interface IShopService {
    Shop save(Shop shop);

    Shop findById(long id);
}
