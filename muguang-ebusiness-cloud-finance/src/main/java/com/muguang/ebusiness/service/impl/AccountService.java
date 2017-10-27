package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Account;
import com.muguang.ebusiness.repository.impl.AccountRepository;
import com.muguang.ebusiness.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author muguang
 * @date 2017/3/7 14:10.
 */
@Service
public class AccountService implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void updateBalance(long userId, int amount) {
        Account account = accountRepository.findByUserId(userId);
        account.setBalance(account.getBalance()+amount);
        accountRepository.updateBalance(account);
    }
}
