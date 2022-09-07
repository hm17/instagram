package com.hm17.instagram.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/instagram/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(path="/add")
	public @ResponseBody String addAccount(@RequestParam String username,
			@RequestParam String address) throws Exception {
		accountService.addUser(username, address);
		return "Saved new account with username: " + username + " and address: " + address;
	}
	
	@GetMapping
	public @ResponseBody Iterable<Account> getAllAccounts() {
		return accountService.getAccounts();
	}
}
