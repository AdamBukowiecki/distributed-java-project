package uam.distributed_java.vetulbank.main.actors.messages;

public class ActorMessage {

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
	
}
