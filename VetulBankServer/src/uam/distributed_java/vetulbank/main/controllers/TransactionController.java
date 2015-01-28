package uam.distributed_java.vetulbank.main.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import akka.actor.ActorRef;
import akka.actor.Props;
import uam.distributed_java.vetulbank.main.Starter;
import uam.distributed_java.vetulbank.main.actors.ActorManager;
import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import uam.distributed_java.vetulbank.main.actors.messages.MessageCodes;
import uam.distributed_java.vetulbank.main.actors.messages.TransactionMessage;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
import uam.distributed_java.vetulbank.main.repositories.TransactionRepository;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionsRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public void performTransaction(@Valid @RequestBody Transaction transaction) {
		ActorRef ref = Starter.getActorSystem().actorOf(Props.create(ActorManager.class), "manager");
		TransactionMessage message = new TransactionMessage(transaction);
		ref.tell(message, ActorRef.noSender());
	}
	
}
