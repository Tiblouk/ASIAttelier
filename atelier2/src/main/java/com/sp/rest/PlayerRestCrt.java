package com.sp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Player;
import com.sp.service.PlayerService;
import com.sp.service.CardService;
import com.sp.model.Card;

@RestController
public class PlayerRestCrt {
    @Autowired
	PlayerService pService;

    @RequestMapping(method=RequestMethod.POST,value="/players/add")
	public void addPlayer(@RequestBody Player player) {
		pService.addplayer(player);
	}
    @GetMapping("/players/addcard/{idp}/{idc}")
    public boolean addCardPlayer(@PathVariable int idp, @PathVariable int idc) {
        return pService.addCardPlayer(idp, idc);
    }
    @GetMapping("/players/rmcard/{idp}/{idc}")
    public boolean rmCardPlayer(@PathVariable int idp, @PathVariable int idc) {
        return pService.rmCardPlayer(idp, idc);
    }

    @RequestMapping(method=RequestMethod.POST,value="/players/card")
	public List<Integer> getPlayerCards(@RequestBody Player player) {
		return pService.getPlayer(player.getId()).getCards();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/players/{id}")
	public Player getPlayer(@PathVariable String id) {
		Player p = pService.getPlayer(Integer.valueOf(id));
		return p;
	}

	@RequestMapping(method=RequestMethod.GET,value="/players")
	public Iterable<Player> getPlayers() {
		return pService.getPlayers();
	}
}
