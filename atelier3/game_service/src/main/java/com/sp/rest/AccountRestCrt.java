package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Account;
import com.sp.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/")
@Api(tags = "Accounts")
public class AccountRestCrt {
    
    @Autowired
    AccountService aService;

    @RequestMapping(method=RequestMethod.POST, value="/accounts/add")
    @ApiOperation(value = "Add an Account", notes = "Add the account that is content in Json to the repository")
    public boolean addAccount(@RequestParam("user") String user,
                              @RequestParam("pass") String pass)
    {
        return aService.addAccount(new Account(user, pass));
    }
    
	@RequestMapping(method=RequestMethod.POST, value="/accounts/login")
    @ApiOperation(value = "Verify if account exist", notes = "Verify if account exist in the repository")
    public boolean logIn(@RequestParam("user") String user,
						  @RequestParam("pass") String pass) 
    {
        return aService.logIn(user, pass);
    }

    @PutMapping("/accounts/update")
    @ApiOperation(value = "Update the account", notes = "Update the account if password match repository password")
    public boolean update(@RequestBody Account account) {
        return aService.update(account);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/accounts/{username}")
    @ApiOperation(value = "Get the account by username", notes = "Get the account by username")
    public Account getAccountById(@PathVariable String username) {
        Account a = aService.getAccount(username);
        return a;
    }

    @RequestMapping(method=RequestMethod.GET, value="/accounts/{id}")
    @ApiOperation(value = "Get the account by id", notes = "Get the account by id")
    public Account getAccountByUser(@PathVariable String id) {
        Account a = aService.getAccount(Integer.valueOf(id));
        return a;
    }

    @RequestMapping(method=RequestMethod.GET, value="/accounts")
    @ApiOperation(value = "Get all account in the db", notes = "Return all account contain in the db")
    public Iterable<Account> getAccounts() {
        return aService.getAccounts();
    }
}
