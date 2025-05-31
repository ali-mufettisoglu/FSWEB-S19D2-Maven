package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> get(){
        return addressService.findAll();
    }

    @GetMapping("{id}")
    public Address get(@PathVariable Long id){
        return addressService.find(id);
    }

    @PostMapping
    public Address post(@RequestBody Address address){
        return addressService.save(address);
    }

    @DeleteMapping("{id}")
    public Address delete(@PathVariable Long id){
        return addressService.delete(id);
    }
}
