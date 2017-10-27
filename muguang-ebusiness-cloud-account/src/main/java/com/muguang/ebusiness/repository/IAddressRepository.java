package com.muguang.ebusiness.repository;

import com.muguang.ebusiness.entity.Address;

import java.util.List;

/**
 * @author muguang
 * @date 2017/3/7 18:09.
 */
public interface IAddressRepository {
    List<Address> findByUserId(long userId);
    Address save(Address address);
    void update(Address address);
    Address findDefaultByUserId(long userId);
}
