package uam.distributed_java.vetulbank.main.actors;

import java.util.ArrayList;
import java.util.List;

import uam.distributed_java.vetulbank.main.actors.messages.AccountsTransactionsMessage;
import uam.distributed_java.vetulbank.main.actors.messages.TransactionMessage;
import uam.distributed_java.vetulbank.main.exceptions.NotEnoughHajsException;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
import akka.actor.UntypedActor;

public class ActorManager extends UntypedActor {

	
	@Override
	public void onReceive(Object arg0) throws Exception {
		
		if(arg0 instanceof TransactionMessage) {
			transactionReaction((TransactionMessage) arg0);
		}
		
		if(arg0 instanceof AccountsTransactionsMessage) {
			accountsTransactionsMessageReaction((AccountsTransactionsMessage) arg0);
		}
		
	}

	private void accountsTransactionsMessageReaction(AccountsTransactionsMessage message) {
		
		Iterable<Transaction> transactions = message.getAll();
		List<Transaction> result = new ArrayList<>();
		for(Transaction transaction: transactions) {
			if( transaction.getFromId().equals(message.getId()) ||
				transaction.getTargetId().equals(message.getId()) )
				result.add(transaction);
			}
		message.setResult(result);
	}

	private void transactionReaction(TransactionMessage message) {

		Account from = message.getFrom();
		Account target = message.getTo();
		
		if(from.getMoney() >= message.getValue()) {
			double transfer = message.getValue();
			from.setMoney(from.getMoney() - transfer);
			target.setMoney(target.getMoney() + transfer);
			message.setResult(true);
		} else {
			message.setResult(false);
			throw new NotEnoughHajsException();
		}
		
	}
	
}
