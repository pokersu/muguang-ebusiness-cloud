package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Goods;
import com.muguang.ebusiness.repository.impl.GoodsRepository;
import com.muguang.ebusiness.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017-3-7 21:32
 */
@Service
public class GoodsService implements IGoodsService{


    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }
}
