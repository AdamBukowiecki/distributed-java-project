package uam.distributed_java.vetulbank.main.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uam.distributed_java.vetulbank.main.models.Transaction;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

	@RequestMapping(method = RequestMethod.POST)
	public void performTransaction(@Valid @RequestBody Transaction transaction) {
		// TODO actorManager.performTransaction(transaction)
	}
	
}
