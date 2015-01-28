package uam.distributed_java.vetulbank.main.models;

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
	
	@JsonView(MinimalView.class)
	private String password;
	
	@JsonView(MinimalView.class)
	private double money;
	
	public Account() {}
	
	public Account(String id, double money, String password) {
		setId(id);
		setMoney(money);
		setPassword(password);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
}
