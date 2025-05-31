package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> get(){
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer get(@PathVariable Long id){
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse post(@RequestBody Customer customer){
         customerService.save(customer);
         return new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary());
    }

    @DeleteMapping("{id}")
    public Customer delete(@PathVariable Long id){
        return customerService.delete(id);
    }
}
