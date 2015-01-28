package uam.distributed_java.vetulbank.main.models;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Transaction {
	
	public interface MinimalView {};
	
	@Id
	@JsonView(MinimalView.class)
	private String id;
	
	@JsonView(MinimalView.class)
	private String fromId;

	@JsonView(MinimalView.class)
	private String targetId;
	
	@JsonView(MinimalView.class)
	private double value;
	
	@JsonView(MinimalView.class)
	private String description;
	
	@JsonView(MinimalView.class)
	private Date date;
	
	public Transaction() {}
	
	public Transaction(String id, String from, String target, double value, String desciprion, Date date) {
		setId(id);
		setFromId(from);
		setTargetId(target);
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
	
	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	
}
