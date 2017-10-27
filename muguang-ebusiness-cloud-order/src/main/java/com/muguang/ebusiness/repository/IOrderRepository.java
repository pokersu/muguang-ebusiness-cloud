package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Order;

import java.util.List;

/**
 * @author muguang
 * @date 2017-3-7 21:50
 */
public interface IOrderRepository {

    Order findById(long id);
    List<Order> findByUserId(long userId);
    List<Order> findByDealerId(long dealerId);
    List<Order> findByShopId(long shopId);
    Order save(Order order);
    void update(Order order);
    Order findBySerialno(String serialno);
}
