package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Commodity;
import com.muguang.ebusiness.repository.impl.CommodityRepository;
import com.muguang.ebusiness.service.ICommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017-3-7 21:32
 */
@Service
public class CommodityService implements ICommodityService{

    @Autowired
    private CommodityRepository commodityRepository;

    @Override
    public Commodity save(Commodity commodity) {
        return commodityRepository.save(commodity);
    }
}
