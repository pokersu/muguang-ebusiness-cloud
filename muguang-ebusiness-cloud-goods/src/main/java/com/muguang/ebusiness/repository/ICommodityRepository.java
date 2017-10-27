package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Commodity;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 15:00.
 */
public interface ICommodityRepository {

    List<Commodity> findAll();
    List<Commodity> findByCategoryId(long categoryId);
    Commodity findById(long id);
    void update(Commodity commodity);
    Commodity save(Commodity commodity);
}
