package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Shop;
import com.muguang.ebusiness.repository.impl.ShopRepository;
import com.muguang.ebusiness.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017/3/8 10:14.
 */
@Service
public class ShopService implements IShopService{

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public Shop findById(long id) {
        return shopRepository.findById(id);
    }
}
