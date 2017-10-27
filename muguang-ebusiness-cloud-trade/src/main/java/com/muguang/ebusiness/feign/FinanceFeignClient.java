package com.muguang.ebusiness.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author muguang
 * @date 2017/3/8 14:37.
 */
@FeignClient(name="yokimi-ebusiness-cloud-finance")
public interface FinanceFeignClient {

    @RequestMapping(path = "/account/balance", method = RequestMethod.POST)
    void updateBalance(@RequestParam("userId") long userId, @RequestParam("amount") int amount);
}
