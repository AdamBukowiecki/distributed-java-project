package uam.distributed_java.vetulbank.main.models;

import java.util.Date;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import uam.distributed_java.vetulbank.main.models.Account.MinimalView;

import com.fasterxml.jackson.annotation.JsonView;

public class Transaction {
	
	@Id
	@JsonView(MinimalView.class)
	private String id;
	
	@NotBlank
	@JsonView(MinimalView.class)
	private Account from;
	

	@NotBlank
	@JsonView(MinimalView.class)
	private Account target;
	
	@NotBlank
	@JsonView(MinimalView.class)
	private double value;
	
	@NotBlank
	@JsonView(MinimalView.class)
	private String description;
	
	@NotBlank
	@JsonView(MinimalView.class)
	private Date date;
	
	public Transaction() {}
	
	public Transaction(String id, Account from, Account target, double value, String desciprion, Date date) {
		setId(id);
		setFrom(from);
		setTarget(target);
		setValue(value);
		setDescription(desciprion);
		setDate(date);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public Account getTarget() {
		return target;
	}

	public void setTarget(Account target) {
		this.target = target;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
