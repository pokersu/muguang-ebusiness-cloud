package com.muguang.ebusiness.feign;

import com.muguang.ebusiness.entity.Commodity;
import com.muguang.ebusiness.entity.Goods;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author muguang
 * @date 2017/3/8 11:16.
 */
@FeignClient(name = "yokimi-ebusiness-cloud-goods")
public interface GoodsFeignClient {

    @RequestMapping(value = "/commodity", method = RequestMethod.POST)
    Commodity createCommodity(@RequestBody Commodity commodity);
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    Goods createGoods(@RequestBody Goods goods);
}