package uam.distributed_java.vetulbank.main.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import akka.actor.ActorRef;
import akka.actor.Props;
import uam.distributed_java.vetulbank.main.Starter;
import uam.distributed_java.vetulbank.main.actors.ActorManager;
import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import uam.distributed_java.vetulbank.main.actors.messages.ChangePasswordMessage;
import uam.distributed_java.vetulbank.main.actors.messages.messagescodes.MessageCodes;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
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

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccountById(@PathVariable String id) throws InterruptedException {
		ActorRef actorManager = Starter.getActorManager();
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.GET_ACCOUNT_BY_ID, id);
		actorManager.tell(message, ActorRef.noSender());
		Thread.sleep(100);
		return message.getResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/transactions", method = RequestMethod.GET)
	public List<Transaction> getAccountsTransactionsById(@PathVariable String id) throws InterruptedException {
		ActorRef actorManager = Starter.getActorManager();
		ActorMessage<List<Transaction>> message = new ActorMessage<>(MessageCodes.GET_ACCOUNTS_TRANSACTIONS, id);
		actorManager.tell(message, ActorRef.noSender());
		Thread.sleep(200);
		return message.getResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/password/{pass}", method = RequestMethod.GET)
	public Boolean checkPasswordOfAccountsById(@PathVariable String id, @PathVariable String pass) throws InterruptedException {
		ActorRef actorManager = Starter.getActorManager();
		ActorMessage<String> message = new ActorMessage<>(MessageCodes.GET_ACCOUNT_PASSWORD, id);
		actorManager.tell(message, ActorRef.noSender());
		Thread.sleep(100);
		return message.getResult().equals(pass);
	}
	
	@RequestMapping(value = "create", method = RequestMethod.PUT)
	public Account createAccount() throws InterruptedException {
		ActorRef actorManager = Starter.getActorManager();
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.CREATE_ACCOUNT, "");
		actorManager.tell(message, ActorRef.noSender());
		Thread.sleep(100);
		return message.getResult();
	}
	
	@RequestMapping(value = "create/password/{pass}", method = RequestMethod.PUT)
	public Account createAccountWithPassword(@PathVariable String pass) throws InterruptedException {
		ActorRef actorManager = Starter.getActorManager();
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.CREATE_ACCOUNT, "");
		actorManager.tell(message, ActorRef.noSender());
		ChangePasswordMessage messagePassword = new ChangePasswordMessage(message.getResult().getId(), pass);
		actorManager.tell(messagePassword, ActorRef.noSender());
		Thread.sleep(100);
		return message.getResult();
	}
	
	@RequestMapping(value = "/{id}/password/{pass}", method = RequestMethod.PUT)
	public void setPassword(@PathVariable String id, @PathVariable String pass) {
		ActorRef actorManager = Starter.getActorManager();
		ChangePasswordMessage message = new ChangePasswordMessage(id, pass);
		actorManager.tell(message, ActorRef.noSender());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAccountById(@PathVariable String id) {
		ActorRef actorManager = Starter.getActorManager();
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.DELETE_ACCOUNT_BY_ID, id);
		actorManager.tell(message, ActorRef.noSender());
	}
	
}
