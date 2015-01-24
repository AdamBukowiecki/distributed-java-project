package uam.distributed_java.vetulbank.main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException() {
		super("Account not found!");
	}
	
}
