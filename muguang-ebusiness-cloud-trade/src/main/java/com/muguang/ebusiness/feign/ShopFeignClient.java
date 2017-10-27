package com.muguang.ebusiness.feign;

import com.muguang.ebusiness.entity.Shop;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author muguang
 * @date 2017/3/9 11:11.
 */
@FeignClient(name = "yokimi-ebusiness-cloud-shop")
public interface ShopFeignClient {

    @RequestMapping(path = "/shop/{id}", method = RequestMethod.GET)
    Shop findById(@PathVariable("id") long id);
}
