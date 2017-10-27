package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.Account;
import com.muguang.ebusiness.entity.User;
import com.muguang.ebusiness.entity.UserInfo;
import com.muguang.ebusiness.feign.AccountFeignClient;
import com.muguang.ebusiness.repository.IUserInfoRepository;
import com.muguang.ebusiness.repository.IUserRepository;
import com.muguang.ebusiness.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author muguang
 * @date 2017/3/6 11:38.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IUserInfoRepository userInfoRepository;
    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> match(String name, String password) {
        List<User> userlist = userRepository.findByName(name);
        Iterator<User> iterator = userlist.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (!user.validatePassword(password)) iterator.remove();
        }
        return userlist;
    }

    @Override
    public User register(User user, UserInfo userInfo) {
        user.calcPassword();
        user.setCreateAt(new Date());
        user = userRepository.save(user);
        userInfo.setUserId(user.getId());
        userInfoRepository.save(userInfo);

        //注册资金账号
        Account account = new Account();
        account.setUserId(user.getId());
        account.setType(1);//普通账户
        account.setPassword(user.getPassword());
        account.setSalt(user.getSalt());
        account.setBalance(10000);
        accountFeignClient.save(account);
        return user;
    }

}
