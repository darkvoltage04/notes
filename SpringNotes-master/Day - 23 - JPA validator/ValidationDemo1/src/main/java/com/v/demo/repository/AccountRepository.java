package com.v.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import com.v.demo.entity.Account;

/*
 * Repository
 * |
 * CrudRepository
 * |
 * PaggingAndSorting
 * |
 * JpaRepostiory
 * 
 * 
 * 
 * 
 */
public interface AccountRepository  extends CrudRepository<Account, Long>{

	@Query("select a from Account a")
	public List<Account> getAll();
	
	
}
