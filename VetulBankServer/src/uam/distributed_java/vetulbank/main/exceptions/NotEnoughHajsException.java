package uam.distributed_java.vetulbank.main.exceptions;

public class NotEnoughHajsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotEnoughHajsException() {
		super("Hajs not found!");
	}
	
}