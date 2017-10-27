package com.muguang.ebusiness.service;

import com.muguang.ebusiness.entity.Inventory;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:13.
 */
public interface IInventoryService {
    List<Inventory> findByShopCommodityId(long shopCommodityId);

    Inventory findById(long id);
}
