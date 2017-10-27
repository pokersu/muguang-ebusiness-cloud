package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.OrderItem;

import java.util.List;

/**
 * @author muguang
 * @date 2017-3-7 21:50
 */
public interface IOrderItemRepository {
    List<OrderItem> findByOrderId(long orderId);
    OrderItem findById(long id);
    OrderItem save(OrderItem item);
}
