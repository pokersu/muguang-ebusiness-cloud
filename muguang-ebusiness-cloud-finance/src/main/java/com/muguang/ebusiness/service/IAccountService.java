package com.muguang.ebusiness.service;

import com.muguang.ebusiness.entity.Account;

/**
 * @author muguang
 * @date 2017/3/7 14:10.
 */
public interface IAccountService {

    Account findByUserId(Long userId);

    Account save(Account account);

    void updateBalance(long userId, int amount);

}
