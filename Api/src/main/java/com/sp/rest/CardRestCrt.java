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
@Api(tags = "Card")
public class CardRestCrt {
    @Autowired
	CardService cService;
	
	@RequestMapping(method=RequestMethod.POST,value="/card")
	@ApiOperation(value = "Endpoint Summary", notes = "Endpoint Description")
	public void addCard(@RequestBody Card card) {
		cService.addCard(card);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/card/{id}")
	public Card getCard(@PathVariable String id) {
		Card c = cService.getCard(Integer.valueOf(id));
		return c;
	}

	@RequestMapping(method=RequestMethod.GET,value="/cards")
	public Iterable<Card> getCards() {
		return cService.getCards();
	}
}
