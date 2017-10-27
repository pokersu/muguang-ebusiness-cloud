package com.muguang.ebusiness.feign.fallback;

import com.muguang.ebusiness.entity.Account;
import com.muguang.ebusiness.feign.AccountFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author muguang
 * @date 2017/3/10 9:56.
 */
@Component
public class AccountFeignFallBack implements AccountFeignClient{
    @Override
    public Account save(Account account) {
        return new Account();
    }
}
