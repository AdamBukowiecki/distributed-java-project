package uam.distributed_java.vetulbank.main.actors.messages;

import uam.distributed_java.vetulbank.main.models.Transaction;

public class TransactionMessage {

	private Transaction transaction;
	
	public TransactionMessage(Transaction transaction) {
		setTransaction(transaction);
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}
