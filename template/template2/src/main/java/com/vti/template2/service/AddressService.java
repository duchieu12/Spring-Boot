package com.vti.template2.service;

import com.vti.template2.entity.Address;
import com.vti.template2.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Page<Address> getAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable);
    }
}
