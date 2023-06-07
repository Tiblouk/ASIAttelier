package com.sp.service;

import com.sp.model.Card;

public interface CardService {
    void addCard(Card card);
    void addCards(Iterable<Card> cards);
    Card getCard(int id);
    Iterable<Card> getCards();
}