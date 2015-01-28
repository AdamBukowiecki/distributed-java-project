package uam.distributed_java.vetulbank.main.actors.messages;

public class ChangePasswordMessage {
	
	private String id;
	private String password;
	private boolean result;
	
	public ChangePasswordMessage(String id, String password) {
		setId(id);
		setPassword(password);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
