package com.sp.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.service.CardService;

@RestController
@RequestMapping("/")
@Api(tags = "Cards")
public class CardRestCrt {
    @Autowired
	CardService cService;
	
	@RequestMapping(method=RequestMethod.POST,value="/cards/add")
	@ApiOperation(value = "Add a card", notes = "Add the card that is content in Json to the repository")
	public void addCard(@RequestBody Card card) {
		cService.addCard(card);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/cards/{id}")
	@ApiOperation(value = "Get by ID", notes = "Get a card by its ID")
	public Card getCard(@PathVariable String id) {
		Card c = cService.getCard(Integer.valueOf(id));
		return c;
	}

	@RequestMapping(method=RequestMethod.GET,value="/cards")
	@ApiOperation(value = "Get cards", notes = "Get all cards that are present in the repository")
	public Iterable<Card> getCards() {
		return cService.getCards();
	}
}
