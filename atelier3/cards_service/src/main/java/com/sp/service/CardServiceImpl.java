package com.sp.service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void addCard(Card card) {
        Card createdCard = cardRepository.save(card);
        System.out.println(createdCard);
    }

    @Override
    public void addCards(Iterable<Card> cards) {
        for (Card card : cards) {
            this.addCard(card);
        }
    }

    @Override
    public Card getCard(int id) {
        Optional<Card> cardOpt = cardRepository.findById(id);
        return cardOpt.orElse(null);
    }

    @Override
    public Iterable<Card> getCards() {
        return cardRepository.findAll();
    }
}