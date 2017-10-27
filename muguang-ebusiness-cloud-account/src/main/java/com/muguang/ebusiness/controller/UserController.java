package com.muguang.ebusiness.controller;

import com.muguang.ebusiness.entity.User;
import com.muguang.ebusiness.entity.UserInfo;
import com.muguang.ebusiness.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 * @author muguang
 * @date 2017/3/6 11:45.
 */
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${test}")
    private String property;

    @GetMapping("/prop")
    public String prop(){
        return property;
    }

    @GetMapping("/choose")
    public String loadChoose(){
        ServiceInstance choose = loadBalancerClient.choose("yokimi-ebusiness-cloud-finance");
        String str = choose.getServiceId() + ":" + choose.getHost() + ":" + choose.getPort();
        System.out.println(str);
        return str;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User register(User user, UserInfo userInfo){
        return userService.register(user, userInfo);
    }
}
