package com.sp.rest;

import io.swagger.annotations.ApiOperation;

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

@RestController
public class PlayerRestCrt {
    @Autowired
	PlayerService pService;

    @RequestMapping(method=RequestMethod.POST,value="/players/add")
    @ApiOperation(value = "Use to create a new player", notes = "Use to create a new player")
	public void addPlayer(@RequestBody Player player) {
		pService.addplayer(player);
	}
    @GetMapping("/players/addcard/{idp}/{idc}")
    @ApiOperation(value = "Use to add a card to a player", notes = "Use to add a card to a player | idp is the id of the player and idc is the id of the card")
    public boolean addCardPlayer(@PathVariable int idp, @PathVariable int idc) {
        return pService.addCardPlayer(idp, idc);
    }
    @GetMapping("/players/rmcard/{idp}/{idc}")
    @ApiOperation(value = "Use to remove a card to a player", notes = "Use to remove a card to a player | idp is the id of the player and idc is the id of the card")
    public boolean rmCardPlayer(@PathVariable int idp, @PathVariable int idc) {
        return pService.rmCardPlayer(idp, idc);
    }

    @RequestMapping(method=RequestMethod.POST,value="/players/card")
    @ApiOperation(value = "Use to get all the card of a player", notes = "Use to get all the card of a player | only the id is required")
	public List<Integer> getPlayerCards(@RequestBody Player player) {
		return pService.getPlayer(player.getId()).getCards();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/players/{id}")
    @ApiOperation(value = "get a player by its ID", notes = "get a player by its ID")
	public Player getPlayerById(@PathVariable String id) {
		Player p = pService.getPlayer(Integer.valueOf(id));
		return p;
	}

	@RequestMapping(method=RequestMethod.GET,value="/players/{name}")
    @ApiOperation(value = "get a player by its ID", notes = "get a player by its ID")
	public Player getPlayerByName(@PathVariable String name) {
		Player p = pService.getPlayer(name);
		return p;
	}

	@RequestMapping(method=RequestMethod.GET,value="/players")
    @ApiOperation(value = "get all players", notes = "get all players")
	public Iterable<Player> getPlayers() {
		return pService.getPlayers();
	}
}
