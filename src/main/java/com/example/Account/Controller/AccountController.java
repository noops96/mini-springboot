package com.example.Account.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Account.Entity.Account;
import com.example.Account.Entity.Buyer;
import com.example.Account.Entity.Seller;
import com.example.Account.Model.Pagination;
import com.example.Account.Service.AccountService;
import com.example.Account.Service.BuyerService;
import com.example.Account.Service.SellerService;

@RequestMapping({ "account" })
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private BuyerService buyerService;

	@Autowired
	private SellerService sellerService;
	
	@GetMapping(value = "/get-list")
	public ResponseEntity<?> getAll() {
		List<Account> account = accountService.getAll();
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value = "/get-by-id",params = {"id"})
	public ResponseEntity<?> getById(int id) {
		Account account = accountService.getById(id);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value = "/get-pagination", params = {"page", "limit"})
	public ResponseEntity<?> getPagination(int page,int limit) {
		Pagination account = accountService.getPagination(page, limit);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value = "/get-pagination-buyer", params = {"page", "limit"})
	public ResponseEntity<?> getPaginationBuyer(int page,int limit) {
		Pagination account = buyerService.getPagination(page, limit);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value = "/get-pagination-seller", params = {"page", "limit"})
	public ResponseEntity<?> getPaginationSeller(int page,int limit) {
		Pagination account = sellerService.getPagination(page, limit);
		return ResponseEntity.ok(account);
	}
	
	@PostMapping(value = "/register-seller")
	public ResponseEntity<?> RegSel(@RequestBody Seller seller) {
		return ResponseEntity.ok(sellerService.add(seller));
	}
	
	@PostMapping(value = "/register-buyer")
	public ResponseEntity<?> regBuy(@RequestBody Buyer buyer) {
		return ResponseEntity.ok(buyerService.add(buyer));
	}
}