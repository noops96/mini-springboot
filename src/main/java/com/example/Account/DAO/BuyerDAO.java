package com.example.Account.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Account.Entity.Buyer;
@Transactional 
@Repository
public class BuyerDAO extends BaseDAO<Buyer> {
	
	@PersistenceContext
	private EntityManager manager;
	 
	public BuyerDAO(){
		setClazz(Buyer.class,"buyer");
	}

}
