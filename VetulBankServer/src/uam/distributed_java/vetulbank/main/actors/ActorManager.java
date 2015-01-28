package uam.distributed_java.vetulbank.main.actors;

import java.util.List;

import uam.distributed_java.vetulbank.main.actors.messages.ActorMessage;
import uam.distributed_java.vetulbank.main.actors.messages.TransactionMessage;
import uam.distributed_java.vetulbank.main.models.Account;
import uam.distributed_java.vetulbank.main.models.Transaction;
import akka.actor.UntypedActor;

public class ActorManager extends UntypedActor {

	@Override
	public void onReceive(Object arg0) throws Exception {
		
		if(arg0 instanceof ActorMessage) {
			
			ActorMessage message = (ActorMessage) arg0;
			
			switch(message.getCode()) {
			case DELETE_ACCOUNT_BY_ID:
				
				break;
			case GET_ACCOUNTS_TRANSACTIONS: {
				ActorMessage<List<Transaction>> parameterizedMessage = (ActorMessage<List<Transaction>>) message;
				// message teraz ma odpowienie pole result, wypelnic je
				break;
			}
			case GET_ACCOUNT_BY_ID: {
				ActorMessage<Account> parameterizedMessage = (ActorMessage<Account>) message;
				// message teraz ma odpowienie pole result, wypelnic je
				break;
			}
			default:
				break;
			
			}
			
		}
		
		if(arg0 instanceof TransactionMessage) {
			
		}
		
	}
	
	private void actorMessageReaction(ActorMessage message) {
		
	}

}
