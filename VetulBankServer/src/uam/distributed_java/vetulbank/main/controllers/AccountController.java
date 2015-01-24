package uam.distributed_java.vetulbank.main.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import uam.distributed_java.vetulbank.main.exceptions.AccountNotFoundException;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.repositories.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable String id) {
		Account account = accountRepository.getById(id);
		// TODO Czy tutaj aktor z Akki nie powinien szukac tego accounta?
		// logika wyszukiwania (w sumie tylko pobranie i ten if) powinna byc wyjeta z kontrolera
		if(account == null)
			throw new AccountNotFoundException();
				
		return account;
	}
	
	@JsonView(Account.MinimalView.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Account createAccount(@PathVariable String id, @Valid @RequestBody Account account) {
		// TODO actorManager zleca innym aktorom utworzenie konta i dodanie go do bazy
		return account;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAccountById(@PathVariable String id) {
		accountRepository.deleteAccountById(id);
		// TODO Czy tutaj aktor z Akki nie powinien usuwac tego accounta?
	}
	
}
