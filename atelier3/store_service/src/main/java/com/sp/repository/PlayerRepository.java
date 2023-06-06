package com.sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sp.model.Player;

@Repository
public interface PlayerRepository  extends CrudRepository<Player, Integer> {

    public List<Player> findByName(String name);
    
}
