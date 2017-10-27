package com.muguang.ebusiness.service;

import com.muguang.ebusiness.controller.input.CreateOrderParam;
import com.muguang.ebusiness.entity.Order;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:31.
 */
public interface IOrderService {
    List<Order> findByUserId(long userId);

    Order create(CreateOrderParam param);

    List<Order> findByDealerId(long dealerId);

    void successProcess(String serialno, short status, short payStatus);

    Order findBySerialno(String serialno);
}
