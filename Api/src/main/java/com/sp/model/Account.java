package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.List;
import javax.persistence.ElementCollection;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;

    private String userName;
    private String passWord;

    @ElementCollection
    private List<Integer> Players;


    public Account(){
        
    }

    public Account(String u, String p){
        super();
        this.userName = u;
        this.passWord = p;
    }

    public boolean LogIn(String p){
        if(p == this.passWord)
            return true;
        return false;
    }

    public boolean ChangePassWord(String op, String np){
        if(op == this.passWord){
            this.passWord = np;
            return true;
        }
        return false;
    }

    public List<Integer> getPlayers(){
        return Players;
    }

    public void removePlayer(Integer id) {
        Players.remove(id);
    }

    public void addPlayer(int p){
        Players.add(p);
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String u) {
        this.userName = u;
    }
    
	@Override
	public String toString() {
		return "Account ["+this.id+"]: Username:"+this.userName+", Playes:"+this.Players;
	}
}
