package com.muguang.ebusiness.service;

import com.muguang.ebusiness.entity.Address;

import java.util.List;

/**
 * @author muguang
 * @date 2017-3-8 0:19
 */
public interface IAddressService {
    List<Address> findByUserId(long userId);
    Address save(Address address);
    void update(Address address);
    Address findDefaultByUserId(long userId);
}
