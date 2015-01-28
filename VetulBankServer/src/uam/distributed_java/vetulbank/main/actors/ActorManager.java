package uam.distributed_java.vetulbank.main.actors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import uam.distributed_java.vetulbank.main.actors.messages.ChangePasswordMessage;
import uam.distributed_java.vetulbank.main.actors.messages.TransactionMessage;
import uam.distributed_java.vetulbank.main.exceptions.NotEnoughHajsException;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
import uam.distributed_java.vetulbank.main.repositories.AccountRepository;
import uam.distributed_java.vetulbank.main.repositories.TransactionRepository;
import uam.distributed_java.vetulbank.main.tools.IDGenerator;
import akka.actor.UntypedActor;

public class ActorManager extends UntypedActor {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void onReceive(Object arg0) throws Exception {
		
		if(arg0 instanceof ActorMessage) {
			actorMessageReaction((ActorMessage) arg0);
		}
		
		if(arg0 instanceof TransactionMessage) {
			transactionReaction((TransactionMessage) arg0);
		}
		
		if(arg0 instanceof ChangePasswordMessage) {
			changePassowrdReaction((ChangePasswordMessage) arg0);
		}
		
	}
	
	private void actorMessageReaction(ActorMessage message) {

		switch(message.getCode()) {
		case DELETE_ACCOUNT_BY_ID: {
			ActorMessage<Boolean> parameterizedMessage = (ActorMessage<Boolean>) message;
			accountRepository.delete(parameterizedMessage.getId());
			break;
		}
		case GET_ACCOUNTS_TRANSACTIONS: {
			ActorMessage<List<Transaction>> parameterizedMessage = (ActorMessage<List<Transaction>>) message;
			Iterable<Transaction> transactions = transactionRepository.findAll();
			List<Transaction> result = new ArrayList<>();
			for(Transaction transaction: transactions) {
				if( transaction.getFromId().equals(parameterizedMessage.getId()) ||
					transaction.getTargetId().equals(parameterizedMessage.getId()) )
					result.add(transaction);
			}
			parameterizedMessage.setResult(result);
			break;
		}
		case GET_ACCOUNT_BY_ID: {
			ActorMessage<Account> parameterizedMessage = (ActorMessage<Account>) message;
			parameterizedMessage.setResult(accountRepository.findOne(parameterizedMessage.getId()));
			break;
		}
		
		case GET_ACCOUNT_PASSWORD: {
			ActorMessage<String> parameterizedMessage = (ActorMessage<String>) message;
			parameterizedMessage.setResult(accountRepository.findOne(parameterizedMessage.getId()).getPassword());
			break;
		}
		
		case CREATE_ACCOUNT: {
			ActorMessage<Boolean> parameterizedMessage = (ActorMessage<Boolean>) message;
			String id = parameterizedMessage.getId();
			while(accountRepository.exists(id))
				id = IDGenerator.generateID();
			accountRepository.save(new Account(parameterizedMessage.getId(), 1000, "", new ArrayList<Transaction>()));
		}
		
		default:
			break;
		
		}
		
		
	}

	private void changePassowrdReaction(ChangePasswordMessage message) {
		accountRepository.findOne(message.getId()).setPassword(message.getPassword());
	}

	private void transactionReaction(TransactionMessage message) {

		Transaction transaction = message.getTransaction();
		
		Account from = accountRepository.findOne(transaction.getFromId());
		Account target = accountRepository.findOne(transaction.getTargetId());
		
		if(from.getMoney() >= transaction.getValue()) {
			double transfer = transaction.getValue();
			from.setMoney(from.getMoney() - transfer);
			target.setMoney(target.getMoney() + transfer);
			message.setResult(true);
		} else {
			message.setResult(false);
			throw new NotEnoughHajsException();
		}
		
	}
	
}
