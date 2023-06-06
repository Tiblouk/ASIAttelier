package com.sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sp.model.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

	public List<Card> findByColor(String color);

}
