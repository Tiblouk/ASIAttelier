package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
	@GeneratedValue
    private Integer id;
    
    private Integer number;
    private String color;
    private double price;

    public Card(){

    }
    
    public Card(Integer id, Integer number, String color, double price) {
        super();
        this.id = id;
        this.number = number;
        this.color = color;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
        return String.format("Card [%d]: color: %s, number: %d, price: %.2f", this.id, this.color, this.number, this.price);
	}
}
