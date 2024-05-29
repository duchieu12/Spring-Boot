package com.vti.template2.service;

import com.vti.template2.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAddressService {

    List<Address> getAllAddress();

    Address getAddressById(int id);

    Page<Address> getAddresses(Pageable pageable);
}
