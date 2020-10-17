package com.example.Account.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Account.Entity.Account;
@Transactional 
@Repository
public class AccountDAO extends BaseDAO<Account> {
	
	@PersistenceContext
	private EntityManager manager;
	 
	public AccountDAO(){
		setClazz(Account.class,"account");
	}

}
