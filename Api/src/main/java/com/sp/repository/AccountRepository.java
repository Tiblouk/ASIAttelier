package com.sp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sp.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	public List<Account> findByUserName(String user);

}
