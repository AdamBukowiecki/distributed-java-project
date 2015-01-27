package uam.distributed_java.vetulbank.main.actors;

import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import akka.actor.UntypedActor;

public class ActorManager extends UntypedActor {

	@Override
	public void onReceive(Object arg0) throws Exception {
		
		if(arg0 instanceof ActorMessage) {
			
			ActorMessage message = (ActorMessage) arg0;
			
			switch(message.getCode()) {
			case DELETE_ACCOUNT_BY_ID:
				break;
			case GET_ACCOUNTS_TRANSACTIONS:
				break;
			case GET_ACCOUNT_BY_ID:
				break;
			case PERFORM_TRANSACTION:
				break;
			default:
				break;
			
			}
			
		}
		
	}

}
