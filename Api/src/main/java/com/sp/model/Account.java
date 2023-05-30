package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;
    private String password;

    @ElementCollection
    private List<Integer> players = new ArrayList<>();


    public Account(){
        
    }

    public Account(String u, String p){
        super();
        this.username = u;
        this.password = p;
    }

    public boolean LogIn(String p){
        if(p == this.password)
            return true;
        return false;
    }

    public boolean ChangePassWord(String op, String np){
        if(op.equals(password)){
            this.password = np;
            return true;
        }
        return false;
    }

    public List<Integer> getPlayers(){
        return this.players;
    }

    public void setPlayers(List<Integer> players){
        this.players = players;
    }

    public void removePlayer(Integer id) {
        this.players.remove(id);
    }

    public void addPlayer(int p){
        this.players.add(p);
    }

    public String getUserName() {
        return this.username;
    }

    public void setUserName(String u) {
        this.username = u;
    }
    
	@Override
	public String toString() {
		return String.format("Account [%d]: Username: %s, Players: %s", this.id, this.username, this.players);
	}
}
