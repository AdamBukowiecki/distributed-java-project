package uam.distributed_java.vetulbank.main.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Account {

	public interface MinimalView {};
	
	@Id
	@JsonView(MinimalView.class)
	private String id;
	
	@NotBlank
	@JsonView(MinimalView.class)
	private double money;
	
	@JsonView(MinimalView.class)
	private List<Transaction> transactions;

	public Account() {}
	
	public Account(String id, double money, List<Transaction> transactions) {
		setId(id);
		setMoney(money);
		setTransactions(transactions);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
