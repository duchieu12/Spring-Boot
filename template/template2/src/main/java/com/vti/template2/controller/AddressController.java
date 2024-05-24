package com.vti.template2.controller;

import com.vti.template2.dto.AddressDTO;
import com.vti.template2.entity.Address;
import com.vti.template2.service.IAddressService;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<AddressDTO> getAllAddress() {
        List<Address> address = addressService.getAllAddress();
        return modelMapper.map(address, new TypeToken<List<AddressDTO>>(){}.getType());
    }

    @GetMapping("/{id}")
    public AddressDTO getAddressById(@PathVariable(name = "id") int id) {
        Address address = addressService.getAddressById(id);
        return modelMapper.map(address, AddressDTO.class);
    }
}
