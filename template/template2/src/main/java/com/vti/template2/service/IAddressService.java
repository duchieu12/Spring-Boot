package com.vti.template2.service;

import com.vti.template2.entity.Address;

import java.util.List;

public interface IAddressService {

    List<Address> getAllAddress();

    Address getAddressById(int id);
}
