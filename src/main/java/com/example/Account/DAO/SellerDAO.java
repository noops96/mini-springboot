package com.example.Account.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Account.Entity.Seller;

@Transactional
@Repository
public class SellerDAO extends BaseDAO<Seller> {
	
	@PersistenceContext
	private EntityManager manager;
	 
	public SellerDAO(){
		setClazz(Seller.class,"seller");
	}

}
