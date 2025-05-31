package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    AccountService accountService;
    CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService,CustomerService customerService){
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<AccountResponse> get(){
        List<Account> accounts = accountService.findAll();
        List<AccountResponse> accountResponses = new ArrayList<>();
        for(Account account:accounts){
            accountResponses.add(new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount()));
        }
        return accountResponses;
    }

    @GetMapping("{id}")
    public AccountResponse get(@PathVariable Long id){
        Account account = accountService.find(id);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());

    }

    @PostMapping("{customerId}")
    public AccountResponse save(@PathVariable Long customerId,@RequestBody Account account){
        Customer customer = customerService.find(customerId);
        customer.getAccounts().add(account);
        account.setCustomer(customer);
        accountService.save(account);

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }

    @PutMapping("{customerId}")
    public AccountResponse put(@PathVariable Long customerId,@RequestBody Account account){
        Customer customer = customerService.find(customerId);
        customer.getAccounts().add(account);
        account.setCustomer(customer);
        accountService.save(account);

        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }

    @DeleteMapping("{id}")
    public AccountResponse delete(@PathVariable Long id){
          Account account = accountService.find(id);
          accountService.delete(id);
          return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount());
    }

}
