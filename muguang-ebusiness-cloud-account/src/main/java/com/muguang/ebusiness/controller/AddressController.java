package com.muguang.ebusiness.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.muguang.ebusiness.entity.Address;
import com.muguang.ebusiness.service.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author muguang
 * @date 2017-3-8 0:19
 */
@RestController
@RequestMapping("/address")
@EnableCircuitBreaker
public class AddressController {

    @Autowired
    private AddressService addressService;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{userId}")
    public List<Address> findByUserId(@PathVariable long userId){
        Random random = new Random();
        int ran = random.nextInt(9);
        if (ran<3){
            throw new RuntimeException("服务不可用");
        }
        return addressService.findByUserId(userId);
    }
    @GetMapping("/user/default/{userId}")
    public Address findDefaultByUserId(@PathVariable long userId){
        return addressService.findDefaultByUserId(userId);
    }

    @PostMapping
    public void save(Address address){
        addressService.save(address);
    }

    @PutMapping
    public void update(Address address){
        addressService.update(address);
    }


    public List<Address> findByIdFallback(long userId){
        Address address = new Address();
        address.setAddress("短路回退测试");
        return Arrays.asList(address);
    }
}
