package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Account;

/**
 * @author muguang
 * @date 2017/3/7 14:06.
 */
public interface IAccountRepository {

    Account findByUserId(Long userId);

    Account save(Account account);

    void updateBalance(Account account);
}
