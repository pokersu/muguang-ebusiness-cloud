package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.controller.input.CreateOrderParam;
import com.muguang.ebusiness.entity.Order;
import com.muguang.ebusiness.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/8 10:33.
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${test}")
    private String property;


    @GetMapping("/prop")
    public String prop(){
        return property;
    }

    @GetMapping("/user/{userId}")
    public List<Order> findByUserId(@PathVariable long userId){
        return orderService.findByUserId(userId);
    }

    @GetMapping("/dealer/{dealerId}")
    public List<Order> findByDealerId(@PathVariable long dealerId){
        return orderService.findByDealerId(dealerId);
    }

    @GetMapping("/serialno/{serialno}")
    public Order findBySerialno(@PathVariable String serialno){
        return orderService.findBySerialno(serialno);
    }
    @PutMapping("/status")
    public void successProcess(String serialno, short status, short payStatus){
        orderService.successProcess(serialno, status, payStatus);
    }

    @PostMapping
    Order create(CreateOrderParam param){
        return orderService.create(param);
    }
}
