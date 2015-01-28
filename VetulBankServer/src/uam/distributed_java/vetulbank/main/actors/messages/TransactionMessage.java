package uam.distributed_java.vetulbank.main.actors.messages;

import uam.distributed_java.vetulbank.main.models.Account;

public class TransactionMessage {

	private Account from;
	private Account to;
	private double value;
	private boolean result;

	public TransactionMessage(Account findOne, Account findOne2, double value) {
		setFrom(findOne);
		setTo(findOne2);
		setValue(value);
		result = true;
	}
	
	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}


}
