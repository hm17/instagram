package com.hm17.instagram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm17.instagram.entity.Account;
import com.hm17.instagram.repository.AccountRepository;

@Controller
@RequestMapping(path="/instagram/accounts")
public class MainController {

	@Autowired
	private AccountRepository accountRepository;
	
	@PostMapping(path="/add")
	public @ResponseBody String addAccount(@RequestParam String username,
			@RequestParam String address) {
		Account a = new Account(username, address);
		accountRepository.save(a);
		return "Saved new account with username: " + username + " and address: " + address;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Account> getAllUsers() {
		return accountRepository.findAll();
	}
}
