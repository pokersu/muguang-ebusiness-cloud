package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Inventory;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 16:11.
 */
public interface IInventoryRepository {

    Inventory save(Inventory inventory);
    List<Inventory> findByShopCommodityId(long scId);
    void update(Inventory inventory);
    Inventory findById(long inventoryId);
}
