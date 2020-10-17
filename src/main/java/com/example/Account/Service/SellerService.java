package com.example.Account.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Account.DAO.AccountDAO;
import com.example.Account.DAO.SellerDAO;
import com.example.Account.Entity.Seller;
import com.example.Account.Model.Pagination;

@Service
public class SellerService {
	
	@Autowired
	private SellerDAO sellerDAO;
	@Autowired
	private AccountDAO accountDAO;
	
	@SuppressWarnings("unchecked")
	public List<Seller> getAll() {
		return (List<Seller>) sellerDAO.getAll();
	}
	
	public Seller getById(Integer id) {
		return sellerDAO.getById(id);
	}
	
	public Pagination getPagination(int page , int limit) {
		Pagination pagination = new Pagination();
		pagination.setData(sellerDAO.getPagination(page, limit));
		pagination.setCount(sellerDAO.getCount());
		return pagination;
	}
	
	@Transactional
	public Seller add(Seller seller) {
		seller.setId(null);
		seller.getAccount().setId(null);
		seller.getAccount().setCreatedAt(new Timestamp(System.currentTimeMillis()));
		seller.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		accountDAO.add(seller.getAccount());
		return sellerDAO.add(seller);
	}

}
