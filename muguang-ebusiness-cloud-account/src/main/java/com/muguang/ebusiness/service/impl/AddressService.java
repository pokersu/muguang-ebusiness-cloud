package com.muguang.ebusiness.service.impl;

import com.muguang.ebusiness.EbusinessCloudAccountApplication;
import com.muguang.ebusiness.entity.Address;
import com.muguang.ebusiness.repository.impl.AddressRepository;
import com.muguang.ebusiness.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author muguang
 * @date 2017-3-8 0:19
 */
@Service
public class AddressService implements IAddressService{

    private static final Logger LOG = Logger.getLogger(EbusinessCloudAccountApplication.class.getName());
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findByUserId(long userId) {
        LOG.log(Level.INFO, "根据用户id获取用户地址列表");
        return addressRepository.findByUserId(userId);
    }

    @Override
    public Address save(Address address) {
        if (address.getIsdefault()==1){
            updateUserAddressNotDefault(address.getUserId());
        }
        return addressRepository.save(address);
    }

    @Override
    public void update(Address address) {
        if (address.getIsdefault()==1){
            updateUserAddressNotDefault(address.getUserId());
        }
        addressRepository.update(address);
    }

    @Override
    public Address findDefaultByUserId(long userId) {
        return addressRepository.findDefaultByUserId(userId);
    }


    private void updateUserAddressNotDefault(long userId){
        List<Address> addresses = addressRepository.findByUserId(userId);
        for (Address add : addresses) {
            add.setIsdefault(0);
            addressRepository.update(add);
        }
    }
}
