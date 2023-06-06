package com.sp.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.repository.PlayerRepository;
import com.sp.repository.AccountRepository;
import com.sp.model.Player;
import com.sp.model.Account;

@Service
public class AccountService {
    @Autowired
	AccountRepository aRepository;
    @Autowired
	PlayerService pService;

	public boolean addAccount(Account a) {
		if(aRepository.findByUsername(a.getUserName()).isEmpty()){
			aRepository.save(a);
			
			if(!aRepository.findById(a.getId()).isEmpty())
				return true;
		}
		return false;
	}
	
	public Account getAccount(Integer id) {
		Optional<Account> cOpt = aRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}

	public Account getAccount(String username) {
		Account account = aRepository.findByUsername(username).get(0);
		return account;
	}

	public boolean update(Account a){
		Account cOpt = aRepository.findByUsername(a.getUserName()).get(0);
		if(cOpt != null){
			if(a.LogIn(cOpt))
			{
				for (Integer p : a.getPlayers()) {
					Player pl = pService.getPlayer(p);
					if(pl == null)
						return false;
				}
				aRepository.save(a);
				return true;
			}
		}
		return false;
	}

	public Iterable<Account> getAccounts(Iterable<Integer> ids) {
		Iterable<Account> cOpt = aRepository.findAllById(ids);
		if (cOpt != null) {
			return cOpt;
		}else {
			return null;
		}
	}
    
	public Iterable<Account> getAccounts() {
		Iterable<Account> cOpt = aRepository.findAll();
		if (cOpt != null) {
			return cOpt;
		}else {
			return null;
		}
	}

	public List<Integer> getAccountPlayers(Integer ida) {
		Account a = getAccount(ida);
		return a.getPlayers();
	}

	public boolean logIn(String username, String password ){
		List<Account> la = aRepository.findByUsername(username);
		Account account = la.get(0);
		return account.LogIn(password);
	}
}