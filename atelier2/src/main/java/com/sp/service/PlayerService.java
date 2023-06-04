package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.repository.PlayerRepository;
import com.sp.repository.CardRepository;
import com.sp.model.Player;
import com.sp.model.Card;

@Service
public class PlayerService {
    @Autowired
	PlayerRepository pRepository;

	@Autowired
	CardRepository cRepository;

	public void addplayer(Player p) {
		Player createdplayer = pRepository.save(p);
		System.out.println(createdplayer);
	}
	
	public Player getPlayer(int id) {
		Optional<Player> cOpt = pRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	public Iterable<Player> getPlayers(Iterable<Integer> ids) {
		Iterable<Player> cOpt = pRepository.findAllById(ids);
		if (cOpt != null) {
			return cOpt;
		}else {
			return null;
		}
	}
    
	public Iterable<Player> getPlayers() {
		Iterable<Player> cOpt = pRepository.findAll();
		if (cOpt != null) {
			return cOpt;
		}else {
			return null;
		}
	}

    public boolean addCardPlayer(int p,int c){
        Optional<Player> cOpt = pRepository.findById(p);
		if (cOpt.isPresent()) {
            Optional<Card> co = cRepository.findById(c);
            if (co.isPresent()) {
                Player pl = cOpt.get();
                pl.addCard(c);
                pRepository.save(pl);
                return true;
            }
        }
		return false;
    }
	
    public boolean rmCardPlayer(int p,int c){
        Optional<Player> cOpt = pRepository.findById(p);
		if (cOpt.isPresent()) {
            Optional<Card> co = cRepository.findById(c);
            if (co.isPresent()) {
                Player pl = cOpt.get();
                if(pl.getCards().contains(c)){
                    pl.removeCard(c);
                    pRepository.save(pl);
                    return true;
                }
            }
        }
		return false;
    }
}
