package com.example.Account.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Account.DAO.AccountDAO;
import com.example.Account.DAO.BuyerDAO;
import com.example.Account.Entity.Account;
import com.example.Account.Entity.Buyer;
import com.example.Account.Model.Pagination;

@Service
public class BuyerService {
	
	@Autowired
	private BuyerDAO buyerDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	@SuppressWarnings("unchecked")
	public List<Buyer> getAll() {
		return (List<Buyer>) buyerDAO.getAll();
	}
	
	public Boolean isBuyerExist(Integer id) {
		return buyerDAO.getById(id) == null ? false:true;
	}
	
	public Pagination getPagination(int page , int limit) {
		Pagination pagination = new Pagination();
		pagination.setData(buyerDAO.getPagination(page, limit));
		pagination.setCount(buyerDAO.getCount());
		return pagination;
	}
	
	public Buyer getById(Integer id) {
		return buyerDAO.getById(id);
	}
	
	@Transactional
	public Buyer add(Buyer buyer) {
		buyer.setId(null);
		buyer.getAccount().setId(null);
		buyer.getAccount().setIsActive(true);
		buyer.getAccount().setCreatedAt(new Timestamp(System.currentTimeMillis()));
		buyer.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		accountDAO.add(buyer.getAccount());
		return buyerDAO.add(buyer);
	}

}
