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
	PlayerRepository pRepository;
	
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
		return true;
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

    public boolean addPlayerAccount(int a, int p){
        Optional<Account> cOpt = aRepository.findById(a);
		if (cOpt.isPresent()) {
            Optional<Player> po = pRepository.findById(p);
            if (po.isPresent()) {
                Account acc = cOpt.get();
                acc.addPlayer(p);
                aRepository.save(acc);
                return true;
            }
        }
		return false;
    }
    public boolean rmPlayerAccount(int a, int p){
        Optional<Account> cOpt = aRepository.findById(a);
		if (cOpt.isPresent()) {
            Optional<Player> po = pRepository.findById(p);
            if (po.isPresent()) {
                Account acc = cOpt.get();
                if(acc.getPlayers().contains(p))
                {
                    acc.removePlayer(p);
                    aRepository.save(acc);
                    return true;
                }
            }
        }
		return false;
    }

	public boolean logIn(String username, String password ){
		Account account = aRepository.findByUsername(username).get(0);
		return account.LogIn(password);
	}
}
