package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Account;
import com.sp.service.PlayerService;
import com.sp.service.AccountService;


@RestController
public class AccountRestCrt {
    
    @Autowired
    AccountService aService;
    @Autowired
	PlayerService pService;

    @RequestMapping(method=RequestMethod.POST,value="/account")
	public void addAccount(@RequestBody Account account) {
		aService.addAccount(account);
	}

    @GetMapping("/account/addplayer/{ida}/{idp}")
    public boolean addPlayerAccount(@PathVariable int ida, @PathVariable int idp) {
        return aService.addPlayerAccount(ida, idp);
    }
    @GetMapping("/account/rmplayer/{ida}/{idp}")
    public boolean rmCardPlayer(@PathVariable int ida, @PathVariable int idp) {
        return aService.rmPlayerAccount(ida, idp);
    }

    @RequestMapping(method=RequestMethod.POST,value="/account/player")
	public void getAccountPlayers(@RequestBody Account account) {
		pService.getPlayers(account.getPlayers());
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/account/{id}")
	public Account getAccount(@PathVariable String id) {
		Account a = aService.getAccount(Integer.valueOf(id));
		return a;
	}

	@RequestMapping(method=RequestMethod.GET,value="/accounts")
	public Iterable<Account> getAccounts() {
		return aService.getAccounts();
	}
}
