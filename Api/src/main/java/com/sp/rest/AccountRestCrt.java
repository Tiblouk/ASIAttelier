package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Account;
import com.sp.service.AccountService;


@RestController
public class AccountRestCrt {
    
    @Autowired
    AccountService aService;

    @RequestMapping(method=RequestMethod.POST, value="/account")
    public void addAccount(@RequestBody Account account) {
        aService.addAccount(account);
    }
    
	@RequestMapping(method=RequestMethod.POST, value="/account/login")
    public  boolean handleSubmit(@RequestParam("name") String name,
								@RequestParam("pass") String pass) {
        return aService.logIn(name, pass);
    }

    @GetMapping("/account/addplayer/{ida}/{idp}")
    public boolean addPlayerAccount(@PathVariable int ida, @PathVariable int idp) {
        return aService.addPlayerAccount(ida, idp);
    }
    
    @GetMapping("/account/rmplayer/{ida}/{idp}")
    public boolean rmCardPlayer(@PathVariable int ida, @PathVariable int idp) {
        return aService.rmPlayerAccount(ida, idp);
    }

    @RequestMapping(method=RequestMethod.GET, value="/account/player/{ida}")
    public List<Integer> getAccountPlayers(@PathVariable Integer ida ) {
        return aService.getAccountPlayers(ida);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/account/{id}")
    public Account getAccount(@PathVariable String id) {
        Account a = aService.getAccount(Integer.valueOf(id));
        return a;
    }

    @RequestMapping(method=RequestMethod.GET, value="/accounts")
    public Iterable<Account> getAccounts() {
        return aService.getAccounts();
    }
}
