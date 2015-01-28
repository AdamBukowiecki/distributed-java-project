package uam.distributed_java.vetulbank.main.controllers;

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
import akka.actor.Props;

import com.fasterxml.jackson.annotation.JsonView;

import uam.distributed_java.vetulbank.main.Starter;
import uam.distributed_java.vetulbank.main.actors.ActorManager;
import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import uam.distributed_java.vetulbank.main.actors.messages.ChangePasswordMessage;
import uam.distributed_java.vetulbank.main.actors.messages.MessageCodes;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;

/**
 * 
 * API:
 * 
 * \ GET accounts/{id} - pobranie Account'a o podanym id
 * \ GET accounts/{id}/transactions - pobranie transakcji Account'a o podanym id
 * \ DELETE accounts/{id} - usuniecie Account'a o podanym id
 * \ PUT accounts/{id} - stworzenie i pobranie Account'a o podanym id
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
	public Account getAccountById(@PathVariable String id) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.GET_ACCOUNT_BY_ID, id);
		ref.tell(message, ActorRef.noSender());
		return message.getResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/transactions", method = RequestMethod.GET)
	public List<Transaction> getAccountsTransactionsById(@PathVariable String id) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ActorMessage<List<Transaction>> message = new ActorMessage<>(MessageCodes.GET_ACCOUNTS_TRANSACTIONS, id);
		ref.tell(message, ActorRef.noSender());
		return message.getResult();
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/password/{pass}", method = RequestMethod.GET)
	public Boolean checkPasswordOfAccountsById(@PathVariable String id, @PathVariable String pass) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ActorMessage<String> message = new ActorMessage<>(MessageCodes.GET_ACCOUNT_PASSWORD, id);
		ref.tell(message, ActorRef.noSender());
		return message.getResult().equals(pass);
	}
	
	@JsonView(Account.MinimalView.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Account createAccount(@PathVariable String id) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.CREATE_ACCOUNT, id);
		ref.tell(message, ActorRef.noSender());
		return message.getResult();
	}
	
	@RequestMapping(value = "/{id}/password/{pass}", method = RequestMethod.PUT)
	public void setPassword(@PathVariable String id, @PathVariable String pass) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ChangePasswordMessage message = new ChangePasswordMessage(id, pass);
		ref.tell(message, ActorRef.noSender());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAccountById(@PathVariable String id) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		ActorMessage<Account> message = new ActorMessage<>(MessageCodes.DELETE_ACCOUNT_BY_ID, id);
		ref.tell(message, ActorRef.noSender());
	}
	
}
