package uam.distributed_java.vetulbank.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import akka.actor.ActorRef;
import uam.distributed_java.vetulbank.main.Starter;
import uam.distributed_java.vetulbank.main.actors.messages.AccountsTransactionsMessage;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
import uam.distributed_java.vetulbank.main.repositories.AccountRepository;
import uam.distributed_java.vetulbank.main.repositories.TransactionRepository;
import uam.distributed_java.vetulbank.main.tools.IDGenerator;

/**
 * 
 * API:
 * 
 * \ GET accounts/{id} - pobranie Account'a o podanym id
 * \ GET accounts/{id}/transactions - pobranie transakcji Account'a o podanym id
 * \ DELETE accounts/{id} - usuniecie Account'a o podanym id
 * \ PUT accounts/create - stworzenie i pobranie Account'a
 * \ PUT accounts/create/password/{pass} - stworzenie i pobranie Account'a z konkretnym passem
 * \ GET accounts/{id}/password/{pass} - zwroci Boolean'a czy Account id ma haslo pass
 * \ PUT accounts/{id}/password/{pass} - zmiena haslo Account'a z podanym id na nowe rowne pass
 * 
 * @author s383930
 *
 */

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable String id) {
		return accountRepository.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/transactions", method = RequestMethod.GET)
	public List<Transaction> getAccountsTransactionsById(@PathVariable String id) throws InterruptedException {
		ActorRef actorManager = Starter.getActorManager();
		AccountsTransactionsMessage message = new AccountsTransactionsMessage(transactionRepository.findAll(), id);
		actorManager.tell(message, ActorRef.noSender());
		Thread.sleep(300);
		return message.getResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/password/{pass}", method = RequestMethod.GET)
	public Boolean checkPasswordOfAccountsById(@PathVariable String id, @PathVariable String pass){
		return accountRepository.findOne(id).getId().equals(pass);
	}
	
	@JsonView(Account.MinimalView.class)
	@RequestMapping(value = "create", method = RequestMethod.PUT)
	public Account createAccount() throws InterruptedException {
		String id = IDGenerator.generateID();
		while(accountRepository.exists(id))
			id = IDGenerator.generateID();
		return accountRepository.save(new Account(id, 1000, ""));
	}
	
	@RequestMapping(value = "create/password/{pass}", method = RequestMethod.PUT)
	public Account createAccountWithPassword(@PathVariable String pass) throws InterruptedException {
		String id = IDGenerator.generateID();
		while(accountRepository.exists(id))
			id = IDGenerator.generateID();
		return accountRepository.save(new Account(id, 1000, pass));
	}
	
	@RequestMapping(value = "/{id}/password/{pass}", method = RequestMethod.PUT)
	public void setPassword(@PathVariable String id, @PathVariable String pass) {
		accountRepository.findOne(id).setPassword(pass);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAccountById(@PathVariable String id) {
		accountRepository.delete(id);
	}
	
}
