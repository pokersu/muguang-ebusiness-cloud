package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Inventory;
import com.muguang.ebusiness.repository.impl.InventoryRepository;
import com.muguang.ebusiness.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:14.
 */
@Service
public class InventoryService implements IInventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> findByShopCommodityId(long shopCommodityId) {
        return inventoryRepository.findByShopCommodityId(shopCommodityId);
    }

    @Override
    public Inventory findById(long id) {
        return inventoryRepository.findById(id);
    }
}
