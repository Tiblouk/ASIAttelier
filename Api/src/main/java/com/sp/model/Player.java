package com.sp.model;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ElementCollection
    private List<Integer> cards;

    public Player() {
    }

    public Player(int id, String name, List<Integer> cards) {
        super();
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void addCard(int id) {
        cards.add(id);
    }

    public void removeCard(Integer id) {
        cards.remove(id);
    }

    @Override
    public String toString() {
        return "Player [" + this.id + "]: cards:[" + this.cards + "], name:" + this.name;
    }
}
