package com.sp.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Entity;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private double currency = 10000;

    @ElementCollection
    private List<Integer> cards = new ArrayList<>();;

    public Player() {
    }

    public Player(Integer id, String name, List<Integer> cards) {
        super();
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public boolean hasCard(Integer id) {
        return cards.contains(id);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void addCard(Integer id) {
        cards.add(id);
    }

    public void removeCard(Integer id) {
        cards.remove(id);
    }

    public void addmoney(double m){
        currency += m;
    }

    public void rmmoney(double m){
        currency -= m;
    }

    public double getbalance(){
        return currency;
    }

    @Override
    public String toString() {
        return String.format("Player [%d]: cards: %s, name: %s", this.id, this.cards, this.name);
    }
}
