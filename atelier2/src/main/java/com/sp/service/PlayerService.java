package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.repository.PlayerRepository;
import com.sp.model.Player;
import com.sp.model.Card;

@Service
public class PlayerService {
    @Autowired
	PlayerRepository pRepository;

	@Autowired
	CardService cService;

	public void addplayer(Player p) {
		if(pRepository.findByName(p.getName()).isEmpty()){
			Player createdplayer = pRepository.save(p);
			System.out.println(createdplayer);
		}
	}
	
	public Player getPlayer(int id) {
		Optional<Player> cOpt = pRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		} else {
			return null;
		}
	}

	public Player getPlayer(String name) {
		if (!pRepository.findByName(name).isEmpty()) {
			return pRepository.findByName(name).get(0);
		} else {
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
			if(isCardTakenByAnotherPlayer(c))
				return false;
            Card co = cService.getCard(c);
            if (co != null) {
                Player pl = cOpt.get();
				if(co.getPrice() > pl.getbalance())
					return false;

				pl.rmmoney(co.getPrice());
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
            Card co = cService.getCard(c);
            if (co != null) {
                Player pl = cOpt.get();
                if(pl.getCards().contains(c)){
                    pl.removeCard(c);
					pl.addmoney(co.getPrice());
                    pRepository.save(pl);
                    return true;
                }
            }
        }
		return false;
    }

	public boolean isCardTakenByAnotherPlayer(int cardId) {
		Iterable<Player> players = pRepository.findAll();
		for (Player player : players) {
			if (player.hasCard(cardId)) {
				return true;
			}
		}
        return false;
    }
}
