package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.entity.UserType;
import com.muguang.ebusiness.repository.impl.UserTypeRepository;
import com.muguang.ebusiness.service.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/6 11:38.
 */
@Service
public class UserTypeService implements IUserTypeService{


    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }
}
