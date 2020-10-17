package com.example.Account.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Account.DAO.AccountDAO;
import com.example.Account.Entity.Account;
import com.example.Account.Model.Pagination;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@SuppressWarnings("unchecked")
	public List<Account> getAll() {
		return (List<Account>) accountDAO.getAll();
	}
	
	public Account getById(Integer id) {
		return accountDAO.getById(id);
	}
	
	public Pagination getPagination(int page , int limit) {
		Pagination pagination = new Pagination();
		pagination.setData(accountDAO.getPagination(page, limit));
		pagination.setCount(accountDAO.getCount());
		return pagination;
	}
	
	public Account add(Account account) {
		return accountDAO.add(account);
	}

}
