package com.hm17.instagram.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public void addUser(String username, String address) throws Exception{
		// Data validation
		if(username.equals("") || address.equals(""))
			throw new Exception("Username or Address cannot be empty.");
		
		// TODO: check if username or address already exists (must be unique)
		
		Account a = new Account(username, address);
		accountRepository.save(a);
	}

	public Iterable<Account> getAccounts() {
		return accountRepository.findAll();
	}

}
