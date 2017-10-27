package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.controller.input.CreateOrderParam;
import com.muguang.ebusiness.entity.Order;
import com.muguang.ebusiness.entity.OrderItem;
import com.muguang.ebusiness.repository.impl.OrderItemRepository;
import com.muguang.ebusiness.repository.impl.OrderRepository;
import com.muguang.ebusiness.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author muguang
 * @date 2017/3/8 10:33.
 */
@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<Order> findByUserId(long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order create(CreateOrderParam param) {
        Order order = new Order();
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String serialno = sdf.format(new Date())+random.nextInt(999);
        order.setSerialno(serialno);
        order.setUserId(param.getUserId());
        order.setShopId(param.getShopId());
        order.setAddressId(param.getAddressId());
        order.setNeedInv(param.getNeedInv());
        order.setInvId(param.getInvId());
        order.setPrice(param.getPrice());
        order.setAmount(param.getAmount());
        order.setDiscount(param.getDiscount());
        order.setPostage(param.getPostage());
        order.setStatus(param.getStatus());
        order.setPayStatus(param.getPayStatus());
        order.setCreateTime(new Date());
        order.setType((short)1);
        order = orderRepository.save(order);
        List<OrderItem> items = param.getItems();
        for (OrderItem item : items) {
            item.setOrderId(order.getId());
            item.setCreateat(new Date());
            orderItemRepository.save(item);
        }
        return order;
    }

    @Override
    public List<Order> findByDealerId(long dealerId) {
        return orderRepository.findByUserId(dealerId);
    }

    @Override
    public void successProcess(String serialno, short status, short payStatus) {
        Order order = orderRepository.findBySerialno(serialno);
        order.setStatus(status);
        order.setPayStatus(payStatus);
        orderRepository.update(order);
    }

    @Override
    public Order findBySerialno(String serialno) {
        return orderRepository.findBySerialno(serialno);
    }
}
