package uam.distributed_java.vetulbank.main.actors.messages;

import java.util.List;

import uam.distributed_java.vetulbank.main.models.Transaction;

public class AccountsTransactionsMessage {

	private Iterable<Transaction> all;
	private String id;
	private List<Transaction> result;

	public AccountsTransactionsMessage(Iterable<Transaction> findAll, String id) {
		setAll(findAll);
		setId(id);
	}
	
	public Iterable<Transaction> getAll() {
		return all;
	}

	public void setAll(Iterable<Transaction> all) {
		this.all = all;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Transaction> getResult() {
		return result;
	}

	public void setResult(List<Transaction> result) {
		this.result = result;
	}


}
