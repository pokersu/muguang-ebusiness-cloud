package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.controller.input.PayRequest;
import com.muguang.ebusiness.entity.Order;
import com.muguang.ebusiness.entity.Shop;
import com.muguang.ebusiness.feign.FinanceFeignClient;
import com.muguang.ebusiness.feign.OrderFeignClient;
import com.muguang.ebusiness.feign.ShopFeignClient;
import com.muguang.ebusiness.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017/3/8 14:31.
 */
@Service
public class PayService implements IPayService{


    @Autowired
    private FinanceFeignClient financeFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private ShopFeignClient shopFeignClient;

    @Override
    public void pay(PayRequest request) {

        Order order = orderFeignClient.findBySerialno(request.getSerialNo());
        Shop shop = shopFeignClient.findById(order.getShopId());

        //1. 财务系统执行交易扣款
        financeFeignClient.updateBalance(order.getUserId(), -order.getPrice());
        financeFeignClient.updateBalance(shop.getDealerId(), order.getPrice());
        //2. 订单系统处理订单状态
        orderFeignClient.successProcess(order.getSerialno(), (short)1, (short)1);

    }
}
