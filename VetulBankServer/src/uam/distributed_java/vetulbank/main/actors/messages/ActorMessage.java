package uam.distributed_java.vetulbank.main.actors.messages;

import uam.distributed_java.vetulbank.main.actors.messages.messagescodes.MessageCodes;

public class ActorMessage<T> {

	private T result;
	private MessageCodes code;
	private String id;
	
	public ActorMessage(MessageCodes code, String id) {
		this.code = code;
		this.id = id;
	}
	
	public MessageCodes getCode() {
		return code;
	}
	
	public String getId() {
		return id;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
