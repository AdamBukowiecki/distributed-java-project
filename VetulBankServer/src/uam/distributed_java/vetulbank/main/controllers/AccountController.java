package uam.distributed_java.vetulbank.main.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.fasterxml.jackson.annotation.JsonView;

import uam.distributed_java.vetulbank.main.Starter;
import uam.distributed_java.vetulbank.main.actors.ActorManager;
import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import uam.distributed_java.vetulbank.main.actors.messages.MessageCodes;
import uam.distributed_java.vetulbank.main.exceptions.AccountNotFoundException;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
import uam.distributed_java.vetulbank.main.repositories.AccountRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable String id) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ref.tell(new ActorMessage(MessageCodes.GET_ACCOUNT_BY_ID, id), ActorRef.noSender());
		// TODO Jak aktor ma zwrocic to konto?
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/transactions", method = RequestMethod.GET)
	public List<Transaction> getAccountsTransactionsById(@PathVariable String id) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ref.tell(new ActorMessage(MessageCodes.GET_ACCOUNTS_TRANSACTIONS, id), ActorRef.noSender());
		// TODO Jak aktor ma zwrocic te liste?
		return null;
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
