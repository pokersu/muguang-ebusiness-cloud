package com.muguang.ebusiness.feign;

import com.muguang.ebusiness.entity.Account;
import com.muguang.ebusiness.feign.fallback.AccountFeignFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author muguang
 * @date 2017/3/8 11:16.
 */
@FeignClient(name = "yokimi-ebusiness-cloud-finance", fallback = AccountFeignFallBack.class)
public interface AccountFeignClient {
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    Account save(@RequestBody Account account);
}