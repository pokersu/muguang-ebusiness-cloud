package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Goods;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 15:00.
 */
public interface IGoodsRepository {
    List<Goods> findByCommodityId(long commodityId);
    Goods findById(long id);
    Goods save(Goods goods);
    void update(Goods goods);
}
